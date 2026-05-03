package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomGlowView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomGlowView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "glowSize", "", "overrideRadius", "", "paint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setOverrideRadius", "override", "setGlowColor", "color", "", "setGlowSize", "size", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomGlowView extends View {
    public static final int $stable = 8;
    private float glowSize;
    private boolean overrideRadius;
    private final Paint paint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomGlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.glowSize = 12.0f;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(ContextCompat.getColor(context, R.color.new_orange_transparent));
        paint.setStyle(Paint.Style.FILL);
        paint.setMaskFilter(new BlurMaskFilter(this.glowSize * 1.75f, BlurMaskFilter.Blur.OUTER));
        this.paint = paint;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        RectF rectF = new RectF(getPaddingStart() + 0.0f, getPaddingTop() + 0.0f, getWidth() - getPaddingEnd(), getHeight() - getPaddingBottom());
        if (this.overrideRadius) {
            canvas.drawRect(rectF, this.paint);
            return;
        }
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        float fDpToPx = companion.dpToPx(20, context);
        canvas.drawRoundRect(rectF, fDpToPx, fDpToPx, this.paint);
    }

    public final void setGlowColor(int color) {
        this.paint.setColor(color);
        invalidate();
    }

    public final void setGlowSize(float size) {
        this.glowSize = size;
        Paint paint = this.paint;
        if (size > 0.0f) {
            paint.setMaskFilter(new BlurMaskFilter(size * 1.75f, BlurMaskFilter.Blur.OUTER));
            invalidate();
        } else {
            paint.setMaskFilter(null);
            invalidate();
        }
    }

    public final void setOverrideRadius(boolean override) {
        this.overrideRadius = override;
        invalidate();
    }
}
