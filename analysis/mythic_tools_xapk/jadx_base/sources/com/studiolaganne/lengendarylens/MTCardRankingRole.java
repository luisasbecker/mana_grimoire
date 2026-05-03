package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingRole;", "", "id", "", "deckTier", "deckCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getDeckTier", "getDeckCount", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingRole {
    public static final int $stable = 0;
    private final int deckCount;
    private final String deckTier;
    private final String id;

    public MTCardRankingRole() {
        this(null, null, 0, 7, null);
    }

    public MTCardRankingRole(String str, String str2, int i) {
        this.id = str;
        this.deckTier = str2;
        this.deckCount = i;
    }

    public /* synthetic */ MTCardRankingRole(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ MTCardRankingRole copy$default(MTCardRankingRole mTCardRankingRole, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mTCardRankingRole.id;
        }
        if ((i2 & 2) != 0) {
            str2 = mTCardRankingRole.deckTier;
        }
        if ((i2 & 4) != 0) {
            i = mTCardRankingRole.deckCount;
        }
        return mTCardRankingRole.copy(str, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeckTier() {
        return this.deckTier;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDeckCount() {
        return this.deckCount;
    }

    public final MTCardRankingRole copy(String id, String deckTier, int deckCount) {
        return new MTCardRankingRole(id, deckTier, deckCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingRole)) {
            return false;
        }
        MTCardRankingRole mTCardRankingRole = (MTCardRankingRole) other;
        return Intrinsics.areEqual(this.id, mTCardRankingRole.id) && Intrinsics.areEqual(this.deckTier, mTCardRankingRole.deckTier) && this.deckCount == mTCardRankingRole.deckCount;
    }

    public final int getDeckCount() {
        return this.deckCount;
    }

    public final String getDeckTier() {
        return this.deckTier;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deckTier;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.deckCount);
    }

    public String toString() {
        return "MTCardRankingRole(id=" + this.id + ", deckTier=" + this.deckTier + ", deckCount=" + this.deckCount + ")";
    }
}
