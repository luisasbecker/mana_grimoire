package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessagesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R\u001a\u00107\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R\u001a\u0010:\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0013\"\u0004\b<\u0010\u0015R\u001a\u0010=\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006F"}, d2 = {"Lcom/studiolaganne/lengendarylens/MessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/MessagesClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/MessagesClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/MessagesClickListener;", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "profileLayoutLeft", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getProfileLayoutLeft", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setProfileLayoutLeft", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "profileLayoutRight", "getProfileLayoutRight", "setProfileLayoutRight", "noPhotoLeft", "Landroid/widget/ImageView;", "getNoPhotoLeft", "()Landroid/widget/ImageView;", "setNoPhotoLeft", "(Landroid/widget/ImageView;)V", "noPhotoRight", "getNoPhotoRight", "setNoPhotoRight", "profilePictureLeft", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfilePictureLeft", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "setProfilePictureLeft", "(Lcom/studiolaganne/lengendarylens/CachedImageView;)V", "profilePictureRight", "getProfilePictureRight", "setProfilePictureRight", "userNameText", "Landroid/widget/TextView;", "getUserNameText", "()Landroid/widget/TextView;", "setUserNameText", "(Landroid/widget/TextView;)V", "userFirstName", "getUserFirstName", "setUserFirstName", "message", "getMessage", "setMessage", "messageTime", "getMessageTime", "setMessageTime", "spacerLeft", "getSpacerLeft", "setSpacerLeft", "spacerRight", "getSpacerRight", "setSpacerRight", "cardImage", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "getCardImage", "()Lcom/studiolaganne/lengendarylens/LoadingImageView;", "setCardImage", "(Lcom/studiolaganne/lengendarylens/LoadingImageView;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private LoadingImageView cardImage;
    private final MessagesClickListener clickListener;
    private TextView message;
    private TextView messageTime;
    private ImageView noPhotoLeft;
    private ImageView noPhotoRight;
    private ConstraintLayout profileLayoutLeft;
    private ConstraintLayout profileLayoutRight;
    private CachedImageView profilePictureLeft;
    private CachedImageView profilePictureRight;
    private LinearLayout rootLayout;
    private ConstraintLayout spacerLeft;
    private ConstraintLayout spacerRight;
    private TextView userFirstName;
    private TextView userNameText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageViewHolder(View itemView, MessagesClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.profileLayoutLeft);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.profileLayoutLeft = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.profileLayoutRight);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.profileLayoutRight = (ConstraintLayout) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.no_photo_icon_left);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.noPhotoLeft = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.no_photo_icon_right);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.noPhotoRight = (ImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.profile_icon_left);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.profilePictureLeft = (CachedImageView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.profile_icon_right);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.profilePictureRight = (CachedImageView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.userName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.userNameText = (TextView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.userFirstName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.userFirstName = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.message);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.message = (TextView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.time);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.messageTime = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.spacerLeft);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.spacerLeft = (ConstraintLayout) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.spacerRight);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.spacerRight = (ConstraintLayout) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.cardImage = (LoadingImageView) viewFindViewById14;
    }

    public final LoadingImageView getCardImage() {
        return this.cardImage;
    }

    public final MessagesClickListener getClickListener() {
        return this.clickListener;
    }

    public final TextView getMessage() {
        return this.message;
    }

    public final TextView getMessageTime() {
        return this.messageTime;
    }

    public final ImageView getNoPhotoLeft() {
        return this.noPhotoLeft;
    }

    public final ImageView getNoPhotoRight() {
        return this.noPhotoRight;
    }

    public final ConstraintLayout getProfileLayoutLeft() {
        return this.profileLayoutLeft;
    }

    public final ConstraintLayout getProfileLayoutRight() {
        return this.profileLayoutRight;
    }

    public final CachedImageView getProfilePictureLeft() {
        return this.profilePictureLeft;
    }

    public final CachedImageView getProfilePictureRight() {
        return this.profilePictureRight;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final ConstraintLayout getSpacerLeft() {
        return this.spacerLeft;
    }

    public final ConstraintLayout getSpacerRight() {
        return this.spacerRight;
    }

    public final TextView getUserFirstName() {
        return this.userFirstName;
    }

    public final TextView getUserNameText() {
        return this.userNameText;
    }

    public final void setCardImage(LoadingImageView loadingImageView) {
        Intrinsics.checkNotNullParameter(loadingImageView, "<set-?>");
        this.cardImage = loadingImageView;
    }

    public final void setMessage(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.message = textView;
    }

    public final void setMessageTime(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.messageTime = textView;
    }

    public final void setNoPhotoLeft(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.noPhotoLeft = imageView;
    }

    public final void setNoPhotoRight(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.noPhotoRight = imageView;
    }

    public final void setProfileLayoutLeft(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.profileLayoutLeft = constraintLayout;
    }

    public final void setProfileLayoutRight(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.profileLayoutRight = constraintLayout;
    }

    public final void setProfilePictureLeft(CachedImageView cachedImageView) {
        Intrinsics.checkNotNullParameter(cachedImageView, "<set-?>");
        this.profilePictureLeft = cachedImageView;
    }

    public final void setProfilePictureRight(CachedImageView cachedImageView) {
        Intrinsics.checkNotNullParameter(cachedImageView, "<set-?>");
        this.profilePictureRight = cachedImageView;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }

    public final void setSpacerLeft(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.spacerLeft = constraintLayout;
    }

    public final void setSpacerRight(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.spacerRight = constraintLayout;
    }

    public final void setUserFirstName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.userFirstName = textView;
    }

    public final void setUserNameText(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.userNameText = textView;
    }
}
