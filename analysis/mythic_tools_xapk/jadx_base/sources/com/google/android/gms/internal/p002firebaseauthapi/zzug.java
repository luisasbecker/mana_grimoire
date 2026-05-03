package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzug extends zzalf<zzug, zza> implements zzamo {
    private static final zzug zzc;
    private static volatile zzamv<zzug> zzd;
    private int zze;
    private int zzf;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzug, zza> implements zzamo {
        private zza() {
            super(zzug.zzc);
        }

        public final zza zza(int i) {
            zzg();
            ((zzug) this.zza).zze = i;
            return this;
        }
    }

    static {
        zzug zzugVar = new zzug();
        zzc = zzugVar;
        zzalf.zza((Class<zzug>) zzug.class, zzugVar);
    }

    private zzug() {
    }

    public static zzug zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzug) zzalf.zza(zzc, zzajvVar, zzakuVar);
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
        int i2 = zzui.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzug();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzug> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzug.class) {
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
