package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkManager;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class cv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f262a = new com.google.android.play.core.assetpacks.internal.o("ExtractionWorkScheduler");
    private final dt b;
    private final dd c;
    private final er d;
    private final ci e;
    private final bh f;
    private final com.google.android.play.core.assetpacks.internal.aq g;
    private final com.google.android.play.core.assetpacks.internal.aq h;
    private final com.google.android.play.core.assetpacks.internal.aq i;

    cv(dt dtVar, dd ddVar, er erVar, ci ciVar, com.google.android.play.core.assetpacks.internal.aq aqVar, com.google.android.play.core.assetpacks.internal.aq aqVar2, bh bhVar, com.google.android.play.core.assetpacks.internal.aq aqVar3) {
        this.g = aqVar;
        this.b = dtVar;
        this.c = ddVar;
        this.d = erVar;
        this.e = ciVar;
        this.h = aqVar2;
        this.f = bhVar;
        this.i = aqVar3;
    }

    public static /* synthetic */ void a(cv cvVar, Bundle bundle, AssetPackState assetPackState) {
        if (cvVar.b.o(bundle)) {
            cvVar.f.e(assetPackState);
            ((z) cvVar.h.a()).f();
        }
    }

    final void b(final Bundle bundle, Bundle bundle2, Bundle bundle3) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList == null || stringArrayList.size() != 1) {
            f262a.b("Corrupt packStateBundle.", new Object[0]);
            return;
        }
        boolean z = bundle2.getBoolean("enableExpeditedWork");
        if (z && bundle3 == null) {
            f262a.b("Notification options must be present when expedited work is enabled.", new Object[0]);
            return;
        }
        final AssetPackState assetPackStateB = AssetPackState.b(bundle, stringArrayList.get(0), this.c, this.d);
        f262a.a("ExtractionWorkScheduler.scheduleExtraction: %s", assetPackStateB);
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("confirmation_intent");
        if (pendingIntent != null) {
            this.e.b(pendingIntent);
        }
        ((Executor) this.i.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.cu
            @Override // java.lang.Runnable
            public final void run() {
                cv.a(this.f261a, bundle, assetPackStateB);
            }
        });
        if (z) {
            ((WorkManager) this.g.a()).enqueueUniqueWork("extractAssetPacks", ExistingWorkPolicy.APPEND, new OneTimeWorkRequest.Builder(ExtractionWorker.class).setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST).setInputData(cb.c(bundle, bundle3)).build());
        } else {
            ((WorkManager) this.g.a()).enqueueUniqueWork("extractAssetPacks", ExistingWorkPolicy.APPEND, new OneTimeWorkRequest.Builder(ExtractionWorker.class).setInputData(cb.c(bundle, new Bundle())).build());
        }
    }
}
