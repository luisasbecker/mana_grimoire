package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BeyondBoundsLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"searchBeyondBounds", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BeyondBoundsLayoutKt {
    /* JADX INFO: renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m5950searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        Modifier.Node nodePop;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int iM7758getBeforehoxUOeE;
        NodeChain nodes;
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int iM8088constructorimpl = NodeKind.m8088constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode2.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
        loop0: while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                nodePop = null;
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM8088constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM8088constructorimpl) != 0) {
                        nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((nodePop.getKindSet() & iM8088constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM8088constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodePop;
        if ((focusTargetNode3 != null && Intrinsics.areEqual(focusTargetNode3.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) || (beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent()) == null) {
            return null;
        }
        if (FocusDirection.m5955equalsimpl0(i, FocusDirection.INSTANCE.m5966getUpdhqQ8s())) {
            iM7758getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m7756getAbovehoxUOeE();
        } else if (FocusDirection.m5955equalsimpl0(i, FocusDirection.INSTANCE.m5959getDowndhqQ8s())) {
            iM7758getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m7759getBelowhoxUOeE();
        } else if (FocusDirection.m5955equalsimpl0(i, FocusDirection.INSTANCE.m5962getLeftdhqQ8s())) {
            iM7758getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m7760getLefthoxUOeE();
        } else if (FocusDirection.m5955equalsimpl0(i, FocusDirection.INSTANCE.m5965getRightdhqQ8s())) {
            iM7758getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m7761getRighthoxUOeE();
        } else if (FocusDirection.m5955equalsimpl0(i, FocusDirection.INSTANCE.m5963getNextdhqQ8s())) {
            iM7758getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m7757getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m5955equalsimpl0(i, FocusDirection.INSTANCE.m5964getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            iM7758getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m7758getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo2192layouto7g1Pn8(iM7758getBeforehoxUOeE, function1);
    }
}
