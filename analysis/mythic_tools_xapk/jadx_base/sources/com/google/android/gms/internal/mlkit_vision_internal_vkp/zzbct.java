package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbct extends zzbcm implements RandomAccess, zzbet, zzbga {
    private boolean[] zza;
    private int zzb;

    static {
        new zzbct(new boolean[0], 0, false);
    }

    zzbct() {
        this(new boolean[10], 0, true);
    }

    private zzbct(boolean[] zArr, int i, boolean z) {
        super(z);
        this.zza = zArr;
        this.zzb = i;
    }

    private final String zzg(int i) {
        return "Index:" + i + ", Size:" + this.zzb;
    }

    private final void zzh(int i) {
        if (i < 0 || i >= this.zzb) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcm, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i < 0 || i > (i2 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
        int i3 = i + 1;
        boolean[] zArr = this.zza;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i3, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zza, i, zArr2, i3, this.zzb - i);
            this.zza = zArr2;
        }
        this.zza[i] = zBooleanValue;
        this.zzb++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzbeu.zzb;
        collection.getClass();
        if (!(collection instanceof zzbct)) {
            return super.addAll(collection);
        }
        zzbct zzbctVar = (zzbct) collection;
        int i = zzbctVar.zzb;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzb;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.zza;
        if (i3 > zArr.length) {
            this.zza = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(zzbctVar.zza, 0, this.zza, this.zzb, zzbctVar.zzb);
        this.zzb = i3;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbct)) {
            return super.equals(obj);
        }
        zzbct zzbctVar = (zzbct) obj;
        if (this.zzb != zzbctVar.zzb) {
            return false;
        }
        boolean[] zArr = zzbctVar.zza;
        for (int i = 0; i < this.zzb; i++) {
            if (this.zza[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Boolean.valueOf(this.zza[i]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZza = 1;
        for (int i = 0; i < this.zzb; i++) {
            iZza = (iZza * 31) + zzbeu.zza(this.zza[i]);
        }
        return iZza;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zza[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzh(i);
        boolean[] zArr = this.zza;
        boolean z = zArr[i];
        if (i < this.zzb - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.zzb--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zza;
        System.arraycopy(zArr, i2, zArr, i, this.zzb - i2);
        this.zzb -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzh(i);
        boolean[] zArr = this.zza;
        boolean z = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbet
    public final /* bridge */ /* synthetic */ zzbet zzd(int i) {
        if (i >= this.zzb) {
            return new zzbct(Arrays.copyOf(this.zza, i), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z) {
        zza();
        int i = this.zzb;
        boolean[] zArr = this.zza;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zza = zArr2;
        }
        boolean[] zArr3 = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean zzf(int i) {
        zzh(i);
        return this.zza[i];
    }
}
