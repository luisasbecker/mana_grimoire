package com.studiolaganne.lengendarylens;

import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardRecommendationsPagerActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\b\u0007\u0018\u00002\u00020\u0001BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001dR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001d¨\u00069"}, d2 = {"Lcom/studiolaganne/lengendarylens/PagerPaginationState;", "", "deckId", "", "categoryKey", "", "currentPage", "hasMorePages", "", "total", "userId", "latestCards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "mode", "searchScryfall", "searchName", "searchOrderBy", "searchOrderDirection", "searchSimilarTo", "searchSimilarMode", "searchFillGap", "fromCollection", AndroidContextPlugin.LOCALE_KEY, "<init>", "(ILjava/lang/String;IZLjava/lang/Integer;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getDeckId", "()I", "getCategoryKey", "()Ljava/lang/String;", "getCurrentPage", "setCurrentPage", "(I)V", "getHasMorePages", "()Z", "setHasMorePages", "(Z)V", "getTotal", "()Ljava/lang/Integer;", "setTotal", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUserId", "getLatestCards", "()Ljava/util/List;", "setLatestCards", "(Ljava/util/List;)V", "getMode", "getSearchScryfall", "getSearchName", "getSearchOrderBy", "getSearchOrderDirection", "getSearchSimilarTo", "getSearchSimilarMode", "getSearchFillGap", "getFromCollection", "getLocale", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PagerPaginationState {
    public static final int $stable = 8;
    private final String categoryKey;
    private int currentPage;
    private final int deckId;
    private final boolean fromCollection;
    private boolean hasMorePages;
    private List<MTFullCard> latestCards;
    private final String locale;
    private final String mode;
    private final String searchFillGap;
    private final String searchName;
    private final String searchOrderBy;
    private final String searchOrderDirection;
    private final String searchScryfall;
    private final String searchSimilarMode;
    private final String searchSimilarTo;
    private Integer total;
    private final int userId;

    public PagerPaginationState() {
        this(0, null, 0, false, null, 0, null, null, null, null, null, null, null, null, null, false, null, 131071, null);
    }

    public PagerPaginationState(int i, String categoryKey, int i2, boolean z, Integer num, int i3, List<MTFullCard> list, String mode, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z2, String locale) {
        Intrinsics.checkNotNullParameter(categoryKey, "categoryKey");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.deckId = i;
        this.categoryKey = categoryKey;
        this.currentPage = i2;
        this.hasMorePages = z;
        this.total = num;
        this.userId = i3;
        this.latestCards = list;
        this.mode = mode;
        this.searchScryfall = str;
        this.searchName = str2;
        this.searchOrderBy = str3;
        this.searchOrderDirection = str4;
        this.searchSimilarTo = str5;
        this.searchSimilarMode = str6;
        this.searchFillGap = str7;
        this.fromCollection = z2;
        this.locale = locale;
    }

    public /* synthetic */ PagerPaginationState(int i, String str, int i2, boolean z, Integer num, int i3, List list, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 1 : i2, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? null : num, (i4 & 32) == 0 ? i3 : -1, (i4 & 64) != 0 ? null : list, (i4 & 128) != 0 ? "recommendations" : str2, (i4 & 256) != 0 ? null : str3, (i4 & 512) != 0 ? null : str4, (i4 & 1024) != 0 ? null : str5, (i4 & 2048) != 0 ? null : str6, (i4 & 4096) != 0 ? null : str7, (i4 & 8192) != 0 ? null : str8, (i4 & 16384) != 0 ? null : str9, (i4 & 32768) != 0 ? false : z2, (i4 & 65536) != 0 ? "" : str10);
    }

    public final String getCategoryKey() {
        return this.categoryKey;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final int getDeckId() {
        return this.deckId;
    }

    public final boolean getFromCollection() {
        return this.fromCollection;
    }

    public final boolean getHasMorePages() {
        return this.hasMorePages;
    }

    public final List<MTFullCard> getLatestCards() {
        return this.latestCards;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getSearchFillGap() {
        return this.searchFillGap;
    }

    public final String getSearchName() {
        return this.searchName;
    }

    public final String getSearchOrderBy() {
        return this.searchOrderBy;
    }

    public final String getSearchOrderDirection() {
        return this.searchOrderDirection;
    }

    public final String getSearchScryfall() {
        return this.searchScryfall;
    }

    public final String getSearchSimilarMode() {
        return this.searchSimilarMode;
    }

    public final String getSearchSimilarTo() {
        return this.searchSimilarTo;
    }

    public final Integer getTotal() {
        return this.total;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public final void setHasMorePages(boolean z) {
        this.hasMorePages = z;
    }

    public final void setLatestCards(List<MTFullCard> list) {
        this.latestCards = list;
    }

    public final void setTotal(Integer num) {
        this.total = num;
    }
}
