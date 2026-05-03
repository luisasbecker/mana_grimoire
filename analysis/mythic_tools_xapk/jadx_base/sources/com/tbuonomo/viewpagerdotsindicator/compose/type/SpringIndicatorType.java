package com.tbuonomo.viewpagerdotsindicator.compose.type;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.tbuonomo.viewpagerdotsindicator.compose.DotKt;
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpringIndicatorType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005JN\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014JB\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d²\u0006\n\u0010\u0016\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/compose/type/SpringIndicatorType;", "Lcom/tbuonomo/viewpagerdotsindicator/compose/type/IndicatorType;", "dotsGraphic", "Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;", "selectorDotGraphic", "(Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;)V", "IndicatorTypeComposable", "", "globalOffsetProvider", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "dotCount", "", "dotSpacing", "Landroidx/compose/ui/unit/Dp;", "onDotClicked", "Lkotlin/Function1;", "IndicatorTypeComposable--jt2gSs", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;IFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "computeSelectorDotPositionDp", "firstDotPositionX", "lastDotPositionX", "globalOffset", AndroidContextPlugin.SCREEN_DENSITY_KEY, "centeredOffset", "computeSelectorDotPositionDp-tI-LSbM", "(FFIFFF)F", "viewpagerdotsindicator_release", "foregroundDotPositionDp"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SpringIndicatorType extends IndicatorType {
    public static final int $stable = 0;
    private final DotGraphic dotsGraphic;
    private final DotGraphic selectorDotGraphic;

    /* JADX WARN: Multi-variable type inference failed */
    public SpringIndicatorType() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public SpringIndicatorType(DotGraphic dotsGraphic, DotGraphic selectorDotGraphic) {
        Intrinsics.checkNotNullParameter(dotsGraphic, "dotsGraphic");
        Intrinsics.checkNotNullParameter(selectorDotGraphic, "selectorDotGraphic");
        this.dotsGraphic = dotsGraphic;
        this.selectorDotGraphic = selectorDotGraphic;
    }

    public /* synthetic */ SpringIndicatorType(DotGraphic dotGraphic, DotGraphic dotGraphic2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DotGraphic(0.0f, 0L, null, null, 0L, 31, null) : dotGraphic, (i & 2) != 0 ? new DotGraphic(0.0f, Color.INSTANCE.m6351getBlack0d7_KjU(), null, null, 0L, 29, null) : dotGraphic2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float IndicatorTypeComposable__jt2gSs$lambda$1(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    private static final float IndicatorTypeComposable__jt2gSs$lambda$11$lambda$10(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float IndicatorTypeComposable__jt2gSs$lambda$11$lambda$8(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IndicatorTypeComposable__jt2gSs$lambda$2(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float IndicatorTypeComposable__jt2gSs$lambda$4(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IndicatorTypeComposable__jt2gSs$lambda$5(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeSelectorDotPositionDp-tI-LSbM, reason: not valid java name */
    public final float m11300computeSelectorDotPositionDptILSbM(float firstDotPositionX, float lastDotPositionX, int dotCount, float globalOffset, float density, float centeredOffset) {
        return Dp.m9114constructorimpl(Dp.m9114constructorimpl((firstDotPositionX + (((lastDotPositionX - firstDotPositionX) / (dotCount - 1)) * globalOffset)) / density) + centeredOffset);
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.compose.type.IndicatorType
    /* JADX INFO: renamed from: IndicatorTypeComposable--jt2gSs */
    public void mo11295IndicatorTypeComposablejt2gSs(final Function0<Float> globalOffsetProvider, final Modifier modifier, final int i, final float f, final Function1<? super Integer, Unit> function1, Composer composer, final int i2) {
        int i3;
        final MutableState mutableState;
        final MutableState mutableState2;
        int i4;
        int i5;
        Object obj;
        Composer composer2;
        final SpringIndicatorType springIndicatorType = this;
        Intrinsics.checkNotNullParameter(globalOffsetProvider, "globalOffsetProvider");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(1001950278);
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(globalOffsetProvider) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i2 & 57344) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i2 & 458752) == 0) {
            i3 |= composerStartRestartGroup.changed(springIndicatorType) ? 131072 : 65536;
        }
        if ((374491 & i3) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1001950278, i3, -1, "com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType.IndicatorTypeComposable (SpringIndicatorType.kt:28)");
            }
            DotGraphic dotGraphic = springIndicatorType.dotsGraphic;
            composerStartRestartGroup.startReplaceGroup(2028453812);
            int i6 = i3 & 896;
            boolean zChanged = (i6 == 256) | composerStartRestartGroup.changed(dotGraphic);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(-1.0f), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            DotGraphic dotGraphic2 = springIndicatorType.dotsGraphic;
            composerStartRestartGroup.startReplaceGroup(2028456852);
            boolean zChanged2 = (i6 == 256) | composerStartRestartGroup.changed(dotGraphic2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(-1.0f), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i7 = i3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal horizontalM1908spacedByD5KLDUw = Arrangement.INSTANCE.m1908spacedByD5KLDUw(f, Alignment.INSTANCE.getCenterHorizontally());
            PaddingValues paddingValuesM2034PaddingValuesa9UjIt4$default = PaddingKt.m2034PaddingValuesa9UjIt4$default(f, 0.0f, f, 0.0f, 10, null);
            composerStartRestartGroup.startReplaceGroup(-1014803039);
            boolean zChanged3 = composerStartRestartGroup.changed(mutableState3) | (i6 == 256) | composerStartRestartGroup.changed(mutableState4) | ((i7 & 458752) == 131072) | ((i7 & 57344) == 16384);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState3;
                mutableState2 = mutableState4;
                i4 = i7;
                i5 = 4;
                springIndicatorType = this;
                obj = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                        invoke2(lazyListScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LazyListScope LazyRow) {
                        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                        int i8 = i;
                        final MutableState<Float> mutableState5 = mutableState;
                        final int i9 = i;
                        final MutableState<Float> mutableState6 = mutableState2;
                        final SpringIndicatorType springIndicatorType2 = this;
                        final Function1<Integer, Unit> function12 = function1;
                        LazyListScope.items$default(LazyRow, i8, null, null, ComposableLambdaKt.composableLambdaInstance(38602305, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope items, final int i10, Composer composer3, int i11) {
                                Modifier.Companion companionOnGloballyPositioned;
                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                if ((i11 & 112) == 0) {
                                    i11 |= composer3.changed(i10) ? 32 : 16;
                                }
                                if ((i11 & 721) == 144 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(38602305, i11, -1, "com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType.IndicatorTypeComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SpringIndicatorType.kt:36)");
                                }
                                if (i10 == 0) {
                                    composer3.startReplaceGroup(934357912);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    composer3.startReplaceGroup(307237196);
                                    boolean zChanged4 = composer3.changed(mutableState5);
                                    final MutableState<Float> mutableState7 = mutableState5;
                                    Object objRememberedValue4 = composer3.rememberedValue();
                                    if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue4 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1$1$dotModifier$1$1
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
                                            public final void invoke2(LayoutCoordinates it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$2(mutableState7, Offset.m6080getXimpl(LayoutCoordinatesKt.positionInParent(it)));
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue4);
                                    }
                                    composer3.endReplaceGroup();
                                    companionOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) objRememberedValue4);
                                    composer3.endReplaceGroup();
                                } else if (i10 == i9 - 1) {
                                    composer3.startReplaceGroup(934609849);
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    composer3.startReplaceGroup(307245323);
                                    boolean zChanged5 = composer3.changed(mutableState6);
                                    final MutableState<Float> mutableState8 = mutableState6;
                                    Object objRememberedValue5 = composer3.rememberedValue();
                                    if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1$1$dotModifier$2$1
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
                                            public final void invoke2(LayoutCoordinates it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$5(mutableState8, Offset.m6080getXimpl(LayoutCoordinatesKt.positionInParent(it)));
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue5);
                                    }
                                    composer3.endReplaceGroup();
                                    companionOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) objRememberedValue5);
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(307251009);
                                    composer3.endReplaceGroup();
                                    companionOnGloballyPositioned = Modifier.INSTANCE;
                                }
                                Modifier modifier2 = companionOnGloballyPositioned;
                                DotGraphic dotGraphic3 = springIndicatorType2.dotsGraphic;
                                composer3.startReplaceGroup(307254223);
                                boolean zChanged6 = ((i11 & 112) == 32) | composer3.changed(function12);
                                final Function1<Integer, Unit> function13 = function12;
                                Object objRememberedValue6 = composer3.rememberedValue();
                                if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$1$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                            Function1<Integer, Unit> function14 = function13;
                                            if (function14 != null) {
                                                function14.invoke(Integer.valueOf(i10));
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue6);
                                }
                                composer3.endReplaceGroup();
                                DotKt.Dot(dotGraphic3, ClickableKt.m1516clickableXHw0xAI$default(modifier2, false, null, null, (Function0) objRememberedValue6, 7, null), composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                mutableState = mutableState3;
                obj = objRememberedValue3;
                springIndicatorType = this;
                mutableState2 = mutableState4;
                i4 = i7;
                i5 = 4;
            }
            composerStartRestartGroup.endReplaceGroup();
            LazyDslKt.LazyRow(modifierFillMaxWidth$default, null, paddingValuesM2034PaddingValuesa9UjIt4$default, false, horizontalM1908spacedByD5KLDUw, null, null, false, (Function1) obj, composerStartRestartGroup, 6, 234);
            composer2 = composerStartRestartGroup;
            composer2.startReplaceGroup(-1014767024);
            if (IndicatorTypeComposable__jt2gSs$lambda$1(mutableState) != -1.0f && IndicatorTypeComposable__jt2gSs$lambda$4(mutableState2) != -1.0f) {
                composer2.startReplaceGroup(-1014764804);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$centeredOffset$2$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Dp invoke() {
                            return Dp.m9112boximpl(m11301invokeD9Ej5fM());
                        }

                        /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                        public final float m11301invokeD9Ej5fM() {
                            return Dp.m9114constructorimpl(Dp.m9114constructorimpl(this.this$0.dotsGraphic.m11294getSizeD9Ej5fM() - this.this$0.selectorDotGraphic.m11294getSizeD9Ej5fM()) / 2.0f);
                        }
                    });
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                final State state = (State) objRememberedValue4;
                composer2.endReplaceGroup();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                final float density = ((Density) objConsume).getDensity();
                composer2.startReplaceGroup(-1014755968);
                boolean z = (i4 & 14) == i5;
                Object objRememberedValue5 = composer2.rememberedValue();
                if (z || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState5 = mutableState2;
                    final MutableState mutableState6 = mutableState;
                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$1$foregroundDotPositionDp$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Dp invoke() {
                            return Dp.m9112boximpl(m11302invokeD9Ej5fM());
                        }

                        /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                        public final float m11302invokeD9Ej5fM() {
                            return this.this$0.m11300computeSelectorDotPositionDptILSbM(SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$1(mutableState6), SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$4(mutableState5), i, globalOffsetProvider.invoke().floatValue(), density, SpringIndicatorType.IndicatorTypeComposable__jt2gSs$lambda$11$lambda$8(state));
                        }
                    });
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                composer2.endReplaceGroup();
                DotKt.Dot(springIndicatorType.selectorDotGraphic, OffsetKt.m1996offsetVpY3zN4(Modifier.INSTANCE, IndicatorTypeComposable__jt2gSs$lambda$11$lambda$10((State) objRememberedValue5), IndicatorTypeComposable__jt2gSs$lambda$11$lambda$8(state)), composer2, 0);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType$IndicatorTypeComposable$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i8) {
                    this.$tmp4_rcvr.mo11295IndicatorTypeComposablejt2gSs(globalOffsetProvider, modifier, i, f, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }
}
