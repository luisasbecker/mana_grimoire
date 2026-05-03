package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwo extends zzalf<zzwo, zza> implements zzamo {
    private static final zzwo zzc;
    private static volatile zzamv<zzwo> zzd;
    private int zze;
    private int zzf;
    private int zzg;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwo, zza> implements zzamo {
        private zza() {
            super(zzwo.zzc);
        }

        public final zza zza(zzwj zzwjVar) {
            zzg();
            zzwo.zza((zzwo) this.zza, zzwjVar);
            return this;
        }

        public final zza zza(zzwk zzwkVar) {
            zzg();
            zzwo.zza((zzwo) this.zza, zzwkVar);
            return this;
        }

        public final zza zza(zzwm zzwmVar) {
            zzg();
            zzwo.zza((zzwo) this.zza, zzwmVar);
            return this;
        }
    }

    static {
        zzwo zzwoVar = new zzwo();
        zzc = zzwoVar;
        zzalf.zza((Class<zzwo>) zzwo.class, zzwoVar);
    }

    private zzwo() {
    }

    static /* synthetic */ void zza(zzwo zzwoVar, zzwj zzwjVar) {
        zzwoVar.zzf = zzwjVar.zza();
    }

    static /* synthetic */ void zza(zzwo zzwoVar, zzwk zzwkVar) {
        zzwoVar.zzg = zzwkVar.zza();
    }

    static /* synthetic */ void zza(zzwo zzwoVar, zzwm zzwmVar) {
        zzwoVar.zze = zzwmVar.zza();
    }

    public static zza zzd() {
        return (zza) zzc.zzm();
    }

    public static zzwo zzf() {
        return zzc;
    }

    public final zzwk zza() {
        zzwk zzwkVarZza = zzwk.zza(this.zzg);
        return zzwkVarZza == null ? zzwk.UNRECOGNIZED : zzwkVarZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzwq.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzwo();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwo> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzwo.class) {
                    zzaVar = zzd;
                    if (zzaVar == null) {
                        zzaVar = new zzalf.zza(zzc);
                        zzd = zzaVar;
                    }
                    break;
                }
                return zzaVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    public final zzwj zzb() {
        zzwj zzwjVarZza = zzwj.zza(this.zzf);
        return zzwjVarZza == null ? zzwj.UNRECOGNIZED : zzwjVarZza;
    }

    public final zzwm zzc() {
        zzwm zzwmVarZza = zzwm.zza(this.zze);
        return zzwmVarZza == null ? zzwm.UNRECOGNIZED : zzwmVarZza;
    }
}
