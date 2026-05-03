package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CardSearchViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchPaginationState;", "", "currentPage", "", "totalResults", "hasMorePages", "", "isLoading", "<init>", "(IIZZ)V", "getCurrentPage", "()I", "getTotalResults", "getHasMorePages", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SearchPaginationState {
    public static final int $stable = 0;
    private final int currentPage;
    private final boolean hasMorePages;
    private final boolean isLoading;
    private final int totalResults;

    public SearchPaginationState() {
        this(0, 0, false, false, 15, null);
    }

    public SearchPaginationState(int i, int i2, boolean z, boolean z2) {
        this.currentPage = i;
        this.totalResults = i2;
        this.hasMorePages = z;
        this.isLoading = z2;
    }

    public /* synthetic */ SearchPaginationState(int i, int i2, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2);
    }

    public static /* synthetic */ SearchPaginationState copy$default(SearchPaginationState searchPaginationState, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = searchPaginationState.currentPage;
        }
        if ((i3 & 2) != 0) {
            i2 = searchPaginationState.totalResults;
        }
        if ((i3 & 4) != 0) {
            z = searchPaginationState.hasMorePages;
        }
        if ((i3 & 8) != 0) {
            z2 = searchPaginationState.isLoading;
        }
        return searchPaginationState.copy(i, i2, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCurrentPage() {
        return this.currentPage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotalResults() {
        return this.totalResults;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasMorePages() {
        return this.hasMorePages;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final SearchPaginationState copy(int currentPage, int totalResults, boolean hasMorePages, boolean isLoading) {
        return new SearchPaginationState(currentPage, totalResults, hasMorePages, isLoading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchPaginationState)) {
            return false;
        }
        SearchPaginationState searchPaginationState = (SearchPaginationState) other;
        return this.currentPage == searchPaginationState.currentPage && this.totalResults == searchPaginationState.totalResults && this.hasMorePages == searchPaginationState.hasMorePages && this.isLoading == searchPaginationState.isLoading;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final boolean getHasMorePages() {
        return this.hasMorePages;
    }

    public final int getTotalResults() {
        return this.totalResults;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.currentPage) * 31) + Integer.hashCode(this.totalResults)) * 31) + Boolean.hashCode(this.hasMorePages)) * 31) + Boolean.hashCode(this.isLoading);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "SearchPaginationState(currentPage=" + this.currentPage + ", totalResults=" + this.totalResults + ", hasMorePages=" + this.hasMorePages + ", isLoading=" + this.isLoading + ")";
    }
}
