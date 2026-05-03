package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CombinedAnalyzer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/TitleComparison;", "", "language", "", "similarity", "", "<init>", "(Ljava/lang/String;D)V", "getLanguage", "()Ljava/lang/String;", "getSimilarity", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TitleComparison {
    public static final int $stable = 0;
    private final String language;
    private final double similarity;

    public TitleComparison(String language, double d) {
        Intrinsics.checkNotNullParameter(language, "language");
        this.language = language;
        this.similarity = d;
    }

    public static /* synthetic */ TitleComparison copy$default(TitleComparison titleComparison, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = titleComparison.language;
        }
        if ((i & 2) != 0) {
            d = titleComparison.similarity;
        }
        return titleComparison.copy(str, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getSimilarity() {
        return this.similarity;
    }

    public final TitleComparison copy(String language, double similarity) {
        Intrinsics.checkNotNullParameter(language, "language");
        return new TitleComparison(language, similarity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleComparison)) {
            return false;
        }
        TitleComparison titleComparison = (TitleComparison) other;
        return Intrinsics.areEqual(this.language, titleComparison.language) && Double.compare(this.similarity, titleComparison.similarity) == 0;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final double getSimilarity() {
        return this.similarity;
    }

    public int hashCode() {
        return (this.language.hashCode() * 31) + Double.hashCode(this.similarity);
    }

    public String toString() {
        return "TitleComparison(language=" + this.language + ", similarity=" + this.similarity + ")";
    }
}
