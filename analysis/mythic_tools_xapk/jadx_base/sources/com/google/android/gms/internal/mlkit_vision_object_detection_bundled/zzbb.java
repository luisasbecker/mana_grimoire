package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbb extends AbstractCollection {
    final Map zza;

    zzbb(Map map) {
        this.zza = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new zzay(this.zza.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map.Entry entry : this.zza.entrySet()) {
                if (zzc.zza(obj, entry.getValue())) {
                    this.zza.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        try {
            if (collection == null) {
                throw null;
            }
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry entry : this.zza.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.zza.keySet().removeAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        try {
            if (collection == null) {
                throw null;
            }
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry entry : this.zza.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.zza.keySet().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
