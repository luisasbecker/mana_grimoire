package com.google.mlkit.vision.objects;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import com.google.mlkit.vision.interfaces.Detector;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:object-detection-common@@18.0.0 */
/* JADX INFO: loaded from: classes5.dex */
public interface ObjectDetector extends Detector<List<DetectedObject>>, MultiFlavorDetectorCreator.MultiFlavorDetector {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void close();

    Task<List<DetectedObject>> process(MlImage mlImage);

    Task<List<DetectedObject>> process(InputImage inputImage);
}
