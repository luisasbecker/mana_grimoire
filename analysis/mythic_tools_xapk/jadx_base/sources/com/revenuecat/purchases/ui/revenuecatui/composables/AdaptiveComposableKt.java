package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdaptiveComposable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b0\u0006H\u0001¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"AdaptiveComposable", "", "Landroidx/compose/foundation/layout/RowScope;", "modifier", "Landroidx/compose/ui/Modifier;", "composables", "", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/ui/Modifier;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release", "maxSize", "", "selectedIndex"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AdaptiveComposableKt {
    /* JADX WARN: Removed duplicated region for block: B:108:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AdaptiveComposable(final RowScope rowScope, Modifier modifier, final List<? extends Function2<? super Composer, ? super Integer, Unit>> composables, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Object objRememberedValue;
        Object objRememberedValue2;
        Object objRememberedValue3;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Modifier modifier3;
        Composer composerM5595constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        Iterator it;
        Object objRememberedValue4;
        int currentCompositeKeyHash3;
        Composer composerM5595constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        Intrinsics.checkNotNullParameter(composables, "composables");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1063564770);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AdaptiveComposable)P(1)25@1007L30,26@1058L87,31@1246L158,28@1151L1485:AdaptiveComposable.kt#51odh9");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 1;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 2) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(composables) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1063564770, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.AdaptiveComposable (AdaptiveComposable.kt:24)");
                }
                composerStartRestartGroup.startReplaceGroup(716737426);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AdaptiveComposable.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(716739115);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AdaptiveComposable.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                Object obj = objRememberedValue2;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf = SnapshotStateKt.mutableStateListOf();
                    int size = composables.size();
                    ArrayList arrayList = new ArrayList(size);
                    for (int i5 = 0; i5 < size; i5++) {
                        arrayList.add(0);
                    }
                    snapshotStateListMutableStateListOf.addAll(arrayList);
                    composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf);
                    obj = snapshotStateListMutableStateListOf;
                }
                final SnapshotStateList snapshotStateList = (SnapshotStateList) obj;
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                composerStartRestartGroup.startReplaceGroup(716745202);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AdaptiveComposable.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AdaptiveComposableKt$AdaptiveComposable$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates coordinates) {
                            Intrinsics.checkNotNullParameter(coordinates, "coordinates");
                            if (IntSize.m9285getWidthimpl(coordinates.mo7777getSizeYbymL2g()) != AdaptiveComposableKt.AdaptiveComposable$lambda$1(mutableState)) {
                                AdaptiveComposableKt.AdaptiveComposable$lambda$2(mutableState, IntSize.m9285getWidthimpl(coordinates.mo7777getSizeYbymL2g()));
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierAlign = rowScope.align(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierFillMaxWidth$default, (Function1) objRememberedValue3), Alignment.INSTANCE.getCenterVertically());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor);
                }
                composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789833128, "C39@1502L659,61@2192L290,74@2529L101:AdaptiveComposable.kt#51odh9");
                Modifier modifierAlign2 = boxScopeInstance.align(SizeKt.wrapContentWidth$default(SizeKt.fillMaxWidth$default(GraphicsLayerModifierKt.m6487graphicsLayerAp8cVGQ(Modifier.INSTANCE, (131064 & 1) != 0 ? 1.0f : 0.0f, (131064 & 2) != 0 ? 1.0f : 0.0f, (131064 & 4) == 0 ? 0.0f : 1.0f, (131064 & 8) != 0 ? 0.0f : 0.0f, (131064 & 16) != 0 ? 0.0f : 0.0f, (131064 & 32) != 0 ? 0.0f : 0.0f, (131064 & 64) != 0 ? 0.0f : 0.0f, (131064 & 128) != 0 ? 0.0f : 0.0f, (131064 & 256) == 0 ? 0.0f : 0.0f, (131064 & 512) != 0 ? 8.0f : 0.0f, (131064 & 1024) != 0 ? TransformOrigin.INSTANCE.m6738getCenterSzJe1aQ() : 0L, (131064 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (131064 & 4096) != 0 ? false : false, (131064 & 8192) != 0 ? null : null, (131064 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (32768 & 131064) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131064 & 65536) != 0 ? CompositingStrategy.INSTANCE.m6414getAutoNrFUSI() : 0), 0.0f, 1, null), null, true, 1, null), Alignment.INSTANCE.getCenter());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                modifier3 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor2);
                }
                composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -816702555, "C:AdaptiveComposable.kt#51odh9");
                composerStartRestartGroup.startReplaceGroup(1913317778);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*48@1824L247,47@1783L354");
                it = composables.iterator();
                final int i6 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Function2 function2 = (Function2) next;
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    composerStartRestartGroup.startReplaceGroup(-1953748216);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AdaptiveComposable.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(i6);
                    Iterator it2 = it;
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AdaptiveComposableKt$AdaptiveComposable$2$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m10615invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m10615invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Intrinsics.checkNotNullParameter(measurable, "measurable");
                                if (snapshotStateList.get(i6).intValue() == 0) {
                                    snapshotStateList.set(i6, Integer.valueOf(measurable.mo7769measureBRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null)).getWidth()));
                                }
                                return MeasureScope.layout$default(layout, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AdaptiveComposableKt$AdaptiveComposable$2$1$1$1$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope layout2) {
                                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierLayout = LayoutModifierKt.layout(companion2, (Function3) objRememberedValue5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayout);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composerStartRestartGroup);
                    Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -896542707, "C56@2113L6:AdaptiveComposable.kt#51odh9");
                    function2.invoke(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    it = it2;
                    i6 = i7;
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.startReplaceGroup(-944331595);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AdaptiveComposable.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AdaptiveComposableKt$AdaptiveComposable$2$selectedIndex$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            int size2 = snapshotStateList.size();
                            for (int i8 = 0; i8 < size2; i8++) {
                                if (snapshotStateList.get(i8).intValue() <= AdaptiveComposableKt.AdaptiveComposable$lambda$1(mutableState)) {
                                    return Integer.valueOf(i8);
                                }
                            }
                            return 0;
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                State state = (State) objRememberedValue4;
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierAlign3 = boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor4);
                }
                composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -815852907, "C75@2592L28:AdaptiveComposable.kt#51odh9");
                composables.get(AdaptiveComposable$lambda$14$lambda$12(state)).invoke(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AdaptiveComposableKt.AdaptiveComposable.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        AdaptiveComposableKt.AdaptiveComposable(rowScope, modifier4, composables, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i2 & 2) == 0) {
        }
        if ((i3 & 147) == 146) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.startReplaceGroup(716737426);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AdaptiveComposable.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final MutableState<Integer> mutableState2 = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(716739115);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AdaptiveComposable.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            Object obj2 = objRememberedValue2;
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            final SnapshotStateList<Integer> snapshotStateList2 = (SnapshotStateList) obj2;
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            composerStartRestartGroup.startReplaceGroup(716745202);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AdaptiveComposable.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierAlign4 = rowScope.align(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierFillMaxWidth$default2, (Function1) objRememberedValue3), Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign4);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789833128, "C39@1502L659,61@2192L290,74@2529L101:AdaptiveComposable.kt#51odh9");
                Modifier modifierAlign22 = boxScopeInstance5.align(SizeKt.wrapContentWidth$default(SizeKt.fillMaxWidth$default(GraphicsLayerModifierKt.m6487graphicsLayerAp8cVGQ(Modifier.INSTANCE, (131064 & 1) != 0 ? 1.0f : 0.0f, (131064 & 2) != 0 ? 1.0f : 0.0f, (131064 & 4) == 0 ? 0.0f : 1.0f, (131064 & 8) != 0 ? 0.0f : 0.0f, (131064 & 16) != 0 ? 0.0f : 0.0f, (131064 & 32) != 0 ? 0.0f : 0.0f, (131064 & 64) != 0 ? 0.0f : 0.0f, (131064 & 128) != 0 ? 0.0f : 0.0f, (131064 & 256) == 0 ? 0.0f : 0.0f, (131064 & 512) != 0 ? 8.0f : 0.0f, (131064 & 1024) != 0 ? TransformOrigin.INSTANCE.m6738getCenterSzJe1aQ() : 0L, (131064 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (131064 & 4096) != 0 ? false : false, (131064 & 8192) != 0 ? null : null, (131064 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (32768 & 131064) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131064 & 65536) != 0 ? CompositingStrategy.INSTANCE.m6414getAutoNrFUSI() : 0), 0.0f, 1, null), null, true, 1, null), Alignment.INSTANCE.getCenter());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign22);
                Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                modifier3 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl2.getInserting()) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier22, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -816702555, "C:AdaptiveComposable.kt#51odh9");
                    composerStartRestartGroup.startReplaceGroup(1913317778);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*48@1824L247,47@1783L354");
                    it = composables.iterator();
                    final int i62 = 0;
                    while (it.hasNext()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.startReplaceGroup(-944331595);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AdaptiveComposable.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    }
                    State state2 = (State) objRememberedValue4;
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierAlign32 = boxScopeInstance5.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy42 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap42 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier42 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign32);
                    Function0<ComposeUiNode> constructor42 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy42, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap42, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5595constructorimpl3.getInserting()) {
                        composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier42, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance42 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -815852907, "C75@2592L28:AdaptiveComposable.kt#51odh9");
                        composables.get(AdaptiveComposable$lambda$14$lambda$12(state2)).invoke(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AdaptiveComposable$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final int AdaptiveComposable$lambda$14$lambda$12(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AdaptiveComposable$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }
}
