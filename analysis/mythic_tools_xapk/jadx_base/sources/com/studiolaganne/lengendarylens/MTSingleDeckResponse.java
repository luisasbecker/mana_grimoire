package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSingleDeckResponse;", "", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "privacy", "Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;", "user", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTDeck;Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "getDeck", "()Lcom/studiolaganne/lengendarylens/MTDeck;", "setDeck", "(Lcom/studiolaganne/lengendarylens/MTDeck;)V", "getPrivacy", "()Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;", "setPrivacy", "(Lcom/studiolaganne/lengendarylens/MTDeckPrivacy;)V", "getUser", "()Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "setUser", "(Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSingleDeckResponse {
    public static final int $stable = 8;
    private MTDeck deck;
    private MTDeckPrivacy privacy;
    private MTPrivacyUser user;

    public MTSingleDeckResponse() {
        this(null, null, null, 7, null);
    }

    public MTSingleDeckResponse(MTDeck mTDeck, MTDeckPrivacy mTDeckPrivacy, MTPrivacyUser mTPrivacyUser) {
        this.deck = mTDeck;
        this.privacy = mTDeckPrivacy;
        this.user = mTPrivacyUser;
    }

    public /* synthetic */ MTSingleDeckResponse(MTDeck mTDeck, MTDeckPrivacy mTDeckPrivacy, MTPrivacyUser mTPrivacyUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTDeck, (i & 2) != 0 ? null : mTDeckPrivacy, (i & 4) != 0 ? null : mTPrivacyUser);
    }

    public static /* synthetic */ MTSingleDeckResponse copy$default(MTSingleDeckResponse mTSingleDeckResponse, MTDeck mTDeck, MTDeckPrivacy mTDeckPrivacy, MTPrivacyUser mTPrivacyUser, int i, Object obj) {
        if ((i & 1) != 0) {
            mTDeck = mTSingleDeckResponse.deck;
        }
        if ((i & 2) != 0) {
            mTDeckPrivacy = mTSingleDeckResponse.privacy;
        }
        if ((i & 4) != 0) {
            mTPrivacyUser = mTSingleDeckResponse.user;
        }
        return mTSingleDeckResponse.copy(mTDeck, mTDeckPrivacy, mTPrivacyUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTDeck getDeck() {
        return this.deck;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTDeckPrivacy getPrivacy() {
        return this.privacy;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTPrivacyUser getUser() {
        return this.user;
    }

    public final MTSingleDeckResponse copy(MTDeck deck, MTDeckPrivacy privacy, MTPrivacyUser user) {
        return new MTSingleDeckResponse(deck, privacy, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSingleDeckResponse)) {
            return false;
        }
        MTSingleDeckResponse mTSingleDeckResponse = (MTSingleDeckResponse) other;
        return Intrinsics.areEqual(this.deck, mTSingleDeckResponse.deck) && Intrinsics.areEqual(this.privacy, mTSingleDeckResponse.privacy) && Intrinsics.areEqual(this.user, mTSingleDeckResponse.user);
    }

    public final MTDeck getDeck() {
        return this.deck;
    }

    public final MTDeckPrivacy getPrivacy() {
        return this.privacy;
    }

    public final MTPrivacyUser getUser() {
        return this.user;
    }

    public int hashCode() {
        MTDeck mTDeck = this.deck;
        int iHashCode = (mTDeck == null ? 0 : mTDeck.hashCode()) * 31;
        MTDeckPrivacy mTDeckPrivacy = this.privacy;
        int iHashCode2 = (iHashCode + (mTDeckPrivacy == null ? 0 : mTDeckPrivacy.hashCode())) * 31;
        MTPrivacyUser mTPrivacyUser = this.user;
        return iHashCode2 + (mTPrivacyUser != null ? mTPrivacyUser.hashCode() : 0);
    }

    public final void setDeck(MTDeck mTDeck) {
        this.deck = mTDeck;
    }

    public final void setPrivacy(MTDeckPrivacy mTDeckPrivacy) {
        this.privacy = mTDeckPrivacy;
    }

    public final void setUser(MTPrivacyUser mTPrivacyUser) {
        this.user = mTPrivacyUser;
    }

    public String toString() {
        return "MTSingleDeckResponse(deck=" + this.deck + ", privacy=" + this.privacy + ", user=" + this.user + ")";
    }
}
