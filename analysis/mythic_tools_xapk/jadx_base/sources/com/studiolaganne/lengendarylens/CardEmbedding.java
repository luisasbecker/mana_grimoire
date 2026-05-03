package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingsManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardEmbedding;", "", "scryfallId", "", OptionalModuleUtils.FACE, "", "embedding", "", "<init>", "(Ljava/lang/String;I[F)V", "getScryfallId", "()Ljava/lang/String;", "getFace", "()I", "getEmbedding", "()[F", "equals", "", "other", "hashCode", "component1", "component2", "component3", "copy", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardEmbedding {
    public static final int $stable = 8;
    private final float[] embedding;
    private final int face;
    private final String scryfallId;

    public CardEmbedding(String scryfallId, int i, float[] embedding) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(embedding, "embedding");
        this.scryfallId = scryfallId;
        this.face = i;
        this.embedding = embedding;
    }

    public static /* synthetic */ CardEmbedding copy$default(CardEmbedding cardEmbedding, String str, int i, float[] fArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cardEmbedding.scryfallId;
        }
        if ((i2 & 2) != 0) {
            i = cardEmbedding.face;
        }
        if ((i2 & 4) != 0) {
            fArr = cardEmbedding.embedding;
        }
        return cardEmbedding.copy(str, i, fArr);
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
    public final float[] getEmbedding() {
        return this.embedding;
    }

    public final CardEmbedding copy(String scryfallId, int face, float[] embedding) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(embedding, "embedding");
        return new CardEmbedding(scryfallId, face, embedding);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardEmbedding)) {
            return false;
        }
        CardEmbedding cardEmbedding = (CardEmbedding) other;
        return Intrinsics.areEqual(this.scryfallId, cardEmbedding.scryfallId) && this.face == cardEmbedding.face && Arrays.equals(this.embedding, cardEmbedding.embedding);
    }

    public final float[] getEmbedding() {
        return this.embedding;
    }

    public final int getFace() {
        return this.face;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    public int hashCode() {
        return (((this.scryfallId.hashCode() * 31) + this.face) * 31) + Arrays.hashCode(this.embedding);
    }

    public String toString() {
        return "CardEmbedding(scryfallId=" + this.scryfallId + ", face=" + this.face + ", embedding=" + Arrays.toString(this.embedding) + ")";
    }
}
