package com.studiolaganne.lengendarylens;

import androidx.camera.video.AudioStats;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u008c\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006:"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTRecommendationData;", "", "confidence", "", "deck_count", "frequency_pct", "", PreferencesManager.RECENT_CARDS_LIST_NAME, "", "similarity", "source", "", "content_similarity", "semantic_similarity", "deck_similarity", "gap_category", "collection", "Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;", "<init>", "(IILjava/lang/Double;Ljava/lang/Boolean;DLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;)V", "getConfidence", "()I", "getDeck_count", "getFrequency_pct", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getRecent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSimilarity", "()D", "getSource", "()Ljava/lang/String;", "getContent_similarity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSemantic_similarity", "getDeck_similarity", "getGap_category", "getCollection", "()Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(IILjava/lang/Double;Ljava/lang/Boolean;DLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;)Lcom/studiolaganne/lengendarylens/MTRecommendationData;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTRecommendationData {
    public static final int $stable = 8;
    private final MTCardCollectionStatus collection;
    private final int confidence;
    private final Integer content_similarity;
    private final int deck_count;
    private final Integer deck_similarity;
    private final Double frequency_pct;
    private final String gap_category;
    private final Boolean recent;
    private final Integer semantic_similarity;
    private final double similarity;
    private final String source;

    public MTRecommendationData() {
        this(0, 0, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, null, null, null, null, 2047, null);
    }

    public MTRecommendationData(int i, int i2, Double d, Boolean bool, double d2, String str, Integer num, Integer num2, Integer num3, String str2, MTCardCollectionStatus mTCardCollectionStatus) {
        this.confidence = i;
        this.deck_count = i2;
        this.frequency_pct = d;
        this.recent = bool;
        this.similarity = d2;
        this.source = str;
        this.content_similarity = num;
        this.semantic_similarity = num2;
        this.deck_similarity = num3;
        this.gap_category = str2;
        this.collection = mTCardCollectionStatus;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MTRecommendationData(int i, int i2, Double d, Boolean bool, double d2, String str, Integer num, Integer num2, Integer num3, String str2, MTCardCollectionStatus mTCardCollectionStatus, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        MTCardCollectionStatus mTCardCollectionStatus2;
        String str3;
        Integer num4;
        Integer num5;
        String str4;
        Integer num6;
        i = (i3 & 1) != 0 ? 1 : i;
        i2 = (i3 & 2) != 0 ? 0 : i2;
        d = (i3 & 4) != 0 ? null : d;
        bool = (i3 & 8) != 0 ? null : bool;
        d2 = (i3 & 16) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d2;
        str = (i3 & 32) != 0 ? null : str;
        num = (i3 & 64) != 0 ? null : num;
        num2 = (i3 & 128) != 0 ? null : num2;
        num3 = (i3 & 256) != 0 ? null : num3;
        str2 = (i3 & 512) != 0 ? null : str2;
        if ((i3 & 1024) != 0) {
            mTCardCollectionStatus2 = null;
            num5 = num3;
            str3 = str2;
            num6 = num;
            num4 = num2;
            str4 = str;
        } else {
            mTCardCollectionStatus2 = mTCardCollectionStatus;
            str3 = str2;
            num4 = num2;
            num5 = num3;
            str4 = str;
            num6 = num;
        }
        this(i, i2, d, bool, d2, str4, num6, num4, num5, str3, mTCardCollectionStatus2);
    }

    public static /* synthetic */ MTRecommendationData copy$default(MTRecommendationData mTRecommendationData, int i, int i2, Double d, Boolean bool, double d2, String str, Integer num, Integer num2, Integer num3, String str2, MTCardCollectionStatus mTCardCollectionStatus, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTRecommendationData.confidence;
        }
        if ((i3 & 2) != 0) {
            i2 = mTRecommendationData.deck_count;
        }
        if ((i3 & 4) != 0) {
            d = mTRecommendationData.frequency_pct;
        }
        if ((i3 & 8) != 0) {
            bool = mTRecommendationData.recent;
        }
        if ((i3 & 16) != 0) {
            d2 = mTRecommendationData.similarity;
        }
        if ((i3 & 32) != 0) {
            str = mTRecommendationData.source;
        }
        if ((i3 & 64) != 0) {
            num = mTRecommendationData.content_similarity;
        }
        if ((i3 & 128) != 0) {
            num2 = mTRecommendationData.semantic_similarity;
        }
        if ((i3 & 256) != 0) {
            num3 = mTRecommendationData.deck_similarity;
        }
        if ((i3 & 512) != 0) {
            str2 = mTRecommendationData.gap_category;
        }
        if ((i3 & 1024) != 0) {
            mTCardCollectionStatus = mTRecommendationData.collection;
        }
        String str3 = str2;
        MTCardCollectionStatus mTCardCollectionStatus2 = mTCardCollectionStatus;
        double d3 = d2;
        Double d4 = d;
        Boolean bool2 = bool;
        return mTRecommendationData.copy(i, i2, d4, bool2, d3, str, num, num2, num3, str3, mTCardCollectionStatus2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getConfidence() {
        return this.confidence;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getGap_category() {
        return this.gap_category;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MTCardCollectionStatus getCollection() {
        return this.collection;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDeck_count() {
        return this.deck_count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getFrequency_pct() {
        return this.frequency_pct;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getRecent() {
        return this.recent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getSimilarity() {
        return this.similarity;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getContent_similarity() {
        return this.content_similarity;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getSemantic_similarity() {
        return this.semantic_similarity;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getDeck_similarity() {
        return this.deck_similarity;
    }

    public final MTRecommendationData copy(int confidence, int deck_count, Double frequency_pct, Boolean recent, double similarity, String source, Integer content_similarity, Integer semantic_similarity, Integer deck_similarity, String gap_category, MTCardCollectionStatus collection) {
        return new MTRecommendationData(confidence, deck_count, frequency_pct, recent, similarity, source, content_similarity, semantic_similarity, deck_similarity, gap_category, collection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTRecommendationData)) {
            return false;
        }
        MTRecommendationData mTRecommendationData = (MTRecommendationData) other;
        return this.confidence == mTRecommendationData.confidence && this.deck_count == mTRecommendationData.deck_count && Intrinsics.areEqual((Object) this.frequency_pct, (Object) mTRecommendationData.frequency_pct) && Intrinsics.areEqual(this.recent, mTRecommendationData.recent) && Double.compare(this.similarity, mTRecommendationData.similarity) == 0 && Intrinsics.areEqual(this.source, mTRecommendationData.source) && Intrinsics.areEqual(this.content_similarity, mTRecommendationData.content_similarity) && Intrinsics.areEqual(this.semantic_similarity, mTRecommendationData.semantic_similarity) && Intrinsics.areEqual(this.deck_similarity, mTRecommendationData.deck_similarity) && Intrinsics.areEqual(this.gap_category, mTRecommendationData.gap_category) && Intrinsics.areEqual(this.collection, mTRecommendationData.collection);
    }

    public final MTCardCollectionStatus getCollection() {
        return this.collection;
    }

    public final int getConfidence() {
        return this.confidence;
    }

    public final Integer getContent_similarity() {
        return this.content_similarity;
    }

    public final int getDeck_count() {
        return this.deck_count;
    }

    public final Integer getDeck_similarity() {
        return this.deck_similarity;
    }

    public final Double getFrequency_pct() {
        return this.frequency_pct;
    }

    public final String getGap_category() {
        return this.gap_category;
    }

    public final Boolean getRecent() {
        return this.recent;
    }

    public final Integer getSemantic_similarity() {
        return this.semantic_similarity;
    }

    public final double getSimilarity() {
        return this.similarity;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.confidence) * 31) + Integer.hashCode(this.deck_count)) * 31;
        Double d = this.frequency_pct;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Boolean bool = this.recent;
        int iHashCode3 = (((iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + Double.hashCode(this.similarity)) * 31;
        String str = this.source;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.content_similarity;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.semantic_similarity;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.deck_similarity;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.gap_category;
        int iHashCode8 = (iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MTCardCollectionStatus mTCardCollectionStatus = this.collection;
        return iHashCode8 + (mTCardCollectionStatus != null ? mTCardCollectionStatus.hashCode() : 0);
    }

    public String toString() {
        return "MTRecommendationData(confidence=" + this.confidence + ", deck_count=" + this.deck_count + ", frequency_pct=" + this.frequency_pct + ", recent=" + this.recent + ", similarity=" + this.similarity + ", source=" + this.source + ", content_similarity=" + this.content_similarity + ", semantic_similarity=" + this.semantic_similarity + ", deck_similarity=" + this.deck_similarity + ", gap_category=" + this.gap_category + ", collection=" + this.collection + ")";
    }
}
