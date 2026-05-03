package com.studiolaganne.lengendarylens;

import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCirclePlaygroup;", "", "id", "", "name", "", AuthenticationTokenClaims.JSON_KEY_PICTURE, "description", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPicture", "setPicture", "getDescription", "setDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCirclePlaygroup {
    public static final int $stable = 8;
    private String description;
    private int id;
    private String name;
    private String picture;

    public MTCirclePlaygroup() {
        this(0, null, null, null, 15, null);
    }

    public MTCirclePlaygroup(int i, String str, String str2, String str3) {
        this.id = i;
        this.name = str;
        this.picture = str2;
        this.description = str3;
    }

    public /* synthetic */ MTCirclePlaygroup(int i, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ MTCirclePlaygroup copy$default(MTCirclePlaygroup mTCirclePlaygroup, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTCirclePlaygroup.id;
        }
        if ((i2 & 2) != 0) {
            str = mTCirclePlaygroup.name;
        }
        if ((i2 & 4) != 0) {
            str2 = mTCirclePlaygroup.picture;
        }
        if ((i2 & 8) != 0) {
            str3 = mTCirclePlaygroup.description;
        }
        return mTCirclePlaygroup.copy(i, str, str2, str3);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final MTCirclePlaygroup copy(int id, String name, String picture, String description) {
        return new MTCirclePlaygroup(id, name, picture, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCirclePlaygroup)) {
            return false;
        }
        MTCirclePlaygroup mTCirclePlaygroup = (MTCirclePlaygroup) other;
        return this.id == mTCirclePlaygroup.id && Intrinsics.areEqual(this.name, mTCirclePlaygroup.name) && Intrinsics.areEqual(this.picture, mTCirclePlaygroup.picture) && Intrinsics.areEqual(this.description, mTCirclePlaygroup.description);
    }

    public final String getDescription() {
        return this.description;
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
        int iHashCode = Integer.hashCode(this.id) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.picture;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPicture(String str) {
        this.picture = str;
    }

    public String toString() {
        return "MTCirclePlaygroup(id=" + this.id + ", name=" + this.name + ", picture=" + this.picture + ", description=" + this.description + ")";
    }
}
