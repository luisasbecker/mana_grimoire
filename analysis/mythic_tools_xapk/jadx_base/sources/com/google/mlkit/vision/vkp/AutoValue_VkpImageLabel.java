package com.google.mlkit.vision.vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_VkpImageLabel extends VkpImageLabel {
    private final String zza;
    private final String zzb;
    private final float zzc;
    private final int zzd;

    AutoValue_VkpImageLabel(String str, String str2, float f, int i) {
        if (str == null) {
            throw new NullPointerException("Null className");
        }
        this.zza = str;
        if (str2 == null) {
            throw new NullPointerException("Null text");
        }
        this.zzb = str2;
        this.zzc = f;
        this.zzd = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VkpImageLabel) {
            VkpImageLabel vkpImageLabel = (VkpImageLabel) obj;
            if (this.zza.equals(vkpImageLabel.getClassName()) && this.zzb.equals(vkpImageLabel.getText()) && Float.floatToIntBits(this.zzc) == Float.floatToIntBits(vkpImageLabel.getScore()) && this.zzd == vkpImageLabel.getIndex()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.vision.vkp.VkpImageLabel
    public String getClassName() {
        return this.zza;
    }

    @Override // com.google.mlkit.vision.vkp.VkpImageLabel
    public int getIndex() {
        return this.zzd;
    }

    @Override // com.google.mlkit.vision.vkp.VkpImageLabel
    public float getScore() {
        return this.zzc;
    }

    @Override // com.google.mlkit.vision.vkp.VkpImageLabel
    public String getText() {
        return this.zzb;
    }

    public final int hashCode() {
        return this.zzd ^ ((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ Float.floatToIntBits(this.zzc)) * 1000003);
    }

    public final String toString() {
        return "VkpImageLabel{className=" + this.zza + ", text=" + this.zzb + ", score=" + this.zzc + ", index=" + this.zzd + "}";
    }
}
