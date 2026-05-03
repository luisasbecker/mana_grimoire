package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTRecommendMeta;", "", "modelId", "", "training_decks", "commanderDecks", "confidence", "", "confidence_top_k", "error", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getModelId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTraining_decks", "getCommanderDecks", "getConfidence", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConfidence_top_k", "getError", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTRecommendMeta;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTRecommendMeta {
    public static final int $stable = 0;
    private final Integer commanderDecks;
    private final Boolean confidence;
    private final Integer confidence_top_k;
    private final String error;
    private final Integer modelId;
    private final Integer training_decks;

    public MTRecommendMeta() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MTRecommendMeta(Integer num, Integer num2, Integer num3, Boolean bool, Integer num4, String str) {
        this.modelId = num;
        this.training_decks = num2;
        this.commanderDecks = num3;
        this.confidence = bool;
        this.confidence_top_k = num4;
        this.error = str;
    }

    public /* synthetic */ MTRecommendMeta(Integer num, Integer num2, Integer num3, Boolean bool, Integer num4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : str);
    }

    public static /* synthetic */ MTRecommendMeta copy$default(MTRecommendMeta mTRecommendMeta, Integer num, Integer num2, Integer num3, Boolean bool, Integer num4, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTRecommendMeta.modelId;
        }
        if ((i & 2) != 0) {
            num2 = mTRecommendMeta.training_decks;
        }
        if ((i & 4) != 0) {
            num3 = mTRecommendMeta.commanderDecks;
        }
        if ((i & 8) != 0) {
            bool = mTRecommendMeta.confidence;
        }
        if ((i & 16) != 0) {
            num4 = mTRecommendMeta.confidence_top_k;
        }
        if ((i & 32) != 0) {
            str = mTRecommendMeta.error;
        }
        Integer num5 = num4;
        String str2 = str;
        return mTRecommendMeta.copy(num, num2, num3, bool, num5, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getModelId() {
        return this.modelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTraining_decks() {
        return this.training_decks;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCommanderDecks() {
        return this.commanderDecks;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getConfidence() {
        return this.confidence;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getConfidence_top_k() {
        return this.confidence_top_k;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final MTRecommendMeta copy(Integer modelId, Integer training_decks, Integer commanderDecks, Boolean confidence, Integer confidence_top_k, String error) {
        return new MTRecommendMeta(modelId, training_decks, commanderDecks, confidence, confidence_top_k, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTRecommendMeta)) {
            return false;
        }
        MTRecommendMeta mTRecommendMeta = (MTRecommendMeta) other;
        return Intrinsics.areEqual(this.modelId, mTRecommendMeta.modelId) && Intrinsics.areEqual(this.training_decks, mTRecommendMeta.training_decks) && Intrinsics.areEqual(this.commanderDecks, mTRecommendMeta.commanderDecks) && Intrinsics.areEqual(this.confidence, mTRecommendMeta.confidence) && Intrinsics.areEqual(this.confidence_top_k, mTRecommendMeta.confidence_top_k) && Intrinsics.areEqual(this.error, mTRecommendMeta.error);
    }

    public final Integer getCommanderDecks() {
        return this.commanderDecks;
    }

    public final Boolean getConfidence() {
        return this.confidence;
    }

    public final Integer getConfidence_top_k() {
        return this.confidence_top_k;
    }

    public final String getError() {
        return this.error;
    }

    public final Integer getModelId() {
        return this.modelId;
    }

    public final Integer getTraining_decks() {
        return this.training_decks;
    }

    public int hashCode() {
        Integer num = this.modelId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.training_decks;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.commanderDecks;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.confidence;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num4 = this.confidence_top_k;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str = this.error;
        return iHashCode5 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "MTRecommendMeta(modelId=" + this.modelId + ", training_decks=" + this.training_decks + ", commanderDecks=" + this.commanderDecks + ", confidence=" + this.confidence + ", confidence_top_k=" + this.confidence_top_k + ", error=" + this.error + ")";
    }
}
