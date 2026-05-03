package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardUsedInDeck;", "", "id", "", "name", "", "owner_userid", "owner_username", "owner_firstname", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOwner_userid", "setOwner_userid", "getOwner_username", "setOwner_username", "getOwner_firstname", "setOwner_firstname", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTCardUsedInDeck;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardUsedInDeck {
    public static final int $stable = 8;
    private Integer id;
    private String name;
    private String owner_firstname;
    private Integer owner_userid;
    private String owner_username;

    public MTCardUsedInDeck() {
        this(null, null, null, null, null, 31, null);
    }

    public MTCardUsedInDeck(Integer num, String str, Integer num2, String str2, String str3) {
        this.id = num;
        this.name = str;
        this.owner_userid = num2;
        this.owner_username = str2;
        this.owner_firstname = str3;
    }

    public /* synthetic */ MTCardUsedInDeck(Integer num, String str, Integer num2, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }

    public static /* synthetic */ MTCardUsedInDeck copy$default(MTCardUsedInDeck mTCardUsedInDeck, Integer num, String str, Integer num2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTCardUsedInDeck.id;
        }
        if ((i & 2) != 0) {
            str = mTCardUsedInDeck.name;
        }
        if ((i & 4) != 0) {
            num2 = mTCardUsedInDeck.owner_userid;
        }
        if ((i & 8) != 0) {
            str2 = mTCardUsedInDeck.owner_username;
        }
        if ((i & 16) != 0) {
            str3 = mTCardUsedInDeck.owner_firstname;
        }
        String str4 = str3;
        Integer num3 = num2;
        return mTCardUsedInDeck.copy(num, str, num3, str2, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getOwner_userid() {
        return this.owner_userid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOwner_username() {
        return this.owner_username;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOwner_firstname() {
        return this.owner_firstname;
    }

    public final MTCardUsedInDeck copy(Integer id, String name, Integer owner_userid, String owner_username, String owner_firstname) {
        return new MTCardUsedInDeck(id, name, owner_userid, owner_username, owner_firstname);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardUsedInDeck)) {
            return false;
        }
        MTCardUsedInDeck mTCardUsedInDeck = (MTCardUsedInDeck) other;
        return Intrinsics.areEqual(this.id, mTCardUsedInDeck.id) && Intrinsics.areEqual(this.name, mTCardUsedInDeck.name) && Intrinsics.areEqual(this.owner_userid, mTCardUsedInDeck.owner_userid) && Intrinsics.areEqual(this.owner_username, mTCardUsedInDeck.owner_username) && Intrinsics.areEqual(this.owner_firstname, mTCardUsedInDeck.owner_firstname);
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOwner_firstname() {
        return this.owner_firstname;
    }

    public final Integer getOwner_userid() {
        return this.owner_userid;
    }

    public final String getOwner_username() {
        return this.owner_username;
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.owner_userid;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.owner_username;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.owner_firstname;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOwner_firstname(String str) {
        this.owner_firstname = str;
    }

    public final void setOwner_userid(Integer num) {
        this.owner_userid = num;
    }

    public final void setOwner_username(String str) {
        this.owner_username = str;
    }

    public String toString() {
        return "MTCardUsedInDeck(id=" + this.id + ", name=" + this.name + ", owner_userid=" + this.owner_userid + ", owner_username=" + this.owner_username + ", owner_firstname=" + this.owner_firstname + ")";
    }
}
