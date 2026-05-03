package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaam {
    private final BigInteger zza;

    private zzaam(BigInteger bigInteger) {
        this.zza = bigInteger;
    }

    public static zzaam zza(BigInteger bigInteger, zzch zzchVar) {
        if (zzchVar != null) {
            return new zzaam(bigInteger);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final BigInteger zza(zzch zzchVar) {
        if (zzchVar != null) {
            return this.zza;
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
