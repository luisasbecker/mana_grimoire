package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckListTxtParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JW\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/ParsedCard;", "", FirebaseAnalytics.Param.QUANTITY, "", "cardName", "", "setCode", "collectorNumber", "finish", "mtgoId", "section", "Lcom/studiolaganne/lengendarylens/CardSection;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/CardSection;)V", "getQuantity", "()I", "getCardName", "()Ljava/lang/String;", "getSetCode", "getCollectorNumber", "getFinish", "getMtgoId", "getSection", "()Lcom/studiolaganne/lengendarylens/CardSection;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ParsedCard {
    public static final int $stable = 0;
    private final String cardName;
    private final String collectorNumber;
    private final String finish;
    private final String mtgoId;
    private final int quantity;
    private final CardSection section;
    private final String setCode;

    public ParsedCard(int i, String cardName, String str, String str2, String str3, String str4, CardSection section) {
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        Intrinsics.checkNotNullParameter(section, "section");
        this.quantity = i;
        this.cardName = cardName;
        this.setCode = str;
        this.collectorNumber = str2;
        this.finish = str3;
        this.mtgoId = str4;
        this.section = section;
    }

    public /* synthetic */ ParsedCard(int i, String str, String str2, String str3, String str4, String str5, CardSection cardSection, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? CardSection.MAIN_DECK : cardSection);
    }

    public static /* synthetic */ ParsedCard copy$default(ParsedCard parsedCard, int i, String str, String str2, String str3, String str4, String str5, CardSection cardSection, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = parsedCard.quantity;
        }
        if ((i2 & 2) != 0) {
            str = parsedCard.cardName;
        }
        if ((i2 & 4) != 0) {
            str2 = parsedCard.setCode;
        }
        if ((i2 & 8) != 0) {
            str3 = parsedCard.collectorNumber;
        }
        if ((i2 & 16) != 0) {
            str4 = parsedCard.finish;
        }
        if ((i2 & 32) != 0) {
            str5 = parsedCard.mtgoId;
        }
        if ((i2 & 64) != 0) {
            cardSection = parsedCard.section;
        }
        String str6 = str5;
        CardSection cardSection2 = cardSection;
        String str7 = str4;
        String str8 = str2;
        return parsedCard.copy(i, str, str8, str3, str7, str6, cardSection2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCardName() {
        return this.cardName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSetCode() {
        return this.setCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCollectorNumber() {
        return this.collectorNumber;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFinish() {
        return this.finish;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMtgoId() {
        return this.mtgoId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final CardSection getSection() {
        return this.section;
    }

    public final ParsedCard copy(int quantity, String cardName, String setCode, String collectorNumber, String finish, String mtgoId, CardSection section) {
        Intrinsics.checkNotNullParameter(cardName, "cardName");
        Intrinsics.checkNotNullParameter(section, "section");
        return new ParsedCard(quantity, cardName, setCode, collectorNumber, finish, mtgoId, section);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedCard)) {
            return false;
        }
        ParsedCard parsedCard = (ParsedCard) other;
        return this.quantity == parsedCard.quantity && Intrinsics.areEqual(this.cardName, parsedCard.cardName) && Intrinsics.areEqual(this.setCode, parsedCard.setCode) && Intrinsics.areEqual(this.collectorNumber, parsedCard.collectorNumber) && Intrinsics.areEqual(this.finish, parsedCard.finish) && Intrinsics.areEqual(this.mtgoId, parsedCard.mtgoId) && this.section == parsedCard.section;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final String getCollectorNumber() {
        return this.collectorNumber;
    }

    public final String getFinish() {
        return this.finish;
    }

    public final String getMtgoId() {
        return this.mtgoId;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final CardSection getSection() {
        return this.section;
    }

    public final String getSetCode() {
        return this.setCode;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.quantity) * 31) + this.cardName.hashCode()) * 31;
        String str = this.setCode;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.collectorNumber;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.finish;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mtgoId;
        return ((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.section.hashCode();
    }

    public String toString() {
        return "ParsedCard(quantity=" + this.quantity + ", cardName=" + this.cardName + ", setCode=" + this.setCode + ", collectorNumber=" + this.collectorNumber + ", finish=" + this.finish + ", mtgoId=" + this.mtgoId + ", section=" + this.section + ")";
    }
}
