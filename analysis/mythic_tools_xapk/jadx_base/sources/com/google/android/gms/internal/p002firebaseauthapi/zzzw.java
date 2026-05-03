package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzzw implements zzzp<Mac> {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzzp
    public final /* synthetic */ Mac zza(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
