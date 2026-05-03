package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.ProfileBottomSheetFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PlaygroupUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupUsersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/studiolaganne/lengendarylens/ProfileCallback;", "users", "", "Lcom/studiolaganne/lengendarylens/MTUser;", "currentUser", "playgroupAdmins", "", "ownerId", "clickListener", "Lcom/studiolaganne/lengendarylens/PlaygroupUserClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTUser;Ljava/util/List;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/PlaygroupUserClickListener;)V", "Ljava/lang/Integer;", "currentProfileSheet", "Lcom/studiolaganne/lengendarylens/ProfileBottomSheetFragment;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "onProfileClose", "onProfileLogout", "onProfilePictureUpdated", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupUsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ProfileCallback {
    private static final int VIEW_TYPE_PLAYGROUP_USER = 1;
    private final PlaygroupUserClickListener clickListener;
    private ProfileBottomSheetFragment currentProfileSheet;
    private final MTUser currentUser;
    private final Integer ownerId;
    private final List<Integer> playgroupAdmins;
    private final List<MTUser> users;
    public static final int $stable = 8;

    public PlaygroupUsersAdapter(List<MTUser> users, MTUser currentUser, List<Integer> playgroupAdmins, Integer num, PlaygroupUserClickListener clickListener) {
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(currentUser, "currentUser");
        Intrinsics.checkNotNullParameter(playgroupAdmins, "playgroupAdmins");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.users = users;
        this.currentUser = currentUser;
        this.playgroupAdmins = playgroupAdmins;
        this.ownerId = num;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$3(PlaygroupUsersAdapter playgroupUsersAdapter, MTUser mTUser) {
        playgroupUsersAdapter.clickListener.onUserLeave(mTUser);
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$4(PlaygroupUsersAdapter playgroupUsersAdapter, MTUser mTUser) {
        playgroupUsersAdapter.clickListener.onUserPending(mTUser);
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$5(PlaygroupUserViewHolder playgroupUserViewHolder, final PlaygroupUsersAdapter playgroupUsersAdapter, final MTUser mTUser, Ref.BooleanRef booleanRef) {
        Object next;
        Context context = playgroupUserViewHolder.itemView.getContext();
        Intrinsics.checkNotNull(context);
        Iterator<T> it = new PreferencesManager(context).getCurrentUserFriends().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MTFriend) next).getId() == mTUser.getId()) {
                break;
            }
        }
        boolean z = next != null;
        boolean zContains = playgroupUsersAdapter.playgroupAdmins.contains(Integer.valueOf(mTUser.getId()));
        boolean zContains2 = playgroupUsersAdapter.playgroupAdmins.contains(Integer.valueOf(playgroupUsersAdapter.currentUser.getId()));
        IconPopupMenu iconPopupMenu = new IconPopupMenu(context);
        if (!z) {
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.send_friend_request, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupUsersAdapter.onBindViewHolder$lambda$5$1(this.f$0, mTUser);
                }
            }, 30, (Object) null);
        }
        if (zContains2 && !zContains) {
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.make_admin_user, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupUsersAdapter.onBindViewHolder$lambda$5$2(this.f$0, mTUser);
                }
            }, 30, (Object) null);
        }
        if (booleanRef.element && zContains) {
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.remove_admin_user, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupUsersAdapter.onBindViewHolder$lambda$5$3(this.f$0, mTUser);
                }
            }, 30, (Object) null);
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.transfer_ownership, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupUsersAdapter.onBindViewHolder$lambda$5$4(this.f$0, mTUser);
                }
            }, 30, (Object) null);
        }
        if (zContains2 && !zContains) {
            iconPopupMenu.addDivider();
            IconPopupMenu.addItem$default(iconPopupMenu, R.string.remove_playgroup_user, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupUsersAdapter.onBindViewHolder$lambda$5$5(this.f$0, mTUser);
                }
            }, 24, (Object) null);
        }
        iconPopupMenu.show(playgroupUserViewHolder.getDotsLayout());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$1(PlaygroupUsersAdapter playgroupUsersAdapter, MTUser mTUser) {
        playgroupUsersAdapter.clickListener.onUserFriendRequest(mTUser);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$2(PlaygroupUsersAdapter playgroupUsersAdapter, MTUser mTUser) {
        playgroupUsersAdapter.clickListener.onUserAdminPromote(mTUser);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$3(PlaygroupUsersAdapter playgroupUsersAdapter, MTUser mTUser) {
        playgroupUsersAdapter.clickListener.onUserAdminRemove(mTUser);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$4(PlaygroupUsersAdapter playgroupUsersAdapter, MTUser mTUser) {
        playgroupUsersAdapter.clickListener.onTransferOwnership(mTUser);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$5(PlaygroupUsersAdapter playgroupUsersAdapter, MTUser mTUser) {
        playgroupUsersAdapter.clickListener.onUserRemove(mTUser);
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$6(PlaygroupUsersAdapter playgroupUsersAdapter, MTUser mTUser, PlaygroupUserViewHolder playgroupUserViewHolder) {
        ProfileBottomSheetFragment profileBottomSheetFragmentNewInstance$default = ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, playgroupUsersAdapter, mTUser, true, null, 8, null);
        playgroupUsersAdapter.currentProfileSheet = profileBottomSheetFragmentNewInstance$default;
        Context context = playgroupUserViewHolder.itemView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.PlaygroupDetailsActivity");
        profileBottomSheetFragmentNewInstance$default.show(((PlaygroupDetailsActivity) context).getSupportFragmentManager(), ProfileBottomSheetFragment.TAG);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.users.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016f  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        boolean z;
        final Ref.BooleanRef booleanRef;
        Integer num;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PlaygroupUserViewHolder playgroupUserViewHolder = (PlaygroupUserViewHolder) holder;
        final MTUser mTUser = this.users.get(position);
        playgroupUserViewHolder.getUserFirstName().setText(mTUser.getFirstname());
        playgroupUserViewHolder.getUserName().setText("@" + mTUser.getUsername());
        playgroupUserViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        playgroupUserViewHolder.getProfileLayout().setClipToOutline(true);
        playgroupUserViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        playgroupUserViewHolder.getProfileIcon().setClipToOutline(true);
        String picture = mTUser.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            playgroupUserViewHolder.getProfileIcon().setVisibility(4);
            playgroupUserViewHolder.getNoPhotoIcon().setVisibility(0);
        } else {
            playgroupUserViewHolder.getProfileIcon().setVisibility(0);
            playgroupUserViewHolder.getNoPhotoIcon().setVisibility(4);
            playgroupUserViewHolder.getProfileIcon().reset();
            playgroupUserViewHolder.getProfileIcon().setAutoLoad(false);
            playgroupUserViewHolder.getProfileIcon().loadImage(picture);
        }
        Integer num2 = this.ownerId;
        if (num2 != null && num2.intValue() == mTUser.getId()) {
            playgroupUserViewHolder.getOwnerLabel().setVisibility(0);
            z = false;
            if (this.playgroupAdmins.contains(Integer.valueOf(mTUser.getId()))) {
                playgroupUserViewHolder.getAdminLabel().setVisibility(8);
            }
            playgroupUserViewHolder.getDotsLayout().setVisibility(8);
            booleanRef = new Ref.BooleanRef();
            num = this.ownerId;
            if (num != null) {
                booleanRef.element = true;
            }
            if (mTUser.getId() != this.currentUser.getId()) {
            }
            ViewExtensionsKt.setOnClickWithFade(playgroupUserViewHolder.getProfileLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupUsersAdapter.onBindViewHolder$lambda$6(this.f$0, mTUser, playgroupUserViewHolder);
                }
            });
        }
        playgroupUserViewHolder.getOwnerLabel().setVisibility(8);
        z = true;
        if (this.playgroupAdmins.contains(Integer.valueOf(mTUser.getId())) || !z) {
            playgroupUserViewHolder.getAdminLabel().setVisibility(8);
        } else {
            playgroupUserViewHolder.getAdminLabel().setVisibility(0);
        }
        playgroupUserViewHolder.getDotsLayout().setVisibility(8);
        booleanRef = new Ref.BooleanRef();
        num = this.ownerId;
        if (num != null && num.intValue() == this.currentUser.getId()) {
            booleanRef.element = true;
        }
        if (mTUser.getId() != this.currentUser.getId()) {
            playgroupUserViewHolder.getYouLabel().setVisibility(0);
            playgroupUserViewHolder.getActionButtonLayout().setVisibility(0);
            playgroupUserViewHolder.getActionButtonLayout().setBackground(ContextCompat.getDrawable(playgroupUserViewHolder.itemView.getContext(), R.drawable.custom_button_background));
            playgroupUserViewHolder.getActionButtonText().setText(playgroupUserViewHolder.itemView.getResources().getString(R.string.leave_playgroup_short));
            ViewExtensionsKt.setOnClickWithFade(playgroupUserViewHolder.getActionButtonLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupUsersAdapter.onBindViewHolder$lambda$3(this.f$0, mTUser);
                }
            });
        } else {
            playgroupUserViewHolder.getYouLabel().setVisibility(8);
            if (Intrinsics.areEqual(mTUser.getStatus(), "pending")) {
                playgroupUserViewHolder.getActionButtonLayout().setVisibility(0);
                playgroupUserViewHolder.getActionButtonLayout().setBackground(ContextCompat.getDrawable(playgroupUserViewHolder.itemView.getContext(), R.drawable.custom_button_background_blue));
                playgroupUserViewHolder.getActionButtonText().setText(playgroupUserViewHolder.itemView.getResources().getString(R.string.pending));
                ViewExtensionsKt.setOnClickWithFade(playgroupUserViewHolder.getActionButtonLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PlaygroupUsersAdapter.onBindViewHolder$lambda$4(this.f$0, mTUser);
                    }
                });
            } else {
                playgroupUserViewHolder.getActionButtonLayout().setVisibility(8);
                playgroupUserViewHolder.getDotsLayout().setVisibility(0);
                ViewExtensionsKt.setOnClickWithFade(playgroupUserViewHolder.getDotsLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PlaygroupUsersAdapter.onBindViewHolder$lambda$5(playgroupUserViewHolder, this, mTUser, booleanRef);
                    }
                });
            }
        }
        ViewExtensionsKt.setOnClickWithFade(playgroupUserViewHolder.getProfileLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupUsersAdapter.onBindViewHolder$lambda$6(this.f$0, mTUser, playgroupUserViewHolder);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.playgroup_member_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new PlaygroupUserViewHolder(viewInflate, this.clickListener);
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfileClose() {
        ProfileBottomSheetFragment profileBottomSheetFragment = this.currentProfileSheet;
        if (profileBottomSheetFragment != null) {
            profileBottomSheetFragment.dismiss();
        }
        this.currentProfileSheet = null;
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfileLogout() {
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfilePictureUpdated() {
    }
}
