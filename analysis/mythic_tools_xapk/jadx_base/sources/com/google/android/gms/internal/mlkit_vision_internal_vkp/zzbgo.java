package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbgo {
    public static final /* synthetic */ int zza = 0;
    private static final zzbhd zzb;

    static {
        int i = zzbgb.zza;
        zzb = new zzbhf();
    }

    public static void zzA(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzB(i, list, z);
    }

    public static void zzB(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzD(i, list, z);
    }

    public static void zzC(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzF(i, list, z);
    }

    public static void zzD(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzK(i, list, z);
    }

    public static void zzE(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzM(i, list, z);
    }

    static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbem)) {
            int iZzG = 0;
            while (i < size) {
                iZzG += zzbdq.zzG(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzG;
        }
        zzbem zzbemVar = (zzbem) list;
        int iZzG2 = 0;
        while (i < size) {
            iZzG2 += zzbdq.zzG(zzbemVar.zze(i));
            i++;
        }
        return iZzG2;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbdq.zzF(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbdq.zzF(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbem)) {
            int iZzG = 0;
            while (i < size) {
                iZzG += zzbdq.zzG(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzG;
        }
        zzbem zzbemVar = (zzbem) list;
        int iZzG2 = 0;
        while (i < size) {
            iZzG2 += zzbdq.zzG(zzbemVar.zze(i));
            i++;
        }
        return iZzG2;
    }

    static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbfg)) {
            int iZzG = 0;
            while (i < size) {
                iZzG += zzbdq.zzG(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzG;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int iZzG2 = 0;
        while (i < size) {
            iZzG2 += zzbdq.zzG(zzbfgVar.zze(i));
            i++;
        }
        return iZzG2;
    }

    static int zzh(int i, Object obj, zzbgm zzbgmVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzbfc)) {
            return zzbdq.zzF(i2) + zzbdq.zzD((zzbfs) obj, zzbgmVar);
        }
        int iZzF = zzbdq.zzF(i2);
        int iZza = ((zzbfc) obj).zza();
        return iZzF + zzbdq.zzF(iZza) + iZza;
    }

    static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbem)) {
            int iZzF = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzF += zzbdq.zzF((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzF;
        }
        zzbem zzbemVar = (zzbem) list;
        int iZzF2 = 0;
        while (i < size) {
            int iZze = zzbemVar.zze(i);
            iZzF2 += zzbdq.zzF((iZze >> 31) ^ (iZze + iZze));
            i++;
        }
        return iZzF2;
    }

    static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbfg)) {
            int iZzG = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzG += zzbdq.zzG((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzG;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int iZzG2 = 0;
        while (i < size) {
            long jZze = zzbfgVar.zze(i);
            iZzG2 += zzbdq.zzG((jZze >> 63) ^ (jZze + jZze));
            i++;
        }
        return iZzG2;
    }

    static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbem)) {
            int iZzF = 0;
            while (i < size) {
                iZzF += zzbdq.zzF(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzF;
        }
        zzbem zzbemVar = (zzbem) list;
        int iZzF2 = 0;
        while (i < size) {
            iZzF2 += zzbdq.zzF(zzbemVar.zze(i));
            i++;
        }
        return iZzF2;
    }

    static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzbfg)) {
            int iZzG = 0;
            while (i < size) {
                iZzG += zzbdq.zzG(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzG;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int iZzG2 = 0;
        while (i < size) {
            iZzG2 += zzbdq.zzG(zzbfgVar.zze(i));
            i++;
        }
        return iZzG2;
    }

    public static zzbhd zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, List list, zzbep zzbepVar, Object obj2, zzbhd zzbhdVar) {
        if (zzbepVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzbepVar.zza(iIntValue)) {
                    obj2 = zzo(obj, i, iIntValue, obj2, zzbhdVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            if (zzbepVar.zza(iIntValue2)) {
                if (i3 != i2) {
                    list.set(i2, Integer.valueOf(iIntValue2));
                }
                i2++;
            } else {
                obj2 = zzo(obj, i, iIntValue2, obj2, zzbhdVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzbhd zzbhdVar) {
        if (obj2 == null) {
            obj2 = zzbhdVar.zza(obj);
        }
        zzbhdVar.zzh(obj2, i, i2);
        return obj2;
    }

    static void zzp(zzbdw zzbdwVar, Object obj, Object obj2) {
        zzbea zzbeaVar = ((zzbeh) obj2).zzb;
        if (zzbeaVar.zza.isEmpty()) {
            return;
        }
        ((zzbeh) obj).zzn().zzi(zzbeaVar);
    }

    static void zzq(zzbhd zzbhdVar, Object obj, Object obj2) {
        zzbel zzbelVar = (zzbel) obj;
        zzbhe zzbheVarZze = zzbelVar.zzc;
        zzbhe zzbheVar = ((zzbel) obj2).zzc;
        if (!zzbhe.zzc().equals(zzbheVar)) {
            if (zzbhe.zzc().equals(zzbheVarZze)) {
                zzbheVarZze = zzbhe.zze(zzbheVarZze, zzbheVar);
            } else {
                zzbheVarZze.zzd(zzbheVar);
            }
        }
        zzbelVar.zzc = zzbheVarZze;
    }

    public static void zzr(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzg(i, list, z);
    }

    public static void zzt(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzj(i, list, z);
    }

    public static void zzu(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzl(i, list, z);
    }

    public static void zzv(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzn(i, list, z);
    }

    public static void zzw(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzp(i, list, z);
    }

    public static void zzx(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzs(i, list, z);
    }

    public static void zzy(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzu(i, list, z);
    }

    public static void zzz(int i, List list, zzbhs zzbhsVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbhsVar.zzz(i, list, z);
    }
}
