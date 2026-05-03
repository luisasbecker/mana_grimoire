package com.google.android.gms.internal.mlkit_vision_face;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzch extends zzbp {
    static final zzbp zza = new zzch(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzch(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    static zzch zzg(int i, Object[] objArr, zzbo zzboVar) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        zzau.zzb(obj, obj2);
        return new zzch(null, objArr, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbp, java.util.Map
    @CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(@CheckForNull Object obj) {
        Object obj2;
        Object[] objArr = this.zzb;
        int i = this.zzc;
        if (obj != null && i == 1) {
            Object obj3 = objArr[0];
            obj3.getClass();
            if (obj3.equals(obj)) {
                obj2 = objArr[1];
                obj2.getClass();
            } else {
                obj2 = null;
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbp
    final zzbi zza() {
        return new zzcg(this.zzb, 1, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbp
    final zzbq zzd() {
        return new zzce(this, this.zzb, 0, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbp
    final zzbq zze() {
        return new zzcf(this, new zzcg(this.zzb, 0, this.zzc));
    }
}
