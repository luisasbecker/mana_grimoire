package com.google.mlkit.vision.vkp;

import android.text.TextUtils;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzha;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class VkpImageLabel {
    public static VkpImageLabel zza(zzha zzhaVar) {
        String strZzf = zzhaVar.zzf();
        if (TextUtils.isEmpty(strZzf)) {
            strZzf = zzhaVar.zze();
        }
        return new AutoValue_VkpImageLabel(zzhaVar.zze(), strZzf, zzhaVar.zza(), zzhaVar.zzc());
    }

    public abstract String getClassName();

    public abstract int getIndex();

    public abstract float getScore();

    public abstract String getText();
}
