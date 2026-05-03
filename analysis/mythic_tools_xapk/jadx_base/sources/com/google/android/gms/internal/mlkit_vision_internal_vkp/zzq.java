package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzq {
    private final zzkw zza = new zzkw();
    private Boolean zzb;

    private zzq() {
    }

    /* synthetic */ zzq(zzp zzpVar) {
    }

    public final zzq zza(zzv zzvVar) {
        zzkj.zzc(this.zzb, "Must call internal() or external() before appending rules.");
        this.zza.zzb(zzvVar);
        return this;
    }

    public final zzq zzb() {
        zzkj.zzg(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = false;
        return this;
    }

    public final zzq zzc() {
        zzkj.zzg(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = true;
        return this;
    }

    public final zzs zzd() {
        zzkj.zzc(this.zzb, "Must call internal() or external() when building a SourcePolicy.");
        return new zzs(this.zzb.booleanValue(), false, this.zza.zzc(), null);
    }
}
