package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzge extends zzcy {
    private final zza zza;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("NO_PREFIX");
        private final String zzd;

        private zza(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    private zzge(zza zzaVar) {
        this.zza = zzaVar;
    }

    public static zzge zza(zza zzaVar) {
        return new zzge(zzaVar);
    }

    public static zzge zzc() {
        return new zzge(zza.zzc);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzge) && ((zzge) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzge.class, this.zza);
    }

    public final String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + String.valueOf(this.zza) + ")";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcb
    public final boolean zza() {
        return this.zza != zza.zzc;
    }

    public final zza zzb() {
        return this.zza;
    }
}
