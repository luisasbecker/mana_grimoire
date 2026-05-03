package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzau extends zzal implements Set {

    @CheckForNull
    private transient zzaq zza;

    zzau() {
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
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
        return zzbn.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzbp iterator();

    public final zzaq zzf() {
        zzaq zzaqVar = this.zza;
        if (zzaqVar != null) {
            return zzaqVar;
        }
        zzaq zzaqVarZzg = zzg();
        this.zza = zzaqVarZzg;
        return zzaqVarZzg;
    }

    zzaq zzg() {
        Object[] array = toArray();
        int i = zzaq.zzd;
        return zzaq.zzg(array, array.length);
    }
}
