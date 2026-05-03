package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzbo implements Iterator {
    final Iterator zza;

    zzbo(Iterator it) {
        it.getClass();
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return zza(this.zza.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
    }

    abstract Object zza(Object obj);
}
