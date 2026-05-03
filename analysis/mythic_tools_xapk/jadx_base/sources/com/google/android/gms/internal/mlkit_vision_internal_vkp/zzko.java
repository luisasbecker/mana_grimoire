package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzko {
    private final zzkm zza;

    private zzko(zzkm zzkmVar) {
        int i = zzke.zzb;
        this.zza = zzkmVar;
    }

    public static zzko zza(String str) {
        return new zzko(new zzkm("#vk "));
    }

    public final List zzb(CharSequence charSequence) {
        charSequence.getClass();
        zzkl zzklVar = new zzkl(this.zza, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzklVar.hasNext()) {
            arrayList.add((String) zzklVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
