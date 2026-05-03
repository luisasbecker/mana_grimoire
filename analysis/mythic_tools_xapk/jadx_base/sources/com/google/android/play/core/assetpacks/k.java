package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class k extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f349a;
    final /* synthetic */ l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(l lVar, Handler handler, TaskCompletionSource taskCompletionSource) {
        super(handler);
        this.f349a = taskCompletionSource;
        this.b = lVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.f349a.trySetResult(-1);
            this.b.h.b(null);
            return;
        }
        TaskCompletionSource taskCompletionSource = this.f349a;
        if (i != 2) {
            taskCompletionSource.trySetException(new AssetPackException(-100));
        } else {
            taskCompletionSource.trySetResult(0);
        }
    }
}
