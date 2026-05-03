package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.ServerProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0087\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020PHÖ\u0001J\t\u0010Q\u001a\u00020RHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006S"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUserResponse;", "", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "onboarding", "Lcom/studiolaganne/lengendarylens/MTOnboarding;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/studiolaganne/lengendarylens/MTUserState;", "lists", "Lcom/studiolaganne/lengendarylens/MTUserLists;", "collection", "Lcom/studiolaganne/lengendarylens/MTCollection;", "favorites", "Lcom/studiolaganne/lengendarylens/MTFavorites;", "tags", "Lcom/studiolaganne/lengendarylens/MTUserTags;", "trophies", "", "Lcom/studiolaganne/lengendarylens/MTTrophy;", "privacy", "Lcom/studiolaganne/lengendarylens/MTUserPrivacy;", NotificationCompat.CATEGORY_EVENT, "Lcom/studiolaganne/lengendarylens/MTCommunityEvent;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/MTOnboarding;Lcom/studiolaganne/lengendarylens/MTUserState;Lcom/studiolaganne/lengendarylens/MTUserLists;Lcom/studiolaganne/lengendarylens/MTCollection;Lcom/studiolaganne/lengendarylens/MTFavorites;Lcom/studiolaganne/lengendarylens/MTUserTags;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTUserPrivacy;Lcom/studiolaganne/lengendarylens/MTCommunityEvent;)V", "getUser", "()Lcom/studiolaganne/lengendarylens/MTUser;", "setUser", "(Lcom/studiolaganne/lengendarylens/MTUser;)V", "getOnboarding", "()Lcom/studiolaganne/lengendarylens/MTOnboarding;", "setOnboarding", "(Lcom/studiolaganne/lengendarylens/MTOnboarding;)V", "getState", "()Lcom/studiolaganne/lengendarylens/MTUserState;", "setState", "(Lcom/studiolaganne/lengendarylens/MTUserState;)V", "getLists", "()Lcom/studiolaganne/lengendarylens/MTUserLists;", "setLists", "(Lcom/studiolaganne/lengendarylens/MTUserLists;)V", "getCollection", "()Lcom/studiolaganne/lengendarylens/MTCollection;", "setCollection", "(Lcom/studiolaganne/lengendarylens/MTCollection;)V", "getFavorites", "()Lcom/studiolaganne/lengendarylens/MTFavorites;", "setFavorites", "(Lcom/studiolaganne/lengendarylens/MTFavorites;)V", "getTags", "()Lcom/studiolaganne/lengendarylens/MTUserTags;", "setTags", "(Lcom/studiolaganne/lengendarylens/MTUserTags;)V", "getTrophies", "()Ljava/util/List;", "setTrophies", "(Ljava/util/List;)V", "getPrivacy", "()Lcom/studiolaganne/lengendarylens/MTUserPrivacy;", "setPrivacy", "(Lcom/studiolaganne/lengendarylens/MTUserPrivacy;)V", "getEvent", "()Lcom/studiolaganne/lengendarylens/MTCommunityEvent;", "setEvent", "(Lcom/studiolaganne/lengendarylens/MTCommunityEvent;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUserResponse {
    public static final int $stable = 8;
    private MTCollection collection;
    private MTCommunityEvent event;
    private MTFavorites favorites;
    private MTUserLists lists;
    private MTOnboarding onboarding;
    private MTUserPrivacy privacy;
    private MTUserState state;
    private MTUserTags tags;
    private List<MTTrophy> trophies;
    private MTUser user;

    public MTUserResponse() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public MTUserResponse(MTUser mTUser, MTOnboarding mTOnboarding, MTUserState mTUserState, MTUserLists mTUserLists, MTCollection mTCollection, MTFavorites mTFavorites, MTUserTags mTUserTags, List<MTTrophy> list, MTUserPrivacy mTUserPrivacy, MTCommunityEvent mTCommunityEvent) {
        this.user = mTUser;
        this.onboarding = mTOnboarding;
        this.state = mTUserState;
        this.lists = mTUserLists;
        this.collection = mTCollection;
        this.favorites = mTFavorites;
        this.tags = mTUserTags;
        this.trophies = list;
        this.privacy = mTUserPrivacy;
        this.event = mTCommunityEvent;
    }

    public /* synthetic */ MTUserResponse(MTUser mTUser, MTOnboarding mTOnboarding, MTUserState mTUserState, MTUserLists mTUserLists, MTCollection mTCollection, MTFavorites mTFavorites, MTUserTags mTUserTags, List list, MTUserPrivacy mTUserPrivacy, MTCommunityEvent mTCommunityEvent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MTUser(false, 0, null, null, null, null, null, null, null, null, 1023, null) : mTUser, (i & 2) != 0 ? null : mTOnboarding, (i & 4) != 0 ? null : mTUserState, (i & 8) != 0 ? null : mTUserLists, (i & 16) != 0 ? null : mTCollection, (i & 32) != 0 ? null : mTFavorites, (i & 64) != 0 ? null : mTUserTags, (i & 128) != 0 ? CollectionsKt.emptyList() : list, (i & 256) != 0 ? null : mTUserPrivacy, (i & 512) != 0 ? null : mTCommunityEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTUserResponse copy$default(MTUserResponse mTUserResponse, MTUser mTUser, MTOnboarding mTOnboarding, MTUserState mTUserState, MTUserLists mTUserLists, MTCollection mTCollection, MTFavorites mTFavorites, MTUserTags mTUserTags, List list, MTUserPrivacy mTUserPrivacy, MTCommunityEvent mTCommunityEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            mTUser = mTUserResponse.user;
        }
        if ((i & 2) != 0) {
            mTOnboarding = mTUserResponse.onboarding;
        }
        if ((i & 4) != 0) {
            mTUserState = mTUserResponse.state;
        }
        if ((i & 8) != 0) {
            mTUserLists = mTUserResponse.lists;
        }
        if ((i & 16) != 0) {
            mTCollection = mTUserResponse.collection;
        }
        if ((i & 32) != 0) {
            mTFavorites = mTUserResponse.favorites;
        }
        if ((i & 64) != 0) {
            mTUserTags = mTUserResponse.tags;
        }
        if ((i & 128) != 0) {
            list = mTUserResponse.trophies;
        }
        if ((i & 256) != 0) {
            mTUserPrivacy = mTUserResponse.privacy;
        }
        if ((i & 512) != 0) {
            mTCommunityEvent = mTUserResponse.event;
        }
        MTUserPrivacy mTUserPrivacy2 = mTUserPrivacy;
        MTCommunityEvent mTCommunityEvent2 = mTCommunityEvent;
        MTUserTags mTUserTags2 = mTUserTags;
        List list2 = list;
        MTCollection mTCollection2 = mTCollection;
        MTFavorites mTFavorites2 = mTFavorites;
        return mTUserResponse.copy(mTUser, mTOnboarding, mTUserState, mTUserLists, mTCollection2, mTFavorites2, mTUserTags2, list2, mTUserPrivacy2, mTCommunityEvent2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTUser getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MTCommunityEvent getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTOnboarding getOnboarding() {
        return this.onboarding;
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

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTUserTags getTags() {
        return this.tags;
    }

    public final List<MTTrophy> component8() {
        return this.trophies;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MTUserPrivacy getPrivacy() {
        return this.privacy;
    }

    public final MTUserResponse copy(MTUser user, MTOnboarding onboarding, MTUserState state, MTUserLists lists, MTCollection collection, MTFavorites favorites, MTUserTags tags, List<MTTrophy> trophies, MTUserPrivacy privacy, MTCommunityEvent event) {
        return new MTUserResponse(user, onboarding, state, lists, collection, favorites, tags, trophies, privacy, event);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUserResponse)) {
            return false;
        }
        MTUserResponse mTUserResponse = (MTUserResponse) other;
        return Intrinsics.areEqual(this.user, mTUserResponse.user) && Intrinsics.areEqual(this.onboarding, mTUserResponse.onboarding) && Intrinsics.areEqual(this.state, mTUserResponse.state) && Intrinsics.areEqual(this.lists, mTUserResponse.lists) && Intrinsics.areEqual(this.collection, mTUserResponse.collection) && Intrinsics.areEqual(this.favorites, mTUserResponse.favorites) && Intrinsics.areEqual(this.tags, mTUserResponse.tags) && Intrinsics.areEqual(this.trophies, mTUserResponse.trophies) && Intrinsics.areEqual(this.privacy, mTUserResponse.privacy) && Intrinsics.areEqual(this.event, mTUserResponse.event);
    }

    public final MTCollection getCollection() {
        return this.collection;
    }

    public final MTCommunityEvent getEvent() {
        return this.event;
    }

    public final MTFavorites getFavorites() {
        return this.favorites;
    }

    public final MTUserLists getLists() {
        return this.lists;
    }

    public final MTOnboarding getOnboarding() {
        return this.onboarding;
    }

    public final MTUserPrivacy getPrivacy() {
        return this.privacy;
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
        MTUser mTUser = this.user;
        int iHashCode = (mTUser == null ? 0 : mTUser.hashCode()) * 31;
        MTOnboarding mTOnboarding = this.onboarding;
        int iHashCode2 = (iHashCode + (mTOnboarding == null ? 0 : mTOnboarding.hashCode())) * 31;
        MTUserState mTUserState = this.state;
        int iHashCode3 = (iHashCode2 + (mTUserState == null ? 0 : mTUserState.hashCode())) * 31;
        MTUserLists mTUserLists = this.lists;
        int iHashCode4 = (iHashCode3 + (mTUserLists == null ? 0 : mTUserLists.hashCode())) * 31;
        MTCollection mTCollection = this.collection;
        int iHashCode5 = (iHashCode4 + (mTCollection == null ? 0 : mTCollection.hashCode())) * 31;
        MTFavorites mTFavorites = this.favorites;
        int iHashCode6 = (iHashCode5 + (mTFavorites == null ? 0 : mTFavorites.hashCode())) * 31;
        MTUserTags mTUserTags = this.tags;
        int iHashCode7 = (iHashCode6 + (mTUserTags == null ? 0 : mTUserTags.hashCode())) * 31;
        List<MTTrophy> list = this.trophies;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        MTUserPrivacy mTUserPrivacy = this.privacy;
        int iHashCode9 = (iHashCode8 + (mTUserPrivacy == null ? 0 : mTUserPrivacy.hashCode())) * 31;
        MTCommunityEvent mTCommunityEvent = this.event;
        return iHashCode9 + (mTCommunityEvent != null ? mTCommunityEvent.hashCode() : 0);
    }

    public final void setCollection(MTCollection mTCollection) {
        this.collection = mTCollection;
    }

    public final void setEvent(MTCommunityEvent mTCommunityEvent) {
        this.event = mTCommunityEvent;
    }

    public final void setFavorites(MTFavorites mTFavorites) {
        this.favorites = mTFavorites;
    }

    public final void setLists(MTUserLists mTUserLists) {
        this.lists = mTUserLists;
    }

    public final void setOnboarding(MTOnboarding mTOnboarding) {
        this.onboarding = mTOnboarding;
    }

    public final void setPrivacy(MTUserPrivacy mTUserPrivacy) {
        this.privacy = mTUserPrivacy;
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
        return "MTUserResponse(user=" + this.user + ", onboarding=" + this.onboarding + ", state=" + this.state + ", lists=" + this.lists + ", collection=" + this.collection + ", favorites=" + this.favorites + ", tags=" + this.tags + ", trophies=" + this.trophies + ", privacy=" + this.privacy + ", event=" + this.event + ")";
    }
}
