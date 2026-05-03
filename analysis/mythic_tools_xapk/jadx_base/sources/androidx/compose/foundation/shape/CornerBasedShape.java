package androidx.compose.foundation.shape;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.caverock.androidsvg.SVGParser;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;

/* JADX INFO: compiled from: CornerBasedShape.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0004\b\u001a\u0010\u001bJ0\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H&J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\""}, d2 = {"Landroidx/compose/foundation/shape/CornerBasedShape;", "Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/graphics/Interpolatable;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "getTopStart", "()Landroidx/compose/foundation/shape/CornerSize;", "getTopEnd", "getBottomEnd", "getBottomStart", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "lerp", "", "other", "t", SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CornerBasedShape implements Shape, Interpolatable {
    public static final int $stable = 0;
    private final CornerSize bottomEnd;
    private final CornerSize bottomStart;
    private final CornerSize topEnd;
    private final CornerSize topStart;

    public CornerBasedShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        this.topStart = cornerSize;
        this.topEnd = cornerSize2;
        this.bottomEnd = cornerSize3;
        this.bottomStart = cornerSize4;
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            cornerSize = cornerBasedShape.topStart;
        }
        if ((i & 2) != 0) {
            cornerSize2 = cornerBasedShape.topEnd;
        }
        if ((i & 4) != 0) {
            cornerSize3 = cornerBasedShape.bottomEnd;
        }
        if ((i & 8) != 0) {
            cornerSize4 = cornerBasedShape.bottomStart;
        }
        return cornerBasedShape.copy(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    public final CornerBasedShape copy(CornerSize all) {
        return copy(all, all, all, all);
    }

    public abstract CornerBasedShape copy(CornerSize topStart, CornerSize topEnd, CornerSize bottomEnd, CornerSize bottomStart);

    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public abstract Outline mo2328createOutlineLjSzlW0(long size, float topStart, float topEnd, float bottomEnd, float bottomStart, LayoutDirection layoutDirection);

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final Outline mo1539createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        float fMo2336toPxTmRCtEA = this.topStart.mo2336toPxTmRCtEA(size, density);
        float fMo2336toPxTmRCtEA2 = this.topEnd.mo2336toPxTmRCtEA(size, density);
        float fMo2336toPxTmRCtEA3 = this.bottomEnd.mo2336toPxTmRCtEA(size, density);
        float fMo2336toPxTmRCtEA4 = this.bottomStart.mo2336toPxTmRCtEA(size, density);
        float fM6148getMinDimensionimpl = Size.m6148getMinDimensionimpl(size);
        float f = fMo2336toPxTmRCtEA + fMo2336toPxTmRCtEA4;
        if (f > fM6148getMinDimensionimpl) {
            float f2 = fM6148getMinDimensionimpl / f;
            fMo2336toPxTmRCtEA *= f2;
            fMo2336toPxTmRCtEA4 *= f2;
        }
        float f3 = fMo2336toPxTmRCtEA2 + fMo2336toPxTmRCtEA3;
        if (f3 > fM6148getMinDimensionimpl) {
            float f4 = fM6148getMinDimensionimpl / f3;
            fMo2336toPxTmRCtEA2 *= f4;
            fMo2336toPxTmRCtEA3 *= f4;
        }
        if (!(fMo2336toPxTmRCtEA >= 0.0f && fMo2336toPxTmRCtEA2 >= 0.0f && fMo2336toPxTmRCtEA3 >= 0.0f && fMo2336toPxTmRCtEA4 >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Corner size in Px can't be negative(topStart = " + fMo2336toPxTmRCtEA + ", topEnd = " + fMo2336toPxTmRCtEA2 + ", bottomEnd = " + fMo2336toPxTmRCtEA3 + ", bottomStart = " + fMo2336toPxTmRCtEA4 + ")!");
        }
        return mo2328createOutlineLjSzlW0(size, fMo2336toPxTmRCtEA, fMo2336toPxTmRCtEA2, fMo2336toPxTmRCtEA3, fMo2336toPxTmRCtEA4, layoutDirection);
    }

    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    public final CornerSize getTopStart() {
        return this.topStart;
    }

    public Object lerp(Object other, float t) {
        return null;
    }
}
