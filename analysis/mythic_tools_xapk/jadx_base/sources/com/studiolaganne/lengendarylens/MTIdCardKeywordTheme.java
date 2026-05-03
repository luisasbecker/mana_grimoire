package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J6\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardKeywordTheme;", "", "keyword", "", "count", "", "cards", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getKeyword", "()Ljava/lang/String;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCards", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardKeywordTheme;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardKeywordTheme {
    public static final int $stable = 8;
    private final List<String> cards;
    private final Integer count;
    private final String keyword;

    public MTIdCardKeywordTheme() {
        this(null, null, null, 7, null);
    }

    public MTIdCardKeywordTheme(String str, Integer num, List<String> cards) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        this.keyword = str;
        this.count = num;
        this.cards = cards;
    }

    public /* synthetic */ MTIdCardKeywordTheme(String str, Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardKeywordTheme copy$default(MTIdCardKeywordTheme mTIdCardKeywordTheme, String str, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardKeywordTheme.keyword;
        }
        if ((i & 2) != 0) {
            num = mTIdCardKeywordTheme.count;
        }
        if ((i & 4) != 0) {
            list = mTIdCardKeywordTheme.cards;
        }
        return mTIdCardKeywordTheme.copy(str, num, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKeyword() {
        return this.keyword;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    public final List<String> component3() {
        return this.cards;
    }

    public final MTIdCardKeywordTheme copy(String keyword, Integer count, List<String> cards) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        return new MTIdCardKeywordTheme(keyword, count, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardKeywordTheme)) {
            return false;
        }
        MTIdCardKeywordTheme mTIdCardKeywordTheme = (MTIdCardKeywordTheme) other;
        return Intrinsics.areEqual(this.keyword, mTIdCardKeywordTheme.keyword) && Intrinsics.areEqual(this.count, mTIdCardKeywordTheme.count) && Intrinsics.areEqual(this.cards, mTIdCardKeywordTheme.cards);
    }

    public final List<String> getCards() {
        return this.cards;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public int hashCode() {
        String str = this.keyword;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.count;
        return ((iHashCode + (num != null ? num.hashCode() : 0)) * 31) + this.cards.hashCode();
    }

    public String toString() {
        return "MTIdCardKeywordTheme(keyword=" + this.keyword + ", count=" + this.count + ", cards=" + this.cards + ")";
    }
}
