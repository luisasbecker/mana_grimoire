package androidx.camera.core;

/* JADX INFO: loaded from: classes.dex */
final class ImageReaderFormatRecommender {

    static abstract class FormatCombo {
        FormatCombo() {
        }

        static FormatCombo create(int i, int i2) {
            return new AutoValue_ImageReaderFormatRecommender_FormatCombo(i, i2);
        }

        abstract int imageAnalysisFormat();

        abstract int imageCaptureFormat();
    }

    private ImageReaderFormatRecommender() {
    }

    static FormatCombo chooseCombo() {
        return FormatCombo.create(256, 35);
    }
}
