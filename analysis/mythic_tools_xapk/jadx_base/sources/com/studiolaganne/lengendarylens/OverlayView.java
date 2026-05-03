package com.studiolaganne.lengendarylens;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverlayView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/OverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "rectangles", "", "Landroid/graphics/RectF;", "dim", "", "undim", "clearRectangles", "updateRectangles", "newRectangles", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OverlayView extends View {
    public static final int $stable = 8;
    private final Paint paint;
    private final List<RectF> rectangles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Paint paint = new Paint();
        this.paint = paint;
        this.rectangles = new ArrayList();
        paint.setColor(-7829368);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20.0f);
    }

    static final void dim$lambda$0(OverlayView overlayView, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        overlayView.setBackgroundColor(((Integer) animatedValue).intValue());
    }

    static final void undim$lambda$0(OverlayView overlayView, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        overlayView.setBackgroundColor(((Integer) animatedValue).intValue());
    }

    public final void clearRectangles() {
        this.rectangles.clear();
        invalidate();
    }

    public final void dim() {
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(Color.argb(0, 0, 0, 0), Color.argb(229, 0, 0, 0));
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.OverlayView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OverlayView.dim$lambda$0(this.f$0, valueAnimator);
            }
        });
        valueAnimatorOfArgb.setDuration(500L);
        valueAnimatorOfArgb.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Iterator<RectF> it = this.rectangles.iterator();
        while (it.hasNext()) {
            canvas.drawRect(it.next(), this.paint);
        }
    }

    public final void undim() {
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(Color.argb(229, 0, 0, 0), Color.argb(0, 0, 0, 0));
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.OverlayView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OverlayView.undim$lambda$0(this.f$0, valueAnimator);
            }
        });
        valueAnimatorOfArgb.setDuration(500L);
        valueAnimatorOfArgb.start();
    }

    public final void updateRectangles(List<? extends RectF> newRectangles) {
        Intrinsics.checkNotNullParameter(newRectangles, "newRectangles");
        this.rectangles.clear();
        this.rectangles.addAll(newRectangles);
        invalidate();
    }
}
