package com.studiolaganne.lengendarylens;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: RotateTransformation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/RotateTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "rotationAngle", "", "<init>", "(F)V", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "", "outHeight", "equals", "", "other", "", "hashCode", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RotateTransformation extends BitmapTransformation {
    private static final String ID = "com.studiolaganne.lengendarylens.RotateTransformation";
    private final float rotationAngle;
    public static final int $stable = 8;

    public RotateTransformation(float f) {
        this.rotationAngle = f;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object other) {
        return (other instanceof RotateTransformation) && ((RotateTransformation) other).rotationAngle == this.rotationAngle;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(ID.hashCode(), Util.hashCode(Float.hashCode(this.rotationAngle)));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(toTransform, "toTransform");
        Matrix matrix = new Matrix();
        matrix.postRotate(this.rotationAngle);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(toTransform, 0, 0, toTransform.getWidth(), toTransform.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        byte[] bytes = ("rotate transformation v2 " + this.rotationAngle).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
    }
}
