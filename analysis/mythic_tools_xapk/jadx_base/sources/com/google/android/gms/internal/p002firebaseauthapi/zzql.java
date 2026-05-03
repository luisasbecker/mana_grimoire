package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzql extends RuntimeException {
    public zzql(String str) {
        super(str);
    }

    public zzql(String str, Throwable th) {
        super(str, th);
    }

    public zzql(Throwable th) {
        super(th);
    }

    public static <T> T zza(zzqo<T> zzqoVar) {
        try {
            return zzqoVar.zza();
        } catch (Exception e) {
            throw new zzql(e);
        }
    }
}
