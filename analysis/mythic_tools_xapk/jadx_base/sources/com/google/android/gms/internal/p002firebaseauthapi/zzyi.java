package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyi extends zzalf<zzyi, zza> implements zzamo {
    private static final zzyi zzc;
    private static volatile zzamv<zzyi> zzd;
    private int zze;
    private int zzf;
    private zzyl zzg;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzyi, zza> implements zzamo {
        private zza() {
            super(zzyi.zzc);
        }

        public final zza zza(zzyl zzylVar) {
            zzg();
            zzyi.zza((zzyi) this.zza, zzylVar);
            return this;
        }
    }

    static {
        zzyi zzyiVar = new zzyi();
        zzc = zzyiVar;
        zzalf.zza((Class<zzyi>) zzyi.class, zzyiVar);
    }

    private zzyi() {
    }

    public static zzyi zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzyi) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    static /* synthetic */ void zza(zzyi zzyiVar, zzyl zzylVar) {
        zzylVar.getClass();
        zzyiVar.zzg = zzylVar;
        zzyiVar.zze |= 1;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzyh.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzyi();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyi> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzyi.class) {
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

    public final zzyl zzd() {
        zzyl zzylVar = this.zzg;
        return zzylVar == null ? zzyl.zzd() : zzylVar;
    }
}
