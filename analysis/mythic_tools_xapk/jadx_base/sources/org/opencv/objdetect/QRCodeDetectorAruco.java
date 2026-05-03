package org.opencv.objdetect;

/* JADX INFO: loaded from: classes7.dex */
public class QRCodeDetectorAruco extends GraphicalCodeDetector {
    public QRCodeDetectorAruco() {
        super(QRCodeDetectorAruco_0());
    }

    protected QRCodeDetectorAruco(long j) {
        super(j);
    }

    public QRCodeDetectorAruco(QRCodeDetectorAruco_Params qRCodeDetectorAruco_Params) {
        super(QRCodeDetectorAruco_1(qRCodeDetectorAruco_Params.getNativeObjAddr()));
    }

    private static native long QRCodeDetectorAruco_0();

    private static native long QRCodeDetectorAruco_1(long j);

    public static QRCodeDetectorAruco __fromPtr__(long j) {
        return new QRCodeDetectorAruco(j);
    }

    private static native void delete(long j);

    private static native long getDetectorParameters_0(long j);

    private static native long setDetectorParameters_0(long j, long j2);

    @Override // org.opencv.objdetect.GraphicalCodeDetector
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public QRCodeDetectorAruco_Params getDetectorParameters() {
        return new QRCodeDetectorAruco_Params(getDetectorParameters_0(this.nativeObj));
    }

    public QRCodeDetectorAruco setDetectorParameters(QRCodeDetectorAruco_Params qRCodeDetectorAruco_Params) {
        return new QRCodeDetectorAruco(setDetectorParameters_0(this.nativeObj, qRCodeDetectorAruco_Params.getNativeObjAddr()));
    }
}
