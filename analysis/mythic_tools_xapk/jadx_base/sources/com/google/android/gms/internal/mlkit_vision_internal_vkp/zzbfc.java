package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public class zzbfc {
    protected volatile zzbfs zza;
    private volatile zzbdd zzb;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbfc)) {
            return false;
        }
        zzbfc zzbfcVar = (zzbfc) obj;
        zzbfs zzbfsVar = this.zza;
        zzbfs zzbfsVar2 = zzbfcVar.zza;
        if (zzbfsVar == null && zzbfsVar2 == null) {
            return zzb().equals(zzbfcVar.zzb());
        }
        if (zzbfsVar != null && zzbfsVar2 != null) {
            return zzbfsVar.equals(zzbfsVar2);
        }
        if (zzbfsVar != null) {
            zzbfcVar.zzd(zzbfsVar.zzx());
            return zzbfsVar.equals(zzbfcVar.zza);
        }
        zzd(zzbfsVar2.zzx());
        return this.zza.equals(zzbfsVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return ((zzbdc) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzz();
        }
        return 0;
    }

    public final zzbdd zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                return this.zzb;
            }
            if (this.zza == null) {
                this.zzb = zzbdd.zzb;
            } else {
                this.zzb = this.zza.zzt();
            }
            return this.zzb;
        }
    }

    public final zzbfs zzc(zzbfs zzbfsVar) {
        zzbfs zzbfsVar2 = this.zza;
        this.zzb = null;
        this.zza = zzbfsVar;
        return zzbfsVar2;
    }

    protected final void zzd(zzbfs zzbfsVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzbfsVar;
                this.zzb = zzbdd.zzb;
            } catch (zzbew unused) {
                this.zza = zzbfsVar;
                this.zzb = zzbdd.zzb;
            }
        }
    }
}
