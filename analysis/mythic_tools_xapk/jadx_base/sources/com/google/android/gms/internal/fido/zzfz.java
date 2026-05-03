package com.google.android.gms.internal.fido;

import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfz extends zzfp {
    private final MessageDigest zza;
    private final int zzb;
    private boolean zzc;

    /* synthetic */ zzfz(MessageDigest messageDigest, int i, zzfy zzfyVar) {
        this.zza = messageDigest;
        this.zzb = i;
    }

    private final void zzd() {
        zzbm.zzf(!this.zzc, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override // com.google.android.gms.internal.fido.zzfp
    protected final void zzb(byte[] bArr, int i, int i2) {
        zzd();
        this.zza.update(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.fido.zzfv
    public final zzft zzc() {
        zzd();
        this.zzc = true;
        int i = this.zzb;
        int digestLength = this.zza.getDigestLength();
        MessageDigest messageDigest = this.zza;
        if (i == digestLength) {
            byte[] bArrDigest = messageDigest.digest();
            int i2 = zzft.zzb;
            return new zzfs(bArrDigest);
        }
        byte[] bArrCopyOf = Arrays.copyOf(messageDigest.digest(), i);
        int i3 = zzft.zzb;
        return new zzfs(bArrCopyOf);
    }
}
