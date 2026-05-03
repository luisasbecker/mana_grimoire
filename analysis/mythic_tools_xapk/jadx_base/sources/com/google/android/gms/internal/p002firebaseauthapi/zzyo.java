package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyo extends zzalf<zzyo, zza> implements zzamo {
    private static final zzyo zzc;
    private static volatile zzamv<zzyo> zzd;
    private int zze;
    private zzajv zzf = zzajv.zza;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzyo, zza> implements zzamo {
        private zza() {
            super(zzyo.zzc);
        }

        public final zza zza(zzajv zzajvVar) {
            zzg();
            zzyo.zza((zzyo) this.zza, zzajvVar);
            return this;
        }
    }

    static {
        zzyo zzyoVar = new zzyo();
        zzc = zzyoVar;
        zzalf.zza((Class<zzyo>) zzyo.class, zzyoVar);
    }

    private zzyo() {
    }

    public static zzyo zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzyo) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    static /* synthetic */ void zza(zzyo zzyoVar, zzajv zzajvVar) {
        zzajvVar.getClass();
        zzyoVar.zzf = zzajvVar;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamv<zzyo> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzyn.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzyo();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyo> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzyo.class) {
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

    public final zzajv zzd() {
        return this.zzf;
    }
}
