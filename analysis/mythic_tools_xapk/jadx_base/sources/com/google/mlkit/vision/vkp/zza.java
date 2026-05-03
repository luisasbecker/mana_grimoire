package com.google.mlkit.vision.vkp;

import com.google.mlkit.common.model.LocalModel;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
final class zza extends VkpImageLabelerOptions {
    private final float zza;
    private final int zzb;
    private final LocalModel zzc;

    zza(float f, int i, LocalModel localModel) {
        this.zza = f;
        this.zzb = i;
        this.zzc = localModel;
    }

    public final boolean equals(Object obj) {
        LocalModel localModel;
        if (obj == this) {
            return true;
        }
        if (obj instanceof VkpImageLabelerOptions) {
            VkpImageLabelerOptions vkpImageLabelerOptions = (VkpImageLabelerOptions) obj;
            if (Float.floatToIntBits(this.zza) == Float.floatToIntBits(vkpImageLabelerOptions.zza()) && this.zzb == vkpImageLabelerOptions.zzb() && ((localModel = this.zzc) != null ? localModel.equals(vkpImageLabelerOptions.zzc()) : vkpImageLabelerOptions.zzc() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iFloatToIntBits = Float.floatToIntBits(this.zza) ^ 1000003;
        LocalModel localModel = this.zzc;
        return ((this.zzb ^ (iFloatToIntBits * 1000003)) * 1000003) ^ (localModel == null ? 0 : localModel.hashCode());
    }

    public final String toString() {
        return "VkpImageLabelerOptions{confidenceThreshold=" + this.zza + ", maxResultCount=" + this.zzb + ", customClassifierLocalModel=" + String.valueOf(this.zzc) + "}";
    }

    @Override // com.google.mlkit.vision.vkp.VkpImageLabelerOptions
    final float zza() {
        return this.zza;
    }

    @Override // com.google.mlkit.vision.vkp.VkpImageLabelerOptions
    final int zzb() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.vkp.VkpImageLabelerOptions
    final LocalModel zzc() {
        return this.zzc;
    }
}
