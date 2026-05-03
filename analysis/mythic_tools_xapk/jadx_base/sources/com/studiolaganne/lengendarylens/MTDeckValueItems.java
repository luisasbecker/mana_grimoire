package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J=\u0010\u0011\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckValueItems;", "", "main", "", "", "Lcom/studiolaganne/lengendarylens/MTDeckValueDetail;", "sideboard", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getMain", "()Ljava/util/Map;", "setMain", "(Ljava/util/Map;)V", "getSideboard", "setSideboard", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckValueItems {
    public static final int $stable = 8;
    private Map<String, MTDeckValueDetail> main;
    private Map<String, MTDeckValueDetail> sideboard;

    /* JADX WARN: Multi-variable type inference failed */
    public MTDeckValueItems() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTDeckValueItems(Map<String, MTDeckValueDetail> map, Map<String, MTDeckValueDetail> map2) {
        this.main = map;
        this.sideboard = map2;
    }

    public /* synthetic */ MTDeckValueItems(Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTDeckValueItems copy$default(MTDeckValueItems mTDeckValueItems, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = mTDeckValueItems.main;
        }
        if ((i & 2) != 0) {
            map2 = mTDeckValueItems.sideboard;
        }
        return mTDeckValueItems.copy(map, map2);
    }

    public final Map<String, MTDeckValueDetail> component1() {
        return this.main;
    }

    public final Map<String, MTDeckValueDetail> component2() {
        return this.sideboard;
    }

    public final MTDeckValueItems copy(Map<String, MTDeckValueDetail> main, Map<String, MTDeckValueDetail> sideboard) {
        return new MTDeckValueItems(main, sideboard);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckValueItems)) {
            return false;
        }
        MTDeckValueItems mTDeckValueItems = (MTDeckValueItems) other;
        return Intrinsics.areEqual(this.main, mTDeckValueItems.main) && Intrinsics.areEqual(this.sideboard, mTDeckValueItems.sideboard);
    }

    public final Map<String, MTDeckValueDetail> getMain() {
        return this.main;
    }

    public final Map<String, MTDeckValueDetail> getSideboard() {
        return this.sideboard;
    }

    public int hashCode() {
        Map<String, MTDeckValueDetail> map = this.main;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, MTDeckValueDetail> map2 = this.sideboard;
        return iHashCode + (map2 != null ? map2.hashCode() : 0);
    }

    public final void setMain(Map<String, MTDeckValueDetail> map) {
        this.main = map;
    }

    public final void setSideboard(Map<String, MTDeckValueDetail> map) {
        this.sideboard = map;
    }

    public String toString() {
        return "MTDeckValueItems(main=" + this.main + ", sideboard=" + this.sideboard + ")";
    }
}
