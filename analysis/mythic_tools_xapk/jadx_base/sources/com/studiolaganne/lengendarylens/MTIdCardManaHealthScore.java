package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J*\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardManaHealthScore;", "", "overall", "", "subscores", "", "Lcom/studiolaganne/lengendarylens/MTIdCardManaSubscore;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "getOverall", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSubscores", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardManaHealthScore;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardManaHealthScore {
    public static final int $stable = 8;
    private final Integer overall;
    private final List<MTIdCardManaSubscore> subscores;

    /* JADX WARN: Multi-variable type inference failed */
    public MTIdCardManaHealthScore() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTIdCardManaHealthScore(Integer num, List<MTIdCardManaSubscore> subscores) {
        Intrinsics.checkNotNullParameter(subscores, "subscores");
        this.overall = num;
        this.subscores = subscores;
    }

    public /* synthetic */ MTIdCardManaHealthScore(Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardManaHealthScore copy$default(MTIdCardManaHealthScore mTIdCardManaHealthScore, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardManaHealthScore.overall;
        }
        if ((i & 2) != 0) {
            list = mTIdCardManaHealthScore.subscores;
        }
        return mTIdCardManaHealthScore.copy(num, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getOverall() {
        return this.overall;
    }

    public final List<MTIdCardManaSubscore> component2() {
        return this.subscores;
    }

    public final MTIdCardManaHealthScore copy(Integer overall, List<MTIdCardManaSubscore> subscores) {
        Intrinsics.checkNotNullParameter(subscores, "subscores");
        return new MTIdCardManaHealthScore(overall, subscores);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardManaHealthScore)) {
            return false;
        }
        MTIdCardManaHealthScore mTIdCardManaHealthScore = (MTIdCardManaHealthScore) other;
        return Intrinsics.areEqual(this.overall, mTIdCardManaHealthScore.overall) && Intrinsics.areEqual(this.subscores, mTIdCardManaHealthScore.subscores);
    }

    public final Integer getOverall() {
        return this.overall;
    }

    public final List<MTIdCardManaSubscore> getSubscores() {
        return this.subscores;
    }

    public int hashCode() {
        Integer num = this.overall;
        return ((num == null ? 0 : num.hashCode()) * 31) + this.subscores.hashCode();
    }

    public String toString() {
        return "MTIdCardManaHealthScore(overall=" + this.overall + ", subscores=" + this.subscores + ")";
    }
}
