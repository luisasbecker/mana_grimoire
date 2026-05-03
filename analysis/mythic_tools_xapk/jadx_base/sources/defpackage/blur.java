package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: renamed from: BlurTransformationKt, reason: from Kotlin metadata */
/* JADX INFO: compiled from: BlurTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\t"}, d2 = {"blur", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "radius", "", "scaleDown", "", "scaledDown", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class blur {
    public static final Bitmap blur(Bitmap bitmap, Context context, float f, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (f < 1.0f) {
            return bitmap;
        }
        double dMin = Math.min(f, 25.0d);
        Bitmap bitmapScaledDown = z ? scaledDown(bitmap) : bitmap;
        RenderScript renderScriptCreate = RenderScript.create(context);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapScaledDown);
        Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        scriptIntrinsicBlurCreate.setRadius((float) dMin);
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        Bitmap.Config config = bitmap.getConfig();
        Bitmap bitmapCreateBitmap = config != null ? Bitmap.createBitmap(bitmapScaledDown.getWidth(), bitmapScaledDown.getHeight(), config) : null;
        allocationCreateTyped.copyTo(bitmapCreateBitmap);
        allocationCreateFromBitmap.destroy();
        allocationCreateTyped.destroy();
        scriptIntrinsicBlurCreate.destroy();
        renderScriptCreate.destroy();
        return bitmapCreateBitmap == null ? bitmapScaledDown : bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap blur$default(Bitmap bitmap, Context context, float f, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return blur(bitmap, context, f, z);
    }

    private static final Bitmap scaledDown(Bitmap bitmap) {
        float fMin = Math.min(400.0f / bitmap.getWidth(), 400.0f / bitmap.getHeight());
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, MathKt.roundToInt(bitmap.getWidth() * fMin), MathKt.roundToInt(fMin * bitmap.getHeight()), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, true)");
        return bitmapCreateScaledBitmap;
    }
}
