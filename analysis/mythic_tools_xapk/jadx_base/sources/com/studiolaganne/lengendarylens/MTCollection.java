package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fj\u0004\u0018\u0001`\u000f\u0012&\b\u0002\u0010\u0010\u001a \u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\u001d\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fj\u0004\u0018\u0001`\u000fHÆ\u0003J'\u0010*\u001a \u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f\u0018\u00010\fHÆ\u0003J«\u0001\u0010+\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fj\u0004\u0018\u0001`\u000f2&\b\u0002\u0010\u0010\u001a \u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f\u0018\u00010\fHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\tHÖ\u0001J\t\u00100\u001a\u00020\rHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fj\u0004\u0018\u0001`\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R/\u0010\u0010\u001a \u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!¨\u00061"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCollection;", "", "binders", "", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "boxes", "decks", "sideboards", "total_cards", "", "total_lists", "values", "", "", "Lcom/studiolaganne/lengendarylens/MTCardsValue;", "Lcom/studiolaganne/lengendarylens/MTCardsValues;", "values_by_user", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IILjava/util/Map;Ljava/util/Map;)V", "getBinders", "()Ljava/util/List;", "setBinders", "(Ljava/util/List;)V", "getBoxes", "setBoxes", "getDecks", "setDecks", "getSideboards", "setSideboards", "getTotal_cards", "()I", "getTotal_lists", "getValues", "()Ljava/util/Map;", "getValues_by_user", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCollection {
    public static final int $stable = 8;
    private List<MTCardContainer> binders;
    private List<MTCardContainer> boxes;
    private List<MTCardContainer> decks;
    private List<MTCardContainer> sideboards;
    private final int total_cards;
    private final int total_lists;
    private final Map<String, MTCardsValue> values;
    private final Map<String, Map<String, MTCardsValue>> values_by_user;

    public MTCollection() {
        this(null, null, null, null, 0, 0, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MTCollection(List<MTCardContainer> list, List<MTCardContainer> list2, List<MTCardContainer> list3, List<MTCardContainer> list4, int i, int i2, Map<String, MTCardsValue> map, Map<String, ? extends Map<String, MTCardsValue>> map2) {
        this.binders = list;
        this.boxes = list2;
        this.decks = list3;
        this.sideboards = list4;
        this.total_cards = i;
        this.total_lists = i2;
        this.values = map;
        this.values_by_user = map2;
    }

    public /* synthetic */ MTCollection(List list, List list2, List list3, List list4, int i, int i2, Map map, Map map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list, (i3 & 2) != 0 ? null : list2, (i3 & 4) != 0 ? null : list3, (i3 & 8) != 0 ? null : list4, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? null : map, (i3 & 128) != 0 ? null : map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCollection copy$default(MTCollection mTCollection, List list, List list2, List list3, List list4, int i, int i2, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = mTCollection.binders;
        }
        if ((i3 & 2) != 0) {
            list2 = mTCollection.boxes;
        }
        if ((i3 & 4) != 0) {
            list3 = mTCollection.decks;
        }
        if ((i3 & 8) != 0) {
            list4 = mTCollection.sideboards;
        }
        if ((i3 & 16) != 0) {
            i = mTCollection.total_cards;
        }
        if ((i3 & 32) != 0) {
            i2 = mTCollection.total_lists;
        }
        if ((i3 & 64) != 0) {
            map = mTCollection.values;
        }
        if ((i3 & 128) != 0) {
            map2 = mTCollection.values_by_user;
        }
        Map map3 = map;
        Map map4 = map2;
        int i4 = i;
        int i5 = i2;
        return mTCollection.copy(list, list2, list3, list4, i4, i5, map3, map4);
    }

    public final List<MTCardContainer> component1() {
        return this.binders;
    }

    public final List<MTCardContainer> component2() {
        return this.boxes;
    }

    public final List<MTCardContainer> component3() {
        return this.decks;
    }

    public final List<MTCardContainer> component4() {
        return this.sideboards;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTotal_cards() {
        return this.total_cards;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTotal_lists() {
        return this.total_lists;
    }

    public final Map<String, MTCardsValue> component7() {
        return this.values;
    }

    public final Map<String, Map<String, MTCardsValue>> component8() {
        return this.values_by_user;
    }

    public final MTCollection copy(List<MTCardContainer> binders, List<MTCardContainer> boxes, List<MTCardContainer> decks, List<MTCardContainer> sideboards, int total_cards, int total_lists, Map<String, MTCardsValue> values, Map<String, ? extends Map<String, MTCardsValue>> values_by_user) {
        return new MTCollection(binders, boxes, decks, sideboards, total_cards, total_lists, values, values_by_user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCollection)) {
            return false;
        }
        MTCollection mTCollection = (MTCollection) other;
        return Intrinsics.areEqual(this.binders, mTCollection.binders) && Intrinsics.areEqual(this.boxes, mTCollection.boxes) && Intrinsics.areEqual(this.decks, mTCollection.decks) && Intrinsics.areEqual(this.sideboards, mTCollection.sideboards) && this.total_cards == mTCollection.total_cards && this.total_lists == mTCollection.total_lists && Intrinsics.areEqual(this.values, mTCollection.values) && Intrinsics.areEqual(this.values_by_user, mTCollection.values_by_user);
    }

    public final List<MTCardContainer> getBinders() {
        return this.binders;
    }

    public final List<MTCardContainer> getBoxes() {
        return this.boxes;
    }

    public final List<MTCardContainer> getDecks() {
        return this.decks;
    }

    public final List<MTCardContainer> getSideboards() {
        return this.sideboards;
    }

    public final int getTotal_cards() {
        return this.total_cards;
    }

    public final int getTotal_lists() {
        return this.total_lists;
    }

    public final Map<String, MTCardsValue> getValues() {
        return this.values;
    }

    public final Map<String, Map<String, MTCardsValue>> getValues_by_user() {
        return this.values_by_user;
    }

    public int hashCode() {
        List<MTCardContainer> list = this.binders;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTCardContainer> list2 = this.boxes;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MTCardContainer> list3 = this.decks;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<MTCardContainer> list4 = this.sideboards;
        int iHashCode4 = (((((iHashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31) + Integer.hashCode(this.total_cards)) * 31) + Integer.hashCode(this.total_lists)) * 31;
        Map<String, MTCardsValue> map = this.values;
        int iHashCode5 = (iHashCode4 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Map<String, MTCardsValue>> map2 = this.values_by_user;
        return iHashCode5 + (map2 != null ? map2.hashCode() : 0);
    }

    public final void setBinders(List<MTCardContainer> list) {
        this.binders = list;
    }

    public final void setBoxes(List<MTCardContainer> list) {
        this.boxes = list;
    }

    public final void setDecks(List<MTCardContainer> list) {
        this.decks = list;
    }

    public final void setSideboards(List<MTCardContainer> list) {
        this.sideboards = list;
    }

    public String toString() {
        return "MTCollection(binders=" + this.binders + ", boxes=" + this.boxes + ", decks=" + this.decks + ", sideboards=" + this.sideboards + ", total_cards=" + this.total_cards + ", total_lists=" + this.total_lists + ", values=" + this.values + ", values_by_user=" + this.values_by_user + ")";
    }
}
