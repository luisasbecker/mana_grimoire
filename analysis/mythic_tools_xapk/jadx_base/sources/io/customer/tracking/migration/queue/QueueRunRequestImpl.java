package io.customer.tracking.migration.queue;

import io.customer.sdk.core.util.Logger;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueueRunRequest.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ4\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u00122\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0016H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lio/customer/tracking/migration/queue/QueueRunRequestImpl;", "Lio/customer/tracking/migration/queue/QueueRunRequest;", "runner", "Lio/customer/tracking/migration/queue/QueueRunner;", "queueStorage", "Lio/customer/tracking/migration/queue/QueueStorage;", "logger", "Lio/customer/sdk/core/util/Logger;", "queryRunner", "Lio/customer/tracking/migration/queue/QueueQueryRunner;", "<init>", "(Lio/customer/tracking/migration/queue/QueueRunner;Lio/customer/tracking/migration/queue/QueueStorage;Lio/customer/sdk/core/util/Logger;Lio/customer/tracking/migration/queue/QueueQueryRunner;)V", "run", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeOrThrows", "Lkotlin/Result;", "tasksToRun", "", "Lorg/json/JSONObject;", "Lio/customer/tracking/migration/queue/QueueTask;", "currentTaskMetadata", "Lio/customer/tracking/migration/queue/QueueTaskMetadata;", "executeOrThrows-0E7RQCE", "(Ljava/util/List;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueueRunRequestImpl implements QueueRunRequest {
    private final Logger logger;
    private final QueueQueryRunner queryRunner;
    private final QueueStorage queueStorage;
    private final QueueRunner runner;

    /* JADX INFO: renamed from: io.customer.tracking.migration.queue.QueueRunRequestImpl$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: QueueRunRequest.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.customer.tracking.migration.queue.QueueRunRequestImpl", f = "QueueRunRequest.kt", i = {0, 0}, l = {28}, m = "run", n = {"$this$run_u24lambda_u240", "tasksToRun"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return QueueRunRequestImpl.this.run(this);
        }
    }

    public QueueRunRequestImpl(QueueRunner runner, QueueStorage queueStorage, Logger logger, QueueQueryRunner queryRunner) {
        Intrinsics.checkNotNullParameter(runner, "runner");
        Intrinsics.checkNotNullParameter(queueStorage, "queueStorage");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(queryRunner, "queryRunner");
        this.runner = runner;
        this.queueStorage = queueStorage;
        this.logger = logger;
        this.queryRunner = queryRunner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /* JADX INFO: renamed from: executeOrThrows-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m11438executeOrThrows0E7RQCE(List<JSONObject> list, JSONObject jSONObject, Continuation<? super Result<Unit>> continuation) {
        QueueRunRequestImpl$executeOrThrows$1 queueRunRequestImpl$executeOrThrows$1;
        String taskPersistedId;
        Object objMo11439runTaskgIAlus;
        QueueRunRequestImpl queueRunRequestImpl = this;
        if (continuation instanceof QueueRunRequestImpl$executeOrThrows$1) {
            queueRunRequestImpl$executeOrThrows$1 = (QueueRunRequestImpl$executeOrThrows$1) continuation;
            if ((queueRunRequestImpl$executeOrThrows$1.label & Integer.MIN_VALUE) != 0) {
                queueRunRequestImpl$executeOrThrows$1.label -= Integer.MIN_VALUE;
            } else {
                queueRunRequestImpl$executeOrThrows$1 = new QueueRunRequestImpl$executeOrThrows$1(queueRunRequestImpl, continuation);
            }
        }
        Object obj = queueRunRequestImpl$executeOrThrows$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = queueRunRequestImpl$executeOrThrows$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                list.remove(jSONObject);
                taskPersistedId = AliasesKt.getTaskPersistedId(jSONObject);
                JSONObject jSONObject2 = taskPersistedId != null ? queueRunRequestImpl.queueStorage.get(taskPersistedId) : null;
                Logger logger = queueRunRequestImpl.logger;
                if (jSONObject2 == null) {
                    Logger.DefaultImpls.error$default(logger, "Tried to get queue task with storage id: " + taskPersistedId + " but storage couldn't find it.", null, null, 6, null);
                    if (taskPersistedId != null) {
                        Boxing.boxBoolean(queueRunRequestImpl.queueStorage.delete(taskPersistedId));
                    }
                    return Result.m11445constructorimpl(Unit.INSTANCE);
                }
                Logger.DefaultImpls.debug$default(logger, "queue tasks left to run: " + list.size(), null, 2, null);
                Logger.DefaultImpls.debug$default(queueRunRequestImpl.logger, "queue next task to run: " + taskPersistedId + ", " + jSONObject2, null, 2, null);
                QueueRunner queueRunner = queueRunRequestImpl.runner;
                queueRunRequestImpl$executeOrThrows$1.L$0 = queueRunRequestImpl;
                queueRunRequestImpl$executeOrThrows$1.L$1 = taskPersistedId;
                queueRunRequestImpl$executeOrThrows$1.label = 1;
                objMo11439runTaskgIAlus = queueRunner.mo11439runTaskgIAlus(jSONObject2, queueRunRequestImpl$executeOrThrows$1);
                if (objMo11439runTaskgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str = (String) queueRunRequestImpl$executeOrThrows$1.L$1;
                QueueRunRequestImpl queueRunRequestImpl2 = (QueueRunRequestImpl) queueRunRequestImpl$executeOrThrows$1.L$0;
                ResultKt.throwOnFailure(obj);
                Object value = ((Result) obj).getValue();
                taskPersistedId = str;
                queueRunRequestImpl = queueRunRequestImpl2;
                objMo11439runTaskgIAlus = value;
            }
            if (Result.m11452isSuccessimpl(objMo11439runTaskgIAlus)) {
                Logger.DefaultImpls.debug$default(queueRunRequestImpl.logger, "queue task " + taskPersistedId + " ran successfully", null, 2, null);
                Logger.DefaultImpls.debug$default(queueRunRequestImpl.logger, "queue deleting task " + taskPersistedId, null, 2, null);
            } else if (Result.m11451isFailureimpl(objMo11439runTaskgIAlus)) {
                Logger.DefaultImpls.debug$default(queueRunRequestImpl.logger, "queue task " + taskPersistedId + " run failed " + Result.m11448exceptionOrNullimpl(objMo11439runTaskgIAlus), null, 2, null);
            }
            queueRunRequestImpl.queueStorage.delete(taskPersistedId);
            return Result.m11445constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.customer.tracking.migration.queue.QueueRunRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object run(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objM11445constructorimpl;
        QueueRunRequestImpl queueRunRequestImpl;
        List<JSONObject> mutableList;
        JSONObject nextTask;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                QueueRunRequestImpl queueRunRequestImpl2 = this;
                Logger.DefaultImpls.debug$default(this.logger, "queue starting to run tasks...", null, 2, null);
                queueRunRequestImpl = this;
                mutableList = CollectionsKt.toMutableList((Collection) this.queueStorage.getInventory());
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableList = (List) anonymousClass1.L$1;
                queueRunRequestImpl = (QueueRunRequestImpl) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM11445constructorimpl = Result.m11445constructorimpl(ResultKt.createFailure(th));
        }
        do {
            if (!mutableList.isEmpty()) {
                nextTask = queueRunRequestImpl.queryRunner.getNextTask(mutableList);
                if (nextTask == null) {
                    Logger.DefaultImpls.debug$default(queueRunRequestImpl.logger, "all queue tasks have been migrated or failed to run. Exiting queue run.", null, 2, null);
                } else {
                    anonymousClass1.L$0 = queueRunRequestImpl;
                    anonymousClass1.L$1 = mutableList;
                    anonymousClass1.label = 1;
                }
            }
            Logger.DefaultImpls.debug$default(queueRunRequestImpl.logger, "queue done running tasks", null, 2, null);
            objM11445constructorimpl = Result.m11445constructorimpl(Unit.INSTANCE);
            Throwable thM11448exceptionOrNullimpl = Result.m11448exceptionOrNullimpl(objM11445constructorimpl);
            if (thM11448exceptionOrNullimpl != null) {
                Logger.DefaultImpls.error$default(this.logger, "queue run failed with exception: " + thM11448exceptionOrNullimpl, null, null, 6, null);
            }
            return Unit.INSTANCE;
        } while (queueRunRequestImpl.m11438executeOrThrows0E7RQCE(mutableList, nextTask, anonymousClass1) != coroutine_suspended);
        return coroutine_suspended;
    }
}
