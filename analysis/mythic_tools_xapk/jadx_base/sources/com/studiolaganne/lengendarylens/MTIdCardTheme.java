package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u0082\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\nHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardTheme;", "", "themeId", "", "themeName", "themeNameFr", "classification", "matchScore", "", "totalCards", "", FirebaseAnalytics.Param.SCORE, "matchedTags", "", "cards", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;)V", "getThemeId", "()Ljava/lang/String;", "getThemeName", "getThemeNameFr", "getClassification", "getMatchScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTotalCards", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScore", "getMatchedTags", "()Ljava/util/List;", "getCards", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardTheme;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardTheme {
    public static final int $stable = 8;
    private final List<String> cards;
    private final String classification;
    private final Double matchScore;
    private final List<String> matchedTags;
    private final Double score;
    private final String themeId;
    private final String themeName;
    private final String themeNameFr;
    private final Integer totalCards;

    public MTIdCardTheme() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public MTIdCardTheme(String str, String str2, String str3, String str4, Double d, Integer num, Double d2, List<String> matchedTags, List<String> cards) {
        Intrinsics.checkNotNullParameter(matchedTags, "matchedTags");
        Intrinsics.checkNotNullParameter(cards, "cards");
        this.themeId = str;
        this.themeName = str2;
        this.themeNameFr = str3;
        this.classification = str4;
        this.matchScore = d;
        this.totalCards = num;
        this.score = d2;
        this.matchedTags = matchedTags;
        this.cards = cards;
    }

    public /* synthetic */ MTIdCardTheme(String str, String str2, String str3, String str4, Double d, Integer num, Double d2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : d, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : d2, (i & 128) != 0 ? CollectionsKt.emptyList() : list, (i & 256) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardTheme copy$default(MTIdCardTheme mTIdCardTheme, String str, String str2, String str3, String str4, Double d, Integer num, Double d2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardTheme.themeId;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardTheme.themeName;
        }
        if ((i & 4) != 0) {
            str3 = mTIdCardTheme.themeNameFr;
        }
        if ((i & 8) != 0) {
            str4 = mTIdCardTheme.classification;
        }
        if ((i & 16) != 0) {
            d = mTIdCardTheme.matchScore;
        }
        if ((i & 32) != 0) {
            num = mTIdCardTheme.totalCards;
        }
        if ((i & 64) != 0) {
            d2 = mTIdCardTheme.score;
        }
        if ((i & 128) != 0) {
            list = mTIdCardTheme.matchedTags;
        }
        if ((i & 256) != 0) {
            list2 = mTIdCardTheme.cards;
        }
        List list3 = list;
        List list4 = list2;
        Integer num2 = num;
        Double d3 = d2;
        Double d4 = d;
        String str5 = str3;
        return mTIdCardTheme.copy(str, str2, str5, str4, d4, num2, d3, list3, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getThemeId() {
        return this.themeId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThemeName() {
        return this.themeName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getThemeNameFr() {
        return this.themeNameFr;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClassification() {
        return this.classification;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getMatchScore() {
        return this.matchScore;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getTotalCards() {
        return this.totalCards;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getScore() {
        return this.score;
    }

    public final List<String> component8() {
        return this.matchedTags;
    }

    public final List<String> component9() {
        return this.cards;
    }

    public final MTIdCardTheme copy(String themeId, String themeName, String themeNameFr, String classification, Double matchScore, Integer totalCards, Double score, List<String> matchedTags, List<String> cards) {
        Intrinsics.checkNotNullParameter(matchedTags, "matchedTags");
        Intrinsics.checkNotNullParameter(cards, "cards");
        return new MTIdCardTheme(themeId, themeName, themeNameFr, classification, matchScore, totalCards, score, matchedTags, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardTheme)) {
            return false;
        }
        MTIdCardTheme mTIdCardTheme = (MTIdCardTheme) other;
        return Intrinsics.areEqual(this.themeId, mTIdCardTheme.themeId) && Intrinsics.areEqual(this.themeName, mTIdCardTheme.themeName) && Intrinsics.areEqual(this.themeNameFr, mTIdCardTheme.themeNameFr) && Intrinsics.areEqual(this.classification, mTIdCardTheme.classification) && Intrinsics.areEqual((Object) this.matchScore, (Object) mTIdCardTheme.matchScore) && Intrinsics.areEqual(this.totalCards, mTIdCardTheme.totalCards) && Intrinsics.areEqual((Object) this.score, (Object) mTIdCardTheme.score) && Intrinsics.areEqual(this.matchedTags, mTIdCardTheme.matchedTags) && Intrinsics.areEqual(this.cards, mTIdCardTheme.cards);
    }

    public final List<String> getCards() {
        return this.cards;
    }

    public final String getClassification() {
        return this.classification;
    }

    public final Double getMatchScore() {
        return this.matchScore;
    }

    public final List<String> getMatchedTags() {
        return this.matchedTags;
    }

    public final Double getScore() {
        return this.score;
    }

    public final String getThemeId() {
        return this.themeId;
    }

    public final String getThemeName() {
        return this.themeName;
    }

    public final String getThemeNameFr() {
        return this.themeNameFr;
    }

    public final Integer getTotalCards() {
        return this.totalCards;
    }

    public int hashCode() {
        String str = this.themeId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.themeName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.themeNameFr;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.classification;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d = this.matchScore;
        int iHashCode5 = (iHashCode4 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num = this.totalCards;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Double d2 = this.score;
        return ((((iHashCode6 + (d2 != null ? d2.hashCode() : 0)) * 31) + this.matchedTags.hashCode()) * 31) + this.cards.hashCode();
    }

    public String toString() {
        return "MTIdCardTheme(themeId=" + this.themeId + ", themeName=" + this.themeName + ", themeNameFr=" + this.themeNameFr + ", classification=" + this.classification + ", matchScore=" + this.matchScore + ", totalCards=" + this.totalCards + ", score=" + this.score + ", matchedTags=" + this.matchedTags + ", cards=" + this.cards + ")";
    }
}
