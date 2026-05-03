package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCreateSet;", "", "bestof", "", "games", "", "Lcom/studiolaganne/lengendarylens/MTCreateGame;", "<init>", "(ILjava/util/List;)V", "getBestof", "()I", "setBestof", "(I)V", "getGames", "()Ljava/util/List;", "setGames", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCreateSet {
    public static final int $stable = 8;
    private int bestof;
    private List<MTCreateGame> games;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCreateSet() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public MTCreateSet(int i, List<MTCreateGame> games) {
        Intrinsics.checkNotNullParameter(games, "games");
        this.bestof = i;
        this.games = games;
    }

    public /* synthetic */ MTCreateSet(int i, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? new ArrayList() : arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCreateSet copy$default(MTCreateSet mTCreateSet, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTCreateSet.bestof;
        }
        if ((i2 & 2) != 0) {
            list = mTCreateSet.games;
        }
        return mTCreateSet.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBestof() {
        return this.bestof;
    }

    public final List<MTCreateGame> component2() {
        return this.games;
    }

    public final MTCreateSet copy(int bestof, List<MTCreateGame> games) {
        Intrinsics.checkNotNullParameter(games, "games");
        return new MTCreateSet(bestof, games);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCreateSet)) {
            return false;
        }
        MTCreateSet mTCreateSet = (MTCreateSet) other;
        return this.bestof == mTCreateSet.bestof && Intrinsics.areEqual(this.games, mTCreateSet.games);
    }

    public final int getBestof() {
        return this.bestof;
    }

    public final List<MTCreateGame> getGames() {
        return this.games;
    }

    public int hashCode() {
        return (Integer.hashCode(this.bestof) * 31) + this.games.hashCode();
    }

    public final void setBestof(int i) {
        this.bestof = i;
    }

    public final void setGames(List<MTCreateGame> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.games = list;
    }

    public String toString() {
        return "MTCreateSet(bestof=" + this.bestof + ", games=" + this.games + ")";
    }
}
