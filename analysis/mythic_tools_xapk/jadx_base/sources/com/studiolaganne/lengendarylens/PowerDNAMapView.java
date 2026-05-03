package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
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
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.muxer.WebmConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PowerDNAMapView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0002[\\B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u00105\u001a\u00020\u001f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007J\u0010\u00109\u001a\u00020\u001f2\b\u0010:\u001a\u0004\u0018\u00010\u0012J\u0006\u0010;\u001a\u00020\u001fJ\u0018\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0014J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0002J\u0010\u0010F\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0002J\b\u0010G\u001a\u00020\u001fH\u0002J \u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020D2\u0006\u0010K\u001a\u00020DH\u0002J \u0010L\u001a\u00020D2\u0006\u0010I\u001a\u00020D2\u0006\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020DH\u0002J\u0010\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020QH\u0014J0\u0010R\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020D2\u0006\u0010M\u001a\u00020D2\u0006\u0010K\u001a\u00020D2\u0006\u0010N\u001a\u00020DH\u0002J0\u0010S\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020D2\u0006\u0010M\u001a\u00020D2\u0006\u0010K\u001a\u00020D2\u0006\u0010N\u001a\u00020DH\u0002J0\u0010T\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020D2\u0006\u0010M\u001a\u00020D2\u0006\u0010K\u001a\u00020D2\u0006\u0010N\u001a\u00020DH\u0002J0\u0010U\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020D2\u0006\u0010M\u001a\u00020D2\u0006\u0010K\u001a\u00020D2\u0006\u0010N\u001a\u00020DH\u0002J0\u0010V\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020D2\u0006\u0010M\u001a\u00020D2\u0006\u0010K\u001a\u00020D2\u0006\u0010N\u001a\u00020DH\u0002J8\u0010W\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020D2\u0006\u0010M\u001a\u00020D2\u0006\u0010K\u001a\u00020D2\u0006\u0010N\u001a\u00020D2\u0006\u0010X\u001a\u00020DH\u0002J0\u0010Y\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010J\u001a\u00020D2\u0006\u0010M\u001a\u00020D2\u0006\u0010K\u001a\u00020D2\u0006\u0010N\u001a\u00020DH\u0002J\u0010\u0010Z\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020QH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/studiolaganne/lengendarylens/PowerDNAMapView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tierPoints", "", "Lcom/studiolaganne/lengendarylens/PowerDNAMapView$TierPoint;", "overallScore", "overallColor", "deckPos", "Landroid/graphics/PointF;", "backgroundBitmap", "Landroid/graphics/Bitmap;", "hintText", "", "getHintText", "()Ljava/lang/String;", "setHintText", "(Ljava/lang/String;)V", "value", "selectedIndex", "getSelectedIndex", "()I", "onTierSelected", "Lkotlin/Function1;", "", "getOnTierSelected", "()Lkotlin/jvm/functions/Function1;", "setOnTierSelected", "(Lkotlin/jvm/functions/Function1;)V", "labelHitRects", "", "Landroid/graphics/RectF;", "helixPaint", "Landroid/graphics/Paint;", "zonePaint", "beamPaint", "dotPaint", "dotStrokePaint", "glowPaint", "scorePaint", "scoreBgPaint", "labelPaint", "Landroid/text/TextPaint;", "simPaint", "hintIconPaint", "hintTextPaint", "setData", "tiers", FirebaseAnalytics.Param.SCORE, "scoreColor", "setBackgroundImage", "bitmap", "clearSelection", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "dp", "", "v", "sp", "computeDeckPosition", "mx", "n", "l", "r", "my", "t", "b", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawHelix", "drawZones", "drawBeams", "drawTierDots", "drawDeckDot", "drawLabels", "viewW", "drawScore", "drawHint", "TierPoint", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PowerDNAMapView extends View {
    private Bitmap backgroundBitmap;
    private final Paint beamPaint;
    private PointF deckPos;
    private final Paint dotPaint;
    private final Paint dotStrokePaint;
    private final Paint glowPaint;
    private final Paint helixPaint;
    private final Paint hintIconPaint;
    private String hintText;
    private final Paint hintTextPaint;
    private final List<RectF> labelHitRects;
    private final TextPaint labelPaint;
    private Function1<? super Integer, Unit> onTierSelected;
    private int overallColor;
    private int overallScore;
    private final Paint scoreBgPaint;
    private final Paint scorePaint;
    private int selectedIndex;
    private final TextPaint simPaint;
    private List<TierPoint> tierPoints;
    private final Paint zonePaint;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final PointF[] TIER_POSITIONS = {new PointF(0.08f, 0.74f), new PointF(0.3f, 0.56f), new PointF(0.64f, 0.38f), new PointF(0.92f, 0.2f)};
    private static final int[] TIER_COLORS = {Color.parseColor("#8B8B8B"), Color.parseColor("#ED9A57"), Color.parseColor("#5B8DEF"), Color.parseColor("#7C6FE0")};

    /* JADX INFO: compiled from: PowerDNAMapView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/PowerDNAMapView$Companion;", "", "<init>", "()V", "TIER_POSITIONS", "", "Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "TIER_COLORS", "", "getTIER_COLORS", "()[I", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int[] getTIER_COLORS() {
            return PowerDNAMapView.TIER_COLORS;
        }
    }

    /* JADX INFO: compiled from: PowerDNAMapView.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/PowerDNAMapView$TierPoint;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "similarity", "", "weight", "", "color", "<init>", "(Ljava/lang/String;IFI)V", "getLabel", "()Ljava/lang/String;", "getSimilarity", "()I", "getWeight", "()F", "getColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TierPoint {
        public static final int $stable = 0;
        private final int color;
        private final String label;
        private final int similarity;
        private final float weight;

        public TierPoint(String label, int i, float f, int i2) {
            Intrinsics.checkNotNullParameter(label, "label");
            this.label = label;
            this.similarity = i;
            this.weight = f;
            this.color = i2;
        }

        public static /* synthetic */ TierPoint copy$default(TierPoint tierPoint, String str, int i, float f, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = tierPoint.label;
            }
            if ((i3 & 2) != 0) {
                i = tierPoint.similarity;
            }
            if ((i3 & 4) != 0) {
                f = tierPoint.weight;
            }
            if ((i3 & 8) != 0) {
                i2 = tierPoint.color;
            }
            return tierPoint.copy(str, i, f, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSimilarity() {
            return this.similarity;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getWeight() {
            return this.weight;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        public final TierPoint copy(String label, int similarity, float weight, int color) {
            Intrinsics.checkNotNullParameter(label, "label");
            return new TierPoint(label, similarity, weight, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TierPoint)) {
                return false;
            }
            TierPoint tierPoint = (TierPoint) other;
            return Intrinsics.areEqual(this.label, tierPoint.label) && this.similarity == tierPoint.similarity && Float.compare(this.weight, tierPoint.weight) == 0 && this.color == tierPoint.color;
        }

        public final int getColor() {
            return this.color;
        }

        public final String getLabel() {
            return this.label;
        }

        public final int getSimilarity() {
            return this.similarity;
        }

        public final float getWeight() {
            return this.weight;
        }

        public int hashCode() {
            return (((((this.label.hashCode() * 31) + Integer.hashCode(this.similarity)) * 31) + Float.hashCode(this.weight)) * 31) + Integer.hashCode(this.color);
        }

        public String toString() {
            return "TierPoint(label=" + this.label + ", similarity=" + this.similarity + ", weight=" + this.weight + ", color=" + this.color + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PowerDNAMapView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PowerDNAMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PowerDNAMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tierPoints = CollectionsKt.emptyList();
        this.overallColor = Color.parseColor("#2DB570");
        this.deckPos = new PointF(0.5f, 0.5f);
        this.hintText = "";
        this.selectedIndex = -1;
        this.labelHitRects = new ArrayList();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.helixPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        this.zonePaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        this.beamPaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.FILL);
        this.dotPaint = paint4;
        Paint paint5 = new Paint(1);
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(dp(0.5f));
        paint5.setColor(Color.argb(60, 0, 0, 0));
        this.dotStrokePaint = paint5;
        Paint paint6 = new Paint(1);
        paint6.setStyle(Paint.Style.FILL);
        this.glowPaint = paint6;
        Paint paint7 = new Paint(1);
        paint7.setTextAlign(Paint.Align.CENTER);
        paint7.setTypeface(Typeface.DEFAULT_BOLD);
        this.scorePaint = paint7;
        Paint paint8 = new Paint(1);
        paint8.setStyle(Paint.Style.FILL);
        paint8.setColor(Color.argb(WebmConstants.MkvEbmlElement.BLOCK_GROUP, 18, 18, 22));
        this.scoreBgPaint = paint8;
        TextPaint textPaint = new TextPaint(1);
        Typeface font = ResourcesCompat.getFont(context, R.font.be_vietnam_pro_regular);
        textPaint.setTypeface(font == null ? Typeface.DEFAULT : font);
        this.labelPaint = textPaint;
        TextPaint textPaint2 = new TextPaint(1);
        textPaint2.setTypeface(Typeface.DEFAULT_BOLD);
        this.simPaint = textPaint2;
        Paint paint9 = new Paint(1);
        Typeface font2 = ResourcesCompat.getFont(context, R.font.fa6solid);
        paint9.setTypeface(font2 == null ? Typeface.DEFAULT : font2);
        paint9.setTextAlign(Paint.Align.LEFT);
        this.hintIconPaint = paint9;
        Paint paint10 = new Paint(1);
        Typeface font3 = ResourcesCompat.getFont(context, R.font.be_vietnam_pro_regular);
        paint10.setTypeface(font3 == null ? Typeface.DEFAULT : font3);
        paint10.setTextAlign(Paint.Align.LEFT);
        this.hintTextPaint = paint10;
    }

    public /* synthetic */ PowerDNAMapView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void computeDeckPosition() {
        if (this.tierPoints.isEmpty()) {
            this.deckPos.set(0.5f, 0.5f);
            return;
        }
        int size = this.tierPoints.size();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i = 0; i < size; i++) {
            PointF[] pointFArr = TIER_POSITIONS;
            if (i >= pointFArr.length) {
                break;
            }
            float weight = this.tierPoints.get(i).getWeight();
            f2 += pointFArr[i].x * weight;
            f3 += pointFArr[i].y * weight;
            f += weight;
        }
        this.deckPos = f > 0.0f ? new PointF(f2 / f, f3 / f) : new PointF(0.5f, 0.5f);
    }

    private final float dp(float v) {
        return TypedValue.applyDimension(1, v, getResources().getDisplayMetrics());
    }

    private final void drawBeams(Canvas canvas, float l, float t, float r, float b) {
        Float fValueOf;
        float f = l;
        float f2 = t;
        float f3 = r;
        float fMx = mx(this.deckPos.x, f, f3);
        float fMy = my(this.deckPos.y, f2, b);
        Iterator<T> it = this.tierPoints.iterator();
        if (it.hasNext()) {
            float weight = ((TierPoint) it.next()).getWeight();
            while (it.hasNext()) {
                weight = Math.max(weight, ((TierPoint) it.next()).getWeight());
            }
            fValueOf = Float.valueOf(weight);
        } else {
            fValueOf = null;
        }
        float fFloatValue = fValueOf != null ? fValueOf.floatValue() : 1.0f;
        int size = this.tierPoints.size();
        int i = 0;
        while (i < size) {
            PointF[] pointFArr = TIER_POSITIONS;
            if (i >= pointFArr.length) {
                break;
            }
            TierPoint tierPoint = this.tierPoints.get(i);
            PointF pointF = pointFArr[i];
            float fMx2 = mx(pointF.x, f, f3);
            float fMy2 = my(pointF.y, f2, b);
            float weight2 = fFloatValue > 0.0f ? tierPoint.getWeight() / fFloatValue : 0.0f;
            boolean z = i == this.selectedIndex;
            float fDp = dp(0.8f) + (dp(2.5f) * weight2);
            int iCoerceIn = RangesKt.coerceIn((int) (25.0f + (90.0f * weight2)), 20, 115);
            int iRed = Color.red(tierPoint.getColor());
            int iGreen = Color.green(tierPoint.getColor());
            int iBlue = Color.blue(tierPoint.getColor());
            Paint paint = this.beamPaint;
            if (z) {
                fDp *= 1.5f;
            }
            paint.setStrokeWidth(fDp);
            Paint paint2 = this.beamPaint;
            int i2 = i;
            if (z) {
                iCoerceIn = RangesKt.coerceAtMost((int) (iCoerceIn * 1.6f), 220);
            }
            paint2.setShader(new LinearGradient(fMx2, fMy2, fMx, fMy, Color.argb(iCoerceIn, iRed, iGreen, iBlue), Color.argb(3, iRed, iGreen, iBlue), Shader.TileMode.CLAMP));
            canvas.drawLine(fMx2, fMy2, fMx, fMy, this.beamPaint);
            i = i2 + 1;
            f = l;
            f2 = t;
            f3 = r;
        }
        this.beamPaint.setShader(null);
    }

    private final void drawDeckDot(Canvas canvas, float l, float t, float r, float b) {
        float fMx = mx(this.deckPos.x, l, r);
        float fMy = my(this.deckPos.y, t, b);
        float fDp = dp(7.0f);
        int iRed = Color.red(this.overallColor);
        int iGreen = Color.green(this.overallColor);
        int iBlue = Color.blue(this.overallColor);
        for (int i = 3; -1 < i; i--) {
            float fDp2 = fDp + dp(i * 5.0f);
            this.glowPaint.setShader(new RadialGradient(fMx, fMy, fDp2, Color.argb((i * 4) + 10, iRed, iGreen, iBlue), Color.argb(0, iRed, iGreen, iBlue), Shader.TileMode.CLAMP));
            canvas.drawCircle(fMx, fMy, fDp2, this.glowPaint);
        }
        this.glowPaint.setShader(null);
        this.dotPaint.setColor(this.overallColor);
        canvas.drawCircle(fMx, fMy, fDp, this.dotPaint);
        this.dotPaint.setColor(Color.argb(90, 255, 255, 255));
        canvas.drawCircle(fMx, fMy, fDp * 0.35f, this.dotPaint);
    }

    private final void drawHelix(Canvas canvas, float l, float t, float r, float b) {
        int i;
        int i2;
        Bitmap bitmap = this.backgroundBitmap;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            RectF rectF = new RectF(l - dp(20.0f), t - dp(10.0f), r + dp(20.0f), dp(10.0f) + b);
            Paint paint = new Paint(1);
            paint.setAlpha(25);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
            return;
        }
        float fMx = mx(-0.04f, l, r);
        float fMy = my(0.88f, t, b);
        float fMx2 = mx(1.04f, l, r) - fMx;
        float fMy2 = my(0.12f, t, b) - fMy;
        float fSqrt = (float) Math.sqrt((fMx2 * fMx2) + (fMy2 * fMy2));
        float f = -(fMy2 / fSqrt);
        float f2 = fMx2 / fSqrt;
        float f3 = fSqrt * 0.05f;
        int i3 = 0;
        while (i3 < 2) {
            float fDp = dp(i3 == 0 ? 6.0f : 1.4f);
            int i4 = i3 == 0 ? 13 : 30;
            this.helixPaint.setStrokeWidth(fDp);
            this.helixPaint.setColor(Color.argb(i4, 100, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 255));
            int i5 = 0;
            while (i5 < 2) {
                float f4 = i5 * 3.1415927f;
                Path path = new Path();
                int i6 = 0;
                while (true) {
                    float f5 = i6 / 120.0f;
                    i = i5;
                    i2 = i3;
                    float fSin = ((float) Math.sin((f5 * 3.0f * 2.0f * 3.1415927f) + f4)) * f3;
                    float f6 = fMx + (fMx2 * f5) + (f * fSin);
                    float f7 = fMy + (fMy2 * f5) + (fSin * f2);
                    if (i6 == 0) {
                        path.moveTo(f6, f7);
                    } else {
                        path.lineTo(f6, f7);
                    }
                    if (i6 != 120) {
                        i6++;
                        i3 = i2;
                        i5 = i;
                    }
                }
                this.helixPaint.setAlpha(i4);
                canvas.drawPath(path, this.helixPaint);
                i5 = i + 1;
                i3 = i2;
            }
            i3++;
        }
        this.helixPaint.setStrokeWidth(dp(0.5f));
        this.helixPaint.setColor(Color.argb(18, 100, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 255));
        int i7 = 0;
        while (true) {
            float f8 = i7 / 24.0f;
            float f9 = (fMx2 * f8) + fMx;
            float f10 = (fMy2 * f8) + fMy;
            float fSin2 = ((float) Math.sin(f8 * 3.0f * 2.0f * 3.1415927f)) * f3;
            float fSin3 = ((float) Math.sin(r2 + 3.1415927f)) * f3;
            canvas.drawLine((f * fSin2) + f9, (fSin2 * f2) + f10, f9 + (f * fSin3), f10 + (fSin3 * f2), this.helixPaint);
            if (i7 == 24) {
                return;
            } else {
                i7++;
            }
        }
    }

    private final void drawHint(Canvas canvas) {
        if (this.hintText.length() == 0) {
            return;
        }
        int iArgb = Color.argb(90, 199, 202, 202);
        float fDp = dp(12.0f);
        float fDp2 = dp(14.0f);
        this.hintIconPaint.setTextSize(sp(11.0f));
        this.hintIconPaint.setColor(iArgb);
        canvas.drawText("\uf05a", fDp, fDp2, this.hintIconPaint);
        float fMeasureText = this.hintIconPaint.measureText("\uf05a");
        this.hintTextPaint.setTextSize(sp(10.5f));
        this.hintTextPaint.setColor(iArgb);
        canvas.drawText(this.hintText, fDp + fMeasureText + dp(4.0f), fDp2, this.hintTextPaint);
    }

    private final void drawLabels(Canvas canvas, float l, float t, float r, float b, float viewW) {
        float fSp = sp(10.0f);
        float fSp2 = sp(9.0f);
        int color = ContextCompat.getColor(getContext(), R.color.almost_white);
        int iArgb = Color.argb(140, Color.red(color), Color.green(color), Color.blue(color));
        int color2 = ContextCompat.getColor(getContext(), R.color.selected_color_new);
        float fDp = dp(8.0f);
        this.labelHitRects.clear();
        int size = this.tierPoints.size();
        int i = 0;
        while (i < size) {
            PointF[] pointFArr = TIER_POSITIONS;
            if (i >= pointFArr.length) {
                return;
            }
            TierPoint tierPoint = this.tierPoints.get(i);
            PointF pointF = pointFArr[i];
            float fMx = mx(pointF.x, l, r);
            int i2 = color;
            float fMy = my(pointF.y, t, b);
            boolean z = i == this.selectedIndex;
            boolean z2 = pointF.x < 0.5f;
            Layout.Alignment alignment = z2 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
            boolean z3 = z;
            this.labelPaint.setTextSize(fSp);
            float f = fSp;
            this.labelPaint.setColor(z3 ? color2 : i2);
            int iDp = (int) dp(72.0f);
            int i3 = iArgb;
            int i4 = color2;
            float f2 = fDp;
            StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(tierPoint.getLabel(), 0, tierPoint.getLabel().length(), this.labelPaint, iDp).setAlignment(alignment).setMaxLines(1).build();
            Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "build(...)");
            this.simPaint.setTextSize(fSp2);
            this.simPaint.setColor(z3 ? i4 : i3);
            String str = tierPoint.getSimilarity() + "%";
            float f3 = fSp2;
            StaticLayout staticLayoutBuild2 = StaticLayout.Builder.obtain(str, 0, str.length(), this.simPaint, iDp).setAlignment(alignment).setMaxLines(1).build();
            Intrinsics.checkNotNullExpressionValue(staticLayoutBuild2, "build(...)");
            float height = staticLayoutBuild.getHeight() + staticLayoutBuild2.getHeight() + dp(1.0f);
            float fDp2 = dp(10.0f);
            if (z2) {
                fMx -= iDp;
            }
            float f4 = fMy + fDp2;
            this.labelHitRects.add(new RectF(fMx - f2, f4 - f2, iDp + fMx + f2, height + f4 + f2));
            canvas.save();
            canvas.translate(fMx, f4);
            staticLayoutBuild.draw(canvas);
            canvas.translate(0.0f, staticLayoutBuild.getHeight() + dp(1.0f));
            staticLayoutBuild2.draw(canvas);
            canvas.restore();
            i++;
            color = i2;
            fSp2 = f3;
            fSp = f;
            color2 = i4;
            iArgb = i3;
            fDp = f2;
        }
    }

    private final void drawScore(Canvas canvas, float l, float t, float r, float b) {
        float fMx = mx(this.deckPos.x, l, r);
        float fMy = my(this.deckPos.y, t, b);
        this.scorePaint.setTextSize(sp(16.0f));
        this.scorePaint.setColor(this.overallColor);
        String strValueOf = String.valueOf(this.overallScore);
        float fMeasureText = this.scorePaint.measureText(strValueOf);
        Paint.FontMetrics fontMetrics = this.scorePaint.getFontMetrics();
        float fDp = (fontMetrics.descent - fontMetrics.ascent) + dp(6.0f);
        float fDp2 = fMeasureText + dp(16.0f);
        float fDp3 = fMy - dp(16.0f);
        float fDp4 = (fontMetrics.ascent + fDp3) - dp(3.0f);
        float f = fDp2 / 2.0f;
        canvas.drawRoundRect(new RectF(fMx - f, fDp4, f + fMx, fDp + fDp4), dp(8.0f), dp(8.0f), this.scoreBgPaint);
        canvas.drawText(strValueOf, fMx, fDp3, this.scorePaint);
    }

    private final void drawTierDots(Canvas canvas, float l, float t, float r, float b) {
        int color = ContextCompat.getColor(getContext(), R.color.selected_color_new);
        int size = this.tierPoints.size();
        int i = 0;
        while (i < size) {
            PointF[] pointFArr = TIER_POSITIONS;
            if (i >= pointFArr.length) {
                return;
            }
            TierPoint tierPoint = this.tierPoints.get(i);
            PointF pointF = pointFArr[i];
            float fMx = mx(pointF.x, l, r);
            float fMy = my(pointF.y, t, b);
            boolean z = i == this.selectedIndex;
            float fDp = dp(z ? 6.0f : 4.0f);
            int iRed = Color.red(tierPoint.getColor());
            int iGreen = Color.green(tierPoint.getColor());
            int i2 = color;
            int iBlue = Color.blue(tierPoint.getColor());
            int i3 = size;
            float f = 3.5f * fDp;
            int i4 = i;
            this.glowPaint.setShader(new RadialGradient(fMx, fMy, f, Color.argb(z ? 55 : 30, iRed, iGreen, iBlue), Color.argb(0, iRed, iGreen, iBlue), Shader.TileMode.CLAMP));
            canvas.drawCircle(fMx, fMy, f, this.glowPaint);
            this.glowPaint.setShader(null);
            this.dotPaint.setColor(z ? i2 : tierPoint.getColor());
            canvas.drawCircle(fMx, fMy, fDp, this.dotPaint);
            canvas.drawCircle(fMx, fMy, fDp, this.dotStrokePaint);
            i = i4 + 1;
            color = i2;
            size = i3;
        }
    }

    private final void drawZones(Canvas canvas, float l, float t, float r, float b) {
        int size = this.tierPoints.size();
        for (int i = 0; i < size; i++) {
            PointF[] pointFArr = TIER_POSITIONS;
            if (i >= pointFArr.length) {
                break;
            }
            TierPoint tierPoint = this.tierPoints.get(i);
            PointF pointF = pointFArr[i];
            float fMx = mx(pointF.x, l, r);
            float fMy = my(pointF.y, t, b);
            float fDp = dp(90.0f);
            int iRed = Color.red(tierPoint.getColor());
            int iGreen = Color.green(tierPoint.getColor());
            int iBlue = Color.blue(tierPoint.getColor());
            this.zonePaint.setShader(new RadialGradient(fMx, fMy, fDp, Color.argb(22, iRed, iGreen, iBlue), Color.argb(0, iRed, iGreen, iBlue), Shader.TileMode.CLAMP));
            canvas.drawCircle(fMx, fMy, fDp, this.zonePaint);
        }
        this.zonePaint.setShader(null);
    }

    private final float mx(float n, float l, float r) {
        return l + (n * (r - l));
    }

    private final float my(float n, float t, float b) {
        return t + (n * (b - t));
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

    public final String getHintText() {
        return this.hintText;
    }

    public final Function1<Integer, Unit> getOnTierSelected() {
        return this.onTierSelected;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.tierPoints.isEmpty()) {
            return;
        }
        float width = getWidth();
        float height = getHeight();
        float fDp = dp(48.0f);
        float fDp2 = dp(24.0f);
        float f = width - fDp;
        float f2 = height - fDp2;
        drawHelix(canvas, fDp, fDp2, f, f2);
        drawZones(canvas, fDp, fDp2, f, f2);
        drawBeams(canvas, fDp, fDp2, f, f2);
        drawTierDots(canvas, fDp, fDp2, f, f2);
        drawDeckDot(canvas, fDp, fDp2, f, f2);
        drawLabels(canvas, fDp, fDp2, f, f2, width);
        drawScore(canvas, fDp, fDp2, f, f2);
        drawHint(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(size, (int) (size * 0.72f));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Function1<? super Integer, Unit> function1;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0 && !this.labelHitRects.isEmpty()) {
            int size = this.labelHitRects.size();
            int i = 0;
            while (i < size) {
                if (this.labelHitRects.get(i).contains(event.getX(), event.getY())) {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (this.selectedIndex == i) {
                        i = -1;
                    }
                    this.selectedIndex = i;
                    invalidate();
                    int i2 = this.selectedIndex;
                    if (i2 >= 0 && (function1 = this.onTierSelected) != null) {
                        function1.invoke(Integer.valueOf(i2));
                    }
                    return true;
                }
                i++;
            }
            if (this.selectedIndex != -1) {
                this.selectedIndex = -1;
                invalidate();
            }
        }
        return super.onTouchEvent(event);
    }

    public final void setBackgroundImage(Bitmap bitmap) {
        this.backgroundBitmap = bitmap;
        invalidate();
    }

    public final void setData(List<TierPoint> tiers, int score, int scoreColor) {
        Intrinsics.checkNotNullParameter(tiers, "tiers");
        this.tierPoints = tiers;
        this.overallScore = score;
        this.overallColor = scoreColor;
        computeDeckPosition();
        this.selectedIndex = -1;
        requestLayout();
        invalidate();
    }

    public final void setHintText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hintText = str;
    }

    public final void setOnTierSelected(Function1<? super Integer, Unit> function1) {
        this.onTierSelected = function1;
    }
}
