package com.google.mlkit.vision.vkp;

import com.google.mlkit.common.model.LocalModel;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class VkpImageLabelerOptions implements zzc {
    public static VkpImageLabelerOptions from(float f, int i, LocalModel localModel) {
        return new zza(f, i, localModel);
    }

    abstract float zza();

    abstract int zzb();

    abstract LocalModel zzc();
}
