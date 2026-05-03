package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingCommanderAlignment;", "", FirebaseAnalytics.Param.SCORE, "", "raw", Constants.ScionAnalytics.PARAM_LABEL, "", "isUtilityCard", "", "<init>", "(IILjava/lang/String;Z)V", "getScore", "()I", "getRaw", "getLabel", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingCommanderAlignment {
    public static final int $stable = 0;
    private final boolean isUtilityCard;
    private final String label;
    private final int raw;
    private final int score;

    public MTCardRankingCommanderAlignment() {
        this(0, 0, null, false, 15, null);
    }

    public MTCardRankingCommanderAlignment(int i, int i2, String str, boolean z) {
        this.score = i;
        this.raw = i2;
        this.label = str;
        this.isUtilityCard = z;
    }

    public /* synthetic */ MTCardRankingCommanderAlignment(int i, int i2, String str, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? false : z);
    }

    public static /* synthetic */ MTCardRankingCommanderAlignment copy$default(MTCardRankingCommanderAlignment mTCardRankingCommanderAlignment, int i, int i2, String str, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTCardRankingCommanderAlignment.score;
        }
        if ((i3 & 2) != 0) {
            i2 = mTCardRankingCommanderAlignment.raw;
        }
        if ((i3 & 4) != 0) {
            str = mTCardRankingCommanderAlignment.label;
        }
        if ((i3 & 8) != 0) {
            z = mTCardRankingCommanderAlignment.isUtilityCard;
        }
        return mTCardRankingCommanderAlignment.copy(i, i2, str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRaw() {
        return this.raw;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsUtilityCard() {
        return this.isUtilityCard;
    }

    public final MTCardRankingCommanderAlignment copy(int score, int raw, String label, boolean isUtilityCard) {
        return new MTCardRankingCommanderAlignment(score, raw, label, isUtilityCard);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingCommanderAlignment)) {
            return false;
        }
        MTCardRankingCommanderAlignment mTCardRankingCommanderAlignment = (MTCardRankingCommanderAlignment) other;
        return this.score == mTCardRankingCommanderAlignment.score && this.raw == mTCardRankingCommanderAlignment.raw && Intrinsics.areEqual(this.label, mTCardRankingCommanderAlignment.label) && this.isUtilityCard == mTCardRankingCommanderAlignment.isUtilityCard;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getRaw() {
        return this.raw;
    }

    public final int getScore() {
        return this.score;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.score) * 31) + Integer.hashCode(this.raw)) * 31;
        String str = this.label;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isUtilityCard);
    }

    public final boolean isUtilityCard() {
        return this.isUtilityCard;
    }

    public String toString() {
        return "MTCardRankingCommanderAlignment(score=" + this.score + ", raw=" + this.raw + ", label=" + this.label + ", isUtilityCard=" + this.isUtilityCard + ")";
    }
}
