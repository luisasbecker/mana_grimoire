package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPlaymatData;", "", "playmatImageURL", "", "isArtCrop", "", "<init>", "(Ljava/lang/String;Z)V", "getPlaymatImageURL", "()Ljava/lang/String;", "setPlaymatImageURL", "(Ljava/lang/String;)V", "()Z", "setArtCrop", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPlaymatData {
    public static final int $stable = 8;
    private boolean isArtCrop;
    private String playmatImageURL;

    /* JADX WARN: Multi-variable type inference failed */
    public MTPlaymatData() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public MTPlaymatData(String playmatImageURL, boolean z) {
        Intrinsics.checkNotNullParameter(playmatImageURL, "playmatImageURL");
        this.playmatImageURL = playmatImageURL;
        this.isArtCrop = z;
    }

    public /* synthetic */ MTPlaymatData(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
    }

    public static /* synthetic */ MTPlaymatData copy$default(MTPlaymatData mTPlaymatData, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTPlaymatData.playmatImageURL;
        }
        if ((i & 2) != 0) {
            z = mTPlaymatData.isArtCrop;
        }
        return mTPlaymatData.copy(str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPlaymatImageURL() {
        return this.playmatImageURL;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsArtCrop() {
        return this.isArtCrop;
    }

    public final MTPlaymatData copy(String playmatImageURL, boolean isArtCrop) {
        Intrinsics.checkNotNullParameter(playmatImageURL, "playmatImageURL");
        return new MTPlaymatData(playmatImageURL, isArtCrop);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPlaymatData)) {
            return false;
        }
        MTPlaymatData mTPlaymatData = (MTPlaymatData) other;
        return Intrinsics.areEqual(this.playmatImageURL, mTPlaymatData.playmatImageURL) && this.isArtCrop == mTPlaymatData.isArtCrop;
    }

    public final String getPlaymatImageURL() {
        return this.playmatImageURL;
    }

    public int hashCode() {
        return (this.playmatImageURL.hashCode() * 31) + Boolean.hashCode(this.isArtCrop);
    }

    public final boolean isArtCrop() {
        return this.isArtCrop;
    }

    public final void setArtCrop(boolean z) {
        this.isArtCrop = z;
    }

    public final void setPlaymatImageURL(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playmatImageURL = str;
    }

    public String toString() {
        return "MTPlaymatData(playmatImageURL=" + this.playmatImageURL + ", isArtCrop=" + this.isArtCrop + ")";
    }
}
