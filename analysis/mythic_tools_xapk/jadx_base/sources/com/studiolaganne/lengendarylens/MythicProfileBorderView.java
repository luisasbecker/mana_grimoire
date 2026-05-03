package com.studiolaganne.lengendarylens;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.camera.core.RetryPolicy;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MythicProfileBorderView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020#2\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010*\u001a\u00020#2\u0006\u0010(\u001a\u00020\u000fJ(\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0002J\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u000204H\u0014J\u0006\u00105\u001a\u00020#J\u0006\u00106\u001a\u00020#J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0014J\b\u0010<\u001a\u00020#H\u0014J\u0018\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicProfileBorderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderColor", "strokeWidthPx", "", "glowPaddingPx", "pulseEnabled", "", "highlightEnabled", "glowEnabled", "basePaint", "Landroid/graphics/Paint;", "highlightPaint", "glowPaint", "gradientMatrix", "Landroid/graphics/Matrix;", "sweepGradient", "Landroid/graphics/SweepGradient;", "glowGradient", "Landroid/graphics/RadialGradient;", "highlightAngle", "highlightAlpha", "highlightAnimator", "Landroid/animation/ValueAnimator;", "pulseAnimator", "Landroid/animation/ObjectAnimator;", "setBorderStrokeWidth", "", "widthDp", "setBorderColor", "color", "setGlowEnabled", "enabled", "setPulseEnabled", "setHighlightEnabled", "onSizeChanged", "w", "h", "oldw", "oldh", "rebuildGradient", "rebuildGlowGradient", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startAnimation", "stopAnimation", "startPulse", "stopPulse", "startHighlight", "stopHighlight", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "visibility", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicProfileBorderView extends View {
    private final Paint basePaint;
    private int borderColor;
    private boolean glowEnabled;
    private RadialGradient glowGradient;
    private final float glowPaddingPx;
    private final Paint glowPaint;
    private final Matrix gradientMatrix;
    private float highlightAlpha;
    private float highlightAngle;
    private ValueAnimator highlightAnimator;
    private boolean highlightEnabled;
    private final Paint highlightPaint;
    private ObjectAnimator pulseAnimator;
    private boolean pulseEnabled;
    private float strokeWidthPx;
    private SweepGradient sweepGradient;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MythicProfileBorderView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicProfileBorderView$Companion;", "", "<init>", "()V", "adjustAlpha", "", "color", "factor", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    public MythicProfileBorderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MythicProfileBorderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MythicProfileBorderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.borderColor = ContextCompat.getColor(context, R.color.mythic_plus);
        this.strokeWidthPx = GameUtils.INSTANCE.getInstance().dpToPx(3, context);
        this.glowPaddingPx = GameUtils.INSTANCE.getInstance().dpToPx(8, context);
        this.glowEnabled = true;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.strokeWidthPx);
        paint.setColor(INSTANCE.adjustAlpha(this.borderColor, 0.55f));
        this.basePaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(this.strokeWidthPx);
        this.highlightPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.FILL);
        this.glowPaint = paint3;
        this.gradientMatrix = new Matrix();
        this.highlightAlpha = 0.5f;
    }

    public /* synthetic */ MythicProfileBorderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void rebuildGlowGradient() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        float fCoerceIn = RangesKt.coerceIn(((fMin - this.glowPaddingPx) - (this.strokeWidthPx / 2.0f)) / fMin, 0.0f, 1.0f);
        Companion companion = INSTANCE;
        RadialGradient radialGradient = new RadialGradient(getWidth() / 2.0f, getHeight() / 2.0f, fMin, new int[]{0, companion.adjustAlpha(this.borderColor, 0.4f), companion.adjustAlpha(this.borderColor, 0.5f), companion.adjustAlpha(this.borderColor, 0.25f), 0}, new float[]{fCoerceIn - 0.06f, fCoerceIn, 0.04f + fCoerceIn, 0.14f + fCoerceIn, 1.0f}, Shader.TileMode.CLAMP);
        this.glowGradient = radialGradient;
        this.glowPaint.setShader(radialGradient);
    }

    private final void rebuildGradient() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Companion companion = INSTANCE;
        int iAdjustAlpha = companion.adjustAlpha(this.borderColor, 0.8f);
        int i = this.borderColor;
        SweepGradient sweepGradient = new SweepGradient(getWidth() / 2.0f, getHeight() / 2.0f, new int[]{0, iAdjustAlpha, i, i, companion.adjustAlpha(i, 0.8f), 0, 0, companion.adjustAlpha(this.borderColor, 0.5f), companion.adjustAlpha(this.borderColor, 0.7f), companion.adjustAlpha(this.borderColor, 0.5f), 0, 0}, new float[]{0.0f, 0.03f, 0.08f, 0.14f, 0.2f, 0.28f, 0.5f, 0.54f, 0.6f, 0.66f, 0.72f, 1.0f});
        this.sweepGradient = sweepGradient;
        this.highlightPaint.setShader(sweepGradient);
    }

    private final void startHighlight() {
        ValueAnimator valueAnimator = this.highlightAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("angle", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, 8.0f), Keyframe.ofFloat(0.2f, 50.0f), Keyframe.ofFloat(0.5f, 300.0f), Keyframe.ofFloat(0.62f, 345.0f), Keyframe.ofFloat(0.72f, 358.0f), Keyframe.ofFloat(0.78f, 360.0f), Keyframe.ofFloat(1.0f, 360.0f)), PropertyValuesHolder.ofKeyframe("highlightAlpha", Keyframe.ofFloat(0.0f, 0.5f), Keyframe.ofFloat(0.08f, 0.9f), Keyframe.ofFloat(0.15f, 1.0f), Keyframe.ofFloat(0.55f, 1.0f), Keyframe.ofFloat(0.65f, 0.9f), Keyframe.ofFloat(0.72f, 0.65f), Keyframe.ofFloat(0.78f, 0.5f), Keyframe.ofFloat(1.0f, 0.5f)));
            valueAnimatorOfPropertyValuesHolder.setDuration(RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
            valueAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            valueAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.MythicProfileBorderView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    MythicProfileBorderView.startHighlight$lambda$0$0(this.f$0, valueAnimator2);
                }
            });
            valueAnimatorOfPropertyValuesHolder.start();
            this.highlightAnimator = valueAnimatorOfPropertyValuesHolder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startHighlight$lambda$0$0(MythicProfileBorderView mythicProfileBorderView, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        Object animatedValue = anim.getAnimatedValue("angle");
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        mythicProfileBorderView.highlightAngle = ((Float) animatedValue).floatValue();
        Object animatedValue2 = anim.getAnimatedValue("highlightAlpha");
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        mythicProfileBorderView.highlightAlpha = ((Float) animatedValue2).floatValue();
        mythicProfileBorderView.invalidate();
    }

    private final void startPulse() {
        ObjectAnimator objectAnimator = this.pulseAnimator;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.55f, 1.0f);
            objectAnimatorOfFloat.setDuration(3000L);
            objectAnimatorOfFloat.setRepeatMode(2);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.start();
            this.pulseAnimator = objectAnimatorOfFloat;
        }
    }

    private final void stopHighlight() {
        ValueAnimator valueAnimator = this.highlightAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.highlightAnimator = null;
    }

    private final void stopPulse() {
        ObjectAnimator objectAnimator = this.pulseAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.pulseAnimator = null;
        setAlpha(1.0f);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            startAnimation();
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
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        float f = (fMin - this.glowPaddingPx) - (this.strokeWidthPx / 2.0f);
        if (this.glowEnabled && this.glowGradient != null) {
            canvas.drawCircle(width, height, fMin, this.glowPaint);
        }
        canvas.drawCircle(width, height, f, this.basePaint);
        if (!this.highlightEnabled || this.sweepGradient == null) {
            return;
        }
        this.gradientMatrix.reset();
        this.gradientMatrix.postRotate(this.highlightAngle, width, height);
        SweepGradient sweepGradient = this.sweepGradient;
        if (sweepGradient != null) {
            sweepGradient.setLocalMatrix(this.gradientMatrix);
        }
        canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), RangesKt.coerceIn((int) (this.highlightAlpha * 255.0f), 0, 255));
        canvas.drawCircle(width, height, f, this.highlightPaint);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w <= 0 || h <= 0) {
            return;
        }
        rebuildGradient();
        rebuildGlowGradient();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    public final void setBorderColor(int color) {
        this.borderColor = color;
        this.basePaint.setColor(INSTANCE.adjustAlpha(color, 0.55f));
        rebuildGradient();
        rebuildGlowGradient();
        invalidate();
    }

    public final void setBorderStrokeWidth(int widthDp) {
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        float fDpToPx = companion.dpToPx(widthDp, context);
        this.strokeWidthPx = fDpToPx;
        this.basePaint.setStrokeWidth(fDpToPx);
        this.highlightPaint.setStrokeWidth(this.strokeWidthPx);
        invalidate();
    }

    public final void setGlowEnabled(boolean enabled) {
        this.glowEnabled = enabled;
        invalidate();
    }

    public final void setHighlightEnabled(boolean enabled) {
        this.highlightEnabled = enabled;
        if (enabled) {
            startHighlight();
        } else {
            stopHighlight();
        }
    }

    public final void setPulseEnabled(boolean enabled) {
        this.pulseEnabled = enabled;
        if (enabled) {
            startPulse();
        } else {
            stopPulse();
        }
    }

    public final void startAnimation() {
        if (this.pulseEnabled) {
            startPulse();
        }
        if (this.highlightEnabled) {
            startHighlight();
        }
    }

    public final void stopAnimation() {
        stopPulse();
        stopHighlight();
    }
}
