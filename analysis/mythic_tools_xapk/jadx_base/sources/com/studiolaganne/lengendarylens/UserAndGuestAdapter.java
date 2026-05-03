package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: UserAndGuestAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserAndGuestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "reversed", "", Key.ROTATION, "", "clickListener", "Lcom/studiolaganne/lengendarylens/UserAndGuestClickListener;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTUser;ZILcom/studiolaganne/lengendarylens/UserAndGuestClickListener;)V", "dpToPx", "context", "Landroid/content/Context;", "dp", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserAndGuestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_CURRENT_USER = 1;
    private static final int VIEW_TYPE_GUEST_USER = 3;
    private static final int VIEW_TYPE_MYTHIC_USER = 2;
    private final UserAndGuestClickListener clickListener;
    private final MTUser currentUser;
    private final boolean reversed;
    private final int rotation;
    public static final int $stable = 8;

    public UserAndGuestAdapter(MTUser mTUser, boolean z, int i, UserAndGuestClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.currentUser = mTUser;
        this.reversed = z;
        this.rotation = i;
        this.clickListener = clickListener;
    }

    private final int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$0(UserAndGuestAdapter userAndGuestAdapter) {
        userAndGuestAdapter.clickListener.onCurrentUserSelected();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$1$0(UserAndGuestAdapter userAndGuestAdapter) {
        userAndGuestAdapter.clickListener.onMythicUserSelected();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$0(UserAndGuestAdapter userAndGuestAdapter) {
        userAndGuestAdapter.clickListener.onGuestSelected();
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.currentUser != null ? 3 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        boolean z = this.reversed;
        MTUser mTUser = this.currentUser;
        if (z) {
            if (mTUser == null) {
                if (position == 0) {
                    return 3;
                }
                if (position == 1) {
                    return 2;
                }
                throw new IllegalArgumentException("Invalid position");
            }
            if (position == 0) {
                return 3;
            }
            if (position == 1) {
                return 2;
            }
            if (position == 2) {
                return 1;
            }
            throw new IllegalArgumentException("Invalid position");
        }
        if (mTUser == null) {
            if (position == 0) {
                return 2;
            }
            if (position == 1) {
                return 3;
            }
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            return 1;
        }
        if (position == 1) {
            return 2;
        }
        if (position == 2) {
            return 3;
        }
        throw new IllegalArgumentException("Invalid position");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CurrentUserViewHolder currentUserViewHolder = holder instanceof CurrentUserViewHolder ? (CurrentUserViewHolder) holder : null;
        if (currentUserViewHolder != null) {
            ((CurrentUserViewHolder) holder).getRootLayout().setRotation(this.rotation);
            ViewExtensionsKt.setOnClickWithFade(currentUserViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.UserAndGuestAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UserAndGuestAdapter.onBindViewHolder$lambda$0$0(this.f$0);
                }
            });
            MTUser mTUser = this.currentUser;
            if (mTUser != null) {
                currentUserViewHolder.getUserFirstName().setText(mTUser.getFirstname());
                currentUserViewHolder.getUserName().setText("@" + mTUser.getUsername());
                String picture = mTUser.getPicture();
                currentUserViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
                currentUserViewHolder.getProfileIcon().setClipToOutline(true);
                String str = picture;
                if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
                    currentUserViewHolder.getNoPhotoIcon().setVisibility(0);
                    currentUserViewHolder.getProfileIcon().setVisibility(8);
                } else {
                    currentUserViewHolder.getNoPhotoIcon().setVisibility(8);
                    currentUserViewHolder.getProfileIcon().setVisibility(0);
                    currentUserViewHolder.getProfileIcon().setAutoLoad(false);
                    currentUserViewHolder.getProfileIcon().reset();
                    currentUserViewHolder.getProfileIcon().loadImage(picture);
                }
            }
        }
        MythicUserHolder mythicUserHolder = holder instanceof MythicUserHolder ? (MythicUserHolder) holder : null;
        if (mythicUserHolder != null) {
            ((MythicUserHolder) holder).getRootLayout().setRotation(this.rotation);
            ViewExtensionsKt.setOnClickWithFade(mythicUserHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.UserAndGuestAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UserAndGuestAdapter.onBindViewHolder$lambda$1$0(this.f$0);
                }
            });
        }
        GuestUserHolder guestUserHolder = holder instanceof GuestUserHolder ? (GuestUserHolder) holder : null;
        if (guestUserHolder != null) {
            ((GuestUserHolder) holder).getRootLayout().setRotation(this.rotation);
            ViewExtensionsKt.setOnClickWithFade(guestUserHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.UserAndGuestAdapter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UserAndGuestAdapter.onBindViewHolder$lambda$2$0(this.f$0);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.current_user_item, parent, false);
            Context context = viewInflate.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int iDpToPx = dpToPx(context, 100);
            Context context2 = viewInflate.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            FlexboxLayoutManager.LayoutParams layoutParams = new FlexboxLayoutManager.LayoutParams(iDpToPx, dpToPx(context2, 100));
            layoutParams.setFlexShrink(0.0f);
            layoutParams.setFlexGrow(0.0f);
            Context context3 = viewInflate.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            int iDpToPx2 = dpToPx(context3, 4);
            layoutParams.setMargins(iDpToPx2, iDpToPx2, iDpToPx2, iDpToPx2);
            viewInflate.setLayoutParams(layoutParams);
            Intrinsics.checkNotNull(viewInflate);
            return new CurrentUserViewHolder(viewInflate, this.clickListener);
        }
        if (viewType == 2) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.mythic_user_item, parent, false);
            Context context4 = viewInflate2.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            int iDpToPx3 = dpToPx(context4, 100);
            Context context5 = viewInflate2.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
            FlexboxLayoutManager.LayoutParams layoutParams2 = new FlexboxLayoutManager.LayoutParams(iDpToPx3, dpToPx(context5, 100));
            layoutParams2.setFlexShrink(0.0f);
            layoutParams2.setFlexGrow(0.0f);
            Context context6 = viewInflate2.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
            int iDpToPx4 = dpToPx(context6, 4);
            layoutParams2.setMargins(iDpToPx4, iDpToPx4, iDpToPx4, iDpToPx4);
            viewInflate2.setLayoutParams(layoutParams2);
            Intrinsics.checkNotNull(viewInflate2);
            return new MythicUserHolder(viewInflate2, this.clickListener);
        }
        if (viewType != 3) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.guest_item, parent, false);
        Context context7 = viewInflate3.getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
        int iDpToPx5 = dpToPx(context7, 100);
        Context context8 = viewInflate3.getContext();
        Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
        FlexboxLayoutManager.LayoutParams layoutParams3 = new FlexboxLayoutManager.LayoutParams(iDpToPx5, dpToPx(context8, 100));
        layoutParams3.setFlexShrink(0.0f);
        layoutParams3.setFlexGrow(0.0f);
        Context context9 = viewInflate3.getContext();
        Intrinsics.checkNotNullExpressionValue(context9, "getContext(...)");
        int iDpToPx6 = dpToPx(context9, 4);
        layoutParams3.setMargins(iDpToPx6, iDpToPx6, iDpToPx6, iDpToPx6);
        viewInflate3.setLayoutParams(layoutParams3);
        Intrinsics.checkNotNull(viewInflate3);
        return new GuestUserHolder(viewInflate3, this.clickListener);
    }
}
