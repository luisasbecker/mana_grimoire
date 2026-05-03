package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardComboHighlight;", "", "id", "", "cards", "", "produces", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getCards", "()Ljava/util/List;", "getProduces", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardComboHighlight {
    public static final int $stable = 8;
    private final List<String> cards;
    private final String id;
    private final List<String> produces;

    public MTIdCardComboHighlight() {
        this(null, null, null, 7, null);
    }

    public MTIdCardComboHighlight(String str, List<String> cards, List<String> produces) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(produces, "produces");
        this.id = str;
        this.cards = cards;
        this.produces = produces;
    }

    public /* synthetic */ MTIdCardComboHighlight(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardComboHighlight copy$default(MTIdCardComboHighlight mTIdCardComboHighlight, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardComboHighlight.id;
        }
        if ((i & 2) != 0) {
            list = mTIdCardComboHighlight.cards;
        }
        if ((i & 4) != 0) {
            list2 = mTIdCardComboHighlight.produces;
        }
        return mTIdCardComboHighlight.copy(str, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> component2() {
        return this.cards;
    }

    public final List<String> component3() {
        return this.produces;
    }

    public final MTIdCardComboHighlight copy(String id, List<String> cards, List<String> produces) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(produces, "produces");
        return new MTIdCardComboHighlight(id, cards, produces);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardComboHighlight)) {
            return false;
        }
        MTIdCardComboHighlight mTIdCardComboHighlight = (MTIdCardComboHighlight) other;
        return Intrinsics.areEqual(this.id, mTIdCardComboHighlight.id) && Intrinsics.areEqual(this.cards, mTIdCardComboHighlight.cards) && Intrinsics.areEqual(this.produces, mTIdCardComboHighlight.produces);
    }

    public final List<String> getCards() {
        return this.cards;
    }

    public final String getId() {
        return this.id;
    }

    public final List<String> getProduces() {
        return this.produces;
    }

    public int hashCode() {
        String str = this.id;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.cards.hashCode()) * 31) + this.produces.hashCode();
    }

    public String toString() {
        return "MTIdCardComboHighlight(id=" + this.id + ", cards=" + this.cards + ", produces=" + this.produces + ")";
    }
}
