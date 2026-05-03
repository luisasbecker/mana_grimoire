package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
public class HdrRepeatingRequestFailureQuirk implements Quirk {
    private static boolean isSamsungS25Ultra() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "pa3q".equalsIgnoreCase(Build.DEVICE);
    }

    static boolean load() {
        return isSamsungS25Ultra();
    }

    public boolean workaroundBySurfaceProcessing(DynamicRange dynamicRange) {
        return isSamsungS25Ultra() && (dynamicRange != DynamicRange.SDR);
    }
}
