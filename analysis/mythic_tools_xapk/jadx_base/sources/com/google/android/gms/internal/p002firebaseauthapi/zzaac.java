package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaac implements zzsq {
    private final zzsq zza;
    private final zzsq zzb;

    private zzaac(zzsq zzsqVar, zzsq zzsqVar2) {
        this.zza = zzsqVar;
        this.zzb = zzsqVar2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzsq
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        return bArr.length <= 64 ? this.zza.zza(bArr, i) : this.zzb.zza(bArr, i);
    }
}
