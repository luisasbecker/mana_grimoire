package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUserPrivacy;", "", "type", "", "options", "Lcom/studiolaganne/lengendarylens/MTUserPrivacyOptions;", "circles", "", "Lcom/studiolaganne/lengendarylens/MTCircle;", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTUserPrivacyOptions;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getOptions", "()Lcom/studiolaganne/lengendarylens/MTUserPrivacyOptions;", "setOptions", "(Lcom/studiolaganne/lengendarylens/MTUserPrivacyOptions;)V", "getCircles", "()Ljava/util/List;", "setCircles", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUserPrivacy {
    public static final int $stable = 8;
    private List<MTCircle> circles;
    private MTUserPrivacyOptions options;
    private String type;

    public MTUserPrivacy() {
        this(null, null, null, 7, null);
    }

    public MTUserPrivacy(String str, MTUserPrivacyOptions mTUserPrivacyOptions, List<MTCircle> list) {
        this.type = str;
        this.options = mTUserPrivacyOptions;
        this.circles = list;
    }

    public /* synthetic */ MTUserPrivacy(String str, MTUserPrivacyOptions mTUserPrivacyOptions, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : mTUserPrivacyOptions, (i & 4) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTUserPrivacy copy$default(MTUserPrivacy mTUserPrivacy, String str, MTUserPrivacyOptions mTUserPrivacyOptions, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTUserPrivacy.type;
        }
        if ((i & 2) != 0) {
            mTUserPrivacyOptions = mTUserPrivacy.options;
        }
        if ((i & 4) != 0) {
            list = mTUserPrivacy.circles;
        }
        return mTUserPrivacy.copy(str, mTUserPrivacyOptions, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTUserPrivacyOptions getOptions() {
        return this.options;
    }

    public final List<MTCircle> component3() {
        return this.circles;
    }

    public final MTUserPrivacy copy(String type, MTUserPrivacyOptions options, List<MTCircle> circles) {
        return new MTUserPrivacy(type, options, circles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUserPrivacy)) {
            return false;
        }
        MTUserPrivacy mTUserPrivacy = (MTUserPrivacy) other;
        return Intrinsics.areEqual(this.type, mTUserPrivacy.type) && Intrinsics.areEqual(this.options, mTUserPrivacy.options) && Intrinsics.areEqual(this.circles, mTUserPrivacy.circles);
    }

    public final List<MTCircle> getCircles() {
        return this.circles;
    }

    public final MTUserPrivacyOptions getOptions() {
        return this.options;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        MTUserPrivacyOptions mTUserPrivacyOptions = this.options;
        int iHashCode2 = (iHashCode + (mTUserPrivacyOptions == null ? 0 : mTUserPrivacyOptions.hashCode())) * 31;
        List<MTCircle> list = this.circles;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setCircles(List<MTCircle> list) {
        this.circles = list;
    }

    public final void setOptions(MTUserPrivacyOptions mTUserPrivacyOptions) {
        this.options = mTUserPrivacyOptions;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MTUserPrivacy(type=" + this.type + ", options=" + this.options + ", circles=" + this.circles + ")";
    }
}
