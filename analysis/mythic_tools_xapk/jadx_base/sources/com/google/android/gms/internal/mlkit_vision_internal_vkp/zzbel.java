package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbef;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbel<MessageType extends zzbel<MessageType, BuilderType>, BuilderType extends zzbef<MessageType, BuilderType>> extends zzbck<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzbhe zzc = zzbhe.zzc();

    public static zzbej zzD(zzbfs zzbfsVar, Object obj, zzbfs zzbfsVar2, zzbeo zzbeoVar, int i, zzbhq zzbhqVar, Class cls) {
        return new zzbej(zzbfsVar, obj, zzbfsVar2, new zzbei(null, 32149011, zzbhqVar, false, false), cls);
    }

    static zzbel zzE(Class cls) {
        Map map = zzb;
        zzbel zzbelVar = (zzbel) map.get(cls);
        if (zzbelVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzbelVar = (zzbel) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzbelVar != null) {
            return zzbelVar;
        }
        zzbel zzbelVar2 = (zzbel) ((zzbel) zzbhk.zze(cls)).zzb(6, null, null);
        if (zzbelVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzbelVar2);
        return zzbelVar2;
    }

    protected static zzbel zzG(zzbel zzbelVar, InputStream inputStream, zzbdv zzbdvVar) throws zzbew {
        zzbdj zzbdhVar;
        int i = zzbdj.zzd;
        if (inputStream == null) {
            byte[] bArr = zzbeu.zzb;
            int length = bArr.length;
            zzbdhVar = zzbdj.zzH(bArr, 0, 0, false);
        } else {
            zzbdhVar = new zzbdh(inputStream, 4096, null);
        }
        zzbel zzbelVarZzF = zzbelVar.zzF();
        try {
            zzbgm zzbgmVarZzb = zzbgb.zza().zzb(zzbelVarZzF.getClass());
            zzbgmVarZzb.zzh(zzbelVarZzF, zzbdk.zzq(zzbdhVar), zzbdvVar);
            zzbgmVarZzb.zzf(zzbelVarZzF);
            zze(zzbelVarZzF);
            return zzbelVarZzF;
        } catch (zzbew e) {
            if (e.zzb()) {
                throw new zzbew(e);
            }
            throw e;
        } catch (zzbhc e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzbew) {
                throw ((zzbew) e3.getCause());
            }
            throw new zzbew(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzbew) {
                throw ((zzbew) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzbel zzH(zzbel zzbelVar, byte[] bArr, zzbdv zzbdvVar) throws zzbew {
        zzbel zzbelVarZzf = zzf(zzbelVar, bArr, 0, bArr.length, zzbdvVar);
        zze(zzbelVarZzf);
        return zzbelVarZzf;
    }

    protected static zzbeq zzI() {
        return zzbec.zzf();
    }

    protected static zzber zzJ() {
        return zzbem.zzf();
    }

    protected static zzbes zzK() {
        return zzbfg.zzf();
    }

    protected static zzbet zzL() {
        return zzbgc.zze();
    }

    protected static zzbet zzM(zzbet zzbetVar) {
        int size = zzbetVar.size();
        return zzbetVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzN(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzO(zzbfs zzbfsVar, String str, Object[] objArr) {
        return new zzbgd(zzbfsVar, str, objArr);
    }

    protected static void zzR(Class cls, zzbel zzbelVar) {
        zzbelVar.zzQ();
        zzb.put(cls, zzbelVar);
    }

    protected static final boolean zzT(zzbel zzbelVar, boolean z) {
        byte bByteValue = ((Byte) zzbelVar.zzb(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzbgb.zza().zzb(zzbelVar.getClass()).zzl(zzbelVar);
        if (z) {
            zzbelVar.zzb(2, true != zZzl ? null : zzbelVar, null);
        }
        return zZzl;
    }

    private final int zzc(zzbgm zzbgmVar) {
        return zzbgb.zza().zzb(getClass()).zza(this);
    }

    private static zzbel zze(zzbel zzbelVar) throws zzbew {
        if (zzbelVar == null || zzT(zzbelVar, true)) {
            return zzbelVar;
        }
        throw new zzbhc(zzbelVar).zza();
    }

    private static zzbel zzf(zzbel zzbelVar, byte[] bArr, int i, int i2, zzbdv zzbdvVar) throws zzbew {
        if (i2 == 0) {
            return zzbelVar;
        }
        zzbel zzbelVarZzF = zzbelVar.zzF();
        try {
            zzbgm zzbgmVarZzb = zzbgb.zza().zzb(zzbelVarZzF.getClass());
            zzbgmVarZzb.zzi(zzbelVarZzF, bArr, 0, i2, new zzbcr(zzbdvVar));
            zzbgmVarZzb.zzf(zzbelVarZzF);
            return zzbelVarZzF;
        } catch (zzbew e) {
            if (e.zzb()) {
                throw new zzbew(e);
            }
            throw e;
        } catch (zzbhc e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzbew) {
                throw ((zzbew) e3.getCause());
            }
            throw new zzbew(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzbew("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzbgb.zza().zzb(getClass()).zzk(this, (zzbel) obj);
    }

    public final int hashCode() {
        if (zzU()) {
            return zzy();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzy = zzy();
        this.zza = iZzy;
        return iZzy;
    }

    public final String toString() {
        return zzbfu.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft
    public final boolean zzA() {
        return zzT(this, true);
    }

    protected final zzbef zzB() {
        return (zzbef) zzb(5, null, null);
    }

    public final zzbef zzC() {
        zzbef zzbefVar = (zzbef) zzb(5, null, null);
        zzbefVar.zzs(this);
        return zzbefVar;
    }

    final zzbel zzF() {
        return (zzbel) zzb(4, null, null);
    }

    protected final void zzP() {
        zzbgb.zza().zzb(getClass()).zzf(this);
        zzQ();
    }

    final void zzQ() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzS(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    final boolean zzU() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfs
    public final /* synthetic */ zzbfr zzV() {
        return (zzbef) zzb(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfs
    public final /* synthetic */ zzbfr zzW() {
        zzbef zzbefVar = (zzbef) zzb(5, null, null);
        zzbefVar.zzs(this);
        return zzbefVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfs
    public final void zzX(zzbdq zzbdqVar) throws IOException {
        zzbgb.zza().zzb(getClass()).zzj(this, zzbdr.zza(zzbdqVar));
    }

    protected abstract Object zzb(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbck
    final int zzs(zzbgm zzbgmVar) {
        if (zzU()) {
            int iZza = zzbgmVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzbgmVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft
    public final /* synthetic */ zzbfs zzx() {
        return (zzbel) zzb(6, null, null);
    }

    final int zzy() {
        return zzbgb.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfs
    public final int zzz() {
        if (zzU()) {
            int iZzc = zzc(null);
            if (iZzc >= 0) {
                return iZzc;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzc);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZzc2 = zzc(null);
        if (iZzc2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzc2;
            return iZzc2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZzc2);
    }
}
