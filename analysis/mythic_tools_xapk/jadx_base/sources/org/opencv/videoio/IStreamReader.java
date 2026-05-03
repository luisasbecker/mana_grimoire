package org.opencv.videoio;

/* JADX INFO: loaded from: classes7.dex */
public class IStreamReader {
    protected final long nativeObj;

    protected IStreamReader() {
        this.nativeObj = 0L;
    }

    protected IStreamReader(long j) {
        this.nativeObj = j;
    }

    public static IStreamReader __fromPtr__(long j) {
        return new IStreamReader(j);
    }

    private static native void delete(long j);

    private static native long read_0(long j, byte[] bArr, long j2);

    private static native long seek_0(long j, long j2, int i);

    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public long read(byte[] bArr, long j) {
        return read_0(this.nativeObj, bArr, j);
    }

    public long seek(long j, int i) {
        return seek_0(this.nativeObj, j, i);
    }
}
