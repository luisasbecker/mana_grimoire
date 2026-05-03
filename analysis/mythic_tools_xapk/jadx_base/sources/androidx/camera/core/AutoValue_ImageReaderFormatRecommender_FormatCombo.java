package androidx.camera.core;

import androidx.camera.core.ImageReaderFormatRecommender;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_ImageReaderFormatRecommender_FormatCombo extends ImageReaderFormatRecommender.FormatCombo {
    private final int imageAnalysisFormat;
    private final int imageCaptureFormat;

    AutoValue_ImageReaderFormatRecommender_FormatCombo(int i, int i2) {
        this.imageCaptureFormat = i;
        this.imageAnalysisFormat = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImageReaderFormatRecommender.FormatCombo) {
            ImageReaderFormatRecommender.FormatCombo formatCombo = (ImageReaderFormatRecommender.FormatCombo) obj;
            if (this.imageCaptureFormat == formatCombo.imageCaptureFormat() && this.imageAnalysisFormat == formatCombo.imageAnalysisFormat()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.imageAnalysisFormat ^ ((this.imageCaptureFormat ^ 1000003) * 1000003);
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    int imageAnalysisFormat() {
        return this.imageAnalysisFormat;
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    int imageCaptureFormat() {
        return this.imageCaptureFormat;
    }

    public String toString() {
        return "FormatCombo{imageCaptureFormat=" + this.imageCaptureFormat + ", imageAnalysisFormat=" + this.imageAnalysisFormat + "}";
    }
}
