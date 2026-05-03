package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardWinCondition;", "", "type", "", "description", "cards", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getDescription", "getCards", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardWinCondition {
    public static final int $stable = 8;
    private final List<String> cards;
    private final String description;
    private final String type;

    public MTIdCardWinCondition() {
        this(null, null, null, 7, null);
    }

    public MTIdCardWinCondition(String str, String str2, List<String> list) {
        this.type = str;
        this.description = str2;
        this.cards = list;
    }

    public /* synthetic */ MTIdCardWinCondition(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardWinCondition copy$default(MTIdCardWinCondition mTIdCardWinCondition, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardWinCondition.type;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardWinCondition.description;
        }
        if ((i & 4) != 0) {
            list = mTIdCardWinCondition.cards;
        }
        return mTIdCardWinCondition.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<String> component3() {
        return this.cards;
    }

    public final MTIdCardWinCondition copy(String type, String description, List<String> cards) {
        return new MTIdCardWinCondition(type, description, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardWinCondition)) {
            return false;
        }
        MTIdCardWinCondition mTIdCardWinCondition = (MTIdCardWinCondition) other;
        return Intrinsics.areEqual(this.type, mTIdCardWinCondition.type) && Intrinsics.areEqual(this.description, mTIdCardWinCondition.description) && Intrinsics.areEqual(this.cards, mTIdCardWinCondition.cards);
    }

    public final List<String> getCards() {
        return this.cards;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.cards;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardWinCondition(type=" + this.type + ", description=" + this.description + ", cards=" + this.cards + ")";
    }
}
