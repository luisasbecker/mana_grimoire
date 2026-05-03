package org.opencv.objdetect;

import org.opencv.core.Algorithm;

/* JADX INFO: loaded from: classes7.dex */
public class BaseCascadeClassifier extends Algorithm {
    protected BaseCascadeClassifier(long j) {
        super(j);
    }

    public static BaseCascadeClassifier __fromPtr__(long j) {
        return new BaseCascadeClassifier(j);
    }

    private static native void delete(long j);

    @Override // org.opencv.core.Algorithm
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
