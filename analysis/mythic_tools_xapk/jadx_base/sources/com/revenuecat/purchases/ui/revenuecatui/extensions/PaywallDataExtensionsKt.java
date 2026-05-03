package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.ColorKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockResourceProvider;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallDataExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001b\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u001e\u001a\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002\u001a\u0016\u0010#\u001a\u00020$*\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a*\u0010(\u001a\u00020)*\u00020\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0000\u001a*\u0010.\u001a\u00020)*\u00020\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u00100\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0000\u001a\u0014\u00101\u001a\u000202*\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0002\u001a\u0014\u00103\u001a\u000204*\u00020\u00022\u0006\u0010,\u001a\u00020-H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\u0010*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"defaultAppIconPlaceholder", "", "Lcom/revenuecat/purchases/paywalls/PaywallData$Companion;", "getDefaultAppIconPlaceholder", "(Lcom/revenuecat/purchases/paywalls/PaywallData$Companion;)Ljava/lang/String;", "defaultBackgroundPlaceholder", "getDefaultBackgroundPlaceholder", "defaultTemplate", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "getDefaultTemplate", "(Lcom/revenuecat/purchases/paywalls/PaywallData$Companion;)Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "defaultTemplateBaseURL", "Ljava/net/URL;", "getDefaultTemplateBaseURL", "(Lcom/revenuecat/purchases/paywalls/PaywallData$Companion;)Ljava/net/URL;", "revisionID", "", "getRevisionID", "(Lcom/revenuecat/purchases/paywalls/PaywallData$Companion;)I", "zeroDecimalPlaceCountries", "", "getZeroDecimalPlaceCountries", "(Lcom/revenuecat/purchases/paywalls/PaywallData$Companion;)Ljava/util/List;", "DefaultPaywallFooterCondensedPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "DefaultPaywallFooterPreview", "DefaultPaywallPreview", "getDefaultPreviewOffering", "Lcom/revenuecat/purchases/Offering;", "(Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/Offering;", "getThemeColors", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "currentColorScheme", "Landroidx/compose/material3/ColorScheme;", "asPaywallColor", "Lcom/revenuecat/purchases/paywalls/PaywallColor;", "Landroidx/compose/ui/graphics/Color;", "asPaywallColor-8_81llA", "(J)Lcom/revenuecat/purchases/paywalls/PaywallColor;", "createDefault", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "packages", "Lcom/revenuecat/purchases/Package;", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "createDefaultForIdentifiers", "packageIdentifiers", "currentColors", "defaultColors", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "defaultLocalization", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallDataExtensionsKt {
    public static final void DefaultPaywallFooterCondensedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1110154474);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallFooterCondensedPreview)171@6427L27,169@6257L205:PaywallDataExtensions.kt#yuhptp");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1110154474, i, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.DefaultPaywallFooterCondensedPreview (PaywallDataExtensions.kt:168)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallFooterCondensedPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, getDefaultPreviewOffering(composerStartRestartGroup, 0), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallFooterCondensedPreview.2
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
                    PaywallDataExtensionsKt.DefaultPaywallFooterCondensedPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void DefaultPaywallFooterPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1073266441);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallFooterPreview)162@6079L27,160@5919L195:PaywallDataExtensions.kt#yuhptp");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1073266441, i, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.DefaultPaywallFooterPreview (PaywallDataExtensions.kt:159)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallFooterPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, getDefaultPreviewOffering(composerStartRestartGroup, 0), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallFooterPreview.2
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
                    PaywallDataExtensionsKt.DefaultPaywallFooterPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void DefaultPaywallPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1231396708);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallPreview)153@5750L27,151@5617L168:PaywallDataExtensions.kt#yuhptp");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1231396708, i, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.DefaultPaywallPreview (PaywallDataExtensions.kt:150)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(null, getDefaultPreviewOffering(composerStartRestartGroup, 0), null, false, false, 29, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt.DefaultPaywallPreview.2
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
                    PaywallDataExtensionsKt.DefaultPaywallPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: asPaywallColor-8_81llA, reason: not valid java name */
    private static final PaywallColor m10843asPaywallColor8_81llA(long j) {
        return new PaywallColor(ColorKt.m6379toArgb8_81llA(j));
    }

    public static final PaywallData createDefault(PaywallData.Companion companion, List<Package> packages, ColorScheme currentColorScheme, ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        PaywallData.Companion companion2 = PaywallData.INSTANCE;
        List<Package> list = packages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Package) it.next()).getIdentifier());
        }
        return createDefaultForIdentifiers(companion2, arrayList, currentColorScheme, resourceProvider);
    }

    public static final PaywallData createDefaultForIdentifiers(PaywallData.Companion companion, List<String> packageIdentifiers, ColorScheme currentColors, ResourceProvider resourceProvider) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(packageIdentifiers, "packageIdentifiers");
        Intrinsics.checkNotNullParameter(currentColors, "currentColors");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        return new PaywallData((String) null, getDefaultTemplate(PaywallData.INSTANCE).getId(), new PaywallData.Configuration((List) packageIdentifiers, (String) null, new PaywallData.Configuration.Images((String) null, getDefaultBackgroundPlaceholder(PaywallData.INSTANCE), getDefaultAppIconPlaceholder(PaywallData.INSTANCE), 1, (DefaultConstructorMarker) null), (Map) null, defaultColors(PaywallData.INSTANCE, currentColors), (Map) null, (List) null, true, true, (URL) null, (URL) null, 1642, (DefaultConstructorMarker) null), getDefaultTemplateBaseURL(PaywallData.INSTANCE), getRevisionID(PaywallData.INSTANCE), MapsKt.mapOf(TuplesKt.to(resourceProvider.getLocale().toString(), defaultLocalization(PaywallData.INSTANCE, resourceProvider))), (Map) null, getZeroDecimalPlaceCountries(PaywallData.INSTANCE), (String) null, 321, (DefaultConstructorMarker) null);
    }

    private static final PaywallData.Configuration.ColorInformation defaultColors(PaywallData.Companion companion, ColorScheme colorScheme) {
        PaywallData.Configuration.Colors themeColors = getThemeColors(colorScheme);
        return new PaywallData.Configuration.ColorInformation(themeColors, themeColors);
    }

    private static final PaywallData.LocalizedConfiguration defaultLocalization(PaywallData.Companion companion, ResourceProvider resourceProvider) {
        return new PaywallData.LocalizedConfiguration("{{ app_name }}", (String) null, resourceProvider.getString(R.string.continue_cta, new Object[0]), (String) null, (String) null, "{{ total_price_and_per_month }}", resourceProvider.getString(R.string.default_offer_details_with_intro_offer, new Object[0]), (String) null, "{{ sub_period }}", (List) null, (String) null, (Map) null, 3738, (DefaultConstructorMarker) null);
    }

    public static final String getDefaultAppIconPlaceholder(PaywallData.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return "revenuecatui_default_paywall_app_icon";
    }

    public static final String getDefaultBackgroundPlaceholder(PaywallData.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return "revenuecatui_default_paywall_background";
    }

    private static final Offering getDefaultPreviewOffering(Composer composer, int i) {
        composer.startReplaceGroup(-363130030);
        ComposerKt.sourceInformation(composer, "C(getDefaultPreviewOffering)135@5207L11:PaywallDataExtensions.kt#yuhptp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-363130030, i, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.getDefaultPreviewOffering (PaywallDataExtensions.kt:127)");
        }
        List listListOf = CollectionsKt.listOf((Object[]) new Package[]{TestData.Packages.INSTANCE.getWeekly(), TestData.Packages.INSTANCE.getMonthly(), TestData.Packages.INSTANCE.getAnnual()});
        Offering offering = new Offering("Template2", "", MapsKt.emptyMap(), listListOf, createDefault(PaywallData.INSTANCE, listListOf, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable), new MockResourceProvider(null, null, null, null, null, 31, null)), null, null, 96, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return offering;
    }

    public static final PaywallTemplate getDefaultTemplate(PaywallData.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return PaywallTemplate.TEMPLATE_2;
    }

    private static final URL getDefaultTemplateBaseURL(PaywallData.Companion companion) {
        return new URL("https://");
    }

    private static final int getRevisionID(PaywallData.Companion companion) {
        return -1;
    }

    private static final PaywallData.Configuration.Colors getThemeColors(ColorScheme colorScheme) {
        return new PaywallData.Configuration.Colors(m10843asPaywallColor8_81llA(colorScheme.getBackground()), m10843asPaywallColor8_81llA(colorScheme.getInverseSurface()), (PaywallColor) null, (PaywallColor) null, m10843asPaywallColor8_81llA(colorScheme.getSecondary()), m10843asPaywallColor8_81llA(colorScheme.getBackground()), (PaywallColor) null, m10843asPaywallColor8_81llA(colorScheme.getPrimary()), m10843asPaywallColor8_81llA(colorScheme.getInversePrimary()), (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 32332, (DefaultConstructorMarker) null);
    }

    private static final List<String> getZeroDecimalPlaceCountries(PaywallData.Companion companion) {
        return CollectionsKt.emptyList();
    }
}
