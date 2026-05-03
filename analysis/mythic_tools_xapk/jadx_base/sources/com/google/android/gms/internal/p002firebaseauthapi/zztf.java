package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zztf extends zzalf<zztf, zza> implements zzamo {
    private static final zztf zzc;
    private static volatile zzamv<zztf> zzd;
    private int zze;
    private int zzf;
    private zztl zzg;
    private zzwb zzh;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zztf, zza> implements zzamo {
        private zza() {
            super(zztf.zzc);
        }

        public final zza zza(zztl zztlVar) {
            zzg();
            zztf.zza((zztf) this.zza, zztlVar);
            return this;
        }

        public final zza zza(zzwb zzwbVar) {
            zzg();
            zztf.zza((zztf) this.zza, zzwbVar);
            return this;
        }
    }

    static {
        zztf zztfVar = new zztf();
        zzc = zztfVar;
        zzalf.zza((Class<zztf>) zztf.class, zztfVar);
    }

    private zztf() {
    }

    public static zztf zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zztf) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    static /* synthetic */ void zza(zztf zztfVar, zztl zztlVar) {
        zztlVar.getClass();
        zztfVar.zzg = zztlVar;
        zztfVar.zze |= 1;
    }

    static /* synthetic */ void zza(zztf zztfVar, zzwb zzwbVar) {
        zzwbVar.getClass();
        zztfVar.zzh = zzwbVar;
        zztfVar.zze |= 2;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamv<zztf> zzf() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzth.zza[i - 1];
        switch (i2) {
            case 1:
                return new zztf();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zztf> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zztf.class) {
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

    public final zztl zzd() {
        zztl zztlVar = this.zzg;
        return zztlVar == null ? zztl.zzd() : zztlVar;
    }

    public final zzwb zze() {
        zzwb zzwbVar = this.zzh;
        return zzwbVar == null ? zzwb.zzd() : zzwbVar;
    }
}
