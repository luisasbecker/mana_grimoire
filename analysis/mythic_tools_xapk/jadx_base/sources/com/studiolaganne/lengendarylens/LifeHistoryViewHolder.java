package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifeHistoryAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/LifeHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "lifeTotalTextView", "Landroid/widget/TextView;", "getLifeTotalTextView", "()Landroid/widget/TextView;", "setLifeTotalTextView", "(Landroid/widget/TextView;)V", "strikeThrough", "getStrikeThrough", "()Landroid/view/View;", "setStrikeThrough", "strikeThroughShadow", "getStrikeThroughShadow", "setStrikeThroughShadow", "offsetTextView", "getOffsetTextView", "setOffsetTextView", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LifeHistoryViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private TextView lifeTotalTextView;
    private TextView offsetTextView;
    private ConstraintLayout rootLayout;
    private View strikeThrough;
    private View strikeThroughShadow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifeHistoryViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.life_total_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.lifeTotalTextView = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.strikeThrough);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.strikeThrough = viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.strikeThroughShadow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.strikeThroughShadow = viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.offset_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.offsetTextView = (TextView) viewFindViewById5;
    }

    public final TextView getLifeTotalTextView() {
        return this.lifeTotalTextView;
    }

    public final TextView getOffsetTextView() {
        return this.offsetTextView;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final View getStrikeThrough() {
        return this.strikeThrough;
    }

    public final View getStrikeThroughShadow() {
        return this.strikeThroughShadow;
    }

    public final void setLifeTotalTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.lifeTotalTextView = textView;
    }

    public final void setOffsetTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.offsetTextView = textView;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }

    public final void setStrikeThrough(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.strikeThrough = view;
    }

    public final void setStrikeThroughShadow(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.strikeThroughShadow = view;
    }
}
