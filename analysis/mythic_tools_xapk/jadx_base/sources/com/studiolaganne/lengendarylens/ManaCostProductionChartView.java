package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManaCostProductionChartView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007J(\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/ManaCostProductionChartView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "costBackgroundPaint", "productionBackgroundPaint", "costPaint", "productionPaint", "centerX", "", "centerY", "radius", "color", "", "costValue", "productionValue", "maxCostValue", "maxProductionValue", "symbolDrawable", "Landroid/graphics/drawable/Drawable;", "colorMap", "", "setupPaints", "", "setData", "entry", "Lcom/studiolaganne/lengendarylens/MTManaCostProductionEntry;", "maxCost", "maxProduction", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ManaCostProductionChartView extends View {
    public static final int $stable = 8;
    private float centerX;
    private float centerY;
    private String color;
    private final Map<String, Integer> colorMap;
    private final Paint costBackgroundPaint;
    private final Paint costPaint;
    private int costValue;
    private int maxCostValue;
    private int maxProductionValue;
    private final Paint paint;
    private final Paint productionBackgroundPaint;
    private final Paint productionPaint;
    private int productionValue;
    private float radius;
    private Drawable symbolDrawable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManaCostProductionChartView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManaCostProductionChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManaCostProductionChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint(1);
        this.costBackgroundPaint = new Paint(1);
        this.productionBackgroundPaint = new Paint(1);
        this.costPaint = new Paint(1);
        this.productionPaint = new Paint(1);
        this.color = ExifInterface.LONGITUDE_WEST;
        this.maxCostValue = 1;
        this.maxProductionValue = 1;
        this.colorMap = MapsKt.mapOf(TuplesKt.to(ExifInterface.LONGITUDE_WEST, Integer.valueOf(Color.parseColor("#F5F5DC"))), TuplesKt.to("U", Integer.valueOf(Color.parseColor("#5EA8FB"))), TuplesKt.to("B", Integer.valueOf(Color.parseColor("#B5BBB0"))), TuplesKt.to("R", Integer.valueOf(Color.parseColor("#F3403A"))), TuplesKt.to(GameUtils.CONDITION_GOOD, Integer.valueOf(Color.parseColor("#30D34E"))), TuplesKt.to("C", Integer.valueOf(Color.parseColor("#CAC5C0"))));
        setupPaints();
    }

    public /* synthetic */ ManaCostProductionChartView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setupPaints() {
        this.costBackgroundPaint.setStyle(Paint.Style.STROKE);
        this.costBackgroundPaint.setStrokeWidth(24.0f);
        this.costBackgroundPaint.setColor(Color.parseColor("#333333"));
        this.productionBackgroundPaint.setStyle(Paint.Style.STROKE);
        this.productionBackgroundPaint.setStrokeWidth(24.0f);
        this.productionBackgroundPaint.setColor(Color.parseColor("#333333"));
        this.costPaint.setStyle(Paint.Style.STROKE);
        this.costPaint.setStrokeWidth(28.0f);
        this.costPaint.setStrokeCap(Paint.Cap.ROUND);
        this.productionPaint.setStyle(Paint.Style.STROKE);
        this.productionPaint.setStrokeWidth(28.0f);
        this.productionPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.maxCostValue == 0 && this.maxProductionValue == 0) {
            return;
        }
        float f = this.radius;
        float f2 = f - 28.0f;
        float f3 = this.centerX;
        float f4 = this.centerY;
        RectF rectF = new RectF(f3 - f, f4 - f, f3 + f, f4 + f);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.costBackgroundPaint);
        float f5 = this.centerX;
        float f6 = this.centerY;
        RectF rectF2 = new RectF(f5 - f2, f6 - f2, f5 + f2, f6 + f2);
        canvas.drawArc(rectF2, 0.0f, 360.0f, false, this.productionBackgroundPaint);
        int i3 = this.costValue;
        if (i3 > 0 && (i2 = this.maxCostValue) > 0) {
            canvas.drawArc(rectF, -90.0f, (i3 / i2) * 360.0f, false, this.costPaint);
        }
        int i4 = this.productionValue;
        if (i4 > 0 && (i = this.maxProductionValue) > 0) {
            canvas.drawArc(rectF2, -90.0f, (i4 / i) * 360.0f, false, this.productionPaint);
        }
        Drawable drawable = this.symbolDrawable;
        if (drawable != null) {
            float f7 = (int) (this.radius * 0.95f);
            float f8 = f7 / 2.0f;
            float f9 = this.centerX - f8;
            float f10 = this.centerY - f8;
            drawable.setBounds((int) f9, (int) f10, (int) (f9 + f7), (int) (f10 + f7));
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.centerX = w / 2.0f;
        this.centerY = h / 2.0f;
        this.radius = (Math.min(w, h) / 2.0f) - 20.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setData(MTManaCostProductionEntry entry, int maxCost, int maxProduction) {
        int i;
        Intrinsics.checkNotNullParameter(entry, "entry");
        String upperCase = entry.getColor().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        this.color = upperCase;
        MTProductionEntry costs = entry.getCosts();
        this.costValue = costs != null ? costs.getSymbols() : 0;
        MTProductionEntry production = entry.getProduction();
        this.productionValue = production != null ? production.getSymbols() : 0;
        this.maxCostValue = Math.max(maxCost, 1);
        this.maxProductionValue = Math.max(maxProduction, 1);
        String str = this.color;
        int iHashCode = str.hashCode();
        if (iHashCode != 66) {
            if (iHashCode != 67) {
                if (iHashCode != 71) {
                    if (iHashCode != 82) {
                        if (iHashCode != 85) {
                            i = (iHashCode == 87 && str.equals(ExifInterface.LONGITUDE_WEST)) ? R.drawable.symbol_w : R.drawable.symbol_c;
                        } else if (str.equals("U")) {
                            i = R.drawable.symbol_u;
                        }
                    } else if (str.equals("R")) {
                        i = R.drawable.symbol_r;
                    }
                } else if (str.equals(GameUtils.CONDITION_GOOD)) {
                    i = R.drawable.symbol_g;
                }
            } else if (str.equals("C")) {
                i = R.drawable.symbol_c;
            }
        } else if (str.equals("B")) {
            i = R.drawable.symbol_b;
        }
        this.symbolDrawable = ContextCompat.getDrawable(getContext(), i);
        Integer num = this.colorMap.get(this.color);
        int iIntValue = num != null ? num.intValue() : -7829368;
        this.costBackgroundPaint.setColor(Color.argb(20, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        this.costPaint.setColor(Color.argb(175, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        this.productionPaint.setColor(iIntValue);
        this.productionBackgroundPaint.setColor(Color.argb(40, Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        invalidate();
    }
}
