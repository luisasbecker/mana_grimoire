package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import androidx.media3.muxer.WebmConstants;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.vanniktech.ui.ColorKt;
import java.util.ArrayList;
import java.util.List;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes3.dex */
public class ColorTemplate {
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] LIBERTY_COLORS = {Color.rgb(207, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, 246), Color.rgb(148, 212, 212), Color.rgb(136, SensibleDefaults.X_OFFSET, WebmConstants.MkvEbmlElement.CUE_POINT), Color.rgb(Imgproc.COLOR_YUV2BGR_YVYU, WebmConstants.MkvEbmlElement.TRACK_ENTRY, 175), Color.rgb(42, 109, 130)};
    public static final int[] JOYFUL_COLORS = {Color.rgb(217, 80, 138), Color.rgb(254, Imgproc.COLOR_RGB2YUV_YVYU, 7), Color.rgb(254, WebmConstants.MkvEbmlElement.CUE_TRACK, 120), Color.rgb(106, 167, 134), Color.rgb(53, 194, 209)};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(Imgproc.COLOR_RGB2YUV_YVYU, WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL, 124), Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(WebmConstants.MkvEbmlElement.CUE_TIME, 48, 80)};
    public static final int[] COLORFUL_COLORS = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(WebmConstants.MkvEbmlElement.CUE_TIME, 100, 53)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb(192, 255, 140), Color.rgb(255, WebmConstants.MkvEbmlElement.CUE_TRACK, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};
    public static final int[] MATERIAL_COLORS = {rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};

    public static int colorWithAlpha(int i, int i2) {
        return (i & 16777215) | ((i2 & 255) << 24);
    }

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i)));
        }
        return arrayList;
    }

    public static List<Integer> createColors(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static int getHoloBlue() {
        return Color.rgb(51, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 229);
    }

    public static int rgb(String str) {
        int i = (int) Long.parseLong(str.replace(ColorKt.HEX_PREFIX, ""), 16);
        return Color.rgb((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }
}
