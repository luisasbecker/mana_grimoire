package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J6\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardCombos;", "", "completeCount", "", "partialCount", "highlights", "", "Lcom/studiolaganne/lengendarylens/MTIdCardComboHighlight;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getCompleteCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPartialCount", "getHighlights", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardCombos;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardCombos {
    public static final int $stable = 8;
    private final Integer completeCount;
    private final List<MTIdCardComboHighlight> highlights;
    private final Integer partialCount;

    public MTIdCardCombos() {
        this(null, null, null, 7, null);
    }

    public MTIdCardCombos(Integer num, Integer num2, List<MTIdCardComboHighlight> highlights) {
        Intrinsics.checkNotNullParameter(highlights, "highlights");
        this.completeCount = num;
        this.partialCount = num2;
        this.highlights = highlights;
    }

    public /* synthetic */ MTIdCardCombos(Integer num, Integer num2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardCombos copy$default(MTIdCardCombos mTIdCardCombos, Integer num, Integer num2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardCombos.completeCount;
        }
        if ((i & 2) != 0) {
            num2 = mTIdCardCombos.partialCount;
        }
        if ((i & 4) != 0) {
            list = mTIdCardCombos.highlights;
        }
        return mTIdCardCombos.copy(num, num2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getCompleteCount() {
        return this.completeCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getPartialCount() {
        return this.partialCount;
    }

    public final List<MTIdCardComboHighlight> component3() {
        return this.highlights;
    }

    public final MTIdCardCombos copy(Integer completeCount, Integer partialCount, List<MTIdCardComboHighlight> highlights) {
        Intrinsics.checkNotNullParameter(highlights, "highlights");
        return new MTIdCardCombos(completeCount, partialCount, highlights);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardCombos)) {
            return false;
        }
        MTIdCardCombos mTIdCardCombos = (MTIdCardCombos) other;
        return Intrinsics.areEqual(this.completeCount, mTIdCardCombos.completeCount) && Intrinsics.areEqual(this.partialCount, mTIdCardCombos.partialCount) && Intrinsics.areEqual(this.highlights, mTIdCardCombos.highlights);
    }

    public final Integer getCompleteCount() {
        return this.completeCount;
    }

    public final List<MTIdCardComboHighlight> getHighlights() {
        return this.highlights;
    }

    public final Integer getPartialCount() {
        return this.partialCount;
    }

    public int hashCode() {
        Integer num = this.completeCount;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.partialCount;
        return ((iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31) + this.highlights.hashCode();
    }

    public String toString() {
        return "MTIdCardCombos(completeCount=" + this.completeCount + ", partialCount=" + this.partialCount + ", highlights=" + this.highlights + ")";
    }
}
