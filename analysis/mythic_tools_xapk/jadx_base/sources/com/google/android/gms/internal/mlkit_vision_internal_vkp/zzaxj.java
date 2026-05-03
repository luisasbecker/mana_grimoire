package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaxj {
    private final zzaxz zza;

    public zzaxj(Context context) {
        this.zza = new zzaxz(context, new SharedPrefManager(context), new zzaxv(context, zzaxu.zzd("shared-installation-id").zzd()), "shared-installation-id");
    }

    protected final void zza(zzary zzaryVar, zzaxi zzaxiVar) {
        zzarz zzarzVar = new zzarz();
        zzarzVar.zze(zzaxiVar.zza().zzi());
        this.zza.zzd(zzayb.zze(zzarzVar), zzaryVar, "o:a:mlkit:1.0.0");
    }
}
