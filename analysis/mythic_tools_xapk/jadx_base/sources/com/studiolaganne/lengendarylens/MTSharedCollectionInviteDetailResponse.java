package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSharedCollectionInviteDetailResponse;", "", "invite", "Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;", "preview", "Lcom/studiolaganne/lengendarylens/MTInvitePreview;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;Lcom/studiolaganne/lengendarylens/MTInvitePreview;)V", "getInvite", "()Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;", "setInvite", "(Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;)V", "getPreview", "()Lcom/studiolaganne/lengendarylens/MTInvitePreview;", "setPreview", "(Lcom/studiolaganne/lengendarylens/MTInvitePreview;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSharedCollectionInviteDetailResponse {
    public static final int $stable = 8;
    private MTSharedCollectionInvite invite;
    private MTInvitePreview preview;

    /* JADX WARN: Multi-variable type inference failed */
    public MTSharedCollectionInviteDetailResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTSharedCollectionInviteDetailResponse(MTSharedCollectionInvite mTSharedCollectionInvite, MTInvitePreview mTInvitePreview) {
        this.invite = mTSharedCollectionInvite;
        this.preview = mTInvitePreview;
    }

    public /* synthetic */ MTSharedCollectionInviteDetailResponse(MTSharedCollectionInvite mTSharedCollectionInvite, MTInvitePreview mTInvitePreview, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTSharedCollectionInvite, (i & 2) != 0 ? null : mTInvitePreview);
    }

    public static /* synthetic */ MTSharedCollectionInviteDetailResponse copy$default(MTSharedCollectionInviteDetailResponse mTSharedCollectionInviteDetailResponse, MTSharedCollectionInvite mTSharedCollectionInvite, MTInvitePreview mTInvitePreview, int i, Object obj) {
        if ((i & 1) != 0) {
            mTSharedCollectionInvite = mTSharedCollectionInviteDetailResponse.invite;
        }
        if ((i & 2) != 0) {
            mTInvitePreview = mTSharedCollectionInviteDetailResponse.preview;
        }
        return mTSharedCollectionInviteDetailResponse.copy(mTSharedCollectionInvite, mTInvitePreview);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTSharedCollectionInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTInvitePreview getPreview() {
        return this.preview;
    }

    public final MTSharedCollectionInviteDetailResponse copy(MTSharedCollectionInvite invite, MTInvitePreview preview) {
        return new MTSharedCollectionInviteDetailResponse(invite, preview);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSharedCollectionInviteDetailResponse)) {
            return false;
        }
        MTSharedCollectionInviteDetailResponse mTSharedCollectionInviteDetailResponse = (MTSharedCollectionInviteDetailResponse) other;
        return Intrinsics.areEqual(this.invite, mTSharedCollectionInviteDetailResponse.invite) && Intrinsics.areEqual(this.preview, mTSharedCollectionInviteDetailResponse.preview);
    }

    public final MTSharedCollectionInvite getInvite() {
        return this.invite;
    }

    public final MTInvitePreview getPreview() {
        return this.preview;
    }

    public int hashCode() {
        MTSharedCollectionInvite mTSharedCollectionInvite = this.invite;
        int iHashCode = (mTSharedCollectionInvite == null ? 0 : mTSharedCollectionInvite.hashCode()) * 31;
        MTInvitePreview mTInvitePreview = this.preview;
        return iHashCode + (mTInvitePreview != null ? mTInvitePreview.hashCode() : 0);
    }

    public final void setInvite(MTSharedCollectionInvite mTSharedCollectionInvite) {
        this.invite = mTSharedCollectionInvite;
    }

    public final void setPreview(MTInvitePreview mTInvitePreview) {
        this.preview = mTInvitePreview;
    }

    public String toString() {
        return "MTSharedCollectionInviteDetailResponse(invite=" + this.invite + ", preview=" + this.preview + ")";
    }
}
