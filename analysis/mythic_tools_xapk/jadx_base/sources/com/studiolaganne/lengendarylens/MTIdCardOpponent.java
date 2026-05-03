package com.studiolaganne.lengendarylens;

import androidx.autofill.HintConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardOpponent;", "", HintConstants.AUTOFILL_HINT_USERNAME, "", "games", "", "myWinrate", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getUsername", "()Ljava/lang/String;", "getGames", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMyWinrate", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardOpponent;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardOpponent {
    public static final int $stable = 0;
    private final Integer games;
    private final Integer myWinrate;
    private final String username;

    public MTIdCardOpponent() {
        this(null, null, null, 7, null);
    }

    public MTIdCardOpponent(String str, Integer num, Integer num2) {
        this.username = str;
        this.games = num;
        this.myWinrate = num2;
    }

    public /* synthetic */ MTIdCardOpponent(String str, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2);
    }

    public static /* synthetic */ MTIdCardOpponent copy$default(MTIdCardOpponent mTIdCardOpponent, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardOpponent.username;
        }
        if ((i & 2) != 0) {
            num = mTIdCardOpponent.games;
        }
        if ((i & 4) != 0) {
            num2 = mTIdCardOpponent.myWinrate;
        }
        return mTIdCardOpponent.copy(str, num, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getGames() {
        return this.games;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getMyWinrate() {
        return this.myWinrate;
    }

    public final MTIdCardOpponent copy(String username, Integer games, Integer myWinrate) {
        return new MTIdCardOpponent(username, games, myWinrate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardOpponent)) {
            return false;
        }
        MTIdCardOpponent mTIdCardOpponent = (MTIdCardOpponent) other;
        return Intrinsics.areEqual(this.username, mTIdCardOpponent.username) && Intrinsics.areEqual(this.games, mTIdCardOpponent.games) && Intrinsics.areEqual(this.myWinrate, mTIdCardOpponent.myWinrate);
    }

    public final Integer getGames() {
        return this.games;
    }

    public final Integer getMyWinrate() {
        return this.myWinrate;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.username;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.games;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.myWinrate;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardOpponent(username=" + this.username + ", games=" + this.games + ", myWinrate=" + this.myWinrate + ")";
    }
}
