package com.google.android.play.core.assetpacks;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExtractionWorker extends Worker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    cx f211a;

    public ExtractionWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        d.a(context).d(this);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        return this.f211a.b(getInputData());
    }

    @Override // androidx.work.Worker
    public final ForegroundInfo getForegroundInfo() {
        return this.f211a.a(getInputData());
    }
}
