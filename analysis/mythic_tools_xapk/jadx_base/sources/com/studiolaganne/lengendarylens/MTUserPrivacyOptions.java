package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUserPrivacyOptions;", "", "share_friend_code", "", "share_games", "share_stats", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getShare_friend_code", "()Ljava/lang/Boolean;", "setShare_friend_code", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getShare_games", "setShare_games", "getShare_stats", "setShare_stats", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTUserPrivacyOptions;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUserPrivacyOptions {
    public static final int $stable = 8;
    private Boolean share_friend_code;
    private Boolean share_games;
    private Boolean share_stats;

    public MTUserPrivacyOptions() {
        this(null, null, null, 7, null);
    }

    public MTUserPrivacyOptions(Boolean bool, Boolean bool2, Boolean bool3) {
        this.share_friend_code = bool;
        this.share_games = bool2;
        this.share_stats = bool3;
    }

    public /* synthetic */ MTUserPrivacyOptions(Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3);
    }

    public static /* synthetic */ MTUserPrivacyOptions copy$default(MTUserPrivacyOptions mTUserPrivacyOptions, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = mTUserPrivacyOptions.share_friend_code;
        }
        if ((i & 2) != 0) {
            bool2 = mTUserPrivacyOptions.share_games;
        }
        if ((i & 4) != 0) {
            bool3 = mTUserPrivacyOptions.share_stats;
        }
        return mTUserPrivacyOptions.copy(bool, bool2, bool3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getShare_friend_code() {
        return this.share_friend_code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getShare_games() {
        return this.share_games;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getShare_stats() {
        return this.share_stats;
    }

    public final MTUserPrivacyOptions copy(Boolean share_friend_code, Boolean share_games, Boolean share_stats) {
        return new MTUserPrivacyOptions(share_friend_code, share_games, share_stats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUserPrivacyOptions)) {
            return false;
        }
        MTUserPrivacyOptions mTUserPrivacyOptions = (MTUserPrivacyOptions) other;
        return Intrinsics.areEqual(this.share_friend_code, mTUserPrivacyOptions.share_friend_code) && Intrinsics.areEqual(this.share_games, mTUserPrivacyOptions.share_games) && Intrinsics.areEqual(this.share_stats, mTUserPrivacyOptions.share_stats);
    }

    public final Boolean getShare_friend_code() {
        return this.share_friend_code;
    }

    public final Boolean getShare_games() {
        return this.share_games;
    }

    public final Boolean getShare_stats() {
        return this.share_stats;
    }

    public int hashCode() {
        Boolean bool = this.share_friend_code;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.share_games;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.share_stats;
        return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final void setShare_friend_code(Boolean bool) {
        this.share_friend_code = bool;
    }

    public final void setShare_games(Boolean bool) {
        this.share_games = bool;
    }

    public final void setShare_stats(Boolean bool) {
        this.share_stats = bool;
    }

    public String toString() {
        return "MTUserPrivacyOptions(share_friend_code=" + this.share_friend_code + ", share_games=" + this.share_games + ", share_stats=" + this.share_stats + ")";
    }
}
