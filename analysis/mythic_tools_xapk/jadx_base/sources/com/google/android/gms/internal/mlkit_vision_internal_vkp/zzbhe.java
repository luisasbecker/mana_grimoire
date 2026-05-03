package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhe {
    private static final zzbhe zza = new zzbhe(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzbhe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzbhe(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzbhe zzc() {
        return zza;
    }

    static zzbhe zze(zzbhe zzbheVar, zzbhe zzbheVar2) {
        int i = zzbheVar.zzb + zzbheVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzbheVar.zzc, i);
        System.arraycopy(zzbheVar2.zzc, 0, iArrCopyOf, zzbheVar.zzb, zzbheVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzbheVar.zzd, i);
        System.arraycopy(zzbheVar2.zzd, 0, objArrCopyOf, zzbheVar.zzb, zzbheVar2.zzb);
        return new zzbhe(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzbhe zzf() {
        return new zzbhe(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbhe)) {
            return false;
        }
        zzbhe zzbheVar = (zzbhe) obj;
        int i = this.zzb;
        if (i == zzbheVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzbheVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzbheVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzF;
        int iZzG;
        int iZzF2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iZzF2 = zzbdq.zzF(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzbdd zzbddVar = (zzbdd) this.zzd[i3];
                    int iZzF3 = zzbdq.zzF(i7);
                    int iZzd = zzbddVar.zzd();
                    iZzF2 = iZzF3 + zzbdq.zzF(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int iZzF4 = zzbdq.zzF(i5 << 3);
                    iZzF = iZzF4 + iZzF4;
                    iZzG = ((zzbhe) this.zzd[i3]).zza();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new zzbev("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzF2 = zzbdq.zzF(i5 << 3) + 4;
                }
                i2 += iZzF2;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i3]).longValue();
                iZzF = zzbdq.zzF(i8);
                iZzG = zzbdq.zzG(jLongValue);
            }
            iZzF2 = iZzF + iZzG;
            i2 += iZzF2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzF = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzbdd zzbddVar = (zzbdd) this.zzd[i2];
            int iZzF2 = zzbdq.zzF(8);
            int iZzF3 = zzbdq.zzF(16) + zzbdq.zzF(i3);
            int iZzF4 = zzbdq.zzF(24);
            int iZzd = zzbddVar.zzd();
            iZzF += iZzF2 + iZzF2 + iZzF3 + iZzF4 + zzbdq.zzF(iZzd) + iZzd;
        }
        this.zze = iZzF;
        return iZzF;
    }

    final zzbhe zzd(zzbhe zzbheVar) {
        if (zzbheVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzbheVar.zzb;
        zzm(i);
        System.arraycopy(zzbheVar.zzc, 0, this.zzc, this.zzb, zzbheVar.zzb);
        System.arraycopy(zzbheVar.zzd, 0, this.zzd, this.zzb, zzbheVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzbfu.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final void zzk(zzbhs zzbhsVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzbhsVar.zzx(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzbhs zzbhsVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzbhsVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzbhsVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzbhsVar.zzd(i4, (zzbdd) obj);
                } else if (i3 == 3) {
                    zzbhsVar.zzG(i4);
                    ((zzbhe) obj).zzl(zzbhsVar);
                    zzbhsVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(new zzbev("Protocol message tag had invalid wire type."));
                    }
                    zzbhsVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
