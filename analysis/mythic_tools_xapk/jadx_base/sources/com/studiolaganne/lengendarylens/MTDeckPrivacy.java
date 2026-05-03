package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003JW\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001a¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;", "", "type", "", "options", "Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;", "circles", "", "Lcom/studiolaganne/lengendarylens/MTCircle;", NativeProtocol.AUDIENCE_FRIENDS, "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "playgroups", "Lcom/studiolaganne/lengendarylens/MTCirclePlaygroup;", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getOptions", "()Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;", "setOptions", "(Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;)V", "getCircles", "()Ljava/util/List;", "setCircles", "(Ljava/util/List;)V", "getFriends", "setFriends", "getPlaygroups", "setPlaygroups", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckPrivacy {
    public static final int $stable = 8;
    private List<MTCircle> circles;
    private List<MTPrivacyUser> friends;
    private MTDeckPrivacyOptions options;
    private List<MTCirclePlaygroup> playgroups;
    private String type;

    public MTDeckPrivacy() {
        this(null, null, null, null, null, 31, null);
    }

    public MTDeckPrivacy(String str, MTDeckPrivacyOptions mTDeckPrivacyOptions, List<MTCircle> list, List<MTPrivacyUser> list2, List<MTCirclePlaygroup> list3) {
        this.type = str;
        this.options = mTDeckPrivacyOptions;
        this.circles = list;
        this.friends = list2;
        this.playgroups = list3;
    }

    public /* synthetic */ MTDeckPrivacy(String str, MTDeckPrivacyOptions mTDeckPrivacyOptions, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : mTDeckPrivacyOptions, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTDeckPrivacy copy$default(MTDeckPrivacy mTDeckPrivacy, String str, MTDeckPrivacyOptions mTDeckPrivacyOptions, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTDeckPrivacy.type;
        }
        if ((i & 2) != 0) {
            mTDeckPrivacyOptions = mTDeckPrivacy.options;
        }
        if ((i & 4) != 0) {
            list = mTDeckPrivacy.circles;
        }
        if ((i & 8) != 0) {
            list2 = mTDeckPrivacy.friends;
        }
        if ((i & 16) != 0) {
            list3 = mTDeckPrivacy.playgroups;
        }
        List list4 = list3;
        List list5 = list;
        return mTDeckPrivacy.copy(str, mTDeckPrivacyOptions, list5, list2, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTDeckPrivacyOptions getOptions() {
        return this.options;
    }

    public final List<MTCircle> component3() {
        return this.circles;
    }

    public final List<MTPrivacyUser> component4() {
        return this.friends;
    }

    public final List<MTCirclePlaygroup> component5() {
        return this.playgroups;
    }

    public final MTDeckPrivacy copy(String type, MTDeckPrivacyOptions options, List<MTCircle> circles, List<MTPrivacyUser> friends, List<MTCirclePlaygroup> playgroups) {
        return new MTDeckPrivacy(type, options, circles, friends, playgroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckPrivacy)) {
            return false;
        }
        MTDeckPrivacy mTDeckPrivacy = (MTDeckPrivacy) other;
        return Intrinsics.areEqual(this.type, mTDeckPrivacy.type) && Intrinsics.areEqual(this.options, mTDeckPrivacy.options) && Intrinsics.areEqual(this.circles, mTDeckPrivacy.circles) && Intrinsics.areEqual(this.friends, mTDeckPrivacy.friends) && Intrinsics.areEqual(this.playgroups, mTDeckPrivacy.playgroups);
    }

    public final List<MTCircle> getCircles() {
        return this.circles;
    }

    public final List<MTPrivacyUser> getFriends() {
        return this.friends;
    }

    public final MTDeckPrivacyOptions getOptions() {
        return this.options;
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
        MTDeckPrivacyOptions mTDeckPrivacyOptions = this.options;
        int iHashCode2 = (iHashCode + (mTDeckPrivacyOptions == null ? 0 : mTDeckPrivacyOptions.hashCode())) * 31;
        List<MTCircle> list = this.circles;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<MTPrivacyUser> list2 = this.friends;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MTCirclePlaygroup> list3 = this.playgroups;
        return iHashCode4 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setCircles(List<MTCircle> list) {
        this.circles = list;
    }

    public final void setFriends(List<MTPrivacyUser> list) {
        this.friends = list;
    }

    public final void setOptions(MTDeckPrivacyOptions mTDeckPrivacyOptions) {
        this.options = mTDeckPrivacyOptions;
    }

    public final void setPlaygroups(List<MTCirclePlaygroup> list) {
        this.playgroups = list;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MTDeckPrivacy(type=" + this.type + ", options=" + this.options + ", circles=" + this.circles + ", friends=" + this.friends + ", playgroups=" + this.playgroups + ")";
    }
}
