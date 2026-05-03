package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaxv implements zzaxs {
    final List zza;

    public zzaxv(Context context, zzaxu zzaxuVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzaxuVar.zzc()) {
            arrayList.add(new zzayg(context, zzaxuVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxs
    public final void zza(zzaxr zzaxrVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzaxs) it.next()).zza(zzaxrVar);
        }
    }
}
