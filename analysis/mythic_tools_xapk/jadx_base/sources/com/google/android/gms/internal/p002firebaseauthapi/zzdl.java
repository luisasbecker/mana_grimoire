package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdq;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdl extends zzcw {
    private final zzdq zza;
    private final zzaal zzb;
    private final zzaaj zzc;

    @Nullable
    private final Integer zzd;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zza {

        @Nullable
        private zzdq zza;

        @Nullable
        private zzaal zzb;

        @Nullable
        private Integer zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzaal zzaalVar) {
            this.zzb = zzaalVar;
            return this;
        }

        public final zza zza(zzdq zzdqVar) {
            this.zza = zzdqVar;
            return this;
        }

        public final zza zza(@Nullable Integer num) {
            this.zzc = num;
            return this;
        }

        public final zzdl zza() throws GeneralSecurityException {
            zzaaj zzaajVarZzb;
            zzdq zzdqVar = this.zza;
            if (zzdqVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzdqVar.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzf() == zzdq.zzb.zzc) {
                zzaajVarZzb = zzpe.zza;
            } else if (this.zza.zzf() == zzdq.zzb.zzb) {
                zzaajVarZzb = zzpe.zza(this.zzc.intValue());
            } else {
                if (this.zza.zzf() != zzdq.zzb.zza) {
                    throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + String.valueOf(this.zza.zzf()));
                }
                zzaajVarZzb = zzpe.zzb(this.zzc.intValue());
            }
            return new zzdl(this.zza, this.zzb, zzaajVarZzb, this.zzc);
        }
    }

    private zzdl(zzdq zzdqVar, zzaal zzaalVar, zzaaj zzaajVar, @Nullable Integer num) {
        this.zza = zzdqVar;
        this.zzb = zzaalVar;
        this.zzc = zzaajVar;
        this.zzd = num;
    }

    public static zza zze() {
        return new zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcw, com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final /* synthetic */ zzcb zza() {
        return (zzdq) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcw
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzcy zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcw
    public final zzaaj zzd() {
        return this.zzc;
    }

    public final zzaal zzf() {
        return this.zzb;
    }
}
