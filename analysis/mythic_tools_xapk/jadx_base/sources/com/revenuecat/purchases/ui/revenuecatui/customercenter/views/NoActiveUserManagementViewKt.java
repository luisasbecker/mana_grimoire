package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
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
import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonConfig;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonStyle;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import com.revenuecat.purchases.ui.revenuecatui.icons.InfoKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: NoActiveUserManagementView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010\u0007\u001aa\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017H\u0001¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001b¨\u0006\u001d"}, d2 = {"ContentUnavailableView", "", Constants.GP_IAP_TITLE, "", "description", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NoActiveUserManagementView", AndroidContextPlugin.SCREEN_KEY, "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "contactEmail", "appearance", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "supportTickets", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;", "offering", "Lcom/revenuecat/purchases/Offering;", "virtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "onAction", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/actions/CustomerCenterAction;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;Ljava/lang/String;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "NoActiveUserManagementView_Preview", "(Landroidx/compose/runtime/Composer;I)V", "NoActiveUserManagementView_WithVCs_Preview", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NoActiveUserManagementViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContentUnavailableView(final String str, final String str2, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1625781673);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContentUnavailableView)P(2)115@5401L11,116@5481L11,117@5510L1262,112@5247L1525:NoActiveUserManagementView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1625781673, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ContentUnavailableView (NoActiveUserManagementView.kt:111)");
                }
                SurfaceKt.m4145SurfaceT9BRK9s(companion, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM()), ColorSchemeKt.m3492surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), Dp.m9114constructorimpl(2.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-805166926, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.ContentUnavailableView.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C118@5520L1246:NoActiveUserManagementView.kt#870w7w");
                        if ((i5 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-805166926, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ContentUnavailableView.<anonymous> (NoActiveUserManagementView.kt:118)");
                        }
                        Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), CustomerCenterUIConstants.INSTANCE.m10704getContentUnavailableViewPaddingHorizontalD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10706getContentUnavailableViewPaddingVerticalD9Ej5fM());
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        String str3 = str;
                        String str4 = str2;
                        ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2038paddingVpY3zN4);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1517535808, "C130@5991L11,127@5869L228,136@6185L10,137@6247L11,134@6111L258:NoActiveUserManagementView.kt#870w7w");
                        IconKt.m3736Iconww6aTOc(InfoKt.getInfo(), (String) null, SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, CustomerCenterUIConstants.INSTANCE.m10703getContentUnavailableIconSizeD9Ej5fM()), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), composer2, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                        TextStyle titleMedium = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleMedium();
                        TextKt.m4286Text4IGK_g(str3, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, CustomerCenterUIConstants.INSTANCE.m10705getContentUnavailableViewPaddingTextD9Ej5fM(), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, titleMedium, composer2, 48, 0, 65528);
                        composer2.startReplaceGroup(-1018767756);
                        ComposerKt.sourceInformation(composer2, "*144@6497L10,145@6562L11,142@6418L324");
                        if (str4 != null) {
                            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium();
                            TextKt.m4286Text4IGK_g(str4, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, CustomerCenterUIConstants.INSTANCE.m10705getContentUnavailableViewPaddingTextD9Ej5fM(), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, bodyMedium, composer2, 48, 0, 65016);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 12582912, 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.ContentUnavailableView.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        NoActiveUserManagementViewKt.ContentUnavailableView(str, str2, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            SurfaceKt.m4145SurfaceT9BRK9s(companion, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM()), ColorSchemeKt.m3492surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), Dp.m9114constructorimpl(2.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-805166926, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.ContentUnavailableView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposerKt.sourceInformation(composer2, "C118@5520L1246:NoActiveUserManagementView.kt#870w7w");
                    if ((i5 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-805166926, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ContentUnavailableView.<anonymous> (NoActiveUserManagementView.kt:118)");
                    }
                    Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), CustomerCenterUIConstants.INSTANCE.m10704getContentUnavailableViewPaddingHorizontalD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10706getContentUnavailableViewPaddingVerticalD9Ej5fM());
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    String str3 = str;
                    String str4 = str2;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2038paddingVpY3zN4);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1517535808, "C130@5991L11,127@5869L228,136@6185L10,137@6247L11,134@6111L258:NoActiveUserManagementView.kt#870w7w");
                    IconKt.m3736Iconww6aTOc(InfoKt.getInfo(), (String) null, SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, CustomerCenterUIConstants.INSTANCE.m10703getContentUnavailableIconSizeD9Ej5fM()), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), composer2, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                    TextStyle titleMedium = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getTitleMedium();
                    TextKt.m4286Text4IGK_g(str3, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, CustomerCenterUIConstants.INSTANCE.m10705getContentUnavailableViewPaddingTextD9Ej5fM(), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, titleMedium, composer2, 48, 0, 65528);
                    composer2.startReplaceGroup(-1018767756);
                    ComposerKt.sourceInformation(composer2, "*144@6497L10,145@6562L11,142@6418L324");
                    if (str4 != null) {
                        TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium();
                        TextKt.m4286Text4IGK_g(str4, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, CustomerCenterUIConstants.INSTANCE.m10705getContentUnavailableViewPaddingTextD9Ej5fM(), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, bodyMedium, composer2, 48, 0, 65016);
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 12582912, 112);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = companion;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NoActiveUserManagementView(final CustomerCenterConfigData.Screen screen, final String str, final CustomerCenterConfigData.Appearance appearance, final CustomerCenterConfigData.Localization localization, final CustomerCenterConfigData.Support.SupportTickets supportTickets, final Offering offering, VirtualCurrencies virtualCurrencies, final Function1<? super CustomerCenterAction, Unit> onAction, Composer composer, final int i, final int i2) {
        int i3;
        String str2;
        VirtualCurrencies virtualCurrencies2;
        int i4;
        int currentCompositeKeyHash;
        VirtualCurrencies virtualCurrencies3;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z;
        boolean z2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(supportTickets, "supportTickets");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(303819697);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoActiveUserManagementView)P(5,1!2,6!1,7)52@3050L2057:NoActiveUserManagementView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(screen) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            str2 = str;
        } else {
            str2 = str;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(appearance) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(supportTickets) ? 16384 : 8192;
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(offering) ? 131072 : 65536;
        }
        int i5 = i2 & 64;
        if (i5 == 0) {
            if ((1572864 & i) == 0) {
                virtualCurrencies2 = virtualCurrencies;
                i3 |= composerStartRestartGroup.changedInstance(virtualCurrencies2) ? 1048576 : 524288;
            }
            if ((i2 & 128) == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(onAction) ? 8388608 : 4194304;
            }
            i4 = i3;
            if ((4793491 & i4) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    virtualCurrencies2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(303819697, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementView (NoActiveUserManagementView.kt:51)");
                }
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                virtualCurrencies3 = virtualCurrencies2;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1863057254, "C53@3119L333,94@4704L397:NoActiveUserManagementView.kt#870w7w");
                ContentUnavailableView(screen.getTitle(), screen.getSubtitle(), PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), 0.0f, 8, null), composerStartRestartGroup, 0, 0);
                composerStartRestartGroup.startReplaceGroup(-1999749722);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*66@3585L46,65@3543L511");
                if (offering != null) {
                    z = false;
                } else {
                    String strResolveButtonText = ScreenOfferingExtensionsKt.resolveButtonText(screen, localization);
                    SettingsButtonStyle settingsButtonStyle = SettingsButtonStyle.FILLED;
                    Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), 0.0f, 8, null);
                    z = false;
                    SettingsButtonConfig settingsButtonConfig = new SettingsButtonConfig(false, false, 3, null);
                    composerStartRestartGroup.startReplaceGroup(-1739883336);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):NoActiveUserManagementView.kt#9igjgp");
                    boolean z3 = (29360128 & i4) == 8388608;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt$NoActiveUserManagementView$1$1$1$1
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
                                onAction.invoke(CustomerCenterAction.ShowPaywall.INSTANCE);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    SettingsButtonKt.SettingsButton(strResolveButtonText, (Function0) objRememberedValue, settingsButtonConfig, modifierM2041paddingqDBjuR0$default, settingsButtonStyle, composerStartRestartGroup, 24576, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1999731484);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (virtualCurrencies3 != null) {
                    z2 = z;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1999730936);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@4169L501");
                    if (virtualCurrencies3.getAll().isEmpty()) {
                        z2 = z;
                    } else {
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        int i6 = i4 >> 3;
                        z2 = z;
                        VirtualCurrenciesListViewKt.VirtualCurrenciesListView(virtualCurrencies3, appearance, localization, onAction, PaddingKt.m2041paddingqDBjuR0$default(companion2, CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), 0.0f, 8, null), composerStartRestartGroup, ((i4 >> 18) & 14) | (i6 & 112) | (i6 & 896) | ((i4 >> 12) & 7168), 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                List<CustomerCenterConfigData.HelpPath> paths = screen.getPaths();
                boolean z4 = (supportTickets.getAllowCreation() || !supportTickets.allowsNonActiveCustomers()) ? z2 : true;
                int i7 = i4 >> 3;
                boolean z5 = z4;
                ManageSubscriptionsButtonsViewKt.ManageSubscriptionsButtonsView(null, paths, localization, str2, true, z5, onAction, composerStartRestartGroup, (i7 & 3670016) | (i7 & 896) | 24582 | ((i4 << 6) & 7168), 0);
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
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                virtualCurrencies3 = virtualCurrencies2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final VirtualCurrencies virtualCurrencies4 = virtualCurrencies3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView.2
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

                    public final void invoke(Composer composer2, int i8) {
                        NoActiveUserManagementViewKt.NoActiveUserManagementView(screen, str, appearance, localization, supportTickets, offering, virtualCurrencies4, onAction, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 1572864;
        virtualCurrencies2 = virtualCurrencies;
        if ((i2 & 128) == 0) {
        }
        i4 = i3;
        if ((4793491 & i4) == 4793490) {
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            virtualCurrencies3 = virtualCurrencies2;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1863057254, "C53@3119L333,94@4704L397:NoActiveUserManagementView.kt#870w7w");
                ContentUnavailableView(screen.getTitle(), screen.getSubtitle(), PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), 0.0f, 8, null), composerStartRestartGroup, 0, 0);
                composerStartRestartGroup.startReplaceGroup(-1999749722);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*66@3585L46,65@3543L511");
                if (offering != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1999731484);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (virtualCurrencies3 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                List<CustomerCenterConfigData.HelpPath> paths2 = screen.getPaths();
                if (supportTickets.getAllowCreation()) {
                    int i72 = i4 >> 3;
                    boolean z52 = z4;
                    ManageSubscriptionsButtonsViewKt.ManageSubscriptionsButtonsView(null, paths2, localization, str2, true, z52, onAction, composerStartRestartGroup, (i72 & 3670016) | (i72 & 896) | 24582 | ((i4 << 6) & 7168), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NoActiveUserManagementView_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(109169625);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoActiveUserManagementView_Preview)161@7220L610,161@7193L637:NoActiveUserManagementView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(109169625, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementView_Preview (NoActiveUserManagementView.kt:157)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(403847802, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView_Preview.1
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
                    ComposerKt.sourceInformation(composer2, "C165@7340L11,162@7230L594:NoActiveUserManagementView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(403847802, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementView_Preview.<anonymous> (NoActiveUserManagementView.kt:162)");
                    }
                    Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1483backgroundbw27NRU$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 481668263, "C167@7389L425:NoActiveUserManagementView.kt#870w7w");
                    NoActiveUserManagementViewKt.NoActiveUserManagementView(screen3, "support@example.com", CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), null, null, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt$NoActiveUserManagementView_Preview$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, composer2, 12779568, 64);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView_Preview.2
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
                    NoActiveUserManagementViewKt.NoActiveUserManagementView_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NoActiveUserManagementView_WithVCs_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1469396296);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoActiveUserManagementView_WithVCs_Preview)193@8431L698,193@8404L725:NoActiveUserManagementView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1469396296, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementView_WithVCs_Preview (NoActiveUserManagementView.kt:189)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(-793311143, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView_WithVCs_Preview.1
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
                    ComposerKt.sourceInformation(composer2, "C197@8551L11,194@8441L682:NoActiveUserManagementView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-793311143, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementView_WithVCs_Preview.<anonymous> (NoActiveUserManagementView.kt:194)");
                    }
                    Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getBackground(), null, 2, null);
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1483backgroundbw27NRU$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1655315250, "C199@8600L513:NoActiveUserManagementView.kt#870w7w");
                    NoActiveUserManagementViewKt.NoActiveUserManagementView(screen3, "support@example.com", CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), null, CustomerCenterConfigTestData.INSTANCE.getFiveVirtualCurrencies(), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt$NoActiveUserManagementView_WithVCs_Preview$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, composer2, 12779568, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView_WithVCs_Preview.2
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
                    NoActiveUserManagementViewKt.NoActiveUserManagementView_WithVCs_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
