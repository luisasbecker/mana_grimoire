package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardHardToCastCard;", "", "name", "", "manaCost", "probability", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getName", "()Ljava/lang/String;", "getManaCost", "getProbability", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardHardToCastCard;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardHardToCastCard {
    public static final int $stable = 0;
    private final String manaCost;
    private final String name;
    private final Double probability;

    public MTIdCardHardToCastCard() {
        this(null, null, null, 7, null);
    }

    public MTIdCardHardToCastCard(String str, String str2, Double d) {
        this.name = str;
        this.manaCost = str2;
        this.probability = d;
    }

    public /* synthetic */ MTIdCardHardToCastCard(String str, String str2, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : d);
    }

    public static /* synthetic */ MTIdCardHardToCastCard copy$default(MTIdCardHardToCastCard mTIdCardHardToCastCard, String str, String str2, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardHardToCastCard.name;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardHardToCastCard.manaCost;
        }
        if ((i & 4) != 0) {
            d = mTIdCardHardToCastCard.probability;
        }
        return mTIdCardHardToCastCard.copy(str, str2, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getManaCost() {
        return this.manaCost;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getProbability() {
        return this.probability;
    }

    public final MTIdCardHardToCastCard copy(String name, String manaCost, Double probability) {
        return new MTIdCardHardToCastCard(name, manaCost, probability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardHardToCastCard)) {
            return false;
        }
        MTIdCardHardToCastCard mTIdCardHardToCastCard = (MTIdCardHardToCastCard) other;
        return Intrinsics.areEqual(this.name, mTIdCardHardToCastCard.name) && Intrinsics.areEqual(this.manaCost, mTIdCardHardToCastCard.manaCost) && Intrinsics.areEqual((Object) this.probability, (Object) mTIdCardHardToCastCard.probability);
    }

    public final String getManaCost() {
        return this.manaCost;
    }

    public final String getName() {
        return this.name;
    }

    public final Double getProbability() {
        return this.probability;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.manaCost;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d = this.probability;
        return iHashCode2 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardHardToCastCard(name=" + this.name + ", manaCost=" + this.manaCost + ", probability=" + this.probability + ")";
    }
}
