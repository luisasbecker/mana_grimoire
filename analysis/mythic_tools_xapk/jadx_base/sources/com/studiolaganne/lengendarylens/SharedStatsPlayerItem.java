package com.studiolaganne.lengendarylens;

import androidx.autofill.HintConstants;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedStatsPlayerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJp\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/SharedStatsPlayerItem;", "", AuthenticationTokenClaims.JSON_KEY_PICTURE, "", "firstname", HintConstants.AUTOFILL_HINT_USERNAME, "wins", "", "losses", "draws", "games", "rate", "formatId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/Integer;)V", "getPicture", "()Ljava/lang/String;", "getFirstname", "getUsername", "getWins", "()I", "getLosses", "getDraws", "getGames", "getRate", "getFormatId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/SharedStatsPlayerItem;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SharedStatsPlayerItem {
    public static final int $stable = 0;
    private final int draws;
    private final String firstname;
    private final Integer formatId;
    private final int games;
    private final int losses;
    private final String picture;
    private final String rate;
    private final String username;
    private final int wins;

    public SharedStatsPlayerItem(String str, String str2, String str3, int i, int i2, int i3, int i4, String rate, Integer num) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        this.picture = str;
        this.firstname = str2;
        this.username = str3;
        this.wins = i;
        this.losses = i2;
        this.draws = i3;
        this.games = i4;
        this.rate = rate;
        this.formatId = num;
    }

    public static /* synthetic */ SharedStatsPlayerItem copy$default(SharedStatsPlayerItem sharedStatsPlayerItem, String str, String str2, String str3, int i, int i2, int i3, int i4, String str4, Integer num, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = sharedStatsPlayerItem.picture;
        }
        if ((i5 & 2) != 0) {
            str2 = sharedStatsPlayerItem.firstname;
        }
        if ((i5 & 4) != 0) {
            str3 = sharedStatsPlayerItem.username;
        }
        if ((i5 & 8) != 0) {
            i = sharedStatsPlayerItem.wins;
        }
        if ((i5 & 16) != 0) {
            i2 = sharedStatsPlayerItem.losses;
        }
        if ((i5 & 32) != 0) {
            i3 = sharedStatsPlayerItem.draws;
        }
        if ((i5 & 64) != 0) {
            i4 = sharedStatsPlayerItem.games;
        }
        if ((i5 & 128) != 0) {
            str4 = sharedStatsPlayerItem.rate;
        }
        if ((i5 & 256) != 0) {
            num = sharedStatsPlayerItem.formatId;
        }
        String str5 = str4;
        Integer num2 = num;
        int i6 = i3;
        int i7 = i4;
        int i8 = i2;
        String str6 = str3;
        return sharedStatsPlayerItem.copy(str, str2, str6, i, i8, i6, i7, str5, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPicture() {
        return this.picture;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstname() {
        return this.firstname;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getWins() {
        return this.wins;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLosses() {
        return this.losses;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getDraws() {
        return this.draws;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getGames() {
        return this.games;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getRate() {
        return this.rate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getFormatId() {
        return this.formatId;
    }

    public final SharedStatsPlayerItem copy(String picture, String firstname, String username, int wins, int losses, int draws, int games, String rate, Integer formatId) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        return new SharedStatsPlayerItem(picture, firstname, username, wins, losses, draws, games, rate, formatId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SharedStatsPlayerItem)) {
            return false;
        }
        SharedStatsPlayerItem sharedStatsPlayerItem = (SharedStatsPlayerItem) other;
        return Intrinsics.areEqual(this.picture, sharedStatsPlayerItem.picture) && Intrinsics.areEqual(this.firstname, sharedStatsPlayerItem.firstname) && Intrinsics.areEqual(this.username, sharedStatsPlayerItem.username) && this.wins == sharedStatsPlayerItem.wins && this.losses == sharedStatsPlayerItem.losses && this.draws == sharedStatsPlayerItem.draws && this.games == sharedStatsPlayerItem.games && Intrinsics.areEqual(this.rate, sharedStatsPlayerItem.rate) && Intrinsics.areEqual(this.formatId, sharedStatsPlayerItem.formatId);
    }

    public final int getDraws() {
        return this.draws;
    }

    public final String getFirstname() {
        return this.firstname;
    }

    public final Integer getFormatId() {
        return this.formatId;
    }

    public final int getGames() {
        return this.games;
    }

    public final int getLosses() {
        return this.losses;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getRate() {
        return this.rate;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int getWins() {
        return this.wins;
    }

    public int hashCode() {
        String str = this.picture;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.firstname;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.username;
        int iHashCode3 = (((((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + Integer.hashCode(this.wins)) * 31) + Integer.hashCode(this.losses)) * 31) + Integer.hashCode(this.draws)) * 31) + Integer.hashCode(this.games)) * 31) + this.rate.hashCode()) * 31;
        Integer num = this.formatId;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "SharedStatsPlayerItem(picture=" + this.picture + ", firstname=" + this.firstname + ", username=" + this.username + ", wins=" + this.wins + ", losses=" + this.losses + ", draws=" + this.draws + ", games=" + this.games + ", rate=" + this.rate + ", formatId=" + this.formatId + ")";
    }
}
