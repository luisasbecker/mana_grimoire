package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzld extends zzkv implements Set {

    @CheckForNull
    private transient zzkz zza;

    zzld() {
    }

    static int zzf(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzld zzj() {
        return zzlm.zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzld zzl(int i, Object... objArr) {
        if (i == 0) {
            return zzlm.zza;
        }
        if (i == 1) {
            return new zzlo(Objects.requireNonNull(objArr[0]));
        }
        int iZzf = zzf(i);
        Object[] objArr2 = new Object[iZzf];
        int i2 = iZzf - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzlf.zza(obj, i5);
            int iHashCode = obj.hashCode();
            int iZza = zzks.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (!obj2.equals(obj)) {
                    iZza++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzlo(Objects.requireNonNull(objArr[0]));
        }
        if (zzf(i4) < iZzf / 2) {
            return zzl(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzlm(objArr, i3, objArr2, i2, i4);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzld) && zzk() && ((zzld) obj).zzk() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzln.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzlp iterator();

    public final zzkz zzg() {
        zzkz zzkzVar = this.zza;
        if (zzkzVar != null) {
            return zzkzVar;
        }
        zzkz zzkzVarZzh = zzh();
        this.zza = zzkzVarZzh;
        return zzkzVarZzh;
    }

    zzkz zzh() {
        Object[] array = toArray();
        int i = zzkz.zzd;
        return zzkz.zzg(array, array.length);
    }

    boolean zzk() {
        return false;
    }
}
