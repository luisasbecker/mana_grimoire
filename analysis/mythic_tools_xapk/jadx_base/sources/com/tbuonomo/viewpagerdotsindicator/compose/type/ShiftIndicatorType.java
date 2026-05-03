package com.tbuonomo.viewpagerdotsindicator.compose.type;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
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
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ShiftIndicatorType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JN\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a²\u0006\n\u0010\u001b\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"Lcom/tbuonomo/viewpagerdotsindicator/compose/type/ShiftIndicatorType;", "Lcom/tbuonomo/viewpagerdotsindicator/compose/type/IndicatorType;", "dotsGraphic", "Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;", "shiftSizeFactor", "", "(Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;F)V", "IndicatorTypeComposable", "", "globalOffsetProvider", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "dotCount", "", "dotSpacing", "Landroidx/compose/ui/unit/Dp;", "onDotClicked", "Lkotlin/Function1;", "IndicatorTypeComposable--jt2gSs", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;IFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "computeDotWidth", "currentDotIndex", "globalOffset", "computeDotWidth-chRvn1I", "(IF)F", "viewpagerdotsindicator_release", "dotWidth", "dotModifier"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ShiftIndicatorType extends IndicatorType {
    public static final int $stable = 0;
    private final DotGraphic dotsGraphic;
    private final float shiftSizeFactor;

    /* JADX WARN: Multi-variable type inference failed */
    public ShiftIndicatorType() {
        this(null, 0.0f, 3, 0 == true ? 1 : 0);
    }

    public ShiftIndicatorType(DotGraphic dotsGraphic, float f) {
        Intrinsics.checkNotNullParameter(dotsGraphic, "dotsGraphic");
        this.dotsGraphic = dotsGraphic;
        this.shiftSizeFactor = f;
    }

    public /* synthetic */ ShiftIndicatorType(DotGraphic dotGraphic, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DotGraphic(0.0f, 0L, null, null, 0L, 31, null) : dotGraphic, (i & 2) != 0 ? 3.0f : f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeDotWidth-chRvn1I, reason: not valid java name */
    public final float m11297computeDotWidthchRvn1I(int currentDotIndex, float globalOffset) {
        return Dp.m9114constructorimpl(this.dotsGraphic.m11294getSizeD9Ej5fM() + Dp.m9114constructorimpl(Dp.m9114constructorimpl(RangesKt.coerceAtLeast(this.shiftSizeFactor - 1.0f, 0.0f) * this.dotsGraphic.m11294getSizeD9Ej5fM()) * (1.0f - RangesKt.coerceAtMost(Math.abs(currentDotIndex - globalOffset), 1.0f))));
    }

    @Override // com.tbuonomo.viewpagerdotsindicator.compose.type.IndicatorType
    /* JADX INFO: renamed from: IndicatorTypeComposable--jt2gSs */
    public void mo11295IndicatorTypeComposablejt2gSs(final Function0<Float> globalOffsetProvider, final Modifier modifier, final int i, final float f, final Function1<? super Integer, Unit> function1, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(globalOffsetProvider, "globalOffsetProvider");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-588367988);
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
            i3 |= composerStartRestartGroup.changed(this) ? 131072 : 65536;
        }
        if ((374491 & i3) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-588367988, i3, -1, "com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType.IndicatorTypeComposable (ShiftIndicatorType.kt:25)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            int i4 = i3;
            PaddingValues paddingValuesM2034PaddingValuesa9UjIt4$default = PaddingKt.m2034PaddingValuesa9UjIt4$default(f, 0.0f, f, 0.0f, 10, null);
            composerStartRestartGroup.startReplaceGroup(1682794319);
            boolean z = ((i4 & 14) == 4) | ((i4 & 896) == 256) | ((i4 & 458752) == 131072) | ((i4 & 57344) == 16384);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType$IndicatorTypeComposable$1$1$1
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
                        int i5 = i;
                        final Function0<Float> function0 = globalOffsetProvider;
                        final ShiftIndicatorType shiftIndicatorType = this;
                        final Function1<Integer, Unit> function12 = function1;
                        LazyListScope.items$default(LazyRow, i5, null, null, ComposableLambdaKt.composableLambdaInstance(1421800519, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType$IndicatorTypeComposable$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            private static final float invoke$lambda$1(State<Dp> state) {
                                return state.getValue().m9128unboximpl();
                            }

                            private static final Modifier invoke$lambda$3(MutableState<Modifier> mutableState) {
                                return mutableState.getValue();
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope items, final int i6, Composer composer3, int i7) {
                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                if ((i7 & 112) == 0) {
                                    i7 |= composer3.changed(i6) ? 32 : 16;
                                }
                                if ((i7 & 721) == 144 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1421800519, i7, -1, "com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType.IndicatorTypeComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShiftIndicatorType.kt:30)");
                                }
                                float fFloatValue = function0.invoke().floatValue();
                                composer3.startReplaceGroup(-1855390577);
                                boolean zChanged = composer3.changed(fFloatValue);
                                final ShiftIndicatorType shiftIndicatorType2 = shiftIndicatorType;
                                final Function0<Float> function02 = function0;
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType$IndicatorTypeComposable$1$1$1$1$dotWidth$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Dp invoke() {
                                            return Dp.m9112boximpl(m11298invokeD9Ej5fM());
                                        }

                                        /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                                        public final float m11298invokeD9Ej5fM() {
                                            return shiftIndicatorType2.m11297computeDotWidthchRvn1I(i6, function02.invoke().floatValue());
                                        }
                                    });
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                State state = (State) objRememberedValue2;
                                composer3.endReplaceGroup();
                                float fInvoke$lambda$1 = invoke$lambda$1(state);
                                composer3.startReplaceGroup(-1855383959);
                                boolean zChanged2 = composer3.changed(fInvoke$lambda$1);
                                final Function1<Integer, Unit> function13 = function12;
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ClickableKt.m1516clickableXHw0xAI$default(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, invoke$lambda$1(state)), false, null, null, new Function0<Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType$IndicatorTypeComposable$1$1$1$1$dotModifier$2$1
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
                                                function14.invoke(Integer.valueOf(i6));
                                            }
                                        }
                                    }, 7, null), null, 2, null);
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                composer3.endReplaceGroup();
                                DotKt.Dot(shiftIndicatorType.dotsGraphic, invoke$lambda$3((MutableState) objRememberedValue3), composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 6, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyRow(modifierFillMaxWidth$default, null, paddingValuesM2034PaddingValuesa9UjIt4$default, false, horizontalM1908spacedByD5KLDUw, null, null, false, (Function1) objRememberedValue, composer2, 6, 234);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType$IndicatorTypeComposable$2
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

                public final void invoke(Composer composer3, int i5) {
                    this.$tmp0_rcvr.mo11295IndicatorTypeComposablejt2gSs(globalOffsetProvider, modifier, i, f, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }
}
