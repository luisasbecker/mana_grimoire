package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbfa implements Iterator {
    private final Iterator zza;

    public zzbfa(Iterator it) {
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        return entry.getValue() instanceof zzbfb ? new zzbez(entry, null) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
    }
}
