package com.revenuecat.purchases.ui.revenuecatui.components;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.PaywallAnimation;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TransitionView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u001a*\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a$\u0010\b\u001a\u00020\u0001*\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0007\u001a\u000e\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u000bH\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u00020\n*\u00020\u000bH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0010H\u0002¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"TransitionView", "", "transition", "Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AnimatedVisibility", "easing", "Landroidx/compose/animation/core/Easing;", "Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation;", "enterTransition", "Landroidx/compose/animation/EnterTransition;", "getEasing", "hidden", "Landroidx/compose/ui/Modifier;", "revenuecatui_defaultsBc8Release", "shouldShow", ""}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransitionViewKt {

    /* JADX INFO: compiled from: TransitionView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaywallTransition.TransitionType.values().length];
            try {
                iArr[PaywallTransition.TransitionType.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallTransition.TransitionType.FADE_AND_SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallTransition.TransitionType.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaywallTransition.TransitionType.SLIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PaywallAnimation.AnimationType.values().length];
            try {
                iArr2[PaywallAnimation.AnimationType.EASE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PaywallAnimation.AnimationType.EASE_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PaywallAnimation.AnimationType.EASE_IN_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PaywallAnimation.AnimationType.LINEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnimatedVisibility(final PaywallTransition paywallTransition, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(391884057);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibility)58@2311L40,59@2377L33,59@2356L54,65@2506L25,62@2415L116:TransitionView.kt#dnqhhd");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(paywallTransition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(391884057, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.AnimatedVisibility (TransitionView.kt:57)");
            }
            composerStartRestartGroup.startReplaceGroup(1463461260);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TransitionView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(paywallTransition);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(1463463365);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TransitionView.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
            TransitionViewKt$AnimatedVisibility$1$1 transitionViewKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || transitionViewKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                transitionViewKt$AnimatedVisibility$1$1RememberedValue = new TransitionViewKt$AnimatedVisibility$1$1(mutableState, null);
                composerStartRestartGroup.updateRememberedValue(transitionViewKt$AnimatedVisibility$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(paywallTransition, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transitionViewKt$AnimatedVisibility$1$1RememberedValue, composerStartRestartGroup, i2 & 14);
            AnimatedVisibilityKt.AnimatedVisibility(AnimatedVisibility$lambda$3(mutableState), (Modifier) null, enterTransition(paywallTransition), (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1879822145, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.AnimatedVisibility.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation(composer2, "C66@2516L9:TransitionView.kt#dnqhhd");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1879822145, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.AnimatedVisibility.<anonymous> (TransitionView.kt:66)");
                    }
                    function2.invoke(composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.AnimatedVisibility.3
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

                public final void invoke(Composer composer2, int i3) {
                    TransitionViewKt.AnimatedVisibility(paywallTransition, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final boolean AnimatedVisibility$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnimatedVisibility$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final void TransitionView(final PaywallTransition paywallTransition, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1753108978);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TransitionView)P(1):TransitionView.kt#dnqhhd");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(paywallTransition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1753108978, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.TransitionView (TransitionView.kt:29)");
            }
            if (paywallTransition == null) {
                composerStartRestartGroup.startReplaceGroup(1473784896);
                ComposerKt.sourceInformation(composerStartRestartGroup, "31@1519L9");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1473826622);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (paywallTransition.getDisplacementStrategy() == PaywallTransition.DisplacementStrategy.GREEDY) {
                    composerStartRestartGroup.startReplaceGroup(1473916429);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "34@1650L180");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -625826389, "C35@1672L83,39@1803L13,39@1784L32:TransitionView.kt#dnqhhd");
                    Modifier modifierHidden = hidden(Modifier.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHidden);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                    Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1847830477, "C36@1728L9:TransitionView.kt#dnqhhd");
                    content.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AnimatedVisibility(paywallTransition, ComposableLambdaKt.rememberComposableLambda(1120237739, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt$TransitionView$1$2
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

                        public final void invoke(Composer composer2, int i3) {
                            ComposerKt.sourceInformation(composer2, "C39@1805L9:TransitionView.kt#dnqhhd");
                            if ((i3 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1120237739, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.TransitionView.<anonymous>.<anonymous> (TransitionView.kt:39)");
                            }
                            content.invoke(composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 48);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1474120502);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "42@1890L13,42@1871L32");
                    AnimatedVisibility(paywallTransition, ComposableLambdaKt.rememberComposableLambda(797485256, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.TransitionView.2
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

                        public final void invoke(Composer composer2, int i3) {
                            ComposerKt.sourceInformation(composer2, "C42@1892L9:TransitionView.kt#dnqhhd");
                            if ((i3 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(797485256, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.TransitionView.<anonymous> (TransitionView.kt:42)");
                            }
                            content.invoke(composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 48);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.TransitionView.3
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

                public final void invoke(Composer composer2, int i3) {
                    TransitionViewKt.TransitionView(paywallTransition, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Easing easing(PaywallAnimation paywallAnimation) {
        Easing easing;
        return (paywallAnimation == null || (easing = getEasing(paywallAnimation)) == null) ? EasingKt.getLinearOutSlowInEasing() : easing;
    }

    private static final EnterTransition enterTransition(PaywallTransition paywallTransition) {
        int msDuration;
        int i = WhenMappings.$EnumSwitchMapping$0[paywallTransition.getType().ordinal()];
        if (i == 1) {
            PaywallAnimation animation = paywallTransition.getAnimation();
            msDuration = animation != null ? animation.getMsDuration() : 300;
            PaywallAnimation animation2 = paywallTransition.getAnimation();
            return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(msDuration, animation2 != null ? animation2.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 2, null);
        }
        if (i == 2) {
            PaywallAnimation animation3 = paywallTransition.getAnimation();
            int msDuration2 = animation3 != null ? animation3.getMsDuration() : 300;
            PaywallAnimation animation4 = paywallTransition.getAnimation();
            EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(msDuration2, animation4 != null ? animation4.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 2, null);
            PaywallAnimation animation5 = paywallTransition.getAnimation();
            msDuration = animation5 != null ? animation5.getMsDuration() : 300;
            PaywallAnimation animation6 = paywallTransition.getAnimation();
            return enterTransitionFadeIn$default.plus(EnterExitTransitionKt.m1305scaleInL8ZKhE$default(AnimationSpecKt.tween(msDuration, animation6 != null ? animation6.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 0L, 6, null));
        }
        if (i == 3) {
            PaywallAnimation animation7 = paywallTransition.getAnimation();
            msDuration = animation7 != null ? animation7.getMsDuration() : 300;
            PaywallAnimation animation8 = paywallTransition.getAnimation();
            return EnterExitTransitionKt.m1305scaleInL8ZKhE$default(AnimationSpecKt.tween(msDuration, animation8 != null ? animation8.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 0L, 6, null);
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        PaywallAnimation animation9 = paywallTransition.getAnimation();
        msDuration = animation9 != null ? animation9.getMsDuration() : 300;
        PaywallAnimation animation10 = paywallTransition.getAnimation();
        return EnterExitTransitionKt.slideIn(AnimationSpecKt.tween(msDuration, animation10 != null ? animation10.getMsDelay() : 0, easing(paywallTransition.getAnimation())), new Function1<IntSize, IntOffset>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.enterTransition.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m9233boximpl(m10459invokemHKZG7I(intSize.m9289unboximpl()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m10459invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(-180, 0);
            }
        });
    }

    private static final Easing getEasing(PaywallAnimation paywallAnimation) {
        int i = WhenMappings.$EnumSwitchMapping$1[paywallAnimation.getType().ordinal()];
        if (i == 1) {
            return EasingKt.getFastOutSlowInEasing();
        }
        if (i == 2) {
            return EasingKt.getFastOutLinearInEasing();
        }
        if (i == 3) {
            return EasingKt.getLinearOutSlowInEasing();
        }
        if (i == 4) {
            return EasingKt.getLinearEasing();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Modifier hidden(Modifier modifier) {
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.hidden.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m10460invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m10460invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(j);
                return MeasureScope.layout$default(layout, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.hidden.1.1
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
        });
    }
}
