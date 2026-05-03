package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AspectRatio.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010\u001f\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010 \u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u001c\u0010\"\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0013\u0010#\u001a\u00020$*\u00020\u0017H\u0002¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010*J\u001b\u0010-\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010*J\u001b\u0010/\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010*R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "<init>", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "findSize", "Landroidx/compose/ui/unit/IntSize;", "findSize-ToXhtMw", "(J)J", "tryMaxWidth", "enforceConstraints", "tryMaxWidth-JN-0ABg", "(JZ)J", "tryMaxHeight", "tryMaxHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m1925findSizeToXhtMw(long j) {
        if (this.matchHeightConstraintsFirst) {
            long jM1926tryMaxHeightJN0ABg = m1926tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m9283equalsimpl0(jM1926tryMaxHeightJN0ABg, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1926tryMaxHeightJN0ABg;
            }
            long jM1927tryMaxWidthJN0ABg = m1927tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m9283equalsimpl0(jM1927tryMaxWidthJN0ABg, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1927tryMaxWidthJN0ABg;
            }
            long jM1928tryMinHeightJN0ABg = m1928tryMinHeightJN0ABg(j, true);
            if (!IntSize.m9283equalsimpl0(jM1928tryMinHeightJN0ABg, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1928tryMinHeightJN0ABg;
            }
            long jM1929tryMinWidthJN0ABg = m1929tryMinWidthJN0ABg(j, true);
            if (!IntSize.m9283equalsimpl0(jM1929tryMinWidthJN0ABg, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1929tryMinWidthJN0ABg;
            }
            long jM1926tryMaxHeightJN0ABg2 = m1926tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m9283equalsimpl0(jM1926tryMaxHeightJN0ABg2, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1926tryMaxHeightJN0ABg2;
            }
            long jM1927tryMaxWidthJN0ABg2 = m1927tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m9283equalsimpl0(jM1927tryMaxWidthJN0ABg2, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1927tryMaxWidthJN0ABg2;
            }
            long jM1928tryMinHeightJN0ABg2 = m1928tryMinHeightJN0ABg(j, false);
            if (!IntSize.m9283equalsimpl0(jM1928tryMinHeightJN0ABg2, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1928tryMinHeightJN0ABg2;
            }
            long jM1929tryMinWidthJN0ABg2 = m1929tryMinWidthJN0ABg(j, false);
            if (!IntSize.m9283equalsimpl0(jM1929tryMinWidthJN0ABg2, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1929tryMinWidthJN0ABg2;
            }
        } else {
            long jM1927tryMaxWidthJN0ABg3 = m1927tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m9283equalsimpl0(jM1927tryMaxWidthJN0ABg3, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1927tryMaxWidthJN0ABg3;
            }
            long jM1926tryMaxHeightJN0ABg3 = m1926tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m9283equalsimpl0(jM1926tryMaxHeightJN0ABg3, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1926tryMaxHeightJN0ABg3;
            }
            long jM1929tryMinWidthJN0ABg3 = m1929tryMinWidthJN0ABg(j, true);
            if (!IntSize.m9283equalsimpl0(jM1929tryMinWidthJN0ABg3, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1929tryMinWidthJN0ABg3;
            }
            long jM1928tryMinHeightJN0ABg3 = m1928tryMinHeightJN0ABg(j, true);
            if (!IntSize.m9283equalsimpl0(jM1928tryMinHeightJN0ABg3, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1928tryMinHeightJN0ABg3;
            }
            long jM1927tryMaxWidthJN0ABg4 = m1927tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m9283equalsimpl0(jM1927tryMaxWidthJN0ABg4, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1927tryMaxWidthJN0ABg4;
            }
            long jM1926tryMaxHeightJN0ABg4 = m1926tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m9283equalsimpl0(jM1926tryMaxHeightJN0ABg4, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1926tryMaxHeightJN0ABg4;
            }
            long jM1929tryMinWidthJN0ABg4 = m1929tryMinWidthJN0ABg(j, false);
            if (!IntSize.m9283equalsimpl0(jM1929tryMinWidthJN0ABg4, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1929tryMinWidthJN0ABg4;
            }
            long jM1928tryMinHeightJN0ABg4 = m1928tryMinHeightJN0ABg(j, false);
            if (!IntSize.m9283equalsimpl0(jM1928tryMinHeightJN0ABg4, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                return jM1928tryMinHeightJN0ABg4;
            }
        }
        return IntSize.INSTANCE.m9290getZeroYbymL2g();
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m1926tryMaxHeightJN0ABg(long j, boolean z) {
        int iRound;
        int iM9066getMaxHeightimpl = Constraints.m9066getMaxHeightimpl(j);
        return (iM9066getMaxHeightimpl == Integer.MAX_VALUE || (iRound = Math.round(((float) iM9066getMaxHeightimpl) * this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m1924isSatisfiedByNN6EwU(j, iRound, iM9066getMaxHeightimpl))) ? IntSize.INSTANCE.m9290getZeroYbymL2g() : IntSize.m9280constructorimpl((((long) iRound) << 32) | (((long) iM9066getMaxHeightimpl) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m1927tryMaxWidthJN0ABg(long j, boolean z) {
        int iRound;
        int iM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(j);
        return (iM9067getMaxWidthimpl == Integer.MAX_VALUE || (iRound = Math.round(((float) iM9067getMaxWidthimpl) / this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m1924isSatisfiedByNN6EwU(j, iM9067getMaxWidthimpl, iRound))) ? IntSize.INSTANCE.m9290getZeroYbymL2g() : IntSize.m9280constructorimpl((((long) iM9067getMaxWidthimpl) << 32) | (((long) iRound) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m1928tryMinHeightJN0ABg(long j, boolean z) {
        int iM9068getMinHeightimpl = Constraints.m9068getMinHeightimpl(j);
        int iRound = Math.round(iM9068getMinHeightimpl * this.aspectRatio);
        return (iRound <= 0 || (z && !AspectRatioKt.m1924isSatisfiedByNN6EwU(j, iRound, iM9068getMinHeightimpl))) ? IntSize.INSTANCE.m9290getZeroYbymL2g() : IntSize.m9280constructorimpl((((long) iRound) << 32) | (((long) iM9068getMinHeightimpl) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m1929tryMinWidthJN0ABg(long j, boolean z) {
        int iM9069getMinWidthimpl = Constraints.m9069getMinWidthimpl(j);
        int iRound = Math.round(iM9069getMinWidthimpl / this.aspectRatio);
        return (iRound <= 0 || (z && !AspectRatioKt.m1924isSatisfiedByNN6EwU(j, iM9069getMinWidthimpl, iRound))) ? IntSize.INSTANCE.m9290getZeroYbymL2g() : IntSize.m9280constructorimpl((((long) iM9069getMinWidthimpl) << 32) | (((long) iRound) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.aspectRatio) : intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.aspectRatio) : intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1288measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long jM1925findSizeToXhtMw = m1925findSizeToXhtMw(j);
        if (!IntSize.m9283equalsimpl0(jM1925findSizeToXhtMw, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m9077fixedJhjzzOo((int) (jM1925findSizeToXhtMw >> 32), (int) (jM1925findSizeToXhtMw & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        }
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.AspectRatioNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AspectRatioNode.measure_3p2s80s$lambda$0(placeableMo7769measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.aspectRatio) : intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.aspectRatio) : intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }
}
