package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwipePlaymatAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/SwipePlaymatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/SwipePlaymatClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/SwipePlaymatClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/SwipePlaymatClickListener;", "cardView", "Lcom/google/android/material/card/MaterialCardView;", "getCardView", "()Lcom/google/android/material/card/MaterialCardView;", "setCardView", "(Lcom/google/android/material/card/MaterialCardView;)V", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "playmatName", "Landroid/widget/TextView;", "getPlaymatName", "()Landroid/widget/TextView;", "setPlaymatName", "(Landroid/widget/TextView;)V", "playmatImage", "Landroid/widget/ImageView;", "getPlaymatImage", "()Landroid/widget/ImageView;", "setPlaymatImage", "(Landroid/widget/ImageView;)V", "lockImage", "getLockImage", "setLockImage", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SwipePlaymatViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private MaterialCardView cardView;
    private final SwipePlaymatClickListener clickListener;
    private ImageView lockImage;
    private ImageView playmatImage;
    private TextView playmatName;
    private ConstraintLayout rootLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipePlaymatViewHolder(View itemView, SwipePlaymatClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.cardView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.cardView = (MaterialCardView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.playmat_name_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.playmatName = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.playmat_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.playmatImage = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.lock_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.lockImage = (ImageView) viewFindViewById5;
    }

    public final MaterialCardView getCardView() {
        return this.cardView;
    }

    public final SwipePlaymatClickListener getClickListener() {
        return this.clickListener;
    }

    public final ImageView getLockImage() {
        return this.lockImage;
    }

    public final ImageView getPlaymatImage() {
        return this.playmatImage;
    }

    public final TextView getPlaymatName() {
        return this.playmatName;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final void setCardView(MaterialCardView materialCardView) {
        Intrinsics.checkNotNullParameter(materialCardView, "<set-?>");
        this.cardView = materialCardView;
    }

    public final void setLockImage(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.lockImage = imageView;
    }

    public final void setPlaymatImage(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.playmatImage = imageView;
    }

    public final void setPlaymatName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.playmatName = textView;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }
}
