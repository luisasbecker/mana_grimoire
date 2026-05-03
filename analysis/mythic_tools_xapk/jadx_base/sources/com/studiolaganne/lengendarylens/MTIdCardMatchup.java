package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardMatchup;", "", "commander", "", "colors", "games", "", "myWinrate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCommander", "()Ljava/lang/String;", "getColors", "getGames", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMyWinrate", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardMatchup;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardMatchup {
    public static final int $stable = 0;
    private final String colors;
    private final String commander;
    private final Integer games;
    private final Integer myWinrate;

    public MTIdCardMatchup() {
        this(null, null, null, null, 15, null);
    }

    public MTIdCardMatchup(String str, String str2, Integer num, Integer num2) {
        this.commander = str;
        this.colors = str2;
        this.games = num;
        this.myWinrate = num2;
    }

    public /* synthetic */ MTIdCardMatchup(String str, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
    }

    public static /* synthetic */ MTIdCardMatchup copy$default(MTIdCardMatchup mTIdCardMatchup, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardMatchup.commander;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardMatchup.colors;
        }
        if ((i & 4) != 0) {
            num = mTIdCardMatchup.games;
        }
        if ((i & 8) != 0) {
            num2 = mTIdCardMatchup.myWinrate;
        }
        return mTIdCardMatchup.copy(str, str2, num, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCommander() {
        return this.commander;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getGames() {
        return this.games;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getMyWinrate() {
        return this.myWinrate;
    }

    public final MTIdCardMatchup copy(String commander, String colors, Integer games, Integer myWinrate) {
        return new MTIdCardMatchup(commander, colors, games, myWinrate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardMatchup)) {
            return false;
        }
        MTIdCardMatchup mTIdCardMatchup = (MTIdCardMatchup) other;
        return Intrinsics.areEqual(this.commander, mTIdCardMatchup.commander) && Intrinsics.areEqual(this.colors, mTIdCardMatchup.colors) && Intrinsics.areEqual(this.games, mTIdCardMatchup.games) && Intrinsics.areEqual(this.myWinrate, mTIdCardMatchup.myWinrate);
    }

    public final String getColors() {
        return this.colors;
    }

    public final String getCommander() {
        return this.commander;
    }

    public final Integer getGames() {
        return this.games;
    }

    public final Integer getMyWinrate() {
        return this.myWinrate;
    }

    public int hashCode() {
        String str = this.commander;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.colors;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.games;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.myWinrate;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardMatchup(commander=" + this.commander + ", colors=" + this.colors + ", games=" + this.games + ", myWinrate=" + this.myWinrate + ")";
    }
}
