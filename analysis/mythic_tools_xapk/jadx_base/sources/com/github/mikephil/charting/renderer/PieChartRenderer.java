package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.camera.video.AudioStats;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds;
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mDrawCenterTextPathBuffer;
    protected RectF mDrawHighlightedRectF;
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath;
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer;
    private Path mPathBuffer;
    private RectF[] mRectBuffer;
    protected Paint mTransparentCirclePaint;
    protected Paint mValueLinePaint;

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mCenterTextLastBounds = new RectF();
        this.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.mPathBuffer = new Path();
        this.mInnerRectBuffer = new RectF();
        this.mHoleCirclePath = new Path();
        this.mDrawCenterTextPathBuffer = new Path();
        this.mDrawHighlightedRectF = new RectF();
        this.mChart = pieChart;
        Paint paint = new Paint(1);
        this.mHolePaint = paint;
        paint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mTransparentCirclePaint = paint2;
        paint2.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.mCenterTextPaint = textPaint;
        textPaint.setColor(-16777216);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.mEntryLabelsPaint = paint3;
        paint3.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        Paint paint4 = new Paint(1);
        this.mValueLinePaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    protected float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f, float f2, float f3, float f4, float f5, float f6) {
        double d = (f5 + f6) * 0.017453292f;
        float fCos = mPPointF.x + (((float) Math.cos(d)) * f);
        float fSin = mPPointF.y + (((float) Math.sin(d)) * f);
        double d2 = (f5 + (f6 / 2.0f)) * 0.017453292f;
        return (float) (((double) (f - ((float) ((Math.sqrt(Math.pow(fCos - f3, 2.0d) + Math.pow(fSin - f4, 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f2)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((mPPointF.x + (((float) Math.cos(d2)) * f)) - ((fCos + f3) / 2.0f), 2.0d) + Math.pow((mPPointF.y + (((float) Math.sin(d2)) * f)) - ((fSin + f4) / 2.0f), 2.0d)));
    }

    protected void drawCenterText(Canvas canvas) {
        CharSequence centerText = this.mChart.getCenterText();
        if (!this.mChart.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        MPPointF centerTextOffset = this.mChart.getCenterTextOffset();
        float f = centerCircleBox.x + centerTextOffset.x;
        float f2 = centerCircleBox.y + centerTextOffset.y;
        float radius = (!this.mChart.isDrawHoleEnabled() || this.mChart.isDrawSlicesUnderHoleEnabled()) ? this.mChart.getRadius() : this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
        RectF rectF = this.mRectBuffer[0];
        rectF.left = f - radius;
        rectF.top = f2 - radius;
        rectF.right = f + radius;
        rectF.bottom = f2 + radius;
        RectF rectF2 = this.mRectBuffer[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > AudioStats.AUDIO_AMPLITUDE_NONE) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (!centerText.equals(this.mCenterTextLastValue) || !rectF2.equals(this.mCenterTextLastBounds)) {
            this.mCenterTextLastBounds.set(rectF2);
            this.mCenterTextLastValue = centerText;
            this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.mCenterTextLayout.getHeight();
        canvas.save();
        Path path = this.mDrawCenterTextPathBuffer;
        path.reset();
        path.addOval(rectF, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.mCenterTextLayout.draw(canvas);
        canvas.restore();
        MPPointF.recycleInstance(centerCircleBox);
        MPPointF.recycleInstance(centerTextOffset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != chartWidth || bitmapCreateBitmap.getHeight() != chartHeight) {
            if (chartWidth <= 0 || chartHeight <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444);
            this.mDrawBitmap = new WeakReference<>(bitmapCreateBitmap);
            this.mBitmapCanvas = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    protected void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        float f;
        int i;
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        int i3;
        RectF rectF;
        float f6;
        float f7;
        int i4;
        float f8;
        float f9;
        int i5;
        int i6;
        float fMax;
        PieChartRenderer pieChartRenderer = this;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = pieChartRenderer.mChart.getRotationAngle();
        float phaseX = pieChartRenderer.mAnimator.getPhaseX();
        float phaseY = pieChartRenderer.mAnimator.getPhaseY();
        RectF circleBox = pieChartRenderer.mChart.getCircleBox();
        int entryCount = iPieDataSet2.getEntryCount();
        float[] drawAngles = pieChartRenderer.mChart.getDrawAngles();
        MPPointF centerCircleBox = pieChartRenderer.mChart.getCenterCircleBox();
        float radius = pieChartRenderer.mChart.getRadius();
        boolean z = pieChartRenderer.mChart.isDrawHoleEnabled() && !pieChartRenderer.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (pieChartRenderer.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((pieChartRenderer.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF2 = new RectF();
        boolean z2 = z && pieChartRenderer.mChart.isDrawRoundedSlicesEnabled();
        int i7 = 0;
        for (int i8 = 0; i8 < entryCount; i8++) {
            if (Math.abs(iPieDataSet2.getEntryForIndex(i8).getY()) > Utils.FLOAT_EPSILON) {
                i7++;
            }
        }
        float sliceSpace = i7 <= 1 ? 0.0f : pieChartRenderer.getSliceSpace(iPieDataSet2);
        float f10 = 0.0f;
        int i9 = 0;
        while (i9 < entryCount) {
            float f11 = drawAngles[i9];
            if (Math.abs(iPieDataSet2.getEntryForIndex(i9).getY()) > Utils.FLOAT_EPSILON && (!pieChartRenderer.mChart.needsHighlight(i9) || z2)) {
                boolean z3 = sliceSpace > 0.0f && f11 <= 180.0f;
                f = holeRadius;
                pieChartRenderer.mRenderPaint.setColor(iPieDataSet2.getColor(i9));
                float f12 = i7 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f13 = rotationAngle + ((f10 + (f12 / 2.0f)) * phaseY);
                float f14 = (f11 - f12) * phaseY;
                if (f14 < 0.0f) {
                    f14 = 0.0f;
                }
                i = i9;
                pieChartRenderer.mPathBuffer.reset();
                if (z2) {
                    float f15 = radius - holeRadius2;
                    i2 = i7;
                    double d = f13 * 0.017453292f;
                    float fCos = centerCircleBox.x + (((float) Math.cos(d)) * f15);
                    float fSin = centerCircleBox.y + (f15 * ((float) Math.sin(d)));
                    f2 = rotationAngle;
                    rectF2.set(fCos - holeRadius2, fSin - holeRadius2, fCos + holeRadius2, fSin + holeRadius2);
                } else {
                    i2 = i7;
                    f2 = rotationAngle;
                }
                double d2 = f13 * 0.017453292f;
                float fCos2 = (((float) Math.cos(d2)) * radius) + centerCircleBox.x;
                float fSin2 = centerCircleBox.y + (((float) Math.sin(d2)) * radius);
                int i10 = (f14 > 360.0f ? 1 : (f14 == 360.0f ? 0 : -1));
                if (i10 < 0 || f14 % 360.0f > Utils.FLOAT_EPSILON) {
                    f3 = fCos2;
                    f4 = fSin2;
                    f5 = 360.0f;
                    i3 = i10;
                    if (z2) {
                        pieChartRenderer.mPathBuffer.arcTo(rectF2, f13 + 180.0f, -180.0f);
                    }
                    pieChartRenderer.mPathBuffer.arcTo(circleBox, f13, f14);
                } else {
                    f5 = 360.0f;
                    f3 = fCos2;
                    f4 = fSin2;
                    i3 = i10;
                    pieChartRenderer.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, radius, Path.Direction.CW);
                }
                pieChartRenderer.mInnerRectBuffer.set(centerCircleBox.x - f, centerCircleBox.y - f, centerCircleBox.x + f, centerCircleBox.y + f);
                if (!z || (f <= 0.0f && !z3)) {
                    pieChartRenderer = this;
                    rectF = rectF2;
                    float f16 = f14;
                    f6 = phaseX;
                    f7 = phaseY;
                    i4 = i2;
                    float f17 = f3;
                    float f18 = f4;
                    if (f16 % f5 > Utils.FLOAT_EPSILON) {
                        if (z3) {
                            float fCalculateMinimumRadiusForSpacedSlice = pieChartRenderer.calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f11 * f7, f17, f18, f13, f16);
                            double d3 = (f13 + (f16 / 2.0f)) * 0.017453292f;
                            pieChartRenderer.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d3)) * fCalculateMinimumRadiusForSpacedSlice), centerCircleBox.y + (fCalculateMinimumRadiusForSpacedSlice * ((float) Math.sin(d3))));
                        } else {
                            pieChartRenderer.mPathBuffer.lineTo(centerCircleBox.x, centerCircleBox.y);
                        }
                    }
                } else {
                    if (z3) {
                        rectF = rectF2;
                        f8 = f14;
                        f6 = phaseX;
                        f9 = f;
                        i5 = i2;
                        i6 = 1;
                        pieChartRenderer = this;
                        float fCalculateMinimumRadiusForSpacedSlice2 = pieChartRenderer.calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f11 * phaseY, f3, f4, f13, f8);
                        if (fCalculateMinimumRadiusForSpacedSlice2 < 0.0f) {
                            fCalculateMinimumRadiusForSpacedSlice2 = -fCalculateMinimumRadiusForSpacedSlice2;
                        }
                        fMax = Math.max(f9, fCalculateMinimumRadiusForSpacedSlice2);
                    } else {
                        pieChartRenderer = this;
                        rectF = rectF2;
                        f8 = f14;
                        f6 = phaseX;
                        f9 = f;
                        i5 = i2;
                        i6 = 1;
                        fMax = f9;
                    }
                    float f19 = (i5 == i6 || fMax == 0.0f) ? 0.0f : sliceSpace / (fMax * 0.017453292f);
                    float f20 = f2 + ((f10 + (f19 / 2.0f)) * phaseY);
                    float f21 = (f11 - f19) * phaseY;
                    if (f21 < 0.0f) {
                        f21 = 0.0f;
                    }
                    float f22 = f20 + f21;
                    if (i3 < 0 || f8 % f5 > Utils.FLOAT_EPSILON) {
                        if (z2) {
                            float f23 = radius - holeRadius2;
                            f7 = phaseY;
                            double d4 = f22 * 0.017453292f;
                            float fCos3 = centerCircleBox.x + (f23 * ((float) Math.cos(d4)));
                            float fSin3 = centerCircleBox.y + (((float) Math.sin(d4)) * f23);
                            rectF.set(fCos3 - holeRadius2, fSin3 - holeRadius2, fCos3 + holeRadius2, fSin3 + holeRadius2);
                            pieChartRenderer.mPathBuffer.arcTo(rectF, f22, 180.0f);
                            f = f9;
                        } else {
                            f7 = phaseY;
                            double d5 = f22 * 0.017453292f;
                            f = f9;
                            pieChartRenderer.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d5)) * fMax), centerCircleBox.y + (fMax * ((float) Math.sin(d5))));
                        }
                        pieChartRenderer.mPathBuffer.arcTo(pieChartRenderer.mInnerRectBuffer, f22, -f21);
                    } else {
                        pieChartRenderer.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, fMax, Path.Direction.CCW);
                        f = f9;
                        f7 = phaseY;
                    }
                    i4 = i5;
                }
                pieChartRenderer.mPathBuffer.close();
                pieChartRenderer.mBitmapCanvas.drawPath(pieChartRenderer.mPathBuffer, pieChartRenderer.mRenderPaint);
                f10 += f11 * f6;
            } else {
                f10 += f11 * phaseX;
                f = holeRadius;
                i = i9;
                i4 = i7;
                f2 = rotationAngle;
                f6 = phaseX;
                f7 = phaseY;
                rectF = rectF2;
            }
            i9 = i + 1;
            i7 = i4;
            rectF2 = rectF;
            phaseX = f6;
            holeRadius = f;
            phaseY = f7;
            rotationAngle = f2;
            iPieDataSet2 = iPieDataSet;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawEntryLabel(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.mEntryLabelsPaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float f;
        float f2;
        RectF rectF;
        int i;
        IPieDataSet dataSetByIndex;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float fCalculateMinimumRadiusForSpacedSlice;
        float fMax;
        Highlight[] highlightArr2 = highlightArr;
        boolean z = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        if (z && this.mChart.isDrawRoundedSlicesEnabled()) {
            return;
        }
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float f9 = 0.0f;
        float holeRadius = z ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.mDrawHighlightedRectF;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i2 = 0;
        while (i2 < highlightArr2.length) {
            int x = (int) highlightArr2[i2].getX();
            float f10 = f9;
            if (x < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i2].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i3 = 0;
                for (int i4 = 0; i4 < entryCount; i4++) {
                    if (Math.abs(dataSetByIndex.getEntryForIndex(i4).getY()) > Utils.FLOAT_EPSILON) {
                        i3++;
                    }
                }
                float f11 = x == 0 ? f10 : absoluteAngles[x - 1] * phaseX;
                float sliceSpace = i3 <= 1 ? f10 : dataSetByIndex.getSliceSpace();
                float f12 = drawAngles[x];
                float f13 = radius;
                float selectionShift = dataSetByIndex.getSelectionShift();
                float f14 = holeRadius;
                float f15 = f13 + selectionShift;
                i = i2;
                rectF2.set(this.mChart.getCircleBox());
                float f16 = -selectionShift;
                rectF2.inset(f16, f16);
                boolean z2 = sliceSpace > f10 && f12 <= 180.0f;
                this.mRenderPaint.setColor(dataSetByIndex.getColor(x));
                float f17 = i3 == 1 ? f10 : sliceSpace / (f13 * 0.017453292f);
                float f18 = i3 == 1 ? f10 : sliceSpace / (f15 * 0.017453292f);
                float f19 = (((f17 / 2.0f) + f11) * phaseY) + rotationAngle;
                float f20 = (f12 - f17) * phaseY;
                float f21 = f20 < f10 ? f10 : f20;
                float f22 = (((f18 / 2.0f) + f11) * phaseY) + rotationAngle;
                float f23 = (f12 - f18) * phaseY;
                if (f23 < f10) {
                    f23 = f10;
                }
                this.mPathBuffer.reset();
                if (f21 < 360.0f || f21 % 360.0f > Utils.FLOAT_EPSILON) {
                    f3 = f21;
                    f4 = f11;
                    f5 = sliceSpace;
                    double d = f22 * 0.017453292f;
                    this.mPathBuffer.moveTo(centerCircleBox.x + (((float) Math.cos(d)) * f15), centerCircleBox.y + (((float) Math.sin(d)) * f15));
                    this.mPathBuffer.arcTo(rectF2, f22, f23);
                } else {
                    f3 = f21;
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f15, Path.Direction.CW);
                    f4 = f11;
                    f5 = sliceSpace;
                }
                if (z2) {
                    double d2 = f19 * 0.017453292f;
                    float fCos = (((float) Math.cos(d2)) * f13) + centerCircleBox.x;
                    float fSin = centerCircleBox.y + (((float) Math.sin(d2)) * f13);
                    f7 = f13;
                    rectF = rectF2;
                    f6 = f10;
                    f2 = f14;
                    f8 = f19;
                    fCalculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, f7, f12 * phaseY, fCos, fSin, f8, f3);
                } else {
                    f6 = f10;
                    f7 = f13;
                    f2 = f14;
                    f8 = f19;
                    rectF = rectF2;
                    fCalculateMinimumRadiusForSpacedSlice = f6;
                }
                f10 = f6;
                f = f7;
                this.mInnerRectBuffer.set(centerCircleBox.x - f2, centerCircleBox.y - f2, centerCircleBox.x + f2, centerCircleBox.y + f2);
                if (z && (f2 > f10 || z2)) {
                    if (z2) {
                        if (fCalculateMinimumRadiusForSpacedSlice < f10) {
                            fCalculateMinimumRadiusForSpacedSlice = -fCalculateMinimumRadiusForSpacedSlice;
                        }
                        fMax = Math.max(f2, fCalculateMinimumRadiusForSpacedSlice);
                    } else {
                        fMax = f2;
                    }
                    float f24 = (i3 == 1 || fMax == f10) ? f10 : f5 / (fMax * 0.017453292f);
                    float f25 = ((f4 + (f24 / 2.0f)) * phaseY) + rotationAngle;
                    float f26 = (f12 - f24) * phaseY;
                    if (f26 < f10) {
                        f26 = f10;
                    }
                    float f27 = f25 + f26;
                    if (f21 < 360.0f || f3 % 360.0f > Utils.FLOAT_EPSILON) {
                        double d3 = f27 * 0.017453292f;
                        this.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d3)) * fMax), centerCircleBox.y + (fMax * ((float) Math.sin(d3))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f27, -f26);
                    } else {
                        this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, fMax, Path.Direction.CCW);
                    }
                } else if (f3 % 360.0f > Utils.FLOAT_EPSILON) {
                    if (z2) {
                        double d4 = (f8 + (f3 / 2.0f)) * 0.017453292f;
                        this.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d4)) * fCalculateMinimumRadiusForSpacedSlice), centerCircleBox.y + (fCalculateMinimumRadiusForSpacedSlice * ((float) Math.sin(d4))));
                    } else {
                        this.mPathBuffer.lineTo(centerCircleBox.x, centerCircleBox.y);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                f = radius;
                f2 = holeRadius;
                rectF = rectF2;
                i = i2;
            }
            i2 = i + 1;
            f9 = f10;
            highlightArr2 = highlightArr;
            holeRadius = f2;
            rectF2 = rectF;
            radius = f;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawHole(Canvas canvas) {
        if (!this.mChart.isDrawHoleEnabled() || this.mBitmapCanvas == null) {
            return;
        }
        float radius = this.mChart.getRadius();
        float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        if (Color.alpha(this.mHolePaint.getColor()) > 0) {
            this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, this.mHolePaint);
        }
        if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
            int alpha = this.mTransparentCirclePaint.getAlpha();
            float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
            this.mTransparentCirclePaint.setAlpha((int) (alpha * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
            this.mHoleCirclePath.reset();
            this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, transparentCircleRadius, Path.Direction.CW);
            this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, Path.Direction.CCW);
            this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
            this.mTransparentCirclePaint.setAlpha(alpha);
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawRoundedSlices(Canvas canvas) {
        float f;
        float f2;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i = 0;
                while (i < dataSet.getEntryCount()) {
                    float f3 = drawAngles[i];
                    if (Math.abs(dataSet.getEntryForIndex(i).getY()) > Utils.FLOAT_EPSILON) {
                        double d = radius - holeRadius;
                        double d2 = (rotationAngle + f3) * phaseY;
                        f = phaseX;
                        f2 = phaseY;
                        float fCos = (float) (((double) centerCircleBox.x) + (Math.cos(Math.toRadians(d2)) * d));
                        float fSin = (float) ((d * Math.sin(Math.toRadians(d2))) + ((double) centerCircleBox.y));
                        this.mRenderPaint.setColor(dataSet.getColor(i));
                        this.mBitmapCanvas.drawCircle(fCos, fSin, holeRadius, this.mRenderPaint);
                    } else {
                        f = phaseX;
                        f2 = phaseY;
                    }
                    rotationAngle += f3 * f;
                    i++;
                    phaseX = f;
                    phaseY = f2;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x007d A[PHI: r3
      0x007d: PHI (r3v5 float) = (r3v4 float), (r3v37 float), (r3v37 float) binds: [B:3:0x0051, B:5:0x005e, B:7:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drawValues(Canvas canvas) {
        float f;
        float f2;
        List<IPieDataSet> list;
        int i;
        float f3;
        float[] fArr;
        float[] fArr2;
        float f4;
        float f5;
        PieDataSet.ValuePosition valuePosition;
        PieDataSet.ValuePosition valuePosition2;
        float fAbs;
        PieDataSet.ValuePosition valuePosition3;
        float f6;
        float f7;
        float f8;
        boolean z;
        float f9;
        MPPointF mPPointF;
        String str;
        float f10;
        IPieDataSet iPieDataSet;
        String str2;
        PieChartRenderer pieChartRenderer = this;
        MPPointF centerCircleBox = pieChartRenderer.mChart.getCenterCircleBox();
        float radius = pieChartRenderer.mChart.getRadius();
        float rotationAngle = pieChartRenderer.mChart.getRotationAngle();
        float[] drawAngles = pieChartRenderer.mChart.getDrawAngles();
        float[] absoluteAngles = pieChartRenderer.mChart.getAbsoluteAngles();
        float phaseX = pieChartRenderer.mAnimator.getPhaseX();
        float phaseY = pieChartRenderer.mAnimator.getPhaseY();
        float holeRadius = (radius - ((pieChartRenderer.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        float holeRadius2 = pieChartRenderer.mChart.getHoleRadius() / 100.0f;
        float f11 = (radius / 10.0f) * 3.6f;
        if (pieChartRenderer.mChart.isDrawHoleEnabled()) {
            f11 = (radius - (radius * holeRadius2)) / 2.0f;
            if (pieChartRenderer.mChart.isDrawSlicesUnderHoleEnabled() || !pieChartRenderer.mChart.isDrawRoundedSlicesEnabled()) {
                f = 100.0f;
                f2 = 2.0f;
            } else {
                f = 100.0f;
                f2 = 2.0f;
                rotationAngle = (float) (((double) rotationAngle) + (((double) (holeRadius * 360.0f)) / (((double) radius) * 6.283185307179586d)));
            }
        }
        float f12 = rotationAngle;
        float f13 = radius - f11;
        PieData pieData = (PieData) pieChartRenderer.mChart.getData();
        List<IPieDataSet> dataSets = pieData.getDataSets();
        float yValueSum = pieData.getYValueSum();
        boolean zIsDrawEntryLabelsEnabled = pieChartRenderer.mChart.isDrawEntryLabelsEnabled();
        canvas.save();
        float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i2 = 0;
        int i3 = 0;
        while (i2 < dataSets.size()) {
            IPieDataSet iPieDataSet2 = dataSets.get(i2);
            boolean zIsDrawValuesEnabled = iPieDataSet2.isDrawValuesEnabled();
            if (zIsDrawValuesEnabled || zIsDrawEntryLabelsEnabled) {
                PieDataSet.ValuePosition xValuePosition = iPieDataSet2.getXValuePosition();
                PieDataSet.ValuePosition yValuePosition = iPieDataSet2.getYValuePosition();
                pieChartRenderer.applyValueTextStyle(iPieDataSet2);
                list = dataSets;
                i = i2;
                float fCalcTextHeight = Utils.calcTextHeight(pieChartRenderer.mValuePaint, "Q") + Utils.convertDpToPixel(4.0f);
                ValueFormatter valueFormatter = iPieDataSet2.getValueFormatter();
                int entryCount = iPieDataSet2.getEntryCount();
                int i4 = i3;
                f3 = radius;
                pieChartRenderer.mValueLinePaint.setColor(iPieDataSet2.getValueLineColor());
                pieChartRenderer.mValueLinePaint.setStrokeWidth(Utils.convertDpToPixel(iPieDataSet2.getValueLineWidth()));
                float sliceSpace = pieChartRenderer.getSliceSpace(iPieDataSet2);
                MPPointF mPPointF2 = MPPointF.getInstance(iPieDataSet2.getIconsOffset());
                mPPointF2.x = Utils.convertDpToPixel(mPPointF2.x);
                mPPointF2.y = Utils.convertDpToPixel(mPPointF2.y);
                int i5 = 0;
                while (i5 < entryCount) {
                    float[] fArr3 = drawAngles;
                    PieEntry entryForIndex = iPieDataSet2.getEntryForIndex(i5);
                    int i6 = entryCount;
                    float f14 = f12 + (((i4 == 0 ? 0.0f : absoluteAngles[i4 - 1] * phaseX) + ((fArr3[i4] - ((sliceSpace / (f13 * 0.017453292f)) / f2)) / f2)) * phaseY);
                    MPPointF mPPointF3 = mPPointF2;
                    String pieLabel = valueFormatter.getPieLabel(pieChartRenderer.mChart.isUsePercentValuesEnabled() ? (entryForIndex.getY() / yValueSum) * f : entryForIndex.getY(), entryForIndex);
                    String label = entryForIndex.getLabel();
                    ValueFormatter valueFormatter2 = valueFormatter;
                    float[] fArr4 = absoluteAngles;
                    double d = f14 * 0.017453292f;
                    float fCos = (float) Math.cos(d);
                    float fSin = (float) Math.sin(d);
                    boolean z2 = zIsDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    boolean z3 = zIsDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    boolean z4 = zIsDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    boolean z5 = zIsDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    if (z2 || z3) {
                        float valueLinePart1Length = iPieDataSet2.getValueLinePart1Length();
                        float valueLinePart2Length = iPieDataSet2.getValueLinePart2Length();
                        float valueLinePart1OffsetPercentage = iPieDataSet2.getValueLinePart1OffsetPercentage() / f;
                        if (pieChartRenderer.mChart.isDrawHoleEnabled()) {
                            float f15 = f3 * holeRadius2;
                            f5 = ((f3 - f15) * valueLinePart1OffsetPercentage) + f15;
                        } else {
                            f5 = f3 * valueLinePart1OffsetPercentage;
                        }
                        if (iPieDataSet2.isValueLineVariableLength()) {
                            valuePosition = xValuePosition;
                            valuePosition2 = yValuePosition;
                            fAbs = valueLinePart2Length * f13 * ((float) Math.abs(Math.sin(d)));
                        } else {
                            valuePosition = xValuePosition;
                            valuePosition2 = yValuePosition;
                            fAbs = valueLinePart2Length * f13;
                        }
                        float f16 = (f5 * fCos) + centerCircleBox.x;
                        float f17 = (f5 * fSin) + centerCircleBox.y;
                        float f18 = (valueLinePart1Length + 1.0f) * f13;
                        valuePosition3 = valuePosition;
                        float f19 = (f18 * fCos) + centerCircleBox.x;
                        float f20 = (f18 * fSin) + centerCircleBox.y;
                        double d2 = ((double) f14) % 360.0d;
                        if (d2 < 90.0d || d2 > 270.0d) {
                            f6 = f19 + fAbs;
                            pieChartRenderer.mValuePaint.setTextAlign(Paint.Align.LEFT);
                            if (z2) {
                                pieChartRenderer.mEntryLabelsPaint.setTextAlign(Paint.Align.LEFT);
                            }
                            f7 = f6 + fConvertDpToPixel;
                        } else {
                            f6 = f19 - fAbs;
                            pieChartRenderer.mValuePaint.setTextAlign(Paint.Align.RIGHT);
                            if (z2) {
                                pieChartRenderer.mEntryLabelsPaint.setTextAlign(Paint.Align.RIGHT);
                            }
                            f7 = f6 - fConvertDpToPixel;
                        }
                        float f21 = f7;
                        if (iPieDataSet2.getValueLineColor() != 1122867) {
                            if (iPieDataSet2.isUsingSliceColorAsValueLineColor()) {
                                pieChartRenderer.mValueLinePaint.setColor(iPieDataSet2.getColor(i5));
                            }
                            f8 = f20;
                            float f22 = phaseX;
                            str = label;
                            f9 = f22;
                            iPieDataSet = iPieDataSet2;
                            z = z2;
                            mPPointF = mPPointF3;
                            f10 = fSin;
                            canvas.drawLine(f16, f17, f19, f8, pieChartRenderer.mValueLinePaint);
                            canvas.drawLine(f19, f8, f6, f8, pieChartRenderer.mValueLinePaint);
                        } else {
                            f8 = f20;
                            z = z2;
                            f9 = phaseX;
                            mPPointF = mPPointF3;
                            str = label;
                            f10 = fSin;
                            iPieDataSet = iPieDataSet2;
                        }
                        if (z && z3) {
                            float f23 = f8;
                            str2 = pieLabel;
                            pieChartRenderer.drawValue(canvas, str2, f21, f23, iPieDataSet.getValueTextColor(i5));
                            if (i5 < pieData.getEntryCount() && str != null) {
                                pieChartRenderer.drawEntryLabel(canvas, str, f21, f23 + fCalcTextHeight);
                            }
                        } else {
                            str2 = pieLabel;
                            if (z) {
                                if (i5 < pieData.getEntryCount() && str != null) {
                                    pieChartRenderer.drawEntryLabel(canvas, str, f21, f8 + (fCalcTextHeight / f2));
                                }
                            } else if (z3) {
                                pieChartRenderer.drawValue(canvas, str2, f21, (fCalcTextHeight / f2) + f8, iPieDataSet.getValueTextColor(i5));
                            }
                        }
                    } else {
                        valuePosition3 = xValuePosition;
                        valuePosition2 = yValuePosition;
                        f9 = phaseX;
                        mPPointF = mPPointF3;
                        str2 = pieLabel;
                        str = label;
                        f10 = fSin;
                        iPieDataSet = iPieDataSet2;
                    }
                    if (z4 || z5) {
                        float f24 = centerCircleBox.x + (f13 * fCos);
                        float f25 = centerCircleBox.y + (f13 * f10);
                        pieChartRenderer.mValuePaint.setTextAlign(Paint.Align.CENTER);
                        if (z4 && z5) {
                            pieChartRenderer.drawValue(canvas, str2, f24, f25, iPieDataSet.getValueTextColor(i5));
                            if (i5 < pieData.getEntryCount() && str != null) {
                                pieChartRenderer.drawEntryLabel(canvas, str, f24, f25 + fCalcTextHeight);
                            }
                        } else if (z4) {
                            if (i5 < pieData.getEntryCount() && str != null) {
                                pieChartRenderer.drawEntryLabel(canvas, str, f24, f25 + (fCalcTextHeight / f2));
                            }
                        } else if (z5) {
                            pieChartRenderer.drawValue(canvas, str2, f24, f25 + (fCalcTextHeight / f2), iPieDataSet.getValueTextColor(i5));
                        }
                    }
                    if (entryForIndex.getIcon() != null && iPieDataSet.isDrawIconsEnabled()) {
                        Drawable icon = entryForIndex.getIcon();
                        Utils.drawImage(canvas, icon, (int) (((mPPointF.y + f13) * fCos) + centerCircleBox.x), (int) (((mPPointF.y + f13) * f10) + centerCircleBox.y + mPPointF.x), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                    }
                    i4++;
                    i5++;
                    pieChartRenderer = this;
                    iPieDataSet2 = iPieDataSet;
                    mPPointF2 = mPPointF;
                    drawAngles = fArr3;
                    entryCount = i6;
                    absoluteAngles = fArr4;
                    valueFormatter = valueFormatter2;
                    xValuePosition = valuePosition3;
                    yValuePosition = valuePosition2;
                    phaseX = f9;
                }
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f4 = phaseX;
                MPPointF.recycleInstance(mPPointF2);
                i3 = i4;
            } else {
                list = dataSets;
                i = i2;
                f3 = radius;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f4 = phaseX;
            }
            i2 = i + 1;
            pieChartRenderer = this;
            dataSets = list;
            radius = f3;
            drawAngles = fArr;
            absoluteAngles = fArr2;
            phaseX = f4;
        }
        MPPointF.recycleInstance(centerCircleBox);
        canvas.restore();
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected float getSliceSpace(IPieDataSet iPieDataSet) {
        if (iPieDataSet.isAutomaticallyDisableSliceSpacingEnabled() && iPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > (iPieDataSet.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.getSliceSpace();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
