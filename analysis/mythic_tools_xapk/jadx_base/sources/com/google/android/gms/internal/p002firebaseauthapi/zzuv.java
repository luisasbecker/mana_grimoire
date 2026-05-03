package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzuv extends zzalf<zzuv, zza> implements zzamo {
    private static final zzuv zzc;
    private static volatile zzamv<zzuv> zzd;
    private int zze;
    private zzajv zzf = zzajv.zza;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzuv, zza> implements zzamo {
        private zza() {
            super(zzuv.zzc);
        }

        public final zza zza(zzajv zzajvVar) {
            zzg();
            zzuv.zza((zzuv) this.zza, zzajvVar);
            return this;
        }
    }

    static {
        zzuv zzuvVar = new zzuv();
        zzc = zzuvVar;
        zzalf.zza((Class<zzuv>) zzuv.class, zzuvVar);
    }

    private zzuv() {
    }

    public static zzuv zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzuv) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    static /* synthetic */ void zza(zzuv zzuvVar, zzajv zzajvVar) {
        zzajvVar.getClass();
        zzuvVar.zzf = zzajvVar;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamv<zzuv> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzux.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzuv();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzuv> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzuv.class) {
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
