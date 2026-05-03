package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes5.dex */
public class FirebaseAuthMultiFactorException extends FirebaseAuthException {
    private MultiFactorResolver zza;

    public FirebaseAuthMultiFactorException(String str, String str2, MultiFactorResolver multiFactorResolver) {
        super(str, str2);
        this.zza = multiFactorResolver;
    }

    public MultiFactorResolver getResolver() {
        return this.zza;
    }
}
