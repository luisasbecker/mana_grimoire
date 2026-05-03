package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DualColorImageGenerator;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultPaywallPreviews.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\r\u0010\u0003\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0003¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0005\u001a\r\u0010\r\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0005\u001a\r\u0010\u000e\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0005\u001a\r\u0010\u000f\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u0005\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"previewPackages", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "DefaultPaywallBlueGreenPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "DefaultPaywallPreview", "icon", "Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DualColorImageGenerator$PreviewAppIcon;", "warning", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "(Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DualColorImageGenerator$PreviewAppIcon;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;Landroidx/compose/runtime/Composer;I)V", "DefaultPaywallPurpleOrangePreview", "DefaultPaywallRedGreenPreview", "DefaultPaywallWarningLocalizationPreview", "DefaultPaywallWarningNoPaywallPreview", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DefaultPaywallPreviewsKt {
    private static final List<TemplateConfiguration.PackageInfo> previewPackages;

    static {
        List<Package> listListOf = CollectionsKt.listOf((Object[]) new Package[]{TestData.Packages.INSTANCE.getAnnual(), TestData.Packages.INSTANCE.getMonthly()});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        for (Package r2 : listListOf) {
            arrayList.add(new TemplateConfiguration.PackageInfo(r2, new ProcessedLocalizedConfiguration(r2.getProduct().getName(), null, "Continue", null, null, null, null, null, r2.getProduct().getName(), null, null, null, 1024, null), null));
        }
        previewPackages = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallBlueGreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(657651692);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallBlueGreenPreview)62@2373L102:DefaultPaywallPreviews.kt#trihdm");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(657651692, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallBlueGreenPreview (DefaultPaywallPreviews.kt:61)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getBlueGreen(), null, composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallBlueGreenPreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallBlueGreenPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallPreview(final DualColorImageGenerator.PreviewAppIcon previewAppIcon, final PaywallWarning paywallWarning, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1946056999);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallPreview)115@3936L21,116@4046L600,116@4005L641:DefaultPaywallPreviews.kt#trihdm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(previewAppIcon) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallWarning) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1946056999, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreview (DefaultPaywallPreviews.kt:114)");
            }
            MaterialThemeKt.MaterialTheme(DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0) ? ColorSchemeKt.m3481darkColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null) : ColorSchemeKt.m3487lightColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null), null, null, ComposableLambdaKt.rememberComposableLambda(2020893435, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.1
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
                    ComposerKt.sourceInformation(composer2, "C124@4350L11,117@4056L584:DefaultPaywallPreviews.kt#trihdm");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2020893435, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreview.<anonymous> (DefaultPaywallPreviews.kt:117)");
                    }
                    DefaultPaywallViewKt.DefaultPaywallView(DefaultPaywallPreviewsKt.previewPackages, (TemplateConfiguration.PackageInfo) CollectionsKt.first(DefaultPaywallPreviewsKt.previewPackages), paywallWarning, new Function1<TemplateConfiguration.PackageInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.PackageInfo packageInfo) {
                            invoke2(packageInfo);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TemplateConfiguration.PackageInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.1.2
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.1.3
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    }, BackgroundKt.m1483backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null), new DefaultPaywallPreviewOverrides("RevenueCat", previewAppIcon.getBitmap(), previewAppIcon.getProminentColors(), true), composer2, 224256, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPreview.2
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
                    DefaultPaywallPreviewsKt.DefaultPaywallPreview(previewAppIcon, paywallWarning, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallPurpleOrangePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(361581643);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallPurpleOrangePreview)76@2770L105:DefaultPaywallPreviews.kt#trihdm");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(361581643, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPurpleOrangePreview (DefaultPaywallPreviews.kt:75)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getPurpleOrange(), null, composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallPurpleOrangePreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallPurpleOrangePreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallRedGreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-848283725);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallRedGreenPreview)48@1980L101:DefaultPaywallPreviews.kt#trihdm");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-848283725, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallRedGreenPreview (DefaultPaywallPreviews.kt:47)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getRedGreen(), null, composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallRedGreenPreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallRedGreenPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallWarningLocalizationPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-197693384);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallWarningLocalizationPreview)90@3197L131:DefaultPaywallPreviews.kt#trihdm");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-197693384, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallWarningLocalizationPreview (DefaultPaywallPreviews.kt:89)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getRedGreen(), PaywallWarning.MissingLocalization.INSTANCE, composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallWarningLocalizationPreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallWarningLocalizationPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DefaultPaywallWarningNoPaywallPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-684325386);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultPaywallWarningNoPaywallPreview)104@3643L132:DefaultPaywallPreviews.kt#trihdm");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-684325386, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallWarningNoPaywallPreview (DefaultPaywallPreviews.kt:103)");
            }
            DefaultPaywallPreview(DualColorImageGenerator.INSTANCE.getPurpleOrange(), new PaywallWarning.NoPaywall("WAT"), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewsKt.DefaultPaywallWarningNoPaywallPreview.1
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
                    DefaultPaywallPreviewsKt.DefaultPaywallWarningNoPaywallPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
