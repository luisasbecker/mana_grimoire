package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTBracketSuggestionResponse;", "", "suggested", "", "confidence", "", "minBracket", "metrics", "Lcom/studiolaganne/lengendarylens/MTBracketMetrics;", "<init>", "(ILjava/lang/String;ILcom/studiolaganne/lengendarylens/MTBracketMetrics;)V", "getSuggested", "()I", "setSuggested", "(I)V", "getConfidence", "()Ljava/lang/String;", "setConfidence", "(Ljava/lang/String;)V", "getMinBracket", "setMinBracket", "getMetrics", "()Lcom/studiolaganne/lengendarylens/MTBracketMetrics;", "setMetrics", "(Lcom/studiolaganne/lengendarylens/MTBracketMetrics;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTBracketSuggestionResponse {
    public static final int $stable = 8;
    private String confidence;
    private MTBracketMetrics metrics;
    private int minBracket;
    private int suggested;

    public MTBracketSuggestionResponse() {
        this(0, null, 0, null, 15, null);
    }

    public MTBracketSuggestionResponse(int i, String confidence, int i2, MTBracketMetrics mTBracketMetrics) {
        Intrinsics.checkNotNullParameter(confidence, "confidence");
        this.suggested = i;
        this.confidence = confidence;
        this.minBracket = i2;
        this.metrics = mTBracketMetrics;
    }

    public /* synthetic */ MTBracketSuggestionResponse(int i, String str, int i2, MTBracketMetrics mTBracketMetrics, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 2 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 2 : i2, (i3 & 8) != 0 ? null : mTBracketMetrics);
    }

    public static /* synthetic */ MTBracketSuggestionResponse copy$default(MTBracketSuggestionResponse mTBracketSuggestionResponse, int i, String str, int i2, MTBracketMetrics mTBracketMetrics, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTBracketSuggestionResponse.suggested;
        }
        if ((i3 & 2) != 0) {
            str = mTBracketSuggestionResponse.confidence;
        }
        if ((i3 & 4) != 0) {
            i2 = mTBracketSuggestionResponse.minBracket;
        }
        if ((i3 & 8) != 0) {
            mTBracketMetrics = mTBracketSuggestionResponse.metrics;
        }
        return mTBracketSuggestionResponse.copy(i, str, i2, mTBracketMetrics);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSuggested() {
        return this.suggested;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getConfidence() {
        return this.confidence;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMinBracket() {
        return this.minBracket;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTBracketMetrics getMetrics() {
        return this.metrics;
    }

    public final MTBracketSuggestionResponse copy(int suggested, String confidence, int minBracket, MTBracketMetrics metrics) {
        Intrinsics.checkNotNullParameter(confidence, "confidence");
        return new MTBracketSuggestionResponse(suggested, confidence, minBracket, metrics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTBracketSuggestionResponse)) {
            return false;
        }
        MTBracketSuggestionResponse mTBracketSuggestionResponse = (MTBracketSuggestionResponse) other;
        return this.suggested == mTBracketSuggestionResponse.suggested && Intrinsics.areEqual(this.confidence, mTBracketSuggestionResponse.confidence) && this.minBracket == mTBracketSuggestionResponse.minBracket && Intrinsics.areEqual(this.metrics, mTBracketSuggestionResponse.metrics);
    }

    public final String getConfidence() {
        return this.confidence;
    }

    public final MTBracketMetrics getMetrics() {
        return this.metrics;
    }

    public final int getMinBracket() {
        return this.minBracket;
    }

    public final int getSuggested() {
        return this.suggested;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.suggested) * 31) + this.confidence.hashCode()) * 31) + Integer.hashCode(this.minBracket)) * 31;
        MTBracketMetrics mTBracketMetrics = this.metrics;
        return iHashCode + (mTBracketMetrics == null ? 0 : mTBracketMetrics.hashCode());
    }

    public final void setConfidence(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.confidence = str;
    }

    public final void setMetrics(MTBracketMetrics mTBracketMetrics) {
        this.metrics = mTBracketMetrics;
    }

    public final void setMinBracket(int i) {
        this.minBracket = i;
    }

    public final void setSuggested(int i) {
        this.suggested = i;
    }

    public String toString() {
        return "MTBracketSuggestionResponse(suggested=" + this.suggested + ", confidence=" + this.confidence + ", minBracket=" + this.minBracket + ", metrics=" + this.metrics + ")";
    }
}
