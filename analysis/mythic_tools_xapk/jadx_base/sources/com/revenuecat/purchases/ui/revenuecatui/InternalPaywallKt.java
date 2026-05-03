package com.revenuecat.purchases.ui.revenuecatui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.composables.CloseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.ErrorDialogKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelFactory;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallThemeKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ContextExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallResourceProviderKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template1Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template3Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template5Kt;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt;
import com.revenuecat.purchases.ui.revenuecatui.utils.URLOpener;
import com.revenuecat.purchases.ui.revenuecatui.utils.URLOpeningMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: InternalPaywall.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\n\u001a\u001d\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\n\u001a-\u0010\f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0001¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0019*\u00020\tH\u0003¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u001c*\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002\u001a&\u0010$\u001a\u00020%*\u00020%2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"InternalPaywall", "", "options", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;II)V", "LoadedPaywall", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;I)V", "TemplatePaywall", "getPaywallViewModel", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "rememberPaywallActionHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "configurationWithOverriddenLocale", "Landroid/content/res/Configuration;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroidx/compose/runtime/Composer;I)Landroid/content/res/Configuration;", "contextWithConfiguration", "Landroid/content/Context;", "configuration", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroid/content/res/Configuration;Landroidx/compose/runtime/Composer;I)Landroid/content/Context;", "handleUrlDestination", "url", "", FirebaseAnalytics.Param.METHOD, "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "screenModeBackground", "Landroidx/compose/ui/Modifier;", "isInFullScreenMode", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "screenModeBackground-mxwnekA", "(Landroidx/compose/ui/Modifier;ZJ)Landroidx/compose/ui/Modifier;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InternalPaywallKt {

    /* JADX INFO: compiled from: InternalPaywall.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaywallTemplate.values().length];
            try {
                iArr[PaywallTemplate.TEMPLATE_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_5.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_7.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ButtonComponent.UrlMethod.values().length];
            try {
                iArr2[ButtonComponent.UrlMethod.IN_APP_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ButtonComponent.UrlMethod.EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ButtonComponent.UrlMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ButtonComponent.UrlMethod.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x026b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InternalPaywall(final PaywallOptions options, PaywallViewModel paywallViewModel, Composer composer, final int i, final int i2) {
        int i3;
        PaywallViewModel paywallViewModel2;
        final PaywallViewModel paywallViewModel3;
        boolean z;
        Object objRememberedValue;
        final ColorScheme colorScheme;
        final boolean zIsSystemInDarkTheme;
        boolean zChanged;
        Object objRememberedValue2;
        final PaywallState paywallState;
        Intrinsics.checkNotNullParameter(options, "options");
        Composer composerStartRestartGroup = composer.startRestartGroup(458565693);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InternalPaywall)65@3536L40,65@3524L52,69@3614L11,70@3643L21,71@3680L145,71@3669L156,76@3859L29,78@3950L482,78@3900L532,92@4488L646,92@4438L696,114@5459L537,110@5254L742:InternalPaywall.kt#ao8ymz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(options) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                paywallViewModel2 = paywallViewModel;
                int i4 = composerStartRestartGroup.changed(paywallViewModel2) ? 32 : 16;
                i3 |= i4;
            } else {
                paywallViewModel2 = paywallViewModel;
            }
            i3 |= i4;
        } else {
            paywallViewModel2 = paywallViewModel;
        }
        if ((i3 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            paywallViewModel3 = paywallViewModel2;
        } else {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "63@3486L28");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
                    paywallViewModel2 = getPaywallViewModel(options, null, composerStartRestartGroup, i3 & 14, 2);
                    i3 &= -113;
                }
                paywallViewModel3 = paywallViewModel2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(458565693, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall (InternalPaywall.kt:64)");
                }
                composerStartRestartGroup.startReplaceGroup(-1568492876);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                int i5 = (i3 & 112) ^ 48;
                z = (i5 <= 32 && composerStartRestartGroup.changed(paywallViewModel3)) || (i3 & 48) == 32;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$1$1
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
                            PaywallViewModel.DefaultImpls.closePaywall$default(paywallViewModel3, null, 1, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                BackHandlerKt.BackHandler(false, (Function0) objRememberedValue, composerStartRestartGroup, 0, 1);
                colorScheme = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable);
                zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceGroup(-1568488163);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                zChanged = ((i5 <= 32 && composerStartRestartGroup.changed(paywallViewModel3)) || (i3 & 48) == 32) | composerStartRestartGroup.changed(colorScheme) | composerStartRestartGroup.changed(zIsSystemInDarkTheme);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            paywallViewModel3.refreshStateIfLocaleChanged();
                            paywallViewModel3.refreshStateIfColorsChanged(colorScheme, zIsSystemInDarkTheme);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.SideEffect((Function0) objRememberedValue2, composerStartRestartGroup, 0);
                paywallState = (PaywallState) FlowExtKt.collectAsStateWithLifecycle(paywallViewModel3.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7).getValue();
                PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1925201086, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        ComposerKt.sourceInformation(composer2, "C83@4202L224,79@3960L466:InternalPaywall.kt#ao8ymz");
                        if ((i6 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1925201086, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:79)");
                        }
                        PaywallState paywallState2 = paywallState;
                        boolean z2 = (paywallState2 instanceof PaywallState.Loading) || (paywallState2 instanceof PaywallState.Error);
                        EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                        ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                        final PaywallOptions paywallOptions = options;
                        final PaywallViewModel paywallViewModel4 = paywallViewModel3;
                        AnimatedVisibilityKt.AnimatedVisibility(z2, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, ComposableLambdaKt.rememberComposableLambda(272980506, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                invoke(animatedVisibilityScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i7) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation(composer3, "C87@4378L23,84@4216L200:InternalPaywall.kt#ao8ymz");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(272980506, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:84)");
                                }
                                PaywallMode mode = paywallOptions.getMode();
                                boolean shouldDisplayDismissButton = paywallOptions.getShouldDisplayDismissButton();
                                PaywallViewModel paywallViewModel5 = paywallViewModel4;
                                composer3.startReplaceGroup(1191294305);
                                ComposerKt.sourceInformation(composer3, "CC(remember):InternalPaywall.kt#9igjgp");
                                boolean zChanged2 = composer3.changed(paywallViewModel5);
                                InternalPaywallKt$InternalPaywall$3$1$1$1 internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue = composer3.rememberedValue();
                                if (zChanged2 || internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$3$1$1$1(paywallViewModel5);
                                    composer3.updateRememberedValue(internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue);
                                }
                                composer3.endReplaceGroup();
                                LoadingPaywallKt.LoadingPaywall(mode, shouldDisplayDismissButton, (Function0<Unit>) internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
                PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1460021447, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        ComposerKt.sourceInformation(composer2, "C97@4715L413,93@4498L630:InternalPaywall.kt#ao8ymz");
                        if ((i6 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1460021447, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:93)");
                        }
                        boolean z2 = paywallState instanceof PaywallState.Loaded.Legacy;
                        EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                        ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                        final PaywallState paywallState2 = paywallState;
                        final PaywallViewModel paywallViewModel4 = paywallViewModel3;
                        AnimatedVisibilityKt.AnimatedVisibility(z2, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, ComposableLambdaKt.rememberComposableLambda(-2131421167, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                invoke(animatedVisibilityScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i7) {
                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                ComposerKt.sourceInformation(composer3, "C99@4788L51:InternalPaywall.kt#ao8ymz");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2131421167, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:98)");
                                }
                                PaywallState paywallState3 = paywallState2;
                                if (paywallState3 instanceof PaywallState.Loaded.Legacy) {
                                    InternalPaywallKt.LoadedPaywall((PaywallState.Loaded.Legacy) paywallState3, paywallViewModel4, composer3, 0);
                                } else {
                                    Logger.INSTANCE.e("State is not loaded while transitioning animation. This may happen if state changes from being loaded to a different state. This should not happen.");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
                AnimatedVisibilityKt.AnimatedVisibility(paywallState instanceof PaywallState.Loaded.Components, (Modifier) null, EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1024882965, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.5
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
                        ComposerKt.sourceInformation(composer2, "C119@5670L39,117@5583L141:InternalPaywall.kt#ao8ymz");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1024882965, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:115)");
                        }
                        if (paywallState instanceof PaywallState.Loaded.Components) {
                            paywallViewModel3.trackPaywallImpressionIfNeeded();
                            LoadedPaywallComponentsKt.LoadedPaywallComponents((PaywallState.Loaded.Components) paywallState, InternalPaywallKt.rememberPaywallActionHandler(paywallViewModel3, composer2, 0), null, composer2, 0, 4);
                        } else {
                            Logger.INSTANCE.e("State is not Loaded.Components while transitioning animation. This may happen if state changes from being loaded to a different state. This should not happen.");
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                composerStartRestartGroup = composerStartRestartGroup;
                if (!(paywallState instanceof PaywallState.Loading)) {
                    composerStartRestartGroup.startReplaceGroup(-1376144204);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (paywallState instanceof PaywallState.Error) {
                    composerStartRestartGroup.startReplaceGroup(-1376099967);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "133@6153L171,133@6103L221");
                    PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1440901149, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            ComposerKt.sourceInformation(composer2, "C134@6171L139:InternalPaywall.kt#ao8ymz");
                            if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1440901149, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:134)");
                            }
                            ErrorDialogKt.ErrorDialog(options.getDismissRequest(), ((PaywallState.Error) paywallState).getErrorMessage(), composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (paywallState instanceof PaywallState.Loaded) {
                    composerStartRestartGroup.startReplaceGroup(-1375811822);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*143@6465L188");
                    final PurchasesError value = paywallViewModel3.getActionError().getValue();
                    if (value != null) {
                        final ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2015353972, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$7$errorDialog$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i6) {
                                ComposerKt.sourceInformation(composer2, "C145@6541L27,144@6487L148:InternalPaywall.kt#ao8ymz");
                                if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2015353972, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:144)");
                                }
                                PaywallViewModel paywallViewModel4 = paywallViewModel3;
                                composer2.startReplaceGroup(1191363525);
                                ComposerKt.sourceInformation(composer2, "CC(remember):InternalPaywall.kt#9igjgp");
                                boolean zChanged2 = composer2.changed(paywallViewModel4);
                                InternalPaywallKt$InternalPaywall$7$errorDialog$1$1$1 internalPaywallKt$InternalPaywall$7$errorDialog$1$1$1RememberedValue = composer2.rememberedValue();
                                if (zChanged2 || internalPaywallKt$InternalPaywall$7$errorDialog$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    internalPaywallKt$InternalPaywall$7$errorDialog$1$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$7$errorDialog$1$1$1(paywallViewModel4);
                                    composer2.updateRememberedValue(internalPaywallKt$InternalPaywall$7$errorDialog$1$1$1RememberedValue);
                                }
                                composer2.endReplaceGroup();
                                ErrorDialogKt.ErrorDialog((Function0) ((KFunction) internalPaywallKt$InternalPaywall$7$errorDialog$1$1$1RememberedValue), value.getMessage(), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54);
                        PaywallState.Loaded loaded = (PaywallState.Loaded) paywallState;
                        if (loaded instanceof PaywallState.Loaded.Legacy) {
                            composerStartRestartGroup.startReplaceGroup(-1503587570);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "150@6788L17,150@6738L67");
                            PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-533250649, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$7$1
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
                                    ComposerKt.sourceInformation(composer2, "C150@6790L13:InternalPaywall.kt#ao8ymz");
                                    if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-533250649, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:150)");
                                    }
                                    composableLambdaRememberComposableLambda.invoke(composer2, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (loaded instanceof PaywallState.Loaded.Components) {
                            composerStartRestartGroup.startReplaceGroup(-1503583624);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "151@6863L13");
                            composableLambdaRememberComposableLambda.invoke(composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(633578263);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1375279242);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                paywallViewModel3 = paywallViewModel2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceGroup(-1568492876);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                int i52 = (i3 & 112) ^ 48;
                if (i52 <= 32) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$1$1
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
                                PaywallViewModel.DefaultImpls.closePaywall$default(paywallViewModel3, null, 1, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        BackHandlerKt.BackHandler(false, (Function0) objRememberedValue, composerStartRestartGroup, 0, 1);
                        colorScheme = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable);
                        zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceGroup(-1568488163);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                        if (i52 <= 32) {
                            zChanged = ((i52 <= 32 && composerStartRestartGroup.changed(paywallViewModel3)) || (i3 & 48) == 32) | composerStartRestartGroup.changed(colorScheme) | composerStartRestartGroup.changed(zIsSystemInDarkTheme);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        paywallViewModel3.refreshStateIfLocaleChanged();
                                        paywallViewModel3.refreshStateIfColorsChanged(colorScheme, zIsSystemInDarkTheme);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                composerStartRestartGroup.endReplaceGroup();
                                EffectsKt.SideEffect((Function0) objRememberedValue2, composerStartRestartGroup, 0);
                                paywallState = (PaywallState) FlowExtKt.collectAsStateWithLifecycle(paywallViewModel3.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7).getValue();
                                PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1925201086, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i6) {
                                        ComposerKt.sourceInformation(composer2, "C83@4202L224,79@3960L466:InternalPaywall.kt#ao8ymz");
                                        if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1925201086, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:79)");
                                        }
                                        PaywallState paywallState2 = paywallState;
                                        boolean z2 = (paywallState2 instanceof PaywallState.Loading) || (paywallState2 instanceof PaywallState.Error);
                                        EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                        ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                        final PaywallOptions paywallOptions = options;
                                        final PaywallViewModel paywallViewModel4 = paywallViewModel3;
                                        AnimatedVisibilityKt.AnimatedVisibility(z2, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, ComposableLambdaKt.rememberComposableLambda(272980506, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                                invoke(animatedVisibilityScope, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i7) {
                                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                                ComposerKt.sourceInformation(composer3, "C87@4378L23,84@4216L200:InternalPaywall.kt#ao8ymz");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(272980506, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:84)");
                                                }
                                                PaywallMode mode = paywallOptions.getMode();
                                                boolean shouldDisplayDismissButton = paywallOptions.getShouldDisplayDismissButton();
                                                PaywallViewModel paywallViewModel5 = paywallViewModel4;
                                                composer3.startReplaceGroup(1191294305);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):InternalPaywall.kt#9igjgp");
                                                boolean zChanged2 = composer3.changed(paywallViewModel5);
                                                InternalPaywallKt$InternalPaywall$3$1$1$1 internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue = composer3.rememberedValue();
                                                if (zChanged2 || internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$3$1$1$1(paywallViewModel5);
                                                    composer3.updateRememberedValue(internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue);
                                                }
                                                composer3.endReplaceGroup();
                                                LoadingPaywallKt.LoadingPaywall(mode, shouldDisplayDismissButton, (Function0<Unit>) internalPaywallKt$InternalPaywall$3$1$1$1RememberedValue, composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
                                PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1460021447, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i6) {
                                        ComposerKt.sourceInformation(composer2, "C97@4715L413,93@4498L630:InternalPaywall.kt#ao8ymz");
                                        if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1460021447, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:93)");
                                        }
                                        boolean z2 = paywallState instanceof PaywallState.Loaded.Legacy;
                                        EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                        ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                        final PaywallState paywallState2 = paywallState;
                                        final PaywallViewModel paywallViewModel4 = paywallViewModel3;
                                        AnimatedVisibilityKt.AnimatedVisibility(z2, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, ComposableLambdaKt.rememberComposableLambda(-2131421167, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                                invoke(animatedVisibilityScope, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i7) {
                                                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                                ComposerKt.sourceInformation(composer3, "C99@4788L51:InternalPaywall.kt#ao8ymz");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2131421167, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:98)");
                                                }
                                                PaywallState paywallState3 = paywallState2;
                                                if (paywallState3 instanceof PaywallState.Loaded.Legacy) {
                                                    InternalPaywallKt.LoadedPaywall((PaywallState.Loaded.Legacy) paywallState3, paywallViewModel4, composer3, 0);
                                                } else {
                                                    Logger.INSTANCE.e("State is not loaded while transitioning animation. This may happen if state changes from being loaded to a different state. This should not happen.");
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
                                AnimatedVisibilityKt.AnimatedVisibility(paywallState instanceof PaywallState.Loaded.Components, (Modifier) null, EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1024882965, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.5
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
                                        ComposerKt.sourceInformation(composer2, "C119@5670L39,117@5583L141:InternalPaywall.kt#ao8ymz");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1024882965, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:115)");
                                        }
                                        if (paywallState instanceof PaywallState.Loaded.Components) {
                                            paywallViewModel3.trackPaywallImpressionIfNeeded();
                                            LoadedPaywallComponentsKt.LoadedPaywallComponents((PaywallState.Loaded.Components) paywallState, InternalPaywallKt.rememberPaywallActionHandler(paywallViewModel3, composer2, 0), null, composer2, 0, 4);
                                        } else {
                                            Logger.INSTANCE.e("State is not Loaded.Components while transitioning animation. This may happen if state changes from being loaded to a different state. This should not happen.");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                composerStartRestartGroup = composerStartRestartGroup;
                                if (!(paywallState instanceof PaywallState.Loading)) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                        } else {
                            zChanged = ((i52 <= 32 && composerStartRestartGroup.changed(paywallViewModel3)) || (i3 & 48) == 32) | composerStartRestartGroup.changed(colorScheme) | composerStartRestartGroup.changed(zIsSystemInDarkTheme);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                            }
                        }
                    }
                } else {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z) {
                    }
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    InternalPaywallKt.InternalPaywall(options, paywallViewModel3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywall(final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1252678312);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywall)162@7134L7,193@8354L18,194@8388L756:InternalPaywall.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(legacy) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1252678312, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.LoadedPaywall (InternalPaywall.kt:160)");
            }
            paywallViewModel.trackPaywallImpressionIfNeeded();
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Activity activity = ContextExtensionsKt.getActivity((Context) objConsume);
            composerStartRestartGroup.startReplaceGroup(-492482342);
            ComposerKt.sourceInformation(composerStartRestartGroup, "166@7273L11,167@7341L11,168@7371L906");
            if (legacy.getValidationWarning() != null) {
                long background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                long onSurface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface();
                Modifier modifierM10445screenModeBackgroundmxwnekA = m10445screenModeBackgroundmxwnekA(Modifier.INSTANCE, PaywallStateKt.isInFullScreenMode(legacy), background);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM10445screenModeBackgroundmxwnekA);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 188643840, "C175@7736L24,176@7791L83,179@7904L68,171@7499L488,187@8229L23,183@8000L267:InternalPaywall.kt#ao8ymz");
                List<TemplateConfiguration.PackageInfo> all = legacy.getTemplateConfiguration().getPackages().getAll();
                TemplateConfiguration.PackageInfo value = legacy.getSelectedPackage().getValue();
                PaywallWarning validationWarning = legacy.getValidationWarning();
                composerStartRestartGroup.startReplaceGroup(2084302107);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                int i3 = i2 & 112;
                boolean z = i3 == 32;
                InternalPaywallKt$LoadedPaywall$1$1$1 internalPaywallKt$LoadedPaywall$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || internalPaywallKt$LoadedPaywall$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    internalPaywallKt$LoadedPaywall$1$1$1RememberedValue = new InternalPaywallKt$LoadedPaywall$1$1$1(paywallViewModel);
                    composerStartRestartGroup.updateRememberedValue(internalPaywallKt$LoadedPaywall$1$1$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                Function1 function1 = (Function1) ((KFunction) internalPaywallKt$LoadedPaywall$1$1$1RememberedValue);
                composerStartRestartGroup.startReplaceGroup(2084303926);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                boolean zChangedInstance = (i3 == 32) | composerStartRestartGroup.changedInstance(activity);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$LoadedPaywall$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            paywallViewModel.purchaseSelectedPackage(activity);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(2084307527);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                boolean z2 = i3 == 32;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$LoadedPaywall$1$3$1
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
                            paywallViewModel.restorePurchases();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                DefaultPaywallViewKt.DefaultPaywallView(all, value, validationWarning, function1, function0, (Function0) objRememberedValue2, null, null, composerStartRestartGroup, 0, 192);
                boolean shouldDisplayDismissButton = legacy.getShouldDisplayDismissButton();
                Color colorM6315boximpl = Color.m6315boximpl(onSurface);
                boolean zBooleanValue = paywallViewModel.getActionInProgress().getValue().booleanValue();
                composerStartRestartGroup.startReplaceGroup(2084317882);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                boolean z3 = i3 == 32;
                InternalPaywallKt$LoadedPaywall$1$4$1 internalPaywallKt$LoadedPaywall$1$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || internalPaywallKt$LoadedPaywall$1$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    internalPaywallKt$LoadedPaywall$1$4$1RememberedValue = new InternalPaywallKt$LoadedPaywall$1$4$1(paywallViewModel);
                    composerStartRestartGroup.updateRememberedValue(internalPaywallKt$LoadedPaywall$1$4$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                CloseButtonKt.m10618CloseButtondrOMvmE(boxScopeInstance, shouldDisplayDismissButton, colorM6315boximpl, zBooleanValue, (Function0) internalPaywallKt$LoadedPaywall$1$4$1RememberedValue, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.LoadedPaywall.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i4) {
                            InternalPaywallKt.LoadedPaywall(legacy, paywallViewModel, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                        }
                    });
                    return;
                }
                return;
            }
            int i4 = i2;
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM10445screenModeBackgroundmxwnekA2 = m10445screenModeBackgroundmxwnekA(Modifier.INSTANCE, PaywallStateKt.isInFullScreenMode(legacy), legacy.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0).m10776getBackground0d7_KjU());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM10445screenModeBackgroundmxwnekA2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 189634724, "C197@8528L35,201@8684L39,203@8790L77,199@8573L294,208@8990L13,210@9104L23,206@8876L262:InternalPaywall.kt#ao8ymz");
            int i5 = i4 & 14;
            Configuration configurationConfigurationWithOverriddenLocale = configurationWithOverriddenLocale(legacy, composerStartRestartGroup, i5);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{HelperFunctionsKt.getLocalActivity().provides(activity), AndroidCompositionLocals_androidKt.getLocalContext().provides(contextWithConfiguration(legacy, configurationConfigurationWithOverriddenLocale, composerStartRestartGroup, i5)), AndroidCompositionLocals_androidKt.getLocalConfiguration().provides(configurationConfigurationWithOverriddenLocale)}, ComposableLambdaKt.rememberComposableLambda(1771404190, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$LoadedPaywall$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    ComposerKt.sourceInformation(composer2, "C204@8804L53:InternalPaywall.kt#ao8ymz");
                    if ((i6 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1771404190, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.LoadedPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:204)");
                    }
                    InternalPaywallKt.TemplatePaywall(legacy, paywallViewModel, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            boolean shouldDisplayDismissButton2 = legacy.getShouldDisplayDismissButton();
            Color colorM10780getCloseButtonQN2ZGVo = PaywallStateKt.getCurrentColors(legacy, composerStartRestartGroup, i5).m10780getCloseButtonQN2ZGVo();
            boolean zBooleanValue2 = paywallViewModel.getActionInProgress().getValue().booleanValue();
            composerStartRestartGroup.startReplaceGroup(2084345882);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
            boolean z4 = (i4 & 112) == 32;
            InternalPaywallKt$LoadedPaywall$3$2$1 internalPaywallKt$LoadedPaywall$3$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4 || internalPaywallKt$LoadedPaywall$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                internalPaywallKt$LoadedPaywall$3$2$1RememberedValue = new InternalPaywallKt$LoadedPaywall$3$2$1(paywallViewModel);
                composerStartRestartGroup.updateRememberedValue(internalPaywallKt$LoadedPaywall$3$2$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            CloseButtonKt.m10618CloseButtondrOMvmE(boxScopeInstance2, shouldDisplayDismissButton2, colorM10780getCloseButtonQN2ZGVo, zBooleanValue2, (Function0) internalPaywallKt$LoadedPaywall$3$2$1RememberedValue, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.LoadedPaywall.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    InternalPaywallKt.LoadedPaywall(legacy, paywallViewModel, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TemplatePaywall(PaywallState.Loaded.Legacy legacy, PaywallViewModel paywallViewModel, Composer composer, final int i) {
        int i2;
        final PaywallState.Loaded.Legacy legacy2;
        final PaywallViewModel paywallViewModel2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1883481085);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TemplatePaywall):InternalPaywall.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(legacy) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            legacy2 = legacy;
            paywallViewModel2 = paywallViewModel;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1883481085, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.TemplatePaywall (InternalPaywall.kt:216)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[legacy.getTemplateConfiguration().getTemplate().ordinal()]) {
                case 1:
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    composerStartRestartGroup.startReplaceGroup(-820467874);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "218@9342L47");
                    Template1Kt.Template1(legacy2, paywallViewModel2, composerStartRestartGroup, i2 & 126);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 2:
                    composerStartRestartGroup.startReplaceGroup(-820465122);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "219@9428L47");
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    Template2Kt.Template2(legacy2, paywallViewModel2, null, composerStartRestartGroup, i2 & 126, 4);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 3:
                    composerStartRestartGroup.startReplaceGroup(-820462370);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "220@9514L47");
                    Template3Kt.Template3(legacy, paywallViewModel, composerStartRestartGroup, i2 & 126);
                    composerStartRestartGroup.endReplaceGroup();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                case 4:
                    composerStartRestartGroup.startReplaceGroup(-820459618);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "221@9600L47");
                    Template4Kt.Template4(legacy, paywallViewModel, composerStartRestartGroup, i2 & 126);
                    composerStartRestartGroup.endReplaceGroup();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                case 5:
                    composerStartRestartGroup.startReplaceGroup(-820456866);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "222@9686L47");
                    Template5Kt.Template5(legacy, paywallViewModel, composerStartRestartGroup, i2 & 126);
                    composerStartRestartGroup.endReplaceGroup();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                case 6:
                    composerStartRestartGroup.startReplaceGroup(-820454114);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@9772L47");
                    Template7Kt.Template7(legacy, paywallViewModel, composerStartRestartGroup, i2 & 126);
                    composerStartRestartGroup.endReplaceGroup();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                default:
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    composerStartRestartGroup.startReplaceGroup(335777363);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.TemplatePaywall.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    InternalPaywallKt.TemplatePaywall(legacy2, paywallViewModel2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Configuration configurationWithOverriddenLocale(PaywallState.Loaded.Legacy legacy, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 761546839, "C(configurationWithOverriddenLocale)261@11030L7:InternalPaywall.kt#ao8ymz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(761546839, i, -1, "com.revenuecat.purchases.ui.revenuecatui.configurationWithOverriddenLocale (InternalPaywall.kt:260)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Configuration configuration = new Configuration((Configuration) objConsume);
        configuration.setLocale(legacy.getTemplateConfiguration().getLocale());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return configuration;
    }

    private static final Context contextWithConfiguration(PaywallState.Loaded.Legacy legacy, Configuration configuration, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2083869389, "C(contextWithConfiguration)252@10693L7:InternalPaywall.kt#ao8ymz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2083869389, i, -1, "com.revenuecat.purchases.ui.revenuecatui.contextWithConfiguration (InternalPaywall.kt:251)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        if (contextCreateConfigurationContext != null) {
            context = contextCreateConfigurationContext;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return context;
    }

    public static final PaywallViewModel getPaywallViewModel(PaywallOptions options, Function1<? super CustomerInfo, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(options, "options");
        composer.startReplaceGroup(-1725540891);
        ComposerKt.sourceInformation(composer, "C(getPaywallViewModel)233@10037L7,239@10305L11,240@10330L21,242@10428L17,234@10084L379:InternalPaywall.kt#ao8ymz");
        Function1<? super CustomerInfo, Boolean> function12 = (i2 & 2) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1725540891, i, -1, "com.revenuecat.purchases.ui.revenuecatui.getPaywallViewModel (InternalPaywall.kt:232)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context applicationContext = ((Context) objConsume).getApplicationContext();
        String strValueOf = String.valueOf(options.hashCode());
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        PaywallViewModelFactory paywallViewModelFactory = new PaywallViewModelFactory(PaywallResourceProviderKt.toResourceProvider(applicationContext), options, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable), DarkThemeKt.isSystemInDarkTheme(composer, 0), function12, HelperFunctionsKt.isInPreviewMode(composer, 0));
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PaywallViewModelImpl.class), current, strValueOf, paywallViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer, 0, 0);
        composer.endReplaceableGroup();
        PaywallViewModelImpl paywallViewModelImpl = (PaywallViewModelImpl) viewModel;
        paywallViewModelImpl.updateOptions(options);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return paywallViewModelImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleUrlDestination(Context context, String str, ButtonComponent.UrlMethod urlMethod) {
        URLOpeningMethod uRLOpeningMethod;
        int i = WhenMappings.$EnumSwitchMapping$1[urlMethod.ordinal()];
        if (i == 1) {
            uRLOpeningMethod = URLOpeningMethod.IN_APP_BROWSER;
        } else if (i == 2) {
            uRLOpeningMethod = URLOpeningMethod.EXTERNAL_BROWSER;
        } else {
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.INSTANCE.e("Ignoring button click with unknown open method for URL: '" + str + "'. This is a bug in the SDK.");
                return;
            }
            uRLOpeningMethod = URLOpeningMethod.DEEP_LINK;
        }
        URLOpener.INSTANCE.openURL$revenuecatui_defaultsBc8Release(context, str, uRLOpeningMethod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<PaywallAction.External, Continuation<? super Unit>, Object> rememberPaywallActionHandler(PaywallViewModel paywallViewModel, Composer composer, int i) {
        composer.startReplaceGroup(-1933557776);
        ComposerKt.sourceInformation(composer, "C(rememberPaywallActionHandler)269@11292L7,271@11363L2002:InternalPaywall.kt#ao8ymz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1933557776, i, -1, "com.revenuecat.purchases.ui.revenuecatui.rememberPaywallActionHandler (InternalPaywall.kt:268)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        Activity activity = ContextExtensionsKt.getActivity(context);
        composer.startReplaceGroup(-1197188630);
        ComposerKt.sourceInformation(composer, "CC(remember):InternalPaywall.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(paywallViewModel)) || (i & 6) == 4;
        InternalPaywallKt$rememberPaywallActionHandler$1$1 internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue = composer.rememberedValue();
        if (z || internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue = new InternalPaywallKt$rememberPaywallActionHandler$1$1(paywallViewModel, activity, context, null);
            composer.updateRememberedValue(internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue);
        }
        Function2<PaywallAction.External, Continuation<? super Unit>, Object> function2 = (Function2) internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return function2;
    }

    /* JADX INFO: renamed from: screenModeBackground-mxwnekA, reason: not valid java name */
    private static final Modifier m10445screenModeBackgroundmxwnekA(Modifier modifier, boolean z, final long j) {
        return ModifierExtensionsKt.conditional(ModifierExtensionsKt.conditional(modifier, z, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$screenModeBackground$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Modifier invoke(Modifier conditional) {
                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                return BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), j, null, 2, null);
            }
        }), !z, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$screenModeBackground$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Modifier invoke(Modifier conditional) {
                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                return BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m2347RoundedCornerShapea9UjIt4$default(UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM(), UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM(), 0.0f, 0.0f, 12, null)), j, null, 2, null);
            }
        });
    }
}
