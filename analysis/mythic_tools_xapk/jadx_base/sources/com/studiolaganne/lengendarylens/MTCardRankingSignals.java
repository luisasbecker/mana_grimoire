package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingSignals;", "", "deckFit", "Lcom/studiolaganne/lengendarylens/MTCardRankingSignal;", "themeAlignment", "Lcom/studiolaganne/lengendarylens/MTCardRankingThemeAlignment;", "commanderAlignment", "Lcom/studiolaganne/lengendarylens/MTCardRankingCommanderAlignment;", "roleContribution", "Lcom/studiolaganne/lengendarylens/MTCardRankingRoleContribution;", "cardPower", "Lcom/studiolaganne/lengendarylens/MTCardRankingCardPower;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCardRankingSignal;Lcom/studiolaganne/lengendarylens/MTCardRankingThemeAlignment;Lcom/studiolaganne/lengendarylens/MTCardRankingCommanderAlignment;Lcom/studiolaganne/lengendarylens/MTCardRankingRoleContribution;Lcom/studiolaganne/lengendarylens/MTCardRankingCardPower;)V", "getDeckFit", "()Lcom/studiolaganne/lengendarylens/MTCardRankingSignal;", "getThemeAlignment", "()Lcom/studiolaganne/lengendarylens/MTCardRankingThemeAlignment;", "getCommanderAlignment", "()Lcom/studiolaganne/lengendarylens/MTCardRankingCommanderAlignment;", "getRoleContribution", "()Lcom/studiolaganne/lengendarylens/MTCardRankingRoleContribution;", "getCardPower", "()Lcom/studiolaganne/lengendarylens/MTCardRankingCardPower;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingSignals {
    public static final int $stable = 8;
    private final MTCardRankingCardPower cardPower;
    private final MTCardRankingCommanderAlignment commanderAlignment;
    private final MTCardRankingSignal deckFit;
    private final MTCardRankingRoleContribution roleContribution;
    private final MTCardRankingThemeAlignment themeAlignment;

    public MTCardRankingSignals() {
        this(null, null, null, null, null, 31, null);
    }

    public MTCardRankingSignals(MTCardRankingSignal mTCardRankingSignal, MTCardRankingThemeAlignment mTCardRankingThemeAlignment, MTCardRankingCommanderAlignment mTCardRankingCommanderAlignment, MTCardRankingRoleContribution mTCardRankingRoleContribution, MTCardRankingCardPower mTCardRankingCardPower) {
        this.deckFit = mTCardRankingSignal;
        this.themeAlignment = mTCardRankingThemeAlignment;
        this.commanderAlignment = mTCardRankingCommanderAlignment;
        this.roleContribution = mTCardRankingRoleContribution;
        this.cardPower = mTCardRankingCardPower;
    }

    public /* synthetic */ MTCardRankingSignals(MTCardRankingSignal mTCardRankingSignal, MTCardRankingThemeAlignment mTCardRankingThemeAlignment, MTCardRankingCommanderAlignment mTCardRankingCommanderAlignment, MTCardRankingRoleContribution mTCardRankingRoleContribution, MTCardRankingCardPower mTCardRankingCardPower, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTCardRankingSignal, (i & 2) != 0 ? null : mTCardRankingThemeAlignment, (i & 4) != 0 ? null : mTCardRankingCommanderAlignment, (i & 8) != 0 ? null : mTCardRankingRoleContribution, (i & 16) != 0 ? null : mTCardRankingCardPower);
    }

    public static /* synthetic */ MTCardRankingSignals copy$default(MTCardRankingSignals mTCardRankingSignals, MTCardRankingSignal mTCardRankingSignal, MTCardRankingThemeAlignment mTCardRankingThemeAlignment, MTCardRankingCommanderAlignment mTCardRankingCommanderAlignment, MTCardRankingRoleContribution mTCardRankingRoleContribution, MTCardRankingCardPower mTCardRankingCardPower, int i, Object obj) {
        if ((i & 1) != 0) {
            mTCardRankingSignal = mTCardRankingSignals.deckFit;
        }
        if ((i & 2) != 0) {
            mTCardRankingThemeAlignment = mTCardRankingSignals.themeAlignment;
        }
        if ((i & 4) != 0) {
            mTCardRankingCommanderAlignment = mTCardRankingSignals.commanderAlignment;
        }
        if ((i & 8) != 0) {
            mTCardRankingRoleContribution = mTCardRankingSignals.roleContribution;
        }
        if ((i & 16) != 0) {
            mTCardRankingCardPower = mTCardRankingSignals.cardPower;
        }
        MTCardRankingCardPower mTCardRankingCardPower2 = mTCardRankingCardPower;
        MTCardRankingCommanderAlignment mTCardRankingCommanderAlignment2 = mTCardRankingCommanderAlignment;
        return mTCardRankingSignals.copy(mTCardRankingSignal, mTCardRankingThemeAlignment, mTCardRankingCommanderAlignment2, mTCardRankingRoleContribution, mTCardRankingCardPower2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCardRankingSignal getDeckFit() {
        return this.deckFit;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTCardRankingThemeAlignment getThemeAlignment() {
        return this.themeAlignment;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTCardRankingCommanderAlignment getCommanderAlignment() {
        return this.commanderAlignment;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTCardRankingRoleContribution getRoleContribution() {
        return this.roleContribution;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTCardRankingCardPower getCardPower() {
        return this.cardPower;
    }

    public final MTCardRankingSignals copy(MTCardRankingSignal deckFit, MTCardRankingThemeAlignment themeAlignment, MTCardRankingCommanderAlignment commanderAlignment, MTCardRankingRoleContribution roleContribution, MTCardRankingCardPower cardPower) {
        return new MTCardRankingSignals(deckFit, themeAlignment, commanderAlignment, roleContribution, cardPower);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingSignals)) {
            return false;
        }
        MTCardRankingSignals mTCardRankingSignals = (MTCardRankingSignals) other;
        return Intrinsics.areEqual(this.deckFit, mTCardRankingSignals.deckFit) && Intrinsics.areEqual(this.themeAlignment, mTCardRankingSignals.themeAlignment) && Intrinsics.areEqual(this.commanderAlignment, mTCardRankingSignals.commanderAlignment) && Intrinsics.areEqual(this.roleContribution, mTCardRankingSignals.roleContribution) && Intrinsics.areEqual(this.cardPower, mTCardRankingSignals.cardPower);
    }

    public final MTCardRankingCardPower getCardPower() {
        return this.cardPower;
    }

    public final MTCardRankingCommanderAlignment getCommanderAlignment() {
        return this.commanderAlignment;
    }

    public final MTCardRankingSignal getDeckFit() {
        return this.deckFit;
    }

    public final MTCardRankingRoleContribution getRoleContribution() {
        return this.roleContribution;
    }

    public final MTCardRankingThemeAlignment getThemeAlignment() {
        return this.themeAlignment;
    }

    public int hashCode() {
        MTCardRankingSignal mTCardRankingSignal = this.deckFit;
        int iHashCode = (mTCardRankingSignal == null ? 0 : mTCardRankingSignal.hashCode()) * 31;
        MTCardRankingThemeAlignment mTCardRankingThemeAlignment = this.themeAlignment;
        int iHashCode2 = (iHashCode + (mTCardRankingThemeAlignment == null ? 0 : mTCardRankingThemeAlignment.hashCode())) * 31;
        MTCardRankingCommanderAlignment mTCardRankingCommanderAlignment = this.commanderAlignment;
        int iHashCode3 = (iHashCode2 + (mTCardRankingCommanderAlignment == null ? 0 : mTCardRankingCommanderAlignment.hashCode())) * 31;
        MTCardRankingRoleContribution mTCardRankingRoleContribution = this.roleContribution;
        int iHashCode4 = (iHashCode3 + (mTCardRankingRoleContribution == null ? 0 : mTCardRankingRoleContribution.hashCode())) * 31;
        MTCardRankingCardPower mTCardRankingCardPower = this.cardPower;
        return iHashCode4 + (mTCardRankingCardPower != null ? mTCardRankingCardPower.hashCode() : 0);
    }

    public String toString() {
        return "MTCardRankingSignals(deckFit=" + this.deckFit + ", themeAlignment=" + this.themeAlignment + ", commanderAlignment=" + this.commanderAlignment + ", roleContribution=" + this.roleContribution + ", cardPower=" + this.cardPower + ")";
    }
}
