package org.opencv.features2d;

/* JADX INFO: loaded from: classes7.dex */
public class BFMatcher extends DescriptorMatcher {
    public BFMatcher() {
        super(BFMatcher_2());
    }

    public BFMatcher(int i) {
        super(BFMatcher_1(i));
    }

    public BFMatcher(int i, boolean z) {
        super(BFMatcher_0(i, z));
    }

    protected BFMatcher(long j) {
        super(j);
    }

    private static native long BFMatcher_0(int i, boolean z);

    private static native long BFMatcher_1(int i);

    private static native long BFMatcher_2();

    public static BFMatcher __fromPtr__(long j) {
        return new BFMatcher(j);
    }

    public static BFMatcher create() {
        return __fromPtr__(create_2());
    }

    public static BFMatcher create(int i) {
        return __fromPtr__(create_1(i));
    }

    public static BFMatcher create(int i, boolean z) {
        return __fromPtr__(create_0(i, z));
    }

    private static native long create_0(int i, boolean z);

    private static native long create_1(int i);

    private static native long create_2();

    private static native void delete(long j);

    @Override // org.opencv.features2d.DescriptorMatcher, org.opencv.core.Algorithm
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
