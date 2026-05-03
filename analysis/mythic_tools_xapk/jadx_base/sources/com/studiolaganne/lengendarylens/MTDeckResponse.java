package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003JI\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckResponse;", "", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "games", "", "Lcom/studiolaganne/lengendarylens/MTGame;", "lists", "Lcom/studiolaganne/lengendarylens/MTDeckLists;", "privacy", "Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;", "user", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTDeck;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTDeckLists;Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "getDeck", "()Lcom/studiolaganne/lengendarylens/MTDeck;", "setDeck", "(Lcom/studiolaganne/lengendarylens/MTDeck;)V", "getGames", "()Ljava/util/List;", "setGames", "(Ljava/util/List;)V", "getLists", "()Lcom/studiolaganne/lengendarylens/MTDeckLists;", "setLists", "(Lcom/studiolaganne/lengendarylens/MTDeckLists;)V", "getPrivacy", "()Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;", "setPrivacy", "(Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;)V", "getUser", "()Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "setUser", "(Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckResponse {
    public static final int $stable = 8;
    private MTDeck deck;
    private List<MTGame> games;
    private MTDeckLists lists;
    private MTDeckPrivacy privacy;
    private MTPrivacyUser user;

    public MTDeckResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public MTDeckResponse(MTDeck mTDeck, List<MTGame> games, MTDeckLists mTDeckLists, MTDeckPrivacy mTDeckPrivacy, MTPrivacyUser mTPrivacyUser) {
        Intrinsics.checkNotNullParameter(games, "games");
        this.deck = mTDeck;
        this.games = games;
        this.lists = mTDeckLists;
        this.privacy = mTDeckPrivacy;
        this.user = mTPrivacyUser;
    }

    public /* synthetic */ MTDeckResponse(MTDeck mTDeck, List list, MTDeckLists mTDeckLists, MTDeckPrivacy mTDeckPrivacy, MTPrivacyUser mTPrivacyUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTDeck, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : mTDeckLists, (i & 8) != 0 ? null : mTDeckPrivacy, (i & 16) != 0 ? null : mTPrivacyUser);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTDeckResponse copy$default(MTDeckResponse mTDeckResponse, MTDeck mTDeck, List list, MTDeckLists mTDeckLists, MTDeckPrivacy mTDeckPrivacy, MTPrivacyUser mTPrivacyUser, int i, Object obj) {
        if ((i & 1) != 0) {
            mTDeck = mTDeckResponse.deck;
        }
        if ((i & 2) != 0) {
            list = mTDeckResponse.games;
        }
        if ((i & 4) != 0) {
            mTDeckLists = mTDeckResponse.lists;
        }
        if ((i & 8) != 0) {
            mTDeckPrivacy = mTDeckResponse.privacy;
        }
        if ((i & 16) != 0) {
            mTPrivacyUser = mTDeckResponse.user;
        }
        MTPrivacyUser mTPrivacyUser2 = mTPrivacyUser;
        MTDeckLists mTDeckLists2 = mTDeckLists;
        return mTDeckResponse.copy(mTDeck, list, mTDeckLists2, mTDeckPrivacy, mTPrivacyUser2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTDeck getDeck() {
        return this.deck;
    }

    public final List<MTGame> component2() {
        return this.games;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTDeckLists getLists() {
        return this.lists;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTDeckPrivacy getPrivacy() {
        return this.privacy;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTPrivacyUser getUser() {
        return this.user;
    }

    public final MTDeckResponse copy(MTDeck deck, List<MTGame> games, MTDeckLists lists, MTDeckPrivacy privacy, MTPrivacyUser user) {
        Intrinsics.checkNotNullParameter(games, "games");
        return new MTDeckResponse(deck, games, lists, privacy, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckResponse)) {
            return false;
        }
        MTDeckResponse mTDeckResponse = (MTDeckResponse) other;
        return Intrinsics.areEqual(this.deck, mTDeckResponse.deck) && Intrinsics.areEqual(this.games, mTDeckResponse.games) && Intrinsics.areEqual(this.lists, mTDeckResponse.lists) && Intrinsics.areEqual(this.privacy, mTDeckResponse.privacy) && Intrinsics.areEqual(this.user, mTDeckResponse.user);
    }

    public final MTDeck getDeck() {
        return this.deck;
    }

    public final List<MTGame> getGames() {
        return this.games;
    }

    public final MTDeckLists getLists() {
        return this.lists;
    }

    public final MTDeckPrivacy getPrivacy() {
        return this.privacy;
    }

    public final MTPrivacyUser getUser() {
        return this.user;
    }

    public int hashCode() {
        MTDeck mTDeck = this.deck;
        int iHashCode = (((mTDeck == null ? 0 : mTDeck.hashCode()) * 31) + this.games.hashCode()) * 31;
        MTDeckLists mTDeckLists = this.lists;
        int iHashCode2 = (iHashCode + (mTDeckLists == null ? 0 : mTDeckLists.hashCode())) * 31;
        MTDeckPrivacy mTDeckPrivacy = this.privacy;
        int iHashCode3 = (iHashCode2 + (mTDeckPrivacy == null ? 0 : mTDeckPrivacy.hashCode())) * 31;
        MTPrivacyUser mTPrivacyUser = this.user;
        return iHashCode3 + (mTPrivacyUser != null ? mTPrivacyUser.hashCode() : 0);
    }

    public final void setDeck(MTDeck mTDeck) {
        this.deck = mTDeck;
    }

    public final void setGames(List<MTGame> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.games = list;
    }

    public final void setLists(MTDeckLists mTDeckLists) {
        this.lists = mTDeckLists;
    }

    public final void setPrivacy(MTDeckPrivacy mTDeckPrivacy) {
        this.privacy = mTDeckPrivacy;
    }

    public final void setUser(MTPrivacyUser mTPrivacyUser) {
        this.user = mTPrivacyUser;
    }

    public String toString() {
        return "MTDeckResponse(deck=" + this.deck + ", games=" + this.games + ", lists=" + this.lists + ", privacy=" + this.privacy + ", user=" + this.user + ")";
    }
}
