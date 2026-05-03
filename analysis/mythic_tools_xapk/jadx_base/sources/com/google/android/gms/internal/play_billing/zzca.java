package com.google.android.gms.internal.play_billing;

import java.util.Set;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzca extends zzbt implements Set {
    private transient zzbw zza;

    zzca() {
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
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
    public final int hashCode() {
        return zzcj.zza(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    public zzbw zzd() {
        zzbw zzbwVar = this.zza;
        if (zzbwVar != null) {
            return zzbwVar;
        }
        zzbw zzbwVarZzh = zzh();
        this.zza = zzbwVarZzh;
        return zzbwVarZzh;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze */
    public abstract zzck iterator();

    zzbw zzh() {
        Object[] array = toArray();
        int i = zzbw.zzd;
        return zzbw.zzi(array, array.length);
    }
}
