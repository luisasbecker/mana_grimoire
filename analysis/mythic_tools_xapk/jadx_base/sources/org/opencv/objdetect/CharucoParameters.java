package org.opencv.objdetect;

import org.opencv.core.Mat;

/* JADX INFO: loaded from: classes7.dex */
public class CharucoParameters {
    protected final long nativeObj;

    public CharucoParameters() {
        this.nativeObj = CharucoParameters_0();
    }

    protected CharucoParameters(long j) {
        this.nativeObj = j;
    }

    private static native long CharucoParameters_0();

    public static CharucoParameters __fromPtr__(long j) {
        return new CharucoParameters(j);
    }

    private static native void delete(long j);

    private static native long get_cameraMatrix_0(long j);

    private static native boolean get_checkMarkers_0(long j);

    private static native long get_distCoeffs_0(long j);

    private static native int get_minMarkers_0(long j);

    private static native boolean get_tryRefineMarkers_0(long j);

    private static native void set_cameraMatrix_0(long j, long j2);

    private static native void set_checkMarkers_0(long j, boolean z);

    private static native void set_distCoeffs_0(long j, long j2);

    private static native void set_minMarkers_0(long j, int i);

    private static native void set_tryRefineMarkers_0(long j, boolean z);

    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public Mat get_cameraMatrix() {
        return new Mat(get_cameraMatrix_0(this.nativeObj));
    }

    public boolean get_checkMarkers() {
        return get_checkMarkers_0(this.nativeObj);
    }

    public Mat get_distCoeffs() {
        return new Mat(get_distCoeffs_0(this.nativeObj));
    }

    public int get_minMarkers() {
        return get_minMarkers_0(this.nativeObj);
    }

    public boolean get_tryRefineMarkers() {
        return get_tryRefineMarkers_0(this.nativeObj);
    }

    public void set_cameraMatrix(Mat mat) {
        set_cameraMatrix_0(this.nativeObj, mat.nativeObj);
    }

    public void set_checkMarkers(boolean z) {
        set_checkMarkers_0(this.nativeObj, z);
    }

    public void set_distCoeffs(Mat mat) {
        set_distCoeffs_0(this.nativeObj, mat.nativeObj);
    }

    public void set_minMarkers(int i) {
        set_minMarkers_0(this.nativeObj, i);
    }

    public void set_tryRefineMarkers(boolean z) {
        set_tryRefineMarkers_0(this.nativeObj, z);
    }
}
