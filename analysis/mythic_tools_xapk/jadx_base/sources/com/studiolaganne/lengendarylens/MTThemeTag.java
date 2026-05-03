package com.studiolaganne.lengendarylens;

import androidx.camera.video.AudioStats;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTThemeTag;", "", "tagName", "", "weight", "", "<init>", "(Ljava/lang/String;D)V", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "getWeight", "()D", "setWeight", "(D)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTThemeTag {
    public static final int $stable = 8;
    private String tagName;
    private double weight;

    public MTThemeTag() {
        this(null, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null);
    }

    public MTThemeTag(String tagName, double d) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        this.tagName = tagName;
        this.weight = d;
    }

    public /* synthetic */ MTThemeTag(String str, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 1.0d : d);
    }

    public static /* synthetic */ MTThemeTag copy$default(MTThemeTag mTThemeTag, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTThemeTag.tagName;
        }
        if ((i & 2) != 0) {
            d = mTThemeTag.weight;
        }
        return mTThemeTag.copy(str, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getWeight() {
        return this.weight;
    }

    public final MTThemeTag copy(String tagName, double weight) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        return new MTThemeTag(tagName, weight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTThemeTag)) {
            return false;
        }
        MTThemeTag mTThemeTag = (MTThemeTag) other;
        return Intrinsics.areEqual(this.tagName, mTThemeTag.tagName) && Double.compare(this.weight, mTThemeTag.weight) == 0;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final double getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (this.tagName.hashCode() * 31) + Double.hashCode(this.weight);
    }

    public final void setTagName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagName = str;
    }

    public final void setWeight(double d) {
        this.weight = d;
    }

    public String toString() {
        return "MTThemeTag(tagName=" + this.tagName + ", weight=" + this.weight + ")";
    }
}
