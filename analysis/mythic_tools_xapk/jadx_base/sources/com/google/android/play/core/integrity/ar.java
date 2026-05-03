package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ar extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ as f378a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ar(as asVar, Handler handler) {
        super(handler);
        this.f378a = asVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.f378a.f379a.trySetResult(3);
        } else if (i == 2) {
            this.f378a.f379a.trySetResult(2);
        } else {
            if (i != 3) {
                return;
            }
            this.f378a.f379a.trySetResult(1);
        }
    }
}
