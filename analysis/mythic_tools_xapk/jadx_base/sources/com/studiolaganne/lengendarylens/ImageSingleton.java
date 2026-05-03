package com.studiolaganne.lengendarylens;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageSingleton.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/ImageSingleton;", "", "<init>", "()V", "backgroundImage", "Landroid/graphics/Bitmap;", "getBackgroundImage", "resources", "Landroid/content/res/Resources;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageSingleton {
    private static Bitmap backgroundImage;
    public static final ImageSingleton INSTANCE = new ImageSingleton();
    public static final int $stable = 8;

    private ImageSingleton() {
    }

    public final Bitmap getBackgroundImage(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (backgroundImage == null) {
            backgroundImage = BitmapFactory.decodeResource(resources, R.drawable.background);
        }
        Bitmap bitmap = backgroundImage;
        Intrinsics.checkNotNull(bitmap);
        return bitmap;
    }
}
