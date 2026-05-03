package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardListResponse;", "", "list", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "result", "Lcom/studiolaganne/lengendarylens/MTAddCardsResult;", "privacy", "Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;", "user", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;Lcom/studiolaganne/lengendarylens/MTAddCardsResult;Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "getList", "()Lcom/studiolaganne/lengendarylens/MTCardContainer;", "setList", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "getResult", "()Lcom/studiolaganne/lengendarylens/MTAddCardsResult;", "setResult", "(Lcom/studiolaganne/lengendarylens/MTAddCardsResult;)V", "getPrivacy", "()Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;", "setPrivacy", "(Lcom/studiolaganne/lengendarylens/MTContainerPrivacy;)V", "getUser", "()Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "setUser", "(Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardListResponse {
    public static final int $stable = 8;
    private MTCardContainer list;
    private MTContainerPrivacy privacy;
    private MTAddCardsResult result;
    private MTPrivacyUser user;

    public MTCardListResponse() {
        this(null, null, null, null, 15, null);
    }

    public MTCardListResponse(MTCardContainer mTCardContainer, MTAddCardsResult mTAddCardsResult, MTContainerPrivacy mTContainerPrivacy, MTPrivacyUser mTPrivacyUser) {
        this.list = mTCardContainer;
        this.result = mTAddCardsResult;
        this.privacy = mTContainerPrivacy;
        this.user = mTPrivacyUser;
    }

    public /* synthetic */ MTCardListResponse(MTCardContainer mTCardContainer, MTAddCardsResult mTAddCardsResult, MTContainerPrivacy mTContainerPrivacy, MTPrivacyUser mTPrivacyUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTCardContainer, (i & 2) != 0 ? null : mTAddCardsResult, (i & 4) != 0 ? null : mTContainerPrivacy, (i & 8) != 0 ? null : mTPrivacyUser);
    }

    public static /* synthetic */ MTCardListResponse copy$default(MTCardListResponse mTCardListResponse, MTCardContainer mTCardContainer, MTAddCardsResult mTAddCardsResult, MTContainerPrivacy mTContainerPrivacy, MTPrivacyUser mTPrivacyUser, int i, Object obj) {
        if ((i & 1) != 0) {
            mTCardContainer = mTCardListResponse.list;
        }
        if ((i & 2) != 0) {
            mTAddCardsResult = mTCardListResponse.result;
        }
        if ((i & 4) != 0) {
            mTContainerPrivacy = mTCardListResponse.privacy;
        }
        if ((i & 8) != 0) {
            mTPrivacyUser = mTCardListResponse.user;
        }
        return mTCardListResponse.copy(mTCardContainer, mTAddCardsResult, mTContainerPrivacy, mTPrivacyUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCardContainer getList() {
        return this.list;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTAddCardsResult getResult() {
        return this.result;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTContainerPrivacy getPrivacy() {
        return this.privacy;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTPrivacyUser getUser() {
        return this.user;
    }

    public final MTCardListResponse copy(MTCardContainer list, MTAddCardsResult result, MTContainerPrivacy privacy, MTPrivacyUser user) {
        return new MTCardListResponse(list, result, privacy, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardListResponse)) {
            return false;
        }
        MTCardListResponse mTCardListResponse = (MTCardListResponse) other;
        return Intrinsics.areEqual(this.list, mTCardListResponse.list) && Intrinsics.areEqual(this.result, mTCardListResponse.result) && Intrinsics.areEqual(this.privacy, mTCardListResponse.privacy) && Intrinsics.areEqual(this.user, mTCardListResponse.user);
    }

    public final MTCardContainer getList() {
        return this.list;
    }

    public final MTContainerPrivacy getPrivacy() {
        return this.privacy;
    }

    public final MTAddCardsResult getResult() {
        return this.result;
    }

    public final MTPrivacyUser getUser() {
        return this.user;
    }

    public int hashCode() {
        MTCardContainer mTCardContainer = this.list;
        int iHashCode = (mTCardContainer == null ? 0 : mTCardContainer.hashCode()) * 31;
        MTAddCardsResult mTAddCardsResult = this.result;
        int iHashCode2 = (iHashCode + (mTAddCardsResult == null ? 0 : mTAddCardsResult.hashCode())) * 31;
        MTContainerPrivacy mTContainerPrivacy = this.privacy;
        int iHashCode3 = (iHashCode2 + (mTContainerPrivacy == null ? 0 : mTContainerPrivacy.hashCode())) * 31;
        MTPrivacyUser mTPrivacyUser = this.user;
        return iHashCode3 + (mTPrivacyUser != null ? mTPrivacyUser.hashCode() : 0);
    }

    public final void setList(MTCardContainer mTCardContainer) {
        this.list = mTCardContainer;
    }

    public final void setPrivacy(MTContainerPrivacy mTContainerPrivacy) {
        this.privacy = mTContainerPrivacy;
    }

    public final void setResult(MTAddCardsResult mTAddCardsResult) {
        this.result = mTAddCardsResult;
    }

    public final void setUser(MTPrivacyUser mTPrivacyUser) {
        this.user = mTPrivacyUser;
    }

    public String toString() {
        return "MTCardListResponse(list=" + this.list + ", result=" + this.result + ", privacy=" + this.privacy + ", user=" + this.user + ")";
    }
}
