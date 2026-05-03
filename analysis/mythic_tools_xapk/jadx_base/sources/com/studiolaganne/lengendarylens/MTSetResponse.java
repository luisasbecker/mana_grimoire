package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSetResponse;", "", "id", "", "games", "", "Lcom/studiolaganne/lengendarylens/MTCreateGame;", "<init>", "(ILjava/util/List;)V", "getId", "()I", "getGames", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSetResponse {
    public static final int $stable = 8;
    private final List<MTCreateGame> games;
    private final int id;

    /* JADX WARN: Multi-variable type inference failed */
    public MTSetResponse() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public MTSetResponse(int i, List<MTCreateGame> games) {
        Intrinsics.checkNotNullParameter(games, "games");
        this.id = i;
        this.games = games;
    }

    public /* synthetic */ MTSetResponse(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTSetResponse copy$default(MTSetResponse mTSetResponse, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTSetResponse.id;
        }
        if ((i2 & 2) != 0) {
            list = mTSetResponse.games;
        }
        return mTSetResponse.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final List<MTCreateGame> component2() {
        return this.games;
    }

    public final MTSetResponse copy(int id, List<MTCreateGame> games) {
        Intrinsics.checkNotNullParameter(games, "games");
        return new MTSetResponse(id, games);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSetResponse)) {
            return false;
        }
        MTSetResponse mTSetResponse = (MTSetResponse) other;
        return this.id == mTSetResponse.id && Intrinsics.areEqual(this.games, mTSetResponse.games);
    }

    public final List<MTCreateGame> getGames() {
        return this.games;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + this.games.hashCode();
    }

    public String toString() {
        return "MTSetResponse(id=" + this.id + ", games=" + this.games + ")";
    }
}
