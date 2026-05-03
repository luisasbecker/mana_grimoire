package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mBarShadowRectBuffer = new RectF();
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        int i2 = 0;
        boolean z = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int iMin = Math.min((int) Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i3 = 0; i3 < iMin; i3++) {
                float x = ((BarEntry) iBarDataSet.getEntryForIndex(i3)).getX();
                this.mBarShadowRectBuffer.top = x - barWidth;
                this.mBarShadowRectBuffer.bottom = x + barWidth;
                transformer.rectValueToPixel(this.mBarShadowRectBuffer);
                if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom)) {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
                    this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
                    canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                }
            }
        }
        Canvas canvas2 = canvas;
        BarBuffer barBuffer = this.mBarBuffers[i];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z2 = iBarDataSet.getColors().size() == 1;
        if (z2) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        while (i2 < barBuffer.size()) {
            int i4 = i2 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i4])) {
                return;
            }
            int i5 = i2 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i5])) {
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i2 / 4));
                }
                int i6 = i2 + 2;
                canvas2.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i5], barBuffer.buffer[i6], barBuffer.buffer[i4], this.mRenderPaint);
                if (z) {
                    canvas.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i5], barBuffer.buffer[i6], barBuffer.buffer[i4], this.mBarBorderPaint);
                }
            }
            i2 += 4;
            canvas2 = canvas;
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        float f;
        MPPointF mPPointF;
        boolean z;
        int i;
        float[] fArr;
        float f2;
        int i2;
        int i3;
        float f3;
        BarEntry barEntry;
        boolean z2;
        int i4;
        int i5;
        List list2;
        float f4;
        BarBuffer barBuffer;
        MPPointF mPPointF2;
        HorizontalBarChartRenderer horizontalBarChartRenderer = this;
        if (horizontalBarChartRenderer.isDrawingValuesAllowed(horizontalBarChartRenderer.mChart)) {
            List dataSets = horizontalBarChartRenderer.mChart.getBarData().getDataSets();
            float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean zIsDrawValueAboveBarEnabled = horizontalBarChartRenderer.mChart.isDrawValueAboveBarEnabled();
            int i6 = 0;
            while (i6 < horizontalBarChartRenderer.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i6);
                if (horizontalBarChartRenderer.shouldDrawValues(iBarDataSet)) {
                    boolean zIsInverted = horizontalBarChartRenderer.mChart.isInverted(iBarDataSet.getAxisDependency());
                    horizontalBarChartRenderer.applyValueTextStyle(iBarDataSet);
                    float f5 = 2.0f;
                    float fCalcTextHeight = Utils.calcTextHeight(horizontalBarChartRenderer.mValuePaint, "10") / 2.0f;
                    ValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer2 = horizontalBarChartRenderer.mBarBuffers[i6];
                    float phaseY = horizontalBarChartRenderer.mAnimator.getPhaseY();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.x = Utils.convertDpToPixel(mPPointF3.x);
                    mPPointF3.y = Utils.convertDpToPixel(mPPointF3.y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        f = fConvertDpToPixel;
                        mPPointF = mPPointF3;
                        Transformer transformer = horizontalBarChartRenderer.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i7 = 0;
                        int length = 0;
                        while (i7 < iBarDataSet.getEntryCount() * horizontalBarChartRenderer.mAnimator.getPhaseX()) {
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i7);
                            int valueTextColor = iBarDataSet.getValueTextColor(i7);
                            float[] yVals = barEntry2.getYVals();
                            if (yVals == null) {
                                int i8 = length + 1;
                                if (!horizontalBarChartRenderer.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i8])) {
                                    break;
                                }
                                if (horizontalBarChartRenderer.mViewPortHandler.isInBoundsX(barBuffer2.buffer[length]) && horizontalBarChartRenderer.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i8])) {
                                    String barLabel = valueFormatter.getBarLabel(barEntry2);
                                    float fCalcTextWidth = Utils.calcTextWidth(horizontalBarChartRenderer.mValuePaint, barLabel);
                                    float f6 = zIsDrawValueAboveBarEnabled ? f : -(fCalcTextWidth + f);
                                    float f7 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth + f) : f;
                                    if (zIsInverted) {
                                        f6 = (-f6) - fCalcTextWidth;
                                        f7 = (-f7) - fCalcTextWidth;
                                    }
                                    float f8 = f6;
                                    float f9 = f7;
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        barEntry = barEntry2;
                                        z = zIsDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        drawValue(canvas, barLabel, barBuffer2.buffer[length + 2] + (barEntry2.getY() >= 0.0f ? f8 : f9), barBuffer2.buffer[i8] + fCalcTextHeight, valueTextColor);
                                    } else {
                                        barEntry = barEntry2;
                                        z = zIsDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() == null || !iBarDataSet.isDrawIconsEnabled()) {
                                        i = i6;
                                    } else {
                                        Drawable icon = barEntry.getIcon();
                                        float f10 = barBuffer2.buffer[length + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f8 = f9;
                                        }
                                        float f11 = barBuffer2.buffer[i8];
                                        i = i6;
                                        Utils.drawImage(canvas, icon, (int) (f10 + f8 + mPPointF.x), (int) (f11 + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                BarEntry barEntry3 = barEntry2;
                                z = zIsDrawValueAboveBarEnabled;
                                i = i6;
                                HorizontalBarChartRenderer horizontalBarChartRenderer2 = horizontalBarChartRenderer;
                                fArr = yVals;
                                int length2 = fArr.length * 2;
                                float[] fArr2 = new float[length2];
                                float f12 = -barEntry3.getNegativeSum();
                                float f13 = 0.0f;
                                int i9 = 0;
                                int i10 = 0;
                                while (i9 < length2) {
                                    float f14 = fArr[i10];
                                    if (f14 == 0.0f && (f13 == 0.0f || f12 == 0.0f)) {
                                        float f15 = f12;
                                        f12 = f14;
                                        f3 = f15;
                                    } else if (f14 >= 0.0f) {
                                        f13 += f14;
                                        f3 = f12;
                                        f12 = f13;
                                    } else {
                                        f3 = f12 - f14;
                                    }
                                    fArr2[i9] = f12 * phaseY;
                                    i9 += 2;
                                    i10++;
                                    f12 = f3;
                                }
                                transformer.pointValuesToPixel(fArr2);
                                int i11 = 0;
                                while (i11 < length2) {
                                    float f16 = fArr[i11 / 2];
                                    BarEntry barEntry4 = barEntry3;
                                    int i12 = i11;
                                    String barStackedLabel = valueFormatter.getBarStackedLabel(f16, barEntry4);
                                    int i13 = length2;
                                    float fCalcTextWidth2 = Utils.calcTextWidth(horizontalBarChartRenderer2.mValuePaint, barStackedLabel);
                                    float f17 = z ? f : -(fCalcTextWidth2 + f);
                                    float[] fArr3 = fArr2;
                                    float f18 = z ? -(fCalcTextWidth2 + f) : f;
                                    if (zIsInverted) {
                                        f17 = (-f17) - fCalcTextWidth2;
                                        f18 = (-f18) - fCalcTextWidth2;
                                    }
                                    boolean z3 = (f16 == 0.0f && f12 == 0.0f && f13 > 0.0f) || f16 < 0.0f;
                                    float f19 = fArr3[i12];
                                    if (z3) {
                                        f17 = f18;
                                    }
                                    float f20 = f19 + f17;
                                    float f21 = (barBuffer2.buffer[length + 1] + barBuffer2.buffer[length + 3]) / 2.0f;
                                    if (!horizontalBarChartRenderer2.mViewPortHandler.isInBoundsTop(f21)) {
                                        break;
                                    }
                                    if (horizontalBarChartRenderer2.mViewPortHandler.isInBoundsX(f20) && horizontalBarChartRenderer2.mViewPortHandler.isInBoundsBottom(f21)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            float f22 = f21 + fCalcTextHeight;
                                            f2 = f21;
                                            HorizontalBarChartRenderer horizontalBarChartRenderer3 = horizontalBarChartRenderer2;
                                            i2 = i12;
                                            barEntry3 = barEntry4;
                                            horizontalBarChartRenderer3.drawValue(canvas, barStackedLabel, f20, f22, valueTextColor);
                                        } else {
                                            f2 = f21;
                                            i2 = i12;
                                            barEntry3 = barEntry4;
                                        }
                                        i3 = valueTextColor;
                                        if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry3.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f20 + mPPointF.x), (int) (f2 + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i3 = valueTextColor;
                                        i2 = i12;
                                        barEntry3 = barEntry4;
                                    }
                                    i11 = i2 + 2;
                                    horizontalBarChartRenderer2 = this;
                                    length2 = i13;
                                    fArr2 = fArr3;
                                    valueTextColor = i3;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i7++;
                            horizontalBarChartRenderer = this;
                            i6 = i;
                            zIsDrawValueAboveBarEnabled = z;
                        }
                    } else {
                        int i14 = 0;
                        while (i14 < barBuffer2.buffer.length * horizontalBarChartRenderer.mAnimator.getPhaseX()) {
                            int i15 = i14 + 1;
                            float f23 = (barBuffer2.buffer[i15] + barBuffer2.buffer[i14 + 3]) / f5;
                            float f24 = f5;
                            if (!horizontalBarChartRenderer.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i15])) {
                                break;
                            }
                            if (horizontalBarChartRenderer.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i14]) && horizontalBarChartRenderer.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i15])) {
                                BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i14 / 4);
                                float y = barEntry5.getY();
                                MPPointF mPPointF4 = mPPointF3;
                                String barLabel2 = valueFormatter.getBarLabel(barEntry5);
                                float fCalcTextWidth3 = Utils.calcTextWidth(horizontalBarChartRenderer.mValuePaint, barLabel2);
                                float f25 = zIsDrawValueAboveBarEnabled ? fConvertDpToPixel : -(fCalcTextWidth3 + fConvertDpToPixel);
                                float f26 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth3 + fConvertDpToPixel) : fConvertDpToPixel;
                                if (zIsInverted) {
                                    f25 = (-f25) - fCalcTextWidth3;
                                    f26 = (-f26) - fCalcTextWidth3;
                                }
                                float f27 = f25;
                                float f28 = f26;
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    float f29 = fConvertDpToPixel;
                                    mPPointF2 = mPPointF4;
                                    f4 = f29;
                                    i5 = i14;
                                    list2 = dataSets;
                                    barBuffer = barBuffer2;
                                    horizontalBarChartRenderer = this;
                                    horizontalBarChartRenderer.drawValue(canvas, barLabel2, barBuffer2.buffer[i14 + 2] + (y >= 0.0f ? f27 : f28), f23 + fCalcTextHeight, iBarDataSet.getValueTextColor(i14 / 2));
                                } else {
                                    horizontalBarChartRenderer = this;
                                    i5 = i14;
                                    list2 = dataSets;
                                    f4 = fConvertDpToPixel;
                                    barBuffer = barBuffer2;
                                    mPPointF2 = mPPointF4;
                                }
                                if (barEntry5.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry5.getIcon();
                                    float f30 = barBuffer.buffer[i5 + 2];
                                    if (y < 0.0f) {
                                        f27 = f28;
                                    }
                                    Utils.drawImage(canvas, icon3, (int) (f30 + f27 + mPPointF2.x), (int) (f23 + mPPointF2.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i5 = i14;
                                list2 = dataSets;
                                f4 = fConvertDpToPixel;
                                barBuffer = barBuffer2;
                                mPPointF2 = mPPointF3;
                            }
                            i14 = i5 + 4;
                            barBuffer2 = barBuffer;
                            mPPointF3 = mPPointF2;
                            f5 = f24;
                            fConvertDpToPixel = f4;
                            dataSets = list2;
                        }
                        list = dataSets;
                        f = fConvertDpToPixel;
                        mPPointF = mPPointF3;
                    }
                    z2 = zIsDrawValueAboveBarEnabled;
                    i4 = i6;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f = fConvertDpToPixel;
                    z2 = zIsDrawValueAboveBarEnabled;
                    i4 = i6;
                }
                i6 = i4 + 1;
                horizontalBarChartRenderer = this;
                fConvertDpToPixel = f;
                dataSets = list;
                zIsDrawValueAboveBarEnabled = z2;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    protected boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f2, f - f4, f3, f + f4);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }
}
