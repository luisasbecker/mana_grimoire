package com.revenuecat.purchases.ui.revenuecatui.components.button;

import androidx.camera.video.AudioStats;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentStateKt;
import com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ButtonComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aK\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u0018\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0019\u001a!\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010 \u001a\u0017\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#H\u0003¢\u0006\u0002\u0010$\u001a\u0015\u0010!\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002¢\u0006\u0002\u0010'\u001a<\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u00061²\u0006\n\u00102\u001a\u000203X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"ALPHA_DISABLED", "", "BRIGHTNESS_CUTOFF", "COEFFICIENT_LUMINANCE_BLUE", "COEFFICIENT_LUMINANCE_GREEN", "COEFFICIENT_LUMINANCE_RED", "brightness", "Landroidx/compose/ui/graphics/Color;", "getBrightness-8_81llA", "(J)F", "ButtonComponentView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "onClick", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ButtonComponentView_Preview_Default", "(Landroidx/compose/runtime/Composer;I)V", "ButtonComponentView_Preview_Narrow", "previewButtonComponentStyle", "stackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;", "progressColorFor", "backgroundStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/runtime/Composer;I)J", "colorStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;)J", "progressSize", "", "Landroidx/compose/ui/unit/Density;", "stackWidthPx", "stackHeightPx", "stackMarginStartPx", "stackMarginEndPx", "stackMarginTopPx", "stackMarginBottomPx", "revenuecatui_defaultsBc8Release", "myActionInProgress", "", "contentAlpha", "progressAlpha", "animatedContentAlpha", "animatedProgressAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class ButtonComponentViewKt {
    private static final float ALPHA_DISABLED = 0.6f;
    private static final float BRIGHTNESS_CUTOFF = 0.6f;
    private static final float COEFFICIENT_LUMINANCE_BLUE = 0.114f;
    private static final float COEFFICIENT_LUMINANCE_GREEN = 0.587f;
    private static final float COEFFICIENT_LUMINANCE_RED = 0.299f;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$2, reason: invalid class name */
    /* JADX INFO: compiled from: ButtonComponentView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function2<PaywallAction, Continuation<? super Unit>, Object> $onClick;
        final /* synthetic */ PaywallState.Loaded.Components $state;
        final /* synthetic */ ButtonComponentStyle $style;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(ButtonComponentStyle buttonComponentStyle, PaywallState.Loaded.Components components, Modifier modifier, Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2) {
            super(2);
            this.$style = buttonComponentStyle;
            this.$state = components;
            this.$modifier = modifier;
            this.$onClick = function2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invoke$lambda$2(MutableState<Boolean> mutableState) {
            return mutableState.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        private static final float invoke$lambda$5(State<Float> state) {
            return state.getValue().floatValue();
        }

        private static final float invoke$lambda$7(State<Float> state) {
            return state.getValue().floatValue();
        }

        private static final float invoke$lambda$8(State<Float> state) {
            return state.getValue().floatValue();
        }

        private static final float invoke$lambda$9(State<Float> state) {
            return state.getValue().floatValue();
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            Modifier modifier;
            String str;
            Continuation continuation;
            Object obj;
            ComposerKt.sourceInformation(composer, "C85@4290L100,90@4421L24,94@4669L34,95@4732L131,98@4893L66,99@4996L47,100@5081L48,102@5182L7,103@5214L121,106@5363L124,109@5514L155,112@5694L153,134@6971L323,143@7324L1940,120@6316L2959:ButtonComponentView.kt#5w7xmn");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-17542715, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView.<anonymous> (ButtonComponentView.kt:85)");
            }
            final ButtonComponentState buttonComponentStateRememberButtonComponentState = ButtonComponentStateKt.rememberButtonComponentState(this.$style, this.$state, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, -954367824, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composer);
            final PaywallState.Loaded.Components components = this.$state;
            composer.startReplaceGroup(-1790179292);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-1790177179);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$2$contentAlpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(ButtonComponentViewKt.AnonymousClass2.invoke$lambda$2(mutableState) ? 0.0f : components.getActionInProgress() ? 0.6f : 1.0f);
                    }
                });
                composer.updateRememberedValue(objRememberedValue3);
            }
            State state = (State) objRememberedValue3;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-1790172092);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$2$progressAlpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(ButtonComponentViewKt.AnonymousClass2.invoke$lambda$2(mutableState) ? 1.0f : 0.0f);
                    }
                });
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceGroup();
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(invoke$lambda$5(state), null, 0.0f, null, null, composer, 0, 30);
            State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(invoke$lambda$7((State) objRememberedValue4), null, 0.0f, null, null, composer, 0, 30);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            Object margin = this.$style.getStackComponentStyle().getMargin();
            composer.startReplaceGroup(-1790161765);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged = composer.changed(margin);
            ButtonComponentStyle buttonComponentStyle = this.$style;
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = Dp.m9112boximpl(buttonComponentStyle.getStackComponentStyle().getMargin().getTop());
                composer.updateRememberedValue(objRememberedValue5);
            }
            final float fM9128unboximpl = ((Dp) objRememberedValue5).m9128unboximpl();
            composer.endReplaceGroup();
            Object margin2 = this.$style.getStackComponentStyle().getMargin();
            composer.startReplaceGroup(-1790156994);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged2 = composer.changed(margin2);
            ButtonComponentStyle buttonComponentStyle2 = this.$style;
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = Dp.m9112boximpl(buttonComponentStyle2.getStackComponentStyle().getMargin().getBottom());
                composer.updateRememberedValue(objRememberedValue6);
            }
            final float fM9128unboximpl2 = ((Dp) objRememberedValue6).m9128unboximpl();
            composer.endReplaceGroup();
            Object margin3 = this.$style.getStackComponentStyle().getMargin();
            composer.startReplaceGroup(-1790152131);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged3 = composer.changed(margin3) | composer.changed(layoutDirection);
            ButtonComponentStyle buttonComponentStyle3 = this.$style;
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = Dp.m9112boximpl(PaddingKt.calculateStartPadding(buttonComponentStyle3.getStackComponentStyle().getMargin(), layoutDirection));
                composer.updateRememberedValue(objRememberedValue7);
            }
            final float fM9128unboximpl3 = ((Dp) objRememberedValue7).m9128unboximpl();
            composer.endReplaceGroup();
            Object margin4 = this.$style.getStackComponentStyle().getMargin();
            composer.startReplaceGroup(-1790146373);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged4 = composer.changed(margin4) | composer.changed(layoutDirection);
            ButtonComponentStyle buttonComponentStyle4 = this.$style;
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = Dp.m9112boximpl(PaddingKt.calculateEndPadding(buttonComponentStyle4.getStackComponentStyle().getMargin(), layoutDirection));
                composer.updateRememberedValue(objRememberedValue8);
            }
            final float fM9128unboximpl4 = ((Dp) objRememberedValue8).m9128unboximpl();
            composer.endReplaceGroup();
            ButtonComponentStyle buttonComponentStyle5 = this.$style;
            PaywallState.Loaded.Components components2 = this.$state;
            Modifier modifier2 = this.$modifier;
            boolean z = !components.getActionInProgress();
            composer.startReplaceGroup(-1790105339);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(this.$onClick) | composer.changed(this.$state) | composer.changedInstance(coroutineScope) | composer.changed(buttonComponentStateRememberButtonComponentState);
            final PaywallState.Loaded.Components components3 = this.$state;
            final Function2<PaywallAction, Continuation<? super Unit>, Object> function2 = this.$onClick;
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                modifier = modifier2;
                str = "CC(remember):ButtonComponentView.kt#9igjgp";
                continuation = null;
                obj = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$2$2$1

                    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$2$2$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: ButtonComponentView.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$2$2$1$1", f = "ButtonComponentView.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ButtonComponentState $buttonState;
                        final /* synthetic */ MutableState<Boolean> $myActionInProgress$delegate;
                        final /* synthetic */ Function2<PaywallAction, Continuation<? super Unit>, Object> $onClick;
                        final /* synthetic */ PaywallState.Loaded.Components $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        AnonymousClass1(Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, ButtonComponentState buttonComponentState, PaywallState.Loaded.Components components, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$onClick = function2;
                            this.$buttonState = buttonComponentState;
                            this.$state = components;
                            this.$myActionInProgress$delegate = mutableState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$onClick, this.$buttonState, this.$state, this.$myActionInProgress$delegate, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Function2<PaywallAction, Continuation<? super Unit>, Object> function2 = this.$onClick;
                                PaywallAction action = this.$buttonState.getAction();
                                this.label = 1;
                                if (function2.invoke(action, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            ButtonComponentViewKt.AnonymousClass2.invoke$lambda$3(this.$myActionInProgress$delegate, false);
                            PaywallState.Loaded.Components.update$default(this.$state, null, null, Boxing.boxBoolean(false), 3, null);
                            return Unit.INSTANCE;
                        }
                    }

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
                        ButtonComponentViewKt.AnonymousClass2.invoke$lambda$3(mutableState, true);
                        PaywallState.Loaded.Components.update$default(components3, null, null, true, 3, null);
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(function2, buttonComponentStateRememberButtonComponentState, components3, mutableState, null), 3, null);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                str = "CC(remember):ButtonComponentView.kt#9igjgp";
                modifier = modifier2;
                obj = objRememberedValue9;
                continuation = null;
            }
            composer.endReplaceGroup();
            Modifier modifierM1516clickableXHw0xAI$default = ClickableKt.m1516clickableXHw0xAI$default(modifier, z, null, null, (Function0) obj, 6, null);
            composer.startReplaceGroup(-1790092426);
            ComposerKt.sourceInformation(composer, str);
            boolean zChanged5 = composer.changed(fM9128unboximpl3) | composer.changed(fM9128unboximpl4) | composer.changed(fM9128unboximpl) | composer.changed(fM9128unboximpl2);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = (MeasurePolicy) new MeasurePolicy() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$2$3$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo1260measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        final Placeable placeableMo7769measureBRTryo0 = measurables.get(0).mo7769measureBRTryo0(j);
                        final float f = Layout.mo1624toPx0680j_4(fM9128unboximpl3);
                        float f2 = Layout.mo1624toPx0680j_4(fM9128unboximpl4);
                        final float f3 = Layout.mo1624toPx0680j_4(fM9128unboximpl);
                        float f4 = Layout.mo1624toPx0680j_4(fM9128unboximpl2);
                        int iProgressSize = ButtonComponentViewKt.progressSize(Layout, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), f, f2, f3, f4);
                        final Placeable placeableMo7769measureBRTryo02 = measurables.get(1).mo7769measureBRTryo0(ConstraintsKt.Constraints(iProgressSize, iProgressSize, iProgressSize, iProgressSize));
                        int width = placeableMo7769measureBRTryo0.getWidth();
                        int height = placeableMo7769measureBRTryo0.getHeight();
                        final float f5 = (height - f3) - f4;
                        final float f6 = (width - f) - f2;
                        return MeasureScope.layout$default(Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$2$3$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope layout) {
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo0, 0, 0, 0.0f, 4, null);
                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo7769measureBRTryo02, ((int) f) + MathKt.roundToInt((f6 / 2.0f) - (r3.getWidth() / 2.0f)), ((int) f3) + MathKt.roundToInt((f5 / 2.0f) - (placeableMo7769measureBRTryo02.getHeight() / 2.0f)), 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue10;
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1516clickableXHw0xAI$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 789905373, "C122@6364L302,131@6808L54,129@6683L198:ButtonComponentView.kt#5w7xmn");
            StackComponentViewKt.StackComponentView(buttonComponentStyle5.getStackComponentStyle(), components2, new ButtonComponentViewKt$ButtonComponentView$2$1$1(continuation), null, invoke$lambda$8(stateAnimateFloatAsState), composer, 384, 8);
            ProgressIndicatorKt.m3947CircularProgressIndicatorLxG7B9w(AlphaKt.alpha(Modifier.INSTANCE, invoke$lambda$9(stateAnimateFloatAsState2)), ButtonComponentViewKt.progressColorFor(buttonComponentStyle5.getStackComponentStyle().getBackground(), composer, 0), 0.0f, 0L, 0, composer, 0, 28);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Default$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ButtonComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Default$1", f = "ButtonComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07131 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07131(Continuation<? super C07131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07131(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07131) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Narrow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ButtonComponentView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Narrow$1", f = "ButtonComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07151 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C07151(Continuation<? super C07151> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07151(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C07151) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public static final void ButtonComponentView(final ButtonComponentStyle style, final PaywallState.Loaded.Components state, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> onClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1096165859);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonComponentView)P(3,2,1)75@3951L114,83@4169L5112,83@4123L5158:ButtonComponentView.kt#5w7xmn");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(style) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1096165859, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView (ButtonComponentView.kt:74)");
            }
            if (!StackComponentStateKt.rememberUpdatedStackComponentState(style.getStackComponentStyle(), state, composerStartRestartGroup, i3 & 112).getVisible()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView.1
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
                            ButtonComponentViewKt.ButtonComponentView(style, state, onClick, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            TransitionViewKt.TransitionView(style.getTransition(), ComposableLambdaKt.rememberComposableLambda(-17542715, true, new AnonymousClass2(style, state, modifier2, onClick), composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView.3
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
                    ButtonComponentViewKt.ButtonComponentView(style, state, onClick, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ButtonComponentView_Preview_Default(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-291258808);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonComponentView_Preview_Default)241@11183L29,241@11214L19,241@11163L76:ButtonComponentView.kt#5w7xmn");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-291258808, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView_Preview_Default (ButtonComponentView.kt:240)");
            }
            ButtonComponentView(previewButtonComponentStyle(null, null, composerStartRestartGroup, 0, 3), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C07131(null), null, composerStartRestartGroup, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView_Preview_Default.2
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
                    ButtonComponentViewKt.ButtonComponentView_Preview_Default(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ButtonComponentView_Preview_Narrow(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1236087174);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonComponentView_Preview_Narrow)248@11356L386,258@11760L19,247@11319L490:ButtonComponentView.kt#5w7xmn");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1236087174, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView_Preview_Narrow (ButtonComponentView.kt:246)");
            }
            ButtonComponentView(previewButtonComponentStyle(PreviewHelpersKt.m10457previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Restore purchases", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), null, 2, null), false, null, null, null, null, null, null, null, 65406, null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.m9114constructorimpl(16.0f) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 128) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(0.0f)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), null, composerStartRestartGroup, 0, 2), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C07151(null), null, composerStartRestartGroup, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView_Preview_Narrow.2
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
                    ButtonComponentViewKt.ButtonComponentView_Preview_Narrow(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: getBrightness-8_81llA, reason: not valid java name */
    private static final float m10463getBrightness8_81llA(long j) {
        return (Color.m6331getRedimpl(j) * COEFFICIENT_LUMINANCE_RED) + (Color.m6330getGreenimpl(j) * COEFFICIENT_LUMINANCE_GREEN) + (Color.m6328getBlueimpl(j) * COEFFICIENT_LUMINANCE_BLUE);
    }

    private static final ButtonComponentStyle previewButtonComponentStyle(StackComponentStyle stackComponentStyle, ButtonComponentStyle.Action action, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-1733277159);
        ComposerKt.sourceInformation(composer, "C(previewButtonComponentStyle)P(1):ButtonComponentView.kt#5w7xmn");
        StackComponentStyle stackComponentStyle2 = (i2 & 1) != 0 ? new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Restore purchases", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), null, 2, null), false, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(8.0d, 8.0d, 8.0d, 8.0d), new Padding(AudioStats.AUDIO_AMPLITUDE_NONE, 24.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 24.0d), null, null, null, null, 61822, null)), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE), Dp.m9114constructorimpl(16.0f), BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null))), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(16.0f)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(10.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(3.0f), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null) : stackComponentStyle;
        ButtonComponentStyle.Action action2 = (i2 & 2) != 0 ? ButtonComponentStyle.Action.RestorePurchases.INSTANCE : action;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1733277159, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.previewButtonComponentStyle (ButtonComponentView.kt:299)");
        }
        ButtonComponentStyle buttonComponentStyle = new ButtonComponentStyle(stackComponentStyle2, action2, null, 4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return buttonComponentStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long progressColorFor(BackgroundStyles backgroundStyles, Composer composer, int i) {
        long jM6362getWhite0d7_KjU;
        composer.startReplaceGroup(-1216934903);
        ComposerKt.sourceInformation(composer, "C(progressColorFor)218@10363L15:ButtonComponentView.kt#5w7xmn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216934903, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.progressColorFor (ButtonComponentView.kt:214)");
        }
        composer.startReplaceGroup(-1003117124);
        ComposerKt.sourceInformation(composer, "215@10196L21");
        if (backgroundStyles == null) {
            long jM6362getWhite0d7_KjU2 = DarkThemeKt.isSystemInDarkTheme(composer, 0) ? Color.INSTANCE.m6362getWhite0d7_KjU() : Color.INSTANCE.m6351getBlack0d7_KjU();
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return jM6362getWhite0d7_KjU2;
        }
        composer.endReplaceGroup();
        if (backgroundStyles instanceof BackgroundStyles.Color) {
            jM6362getWhite0d7_KjU = progressColorFor(ColorStyleKt.getForCurrentTheme(((BackgroundStyles.Color) backgroundStyles).m10515unboximpl(), composer, 0));
        } else {
            if (!(backgroundStyles instanceof BackgroundStyles.Image) && !(backgroundStyles instanceof BackgroundStyles.Video)) {
                throw new NoWhenBranchMatchedException();
            }
            jM6362getWhite0d7_KjU = Color.INSTANCE.m6362getWhite0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return jM6362getWhite0d7_KjU;
    }

    private static final long progressColorFor(ColorStyle colorStyle) {
        if (colorStyle instanceof ColorStyle.Solid) {
            return m10463getBrightness8_81llA(((ColorStyle.Solid) colorStyle).m10538unboximpl()) > 0.6f ? Color.INSTANCE.m6351getBlack0d7_KjU() : Color.INSTANCE.m6362getWhite0d7_KjU();
        }
        if (!(colorStyle instanceof ColorStyle.Gradient)) {
            throw new NoWhenBranchMatchedException();
        }
        List colors$revenuecatui_defaultsBc8Release = ((ColorStyle.Gradient) colorStyle).m10530unboximpl().getColors$revenuecatui_defaultsBc8Release();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(colors$revenuecatui_defaultsBc8Release, 10));
        Iterator it = colors$revenuecatui_defaultsBc8Release.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(m10463getBrightness8_81llA(((Color) it.next()).m6335unboximpl())));
        }
        return CollectionsKt.averageOfFloat(arrayList) > 0.6000000238418579d ? Color.INSTANCE.m6351getBlack0d7_KjU() : Color.INSTANCE.m6362getWhite0d7_KjU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int progressSize(Density density, int i, int i2, float f, float f2, float f3, float f4) {
        float fMo1620toDpu2uoSUM = density.mo1620toDpu2uoSUM(Math.min((i - f) - f2, (i2 - f3) - f4));
        return density.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(RangesKt.coerceIn(Dp.m9114constructorimpl(fMo1620toDpu2uoSUM - (Dp.m9113compareTo0680j_4(fMo1620toDpu2uoSUM, Dp.m9114constructorimpl(32.0f)) >= 0 ? Dp.m9114constructorimpl(16.0f) : Dp.m9113compareTo0680j_4(fMo1620toDpu2uoSUM, Dp.m9114constructorimpl(24.0f)) >= 0 ? Dp.m9114constructorimpl(fMo1620toDpu2uoSUM - Dp.m9114constructorimpl(16.0f)) : Dp.m9113compareTo0680j_4(fMo1620toDpu2uoSUM, Dp.m9114constructorimpl(16.0f)) >= 0 ? Dp.m9114constructorimpl(8.0f) : Dp.m9113compareTo0680j_4(fMo1620toDpu2uoSUM, Dp.m9114constructorimpl(8.0f)) >= 0 ? Dp.m9114constructorimpl(fMo1620toDpu2uoSUM - Dp.m9114constructorimpl(8.0f)) : Dp.m9114constructorimpl(0.0f))), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(38.0f))));
    }
}
