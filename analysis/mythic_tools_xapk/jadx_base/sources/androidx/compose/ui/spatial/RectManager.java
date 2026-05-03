package androidx.compose.ui.spatial;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_androidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: RectManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u0010J5\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0006\u0010%\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0012J\u0006\u0010(\u001a\u00020\u0010J\u0016\u0010)\u001a\u0004\u0018\u00010\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ:\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u0002012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001002J:\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u0002012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001002J\u0010\u00105\u001a\u00020\u00102\b\u00106\u001a\u0004\u0018\u00010\u0001J\u000e\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004J\u001e\u00109\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0012J\u000e\u0010<\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004J\u0018\u0010=\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00042\b\b\u0002\u0010>\u001a\u00020\u0012J\u0015\u0010?\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u0004¢\u0006\u0004\b@\u0010AJ\f\u0010B\u001a\u00020\u0010*\u00020\u0004H\u0002J\u0010\u0010C\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004H\u0002J\u0010\u0010F\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004H\u0002J\u0014\u0010G\u001a\u00020\u0010*\u00020H2\u0006\u0010I\u001a\u00020EH\u0002J\f\u0010J\u001a\u00020\u0012*\u00020HH\u0002J\u0013\u0010K\u001a\u00020\u001c*\u00020\u0004H\u0002¢\u0006\u0004\bL\u0010AJ\u000e\u0010M\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004J\u001d\u0010N\u001a\u00020\u00122\u0006\u0010O\u001a\u00020!2\u0006\u0010P\u001a\u00020!H\u0000¢\u0006\u0002\bQJ7\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020!2\u0006\u0010X\u001a\u00020!H\u0000¢\u0006\u0002\bYJ1\u0010Z\u001a\u00020\u0012*\u0002012\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020!H\u0000¢\u0006\u0002\b[J\u0019\u0010\\\u001a\u00020\u0012*\u00020\u00042\u0006\u0010]\u001a\u00020\u0004H\u0000¢\u0006\u0002\b^J\u000e\u0010_\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Landroidx/compose/ui/spatial/RectManager;", "", "layoutNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/collection/IntObjectMap;)V", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "callbacks", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "", "isDirty", "", "isScreenOrWindowDirty", "isFragmented", "dispatchToken", "scheduledDispatchDeadline", "", "dispatchLambda", "invalidate", "updateOffsets", "screenOffset", "Landroidx/compose/ui/unit/IntOffset;", "windowOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "windowWidth", "", "windowHeight", "updateOffsets-gTq6Wqs", "(JJ[FII)V", "dispatchCallbacks", "scheduleDebounceCallback", "ensureSomethingScheduled", "removeScheduledCallback", "registerOnChangedCallback", "callback", "registerOnRectChangedCallback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "throttleMillis", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "registerOnGlobalLayoutCallback", "unregisterOnChangedCallback", "token", "invalidateCallbacksFor", "layoutNode", "updateFlagsFor", "focusable", "gesturable", "onLayoutLayerPositionalPropertiesChanged", "onLayoutPositionChanged", "forceUpdate", "getOffsetFromRectListFor", "getOffsetFromRectListFor-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "resetHasPositionalLayerTransformationsForSubtreeIfNeeded", "insertOrUpdateTransformedNodeSubhierarchy", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "insertOrUpdateTransformedNode", "boundingRectInRoot", "Landroidx/compose/ui/node/NodeCoordinator;", "rect", "hasPositionalLayerTransformations", "outerToInnerOffset", "outerToInnerOffset-Bjo55l4", "remove", "isTargetDrawnFirst", "targetId", "otherId", "isTargetDrawnFirst$ui", "findFocusableNodeFromRect", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "containerId", "findFocusableNodeFromRect$ui", "intersects", "intersects$ui", "isDescendantOf", "container", "isDescendantOf$ui", "unsetHasCallbacksFor", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RectManager {
    public static final int $stable = 8;
    private final MutableRect cachedRect;
    private final MutableObjectList<Function0<Unit>> callbacks;
    private final Function0<Unit> dispatchLambda;
    private Object dispatchToken;
    private boolean isDirty;
    private boolean isFragmented;
    private boolean isScreenOrWindowDirty;
    private final IntObjectMap<LayoutNode> layoutNodes;
    private final RectList rects;
    private long scheduledDispatchDeadline;
    private final ThrottledCallbacks throttledCallbacks;

    /* JADX WARN: Multi-variable type inference failed */
    public RectManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public RectManager(IntObjectMap<LayoutNode> intObjectMap) {
        this.layoutNodes = intObjectMap;
        this.rects = new RectList();
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList<>(0, 1, null);
        this.scheduledDispatchDeadline = -1L;
        this.dispatchLambda = new Function0<Unit>() { // from class: androidx.compose.ui.spatial.RectManager$dispatchLambda$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.dispatchToken = null;
                RectManager rectManager = this.this$0;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    rectManager.dispatchCallbacks();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
        };
        this.cachedRect = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ RectManager(IntObjectMap intObjectMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IntObjectMapKt.intObjectMapOf() : intObjectMap);
    }

    private final void boundingRectInRoot(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        while (nodeCoordinator != null) {
            LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
            if (nodeCoordinator == layoutNode.getOuterCoordinator$ui() && !layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot()) {
                long jM8349getOffsetFromRectListForBjo55l4 = m8349getOffsetFromRectListForBjo55l4(layoutNode);
                if (!IntOffset.m9241equalsimpl0(jM8349getOffsetFromRectListForBjo55l4, IntOffset.INSTANCE.m9252getMaxnOccac())) {
                    float fM9242getXimpl = IntOffset.m9242getXimpl(jM8349getOffsetFromRectListForBjo55l4);
                    mutableRect.m6065translatek4lQ0M(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m9243getYimpl(jM8349getOffsetFromRectListForBjo55l4))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fM9242getXimpl) << 32)));
                    return;
                }
            }
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                float[] fArrMo8145getUnderlyingMatrixsQKQjiQ = layer.mo8145getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.m6594isIdentity58bKbWc(fArrMo8145getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.m6577mapimpl(fArrMo8145getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
            long jMo8017getPositionnOccac = nodeCoordinator.getPosition();
            float fM9242getXimpl2 = IntOffset.m9242getXimpl(jMo8017getPositionnOccac);
            mutableRect.m6065translatek4lQ0M(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m9243getYimpl(jMo8017getPositionnOccac))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fM9242getXimpl2) << 32)));
            nodeCoordinator = nodeCoordinator.getWrappedBy();
        }
    }

    private final boolean hasPositionalLayerTransformations(NodeCoordinator nodeCoordinator) {
        OwnedLayer layer = nodeCoordinator.getLayer();
        return (layer == null || MatrixKt.m6594isIdentity58bKbWc(layer.mo8145getUnderlyingMatrixsQKQjiQ())) ? false : true;
    }

    private final void insertOrUpdateTransformedNode(LayoutNode layoutNode) {
        layoutNode.setHasPositionalLayerTransformationsInOffsetFromRoot$ui(true);
        layoutNode.m8001setLastOffsetFromParentgyyYBs$ui(IntOffset.INSTANCE.m9252getMaxnOccac());
        NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
        MeasurePassDelegate measurePassDelegate$ui = layoutNode.getMeasurePassDelegate$ui();
        int measuredWidth = measurePassDelegate$ui.getMeasuredWidth();
        int measuredHeight = measurePassDelegate$ui.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        boundingRectInRoot(outerCoordinator$ui, mutableRect);
        int left = (int) mutableRect.getLeft();
        int top = (int) mutableRect.getTop();
        int right = (int) mutableRect.getRight();
        int bottom = (int) mutableRect.getBottom();
        int semanticsId = layoutNode.getSemanticsId();
        boolean addedToRectList = layoutNode.getAddedToRectList();
        layoutNode.setAddedToRectList$ui(true);
        if (!addedToRectList || !this.rects.update(semanticsId, left, top, right, bottom)) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            RectList.insert$default(this.rects, semanticsId, left, top, right, bottom, parent$ui != null ? parent$ui.getSemanticsId() : -1, layoutNode.getNodes().m8049hasH91voCI$ui(NodeKind.m8088constructorimpl(1024)), layoutNode.getNodes().m8049hasH91voCI$ui(NodeKind.m8088constructorimpl(16)), this.throttledCallbacks.getRectChangedMap().containsKey(semanticsId), 0, 512, null);
        }
        invalidate();
    }

    private final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        insertOrUpdateTransformedNode(layoutNode);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.isPlaced()) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode2);
            }
        }
    }

    public static /* synthetic */ void onLayoutPositionChanged$default(RectManager rectManager, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        rectManager.onLayoutPositionChanged(layoutNode, z);
    }

    /* JADX INFO: renamed from: outerToInnerOffset-Bjo55l4, reason: not valid java name */
    private final long m8348outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
        long jM9253getZeronOccac = IntOffset.INSTANCE.m9253getZeronOccac();
        for (NodeCoordinator innerCoordinator$ui = layoutNode.getInnerCoordinator$ui(); innerCoordinator$ui != null && innerCoordinator$ui != outerCoordinator$ui; innerCoordinator$ui = innerCoordinator$ui.getWrappedBy()) {
            if (hasPositionalLayerTransformations(innerCoordinator$ui)) {
                return IntOffset.INSTANCE.m9252getMaxnOccac();
            }
            jM9253getZeronOccac = IntOffset.m9246plusqkQi6aY(jM9253getZeronOccac, innerCoordinator$ui.getPosition());
        }
        return jM9253getZeronOccac;
    }

    private final void resetHasPositionalLayerTransformationsForSubtreeIfNeeded(LayoutNode layoutNode) {
        if (!layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot() || hasPositionalLayerTransformations(layoutNode.getOuterCoordinator$ui())) {
            return;
        }
        layoutNode.setHasPositionalLayerTransformationsInOffsetFromRoot$ui(false);
        if (layoutNode.getOuterToInnerOffsetDirty()) {
            layoutNode.m8003setOuterToInnerOffsetgyyYBs$ui(m8348outerToInnerOffsetBjo55l4(layoutNode));
            layoutNode.setOuterToInnerOffsetDirty$ui(false);
        }
        if (IntOffset.m9241equalsimpl0(layoutNode.getOuterToInnerOffset(), IntOffset.INSTANCE.m9252getMaxnOccac())) {
            return;
        }
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            resetHasPositionalLayerTransformationsForSubtreeIfNeeded(layoutNodeArr[i]);
        }
    }

    public final void dispatchCallbacks() {
        removeScheduledCallback();
        long jCurrentTimeMillis = Actual_androidKt.currentTimeMillis();
        boolean z = this.isDirty;
        boolean z2 = z || this.isScreenOrWindowDirty;
        if (z) {
            this.isDirty = false;
            MutableObjectList<Function0<Unit>> mutableObjectList = this.callbacks;
            Object[] objArr = mutableObjectList.content;
            int i = mutableObjectList._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((Function0) objArr[i2]).invoke();
            }
            RectList rectList = this.rects;
            long[] jArr = rectList.items;
            int i3 = rectList.itemsSize;
            for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
                long j = jArr[i4 + 2];
                if ((((int) (j >> 60)) & 1) != 0) {
                    this.throttledCallbacks.fireOnUpdatedRect(33554431 & ((int) j), jArr[i4], jArr[i4 + 1], jCurrentTimeMillis);
                }
            }
            this.rects.clearUpdated();
        }
        if (this.isScreenOrWindowDirty) {
            this.isScreenOrWindowDirty = false;
            this.throttledCallbacks.fireOnRectChangedEntries(jCurrentTimeMillis);
        }
        if (z2) {
            this.throttledCallbacks.fireGlobalChangeEntries(jCurrentTimeMillis);
        }
        if (this.isFragmented) {
            this.isFragmented = false;
            this.rects.defragment();
        }
        this.throttledCallbacks.triggerDebounced(jCurrentTimeMillis);
        if (this.throttledCallbacks.getMinDebounceDeadline() > 0) {
            scheduleDebounceCallback(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final FocusTargetModifierNode findFocusableNodeFromRect$ui(int left, int top, int right, int bottom, int containerId) {
        int i;
        LayoutNode layoutNode;
        int i2;
        LayoutNode layoutNode2;
        byte b;
        Modifier.Node nodePop;
        FocusTargetNode focusTargetNode;
        int i3;
        LayoutNode layoutNode3;
        boolean z;
        int i4;
        LayoutNode layoutNode4;
        int i5;
        MutableVector mutableVector;
        SemanticsInfo semanticsInfoRequireSemanticsInfo;
        RectManager rectManager = this;
        LayoutNode layoutNode5 = rectManager.layoutNodes.get(containerId);
        if (layoutNode5 == null) {
            return null;
        }
        FocusTargetNode activeFocusTargetNode = LayoutNodeKt.requireOwner(layoutNode5).getFocusOwner().getActiveFocusTargetNode();
        int semanticsId = (activeFocusTargetNode == null || (semanticsInfoRequireSemanticsInfo = DelegatableNodeKt.requireSemanticsInfo(activeFocusTargetNode)) == null) ? -1 : semanticsInfoRequireSemanticsInfo.getSemanticsId();
        RectList rectList = rectManager.rects;
        int i6 = top;
        long j = (((long) i6) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) left) << 32);
        long j2 = (((long) bottom) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) right) << 32);
        long[] jArr = rectList.items;
        int i7 = rectList.itemsSize;
        int depth = Integer.MAX_VALUE;
        FocusTargetNode focusTargetNode2 = null;
        int i8 = 0;
        while (i8 < jArr.length - 2 && i8 < i7) {
            int i9 = i8;
            long j3 = jArr[i8 + 2];
            boolean z2 = true;
            if ((((int) (j3 >> 61)) & 1) != 0) {
                if (((((j2 - jArr[i9]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i9 + 1] - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0 || (layoutNode2 = rectManager.layoutNodes.get((i2 = ((int) j3) & 33554431))) == null) {
                    i = depth;
                    layoutNode = layoutNode5;
                } else {
                    if (semanticsId == i2) {
                        b = -1;
                        if (semanticsId != -1) {
                            return null;
                        }
                    } else {
                        b = -1;
                    }
                    if (layoutNode2.getDepth() >= depth || !rectManager.isDescendantOf$ui(layoutNode2, layoutNode5)) {
                        i = depth;
                        layoutNode = layoutNode5;
                    } else {
                        NodeChain nodes = layoutNode2.getNodes();
                        int iM8088constructorimpl = NodeKind.m8088constructorimpl(1024);
                        if ((nodes.getAggregateChildKindSet() & iM8088constructorimpl) != 0) {
                            Modifier.Node head = nodes.getHead();
                            while (head != null) {
                                if ((head.getKindSet() & iM8088constructorimpl) != 0) {
                                    MutableVector mutableVector2 = null;
                                    nodePop = head;
                                    while (nodePop != null) {
                                        if (nodePop instanceof FocusTargetNode) {
                                            i = depth;
                                            layoutNode = layoutNode5;
                                            break;
                                        }
                                        if ((nodePop.getKindSet() & iM8088constructorimpl) == 0 || !(nodePop instanceof DelegatingNode)) {
                                            i3 = depth;
                                            layoutNode3 = layoutNode5;
                                            z = true;
                                        } else {
                                            Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                                            int i10 = 0;
                                            while (delegate$ui != null) {
                                                if ((delegate$ui.getKindSet() & iM8088constructorimpl) != 0) {
                                                    i10++;
                                                    i4 = depth;
                                                    if (i10 == 1) {
                                                        nodePop = delegate$ui;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            i5 = i10;
                                                            layoutNode4 = layoutNode5;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            i5 = i10;
                                                            layoutNode4 = layoutNode5;
                                                            mutableVector = mutableVector2;
                                                        }
                                                        if (nodePop != null) {
                                                            if (mutableVector != null) {
                                                                mutableVector.add(nodePop);
                                                            }
                                                            nodePop = null;
                                                        }
                                                        if (mutableVector != null) {
                                                            mutableVector.add(delegate$ui);
                                                        }
                                                        mutableVector2 = mutableVector;
                                                        i10 = i5;
                                                        delegate$ui = delegate$ui.getChild();
                                                        depth = i4;
                                                        layoutNode5 = layoutNode4;
                                                    }
                                                } else {
                                                    i4 = depth;
                                                }
                                                layoutNode4 = layoutNode5;
                                                delegate$ui = delegate$ui.getChild();
                                                depth = i4;
                                                layoutNode5 = layoutNode4;
                                            }
                                            i3 = depth;
                                            layoutNode3 = layoutNode5;
                                            z = true;
                                            if (i10 == 1) {
                                            }
                                            z2 = z;
                                            depth = i3;
                                            layoutNode5 = layoutNode3;
                                        }
                                        nodePop = DelegatableNodeKt.pop(mutableVector2);
                                        z2 = z;
                                        depth = i3;
                                        layoutNode5 = layoutNode3;
                                    }
                                }
                                i = depth;
                                boolean z3 = z2;
                                layoutNode = layoutNode5;
                                if ((head.getAggregateChildKindSet() & iM8088constructorimpl) == 0) {
                                    break;
                                }
                                head = head.getChild();
                                z2 = z3;
                                depth = i;
                                layoutNode5 = layoutNode;
                            }
                            i = depth;
                            layoutNode = layoutNode5;
                            nodePop = null;
                            focusTargetNode = (FocusTargetNode) nodePop;
                            if (focusTargetNode == null) {
                                if (intersects$ui(focusTargetNode, left, i6, right, bottom)) {
                                    depth = layoutNode2.getDepth();
                                    focusTargetNode2 = focusTargetNode;
                                }
                            }
                        } else {
                            i = depth;
                            layoutNode = layoutNode5;
                            nodePop = null;
                            focusTargetNode = (FocusTargetNode) nodePop;
                            if (focusTargetNode == null) {
                            }
                        }
                    }
                    depth = i;
                }
                depth = i;
            } else {
                i = depth;
                layoutNode = layoutNode5;
                depth = i;
            }
            i8 = i9 + 3;
            rectManager = this;
            i6 = top;
            layoutNode5 = layoutNode;
        }
        return focusTargetNode2;
    }

    /* JADX INFO: renamed from: getOffsetFromRectListFor-Bjo55l4, reason: not valid java name */
    public final long m8349getOffsetFromRectListForBjo55l4(LayoutNode layoutNode) {
        long topLeft = this.rects.getTopLeft(layoutNode.getSemanticsId());
        if (topLeft == Long.MAX_VALUE) {
            return IntOffset.INSTANCE.m9252getMaxnOccac();
        }
        int i = (int) (topLeft >> 32);
        return IntOffset.m9236constructorimpl((((long) ((int) topLeft)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i) << 32));
    }

    public final RectList getRects() {
        return this.rects;
    }

    public final boolean intersects$ui(DelegatableNode delegatableNode, int i, int i2, int i3, int i4) {
        NodeCoordinator nodeCoordinatorM7940requireCoordinator64DMado = DelegatableNodeKt.m7940requireCoordinator64DMado(delegatableNode, NodeKind.m8088constructorimpl(1024));
        LayoutNode layoutNode = nodeCoordinatorM7940requireCoordinator64DMado.getLayoutNode();
        if (Intrinsics.areEqual(nodeCoordinatorM7940requireCoordinator64DMado, layoutNode.getOuterCoordinator$ui())) {
            return true;
        }
        long jMo7780localToRootMKHz9U = layoutNode.getOuterCoordinator$ui().mo7780localToRootMKHz9U(LayoutCoordinates.m7776localPositionOfS_NoaFU$default(layoutNode.getOuterCoordinator$ui(), nodeCoordinatorM7940requireCoordinator64DMado, 0L, false, 6, null));
        long jMo7777getSizeYbymL2g = nodeCoordinatorM7940requireCoordinator64DMado.mo7777getSizeYbymL2g();
        int iRound = Math.round(Float.intBitsToFloat((int) (jMo7780localToRootMKHz9U >> 32)));
        int i5 = ((int) (jMo7777getSizeYbymL2g >> 32)) + iRound;
        int iRound2 = Math.round(Float.intBitsToFloat((int) (jMo7780localToRootMKHz9U & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        return i < i5 && i3 > iRound && i2 < ((int) (jMo7777getSizeYbymL2g & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) + iRound2 && i4 > iRound2;
    }

    public final void invalidate() {
        this.isDirty = true;
    }

    public final void invalidateCallbacksFor(LayoutNode layoutNode) {
        if (layoutNode.getAddedToRectList()) {
            this.isDirty = true;
            this.rects.markUpdated(layoutNode.getSemanticsId());
        }
        scheduleDebounceCallback(true);
    }

    public final boolean isDescendantOf$ui(LayoutNode layoutNode, LayoutNode layoutNode2) {
        int depth = layoutNode.getDepth() - layoutNode2.getDepth();
        if (depth <= 0) {
            return false;
        }
        for (int i = 0; i < depth; i++) {
            layoutNode = layoutNode.getParent$ui();
            if (layoutNode == null) {
                return false;
            }
        }
        return layoutNode == layoutNode2;
    }

    public final boolean isTargetDrawnFirst$ui(int targetId, int otherId) {
        LayoutNode parent$ui;
        LayoutNode parent$ui2;
        LayoutNode parent$ui3 = this.layoutNodes.get(targetId);
        if (parent$ui3 != null && (parent$ui = this.layoutNodes.get(otherId)) != null && parent$ui3.getDepth() != 0 && parent$ui.getDepth() != 0) {
            while (parent$ui3.getDepth() > parent$ui.getDepth()) {
                parent$ui3 = parent$ui3.getParent$ui();
                if (parent$ui3 == null) {
                    return false;
                }
            }
            if (parent$ui3 == parent$ui) {
                return false;
            }
            while (parent$ui.getDepth() > parent$ui3.getDepth()) {
                parent$ui = parent$ui.getParent$ui();
                if (parent$ui == null) {
                    return false;
                }
            }
            if (parent$ui3 == parent$ui) {
                return false;
            }
            LayoutNode layoutNode = parent$ui3;
            LayoutNode layoutNode2 = layoutNode;
            LayoutNode layoutNode3 = parent$ui;
            while (layoutNode != parent$ui) {
                LayoutNode parent$ui4 = layoutNode.getParent$ui();
                if (parent$ui4 == null || (parent$ui2 = parent$ui.getParent$ui()) == null) {
                    return false;
                }
                layoutNode3 = parent$ui;
                parent$ui = parent$ui2;
                layoutNode2 = layoutNode;
                layoutNode = parent$ui4;
            }
            if (layoutNode2.getMeasurePassDelegate$ui().getZIndex() == layoutNode3.getMeasurePassDelegate$ui().getZIndex()) {
                return layoutNode2.getPlaceOrder$ui() < layoutNode3.getPlaceOrder$ui();
            }
            if (layoutNode2.getMeasurePassDelegate$ui().getZIndex() < layoutNode3.getMeasurePassDelegate$ui().getZIndex()) {
                return true;
            }
        }
        return false;
    }

    public final void onLayoutLayerPositionalPropertiesChanged(LayoutNode layoutNode) {
        if (layoutNode.isPlaced()) {
            long jM8348outerToInnerOffsetBjo55l4 = m8348outerToInnerOffsetBjo55l4(layoutNode);
            if (!RectManagerKt.m8354isSetgyyYBs(jM8348outerToInnerOffsetBjo55l4)) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
                return;
            }
            layoutNode.m8003setOuterToInnerOffsetgyyYBs$ui(jM8348outerToInnerOffsetBjo55l4);
            layoutNode.setOuterToInnerOffsetDirty$ui(false);
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                onLayoutPositionChanged$default(this, layoutNodeArr[i], false, 2, null);
            }
            invalidateCallbacksFor(layoutNode);
        }
    }

    public final void onLayoutPositionChanged(LayoutNode layoutNode, boolean forceUpdate) {
        long jM9253getZeronOccac;
        long j;
        long j2;
        if (layoutNode.isPlaced()) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            if (parent$ui == null || parent$ui.getHasPositionalLayerTransformationsInOffsetFromRoot()) {
                jM9253getZeronOccac = parent$ui == null ? IntOffset.INSTANCE.m9253getZeronOccac() : IntOffset.INSTANCE.m9252getMaxnOccac();
            } else {
                if (parent$ui.getOuterToInnerOffsetDirty()) {
                    parent$ui.setOuterToInnerOffsetDirty$ui(false);
                    parent$ui.m8003setOuterToInnerOffsetgyyYBs$ui(m8348outerToInnerOffsetBjo55l4(parent$ui));
                }
                jM9253getZeronOccac = parent$ui.getOuterToInnerOffset();
            }
            NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
            if (!RectManagerKt.m8354isSetgyyYBs(jM9253getZeronOccac) || hasPositionalLayerTransformations(outerCoordinator$ui)) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
                return;
            }
            if (layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot()) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
                resetHasPositionalLayerTransformationsForSubtreeIfNeeded(layoutNode);
                return;
            }
            long jM9246plusqkQi6aY = IntOffset.m9246plusqkQi6aY(jM9253getZeronOccac, outerCoordinator$ui.getPosition());
            MeasurePassDelegate measurePassDelegate$ui = layoutNode.getMeasurePassDelegate$ui();
            int measuredWidth = measurePassDelegate$ui.getMeasuredWidth();
            int measuredHeight = measurePassDelegate$ui.getMeasuredHeight();
            long jM9280constructorimpl = IntSize.m9280constructorimpl((((long) measuredWidth) << 32) | (((long) measuredHeight) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
            int semanticsId = layoutNode.getSemanticsId();
            if (layoutNode.getAddedToRectList()) {
                if (forceUpdate || !IntOffset.m9241equalsimpl0(jM9246plusqkQi6aY, layoutNode.getLastOffsetFromParent()) || !IntSize.m9283equalsimpl0(jM9280constructorimpl, layoutNode.getLastSize())) {
                    RectList rectList = this.rects;
                    if (parent$ui != null) {
                        rectList.moveBasedOnParentOffset(semanticsId, parent$ui.getSemanticsId(), IntOffset.m9242getXimpl(jM9246plusqkQi6aY), IntOffset.m9243getYimpl(jM9246plusqkQi6aY), measuredWidth, measuredHeight);
                    } else {
                        rectList.move(semanticsId, IntOffset.m9242getXimpl(jM9246plusqkQi6aY), IntOffset.m9243getYimpl(jM9246plusqkQi6aY), IntOffset.m9242getXimpl(jM9246plusqkQi6aY) + measuredWidth, IntOffset.m9243getYimpl(jM9246plusqkQi6aY) + measuredHeight);
                    }
                    invalidate();
                }
                j = jM9246plusqkQi6aY;
                j2 = jM9280constructorimpl;
            } else {
                layoutNode.setAddedToRectList$ui(true);
                boolean zM8049hasH91voCI$ui = layoutNode.getNodes().m8049hasH91voCI$ui(NodeKind.m8088constructorimpl(1024));
                boolean zM8049hasH91voCI$ui2 = layoutNode.getNodes().m8049hasH91voCI$ui(NodeKind.m8088constructorimpl(16));
                boolean zContainsKey = this.throttledCallbacks.getRectChangedMap().containsKey(semanticsId);
                RectList rectList2 = this.rects;
                if (parent$ui != null) {
                    j = jM9246plusqkQi6aY;
                    j2 = jM9280constructorimpl;
                    rectList2.insertBasedOnParentOffset(semanticsId, parent$ui.getSemanticsId(), IntOffset.m9242getXimpl(jM9246plusqkQi6aY), IntOffset.m9243getYimpl(jM9246plusqkQi6aY), measuredWidth, measuredHeight, zM8049hasH91voCI$ui, zM8049hasH91voCI$ui2, zContainsKey);
                } else {
                    j = jM9246plusqkQi6aY;
                    j2 = jM9280constructorimpl;
                    RectList.insert$default(rectList2, semanticsId, IntOffset.m9242getXimpl(j), IntOffset.m9243getYimpl(j), IntOffset.m9242getXimpl(j) + measuredWidth, IntOffset.m9243getYimpl(j) + measuredHeight, 0, zM8049hasH91voCI$ui, zM8049hasH91voCI$ui2, zContainsKey, 0, Videoio.CAP_PROP_XI_TRG_DELAY, null);
                }
                invalidate();
            }
            layoutNode.m8002setLastSizeozmzZPI$ui(j2);
            layoutNode.m8001setLastOffsetFromParentgyyYBs$ui(j);
        }
    }

    public final Object registerOnChangedCallback(Function0<Unit> callback) {
        this.callbacks.add(callback);
        return callback;
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalLayoutCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        return this.throttledCallbacks.registerOnGlobalChange(id, throttleMillis, debounceMillis, node, callback);
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChangedCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        DelegatableNode.RegistrationHandle registrationHandleRegisterOnRectChanged = this.throttledCallbacks.registerOnRectChanged(id, throttleMillis, debounceMillis, node, callback);
        if (DelegatableNodeKt.requireLayoutNode(node.getNode()).getAddedToRectList()) {
            this.rects.updateHasCallbacks(id, true);
        }
        invalidate();
        scheduleDebounceCallback(true);
        return registrationHandleRegisterOnRectChanged;
    }

    public final void remove(LayoutNode layoutNode) {
        if (layoutNode.getAddedToRectList()) {
            this.rects.remove(layoutNode.getSemanticsId());
            layoutNode.setAddedToRectList$ui(false);
            invalidate();
            this.isFragmented = true;
        }
    }

    public final void removeScheduledCallback() {
        Object obj = this.dispatchToken;
        if (obj != null) {
            Actual_androidKt.removePost(obj);
            this.dispatchToken = null;
        }
    }

    public final void scheduleDebounceCallback(boolean ensureSomethingScheduled) {
        boolean z = (ensureSomethingScheduled && this.dispatchToken == null) ? false : true;
        long minDebounceDeadline = this.throttledCallbacks.getMinDebounceDeadline();
        if (minDebounceDeadline >= 0 || !z) {
            if (this.scheduledDispatchDeadline == minDebounceDeadline && z) {
                return;
            }
            Object obj = this.dispatchToken;
            if (obj != null) {
                Actual_androidKt.removePost(obj);
            }
            long jCurrentTimeMillis = Actual_androidKt.currentTimeMillis();
            long jMax = Math.max(minDebounceDeadline, 16 + jCurrentTimeMillis);
            this.scheduledDispatchDeadline = jMax;
            this.dispatchToken = Actual_androidKt.postDelayed(jMax - jCurrentTimeMillis, this.dispatchLambda);
        }
    }

    public final void unregisterOnChangedCallback(Object token) {
        if ((TypeIntrinsics.isFunctionOfArity(token, 0) ? (Function0) token : null) == null) {
            return;
        }
        this.callbacks.remove(token);
    }

    public final void unsetHasCallbacksFor(LayoutNode layoutNode) {
        this.rects.updateHasCallbacks(layoutNode.getSemanticsId(), false);
    }

    public final void updateFlagsFor(LayoutNode layoutNode, boolean focusable, boolean gesturable) {
        if (layoutNode.isAttached()) {
            this.rects.updateFlagsFor(layoutNode.getSemanticsId(), focusable, gesturable);
        }
    }

    /* JADX INFO: renamed from: updateOffsets-gTq6Wqs, reason: not valid java name */
    public final void m8350updateOffsetsgTq6Wqs(long screenOffset, long windowOffset, float[] viewToWindowMatrix, int windowWidth, int windowHeight) {
        int iM8353analyzeComponents58bKbWc = RectManagerKt.m8353analyzeComponents58bKbWc(viewToWindowMatrix);
        ThrottledCallbacks throttledCallbacks = this.throttledCallbacks;
        if ((iM8353analyzeComponents58bKbWc & 2) != 0) {
            viewToWindowMatrix = null;
        }
        this.isScreenOrWindowDirty = throttledCallbacks.m8367updateOffsetsLDcG7Xg(screenOffset, windowOffset, viewToWindowMatrix, windowWidth, windowHeight) || this.isScreenOrWindowDirty;
    }
}
