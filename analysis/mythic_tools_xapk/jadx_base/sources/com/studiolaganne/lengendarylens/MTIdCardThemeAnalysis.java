package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001By\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fHÆ\u0003J\u001d\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0018\u00010\fHÆ\u0003J\u0080\u0001\u0010\"\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\rHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardThemeAnalysis;", "", "themes", "", "Lcom/studiolaganne/lengendarylens/MTIdCardTheme;", "tribalThemes", "Lcom/studiolaganne/lengendarylens/MTIdCardTribalTheme;", "keywordThemes", "Lcom/studiolaganne/lengendarylens/MTIdCardKeywordTheme;", "synergyScore", "", "autoTags", "", "", "", "autoTagCards", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Double;Ljava/util/Map;Ljava/util/Map;)V", "getThemes", "()Ljava/util/List;", "getTribalThemes", "getKeywordThemes", "getSynergyScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAutoTags", "()Ljava/util/Map;", "getAutoTagCards", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Double;Ljava/util/Map;Ljava/util/Map;)Lcom/studiolaganne/lengendarylens/MTIdCardThemeAnalysis;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardThemeAnalysis {
    public static final int $stable = 8;
    private final Map<String, List<String>> autoTagCards;
    private final Map<String, Integer> autoTags;
    private final List<MTIdCardKeywordTheme> keywordThemes;
    private final Double synergyScore;
    private final List<MTIdCardTheme> themes;
    private final List<MTIdCardTribalTheme> tribalThemes;

    public MTIdCardThemeAnalysis() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MTIdCardThemeAnalysis(List<MTIdCardTheme> themes, List<MTIdCardTribalTheme> tribalThemes, List<MTIdCardKeywordTheme> keywordThemes, Double d, Map<String, Integer> map, Map<String, ? extends List<String>> map2) {
        Intrinsics.checkNotNullParameter(themes, "themes");
        Intrinsics.checkNotNullParameter(tribalThemes, "tribalThemes");
        Intrinsics.checkNotNullParameter(keywordThemes, "keywordThemes");
        this.themes = themes;
        this.tribalThemes = tribalThemes;
        this.keywordThemes = keywordThemes;
        this.synergyScore = d;
        this.autoTags = map;
        this.autoTagCards = map2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ MTIdCardThemeAnalysis(java.util.List r2, java.util.List r3, java.util.List r4, java.lang.Double r5, java.util.Map r6, java.util.Map r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L8
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r9 = r8 & 2
            if (r9 == 0) goto L10
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L10:
            r9 = r8 & 4
            if (r9 == 0) goto L18
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L18:
            r9 = r8 & 8
            r0 = 0
            if (r9 == 0) goto L1e
            r5 = r0
        L1e:
            r9 = r8 & 16
            if (r9 == 0) goto L23
            r6 = r0
        L23:
            r8 = r8 & 32
            if (r8 == 0) goto L2f
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L36
        L2f:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L36:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTIdCardThemeAnalysis.<init>(java.util.List, java.util.List, java.util.List, java.lang.Double, java.util.Map, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardThemeAnalysis copy$default(MTIdCardThemeAnalysis mTIdCardThemeAnalysis, List list, List list2, List list3, Double d, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTIdCardThemeAnalysis.themes;
        }
        if ((i & 2) != 0) {
            list2 = mTIdCardThemeAnalysis.tribalThemes;
        }
        if ((i & 4) != 0) {
            list3 = mTIdCardThemeAnalysis.keywordThemes;
        }
        if ((i & 8) != 0) {
            d = mTIdCardThemeAnalysis.synergyScore;
        }
        if ((i & 16) != 0) {
            map = mTIdCardThemeAnalysis.autoTags;
        }
        if ((i & 32) != 0) {
            map2 = mTIdCardThemeAnalysis.autoTagCards;
        }
        Map map3 = map;
        Map map4 = map2;
        return mTIdCardThemeAnalysis.copy(list, list2, list3, d, map3, map4);
    }

    public final List<MTIdCardTheme> component1() {
        return this.themes;
    }

    public final List<MTIdCardTribalTheme> component2() {
        return this.tribalThemes;
    }

    public final List<MTIdCardKeywordTheme> component3() {
        return this.keywordThemes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getSynergyScore() {
        return this.synergyScore;
    }

    public final Map<String, Integer> component5() {
        return this.autoTags;
    }

    public final Map<String, List<String>> component6() {
        return this.autoTagCards;
    }

    public final MTIdCardThemeAnalysis copy(List<MTIdCardTheme> themes, List<MTIdCardTribalTheme> tribalThemes, List<MTIdCardKeywordTheme> keywordThemes, Double synergyScore, Map<String, Integer> autoTags, Map<String, ? extends List<String>> autoTagCards) {
        Intrinsics.checkNotNullParameter(themes, "themes");
        Intrinsics.checkNotNullParameter(tribalThemes, "tribalThemes");
        Intrinsics.checkNotNullParameter(keywordThemes, "keywordThemes");
        return new MTIdCardThemeAnalysis(themes, tribalThemes, keywordThemes, synergyScore, autoTags, autoTagCards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardThemeAnalysis)) {
            return false;
        }
        MTIdCardThemeAnalysis mTIdCardThemeAnalysis = (MTIdCardThemeAnalysis) other;
        return Intrinsics.areEqual(this.themes, mTIdCardThemeAnalysis.themes) && Intrinsics.areEqual(this.tribalThemes, mTIdCardThemeAnalysis.tribalThemes) && Intrinsics.areEqual(this.keywordThemes, mTIdCardThemeAnalysis.keywordThemes) && Intrinsics.areEqual((Object) this.synergyScore, (Object) mTIdCardThemeAnalysis.synergyScore) && Intrinsics.areEqual(this.autoTags, mTIdCardThemeAnalysis.autoTags) && Intrinsics.areEqual(this.autoTagCards, mTIdCardThemeAnalysis.autoTagCards);
    }

    public final Map<String, List<String>> getAutoTagCards() {
        return this.autoTagCards;
    }

    public final Map<String, Integer> getAutoTags() {
        return this.autoTags;
    }

    public final List<MTIdCardKeywordTheme> getKeywordThemes() {
        return this.keywordThemes;
    }

    public final Double getSynergyScore() {
        return this.synergyScore;
    }

    public final List<MTIdCardTheme> getThemes() {
        return this.themes;
    }

    public final List<MTIdCardTribalTheme> getTribalThemes() {
        return this.tribalThemes;
    }

    public int hashCode() {
        int iHashCode = ((((this.themes.hashCode() * 31) + this.tribalThemes.hashCode()) * 31) + this.keywordThemes.hashCode()) * 31;
        Double d = this.synergyScore;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Map<String, Integer> map = this.autoTags;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, List<String>> map2 = this.autoTagCards;
        return iHashCode3 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardThemeAnalysis(themes=" + this.themes + ", tribalThemes=" + this.tribalThemes + ", keywordThemes=" + this.keywordThemes + ", synergyScore=" + this.synergyScore + ", autoTags=" + this.autoTags + ", autoTagCards=" + this.autoTagCards + ")";
    }
}
