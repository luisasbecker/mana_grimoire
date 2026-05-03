package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003JN\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardTribalTheme;", "", "creatureType", "", "count", "", "changelingCount", "commanderValidated", "", "cards", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)V", "getCreatureType", "()Ljava/lang/String;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChangelingCount", "getCommanderValidated", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardTribalTheme;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardTribalTheme {
    public static final int $stable = 8;
    private final List<String> cards;
    private final Integer changelingCount;
    private final Boolean commanderValidated;
    private final Integer count;
    private final String creatureType;

    public MTIdCardTribalTheme() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardTribalTheme(String str, Integer num, Integer num2, Boolean bool, List<String> cards) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        this.creatureType = str;
        this.count = num;
        this.changelingCount = num2;
        this.commanderValidated = bool;
        this.cards = cards;
    }

    public /* synthetic */ MTIdCardTribalTheme(String str, Integer num, Integer num2, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardTribalTheme copy$default(MTIdCardTribalTheme mTIdCardTribalTheme, String str, Integer num, Integer num2, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardTribalTheme.creatureType;
        }
        if ((i & 2) != 0) {
            num = mTIdCardTribalTheme.count;
        }
        if ((i & 4) != 0) {
            num2 = mTIdCardTribalTheme.changelingCount;
        }
        if ((i & 8) != 0) {
            bool = mTIdCardTribalTheme.commanderValidated;
        }
        if ((i & 16) != 0) {
            list = mTIdCardTribalTheme.cards;
        }
        List list2 = list;
        Integer num3 = num2;
        return mTIdCardTribalTheme.copy(str, num, num3, bool, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCreatureType() {
        return this.creatureType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getChangelingCount() {
        return this.changelingCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getCommanderValidated() {
        return this.commanderValidated;
    }

    public final List<String> component5() {
        return this.cards;
    }

    public final MTIdCardTribalTheme copy(String creatureType, Integer count, Integer changelingCount, Boolean commanderValidated, List<String> cards) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        return new MTIdCardTribalTheme(creatureType, count, changelingCount, commanderValidated, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardTribalTheme)) {
            return false;
        }
        MTIdCardTribalTheme mTIdCardTribalTheme = (MTIdCardTribalTheme) other;
        return Intrinsics.areEqual(this.creatureType, mTIdCardTribalTheme.creatureType) && Intrinsics.areEqual(this.count, mTIdCardTribalTheme.count) && Intrinsics.areEqual(this.changelingCount, mTIdCardTribalTheme.changelingCount) && Intrinsics.areEqual(this.commanderValidated, mTIdCardTribalTheme.commanderValidated) && Intrinsics.areEqual(this.cards, mTIdCardTribalTheme.cards);
    }

    public final List<String> getCards() {
        return this.cards;
    }

    public final Integer getChangelingCount() {
        return this.changelingCount;
    }

    public final Boolean getCommanderValidated() {
        return this.commanderValidated;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getCreatureType() {
        return this.creatureType;
    }

    public int hashCode() {
        String str = this.creatureType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.count;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.changelingCount;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.commanderValidated;
        return ((iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31) + this.cards.hashCode();
    }

    public String toString() {
        return "MTIdCardTribalTheme(creatureType=" + this.creatureType + ", count=" + this.count + ", changelingCount=" + this.changelingCount + ", commanderValidated=" + this.commanderValidated + ", cards=" + this.cards + ")";
    }
}
