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

/* JADX INFO: compiled from: FadedPlaymatTransformation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/FadedPlaymatTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "context", "Landroid/content/Context;", "color", "", Key.ROTATION, "<init>", "(Landroid/content/Context;II)V", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FadedPlaymatTransformation extends BitmapTransformation {
    public static final int $stable = 8;
    private final int color;
    private final Context context;
    private final int rotation;

    public FadedPlaymatTransformation(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.color = i;
        this.rotation = i2;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(toTransform, "toTransform");
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform");
        float f = width;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(toTransform, 0, 0, (int) (0.15f * f), height);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Palette paletteGenerate = Palette.from(bitmapCreateBitmap).generate();
        Intrinsics.checkNotNullExpressionValue(paletteGenerate, "generate(...)");
        int dominantColor = paletteGenerate.getDominantColor(-16777216);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_1");
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        int iAdjustOpacity = companion.adjustOpacity(companion.adjustBrightness(dominantColor, 0.55f));
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_2");
        int iAdjustOpacity2 = companion.adjustOpacity(-16777216);
        Bitmap bitmap = pool.get(toTransform.getWidth(), toTransform.getHeight(), toTransform.getConfig());
        Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, (Paint) null);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_3");
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f / 2.0f, 0.0f, 0, -16777216, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        float f2 = height;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_4");
        int i = (int) (((double) width) * 1.5d);
        Bitmap bitmap2 = pool.get(i, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmap2, "get(...)");
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_5");
        Canvas canvas2 = new Canvas(bitmap2);
        canvas2.drawColor(-16777216, PorterDuff.Mode.CLEAR);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_6");
        ImageSingleton imageSingleton = ImageSingleton.INSTANCE;
        Resources resources = this.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        canvas2.drawBitmap(imageSingleton.getBackgroundImage(resources), (Rect) null, new Rect(0, 0, i, height), (Paint) null);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_7");
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        float f3 = i;
        float f4 = (f3 * 2.0f) / 3.0f;
        paint2.setShader(new LinearGradient(0.0f, 0.0f, f4, 0.0f, iAdjustOpacity, iAdjustOpacity2, Shader.TileMode.CLAMP));
        canvas2.drawRect(0.0f, 0.0f, f4, f2, paint2);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_8");
        canvas2.drawBitmap(bitmap, f3 / 3.0f, 0.0f, paint2);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_9");
        pool.put(bitmap);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("faded_playmat_transform_10");
        Bitmap bitmapRotateImage = TransformationUtils.rotateImage(bitmap2, this.rotation);
        Intrinsics.checkNotNullExpressionValue(bitmapRotateImage, "rotateImage(...)");
        return bitmapRotateImage;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        String str = "FadedPlaymatCropTransformation-final-v4-" + this.rotation;
        Charset CHARSET = BitmapTransformation.CHARSET;
        Intrinsics.checkNotNullExpressionValue(CHARSET, "CHARSET");
        byte[] bytes = str.getBytes(CHARSET);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
    }
}
