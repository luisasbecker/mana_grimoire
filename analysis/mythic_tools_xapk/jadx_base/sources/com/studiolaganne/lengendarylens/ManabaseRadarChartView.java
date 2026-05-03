package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.muxer.WebmConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ManabaseRadarChartView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 W2\u00020\u0001:\u0002VWB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ.\u0010/\u001a\u00020\u00172\f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0010J\u0006\u00104\u001a\u00020\u0017J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020.H\u0002J\u0010\u0010;\u001a\u00020.2\u0006\u0010:\u001a\u00020.H\u0002J\u0018\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0014J\u0018\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0002J(\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020.2\u0006\u0010?\u001a\u00020.H\u0002J\u0018\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020.H\u0002J\u0018\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010I\u001a\u00020.H\u0002J\u0010\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020NH\u0014J0\u0010O\u001a\u00020\u00172\u0006\u0010M\u001a\u00020N2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u0006\u0010P\u001a\u00020.2\u0006\u0010A\u001a\u00020\u0007H\u0002J0\u0010Q\u001a\u00020\u00172\u0006\u0010M\u001a\u00020N2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u0006\u0010P\u001a\u00020.2\u0006\u0010A\u001a\u00020\u0007H\u0002J0\u0010R\u001a\u00020\u00172\u0006\u0010M\u001a\u00020N2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u0006\u0010P\u001a\u00020.2\u0006\u0010A\u001a\u00020\u0007H\u0002J0\u0010S\u001a\u00020\u00172\u0006\u0010M\u001a\u00020N2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u0006\u0010P\u001a\u00020.2\u0006\u0010A\u001a\u00020\u0007H\u0002J0\u0010T\u001a\u00020\u00172\u0006\u0010M\u001a\u00020N2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u0006\u0010P\u001a\u00020.2\u0006\u0010A\u001a\u00020\u0007H\u0002J \u0010U\u001a\u00020\u00172\u0006\u0010M\u001a\u00020N2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.H\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082D¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/studiolaganne/lengendarylens/ManabaseRadarChartView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dataPoints", "", "Lcom/studiolaganne/lengendarylens/ManabaseRadarChartView$DataPoint;", "centerScore", "centerColor", "centerLabel", "", "value", "selectedIndex", "getSelectedIndex", "()I", "onDataPointSelected", "Lkotlin/Function1;", "", "getOnDataPointSelected", "()Lkotlin/jvm/functions/Function1;", "setOnDataPointSelected", "(Lkotlin/jvm/functions/Function1;)V", "labelHitRects", "", "Landroid/graphics/RectF;", "ringPaint", "Landroid/graphics/Paint;", "axisPaint", "dataFillPaint", "dataStrokePaint", "dotPaint", "dotStrokePaint", "centerScorePaint", "centerLabelPaint", "labelPaint", "Landroid/text/TextPaint;", "scoreLabelPaint", "rings", "", "minRadiusFraction", "", "setData", "points", "overallScore", "overallColor", Constants.ScionAnalytics.PARAM_LABEL, "clearSelection", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "dp", "v", "sp", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "angle", "i", "n", "pointOnRadius", "Landroid/graphics/PointF;", "cx", "cy", "radius", "dataRadius", FirebaseAnalytics.Param.SCORE, "fullRadius", "gridRadius", "ringValue", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawRings", "r", "drawAxes", "drawDataPolygon", "drawDots", "drawLabels", "drawCenterScore", "DataPoint", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ManabaseRadarChartView extends View {
    private final Paint axisPaint;
    private int centerColor;
    private String centerLabel;
    private final Paint centerLabelPaint;
    private int centerScore;
    private final Paint centerScorePaint;
    private final Paint dataFillPaint;
    private List<DataPoint> dataPoints;
    private final Paint dataStrokePaint;
    private final Paint dotPaint;
    private final Paint dotStrokePaint;
    private final List<RectF> labelHitRects;
    private final TextPaint labelPaint;
    private final float minRadiusFraction;
    private Function1<? super Integer, Unit> onDataPointSelected;
    private final Paint ringPaint;
    private final int[] rings;
    private final TextPaint scoreLabelPaint;
    private int selectedIndex;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final int COLOR_RED = Color.parseColor("#FF4444");
    private static final int COLOR_ORANGE = Color.parseColor("#FFA726");
    private static final int COLOR_GREEN = Color.parseColor("#4CAF50");

    /* JADX INFO: compiled from: ManabaseRadarChartView.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/ManabaseRadarChartView$Companion;", "", "<init>", "()V", "interpolateScoreColor", "", FirebaseAnalytics.Param.SCORE, "blendColors", "from", TypedValues.TransitionType.S_TO, "ratio", "", "COLOR_RED", "COLOR_ORANGE", "COLOR_GREEN", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int blendColors(int from, int to, float ratio) {
            float fCoerceIn = RangesKt.coerceIn(ratio, 0.0f, 1.0f);
            return Color.rgb(Color.red(from) + MathKt.roundToInt((Color.red(to) - Color.red(from)) * fCoerceIn), Color.green(from) + MathKt.roundToInt((Color.green(to) - Color.green(from)) * fCoerceIn), Color.blue(from) + MathKt.roundToInt((Color.blue(to) - Color.blue(from)) * fCoerceIn));
        }

        public final int interpolateScoreColor(int score) {
            float fCoerceIn = RangesKt.coerceIn(score, 0, 100) / 100.0f;
            if (fCoerceIn <= 0.5f) {
                return blendColors(ManabaseRadarChartView.COLOR_RED, ManabaseRadarChartView.COLOR_ORANGE, fCoerceIn / 0.5f);
            }
            return blendColors(ManabaseRadarChartView.COLOR_ORANGE, ManabaseRadarChartView.COLOR_GREEN, (fCoerceIn - 0.5f) / 0.5f);
        }
    }

    /* JADX INFO: compiled from: ManabaseRadarChartView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/ManabaseRadarChartView$DataPoint;", "", Constants.ScionAnalytics.PARAM_LABEL, "", FirebaseAnalytics.Param.SCORE, "", "color", "<init>", "(Ljava/lang/String;II)V", "getLabel", "()Ljava/lang/String;", "getScore", "()I", "getColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DataPoint {
        public static final int $stable = 0;
        private final int color;
        private final String label;
        private final int score;

        public DataPoint(String label, int i, int i2) {
            Intrinsics.checkNotNullParameter(label, "label");
            this.label = label;
            this.score = i;
            this.color = i2;
        }

        public static /* synthetic */ DataPoint copy$default(DataPoint dataPoint, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = dataPoint.label;
            }
            if ((i3 & 2) != 0) {
                i = dataPoint.score;
            }
            if ((i3 & 4) != 0) {
                i2 = dataPoint.color;
            }
            return dataPoint.copy(str, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getScore() {
            return this.score;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        public final DataPoint copy(String label, int score, int color) {
            Intrinsics.checkNotNullParameter(label, "label");
            return new DataPoint(label, score, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataPoint)) {
                return false;
            }
            DataPoint dataPoint = (DataPoint) other;
            return Intrinsics.areEqual(this.label, dataPoint.label) && this.score == dataPoint.score && this.color == dataPoint.color;
        }

        public final int getColor() {
            return this.color;
        }

        public final String getLabel() {
            return this.label;
        }

        public final int getScore() {
            return this.score;
        }

        public int hashCode() {
            return (((this.label.hashCode() * 31) + Integer.hashCode(this.score)) * 31) + Integer.hashCode(this.color);
        }

        public String toString() {
            return "DataPoint(label=" + this.label + ", score=" + this.score + ", color=" + this.color + ")";
        }
    }

    /* JADX INFO: compiled from: ManabaseRadarChartView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManabaseRadarChartView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManabaseRadarChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManabaseRadarChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dataPoints = CollectionsKt.emptyList();
        this.centerColor = Color.parseColor("#2DB570");
        this.centerLabel = "";
        this.selectedIndex = -1;
        this.labelHitRects = new ArrayList();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dp(1.0f));
        this.ringPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(dp(1.0f));
        paint2.setColor(Color.argb(20, 255, 255, 255));
        this.axisPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.FILL);
        this.dataFillPaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(dp(1.5f));
        paint4.setStrokeJoin(Paint.Join.ROUND);
        this.dataStrokePaint = paint4;
        Paint paint5 = new Paint(1);
        paint5.setStyle(Paint.Style.FILL);
        this.dotPaint = paint5;
        Paint paint6 = new Paint(1);
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeWidth(dp(0.5f));
        paint6.setColor(Color.argb(77, 0, 0, 0));
        this.dotStrokePaint = paint6;
        Paint paint7 = new Paint(1);
        paint7.setTextAlign(Paint.Align.CENTER);
        paint7.setTypeface(Typeface.DEFAULT_BOLD);
        paint7.setColor(Color.parseColor("#2DB570"));
        this.centerScorePaint = paint7;
        Paint paint8 = new Paint(1);
        paint8.setTextAlign(Paint.Align.CENTER);
        paint8.setColor(Color.argb(102, 199, 202, 202));
        this.centerLabelPaint = paint8;
        TextPaint textPaint = new TextPaint(1);
        Typeface font = ResourcesCompat.getFont(context, R.font.be_vietnam_pro_regular);
        textPaint.setTypeface(font == null ? Typeface.DEFAULT : font);
        this.labelPaint = textPaint;
        TextPaint textPaint2 = new TextPaint(1);
        textPaint2.setTypeface(Typeface.DEFAULT_BOLD);
        this.scoreLabelPaint = textPaint2;
        this.rings = new int[]{25, 50, 75, 100};
        this.minRadiusFraction = 0.2f;
    }

    public /* synthetic */ ManabaseRadarChartView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final float angle(int i, int n) {
        return ((6.2831855f / n) * i) - 1.5707964f;
    }

    private final float dataRadius(int score, float fullRadius) {
        float f = this.minRadiusFraction * fullRadius;
        return f + ((score / 100.0f) * (fullRadius - f));
    }

    private final float dp(float v) {
        return TypedValue.applyDimension(1, v, getResources().getDisplayMetrics());
    }

    private final void drawAxes(Canvas canvas, float cx, float cy, float r, int n) {
        for (int i = 0; i < n; i++) {
            PointF pointFPointOnRadius = pointOnRadius(cx, cy, r, angle(i, n));
            canvas.drawLine(cx, cy, pointFPointOnRadius.x, pointFPointOnRadius.y, this.axisPaint);
        }
    }

    private final void drawCenterScore(Canvas canvas, float cx, float cy) {
        this.centerScorePaint.setTextSize(sp(20.0f));
        canvas.drawText(String.valueOf(this.centerScore), cx, cy - dp(2.0f), this.centerScorePaint);
        if (this.centerLabel.length() > 0) {
            this.centerLabelPaint.setTextSize(sp(7.0f));
            canvas.drawText(this.centerLabel, cx, cy + dp(12.0f), this.centerLabelPaint);
        }
    }

    private final void drawDataPolygon(Canvas canvas, float cx, float cy, float r, int n) {
        Path path = new Path();
        for (int i = 0; i < n; i++) {
            PointF pointFPointOnRadius = pointOnRadius(cx, cy, dataRadius(this.dataPoints.get(i).getScore(), r), angle(i, n));
            float f = pointFPointOnRadius.x;
            float f2 = pointFPointOnRadius.y;
            if (i == 0) {
                path.moveTo(f, f2);
            } else {
                path.lineTo(f, f2);
            }
        }
        path.close();
        this.dataFillPaint.setShader(new RadialGradient(cx, cy, r, Color.argb(64, Color.red(this.centerColor), Color.green(this.centerColor), Color.blue(this.centerColor)), Color.argb(13, Color.red(this.centerColor), Color.green(this.centerColor), Color.blue(this.centerColor)), Shader.TileMode.CLAMP));
        canvas.drawPath(path, this.dataFillPaint);
        this.dataStrokePaint.setColor(Color.argb(178, Color.red(this.centerColor), Color.green(this.centerColor), Color.blue(this.centerColor)));
        canvas.drawPath(path, this.dataStrokePaint);
    }

    private final void drawDots(Canvas canvas, float cx, float cy, float r, int n) {
        int color = ContextCompat.getColor(getContext(), R.color.selected_color_new);
        int i = 0;
        while (i < n) {
            DataPoint dataPoint = this.dataPoints.get(i);
            PointF pointFPointOnRadius = pointOnRadius(cx, cy, dataRadius(dataPoint.getScore(), r), angle(i, n));
            boolean z = i == this.selectedIndex;
            float fDp = dp(z ? 6.0f : 3.5f);
            this.dotPaint.setColor(z ? color : dataPoint.getColor());
            canvas.drawCircle(pointFPointOnRadius.x, pointFPointOnRadius.y, fDp, this.dotPaint);
            canvas.drawCircle(pointFPointOnRadius.x, pointFPointOnRadius.y, fDp, this.dotStrokePaint);
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void drawLabels(Canvas canvas, float cx, float cy, float r, int n) {
        float f;
        float f2;
        float f3;
        float f4;
        float fDp;
        int i = n;
        float fDp2 = r + dp(18.0f);
        float fSp = sp(10.0f);
        float fSp2 = sp(9.0f);
        int color = ContextCompat.getColor(getContext(), R.color.almost_white);
        int iArgb = Color.argb(WebmConstants.MkvEbmlElement.BLOCK_GROUP, Color.red(color), Color.green(color), Color.blue(color));
        int color2 = ContextCompat.getColor(getContext(), R.color.selected_color_new);
        float fDp3 = dp(6.0f);
        this.labelHitRects.clear();
        int i2 = 0;
        while (i2 < i) {
            DataPoint dataPoint = this.dataPoints.get(i2);
            float fAngle = angle(i2, i);
            float f5 = (((180.0f * fAngle) / 3.1415927f) + 360.0f) % 360.0f;
            PointF pointFPointOnRadius = pointOnRadius(cx, cy, fDp2, fAngle);
            Layout.Alignment alignment = (f5 <= 75.0f || f5 >= 105.0f) ? (f5 <= 255.0f || f5 >= 285.0f) ? (f5 <= 75.0f || f5 >= 285.0f) ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_CENTER;
            boolean z = i2 == this.selectedIndex;
            this.labelPaint.setTextSize(fSp);
            float f6 = fDp2;
            this.labelPaint.setColor(z ? color2 : color);
            int iDp = (int) dp(70.0f);
            float f7 = fSp;
            int i3 = color;
            StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(dataPoint.getLabel(), 0, dataPoint.getLabel().length(), this.labelPaint, iDp).setAlignment(alignment).setMaxLines(2).setLineSpacing(0.0f, 1.05f).build();
            Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "build(...)");
            this.scoreLabelPaint.setTextSize(fSp2);
            this.scoreLabelPaint.setColor(z ? color2 : iArgb);
            String str = dataPoint.getScore() + "/100";
            float f8 = fSp2;
            StaticLayout staticLayoutBuild2 = StaticLayout.Builder.obtain(str, 0, str.length(), this.scoreLabelPaint, iDp).setAlignment(alignment).setMaxLines(1).build();
            Intrinsics.checkNotNullExpressionValue(staticLayoutBuild2, "build(...)");
            float height = staticLayoutBuild.getHeight() + staticLayoutBuild2.getHeight() + dp(1.0f);
            int i4 = WhenMappings.$EnumSwitchMapping$0[alignment.ordinal()];
            if (i4 == 1) {
                f = pointFPointOnRadius.x;
                f2 = iDp / 2.0f;
            } else if (i4 == 2) {
                f3 = pointFPointOnRadius.x;
                if (f5 > 250.0f || f5 >= 290.0f) {
                    f4 = 2.0f;
                    fDp = 0.0f;
                } else {
                    f4 = 2.0f;
                    fDp = -dp(10.0f);
                }
                if (f5 <= 70.0f && f5 < 110.0f) {
                    fDp = dp(6.0f);
                }
                float f9 = (pointFPointOnRadius.y - (height / f4)) + fDp;
                this.labelHitRects.add(new RectF(f3 - fDp3, f9 - fDp3, iDp + f3 + fDp3, f9 + height + fDp3));
                canvas.save();
                canvas.translate(f3, f9);
                staticLayoutBuild.draw(canvas);
                canvas.translate(0.0f, staticLayoutBuild.getHeight() + dp(1.0f));
                staticLayoutBuild2.draw(canvas);
                canvas.restore();
                i2++;
                i = n;
                fDp2 = f6;
                iArgb = iArgb;
                fSp = f7;
                color = i3;
                fSp2 = f8;
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f = pointFPointOnRadius.x;
                f2 = iDp;
            }
            f3 = f - f2;
            if (f5 > 250.0f) {
                f4 = 2.0f;
                fDp = 0.0f;
            }
            if (f5 <= 70.0f) {
            }
            float f92 = (pointFPointOnRadius.y - (height / f4)) + fDp;
            this.labelHitRects.add(new RectF(f3 - fDp3, f92 - fDp3, iDp + f3 + fDp3, f92 + height + fDp3));
            canvas.save();
            canvas.translate(f3, f92);
            staticLayoutBuild.draw(canvas);
            canvas.translate(0.0f, staticLayoutBuild.getHeight() + dp(1.0f));
            staticLayoutBuild2.draw(canvas);
            canvas.restore();
            i2++;
            i = n;
            fDp2 = f6;
            iArgb = iArgb;
            fSp = f7;
            color = i3;
            fSp2 = f8;
        }
    }

    private final void drawRings(Canvas canvas, float cx, float cy, float r, int n) {
        int[] iArr = this.rings;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            float fGridRadius = gridRadius(i2, r);
            this.ringPaint.setColor(Color.argb(i2 == 100 ? 38 : 20, 255, 255, 255));
            Path path = new Path();
            for (int i3 = 0; i3 < n; i3++) {
                PointF pointFPointOnRadius = pointOnRadius(cx, cy, fGridRadius, angle(i3, n));
                float f = pointFPointOnRadius.x;
                float f2 = pointFPointOnRadius.y;
                if (i3 == 0) {
                    path.moveTo(f, f2);
                } else {
                    path.lineTo(f, f2);
                }
            }
            path.close();
            canvas.drawPath(path, this.ringPaint);
        }
    }

    private final float gridRadius(int ringValue, float fullRadius) {
        return (ringValue / 100.0f) * fullRadius;
    }

    private final PointF pointOnRadius(float cx, float cy, float radius, float angle) {
        double d = angle;
        return new PointF(cx + (((float) Math.cos(d)) * radius), cy + (radius * ((float) Math.sin(d))));
    }

    public static /* synthetic */ void setData$default(ManabaseRadarChartView manabaseRadarChartView, List list, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str = "";
        }
        manabaseRadarChartView.setData(list, i, i2, str);
    }

    private final float sp(float v) {
        return TypedValue.applyDimension(2, v, getResources().getDisplayMetrics());
    }

    public final void clearSelection() {
        if (this.selectedIndex != -1) {
            this.selectedIndex = -1;
            invalidate();
        }
    }

    public final Function1<Integer, Unit> getOnDataPointSelected() {
        return this.onDataPointSelected;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int size = this.dataPoints.size();
        if (size < 3) {
            return;
        }
        float width = getWidth();
        float height = getHeight();
        float f = width / 2.0f;
        float f2 = 0.48f * height;
        float fMin = (Math.min(width, height) / 2.0f) - dp(50.0f);
        drawRings(canvas, f, f2, fMin, size);
        drawAxes(canvas, f, f2, fMin, size);
        drawDataPolygon(canvas, f, f2, fMin, size);
        drawDots(canvas, f, f2, fMin, size);
        drawLabels(canvas, f, f2, fMin, size);
        drawCenterScore(canvas, f, f2);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(size, (int) (size * 0.75f));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Function1<? super Integer, Unit> function1;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 0 || this.labelHitRects.isEmpty()) {
            return super.onTouchEvent(event);
        }
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        float x = event.getX();
        float y = event.getY();
        int size = this.labelHitRects.size();
        int i = 0;
        while (i < size) {
            if (this.labelHitRects.get(i).contains(x, y)) {
                if (this.selectedIndex == i) {
                    i = -1;
                }
                this.selectedIndex = i;
                invalidate();
                if (i >= 0 && (function1 = this.onDataPointSelected) != null) {
                    function1.invoke(Integer.valueOf(i));
                }
                return true;
            }
            i++;
        }
        if (this.selectedIndex != -1) {
            this.selectedIndex = -1;
            invalidate();
        }
        return true;
    }

    public final void setData(List<DataPoint> points, int overallScore, int overallColor, String label) {
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(label, "label");
        this.dataPoints = points;
        this.centerScore = overallScore;
        this.centerColor = overallColor;
        this.centerLabel = label;
        this.centerScorePaint.setColor(overallColor);
        this.selectedIndex = -1;
        requestLayout();
        invalidate();
    }

    public final void setOnDataPointSelected(Function1<? super Integer, Unit> function1) {
        this.onDataPointSelected = function1;
    }
}
