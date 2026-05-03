package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import coil.size.Size;
import coil.transform.Transformation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: BlurTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"LBlurTransformation;", "Lcoil/transform/Transformation;", "context", "Landroid/content/Context;", "radius", "", "(Landroid/content/Context;F)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "transform", "Landroid/graphics/Bitmap;", "input", "size", "Lcoil/size/Size;", "(Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlurTransformation implements Transformation {
    public static final int $stable = 8;
    private final String cacheKey;
    private final Context context;
    private final float radius;

    public BlurTransformation(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.radius = f;
        this.cacheKey = getClass().getName() + Soundex.SILENT_MARKER + f;
    }

    @Override // coil.transform.Transformation
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // coil.transform.Transformation
    public Object transform(Bitmap bitmap, Size size, Continuation<? super Bitmap> continuation) {
        return blur.blur$default(bitmap, this.context, this.radius, false, 4, null);
    }
}
