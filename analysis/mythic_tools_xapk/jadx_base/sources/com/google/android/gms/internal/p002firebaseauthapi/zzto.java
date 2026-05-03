package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzto extends zzalf<zzto, zza> implements zzamo {
    private static final zzto zzc;
    private static volatile zzamv<zzto> zzd;
    private int zze;
    private zztr zzf;
    private int zzg;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzto, zza> implements zzamo {
        private zza() {
            super(zzto.zzc);
        }

        public final zza zza(int i) {
            zzg();
            ((zzto) this.zza).zzg = i;
            return this;
        }

        public final zza zza(zztr zztrVar) {
            zzg();
            zzto.zza((zzto) this.zza, zztrVar);
            return this;
        }
    }

    static {
        zzto zztoVar = new zzto();
        zzc = zztoVar;
        zzalf.zza((Class<zzto>) zzto.class, zztoVar);
    }

    private zzto() {
    }

    static /* synthetic */ void zza(zzto zztoVar, zztr zztrVar) {
        zztrVar.getClass();
        zztoVar.zzf = zztrVar;
        zztoVar.zze |= 1;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzto zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zztq.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzto();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzto> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzto.class) {
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

    public final zztr zze() {
        zztr zztrVar = this.zzf;
        return zztrVar == null ? zztr.zzd() : zztrVar;
    }
}
