package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbdk implements zzbge {
    private final zzbdj zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzbdk(zzbdj zzbdjVar) {
        byte[] bArr = zzbeu.zzb;
        this.zza = zzbdjVar;
        zzbdjVar.zzc = this;
    }

    private final Object zzS(zzbhq zzbhqVar, Class cls, zzbdv zzbdvVar) throws IOException {
        zzbhq zzbhqVar2 = zzbhq.DOUBLE;
        switch (zzbhqVar) {
            case DOUBLE:
                return Double.valueOf(zza());
            case FLOAT:
                return Float.valueOf(zzb());
            case INT64:
                return Long.valueOf(zzl());
            case UINT64:
                return Long.valueOf(zzo());
            case INT32:
                return Integer.valueOf(zzg());
            case FIXED64:
                return Long.valueOf(zzk());
            case FIXED32:
                return Integer.valueOf(zzf());
            case BOOL:
                return Boolean.valueOf(zzQ());
            case STRING:
                return zzu();
            case GROUP:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case MESSAGE:
                return zzs(cls, zzbdvVar);
            case BYTES:
                return zzp();
            case UINT32:
                return Integer.valueOf(zzj());
            case ENUM:
                return Integer.valueOf(zze());
            case SFIXED32:
                return Integer.valueOf(zzh());
            case SFIXED64:
                return Long.valueOf(zzm());
            case SINT32:
                return Integer.valueOf(zzi());
            case SINT64:
                return Long.valueOf(zzn());
        }
    }

    private final Object zzT(zzbgm zzbgmVar, zzbdv zzbdvVar) throws IOException {
        Object objZze = zzbgmVar.zze();
        zzV(objZze, zzbgmVar, zzbdvVar);
        zzbgmVar.zzf(objZze);
        return objZze;
    }

    private final Object zzU(zzbgm zzbgmVar, zzbdv zzbdvVar) throws IOException {
        Object objZze = zzbgmVar.zze();
        zzW(objZze, zzbgmVar, zzbdvVar);
        zzbgmVar.zzf(objZze);
        return objZze;
    }

    private final void zzV(Object obj, zzbgm zzbgmVar, zzbdv zzbdvVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzbgmVar.zzh(obj, this, zzbdvVar);
            if (this.zzb == this.zzc) {
            } else {
                throw new zzbew("Failed to parse the message.");
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzW(Object obj, zzbgm zzbgmVar, zzbdv zzbdvVar) throws IOException {
        zzbdj zzbdjVar = this.zza;
        int iZzn = zzbdjVar.zzn();
        if (zzbdjVar.zza >= zzbdjVar.zzb) {
            throw new zzbew("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iZze = zzbdjVar.zze(iZzn);
        this.zza.zza++;
        zzbgmVar.zzh(obj, this, zzbdvVar);
        this.zza.zzz(0);
        r4.zza--;
        this.zza.zzA(iZze);
    }

    private final void zzX(int i) throws IOException {
        if (this.zza.zzd() != i) {
            throw new zzbew("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final void zzY(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zzbev("Protocol message tag had invalid wire type.");
        }
    }

    private static final void zzZ(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zzbew("Failed to parse the message.");
        }
    }

    private static final void zzaa(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zzbew("Failed to parse the message.");
        }
    }

    public static zzbdk zzq(zzbdj zzbdjVar) {
        zzbdk zzbdkVar = zzbdjVar.zzc;
        return zzbdkVar != null ? zzbdkVar : new zzbdk(zzbdjVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzA(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar = this.zza;
                int iZzd = zzbdjVar.zzd() + zzbdjVar.zzn();
                do {
                    zzbemVar.zzg(this.zza.zzf());
                } while (this.zza.zzd() < iZzd);
                zzX(iZzd);
                return;
            }
            do {
                zzbemVar.zzg(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar2 = this.zza;
                int iZzd2 = zzbdjVar2.zzd() + zzbdjVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < iZzd2);
                zzX(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzB(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzn = this.zza.zzn();
                zzZ(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzbemVar.zzg(this.zza.zzg());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i != 5) {
                throw new zzbev("Protocol message tag had invalid wire type.");
            }
            do {
                zzbemVar.zzg(this.zza.zzg());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZzn2 = this.zza.zzn();
                zzZ(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            if (i2 != 5) {
                throw new zzbev("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzC(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbfg) {
            zzbfg zzbfgVar = (zzbfg) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                int iZzn = this.zza.zzn();
                zzaa(iZzn);
                int iZzd = iZzn + this.zza.zzd();
                do {
                    zzbfgVar.zzg(this.zza.zzo());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            do {
                zzbfgVar.zzg(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                int iZzn2 = this.zza.zzn();
                zzaa(iZzn2);
                int iZzd2 = iZzn2 + this.zza.zzd();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzD(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbec) {
            zzbec zzbecVar = (zzbec) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzn = this.zza.zzn();
                zzZ(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzbecVar.zzg(this.zza.zzc());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i != 5) {
                throw new zzbev("Protocol message tag had invalid wire type.");
            }
            do {
                zzbecVar.zzg(this.zza.zzc());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZzn2 = this.zza.zzn();
                zzZ(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            if (i2 != 5) {
                throw new zzbev("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    @Deprecated
    public final void zzE(List list, zzbgm zzbgmVar, zzbdv zzbdvVar) throws IOException {
        int iZzm;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw new zzbev("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzT(zzbgmVar, zzbdvVar));
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == i);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzF(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar = this.zza;
                int iZzd = zzbdjVar.zzd() + zzbdjVar.zzn();
                do {
                    zzbemVar.zzg(this.zza.zzh());
                } while (this.zza.zzd() < iZzd);
                zzX(iZzd);
                return;
            }
            do {
                zzbemVar.zzg(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar2 = this.zza;
                int iZzd2 = zzbdjVar2.zzd() + zzbdjVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < iZzd2);
                zzX(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzG(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbfg) {
            zzbfg zzbfgVar = (zzbfg) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar = this.zza;
                int iZzd = zzbdjVar.zzd() + zzbdjVar.zzn();
                do {
                    zzbfgVar.zzg(this.zza.zzp());
                } while (this.zza.zzd() < iZzd);
                zzX(iZzd);
                return;
            }
            do {
                zzbfgVar.zzg(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar2 = this.zza;
                int iZzd2 = zzbdjVar2.zzd() + zzbdjVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < iZzd2);
                zzX(iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        r8.put(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        return;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzH(Map map, zzbfk zzbfkVar, zzbdv zzbdvVar) throws IOException {
        zzY(2);
        zzbdj zzbdjVar = this.zza;
        int iZze = zzbdjVar.zze(zzbdjVar.zzn());
        Object objZzS = zzbfkVar.zzd;
        Object objZzS2 = zzbfkVar.zzb;
        while (true) {
            try {
                int iZzc = zzc();
                if (iZzc == Integer.MAX_VALUE || this.zza.zzC()) {
                    break;
                }
                if (iZzc == 1) {
                    objZzS2 = zzS(zzbfkVar.zza, null, null);
                } else if (iZzc != 2) {
                    try {
                        if (!zzR()) {
                            throw new zzbew("Unable to parse map entry.");
                        }
                    } catch (zzbev unused) {
                        if (!zzR()) {
                            throw new zzbew("Unable to parse map entry.");
                        }
                    }
                } else {
                    objZzS = zzS(zzbfkVar.zzc, zzbfkVar.zzd.getClass(), zzbdvVar);
                }
            } finally {
                this.zza.zzA(iZze);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzI(List list, zzbgm zzbgmVar, zzbdv zzbdvVar) throws IOException {
        int iZzm;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw new zzbev("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzU(zzbgmVar, zzbdvVar));
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == i);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzJ(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzn = this.zza.zzn();
                zzZ(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzbemVar.zzg(this.zza.zzk());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i != 5) {
                throw new zzbev("Protocol message tag had invalid wire type.");
            }
            do {
                zzbemVar.zzg(this.zza.zzk());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZzn2 = this.zza.zzn();
                zzZ(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            if (i2 != 5) {
                throw new zzbev("Protocol message tag had invalid wire type.");
            }
            do {
                list.add(Integer.valueOf(this.zza.zzk()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzK(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbfg) {
            zzbfg zzbfgVar = (zzbfg) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                int iZzn = this.zza.zzn();
                zzaa(iZzn);
                int iZzd = iZzn + this.zza.zzd();
                do {
                    zzbfgVar.zzg(this.zza.zzt());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            do {
                zzbfgVar.zzg(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                int iZzn2 = this.zza.zzn();
                zzaa(iZzn2);
                int iZzd2 = iZzn2 + this.zza.zzd();
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzt()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzL(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar = this.zza;
                int iZzd = zzbdjVar.zzd() + zzbdjVar.zzn();
                do {
                    zzbemVar.zzg(this.zza.zzl());
                } while (this.zza.zzd() < iZzd);
                zzX(iZzd);
                return;
            }
            do {
                zzbemVar.zzg(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar2 = this.zza;
                int iZzd2 = zzbdjVar2.zzd() + zzbdjVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < iZzd2);
                zzX(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzM(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbfg) {
            zzbfg zzbfgVar = (zzbfg) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar = this.zza;
                int iZzd = zzbdjVar.zzd() + zzbdjVar.zzn();
                do {
                    zzbfgVar.zzg(this.zza.zzu());
                } while (this.zza.zzd() < iZzd);
                zzX(iZzd);
                return;
            }
            do {
                zzbfgVar.zzg(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar2 = this.zza;
                int iZzd2 = zzbdjVar2.zzd() + zzbdjVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < iZzd2);
                zzX(iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    public final void zzN(List list, boolean z) throws IOException {
        int iZzm;
        int iZzm2;
        if ((this.zzb & 7) != 2) {
            throw new zzbev("Protocol message tag had invalid wire type.");
        }
        if ((list instanceof zzbfd) && !z) {
            zzbfd zzbfdVar = (zzbfd) list;
            do {
                zzp();
                zzbfdVar.zzb();
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            do {
                list.add(z ? zzu() : zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzO(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbem) {
            zzbem zzbemVar = (zzbem) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar = this.zza;
                int iZzd = zzbdjVar.zzd() + zzbdjVar.zzn();
                do {
                    zzbemVar.zzg(this.zza.zzn());
                } while (this.zza.zzd() < iZzd);
                zzX(iZzd);
                return;
            }
            do {
                zzbemVar.zzg(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar2 = this.zza;
                int iZzd2 = zzbdjVar2.zzd() + zzbdjVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < iZzd2);
                zzX(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzP(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbfg) {
            zzbfg zzbfgVar = (zzbfg) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar = this.zza;
                int iZzd = zzbdjVar.zzd() + zzbdjVar.zzn();
                do {
                    zzbfgVar.zzg(this.zza.zzv());
                } while (this.zza.zzd() < iZzd);
                zzX(iZzd);
                return;
            }
            do {
                zzbfgVar.zzg(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar2 = this.zza;
                int iZzd2 = zzbdjVar2.zzd() + zzbdjVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < iZzd2);
                zzX(iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzv()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final boolean zzQ() throws IOException {
        zzY(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final boolean zzR() throws IOException {
        int i;
        if (this.zza.zzC() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final double zza() throws IOException {
        zzY(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final float zzb() throws IOException {
        zzY(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final int zzc() throws IOException {
        int iZzm = this.zzd;
        if (iZzm != 0) {
            this.zzb = iZzm;
            this.zzd = 0;
        } else {
            iZzm = this.zza.zzm();
            this.zzb = iZzm;
        }
        if (iZzm == 0 || iZzm == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return iZzm >>> 3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final int zze() throws IOException {
        zzY(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final int zzf() throws IOException {
        zzY(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final int zzg() throws IOException {
        zzY(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final int zzh() throws IOException {
        zzY(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final int zzi() throws IOException {
        zzY(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final int zzj() throws IOException {
        zzY(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final long zzk() throws IOException {
        zzY(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final long zzl() throws IOException {
        zzY(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final long zzm() throws IOException {
        zzY(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final long zzn() throws IOException {
        zzY(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final long zzo() throws IOException {
        zzY(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final zzbdd zzp() throws IOException {
        zzY(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    @Deprecated
    public final Object zzr(Class cls, zzbdv zzbdvVar) throws IOException {
        zzY(3);
        return zzT(zzbgb.zza().zzb(cls), zzbdvVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final Object zzs(Class cls, zzbdv zzbdvVar) throws IOException {
        zzY(2);
        return zzU(zzbgb.zza().zzb(cls), zzbdvVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final String zzt() throws IOException {
        zzY(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final String zzu() throws IOException {
        zzY(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzv(Object obj, zzbgm zzbgmVar, zzbdv zzbdvVar) throws IOException {
        zzY(3);
        zzV(obj, zzbgmVar, zzbdvVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzw(Object obj, zzbgm zzbgmVar, zzbdv zzbdvVar) throws IOException {
        zzY(2);
        zzW(obj, zzbgmVar, zzbdvVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzx(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbct) {
            zzbct zzbctVar = (zzbct) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar = this.zza;
                int iZzd = zzbdjVar.zzd() + zzbdjVar.zzn();
                do {
                    zzbctVar.zze(this.zza.zzD());
                } while (this.zza.zzd() < iZzd);
                zzX(iZzd);
                return;
            }
            do {
                zzbctVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                zzbdj zzbdjVar2 = this.zza;
                int iZzd2 = zzbdjVar2.zzd() + zzbdjVar2.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < iZzd2);
                zzX(iZzd2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzy(List list) throws IOException {
        int iZzm;
        if ((this.zzb & 7) != 2) {
            throw new zzbev("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == this.zzb);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbge
    public final void zzz(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzbds) {
            zzbds zzbdsVar = (zzbds) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                int iZzn = this.zza.zzn();
                zzaa(iZzn);
                int iZzd = iZzn + this.zza.zzd();
                do {
                    zzbdsVar.zzf(this.zza.zzb());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            do {
                zzbdsVar.zzf(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzbev("Protocol message tag had invalid wire type.");
                }
                int iZzn2 = this.zza.zzn();
                zzaa(iZzn2);
                int iZzd2 = iZzn2 + this.zza.zzd();
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }
}
