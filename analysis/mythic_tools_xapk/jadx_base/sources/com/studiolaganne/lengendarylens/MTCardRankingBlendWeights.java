package com.studiolaganne.lengendarylens;

import androidx.camera.video.AudioStats;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingBlendWeights;", "", "deckFit", "", "themeAlignment", "role", "cardPower", "<init>", "(DDDD)V", "getDeckFit", "()D", "getThemeAlignment", "getRole", "getCardPower", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingBlendWeights {
    public static final int $stable = 0;
    private final double cardPower;
    private final double deckFit;
    private final double role;
    private final double themeAlignment;

    public MTCardRankingBlendWeights() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 15, null);
    }

    public MTCardRankingBlendWeights(double d, double d2, double d3, double d4) {
        this.deckFit = d;
        this.themeAlignment = d2;
        this.role = d3;
        this.cardPower = d4;
    }

    public /* synthetic */ MTCardRankingBlendWeights(double d, double d2, double d3, double d4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3, (i & 8) != 0 ? 0.0d : d4);
    }

    public static /* synthetic */ MTCardRankingBlendWeights copy$default(MTCardRankingBlendWeights mTCardRankingBlendWeights, double d, double d2, double d3, double d4, int i, Object obj) {
        if ((i & 1) != 0) {
            d = mTCardRankingBlendWeights.deckFit;
        }
        double d5 = d;
        if ((i & 2) != 0) {
            d2 = mTCardRankingBlendWeights.themeAlignment;
        }
        double d6 = d2;
        if ((i & 4) != 0) {
            d3 = mTCardRankingBlendWeights.role;
        }
        return mTCardRankingBlendWeights.copy(d5, d6, d3, (i & 8) != 0 ? mTCardRankingBlendWeights.cardPower : d4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getDeckFit() {
        return this.deckFit;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getThemeAlignment() {
        return this.themeAlignment;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getCardPower() {
        return this.cardPower;
    }

    public final MTCardRankingBlendWeights copy(double deckFit, double themeAlignment, double role, double cardPower) {
        return new MTCardRankingBlendWeights(deckFit, themeAlignment, role, cardPower);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingBlendWeights)) {
            return false;
        }
        MTCardRankingBlendWeights mTCardRankingBlendWeights = (MTCardRankingBlendWeights) other;
        return Double.compare(this.deckFit, mTCardRankingBlendWeights.deckFit) == 0 && Double.compare(this.themeAlignment, mTCardRankingBlendWeights.themeAlignment) == 0 && Double.compare(this.role, mTCardRankingBlendWeights.role) == 0 && Double.compare(this.cardPower, mTCardRankingBlendWeights.cardPower) == 0;
    }

    public final double getCardPower() {
        return this.cardPower;
    }

    public final double getDeckFit() {
        return this.deckFit;
    }

    public final double getRole() {
        return this.role;
    }

    public final double getThemeAlignment() {
        return this.themeAlignment;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.deckFit) * 31) + Double.hashCode(this.themeAlignment)) * 31) + Double.hashCode(this.role)) * 31) + Double.hashCode(this.cardPower);
    }

    public String toString() {
        return "MTCardRankingBlendWeights(deckFit=" + this.deckFit + ", themeAlignment=" + this.themeAlignment + ", role=" + this.role + ", cardPower=" + this.cardPower + ")";
    }
}
