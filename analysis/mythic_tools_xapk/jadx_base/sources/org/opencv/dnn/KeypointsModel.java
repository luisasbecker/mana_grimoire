package org.opencv.dnn;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;

/* JADX INFO: loaded from: classes7.dex */
public class KeypointsModel extends Model {
    protected KeypointsModel(long j) {
        super(j);
    }

    public KeypointsModel(String str) {
        super(KeypointsModel_1(str));
    }

    public KeypointsModel(String str, String str2) {
        super(KeypointsModel_0(str, str2));
    }

    public KeypointsModel(Net net) {
        super(KeypointsModel_2(net.getNativeObjAddr()));
    }

    private static native long KeypointsModel_0(String str, String str2);

    private static native long KeypointsModel_1(String str);

    private static native long KeypointsModel_2(long j);

    public static KeypointsModel __fromPtr__(long j) {
        return new KeypointsModel(j);
    }

    private static native void delete(long j);

    private static native long estimate_0(long j, long j2, float f);

    private static native long estimate_1(long j, long j2);

    public MatOfPoint2f estimate(Mat mat) {
        return MatOfPoint2f.fromNativeAddr(estimate_1(this.nativeObj, mat.nativeObj));
    }

    public MatOfPoint2f estimate(Mat mat, float f) {
        return MatOfPoint2f.fromNativeAddr(estimate_0(this.nativeObj, mat.nativeObj, f));
    }

    @Override // org.opencv.dnn.Model
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
