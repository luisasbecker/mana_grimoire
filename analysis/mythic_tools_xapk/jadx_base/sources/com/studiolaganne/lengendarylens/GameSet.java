package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/GameSet;", "", "version", "", "bestOf", "", "finishedGames", "", "Lcom/studiolaganne/lengendarylens/GameState;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getBestOf", "()I", "setBestOf", "(I)V", "getFinishedGames", "()Ljava/util/List;", "setFinishedGames", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GameSet {
    public static final int $stable = 8;
    private int bestOf;
    private List<GameState> finishedGames;
    private String version;

    public GameSet() {
        this(null, 0, null, 7, null);
    }

    public GameSet(String version, int i, List<GameState> finishedGames) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(finishedGames, "finishedGames");
        this.version = version;
        this.bestOf = i;
        this.finishedGames = finishedGames;
    }

    public /* synthetic */ GameSet(String str, int i, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "v1" : str, (i2 & 2) != 0 ? 3 : i, (i2 & 4) != 0 ? new ArrayList() : arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameSet copy$default(GameSet gameSet, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gameSet.version;
        }
        if ((i2 & 2) != 0) {
            i = gameSet.bestOf;
        }
        if ((i2 & 4) != 0) {
            list = gameSet.finishedGames;
        }
        return gameSet.copy(str, i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBestOf() {
        return this.bestOf;
    }

    public final List<GameState> component3() {
        return this.finishedGames;
    }

    public final GameSet copy(String version, int bestOf, List<GameState> finishedGames) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(finishedGames, "finishedGames");
        return new GameSet(version, bestOf, finishedGames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameSet)) {
            return false;
        }
        GameSet gameSet = (GameSet) other;
        return Intrinsics.areEqual(this.version, gameSet.version) && this.bestOf == gameSet.bestOf && Intrinsics.areEqual(this.finishedGames, gameSet.finishedGames);
    }

    public final int getBestOf() {
        return this.bestOf;
    }

    public final List<GameState> getFinishedGames() {
        return this.finishedGames;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((this.version.hashCode() * 31) + Integer.hashCode(this.bestOf)) * 31) + this.finishedGames.hashCode();
    }

    public final void setBestOf(int i) {
        this.bestOf = i;
    }

    public final void setFinishedGames(List<GameState> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.finishedGames = list;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "GameSet(version=" + this.version + ", bestOf=" + this.bestOf + ", finishedGames=" + this.finishedGames + ")";
    }
}
