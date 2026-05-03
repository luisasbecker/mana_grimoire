package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
public class SignalEosOutputBufferNotComeQuirk implements Quirk {
    private static boolean isNokia1() {
        return "Nokia".equalsIgnoreCase(Build.BRAND) && "Nokia 1".equalsIgnoreCase(Build.MODEL);
    }

    static boolean load() {
        return isNokia1();
    }
}
