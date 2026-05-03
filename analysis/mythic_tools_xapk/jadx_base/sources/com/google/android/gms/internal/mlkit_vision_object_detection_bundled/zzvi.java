package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvi implements zzuv {
    private final zzpc zza;
    private zzti zzb = new zzti();
    private final int zzc;

    private zzvi(zzpc zzpcVar, int i) {
        this.zza = zzpcVar;
        zzwk.zza();
        this.zzc = i;
    }

    public static zzuv zzf(zzpc zzpcVar) {
        return new zzvi(zzpcVar, 0);
    }

    public static zzuv zzg(zzpc zzpcVar, int i) {
        return new zzvi(zzpcVar, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuv
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuv
    public final zzuv zzb(zzpb zzpbVar) {
        this.zza.zzf(zzpbVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuv
    public final zzuv zzc(zzti zztiVar) {
        this.zzb = zztiVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuv
    public final String zzd() {
        String strZzk;
        zztk zztkVarZzh = this.zza.zzl().zzh();
        return (zztkVarZzh == null || (strZzk = zztkVarZzh.zzk()) == null || strZzk.isEmpty()) ? "NA" : (String) Preconditions.checkNotNull(zztkVarZzh.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuv
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzk(this.zzb.zzm());
        try {
            zzwk.zza();
            zzpc zzpcVar = this.zza;
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzmw.zza).ignoreNullValues(true).build().encode(zzpcVar.zzl()).getBytes("utf-8");
            }
            zzpe zzpeVarZzl = zzpcVar.zzl();
            zzcc zzccVar = new zzcc();
            zzmw.zza.configure(zzccVar);
            return zzccVar.zza().zza(zzpeVarZzl);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
