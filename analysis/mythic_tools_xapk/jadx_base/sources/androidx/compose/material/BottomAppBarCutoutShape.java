package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J4\u0010\u0018\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\t\u0010\u001f\u001a\u00020\u0001HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\u001d\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006*"}, d2 = {"Landroidx/compose/material/BottomAppBarCutoutShape;", "Landroidx/compose/ui/graphics/Shape;", "cutoutShape", "fabPlacement", "Landroidx/compose/material/FabPlacement;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/FabPlacement;)V", "getCutoutShape", "()Landroidx/compose/ui/graphics/Shape;", "getFabPlacement", "()Landroidx/compose/material/FabPlacement;", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "addCutoutShape", "", "Landroidx/compose/ui/graphics/Path;", "addRoundedEdges", "cutoutStartPosition", "", "cutoutEndPosition", "cutoutRadius", "roundedEdgeRadius", "verticalOffset", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final /* data */ class BottomAppBarCutoutShape implements Shape {
    private final Shape cutoutShape;
    private final FabPlacement fabPlacement;

    public BottomAppBarCutoutShape(Shape shape, FabPlacement fabPlacement) {
        this.cutoutShape = shape;
        this.fabPlacement = fabPlacement;
    }

    private final void addCutoutShape(Path path, LayoutDirection layoutDirection, Density density) {
        float fMo1624toPx0680j_4 = density.mo1624toPx0680j_4(AppBarKt.BottomAppBarCutoutOffset);
        float f = fMo1624toPx0680j_4 * 2.0f;
        long jM6140constructorimpl = Size.m6140constructorimpl((((long) Float.floatToRawIntBits(this.fabPlacement.getHeight() + f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(this.fabPlacement.getWidth() + f) << 32));
        float left = this.fabPlacement.getLeft() - fMo1624toPx0680j_4;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM6140constructorimpl >> 32)) + left;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM6140constructorimpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / 2.0f;
        OutlineKt.addOutline(path, this.cutoutShape.mo1539createOutlinePq9zytI(jM6140constructorimpl, layoutDirection, density));
        path.mo6217translatek4lQ0M(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(left)) << 32) | (((long) Float.floatToRawIntBits(-fIntBitsToFloat2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        if (Intrinsics.areEqual(this.cutoutShape, RoundedCornerShapeKt.getCircleShape())) {
            addRoundedEdges(path, left, fIntBitsToFloat, fIntBitsToFloat2, density.mo1624toPx0680j_4(AppBarKt.BottomAppBarRoundedEdgeRadius), 0.0f);
        }
    }

    private final void addRoundedEdges(Path path, float f, float f2, float f3, float f4, float f5) {
        float f6 = -((float) Math.sqrt((f3 * f3) - (f5 * f5)));
        float f7 = f3 + f6;
        float f8 = f + f7;
        float f9 = f2 - f7;
        Pair<Float, Float> pairCalculateRoundedEdgeIntercept = AppBarKt.calculateRoundedEdgeIntercept(f6 - 1.0f, f5, f3);
        float fFloatValue = pairCalculateRoundedEdgeIntercept.component1().floatValue() + f3;
        float fFloatValue2 = pairCalculateRoundedEdgeIntercept.component2().floatValue() - f5;
        path.moveTo(f8 - f4, 0.0f);
        path.quadraticTo(f8 - 1.0f, 0.0f, f + fFloatValue, fFloatValue2);
        path.lineTo(f2 - fFloatValue, fFloatValue2);
        path.quadraticTo(f9 + 1.0f, 0.0f, f4 + f9, 0.0f);
        path.close();
    }

    public static /* synthetic */ BottomAppBarCutoutShape copy$default(BottomAppBarCutoutShape bottomAppBarCutoutShape, Shape shape, FabPlacement fabPlacement, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = bottomAppBarCutoutShape.cutoutShape;
        }
        if ((i & 2) != 0) {
            fabPlacement = bottomAppBarCutoutShape.fabPlacement;
        }
        return bottomAppBarCutoutShape.copy(shape, fabPlacement);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    public final BottomAppBarCutoutShape copy(Shape cutoutShape, FabPlacement fabPlacement) {
        return new BottomAppBarCutoutShape(cutoutShape, fabPlacement);
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo1539createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        Path Path = AndroidPath_androidKt.Path();
        Path.addRect$default(Path, new Rect(0.0f, 0.0f, Float.intBitsToFloat((int) (size >> 32)), Float.intBitsToFloat((int) (size & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), null, 2, null);
        Path Path2 = AndroidPath_androidKt.Path();
        addCutoutShape(Path2, layoutDirection, density);
        Path2.mo6214opN5in7k0(Path, Path2, PathOperation.INSTANCE.m6631getDifferenceb3I0S0c());
        return new Outline.Generic(Path2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomAppBarCutoutShape)) {
            return false;
        }
        BottomAppBarCutoutShape bottomAppBarCutoutShape = (BottomAppBarCutoutShape) other;
        return Intrinsics.areEqual(this.cutoutShape, bottomAppBarCutoutShape.cutoutShape) && Intrinsics.areEqual(this.fabPlacement, bottomAppBarCutoutShape.fabPlacement);
    }

    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    public int hashCode() {
        return (this.cutoutShape.hashCode() * 31) + this.fabPlacement.hashCode();
    }

    public String toString() {
        return "BottomAppBarCutoutShape(cutoutShape=" + this.cutoutShape + ", fabPlacement=" + this.fabPlacement + ')';
    }
}
