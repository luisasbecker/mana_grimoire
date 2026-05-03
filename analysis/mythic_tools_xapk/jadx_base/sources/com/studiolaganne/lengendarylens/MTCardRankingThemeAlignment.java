package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingThemeAlignment;", "", FirebaseAnalytics.Param.SCORE, "", "raw", "isUtilityCard", "", Constants.ScionAnalytics.PARAM_LABEL, "", "mode", "<init>", "(IIZLjava/lang/String;Ljava/lang/String;)V", "getScore", "()I", "getRaw", "()Z", "getLabel", "()Ljava/lang/String;", "getMode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingThemeAlignment {
    public static final int $stable = 0;
    private final boolean isUtilityCard;
    private final String label;
    private final String mode;
    private final int raw;
    private final int score;

    public MTCardRankingThemeAlignment() {
        this(0, 0, false, null, null, 31, null);
    }

    public MTCardRankingThemeAlignment(int i, int i2, boolean z, String str, String str2) {
        this.score = i;
        this.raw = i2;
        this.isUtilityCard = z;
        this.label = str;
        this.mode = str2;
    }

    public /* synthetic */ MTCardRankingThemeAlignment(int i, int i2, boolean z, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2);
    }

    public static /* synthetic */ MTCardRankingThemeAlignment copy$default(MTCardRankingThemeAlignment mTCardRankingThemeAlignment, int i, int i2, boolean z, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTCardRankingThemeAlignment.score;
        }
        if ((i3 & 2) != 0) {
            i2 = mTCardRankingThemeAlignment.raw;
        }
        if ((i3 & 4) != 0) {
            z = mTCardRankingThemeAlignment.isUtilityCard;
        }
        if ((i3 & 8) != 0) {
            str = mTCardRankingThemeAlignment.label;
        }
        if ((i3 & 16) != 0) {
            str2 = mTCardRankingThemeAlignment.mode;
        }
        String str3 = str2;
        boolean z2 = z;
        return mTCardRankingThemeAlignment.copy(i, i2, z2, str, str3);
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
    public final boolean getIsUtilityCard() {
        return this.isUtilityCard;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final MTCardRankingThemeAlignment copy(int score, int raw, boolean isUtilityCard, String label, String mode) {
        return new MTCardRankingThemeAlignment(score, raw, isUtilityCard, label, mode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingThemeAlignment)) {
            return false;
        }
        MTCardRankingThemeAlignment mTCardRankingThemeAlignment = (MTCardRankingThemeAlignment) other;
        return this.score == mTCardRankingThemeAlignment.score && this.raw == mTCardRankingThemeAlignment.raw && this.isUtilityCard == mTCardRankingThemeAlignment.isUtilityCard && Intrinsics.areEqual(this.label, mTCardRankingThemeAlignment.label) && Intrinsics.areEqual(this.mode, mTCardRankingThemeAlignment.mode);
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getMode() {
        return this.mode;
    }

    public final int getRaw() {
        return this.raw;
    }

    public final int getScore() {
        return this.score;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.score) * 31) + Integer.hashCode(this.raw)) * 31) + Boolean.hashCode(this.isUtilityCard)) * 31;
        String str = this.label;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mode;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isUtilityCard() {
        return this.isUtilityCard;
    }

    public String toString() {
        return "MTCardRankingThemeAlignment(score=" + this.score + ", raw=" + this.raw + ", isUtilityCard=" + this.isUtilityCard + ", label=" + this.label + ", mode=" + this.mode + ")";
    }
}
