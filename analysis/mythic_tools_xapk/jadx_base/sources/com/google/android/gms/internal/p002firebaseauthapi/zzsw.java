package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsw extends zzalf<zzsw, zza> implements zzamo {
    private static final zzsw zzc;
    private static volatile zzamv<zzsw> zzd;
    private int zze;
    private int zzf;
    private zzajv zzg = zzajv.zza;
    private zztc zzh;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzsw, zza> implements zzamo {
        private zza() {
            super(zzsw.zzc);
        }

        public final zza zza(zzajv zzajvVar) {
            zzg();
            zzsw.zza((zzsw) this.zza, zzajvVar);
            return this;
        }

        public final zza zza(zztc zztcVar) {
            zzg();
            zzsw.zza((zzsw) this.zza, zztcVar);
            return this;
        }
    }

    static {
        zzsw zzswVar = new zzsw();
        zzc = zzswVar;
        zzalf.zza((Class<zzsw>) zzsw.class, zzswVar);
    }

    private zzsw() {
    }

    public static zzsw zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzsw) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    static /* synthetic */ void zza(zzsw zzswVar, zzajv zzajvVar) {
        zzajvVar.getClass();
        zzswVar.zzg = zzajvVar;
    }

    static /* synthetic */ void zza(zzsw zzswVar, zztc zztcVar) {
        zztcVar.getClass();
        zzswVar.zzh = zztcVar;
        zzswVar.zze |= 1;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamv<zzsw> zzf() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzsy.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzsw();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzsw> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzsw.class) {
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

    public final zztc zzd() {
        zztc zztcVar = this.zzh;
        return zztcVar == null ? zztc.zzd() : zztcVar;
    }

    public final zzajv zze() {
        return this.zzg;
    }
}
