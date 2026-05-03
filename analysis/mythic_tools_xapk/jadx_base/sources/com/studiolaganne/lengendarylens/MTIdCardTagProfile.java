package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardTagProfile;", "", "dominant", "", "Lcom/studiolaganne/lengendarylens/MTIdCardTagCategory;", "notable", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getDominant", "()Ljava/util/List;", "getNotable", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardTagProfile {
    public static final int $stable = 8;
    private final List<MTIdCardTagCategory> dominant;
    private final List<MTIdCardTagCategory> notable;

    /* JADX WARN: Multi-variable type inference failed */
    public MTIdCardTagProfile() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTIdCardTagProfile(List<MTIdCardTagCategory> list, List<MTIdCardTagCategory> list2) {
        this.dominant = list;
        this.notable = list2;
    }

    public /* synthetic */ MTIdCardTagProfile(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardTagProfile copy$default(MTIdCardTagProfile mTIdCardTagProfile, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTIdCardTagProfile.dominant;
        }
        if ((i & 2) != 0) {
            list2 = mTIdCardTagProfile.notable;
        }
        return mTIdCardTagProfile.copy(list, list2);
    }

    public final List<MTIdCardTagCategory> component1() {
        return this.dominant;
    }

    public final List<MTIdCardTagCategory> component2() {
        return this.notable;
    }

    public final MTIdCardTagProfile copy(List<MTIdCardTagCategory> dominant, List<MTIdCardTagCategory> notable) {
        return new MTIdCardTagProfile(dominant, notable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardTagProfile)) {
            return false;
        }
        MTIdCardTagProfile mTIdCardTagProfile = (MTIdCardTagProfile) other;
        return Intrinsics.areEqual(this.dominant, mTIdCardTagProfile.dominant) && Intrinsics.areEqual(this.notable, mTIdCardTagProfile.notable);
    }

    public final List<MTIdCardTagCategory> getDominant() {
        return this.dominant;
    }

    public final List<MTIdCardTagCategory> getNotable() {
        return this.notable;
    }

    public int hashCode() {
        List<MTIdCardTagCategory> list = this.dominant;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTIdCardTagCategory> list2 = this.notable;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardTagProfile(dominant=" + this.dominant + ", notable=" + this.notable + ")";
    }
}
