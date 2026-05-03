package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
class zzakg extends zzakd {
    protected final byte[] zzb;

    zzakg(byte[] bArr) {
        super();
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzajv) || zzb() != ((zzajv) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (!(obj instanceof zzakg)) {
            return obj.equals(this);
        }
        zzakg zzakgVar = (zzakg) obj;
        int iZza = zza();
        int iZza2 = zzakgVar.zza();
        if (iZza == 0 || iZza2 == 0 || iZza == iZza2) {
            return zza(zzakgVar, 0, zzb());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final zzajv zza(int i, int i2) {
        int iZza = zza(0, i2, zzb());
        return iZza == 0 ? zzajv.zza : new zzajz(this.zzb, zze(), iZza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    final void zza(zzajw zzajwVar) throws IOException {
        zzajwVar.zza(this.zzb, zze(), zzb());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    protected void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakd
    final boolean zza(zzajv zzajvVar, int i, int i2) {
        if (i2 > zzajvVar.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        }
        if (i2 > zzajvVar.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzajvVar.zzb());
        }
        if (!(zzajvVar instanceof zzakg)) {
            return zzajvVar.zza(0, i2).equals(zza(0, i2));
        }
        zzakg zzakgVar = (zzakg) zzajvVar;
        byte[] bArr = this.zzb;
        byte[] bArr2 = zzakgVar.zzb;
        int iZze = zze() + i2;
        int iZze2 = zze();
        int iZze3 = zzakgVar.zze();
        while (iZze2 < iZze) {
            if (bArr[iZze2] != bArr2[iZze3]) {
                return false;
            }
            iZze2++;
            iZze3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    protected final int zzb(int i, int i2, int i3) {
        return zzalh.zza(i, this.zzb, zze(), i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajv
    public final zzakh zzc() {
        return zzakh.zza(this.zzb, zze(), zzb(), true);
    }

    protected int zze() {
        return 0;
    }
}
