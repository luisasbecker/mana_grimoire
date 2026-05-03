package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzk implements Iterator {

    @CheckForNull
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzl zzc;

    zzk(zzl zzlVar, Iterator it) {
        this.zzb = it;
        this.zzc = zzlVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzd.zze(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        this.zzc.zza.zzb -= collection.size();
        collection.clear();
        this.zza = null;
    }
}
