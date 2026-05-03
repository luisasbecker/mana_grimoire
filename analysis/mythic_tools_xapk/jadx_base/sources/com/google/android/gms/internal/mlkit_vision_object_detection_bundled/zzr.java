package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzr extends zzt implements Serializable {
    private transient Map zza;
    private transient int zzb;

    protected zzr(Map map) {
        if (!map.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.zza = map;
    }

    static /* bridge */ /* synthetic */ void zzk(zzr zzrVar, Object obj) {
        Object objRemove;
        Map map = zzrVar.zza;
        map.getClass();
        try {
            objRemove = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzrVar.zzb -= size;
        }
    }

    abstract Collection zza();

    Collection zzb(Object obj, Collection collection) {
        throw null;
    }

    public final Collection zze(Object obj) {
        Collection collectionZza = (Collection) this.zza.get(obj);
        if (collectionZza == null) {
            collectionZza = zza();
        }
        return zzb(obj, collectionZza);
    }

    final List zzf(Object obj, List list, @CheckForNull zzo zzoVar) {
        return list instanceof RandomAccess ? new zzm(this, obj, list, zzoVar) : new zzq(this, obj, list, zzoVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzt
    final Map zzh() {
        return new zzj(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzt
    final Set zzi() {
        return new zzl(this, this.zza);
    }

    public final void zzl() {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzt, com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzbe
    public final boolean zzm(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZza = zza();
        if (!collectionZza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        this.zza.put(obj, collectionZza);
        return true;
    }
}
