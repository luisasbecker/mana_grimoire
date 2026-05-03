package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010!J\t\u0010.\u001a\u00020\fHÆ\u0003JZ\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\fHÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00067"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFavoriteSetup;", "", "format", "Lcom/studiolaganne/lengendarylens/MTGameFormat;", "subformat", "Lcom/studiolaganne/lengendarylens/MTGameSubformat;", "playgroup", "Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;", "players", "", "Lcom/studiolaganne/lengendarylens/MTFavoritePlayer;", "bestOf", "", "games", "<init>", "(Lcom/studiolaganne/lengendarylens/MTGameFormat;Lcom/studiolaganne/lengendarylens/MTGameSubformat;Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;Ljava/util/List;Ljava/lang/Integer;I)V", "getFormat", "()Lcom/studiolaganne/lengendarylens/MTGameFormat;", "setFormat", "(Lcom/studiolaganne/lengendarylens/MTGameFormat;)V", "getSubformat", "()Lcom/studiolaganne/lengendarylens/MTGameSubformat;", "setSubformat", "(Lcom/studiolaganne/lengendarylens/MTGameSubformat;)V", "getPlaygroup", "()Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;", "setPlaygroup", "(Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;)V", "getPlayers", "()Ljava/util/List;", "setPlayers", "(Ljava/util/List;)V", "getBestOf", "()Ljava/lang/Integer;", "setBestOf", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGames", "()I", "setGames", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/studiolaganne/lengendarylens/MTGameFormat;Lcom/studiolaganne/lengendarylens/MTGameSubformat;Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;Ljava/util/List;Ljava/lang/Integer;I)Lcom/studiolaganne/lengendarylens/MTFavoriteSetup;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTFavoriteSetup {
    public static final int $stable = 8;
    private Integer bestOf;
    private MTGameFormat format;
    private int games;
    private List<MTFavoritePlayer> players;
    private MTGamePlaygroup playgroup;
    private MTGameSubformat subformat;

    public MTFavoriteSetup() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public MTFavoriteSetup(MTGameFormat mTGameFormat, MTGameSubformat mTGameSubformat, MTGamePlaygroup mTGamePlaygroup, List<MTFavoritePlayer> players, Integer num, int i) {
        Intrinsics.checkNotNullParameter(players, "players");
        this.format = mTGameFormat;
        this.subformat = mTGameSubformat;
        this.playgroup = mTGamePlaygroup;
        this.players = players;
        this.bestOf = num;
        this.games = i;
    }

    public /* synthetic */ MTFavoriteSetup(MTGameFormat mTGameFormat, MTGameSubformat mTGameSubformat, MTGamePlaygroup mTGamePlaygroup, List list, Integer num, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : mTGameFormat, (i2 & 2) != 0 ? null : mTGameSubformat, (i2 & 4) != 0 ? null : mTGamePlaygroup, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTFavoriteSetup copy$default(MTFavoriteSetup mTFavoriteSetup, MTGameFormat mTGameFormat, MTGameSubformat mTGameSubformat, MTGamePlaygroup mTGamePlaygroup, List list, Integer num, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mTGameFormat = mTFavoriteSetup.format;
        }
        if ((i2 & 2) != 0) {
            mTGameSubformat = mTFavoriteSetup.subformat;
        }
        if ((i2 & 4) != 0) {
            mTGamePlaygroup = mTFavoriteSetup.playgroup;
        }
        if ((i2 & 8) != 0) {
            list = mTFavoriteSetup.players;
        }
        if ((i2 & 16) != 0) {
            num = mTFavoriteSetup.bestOf;
        }
        if ((i2 & 32) != 0) {
            i = mTFavoriteSetup.games;
        }
        Integer num2 = num;
        int i3 = i;
        return mTFavoriteSetup.copy(mTGameFormat, mTGameSubformat, mTGamePlaygroup, list, num2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTGameFormat getFormat() {
        return this.format;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTGameSubformat getSubformat() {
        return this.subformat;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTGamePlaygroup getPlaygroup() {
        return this.playgroup;
    }

    public final List<MTFavoritePlayer> component4() {
        return this.players;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getBestOf() {
        return this.bestOf;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getGames() {
        return this.games;
    }

    public final MTFavoriteSetup copy(MTGameFormat format, MTGameSubformat subformat, MTGamePlaygroup playgroup, List<MTFavoritePlayer> players, Integer bestOf, int games) {
        Intrinsics.checkNotNullParameter(players, "players");
        return new MTFavoriteSetup(format, subformat, playgroup, players, bestOf, games);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTFavoriteSetup)) {
            return false;
        }
        MTFavoriteSetup mTFavoriteSetup = (MTFavoriteSetup) other;
        return Intrinsics.areEqual(this.format, mTFavoriteSetup.format) && Intrinsics.areEqual(this.subformat, mTFavoriteSetup.subformat) && Intrinsics.areEqual(this.playgroup, mTFavoriteSetup.playgroup) && Intrinsics.areEqual(this.players, mTFavoriteSetup.players) && Intrinsics.areEqual(this.bestOf, mTFavoriteSetup.bestOf) && this.games == mTFavoriteSetup.games;
    }

    public final Integer getBestOf() {
        return this.bestOf;
    }

    public final MTGameFormat getFormat() {
        return this.format;
    }

    public final int getGames() {
        return this.games;
    }

    public final List<MTFavoritePlayer> getPlayers() {
        return this.players;
    }

    public final MTGamePlaygroup getPlaygroup() {
        return this.playgroup;
    }

    public final MTGameSubformat getSubformat() {
        return this.subformat;
    }

    public int hashCode() {
        MTGameFormat mTGameFormat = this.format;
        int iHashCode = (mTGameFormat == null ? 0 : mTGameFormat.hashCode()) * 31;
        MTGameSubformat mTGameSubformat = this.subformat;
        int iHashCode2 = (iHashCode + (mTGameSubformat == null ? 0 : mTGameSubformat.hashCode())) * 31;
        MTGamePlaygroup mTGamePlaygroup = this.playgroup;
        int iHashCode3 = (((iHashCode2 + (mTGamePlaygroup == null ? 0 : mTGamePlaygroup.hashCode())) * 31) + this.players.hashCode()) * 31;
        Integer num = this.bestOf;
        return ((iHashCode3 + (num != null ? num.hashCode() : 0)) * 31) + Integer.hashCode(this.games);
    }

    public final void setBestOf(Integer num) {
        this.bestOf = num;
    }

    public final void setFormat(MTGameFormat mTGameFormat) {
        this.format = mTGameFormat;
    }

    public final void setGames(int i) {
        this.games = i;
    }

    public final void setPlayers(List<MTFavoritePlayer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.players = list;
    }

    public final void setPlaygroup(MTGamePlaygroup mTGamePlaygroup) {
        this.playgroup = mTGamePlaygroup;
    }

    public final void setSubformat(MTGameSubformat mTGameSubformat) {
        this.subformat = mTGameSubformat;
    }

    public String toString() {
        return "MTFavoriteSetup(format=" + this.format + ", subformat=" + this.subformat + ", playgroup=" + this.playgroup + ", players=" + this.players + ", bestOf=" + this.bestOf + ", games=" + this.games + ")";
    }
}
