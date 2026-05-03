package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation;
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this(workContinuationImpl, new OperationImpl());
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl, OperationImpl operationImpl) {
        this.mWorkContinuation = workContinuationImpl;
        this.mOperation = operationImpl;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean zEnqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return zEnqueueWorkWithPrerequisites;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean enqueueWorkWithPrerequisites(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> list, String[] strArr, String str, ExistingWorkPolicy existingWorkPolicy) {
        boolean z;
        boolean z2;
        boolean z3;
        WorkManagerImpl workManagerImpl2;
        WorkDatabase workDatabase;
        boolean z4;
        WorkDatabase workDatabase2;
        String[] strArr2 = strArr;
        long jCurrentTimeMillis = workManagerImpl.getConfiguration().getClock().currentTimeMillis();
        WorkDatabase workDatabase3 = workManagerImpl.getWorkDatabase();
        boolean z5 = strArr2 != null && strArr2.length > 0;
        if (z5) {
            z = false;
            z2 = false;
            z3 = true;
            for (String str2 : strArr2) {
                WorkSpec workSpec = workDatabase3.workSpecDao().getWorkSpec(str2);
                if (workSpec == null) {
                    Logger.get().error(TAG, "Prerequisite " + str2 + " doesn't exist; not enqueuing");
                    return false;
                }
                WorkInfo.State state = workSpec.state;
                z3 &= state == WorkInfo.State.SUCCEEDED;
                if (state == WorkInfo.State.FAILED) {
                    z2 = true;
                } else if (state == WorkInfo.State.CANCELLED) {
                    z = true;
                }
            }
        } else {
            z = false;
            z2 = false;
            z3 = true;
        }
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if (zIsEmpty || z5) {
            workManagerImpl2 = workManagerImpl;
            workDatabase = workDatabase3;
            z4 = false;
        } else {
            List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workDatabase3.workSpecDao().getWorkSpecIdAndStatesForName(str);
            if (!workSpecIdAndStatesForName.isEmpty()) {
                if (existingWorkPolicy == ExistingWorkPolicy.APPEND || existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE) {
                    workManagerImpl2 = workManagerImpl;
                    DependencyDao dependencyDao = workDatabase3.dependencyDao();
                    List arrayList = new ArrayList();
                    for (WorkSpec.IdAndState idAndState : workSpecIdAndStatesForName) {
                        if (dependencyDao.hasDependents(idAndState.id)) {
                            workDatabase2 = workDatabase3;
                        } else {
                            workDatabase2 = workDatabase3;
                            boolean z6 = (idAndState.state == WorkInfo.State.SUCCEEDED) & z3;
                            if (idAndState.state == WorkInfo.State.FAILED) {
                                z2 = true;
                            } else if (idAndState.state == WorkInfo.State.CANCELLED) {
                                z = true;
                            }
                            arrayList.add(idAndState.id);
                            z3 = z6;
                        }
                        workDatabase3 = workDatabase2;
                    }
                    workDatabase = workDatabase3;
                    if (existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE && (z || z2)) {
                        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
                        Iterator<WorkSpec.IdAndState> it = workSpecDao.getWorkSpecIdAndStatesForName(str).iterator();
                        while (it.hasNext()) {
                            workSpecDao.delete(it.next().id);
                        }
                        arrayList = Collections.emptyList();
                        z = false;
                        z2 = false;
                    }
                    strArr2 = (String[]) arrayList.toArray(strArr2);
                    z5 = strArr2.length > 0;
                } else {
                    if (existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                        for (WorkSpec.IdAndState idAndState2 : workSpecIdAndStatesForName) {
                            if (idAndState2.state == WorkInfo.State.ENQUEUED || idAndState2.state == WorkInfo.State.RUNNING) {
                                return false;
                            }
                        }
                    }
                    workManagerImpl2 = workManagerImpl;
                    CancelWorkRunnable.forName(str, workManagerImpl2, false).run();
                    WorkSpecDao workSpecDao2 = workDatabase3.workSpecDao();
                    Iterator<WorkSpec.IdAndState> it2 = workSpecIdAndStatesForName.iterator();
                    while (it2.hasNext()) {
                        workSpecDao2.delete(it2.next().id);
                    }
                    workDatabase = workDatabase3;
                    z4 = true;
                }
            }
            z4 = false;
        }
        for (WorkRequest workRequest : list) {
            WorkSpec workSpec2 = workRequest.getWorkSpec();
            if (!z5 || z3) {
                workSpec2.lastEnqueueTime = jCurrentTimeMillis;
            } else if (z2) {
                workSpec2.state = WorkInfo.State.FAILED;
            } else if (z) {
                workSpec2.state = WorkInfo.State.CANCELLED;
            } else {
                workSpec2.state = WorkInfo.State.BLOCKED;
            }
            if (workSpec2.state == WorkInfo.State.ENQUEUED) {
                z4 = true;
            }
            workDatabase.workSpecDao().insertWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(workManagerImpl2.getSchedulers(), workSpec2));
            if (z5) {
                int length = strArr2.length;
                int i = 0;
                while (i < length) {
                    workDatabase.dependencyDao().insertDependency(new Dependency(workRequest.getStringId(), strArr2[i]));
                    i++;
                    z4 = z4;
                    strArr2 = strArr2;
                }
            }
            String[] strArr3 = strArr2;
            boolean z7 = z4;
            workDatabase.workTagDao().insertTags(workRequest.getStringId(), workRequest.getTags());
            if (!zIsEmpty) {
                workDatabase.workNameDao().insert(new WorkName(str, workRequest.getStringId()));
            }
            z4 = z7;
            strArr2 = strArr3;
        }
        return z4;
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean zProcessContinuation = false;
        if (parents != null) {
            for (WorkContinuationImpl workContinuationImpl2 : parents) {
                if (workContinuationImpl2.isEnqueued()) {
                    Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", workContinuationImpl2.getIds()) + ")");
                } else {
                    zProcessContinuation |= processContinuation(workContinuationImpl2);
                }
            }
        }
        return enqueueContinuation(workContinuationImpl) | zProcessContinuation;
    }

    public boolean addToDatabase() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            EnqueueUtilsKt.checkContentUriTriggerWorkerLimits(workDatabase, workManagerImpl.getConfiguration(), this.mWorkContinuation);
            boolean zProcessContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return zProcessContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.mWorkContinuation.hasCycles()) {
                throw new IllegalStateException("WorkContinuation has cycles (" + this.mWorkContinuation + ")");
            }
            if (addToDatabase()) {
                PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                scheduleWorkInBackground();
            }
            this.mOperation.markState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.mOperation.markState(new Operation.State.FAILURE(th));
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
