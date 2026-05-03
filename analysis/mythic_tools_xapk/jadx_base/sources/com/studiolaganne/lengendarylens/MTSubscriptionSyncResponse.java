package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001eB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSubscriptionSyncResponse;", "", "success", "", "synced", "mythicPlus", "Lcom/studiolaganne/lengendarylens/MTSubscriptionSyncResponse$MythicPlusStatus;", "allDecksSmart", "<init>", "(ZZLcom/studiolaganne/lengendarylens/MTSubscriptionSyncResponse$MythicPlusStatus;Ljava/lang/Boolean;)V", "getSuccess", "()Z", "getSynced", "getMythicPlus", "()Lcom/studiolaganne/lengendarylens/MTSubscriptionSyncResponse$MythicPlusStatus;", "getAllDecksSmart", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(ZZLcom/studiolaganne/lengendarylens/MTSubscriptionSyncResponse$MythicPlusStatus;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTSubscriptionSyncResponse;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "MythicPlusStatus", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSubscriptionSyncResponse {
    public static final int $stable = 0;
    private final Boolean allDecksSmart;
    private final MythicPlusStatus mythicPlus;
    private final boolean success;
    private final boolean synced;

    /* JADX INFO: compiled from: MTApi.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSubscriptionSyncResponse$MythicPlusStatus;", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "expiresAt", "", "willRenew", "<init>", "(ZLjava/lang/String;Ljava/lang/Boolean;)V", "getActive", "()Z", "getExpiresAt", "()Ljava/lang/String;", "getWillRenew", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(ZLjava/lang/String;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTSubscriptionSyncResponse$MythicPlusStatus;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MythicPlusStatus {
        public static final int $stable = 0;
        private final boolean active;
        private final String expiresAt;
        private final Boolean willRenew;

        public MythicPlusStatus(boolean z, String str, Boolean bool) {
            this.active = z;
            this.expiresAt = str;
            this.willRenew = bool;
        }

        public static /* synthetic */ MythicPlusStatus copy$default(MythicPlusStatus mythicPlusStatus, boolean z, String str, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                z = mythicPlusStatus.active;
            }
            if ((i & 2) != 0) {
                str = mythicPlusStatus.expiresAt;
            }
            if ((i & 4) != 0) {
                bool = mythicPlusStatus.willRenew;
            }
            return mythicPlusStatus.copy(z, str, bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getActive() {
            return this.active;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getExpiresAt() {
            return this.expiresAt;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getWillRenew() {
            return this.willRenew;
        }

        public final MythicPlusStatus copy(boolean active, String expiresAt, Boolean willRenew) {
            return new MythicPlusStatus(active, expiresAt, willRenew);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MythicPlusStatus)) {
                return false;
            }
            MythicPlusStatus mythicPlusStatus = (MythicPlusStatus) other;
            return this.active == mythicPlusStatus.active && Intrinsics.areEqual(this.expiresAt, mythicPlusStatus.expiresAt) && Intrinsics.areEqual(this.willRenew, mythicPlusStatus.willRenew);
        }

        public final boolean getActive() {
            return this.active;
        }

        public final String getExpiresAt() {
            return this.expiresAt;
        }

        public final Boolean getWillRenew() {
            return this.willRenew;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.active) * 31;
            String str = this.expiresAt;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.willRenew;
            return iHashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "MythicPlusStatus(active=" + this.active + ", expiresAt=" + this.expiresAt + ", willRenew=" + this.willRenew + ")";
        }
    }

    public MTSubscriptionSyncResponse(boolean z, boolean z2, MythicPlusStatus mythicPlusStatus, Boolean bool) {
        this.success = z;
        this.synced = z2;
        this.mythicPlus = mythicPlusStatus;
        this.allDecksSmart = bool;
    }

    public static /* synthetic */ MTSubscriptionSyncResponse copy$default(MTSubscriptionSyncResponse mTSubscriptionSyncResponse, boolean z, boolean z2, MythicPlusStatus mythicPlusStatus, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            z = mTSubscriptionSyncResponse.success;
        }
        if ((i & 2) != 0) {
            z2 = mTSubscriptionSyncResponse.synced;
        }
        if ((i & 4) != 0) {
            mythicPlusStatus = mTSubscriptionSyncResponse.mythicPlus;
        }
        if ((i & 8) != 0) {
            bool = mTSubscriptionSyncResponse.allDecksSmart;
        }
        return mTSubscriptionSyncResponse.copy(z, z2, mythicPlusStatus, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSynced() {
        return this.synced;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MythicPlusStatus getMythicPlus() {
        return this.mythicPlus;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getAllDecksSmart() {
        return this.allDecksSmart;
    }

    public final MTSubscriptionSyncResponse copy(boolean success, boolean synced, MythicPlusStatus mythicPlus, Boolean allDecksSmart) {
        return new MTSubscriptionSyncResponse(success, synced, mythicPlus, allDecksSmart);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSubscriptionSyncResponse)) {
            return false;
        }
        MTSubscriptionSyncResponse mTSubscriptionSyncResponse = (MTSubscriptionSyncResponse) other;
        return this.success == mTSubscriptionSyncResponse.success && this.synced == mTSubscriptionSyncResponse.synced && Intrinsics.areEqual(this.mythicPlus, mTSubscriptionSyncResponse.mythicPlus) && Intrinsics.areEqual(this.allDecksSmart, mTSubscriptionSyncResponse.allDecksSmart);
    }

    public final Boolean getAllDecksSmart() {
        return this.allDecksSmart;
    }

    public final MythicPlusStatus getMythicPlus() {
        return this.mythicPlus;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final boolean getSynced() {
        return this.synced;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.success) * 31) + Boolean.hashCode(this.synced)) * 31;
        MythicPlusStatus mythicPlusStatus = this.mythicPlus;
        int iHashCode2 = (iHashCode + (mythicPlusStatus == null ? 0 : mythicPlusStatus.hashCode())) * 31;
        Boolean bool = this.allDecksSmart;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "MTSubscriptionSyncResponse(success=" + this.success + ", synced=" + this.synced + ", mythicPlus=" + this.mythicPlus + ", allDecksSmart=" + this.allDecksSmart + ")";
    }
}
