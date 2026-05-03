package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaal {
    private final zzaaj zza;

    private zzaal(zzaaj zzaajVar) {
        this.zza = zzaajVar;
    }

    public static zzaal zza(int i) {
        return new zzaal(zzaaj.zza(zzqd.zza(i)));
    }

    public static zzaal zza(byte[] bArr, zzch zzchVar) {
        if (zzchVar != null) {
            return new zzaal(zzaaj.zza(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final byte[] zza(zzch zzchVar) {
        if (zzchVar != null) {
            return this.zza.zzb();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
