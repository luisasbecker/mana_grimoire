package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.camera.video.AudioStats;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AxisRenderer extends Renderer {
    protected AxisBase mAxis;
    protected Paint mAxisLabelPaint;
    protected Paint mAxisLinePaint;
    protected Paint mGridPaint;
    protected Paint mLimitLinePaint;
    protected Transformer mTrans;

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.mTrans = transformer;
        this.mAxis = axisBase;
        if (this.mViewPortHandler != null) {
            this.mAxisLabelPaint = new Paint(1);
            Paint paint = new Paint();
            this.mGridPaint = paint;
            paint.setColor(-7829368);
            this.mGridPaint.setStrokeWidth(1.0f);
            this.mGridPaint.setStyle(Paint.Style.STROKE);
            this.mGridPaint.setAlpha(90);
            Paint paint2 = new Paint();
            this.mAxisLinePaint = paint2;
            paint2.setColor(-16777216);
            this.mAxisLinePaint.setStrokeWidth(1.0f);
            this.mAxisLinePaint.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.mLimitLinePaint = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public void computeAxis(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.mViewPortHandler != null && this.mViewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            if (z) {
                f3 = (float) valuesByTouchPoint.y;
                d = valuesByTouchPoint2.y;
            } else {
                f3 = (float) valuesByTouchPoint2.y;
                d = valuesByTouchPoint.y;
            }
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f = f3;
            f2 = (float) d;
        }
        computeAxisValues(f, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [int] */
    /* JADX WARN: Type inference failed for: r7v9 */
    protected void computeAxisValues(float f, float f2) {
        float f3 = f;
        int labelCount = this.mAxis.getLabelCount();
        double dAbs = Math.abs(f2 - f3);
        if (labelCount == 0 || dAbs <= AudioStats.AUDIO_AMPLITUDE_NONE || Double.isInfinite(dAbs)) {
            this.mAxis.mEntries = new float[0];
            this.mAxis.mCenteredEntries = new float[0];
            this.mAxis.mEntryCount = 0;
            return;
        }
        double dRoundToNextSignificant = Utils.roundToNextSignificant(dAbs / ((double) labelCount));
        if (this.mAxis.isGranularityEnabled() && dRoundToNextSignificant < this.mAxis.getGranularity()) {
            dRoundToNextSignificant = this.mAxis.getGranularity();
        }
        double dRoundToNextSignificant2 = Utils.roundToNextSignificant(Math.pow(10.0d, (int) Math.log10(dRoundToNextSignificant)));
        if (((int) (dRoundToNextSignificant / dRoundToNextSignificant2)) > 5) {
            dRoundToNextSignificant = Math.floor(dRoundToNextSignificant2 * 10.0d);
        }
        ?? IsCenterAxisLabelsEnabled = this.mAxis.isCenterAxisLabelsEnabled();
        if (this.mAxis.isForceLabelsEnabled()) {
            dRoundToNextSignificant = ((float) dAbs) / (labelCount - 1);
            this.mAxis.mEntryCount = labelCount;
            if (this.mAxis.mEntries.length < labelCount) {
                this.mAxis.mEntries = new float[labelCount];
            }
            for (int i = 0; i < labelCount; i++) {
                this.mAxis.mEntries[i] = f3;
                f3 = (float) (((double) f3) + dRoundToNextSignificant);
            }
        } else {
            double dCeil = dRoundToNextSignificant == AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : Math.ceil(((double) f3) / dRoundToNextSignificant) * dRoundToNextSignificant;
            if (this.mAxis.isCenterAxisLabelsEnabled()) {
                dCeil -= dRoundToNextSignificant;
            }
            double dNextUp = dRoundToNextSignificant == AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : Utils.nextUp(Math.floor(((double) f2) / dRoundToNextSignificant) * dRoundToNextSignificant);
            if (dRoundToNextSignificant != AudioStats.AUDIO_AMPLITUDE_NONE) {
                double d = dCeil;
                IsCenterAxisLabelsEnabled = IsCenterAxisLabelsEnabled;
                while (d <= dNextUp) {
                    d += dRoundToNextSignificant;
                    IsCenterAxisLabelsEnabled++;
                }
            }
            labelCount = IsCenterAxisLabelsEnabled;
            this.mAxis.mEntryCount = labelCount;
            if (this.mAxis.mEntries.length < labelCount) {
                this.mAxis.mEntries = new float[labelCount];
            }
            for (int i2 = 0; i2 < labelCount; i2++) {
                if (dCeil == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    dCeil = 0.0d;
                }
                this.mAxis.mEntries[i2] = (float) dCeil;
                dCeil += dRoundToNextSignificant;
            }
        }
        AxisBase axisBase = this.mAxis;
        if (dRoundToNextSignificant < 1.0d) {
            axisBase.mDecimals = (int) Math.ceil(-Math.log10(dRoundToNextSignificant));
        } else {
            axisBase.mDecimals = 0;
        }
        if (this.mAxis.isCenterAxisLabelsEnabled()) {
            if (this.mAxis.mCenteredEntries.length < labelCount) {
                this.mAxis.mCenteredEntries = new float[labelCount];
            }
            float f4 = ((float) dRoundToNextSignificant) / 2.0f;
            for (int i3 = 0; i3 < labelCount; i3++) {
                this.mAxis.mCenteredEntries[i3] = this.mAxis.mEntries[i3] + f4;
            }
        }
    }

    public Paint getPaintAxisLabels() {
        return this.mAxisLabelPaint;
    }

    public Paint getPaintAxisLine() {
        return this.mAxisLinePaint;
    }

    public Paint getPaintGrid() {
        return this.mGridPaint;
    }

    public Transformer getTransformer() {
        return this.mTrans;
    }

    public abstract void renderAxisLabels(Canvas canvas);

    public abstract void renderAxisLine(Canvas canvas);

    public abstract void renderGridLines(Canvas canvas);

    public abstract void renderLimitLines(Canvas canvas);
}
