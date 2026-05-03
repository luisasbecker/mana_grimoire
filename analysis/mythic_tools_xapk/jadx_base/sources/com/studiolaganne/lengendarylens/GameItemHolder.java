package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GamesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J]\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00103\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00067"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameItemHolder;", "", "type", "", "game", "Lcom/studiolaganne/lengendarylens/MTGame;", "set", "Lcom/studiolaganne/lengendarylens/MTSet;", "bestof", "subgames", "", "separator", "", "expanded", "", "<init>", "(ILcom/studiolaganne/lengendarylens/MTGame;Lcom/studiolaganne/lengendarylens/MTSet;ILjava/util/List;Ljava/lang/String;Z)V", "getType", "()I", "setType", "(I)V", "getGame", "()Lcom/studiolaganne/lengendarylens/MTGame;", "setGame", "(Lcom/studiolaganne/lengendarylens/MTGame;)V", "getSet", "()Lcom/studiolaganne/lengendarylens/MTSet;", "setSet", "(Lcom/studiolaganne/lengendarylens/MTSet;)V", "getBestof", "setBestof", "getSubgames", "()Ljava/util/List;", "setSubgames", "(Ljava/util/List;)V", "getSeparator", "()Ljava/lang/String;", "setSeparator", "(Ljava/lang/String;)V", "getExpanded", "()Z", "setExpanded", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GameItemHolder {
    public static final int $stable = 8;
    private int bestof;
    private boolean expanded;
    private MTGame game;
    private String separator;
    private MTSet set;
    private List<MTGame> subgames;
    private int type;

    public GameItemHolder() {
        this(0, null, null, 0, null, null, false, 127, null);
    }

    public GameItemHolder(int i, MTGame mTGame, MTSet mTSet, int i2, List<MTGame> list, String str, boolean z) {
        this.type = i;
        this.game = mTGame;
        this.set = mTSet;
        this.bestof = i2;
        this.subgames = list;
        this.separator = str;
        this.expanded = z;
    }

    public /* synthetic */ GameItemHolder(int i, MTGame mTGame, MTSet mTSet, int i2, ArrayList arrayList, String str, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? null : mTGame, (i3 & 4) != 0 ? null : mTSet, (i3 & 8) != 0 ? 1 : i2, (i3 & 16) != 0 ? new ArrayList() : arrayList, (i3 & 32) != 0 ? null : str, (i3 & 64) != 0 ? false : z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameItemHolder copy$default(GameItemHolder gameItemHolder, int i, MTGame mTGame, MTSet mTSet, int i2, List list, String str, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = gameItemHolder.type;
        }
        if ((i3 & 2) != 0) {
            mTGame = gameItemHolder.game;
        }
        if ((i3 & 4) != 0) {
            mTSet = gameItemHolder.set;
        }
        if ((i3 & 8) != 0) {
            i2 = gameItemHolder.bestof;
        }
        if ((i3 & 16) != 0) {
            list = gameItemHolder.subgames;
        }
        if ((i3 & 32) != 0) {
            str = gameItemHolder.separator;
        }
        if ((i3 & 64) != 0) {
            z = gameItemHolder.expanded;
        }
        String str2 = str;
        boolean z2 = z;
        List list2 = list;
        MTSet mTSet2 = mTSet;
        return gameItemHolder.copy(i, mTGame, mTSet2, i2, list2, str2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTGame getGame() {
        return this.game;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTSet getSet() {
        return this.set;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBestof() {
        return this.bestof;
    }

    public final List<MTGame> component5() {
        return this.subgames;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSeparator() {
        return this.separator;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getExpanded() {
        return this.expanded;
    }

    public final GameItemHolder copy(int type, MTGame game, MTSet set, int bestof, List<MTGame> subgames, String separator, boolean expanded) {
        return new GameItemHolder(type, game, set, bestof, subgames, separator, expanded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameItemHolder)) {
            return false;
        }
        GameItemHolder gameItemHolder = (GameItemHolder) other;
        return this.type == gameItemHolder.type && Intrinsics.areEqual(this.game, gameItemHolder.game) && Intrinsics.areEqual(this.set, gameItemHolder.set) && this.bestof == gameItemHolder.bestof && Intrinsics.areEqual(this.subgames, gameItemHolder.subgames) && Intrinsics.areEqual(this.separator, gameItemHolder.separator) && this.expanded == gameItemHolder.expanded;
    }

    public final int getBestof() {
        return this.bestof;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    public final MTGame getGame() {
        return this.game;
    }

    public final String getSeparator() {
        return this.separator;
    }

    public final MTSet getSet() {
        return this.set;
    }

    public final List<MTGame> getSubgames() {
        return this.subgames;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.type) * 31;
        MTGame mTGame = this.game;
        int iHashCode2 = (iHashCode + (mTGame == null ? 0 : mTGame.hashCode())) * 31;
        MTSet mTSet = this.set;
        int iHashCode3 = (((iHashCode2 + (mTSet == null ? 0 : mTSet.hashCode())) * 31) + Integer.hashCode(this.bestof)) * 31;
        List<MTGame> list = this.subgames;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.separator;
        return ((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.expanded);
    }

    public final void setBestof(int i) {
        this.bestof = i;
    }

    public final void setExpanded(boolean z) {
        this.expanded = z;
    }

    public final void setGame(MTGame mTGame) {
        this.game = mTGame;
    }

    public final void setSeparator(String str) {
        this.separator = str;
    }

    public final void setSet(MTSet mTSet) {
        this.set = mTSet;
    }

    public final void setSubgames(List<MTGame> list) {
        this.subgames = list;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "GameItemHolder(type=" + this.type + ", game=" + this.game + ", set=" + this.set + ", bestof=" + this.bestof + ", subgames=" + this.subgames + ", separator=" + this.separator + ", expanded=" + this.expanded + ")";
    }
}
