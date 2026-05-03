package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.os.Build;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: SimpleBottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\rH\u0003ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0000\u0010\u0018H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"ALPHA_SCRIM", "", "Scrim", "", "show", "", "radius", "Landroidx/compose/ui/unit/Dp;", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "Scrim-EUb7tLY", "(ZFLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleBottomSheetScaffold", "sheetState", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleBottomSheetScaffold_Preview", "(Landroidx/compose/runtime/Composer;I)V", "blurAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", ExifInterface.GPS_DIRECTION_TRUE, "revenuecatui_defaultsBc8Release", "targetRadius"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SimpleBottomSheetScaffoldKt {
    private static final float ALPHA_SCRIM = 0.6f;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Scrim-EUb7tLY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10667ScrimEUb7tLY(final boolean z, float f, final Function0<Unit> function0, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        float f2;
        final Modifier modifier2;
        int i4;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-507423100);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)P(4,3:c#ui.unit.Dp,2,1)111@3489L118,116@3613L1037:SimpleBottomSheetScaffold.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
            }
            i4 = i3;
            if ((i4 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-507423100, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Scrim (SimpleBottomSheetScaffold.kt:110)");
                }
                Modifier modifierM5848blurF8QBwvs$default = BlurKt.m5848blurF8QBwvs$default(modifier3, Scrim_EUb7tLY$lambda$2(AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(!z ? f2 : Dp.m9114constructorimpl(0.0f), blurAnimationSpec(), null, null, composerStartRestartGroup, 0, 12)), null, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5848blurF8QBwvs$default);
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
                final BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1375845762, "C117@3667L9,124@3925L719,119@3686L958:SimpleBottomSheetScaffold.kt#51odh9");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 12) & 14));
                AnimatedVisibilityKt.AnimatedVisibility(z, boxScopeInstance.matchParentSize(Modifier.INSTANCE), EnterExitTransitionKt.fadeIn$default(blurAnimationSpec(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(blurAnimationSpec(), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(996852834, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$Scrim$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                        invoke(animatedVisibilityScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i6) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation(composer2, "C130@4178L39,125@3939L695:SimpleBottomSheetScaffold.kt#51odh9");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(996852834, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Scrim.<anonymous>.<anonymous> (SimpleBottomSheetScaffold.kt:125)");
                        }
                        Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                        composer2.startReplaceGroup(257503834);
                        ComposerKt.sourceInformation(composer2, "CC(remember):SimpleBottomSheetScaffold.kt#9igjgp");
                        Object objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        composer2.endReplaceGroup();
                        BoxKt.Box(ModifierExtensionsKt.conditional(ClickableKt.m1514clickableO2vRcR0$default(modifierMatchParentSize, (MutableInteractionSource) objRememberedValue, null, false, null, null, function0, 28, null), Build.VERSION.SDK_INT < 31, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$Scrim$1$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Modifier invoke(Modifier conditional) {
                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                return BackgroundKt.m1483backgroundbw27NRU$default(conditional, Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                            }
                        }), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final float f3 = f2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$Scrim$2
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

                    public final void invoke(Composer composer2, int i6) {
                        SimpleBottomSheetScaffoldKt.m10667ScrimEUb7tLY(z, f3, function0, modifier2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i2 & 16) == 0) {
        }
        i4 = i3;
        if ((i4 & 9363) == 9362) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifierM5848blurF8QBwvs$default2 = BlurKt.m5848blurF8QBwvs$default(modifier3, Scrim_EUb7tLY$lambda$2(AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(!z ? f2 : Dp.m9114constructorimpl(0.0f), blurAnimationSpec(), null, null, composerStartRestartGroup, 0, 12)), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5848blurF8QBwvs$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                final BoxScope boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1375845762, "C117@3667L9,124@3925L719,119@3686L958:SimpleBottomSheetScaffold.kt#51odh9");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 12) & 14));
                AnimatedVisibilityKt.AnimatedVisibility(z, boxScopeInstance2.matchParentSize(Modifier.INSTANCE), EnterExitTransitionKt.fadeIn$default(blurAnimationSpec(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(blurAnimationSpec(), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(996852834, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$Scrim$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                        invoke(animatedVisibilityScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i6) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation(composer2, "C130@4178L39,125@3939L695:SimpleBottomSheetScaffold.kt#51odh9");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(996852834, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Scrim.<anonymous>.<anonymous> (SimpleBottomSheetScaffold.kt:125)");
                        }
                        Modifier modifierMatchParentSize = boxScopeInstance2.matchParentSize(Modifier.INSTANCE);
                        composer2.startReplaceGroup(257503834);
                        ComposerKt.sourceInformation(composer2, "CC(remember):SimpleBottomSheetScaffold.kt#9igjgp");
                        Object objRememberedValue = composer2.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        composer2.endReplaceGroup();
                        BoxKt.Box(ModifierExtensionsKt.conditional(ClickableKt.m1514clickableO2vRcR0$default(modifierMatchParentSize, (MutableInteractionSource) objRememberedValue, null, false, null, null, function0, 28, null), Build.VERSION.SDK_INT < 31, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$Scrim$1$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Modifier invoke(Modifier conditional) {
                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                return BackgroundKt.m1483backgroundbw27NRU$default(conditional, Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                            }
                        }), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final float Scrim_EUb7tLY$lambda$2(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SimpleBottomSheetScaffold(final SimpleSheetState sheetState, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z;
        Object objRememberedValue;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(798288174);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SimpleBottomSheetScaffold)P(2,1)48@1958L553:SimpleBottomSheetScaffold.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(sheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(798288174, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffold (SimpleBottomSheetScaffold.kt:47)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1192897411, "C52@2096L21,53@2129L13,49@1993L149,60@2414L91,55@2152L353:SimpleBottomSheetScaffold.kt#51odh9");
                boolean backgroundBlur = sheetState.getBackgroundBlur();
                float fM9114constructorimpl = Dp.m9114constructorimpl(10.0f);
                composerStartRestartGroup.startReplaceGroup(-315572421);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):SimpleBottomSheetScaffold.kt#9igjgp");
                z = (i3 & 14) == 4;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$1$1
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
                            sheetState.hide();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                m10667ScrimEUb7tLY(backgroundBlur, fM9114constructorimpl, (Function0) objRememberedValue, null, ComposableLambdaKt.rememberComposableLambda(693747275, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$2
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

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C53@2131L9:SimpleBottomSheetScaffold.kt#51odh9");
                        if ((i5 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(693747275, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffold.<anonymous>.<anonymous> (SimpleBottomSheetScaffold.kt:53)");
                        }
                        content.invoke(composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 24624, 8);
                AnimatedVisibilityKt.AnimatedVisibility(sheetState.getVisible(), boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), EnterExitTransitionKt.slideInVertically$default(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$3
                    public final Integer invoke(int i5) {
                        return Integer.valueOf(i5);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                }, 1, null), EnterExitTransitionKt.slideOutVertically$default(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$4
                    public final Integer invoke(int i5) {
                        return Integer.valueOf(i5);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                }, 1, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1578294028, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$5
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                        invoke(animatedVisibilityScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation(composer2, "C61@2440L21,61@2428L33,63@2486L9:SimpleBottomSheetScaffold.kt#51odh9");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1578294028, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffold.<anonymous>.<anonymous> (SimpleBottomSheetScaffold.kt:61)");
                        }
                        composer2.startReplaceGroup(465543994);
                        ComposerKt.sourceInformation(composer2, "CC(remember):SimpleBottomSheetScaffold.kt#9igjgp");
                        boolean zChanged = composer2.changed(sheetState);
                        final SimpleSheetState simpleSheetState = sheetState;
                        Object objRememberedValue2 = composer2.rememberedValue();
                        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$5$1$1
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
                                    simpleSheetState.hide();
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        composer2.endReplaceGroup();
                        BackHandlerKt.BackHandler(false, (Function0) objRememberedValue2, composer2, 0, 1);
                        sheetState.getContent().invoke(composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold.2
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

                    public final void invoke(Composer composer2, int i5) {
                        SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold(sheetState, modifier3, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        if ((i3 & 147) == 146) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1192897411, "C52@2096L21,53@2129L13,49@1993L149,60@2414L91,55@2152L353:SimpleBottomSheetScaffold.kt#51odh9");
                boolean backgroundBlur2 = sheetState.getBackgroundBlur();
                float fM9114constructorimpl2 = Dp.m9114constructorimpl(10.0f);
                composerStartRestartGroup.startReplaceGroup(-315572421);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):SimpleBottomSheetScaffold.kt#9igjgp");
                if ((i3 & 14) == 4) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$1$1
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
                            sheetState.hide();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceGroup();
                    m10667ScrimEUb7tLY(backgroundBlur2, fM9114constructorimpl2, (Function0) objRememberedValue, null, ComposableLambdaKt.rememberComposableLambda(693747275, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$2
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

                        public final void invoke(Composer composer2, int i5) {
                            ComposerKt.sourceInformation(composer2, "C53@2131L9:SimpleBottomSheetScaffold.kt#51odh9");
                            if ((i5 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(693747275, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffold.<anonymous>.<anonymous> (SimpleBottomSheetScaffold.kt:53)");
                            }
                            content.invoke(composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 24624, 8);
                    AnimatedVisibilityKt.AnimatedVisibility(sheetState.getVisible(), boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), EnterExitTransitionKt.slideInVertically$default(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$3
                        public final Integer invoke(int i5) {
                            return Integer.valueOf(i5);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                            return invoke(num.intValue());
                        }
                    }, 1, null), EnterExitTransitionKt.slideOutVertically$default(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$4
                        public final Integer invoke(int i5) {
                            return Integer.valueOf(i5);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                            return invoke(num.intValue());
                        }
                    }, 1, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1578294028, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$5
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                            invoke(animatedVisibilityScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                            ComposerKt.sourceInformation(composer2, "C61@2440L21,61@2428L33,63@2486L9:SimpleBottomSheetScaffold.kt#51odh9");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1578294028, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffold.<anonymous>.<anonymous> (SimpleBottomSheetScaffold.kt:61)");
                            }
                            composer2.startReplaceGroup(465543994);
                            ComposerKt.sourceInformation(composer2, "CC(remember):SimpleBottomSheetScaffold.kt#9igjgp");
                            boolean zChanged = composer2.changed(sheetState);
                            final SimpleSheetState simpleSheetState = sheetState;
                            Object objRememberedValue2 = composer2.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt$SimpleBottomSheetScaffold$1$5$1$1
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
                                        simpleSheetState.hide();
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue2);
                            }
                            composer2.endReplaceGroup();
                            BackHandlerKt.BackHandler(false, (Function0) objRememberedValue2, composer2, 0, 1);
                            sheetState.getContent().invoke(composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 16);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4;
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SimpleBottomSheetScaffold_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-266393130);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SimpleBottomSheetScaffold_Preview)171@5500L501:SimpleBottomSheetScaffold.kt#51odh9");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-266393130, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffold_Preview (SimpleBottomSheetScaffold.kt:147)");
            }
            SimpleSheetState simpleSheetState = new SimpleSheetState();
            SimpleSheetState.show$default(simpleSheetState, true, ComposableSingletons$SimpleBottomSheetScaffoldKt.INSTANCE.m10622getLambda2$revenuecatui_defaultsBc8Release(), null, 4, null);
            SimpleBottomSheetScaffold(simpleSheetState, BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m6355getGray0d7_KjU(), null, 2, null), ComposableSingletons$SimpleBottomSheetScaffoldKt.INSTANCE.m10623getLambda3$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold_Preview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final <T> TweenSpec<T> blurAnimationSpec() {
        return AnimationSpecKt.tween$default(0, 0, null, 7, null);
    }
}
