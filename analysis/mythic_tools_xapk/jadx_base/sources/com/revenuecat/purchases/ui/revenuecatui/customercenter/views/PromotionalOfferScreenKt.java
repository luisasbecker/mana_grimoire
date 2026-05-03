package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.ui.revenuecatui.composables.AppIconKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigDataExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PromotionalOfferData;
import com.revenuecat.purchases.ui.revenuecatui.utils.PreviewDataCreatorsKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: PromotionalOfferScreen.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"PromotionalOfferScreen", "", "promotionalOfferData", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PromotionalOfferData;", "appearance", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "onAccept", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PromotionalOfferData;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PromotionalOfferViewPreview", "(Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class PromotionalOfferScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0331  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void PromotionalOfferScreen(final PromotionalOfferData promotionalOfferData, final CustomerCenterConfigData.Appearance appearance, final CustomerCenterConfigData.Localization localization, final Function1 onAccept, final Function0 onDismiss, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean z;
        Object objRememberedValue2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(promotionalOfferData, "promotionalOfferData");
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(onAccept, "onAccept");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-828652641);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PromotionalOfferScreen)P(5!2,3,4)41@1865L21,46@2147L2033:PromotionalOfferScreen.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(promotionalOfferData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(appearance) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onAccept) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDismiss) ? 16384 : 8192;
        }
        int i4 = i2 & 32;
        if (i4 == 0) {
            if ((196608 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-828652641, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreen (PromotionalOfferScreen.kt:40)");
                }
                boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                Color colorForTheme = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zIsSystemInDarkTheme, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$textColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getTextColor();
                    }
                });
                Color colorForTheme2 = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zIsSystemInDarkTheme, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$buttonBackgroundColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getButtonBackgroundColor();
                    }
                });
                Color colorForTheme3 = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zIsSystemInDarkTheme, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$buttonTextColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getButtonTextColor();
                    }
                });
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m9114constructorimpl(24.0f), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2039paddingVpY3zN4$default);
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
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526395454, "C52@2328L135,60@2587L10,58@2473L276,66@2875L10,64@2758L275,71@3043L38,74@3121L81,80@3346L207,84@3565L168,73@3091L642,92@3777L15,96@3910L264,91@3743L431:PromotionalOfferScreen.kt#870w7w");
                AppIconKt.AppIcon(SizeKt.m2083size3ABfNKs(PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(48.0f), 0.0f, Dp.m9114constructorimpl(16.0f), 5, null), Dp.m9114constructorimpl(100.0f)), composerStartRestartGroup, 6, 0);
                String title = promotionalOfferData.getConfiguredPromotionalOffer().getTitle();
                TextStyle headlineLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineLarge();
                composerStartRestartGroup.startReplaceGroup(-432614530);
                ComposerKt.sourceInformation(composerStartRestartGroup, "61@2660L11");
                long onBackground = colorForTheme != null ? MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground() : colorForTheme.m6335unboximpl();
                composerStartRestartGroup.endReplaceGroup();
                int i5 = i3;
                Modifier modifier4 = companion;
                TextKt.m4286Text4IGK_g(title, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(16.0f), 0.0f, 0.0f, 13, null), onBackground, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, headlineLarge, composerStartRestartGroup, 48, 0, 65528);
                String subtitle = promotionalOfferData.getConfiguredPromotionalOffer().getSubtitle();
                TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                composerStartRestartGroup.startReplaceGroup(-432605442);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@2944L11");
                long onBackground2 = colorForTheme != null ? MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground() : colorForTheme.m6335unboximpl();
                composerStartRestartGroup.endReplaceGroup();
                TextKt.m4286Text4IGK_g(subtitle, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(16.0f), 0.0f, 0.0f, 13, null), onBackground2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, bodyLarge, composerStartRestartGroup, 48, 0, 65528);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceGroup(-432598884);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PromotionalOfferScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(promotionalOfferData) | ((i5 & 7168) != 2048);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$1$1$1
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
                            onAccept.invoke(promotionalOfferData.getSubscriptionOption());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(16.0f), 7, null);
                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                composerStartRestartGroup.startReplaceGroup(-432590203);
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@3432L11");
                long primary = colorForTheme2 != null ? MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary() : colorForTheme2.m6335unboximpl();
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-432587295);
                ComposerKt.sourceInformation(composerStartRestartGroup, "82@3517L11");
                long onPrimary = colorForTheme3 != null ? MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimary() : colorForTheme3.m6335unboximpl();
                composerStartRestartGroup.endReplaceGroup();
                ButtonKt.Button(function0, modifierM2041paddingqDBjuR0$default, false, null, buttonDefaults.m3340buttonColorsro_MJ88(primary, onPrimary, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(71715577, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$1$2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                        invoke(rowScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope Button, Composer composer3, int i6) {
                        Intrinsics.checkNotNullParameter(Button, "$this$Button");
                        ComposerKt.sourceInformation(composer3, "C85@3579L144:PromotionalOfferScreen.kt#870w7w");
                        if ((i6 & 17) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(71715577, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreen.<anonymous>.<anonymous> (PromotionalOfferScreen.kt:85)");
                        }
                        TextKt.m4286Text4IGK_g(promotionalOfferData.getLocalizedPricingPhasesDescription(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 130558);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, Videoio.CAP_PROP_XI_CC_MATRIX_31);
                composerStartRestartGroup.startReplaceGroup(-432577958);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PromotionalOfferScreen.kt#9igjgp");
                z = (57344 & i5) != 16384;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$1$3$1
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
                            onDismiss.invoke();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                ButtonKt.TextButton((Function0) objRememberedValue2, PaddingKt.m2041paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(16.0f), 7, null), false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-257431476, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$1$4
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                        invoke(rowScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope TextButton, Composer composer3, int i6) {
                        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                        ComposerKt.sourceInformation(composer3, "C97@3924L240:PromotionalOfferScreen.kt#870w7w");
                        if ((i6 & 17) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-257431476, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreen.<anonymous>.<anonymous> (PromotionalOfferScreen.kt:97)");
                        }
                        TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.NO_THANKS), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 130558);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt.PromotionalOfferScreen.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        PromotionalOfferScreenKt.PromotionalOfferScreen(promotionalOfferData, appearance, localization, onAccept, onDismiss, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        if ((74899 & i3) == 74898) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            boolean zIsSystemInDarkTheme2 = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
            Color colorForTheme4 = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zIsSystemInDarkTheme2, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$textColor$1
                @Override // kotlin.jvm.functions.Function1
                public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getTextColor();
                }
            });
            Color colorForTheme22 = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zIsSystemInDarkTheme2, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$buttonBackgroundColor$1
                @Override // kotlin.jvm.functions.Function1
                public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getButtonBackgroundColor();
                }
            });
            Color colorForTheme32 = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zIsSystemInDarkTheme2, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$buttonTextColor$1
                @Override // kotlin.jvm.functions.Function1
                public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getButtonTextColor();
                }
            });
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierM2039paddingVpY3zN4$default2 = PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m9114constructorimpl(24.0f), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2039paddingVpY3zN4$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526395454, "C52@2328L135,60@2587L10,58@2473L276,66@2875L10,64@2758L275,71@3043L38,74@3121L81,80@3346L207,84@3565L168,73@3091L642,92@3777L15,96@3910L264,91@3743L431:PromotionalOfferScreen.kt#870w7w");
                AppIconKt.AppIcon(SizeKt.m2083size3ABfNKs(PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(48.0f), 0.0f, Dp.m9114constructorimpl(16.0f), 5, null), Dp.m9114constructorimpl(100.0f)), composerStartRestartGroup, 6, 0);
                String title2 = promotionalOfferData.getConfiguredPromotionalOffer().getTitle();
                TextStyle headlineLarge2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineLarge();
                composerStartRestartGroup.startReplaceGroup(-432614530);
                ComposerKt.sourceInformation(composerStartRestartGroup, "61@2660L11");
                if (colorForTheme4 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                int i52 = i3;
                Modifier modifier42 = companion;
                TextKt.m4286Text4IGK_g(title2, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(16.0f), 0.0f, 0.0f, 13, null), onBackground, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, headlineLarge2, composerStartRestartGroup, 48, 0, 65528);
                String subtitle2 = promotionalOfferData.getConfiguredPromotionalOffer().getSubtitle();
                TextStyle bodyLarge2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                composerStartRestartGroup.startReplaceGroup(-432605442);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@2944L11");
                if (colorForTheme4 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                TextKt.m4286Text4IGK_g(subtitle2, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(16.0f), 0.0f, 0.0f, 13, null), onBackground2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, bodyLarge2, composerStartRestartGroup, 48, 0, 65528);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceGroup(-432598884);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PromotionalOfferScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(promotionalOfferData) | ((i52 & 7168) != 2048);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$1$1$1
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
                            onAccept.invoke(promotionalOfferData.getSubscriptionOption());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    Function0 function02 = (Function0) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(16.0f), 7, null);
                    ButtonDefaults buttonDefaults2 = ButtonDefaults.INSTANCE;
                    composerStartRestartGroup.startReplaceGroup(-432590203);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@3432L11");
                    if (colorForTheme22 != null) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-432587295);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "82@3517L11");
                    if (colorForTheme32 != null) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ButtonKt.Button(function02, modifierM2041paddingqDBjuR0$default2, false, null, buttonDefaults2.m3340buttonColorsro_MJ88(primary, onPrimary, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(71715577, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$1$2
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope Button, Composer composer3, int i6) {
                            Intrinsics.checkNotNullParameter(Button, "$this$Button");
                            ComposerKt.sourceInformation(composer3, "C85@3579L144:PromotionalOfferScreen.kt#870w7w");
                            if ((i6 & 17) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(71715577, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreen.<anonymous>.<anonymous> (PromotionalOfferScreen.kt:85)");
                            }
                            TextKt.m4286Text4IGK_g(promotionalOfferData.getLocalizedPricingPhasesDescription(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 130558);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, Videoio.CAP_PROP_XI_CC_MATRIX_31);
                    composerStartRestartGroup.startReplaceGroup(-432577958);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PromotionalOfferScreen.kt#9igjgp");
                    if ((57344 & i52) != 16384) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$1$3$1
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
                                onDismiss.invoke();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceGroup();
                        ButtonKt.TextButton((Function0) objRememberedValue2, PaddingKt.m2041paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(16.0f), 7, null), false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-257431476, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt$PromotionalOfferScreen$1$4
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                invoke(rowScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope TextButton, Composer composer3, int i6) {
                                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                ComposerKt.sourceInformation(composer3, "C97@3924L240:PromotionalOfferScreen.kt#870w7w");
                                if ((i6 & 17) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-257431476, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreen.<anonymous>.<anonymous> (PromotionalOfferScreen.kt:97)");
                                }
                                TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.NO_THANKS), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 130558);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                    }
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final void PromotionalOfferViewPreview(Composer composer, final int i) {
        List<CustomerCenterConfigData.HelpPath> paths;
        Composer composerStartRestartGroup = composer.startRestartGroup(-552832253);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PromotionalOfferViewPreview)127@4995L260:PromotionalOfferScreen.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-552832253, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferViewPreview (PromotionalOfferScreen.kt:109)");
            }
            CustomerCenterConfigData.Screen managementScreen = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getManagementScreen();
            if (managementScreen != null && (paths = managementScreen.getPaths()) != null) {
                for (CustomerCenterConfigData.HelpPath helpPath : paths) {
                    if (helpPath.getType() == CustomerCenterConfigData.HelpPath.PathType.REFUND_REQUEST) {
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            helpPath = null;
            Intrinsics.checkNotNull(helpPath);
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer = helpPath.getPromotionalOffer();
            Intrinsics.checkNotNull(promotionalOffer);
            PromotionalOfferScreen(new PromotionalOfferData(promotionalOffer, PreviewDataCreatorsKt.previewSubscriptionOption$default("rc-cancel-offer", "monthly", null, null, null, null, 60, null), new CustomerCenterConfigData.HelpPath("1", "Check for previous purchases", CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, (DefaultConstructorMarker) null), "1 month for $7.99, then $9.99/mth"), CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getAppearance(), CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new Function1<SubscriptionOption, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt.PromotionalOfferViewPreview.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SubscriptionOption subscriptionOption) {
                    invoke2(subscriptionOption);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SubscriptionOption it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt.PromotionalOfferViewPreview.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, null, composerStartRestartGroup, 27648, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt.PromotionalOfferViewPreview.3
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
                    PromotionalOfferScreenKt.PromotionalOfferViewPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
