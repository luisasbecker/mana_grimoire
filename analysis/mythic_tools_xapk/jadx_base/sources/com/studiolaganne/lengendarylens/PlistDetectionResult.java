package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: PListDetector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlistDetectionResult;", "", "hasPlist", "", "confidence", "", "<init>", "(ZF)V", "getHasPlist", "()Z", "getConfidence", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PlistDetectionResult {
    public static final int $stable = 0;
    private final float confidence;
    private final boolean hasPlist;

    public PlistDetectionResult(boolean z, float f) {
        this.hasPlist = z;
        this.confidence = f;
    }

    public static /* synthetic */ PlistDetectionResult copy$default(PlistDetectionResult plistDetectionResult, boolean z, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            z = plistDetectionResult.hasPlist;
        }
        if ((i & 2) != 0) {
            f = plistDetectionResult.confidence;
        }
        return plistDetectionResult.copy(z, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasPlist() {
        return this.hasPlist;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    public final PlistDetectionResult copy(boolean hasPlist, float confidence) {
        return new PlistDetectionResult(hasPlist, confidence);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlistDetectionResult)) {
            return false;
        }
        PlistDetectionResult plistDetectionResult = (PlistDetectionResult) other;
        return this.hasPlist == plistDetectionResult.hasPlist && Float.compare(this.confidence, plistDetectionResult.confidence) == 0;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final boolean getHasPlist() {
        return this.hasPlist;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.hasPlist) * 31) + Float.hashCode(this.confidence);
    }

    public String toString() {
        return "PlistDetectionResult(hasPlist=" + this.hasPlist + ", confidence=" + this.confidence + ")";
    }
}
