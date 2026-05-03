package com.google.mlkit.vision.vkp;

import com.google.android.gms.common.internal.LibraryVersion;
import com.google.mlkit.common.model.LocalModel;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class VkpObjectDetectorOptions implements zzc {
    public static VkpObjectDetectorOptions from(boolean z, boolean z2, boolean z3, boolean z4, float f, int i, LocalModel localModel) {
        String str = localModel == null ? "object-detection" : "object-detection-custom";
        return new zzb(z, z2, z3, z4, f, i, localModel, str, LibraryVersion.getInstance().getVersion(str));
    }

    abstract float zza();

    abstract int zzb();

    abstract LocalModel zzc();

    abstract String zzd();

    abstract String zze();

    abstract boolean zzf();

    abstract boolean zzg();

    abstract boolean zzh();

    abstract boolean zzi();
}
