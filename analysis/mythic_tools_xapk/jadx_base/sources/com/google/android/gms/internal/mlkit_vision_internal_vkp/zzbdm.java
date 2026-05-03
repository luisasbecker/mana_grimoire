package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbdm extends zzbdq {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzbdm(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzM() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzN(byte b) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            this.zzc = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzbdn(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzO(int i, boolean z) throws IOException {
        zzx(i << 3);
        zzN(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzP(byte[] bArr, int i, int i2) throws IOException {
        zzx(i2);
        zze(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcu
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zze(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzbdn(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i2)), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzh(int i, zzbdd zzbddVar) throws IOException {
        zzx((i << 3) | 2);
        zzi(zzbddVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzi(zzbdd zzbddVar) throws IOException {
        zzx(zzbddVar.zzd());
        zzbddVar.zzk(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzj(int i, int i2) throws IOException {
        zzx((i << 3) | 5);
        zzk(i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzk(int i) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i2 = this.zzc;
            int i3 = i2 + 1;
            this.zzc = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.zzc = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.zzc = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.zzc = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzbdn(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzl(int i, long j) throws IOException {
        zzx((i << 3) | 1);
        zzm(j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzm(long j) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            int i2 = i + 1;
            this.zzc = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.zzc = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.zzc = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.zzc = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.zzc = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.zzc = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.zzc = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.zzc = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzbdn(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzn(int i, int i2) throws IOException {
        zzx(i << 3);
        zzo(i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzo(int i) throws IOException {
        if (i >= 0) {
            zzx(i);
        } else {
            zzz(i);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    final void zzp(int i, zzbfs zzbfsVar, zzbgm zzbgmVar) throws IOException {
        zzx((i << 3) | 2);
        zzx(((zzbck) zzbfsVar).zzs(zzbgmVar));
        zzbgmVar.zzj(zzbfsVar, this.zze);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzq(zzbfs zzbfsVar) throws IOException {
        zzx(zzbfsVar.zzz());
        zzbfsVar.zzX(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzr(int i, zzbfs zzbfsVar) throws IOException {
        zzx(11);
        zzw(2, i);
        zzx(26);
        zzq(zzbfsVar);
        zzx(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzs(int i, zzbdd zzbddVar) throws IOException {
        zzx(11);
        zzw(2, i);
        zzh(3, zzbddVar);
        zzx(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzt(int i, String str) throws IOException {
        zzx((i << 3) | 2);
        zzu(str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzu(String str) throws IOException {
        int i = this.zzc;
        try {
            int iZzF = zzF(str.length() * 3);
            int iZzF2 = zzF(str.length());
            if (iZzF2 != iZzF) {
                zzx(zzbhp.zzc(str));
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = zzbhp.zzb(str, bArr, i2, this.zzb - i2);
                return;
            }
            int i3 = i + iZzF2;
            this.zzc = i3;
            int iZzb = zzbhp.zzb(str, this.zza, i3, this.zzb - i3);
            this.zzc = i;
            zzx((iZzb - i) - iZzF2);
            this.zzc = iZzb;
        } catch (zzbho e) {
            this.zzc = i;
            zzI(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzbdn(e2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzv(int i, int i2) throws IOException {
        zzx((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzw(int i, int i2) throws IOException {
        zzx(i << 3);
        zzx(i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzx(int i) throws IOException {
        while (true) {
            int i2 = i & (-128);
            byte[] bArr = this.zza;
            if (i2 == 0) {
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                bArr[i3] = (byte) i;
                return;
            } else {
                try {
                    int i4 = this.zzc;
                    this.zzc = i4 + 1;
                    bArr[i4] = (byte) ((i | 128) & 255);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzbdn(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
                }
            }
            throw new zzbdn(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzy(int i, long j) throws IOException {
        zzx(i << 3);
        zzz(j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzz(long j) throws IOException {
        if (!zzbdq.zzb || this.zzb - this.zzc < 10) {
            while (true) {
                long j2 = j & (-128);
                byte[] bArr = this.zza;
                if (j2 == 0) {
                    int i = this.zzc;
                    this.zzc = i + 1;
                    bArr[i] = (byte) j;
                    return;
                } else {
                    try {
                        int i2 = this.zzc;
                        this.zzc = i2 + 1;
                        bArr[i2] = (byte) ((((int) j) | 128) & 255);
                        j >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzbdn(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
                    }
                }
                throw new zzbdn(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
            }
        }
        while (true) {
            long j3 = j & (-128);
            int i3 = (int) j;
            byte[] bArr2 = this.zza;
            if (j3 == 0) {
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                zzbhk.zzn(bArr2, i4, (byte) i3);
                return;
            } else {
                int i5 = this.zzc;
                this.zzc = i5 + 1;
                zzbhk.zzn(bArr2, i5, (byte) ((i3 | 128) & 255));
                j >>>= 7;
            }
        }
    }
}
