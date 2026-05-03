package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEventPromoResponse;", "", "themes", "", "Lcom/studiolaganne/lengendarylens/MTTheme;", "trophies", "Lcom/studiolaganne/lengendarylens/MTTrophy;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getThemes", "()Ljava/util/List;", "setThemes", "(Ljava/util/List;)V", "getTrophies", "setTrophies", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTEventPromoResponse {
    public static final int $stable = 8;
    private List<MTTheme> themes;
    private List<MTTrophy> trophies;

    /* JADX WARN: Multi-variable type inference failed */
    public MTEventPromoResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTEventPromoResponse(List<MTTheme> list, List<MTTrophy> list2) {
        this.themes = list;
        this.trophies = list2;
    }

    public /* synthetic */ MTEventPromoResponse(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTEventPromoResponse copy$default(MTEventPromoResponse mTEventPromoResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTEventPromoResponse.themes;
        }
        if ((i & 2) != 0) {
            list2 = mTEventPromoResponse.trophies;
        }
        return mTEventPromoResponse.copy(list, list2);
    }

    public final List<MTTheme> component1() {
        return this.themes;
    }

    public final List<MTTrophy> component2() {
        return this.trophies;
    }

    public final MTEventPromoResponse copy(List<MTTheme> themes, List<MTTrophy> trophies) {
        return new MTEventPromoResponse(themes, trophies);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTEventPromoResponse)) {
            return false;
        }
        MTEventPromoResponse mTEventPromoResponse = (MTEventPromoResponse) other;
        return Intrinsics.areEqual(this.themes, mTEventPromoResponse.themes) && Intrinsics.areEqual(this.trophies, mTEventPromoResponse.trophies);
    }

    public final List<MTTheme> getThemes() {
        return this.themes;
    }

    public final List<MTTrophy> getTrophies() {
        return this.trophies;
    }

    public int hashCode() {
        List<MTTheme> list = this.themes;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTTrophy> list2 = this.trophies;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setThemes(List<MTTheme> list) {
        this.themes = list;
    }

    public final void setTrophies(List<MTTrophy> list) {
        this.trophies = list;
    }

    public String toString() {
        return "MTEventPromoResponse(themes=" + this.themes + ", trophies=" + this.trophies + ")";
    }
}
