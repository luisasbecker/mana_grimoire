package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardContainerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u00106\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\u001a\u00109\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0018\"\u0004\bG\u0010\u001a¨\u0006H"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardContainerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/CardContainerClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/CardContainerClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/CardContainerClickListener;", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "colorView", "getColorView", "()Landroid/view/View;", "setColorView", "(Landroid/view/View;)V", "iconTextView", "Landroid/widget/TextView;", "getIconTextView", "()Landroid/widget/TextView;", "setIconTextView", "(Landroid/widget/TextView;)V", "nameTextView", "getNameTextView", "setNameTextView", "numCardsLabel", "getNumCardsLabel", "setNumCardsLabel", "priceTextView", "getPriceTextView", "setPriceTextView", "deltaTextView", "getDeltaTextView", "setDeltaTextView", "deckImage", "Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "getDeckImage", "()Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "setDeckImage", "(Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;)V", "innerLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getInnerLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setInnerLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "dotsLayout", "getDotsLayout", "setDotsLayout", "ownerLayout", "getOwnerLayout", "setOwnerLayout", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIcon", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "setProfileIcon", "(Lcom/studiolaganne/lengendarylens/CachedImageView;)V", "noPhotoIcon", "Landroid/widget/ImageView;", "getNoPhotoIcon", "()Landroid/widget/ImageView;", "setNoPhotoIcon", "(Landroid/widget/ImageView;)V", "userName", "getUserName", "setUserName", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardContainerViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final CardContainerClickListener clickListener;
    private View colorView;
    private LoadingImageViewDeck deckImage;
    private TextView deltaTextView;
    private ConstraintLayout dotsLayout;
    private TextView iconTextView;
    private ConstraintLayout innerLayout;
    private TextView nameTextView;
    private ImageView noPhotoIcon;
    private TextView numCardsLabel;
    private LinearLayout ownerLayout;
    private TextView priceTextView;
    private CachedImageView profileIcon;
    private LinearLayout rootLayout;
    private TextView userName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardContainerViewHolder(View itemView, CardContainerClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.colorView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.colorView = viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.iconTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.iconTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.nameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.nameTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.numCardsLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.numCardsLabel = (TextView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.priceTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.priceTextView = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.deltaTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.deltaTextView = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.deckImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.deckImage = (LoadingImageViewDeck) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.innerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.innerLayout = (ConstraintLayout) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.dotsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.dotsLayout = (ConstraintLayout) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.ownerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.ownerLayout = (LinearLayout) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.profile_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.profileIcon = (CachedImageView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.no_photo_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.noPhotoIcon = (ImageView) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.userName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.userName = (TextView) viewFindViewById14;
    }

    public final CardContainerClickListener getClickListener() {
        return this.clickListener;
    }

    public final View getColorView() {
        return this.colorView;
    }

    public final LoadingImageViewDeck getDeckImage() {
        return this.deckImage;
    }

    public final TextView getDeltaTextView() {
        return this.deltaTextView;
    }

    public final ConstraintLayout getDotsLayout() {
        return this.dotsLayout;
    }

    public final TextView getIconTextView() {
        return this.iconTextView;
    }

    public final ConstraintLayout getInnerLayout() {
        return this.innerLayout;
    }

    public final TextView getNameTextView() {
        return this.nameTextView;
    }

    public final ImageView getNoPhotoIcon() {
        return this.noPhotoIcon;
    }

    public final TextView getNumCardsLabel() {
        return this.numCardsLabel;
    }

    public final LinearLayout getOwnerLayout() {
        return this.ownerLayout;
    }

    public final TextView getPriceTextView() {
        return this.priceTextView;
    }

    public final CachedImageView getProfileIcon() {
        return this.profileIcon;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final TextView getUserName() {
        return this.userName;
    }

    public final void setColorView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.colorView = view;
    }

    public final void setDeckImage(LoadingImageViewDeck loadingImageViewDeck) {
        Intrinsics.checkNotNullParameter(loadingImageViewDeck, "<set-?>");
        this.deckImage = loadingImageViewDeck;
    }

    public final void setDeltaTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.deltaTextView = textView;
    }

    public final void setDotsLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.dotsLayout = constraintLayout;
    }

    public final void setIconTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.iconTextView = textView;
    }

    public final void setInnerLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.innerLayout = constraintLayout;
    }

    public final void setNameTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.nameTextView = textView;
    }

    public final void setNoPhotoIcon(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.noPhotoIcon = imageView;
    }

    public final void setNumCardsLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.numCardsLabel = textView;
    }

    public final void setOwnerLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.ownerLayout = linearLayout;
    }

    public final void setPriceTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.priceTextView = textView;
    }

    public final void setProfileIcon(CachedImageView cachedImageView) {
        Intrinsics.checkNotNullParameter(cachedImageView, "<set-?>");
        this.profileIcon = cachedImageView;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }

    public final void setUserName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.userName = textView;
    }
}
