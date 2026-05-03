package com.studiolaganne.lengendarylens;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MythicShimmerView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0014J\b\u0010$\u001a\u00020\u0018H\u0014J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicShimmerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mythicColor", "shimmerPaint", "Landroid/graphics/Paint;", "shaderMatrix", "Landroid/graphics/Matrix;", "shimmerGradient", "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "translateX", "", "attached", "", "onSizeChanged", "", "w", "h", "oldw", "oldh", "rebuildGradient", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startAnimation", "stopAnimation", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "visibility", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicShimmerView extends View {
    private ValueAnimator animator;
    private boolean attached;
    private final int mythicColor;
    private final Matrix shaderMatrix;
    private LinearGradient shimmerGradient;
    private final Paint shimmerPaint;
    private float translateX;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MythicShimmerView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicShimmerView$Companion;", "", "<init>", "()V", "adjustAlpha", "", "color", "factor", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int adjustAlpha(int color, float factor) {
            return (RangesKt.coerceIn((int) (Color.alpha(color) * factor), 0, 255) << 24) | (color & 16777215);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MythicShimmerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MythicShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MythicShimmerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mythicColor = ContextCompat.getColor(context, R.color.mythic_plus);
        this.shimmerPaint = new Paint(1);
        this.shaderMatrix = new Matrix();
    }

    public /* synthetic */ MythicShimmerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void rebuildGradient(int w, int h) {
        float f = w * 2.0f;
        double radians = Math.toRadians(110.0d);
        double d = f;
        float f2 = f / 2.0f;
        float f3 = h / 2.0f;
        float fSin = ((float) (Math.sin(radians) * d)) / 2.0f;
        float f4 = ((float) (d * (-Math.cos(radians)))) / 2.0f;
        Companion companion = INSTANCE;
        LinearGradient linearGradient = new LinearGradient(f2 - fSin, f3 - f4, f2 + fSin, f3 + f4, new int[]{0, companion.adjustAlpha(this.mythicColor, 0.25f), companion.adjustAlpha(this.mythicColor, 0.45f), companion.adjustAlpha(this.mythicColor, 0.25f), 0}, new float[]{0.2f, 0.4f, 0.5f, 0.6f, 0.8f}, Shader.TileMode.CLAMP);
        this.shimmerGradient = linearGradient;
        this.shimmerPaint.setShader(linearGradient);
    }

    private final void startAnimation() {
        ValueAnimator valueAnimator = this.animator;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && getWidth() != 0) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-getWidth(), getWidth());
            valueAnimatorOfFloat.setDuration(3000L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.MythicShimmerView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    MythicShimmerView.startAnimation$lambda$0$0(this.f$0, valueAnimator2);
                }
            });
            valueAnimatorOfFloat.start();
            this.animator = valueAnimatorOfFloat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$0$0(MythicShimmerView mythicShimmerView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        mythicShimmerView.translateX = ((Float) animatedValue).floatValue();
        mythicShimmerView.invalidate();
    }

    private final void stopAnimation() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attached = true;
        if (getVisibility() != 0 || getWidth() <= 0) {
            return;
        }
        startAnimation();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.attached = false;
        stopAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.shimmerGradient == null || getWidth() == 0) {
            return;
        }
        this.shaderMatrix.reset();
        this.shaderMatrix.setTranslate(this.translateX, 0.0f);
        LinearGradient linearGradient = this.shimmerGradient;
        if (linearGradient != null) {
            linearGradient.setLocalMatrix(this.shaderMatrix);
        }
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.shimmerPaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w <= 0 || h <= 0) {
            return;
        }
        rebuildGradient(w, h);
        if (this.attached && getVisibility() == 0) {
            startAnimation();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0 && this.attached && getWidth() > 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }
}
