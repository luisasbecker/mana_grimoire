package com.studiolaganne.lengendarylens;

import androidx.autofill.HintConstants;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFavoritePlayer;", "", "id", "", HintConstants.AUTOFILL_HINT_USERNAME, "", "firstname", AuthenticationTokenClaims.JSON_KEY_PICTURE, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "getFirstname", "setFirstname", "getPicture", "setPicture", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTFavoritePlayer {
    public static final int $stable = 8;
    private String firstname;
    private int id;
    private String picture;
    private String username;

    public MTFavoritePlayer() {
        this(0, null, null, null, 15, null);
    }

    public MTFavoritePlayer(int i, String username, String firstname, String str) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(firstname, "firstname");
        this.id = i;
        this.username = username;
        this.firstname = firstname;
        this.picture = str;
    }

    public /* synthetic */ MTFavoritePlayer(int i, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ MTFavoritePlayer copy$default(MTFavoritePlayer mTFavoritePlayer, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTFavoritePlayer.id;
        }
        if ((i2 & 2) != 0) {
            str = mTFavoritePlayer.username;
        }
        if ((i2 & 4) != 0) {
            str2 = mTFavoritePlayer.firstname;
        }
        if ((i2 & 8) != 0) {
            str3 = mTFavoritePlayer.picture;
        }
        return mTFavoritePlayer.copy(i, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFirstname() {
        return this.firstname;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPicture() {
        return this.picture;
    }

    public final MTFavoritePlayer copy(int id, String username, String firstname, String picture) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(firstname, "firstname");
        return new MTFavoritePlayer(id, username, firstname, picture);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTFavoritePlayer)) {
            return false;
        }
        MTFavoritePlayer mTFavoritePlayer = (MTFavoritePlayer) other;
        return this.id == mTFavoritePlayer.id && Intrinsics.areEqual(this.username, mTFavoritePlayer.username) && Intrinsics.areEqual(this.firstname, mTFavoritePlayer.firstname) && Intrinsics.areEqual(this.picture, mTFavoritePlayer.picture);
    }

    public final String getFirstname() {
        return this.firstname;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.id) * 31) + this.username.hashCode()) * 31) + this.firstname.hashCode()) * 31;
        String str = this.picture;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setFirstname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstname = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setPicture(String str) {
        this.picture = str;
    }

    public final void setUsername(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.username = str;
    }

    public String toString() {
        return "MTFavoritePlayer(id=" + this.id + ", username=" + this.username + ", firstname=" + this.firstname + ", picture=" + this.picture + ")";
    }
}
