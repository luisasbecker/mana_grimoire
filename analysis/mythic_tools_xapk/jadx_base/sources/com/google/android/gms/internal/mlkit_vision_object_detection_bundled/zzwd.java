package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwd extends zzun {
    public zzwd(Context context) {
        super(new zzvf(context, new SharedPrefManager(context), new zzuz(context, zzuy.zzd("shared-remote-config").zzd()), "shared-remote-config"));
    }

    public final void zzb(zzum zzumVar) {
        zza(zzpb.REMOTE_CONFIG_ACTIVATE, zzumVar);
    }

    public final void zzc(zzum zzumVar) {
        zza(zzpb.REMOTE_CONFIG_FETCH, zzumVar);
    }

    public final void zzd(zzum zzumVar) {
        zza(zzpb.REMOTE_CONFIG_FRC_FETCH, zzumVar);
    }

    public final void zze(zzum zzumVar) {
        zza(zzpb.REMOTE_CONFIG_LOAD, zzumVar);
    }
}
