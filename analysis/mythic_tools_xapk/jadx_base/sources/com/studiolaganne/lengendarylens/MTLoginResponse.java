package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fHÆ\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000fHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u001dHÆ\u0003JÁ\u0001\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001J\u0013\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020cHÖ\u0001J\t\u0010d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00109\"\u0004\bE\u0010;R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010!\"\u0004\bK\u0010#R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTLoginResponse;", "", "result", "", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/studiolaganne/lengendarylens/MTUserState;", "lists", "Lcom/studiolaganne/lengendarylens/MTUserLists;", "collection", "Lcom/studiolaganne/lengendarylens/MTCollection;", "favorites", "Lcom/studiolaganne/lengendarylens/MTFavorites;", NativeProtocol.AUDIENCE_FRIENDS, "", "Lcom/studiolaganne/lengendarylens/MTFriend;", "playgroups", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "decks", "Lcom/studiolaganne/lengendarylens/MTDeck;", "tags", "Lcom/studiolaganne/lengendarylens/MTUserTags;", "trophies", "Lcom/studiolaganne/lengendarylens/MTTrophy;", "privacy", "Lcom/studiolaganne/lengendarylens/MTUserPrivacy;", "customToken", NotificationCompat.CATEGORY_EVENT, "Lcom/studiolaganne/lengendarylens/MTCommunityEvent;", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/MTUserState;Lcom/studiolaganne/lengendarylens/MTUserLists;Lcom/studiolaganne/lengendarylens/MTCollection;Lcom/studiolaganne/lengendarylens/MTFavorites;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTUserTags;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTUserPrivacy;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCommunityEvent;)V", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "getUser", "()Lcom/studiolaganne/lengendarylens/MTUser;", "setUser", "(Lcom/studiolaganne/lengendarylens/MTUser;)V", "getState", "()Lcom/studiolaganne/lengendarylens/MTUserState;", "setState", "(Lcom/studiolaganne/lengendarylens/MTUserState;)V", "getLists", "()Lcom/studiolaganne/lengendarylens/MTUserLists;", "setLists", "(Lcom/studiolaganne/lengendarylens/MTUserLists;)V", "getCollection", "()Lcom/studiolaganne/lengendarylens/MTCollection;", "setCollection", "(Lcom/studiolaganne/lengendarylens/MTCollection;)V", "getFavorites", "()Lcom/studiolaganne/lengendarylens/MTFavorites;", "setFavorites", "(Lcom/studiolaganne/lengendarylens/MTFavorites;)V", "getFriends", "()Ljava/util/List;", "setFriends", "(Ljava/util/List;)V", "getPlaygroups", "setPlaygroups", "getDecks", "setDecks", "getTags", "()Lcom/studiolaganne/lengendarylens/MTUserTags;", "setTags", "(Lcom/studiolaganne/lengendarylens/MTUserTags;)V", "getTrophies", "setTrophies", "getPrivacy", "()Lcom/studiolaganne/lengendarylens/MTUserPrivacy;", "setPrivacy", "(Lcom/studiolaganne/lengendarylens/MTUserPrivacy;)V", "getCustomToken", "setCustomToken", "getEvent", "()Lcom/studiolaganne/lengendarylens/MTCommunityEvent;", "setEvent", "(Lcom/studiolaganne/lengendarylens/MTCommunityEvent;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTLoginResponse {
    public static final int $stable = 8;
    private MTCollection collection;
    private String customToken;
    private List<MTDeck> decks;
    private MTCommunityEvent event;
    private MTFavorites favorites;
    private List<MTFriend> friends;
    private MTUserLists lists;
    private List<MTPlaygroup> playgroups;
    private MTUserPrivacy privacy;
    private String result;
    private MTUserState state;
    private MTUserTags tags;
    private List<MTTrophy> trophies;
    private MTUser user;

    public MTLoginResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public MTLoginResponse(String result, MTUser mTUser, MTUserState mTUserState, MTUserLists mTUserLists, MTCollection mTCollection, MTFavorites mTFavorites, List<MTFriend> friends, List<MTPlaygroup> playgroups, List<MTDeck> decks, MTUserTags mTUserTags, List<MTTrophy> list, MTUserPrivacy mTUserPrivacy, String str, MTCommunityEvent mTCommunityEvent) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(friends, "friends");
        Intrinsics.checkNotNullParameter(playgroups, "playgroups");
        Intrinsics.checkNotNullParameter(decks, "decks");
        this.result = result;
        this.user = mTUser;
        this.state = mTUserState;
        this.lists = mTUserLists;
        this.collection = mTCollection;
        this.favorites = mTFavorites;
        this.friends = friends;
        this.playgroups = playgroups;
        this.decks = decks;
        this.tags = mTUserTags;
        this.trophies = list;
        this.privacy = mTUserPrivacy;
        this.customToken = str;
        this.event = mTCommunityEvent;
    }

    public /* synthetic */ MTLoginResponse(String str, MTUser mTUser, MTUserState mTUserState, MTUserLists mTUserLists, MTCollection mTCollection, MTFavorites mTFavorites, List list, List list2, List list3, MTUserTags mTUserTags, List list4, MTUserPrivacy mTUserPrivacy, String str2, MTCommunityEvent mTCommunityEvent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null) : mTUser, (i & 4) != 0 ? null : mTUserState, (i & 8) != 0 ? null : mTUserLists, (i & 16) != 0 ? null : mTCollection, (i & 32) != 0 ? null : mTFavorites, (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) != 0 ? CollectionsKt.emptyList() : list2, (i & 256) != 0 ? CollectionsKt.emptyList() : list3, (i & 512) != 0 ? null : mTUserTags, (i & 1024) != 0 ? CollectionsKt.emptyList() : list4, (i & 2048) != 0 ? null : mTUserPrivacy, (i & 4096) != 0 ? null : str2, (i & 8192) != 0 ? null : mTCommunityEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MTUserTags getTags() {
        return this.tags;
    }

    public final List<MTTrophy> component11() {
        return this.trophies;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final MTUserPrivacy getPrivacy() {
        return this.privacy;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getCustomToken() {
        return this.customToken;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final MTCommunityEvent getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTUser getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTUserState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTUserLists getLists() {
        return this.lists;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTCollection getCollection() {
        return this.collection;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTFavorites getFavorites() {
        return this.favorites;
    }

    public final List<MTFriend> component7() {
        return this.friends;
    }

    public final List<MTPlaygroup> component8() {
        return this.playgroups;
    }

    public final List<MTDeck> component9() {
        return this.decks;
    }

    public final MTLoginResponse copy(String result, MTUser user, MTUserState state, MTUserLists lists, MTCollection collection, MTFavorites favorites, List<MTFriend> friends, List<MTPlaygroup> playgroups, List<MTDeck> decks, MTUserTags tags, List<MTTrophy> trophies, MTUserPrivacy privacy, String customToken, MTCommunityEvent event) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(friends, "friends");
        Intrinsics.checkNotNullParameter(playgroups, "playgroups");
        Intrinsics.checkNotNullParameter(decks, "decks");
        return new MTLoginResponse(result, user, state, lists, collection, favorites, friends, playgroups, decks, tags, trophies, privacy, customToken, event);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTLoginResponse)) {
            return false;
        }
        MTLoginResponse mTLoginResponse = (MTLoginResponse) other;
        return Intrinsics.areEqual(this.result, mTLoginResponse.result) && Intrinsics.areEqual(this.user, mTLoginResponse.user) && Intrinsics.areEqual(this.state, mTLoginResponse.state) && Intrinsics.areEqual(this.lists, mTLoginResponse.lists) && Intrinsics.areEqual(this.collection, mTLoginResponse.collection) && Intrinsics.areEqual(this.favorites, mTLoginResponse.favorites) && Intrinsics.areEqual(this.friends, mTLoginResponse.friends) && Intrinsics.areEqual(this.playgroups, mTLoginResponse.playgroups) && Intrinsics.areEqual(this.decks, mTLoginResponse.decks) && Intrinsics.areEqual(this.tags, mTLoginResponse.tags) && Intrinsics.areEqual(this.trophies, mTLoginResponse.trophies) && Intrinsics.areEqual(this.privacy, mTLoginResponse.privacy) && Intrinsics.areEqual(this.customToken, mTLoginResponse.customToken) && Intrinsics.areEqual(this.event, mTLoginResponse.event);
    }

    public final MTCollection getCollection() {
        return this.collection;
    }

    public final String getCustomToken() {
        return this.customToken;
    }

    public final List<MTDeck> getDecks() {
        return this.decks;
    }

    public final MTCommunityEvent getEvent() {
        return this.event;
    }

    public final MTFavorites getFavorites() {
        return this.favorites;
    }

    public final List<MTFriend> getFriends() {
        return this.friends;
    }

    public final MTUserLists getLists() {
        return this.lists;
    }

    public final List<MTPlaygroup> getPlaygroups() {
        return this.playgroups;
    }

    public final MTUserPrivacy getPrivacy() {
        return this.privacy;
    }

    public final String getResult() {
        return this.result;
    }

    public final MTUserState getState() {
        return this.state;
    }

    public final MTUserTags getTags() {
        return this.tags;
    }

    public final List<MTTrophy> getTrophies() {
        return this.trophies;
    }

    public final MTUser getUser() {
        return this.user;
    }

    public int hashCode() {
        int iHashCode = this.result.hashCode() * 31;
        MTUser mTUser = this.user;
        int iHashCode2 = (iHashCode + (mTUser == null ? 0 : mTUser.hashCode())) * 31;
        MTUserState mTUserState = this.state;
        int iHashCode3 = (iHashCode2 + (mTUserState == null ? 0 : mTUserState.hashCode())) * 31;
        MTUserLists mTUserLists = this.lists;
        int iHashCode4 = (iHashCode3 + (mTUserLists == null ? 0 : mTUserLists.hashCode())) * 31;
        MTCollection mTCollection = this.collection;
        int iHashCode5 = (iHashCode4 + (mTCollection == null ? 0 : mTCollection.hashCode())) * 31;
        MTFavorites mTFavorites = this.favorites;
        int iHashCode6 = (((((((iHashCode5 + (mTFavorites == null ? 0 : mTFavorites.hashCode())) * 31) + this.friends.hashCode()) * 31) + this.playgroups.hashCode()) * 31) + this.decks.hashCode()) * 31;
        MTUserTags mTUserTags = this.tags;
        int iHashCode7 = (iHashCode6 + (mTUserTags == null ? 0 : mTUserTags.hashCode())) * 31;
        List<MTTrophy> list = this.trophies;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        MTUserPrivacy mTUserPrivacy = this.privacy;
        int iHashCode9 = (iHashCode8 + (mTUserPrivacy == null ? 0 : mTUserPrivacy.hashCode())) * 31;
        String str = this.customToken;
        int iHashCode10 = (iHashCode9 + (str == null ? 0 : str.hashCode())) * 31;
        MTCommunityEvent mTCommunityEvent = this.event;
        return iHashCode10 + (mTCommunityEvent != null ? mTCommunityEvent.hashCode() : 0);
    }

    public final void setCollection(MTCollection mTCollection) {
        this.collection = mTCollection;
    }

    public final void setCustomToken(String str) {
        this.customToken = str;
    }

    public final void setDecks(List<MTDeck> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.decks = list;
    }

    public final void setEvent(MTCommunityEvent mTCommunityEvent) {
        this.event = mTCommunityEvent;
    }

    public final void setFavorites(MTFavorites mTFavorites) {
        this.favorites = mTFavorites;
    }

    public final void setFriends(List<MTFriend> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.friends = list;
    }

    public final void setLists(MTUserLists mTUserLists) {
        this.lists = mTUserLists;
    }

    public final void setPlaygroups(List<MTPlaygroup> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.playgroups = list;
    }

    public final void setPrivacy(MTUserPrivacy mTUserPrivacy) {
        this.privacy = mTUserPrivacy;
    }

    public final void setResult(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.result = str;
    }

    public final void setState(MTUserState mTUserState) {
        this.state = mTUserState;
    }

    public final void setTags(MTUserTags mTUserTags) {
        this.tags = mTUserTags;
    }

    public final void setTrophies(List<MTTrophy> list) {
        this.trophies = list;
    }

    public final void setUser(MTUser mTUser) {
        this.user = mTUser;
    }

    public String toString() {
        return "MTLoginResponse(result=" + this.result + ", user=" + this.user + ", state=" + this.state + ", lists=" + this.lists + ", collection=" + this.collection + ", favorites=" + this.favorites + ", friends=" + this.friends + ", playgroups=" + this.playgroups + ", decks=" + this.decks + ", tags=" + this.tags + ", trophies=" + this.trophies + ", privacy=" + this.privacy + ", customToken=" + this.customToken + ", event=" + this.event + ")";
    }
}
