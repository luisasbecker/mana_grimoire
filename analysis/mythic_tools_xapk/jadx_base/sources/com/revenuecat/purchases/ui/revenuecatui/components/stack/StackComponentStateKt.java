package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackComponentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u0005H\u0003¢\u0006\u0002\u0010\u000f\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"rememberUpdatedStackComponentState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;", "paywallState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class StackComponentStateKt {
    public static final /* synthetic */ StackComponentState rememberUpdatedStackComponentState(StackComponentStyle style, final PaywallState.Loaded.Components paywallState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(paywallState, "paywallState");
        composer.startReplaceGroup(-1712011381);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedStackComponentState)P(1)41@2103L36,42@2172L33,43@2246L41,44@2319L38,39@2014L346:StackComponentState.kt#280jdz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1712011381, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.rememberUpdatedStackComponentState (StackComponentState.kt:39)");
        }
        composer.startReplaceGroup(998073447);
        ComposerKt.sourceInformation(composer, "CC(remember):StackComponentState.kt#9igjgp");
        int i2 = (i & 112) ^ 48;
        boolean z = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<PaywallState.Loaded.Components.SelectedPackageInfo>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentStateKt$rememberUpdatedStackComponentState$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PaywallState.Loaded.Components.SelectedPackageInfo invoke() {
                    return paywallState.getSelectedPackageInfo();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(998075652);
        ComposerKt.sourceInformation(composer, "CC(remember):StackComponentState.kt#9igjgp");
        boolean z2 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function0) new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentStateKt$rememberUpdatedStackComponentState$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(paywallState.getSelectedTabIndex());
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function02 = (Function0) objRememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(998078028);
        ComposerKt.sourceInformation(composer, "CC(remember):StackComponentState.kt#9igjgp");
        boolean z3 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function0) new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentStateKt$rememberUpdatedStackComponentState$3$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final OfferEligibility invoke() {
                    return paywallState.getSelectedOfferEligibility();
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function0 function03 = (Function0) objRememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(998080361);
        ComposerKt.sourceInformation(composer, "CC(remember):StackComponentState.kt#9igjgp");
        boolean z4 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue4 = composer.rememberedValue();
        if (z4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function0) new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentStateKt$rememberUpdatedStackComponentState$4$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends CustomVariableValue> invoke() {
                    return paywallState.getMergedCustomVariables();
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        composer.endReplaceGroup();
        StackComponentState stackComponentStateRememberUpdatedStackComponentState = rememberUpdatedStackComponentState(style, function0, function02, function03, (Function0) objRememberedValue4, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stackComponentStateRememberUpdatedStackComponentState;
    }

    private static final /* synthetic */ StackComponentState rememberUpdatedStackComponentState(StackComponentStyle stackComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Composer composer, int i) {
        composer.startReplaceGroup(1491776249);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedStackComponentState)P(4,2,3,1)57@2786L27,58@2898L7,*60@2918L467:StackComponentState.kt#280jdz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1491776249, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.rememberUpdatedStackComponentState (StackComponentState.kt:56)");
        }
        WindowWidthSizeClass windowWidthSizeClass = AndroidWindowAdaptiveInfo_androidKt.currentWindowAdaptiveInfo(composer, 0).getWindowSizeClass().getWindowWidthSizeClass();
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume;
        composer.startReplaceGroup(998099958);
        ComposerKt.sourceInformation(composer, "CC(remember):StackComponentState.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(stackComponentStyle)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            StackComponentState stackComponentState = new StackComponentState(windowWidthSizeClass, layoutDirection, stackComponentStyle, function0, function02, function03, function04);
            composer.updateRememberedValue(stackComponentState);
            objRememberedValue = stackComponentState;
        }
        StackComponentState stackComponentState2 = (StackComponentState) objRememberedValue;
        composer.endReplaceGroup();
        stackComponentState2.update(windowWidthSizeClass, layoutDirection);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stackComponentState2;
    }
}
