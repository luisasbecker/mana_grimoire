package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandCategoryProb;", "", "category", "", "probability", "", "copies", "", "status", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getProbability", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCopies", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandCategoryProb;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardOpeningHandCategoryProb {
    public static final int $stable = 0;
    private final String category;
    private final Integer copies;
    private final Double probability;
    private final String status;

    public MTIdCardOpeningHandCategoryProb() {
        this(null, null, null, null, 15, null);
    }

    public MTIdCardOpeningHandCategoryProb(String str, Double d, Integer num, String str2) {
        this.category = str;
        this.probability = d;
        this.copies = num;
        this.status = str2;
    }

    public /* synthetic */ MTIdCardOpeningHandCategoryProb(String str, Double d, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2);
    }

    public static /* synthetic */ MTIdCardOpeningHandCategoryProb copy$default(MTIdCardOpeningHandCategoryProb mTIdCardOpeningHandCategoryProb, String str, Double d, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardOpeningHandCategoryProb.category;
        }
        if ((i & 2) != 0) {
            d = mTIdCardOpeningHandCategoryProb.probability;
        }
        if ((i & 4) != 0) {
            num = mTIdCardOpeningHandCategoryProb.copies;
        }
        if ((i & 8) != 0) {
            str2 = mTIdCardOpeningHandCategoryProb.status;
        }
        return mTIdCardOpeningHandCategoryProb.copy(str, d, num, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getProbability() {
        return this.probability;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCopies() {
        return this.copies;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final MTIdCardOpeningHandCategoryProb copy(String category, Double probability, Integer copies, String status) {
        return new MTIdCardOpeningHandCategoryProb(category, probability, copies, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardOpeningHandCategoryProb)) {
            return false;
        }
        MTIdCardOpeningHandCategoryProb mTIdCardOpeningHandCategoryProb = (MTIdCardOpeningHandCategoryProb) other;
        return Intrinsics.areEqual(this.category, mTIdCardOpeningHandCategoryProb.category) && Intrinsics.areEqual((Object) this.probability, (Object) mTIdCardOpeningHandCategoryProb.probability) && Intrinsics.areEqual(this.copies, mTIdCardOpeningHandCategoryProb.copies) && Intrinsics.areEqual(this.status, mTIdCardOpeningHandCategoryProb.status);
    }

    public final String getCategory() {
        return this.category;
    }

    public final Integer getCopies() {
        return this.copies;
    }

    public final Double getProbability() {
        return this.probability;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.category;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.probability;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Integer num = this.copies;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.status;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardOpeningHandCategoryProb(category=" + this.category + ", probability=" + this.probability + ", copies=" + this.copies + ", status=" + this.status + ")";
    }
}
