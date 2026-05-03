package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public class zzun {
    private final zzvf zza;

    public zzun(Context context) {
        this.zza = new zzvf(context, new SharedPrefManager(context), new zzuz(context, zzuy.zzd("shared-installation-id").zzd()), "shared-installation-id");
    }

    protected zzun(zzvf zzvfVar) {
        this.zza = zzvfVar;
    }

    protected final void zza(zzpb zzpbVar, zzum zzumVar) {
        zzpc zzpcVar = new zzpc();
        zzpcVar.zzj(zzumVar.zza().zzi());
        this.zza.zze(zzvi.zzf(zzpcVar), zzpbVar, "o:a:mlkit:1.0.0");
    }
}
