package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public class zzaet {
    final zzafe zza;
    private final String zzb;

    public zzaet(String str, zzafe zzafeVar) {
        this.zzb = str;
        this.zza = zzafeVar;
    }

    final String zza(String str, String str2) {
        return this.zzb + str + "?key=" + str2;
    }
}
