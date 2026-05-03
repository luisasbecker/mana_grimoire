package com.google.mlkit.vision.objects;

import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;

/* JADX INFO: compiled from: com.google.mlkit:object-detection-common@@18.0.0 */
/* JADX INFO: loaded from: classes5.dex */
public class ObjectDetection {
    private ObjectDetection() {
    }

    public static ObjectDetector getClient(ObjectDetectorOptionsBase objectDetectorOptionsBase) {
        Preconditions.checkNotNull(objectDetectorOptionsBase, "options cannot be null");
        return (ObjectDetector) MultiFlavorDetectorCreator.getInstance().create(objectDetectorOptionsBase);
    }
}
