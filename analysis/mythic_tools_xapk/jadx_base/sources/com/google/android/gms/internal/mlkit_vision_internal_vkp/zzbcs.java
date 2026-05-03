package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbcs {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzbcr zzbcrVar) throws zzbew {
        int iZzj = zzj(bArr, i, zzbcrVar);
        int i2 = zzbcrVar.zza;
        if (i2 < 0) {
            throw new zzbew("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZzj) {
            throw new zzbew("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzbcrVar.zzc = zzbdd.zzb;
            return iZzj;
        }
        zzbcrVar.zzc = zzbdd.zzo(bArr, iZzj, i2);
        return iZzj + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzbgm zzbgmVar, byte[] bArr, int i, int i2, int i3, zzbcr zzbcrVar) throws IOException {
        Object objZze = zzbgmVar.zze();
        int iZzn = zzn(objZze, zzbgmVar, bArr, i, i2, i3, zzbcrVar);
        zzbgmVar.zzf(objZze);
        zzbcrVar.zzc = objZze;
        return iZzn;
    }

    static int zzd(zzbgm zzbgmVar, byte[] bArr, int i, int i2, zzbcr zzbcrVar) throws IOException {
        Object objZze = zzbgmVar.zze();
        int iZzo = zzo(objZze, zzbgmVar, bArr, i, i2, zzbcrVar);
        zzbgmVar.zzf(objZze);
        zzbcrVar.zzc = objZze;
        return iZzo;
    }

    static int zze(zzbgm zzbgmVar, int i, byte[] bArr, int i2, int i3, zzbet zzbetVar, zzbcr zzbcrVar) throws IOException {
        int iZzd = zzd(zzbgmVar, bArr, i2, i3, zzbcrVar);
        zzbetVar.add(zzbcrVar.zzc);
        while (iZzd < i3) {
            int iZzj = zzj(bArr, iZzd, zzbcrVar);
            if (i != zzbcrVar.zza) {
                break;
            }
            iZzd = zzd(zzbgmVar, bArr, iZzj, i3, zzbcrVar);
            zzbetVar.add(zzbcrVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzbet zzbetVar, zzbcr zzbcrVar) throws IOException {
        zzbem zzbemVar = (zzbem) zzbetVar;
        int iZzj = zzj(bArr, i, zzbcrVar);
        int i2 = zzbcrVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzbcrVar);
            zzbemVar.zzg(zzbcrVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw new zzbew("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(byte[] bArr, int i, zzbcr zzbcrVar) throws zzbew {
        int iZzj = zzj(bArr, i, zzbcrVar);
        int i2 = zzbcrVar.zza;
        if (i2 < 0) {
            throw new zzbew("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zzbcrVar.zzc = "";
            return iZzj;
        }
        zzbcrVar.zzc = new String(bArr, iZzj, i2, zzbeu.zza);
        return iZzj + i2;
    }

    static int zzh(byte[] bArr, int i, zzbcr zzbcrVar) throws zzbew {
        int iZzj = zzj(bArr, i, zzbcrVar);
        int i2 = zzbcrVar.zza;
        if (i2 < 0) {
            throw new zzbew("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zzbcrVar.zzc = "";
            return iZzj;
        }
        zzbcrVar.zzc = zzbhp.zzd(bArr, iZzj, i2);
        return iZzj + i2;
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzbhe zzbheVar, zzbcr zzbcrVar) throws zzbew {
        if ((i >>> 3) == 0) {
            throw new zzbew("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zzbcrVar);
            zzbheVar.zzj(i, Long.valueOf(zzbcrVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zzbheVar.zzj(i, Long.valueOf(zzq(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zzbcrVar);
            int i5 = zzbcrVar.zza;
            if (i5 < 0) {
                throw new zzbew("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZzj) {
                throw new zzbew("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzbheVar.zzj(i, zzbdd.zzb);
            } else {
                zzbheVar.zzj(i, zzbdd.zzo(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzbew("Protocol message contained an invalid tag (zero).");
            }
            zzbheVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzbhe zzbheVarZzf = zzbhe.zzf();
        int i7 = zzbcrVar.zze + 1;
        zzbcrVar.zze = i7;
        zzr(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzj2 = zzj(bArr, i2, zzbcrVar);
            int i9 = zzbcrVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZzj2;
                break;
            }
            i2 = zzi(i9, bArr, iZzj2, i3, zzbheVarZzf, zzbcrVar);
            i8 = i9;
        }
        zzbcrVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzbew("Failed to parse the message.");
        }
        zzbheVar.zzj(i, zzbheVarZzf);
        return i2;
    }

    static int zzj(byte[] bArr, int i, zzbcr zzbcrVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzbcrVar);
        }
        zzbcrVar.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzbcr zzbcrVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzbcrVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzbcrVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzbcrVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzbcrVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzbcrVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzbet zzbetVar, zzbcr zzbcrVar) {
        zzbem zzbemVar = (zzbem) zzbetVar;
        int iZzj = zzj(bArr, i2, zzbcrVar);
        zzbemVar.zzg(zzbcrVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zzbcrVar);
            if (i != zzbcrVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzbcrVar);
            zzbemVar.zzg(zzbcrVar.zza);
        }
        return iZzj;
    }

    static int zzm(byte[] bArr, int i, zzbcr zzbcrVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzbcrVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzbcrVar.zzb = j2;
        return i3;
    }

    static int zzn(Object obj, zzbgm zzbgmVar, byte[] bArr, int i, int i2, int i3, zzbcr zzbcrVar) throws IOException {
        int i4 = zzbcrVar.zze + 1;
        zzbcrVar.zze = i4;
        zzr(i4);
        int iZzc = ((zzbfv) zzbgmVar).zzc(obj, bArr, i, i2, i3, zzbcrVar);
        zzbcrVar.zze--;
        zzbcrVar.zzc = obj;
        return iZzc;
    }

    static int zzo(Object obj, zzbgm zzbgmVar, byte[] bArr, int i, int i2, zzbcr zzbcrVar) throws IOException {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zzbcrVar);
            i3 = zzbcrVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzbew("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzbcrVar.zze + 1;
        zzbcrVar.zze = i5;
        zzr(i5);
        int i6 = i4 + i3;
        zzbgmVar.zzi(obj, bArr, i4, i6, zzbcrVar);
        zzbcrVar.zze--;
        zzbcrVar.zzc = obj;
        return i6;
    }

    static int zzp(int i, byte[] bArr, int i2, int i3, zzbcr zzbcrVar) throws zzbew {
        if ((i >>> 3) == 0) {
            throw new zzbew("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzm(bArr, i2, zzbcrVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzj(bArr, i2, zzbcrVar) + zzbcrVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zzbew("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzj(bArr, i2, zzbcrVar);
            i6 = zzbcrVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzp(i6, bArr, i2, i3, zzbcrVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new zzbew("Failed to parse the message.");
        }
        return i2;
    }

    static long zzq(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzr(int i) throws zzbew {
        if (i >= zzb) {
            throw new zzbew("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
