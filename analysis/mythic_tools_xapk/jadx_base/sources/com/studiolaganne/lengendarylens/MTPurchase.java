package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019JB\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPurchase;", "", "id", "", "name", "", "googleproductid", "appleproductid", "bought", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getGoogleproductid", "setGoogleproductid", "getAppleproductid", "setAppleproductid", "getBought", "()Ljava/lang/Boolean;", "setBought", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTPurchase;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPurchase {
    public static final int $stable = 8;
    private String appleproductid;
    private Boolean bought;
    private String googleproductid;
    private int id;
    private String name;

    public MTPurchase() {
        this(0, null, null, null, null, 31, null);
    }

    public MTPurchase(int i, String name, String googleproductid, String appleproductid, Boolean bool) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(googleproductid, "googleproductid");
        Intrinsics.checkNotNullParameter(appleproductid, "appleproductid");
        this.id = i;
        this.name = name;
        this.googleproductid = googleproductid;
        this.appleproductid = appleproductid;
        this.bought = bool;
    }

    public /* synthetic */ MTPurchase(int i, String str, String str2, String str3, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? null : bool);
    }

    public static /* synthetic */ MTPurchase copy$default(MTPurchase mTPurchase, int i, String str, String str2, String str3, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTPurchase.id;
        }
        if ((i2 & 2) != 0) {
            str = mTPurchase.name;
        }
        if ((i2 & 4) != 0) {
            str2 = mTPurchase.googleproductid;
        }
        if ((i2 & 8) != 0) {
            str3 = mTPurchase.appleproductid;
        }
        if ((i2 & 16) != 0) {
            bool = mTPurchase.bought;
        }
        Boolean bool2 = bool;
        String str4 = str2;
        return mTPurchase.copy(i, str, str4, str3, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGoogleproductid() {
        return this.googleproductid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAppleproductid() {
        return this.appleproductid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getBought() {
        return this.bought;
    }

    public final MTPurchase copy(int id, String name, String googleproductid, String appleproductid, Boolean bought) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(googleproductid, "googleproductid");
        Intrinsics.checkNotNullParameter(appleproductid, "appleproductid");
        return new MTPurchase(id, name, googleproductid, appleproductid, bought);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPurchase)) {
            return false;
        }
        MTPurchase mTPurchase = (MTPurchase) other;
        return this.id == mTPurchase.id && Intrinsics.areEqual(this.name, mTPurchase.name) && Intrinsics.areEqual(this.googleproductid, mTPurchase.googleproductid) && Intrinsics.areEqual(this.appleproductid, mTPurchase.appleproductid) && Intrinsics.areEqual(this.bought, mTPurchase.bought);
    }

    public final String getAppleproductid() {
        return this.appleproductid;
    }

    public final Boolean getBought() {
        return this.bought;
    }

    public final String getGoogleproductid() {
        return this.googleproductid;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.googleproductid.hashCode()) * 31) + this.appleproductid.hashCode()) * 31;
        Boolean bool = this.bought;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public final void setAppleproductid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appleproductid = str;
    }

    public final void setBought(Boolean bool) {
        this.bought = bool;
    }

    public final void setGoogleproductid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.googleproductid = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return "MTPurchase(id=" + this.id + ", name=" + this.name + ", googleproductid=" + this.googleproductid + ", appleproductid=" + this.appleproductid + ", bought=" + this.bought + ")";
    }
}
