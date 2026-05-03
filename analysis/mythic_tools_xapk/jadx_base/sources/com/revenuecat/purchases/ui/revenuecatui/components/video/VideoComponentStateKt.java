package com.revenuecat.purchases.ui.revenuecatui.components.video;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.style.VideoComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoComponentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ai\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0005H\u0003¢\u0006\u0002\u0010\u0011\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"rememberUpdatedVideoComponentState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/video/VideoComponentState;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;", "localeProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/text/intl/Locale;", "selectedPackageInfoProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/video/VideoComponentState;", "paywallState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/video/VideoComponentState;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VideoComponentStateKt {
    public static final /* synthetic */ VideoComponentState rememberUpdatedVideoComponentState(VideoComponentStyle style, final PaywallState.Loaded.Components paywallState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(paywallState, "paywallState");
        composer.startReplaceGroup(-374173384);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedVideoComponentState)P(1)306@12502L23,307@12561L36,308@12630L33,309@12704L41,310@12777L38,304@12426L392:VideoComponentState.kt#26k46s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-374173384, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.video.rememberUpdatedVideoComponentState (VideoComponentState.kt:304)");
        }
        composer.startReplaceGroup(-904430054);
        ComposerKt.sourceInformation(composer, "CC(remember):VideoComponentState.kt#9igjgp");
        int i2 = (i & 112) ^ 48;
        boolean z = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<Locale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentStateKt$rememberUpdatedVideoComponentState$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Locale invoke() {
                    return paywallState.getLocale();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-904428153);
        ComposerKt.sourceInformation(composer, "CC(remember):VideoComponentState.kt#9igjgp");
        boolean z2 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function0) new Function0<PaywallState.Loaded.Components.SelectedPackageInfo>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentStateKt$rememberUpdatedVideoComponentState$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PaywallState.Loaded.Components.SelectedPackageInfo invoke() {
                    return paywallState.getSelectedPackageInfo();
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function02 = (Function0) objRememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-904425948);
        ComposerKt.sourceInformation(composer, "CC(remember):VideoComponentState.kt#9igjgp");
        boolean z3 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function0) new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentStateKt$rememberUpdatedVideoComponentState$3$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(paywallState.getSelectedTabIndex());
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function0 function03 = (Function0) objRememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-904423572);
        ComposerKt.sourceInformation(composer, "CC(remember):VideoComponentState.kt#9igjgp");
        boolean z4 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue4 = composer.rememberedValue();
        if (z4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function0) new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentStateKt$rememberUpdatedVideoComponentState$4$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final OfferEligibility invoke() {
                    return paywallState.getSelectedOfferEligibility();
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Function0 function04 = (Function0) objRememberedValue4;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-904421239);
        ComposerKt.sourceInformation(composer, "CC(remember):VideoComponentState.kt#9igjgp");
        boolean z5 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue5 = composer.rememberedValue();
        if (z5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = (Function0) new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentStateKt$rememberUpdatedVideoComponentState$5$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends CustomVariableValue> invoke() {
                    return paywallState.getMergedCustomVariables();
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        composer.endReplaceGroup();
        VideoComponentState videoComponentStateRememberUpdatedVideoComponentState = rememberUpdatedVideoComponentState(style, function0, function02, function03, function04, (Function0) objRememberedValue5, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return videoComponentStateRememberUpdatedVideoComponentState;
    }

    private static final /* synthetic */ VideoComponentState rememberUpdatedVideoComponentState(VideoComponentStyle videoComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Composer composer, int i) {
        Density density;
        composer.startReplaceGroup(-673938114);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedVideoComponentState)P(5,1,3,4,2)325@13309L27,326@13405L7,327@13432L21,328@13501L7,*330@13521L590:VideoComponentState.kt#26k46s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-673938114, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.video.rememberUpdatedVideoComponentState (VideoComponentState.kt:324)");
        }
        WindowWidthSizeClass windowWidthSizeClass = AndroidWindowAdaptiveInfo_androidKt.currentWindowAdaptiveInfo(composer, 0).getWindowSizeClass().getWindowWidthSizeClass();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density2 = (Density) objConsume;
        boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composer, 0);
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
        composer.startReplaceGroup(-904396879);
        ComposerKt.sourceInformation(composer, "CC(remember):VideoComponentState.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(videoComponentStyle)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            density = density2;
            VideoComponentState videoComponentState = new VideoComponentState(windowWidthSizeClass, density, zIsSystemInDarkTheme, layoutDirection, videoComponentStyle, function0, function02, function03, function04, function05);
            composer.updateRememberedValue(videoComponentState);
            objRememberedValue = videoComponentState;
        } else {
            density = density2;
        }
        VideoComponentState videoComponentState2 = (VideoComponentState) objRememberedValue;
        composer.endReplaceGroup();
        videoComponentState2.update(windowWidthSizeClass, density, Boolean.valueOf(zIsSystemInDarkTheme), layoutDirection);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return videoComponentState2;
    }
}
