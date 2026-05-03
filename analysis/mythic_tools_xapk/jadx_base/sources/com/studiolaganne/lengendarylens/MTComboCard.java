package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTComboCard;", "", "oracleId", "", "name", "zone", FirebaseAnalytics.Param.QUANTITY, "", "inDeck", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getOracleId", "()Ljava/lang/String;", "getName", "getZone", "getQuantity", "()I", "getInDeck", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTComboCard {
    public static final int $stable = 0;
    private final boolean inDeck;
    private final String name;
    private final String oracleId;
    private final int quantity;
    private final String zone;

    public MTComboCard() {
        this(null, null, null, 0, false, 31, null);
    }

    public MTComboCard(String oracleId, String name, String zone, int i, boolean z) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(zone, "zone");
        this.oracleId = oracleId;
        this.name = name;
        this.zone = zone;
        this.quantity = i;
        this.inDeck = z;
    }

    public /* synthetic */ MTComboCard(String str, String str2, String str3, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z);
    }

    public static /* synthetic */ MTComboCard copy$default(MTComboCard mTComboCard, String str, String str2, String str3, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mTComboCard.oracleId;
        }
        if ((i2 & 2) != 0) {
            str2 = mTComboCard.name;
        }
        if ((i2 & 4) != 0) {
            str3 = mTComboCard.zone;
        }
        if ((i2 & 8) != 0) {
            i = mTComboCard.quantity;
        }
        if ((i2 & 16) != 0) {
            z = mTComboCard.inDeck;
        }
        boolean z2 = z;
        String str4 = str3;
        return mTComboCard.copy(str, str2, str4, i, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOracleId() {
        return this.oracleId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getZone() {
        return this.zone;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getInDeck() {
        return this.inDeck;
    }

    public final MTComboCard copy(String oracleId, String name, String zone, int quantity, boolean inDeck) {
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(zone, "zone");
        return new MTComboCard(oracleId, name, zone, quantity, inDeck);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTComboCard)) {
            return false;
        }
        MTComboCard mTComboCard = (MTComboCard) other;
        return Intrinsics.areEqual(this.oracleId, mTComboCard.oracleId) && Intrinsics.areEqual(this.name, mTComboCard.name) && Intrinsics.areEqual(this.zone, mTComboCard.zone) && this.quantity == mTComboCard.quantity && this.inDeck == mTComboCard.inDeck;
    }

    public final boolean getInDeck() {
        return this.inDeck;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracleId() {
        return this.oracleId;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final String getZone() {
        return this.zone;
    }

    public int hashCode() {
        return (((((((this.oracleId.hashCode() * 31) + this.name.hashCode()) * 31) + this.zone.hashCode()) * 31) + Integer.hashCode(this.quantity)) * 31) + Boolean.hashCode(this.inDeck);
    }

    public String toString() {
        return "MTComboCard(oracleId=" + this.oracleId + ", name=" + this.name + ", zone=" + this.zone + ", quantity=" + this.quantity + ", inDeck=" + this.inDeck + ")";
    }
}
