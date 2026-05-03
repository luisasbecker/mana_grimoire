package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThemeAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\rR\u0011\u0010 \u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/ThemeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/ThemeListClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/ThemeListClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/ThemeListClickListener;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "themeTitle", "Landroid/widget/TextView;", "getThemeTitle", "()Landroid/widget/TextView;", "setThemeTitle", "(Landroid/widget/TextView;)V", "themeImage", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getThemeImage", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "setThemeImage", "(Lcom/studiolaganne/lengendarylens/CachedImageView;)V", "themeCatchphraase", "getThemeCatchphraase", "buyButtonLayout", "getBuyButtonLayout", "priceTextView", "getPriceTextView", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThemeViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ConstraintLayout buyButtonLayout;
    private final ThemeListClickListener clickListener;
    private final TextView priceTextView;
    private ConstraintLayout rootLayout;
    private final TextView themeCatchphraase;
    private CachedImageView themeImage;
    private TextView themeTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThemeViewHolder(View itemView, ThemeListClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.themeTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.themeTitle = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.themeImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.themeImage = (CachedImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.catchphraseTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.themeCatchphraase = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.buyButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.buyButtonLayout = (ConstraintLayout) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.priceText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.priceTextView = (TextView) viewFindViewById6;
    }

    public final ConstraintLayout getBuyButtonLayout() {
        return this.buyButtonLayout;
    }

    public final ThemeListClickListener getClickListener() {
        return this.clickListener;
    }

    public final TextView getPriceTextView() {
        return this.priceTextView;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final TextView getThemeCatchphraase() {
        return this.themeCatchphraase;
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

    public final void setThemeImage(CachedImageView cachedImageView) {
        Intrinsics.checkNotNullParameter(cachedImageView, "<set-?>");
        this.themeImage = cachedImageView;
    }

    public final void setThemeTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.themeTitle = textView;
    }
}
