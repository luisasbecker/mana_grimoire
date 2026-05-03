package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbdo extends zzbdl {
    private final OutputStream zzg;

    zzbdo(OutputStream outputStream, int i) {
        super(i);
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.zzg = outputStream;
    }

    private final void zzK() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzL(int i) throws IOException {
        if (this.zzb - this.zzc < i) {
            zzK();
        }
    }

    public final void zzA(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, this.zza, i4, i2);
            this.zzc += i2;
            this.zzd += i2;
            return;
        }
        System.arraycopy(bArr, i, this.zza, i4, i5);
        int i6 = i + i5;
        this.zzc = this.zzb;
        this.zzd += i5;
        zzK();
        int i7 = i2 - i5;
        if (i7 <= this.zzb) {
            System.arraycopy(bArr, i6, this.zza, 0, i7);
            this.zzc = i7;
        } else {
            this.zzg.write(bArr, i6, i7);
        }
        this.zzd += i7;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzM() throws IOException {
        if (this.zzc > 0) {
            zzK();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzN(byte b) throws IOException {
        if (this.zzc == this.zzb) {
            zzK();
        }
        zzc(b);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzO(int i, boolean z) throws IOException {
        zzL(11);
        zzf(i << 3);
        zzc(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzP(byte[] bArr, int i, int i2) throws IOException {
        zzx(i2);
        zzA(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcu
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzA(bArr, i, i2);
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
        zzL(14);
        zzf((i << 3) | 5);
        zzd(i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzk(int i) throws IOException {
        zzL(4);
        zzd(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzl(int i, long j) throws IOException {
        zzL(18);
        zzf((i << 3) | 1);
        zze(j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzm(long j) throws IOException {
        zzL(8);
        zze(j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzn(int i, int i2) throws IOException {
        zzL(20);
        zzf(i << 3);
        if (i2 >= 0) {
            zzf(i2);
        } else {
            zzg(i2);
        }
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
        int iZzc;
        try {
            int length = str.length() * 3;
            int iZzF = zzF(length);
            int i = iZzF + length;
            int i2 = this.zzb;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iZzb = zzbhp.zzb(str, bArr, 0, length);
                zzx(iZzb);
                zzA(bArr, 0, iZzb);
                return;
            }
            if (i > i2 - this.zzc) {
                zzK();
            }
            int iZzF2 = zzF(str.length());
            int i3 = this.zzc;
            try {
                if (iZzF2 == iZzF) {
                    int i4 = i3 + iZzF2;
                    this.zzc = i4;
                    int iZzb2 = zzbhp.zzb(str, this.zza, i4, this.zzb - i4);
                    this.zzc = i3;
                    iZzc = (iZzb2 - i3) - iZzF2;
                    zzf(iZzc);
                    this.zzc = iZzb2;
                } else {
                    iZzc = zzbhp.zzc(str);
                    zzf(iZzc);
                    this.zzc = zzbhp.zzb(str, this.zza, this.zzc, iZzc);
                }
                this.zzd += iZzc;
            } catch (zzbho e) {
                this.zzd -= this.zzc - i3;
                this.zzc = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new zzbdn(e2);
            }
        } catch (zzbho e3) {
            zzI(str, e3);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzv(int i, int i2) throws IOException {
        zzx((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzw(int i, int i2) throws IOException {
        zzL(20);
        zzf(i << 3);
        zzf(i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzx(int i) throws IOException {
        zzL(5);
        zzf(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzy(int i, long j) throws IOException {
        zzL(20);
        zzf(i << 3);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdq
    public final void zzz(long j) throws IOException {
        zzL(10);
        zzg(j);
    }
}
