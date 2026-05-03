package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardContainerDetailsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR\u001a\u00109\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0018\"\u0004\b;\u0010\u001a¨\u0006<"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardContainerDetailsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/CardContainerDetailsClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/CardContainerDetailsClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/CardContainerDetailsClickListener;", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "colorView", "getColorView", "()Landroid/view/View;", "setColorView", "(Landroid/view/View;)V", "iconTextView", "Landroid/widget/TextView;", "getIconTextView", "()Landroid/widget/TextView;", "setIconTextView", "(Landroid/widget/TextView;)V", "nameTextView", "getNameTextView", "setNameTextView", "numCardsLabel", "getNumCardsLabel", "setNumCardsLabel", "priceTextView", "getPriceTextView", "setPriceTextView", "deltaTextView", "getDeltaTextView", "setDeltaTextView", "cardsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getCardsRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setCardsRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "noCardsTextView", "getNoCardsTextView", "setNoCardsTextView", "viewListButtonLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getViewListButtonLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setViewListButtonLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "editActionTextView", "getEditActionTextView", "setEditActionTextView", "deleteActionTextView", "getDeleteActionTextView", "setDeleteActionTextView", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardContainerDetailsViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private RecyclerView cardsRecyclerView;
    private final CardContainerDetailsClickListener clickListener;
    private View colorView;
    private TextView deleteActionTextView;
    private TextView deltaTextView;
    private TextView editActionTextView;
    private TextView iconTextView;
    private TextView nameTextView;
    private TextView noCardsTextView;
    private TextView numCardsLabel;
    private TextView priceTextView;
    private LinearLayout rootLayout;
    private ConstraintLayout viewListButtonLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardContainerDetailsViewHolder(View itemView, CardContainerDetailsClickListener clickListener) {
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
        View viewFindViewById8 = itemView.findViewById(R.id.cardsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.cardsRecyclerView = (RecyclerView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.noCardsTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.noCardsTextView = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.viewListButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.viewListButtonLayout = (ConstraintLayout) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.editActionTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.editActionTextView = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.deleteActionTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.deleteActionTextView = (TextView) viewFindViewById12;
    }

    public final RecyclerView getCardsRecyclerView() {
        return this.cardsRecyclerView;
    }

    public final CardContainerDetailsClickListener getClickListener() {
        return this.clickListener;
    }

    public final View getColorView() {
        return this.colorView;
    }

    public final TextView getDeleteActionTextView() {
        return this.deleteActionTextView;
    }

    public final TextView getDeltaTextView() {
        return this.deltaTextView;
    }

    public final TextView getEditActionTextView() {
        return this.editActionTextView;
    }

    public final TextView getIconTextView() {
        return this.iconTextView;
    }

    public final TextView getNameTextView() {
        return this.nameTextView;
    }

    public final TextView getNoCardsTextView() {
        return this.noCardsTextView;
    }

    public final TextView getNumCardsLabel() {
        return this.numCardsLabel;
    }

    public final TextView getPriceTextView() {
        return this.priceTextView;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final ConstraintLayout getViewListButtonLayout() {
        return this.viewListButtonLayout;
    }

    public final void setCardsRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.cardsRecyclerView = recyclerView;
    }

    public final void setColorView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.colorView = view;
    }

    public final void setDeleteActionTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.deleteActionTextView = textView;
    }

    public final void setDeltaTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.deltaTextView = textView;
    }

    public final void setEditActionTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.editActionTextView = textView;
    }

    public final void setIconTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.iconTextView = textView;
    }

    public final void setNameTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.nameTextView = textView;
    }

    public final void setNoCardsTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.noCardsTextView = textView;
    }

    public final void setNumCardsLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.numCardsLabel = textView;
    }

    public final void setPriceTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.priceTextView = textView;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }

    public final void setViewListButtonLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.viewListButtonLayout = constraintLayout;
    }
}
