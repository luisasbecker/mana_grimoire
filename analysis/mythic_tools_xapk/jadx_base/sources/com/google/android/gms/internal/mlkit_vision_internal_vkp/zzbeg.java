package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public class zzbeg extends zzbef implements zzbft {
    protected zzbeg(zzbeh zzbehVar) {
        super(zzbehVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbef, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfr
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final zzbeh zzw() {
        if (!((zzbeh) this.zza).zzU()) {
            return (zzbeh) this.zza;
        }
        ((zzbeh) this.zza).zzb.zzh();
        return (zzbeh) super.zzw();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbef
    protected final void zzz() {
        super.zzz();
        if (((zzbeh) this.zza).zzb != zzbea.zze()) {
            zzbeh zzbehVar = (zzbeh) this.zza;
            zzbehVar.zzb = zzbehVar.zzb.clone();
        }
    }
}
