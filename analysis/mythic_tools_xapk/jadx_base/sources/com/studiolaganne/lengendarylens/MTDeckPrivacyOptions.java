package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;", "", "share_stats", "", "share_games", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getShare_stats", "()Ljava/lang/Boolean;", "setShare_stats", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getShare_games", "setShare_games", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTDeckPrivacyOptions;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckPrivacyOptions {
    public static final int $stable = 8;
    private Boolean share_games;
    private Boolean share_stats;

    /* JADX WARN: Multi-variable type inference failed */
    public MTDeckPrivacyOptions() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTDeckPrivacyOptions(Boolean bool, Boolean bool2) {
        this.share_stats = bool;
        this.share_games = bool2;
    }

    public /* synthetic */ MTDeckPrivacyOptions(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2);
    }

    public static /* synthetic */ MTDeckPrivacyOptions copy$default(MTDeckPrivacyOptions mTDeckPrivacyOptions, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = mTDeckPrivacyOptions.share_stats;
        }
        if ((i & 2) != 0) {
            bool2 = mTDeckPrivacyOptions.share_games;
        }
        return mTDeckPrivacyOptions.copy(bool, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getShare_stats() {
        return this.share_stats;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getShare_games() {
        return this.share_games;
    }

    public final MTDeckPrivacyOptions copy(Boolean share_stats, Boolean share_games) {
        return new MTDeckPrivacyOptions(share_stats, share_games);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckPrivacyOptions)) {
            return false;
        }
        MTDeckPrivacyOptions mTDeckPrivacyOptions = (MTDeckPrivacyOptions) other;
        return Intrinsics.areEqual(this.share_stats, mTDeckPrivacyOptions.share_stats) && Intrinsics.areEqual(this.share_games, mTDeckPrivacyOptions.share_games);
    }

    public final Boolean getShare_games() {
        return this.share_games;
    }

    public final Boolean getShare_stats() {
        return this.share_stats;
    }

    public int hashCode() {
        Boolean bool = this.share_stats;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.share_games;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setShare_games(Boolean bool) {
        this.share_games = bool;
    }

    public final void setShare_stats(Boolean bool) {
        this.share_stats = bool;
    }

    public String toString() {
        return "MTDeckPrivacyOptions(share_stats=" + this.share_stats + ", share_games=" + this.share_games + ")";
    }
}
