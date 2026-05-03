package com.studiolaganne.lengendarylens;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenshotAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScreenshotViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/ScreenshotClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/ScreenshotClickListener;)V", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "screenshotImage", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getScreenshotImage", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "setScreenshotImage", "(Lcom/studiolaganne/lengendarylens/CachedImageView;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScreenshotViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ScreenshotClickListener clickListener;
    private ConstraintLayout rootLayout;
    private CachedImageView screenshotImage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotViewHolder(View itemView, ScreenshotClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.screenshotImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.screenshotImage = (CachedImageView) viewFindViewById2;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final CachedImageView getScreenshotImage() {
        return this.screenshotImage;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }

    public final void setScreenshotImage(CachedImageView cachedImageView) {
        Intrinsics.checkNotNullParameter(cachedImageView, "<set-?>");
        this.screenshotImage = cachedImageView;
    }
}
