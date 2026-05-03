package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardTagCategory;", "", "category", "", "count", "", Constants.ScionAnalytics.PARAM_LABEL, "subtags", "", "Lcom/studiolaganne/lengendarylens/MTIdCardTagSubtag;", "cards", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCategory", "()Ljava/lang/String;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLabel", "getSubtags", "()Ljava/util/List;", "getCards", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardTagCategory;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardTagCategory {
    public static final int $stable = 8;
    private final List<String> cards;
    private final String category;
    private final Integer count;
    private final String label;
    private final List<MTIdCardTagSubtag> subtags;

    public MTIdCardTagCategory() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardTagCategory(String str, Integer num, String str2, List<MTIdCardTagSubtag> list, List<String> list2) {
        this.category = str;
        this.count = num;
        this.label = str2;
        this.subtags = list;
        this.cards = list2;
    }

    public /* synthetic */ MTIdCardTagCategory(String str, Integer num, String str2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardTagCategory copy$default(MTIdCardTagCategory mTIdCardTagCategory, String str, Integer num, String str2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardTagCategory.category;
        }
        if ((i & 2) != 0) {
            num = mTIdCardTagCategory.count;
        }
        if ((i & 4) != 0) {
            str2 = mTIdCardTagCategory.label;
        }
        if ((i & 8) != 0) {
            list = mTIdCardTagCategory.subtags;
        }
        if ((i & 16) != 0) {
            list2 = mTIdCardTagCategory.cards;
        }
        List list3 = list2;
        String str3 = str2;
        return mTIdCardTagCategory.copy(str, num, str3, list, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final List<MTIdCardTagSubtag> component4() {
        return this.subtags;
    }

    public final List<String> component5() {
        return this.cards;
    }

    public final MTIdCardTagCategory copy(String category, Integer count, String label, List<MTIdCardTagSubtag> subtags, List<String> cards) {
        return new MTIdCardTagCategory(category, count, label, subtags, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardTagCategory)) {
            return false;
        }
        MTIdCardTagCategory mTIdCardTagCategory = (MTIdCardTagCategory) other;
        return Intrinsics.areEqual(this.category, mTIdCardTagCategory.category) && Intrinsics.areEqual(this.count, mTIdCardTagCategory.count) && Intrinsics.areEqual(this.label, mTIdCardTagCategory.label) && Intrinsics.areEqual(this.subtags, mTIdCardTagCategory.subtags) && Intrinsics.areEqual(this.cards, mTIdCardTagCategory.cards);
    }

    public final List<String> getCards() {
        return this.cards;
    }

    public final String getCategory() {
        return this.category;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getLabel() {
        return this.label;
    }

    public final List<MTIdCardTagSubtag> getSubtags() {
        return this.subtags;
    }

    public int hashCode() {
        String str = this.category;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.count;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.label;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MTIdCardTagSubtag> list = this.subtags;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.cards;
        return iHashCode4 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardTagCategory(category=" + this.category + ", count=" + this.count + ", label=" + this.label + ", subtags=" + this.subtags + ", cards=" + this.cards + ")";
    }
}
