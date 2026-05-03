package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014JD\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardTagSubtag;", "", ViewHierarchyConstants.TAG_KEY, "", "count", "", "cards", "", "soft", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;)V", "getTag", "()Ljava/lang/String;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCards", "()Ljava/util/List;", "getSoft", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTIdCardTagSubtag;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardTagSubtag {
    public static final int $stable = 8;
    private final List<String> cards;
    private final Integer count;
    private final Boolean soft;
    private final String tag;

    public MTIdCardTagSubtag() {
        this(null, null, null, null, 15, null);
    }

    public MTIdCardTagSubtag(String str, Integer num, List<String> list, Boolean bool) {
        this.tag = str;
        this.count = num;
        this.cards = list;
        this.soft = bool;
    }

    public /* synthetic */ MTIdCardTagSubtag(String str, Integer num, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardTagSubtag copy$default(MTIdCardTagSubtag mTIdCardTagSubtag, String str, Integer num, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardTagSubtag.tag;
        }
        if ((i & 2) != 0) {
            num = mTIdCardTagSubtag.count;
        }
        if ((i & 4) != 0) {
            list = mTIdCardTagSubtag.cards;
        }
        if ((i & 8) != 0) {
            bool = mTIdCardTagSubtag.soft;
        }
        return mTIdCardTagSubtag.copy(str, num, list, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    public final List<String> component3() {
        return this.cards;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getSoft() {
        return this.soft;
    }

    public final MTIdCardTagSubtag copy(String tag, Integer count, List<String> cards, Boolean soft) {
        return new MTIdCardTagSubtag(tag, count, cards, soft);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardTagSubtag)) {
            return false;
        }
        MTIdCardTagSubtag mTIdCardTagSubtag = (MTIdCardTagSubtag) other;
        return Intrinsics.areEqual(this.tag, mTIdCardTagSubtag.tag) && Intrinsics.areEqual(this.count, mTIdCardTagSubtag.count) && Intrinsics.areEqual(this.cards, mTIdCardTagSubtag.cards) && Intrinsics.areEqual(this.soft, mTIdCardTagSubtag.soft);
    }

    public final List<String> getCards() {
        return this.cards;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Boolean getSoft() {
        return this.soft;
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        String str = this.tag;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.count;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list = this.cards;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.soft;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardTagSubtag(tag=" + this.tag + ", count=" + this.count + ", cards=" + this.cards + ", soft=" + this.soft + ")";
    }
}
