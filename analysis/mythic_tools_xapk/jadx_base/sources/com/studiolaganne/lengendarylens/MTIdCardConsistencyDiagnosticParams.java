package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardConsistencyDiagnosticParams;", "", "probability", "", "cards", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getProbability", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCards", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTIdCardConsistencyDiagnosticParams;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardConsistencyDiagnosticParams {
    public static final int $stable = 0;
    private final String cards;
    private final Integer probability;

    /* JADX WARN: Multi-variable type inference failed */
    public MTIdCardConsistencyDiagnosticParams() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTIdCardConsistencyDiagnosticParams(Integer num, String str) {
        this.probability = num;
        this.cards = str;
    }

    public /* synthetic */ MTIdCardConsistencyDiagnosticParams(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
    }

    public static /* synthetic */ MTIdCardConsistencyDiagnosticParams copy$default(MTIdCardConsistencyDiagnosticParams mTIdCardConsistencyDiagnosticParams, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardConsistencyDiagnosticParams.probability;
        }
        if ((i & 2) != 0) {
            str = mTIdCardConsistencyDiagnosticParams.cards;
        }
        return mTIdCardConsistencyDiagnosticParams.copy(num, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getProbability() {
        return this.probability;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCards() {
        return this.cards;
    }

    public final MTIdCardConsistencyDiagnosticParams copy(Integer probability, String cards) {
        return new MTIdCardConsistencyDiagnosticParams(probability, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardConsistencyDiagnosticParams)) {
            return false;
        }
        MTIdCardConsistencyDiagnosticParams mTIdCardConsistencyDiagnosticParams = (MTIdCardConsistencyDiagnosticParams) other;
        return Intrinsics.areEqual(this.probability, mTIdCardConsistencyDiagnosticParams.probability) && Intrinsics.areEqual(this.cards, mTIdCardConsistencyDiagnosticParams.cards);
    }

    public final String getCards() {
        return this.cards;
    }

    public final Integer getProbability() {
        return this.probability;
    }

    public int hashCode() {
        Integer num = this.probability;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.cards;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardConsistencyDiagnosticParams(probability=" + this.probability + ", cards=" + this.cards + ")";
    }
}
