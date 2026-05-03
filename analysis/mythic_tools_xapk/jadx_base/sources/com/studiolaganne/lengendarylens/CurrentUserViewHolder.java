package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAndGuestAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/CurrentUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/UserAndGuestClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/UserAndGuestClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/UserAndGuestClickListener;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIcon", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "noPhotoIcon", "Landroid/widget/ImageView;", "getNoPhotoIcon", "()Landroid/widget/ImageView;", "userFirstName", "Landroid/widget/TextView;", "getUserFirstName", "()Landroid/widget/TextView;", "userName", "getUserName", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CurrentUserViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final UserAndGuestClickListener clickListener;
    private final ImageView noPhotoIcon;
    private final CachedImageView profileIcon;
    private ConstraintLayout profileLayout;
    private ConstraintLayout rootLayout;
    private final TextView userFirstName;
    private final TextView userName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrentUserViewHolder(View itemView, UserAndGuestClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.profileLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.profileLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.profile_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.profileIcon = (CachedImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.no_photo_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.noPhotoIcon = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.userFirstName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.userFirstName = (TextView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.userName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.userName = (TextView) viewFindViewById6;
    }

    public final UserAndGuestClickListener getClickListener() {
        return this.clickListener;
    }

    public final ImageView getNoPhotoIcon() {
        return this.noPhotoIcon;
    }

    public final CachedImageView getProfileIcon() {
        return this.profileIcon;
    }

    public final ConstraintLayout getProfileLayout() {
        return this.profileLayout;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final TextView getUserFirstName() {
        return this.userFirstName;
    }

    public final TextView getUserName() {
        return this.userName;
    }

    public final void setProfileLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.profileLayout = constraintLayout;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }
}
