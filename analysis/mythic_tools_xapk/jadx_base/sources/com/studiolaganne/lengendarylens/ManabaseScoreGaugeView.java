package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ManabaseScoreGaugeView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0014J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020!J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J \u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u000bH\u0002R\u0014\u0010\n\u001a\u00020\u000bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/ManabaseScoreGaugeView;", "Lcom/studiolaganne/lengendarylens/DeckIdCardArcGaugeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arcStartAngleDeg", "", "getArcStartAngleDeg", "()F", "arcSweepAngleDeg", "getArcSweepAngleDeg", "normalizedScore", "isSingleLine", "", "dp", "v", "labelTopBelowArc", "cy", "radius", "strokeWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setScore", "value", "setTitle", "text", "", "configure", FirebaseAnalytics.Param.SCORE, Constants.GP_IAP_TITLE, "interpolateColor", "blendColors", "from", TypedValues.TransitionType.S_TO, "ratio", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ManabaseScoreGaugeView extends DeckIdCardArcGaugeView {
    private static final int MIN_DISPLAY_SCORE = 10;
    private final float arcStartAngleDeg;
    private final float arcSweepAngleDeg;
    private boolean isSingleLine;
    private float normalizedScore;
    public static final int $stable = 8;
    private static final int COLOR_RED = Color.parseColor("#FF4444");
    private static final int COLOR_ORANGE = Color.parseColor("#FFA726");
    private static final int COLOR_GREEN = Color.parseColor("#4CAF50");

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManabaseScoreGaugeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManabaseScoreGaugeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManabaseScoreGaugeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.arcStartAngleDeg = 150.0f;
        this.arcSweepAngleDeg = 240.0f;
        this.isSingleLine = true;
        setCenterMode(DeckIdCardGaugeCenterMode.ICON);
        setTrackColor(Color.parseColor("#2A2A30"));
    }

    public /* synthetic */ ManabaseScoreGaugeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int blendColors(int from, int to, float ratio) {
        float fCoerceIn = RangesKt.coerceIn(ratio, 0.0f, 1.0f);
        return Color.rgb(Color.red(from) + MathKt.roundToInt((Color.red(to) - Color.red(from)) * fCoerceIn), Color.green(from) + MathKt.roundToInt((Color.green(to) - Color.green(from)) * fCoerceIn), Color.blue(from) + MathKt.roundToInt((Color.blue(to) - Color.blue(from)) * fCoerceIn));
    }

    private final float dp(float v) {
        return TypedValue.applyDimension(1, v, getResources().getDisplayMetrics());
    }

    private final int interpolateColor(float value) {
        if (value <= 0.5f) {
            return blendColors(COLOR_RED, COLOR_ORANGE, value / 0.5f);
        }
        return blendColors(COLOR_ORANGE, COLOR_GREEN, (value - 0.5f) / 0.5f);
    }

    public final void configure(float score, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        setTitle(title);
        setScore(score);
    }

    @Override // com.studiolaganne.lengendarylens.DeckIdCardArcGaugeView
    protected float getArcStartAngleDeg() {
        return this.arcStartAngleDeg;
    }

    @Override // com.studiolaganne.lengendarylens.DeckIdCardArcGaugeView
    protected float getArcSweepAngleDeg() {
        return this.arcSweepAngleDeg;
    }

    @Override // com.studiolaganne.lengendarylens.DeckIdCardArcGaugeView
    protected float labelTopBelowArc(float cy, float radius, float strokeWidth) {
        float fDp = cy + (radius * 0.88f) + (strokeWidth * 0.35f) + dp(2.0f);
        return this.isSingleLine ? fDp - dp(7.0f) : fDp;
    }

    @Override // com.studiolaganne.lengendarylens.DeckIdCardArcGaugeView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), RangesKt.coerceAtLeast(getMeasuredHeight() + ((int) dp(4.0f)), 1));
    }

    public final void setScore(float value) {
        float fCoerceIn = RangesKt.coerceIn(value, 0.0f, 1.0f);
        this.normalizedScore = fCoerceIn;
        int iCoerceIn = RangesKt.coerceIn(RangesKt.coerceAtLeast(MathKt.roundToInt(fCoerceIn * 100.0f), 10), 0, 100);
        setFillColor(interpolateColor(iCoerceIn / 100.0f));
        setScorePercentImmediate(iCoerceIn);
    }

    public final void setTitle(String text) {
        String text2 = text;
        Intrinsics.checkNotNullParameter(text2, "text");
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) text2).toString(), new char[]{' '}, false, 0, 6, (Object) null);
        if (listSplit$default.size() > 2) {
            int size = listSplit$default.size() / 2;
            text2 = CollectionsKt.joinToString$default(listSplit$default.subList(0, size), " ", null, null, 0, null, null, 62, null) + "\n" + CollectionsKt.joinToString$default(listSplit$default.subList(size, listSplit$default.size()), " ", null, null, 0, null, null, 62, null);
        } else if (listSplit$default.size() == 2) {
            text2 = CollectionsKt.joinToString$default(listSplit$default, "\n", null, null, 0, null, null, 62, null);
        }
        this.isSingleLine = true ^ StringsKt.contains$default((CharSequence) text2, '\n', false, 2, (Object) null);
        setGaugeLabel(text2);
    }
}
