package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: NodeKind.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\tR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\tR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\tR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\tR!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\tR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\tR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010\tR!\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\tR!\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\tR!\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0003\u001a\u0004\b1\u0010\tR!\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0003\u001a\u0004\b5\u0010\tR!\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0003\u001a\u0004\b9\u0010\tR!\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010\tR!\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0003\u001a\u0004\bA\u0010\tR!\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0003\u001a\u0004\bE\u0010\tR!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0003\u001a\u0004\bI\u0010\tR!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0003\u001a\u0004\bM\u0010\tR!\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0003\u001a\u0004\bQ\u0010\tR!\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bT\u0010\u0003\u001a\u0004\bU\u0010\tR!\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010\u0003\u001a\u0004\bY\u0010\tR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020#0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010\u0003\u001a\u0004\b\\\u0010\tR!\u0010]\u001a\b\u0012\u0004\u0012\u00020^0\u00058Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010\u0003\u001a\u0004\b`\u0010\t¨\u0006a"}, d2 = {"Landroidx/compose/ui/node/Nodes;", "", "<init>", "()V", "Any", "Landroidx/compose/ui/node/NodeKind;", "Landroidx/compose/ui/Modifier$Node;", "getAny-OLwlOKw$annotations", "getAny-OLwlOKw", "()I", "Layout", "Landroidx/compose/ui/node/LayoutModifierNode;", "getLayout-OLwlOKw$annotations", "getLayout-OLwlOKw", "Draw", "Landroidx/compose/ui/node/DrawModifierNode;", "getDraw-OLwlOKw$annotations", "getDraw-OLwlOKw", "Semantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemantics-OLwlOKw$annotations", "getSemantics-OLwlOKw", "PointerInput", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInput-OLwlOKw$annotations", "getPointerInput-OLwlOKw", "Locals", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "getLocals-OLwlOKw$annotations", "getLocals-OLwlOKw", "ParentData", "Landroidx/compose/ui/node/ParentDataModifierNode;", "getParentData-OLwlOKw$annotations", "getParentData-OLwlOKw", "OnRemeasured", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "getOnRemeasured-OLwlOKw$annotations", "getOnRemeasured-OLwlOKw", "GlobalPositionAware", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "getGlobalPositionAware-OLwlOKw$annotations", "getGlobalPositionAware-OLwlOKw", "ApproachMeasure", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "getApproachMeasure-OLwlOKw$annotations", "getApproachMeasure-OLwlOKw", "FocusTarget", "Landroidx/compose/ui/focus/FocusTargetNode;", "getFocusTarget-OLwlOKw$annotations", "getFocusTarget-OLwlOKw", "FocusProperties", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "getFocusProperties-OLwlOKw$annotations", "getFocusProperties-OLwlOKw", "FocusEvent", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "getFocusEvent-OLwlOKw$annotations", "getFocusEvent-OLwlOKw", "KeyInput", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "getKeyInput-OLwlOKw$annotations", "getKeyInput-OLwlOKw", "RotaryInput", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "getRotaryInput-OLwlOKw$annotations", "getRotaryInput-OLwlOKw", "CompositionLocalConsumer", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "getCompositionLocalConsumer-OLwlOKw$annotations", "getCompositionLocalConsumer-OLwlOKw", "SoftKeyboardKeyInput", "Landroidx/compose/ui/input/key/SoftKeyboardInterceptionModifierNode;", "getSoftKeyboardKeyInput-OLwlOKw$annotations", "getSoftKeyboardKeyInput-OLwlOKw", "Traversable", "Landroidx/compose/ui/node/TraversableNode;", "getTraversable-OLwlOKw$annotations", "getTraversable-OLwlOKw", "BringIntoView", "Landroidx/compose/ui/relocation/BringIntoViewModifierNode;", "getBringIntoView-OLwlOKw$annotations", "getBringIntoView-OLwlOKw", "Unplaced", "Landroidx/compose/ui/node/UnplacedAwareModifierNode;", "getUnplaced-OLwlOKw$annotations", "getUnplaced-OLwlOKw", "IndirectPointerInput", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "getIndirectPointerInput-OLwlOKw$annotations", "getIndirectPointerInput-OLwlOKw", "OnPlaced", "getOnPlaced-OLwlOKw$annotations", "getOnPlaced-OLwlOKw", "BeyondBoundsLayout", "Landroidx/compose/ui/layout/BeyondBoundsLayoutProviderModifierNode;", "getBeyondBoundsLayout-OLwlOKw$annotations", "getBeyondBoundsLayout-OLwlOKw", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Nodes {
    public static final int $stable = 0;
    public static final Nodes INSTANCE = new Nodes();

    private Nodes() {
    }

    /* JADX INFO: renamed from: getAny-OLwlOKw, reason: not valid java name */
    public static final int m8099getAnyOLwlOKw() {
        return NodeKind.m8088constructorimpl(1);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getAny-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8100getAnyOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getApproachMeasure-OLwlOKw, reason: not valid java name */
    public static final int m8101getApproachMeasureOLwlOKw() {
        return NodeKind.m8088constructorimpl(512);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getApproachMeasure-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8102getApproachMeasureOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getBeyondBoundsLayout-OLwlOKw, reason: not valid java name */
    public static final int m8103getBeyondBoundsLayoutOLwlOKw() {
        return NodeKind.m8088constructorimpl(8388608);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getBeyondBoundsLayout-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8104getBeyondBoundsLayoutOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getBringIntoView-OLwlOKw, reason: not valid java name */
    public static final int m8105getBringIntoViewOLwlOKw() {
        return NodeKind.m8088constructorimpl(524288);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getBringIntoView-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8106getBringIntoViewOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getCompositionLocalConsumer-OLwlOKw, reason: not valid java name */
    public static final int m8107getCompositionLocalConsumerOLwlOKw() {
        return NodeKind.m8088constructorimpl(32768);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getCompositionLocalConsumer-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8108getCompositionLocalConsumerOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getDraw-OLwlOKw, reason: not valid java name */
    public static final int m8109getDrawOLwlOKw() {
        return NodeKind.m8088constructorimpl(4);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getDraw-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8110getDrawOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getFocusEvent-OLwlOKw, reason: not valid java name */
    public static final int m8111getFocusEventOLwlOKw() {
        return NodeKind.m8088constructorimpl(4096);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getFocusEvent-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8112getFocusEventOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getFocusProperties-OLwlOKw, reason: not valid java name */
    public static final int m8113getFocusPropertiesOLwlOKw() {
        return NodeKind.m8088constructorimpl(2048);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getFocusProperties-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8114getFocusPropertiesOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getFocusTarget-OLwlOKw, reason: not valid java name */
    public static final int m8115getFocusTargetOLwlOKw() {
        return NodeKind.m8088constructorimpl(1024);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getFocusTarget-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8116getFocusTargetOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getGlobalPositionAware-OLwlOKw, reason: not valid java name */
    public static final int m8117getGlobalPositionAwareOLwlOKw() {
        return NodeKind.m8088constructorimpl(256);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getGlobalPositionAware-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8118getGlobalPositionAwareOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getIndirectPointerInput-OLwlOKw, reason: not valid java name */
    public static final int m8119getIndirectPointerInputOLwlOKw() {
        return NodeKind.m8088constructorimpl(2097152);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getIndirectPointerInput-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8120getIndirectPointerInputOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getKeyInput-OLwlOKw, reason: not valid java name */
    public static final int m8121getKeyInputOLwlOKw() {
        return NodeKind.m8088constructorimpl(8192);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getKeyInput-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8122getKeyInputOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getLayout-OLwlOKw, reason: not valid java name */
    public static final int m8123getLayoutOLwlOKw() {
        return NodeKind.m8088constructorimpl(2);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getLayout-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8124getLayoutOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getLocals-OLwlOKw, reason: not valid java name */
    public static final int m8125getLocalsOLwlOKw() {
        return NodeKind.m8088constructorimpl(32);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getLocals-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8126getLocalsOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getOnPlaced-OLwlOKw, reason: not valid java name */
    public static final int m8127getOnPlacedOLwlOKw() {
        return NodeKind.m8088constructorimpl(4194304);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getOnPlaced-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8128getOnPlacedOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getOnRemeasured-OLwlOKw, reason: not valid java name */
    public static final int m8129getOnRemeasuredOLwlOKw() {
        return NodeKind.m8088constructorimpl(128);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getOnRemeasured-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8130getOnRemeasuredOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getParentData-OLwlOKw, reason: not valid java name */
    public static final int m8131getParentDataOLwlOKw() {
        return NodeKind.m8088constructorimpl(64);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getParentData-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8132getParentDataOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getPointerInput-OLwlOKw, reason: not valid java name */
    public static final int m8133getPointerInputOLwlOKw() {
        return NodeKind.m8088constructorimpl(16);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getPointerInput-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8134getPointerInputOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getRotaryInput-OLwlOKw, reason: not valid java name */
    public static final int m8135getRotaryInputOLwlOKw() {
        return NodeKind.m8088constructorimpl(16384);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getRotaryInput-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8136getRotaryInputOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getSemantics-OLwlOKw, reason: not valid java name */
    public static final int m8137getSemanticsOLwlOKw() {
        return NodeKind.m8088constructorimpl(8);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getSemantics-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8138getSemanticsOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getSoftKeyboardKeyInput-OLwlOKw, reason: not valid java name */
    public static final int m8139getSoftKeyboardKeyInputOLwlOKw() {
        return NodeKind.m8088constructorimpl(131072);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getSoftKeyboardKeyInput-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8140getSoftKeyboardKeyInputOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getTraversable-OLwlOKw, reason: not valid java name */
    public static final int m8141getTraversableOLwlOKw() {
        return NodeKind.m8088constructorimpl(262144);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getTraversable-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8142getTraversableOLwlOKw$annotations() {
    }

    /* JADX INFO: renamed from: getUnplaced-OLwlOKw, reason: not valid java name */
    public static final int m8143getUnplacedOLwlOKw() {
        return NodeKind.m8088constructorimpl(1048576);
    }

    @JvmStatic
    /* JADX INFO: renamed from: getUnplaced-OLwlOKw$annotations, reason: not valid java name */
    public static /* synthetic */ void m8144getUnplacedOLwlOKw$annotations() {
    }
}
