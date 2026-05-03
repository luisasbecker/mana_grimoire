package com.google.android.play.core.assetpacks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionStateBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f212a = new com.google.android.play.core.assetpacks.internal.o("SessionStateBroadcastReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.FLAGS");
        if (bundleExtra == null) {
            f212a.b("Empty flags bundle received from broadcast.", new Object[0]);
            return;
        }
        if (bundleExtra.getBoolean("enableWorkManager")) {
            Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
            if (bundleExtra2 == null) {
                f212a.b("Empty bundle received from broadcast.", new Object[0]);
            } else {
                d.a(context).b().b(bundleExtra2, bundleExtra, intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_NOTIFICATION_OPTIONS"));
            }
        }
    }
}
