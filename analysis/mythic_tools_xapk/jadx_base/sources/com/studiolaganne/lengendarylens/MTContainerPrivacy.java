package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;", "", "type", "", "circles", "", "Lcom/studiolaganne/lengendarylens/MTCircle;", NativeProtocol.AUDIENCE_FRIENDS, "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "playgroups", "Lcom/studiolaganne/lengendarylens/MTCirclePlaygroup;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getCircles", "()Ljava/util/List;", "setCircles", "(Ljava/util/List;)V", "getFriends", "setFriends", "getPlaygroups", "setPlaygroups", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTContainerPrivacy {
    public static final int $stable = 8;
    private List<MTCircle> circles;
    private List<MTPrivacyUser> friends;
    private List<MTCirclePlaygroup> playgroups;
    private String type;

    public MTContainerPrivacy() {
        this(null, null, null, null, 15, null);
    }

    public MTContainerPrivacy(String str, List<MTCircle> list, List<MTPrivacyUser> list2, List<MTCirclePlaygroup> list3) {
        this.type = str;
        this.circles = list;
        this.friends = list2;
        this.playgroups = list3;
    }

    public /* synthetic */ MTContainerPrivacy(String str, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTContainerPrivacy copy$default(MTContainerPrivacy mTContainerPrivacy, String str, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTContainerPrivacy.type;
        }
        if ((i & 2) != 0) {
            list = mTContainerPrivacy.circles;
        }
        if ((i & 4) != 0) {
            list2 = mTContainerPrivacy.friends;
        }
        if ((i & 8) != 0) {
            list3 = mTContainerPrivacy.playgroups;
        }
        return mTContainerPrivacy.copy(str, list, list2, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<MTCircle> component2() {
        return this.circles;
    }

    public final List<MTPrivacyUser> component3() {
        return this.friends;
    }

    public final List<MTCirclePlaygroup> component4() {
        return this.playgroups;
    }

    public final MTContainerPrivacy copy(String type, List<MTCircle> circles, List<MTPrivacyUser> friends, List<MTCirclePlaygroup> playgroups) {
        return new MTContainerPrivacy(type, circles, friends, playgroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTContainerPrivacy)) {
            return false;
        }
        MTContainerPrivacy mTContainerPrivacy = (MTContainerPrivacy) other;
        return Intrinsics.areEqual(this.type, mTContainerPrivacy.type) && Intrinsics.areEqual(this.circles, mTContainerPrivacy.circles) && Intrinsics.areEqual(this.friends, mTContainerPrivacy.friends) && Intrinsics.areEqual(this.playgroups, mTContainerPrivacy.playgroups);
    }

    public final List<MTCircle> getCircles() {
        return this.circles;
    }

    public final List<MTPrivacyUser> getFriends() {
        return this.friends;
    }

    public final List<MTCirclePlaygroup> getPlaygroups() {
        return this.playgroups;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<MTCircle> list = this.circles;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<MTPrivacyUser> list2 = this.friends;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MTCirclePlaygroup> list3 = this.playgroups;
        return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setCircles(List<MTCircle> list) {
        this.circles = list;
    }

    public final void setFriends(List<MTPrivacyUser> list) {
        this.friends = list;
    }

    public final void setPlaygroups(List<MTCirclePlaygroup> list) {
        this.playgroups = list;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MTContainerPrivacy(type=" + this.type + ", circles=" + this.circles + ", friends=" + this.friends + ", playgroups=" + this.playgroups + ")";
    }
}
