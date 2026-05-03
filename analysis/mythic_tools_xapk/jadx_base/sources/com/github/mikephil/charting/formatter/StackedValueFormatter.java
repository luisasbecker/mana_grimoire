package com.github.mikephil.charting.formatter;

import com.facebook.appevents.AppEventsConstants;
import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class StackedValueFormatter extends ValueFormatter {
    private boolean mDrawWholeStack;
    private DecimalFormat mFormat;
    private String mSuffix;

    public StackedValueFormatter(boolean z, String str, int i) {
        this.mDrawWholeStack = z;
        this.mSuffix = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getBarStackedLabel(float f, BarEntry barEntry) {
        float[] yVals;
        return (this.mDrawWholeStack || (yVals = barEntry.getYVals()) == null) ? this.mFormat.format(f) + this.mSuffix : yVals[yVals.length + (-1)] == f ? this.mFormat.format(barEntry.getY()) + this.mSuffix : "";
    }
}
