package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEditCircleBody;", "", "name", "", "description", "members", "Lcom/studiolaganne/lengendarylens/MTEditCircleMembersBody;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTEditCircleMembersBody;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getMembers", "()Lcom/studiolaganne/lengendarylens/MTEditCircleMembersBody;", "setMembers", "(Lcom/studiolaganne/lengendarylens/MTEditCircleMembersBody;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTEditCircleBody {
    public static final int $stable = 8;
    private String description;
    private MTEditCircleMembersBody members;
    private String name;

    public MTEditCircleBody() {
        this(null, null, null, 7, null);
    }

    public MTEditCircleBody(String str, String str2, MTEditCircleMembersBody mTEditCircleMembersBody) {
        this.name = str;
        this.description = str2;
        this.members = mTEditCircleMembersBody;
    }

    public /* synthetic */ MTEditCircleBody(String str, String str2, MTEditCircleMembersBody mTEditCircleMembersBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : mTEditCircleMembersBody);
    }

    public static /* synthetic */ MTEditCircleBody copy$default(MTEditCircleBody mTEditCircleBody, String str, String str2, MTEditCircleMembersBody mTEditCircleMembersBody, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTEditCircleBody.name;
        }
        if ((i & 2) != 0) {
            str2 = mTEditCircleBody.description;
        }
        if ((i & 4) != 0) {
            mTEditCircleMembersBody = mTEditCircleBody.members;
        }
        return mTEditCircleBody.copy(str, str2, mTEditCircleMembersBody);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTEditCircleMembersBody getMembers() {
        return this.members;
    }

    public final MTEditCircleBody copy(String name, String description, MTEditCircleMembersBody members) {
        return new MTEditCircleBody(name, description, members);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTEditCircleBody)) {
            return false;
        }
        MTEditCircleBody mTEditCircleBody = (MTEditCircleBody) other;
        return Intrinsics.areEqual(this.name, mTEditCircleBody.name) && Intrinsics.areEqual(this.description, mTEditCircleBody.description) && Intrinsics.areEqual(this.members, mTEditCircleBody.members);
    }

    public final String getDescription() {
        return this.description;
    }

    public final MTEditCircleMembersBody getMembers() {
        return this.members;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        MTEditCircleMembersBody mTEditCircleMembersBody = this.members;
        return iHashCode2 + (mTEditCircleMembersBody != null ? mTEditCircleMembersBody.hashCode() : 0);
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setMembers(MTEditCircleMembersBody mTEditCircleMembersBody) {
        this.members = mTEditCircleMembersBody;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "MTEditCircleBody(name=" + this.name + ", description=" + this.description + ", members=" + this.members + ")";
    }
}
