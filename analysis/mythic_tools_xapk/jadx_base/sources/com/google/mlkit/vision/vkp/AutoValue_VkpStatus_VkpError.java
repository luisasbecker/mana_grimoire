package com.google.mlkit.vision.vkp;

import com.google.mlkit.vision.vkp.VkpStatus;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_VkpStatus_VkpError extends VkpStatus.VkpError {
    private final int zza;
    private final int zzb;

    AutoValue_VkpStatus_VkpError(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VkpStatus.VkpError) {
            VkpStatus.VkpError vkpError = (VkpStatus.VkpError) obj;
            if (this.zza == vkpError.getErrorSpaceNumber() && this.zzb == vkpError.getErrorCode()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.vision.vkp.VkpStatus.VkpError
    public int getErrorCode() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.vkp.VkpStatus.VkpError
    public int getErrorSpaceNumber() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zzb ^ ((this.zza ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "VkpError{errorSpaceNumber=" + this.zza + ", errorCode=" + this.zzb + "}";
    }
}
