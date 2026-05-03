package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTTrophyLocalization;", "", "fr", "Lcom/studiolaganne/lengendarylens/MTTrophyData;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTTrophyData;)V", "getFr", "()Lcom/studiolaganne/lengendarylens/MTTrophyData;", "setFr", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTTrophyLocalization {
    public static final int $stable = 8;
    private MTTrophyData fr;

    /* JADX WARN: Multi-variable type inference failed */
    public MTTrophyLocalization() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTTrophyLocalization(MTTrophyData mTTrophyData) {
        this.fr = mTTrophyData;
    }

    public /* synthetic */ MTTrophyLocalization(MTTrophyData mTTrophyData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTTrophyData);
    }

    public static /* synthetic */ MTTrophyLocalization copy$default(MTTrophyLocalization mTTrophyLocalization, MTTrophyData mTTrophyData, int i, Object obj) {
        if ((i & 1) != 0) {
            mTTrophyData = mTTrophyLocalization.fr;
        }
        return mTTrophyLocalization.copy(mTTrophyData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTTrophyData getFr() {
        return this.fr;
    }

    public final MTTrophyLocalization copy(MTTrophyData fr) {
        return new MTTrophyLocalization(fr);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTTrophyLocalization) && Intrinsics.areEqual(this.fr, ((MTTrophyLocalization) other).fr);
    }

    public final MTTrophyData getFr() {
        return this.fr;
    }

    public int hashCode() {
        MTTrophyData mTTrophyData = this.fr;
        if (mTTrophyData == null) {
            return 0;
        }
        return mTTrophyData.hashCode();
    }

    public final void setFr(MTTrophyData mTTrophyData) {
        this.fr = mTTrophyData;
    }

    public String toString() {
        return "MTTrophyLocalization(fr=" + this.fr + ")";
    }
}
