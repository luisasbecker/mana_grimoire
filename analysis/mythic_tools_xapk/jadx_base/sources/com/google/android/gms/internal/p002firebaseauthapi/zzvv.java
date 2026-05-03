package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvv extends zzalf<zzvv, zza> implements zzamo {
    private static final zzvv zzc;
    private static volatile zzamv<zzvv> zzd;
    private int zze;
    private zzajv zzf = zzajv.zza;
    private zzxk zzg;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzvv, zza> implements zzamo {
        private zza() {
            super(zzvv.zzc);
        }

        public final zza zza() {
            zzg();
            zzvv.zza((zzvv) this.zza);
            return this;
        }

        public final zza zza(zzajv zzajvVar) {
            zzg();
            zzvv.zza((zzvv) this.zza, zzajvVar);
            return this;
        }

        public final zza zza(zzxk zzxkVar) {
            zzg();
            zzvv.zza((zzvv) this.zza, zzxkVar);
            return this;
        }
    }

    static {
        zzvv zzvvVar = new zzvv();
        zzc = zzvvVar;
        zzalf.zza((Class<zzvv>) zzvv.class, zzvvVar);
    }

    private zzvv() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvv zza(InputStream inputStream, zzaku zzakuVar) throws IOException {
        return (zzvv) zzalf.zza(zzc, inputStream, zzakuVar);
    }

    static /* synthetic */ void zza(zzvv zzvvVar) {
        zzvvVar.zzg = null;
        zzvvVar.zze &= -2;
    }

    static /* synthetic */ void zza(zzvv zzvvVar, zzajv zzajvVar) {
        zzajvVar.getClass();
        zzvvVar.zzf = zzajvVar;
    }

    static /* synthetic */ void zza(zzvv zzvvVar, zzxk zzxkVar) {
        zzxkVar.getClass();
        zzvvVar.zzg = zzxkVar;
        zzvvVar.zze |= 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzvx.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzvv();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzvv> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzvv.class) {
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

    public final zzajv zzc() {
        return this.zzf;
    }
}
