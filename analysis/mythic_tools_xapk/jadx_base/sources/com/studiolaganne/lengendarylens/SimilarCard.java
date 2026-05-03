package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingsManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimilarCard;", "", "scryfallId", "", OptionalModuleUtils.FACE, "", "similarity", "", "<init>", "(Ljava/lang/String;IF)V", "getScryfallId", "()Ljava/lang/String;", "getFace", "()I", "getSimilarity", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SimilarCard {
    public static final int $stable = 0;
    private final int face;
    private final String scryfallId;
    private final float similarity;

    public SimilarCard(String scryfallId, int i, float f) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        this.scryfallId = scryfallId;
        this.face = i;
        this.similarity = f;
    }

    public static /* synthetic */ SimilarCard copy$default(SimilarCard similarCard, String str, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = similarCard.scryfallId;
        }
        if ((i2 & 2) != 0) {
            i = similarCard.face;
        }
        if ((i2 & 4) != 0) {
            f = similarCard.similarity;
        }
        return similarCard.copy(str, i, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScryfallId() {
        return this.scryfallId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFace() {
        return this.face;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getSimilarity() {
        return this.similarity;
    }

    public final SimilarCard copy(String scryfallId, int face, float similarity) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        return new SimilarCard(scryfallId, face, similarity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimilarCard)) {
            return false;
        }
        SimilarCard similarCard = (SimilarCard) other;
        return Intrinsics.areEqual(this.scryfallId, similarCard.scryfallId) && this.face == similarCard.face && Float.compare(this.similarity, similarCard.similarity) == 0;
    }

    public final int getFace() {
        return this.face;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    public final float getSimilarity() {
        return this.similarity;
    }

    public int hashCode() {
        return (((this.scryfallId.hashCode() * 31) + Integer.hashCode(this.face)) * 31) + Float.hashCode(this.similarity);
    }

    public String toString() {
        return "SimilarCard(scryfallId=" + this.scryfallId + ", face=" + this.face + ", similarity=" + this.similarity + ")";
    }
}
