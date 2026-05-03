package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwl extends zzalf<zzwl, zza> implements zzamo {
    private static final zzwl zzc;
    private static volatile zzamv<zzwl> zzd;
    private int zze;
    private zzwo zzf;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwl, zza> implements zzamo {
        private zza() {
            super(zzwl.zzc);
        }

        public final zza zza(zzwo zzwoVar) {
            zzg();
            zzwl.zza((zzwl) this.zza, zzwoVar);
            return this;
        }
    }

    static {
        zzwl zzwlVar = new zzwl();
        zzc = zzwlVar;
        zzalf.zza((Class<zzwl>) zzwl.class, zzwlVar);
    }

    private zzwl() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzwl zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzwl) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    static /* synthetic */ void zza(zzwl zzwlVar, zzwo zzwoVar) {
        zzwoVar.getClass();
        zzwlVar.zzf = zzwoVar;
        zzwlVar.zze |= 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i, Object obj, Object obj2) {
        zzamv zzaVar;
        int i2 = zzwn.zza[i - 1];
        switch (i2) {
            case 1:
                return new zzwl();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwl> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzwl.class) {
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

    public final zzwo zzc() {
        zzwo zzwoVar = this.zzf;
        return zzwoVar == null ? zzwo.zzf() : zzwoVar;
    }
}
