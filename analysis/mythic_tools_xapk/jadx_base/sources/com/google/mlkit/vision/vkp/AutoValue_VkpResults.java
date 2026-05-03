package com.google.mlkit.vision.vkp;

import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_VkpResults extends VkpResults {
    private final VkpStatus zza;
    private final List zzb;
    private final List zzc;
    private final boolean zzd;
    private final Boolean zze;

    AutoValue_VkpResults(VkpStatus vkpStatus, List list, List list2, boolean z, Boolean bool) {
        if (vkpStatus == null) {
            throw new NullPointerException("Null getStatus");
        }
        this.zza = vkpStatus;
        if (list == null) {
            throw new NullPointerException("Null getDetectedObjects");
        }
        this.zzb = list;
        if (list2 == null) {
            throw new NullPointerException("Null getImageLabels");
        }
        this.zzc = list2;
        this.zzd = z;
        this.zze = bool;
    }

    public final boolean equals(Object obj) {
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (obj instanceof VkpResults) {
            VkpResults vkpResults = (VkpResults) obj;
            if (this.zza.equals(vkpResults.getStatus()) && this.zzb.equals(vkpResults.getDetectedObjects()) && this.zzc.equals(vkpResults.getImageLabels()) && this.zzd == vkpResults.isFromColdCall() && ((bool = this.zze) != null ? bool.equals(vkpResults.isAccelerated()) : vkpResults.isAccelerated() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.vision.vkp.VkpResults
    public List<VkpDetectedObject> getDetectedObjects() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.vkp.VkpResults
    public List<VkpImageLabel> getImageLabels() {
        return this.zzc;
    }

    @Override // com.google.mlkit.vision.vkp.VkpResults
    public VkpStatus getStatus() {
        return this.zza;
    }

    public final int hashCode() {
        int iHashCode = ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode();
        Boolean bool = this.zze;
        return (((true != this.zzd ? 1237 : 1231) ^ (iHashCode * 1000003)) * 1000003) ^ (bool == null ? 0 : bool.hashCode());
    }

    @Override // com.google.mlkit.vision.vkp.VkpResults
    public Boolean isAccelerated() {
        return this.zze;
    }

    @Override // com.google.mlkit.vision.vkp.VkpResults
    public boolean isFromColdCall() {
        return this.zzd;
    }

    public final String toString() {
        List list = this.zzc;
        List list2 = this.zzb;
        return "VkpResults{getStatus=" + this.zza.toString() + ", getDetectedObjects=" + list2.toString() + ", getImageLabels=" + list.toString() + ", isFromColdCall=" + this.zzd + ", isAccelerated=" + this.zze + "}";
    }
}
