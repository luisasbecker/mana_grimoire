package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnboardingActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$OnboardingActivityKt {
    public static final ComposableSingletons$OnboardingActivityKt INSTANCE = new ComposableSingletons$OnboardingActivityKt();

    /* JADX INFO: renamed from: lambda$-584823137, reason: not valid java name */
    private static Function4<PagerScope, Integer, Composer, Integer, Unit> f188lambda$584823137 = ComposableLambdaKt.composableLambdaInstance(-584823137, false, new Function4() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$OnboardingActivityKt.lambda__584823137$lambda$0((PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-444036325, reason: not valid java name */
    private static Function3<BoxWithConstraintsScope, Composer, Integer, Unit> f187lambda$444036325 = ComposableLambdaKt.composableLambdaInstance(-444036325, false, new Function3() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OnboardingActivityKt.lambda__444036325$lambda$0((BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-4194428, reason: not valid java name */
    private static Function3<BoxWithConstraintsScope, Composer, Integer, Unit> f186lambda$4194428 = ComposableLambdaKt.composableLambdaInstance(-4194428, false, new Function3() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OnboardingActivityKt.lambda__4194428$lambda$0((BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-757908263, reason: not valid java name */
    private static Function3<BoxWithConstraintsScope, Composer, Integer, Unit> f189lambda$757908263 = ComposableLambdaKt.composableLambdaInstance(-757908263, false, new Function3() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OnboardingActivityKt.lambda__757908263$lambda$0((BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    static final Unit lambda__4194428$lambda$0(BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C454@18505L43,460@18835L329,456@18610L696,476@19593L330,472@19368L697,492@20292L227,488@20091L3277:OnboardingActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-4194428, i2, -1, "com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt.lambda$-4194428.<anonymous> (OnboardingActivity.kt:450)");
            }
            float fM9128unboximpl = ((Dp) ComparisonsKt.minOf(Dp.m9112boximpl(Dp.m9114constructorimpl(BoxWithConstraints.mo1933getMaxWidthD9Ej5fM() * 0.8f)), Dp.m9112boximpl(Dp.m9114constructorimpl(BoxWithConstraints.mo1932getMaxHeightD9Ej5fM() * 0.71590906f)))).m9128unboximpl();
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("hover", composer, 6, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 264141357, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$OnboardingActivityKt.lambda__4194428$lambda$0$0$0((KeyframesSpec.KeyframesSpecConfig) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 0.0f, AnimationSpecKt.m1391infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue), RepeatMode.Restart, 0L, 4, null), "rotationX", composer, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            ComposerKt.sourceInformationMarkerStart(composer, 264165614, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$OnboardingActivityKt.lambda__4194428$lambda$0$2$0((KeyframesSpec.KeyframesSpecConfig) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 0.0f, AnimationSpecKt.m1391infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue2), RepeatMode.Restart, 0L, 4, null), "rotationY", composer, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(composer, 264187879, "CC(remember):OnboardingActivity.kt#9igjgp");
            boolean zChanged = composer.changed(stateAnimateFloat) | composer.changed(stateAnimateFloat2);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$OnboardingActivityKt.lambda__4194428$lambda$0$4$0(stateAnimateFloat, stateAnimateFloat2, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierWrapContentHeight$default, (Function1) objRememberedValue3);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 76191792, "C500@20677L1853,535@22634L708:OnboardingActivity.kt#r9tj48");
            Modifier modifierAlign = boxScopeInstance.align(AspectRatioKt.aspectRatio$default(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, fM9128unboximpl), 0.71590906f, false, 2, null), Alignment.INSTANCE.getCenterStart());
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierAlign);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 76113449, "C509@21152L384,507@21018L552,518@21650L850:OnboardingActivity.kt#r9tj48");
            Modifier modifierMatchParentSize = boxScopeInstance2.matchParentSize(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, 1665026448, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$OnboardingActivityKt.lambda__4194428$lambda$0$5$0$0$0((Context) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifierMatchParentSize, null, composer, 6, 4);
            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(BorderKt.m1494borderxT4_qwU(ClipKt.clip(boxScopeInstance2.matchParentSize(Modifier.INSTANCE), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(12.0f))), Dp.m9114constructorimpl(1.5f), ColorKt.Color(4292115280L), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(12.0f))), Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM1483backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 288865312, "C526@22158L48,525@22101L365:OnboardingActivity.kt#r9tj48");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.onboarding_card, composer, 0), "MTG Card", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (Alignment) null, ContentScale.INSTANCE.getCrop(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(12.0f));
            Modifier modifierAlign2 = boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterEnd());
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierAlign2);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1518793076, "C540@22936L41,540@22905L73,541@23043L42,541@23011L75,542@23155L46,542@23119L83,543@23268L43,543@23235L77:OnboardingActivity.kt#r9tj48");
            OnboardingActivityKt.InfoBadge(R.drawable.ic_price, StringResources_androidKt.stringResource(R.string.onboarding_price, composer, 0), composer, 0);
            OnboardingActivityKt.InfoBadge(R.drawable.ic_oracle, StringResources_androidKt.stringResource(R.string.onboarding_oracle, composer, 0), composer, 0);
            OnboardingActivityKt.InfoBadge(R.drawable.ic_legalities, StringResources_androidKt.stringResource(R.string.onboarding_legalities, composer, 0), composer, 0);
            OnboardingActivityKt.InfoBadge(R.drawable.ic_rulings, StringResources_androidKt.stringResource(R.string.onboarding_rulings, composer, 0), composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__4194428$lambda$0$0$0(KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        keyframes.setDurationMillis(12000);
        Float fValueOf = Float.valueOf(0.0f);
        keyframes.at(fValueOf, 0);
        Float fValueOf2 = Float.valueOf(10.0f);
        keyframes.at(fValueOf2, 3000);
        keyframes.at(fValueOf, 6000);
        keyframes.at(fValueOf2, 9000);
        keyframes.at(fValueOf, 12000);
        return Unit.INSTANCE;
    }

    private static final float lambda__4194428$lambda$0$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__4194428$lambda$0$2$0(KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        keyframes.setDurationMillis(12000);
        Float fValueOf = Float.valueOf(0.0f);
        keyframes.at(fValueOf, 0);
        keyframes.at(Float.valueOf(-10.0f), 3000);
        keyframes.at(fValueOf, 6000);
        keyframes.at(Float.valueOf(10.0f), 9000);
        keyframes.at(fValueOf, 12000);
        return Unit.INSTANCE;
    }

    private static final float lambda__4194428$lambda$0$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__4194428$lambda$0$4$0(State state, State state2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setRotationX(lambda__4194428$lambda$0$1(state));
        graphicsLayer.setRotationY(lambda__4194428$lambda$0$3(state2));
        graphicsLayer.setCameraDistance(12.0f * graphicsLayer.getDensity());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomGlowView lambda__4194428$lambda$0$5$0$0$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CustomGlowView customGlowView = new CustomGlowView(context, null);
        customGlowView.setGlowColor(ContextCompat.getColor(context, R.color.new_orange));
        customGlowView.setGlowSize(context.getResources().getDisplayMetrics().density * 12.0f);
        return customGlowView;
    }

    static final Unit lambda__444036325$lambda$0(BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C373@14477L2583:OnboardingActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-444036325, i2, -1, "com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt.lambda$-444036325.<anonymous> (OnboardingActivity.kt:371)");
            }
            Modifier modifierAlign = BoxWithConstraints.align(AspectRatioKt.aspectRatio$default(PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9114constructorimpl(16.0f)), 0.5042553f, false, 2, null), Alignment.INSTANCE.getTopCenter());
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAlign);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 459616945, "C386@15132L382,383@14969L575,395@15618L1416:OnboardingActivity.kt#r9tj48");
            Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, 1123208543, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$OnboardingActivityKt.lambda__444036325$lambda$0$0$0$0((Context) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue, modifierMatchParentSize, null, composer, 6, 4);
            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(BorderKt.m1494borderxT4_qwU(ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(16.0f))), Dp.m9114constructorimpl(1.5f), ColorKt.Color(4292115280L), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(16.0f))), Color.m6324copywmQWz5c$default(Color.INSTANCE.m6351getBlack0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1483backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 951096432, "C408@16347L552,407@16288L716:OnboardingActivity.kt#r9tj48");
            ComposerKt.sourceInformationMarkerStart(composer, 1139060911, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$OnboardingActivityKt.lambda__444036325$lambda$0$0$1$0$0((Context) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue2, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer, 54, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomGlowView lambda__444036325$lambda$0$0$0$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CustomGlowView customGlowView = new CustomGlowView(context, null);
        customGlowView.setGlowColor(ContextCompat.getColor(context, R.color.new_orange));
        customGlowView.setGlowSize(context.getResources().getDisplayMetrics().density * 12.0f);
        return customGlowView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoView lambda__444036325$lambda$0$0$1$0$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final VideoView videoView = new VideoView(context);
        videoView.setVideoPath("android.resource://" + context.getPackageName() + DomExceptionUtils.SEPARATOR + R.raw.lifecounter_preview);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                ComposableSingletons$OnboardingActivityKt.lambda__444036325$lambda$0$0$1$0$0$0$0(videoView, mediaPlayer);
            }
        });
        return videoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda__444036325$lambda$0$0$1$0$0$0$0(VideoView videoView, MediaPlayer mediaPlayer) {
        mediaPlayer.setLooping(true);
        videoView.start();
    }

    static final Unit lambda__584823137$lambda$0(PagerScope HorizontalPager, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "CN(page)213@8173L20:OnboardingActivity.kt#r9tj48");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584823137, i2, -1, "com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt.lambda$-584823137.<anonymous> (OnboardingActivity.kt:213)");
        }
        OnboardingActivityKt.OnboardingPage(i, composer, (i2 >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__757908263$lambda$0(BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C583@24933L364,581@24807L520,592@25407L2399:OnboardingActivity.kt#r9tj48");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-757908263, i2, -1, "com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt.lambda$-757908263.<anonymous> (OnboardingActivity.kt:581)");
            }
            Modifier modifierMatchParentSize = BoxWithConstraints.matchParentSize(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, 1794606437, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$OnboardingActivityKt.lambda__757908263$lambda$0$0$0((Context) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue, modifierMatchParentSize, null, composer, 6, 4);
            Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(BackgroundKt.m1483backgroundbw27NRU$default(BorderKt.m1494borderxT4_qwU(ClipKt.clip(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(16.0f))), Dp.m9114constructorimpl(1.5f), ColorKt.Color(4292115280L), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(16.0f))), Color.INSTANCE.m6351getBlack0d7_KjU(), null, 2, null), Dp.m9114constructorimpl(16.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2037padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1857829080, "C603@26053L45,602@26004L344,609@26430L49,610@26525L33,608@26381L363,615@26778L41,618@26912L758,617@26853L923:OnboardingActivity.kt#r9tj48");
            TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_deck_name, composer, 0), null, ColorKt.Color(4293234533L), null, TextUnitKt.getSp(18), null, null, FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.be_vietnam_pro_semibold, null, 0, 0, 14, null)), 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 261994);
            TextKt.m4288TextNvy7gAk(StringResources_androidKt.stringResource(R.string.onboarding_deck_subtitle, composer, 0), null, ColorResources_androidKt.colorResource(R.color.text_color, composer, 0), null, TextUnitKt.getSp(13), null, null, FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.be_vietnam_pro_regular, null, 0, 0, 14, null)), 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24576, 0, 261994);
            SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(12.0f)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1464118725, "CC(remember):OnboardingActivity.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$OnboardingActivityKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$OnboardingActivityKt.lambda__757908263$lambda$0$1$0$0((Context) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer, 54, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomGlowView lambda__757908263$lambda$0$0$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CustomGlowView customGlowView = new CustomGlowView(context, null);
        customGlowView.setGlowColor(ContextCompat.getColor(context, R.color.new_orange));
        customGlowView.setGlowSize(context.getResources().getDisplayMetrics().density * 12.0f);
        return customGlowView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View lambda__757908263$lambda$0$1$0$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.onboarding_stats_layout, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.playmatLayoutInner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((ConstraintLayout) viewFindViewById).setClipToOutline(true);
        LoadingImageViewPlaymat loadingImageViewPlaymat = (LoadingImageViewPlaymat) viewInflate.findViewById(R.id.playmatImageView);
        loadingImageViewPlaymat.reset();
        loadingImageViewPlaymat.setImageResourceId("playmat_obeka");
        loadingImageViewPlaymat.loadImages();
        return viewInflate;
    }

    /* JADX INFO: renamed from: getLambda$-4194428$app_release, reason: not valid java name */
    public final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> m10943getLambda$4194428$app_release() {
        return f186lambda$4194428;
    }

    /* JADX INFO: renamed from: getLambda$-444036325$app_release, reason: not valid java name */
    public final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> m10944getLambda$444036325$app_release() {
        return f187lambda$444036325;
    }

    /* JADX INFO: renamed from: getLambda$-584823137$app_release, reason: not valid java name */
    public final Function4<PagerScope, Integer, Composer, Integer, Unit> m10945getLambda$584823137$app_release() {
        return f188lambda$584823137;
    }

    /* JADX INFO: renamed from: getLambda$-757908263$app_release, reason: not valid java name */
    public final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> m10946getLambda$757908263$app_release() {
        return f189lambda$757908263;
    }
}
