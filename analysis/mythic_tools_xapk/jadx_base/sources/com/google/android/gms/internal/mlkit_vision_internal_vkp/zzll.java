package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzll extends zzlb {
    final transient Object[] zza;

    private zzll(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zza = objArr;
    }

    static zzll zzg(int i, Object[] objArr, zzla zzlaVar) {
        zzkr.zza(Objects.requireNonNull(objArr[0]), Objects.requireNonNull(objArr[1]));
        return new zzll(null, objArr, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzlb, java.util.Map
    @CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(@CheckForNull Object obj) {
        Object objRequireNonNull;
        if (obj == null) {
            objRequireNonNull = null;
        } else {
            Object[] objArr = this.zza;
            if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                objRequireNonNull = Objects.requireNonNull(objArr[1]);
            }
        }
        if (objRequireNonNull == null) {
            return null;
        }
        return objRequireNonNull;
    }

    @Override // java.util.Map
    public final int size() {
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzlb
    final zzkv zza() {
        return new zzlk(this.zza, 1, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzlb
    final zzld zzd() {
        return new zzli(this, this.zza, 0, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzlb
    final zzld zze() {
        return new zzlj(this, new zzlk(this.zza, 0, 1));
    }
}
