package com.studiolaganne.lengendarylens;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.camera.core.RetryPolicy;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MythicBorderAnimationView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007J(\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0018\u0010-\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0018\u0010.\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020&2\u0006\u00100\u001a\u000201H\u0014J\u0006\u00102\u001a\u00020&J\u0006\u00103\u001a\u00020&J\u0006\u00104\u001a\u00020&J\b\u00105\u001a\u00020&H\u0014J\b\u00106\u001a\u00020&H\u0014J\u0018\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006;"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicBorderAnimationView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "blackColor", "mythicColor", "cornerRadiusPx", "", "borderStrokeWidth", "ringStrokeWidth", "borderPath", "Landroid/graphics/Path;", "gradientMatrix", "Landroid/graphics/Matrix;", "sweepGradient", "Landroid/graphics/SweepGradient;", "borderPaint", "Landroid/graphics/Paint;", "ringPaint", "currentAngle", "currentSpinnerAlpha", "currentRingAlpha", "animator", "Landroid/animation/ValueAnimator;", "value", "", "animateEnabled", "getAnimateEnabled", "()Z", "setAnimateEnabled", "(Z)V", "setCornerRadiusDp", "", "dp", "onSizeChanged", "w", "h", "oldw", "oldh", "rebuildPath", "rebuildGradient", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startAnimation", "stopAnimation", "showStatic", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "visibility", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicBorderAnimationView extends View {
    private boolean animateEnabled;
    private ValueAnimator animator;
    private final int blackColor;
    private final Paint borderPaint;
    private final Path borderPath;
    private final float borderStrokeWidth;
    private float cornerRadiusPx;
    private float currentAngle;
    private float currentRingAlpha;
    private float currentSpinnerAlpha;
    private final Matrix gradientMatrix;
    private final int mythicColor;
    private final Paint ringPaint;
    private final float ringStrokeWidth;
    private SweepGradient sweepGradient;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MythicBorderAnimationView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicBorderAnimationView$Companion;", "", "<init>", "()V", "adjustAlpha", "", "color", "factor", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    public MythicBorderAnimationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MythicBorderAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MythicBorderAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.blackColor = ContextCompat.getColor(context, R.color.almost_black);
        this.mythicColor = ContextCompat.getColor(context, R.color.mythic_plus);
        this.cornerRadiusPx = GameUtils.INSTANCE.getInstance().dpToPx(26, context);
        float fDpToPx = GameUtils.INSTANCE.getInstance().dpToPx(4, context);
        this.borderStrokeWidth = fDpToPx;
        float fDpToPx2 = GameUtils.INSTANCE.getInstance().dpToPx(2, context);
        this.ringStrokeWidth = fDpToPx2;
        this.borderPath = new Path();
        this.gradientMatrix = new Matrix();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(fDpToPx);
        this.borderPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(fDpToPx2);
        this.ringPaint = paint2;
        this.currentSpinnerAlpha = 0.15f;
        this.currentRingAlpha = 0.4f;
        this.animateEnabled = true;
    }

    public /* synthetic */ MythicBorderAnimationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void rebuildGradient(int w, int h) {
        Companion companion = INSTANCE;
        int iAdjustAlpha = companion.adjustAlpha(this.mythicColor, 0.7f);
        int i = this.mythicColor;
        SweepGradient sweepGradient = new SweepGradient(w / 2.0f, h / 2.0f, new int[]{0, iAdjustAlpha, i, companion.adjustAlpha(i, 0.7f), 0, 0, companion.adjustAlpha(this.mythicColor, 0.2f), companion.adjustAlpha(this.mythicColor, 0.4f), companion.adjustAlpha(this.mythicColor, 0.2f), 0, 0}, new float[]{0.0f, 0.02f, 0.05f, 0.08f, 0.14f, 0.4f, 0.44f, 0.48f, 0.52f, 0.58f, 1.0f});
        this.sweepGradient = sweepGradient;
        this.borderPaint.setShader(sweepGradient);
    }

    private final void rebuildPath(int w, int h) {
        this.borderPath.reset();
        float f = this.borderStrokeWidth / 2.0f;
        RectF rectF = new RectF(f, f, w - f, h - f);
        float fCoerceAtLeast = RangesKt.coerceAtLeast(this.cornerRadiusPx - f, 0.0f);
        this.borderPath.addRoundRect(rectF, fCoerceAtLeast, fCoerceAtLeast, Path.Direction.CW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$0$0(MythicBorderAnimationView mythicBorderAnimationView, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        Object animatedValue = anim.getAnimatedValue("angle");
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        mythicBorderAnimationView.currentAngle = ((Float) animatedValue).floatValue();
        Object animatedValue2 = anim.getAnimatedValue("spinnerAlpha");
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        mythicBorderAnimationView.currentSpinnerAlpha = ((Float) animatedValue2).floatValue();
        Object animatedValue3 = anim.getAnimatedValue("ringAlpha");
        Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
        mythicBorderAnimationView.currentRingAlpha = ((Float) animatedValue3).floatValue();
        mythicBorderAnimationView.invalidate();
    }

    public final boolean getAnimateEnabled() {
        return this.animateEnabled;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            if (this.animateEnabled) {
                startAnimation();
            } else {
                showStatic();
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        float f = (3.0f * this.borderStrokeWidth) / 4.0f;
        RectF rectF = new RectF(f, f, getWidth() - f, getHeight() - f);
        float fCoerceAtLeast = RangesKt.coerceAtLeast(this.cornerRadiusPx - f, 0.0f);
        this.ringPaint.setColor(this.blackColor);
        canvas.drawRoundRect(rectF, fCoerceAtLeast, fCoerceAtLeast, this.ringPaint);
        this.gradientMatrix.reset();
        this.gradientMatrix.postRotate(this.currentAngle, getWidth() / 2.0f, getHeight() / 2.0f);
        SweepGradient sweepGradient = this.sweepGradient;
        if (sweepGradient != null) {
            sweepGradient.setLocalMatrix(this.gradientMatrix);
        }
        canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), RangesKt.coerceIn((int) (this.currentSpinnerAlpha * 255.0f), 0, 255));
        canvas.drawPath(this.borderPath, this.borderPaint);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w <= 0 || h <= 0) {
            return;
        }
        rebuildPath(w, h);
        rebuildGradient(w, h);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 0) {
            stopAnimation();
        } else if (this.animateEnabled) {
            startAnimation();
        } else {
            showStatic();
        }
    }

    public final void setAnimateEnabled(boolean z) {
        if (this.animateEnabled == z) {
            return;
        }
        this.animateEnabled = z;
        if (!z) {
            stopAnimation();
            showStatic();
        } else if (getVisibility() == 0 && isAttachedToWindow()) {
            startAnimation();
        }
    }

    public final void setCornerRadiusDp(int dp) {
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
        this.cornerRadiusPx = companion.dpToPx(dp, r1);
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        rebuildPath(getWidth(), getHeight());
        invalidate();
    }

    public final void showStatic() {
        stopAnimation();
        this.currentAngle = 0.0f;
        this.currentSpinnerAlpha = 0.5f;
        this.currentRingAlpha = 0.4f;
        invalidate();
    }

    public final void startAnimation() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("angle", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, 8.0f), Keyframe.ofFloat(0.2f, 50.0f), Keyframe.ofFloat(0.5f, 300.0f), Keyframe.ofFloat(0.62f, 345.0f), Keyframe.ofFloat(0.72f, 358.0f), Keyframe.ofFloat(0.78f, 360.0f), Keyframe.ofFloat(1.0f, 360.0f)), PropertyValuesHolder.ofKeyframe("spinnerAlpha", Keyframe.ofFloat(0.0f, 0.15f), Keyframe.ofFloat(0.1f, 0.35f), Keyframe.ofFloat(0.2f, 0.8f), Keyframe.ofFloat(0.5f, 1.0f), Keyframe.ofFloat(0.62f, 0.75f), Keyframe.ofFloat(0.72f, 0.4f), Keyframe.ofFloat(0.78f, 0.15f), Keyframe.ofFloat(1.0f, 0.15f)), PropertyValuesHolder.ofKeyframe("ringAlpha", Keyframe.ofFloat(0.0f, 0.4f), Keyframe.ofFloat(0.1f, 0.2f), Keyframe.ofFloat(0.2f, 0.08f), Keyframe.ofFloat(0.5f, 0.05f), Keyframe.ofFloat(0.72f, 0.2f), Keyframe.ofFloat(0.78f, 0.45f), Keyframe.ofFloat(1.0f, 0.4f)));
            valueAnimatorOfPropertyValuesHolder.setDuration(RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
            valueAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            valueAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.MythicBorderAnimationView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    MythicBorderAnimationView.startAnimation$lambda$0$0(this.f$0, valueAnimator2);
                }
            });
            valueAnimatorOfPropertyValuesHolder.start();
            this.animator = valueAnimatorOfPropertyValuesHolder;
        }
    }

    public final void stopAnimation() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
    }
}
