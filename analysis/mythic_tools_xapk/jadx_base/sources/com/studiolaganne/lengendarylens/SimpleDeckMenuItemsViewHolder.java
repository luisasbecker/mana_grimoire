package com.studiolaganne.lengendarylens;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleDecksAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimpleDeckMenuItemsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/SimpleDeckClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/SimpleDeckClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/SimpleDeckClickListener;", "cardView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getCardView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setCardView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "backLayout", "getBackLayout", "setBackLayout", "refreshLayout", "getRefreshLayout", "setRefreshLayout", "createLayout", "getCreateLayout", "setCreateLayout", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SimpleDeckMenuItemsViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private ConstraintLayout backLayout;
    private ConstraintLayout cardView;
    private final SimpleDeckClickListener clickListener;
    private ConstraintLayout createLayout;
    private ConstraintLayout refreshLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDeckMenuItemsViewHolder(View itemView, SimpleDeckClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.cardView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.cardView = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.back_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.backLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.refresh_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.refreshLayout = (ConstraintLayout) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.create_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.createLayout = (ConstraintLayout) viewFindViewById4;
    }

    public final ConstraintLayout getBackLayout() {
        return this.backLayout;
    }

    public final ConstraintLayout getCardView() {
        return this.cardView;
    }

    public final SimpleDeckClickListener getClickListener() {
        return this.clickListener;
    }

    public final ConstraintLayout getCreateLayout() {
        return this.createLayout;
    }

    public final ConstraintLayout getRefreshLayout() {
        return this.refreshLayout;
    }

    public final void setBackLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.backLayout = constraintLayout;
    }

    public final void setCardView(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.cardView = constraintLayout;
    }

    public final void setCreateLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.createLayout = constraintLayout;
    }

    public final void setRefreshLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.refreshLayout = constraintLayout;
    }
}
