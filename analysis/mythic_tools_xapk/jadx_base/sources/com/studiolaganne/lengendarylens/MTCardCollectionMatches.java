package com.studiolaganne.lengendarylens;

import com.caverock.androidsvg.SVGParser;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardCollectionMatches;", "", "exact", "", "Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;", SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, "has_exact", "", "has_any", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getExact", "()Ljava/util/List;", "setExact", "(Ljava/util/List;)V", "getAll", "setAll", "getHas_exact", "()Ljava/lang/Boolean;", "setHas_exact", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHas_any", "setHas_any", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTCardCollectionMatches;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardCollectionMatches {
    public static final int $stable = 8;
    private List<MTCollectionCardMatch> all;
    private List<MTCollectionCardMatch> exact;
    private Boolean has_any;
    private Boolean has_exact;

    public MTCardCollectionMatches() {
        this(null, null, null, null, 15, null);
    }

    public MTCardCollectionMatches(List<MTCollectionCardMatch> list, List<MTCollectionCardMatch> list2, Boolean bool, Boolean bool2) {
        this.exact = list;
        this.all = list2;
        this.has_exact = bool;
        this.has_any = bool2;
    }

    public /* synthetic */ MTCardCollectionMatches(List list, List list2, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardCollectionMatches copy$default(MTCardCollectionMatches mTCardCollectionMatches, List list, List list2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTCardCollectionMatches.exact;
        }
        if ((i & 2) != 0) {
            list2 = mTCardCollectionMatches.all;
        }
        if ((i & 4) != 0) {
            bool = mTCardCollectionMatches.has_exact;
        }
        if ((i & 8) != 0) {
            bool2 = mTCardCollectionMatches.has_any;
        }
        return mTCardCollectionMatches.copy(list, list2, bool, bool2);
    }

    public final List<MTCollectionCardMatch> component1() {
        return this.exact;
    }

    public final List<MTCollectionCardMatch> component2() {
        return this.all;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getHas_exact() {
        return this.has_exact;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getHas_any() {
        return this.has_any;
    }

    public final MTCardCollectionMatches copy(List<MTCollectionCardMatch> exact, List<MTCollectionCardMatch> all, Boolean has_exact, Boolean has_any) {
        return new MTCardCollectionMatches(exact, all, has_exact, has_any);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardCollectionMatches)) {
            return false;
        }
        MTCardCollectionMatches mTCardCollectionMatches = (MTCardCollectionMatches) other;
        return Intrinsics.areEqual(this.exact, mTCardCollectionMatches.exact) && Intrinsics.areEqual(this.all, mTCardCollectionMatches.all) && Intrinsics.areEqual(this.has_exact, mTCardCollectionMatches.has_exact) && Intrinsics.areEqual(this.has_any, mTCardCollectionMatches.has_any);
    }

    public final List<MTCollectionCardMatch> getAll() {
        return this.all;
    }

    public final List<MTCollectionCardMatch> getExact() {
        return this.exact;
    }

    public final Boolean getHas_any() {
        return this.has_any;
    }

    public final Boolean getHas_exact() {
        return this.has_exact;
    }

    public int hashCode() {
        List<MTCollectionCardMatch> list = this.exact;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTCollectionCardMatch> list2 = this.all;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.has_exact;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.has_any;
        return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setAll(List<MTCollectionCardMatch> list) {
        this.all = list;
    }

    public final void setExact(List<MTCollectionCardMatch> list) {
        this.exact = list;
    }

    public final void setHas_any(Boolean bool) {
        this.has_any = bool;
    }

    public final void setHas_exact(Boolean bool) {
        this.has_exact = bool;
    }

    public String toString() {
        return "MTCardCollectionMatches(exact=" + this.exact + ", all=" + this.all + ", has_exact=" + this.has_exact + ", has_any=" + this.has_any + ")";
    }
}
