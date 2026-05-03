package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTThemesResponse;", "", "themes", "", "Lcom/studiolaganne/lengendarylens/MTTheme;", "<init>", "(Ljava/util/List;)V", "getThemes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTThemesResponse {
    public static final int $stable = 8;
    private final List<MTTheme> themes;

    /* JADX WARN: Multi-variable type inference failed */
    public MTThemesResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTThemesResponse(List<MTTheme> themes) {
        Intrinsics.checkNotNullParameter(themes, "themes");
        this.themes = themes;
    }

    public /* synthetic */ MTThemesResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTThemesResponse copy$default(MTThemesResponse mTThemesResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTThemesResponse.themes;
        }
        return mTThemesResponse.copy(list);
    }

    public final List<MTTheme> component1() {
        return this.themes;
    }

    public final MTThemesResponse copy(List<MTTheme> themes) {
        Intrinsics.checkNotNullParameter(themes, "themes");
        return new MTThemesResponse(themes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTThemesResponse) && Intrinsics.areEqual(this.themes, ((MTThemesResponse) other).themes);
    }

    public final List<MTTheme> getThemes() {
        return this.themes;
    }

    public int hashCode() {
        return this.themes.hashCode();
    }

    public String toString() {
        return "MTThemesResponse(themes=" + this.themes + ")";
    }
}
