package com.google.android.gms.internal.mlkit_language_id_common;

/* JADX INFO: compiled from: com.google.mlkit:language-id-common@@16.1.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlt {
    private static zzls zza;

    public static synchronized zzli zza(zzlc zzlcVar) {
        if (zza == null) {
            zza = new zzls(null);
        }
        return (zzli) zza.get(zzlcVar);
    }

    public static synchronized zzli zzb(String str) {
        return zza(zzlc.zzd(str).zzd());
    }
}
