package com.google.mlkit.vision.vkp;

import android.graphics.Rect;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class VkpDetectedObject {
    public abstract Rect getBoundingBox();

    public abstract List<VkpImageLabel> getLabels();

    public abstract Integer getTrackingId();
}
