package com.studiolaganne.lengendarylens;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: GradientBorderDrawable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/GradientBorderDrawable;", "Landroid/graphics/drawable/Drawable;", "colors", "", "strokeWidth", "", "cornerRadius", "<init>", "([IFF)V", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/RectF;", "onBoundsChange", "", "bounds", "Landroid/graphics/Rect;", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GradientBorderDrawable extends Drawable {
    public static final int $stable = 8;
    private final int[] colors;
    private final float cornerRadius;
    private final Paint paint;
    private final RectF rect;
    private final float strokeWidth;

    public GradientBorderDrawable(int[] colors, float f, float f2) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.strokeWidth = f;
        this.cornerRadius = f2;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        this.paint = paint;
        this.rect = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float fCoerceAtLeast = RangesKt.coerceAtLeast(this.cornerRadius - (this.strokeWidth / 2.0f), 0.0f);
        canvas.drawRoundRect(this.rect, fCoerceAtLeast, fCoerceAtLeast, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.TRANSLUCENT", imports = {"android.graphics.PixelFormat"}))
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        float f = this.strokeWidth / 2.0f;
        this.rect.set(bounds.left + f, bounds.top + f, bounds.right - f, bounds.bottom - f);
        this.paint.setShader(new LinearGradient(this.rect.left, this.rect.top, this.rect.right, this.rect.bottom, this.colors, (float[]) null, Shader.TileMode.CLAMP));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
