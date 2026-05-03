package com.skydoves.colorpickerview;

import android.graphics.Color;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
class ColorUtils {
    ColorUtils() {
    }

    public static int[] getColorARGB(int i) {
        return new int[]{Color.alpha(i), Color.red(i), Color.green(i), Color.blue(i)};
    }

    public static String getHexCode(int i) {
        return String.format(Locale.getDefault(), "%02X%02X%02X%02X", Integer.valueOf(Color.alpha(i)), Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)));
    }
}
