package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: loaded from: classes.dex */
public interface ImageInfo {
    default int getFlashState() {
        return 0;
    }

    int getRotationDegrees();

    default Matrix getSensorToBufferTransformMatrix() {
        return new Matrix();
    }

    TagBundle getTagBundle();

    long getTimestamp();

    void populateExifData(ExifData.Builder builder);
}
