package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LegendRenderer extends Renderer {
    protected List<LegendEntry> computedEntries;
    protected Paint.FontMetrics legendFontMetrics;
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;
    private Path mLineFormPath;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.computedEntries = new ArrayList(16);
        this.legendFontMetrics = new Paint.FontMetrics();
        this.mLineFormPath = new Path();
        this.mLegend = legend;
        Paint paint = new Paint(1);
        this.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void computeLegend(ChartData<?> chartData) {
        if (!this.mLegend.isLegendCustom()) {
            this.computedEntries.clear();
            for (int i = 0; i < chartData.getDataSetCount(); i++) {
                IDataSet dataSetByIndex = chartData.getDataSetByIndex(i);
                List<Integer> colors = dataSetByIndex.getColors();
                int entryCount = dataSetByIndex.getEntryCount();
                if (dataSetByIndex instanceof IBarDataSet) {
                    IBarDataSet iBarDataSet = (IBarDataSet) dataSetByIndex;
                    if (iBarDataSet.isStacked()) {
                        String[] stackLabels = iBarDataSet.getStackLabels();
                        for (int i2 = 0; i2 < colors.size() && i2 < iBarDataSet.getStackSize(); i2++) {
                            this.computedEntries.add(new LegendEntry(stackLabels[i2 % stackLabels.length], dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i2).intValue()));
                        }
                        if (iBarDataSet.getLabel() != null) {
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                        }
                    } else if (dataSetByIndex instanceof IPieDataSet) {
                        IPieDataSet iPieDataSet = (IPieDataSet) dataSetByIndex;
                        for (int i3 = 0; i3 < colors.size() && i3 < entryCount; i3++) {
                            this.computedEntries.add(new LegendEntry(iPieDataSet.getEntryForIndex(i3).getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i3).intValue()));
                        }
                        if (iPieDataSet.getLabel() != null) {
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                        }
                    } else if (dataSetByIndex instanceof ICandleDataSet) {
                        ICandleDataSet iCandleDataSet = (ICandleDataSet) dataSetByIndex;
                        if (iCandleDataSet.getDecreasingColor() != 1122867) {
                            int decreasingColor = iCandleDataSet.getDecreasingColor();
                            int increasingColor = iCandleDataSet.getIncreasingColor();
                            this.computedEntries.add(new LegendEntry(null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), decreasingColor));
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), increasingColor));
                        } else {
                            int i4 = 0;
                            while (i4 < colors.size() && i4 < entryCount) {
                                this.computedEntries.add(new LegendEntry((i4 >= colors.size() + (-1) || i4 >= entryCount + (-1)) ? chartData.getDataSetByIndex(i).getLabel() : null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i4).intValue()));
                                i4++;
                            }
                        }
                    }
                }
            }
            if (this.mLegend.getExtraEntries() != null) {
                Collections.addAll(this.computedEntries, this.mLegend.getExtraEntries());
            }
            this.mLegend.setEntries(this.computedEntries);
        }
        Typeface typeface = this.mLegend.getTypeface();
        if (typeface != null) {
            this.mLegendLabelPaint.setTypeface(typeface);
        }
        this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
        this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
        this.mLegend.calculateDimensions(this.mLegendLabelPaint, this.mViewPortHandler);
    }

    protected void drawForm(Canvas canvas, float f, float f2, LegendEntry legendEntry, Legend legend) {
        Canvas canvas2;
        if (legendEntry.formColor == 1122868 || legendEntry.formColor == 1122867 || legendEntry.formColor == 0) {
            return;
        }
        int iSave = canvas.save();
        Legend.LegendForm form = legendEntry.form;
        if (form == Legend.LegendForm.DEFAULT) {
            form = legend.getForm();
        }
        this.mLegendFormPaint.setColor(legendEntry.formColor);
        float fConvertDpToPixel = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? legend.getFormSize() : legendEntry.formSize);
        float f3 = fConvertDpToPixel / 2.0f;
        int i = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[form.ordinal()];
        if (i == 3 || i == 4) {
            canvas2 = canvas;
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas2.drawCircle(f + f3, f2, f3, this.mLegendFormPaint);
        } else if (i != 5) {
            if (i == 6) {
                float fConvertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formLineWidth) ? legend.getFormLineWidth() : legendEntry.formLineWidth);
                DashPathEffect formLineDashEffect = legendEntry.formLineDashEffect == null ? legend.getFormLineDashEffect() : legendEntry.formLineDashEffect;
                this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
                this.mLegendFormPaint.setStrokeWidth(fConvertDpToPixel2);
                this.mLegendFormPaint.setPathEffect(formLineDashEffect);
                this.mLineFormPath.reset();
                this.mLineFormPath.moveTo(f, f2);
                this.mLineFormPath.lineTo(f + fConvertDpToPixel, f2);
                canvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
            }
            canvas2 = canvas;
        } else {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas2 = canvas;
            canvas2.drawRect(f, f2 - f3, f + fConvertDpToPixel, f2 + f3, this.mLegendFormPaint);
        }
        canvas2.restoreToCount(iSave);
    }

    protected void drawLabel(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.mLegendLabelPaint);
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public void renderLegend(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float chartWidth;
        int i;
        List<Boolean> list;
        int i2;
        List<FSize> list2;
        Canvas canvas2;
        List<FSize> list3;
        float fContentTop;
        int i3;
        float f4;
        Canvas canvas3;
        float fCalcTextWidth;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
            float fCalcTextHeight = lineHeight - (Utils.calcTextHeight(this.mLegendLabelPaint, "ABC") / 2.0f);
            LegendEntry[] entries = this.mLegend.getEntries();
            float fConvertDpToPixel = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
            float fConvertDpToPixel2 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
            Legend.LegendOrientation orientation = this.mLegend.getOrientation();
            Legend.LegendHorizontalAlignment horizontalAlignment = this.mLegend.getHorizontalAlignment();
            Legend.LegendVerticalAlignment verticalAlignment = this.mLegend.getVerticalAlignment();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float fConvertDpToPixel3 = Utils.convertDpToPixel(this.mLegend.getFormSize());
            float fConvertDpToPixel4 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            int i4 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[horizontalAlignment.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    f = fConvertDpToPixel4;
                    f2 = lineSpacing;
                    chartWidth = (orientation == Legend.LegendOrientation.VERTICAL ? this.mViewPortHandler.getChartWidth() : this.mViewPortHandler.contentRight()) - xOffset;
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        chartWidth -= this.mLegend.mNeededWidth;
                    }
                } else if (i4 != 3) {
                    f = fConvertDpToPixel4;
                    f2 = lineSpacing;
                    f3 = 0.0f;
                } else {
                    chartWidth = (orientation == Legend.LegendOrientation.VERTICAL ? this.mViewPortHandler.getChartWidth() / 2.0f : this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f)) + (direction == Legend.LegendDirection.LEFT_TO_RIGHT ? xOffset : -xOffset);
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        f2 = lineSpacing;
                        double d = chartWidth;
                        Legend.LegendDirection legendDirection = Legend.LegendDirection.LEFT_TO_RIGHT;
                        f = fConvertDpToPixel4;
                        Legend legend = this.mLegend;
                        chartWidth = (float) (d + (direction == legendDirection ? (((double) (-legend.mNeededWidth)) / 2.0d) + ((double) xOffset) : (((double) legend.mNeededWidth) / 2.0d) - ((double) xOffset)));
                    } else {
                        f = fConvertDpToPixel4;
                        f2 = lineSpacing;
                    }
                }
                f3 = chartWidth;
            } else {
                f = fConvertDpToPixel4;
                f2 = lineSpacing;
                if (orientation != Legend.LegendOrientation.VERTICAL) {
                    xOffset += this.mViewPortHandler.contentLeft();
                }
                if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                    chartWidth = this.mLegend.mNeededWidth + xOffset;
                    f3 = chartWidth;
                } else {
                    f3 = xOffset;
                }
            }
            int i5 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[orientation.ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    return;
                }
                int i6 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
                if (i6 == 1) {
                    fContentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.mViewPortHandler.contentTop()) + yOffset;
                } else if (i6 != 2) {
                    fContentTop = i6 != 3 ? 0.0f : ((this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f)) + this.mLegend.getYOffset();
                } else {
                    fContentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? this.mViewPortHandler.getChartHeight() : this.mViewPortHandler.contentBottom()) - (this.mLegend.mNeededHeight + yOffset);
                }
                float f5 = fContentTop;
                float f6 = 0.0f;
                int i7 = 0;
                boolean z = false;
                while (i7 < entries.length) {
                    LegendEntry legendEntry = entries[i7];
                    boolean z2 = legendEntry.form != Legend.LegendForm.NONE;
                    float fConvertDpToPixel5 = Float.isNaN(legendEntry.formSize) ? fConvertDpToPixel3 : Utils.convertDpToPixel(legendEntry.formSize);
                    if (z2) {
                        fCalcTextWidth = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f3 + f6 : f3 - (fConvertDpToPixel5 - f6);
                        i3 = i7;
                        f4 = f;
                        canvas3 = canvas;
                        drawForm(canvas3, fCalcTextWidth, f5 + fCalcTextHeight, legendEntry, this.mLegend);
                        if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            fCalcTextWidth += fConvertDpToPixel5;
                        }
                    } else {
                        i3 = i7;
                        f4 = f;
                        canvas3 = canvas;
                        fCalcTextWidth = f3;
                    }
                    if (legendEntry.label != null) {
                        if (z2 && !z) {
                            fCalcTextWidth += direction == Legend.LegendDirection.LEFT_TO_RIGHT ? fConvertDpToPixel : -fConvertDpToPixel;
                        } else if (z) {
                            fCalcTextWidth = f3;
                        }
                        if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            fCalcTextWidth -= Utils.calcTextWidth(this.mLegendLabelPaint, legendEntry.label);
                        }
                        if (z) {
                            f5 += lineHeight + f2;
                            drawLabel(canvas3, fCalcTextWidth, f5 + lineHeight, legendEntry.label);
                        } else {
                            drawLabel(canvas3, fCalcTextWidth, f5 + lineHeight, legendEntry.label);
                        }
                        f5 += lineHeight + f2;
                        f6 = 0.0f;
                    } else {
                        f6 += fConvertDpToPixel5 + f4;
                        z = true;
                    }
                    i7 = i3 + 1;
                    f = f4;
                }
                return;
            }
            float f7 = f;
            List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
            List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
            List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
            int i8 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
            float f8 = f3;
            if (i8 != 1) {
                yOffset = i8 != 2 ? i8 != 3 ? 0.0f : yOffset + ((this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f) : (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
            }
            int length = entries.length;
            List<FSize> list4 = calculatedLabelSizes;
            float f9 = f8;
            int i9 = 0;
            int i10 = 0;
            while (i9 < length) {
                float f10 = yOffset;
                LegendEntry legendEntry2 = entries[i9];
                int i11 = length;
                float f11 = f2;
                boolean z3 = legendEntry2.form != Legend.LegendForm.NONE;
                float fConvertDpToPixel6 = Float.isNaN(legendEntry2.formSize) ? fConvertDpToPixel3 : Utils.convertDpToPixel(legendEntry2.formSize);
                boolean z4 = z3;
                if (i9 < calculatedLabelBreakPoints.size() && calculatedLabelBreakPoints.get(i9).booleanValue()) {
                    f10 += lineHeight + f11;
                    f9 = f8;
                }
                if (f9 == f8 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i10 < calculatedLineSizes.size()) {
                    f9 += (direction == Legend.LegendDirection.RIGHT_TO_LEFT ? calculatedLineSizes.get(i10).width : -calculatedLineSizes.get(i10).width) / 2.0f;
                    i10++;
                }
                int i12 = i10;
                boolean z5 = legendEntry2.label == null;
                if (z4) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f9 -= fConvertDpToPixel6;
                    }
                    float f12 = fConvertDpToPixel6;
                    list = calculatedLabelBreakPoints;
                    i = i9;
                    i2 = i12;
                    list2 = list4;
                    canvas2 = canvas;
                    list3 = calculatedLineSizes;
                    float f13 = f9;
                    drawForm(canvas2, f13, f10 + fCalcTextHeight, legendEntry2, this.mLegend);
                    f9 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f13 + f12 : f13;
                } else {
                    i = i9;
                    list = calculatedLabelBreakPoints;
                    i2 = i12;
                    list2 = list4;
                    canvas2 = canvas;
                    list3 = calculatedLineSizes;
                }
                if (z5) {
                    f9 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -f7 : f7;
                } else {
                    if (z4) {
                        f9 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -fConvertDpToPixel : fConvertDpToPixel;
                    }
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f9 -= list2.get(i).width;
                    }
                    float f14 = f9;
                    drawLabel(canvas2, f14, f10 + lineHeight, legendEntry2.label);
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f14 += list2.get(i).width;
                    }
                    f9 = f14 + (direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -fConvertDpToPixel2 : fConvertDpToPixel2);
                }
                i9 = i + 1;
                calculatedLineSizes = list3;
                yOffset = f10;
                f2 = f11;
                i10 = i2;
                calculatedLabelBreakPoints = list;
                list4 = list2;
                length = i11;
            }
        }
    }
}
