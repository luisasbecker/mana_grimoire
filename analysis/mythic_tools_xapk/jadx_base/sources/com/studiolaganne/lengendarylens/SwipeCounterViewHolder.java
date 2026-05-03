package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwipeCountersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/SwipeCounterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/SwipeCountersClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/SwipeCountersClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/SwipeCountersClickListener;", "cardView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getCardView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setCardView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "rootLayout", "getRootLayout", "setRootLayout", "counterName", "Landroid/widget/TextView;", "getCounterName", "()Landroid/widget/TextView;", "setCounterName", "(Landroid/widget/TextView;)V", "iconImage", "Landroid/widget/ImageView;", "getIconImage", "()Landroid/widget/ImageView;", "setIconImage", "(Landroid/widget/ImageView;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SwipeCounterViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private ConstraintLayout cardView;
    private final SwipeCountersClickListener clickListener;
    private TextView counterName;
    private ImageView iconImage;
    private ConstraintLayout rootLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeCounterViewHolder(View itemView, SwipeCountersClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.cardView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.cardView = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.counter_name_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.counterName = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.iconImage = (ImageView) viewFindViewById4;
    }

    public final ConstraintLayout getCardView() {
        return this.cardView;
    }

    public final SwipeCountersClickListener getClickListener() {
        return this.clickListener;
    }

    public final TextView getCounterName() {
        return this.counterName;
    }

    public final ImageView getIconImage() {
        return this.iconImage;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final void setCardView(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.cardView = constraintLayout;
    }

    public final void setCounterName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.counterName = textView;
    }

    public final void setIconImage(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.iconImage = imageView;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }
}
