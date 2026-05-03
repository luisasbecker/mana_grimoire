package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
public class StopCodecAfterSurfaceRemovalCrashMediaServerQuirk implements Quirk {
    private static boolean isMotoC() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    static boolean load() {
        return isMotoC();
    }
}
