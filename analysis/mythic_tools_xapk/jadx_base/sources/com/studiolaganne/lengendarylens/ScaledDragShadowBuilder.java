package com.studiolaganne.lengendarylens;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameOptionsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScaledDragShadowBuilder;", "Landroid/view/View$DragShadowBuilder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "scale", "", "<init>", "(Landroid/view/View;F)V", "onProvideShadowMetrics", "", "outShadowSize", "Landroid/graphics/Point;", "outShadowTouchPoint", "onDrawShadow", "canvas", "Landroid/graphics/Canvas;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScaledDragShadowBuilder extends View.DragShadowBuilder {
    public static final int $stable = 8;
    private final float scale;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaledDragShadowBuilder(View view, float f) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.scale = f;
    }

    public /* synthetic */ ScaledDragShadowBuilder(View view, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i & 2) != 0 ? 1.5f : f);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float f = this.scale;
        canvas.scale(f, f);
        getView().draw(canvas);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {
        Intrinsics.checkNotNullParameter(outShadowSize, "outShadowSize");
        Intrinsics.checkNotNullParameter(outShadowTouchPoint, "outShadowTouchPoint");
        int width = (int) (getView().getWidth() * this.scale);
        int height = (int) (getView().getHeight() * this.scale);
        outShadowSize.set(width, height);
        outShadowTouchPoint.set(width / 2, height / 2);
    }
}
