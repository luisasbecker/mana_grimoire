package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPrints;", "", "oracle_id", "", "prints", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getOracle_id", "()Ljava/lang/String;", "setOracle_id", "(Ljava/lang/String;)V", "getPrints", "()Ljava/util/List;", "setPrints", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardPrints {
    public static final int $stable = 8;
    private String oracle_id;
    private List<MTFullCard> prints;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCardPrints() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTCardPrints(String str, List<MTFullCard> prints) {
        Intrinsics.checkNotNullParameter(prints, "prints");
        this.oracle_id = str;
        this.prints = prints;
    }

    public /* synthetic */ MTCardPrints(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardPrints copy$default(MTCardPrints mTCardPrints, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTCardPrints.oracle_id;
        }
        if ((i & 2) != 0) {
            list = mTCardPrints.prints;
        }
        return mTCardPrints.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOracle_id() {
        return this.oracle_id;
    }

    public final List<MTFullCard> component2() {
        return this.prints;
    }

    public final MTCardPrints copy(String oracle_id, List<MTFullCard> prints) {
        Intrinsics.checkNotNullParameter(prints, "prints");
        return new MTCardPrints(oracle_id, prints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardPrints)) {
            return false;
        }
        MTCardPrints mTCardPrints = (MTCardPrints) other;
        return Intrinsics.areEqual(this.oracle_id, mTCardPrints.oracle_id) && Intrinsics.areEqual(this.prints, mTCardPrints.prints);
    }

    public final String getOracle_id() {
        return this.oracle_id;
    }

    public final List<MTFullCard> getPrints() {
        return this.prints;
    }

    public int hashCode() {
        String str = this.oracle_id;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.prints.hashCode();
    }

    public final void setOracle_id(String str) {
        this.oracle_id = str;
    }

    public final void setPrints(List<MTFullCard> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.prints = list;
    }

    public String toString() {
        return "MTCardPrints(oracle_id=" + this.oracle_id + ", prints=" + this.prints + ")";
    }
}
