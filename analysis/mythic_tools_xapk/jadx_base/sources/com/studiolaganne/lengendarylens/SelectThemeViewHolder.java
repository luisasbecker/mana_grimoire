package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectThemeAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\rR\u0011\u0010\"\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001b¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/SelectThemeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/SelectThemeListClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/SelectThemeListClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/SelectThemeListClickListener;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "innerLayout", "Landroid/widget/LinearLayout;", "getInnerLayout", "()Landroid/widget/LinearLayout;", "checkmark", "Landroid/widget/ImageView;", "getCheckmark", "()Landroid/widget/ImageView;", "themeTitle", "Landroid/widget/TextView;", "getThemeTitle", "()Landroid/widget/TextView;", "themeImage", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getThemeImage", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "buyButtonLayout", "getBuyButtonLayout", "priceTextView", "getPriceTextView", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SelectThemeViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ConstraintLayout buyButtonLayout;
    private final ImageView checkmark;
    private final SelectThemeListClickListener clickListener;
    private final LinearLayout innerLayout;
    private final TextView priceTextView;
    private ConstraintLayout rootLayout;
    private final CachedImageView themeImage;
    private final TextView themeTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectThemeViewHolder(View itemView, SelectThemeListClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.rootLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.innerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.innerLayout = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.checkmark);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.checkmark = (ImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.themeTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.themeTitle = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.themeImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.themeImage = (CachedImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.buyButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.buyButtonLayout = (ConstraintLayout) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.priceText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.priceTextView = (TextView) viewFindViewById7;
    }

    public final ConstraintLayout getBuyButtonLayout() {
        return this.buyButtonLayout;
    }

    public final ImageView getCheckmark() {
        return this.checkmark;
    }

    public final SelectThemeListClickListener getClickListener() {
        return this.clickListener;
    }

    public final LinearLayout getInnerLayout() {
        return this.innerLayout;
    }

    public final TextView getPriceTextView() {
        return this.priceTextView;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final CachedImageView getThemeImage() {
        return this.themeImage;
    }

    public final TextView getThemeTitle() {
        return this.themeTitle;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }
}
