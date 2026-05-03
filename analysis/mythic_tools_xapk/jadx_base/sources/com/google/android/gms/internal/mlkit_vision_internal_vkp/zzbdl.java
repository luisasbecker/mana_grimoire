package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzbdl extends zzbdq {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    zzbdl(int i) {
        super(null);
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i, 20)];
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final int zzb() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    final void zzc(byte b) {
        int i = this.zzc;
        this.zzc = i + 1;
        this.zza[i] = b;
        this.zzd++;
    }

    final void zzd(int i) {
        int i2 = this.zzc;
        int i3 = i2 + 1;
        this.zzc = i3;
        byte[] bArr = this.zza;
        bArr[i2] = (byte) (i & 255);
        int i4 = i2 + 2;
        this.zzc = i4;
        bArr[i3] = (byte) ((i >> 8) & 255);
        int i5 = i2 + 3;
        this.zzc = i5;
        bArr[i4] = (byte) ((i >> 16) & 255);
        this.zzc = i2 + 4;
        bArr[i5] = (byte) ((i >> 24) & 255);
        this.zzd += 4;
    }

    final void zze(long j) {
        int i = this.zzc;
        int i2 = i + 1;
        this.zzc = i2;
        byte[] bArr = this.zza;
        bArr[i] = (byte) (j & 255);
        int i3 = i + 2;
        this.zzc = i3;
        bArr[i2] = (byte) ((j >> 8) & 255);
        int i4 = i + 3;
        this.zzc = i4;
        bArr[i3] = (byte) ((j >> 16) & 255);
        int i5 = i + 4;
        this.zzc = i5;
        bArr[i4] = (byte) (255 & (j >> 24));
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
        this.zzd += 8;
    }

    final void zzf(int i) {
        if (zzbdq.zzb) {
            long j = this.zzc;
            while (true) {
                int i2 = i & (-128);
                byte[] bArr = this.zza;
                if (i2 == 0) {
                    int i3 = this.zzc;
                    this.zzc = i3 + 1;
                    zzbhk.zzn(bArr, i3, (byte) i);
                    this.zzd += (int) (((long) this.zzc) - j);
                    return;
                }
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                zzbhk.zzn(bArr, i4, (byte) ((i | 128) & 255));
                i >>>= 7;
            }
        } else {
            while (true) {
                int i5 = i & (-128);
                byte[] bArr2 = this.zza;
                if (i5 == 0) {
                    int i6 = this.zzc;
                    this.zzc = i6 + 1;
                    bArr2[i6] = (byte) i;
                    this.zzd++;
                    return;
                }
                int i7 = this.zzc;
                this.zzc = i7 + 1;
                bArr2[i7] = (byte) ((i | 128) & 255);
                this.zzd++;
                i >>>= 7;
            }
        }
    }

    final void zzg(long j) {
        if (zzbdq.zzb) {
            long j2 = this.zzc;
            while (true) {
                long j3 = j & (-128);
                int i = (int) j;
                byte[] bArr = this.zza;
                if (j3 == 0) {
                    int i2 = this.zzc;
                    this.zzc = i2 + 1;
                    zzbhk.zzn(bArr, i2, (byte) i);
                    this.zzd += (int) (((long) this.zzc) - j2);
                    return;
                }
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                zzbhk.zzn(bArr, i3, (byte) ((i | 128) & 255));
                j >>>= 7;
            }
        } else {
            while (true) {
                long j4 = j & (-128);
                int i4 = (int) j;
                byte[] bArr2 = this.zza;
                if (j4 == 0) {
                    int i5 = this.zzc;
                    this.zzc = i5 + 1;
                    bArr2[i5] = (byte) i4;
                    this.zzd++;
                    return;
                }
                int i6 = this.zzc;
                this.zzc = i6 + 1;
                bArr2[i6] = (byte) ((i4 | 128) & 255);
                this.zzd++;
                j >>>= 7;
            }
        }
    }
}
