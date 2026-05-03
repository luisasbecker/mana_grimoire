package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjn extends zzbeh implements zzbft {
    private static final zzjn zzd;
    private int zze;
    private long zzf;
    private zzgp zzg;
    private zzgx zzh;
    private byte zzj = 2;
    private zzbet zzi = zzL();

    static {
        zzjn zzjnVar = new zzjn();
        zzd = zzjnVar;
        zzbel.zzR(zzjn.class, zzjnVar);
    }

    private zzjn() {
    }

    public final int zza() {
        return this.zzi.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဉ\u0001\u0003\u001b\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzi", zzha.class, "zzh"});
        }
        if (i2 == 3) {
            return new zzjn();
        }
        zzjl zzjlVar = null;
        if (i2 == 4) {
            return new zzjm(zzjlVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final zzgp zzd() {
        zzgp zzgpVar = this.zzg;
        return zzgpVar == null ? zzgp.zzg() : zzgpVar;
    }

    public final zzha zze(int i) {
        return (zzha) this.zzi.get(i);
    }

    public final boolean zzg() {
        return (this.zze & 1) != 0;
    }
}
