package com.studiolaganne.lengendarylens;

import androidx.autofill.HintConstants;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003JY\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTMessage;", "", "id", "", FirebaseAnalytics.Param.CONTENT, "", DiagnosticsEntry.TIMESTAMP_KEY, AuthenticationTokenClaims.JSON_KEY_PICTURE, HintConstants.AUTOFILL_HINT_USERNAME, "firstname", "userid", "playgroup_id", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getId", "()I", "setId", "(I)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getTimestamp", "setTimestamp", "getPicture", "setPicture", "getUsername", "setUsername", "getFirstname", "setFirstname", "getUserid", "setUserid", "getPlaygroup_id", "setPlaygroup_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTMessage {
    public static final int $stable = 8;
    private String content;
    private String firstname;
    private int id;
    private String picture;
    private int playgroup_id;
    private String timestamp;
    private int userid;
    private String username;

    public MTMessage() {
        this(0, null, null, null, null, null, 0, 0, 255, null);
    }

    public MTMessage(int i, String content, String timestamp, String picture, String username, String firstname, int i2, int i3) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(firstname, "firstname");
        this.id = i;
        this.content = content;
        this.timestamp = timestamp;
        this.picture = picture;
        this.username = username;
        this.firstname = firstname;
        this.userid = i2;
        this.playgroup_id = i3;
    }

    public /* synthetic */ MTMessage(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? "" : str4, (i4 & 32) != 0 ? "" : str5, (i4 & 64) != 0 ? -1 : i2, (i4 & 128) != 0 ? -1 : i3);
    }

    public static /* synthetic */ MTMessage copy$default(MTMessage mTMessage, int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = mTMessage.id;
        }
        if ((i4 & 2) != 0) {
            str = mTMessage.content;
        }
        if ((i4 & 4) != 0) {
            str2 = mTMessage.timestamp;
        }
        if ((i4 & 8) != 0) {
            str3 = mTMessage.picture;
        }
        if ((i4 & 16) != 0) {
            str4 = mTMessage.username;
        }
        if ((i4 & 32) != 0) {
            str5 = mTMessage.firstname;
        }
        if ((i4 & 64) != 0) {
            i2 = mTMessage.userid;
        }
        if ((i4 & 128) != 0) {
            i3 = mTMessage.playgroup_id;
        }
        int i5 = i2;
        int i6 = i3;
        String str6 = str4;
        String str7 = str5;
        return mTMessage.copy(i, str, str2, str3, str6, str7, i5, i6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPicture() {
        return this.picture;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFirstname() {
        return this.firstname;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getUserid() {
        return this.userid;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getPlaygroup_id() {
        return this.playgroup_id;
    }

    public final MTMessage copy(int id, String content, String timestamp, String picture, String username, String firstname, int userid, int playgroup_id) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(firstname, "firstname");
        return new MTMessage(id, content, timestamp, picture, username, firstname, userid, playgroup_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTMessage)) {
            return false;
        }
        MTMessage mTMessage = (MTMessage) other;
        return this.id == mTMessage.id && Intrinsics.areEqual(this.content, mTMessage.content) && Intrinsics.areEqual(this.timestamp, mTMessage.timestamp) && Intrinsics.areEqual(this.picture, mTMessage.picture) && Intrinsics.areEqual(this.username, mTMessage.username) && Intrinsics.areEqual(this.firstname, mTMessage.firstname) && this.userid == mTMessage.userid && this.playgroup_id == mTMessage.playgroup_id;
    }

    public final String getContent() {
        return this.content;
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

    public final int getPlaygroup_id() {
        return this.playgroup_id;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final int getUserid() {
        return this.userid;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.id) * 31) + this.content.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.picture.hashCode()) * 31) + this.username.hashCode()) * 31) + this.firstname.hashCode()) * 31) + Integer.hashCode(this.userid)) * 31) + Integer.hashCode(this.playgroup_id);
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setFirstname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstname = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setPicture(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.picture = str;
    }

    public final void setPlaygroup_id(int i) {
        this.playgroup_id = i;
    }

    public final void setTimestamp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timestamp = str;
    }

    public final void setUserid(int i) {
        this.userid = i;
    }

    public final void setUsername(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.username = str;
    }

    public String toString() {
        return "MTMessage(id=" + this.id + ", content=" + this.content + ", timestamp=" + this.timestamp + ", picture=" + this.picture + ", username=" + this.username + ", firstname=" + this.firstname + ", userid=" + this.userid + ", playgroup_id=" + this.playgroup_id + ")";
    }
}
