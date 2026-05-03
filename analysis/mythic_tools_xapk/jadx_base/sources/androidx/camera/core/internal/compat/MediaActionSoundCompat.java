package androidx.camera.core.internal.compat;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class MediaActionSoundCompat {
    private MediaActionSoundCompat() {
    }

    public static boolean mustPlayShutterSound() {
        return Build.VERSION.SDK_INT >= 33 ? MediaActionSoundCompatApi33Impl.mustPlayShutterSound() : MediaActionSoundCompatBaseImpl.mustPlayShutterSound();
    }
}
