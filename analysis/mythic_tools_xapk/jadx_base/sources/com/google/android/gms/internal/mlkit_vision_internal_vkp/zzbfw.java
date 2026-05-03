package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbfw implements zzbgm {
    private final zzbfs zza;
    private final zzbhd zzb;
    private final boolean zzc;
    private final zzbdw zzd;

    private zzbfw(zzbhd zzbhdVar, zzbdw zzbdwVar, zzbfs zzbfsVar) {
        this.zzb = zzbhdVar;
        this.zzc = zzbfsVar instanceof zzbeh;
        this.zzd = zzbdwVar;
        this.zza = zzbfsVar;
    }

    static zzbfw zzc(zzbhd zzbhdVar, zzbdw zzbdwVar, zzbfs zzbfsVar) {
        return new zzbfw(zzbhdVar, zzbdwVar, zzbfsVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    public final int zza(Object obj) {
        int iZzb = ((zzbel) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzbeh) obj).zzb.zzc() : iZzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    public final int zzb(Object obj) {
        int iHashCode = ((zzbel) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzbeh) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    public final Object zze() {
        zzbfs zzbfsVar = this.zza;
        return zzbfsVar instanceof zzbel ? ((zzbel) zzbfsVar).zzF() : zzbfsVar.zzV().zzw();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    public final void zzg(Object obj, Object obj2) {
        zzbgo.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzbgo.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    public final void zzh(Object obj, zzbge zzbgeVar, zzbdv zzbdvVar) throws IOException {
        boolean zZzR;
        zzbhd zzbhdVar = this.zzb;
        Object objZza = zzbhdVar.zza(obj);
        zzbea zzbeaVarZzn = ((zzbeh) obj).zzn();
        while (zzbgeVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzbgeVar.zzd();
                zzbdw zzbdwVar = this.zzd;
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        zzbej zzbejVarZzc = zzbdvVar.zzc(this.zza, iZzd >>> 3);
                        if (zzbejVarZzc != null) {
                            zzbdwVar.zzb(zzbgeVar, zzbejVarZzc, zzbdvVar, zzbeaVarZzn);
                        } else {
                            zZzR = zzbhdVar.zzk(objZza, zzbgeVar, 0);
                        }
                    } else {
                        zZzR = zzbgeVar.zzR();
                    }
                    if (!zZzR) {
                        break;
                    }
                } else {
                    zzbej zzbejVarZzc2 = null;
                    zzbdd zzbddVarZzp = null;
                    int iZzj = 0;
                    while (zzbgeVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzbgeVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzbgeVar.zzj();
                            zzbejVarZzc2 = zzbdvVar.zzc(this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (zzbejVarZzc2 != null) {
                                zzbdwVar.zzb(zzbgeVar, zzbejVarZzc2, zzbdvVar, zzbeaVarZzn);
                            } else {
                                zzbddVarZzp = zzbgeVar.zzp();
                            }
                        } else if (!zzbgeVar.zzR()) {
                            break;
                        }
                    }
                    if (zzbgeVar.zzd() != 12) {
                        throw new zzbew("Protocol message end-group tag did not match expected tag.");
                    }
                    if (zzbddVarZzp != null) {
                        if (zzbejVarZzc2 != null) {
                            zzbej zzbejVar = zzbejVarZzc2;
                            zzbef zzbefVar = (zzbef) ((zzbel) zzbejVarZzc2.zza).zzb(5, null, null);
                            zzbdj zzbdjVarZzH = zzbdj.zzH(((zzbdc) zzbddVarZzp).zza, 0, ((zzbdc) zzbddVarZzp).zzd(), true);
                            zzbefVar.zzq(zzbdjVarZzH, zzbdvVar);
                            zzbeaVarZzn.zzj(zzbejVarZzc2.zzb, zzbefVar.zzw());
                            zzbdjVarZzH.zzz(0);
                        } else {
                            zzbhdVar.zzg(objZza, iZzj, zzbddVarZzp);
                        }
                    }
                }
            } finally {
                zzbhdVar.zzj(obj, objZza);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be A[EDGE_INSN: B:61:0x00be->B:33:0x00be BREAK  A[LOOP:1: B:17:0x0067->B:64:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzbcr zzbcrVar) throws IOException {
        int iZzj;
        zzbel zzbelVar = (zzbel) obj;
        zzbhe zzbheVarZzf = zzbelVar.zzc;
        if (zzbheVarZzf == zzbhe.zzc()) {
            zzbheVarZzf = zzbhe.zzf();
            zzbelVar.zzc = zzbheVarZzf;
        }
        zzbhe zzbheVar = zzbheVarZzf;
        zzbea zzbeaVarZzn = ((zzbeh) obj).zzn();
        zzbej zzbejVarZzc = null;
        while (i < i2) {
            int iZzj2 = zzbcs.zzj(bArr, i, zzbcrVar);
            int i3 = zzbcrVar.zza;
            if (i3 == 11) {
                int i4 = i2;
                zzbcr zzbcrVar2 = zzbcrVar;
                int i5 = 0;
                zzbdd zzbddVar = null;
                while (true) {
                    if (iZzj2 >= i4) {
                        iZzj = iZzj2;
                        break;
                    }
                    iZzj = zzbcs.zzj(bArr, iZzj2, zzbcrVar2);
                    int i6 = zzbcrVar2.zza;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3) {
                            if (zzbejVarZzc != null) {
                                iZzj2 = zzbcs.zzd(zzbgb.zza().zzb(zzbejVarZzc.zza.getClass()), bArr, iZzj, i4, zzbcrVar2);
                                zzbeaVarZzn.zzj(zzbejVarZzc.zzb, zzbcrVar2.zzc);
                            } else if (i8 == 2) {
                                iZzj2 = zzbcs.zza(bArr, iZzj, zzbcrVar2);
                                zzbddVar = (zzbdd) zzbcrVar2.zzc;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            iZzj2 = zzbcs.zzp(i6, bArr, iZzj, i4, zzbcrVar2);
                        }
                    } else if (i8 == 0) {
                        iZzj2 = zzbcs.zzj(bArr, iZzj, zzbcrVar2);
                        i5 = zzbcrVar2.zza;
                        zzbejVarZzc = zzbcrVar2.zzd.zzc(this.zza, i5);
                    } else if (i6 != 12) {
                    }
                }
                if (zzbddVar != null) {
                    zzbheVar.zzj((i5 << 3) | 2, zzbddVar);
                }
                i = iZzj;
                i2 = i4;
                zzbcrVar = zzbcrVar2;
            } else if ((i3 & 7) == 2) {
                zzbejVarZzc = zzbcrVar.zzd.zzc(this.zza, i3 >>> 3);
                if (zzbejVarZzc != null) {
                    i = zzbcs.zzd(zzbgb.zza().zzb(zzbejVarZzc.zza.getClass()), bArr, iZzj2, i2, zzbcrVar);
                    zzbeaVarZzn.zzj(zzbejVarZzc.zzb, zzbcrVar.zzc);
                } else {
                    i = zzbcs.zzi(i3, bArr, iZzj2, i2, zzbheVar, zzbcrVar);
                }
            } else {
                i = zzbcs.zzp(i3, bArr, iZzj2, i2, zzbcrVar);
            }
        }
        if (i != i2) {
            throw new zzbew("Failed to parse the message.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    public final void zzj(Object obj, zzbhs zzbhsVar) throws IOException {
        Iterator itZzg = ((zzbeh) obj).zzb.zzg();
        while (itZzg.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzg.next();
            zzbdz zzbdzVar = (zzbdz) entry.getKey();
            if (zzbdzVar.zze() != zzbhr.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzbdzVar.zzg();
            zzbdzVar.zzf();
            if (entry instanceof zzbez) {
                zzbdzVar.zza();
                zzbhsVar.zzx(32149011, ((zzbez) entry).zza().zzb());
            } else {
                zzbdzVar.zza();
                zzbhsVar.zzx(32149011, entry.getValue());
            }
        }
        ((zzbel) obj).zzc.zzk(zzbhsVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zzbel) obj).zzc.equals(((zzbel) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzbeh) obj).zzb.equals(((zzbeh) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgm
    public final boolean zzl(Object obj) {
        return ((zzbeh) obj).zzb.zzm();
    }
}
