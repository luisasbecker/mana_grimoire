package com.studiolaganne.lengendarylens;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckIdCardArcGaugeView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 F2\u00020\u0001:\u0002EFB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000bH\u0002J \u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0014J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0007J,\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205J\u000e\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020\u0007J\u000e\u00109\u001a\u00020.2\u0006\u00108\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020\u0014J\u000e\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\u0012J\b\u0010>\u001a\u00020.H\u0014J\u0018\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0014J\u0010\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020DH\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIdCardArcGaugeView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arcStartAngleDeg", "", "getArcStartAngleDeg", "()F", "arcSweepAngleDeg", "getArcSweepAngleDeg", "scorePercent", Constants.ScionAnalytics.PARAM_LABEL, "", "centerMode", "Lcom/studiolaganne/lengendarylens/DeckIdCardGaugeCenterMode;", "fillColor", "trackColor", "arcTrackPaint", "Landroid/graphics/Paint;", "arcFillPaint", "iconPaint", "scoreTextPaint", "Landroid/text/TextPaint;", "labelTextPaint", "arcRect", "Landroid/graphics/RectF;", "scoreAnimator", "Landroid/animation/ValueAnimator;", "labelColor", "layoutArcForWidth", "Lcom/studiolaganne/lengendarylens/DeckIdCardArcGaugeView$ArcLayout;", "w", "labelTopBelowArc", "cy", "radius", "strokeWidth", "dp", "v", "labelLineHeightPx", "cancelScoreAnimation", "", "setScorePercentImmediate", "value", "animateScorePercentTo", TypedValues.TransitionType.S_TO, "from", "durationMs", "", "startDelayMs", "setFillColor", "color", "setTrackColor", "setCenterMode", "mode", "setGaugeLabel", "text", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "ArcLayout", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DeckIdCardArcGaugeView extends View {
    private static final float LABEL_TEXT_SP = 10.0f;
    private final Paint arcFillPaint;
    private final RectF arcRect;
    private final float arcStartAngleDeg;
    private final float arcSweepAngleDeg;
    private final Paint arcTrackPaint;
    private DeckIdCardGaugeCenterMode centerMode;
    private int fillColor;
    private final Paint iconPaint;
    private String label;
    private final int labelColor;
    private final TextPaint labelTextPaint;
    private ValueAnimator scoreAnimator;
    private int scorePercent;
    private final TextPaint scoreTextPaint;
    private int trackColor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Interpolator CUBIC_EASE_OUT = new Interpolator() { // from class: com.studiolaganne.lengendarylens.DeckIdCardArcGaugeView$$ExternalSyntheticLambda0
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return DeckIdCardArcGaugeView.CUBIC_EASE_OUT$lambda$0(f);
        }
    };

    /* JADX INFO: compiled from: DeckIdCardArcGaugeView.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIdCardArcGaugeView$ArcLayout;", "", "cx", "", "cy", "radius", "strokeWidth", "<init>", "(FFFF)V", "getCx", "()F", "getCy", "getRadius", "getStrokeWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class ArcLayout {
        private final float cx;
        private final float cy;
        private final float radius;
        private final float strokeWidth;

        public ArcLayout(float f, float f2, float f3, float f4) {
            this.cx = f;
            this.cy = f2;
            this.radius = f3;
            this.strokeWidth = f4;
        }

        public static /* synthetic */ ArcLayout copy$default(ArcLayout arcLayout, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = arcLayout.cx;
            }
            if ((i & 2) != 0) {
                f2 = arcLayout.cy;
            }
            if ((i & 4) != 0) {
                f3 = arcLayout.radius;
            }
            if ((i & 8) != 0) {
                f4 = arcLayout.strokeWidth;
            }
            return arcLayout.copy(f, f2, f3, f4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getCx() {
            return this.cx;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getCy() {
            return this.cy;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final ArcLayout copy(float cx, float cy, float radius, float strokeWidth) {
            return new ArcLayout(cx, cy, radius, strokeWidth);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ArcLayout)) {
                return false;
            }
            ArcLayout arcLayout = (ArcLayout) other;
            return Float.compare(this.cx, arcLayout.cx) == 0 && Float.compare(this.cy, arcLayout.cy) == 0 && Float.compare(this.radius, arcLayout.radius) == 0 && Float.compare(this.strokeWidth, arcLayout.strokeWidth) == 0;
        }

        public final float getCx() {
            return this.cx;
        }

        public final float getCy() {
            return this.cy;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.cx) * 31) + Float.hashCode(this.cy)) * 31) + Float.hashCode(this.radius)) * 31) + Float.hashCode(this.strokeWidth);
        }

        public String toString() {
            return "ArcLayout(cx=" + this.cx + ", cy=" + this.cy + ", radius=" + this.radius + ", strokeWidth=" + this.strokeWidth + ")";
        }
    }

    /* JADX INFO: compiled from: DeckIdCardArcGaugeView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIdCardArcGaugeView$Companion;", "", "<init>", "()V", "LABEL_TEXT_SP", "", "CUBIC_EASE_OUT", "Landroid/view/animation/Interpolator;", "getCUBIC_EASE_OUT", "()Landroid/view/animation/Interpolator;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Interpolator getCUBIC_EASE_OUT() {
            return DeckIdCardArcGaugeView.CUBIC_EASE_OUT;
        }
    }

    /* JADX INFO: compiled from: DeckIdCardArcGaugeView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeckIdCardGaugeCenterMode.values().length];
            try {
                iArr[DeckIdCardGaugeCenterMode.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeckIdCardGaugeCenterMode.SCORE_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeckIdCardGaugeCenterMode.QUESTION_MARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeckIdCardArcGaugeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeckIdCardArcGaugeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeckIdCardArcGaugeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.arcStartAngleDeg = 180.0f;
        this.arcSweepAngleDeg = 180.0f;
        this.label = "";
        this.centerMode = DeckIdCardGaugeCenterMode.SCORE_TEXT;
        this.fillColor = -1;
        this.trackColor = Color.argb(15, 255, 255, 255);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.arcTrackPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.arcFillPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setTextAlign(Paint.Align.CENTER);
        Typeface font = ResourcesCompat.getFont(context, R.font.fa6solid);
        paint3.setTypeface(font == null ? Typeface.DEFAULT_BOLD : font);
        this.iconPaint = paint3;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextAlign(Paint.Align.CENTER);
        Typeface font2 = ResourcesCompat.getFont(context, R.font.be_vietnam_pro_semibold);
        textPaint.setTypeface(font2 == null ? Typeface.DEFAULT_BOLD : font2);
        this.scoreTextPaint = textPaint;
        TextPaint textPaint2 = new TextPaint(1);
        textPaint2.setTextAlign(Paint.Align.CENTER);
        Typeface font3 = ResourcesCompat.getFont(context, R.font.be_vietnam_pro_semibold);
        textPaint2.setTypeface(font3 == null ? Typeface.DEFAULT_BOLD : font3);
        this.labelTextPaint = textPaint2;
        this.arcRect = new RectF();
        this.labelColor = ContextCompat.getColor(context, R.color.almost_white);
    }

    public /* synthetic */ DeckIdCardArcGaugeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    static final float CUBIC_EASE_OUT$lambda$0(float f) {
        return 1.0f - ((float) Math.pow(1.0f - RangesKt.coerceIn(f, 0.0f, 1.0f), 3.0d));
    }

    public static /* synthetic */ void animateScorePercentTo$default(DeckIdCardArcGaugeView deckIdCardArcGaugeView, int i, int i2, long j, long j2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScorePercentTo");
        }
        if ((i3 & 2) != 0) {
            i2 = deckIdCardArcGaugeView.scorePercent;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            j = 900;
        }
        long j3 = j;
        if ((i3 & 8) != 0) {
            j2 = 0;
        }
        deckIdCardArcGaugeView.animateScorePercentTo(i, i4, j3, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateScorePercentTo$lambda$0$0(DeckIdCardArcGaugeView deckIdCardArcGaugeView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        deckIdCardArcGaugeView.scorePercent = ((Integer) animatedValue).intValue();
        deckIdCardArcGaugeView.invalidate();
    }

    private final float dp(float v) {
        return TypedValue.applyDimension(1, v, getResources().getDisplayMetrics());
    }

    private final int labelLineHeightPx() {
        this.labelTextPaint.setTextSize(TypedValue.applyDimension(2, 10.0f, getResources().getDisplayMetrics()));
        Paint.FontMetrics fontMetrics = this.labelTextPaint.getFontMetrics();
        return RangesKt.coerceAtLeast((int) Math.ceil(fontMetrics.descent - fontMetrics.ascent), 1);
    }

    private final ArcLayout layoutArcForWidth(float w) {
        float f = 0.08f * w;
        float fCoerceAtLeast = RangesKt.coerceAtLeast(((0.88f * w) - (((f / 2.0f) + (0.055f * w)) * 2.0f)) / 2.0f, 1.0f);
        return new ArcLayout(w / 2.0f, (0.5f * f) + dp(1.5f) + fCoerceAtLeast, fCoerceAtLeast, f);
    }

    public final void animateScorePercentTo(int to, int from, long durationMs, long startDelayMs) {
        cancelScoreAnimation();
        int iCoerceIn = RangesKt.coerceIn(to, 0, 100);
        int iCoerceIn2 = RangesKt.coerceIn(from, 0, 100);
        if (iCoerceIn2 == iCoerceIn) {
            this.scorePercent = iCoerceIn;
            invalidate();
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iCoerceIn2, iCoerceIn);
        valueAnimatorOfInt.setDuration(durationMs);
        valueAnimatorOfInt.setStartDelay(startDelayMs);
        valueAnimatorOfInt.setInterpolator(CUBIC_EASE_OUT);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.DeckIdCardArcGaugeView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DeckIdCardArcGaugeView.animateScorePercentTo$lambda$0$0(this.f$0, valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
        this.scoreAnimator = valueAnimatorOfInt;
    }

    public final void cancelScoreAnimation() {
        ValueAnimator valueAnimator = this.scoreAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.scoreAnimator = null;
    }

    protected float getArcStartAngleDeg() {
        return this.arcStartAngleDeg;
    }

    protected float getArcSweepAngleDeg() {
        return this.arcSweepAngleDeg;
    }

    protected float labelTopBelowArc(float cy, float radius, float strokeWidth) {
        return cy + (strokeWidth * 0.45f) + dp(4.0f);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        cancelScoreAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float fDp = dp(8.0f);
        float width = getWidth();
        ArcLayout arcLayoutLayoutArcForWidth = layoutArcForWidth(width);
        float cx = arcLayoutLayoutArcForWidth.getCx();
        float cy = arcLayoutLayoutArcForWidth.getCy() + fDp;
        float radius = arcLayoutLayoutArcForWidth.getRadius();
        float strokeWidth = arcLayoutLayoutArcForWidth.getStrokeWidth();
        this.arcTrackPaint.setStrokeWidth(strokeWidth);
        this.arcFillPaint.setStrokeWidth(strokeWidth);
        this.arcTrackPaint.setColor(this.trackColor);
        this.arcFillPaint.setColor(this.fillColor);
        this.arcRect.set(cx - radius, cy - radius, cx + radius, cy + radius);
        canvas.drawArc(this.arcRect, getArcStartAngleDeg(), getArcSweepAngleDeg(), false, this.arcTrackPaint);
        canvas.drawArc(this.arcRect, getArcStartAngleDeg(), getArcSweepAngleDeg() * (this.scorePercent / 100.0f), false, this.arcFillPaint);
        int i = WhenMappings.$EnumSwitchMapping$0[this.centerMode.ordinal()];
        if (i == 1) {
            int i2 = this.scorePercent;
            String str = i2 >= 75 ? "\uf164" : i2 >= 35 ? "\uf071" : "\uf06a";
            this.iconPaint.setTextSize(0.55f * radius);
            this.iconPaint.setColor(this.fillColor);
            canvas.drawText(str, cx, (this.iconPaint.getTextSize() * 0.35f) + cy + fDp, this.iconPaint);
        } else if (i == 2) {
            this.scoreTextPaint.setTextSize(0.58f * radius);
            this.scoreTextPaint.setColor(this.fillColor);
            canvas.drawText(String.valueOf(this.scorePercent), cx, (this.scoreTextPaint.getTextSize() * 0.32f) + cy + fDp, this.scoreTextPaint);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.scoreTextPaint.setTextSize(0.58f * radius);
            this.scoreTextPaint.setColor(this.fillColor);
            canvas.drawText("?", cx, (this.scoreTextPaint.getTextSize() * 0.32f) + cy + fDp, this.scoreTextPaint);
        }
        this.labelTextPaint.setTextSize(TypedValue.applyDimension(2, 10.0f, getResources().getDisplayMetrics()));
        this.labelTextPaint.setColor(this.labelColor);
        if (this.label.length() > 0) {
            float fLabelTopBelowArc = labelTopBelowArc(cy, radius, strokeWidth);
            float fDp2 = (fLabelTopBelowArc - this.labelTextPaint.getFontMetrics().ascent) + fDp + dp(5.0f);
            if (StringsKt.indexOf$default((CharSequence) this.label, '\n', 0, false, 6, (Object) null) < 0) {
                canvas.drawText(this.label, width / 2.0f, fDp2, this.labelTextPaint);
                return;
            }
            int iCoerceAtLeast = RangesKt.coerceAtLeast((int) width, 1);
            Paint.Align textAlign = this.labelTextPaint.getTextAlign();
            this.labelTextPaint.setTextAlign(Paint.Align.LEFT);
            String str2 = this.label;
            StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(str2, 0, str2.length(), this.labelTextPaint, iCoerceAtLeast).setAlignment(Layout.Alignment.ALIGN_CENTER).setMaxLines(2).setLineSpacing(0.0f, 1.05f).build();
            Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "build(...)");
            canvas.save();
            canvas.translate(0.0f, fLabelTopBelowArc);
            staticLayoutBuild.draw(canvas);
            canvas.restore();
            this.labelTextPaint.setTextAlign(textAlign);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float size = View.MeasureSpec.getSize(widthMeasureSpec);
        ArcLayout arcLayoutLayoutArcForWidth = layoutArcForWidth(size);
        setMeasuredDimension((int) size, RangesKt.coerceAtLeast((int) (labelTopBelowArc(arcLayoutLayoutArcForWidth.getCy(), arcLayoutLayoutArcForWidth.getRadius(), arcLayoutLayoutArcForWidth.getStrokeWidth()) + (labelLineHeightPx() * 2) + ((int) dp(2.0f)) + dp(8.0f) + dp(8.0f)), 1));
    }

    public final void setCenterMode(DeckIdCardGaugeCenterMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.centerMode = mode;
        invalidate();
    }

    public final void setFillColor(int color) {
        this.fillColor = color;
        invalidate();
    }

    public final void setGaugeLabel(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.label = text;
        requestLayout();
        invalidate();
    }

    public final void setScorePercentImmediate(int value) {
        cancelScoreAnimation();
        this.scorePercent = RangesKt.coerceIn(value, 0, 100);
        invalidate();
    }

    public final void setTrackColor(int color) {
        this.trackColor = color;
        invalidate();
    }
}
