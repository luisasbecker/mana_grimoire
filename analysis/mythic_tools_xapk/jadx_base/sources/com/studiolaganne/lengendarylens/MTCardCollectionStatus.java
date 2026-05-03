package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b7\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010>\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0084\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u000bHÖ\u0001J\t\u0010D\u001a\u00020\u000eHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010.\"\u0004\b4\u00100¨\u0006E"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;", "", "in", "", "fetched", "from", "Lcom/studiolaganne/lengendarylens/MTCardSource;", "matches", "Lcom/studiolaganne/lengendarylens/MTCardCollectionMatches;", "in_use", "list_card_id", "", "list_id", "list_name", "", "deck_id", "deck_name", "<init>", "(Ljava/lang/Boolean;ZLcom/studiolaganne/lengendarylens/MTCardSource;Lcom/studiolaganne/lengendarylens/MTCardCollectionMatches;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getIn", "()Ljava/lang/Boolean;", "setIn", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getFetched", "()Z", "setFetched", "(Z)V", "getFrom", "()Lcom/studiolaganne/lengendarylens/MTCardSource;", "setFrom", "(Lcom/studiolaganne/lengendarylens/MTCardSource;)V", "getMatches", "()Lcom/studiolaganne/lengendarylens/MTCardCollectionMatches;", "setMatches", "(Lcom/studiolaganne/lengendarylens/MTCardCollectionMatches;)V", "getIn_use", "setIn_use", "getList_card_id", "()Ljava/lang/Integer;", "setList_card_id", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getList_id", "setList_id", "getList_name", "()Ljava/lang/String;", "setList_name", "(Ljava/lang/String;)V", "getDeck_id", "setDeck_id", "getDeck_name", "setDeck_name", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Boolean;ZLcom/studiolaganne/lengendarylens/MTCardSource;Lcom/studiolaganne/lengendarylens/MTCardCollectionMatches;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTCardCollectionStatus;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardCollectionStatus {
    public static final int $stable = 8;
    private Integer deck_id;
    private String deck_name;
    private boolean fetched;
    private MTCardSource from;
    private Boolean in;
    private Boolean in_use;
    private Integer list_card_id;
    private Integer list_id;
    private String list_name;
    private MTCardCollectionMatches matches;

    public MTCardCollectionStatus() {
        this(null, false, null, null, null, null, null, null, null, null, 1023, null);
    }

    public MTCardCollectionStatus(Boolean bool, boolean z, MTCardSource mTCardSource, MTCardCollectionMatches mTCardCollectionMatches, Boolean bool2, Integer num, Integer num2, String str, Integer num3, String str2) {
        this.in = bool;
        this.fetched = z;
        this.from = mTCardSource;
        this.matches = mTCardCollectionMatches;
        this.in_use = bool2;
        this.list_card_id = num;
        this.list_id = num2;
        this.list_name = str;
        this.deck_id = num3;
        this.deck_name = str2;
    }

    public /* synthetic */ MTCardCollectionStatus(Boolean bool, boolean z, MTCardSource mTCardSource, MTCardCollectionMatches mTCardCollectionMatches, Boolean bool2, Integer num, Integer num2, String str, Integer num3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : mTCardSource, (i & 8) != 0 ? null : mTCardCollectionMatches, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : str, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : str2);
    }

    public static /* synthetic */ MTCardCollectionStatus copy$default(MTCardCollectionStatus mTCardCollectionStatus, Boolean bool, boolean z, MTCardSource mTCardSource, MTCardCollectionMatches mTCardCollectionMatches, Boolean bool2, Integer num, Integer num2, String str, Integer num3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = mTCardCollectionStatus.in;
        }
        if ((i & 2) != 0) {
            z = mTCardCollectionStatus.fetched;
        }
        if ((i & 4) != 0) {
            mTCardSource = mTCardCollectionStatus.from;
        }
        if ((i & 8) != 0) {
            mTCardCollectionMatches = mTCardCollectionStatus.matches;
        }
        if ((i & 16) != 0) {
            bool2 = mTCardCollectionStatus.in_use;
        }
        if ((i & 32) != 0) {
            num = mTCardCollectionStatus.list_card_id;
        }
        if ((i & 64) != 0) {
            num2 = mTCardCollectionStatus.list_id;
        }
        if ((i & 128) != 0) {
            str = mTCardCollectionStatus.list_name;
        }
        if ((i & 256) != 0) {
            num3 = mTCardCollectionStatus.deck_id;
        }
        if ((i & 512) != 0) {
            str2 = mTCardCollectionStatus.deck_name;
        }
        Integer num4 = num3;
        String str3 = str2;
        Integer num5 = num2;
        String str4 = str;
        Boolean bool3 = bool2;
        Integer num6 = num;
        return mTCardCollectionStatus.copy(bool, z, mTCardSource, mTCardCollectionMatches, bool3, num6, num5, str4, num4, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getIn() {
        return this.in;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDeck_name() {
        return this.deck_name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getFetched() {
        return this.fetched;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTCardSource getFrom() {
        return this.from;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTCardCollectionMatches getMatches() {
        return this.matches;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getIn_use() {
        return this.in_use;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getList_id() {
        return this.list_id;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getList_name() {
        return this.list_name;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getDeck_id() {
        return this.deck_id;
    }

    public final MTCardCollectionStatus copy(Boolean in, boolean fetched, MTCardSource from, MTCardCollectionMatches matches, Boolean in_use, Integer list_card_id, Integer list_id, String list_name, Integer deck_id, String deck_name) {
        return new MTCardCollectionStatus(in, fetched, from, matches, in_use, list_card_id, list_id, list_name, deck_id, deck_name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardCollectionStatus)) {
            return false;
        }
        MTCardCollectionStatus mTCardCollectionStatus = (MTCardCollectionStatus) other;
        return Intrinsics.areEqual(this.in, mTCardCollectionStatus.in) && this.fetched == mTCardCollectionStatus.fetched && Intrinsics.areEqual(this.from, mTCardCollectionStatus.from) && Intrinsics.areEqual(this.matches, mTCardCollectionStatus.matches) && Intrinsics.areEqual(this.in_use, mTCardCollectionStatus.in_use) && Intrinsics.areEqual(this.list_card_id, mTCardCollectionStatus.list_card_id) && Intrinsics.areEqual(this.list_id, mTCardCollectionStatus.list_id) && Intrinsics.areEqual(this.list_name, mTCardCollectionStatus.list_name) && Intrinsics.areEqual(this.deck_id, mTCardCollectionStatus.deck_id) && Intrinsics.areEqual(this.deck_name, mTCardCollectionStatus.deck_name);
    }

    public final Integer getDeck_id() {
        return this.deck_id;
    }

    public final String getDeck_name() {
        return this.deck_name;
    }

    public final boolean getFetched() {
        return this.fetched;
    }

    public final MTCardSource getFrom() {
        return this.from;
    }

    public final Boolean getIn() {
        return this.in;
    }

    public final Boolean getIn_use() {
        return this.in_use;
    }

    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    public final Integer getList_id() {
        return this.list_id;
    }

    public final String getList_name() {
        return this.list_name;
    }

    public final MTCardCollectionMatches getMatches() {
        return this.matches;
    }

    public int hashCode() {
        Boolean bool = this.in;
        int iHashCode = (((bool == null ? 0 : bool.hashCode()) * 31) + Boolean.hashCode(this.fetched)) * 31;
        MTCardSource mTCardSource = this.from;
        int iHashCode2 = (iHashCode + (mTCardSource == null ? 0 : mTCardSource.hashCode())) * 31;
        MTCardCollectionMatches mTCardCollectionMatches = this.matches;
        int iHashCode3 = (iHashCode2 + (mTCardCollectionMatches == null ? 0 : mTCardCollectionMatches.hashCode())) * 31;
        Boolean bool2 = this.in_use;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.list_card_id;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.list_id;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.list_name;
        int iHashCode7 = (iHashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.deck_id;
        int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.deck_name;
        return iHashCode8 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setDeck_id(Integer num) {
        this.deck_id = num;
    }

    public final void setDeck_name(String str) {
        this.deck_name = str;
    }

    public final void setFetched(boolean z) {
        this.fetched = z;
    }

    public final void setFrom(MTCardSource mTCardSource) {
        this.from = mTCardSource;
    }

    public final void setIn(Boolean bool) {
        this.in = bool;
    }

    public final void setIn_use(Boolean bool) {
        this.in_use = bool;
    }

    public final void setList_card_id(Integer num) {
        this.list_card_id = num;
    }

    public final void setList_id(Integer num) {
        this.list_id = num;
    }

    public final void setList_name(String str) {
        this.list_name = str;
    }

    public final void setMatches(MTCardCollectionMatches mTCardCollectionMatches) {
        this.matches = mTCardCollectionMatches;
    }

    public String toString() {
        return "MTCardCollectionStatus(in=" + this.in + ", fetched=" + this.fetched + ", from=" + this.from + ", matches=" + this.matches + ", in_use=" + this.in_use + ", list_card_id=" + this.list_card_id + ", list_id=" + this.list_id + ", list_name=" + this.list_name + ", deck_id=" + this.deck_id + ", deck_name=" + this.deck_name + ")";
    }
}
