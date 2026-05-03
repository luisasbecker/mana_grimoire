package com.skydoves.colorpickerview;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
class SizeUtils {
    SizeUtils() {
    }

    protected static int dp2Px(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
