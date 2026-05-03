package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BC\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010 \u001a\u00020\u001bH\u0016¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u001c\u0010+\u001a\u0004\u0018\u00010&2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010,\u001a\u00020\u0007H\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013¨\u0006-"}, d2 = {"Landroidx/compose/ui/graphics/RadialGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Interpolatable;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "<init>", "(Ljava/util/List;Ljava/util/List;JFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColors$ui_graphics", "()Ljava/util/List;", "getStops$ui_graphics", "getCenter-F1C5BW0$ui_graphics", "()J", "J", "getRadius$ui_graphics", "()F", "getTileMode-3opZhB0$ui_graphics", "()I", "I", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "lerp", "t", "ui-graphics"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RadialGradient extends ShaderBrush implements Interpolatable {
    public static final int $stable = 0;
    private final long center;
    private final List<Color> colors;
    private final float radius;
    private final List<Float> stops;
    private final int tileMode;

    private RadialGradient(List<Color> list, List<Float> list2, long j, float f, int i) {
        this.colors = list;
        this.stops = list2;
        this.center = j;
        this.radius = f;
        this.tileMode = i;
    }

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, j, f, (i2 & 16) != 0 ? TileMode.INSTANCE.m6720getClamp3opZhB0() : i, null);
    }

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, f, i);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo6294createShaderuvyYCjk(long size) {
        float fIntBitsToFloat;
        float fIntBitsToFloat2;
        long j = this.center;
        if ((9223372034707292159L & j) == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            long jM6159getCenteruvyYCjk = SizeKt.m6159getCenteruvyYCjk(size);
            fIntBitsToFloat = Float.intBitsToFloat((int) (jM6159getCenteruvyYCjk >> 32));
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM6159getCenteruvyYCjk & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        } else {
            fIntBitsToFloat = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (j >> 32)) == Float.POSITIVE_INFINITY ? size >> 32 : this.center >> 32));
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (this.center & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) == Float.POSITIVE_INFINITY ? size & MuxerUtil.UNSIGNED_INT_MAX_VALUE : this.center & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        }
        List<Color> list = this.colors;
        List<Float> list2 = this.stops;
        long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) Float.floatToRawIntBits(fIntBitsToFloat2))));
        float fM6148getMinDimensionimpl = this.radius;
        if (fM6148getMinDimensionimpl == Float.POSITIVE_INFINITY) {
            fM6148getMinDimensionimpl = Size.m6148getMinDimensionimpl(size) / 2.0f;
        }
        return ShaderKt.m6661RadialGradientShader8uybcMk(jM6072constructorimpl, fM6148getMinDimensionimpl, list, list2, this.tileMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) other;
        return Intrinsics.areEqual(this.colors, radialGradient.colors) && Intrinsics.areEqual(this.stops, radialGradient.stops) && Offset.m6077equalsimpl0(this.center, radialGradient.center) && this.radius == radialGradient.radius && TileMode.m6716equalsimpl0(this.tileMode, radialGradient.tileMode);
    }

    /* JADX INFO: renamed from: getCenter-F1C5BW0$ui_graphics, reason: not valid java name and from getter */
    public final long getCenter() {
        return this.center;
    }

    public final List<Color> getColors$ui_graphics() {
        return this.colors;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        if ((Float.floatToRawIntBits(this.radius) & Integer.MAX_VALUE) >= 2139095040) {
            return Size.INSTANCE.m6157getUnspecifiedNHjbRc();
        }
        float f = this.radius;
        return Size.m6140constructorimpl((((long) Float.floatToRawIntBits(f * 2.0f)) << 32) | (((long) Float.floatToRawIntBits(f * 2.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: renamed from: getRadius$ui_graphics, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    public final List<Float> getStops$ui_graphics() {
        return this.stops;
    }

    /* JADX INFO: renamed from: getTileMode-3opZhB0$ui_graphics, reason: not valid java name and from getter */
    public final int getTileMode() {
        return this.tileMode;
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m6082hashCodeimpl(this.center)) * 31) + Float.hashCode(this.radius)) * 31) + TileMode.m6717hashCodeimpl(this.tileMode);
    }

    @Override // androidx.compose.ui.graphics.Interpolatable
    public Object lerp(Object other, float t) {
        if (other == null) {
            other = new SolidColor(Color.INSTANCE.m6360getTransparent0d7_KjU(), null);
        }
        if (other instanceof SolidColor) {
            List<Color> list = this.colors;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).m6335unboximpl();
                arrayList.add(Color.m6315boximpl(((SolidColor) other).getValue()));
            }
            other = new RadialGradient(arrayList, this.stops, this.center, this.radius, this.tileMode, null);
        }
        if (!(other instanceof RadialGradient)) {
            return null;
        }
        RadialGradient radialGradient = (RadialGradient) other;
        return new RadialGradient(BrushKt.lerpColorList(this.colors, radialGradient.colors, t), BrushKt.lerpNullableFloatList(this.stops, radialGradient.stops, t), OffsetKt.m6103lerpWko1d7g(this.center, radialGradient.center, t), MathHelpersKt.lerp(this.radius, radialGradient.radius, t), t < 0.5f ? this.tileMode : radialGradient.tileMode, null);
    }

    public String toString() {
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + ((this.center & 9223372034707292159L) != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? "center=" + ((Object) Offset.m6088toStringimpl(this.center)) + ", " : "") + ((Float.floatToRawIntBits(this.radius) & Integer.MAX_VALUE) < 2139095040 ? "radius=" + this.radius + ", " : "") + "tileMode=" + ((Object) TileMode.m6718toStringimpl(this.tileMode)) + ')';
    }
}
