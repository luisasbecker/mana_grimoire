package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.NativeProtocol;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: FriendsListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/FriendsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", NativeProtocol.AUDIENCE_FRIENDS, "", "Lcom/studiolaganne/lengendarylens/MTFriend;", "clickListener", "Lcom/studiolaganne/lengendarylens/FriendsListClickListener;", "inviteMode", "", "playgroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/FriendsListClickListener;ZLcom/studiolaganne/lengendarylens/MTPlaygroup;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FriendsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_FRIEND = 1;
    private final FriendsListClickListener clickListener;
    private final List<MTFriend> friends;
    private final boolean inviteMode;
    private final MTPlaygroup playgroup;
    public static final int $stable = 8;

    public FriendsListAdapter(List<MTFriend> friends, FriendsListClickListener clickListener, boolean z, MTPlaygroup mTPlaygroup) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.friends = friends;
        this.clickListener = clickListener;
        this.inviteMode = z;
        this.playgroup = mTPlaygroup;
    }

    public /* synthetic */ FriendsListAdapter(List list, FriendsListClickListener friendsListClickListener, boolean z, MTPlaygroup mTPlaygroup, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, friendsListClickListener, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : mTPlaygroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$1(FriendsListAdapter friendsListAdapter, MTFriend mTFriend, View view) {
        friendsListAdapter.clickListener.onFriendInvite(mTFriend);
    }

    static final Unit onBindViewHolder$lambda$5(FriendsListAdapter friendsListAdapter, MTFriend mTFriend) {
        friendsListAdapter.clickListener.onFriendTap(mTFriend);
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$6(FriendsListViewHolder friendsListViewHolder, final FriendsListAdapter friendsListAdapter, final MTFriend mTFriend) {
        Context context = friendsListViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        IconPopupMenu.addItem$default(new IconPopupMenu(context), R.string.remove_friend, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.FriendsListAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FriendsListAdapter.onBindViewHolder$lambda$6$0(this.f$0, mTFriend);
            }
        }, 24, (Object) null).show(friendsListViewHolder.getDotsLayout());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$6$0(FriendsListAdapter friendsListAdapter, MTFriend mTFriend) {
        friendsListAdapter.clickListener.onFriendRemove(mTFriend);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.friends.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        List<MTUser> users;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final FriendsListViewHolder friendsListViewHolder = (FriendsListViewHolder) holder;
        final MTFriend mTFriend = this.friends.get(position);
        friendsListViewHolder.getUserFirstName().setText(mTFriend.getFirstname());
        friendsListViewHolder.getUserName().setText("@" + mTFriend.getUsername());
        friendsListViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        friendsListViewHolder.getProfileLayout().setClipToOutline(true);
        String picture = mTFriend.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            friendsListViewHolder.getProfileIcon().setVisibility(4);
            friendsListViewHolder.getNoPhotoIcon().setVisibility(0);
        } else {
            friendsListViewHolder.getProfileIcon().setVisibility(0);
            friendsListViewHolder.getNoPhotoIcon().setVisibility(4);
            friendsListViewHolder.getProfileIcon().reset();
            friendsListViewHolder.getProfileIcon().setAutoLoad(false);
            friendsListViewHolder.getProfileIcon().loadImage(picture);
        }
        if (!this.inviteMode) {
            friendsListViewHolder.getActionButtonLayout().setVisibility(8);
            friendsListViewHolder.getDotsLayout().setVisibility(0);
            if (Intrinsics.areEqual(mTFriend.getStatus(), "pending")) {
                friendsListViewHolder.getDotsLayout().setVisibility(8);
                friendsListViewHolder.getActionButtonLayout().setVisibility(0);
                if (mTFriend.is_requester()) {
                    friendsListViewHolder.getActionButtonText().setText(friendsListViewHolder.itemView.getResources().getString(R.string.invited));
                    friendsListViewHolder.getActionButtonLayout().setBackground(ContextCompat.getDrawable(friendsListViewHolder.itemView.getContext(), R.drawable.custom_button_background_blue));
                    friendsListViewHolder.getActionButtonLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FriendsListAdapter$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.clickListener.onFriendWaitDialog(mTFriend);
                        }
                    });
                } else {
                    friendsListViewHolder.getActionButtonText().setText(friendsListViewHolder.itemView.getResources().getString(R.string.pending));
                    friendsListViewHolder.getActionButtonLayout().setBackground(ContextCompat.getDrawable(friendsListViewHolder.itemView.getContext(), R.drawable.custom_button_background));
                    friendsListViewHolder.getActionButtonLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FriendsListAdapter$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.clickListener.onFriendPending(mTFriend);
                        }
                    });
                }
            } else {
                friendsListViewHolder.getActionButtonLayout().setVisibility(8);
                friendsListViewHolder.getDotsLayout().setVisibility(0);
                ViewExtensionsKt.setOnClickWithFade(friendsListViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.FriendsListAdapter$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FriendsListAdapter.onBindViewHolder$lambda$5(this.f$0, mTFriend);
                    }
                });
            }
            ViewExtensionsKt.setOnClickWithFade(friendsListViewHolder.getDotsLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.FriendsListAdapter$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FriendsListAdapter.onBindViewHolder$lambda$6(friendsListViewHolder, this, mTFriend);
                }
            });
            return;
        }
        friendsListViewHolder.getActionButtonLayout().setVisibility(0);
        friendsListViewHolder.getDotsLayout().setVisibility(8);
        MTPlaygroup mTPlaygroup = this.playgroup;
        MTUser mTUser = null;
        Object obj = null;
        mTUser = null;
        if (mTPlaygroup != null && (users = mTPlaygroup.getUsers()) != null) {
            Iterator<T> it = users.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MTUser) next).getId() == mTFriend.getId()) {
                    obj = next;
                    break;
                }
            }
            mTUser = (MTUser) obj;
        }
        if (mTUser != null) {
            friendsListViewHolder.getActionButtonLayout().setVisibility(0);
            if (Intrinsics.areEqual(mTUser.getStatus(), "pending")) {
                friendsListViewHolder.getActionButtonLayout().setBackground(ContextCompat.getDrawable(friendsListViewHolder.itemView.getContext(), R.drawable.custom_button_background_blue));
                friendsListViewHolder.getActionButtonText().setText(friendsListViewHolder.itemView.getResources().getString(R.string.pending));
            } else {
                friendsListViewHolder.getActionButtonLayout().setBackground(ContextCompat.getDrawable(friendsListViewHolder.itemView.getContext(), R.drawable.custom_button_background_grey));
                friendsListViewHolder.getActionButtonText().setText(friendsListViewHolder.itemView.getResources().getString(R.string.already_invited));
            }
            friendsListViewHolder.getActionButtonLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FriendsListAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendsListAdapter.onBindViewHolder$lambda$1$0(view);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(mTFriend.getStatus(), "pending")) {
            friendsListViewHolder.getActionButtonLayout().setBackground(ContextCompat.getDrawable(friendsListViewHolder.itemView.getContext(), R.drawable.custom_button_background_grey));
            friendsListViewHolder.getActionButtonText().setText(friendsListViewHolder.itemView.getResources().getString(R.string.pending));
            friendsListViewHolder.getActionButtonLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FriendsListAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendsListAdapter.onBindViewHolder$lambda$2$0(view);
                }
            });
        } else {
            friendsListViewHolder.getActionButtonLayout().setVisibility(0);
            friendsListViewHolder.getActionButtonText().setText(friendsListViewHolder.itemView.getResources().getString(R.string.invite));
            friendsListViewHolder.getActionButtonLayout().setBackground(ContextCompat.getDrawable(friendsListViewHolder.itemView.getContext(), R.drawable.custom_button_background));
            friendsListViewHolder.getActionButtonLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FriendsListAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendsListAdapter.onBindViewHolder$lambda$2$1(this.f$0, mTFriend, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new FriendsListViewHolder(viewInflate, this.clickListener);
    }
}
