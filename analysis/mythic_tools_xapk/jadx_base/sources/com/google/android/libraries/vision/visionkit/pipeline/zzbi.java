package com.google.android.libraries.vision.visionkit.pipeline;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbi {
    private final int zza;
    private final Map zzb = new HashMap();

    public zzbi(int i) {
        this.zza = i;
    }

    public final synchronized void zza(long j) {
        this.zzb.remove(Long.valueOf(j));
    }

    public final synchronized boolean zzb(Object obj, long j) {
        if (this.zzb.size() != this.zza) {
            this.zzb.put(Long.valueOf(j), obj);
            return true;
        }
        com.google.android.gms.internal.mlkit_vision_internal_vkp.zzcp.zza.zzc(this, "Buffer is full. Drop frame " + j, new Object[0]);
        return false;
    }
}
