package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003Jt\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u0006."}, d2 = {"Lcom/studiolaganne/lengendarylens/CardPriceRow;", "", "type", "", Constants.ScionAnalytics.PARAM_LABEL, "", "eur", "usd", "selected", "", "cardName", "tcgPlayerId", "purchaseURLCardMarket", "purchaseURLTCGPlayer", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getLabel", "()Ljava/lang/String;", "getEur", "getUsd", "getSelected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCardName", "getTcgPlayerId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPurchaseURLCardMarket", "getPurchaseURLTCGPlayer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/CardPriceRow;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardPriceRow {
    public static final int $stable = 0;
    private final String cardName;
    private final String eur;
    private final String label;
    private final String purchaseURLCardMarket;
    private final String purchaseURLTCGPlayer;
    private final Boolean selected;
    private final Integer tcgPlayerId;
    private final int type;
    private final String usd;

    public CardPriceRow(int i, String str, String str2, String str3, Boolean bool, String str4, Integer num, String purchaseURLCardMarket, String purchaseURLTCGPlayer) {
        Intrinsics.checkNotNullParameter(purchaseURLCardMarket, "purchaseURLCardMarket");
        Intrinsics.checkNotNullParameter(purchaseURLTCGPlayer, "purchaseURLTCGPlayer");
        this.type = i;
        this.label = str;
        this.eur = str2;
        this.usd = str3;
        this.selected = bool;
        this.cardName = str4;
        this.tcgPlayerId = num;
        this.purchaseURLCardMarket = purchaseURLCardMarket;
        this.purchaseURLTCGPlayer = purchaseURLTCGPlayer;
    }

    public /* synthetic */ CardPriceRow(int i, String str, String str2, String str3, Boolean bool, String str4, Integer num, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : bool, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? "" : str5, (i2 & 256) != 0 ? "" : str6);
    }

    public static /* synthetic */ CardPriceRow copy$default(CardPriceRow cardPriceRow, int i, String str, String str2, String str3, Boolean bool, String str4, Integer num, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cardPriceRow.type;
        }
        if ((i2 & 2) != 0) {
            str = cardPriceRow.label;
        }
        if ((i2 & 4) != 0) {
            str2 = cardPriceRow.eur;
        }
        if ((i2 & 8) != 0) {
            str3 = cardPriceRow.usd;
        }
        if ((i2 & 16) != 0) {
            bool = cardPriceRow.selected;
        }
        if ((i2 & 32) != 0) {
            str4 = cardPriceRow.cardName;
        }
        if ((i2 & 64) != 0) {
            num = cardPriceRow.tcgPlayerId;
        }
        if ((i2 & 128) != 0) {
            str5 = cardPriceRow.purchaseURLCardMarket;
        }
        if ((i2 & 256) != 0) {
            str6 = cardPriceRow.purchaseURLTCGPlayer;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        Integer num2 = num;
        Boolean bool2 = bool;
        String str10 = str2;
        return cardPriceRow.copy(i, str, str10, str3, bool2, str9, num2, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEur() {
        return this.eur;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUsd() {
        return this.usd;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCardName() {
        return this.cardName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getTcgPlayerId() {
        return this.tcgPlayerId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPurchaseURLCardMarket() {
        return this.purchaseURLCardMarket;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPurchaseURLTCGPlayer() {
        return this.purchaseURLTCGPlayer;
    }

    public final CardPriceRow copy(int type, String label, String eur, String usd, Boolean selected, String cardName, Integer tcgPlayerId, String purchaseURLCardMarket, String purchaseURLTCGPlayer) {
        Intrinsics.checkNotNullParameter(purchaseURLCardMarket, "purchaseURLCardMarket");
        Intrinsics.checkNotNullParameter(purchaseURLTCGPlayer, "purchaseURLTCGPlayer");
        return new CardPriceRow(type, label, eur, usd, selected, cardName, tcgPlayerId, purchaseURLCardMarket, purchaseURLTCGPlayer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardPriceRow)) {
            return false;
        }
        CardPriceRow cardPriceRow = (CardPriceRow) other;
        return this.type == cardPriceRow.type && Intrinsics.areEqual(this.label, cardPriceRow.label) && Intrinsics.areEqual(this.eur, cardPriceRow.eur) && Intrinsics.areEqual(this.usd, cardPriceRow.usd) && Intrinsics.areEqual(this.selected, cardPriceRow.selected) && Intrinsics.areEqual(this.cardName, cardPriceRow.cardName) && Intrinsics.areEqual(this.tcgPlayerId, cardPriceRow.tcgPlayerId) && Intrinsics.areEqual(this.purchaseURLCardMarket, cardPriceRow.purchaseURLCardMarket) && Intrinsics.areEqual(this.purchaseURLTCGPlayer, cardPriceRow.purchaseURLTCGPlayer);
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final String getEur() {
        return this.eur;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getPurchaseURLCardMarket() {
        return this.purchaseURLCardMarket;
    }

    public final String getPurchaseURLTCGPlayer() {
        return this.purchaseURLTCGPlayer;
    }

    public final Boolean getSelected() {
        return this.selected;
    }

    public final Integer getTcgPlayerId() {
        return this.tcgPlayerId;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUsd() {
        return this.usd;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.type) * 31;
        String str = this.label;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.eur;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.usd;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.selected;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.cardName;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.tcgPlayerId;
        return ((((iHashCode6 + (num != null ? num.hashCode() : 0)) * 31) + this.purchaseURLCardMarket.hashCode()) * 31) + this.purchaseURLTCGPlayer.hashCode();
    }

    public String toString() {
        return "CardPriceRow(type=" + this.type + ", label=" + this.label + ", eur=" + this.eur + ", usd=" + this.usd + ", selected=" + this.selected + ", cardName=" + this.cardName + ", tcgPlayerId=" + this.tcgPlayerId + ", purchaseURLCardMarket=" + this.purchaseURLCardMarket + ", purchaseURLTCGPlayer=" + this.purchaseURLTCGPlayer + ")";
    }
}
