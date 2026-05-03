package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidImageBitmap.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a7\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\n\u0010\u0012\u001a\u00020\u0002*\u00020\u0001\u001a\u0013\u0010\u0013\u001a\u00020\u0014*\u00020\u000bH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u00020\u000b*\u00020\u0014H\u0000¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"asImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroid/graphics/Bitmap;", "createImageBitmap", "bytes", "", "ActualImageBitmap", "width", "", "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ActualImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "asAndroidBitmap", "toBitmapConfig", "Landroid/graphics/Bitmap$Config;", "toBitmapConfig-1JJdX4A", "(I)Landroid/graphics/Bitmap$Config;", "toImageConfig", "(Landroid/graphics/Bitmap$Config;)I", "ui-graphics"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidImageBitmap_androidKt {
    /* JADX INFO: renamed from: ActualImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m6190ActualImageBitmapx__hDU(int i, int i2, int i3, boolean z, ColorSpace colorSpace) {
        m6191toBitmapConfig1JJdX4A(i3);
        return new AndroidImageBitmap(Bitmap.createBitmap((DisplayMetrics) null, i, i2, m6191toBitmapConfig1JJdX4A(i3), z, AndroidColorSpace_androidKt.toAndroidColorSpace(colorSpace)));
    }

    public static final Bitmap asAndroidBitmap(ImageBitmap imageBitmap) {
        if (imageBitmap instanceof AndroidImageBitmap) {
            return ((AndroidImageBitmap) imageBitmap).getBitmap();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    public static final ImageBitmap asImageBitmap(Bitmap bitmap) {
        return new AndroidImageBitmap(bitmap);
    }

    public static final ImageBitmap createImageBitmap(byte[] bArr) {
        return asImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }

    /* JADX INFO: renamed from: toBitmapConfig-1JJdX4A, reason: not valid java name */
    public static final Bitmap.Config m6191toBitmapConfig1JJdX4A(int i) {
        return ImageBitmapConfig.m6551equalsimpl0(i, ImageBitmapConfig.INSTANCE.m6556getArgb8888_sVssgQ()) ? Bitmap.Config.ARGB_8888 : ImageBitmapConfig.m6551equalsimpl0(i, ImageBitmapConfig.INSTANCE.m6555getAlpha8_sVssgQ()) ? Bitmap.Config.ALPHA_8 : ImageBitmapConfig.m6551equalsimpl0(i, ImageBitmapConfig.INSTANCE.m6559getRgb565_sVssgQ()) ? Bitmap.Config.RGB_565 : ImageBitmapConfig.m6551equalsimpl0(i, ImageBitmapConfig.INSTANCE.m6557getF16_sVssgQ()) ? Bitmap.Config.RGBA_F16 : ImageBitmapConfig.m6551equalsimpl0(i, ImageBitmapConfig.INSTANCE.m6558getGpu_sVssgQ()) ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    public static final int toImageConfig(Bitmap.Config config) {
        return config == Bitmap.Config.ALPHA_8 ? ImageBitmapConfig.INSTANCE.m6555getAlpha8_sVssgQ() : config == Bitmap.Config.RGB_565 ? ImageBitmapConfig.INSTANCE.m6559getRgb565_sVssgQ() : config == Bitmap.Config.ARGB_4444 ? ImageBitmapConfig.INSTANCE.m6556getArgb8888_sVssgQ() : config == Bitmap.Config.RGBA_F16 ? ImageBitmapConfig.INSTANCE.m6557getF16_sVssgQ() : config == Bitmap.Config.HARDWARE ? ImageBitmapConfig.INSTANCE.m6558getGpu_sVssgQ() : ImageBitmapConfig.INSTANCE.m6556getArgb8888_sVssgQ();
    }
}
