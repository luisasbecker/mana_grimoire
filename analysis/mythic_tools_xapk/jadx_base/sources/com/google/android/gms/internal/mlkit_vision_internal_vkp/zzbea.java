package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbea {
    private static final zzbea zzb = new zzbea(true);
    final zzbgw zza = new zzbgp();
    private boolean zzc;
    private boolean zzd;

    private zzbea() {
    }

    private zzbea(boolean z) {
        zzh();
        zzh();
    }

    static int zza(zzbhq zzbhqVar, int i, Object obj) {
        int iZzd;
        int iZzF;
        int iZzF2 = zzbdq.zzF(i << 3);
        if (zzbhqVar == zzbhq.GROUP) {
            zzbeu.zzd((zzbfs) obj);
            iZzF2 += iZzF2;
        }
        zzbhr zzbhrVar = zzbhr.INT;
        int iZzG = 4;
        switch (zzbhqVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                iZzG = 8;
                return iZzF2 + iZzG;
            case FLOAT:
                ((Float) obj).floatValue();
                return iZzF2 + iZzG;
            case INT64:
                iZzG = zzbdq.zzG(((Long) obj).longValue());
                return iZzF2 + iZzG;
            case UINT64:
                iZzG = zzbdq.zzG(((Long) obj).longValue());
                return iZzF2 + iZzG;
            case INT32:
                iZzG = zzbdq.zzG(((Integer) obj).intValue());
                return iZzF2 + iZzG;
            case FIXED64:
                ((Long) obj).longValue();
                iZzG = 8;
                return iZzF2 + iZzG;
            case FIXED32:
                ((Integer) obj).intValue();
                return iZzF2 + iZzG;
            case BOOL:
                ((Boolean) obj).booleanValue();
                iZzG = 1;
                return iZzF2 + iZzG;
            case STRING:
                if (!(obj instanceof zzbdd)) {
                    iZzG = zzbdq.zzE((String) obj);
                    return iZzF2 + iZzG;
                }
                iZzd = ((zzbdd) obj).zzd();
                iZzF = zzbdq.zzF(iZzd);
                iZzG = iZzF + iZzd;
                return iZzF2 + iZzG;
            case GROUP:
                iZzG = ((zzbfs) obj).zzz();
                return iZzF2 + iZzG;
            case MESSAGE:
                if (!(obj instanceof zzbfb)) {
                    iZzG = zzbdq.zzC((zzbfs) obj);
                    return iZzF2 + iZzG;
                }
                iZzd = ((zzbfb) obj).zza();
                iZzF = zzbdq.zzF(iZzd);
                iZzG = iZzF + iZzd;
                return iZzF2 + iZzG;
            case BYTES:
                if (obj instanceof zzbdd) {
                    iZzd = ((zzbdd) obj).zzd();
                    iZzF = zzbdq.zzF(iZzd);
                } else {
                    iZzd = ((byte[]) obj).length;
                    iZzF = zzbdq.zzF(iZzd);
                }
                iZzG = iZzF + iZzd;
                return iZzF2 + iZzG;
            case UINT32:
                iZzG = zzbdq.zzF(((Integer) obj).intValue());
                return iZzF2 + iZzG;
            case ENUM:
                iZzG = obj instanceof zzben ? zzbdq.zzG(((zzben) obj).zza()) : zzbdq.zzG(((Integer) obj).intValue());
                return iZzF2 + iZzG;
            case SFIXED32:
                ((Integer) obj).intValue();
                return iZzF2 + iZzG;
            case SFIXED64:
                ((Long) obj).longValue();
                iZzG = 8;
                return iZzF2 + iZzG;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                iZzG = zzbdq.zzF((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iZzF2 + iZzG;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                iZzG = zzbdq.zzG((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iZzF2 + iZzG;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzbdz zzbdzVar, Object obj) {
        zzbhq zzbhqVarZzd = zzbdzVar.zzd();
        zzbdzVar.zza();
        zzbdzVar.zzg();
        return zza(zzbhqVarZzd, 32149011, obj);
    }

    public static zzbea zze() {
        return zzb;
    }

    static void zzk(zzbdq zzbdqVar, zzbhq zzbhqVar, int i, Object obj) throws IOException {
        if (zzbhqVar == zzbhq.GROUP) {
            zzbfs zzbfsVar = (zzbfs) obj;
            zzbeu.zzd(zzbfsVar);
            zzbdqVar.zzv(i, 3);
            zzbfsVar.zzX(zzbdqVar);
            zzbdqVar.zzv(i, 4);
            return;
        }
        zzbdqVar.zzv(i, zzbhqVar.zza());
        zzbhr zzbhrVar = zzbhr.INT;
        switch (zzbhqVar) {
            case DOUBLE:
                zzbdqVar.zzm(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case FLOAT:
                zzbdqVar.zzk(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case INT64:
                zzbdqVar.zzz(((Long) obj).longValue());
                break;
            case UINT64:
                zzbdqVar.zzz(((Long) obj).longValue());
                break;
            case INT32:
                zzbdqVar.zzo(((Integer) obj).intValue());
                break;
            case FIXED64:
                zzbdqVar.zzm(((Long) obj).longValue());
                break;
            case FIXED32:
                zzbdqVar.zzk(((Integer) obj).intValue());
                break;
            case BOOL:
                zzbdqVar.zzN(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case STRING:
                if (!(obj instanceof zzbdd)) {
                    zzbdqVar.zzu((String) obj);
                } else {
                    zzbdqVar.zzi((zzbdd) obj);
                }
                break;
            case GROUP:
                ((zzbfs) obj).zzX(zzbdqVar);
                break;
            case MESSAGE:
                zzbdqVar.zzq((zzbfs) obj);
                break;
            case BYTES:
                if (!(obj instanceof zzbdd)) {
                    byte[] bArr = (byte[]) obj;
                    zzbdqVar.zzP(bArr, 0, bArr.length);
                } else {
                    zzbdqVar.zzi((zzbdd) obj);
                }
                break;
            case UINT32:
                zzbdqVar.zzx(((Integer) obj).intValue());
                break;
            case ENUM:
                if (!(obj instanceof zzben)) {
                    zzbdqVar.zzo(((Integer) obj).intValue());
                } else {
                    zzbdqVar.zzo(((zzben) obj).zza());
                }
                break;
            case SFIXED32:
                zzbdqVar.zzk(((Integer) obj).intValue());
                break;
            case SFIXED64:
                zzbdqVar.zzm(((Long) obj).longValue());
                break;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                zzbdqVar.zzx((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                zzbdqVar.zzz((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    private static Object zzn(Object obj) {
        if (obj instanceof zzbfx) {
            return ((zzbfx) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzo(Map.Entry entry) {
        zzbdz zzbdzVar = (zzbdz) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzbfb;
        zzbdzVar.zzg();
        if (zzbdzVar.zze() != zzbhr.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(zzbdzVar, zzn(value));
            return;
        }
        Object objZzf = zzf(zzbdzVar);
        if (objZzf == null) {
            this.zza.put(zzbdzVar, zzn(value));
            if (z) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z) {
            throw null;
        }
        this.zza.put(zzbdzVar, objZzf instanceof zzbfx ? zzbdzVar.zzc((zzbfx) objZzf, (zzbfx) value) : zzbdzVar.zzb(((zzbfs) objZzf).zzW(), (zzbfs) value).zzv());
    }

    private static boolean zzp(Map.Entry entry) {
        zzbdz zzbdzVar = (zzbdz) entry.getKey();
        if (zzbdzVar.zze() != zzbhr.MESSAGE) {
            return true;
        }
        zzbdzVar.zzg();
        Object value = entry.getValue();
        if (value instanceof zzbft) {
            return ((zzbft) value).zzA();
        }
        if (value instanceof zzbfb) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzq(Map.Entry entry) {
        int i;
        int iZzF;
        int iZzF2;
        zzbdz zzbdzVar = (zzbdz) entry.getKey();
        Object value = entry.getValue();
        if (zzbdzVar.zze() != zzbhr.MESSAGE) {
            return zzb(zzbdzVar, value);
        }
        zzbdzVar.zzg();
        zzbdzVar.zzf();
        if (value instanceof zzbfb) {
            ((zzbdz) entry.getKey()).zza();
            int iZzF3 = zzbdq.zzF(8);
            i = iZzF3 + iZzF3;
            iZzF = zzbdq.zzF(16) + zzbdq.zzF(32149011);
            int iZzF4 = zzbdq.zzF(24);
            int iZza = ((zzbfb) value).zza();
            iZzF2 = iZzF4 + zzbdq.zzF(iZza) + iZza;
        } else {
            ((zzbdz) entry.getKey()).zza();
            int iZzF5 = zzbdq.zzF(8);
            i = iZzF5 + iZzF5;
            iZzF = zzbdq.zzF(16) + zzbdq.zzF(32149011);
            iZzF2 = zzbdq.zzF(24) + zzbdq.zzC((zzbfs) value);
        }
        return i + iZzF + iZzF2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbea) {
            return this.zza.equals(((zzbea) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        zzbgw zzbgwVar;
        int iZzc = this.zza.zzc();
        int i = 0;
        int iZzq = 0;
        while (true) {
            zzbgwVar = this.zza;
            if (i >= iZzc) {
                break;
            }
            iZzq += zzq(zzbgwVar.zzg(i));
            i++;
        }
        Iterator it = zzbgwVar.zzd().iterator();
        while (it.hasNext()) {
            iZzq += zzq((Map.Entry) it.next());
        }
        return iZzq;
    }

    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzbea clone() {
        zzbgw zzbgwVar;
        zzbea zzbeaVar = new zzbea();
        int iZzc = this.zza.zzc();
        int i = 0;
        while (true) {
            zzbgwVar = this.zza;
            if (i >= iZzc) {
                break;
            }
            Map.Entry entryZzg = zzbgwVar.zzg(i);
            zzbeaVar.zzj((zzbdz) ((zzbgq) entryZzg).zza(), entryZzg.getValue());
            i++;
        }
        for (Map.Entry entry : zzbgwVar.zzd()) {
            zzbeaVar.zzj((zzbdz) entry.getKey(), entry.getValue());
        }
        zzbeaVar.zzd = this.zzd;
        return zzbeaVar;
    }

    public final Object zzf(zzbdz zzbdzVar) {
        Object obj = this.zza.get(zzbdzVar);
        if (!(obj instanceof zzbfb)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzg() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        boolean z = this.zzd;
        zzbgw zzbgwVar = this.zza;
        return z ? new zzbfa(zzbgwVar.entrySet().iterator()) : zzbgwVar.entrySet().iterator();
    }

    public final void zzh() {
        if (this.zzc) {
            return;
        }
        int iZzc = this.zza.zzc();
        int i = 0;
        while (true) {
            zzbgw zzbgwVar = this.zza;
            if (i >= iZzc) {
                zzbgwVar.zza();
                this.zzc = true;
                return;
            } else {
                Map.Entry entryZzg = zzbgwVar.zzg(i);
                if (entryZzg.getValue() instanceof zzbel) {
                    ((zzbel) entryZzg.getValue()).zzP();
                }
                i++;
            }
        }
    }

    public final void zzi(zzbea zzbeaVar) {
        int iZzc = zzbeaVar.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            zzo(zzbeaVar.zza.zzg(i));
        }
        Iterator it = zzbeaVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzo((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_internal_vkp.zzben) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r0 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfb) == false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj(zzbdz zzbdzVar, Object obj) {
        boolean z;
        zzbdzVar.zzg();
        zzbdzVar.zzd();
        byte[] bArr = zzbeu.zzb;
        obj.getClass();
        zzbhq zzbhqVar = zzbhq.DOUBLE;
        zzbhr zzbhrVar = zzbhr.INT;
        switch (r0.zzb()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof zzbdd)) {
                    break;
                }
                if (obj instanceof zzbfb) {
                    this.zzd = true;
                }
                this.zza.put(zzbdzVar, obj);
                return;
            case ENUM:
                if (!(obj instanceof Integer)) {
                    break;
                }
                if (obj instanceof zzbfb) {
                }
                this.zza.put(zzbdzVar, obj);
                return;
            case MESSAGE:
                if (!(obj instanceof zzbfs)) {
                    break;
                }
                if (obj instanceof zzbfb) {
                }
                this.zza.put(zzbdzVar, obj);
                return;
            default:
                zzbdzVar.zza();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 32149011, zzbdzVar.zzd().zzb(), obj.getClass().getName()));
        }
    }

    public final boolean zzl() {
        return this.zzc;
    }

    public final boolean zzm() {
        int iZzc = this.zza.zzc();
        int i = 0;
        while (true) {
            zzbgw zzbgwVar = this.zza;
            if (i >= iZzc) {
                Iterator it = zzbgwVar.zzd().iterator();
                while (it.hasNext()) {
                    if (!zzp((Map.Entry) it.next())) {
                        return false;
                    }
                }
                return true;
            }
            if (!zzp(zzbgwVar.zzg(i))) {
                return false;
            }
            i++;
        }
    }
}
