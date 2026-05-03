package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
final class zzzl<JcePrimitiveT> implements zzzn<JcePrimitiveT> {
    private final zzzp<JcePrimitiveT> zza;

    private zzzl(zzzp<JcePrimitiveT> zzzpVar) {
        this.zza = zzzpVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzzn
    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        return this.zza.zza(str, null);
    }
}
