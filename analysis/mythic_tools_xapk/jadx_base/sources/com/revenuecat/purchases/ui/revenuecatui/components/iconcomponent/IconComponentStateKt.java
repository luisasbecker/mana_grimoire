package com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent;

import androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconComponentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u0005H\u0003¢\u0006\u0002\u0010\u000f\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"rememberUpdatedIconComponentState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/iconcomponent/IconComponentState;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/iconcomponent/IconComponentState;", "paywallState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/iconcomponent/IconComponentState;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconComponentStateKt {
    public static final /* synthetic */ IconComponentState rememberUpdatedIconComponentState(IconComponentStyle style, final PaywallState.Loaded.Components paywallState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(paywallState, "paywallState");
        composer.startReplaceGroup(-153323417);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedIconComponentState)P(1)37@1970L36,38@2039L33,39@2113L41,40@2186L38,35@1882L345:IconComponentState.kt#vnlbzp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-153323417, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.rememberUpdatedIconComponentState (IconComponentState.kt:35)");
        }
        composer.startReplaceGroup(1960797606);
        ComposerKt.sourceInformation(composer, "CC(remember):IconComponentState.kt#9igjgp");
        int i2 = (i & 112) ^ 48;
        boolean z = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<PaywallState.Loaded.Components.SelectedPackageInfo>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentStateKt$rememberUpdatedIconComponentState$1$1
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
        composer.startReplaceGroup(1960799811);
        ComposerKt.sourceInformation(composer, "CC(remember):IconComponentState.kt#9igjgp");
        boolean z2 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function0) new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentStateKt$rememberUpdatedIconComponentState$2$1
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
        composer.startReplaceGroup(1960802187);
        ComposerKt.sourceInformation(composer, "CC(remember):IconComponentState.kt#9igjgp");
        boolean z3 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function0) new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentStateKt$rememberUpdatedIconComponentState$3$1
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
        composer.startReplaceGroup(1960804520);
        ComposerKt.sourceInformation(composer, "CC(remember):IconComponentState.kt#9igjgp");
        boolean z4 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue4 = composer.rememberedValue();
        if (z4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function0) new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentStateKt$rememberUpdatedIconComponentState$4$1
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
        IconComponentState iconComponentStateRememberUpdatedIconComponentState = rememberUpdatedIconComponentState(style, function0, function02, function03, (Function0) objRememberedValue4, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconComponentStateRememberUpdatedIconComponentState;
    }

    private static final /* synthetic */ IconComponentState rememberUpdatedIconComponentState(IconComponentStyle iconComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Composer composer, int i) {
        composer.startReplaceGroup(-1304007611);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedIconComponentState)P(4,2,3,1)53@2650L27,54@2762L7,*56@2782L466:IconComponentState.kt#vnlbzp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1304007611, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.rememberUpdatedIconComponentState (IconComponentState.kt:52)");
        }
        WindowWidthSizeClass windowWidthSizeClass = AndroidWindowAdaptiveInfo_androidKt.currentWindowAdaptiveInfo(composer, 0).getWindowSizeClass().getWindowWidthSizeClass();
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume;
        composer.startReplaceGroup(1960824020);
        ComposerKt.sourceInformation(composer, "CC(remember):IconComponentState.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(iconComponentStyle)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            IconComponentState iconComponentState = new IconComponentState(windowWidthSizeClass, layoutDirection, iconComponentStyle, function0, function02, function03, function04);
            composer.updateRememberedValue(iconComponentState);
            objRememberedValue = iconComponentState;
        }
        IconComponentState iconComponentState2 = (IconComponentState) objRememberedValue;
        composer.endReplaceGroup();
        iconComponentState2.update(windowWidthSizeClass);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconComponentState2;
    }
}
