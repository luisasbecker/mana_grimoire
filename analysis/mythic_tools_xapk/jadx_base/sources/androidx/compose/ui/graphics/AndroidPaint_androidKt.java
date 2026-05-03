package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidPaint.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0001\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001f\u0010\u0006\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u0011*\u00060\u0001j\u0002`\bH\u0000\u001a\u0018\u0010\u0012\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0011H\u0000\u001a\u0010\u0010\u0013\u001a\u00020\u0014*\u00060\u0001j\u0002`\bH\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0014H\u0000\u001a\u0015\u0010\u0016\u001a\u00020\u0017*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010\u0018\u001a\u001f\u0010\u0019\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001e\u0010\f\u001a\u0015\u0010\u001f\u001a\u00020\u001d*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u0011*\u00060\u0001j\u0002`\bH\u0000\u001a\u0018\u0010\"\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0011H\u0000\u001a\u0015\u0010#\u001a\u00020$*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001a\u001f\u0010%\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020$H\u0000¢\u0006\u0004\b&\u0010\f\u001a\u0015\u0010'\u001a\u00020(*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001a\u001f\u0010)\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020(H\u0000¢\u0006\u0004\b*\u0010\f\u001a\u0010\u0010+\u001a\u00020\u0011*\u00060\u0001j\u0002`\bH\u0000\u001a\u0018\u0010,\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020\u0011H\u0000\u001a\u0015\u0010-\u001a\u00020.*\u00060\u0001j\u0002`\bH\u0000¢\u0006\u0002\u0010 \u001a\u001f\u0010/\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u0006\u0010\u000e\u001a\u00020.H\u0000¢\u0006\u0004\b0\u0010\f\u001a \u00101\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\u000e\u0010\u000e\u001a\n\u0018\u000102j\u0004\u0018\u0001`3H\u0000\u001a\u001a\u00104\u001a\u00020\u0007*\u00060\u0001j\u0002`\b2\b\u0010\u000e\u001a\u0004\u0018\u000105H\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u00066"}, d2 = {"NativePaint", "Landroid/graphics/Paint;", "Paint", "Landroidx/compose/ui/graphics/Paint;", "asComposePaint", "makeNativePaint", "setNativeBlendMode", "", "Landroidx/compose/ui/graphics/NativePaint;", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeColorFilter", "value", "Landroidx/compose/ui/graphics/ColorFilter;", "getNativeAlpha", "", "setNativeAlpha", "getNativeAntiAlias", "", "setNativeAntiAlias", "getNativeColor", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Paint;)J", "setNativeColor", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeStyle", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeStyle--5YerkU", "getNativeStyle", "(Landroid/graphics/Paint;)I", "getNativeStrokeWidth", "setNativeStrokeWidth", "getNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "setNativeStrokeCap", "setNativeStrokeCap-CSYIeUk", "getNativeStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "setNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "getNativeStrokeMiterLimit", "setNativeStrokeMiterLimit", "getNativeFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "setNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativeShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativePathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "ui-graphics"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidPaint_androidKt {

    /* JADX INFO: compiled from: AndroidPaint.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final Paint asComposePaint(android.graphics.Paint paint) {
        return new AndroidPaint(paint);
    }

    public static final float getNativeAlpha(android.graphics.Paint paint) {
        return paint.getAlpha() / 255.0f;
    }

    public static final boolean getNativeAntiAlias(android.graphics.Paint paint) {
        return paint.isAntiAlias();
    }

    public static final long getNativeColor(android.graphics.Paint paint) {
        return ColorKt.Color(paint.getColor());
    }

    public static final int getNativeFilterQuality(android.graphics.Paint paint) {
        return !paint.isFilterBitmap() ? FilterQuality.INSTANCE.m6427getNonefv9h1I() : FilterQuality.INSTANCE.m6425getLowfv9h1I();
    }

    public static final int getNativeStrokeCap(android.graphics.Paint paint) {
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i = strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? StrokeCap.INSTANCE.m6699getButtKaPHkGw() : StrokeCap.INSTANCE.m6701getSquareKaPHkGw() : StrokeCap.INSTANCE.m6700getRoundKaPHkGw() : StrokeCap.INSTANCE.m6699getButtKaPHkGw();
    }

    public static final int getNativeStrokeJoin(android.graphics.Paint paint) {
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i = strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? StrokeJoin.INSTANCE.m6710getMiterLxFBmk8() : StrokeJoin.INSTANCE.m6711getRoundLxFBmk8() : StrokeJoin.INSTANCE.m6709getBevelLxFBmk8() : StrokeJoin.INSTANCE.m6710getMiterLxFBmk8();
    }

    public static final float getNativeStrokeMiterLimit(android.graphics.Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final float getNativeStrokeWidth(android.graphics.Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final int getNativeStyle(android.graphics.Paint paint) {
        Paint.Style style = paint.getStyle();
        return (style == null ? -1 : WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) == 1 ? PaintingStyle.INSTANCE.m6607getStrokeTiuSbCo() : PaintingStyle.INSTANCE.m6606getFillTiuSbCo();
    }

    public static final android.graphics.Paint makeNativePaint() {
        return new android.graphics.Paint(7);
    }

    public static final void setNativeAlpha(android.graphics.Paint paint, float f) {
        paint.setAlpha((int) Math.rint(f * 255.0f));
    }

    public static final void setNativeAntiAlias(android.graphics.Paint paint, boolean z) {
        paint.setAntiAlias(z);
    }

    /* JADX INFO: renamed from: setNativeBlendMode-GB0RdKg, reason: not valid java name */
    public static final void m6206setNativeBlendModeGB0RdKg(android.graphics.Paint paint, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m6751setBlendModeGB0RdKg(paint, i);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m6173toPorterDuffModes9anfk8(i)));
        }
    }

    /* JADX INFO: renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m6207setNativeColor4WTKRHQ(android.graphics.Paint paint, long j) {
        paint.setColor(ColorKt.m6379toArgb8_81llA(j));
    }

    public static final void setNativeColorFilter(android.graphics.Paint paint, ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
    }

    /* JADX INFO: renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m6208setNativeFilterQuality50PEsBU(android.graphics.Paint paint, int i) {
        paint.setFilterBitmap(!FilterQuality.m6420equalsimpl0(i, FilterQuality.INSTANCE.m6427getNonefv9h1I()));
    }

    public static final void setNativePathEffect(android.graphics.Paint paint, PathEffect pathEffect) {
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) pathEffect;
        paint.setPathEffect(androidPathEffect != null ? androidPathEffect.getNativePathEffect() : null);
    }

    public static final void setNativeShader(android.graphics.Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    /* JADX INFO: renamed from: setNativeStrokeCap-CSYIeUk, reason: not valid java name */
    public static final void m6209setNativeStrokeCapCSYIeUk(android.graphics.Paint paint, int i) {
        paint.setStrokeCap(StrokeCap.m6695equalsimpl0(i, StrokeCap.INSTANCE.m6701getSquareKaPHkGw()) ? Paint.Cap.SQUARE : StrokeCap.m6695equalsimpl0(i, StrokeCap.INSTANCE.m6700getRoundKaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m6695equalsimpl0(i, StrokeCap.INSTANCE.m6699getButtKaPHkGw()) ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    /* JADX INFO: renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m6210setNativeStrokeJoinkLtJ_vA(android.graphics.Paint paint, int i) {
        paint.setStrokeJoin(StrokeJoin.m6705equalsimpl0(i, StrokeJoin.INSTANCE.m6710getMiterLxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m6705equalsimpl0(i, StrokeJoin.INSTANCE.m6709getBevelLxFBmk8()) ? Paint.Join.BEVEL : StrokeJoin.m6705equalsimpl0(i, StrokeJoin.INSTANCE.m6711getRoundLxFBmk8()) ? Paint.Join.ROUND : Paint.Join.MITER);
    }

    public static final void setNativeStrokeMiterLimit(android.graphics.Paint paint, float f) {
        paint.setStrokeMiter(f);
    }

    public static final void setNativeStrokeWidth(android.graphics.Paint paint, float f) {
        paint.setStrokeWidth(f);
    }

    /* JADX INFO: renamed from: setNativeStyle--5YerkU, reason: not valid java name */
    public static final void m6211setNativeStyle5YerkU(android.graphics.Paint paint, int i) {
        paint.setStyle(PaintingStyle.m6602equalsimpl0(i, PaintingStyle.INSTANCE.m6607getStrokeTiuSbCo()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
