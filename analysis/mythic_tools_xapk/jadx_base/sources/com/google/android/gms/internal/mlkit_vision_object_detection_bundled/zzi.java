package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzi implements Iterator {
    final Iterator zza;

    @CheckForNull
    Collection zzb;
    final /* synthetic */ zzj zzc;

    zzi(zzj zzjVar) {
        this.zzc = zzjVar;
        this.zza = zzjVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        Object key = entry.getKey();
        return new zzam(key, this.zzc.zzb.zzb(key, (Collection) entry.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzd.zze(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        this.zzc.zzb.zzb -= this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
