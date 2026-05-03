package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaygroupUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010&\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010(\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010*\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0013R\u0011\u0010,\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0011\u0010.\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0013¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/PlaygroupUserClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/PlaygroupUserClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/PlaygroupUserClickListener;", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "profileLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getProfileLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setProfileLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIcon", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "noPhotoIcon", "Landroid/widget/ImageView;", "getNoPhotoIcon", "()Landroid/widget/ImageView;", "userFirstName", "Landroid/widget/TextView;", "getUserFirstName", "()Landroid/widget/TextView;", "userName", "getUserName", "youLabel", "getYouLabel", "adminLabel", "getAdminLabel", "ownerLabel", "getOwnerLabel", "actionButtonLayout", "getActionButtonLayout", "actionButtonText", "getActionButtonText", "dotsLayout", "getDotsLayout", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupUserViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ConstraintLayout actionButtonLayout;
    private final TextView actionButtonText;
    private final TextView adminLabel;
    private final PlaygroupUserClickListener clickListener;
    private final ConstraintLayout dotsLayout;
    private final ImageView noPhotoIcon;
    private final TextView ownerLabel;
    private final CachedImageView profileIcon;
    private ConstraintLayout profileLayout;
    private LinearLayout rootLayout;
    private final TextView userFirstName;
    private final TextView userName;
    private final TextView youLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaygroupUserViewHolder(View itemView, PlaygroupUserClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
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
        View viewFindViewById7 = itemView.findViewById(R.id.youBox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.youLabel = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.adminBox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.adminLabel = (TextView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.ownerBox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.ownerLabel = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.actionButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.actionButtonLayout = (ConstraintLayout) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.actionButtonText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.actionButtonText = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.dotsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.dotsLayout = (ConstraintLayout) viewFindViewById12;
    }

    public final ConstraintLayout getActionButtonLayout() {
        return this.actionButtonLayout;
    }

    public final TextView getActionButtonText() {
        return this.actionButtonText;
    }

    public final TextView getAdminLabel() {
        return this.adminLabel;
    }

    public final PlaygroupUserClickListener getClickListener() {
        return this.clickListener;
    }

    public final ConstraintLayout getDotsLayout() {
        return this.dotsLayout;
    }

    public final ImageView getNoPhotoIcon() {
        return this.noPhotoIcon;
    }

    public final TextView getOwnerLabel() {
        return this.ownerLabel;
    }

    public final CachedImageView getProfileIcon() {
        return this.profileIcon;
    }

    public final ConstraintLayout getProfileLayout() {
        return this.profileLayout;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final TextView getUserFirstName() {
        return this.userFirstName;
    }

    public final TextView getUserName() {
        return this.userName;
    }

    public final TextView getYouLabel() {
        return this.youLabel;
    }

    public final void setProfileLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.profileLayout = constraintLayout;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }
}
