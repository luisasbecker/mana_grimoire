package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.PendingItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedCollectionsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/PendingInviteAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/PendingInviteViewHolder;", "currentUserId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/PendingInviteActionListener;", "<init>", "(ILcom/studiolaganne/lengendarylens/PendingInviteActionListener;)V", FirebaseAnalytics.Param.ITEMS, "", "Lcom/studiolaganne/lengendarylens/PendingItem;", "updateItems", "", "newItems", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "buildParticipantView", "Landroid/view/View;", "context", "Landroid/content/Context;", "participant", "Lcom/studiolaganne/lengendarylens/MTSharedCollectionInviteParticipant;", "dpToPx", "dp", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PendingInviteAdapter extends RecyclerView.Adapter<PendingInviteViewHolder> {
    public static final int $stable = 8;
    private final int currentUserId;
    private List<? extends PendingItem> items;
    private final PendingInviteActionListener listener;

    public PendingInviteAdapter(int i, PendingInviteActionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.currentUserId = i;
        this.listener = listener;
        this.items = CollectionsKt.emptyList();
    }

    private final View buildParticipantView(Context context, MTSharedCollectionInviteParticipant participant) {
        Resources resources;
        int i;
        MTPrivacyUser user = participant.getUser();
        String picture = user != null ? user.getPicture() : null;
        MTPrivacyUser user2 = participant.getUser();
        String firstname = user2 != null ? user2.getFirstname() : null;
        MTPrivacyUser user3 = participant.getUser();
        View viewBuildMemberAvatarView = SharedCollectionsActivityKt.buildMemberAvatarView(context, picture, firstname, user3 != null ? user3.getUsername() : null);
        TextView textView = new TextView(context);
        if (Intrinsics.areEqual(participant.getStatus(), "accepted")) {
            resources = textView.getResources();
            i = R.string.accepted;
        } else {
            resources = textView.getResources();
            i = R.string.pending;
        }
        textView.setText(resources.getString(i));
        textView.setTextSize(10.0f);
        textView.setTypeface(context.getResources().getFont(R.font.baloo_da_2_bold));
        textView.setTextColor(context.getResources().getColor(R.color.almost_white, context.getTheme()));
        textView.setPadding(dpToPx(context, 6), dpToPx(context, 1), dpToPx(context, 6), 0);
        textView.setTextAlignment(4);
        textView.setBackgroundResource(Intrinsics.areEqual(participant.getStatus(), "accepted") ? R.drawable.green_box : R.drawable.blue_box);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = dpToPx(context, 4);
        textView.setLayoutParams(layoutParams);
        Intrinsics.checkNotNull(viewBuildMemberAvatarView, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) viewBuildMemberAvatarView).addView(textView, 0);
        return viewBuildMemberAvatarView;
    }

    private final int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    static final Unit onBindViewHolder$lambda$3(PendingItem pendingItem, PendingInviteAdapter pendingInviteAdapter) {
        if (pendingItem instanceof PendingItem.Invite) {
            pendingInviteAdapter.listener.onCancelInvite(((PendingItem.Invite) pendingItem).getInvite().getId());
        } else {
            if (!(pendingItem instanceof PendingItem.Unshare)) {
                throw new NoWhenBranchMatchedException();
            }
            PendingInviteActionListener pendingInviteActionListener = pendingInviteAdapter.listener;
            Integer shared_collection_id = ((PendingItem.Unshare) pendingItem).getRequest().getShared_collection_id();
            if (shared_collection_id == null) {
                return Unit.INSTANCE;
            }
            pendingInviteActionListener.onCancelUnshare(shared_collection_id.intValue());
        }
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$4(PendingItem pendingItem, PendingInviteAdapter pendingInviteAdapter) {
        if (pendingItem instanceof PendingItem.Invite) {
            pendingInviteAdapter.listener.onAcceptInvite(((PendingItem.Invite) pendingItem).getInvite().getId());
        } else {
            if (!(pendingItem instanceof PendingItem.Unshare)) {
                throw new NoWhenBranchMatchedException();
            }
            PendingInviteActionListener pendingInviteActionListener = pendingInviteAdapter.listener;
            Integer shared_collection_id = ((PendingItem.Unshare) pendingItem).getRequest().getShared_collection_id();
            if (shared_collection_id == null) {
                return Unit.INSTANCE;
            }
            pendingInviteActionListener.onAcceptUnshare(shared_collection_id.intValue());
        }
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$5(PendingItem pendingItem, PendingInviteAdapter pendingInviteAdapter) {
        if (pendingItem instanceof PendingItem.Invite) {
            pendingInviteAdapter.listener.onRejectInvite(((PendingItem.Invite) pendingItem).getInvite().getId());
        } else {
            if (!(pendingItem instanceof PendingItem.Unshare)) {
                throw new NoWhenBranchMatchedException();
            }
            PendingInviteActionListener pendingInviteActionListener = pendingInviteAdapter.listener;
            Integer shared_collection_id = ((PendingItem.Unshare) pendingItem).getRequest().getShared_collection_id();
            if (shared_collection_id == null) {
                return Unit.INSTANCE;
            }
            pendingInviteActionListener.onRejectUnshare(shared_collection_id.intValue());
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[PHI: r1 r3 r6
      0x006c: PHI (r1v14 java.lang.String) = (r1v6 java.lang.String), (r1v10 java.lang.String), (r1v38 java.lang.String) binds: [B:55:0x00d8, B:49:0x00c8, B:22:0x0068] A[DONT_GENERATE, DONT_INLINE]
      0x006c: PHI (r3v3 boolean) = (r3v2 boolean), (r3v2 boolean), (r3v5 boolean) binds: [B:55:0x00d8, B:49:0x00c8, B:22:0x0068] A[DONT_GENERATE, DONT_INLINE]
      0x006c: PHI (r6v4 java.util.List<com.studiolaganne.lengendarylens.MTSharedCollectionInviteParticipant>) = 
      (r6v2 java.util.List<com.studiolaganne.lengendarylens.MTSharedCollectionInviteParticipant>)
      (r6v2 java.util.List<com.studiolaganne.lengendarylens.MTSharedCollectionInviteParticipant>)
      (r6v11 java.util.List<com.studiolaganne.lengendarylens.MTSharedCollectionInviteParticipant>)
     binds: [B:55:0x00d8, B:49:0x00c8, B:22:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(PendingInviteViewHolder holder, int position) {
        List<MTSharedCollectionInviteParticipant> participants;
        MTSharedCollectionInviteParticipant mTSharedCollectionInviteParticipant;
        String username;
        MTPrivacyUser user;
        MTPrivacyUser user2;
        Object next;
        MTSharedCollectionInviteParticipant mTSharedCollectionInviteParticipant2;
        Object next2;
        String firstname;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PendingItem pendingItem = this.items.get(position);
        Context context = holder.itemView.getContext();
        String str = "";
        if (pendingItem instanceof PendingItem.Invite) {
            MTSharedCollectionInvite invite = ((PendingItem.Invite) pendingItem).getInvite();
            holder.getInviteLabel().setText(R.string.pending_invite_header);
            if (!Intrinsics.areEqual(invite.getDirection(), "outgoing") && (invite.getDirection() != null || invite.getInviter_userid() != this.currentUserId)) {
                z = false;
            }
            participants = invite.getParticipants();
            MTPrivacyUser other_party = invite.getOther_party();
            if (other_party == null || (firstname = other_party.getFirstname()) == null) {
                MTPrivacyUser other_party2 = invite.getOther_party();
                username = other_party2 != null ? other_party2.getUsername() : null;
                if (username != null) {
                    str = username;
                }
            } else {
                str = firstname;
            }
        } else {
            if (!(pendingItem instanceof PendingItem.Unshare)) {
                throw new NoWhenBranchMatchedException();
            }
            MTUnshareRequest request = ((PendingItem.Unshare) pendingItem).getRequest();
            holder.getInviteLabel().setText(R.string.pending_unshare_header);
            Integer requester_userid = request.getRequester_userid();
            z = requester_userid != null && requester_userid.intValue() == this.currentUserId;
            participants = request.getParticipants();
            if (participants != null) {
                Iterator<T> it = participants.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((MTSharedCollectionInviteParticipant) next).getUserid() != this.currentUserId) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                mTSharedCollectionInviteParticipant = (MTSharedCollectionInviteParticipant) next;
            } else {
                mTSharedCollectionInviteParticipant = null;
            }
            if (mTSharedCollectionInviteParticipant == null || (user2 = mTSharedCollectionInviteParticipant.getUser()) == null || (username = user2.getFirstname()) == null) {
                username = (mTSharedCollectionInviteParticipant == null || (user = mTSharedCollectionInviteParticipant.getUser()) == null) ? null : user.getUsername();
                if (username != null) {
                }
            }
        }
        holder.getOtherPartyName().setText("• " + str);
        holder.getParticipantsContainer().removeAllViews();
        if (participants != null) {
            for (MTSharedCollectionInviteParticipant mTSharedCollectionInviteParticipant3 : participants) {
                Intrinsics.checkNotNull(context);
                holder.getParticipantsContainer().addView(buildParticipantView(context, mTSharedCollectionInviteParticipant3));
            }
        }
        if (participants != null) {
            Iterator<T> it2 = participants.iterator();
            while (true) {
                if (it2.hasNext()) {
                    next2 = it2.next();
                    if (((MTSharedCollectionInviteParticipant) next2).getUserid() == this.currentUserId) {
                        break;
                    }
                } else {
                    next2 = null;
                    break;
                }
            }
            mTSharedCollectionInviteParticipant2 = (MTSharedCollectionInviteParticipant) next2;
        } else {
            mTSharedCollectionInviteParticipant2 = null;
        }
        String status = mTSharedCollectionInviteParticipant2 != null ? mTSharedCollectionInviteParticipant2.getStatus() : null;
        holder.getAcceptButton().setVisibility(8);
        holder.getRejectButton().setVisibility(8);
        holder.getCancelInviteButton().setVisibility(8);
        holder.getStatusText().setVisibility(8);
        if (z) {
            holder.getCancelInviteButton().setVisibility(0);
            holder.getCancelInviteButton().setText(pendingItem instanceof PendingItem.Unshare ? R.string.cancel_unshare_request : R.string.cancel_invitation);
            ViewExtensionsKt.setOnClickWithFade(holder.getCancelInviteButton(), new Function0() { // from class: com.studiolaganne.lengendarylens.PendingInviteAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PendingInviteAdapter.onBindViewHolder$lambda$3(pendingItem, this);
                }
            });
        } else {
            if (Intrinsics.areEqual(status, "accepted")) {
                holder.getStatusText().setVisibility(0);
                return;
            }
            holder.getAcceptButton().setVisibility(0);
            holder.getRejectButton().setVisibility(0);
            ViewExtensionsKt.setOnClickWithFade(holder.getAcceptButton(), new Function0() { // from class: com.studiolaganne.lengendarylens.PendingInviteAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PendingInviteAdapter.onBindViewHolder$lambda$4(pendingItem, this);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(holder.getRejectButton(), new Function0() { // from class: com.studiolaganne.lengendarylens.PendingInviteAdapter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PendingInviteAdapter.onBindViewHolder$lambda$5(pendingItem, this);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PendingInviteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pending_invite, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new PendingInviteViewHolder(viewInflate);
    }

    public final void updateItems(List<? extends PendingItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }
}
