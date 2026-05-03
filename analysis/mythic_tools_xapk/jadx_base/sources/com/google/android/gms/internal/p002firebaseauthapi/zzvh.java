package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvh extends zzalf<zzvh, zza> implements zzamo {
    private static final zzvh zzc;
    private static volatile zzamv<zzvh> zzd;
    private int zze;
    private zzvk zzf;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzvh, zza> implements zzamo {
        private zza() {
            super(zzvh.zzc);
        }

        public final zza zza(zzvk zzvkVar) {
            zzg();
            zzvh.zza((zzvh) this.zza, zzvkVar);
            return this;
        }
    }

    static {
        zzvh zzvhVar = new zzvh();
        zzc = zzvhVar;
        zzalf.zza((Class<zzvh>) zzvh.class, zzvhVar);
    }

    private zzvh() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvh zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzvh) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    static /* synthetic */ void zza(zzvh zzvhVar, zzvk zzvkVar) {
        zzvkVar.getClass();
        zzvhVar.zzf = zzvkVar;
        zzvhVar.zze |= 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzvg.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzvh();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzvh> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzvh.class) {
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

    public final zzvk zzc() {
        zzvk zzvkVar = this.zzf;
        return zzvkVar == null ? zzvk.zze() : zzvkVar;
    }
}
