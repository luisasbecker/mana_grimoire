package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardManaCurveBucket;", "", "cmc", "", "count", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCmc", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCount", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardManaCurveBucket;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardManaCurveBucket {
    public static final int $stable = 0;
    private final Integer cmc;
    private final Integer count;

    /* JADX WARN: Multi-variable type inference failed */
    public MTIdCardManaCurveBucket() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTIdCardManaCurveBucket(Integer num, Integer num2) {
        this.cmc = num;
        this.count = num2;
    }

    public /* synthetic */ MTIdCardManaCurveBucket(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public static /* synthetic */ MTIdCardManaCurveBucket copy$default(MTIdCardManaCurveBucket mTIdCardManaCurveBucket, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardManaCurveBucket.cmc;
        }
        if ((i & 2) != 0) {
            num2 = mTIdCardManaCurveBucket.count;
        }
        return mTIdCardManaCurveBucket.copy(num, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getCmc() {
        return this.cmc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    public final MTIdCardManaCurveBucket copy(Integer cmc, Integer count) {
        return new MTIdCardManaCurveBucket(cmc, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardManaCurveBucket)) {
            return false;
        }
        MTIdCardManaCurveBucket mTIdCardManaCurveBucket = (MTIdCardManaCurveBucket) other;
        return Intrinsics.areEqual(this.cmc, mTIdCardManaCurveBucket.cmc) && Intrinsics.areEqual(this.count, mTIdCardManaCurveBucket.count);
    }

    public final Integer getCmc() {
        return this.cmc;
    }

    public final Integer getCount() {
        return this.count;
    }

    public int hashCode() {
        Integer num = this.cmc;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.count;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardManaCurveBucket(cmc=" + this.cmc + ", count=" + this.count + ")";
    }
}
