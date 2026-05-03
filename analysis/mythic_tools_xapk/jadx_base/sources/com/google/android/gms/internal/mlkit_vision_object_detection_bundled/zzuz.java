package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzuz implements zzuw {
    final List zza;

    public zzuz(Context context, zzuy zzuyVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzuyVar.zzc()) {
            arrayList.add(new zzvn(context, zzuyVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuw
    public final void zza(zzuv zzuvVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzuw) it.next()).zza(zzuvVar);
        }
    }
}
