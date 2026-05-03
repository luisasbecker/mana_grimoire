package com.google.android.libraries.intelligence.acceleration;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zza {
    private final long zza = TimeUnit.SECONDS.toMillis(10);
    private long zzb;

    zza(long j) {
    }

    final synchronized boolean zza() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzb;
        if (j != 0 && jElapsedRealtime - j < this.zza) {
            return false;
        }
        this.zzb = jElapsedRealtime;
        return true;
    }
}
