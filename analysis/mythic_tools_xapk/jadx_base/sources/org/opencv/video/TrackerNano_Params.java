package org.opencv.video;

/* JADX INFO: loaded from: classes7.dex */
public class TrackerNano_Params {
    protected final long nativeObj;

    public TrackerNano_Params() {
        this.nativeObj = TrackerNano_Params_0();
    }

    protected TrackerNano_Params(long j) {
        this.nativeObj = j;
    }

    private static native long TrackerNano_Params_0();

    public static TrackerNano_Params __fromPtr__(long j) {
        return new TrackerNano_Params(j);
    }

    private static native void delete(long j);

    private static native String get_backbone_0(long j);

    private static native int get_backend_0(long j);

    private static native String get_neckhead_0(long j);

    private static native int get_target_0(long j);

    private static native void set_backbone_0(long j, String str);

    private static native void set_backend_0(long j, int i);

    private static native void set_neckhead_0(long j, String str);

    private static native void set_target_0(long j, int i);

    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public String get_backbone() {
        return get_backbone_0(this.nativeObj);
    }

    public int get_backend() {
        return get_backend_0(this.nativeObj);
    }

    public String get_neckhead() {
        return get_neckhead_0(this.nativeObj);
    }

    public int get_target() {
        return get_target_0(this.nativeObj);
    }

    public void set_backbone(String str) {
        set_backbone_0(this.nativeObj, str);
    }

    public void set_backend(int i) {
        set_backend_0(this.nativeObj, i);
    }

    public void set_neckhead(String str) {
        set_neckhead_0(this.nativeObj, str);
    }

    public void set_target(int i) {
        set_target_0(this.nativeObj, i);
    }
}
