package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbdd implements Iterable, Serializable {
    public static final zzbdd zzb = new zzbdc(zzbeu.zzb);
    private int zza = 0;

    static {
        int i = zzbcn.zza;
    }

    zzbdd() {
    }

    private static zzbdd zzc(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return (zzbdd) it.next();
        }
        int i2 = i >>> 1;
        zzbdd zzbddVarZzc = zzc(it, i2);
        zzbdd zzbddVarZzc2 = zzc(it, i - i2);
        if (Integer.MAX_VALUE - zzbddVarZzc.zzd() >= zzbddVarZzc2.zzd()) {
            return zzbgl.zzt(zzbddVarZzc, zzbddVarZzc2);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + zzbddVarZzc.zzd() + "+" + zzbddVarZzc2.zzd());
    }

    static int zzl(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public static zzbdd zzo(byte[] bArr, int i, int i2) {
        zzl(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzbdc(bArr2);
    }

    public static zzbdd zzp(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i = 0;
            while (i < iMin) {
                int i2 = inputStream.read(bArr, i, iMin - i);
                if (i2 == -1) {
                    break;
                }
                i += i2;
            }
            zzbdd zzbddVarZzo = i == 0 ? null : zzo(bArr, 0, i);
            if (zzbddVarZzo == null) {
                break;
            }
            arrayList.add(zzbddVarZzo);
            iMin = Math.min(iMin + iMin, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zzb : zzc(arrayList.iterator(), size);
    }

    static void zzq(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zza;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zza = iZzi;
        }
        return iZzi;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzd()), zzd() <= 50 ? zzbgy.zza(this) : zzbgy.zza(zzj(0, 47)).concat("..."));
    }

    public abstract byte zza(int i);

    abstract byte zzb(int i);

    public abstract int zzd();

    protected abstract void zze(byte[] bArr, int i, int i2, int i3);

    protected abstract int zzf();

    protected abstract boolean zzh();

    protected abstract int zzi(int i, int i2, int i3);

    public abstract zzbdd zzj(int i, int i2);

    abstract void zzk(zzbcu zzbcuVar) throws IOException;

    protected final int zzm() {
        return this.zza;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public zzbcy iterator() {
        return new zzbcv(this);
    }

    @Deprecated
    public final void zzr(byte[] bArr, int i, int i2, int i3) {
        zzl(0, i3, zzd());
        zzl(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }
}
