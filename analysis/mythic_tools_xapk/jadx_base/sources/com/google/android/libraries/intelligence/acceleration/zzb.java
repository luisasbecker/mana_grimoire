package com.google.android.libraries.intelligence.acceleration;

import android.util.LongSparseArray;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbli;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb {
    private final LongSparseArray zza;

    public zzb() {
        this(10L);
    }

    public zzb(long j) {
        this.zza = new LongSparseArray();
    }

    public final List zza(List list) {
        zza zzaVar;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbli zzbliVar = (zzbli) it.next();
            synchronized (this.zza) {
                if (this.zza.get(zzbliVar.zzc()) == null) {
                    this.zza.put(zzbliVar.zzc(), new zza(10L));
                }
                zzaVar = (zza) this.zza.get(zzbliVar.zzc());
            }
            if (zzaVar.zza()) {
                arrayList.add(zzbliVar);
            }
        }
        return arrayList;
    }
}
