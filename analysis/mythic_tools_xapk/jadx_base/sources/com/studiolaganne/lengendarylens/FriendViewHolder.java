package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FriendsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\u001a\u0010)\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/FriendViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/FriendsClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/FriendsClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/FriendsClickListener;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "playerFirstName", "Landroid/widget/TextView;", "getPlayerFirstName", "()Landroid/widget/TextView;", "setPlayerFirstName", "(Landroid/widget/TextView;)V", "playerUserName", "getPlayerUserName", "setPlayerUserName", "iconLayout", "getIconLayout", "setIconLayout", "playerImage", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getPlayerImage", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "setPlayerImage", "(Lcom/studiolaganne/lengendarylens/CachedImageView;)V", "noPhotoIcon", "Landroid/widget/ImageView;", "getNoPhotoIcon", "()Landroid/widget/ImageView;", "statusLayout", "getStatusLayout", "setStatusLayout", "statusText", "getStatusText", "setStatusText", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FriendViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final FriendsClickListener clickListener;
    private ConstraintLayout iconLayout;
    private final ImageView noPhotoIcon;
    private TextView playerFirstName;
    private CachedImageView playerImage;
    private TextView playerUserName;
    private ConstraintLayout rootLayout;
    private ConstraintLayout statusLayout;
    private TextView statusText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendViewHolder(View itemView, FriendsClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.player_first_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.playerFirstName = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.player_user_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.playerUserName = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.playerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.iconLayout = (ConstraintLayout) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.player_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.playerImage = (CachedImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.no_photo_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.noPhotoIcon = (ImageView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.statusLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.statusLayout = (ConstraintLayout) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.statusText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.statusText = (TextView) viewFindViewById8;
    }

    public final FriendsClickListener getClickListener() {
        return this.clickListener;
    }

    public final ConstraintLayout getIconLayout() {
        return this.iconLayout;
    }

    public final ImageView getNoPhotoIcon() {
        return this.noPhotoIcon;
    }

    public final TextView getPlayerFirstName() {
        return this.playerFirstName;
    }

    public final CachedImageView getPlayerImage() {
        return this.playerImage;
    }

    public final TextView getPlayerUserName() {
        return this.playerUserName;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final ConstraintLayout getStatusLayout() {
        return this.statusLayout;
    }

    public final TextView getStatusText() {
        return this.statusText;
    }

    public final void setIconLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.iconLayout = constraintLayout;
    }

    public final void setPlayerFirstName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.playerFirstName = textView;
    }

    public final void setPlayerImage(CachedImageView cachedImageView) {
        Intrinsics.checkNotNullParameter(cachedImageView, "<set-?>");
        this.playerImage = cachedImageView;
    }

    public final void setPlayerUserName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.playerUserName = textView;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }

    public final void setStatusLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.statusLayout = constraintLayout;
    }

    public final void setStatusText(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.statusText = textView;
    }
}
