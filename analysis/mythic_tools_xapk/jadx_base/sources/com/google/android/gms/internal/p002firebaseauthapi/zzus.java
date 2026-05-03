package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzus extends zzalf<zzus, zza> implements zzamo {
    private static final zzus zzc;
    private static volatile zzamv<zzus> zzd;
    private int zze;
    private int zzf;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzus, zza> implements zzamo {
        private zza() {
            super(zzus.zzc);
        }

        public final zza zza(int i) {
            zzg();
            ((zzus) this.zza).zze = i;
            return this;
        }
    }

    static {
        zzus zzusVar = new zzus();
        zzc = zzusVar;
        zzalf.zza((Class<zzus>) zzus.class, zzusVar);
    }

    private zzus() {
    }

    public static zzus zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzus) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzuu.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzus();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzus> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzus.class) {
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

    public final int zzb() {
        return this.zzf;
    }
}
