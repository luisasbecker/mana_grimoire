package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import androidx.work.Data;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f264a = new com.google.android.play.core.assetpacks.internal.o("ExtractionWorker");
    private final dt b;
    private final da c;
    private final ep d;

    cx(dt dtVar, da daVar, ep epVar) {
        this.b = dtVar;
        this.c = daVar;
        this.d = epVar;
    }

    final ForegroundInfo a(Data data) {
        ep epVar = this.d;
        Bundle bundleA = cb.a(data);
        epVar.b(bundleA);
        return new ForegroundInfo(-1883842196, this.d.a(bundleA));
    }

    final ListenableWorker.Result b(Data data) {
        try {
            if (this.b.p(cb.b(data))) {
                this.c.a();
            }
            return ListenableWorker.Result.success();
        } catch (cz e) {
            f264a.b("Error while updating ExtractorSessionStoreView: %s", e.getMessage());
            return ListenableWorker.Result.failure();
        }
    }
}
