package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardsResponse;", "", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "grouped_cards", "Lcom/studiolaganne/lengendarylens/MTCardGroup;", "pagination", "Lcom/studiolaganne/lengendarylens/MTPagination;", "users", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTPagination;Ljava/util/List;)V", "getCards", "()Ljava/util/List;", "setCards", "(Ljava/util/List;)V", "getGrouped_cards", "setGrouped_cards", "getPagination", "()Lcom/studiolaganne/lengendarylens/MTPagination;", "setPagination", "(Lcom/studiolaganne/lengendarylens/MTPagination;)V", "getUsers", "setUsers", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardsResponse {
    public static final int $stable = 8;
    private List<MTFullCard> cards;
    private List<MTCardGroup> grouped_cards;
    private MTPagination pagination;
    private List<MTPrivacyUser> users;

    public MTCardsResponse() {
        this(null, null, null, null, 15, null);
    }

    public MTCardsResponse(List<MTFullCard> list, List<MTCardGroup> list2, MTPagination mTPagination, List<MTPrivacyUser> list3) {
        this.cards = list;
        this.grouped_cards = list2;
        this.pagination = mTPagination;
        this.users = list3;
    }

    public /* synthetic */ MTCardsResponse(List list, List list2, MTPagination mTPagination, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : mTPagination, (i & 8) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardsResponse copy$default(MTCardsResponse mTCardsResponse, List list, List list2, MTPagination mTPagination, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTCardsResponse.cards;
        }
        if ((i & 2) != 0) {
            list2 = mTCardsResponse.grouped_cards;
        }
        if ((i & 4) != 0) {
            mTPagination = mTCardsResponse.pagination;
        }
        if ((i & 8) != 0) {
            list3 = mTCardsResponse.users;
        }
        return mTCardsResponse.copy(list, list2, mTPagination, list3);
    }

    public final List<MTFullCard> component1() {
        return this.cards;
    }

    public final List<MTCardGroup> component2() {
        return this.grouped_cards;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTPagination getPagination() {
        return this.pagination;
    }

    public final List<MTPrivacyUser> component4() {
        return this.users;
    }

    public final MTCardsResponse copy(List<MTFullCard> cards, List<MTCardGroup> grouped_cards, MTPagination pagination, List<MTPrivacyUser> users) {
        return new MTCardsResponse(cards, grouped_cards, pagination, users);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardsResponse)) {
            return false;
        }
        MTCardsResponse mTCardsResponse = (MTCardsResponse) other;
        return Intrinsics.areEqual(this.cards, mTCardsResponse.cards) && Intrinsics.areEqual(this.grouped_cards, mTCardsResponse.grouped_cards) && Intrinsics.areEqual(this.pagination, mTCardsResponse.pagination) && Intrinsics.areEqual(this.users, mTCardsResponse.users);
    }

    public final List<MTFullCard> getCards() {
        return this.cards;
    }

    public final List<MTCardGroup> getGrouped_cards() {
        return this.grouped_cards;
    }

    public final MTPagination getPagination() {
        return this.pagination;
    }

    public final List<MTPrivacyUser> getUsers() {
        return this.users;
    }

    public int hashCode() {
        List<MTFullCard> list = this.cards;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTCardGroup> list2 = this.grouped_cards;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        MTPagination mTPagination = this.pagination;
        int iHashCode3 = (iHashCode2 + (mTPagination == null ? 0 : mTPagination.hashCode())) * 31;
        List<MTPrivacyUser> list3 = this.users;
        return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setCards(List<MTFullCard> list) {
        this.cards = list;
    }

    public final void setGrouped_cards(List<MTCardGroup> list) {
        this.grouped_cards = list;
    }

    public final void setPagination(MTPagination mTPagination) {
        this.pagination = mTPagination;
    }

    public final void setUsers(List<MTPrivacyUser> list) {
        this.users = list;
    }

    public String toString() {
        return "MTCardsResponse(cards=" + this.cards + ", grouped_cards=" + this.grouped_cards + ", pagination=" + this.pagination + ", users=" + this.users + ")";
    }
}
