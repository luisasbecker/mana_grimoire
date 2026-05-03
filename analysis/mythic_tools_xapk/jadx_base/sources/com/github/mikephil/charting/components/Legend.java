package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Legend extends ComponentBase {
    private List<Boolean> mCalculatedLabelBreakPoints;
    private List<FSize> mCalculatedLabelSizes;
    private List<FSize> mCalculatedLineSizes;
    private LegendDirection mDirection;
    private boolean mDrawInside;
    private LegendEntry[] mEntries;
    private LegendEntry[] mExtraEntries;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    private float mFormToTextSpace;
    private LegendHorizontalAlignment mHorizontalAlignment;
    private boolean mIsLegendCustom;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendOrientation mOrientation;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private LegendVerticalAlignment mVerticalAlignment;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    /* JADX INFO: renamed from: com.github.mikephil.charting.components.Legend$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;

        static {
            int[] iArr = new int[LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr;
            try {
                iArr[LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.mEntries = new LegendEntry[0];
        this.mIsLegendCustom = false;
        this.mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
        this.mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
        this.mOrientation = LegendOrientation.HORIZONTAL;
        this.mDrawInside = false;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mFormLineWidth = 3.0f;
        this.mFormLineDashEffect = null;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = 0.0f;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new ArrayList(16);
        this.mCalculatedLabelBreakPoints = new ArrayList(16);
        this.mCalculatedLineSizes = new ArrayList(16);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

    public Legend(LegendEntry[] legendEntryArr) {
        this();
        if (legendEntryArr == null) {
            throw new IllegalArgumentException("entries array is NULL");
        }
        this.mEntries = legendEntryArr;
    }

    public void calculateDimensions(Paint paint, ViewPortHandler viewPortHandler) {
        float f;
        float f2;
        float fConvertDpToPixel = Utils.convertDpToPixel(this.mFormSize);
        float fConvertDpToPixel2 = Utils.convertDpToPixel(this.mStackSpace);
        float fConvertDpToPixel3 = Utils.convertDpToPixel(this.mFormToTextSpace);
        float fConvertDpToPixel4 = Utils.convertDpToPixel(this.mXEntrySpace);
        float fConvertDpToPixel5 = Utils.convertDpToPixel(this.mYEntrySpace);
        boolean z = this.mWordWrapEnabled;
        LegendEntry[] legendEntryArr = this.mEntries;
        int length = legendEntryArr.length;
        this.mTextWidthMax = getMaximumEntryWidth(paint);
        this.mTextHeightMax = getMaximumEntryHeight(paint);
        int i = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mOrientation.ordinal()];
        if (i == 1) {
            float lineHeight = Utils.getLineHeight(paint);
            boolean z2 = false;
            float fMax = 0.0f;
            float f3 = 0.0f;
            float fCalcTextWidth = 0.0f;
            for (int i2 = 0; i2 < length; i2++) {
                LegendEntry legendEntry = legendEntryArr[i2];
                boolean z3 = legendEntry.form != LegendForm.NONE;
                float fConvertDpToPixel6 = Float.isNaN(legendEntry.formSize) ? fConvertDpToPixel : Utils.convertDpToPixel(legendEntry.formSize);
                String str = legendEntry.label;
                if (!z2) {
                    fCalcTextWidth = 0.0f;
                }
                if (z3) {
                    if (z2) {
                        fCalcTextWidth += fConvertDpToPixel2;
                    }
                    fCalcTextWidth += fConvertDpToPixel6;
                }
                if (str != null) {
                    if (z3 && !z2) {
                        fCalcTextWidth += fConvertDpToPixel3;
                    } else if (z2) {
                        fMax = Math.max(fMax, fCalcTextWidth);
                        f3 += lineHeight + fConvertDpToPixel5;
                        z2 = false;
                        fCalcTextWidth = 0.0f;
                    }
                    fCalcTextWidth += Utils.calcTextWidth(paint, str);
                    if (i2 < length - 1) {
                        f3 += lineHeight + fConvertDpToPixel5;
                    }
                } else {
                    fCalcTextWidth += fConvertDpToPixel6;
                    if (i2 < length - 1) {
                        fCalcTextWidth += fConvertDpToPixel2;
                    }
                    z2 = true;
                }
                fMax = Math.max(fMax, fCalcTextWidth);
            }
            this.mNeededWidth = fMax;
            this.mNeededHeight = f3;
        } else if (i == 2) {
            float lineHeight2 = Utils.getLineHeight(paint);
            float lineSpacing = Utils.getLineSpacing(paint) + fConvertDpToPixel5;
            float fContentWidth = viewPortHandler.contentWidth() * this.mMaxSizePercent;
            this.mCalculatedLabelBreakPoints.clear();
            this.mCalculatedLabelSizes.clear();
            this.mCalculatedLineSizes.clear();
            int i3 = 0;
            int i4 = -1;
            float fMax2 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            while (i3 < length) {
                LegendEntry legendEntry2 = legendEntryArr[i3];
                float f6 = fConvertDpToPixel;
                float f7 = fConvertDpToPixel2;
                boolean z4 = legendEntry2.form != LegendForm.NONE;
                float fConvertDpToPixel7 = Float.isNaN(legendEntry2.formSize) ? f6 : Utils.convertDpToPixel(legendEntry2.formSize);
                String str2 = legendEntry2.label;
                boolean z5 = z4;
                float f8 = fConvertDpToPixel7;
                this.mCalculatedLabelBreakPoints.add(false);
                float f9 = i4 == -1 ? 0.0f : f4 + f7;
                List<FSize> list = this.mCalculatedLabelSizes;
                if (str2 != null) {
                    float f10 = f9;
                    list.add(Utils.calcTextSize(paint, str2));
                    f4 = f10 + (z5 ? fConvertDpToPixel3 + f8 : 0.0f) + this.mCalculatedLabelSizes.get(i3).width;
                    f = fConvertDpToPixel3;
                } else {
                    float f11 = f9;
                    f = fConvertDpToPixel3;
                    list.add(FSize.getInstance(0.0f, 0.0f));
                    f4 = f11 + (z5 ? f8 : 0.0f);
                    if (i4 == -1) {
                        i4 = i3;
                    }
                }
                if (str2 != null || i3 == length - 1) {
                    float f12 = f5;
                    float f13 = f12 == 0.0f ? 0.0f : fConvertDpToPixel4;
                    if (!z || f12 == 0.0f || fContentWidth - f12 >= f13 + f4) {
                        f2 = f12 + f13 + f4;
                    } else {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f12, lineHeight2));
                        float fMax3 = Math.max(fMax2, f12);
                        this.mCalculatedLabelBreakPoints.set(i4 > -1 ? i4 : i3, true);
                        fMax2 = fMax3;
                        f2 = f4;
                    }
                    if (i3 == length - 1) {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f2, lineHeight2));
                        fMax2 = Math.max(fMax2, f2);
                    }
                    f5 = f2;
                }
                if (str2 != null) {
                    i4 = -1;
                }
                i3++;
                fConvertDpToPixel = f6;
                fConvertDpToPixel2 = f7;
                fConvertDpToPixel3 = f;
            }
            this.mNeededWidth = fMax2;
            this.mNeededHeight = (lineHeight2 * this.mCalculatedLineSizes.size()) + (lineSpacing * (this.mCalculatedLineSizes.size() == 0 ? 0 : this.mCalculatedLineSizes.size() - 1));
        }
        this.mNeededHeight += this.mYOffset;
        this.mNeededWidth += this.mXOffset;
    }

    public List<Boolean> getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public List<FSize> getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public List<FSize> getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public LegendEntry[] getEntries() {
        return this.mEntries;
    }

    public LegendEntry[] getExtraEntries() {
        return this.mExtraEntries;
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public LegendHorizontalAlignment getHorizontalAlignment() {
        return this.mHorizontalAlignment;
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public float getMaximumEntryHeight(Paint paint) {
        float f = 0.0f;
        for (LegendEntry legendEntry : this.mEntries) {
            String str = legendEntry.label;
            if (str != null) {
                float fCalcTextHeight = Utils.calcTextHeight(paint, str);
                if (fCalcTextHeight > f) {
                    f = fCalcTextHeight;
                }
            }
        }
        return f;
    }

    public float getMaximumEntryWidth(Paint paint) {
        float fConvertDpToPixel = Utils.convertDpToPixel(this.mFormToTextSpace);
        float f = 0.0f;
        float f2 = 0.0f;
        for (LegendEntry legendEntry : this.mEntries) {
            float fConvertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? this.mFormSize : legendEntry.formSize);
            if (fConvertDpToPixel2 > f2) {
                f2 = fConvertDpToPixel2;
            }
            String str = legendEntry.label;
            if (str != null) {
                float fCalcTextWidth = Utils.calcTextWidth(paint, str);
                if (fCalcTextWidth > f) {
                    f = fCalcTextWidth;
                }
            }
        }
        return f + f2 + fConvertDpToPixel;
    }

    public LegendOrientation getOrientation() {
        return this.mOrientation;
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public LegendVerticalAlignment getVerticalAlignment() {
        return this.mVerticalAlignment;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public boolean isDrawInsideEnabled() {
        return this.mDrawInside;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public void setCustom(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
        this.mIsLegendCustom = true;
    }

    public void setCustom(LegendEntry[] legendEntryArr) {
        this.mEntries = legendEntryArr;
        this.mIsLegendCustom = true;
    }

    public void setDirection(LegendDirection legendDirection) {
        this.mDirection = legendDirection;
    }

    public void setDrawInside(boolean z) {
        this.mDrawInside = z;
    }

    public void setEntries(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setExtra(List<LegendEntry> list) {
        this.mExtraEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setExtra(int[] iArr, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Math.min(iArr.length, strArr.length); i++) {
            LegendEntry legendEntry = new LegendEntry();
            legendEntry.formColor = iArr[i];
            legendEntry.label = strArr[i];
            if (legendEntry.formColor == 1122868 || legendEntry.formColor == 0) {
                legendEntry.form = LegendForm.NONE;
            } else if (legendEntry.formColor == 1122867) {
                legendEntry.form = LegendForm.EMPTY;
            }
            arrayList.add(legendEntry);
        }
        this.mExtraEntries = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
    }

    public void setExtra(LegendEntry[] legendEntryArr) {
        if (legendEntryArr == null) {
            legendEntryArr = new LegendEntry[0];
        }
        this.mExtraEntries = legendEntryArr;
    }

    public void setForm(LegendForm legendForm) {
        this.mShape = legendForm;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.mFormLineDashEffect = dashPathEffect;
    }

    public void setFormLineWidth(float f) {
        this.mFormLineWidth = f;
    }

    public void setFormSize(float f) {
        this.mFormSize = f;
    }

    public void setFormToTextSpace(float f) {
        this.mFormToTextSpace = f;
    }

    public void setHorizontalAlignment(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.mHorizontalAlignment = legendHorizontalAlignment;
    }

    public void setMaxSizePercent(float f) {
        this.mMaxSizePercent = f;
    }

    public void setOrientation(LegendOrientation legendOrientation) {
        this.mOrientation = legendOrientation;
    }

    public void setStackSpace(float f) {
        this.mStackSpace = f;
    }

    public void setVerticalAlignment(LegendVerticalAlignment legendVerticalAlignment) {
        this.mVerticalAlignment = legendVerticalAlignment;
    }

    public void setWordWrapEnabled(boolean z) {
        this.mWordWrapEnabled = z;
    }

    public void setXEntrySpace(float f) {
        this.mXEntrySpace = f;
    }

    public void setYEntrySpace(float f) {
        this.mYEntrySpace = f;
    }
}
