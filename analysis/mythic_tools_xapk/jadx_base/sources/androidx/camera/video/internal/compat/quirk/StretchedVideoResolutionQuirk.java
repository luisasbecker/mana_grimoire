package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import org.opencv.imgcodecs.Imgcodecs;

/* JADX INFO: loaded from: classes.dex */
public class StretchedVideoResolutionQuirk implements Quirk {
    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    static boolean load() {
        return isMotoE5Play();
    }

    public Size getAlternativeResolution(int i) {
        if (i == 4) {
            return new Size(Imgcodecs.IMWRITE_JPEGXL_QUALITY, 480);
        }
        if (i == 5) {
            return new Size(960, 720);
        }
        if (i != 6) {
            return null;
        }
        return new Size(1440, 1080);
    }
}
