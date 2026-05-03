package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedCollectionsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/PendingItem;", "", "<init>", "()V", "Invite", "Unshare", "Lcom/studiolaganne/lengendarylens/PendingItem$Invite;", "Lcom/studiolaganne/lengendarylens/PendingItem$Unshare;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class PendingItem {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: SharedCollectionsActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/PendingItem$Invite;", "Lcom/studiolaganne/lengendarylens/PendingItem;", "invite", "Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;)V", "getInvite", "()Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Invite extends PendingItem {
        public static final int $stable = 8;
        private final MTSharedCollectionInvite invite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Invite(MTSharedCollectionInvite invite) {
            super(null);
            Intrinsics.checkNotNullParameter(invite, "invite");
            this.invite = invite;
        }

        public static /* synthetic */ Invite copy$default(Invite invite, MTSharedCollectionInvite mTSharedCollectionInvite, int i, Object obj) {
            if ((i & 1) != 0) {
                mTSharedCollectionInvite = invite.invite;
            }
            return invite.copy(mTSharedCollectionInvite);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MTSharedCollectionInvite getInvite() {
            return this.invite;
        }

        public final Invite copy(MTSharedCollectionInvite invite) {
            Intrinsics.checkNotNullParameter(invite, "invite");
            return new Invite(invite);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Invite) && Intrinsics.areEqual(this.invite, ((Invite) other).invite);
        }

        public final MTSharedCollectionInvite getInvite() {
            return this.invite;
        }

        public int hashCode() {
            return this.invite.hashCode();
        }

        public String toString() {
            return "Invite(invite=" + this.invite + ")";
        }
    }

    /* JADX INFO: compiled from: SharedCollectionsActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/PendingItem$Unshare;", "Lcom/studiolaganne/lengendarylens/PendingItem;", "request", "Lcom/studiolaganne/lengendarylens/MTUnshareRequest;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTUnshareRequest;)V", "getRequest", "()Lcom/studiolaganne/lengendarylens/MTUnshareRequest;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Unshare extends PendingItem {
        public static final int $stable = 8;
        private final MTUnshareRequest request;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unshare(MTUnshareRequest request) {
            super(null);
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
        }

        public static /* synthetic */ Unshare copy$default(Unshare unshare, MTUnshareRequest mTUnshareRequest, int i, Object obj) {
            if ((i & 1) != 0) {
                mTUnshareRequest = unshare.request;
            }
            return unshare.copy(mTUnshareRequest);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MTUnshareRequest getRequest() {
            return this.request;
        }

        public final Unshare copy(MTUnshareRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            return new Unshare(request);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unshare) && Intrinsics.areEqual(this.request, ((Unshare) other).request);
        }

        public final MTUnshareRequest getRequest() {
            return this.request;
        }

        public int hashCode() {
            return this.request.hashCode();
        }

        public String toString() {
            return "Unshare(request=" + this.request + ")";
        }
    }

    private PendingItem() {
    }

    public /* synthetic */ PendingItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
