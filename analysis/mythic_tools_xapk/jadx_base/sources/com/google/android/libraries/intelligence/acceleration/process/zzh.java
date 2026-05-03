package com.google.android.libraries.intelligence.acceleration.process;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzh {
    private static final AtomicBoolean zza = new AtomicBoolean(false);

    static void zza(Context context) {
        if (zza.getAndSet(true)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new zzg());
    }
}
