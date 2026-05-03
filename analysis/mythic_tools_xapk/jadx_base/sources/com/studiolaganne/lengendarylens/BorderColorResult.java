package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTGBorderColorDetector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/BorderColorResult;", "", "borderColor", "Lcom/studiolaganne/lengendarylens/BorderColor;", "confidence", "", "avgHue", "avgSaturation", "avgBrightness", "<init>", "(Lcom/studiolaganne/lengendarylens/BorderColor;FFFF)V", "getBorderColor", "()Lcom/studiolaganne/lengendarylens/BorderColor;", "getConfidence", "()F", "getAvgHue", "getAvgSaturation", "getAvgBrightness", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BorderColorResult {
    public static final int $stable = 0;
    private final float avgBrightness;
    private final float avgHue;
    private final float avgSaturation;
    private final BorderColor borderColor;
    private final float confidence;

    public BorderColorResult(BorderColor borderColor, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        this.borderColor = borderColor;
        this.confidence = f;
        this.avgHue = f2;
        this.avgSaturation = f3;
        this.avgBrightness = f4;
    }

    public /* synthetic */ BorderColorResult(BorderColor borderColor, float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(borderColor, f, (i & 4) != 0 ? 0.0f : f2, (i & 8) != 0 ? 0.0f : f3, (i & 16) != 0 ? 0.0f : f4);
    }

    public static /* synthetic */ BorderColorResult copy$default(BorderColorResult borderColorResult, BorderColor borderColor, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            borderColor = borderColorResult.borderColor;
        }
        if ((i & 2) != 0) {
            f = borderColorResult.confidence;
        }
        if ((i & 4) != 0) {
            f2 = borderColorResult.avgHue;
        }
        if ((i & 8) != 0) {
            f3 = borderColorResult.avgSaturation;
        }
        if ((i & 16) != 0) {
            f4 = borderColorResult.avgBrightness;
        }
        float f5 = f4;
        float f6 = f2;
        return borderColorResult.copy(borderColor, f, f6, f3, f5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BorderColor getBorderColor() {
        return this.borderColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getAvgHue() {
        return this.avgHue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getAvgSaturation() {
        return this.avgSaturation;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getAvgBrightness() {
        return this.avgBrightness;
    }

    public final BorderColorResult copy(BorderColor borderColor, float confidence, float avgHue, float avgSaturation, float avgBrightness) {
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        return new BorderColorResult(borderColor, confidence, avgHue, avgSaturation, avgBrightness);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderColorResult)) {
            return false;
        }
        BorderColorResult borderColorResult = (BorderColorResult) other;
        return this.borderColor == borderColorResult.borderColor && Float.compare(this.confidence, borderColorResult.confidence) == 0 && Float.compare(this.avgHue, borderColorResult.avgHue) == 0 && Float.compare(this.avgSaturation, borderColorResult.avgSaturation) == 0 && Float.compare(this.avgBrightness, borderColorResult.avgBrightness) == 0;
    }

    public final float getAvgBrightness() {
        return this.avgBrightness;
    }

    public final float getAvgHue() {
        return this.avgHue;
    }

    public final float getAvgSaturation() {
        return this.avgSaturation;
    }

    public final BorderColor getBorderColor() {
        return this.borderColor;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public int hashCode() {
        return (((((((this.borderColor.hashCode() * 31) + Float.hashCode(this.confidence)) * 31) + Float.hashCode(this.avgHue)) * 31) + Float.hashCode(this.avgSaturation)) * 31) + Float.hashCode(this.avgBrightness);
    }

    public String toString() {
        return "BorderColorResult(borderColor=" + this.borderColor + ", confidence=" + this.confidence + ", avgHue=" + this.avgHue + ", avgSaturation=" + this.avgSaturation + ", avgBrightness=" + this.avgBrightness + ")";
    }
}
