package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: ThrottledCallbacks.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"rectInfoFor", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "rectInfoFor-Dg36KO4", "(Landroidx/compose/ui/node/DelegatableNode;JJJJJ[F)Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ThrottledCallbacksKt {
    /* JADX INFO: renamed from: rectInfoFor-Dg36KO4, reason: not valid java name */
    public static final RelativeLayoutBounds m8369rectInfoForDg36KO4(DelegatableNode delegatableNode, long j, long j2, long j3, long j4, long j5, float[] fArr) {
        NodeCoordinator nodeCoordinatorM7940requireCoordinator64DMado = DelegatableNodeKt.m7940requireCoordinator64DMado(delegatableNode, NodeKind.m8088constructorimpl(2));
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        if (!layoutNodeRequireLayoutNode.isPlaced()) {
            return null;
        }
        if (layoutNodeRequireLayoutNode.getOuterCoordinator$ui() == nodeCoordinatorM7940requireCoordinator64DMado) {
            return new RelativeLayoutBounds(j, j2, j3, j4, j5, fArr, delegatableNode, null);
        }
        long jM9236constructorimpl = IntOffset.m9236constructorimpl(j);
        long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m9242getXimpl(jM9236constructorimpl))) << 32) | (((long) Float.floatToRawIntBits(IntOffset.m9243getYimpl(jM9236constructorimpl))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        long jMo7777getSizeYbymL2g = nodeCoordinatorM7940requireCoordinator64DMado.getCoordinates().mo7777getSizeYbymL2g();
        long jM9259roundk4lQ0M = IntOffsetKt.m9259roundk4lQ0M(layoutNodeRequireLayoutNode.getOuterCoordinator$ui().getCoordinates().mo7778localPositionOfR5De75A(nodeCoordinatorM7940requireCoordinator64DMado, jM6072constructorimpl));
        return new RelativeLayoutBounds(jM9259roundk4lQ0M, IntOffset.m9236constructorimpl((((long) (IntOffset.m9242getXimpl(jM9259roundk4lQ0M) + ((int) (jMo7777getSizeYbymL2g >> 32)))) << 32) | (((long) (IntOffset.m9243getYimpl(jM9259roundk4lQ0M) + ((int) (jMo7777getSizeYbymL2g & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), j3, j4, j5, fArr, delegatableNode, null);
    }
}
