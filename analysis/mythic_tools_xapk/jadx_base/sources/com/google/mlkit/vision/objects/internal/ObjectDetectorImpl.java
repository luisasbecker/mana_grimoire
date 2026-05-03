package com.google.mlkit.vision.objects.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.objects.DetectedObject;
import com.google.mlkit.vision.objects.ObjectDetector;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.mlkit:object-detection-common@@18.0.0 */
/* JADX INFO: loaded from: classes5.dex */
public class ObjectDetectorImpl extends MobileVisionBase<List<DetectedObject>> implements ObjectDetector {
    private ObjectDetectorImpl(MLTask mLTask, Executor executor) {
        super(mLTask, executor);
    }

    public static ObjectDetectorImpl newInstance(MLTask<List<DetectedObject>, InputImage> mLTask, Executor executor) {
        return new ObjectDetectorImpl(mLTask, executor);
    }

    @Override // com.google.mlkit.vision.interfaces.Detector
    public final int getDetectorType() {
        return 5;
    }

    @Override // com.google.mlkit.vision.objects.ObjectDetector
    public final Task<List<DetectedObject>> process(MlImage mlImage) {
        return processBase(mlImage);
    }

    @Override // com.google.mlkit.vision.objects.ObjectDetector
    public final Task<List<DetectedObject>> process(InputImage inputImage) {
        ByteBuffer byteBuffer = inputImage.getByteBuffer();
        if (byteBuffer != null) {
            inputImage = InputImage.fromByteBuffer(ImageConvertUtils.getInstance().cloneByteBuffer(byteBuffer), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees(), inputImage.getFormat());
        }
        return processBase(inputImage);
    }
}
