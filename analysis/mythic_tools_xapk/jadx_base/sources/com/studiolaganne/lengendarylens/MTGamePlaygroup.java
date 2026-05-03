package com.studiolaganne.lengendarylens;

import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGamePlaygroup;", "", "id", "", "name", "", AuthenticationTokenClaims.JSON_KEY_PICTURE, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPicture", "setPicture", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTGamePlaygroup {
    public static final int $stable = 8;
    private int id;
    private String name;
    private String picture;

    public MTGamePlaygroup() {
        this(0, null, null, 7, null);
    }

    public MTGamePlaygroup(int i, String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.picture = str;
    }

    public /* synthetic */ MTGamePlaygroup(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ MTGamePlaygroup copy$default(MTGamePlaygroup mTGamePlaygroup, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTGamePlaygroup.id;
        }
        if ((i2 & 2) != 0) {
            str = mTGamePlaygroup.name;
        }
        if ((i2 & 4) != 0) {
            str2 = mTGamePlaygroup.picture;
        }
        return mTGamePlaygroup.copy(i, str, str2);
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
    public final String getPicture() {
        return this.picture;
    }

    public final MTGamePlaygroup copy(int id, String name, String picture) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTGamePlaygroup(id, name, picture);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTGamePlaygroup)) {
            return false;
        }
        MTGamePlaygroup mTGamePlaygroup = (MTGamePlaygroup) other;
        return this.id == mTGamePlaygroup.id && Intrinsics.areEqual(this.name, mTGamePlaygroup.name) && Intrinsics.areEqual(this.picture, mTGamePlaygroup.picture);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPicture() {
        return this.picture;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        String str = this.picture;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setPicture(String str) {
        this.picture = str;
    }

    public String toString() {
        return "MTGamePlaygroup(id=" + this.id + ", name=" + this.name + ", picture=" + this.picture + ")";
    }
}
