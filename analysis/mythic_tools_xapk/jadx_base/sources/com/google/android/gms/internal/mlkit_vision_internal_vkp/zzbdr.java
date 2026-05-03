package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbdr implements zzbhs {
    private final zzbdq zza;

    private zzbdr(zzbdq zzbdqVar) {
        byte[] bArr = zzbeu.zzb;
        this.zza = zzbdqVar;
        zzbdqVar.zze = this;
    }

    public static zzbdr zza(zzbdq zzbdqVar) {
        zzbdr zzbdrVar = zzbdqVar.zze;
        return zzbdrVar != null ? zzbdrVar : new zzbdr(zzbdqVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzA(int i, long j) throws IOException {
        this.zza.zzl(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbfg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzx(i3);
            while (i2 < list.size()) {
                this.zza.zzm(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        if (!z) {
            while (i2 < zzbfgVar.size()) {
                this.zza.zzl(i, zzbfgVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzbfgVar.size(); i6++) {
            zzbfgVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzx(i5);
        while (i2 < zzbfgVar.size()) {
            this.zza.zzm(zzbfgVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzC(int i, int i2) throws IOException {
        zzbdq zzbdqVar = this.zza;
        zzbdqVar.zzw(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbem)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzbdq zzbdqVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzbdqVar.zzw(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int iZzF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzF += zzbdq.zzF((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzx(iZzF);
            while (i2 < list.size()) {
                zzbdq zzbdqVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzbdqVar2.zzx((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z) {
            while (i2 < zzbemVar.size()) {
                zzbdq zzbdqVar3 = this.zza;
                int iZze = zzbemVar.zze(i2);
                zzbdqVar3.zzw(i, (iZze >> 31) ^ (iZze + iZze));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int iZzF2 = 0;
        for (int i4 = 0; i4 < zzbemVar.size(); i4++) {
            int iZze2 = zzbemVar.zze(i4);
            iZzF2 += zzbdq.zzF((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzx(iZzF2);
        while (i2 < zzbemVar.size()) {
            zzbdq zzbdqVar4 = this.zza;
            int iZze3 = zzbemVar.zze(i2);
            zzbdqVar4.zzx((iZze3 >> 31) ^ (iZze3 + iZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzE(int i, long j) throws IOException {
        zzbdq zzbdqVar = this.zza;
        zzbdqVar.zzy(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzF(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbfg)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzbdq zzbdqVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzbdqVar.zzy(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzG += zzbdq.zzG((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzx(iZzG);
            while (i2 < list.size()) {
                zzbdq zzbdqVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzbdqVar2.zzz((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        if (!z) {
            while (i2 < zzbfgVar.size()) {
                zzbdq zzbdqVar3 = this.zza;
                long jZze = zzbfgVar.zze(i2);
                zzbdqVar3.zzy(i, (jZze >> 63) ^ (jZze + jZze));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zzbfgVar.size(); i4++) {
            long jZze2 = zzbfgVar.zze(i4);
            iZzG2 += zzbdq.zzG((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzx(iZzG2);
        while (i2 < zzbfgVar.size()) {
            zzbdq zzbdqVar4 = this.zza;
            long jZze3 = zzbfgVar.zze(i2);
            zzbdqVar4.zzz((jZze3 >> 63) ^ (jZze3 + jZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    @Deprecated
    public final void zzG(int i) throws IOException {
        this.zza.zzv(i, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzH(int i, String str) throws IOException {
        this.zza.zzt(i, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzI(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbfd)) {
            while (i2 < list.size()) {
                this.zza.zzt(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzbfd zzbfdVar = (zzbfd) list;
        while (i2 < list.size()) {
            Object objZzc = zzbfdVar.zzc();
            boolean z = objZzc instanceof String;
            zzbdq zzbdqVar = this.zza;
            if (z) {
                zzbdqVar.zzt(i, (String) objZzc);
            } else {
                zzbdqVar.zzh(i, (zzbdd) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzJ(int i, int i2) throws IOException {
        this.zza.zzw(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbem)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzw(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int iZzF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzF += zzbdq.zzF(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzx(iZzF);
            while (i2 < list.size()) {
                this.zza.zzx(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z) {
            while (i2 < zzbemVar.size()) {
                this.zza.zzw(i, zzbemVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int iZzF2 = 0;
        for (int i4 = 0; i4 < zzbemVar.size(); i4++) {
            iZzF2 += zzbdq.zzF(zzbemVar.zze(i4));
        }
        this.zza.zzx(iZzF2);
        while (i2 < zzbemVar.size()) {
            this.zza.zzx(zzbemVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzL(int i, long j) throws IOException {
        this.zza.zzy(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzM(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbfg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzy(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzG += zzbdq.zzG(((Long) list.get(i3)).longValue());
            }
            this.zza.zzx(iZzG);
            while (i2 < list.size()) {
                this.zza.zzz(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        if (!z) {
            while (i2 < zzbfgVar.size()) {
                this.zza.zzy(i, zzbfgVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zzbfgVar.size(); i4++) {
            iZzG2 += zzbdq.zzG(zzbfgVar.zze(i4));
        }
        this.zza.zzx(iZzG2);
        while (i2 < zzbfgVar.size()) {
            this.zza.zzz(zzbfgVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzO(i, z);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbct)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzO(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            this.zza.zzx(i3);
            while (i2 < list.size()) {
                this.zza.zzN(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzbct zzbctVar = (zzbct) list;
        if (!z) {
            while (i2 < zzbctVar.size()) {
                this.zza.zzO(i, zzbctVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzbctVar.size(); i6++) {
            zzbctVar.zzf(i6);
            i5++;
        }
        this.zza.zzx(i5);
        while (i2 < zzbctVar.size()) {
            this.zza.zzN(zzbctVar.zzf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzd(int i, zzbdd zzbddVar) throws IOException {
        this.zza.zzh(i, zzbddVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzh(i, (zzbdd) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzl(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbds)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            this.zza.zzx(i3);
            while (i2 < list.size()) {
                this.zza.zzm(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzbds zzbdsVar = (zzbds) list;
        if (!z) {
            while (i2 < zzbdsVar.size()) {
                this.zza.zzl(i, Double.doubleToRawLongBits(zzbdsVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzbdsVar.size(); i6++) {
            zzbdsVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzx(i5);
        while (i2 < zzbdsVar.size()) {
            this.zza.zzm(Double.doubleToRawLongBits(zzbdsVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzv(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzn(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbem)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzn(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzG += zzbdq.zzG(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzx(iZzG);
            while (i2 < list.size()) {
                this.zza.zzo(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z) {
            while (i2 < zzbemVar.size()) {
                this.zza.zzn(i, zzbemVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zzbemVar.size(); i4++) {
            iZzG2 += zzbdq.zzG(zzbemVar.zze(i4));
        }
        this.zza.zzx(iZzG2);
        while (i2 < zzbemVar.size()) {
            this.zza.zzo(zzbemVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbem)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzx(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z) {
            while (i2 < zzbemVar.size()) {
                this.zza.zzj(i, zzbemVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzbemVar.size(); i6++) {
            zzbemVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzx(i5);
        while (i2 < zzbemVar.size()) {
            this.zza.zzk(zzbemVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzl(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbfg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzx(i3);
            while (i2 < list.size()) {
                this.zza.zzm(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        if (!z) {
            while (i2 < zzbfgVar.size()) {
                this.zza.zzl(i, zzbfgVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzbfgVar.size(); i6++) {
            zzbfgVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzx(i5);
        while (i2 < zzbfgVar.size()) {
            this.zza.zzm(zzbfgVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzj(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbec)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            this.zza.zzx(i3);
            while (i2 < list.size()) {
                this.zza.zzk(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzbec zzbecVar = (zzbec) list;
        if (!z) {
            while (i2 < zzbecVar.size()) {
                this.zza.zzj(i, Float.floatToRawIntBits(zzbecVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzbecVar.size(); i6++) {
            zzbecVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzx(i5);
        while (i2 < zzbecVar.size()) {
            this.zza.zzk(Float.floatToRawIntBits(zzbecVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzq(int i, Object obj, zzbgm zzbgmVar) throws IOException {
        zzbdq zzbdqVar = this.zza;
        zzbdqVar.zzv(i, 3);
        zzbgmVar.zzj((zzbfs) obj, zzbdqVar.zze);
        zzbdqVar.zzv(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzn(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbem)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzn(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzG += zzbdq.zzG(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzx(iZzG);
            while (i2 < list.size()) {
                this.zza.zzo(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z) {
            while (i2 < zzbemVar.size()) {
                this.zza.zzn(i, zzbemVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zzbemVar.size(); i4++) {
            iZzG2 += zzbdq.zzG(zzbemVar.zze(i4));
        }
        this.zza.zzx(iZzG2);
        while (i2 < zzbemVar.size()) {
            this.zza.zzo(zzbemVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzy(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbfg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzy(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int iZzG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzG += zzbdq.zzG(((Long) list.get(i3)).longValue());
            }
            this.zza.zzx(iZzG);
            while (i2 < list.size()) {
                this.zza.zzz(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        if (!z) {
            while (i2 < zzbfgVar.size()) {
                this.zza.zzy(i, zzbfgVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int iZzG2 = 0;
        for (int i4 = 0; i4 < zzbfgVar.size(); i4++) {
            iZzG2 += zzbdq.zzG(zzbfgVar.zze(i4));
        }
        this.zza.zzx(iZzG2);
        while (i2 < zzbfgVar.size()) {
            this.zza.zzz(zzbfgVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzv(int i, zzbfk zzbfkVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            this.zza.zzv(i, 2);
            this.zza.zzx(zzbfl.zzb(zzbfkVar, entry.getKey(), entry.getValue()));
            zzbfl.zze(this.zza, zzbfkVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzw(int i, Object obj, zzbgm zzbgmVar) throws IOException {
        this.zza.zzp(i, (zzbfs) obj, zzbgmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzx(int i, Object obj) throws IOException {
        boolean z = obj instanceof zzbdd;
        zzbdq zzbdqVar = this.zza;
        if (z) {
            zzbdqVar.zzs(i, (zzbdd) obj);
        } else {
            zzbdqVar.zzr(i, (zzbfs) obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzy(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhs
    public final void zzz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbem)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzv(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzx(i3);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzbem zzbemVar = (zzbem) list;
        if (!z) {
            while (i2 < zzbemVar.size()) {
                this.zza.zzj(i, zzbemVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzv(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzbemVar.size(); i6++) {
            zzbemVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzx(i5);
        while (i2 < zzbemVar.size()) {
            this.zza.zzk(zzbemVar.zze(i2));
            i2++;
        }
    }
}
