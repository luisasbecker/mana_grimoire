package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import androidx.constraintlayout.motion.widget.Key;
import androidx.palette.graphics.Palette;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FadedArtworkCropTransformation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/FadedArtworkCropTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "context", "Landroid/content/Context;", "color", "", Key.ROTATION, "<init>", "(Landroid/content/Context;II)V", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FadedArtworkCropTransformation extends BitmapTransformation {
    public static final int $stable = 8;
    private final int color;
    private final Context context;
    private final int rotation;

    public FadedArtworkCropTransformation(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.color = i;
        this.rotation = i2;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(toTransform, "toTransform");
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_artwork_crop_transform");
        int width = toTransform.getWidth();
        int i = (int) (((double) width) * 0.75d);
        double height = toTransform.getHeight();
        int i2 = (int) (0.425d * height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(toTransform, (width - i) / 2, (int) (height * 0.125d), i, i2);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        float f = i;
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, (int) (0.3f * f), i2);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
        Palette paletteGenerate = Palette.from(bitmapCreateBitmap2).generate();
        Intrinsics.checkNotNullExpressionValue(paletteGenerate, "generate(...)");
        int dominantColor = paletteGenerate.getDominantColor(-16777216);
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        int iAdjustOpacity = companion.adjustOpacity(companion.adjustBrightness(dominantColor, 0.55f));
        int iAdjustOpacity2 = companion.adjustOpacity(-16777216);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f / 2.0f, 0.0f, 0, -16777216, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        float f2 = i2;
        new Canvas(bitmapCreateBitmap).drawRect(0.0f, 0.0f, f, f2, paint);
        int i3 = (int) (((double) i) * 1.5d);
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap3, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap3);
        canvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
        ImageSingleton imageSingleton = ImageSingleton.INSTANCE;
        Resources resources = this.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        canvas.drawBitmap(imageSingleton.getBackgroundImage(resources), (Rect) null, new Rect(0, 0, i3, i2), (Paint) null);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        float f3 = i3;
        float f4 = (2.0f * f3) / 3.0f;
        paint2.setShader(new LinearGradient(0.0f, 0.0f, f4, 0.0f, iAdjustOpacity, iAdjustOpacity2, Shader.TileMode.CLAMP));
        canvas.drawRect(0.0f, 0.0f, f4, f2, paint2);
        canvas.drawBitmap(bitmapCreateBitmap, f3 / 3.0f, 0.0f, paint2);
        Bitmap bitmapRotateImage = TransformationUtils.rotateImage(bitmapCreateBitmap3, this.rotation);
        Intrinsics.checkNotNullExpressionValue(bitmapRotateImage, "rotateImage(...)");
        return bitmapRotateImage;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        String str = "FadedArtworkCropTransformation-final-v2-" + this.rotation;
        Charset CHARSET = BitmapTransformation.CHARSET;
        Intrinsics.checkNotNullExpressionValue(CHARSET, "CHARSET");
        byte[] bytes = str.getBytes(CHARSET);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
    }
}
