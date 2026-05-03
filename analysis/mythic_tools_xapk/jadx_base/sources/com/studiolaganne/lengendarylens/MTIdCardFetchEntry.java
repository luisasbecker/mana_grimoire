package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardFetchEntry;", "", "name", "", "oracleId", "searchesFor", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getOracleId", "getSearchesFor", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardFetchEntry {
    public static final int $stable = 8;
    private final String name;
    private final String oracleId;
    private final List<String> searchesFor;

    public MTIdCardFetchEntry() {
        this(null, null, null, 7, null);
    }

    public MTIdCardFetchEntry(String str, String str2, List<String> list) {
        this.name = str;
        this.oracleId = str2;
        this.searchesFor = list;
    }

    public /* synthetic */ MTIdCardFetchEntry(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardFetchEntry copy$default(MTIdCardFetchEntry mTIdCardFetchEntry, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardFetchEntry.name;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardFetchEntry.oracleId;
        }
        if ((i & 4) != 0) {
            list = mTIdCardFetchEntry.searchesFor;
        }
        return mTIdCardFetchEntry.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOracleId() {
        return this.oracleId;
    }

    public final List<String> component3() {
        return this.searchesFor;
    }

    public final MTIdCardFetchEntry copy(String name, String oracleId, List<String> searchesFor) {
        return new MTIdCardFetchEntry(name, oracleId, searchesFor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardFetchEntry)) {
            return false;
        }
        MTIdCardFetchEntry mTIdCardFetchEntry = (MTIdCardFetchEntry) other;
        return Intrinsics.areEqual(this.name, mTIdCardFetchEntry.name) && Intrinsics.areEqual(this.oracleId, mTIdCardFetchEntry.oracleId) && Intrinsics.areEqual(this.searchesFor, mTIdCardFetchEntry.searchesFor);
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracleId() {
        return this.oracleId;
    }

    public final List<String> getSearchesFor() {
        return this.searchesFor;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.oracleId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.searchesFor;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardFetchEntry(name=" + this.name + ", oracleId=" + this.oracleId + ", searchesFor=" + this.searchesFor + ")";
    }
}
