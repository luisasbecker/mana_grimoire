package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleMTFullCardListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimpleMTFullCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/SimpleMTFullCardClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/SimpleMTFullCardClickListener;)V", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "cardImage", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "getCardImage", "()Lcom/studiolaganne/lengendarylens/LoadingImageView;", "setCardImage", "(Lcom/studiolaganne/lengendarylens/LoadingImageView;)V", "cornerView", "getCornerView", "()Landroid/view/View;", "setCornerView", "(Landroid/view/View;)V", "qtyTextView", "Landroid/widget/TextView;", "getQtyTextView", "()Landroid/widget/TextView;", "setQtyTextView", "(Landroid/widget/TextView;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SimpleMTFullCardViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private LoadingImageView cardImage;
    private final SimpleMTFullCardClickListener clickListener;
    private View cornerView;
    private TextView qtyTextView;
    private ConstraintLayout rootLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleMTFullCardViewHolder(View itemView, SimpleMTFullCardClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.cardImage = (LoadingImageView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.cornerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.cornerView = viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.qtyTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.qtyTextView = (TextView) viewFindViewById4;
    }

    public final LoadingImageView getCardImage() {
        return this.cardImage;
    }

    public final View getCornerView() {
        return this.cornerView;
    }

    public final TextView getQtyTextView() {
        return this.qtyTextView;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final void setCardImage(LoadingImageView loadingImageView) {
        Intrinsics.checkNotNullParameter(loadingImageView, "<set-?>");
        this.cardImage = loadingImageView;
    }

    public final void setCornerView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.cornerView = view;
    }

    public final void setQtyTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.qtyTextView = textView;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }
}
