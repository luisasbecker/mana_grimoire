package com.google.android.material.color;

import android.content.Context;
import android.os.Build;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface ColorResourcesOverride {
    static ColorResourcesOverride getInstance() {
        if ((30 > Build.VERSION.SDK_INT || Build.VERSION.SDK_INT > 33) && Build.VERSION.SDK_INT < 34) {
            return null;
        }
        return ResourcesLoaderColorResourcesOverride.getInstance();
    }

    boolean applyIfPossible(Context context, Map<Integer, Integer> map);

    Context wrapContextIfPossible(Context context, Map<Integer, Integer> map);
}
