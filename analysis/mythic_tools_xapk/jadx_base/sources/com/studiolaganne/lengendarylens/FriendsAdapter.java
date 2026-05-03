package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: FriendsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/FriendsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", NativeProtocol.AUDIENCE_FRIENDS, "", "Lcom/studiolaganne/lengendarylens/MTFriend;", "clickListener", "Lcom/studiolaganne/lengendarylens/FriendsClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/FriendsClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FriendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_ADD = 0;
    private static final int VIEW_TYPE_FRIEND = 1;
    private final FriendsClickListener clickListener;
    private final List<MTFriend> friends;
    public static final int $stable = 8;

    public FriendsAdapter(List<MTFriend> friends, FriendsClickListener clickListener) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.friends = friends;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$0(AddFriendViewHolder addFriendViewHolder) {
        addFriendViewHolder.getClickListener().onAddFriendTapped();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$1(FriendViewHolder friendViewHolder, MTFriend mTFriend) {
        friendViewHolder.getClickListener().onFriendSelected(mTFriend);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.friends.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position == 0) {
            final AddFriendViewHolder addFriendViewHolder = (AddFriendViewHolder) holder;
            ViewExtensionsKt.setOnClickWithFade(addFriendViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.FriendsAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FriendsAdapter.onBindViewHolder$lambda$0(addFriendViewHolder);
                }
            });
            return;
        }
        final FriendViewHolder friendViewHolder = (FriendViewHolder) holder;
        final MTFriend mTFriend = this.friends.get(position - 1);
        friendViewHolder.getPlayerFirstName().setText(mTFriend.getFirstname());
        friendViewHolder.getPlayerUserName().setText("@" + mTFriend.getUsername());
        ViewExtensionsKt.setOnClickWithFade(friendViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.FriendsAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FriendsAdapter.onBindViewHolder$lambda$1(friendViewHolder, mTFriend);
            }
        });
        friendViewHolder.getIconLayout().setOutlineProvider(new CircularOutlineProvider());
        friendViewHolder.getIconLayout().setClipToOutline(true);
        friendViewHolder.getPlayerImage().setOutlineProvider(new CircularOutlineProvider());
        friendViewHolder.getPlayerImage().setClipToOutline(true);
        friendViewHolder.getNoPhotoIcon().setVisibility(4);
        String picture = mTFriend.getPicture();
        if (picture == null) {
            friendViewHolder.getPlayerImage().setVisibility(4);
            friendViewHolder.getNoPhotoIcon().setVisibility(0);
            return;
        }
        if (picture.length() <= 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            friendViewHolder.getPlayerImage().setVisibility(4);
            friendViewHolder.getNoPhotoIcon().setVisibility(0);
            return;
        }
        friendViewHolder.getPlayerImage().setAutoLoad(false);
        friendViewHolder.getPlayerImage().reset();
        friendViewHolder.getPlayerImage().loadImage(picture);
        if (!Intrinsics.areEqual(mTFriend.getStatus(), "pending")) {
            friendViewHolder.getPlayerImage().setAlpha(1.0f);
            friendViewHolder.getStatusLayout().setVisibility(8);
            return;
        }
        friendViewHolder.getPlayerImage().setAlpha(0.5f);
        friendViewHolder.getStatusLayout().setVisibility(0);
        if (mTFriend.is_requester()) {
            friendViewHolder.getStatusText().setText(friendViewHolder.itemView.getContext().getString(R.string.invited));
        } else {
            friendViewHolder.getStatusText().setText(friendViewHolder.itemView.getContext().getString(R.string.pending));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_friend_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new AddFriendViewHolder(viewInflate, this.clickListener);
        }
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new FriendViewHolder(viewInflate2, this.clickListener);
    }
}
