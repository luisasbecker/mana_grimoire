package androidx.compose.material3;

import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: DragHandle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\f\u001a0\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0002¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"VerticalDragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "sizes", "Landroidx/compose/material3/DragHandleSizes;", "colors", "Landroidx/compose/material3/DragHandleColors;", "shapes", "Landroidx/compose/material3/DragHandleShapes;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DragHandleSizes;Landroidx/compose/material3/DragHandleColors;Landroidx/compose/material3/DragHandleShapes;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "pressable", "onPressed", "Lkotlin/Function0;", "onReleasedOrCancelled", "material3", "isDragged", "", "isPressed"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragHandleKt {
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VerticalDragHandle(Modifier modifier, DragHandleSizes dragHandleSizes, DragHandleColors dragHandleColors, DragHandleShapes dragHandleShapes, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        DragHandleSizes dragHandleSizes2;
        final DragHandleColors dragHandleColorsColors;
        final DragHandleShapes dragHandleShapesShapes;
        MutableInteractionSource mutableInteractionSource2;
        final DragHandleSizes dragHandleSizes3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final DragHandleSizes dragHandleSizesSizes;
        MutableInteractionSource mutableInteractionSource3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1693656835);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalDragHandle)N(modifier,sizes,colors,shapes,interactionSource)81@3988L25,82@4035L34,88@4262L20,88@4284L21,89@4338L307,98@4670L796,115@5495L299,83@4074L1783:DragHandle.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                dragHandleSizes2 = dragHandleSizes;
                int i5 = composerStartRestartGroup.changed(dragHandleSizes2) ? 32 : 16;
                i3 |= i5;
            } else {
                dragHandleSizes2 = dragHandleSizes;
            }
            i3 |= i5;
        } else {
            dragHandleSizes2 = dragHandleSizes;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                dragHandleColorsColors = dragHandleColors;
                int i6 = composerStartRestartGroup.changed(dragHandleColorsColors) ? 256 : 128;
                i3 |= i6;
            } else {
                dragHandleColorsColors = dragHandleColors;
            }
            i3 |= i6;
        } else {
            dragHandleColorsColors = dragHandleColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                dragHandleShapesShapes = dragHandleShapes;
                int i7 = composerStartRestartGroup.changed(dragHandleShapesShapes) ? 2048 : 1024;
                i3 |= i7;
            } else {
                dragHandleShapesShapes = dragHandleShapes;
            }
            i3 |= i7;
        } else {
            dragHandleShapesShapes = dragHandleShapes;
        }
        int i8 = i2 & 16;
        if (i8 == 0) {
            if ((i & 24576) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
            }
            boolean z = true;
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                dragHandleSizes3 = dragHandleSizes2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@3689L8,76@3757L8");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        dragHandleSizesSizes = VerticalDragHandleDefaults.INSTANCE.sizes();
                        i3 &= -113;
                    } else {
                        dragHandleSizesSizes = dragHandleSizes2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        dragHandleColorsColors = VerticalDragHandleDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        dragHandleShapesShapes = VerticalDragHandleDefaults.INSTANCE.shapes(composerStartRestartGroup, 6);
                    }
                    if (i8 != 0) {
                        mutableInteractionSource2 = null;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    companion = modifier2;
                    dragHandleSizesSizes = dragHandleSizes2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1693656835, i3, -1, "androidx.compose.material3.VerticalDragHandle (DragHandle.kt:78)");
                }
                if (mutableInteractionSource2 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1544610024);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@3909L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188373462, "CC(remember):DragHandle.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-188374113);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                final State<Boolean> stateCollectIsDraggedAsState = DragInteractionKt.collectIsDraggedAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188369435, "CC(remember):DragHandle.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier3 = companion;
                Modifier modifierHoverable$default = HoverableKt.hoverable$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(companion), mutableInteractionSource3, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188362185, "CC(remember):DragHandle.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DragHandleKt.VerticalDragHandle$lambda$6$lambda$5(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188361480, "CC(remember):DragHandle.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DragHandleKt.VerticalDragHandle$lambda$8$lambda$7(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPressable = pressable(modifierHoverable$default, mutableInteractionSource3, function0, (Function0) objRememberedValue4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188359466, "CC(remember):DragHandle.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(stateCollectIsDraggedAsState) | ((((i3 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(dragHandleShapesShapes)) || (i3 & 3072) == 2048);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DragHandleKt.VerticalDragHandle$lambda$10$lambda$9(dragHandleShapesShapes, stateCollectIsDraggedAsState, mutableState, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierPressable, (Function1) objRememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188348353, "CC(remember):DragHandle.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(stateCollectIsDraggedAsState) | ((((i3 & 112) ^ 48) > 32 && composerStartRestartGroup.changed(dragHandleSizesSizes)) || (i3 & 48) == 32);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function3() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return DragHandleKt.VerticalDragHandle$lambda$13$lambda$12(dragHandleSizesSizes, stateCollectIsDraggedAsState, mutableState, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierLayout = LayoutModifierKt.layout(modifierGraphicsLayer, (Function3) objRememberedValue6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -188322450, "CC(remember):DragHandle.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(stateCollectIsDraggedAsState);
                if ((((i3 & 896) ^ 384) <= 256 || !composerStartRestartGroup.changed(dragHandleColorsColors)) && (i3 & 384) != 256) {
                    z = false;
                }
                boolean z2 = zChanged3 | z;
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DragHandleKt.VerticalDragHandle$lambda$15$lambda$14(dragHandleColorsColors, stateCollectIsDraggedAsState, mutableState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxKt.Box(IndicationKt.indication(DrawModifierKt.drawBehind(modifierLayout, (Function1) objRememberedValue7), mutableInteractionSource4, RippleKt.m3978rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dragHandleSizes3 = dragHandleSizesSizes;
                modifier2 = modifier3;
            }
            final DragHandleColors dragHandleColors2 = dragHandleColorsColors;
            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier4 = modifier2;
                final DragHandleShapes dragHandleShapes2 = dragHandleShapesShapes;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DragHandleKt.VerticalDragHandle$lambda$16(modifier4, dragHandleSizes3, dragHandleColors2, dragHandleShapes2, mutableInteractionSource5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        boolean z3 = true;
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        final DragHandleColors dragHandleColors22 = dragHandleColorsColors;
        final MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final boolean VerticalDragHandle$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static final Unit VerticalDragHandle$lambda$10$lambda$9(DragHandleShapes dragHandleShapes, State state, MutableState mutableState, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setShape(VerticalDragHandle$lambda$1(state) ? dragHandleShapes.getDraggedShape() : VerticalDragHandle$lambda$3(mutableState) ? dragHandleShapes.getPressedShape() : dragHandleShapes.getShape());
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }

    static final MeasureResult VerticalDragHandle$lambda$13$lambda$12(DragHandleSizes dragHandleSizes, State state, MutableState mutableState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        long j = measureScope.mo1625toSizeXkaWNTQ(VerticalDragHandle$lambda$1(state) ? dragHandleSizes.getDraggedSize() : VerticalDragHandle$lambda$3(mutableState) ? dragHandleSizes.getPressedSize() : dragHandleSizes.getSize());
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(Constraints.INSTANCE.m9077fixedJhjzzOo(Math.round(Float.intBitsToFloat((int) (j >> 32))), Math.round(Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))));
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DragHandleKt.VerticalDragHandle$lambda$13$lambda$12$lambda$11(placeableMo7769measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit VerticalDragHandle$lambda$13$lambda$12$lambda$11(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit VerticalDragHandle$lambda$15$lambda$14(DragHandleColors dragHandleColors, State state, MutableState mutableState, DrawScope drawScope) {
        DrawScope.m6893drawRectnJ9OG0$default(drawScope, VerticalDragHandle$lambda$1(state) ? dragHandleColors.getDraggedColor() : VerticalDragHandle$lambda$3(mutableState) ? dragHandleColors.getPressedColor() : dragHandleColors.getColor(), 0L, 0L, 0.0f, null, null, 0, 126, null);
        return Unit.INSTANCE;
    }

    static final Unit VerticalDragHandle$lambda$16(Modifier modifier, DragHandleSizes dragHandleSizes, DragHandleColors dragHandleColors, DragHandleShapes dragHandleShapes, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        VerticalDragHandle(modifier, dragHandleSizes, dragHandleColors, dragHandleShapes, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final boolean VerticalDragHandle$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VerticalDragHandle$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit VerticalDragHandle$lambda$6$lambda$5(MutableState mutableState) {
        VerticalDragHandle$lambda$4(mutableState, true);
        return Unit.INSTANCE;
    }

    static final Unit VerticalDragHandle$lambda$8$lambda$7(MutableState mutableState) {
        VerticalDragHandle$lambda$4(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final Modifier pressable(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Function0<Unit> function0, final Function0<Unit> function02) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mutableInteractionSource, new PointerInputEventHandler() { // from class: androidx.compose.material3.DragHandleKt.pressable.1

            /* JADX INFO: renamed from: androidx.compose.material3.DragHandleKt$pressable$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: DragHandle.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DragHandleKt$pressable$1$1", f = "DragHandle.kt", i = {0}, l = {FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 343}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
            static final class C00661 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $onPressed;
                final /* synthetic */ Function0<Unit> $onReleasedOrCancelled;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00661(Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C00661> continuation) {
                    super(2, continuation);
                    this.$onPressed = function0;
                    this.$onReleasedOrCancelled = function02;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00661 c00661 = new C00661(this.$onPressed, this.$onReleasedOrCancelled, continuation);
                    c00661.L$0 = obj;
                    return c00661;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C00661) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
                
                    if (androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, androidx.compose.ui.input.pointer.PointerEventPass.Initial, r10) == r0) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope2;
                        this.label = 1;
                        if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, PointerEventPass.Initial, this, 1, null) != coroutine_suspended) {
                            awaitPointerEventScope = awaitPointerEventScope2;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$onReleasedOrCancelled.invoke();
                        return Unit.INSTANCE;
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.$onPressed.invoke();
                    this.L$0 = null;
                    this.label = 2;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C00661(function0, function02, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        });
    }
}
