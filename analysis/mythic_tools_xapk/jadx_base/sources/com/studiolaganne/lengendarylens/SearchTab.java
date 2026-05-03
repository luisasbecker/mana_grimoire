package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchTabManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b1\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010:\u001a\u00020\u000fHÆ\u0003J\t\u0010;\u001a\u00020\u0011HÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003Ju\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011HÆ\u0001J\u0013\u0010>\u001a\u00020\u00112\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u000fHÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0016\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0019R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0012\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100¨\u0006B"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchTab;", "", "id", "", Constants.ScionAnalytics.PARAM_LABEL, NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/studiolaganne/lengendarylens/SearchTabParams;", "orderBy", "orderDirection", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "pagination", "Lcom/studiolaganne/lengendarylens/MTPagination;", "scrollPosition", "", "isLoading", "", "needsRefresh", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/SearchTabParams;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTPagination;IZZ)V", "getId", "()Ljava/lang/String;", "getLabel", "setLabel", "(Ljava/lang/String;)V", "getParams", "()Lcom/studiolaganne/lengendarylens/SearchTabParams;", "setParams", "(Lcom/studiolaganne/lengendarylens/SearchTabParams;)V", "getOrderBy", "setOrderBy", "getOrderDirection", "setOrderDirection", "getCards", "()Ljava/util/List;", "setCards", "(Ljava/util/List;)V", "getPagination", "()Lcom/studiolaganne/lengendarylens/MTPagination;", "setPagination", "(Lcom/studiolaganne/lengendarylens/MTPagination;)V", "getScrollPosition", "()I", "setScrollPosition", "(I)V", "()Z", "setLoading", "(Z)V", "getNeedsRefresh", "setNeedsRefresh", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SearchTab {
    public static final int $stable = 8;
    private transient List<MTFullCard> cards;
    private final String id;
    private transient boolean isLoading;
    private String label;
    private transient boolean needsRefresh;
    private String orderBy;
    private String orderDirection;
    private transient MTPagination pagination;
    private SearchTabParams params;
    private transient int scrollPosition;

    public SearchTab() {
        this(null, null, null, null, null, null, null, 0, false, false, 1023, null);
    }

    public SearchTab(String id, String label, SearchTabParams params, String orderBy, String orderDirection, List<MTFullCard> cards, MTPagination mTPagination, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(orderBy, "orderBy");
        Intrinsics.checkNotNullParameter(orderDirection, "orderDirection");
        Intrinsics.checkNotNullParameter(cards, "cards");
        this.id = id;
        this.label = label;
        this.params = params;
        this.orderBy = orderBy;
        this.orderDirection = orderDirection;
        this.cards = cards;
        this.pagination = mTPagination;
        this.scrollPosition = i;
        this.isLoading = z;
        this.needsRefresh = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SearchTab(String str, String str2, SearchTabParams searchTabParams, String str3, String str4, List list, MTPagination mTPagination, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        }
        this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? new SearchTabParams(null, null, null, null, null, null, 63, null) : searchTabParams, (i2 & 8) != 0 ? "relevance" : str3, (i2 & 16) != 0 ? "desc" : str4, (i2 & 32) != 0 ? new ArrayList() : list, (i2 & 64) != 0 ? null : mTPagination, (i2 & 128) != 0 ? 0 : i, (i2 & 256) == 0 ? z : false, (i2 & 512) != 0 ? true : z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchTab copy$default(SearchTab searchTab, String str, String str2, SearchTabParams searchTabParams, String str3, String str4, List list, MTPagination mTPagination, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = searchTab.id;
        }
        if ((i2 & 2) != 0) {
            str2 = searchTab.label;
        }
        if ((i2 & 4) != 0) {
            searchTabParams = searchTab.params;
        }
        if ((i2 & 8) != 0) {
            str3 = searchTab.orderBy;
        }
        if ((i2 & 16) != 0) {
            str4 = searchTab.orderDirection;
        }
        if ((i2 & 32) != 0) {
            list = searchTab.cards;
        }
        if ((i2 & 64) != 0) {
            mTPagination = searchTab.pagination;
        }
        if ((i2 & 128) != 0) {
            i = searchTab.scrollPosition;
        }
        if ((i2 & 256) != 0) {
            z = searchTab.isLoading;
        }
        if ((i2 & 512) != 0) {
            z2 = searchTab.needsRefresh;
        }
        boolean z3 = z;
        boolean z4 = z2;
        MTPagination mTPagination2 = mTPagination;
        int i3 = i;
        String str5 = str4;
        List list2 = list;
        return searchTab.copy(str, str2, searchTabParams, str3, str5, list2, mTPagination2, i3, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getNeedsRefresh() {
        return this.needsRefresh;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SearchTabParams getParams() {
        return this.params;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOrderBy() {
        return this.orderBy;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOrderDirection() {
        return this.orderDirection;
    }

    public final List<MTFullCard> component6() {
        return this.cards;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTPagination getPagination() {
        return this.pagination;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getScrollPosition() {
        return this.scrollPosition;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final SearchTab copy(String id, String label, SearchTabParams params, String orderBy, String orderDirection, List<MTFullCard> cards, MTPagination pagination, int scrollPosition, boolean isLoading, boolean needsRefresh) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(orderBy, "orderBy");
        Intrinsics.checkNotNullParameter(orderDirection, "orderDirection");
        Intrinsics.checkNotNullParameter(cards, "cards");
        return new SearchTab(id, label, params, orderBy, orderDirection, cards, pagination, scrollPosition, isLoading, needsRefresh);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchTab)) {
            return false;
        }
        SearchTab searchTab = (SearchTab) other;
        return Intrinsics.areEqual(this.id, searchTab.id) && Intrinsics.areEqual(this.label, searchTab.label) && Intrinsics.areEqual(this.params, searchTab.params) && Intrinsics.areEqual(this.orderBy, searchTab.orderBy) && Intrinsics.areEqual(this.orderDirection, searchTab.orderDirection) && Intrinsics.areEqual(this.cards, searchTab.cards) && Intrinsics.areEqual(this.pagination, searchTab.pagination) && this.scrollPosition == searchTab.scrollPosition && this.isLoading == searchTab.isLoading && this.needsRefresh == searchTab.needsRefresh;
    }

    public final List<MTFullCard> getCards() {
        return this.cards;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final boolean getNeedsRefresh() {
        return this.needsRefresh;
    }

    public final String getOrderBy() {
        return this.orderBy;
    }

    public final String getOrderDirection() {
        return this.orderDirection;
    }

    public final MTPagination getPagination() {
        return this.pagination;
    }

    public final SearchTabParams getParams() {
        return this.params;
    }

    public final int getScrollPosition() {
        return this.scrollPosition;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + this.label.hashCode()) * 31) + this.params.hashCode()) * 31) + this.orderBy.hashCode()) * 31) + this.orderDirection.hashCode()) * 31) + this.cards.hashCode()) * 31;
        MTPagination mTPagination = this.pagination;
        return ((((((iHashCode + (mTPagination == null ? 0 : mTPagination.hashCode())) * 31) + Integer.hashCode(this.scrollPosition)) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.needsRefresh);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void setCards(List<MTFullCard> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cards = list;
    }

    public final void setLabel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.label = str;
    }

    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    public final void setNeedsRefresh(boolean z) {
        this.needsRefresh = z;
    }

    public final void setOrderBy(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderBy = str;
    }

    public final void setOrderDirection(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderDirection = str;
    }

    public final void setPagination(MTPagination mTPagination) {
        this.pagination = mTPagination;
    }

    public final void setParams(SearchTabParams searchTabParams) {
        Intrinsics.checkNotNullParameter(searchTabParams, "<set-?>");
        this.params = searchTabParams;
    }

    public final void setScrollPosition(int i) {
        this.scrollPosition = i;
    }

    public String toString() {
        return "SearchTab(id=" + this.id + ", label=" + this.label + ", params=" + this.params + ", orderBy=" + this.orderBy + ", orderDirection=" + this.orderDirection + ", cards=" + this.cards + ", pagination=" + this.pagination + ", scrollPosition=" + this.scrollPosition + ", isLoading=" + this.isLoading + ", needsRefresh=" + this.needsRefresh + ")";
    }
}
