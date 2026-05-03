package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbdq extends zzbcu {
    private static final Logger zza = Logger.getLogger(zzbdq.class.getName());
    private static final boolean zzb = zzbhk.zzx();
    public static final /* synthetic */ int zzf = 0;
    zzbdr zze;

    private zzbdq() {
        throw null;
    }

    /* synthetic */ zzbdq(zzbdp zzbdpVar) {
    }

    @Deprecated
    static int zzB(int i, zzbfs zzbfsVar, zzbgm zzbgmVar) {
        int iZzF = zzF(i << 3);
        return iZzF + iZzF + ((zzbck) zzbfsVar).zzs(zzbgmVar);
    }

    public static int zzC(zzbfs zzbfsVar) {
        int iZzz = zzbfsVar.zzz();
        return zzF(iZzz) + iZzz;
    }

    static int zzD(zzbfs zzbfsVar, zzbgm zzbgmVar) {
        int iZzs = ((zzbck) zzbfsVar).zzs(zzbgmVar);
        return zzF(iZzs) + iZzs;
    }

    public static int zzE(String str) {
        int length;
        try {
            length = zzbhp.zzc(str);
        } catch (zzbho unused) {
            length = str.getBytes(zzbeu.zza).length;
        }
        return zzF(length) + length;
    }

    public static int zzF(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzG(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public final void zzH() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zzI(String str, zzbho zzbhoVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzbhoVar);
        byte[] bytes = str.getBytes(zzbeu.zza);
        try {
            int length = bytes.length;
            zzx(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzbdn(e);
        }
    }

    public abstract void zzM() throws IOException;

    public abstract void zzN(byte b) throws IOException;

    public abstract void zzO(int i, boolean z) throws IOException;

    abstract void zzP(byte[] bArr, int i, int i2) throws IOException;

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcu
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, zzbdd zzbddVar) throws IOException;

    public abstract void zzi(zzbdd zzbddVar) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(int i, long j) throws IOException;

    public abstract void zzm(long j) throws IOException;

    public abstract void zzn(int i, int i2) throws IOException;

    public abstract void zzo(int i) throws IOException;

    abstract void zzp(int i, zzbfs zzbfsVar, zzbgm zzbgmVar) throws IOException;

    public abstract void zzq(zzbfs zzbfsVar) throws IOException;

    public abstract void zzr(int i, zzbfs zzbfsVar) throws IOException;

    public abstract void zzs(int i, zzbdd zzbddVar) throws IOException;

    public abstract void zzt(int i, String str) throws IOException;

    public abstract void zzu(String str) throws IOException;

    public abstract void zzv(int i, int i2) throws IOException;

    public abstract void zzw(int i, int i2) throws IOException;

    public abstract void zzx(int i) throws IOException;

    public abstract void zzy(int i, long j) throws IOException;

    public abstract void zzz(long j) throws IOException;
}
