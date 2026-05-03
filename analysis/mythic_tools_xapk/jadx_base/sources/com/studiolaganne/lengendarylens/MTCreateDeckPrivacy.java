package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCreateDeckPrivacy;", "", "type", "", "circleIds", "", "", "options", "Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getCircleIds", "()Ljava/util/List;", "setCircleIds", "(Ljava/util/List;)V", "getOptions", "()Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;", "setOptions", "(Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCreateDeckPrivacy {
    public static final int $stable = 8;
    private List<Integer> circleIds;
    private MTDeckPrivacyOptions options;
    private String type;

    public MTCreateDeckPrivacy() {
        this(null, null, null, 7, null);
    }

    public MTCreateDeckPrivacy(String str, List<Integer> list, MTDeckPrivacyOptions mTDeckPrivacyOptions) {
        this.type = str;
        this.circleIds = list;
        this.options = mTDeckPrivacyOptions;
    }

    public /* synthetic */ MTCreateDeckPrivacy(String str, List list, MTDeckPrivacyOptions mTDeckPrivacyOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : mTDeckPrivacyOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCreateDeckPrivacy copy$default(MTCreateDeckPrivacy mTCreateDeckPrivacy, String str, List list, MTDeckPrivacyOptions mTDeckPrivacyOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTCreateDeckPrivacy.type;
        }
        if ((i & 2) != 0) {
            list = mTCreateDeckPrivacy.circleIds;
        }
        if ((i & 4) != 0) {
            mTDeckPrivacyOptions = mTCreateDeckPrivacy.options;
        }
        return mTCreateDeckPrivacy.copy(str, list, mTDeckPrivacyOptions);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<Integer> component2() {
        return this.circleIds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTDeckPrivacyOptions getOptions() {
        return this.options;
    }

    public final MTCreateDeckPrivacy copy(String type, List<Integer> circleIds, MTDeckPrivacyOptions options) {
        return new MTCreateDeckPrivacy(type, circleIds, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCreateDeckPrivacy)) {
            return false;
        }
        MTCreateDeckPrivacy mTCreateDeckPrivacy = (MTCreateDeckPrivacy) other;
        return Intrinsics.areEqual(this.type, mTCreateDeckPrivacy.type) && Intrinsics.areEqual(this.circleIds, mTCreateDeckPrivacy.circleIds) && Intrinsics.areEqual(this.options, mTCreateDeckPrivacy.options);
    }

    public final List<Integer> getCircleIds() {
        return this.circleIds;
    }

    public final MTDeckPrivacyOptions getOptions() {
        return this.options;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<Integer> list = this.circleIds;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        MTDeckPrivacyOptions mTDeckPrivacyOptions = this.options;
        return iHashCode2 + (mTDeckPrivacyOptions != null ? mTDeckPrivacyOptions.hashCode() : 0);
    }

    public final void setCircleIds(List<Integer> list) {
        this.circleIds = list;
    }

    public final void setOptions(MTDeckPrivacyOptions mTDeckPrivacyOptions) {
        this.options = mTDeckPrivacyOptions;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MTCreateDeckPrivacy(type=" + this.type + ", circleIds=" + this.circleIds + ", options=" + this.options + ")";
    }
}
