package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaek extends zzael implements Iterable {
    private final ArrayList zza = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzaek) && ((zzaek) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final void zza(zzael zzaelVar) {
        this.zza.add(zzaelVar);
    }
}
