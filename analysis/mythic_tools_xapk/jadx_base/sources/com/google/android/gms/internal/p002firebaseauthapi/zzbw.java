package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxh;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbw {
    private final zzxh.zza zza;

    private zzbw(zzxh.zza zzaVar) {
        this.zza = zzaVar;
    }

    public static zzbw zza(zzbm zzbmVar) {
        return new zzbw(zzbmVar.zzd().zzn());
    }

    public final synchronized zzbm zza() throws GeneralSecurityException {
        return zzbm.zza((zzxh) ((zzalf) this.zza.zze()));
    }
}
