package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingsManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimilaritySearchResult;", "", "queryEmbedding", "", "matches", "", "Lcom/studiolaganne/lengendarylens/SimilarCard;", "<init>", "([FLjava/util/List;)V", "getQueryEmbedding", "()[F", "getMatches", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SimilaritySearchResult {
    public static final int $stable = 8;
    private final List<SimilarCard> matches;
    private final float[] queryEmbedding;

    public SimilaritySearchResult(float[] queryEmbedding, List<SimilarCard> matches) {
        Intrinsics.checkNotNullParameter(queryEmbedding, "queryEmbedding");
        Intrinsics.checkNotNullParameter(matches, "matches");
        this.queryEmbedding = queryEmbedding;
        this.matches = matches;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SimilaritySearchResult copy$default(SimilaritySearchResult similaritySearchResult, float[] fArr, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = similaritySearchResult.queryEmbedding;
        }
        if ((i & 2) != 0) {
            list = similaritySearchResult.matches;
        }
        return similaritySearchResult.copy(fArr, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float[] getQueryEmbedding() {
        return this.queryEmbedding;
    }

    public final List<SimilarCard> component2() {
        return this.matches;
    }

    public final SimilaritySearchResult copy(float[] queryEmbedding, List<SimilarCard> matches) {
        Intrinsics.checkNotNullParameter(queryEmbedding, "queryEmbedding");
        Intrinsics.checkNotNullParameter(matches, "matches");
        return new SimilaritySearchResult(queryEmbedding, matches);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimilaritySearchResult)) {
            return false;
        }
        SimilaritySearchResult similaritySearchResult = (SimilaritySearchResult) other;
        return Intrinsics.areEqual(this.queryEmbedding, similaritySearchResult.queryEmbedding) && Intrinsics.areEqual(this.matches, similaritySearchResult.matches);
    }

    public final List<SimilarCard> getMatches() {
        return this.matches;
    }

    public final float[] getQueryEmbedding() {
        return this.queryEmbedding;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.queryEmbedding) * 31) + this.matches.hashCode();
    }

    public String toString() {
        return "SimilaritySearchResult(queryEmbedding=" + Arrays.toString(this.queryEmbedding) + ", matches=" + this.matches + ")";
    }
}
