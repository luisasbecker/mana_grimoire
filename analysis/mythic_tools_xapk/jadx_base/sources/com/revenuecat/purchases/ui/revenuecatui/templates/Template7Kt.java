package com.revenuecat.purchases.ui.revenuecatui.templates;

import android.net.Uri;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.InsetSpacersKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetailsKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconName;
import com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.AnimationsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Template7.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a=\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010$\u001a\u001d\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0003¢\u0006\u0002\u0010,\u001a\u0017\u0010-\u001a\u00020\u00162\b\u0010.\u001a\u0004\u0018\u00010/H\u0003¢\u0006\u0002\u00100\u001a\u001d\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\u00102\u001a\r\u00103\u001a\u00020\u0016H\u0003¢\u0006\u0002\u00104\u001a\r\u00105\u001a\u00020\u0016H\u0003¢\u0006\u0002\u00104\u001a\r\u00106\u001a\u00020\u0016H\u0003¢\u0006\u0002\u00104\u001a\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020+H\u0002\u001a)\u0010:\u001a\u00020\u0016*\u00020;2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010=\u001a1\u0010>\u001a\u00020\u0016*\u00020?2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010@\u001aK\u0010A\u001a\u00020\u0016*\u00020?2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\u0006\u0010*\u001a\u00020+2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00160DH\u0003¢\u0006\u0002\u0010E\u001aS\u0010F\u001a\u00020\u0016*\u00020?2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\u0006\u0010*\u001a\u00020+2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00160DH\u0003¢\u0006\u0002\u0010G\u001a!\u0010H\u001a\u00020\u0016*\u00020?2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0003¢\u0006\u0002\u0010I\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0018\u0010\u000b\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004\"\u0018\u0010\r\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004\"\u0018\u0010\u000f\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004\"\u0018\u0010\u0011\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004\"\u0018\u0010\u0013\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004¨\u0006J²\u0006\n\u0010K\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u008e\u0002"}, d2 = {"featureIcon", "Landroidx/compose/ui/graphics/Color;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "getFeatureIcon", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;)J", "selectedDiscountText", "getSelectedDiscountText", "selectedOutline", "getSelectedOutline", "tierSwitcherBackground", "getTierSwitcherBackground", "tierSwitcherBackgroundSelected", "getTierSwitcherBackgroundSelected", "tierSwitcherForeground", "getTierSwitcherForeground", "tierSwitcherForegroundSelected", "getTierSwitcherForegroundSelected", "unselectedDiscountText", "getUnselectedDiscountText", "unselectedOutline", "getUnselectedOutline", "AnimatedPackages", "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "packageSelectionVisible", "", "packages", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "colors", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;ZLjava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;II)V", "CheckmarkBox", "isSelected", "(ZLcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;I)V", "Feature", "feature", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "(Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;I)V", "Features", "selectedTier", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;Landroidx/compose/runtime/Composer;I)V", "HeaderImage", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Landroidx/compose/runtime/Composer;I)V", "Template7", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;I)V", "Template7PaywallFooterCondensedPreview", "(Landroidx/compose/runtime/Composer;I)V", "Template7PaywallFooterPreview", "Template7PaywallPreview", "selectedLocalizationForTier", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;", "tier", "DiscountBanner", "Landroidx/compose/foundation/layout/RowScope;", "packageInfo", "(Landroidx/compose/foundation/layout/RowScope;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;I)V", "SelectPackageButton", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;I)V", "Template7LandscapeContent", "tiers", "onSelectTierChange", "Lkotlin/Function1;", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Template7PortraitContent", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;ZLjava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Title", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release", "packageSelectorVisible"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Template7Kt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedPackages(final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, boolean z, final List<TemplateConfiguration.PackageInfo> list, final TemplateConfiguration.Colors colors, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1691421480);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedPackages)P(3,4,1,2)456@17022L1185:Template7.kt#mf3l5c");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(legacy) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(paywallViewModel) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(list) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changed(colors) ? 16384 : 8192;
            }
            if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                boolean z4 = i4 == 0 ? true : z2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1691421480, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages (Template7.kt:450)");
                }
                Alignment topStart = !PaywallStateKt.isInFullScreenMode(legacy) ? Alignment.INSTANCE.getTopStart() : Alignment.INSTANCE.getBottomCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 400017878, "C462@17421L115,457@17081L455,474@17811L390,469@17546L655:Template7.kt#mf3l5c");
                AnimatedVisibilityKt.AnimatedVisibility(!z4, (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(0, 200, null, 5, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(0, 200, null, 5, null), 0.0f, 2, null), "OfferDetailsVisibility", ComposableLambdaKt.rememberComposableLambda(-136603126, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$AnimatedPackages$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                        invoke(animatedVisibilityScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation(composer2, "C463@17435L91:Template7.kt#mf3l5c");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-136603126, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages.<anonymous>.<anonymous> (Template7.kt:463)");
                        }
                        OfferDetailsKt.OfferDetails(legacy, colors, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 224640, 2);
                boolean z5 = z4;
                AnimatedVisibilityKt.AnimatedVisibility(z5, (Modifier) null, EnterExitTransitionKt.expandVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null), EnterExitTransitionKt.shrinkVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null), "SelectPackagesVisibility", ComposableLambdaKt.rememberComposableLambda(469640179, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$AnimatedPackages$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                        invoke(animatedVisibilityScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation(composer2, "C475@17825L366:Template7.kt#mf3l5c");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(469640179, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages.<anonymous>.<anonymous> (Template7.kt:475)");
                        }
                        Arrangement.Vertical verticalM1909spacedByD5KLDUw = Arrangement.INSTANCE.m1909spacedByD5KLDUw(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterVertically());
                        List<TemplateConfiguration.PackageInfo> list2 = list;
                        PaywallState.Loaded.Legacy legacy2 = legacy;
                        PaywallViewModel paywallViewModel2 = paywallViewModel;
                        TemplateConfiguration.Colors colors2 = colors;
                        ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM1909spacedByD5KLDUw, Alignment.INSTANCE.getStart(), composer2, 0);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1106044298, "C:Template7.kt#mf3l5c");
                        composer2.startReplaceGroup(1488342084);
                        ComposerKt.sourceInformation(composer2, "*482@18101L58");
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            Template7Kt.SelectPackageButton(columnScopeInstance, legacy2, (TemplateConfiguration.PackageInfo) it.next(), paywallViewModel2, colors2, composer2, 6);
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
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 224640, 2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.AnimatedPackages.2
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
                        Template7Kt.AnimatedPackages(legacy, paywallViewModel, z3, list, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        z2 = z;
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i3 & 9363) == 9362) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!PaywallStateKt.isInFullScreenMode(legacy)) {
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 400017878, "C462@17421L115,457@17081L455,474@17811L390,469@17546L655:Template7.kt#mf3l5c");
                AnimatedVisibilityKt.AnimatedVisibility(!z4, (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(0, 200, null, 5, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(0, 200, null, 5, null), 0.0f, 2, null), "OfferDetailsVisibility", ComposableLambdaKt.rememberComposableLambda(-136603126, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$AnimatedPackages$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                        invoke(animatedVisibilityScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation(composer2, "C463@17435L91:Template7.kt#mf3l5c");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-136603126, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages.<anonymous>.<anonymous> (Template7.kt:463)");
                        }
                        OfferDetailsKt.OfferDetails(legacy, colors, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 224640, 2);
                boolean z52 = z4;
                AnimatedVisibilityKt.AnimatedVisibility(z52, (Modifier) null, EnterExitTransitionKt.expandVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null), EnterExitTransitionKt.shrinkVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null), "SelectPackagesVisibility", ComposableLambdaKt.rememberComposableLambda(469640179, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$AnimatedPackages$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                        invoke(animatedVisibilityScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation(composer2, "C475@17825L366:Template7.kt#mf3l5c");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(469640179, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages.<anonymous>.<anonymous> (Template7.kt:475)");
                        }
                        Arrangement.Vertical verticalM1909spacedByD5KLDUw = Arrangement.INSTANCE.m1909spacedByD5KLDUw(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterVertically());
                        List<TemplateConfiguration.PackageInfo> list2 = list;
                        PaywallState.Loaded.Legacy legacy2 = legacy;
                        PaywallViewModel paywallViewModel2 = paywallViewModel;
                        TemplateConfiguration.Colors colors2 = colors;
                        ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Modifier.Companion companion22 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM1909spacedByD5KLDUw, Alignment.INSTANCE.getStart(), composer2, 0);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composer2, companion22);
                        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor22);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier22, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1106044298, "C:Template7.kt#mf3l5c");
                        composer2.startReplaceGroup(1488342084);
                        ComposerKt.sourceInformation(composer2, "*482@18101L58");
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            Template7Kt.SelectPackageButton(columnScopeInstance, legacy2, (TemplateConfiguration.PackageInfo) it.next(), paywallViewModel2, colors2, composer2, 6);
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
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 224640, 2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                z3 = z52;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CheckmarkBox(final boolean z, final TemplateConfiguration.Colors colors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1250968455);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckmarkBox)P(1)565@21186L401:Template7.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(colors) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1250968455, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CheckmarkBox (Template7.kt:564)");
            }
            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Template7UIConstants.INSTANCE.m10880getCheckmarkSizeD9Ej5fM()), RoundedCornerShapeKt.getCircleShape()), z ? colors.m10776getBackground0d7_KjU() : getUnselectedOutline(colors), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1874325509, "C:Template7.kt#mf3l5c");
            composerStartRestartGroup.startReplaceGroup(1030293438);
            ComposerKt.sourceInformation(composerStartRestartGroup, "572@21440L131");
            if (z) {
                PaywallIconKt.m10655PaywallIconFNF3uiM(PaywallIconName.CHECK_CIRCLE, null, getSelectedOutline(colors), composerStartRestartGroup, 6, 2);
            }
            composerStartRestartGroup.endReplaceGroup();
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.CheckmarkBox.2
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
                    Template7Kt.CheckmarkBox(z, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DiscountBanner(final RowScope rowScope, final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.PackageInfo packageInfo, final TemplateConfiguration.Colors colors, Composer composer, final int i) {
        int i2;
        PaywallState.Loaded.Legacy legacy2;
        TemplateConfiguration.PackageInfo packageInfo2;
        TemplateConfiguration.Colors colors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(148348005);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DiscountBanner)P(2,1)592@21932L169,597@22134L179,603@22319L744:Template7.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            legacy2 = legacy;
            i2 |= composerStartRestartGroup.changed(legacy2) ? 32 : 16;
        } else {
            legacy2 = legacy;
        }
        if ((i & 384) == 0) {
            packageInfo2 = packageInfo;
            i2 |= composerStartRestartGroup.changed(packageInfo2) ? 256 : 128;
        } else {
            packageInfo2 = packageInfo;
        }
        if ((i & 3072) == 0) {
            colors2 = colors;
            i2 |= composerStartRestartGroup.changed(colors2) ? 2048 : 1024;
        } else {
            colors2 = colors;
        }
        if ((i2 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(148348005, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.DiscountBanner (Template7.kt:585)");
            }
            String offerBadge = packageInfo2.getLocalization().getOfferBadge();
            if (offerBadge != null) {
                String upperCase = offerBadge.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (upperCase != null) {
                    if (StringsKt.isBlank(upperCase)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final PaywallState.Loaded.Legacy legacy3 = legacy2;
                            final TemplateConfiguration.PackageInfo packageInfo3 = packageInfo2;
                            final TemplateConfiguration.Colors colors3 = colors2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.DiscountBanner.1
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
                                    Template7Kt.DiscountBanner(rowScope, legacy3, packageInfo3, colors3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                                }
                            });
                            return;
                        }
                        return;
                    }
                    int i3 = (i2 >> 3) & 126;
                    long jM10841packageButtonColorAnimation9z6LAg8 = AnimationsKt.m10841packageButtonColorAnimation9z6LAg8(legacy, packageInfo, getSelectedOutline(colors), getUnselectedOutline(colors), composerStartRestartGroup, i3);
                    long jM10841packageButtonColorAnimation9z6LAg82 = AnimationsKt.m10841packageButtonColorAnimation9z6LAg8(legacy, packageInfo, getSelectedDiscountText(colors), getUnselectedDiscountText(colors), composerStartRestartGroup, i3);
                    Modifier modifierM1996offsetVpY3zN4 = OffsetKt.m1996offsetVpY3zN4(rowScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getTop()), Dp.m9114constructorimpl(UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM() - Template7UIConstants.INSTANCE.m10881getDiscountPaddingD9Ej5fM()), Dp.m9114constructorimpl(Dp.m9114constructorimpl(-UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM()) + Template7UIConstants.INSTANCE.m10881getDiscountPaddingD9Ej5fM()));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1996offsetVpY3zN4);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1197627213, "C613@22731L5,611@22629L428:Template7.kt#mf3l5c");
                    Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(PaddingKt.m2039paddingVpY3zN4$default(BackgroundKt.m1482backgroundbw27NRU(Modifier.INSTANCE, jM10841packageButtonColorAnimation9z6LAg8, ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, ButtonDefaults.$stable)), 0.0f, Dp.m9114constructorimpl(4.0f), 1, null), Dp.m9114constructorimpl(8.0f), 0.0f, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2039paddingVpY3zN4$default);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1029512404, "C620@22963L10,617@22849L198:Template7.kt#mf3l5c");
                    TextKt.m4286Text4IGK_g(upperCase, (Modifier) null, jM10841packageButtonColorAnimation9z6LAg82, 0L, (FontStyle) null, FontWeight.INSTANCE.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup2 != null) {
                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$DiscountBanner$text$1
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
                        Template7Kt.DiscountBanner(rowScope, legacy, packageInfo, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                    }
                });
                return;
            }
            return;
        }
        composerStartRestartGroup.skipToGroupEnd();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup3 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup3 != null) {
            scopeUpdateScopeEndRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.DiscountBanner.3
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
                    Template7Kt.DiscountBanner(rowScope, legacy, packageInfo, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Feature(final PaywallData.LocalizedConfiguration.Feature feature, final TemplateConfiguration.Colors colors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-840416555);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Feature)P(1)395@15074L1536:Template7.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(feature) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(colors) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-840416555, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Feature (Template7.kt:394)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierSemantics = SemanticsModifierKt.semantics(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Feature.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                }
            });
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 727566411, "C401@15259L400,415@15669L935:Template7.kt#mf3l5c");
            Modifier modifierM2083size3ABfNKs = SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Template7UIConstants.INSTANCE.m10882getFeatureIconSizeD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2083size3ABfNKs);
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
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1268528897, "C:Template7.kt#mf3l5c");
            String iconID = feature.getIconID();
            PaywallIconName paywallIconNameFromValue = iconID != null ? PaywallIconName.INSTANCE.fromValue(iconID) : null;
            composerStartRestartGroup.startReplaceGroup(-928908279);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*408@15504L127");
            if (paywallIconNameFromValue != null) {
                PaywallIconKt.m10655PaywallIconFNF3uiM(paywallIconNameFromValue, null, getFeatureIcon(colors), composerStartRestartGroup, 0, 2);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1268964695, "C420@15852L10,419@15804L343:Template7.kt#mf3l5c");
            MarkdownKt.m10642MarkdownDkhmgE0(feature.getTitle(), null, colors.m10781getText10d7_KjU(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, FontWeight.INSTANCE.getNormal(), null, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8997getStarte0LSkKk()), false, true, false, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 54, 722);
            composerStartRestartGroup = composerStartRestartGroup;
            String content = feature.getContent();
            composerStartRestartGroup.startReplaceGroup(-928885417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*430@16262L10,429@16210L370");
            if (content != null) {
                MarkdownKt.m10642MarkdownDkhmgE0(content, null, colors.m10782getText20d7_KjU(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), 0L, FontWeight.INSTANCE.getNormal(), null, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8997getStarte0LSkKk()), false, true, false, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 54, 722);
                composerStartRestartGroup = composerStartRestartGroup;
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Feature.3
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
                    Template7Kt.Feature(feature, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Features(final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.TierInfo tierInfo, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(571837189);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Features)P(1)365@14259L44,372@14471L459,369@14375L555:Template7.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(legacy) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(tierInfo) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(571837189, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Features (Template7.kt:364)");
            }
            final TemplateConfiguration.Colors currentColorsForTier = legacy.getTemplateConfiguration().getCurrentColorsForTier(tierInfo, composerStartRestartGroup, (i2 >> 3) & 14);
            AnimatedContentKt.AnimatedContent(selectedLocalizationForTier(tierInfo), null, null, null, "features portrait", null, ComposableLambdaKt.rememberComposableLambda(-1011395967, true, new Function4<AnimatedContentScope, ProcessedLocalizedConfiguration, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Features.1
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, ProcessedLocalizedConfiguration processedLocalizedConfiguration, Composer composer2, Integer num) {
                    invoke(animatedContentScope, processedLocalizedConfiguration, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedContentScope AnimatedContent, ProcessedLocalizedConfiguration it, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation(composer2, "C373@14481L443:Template7.kt#mf3l5c");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1011395967, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Features.<anonymous> (Template7.kt:373)");
                    }
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.Vertical verticalM1909spacedByD5KLDUw = Arrangement.INSTANCE.m1909spacedByD5KLDUw(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterVertically());
                    TemplateConfiguration.Colors colors = currentColorsForTier;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM1909spacedByD5KLDUw, centerHorizontally, composer2, 48);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -130348577, "C:Template7.kt#mf3l5c");
                    composer2.startReplaceGroup(965626904);
                    ComposerKt.sourceInformation(composer2, "*381@14792L108");
                    Iterator<T> it2 = it.getFeatures().iterator();
                    while (it2.hasNext()) {
                        Template7Kt.Feature((PaywallData.LocalizedConfiguration.Feature) it2.next(), colors, composer2, 0);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1597440, 46);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Features.2
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
                    Template7Kt.Features(legacy, tierInfo, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderImage(final Uri uri, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(108999699);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HeaderImage)*326@13036L218:Template7.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(uri) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(108999699, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.HeaderImage (Template7.kt:324)");
            }
            if (uri != null) {
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
                RemoteImageKt.RemoteImage(string, AspectRatioKt.aspectRatio$default(Modifier.INSTANCE, 2.0f, false, 2, null), null, ContentScale.INSTANCE.getCrop(), null, null, 0.0f, null, composerStartRestartGroup, 3120, 244);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.HeaderImage.2
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
                    Template7Kt.HeaderImage(uri, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectPackageButton(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.PackageInfo packageInfo, final PaywallViewModel paywallViewModel, final TemplateConfiguration.Colors colors, Composer composer, final int i) {
        int i2;
        PaywallState.Loaded.Legacy legacy2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-235261752);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectPackageButton)P(2,1,3)499@18567L47,501@18676L169,512@19006L53,516@19153L74,515@19079L40,526@19598L1482,507@18851L2229:Template7.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            legacy2 = legacy;
            i2 |= composerStartRestartGroup.changed(legacy2) ? 32 : 16;
        } else {
            legacy2 = legacy;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(packageInfo) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(colors) ? 16384 : 8192;
        }
        int i3 = i2;
        if ((i3 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-235261752, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton (Template7.kt:496)");
            }
            final boolean zAreEqual = Intrinsics.areEqual(packageInfo, legacy2.getSelectedPackage().getValue());
            float fPackageButtonActionInProgressOpacityAnimation = AnimationsKt.packageButtonActionInProgressOpacityAnimation(paywallViewModel, composerStartRestartGroup, (i3 >> 9) & 14);
            final long jM10781getText10d7_KjU = colors.m10781getText10d7_KjU();
            long jM10841packageButtonColorAnimation9z6LAg8 = AnimationsKt.m10841packageButtonColorAnimation9z6LAg8(legacy, packageInfo, getSelectedOutline(colors), getUnselectedOutline(colors), composerStartRestartGroup, (i3 >> 3) & 126);
            Modifier modifierAlign = columnScope.align(AlphaKt.alpha(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), fPackageButtonActionInProgressOpacityAnimation), Alignment.INSTANCE.getStart());
            composerStartRestartGroup.startReplaceGroup(1056049171);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(zAreEqual);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$SelectPackageButton$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setSelected(semantics, zAreEqual);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierAlign, false, (Function1) objRememberedValue, 1, null);
            ButtonColors buttonColorsM3340buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3340buttonColorsro_MJ88(Color.INSTANCE.m6360getTransparent0d7_KjU(), jM10781getText10d7_KjU, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 12);
            RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(UIConstant.INSTANCE.m10453getDefaultPackageCornerRadiusD9Ej5fM());
            PaddingValues paddingValuesM2031PaddingValuesYgX7TsA = PaddingKt.m2031PaddingValuesYgX7TsA(UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
            BorderStroke borderStrokeM1509BorderStrokecXLIe8U = BorderStrokeKt.m1509BorderStrokecXLIe8U(UIConstant.INSTANCE.m10452getDefaultPackageBorderWidthD9Ej5fM(), jM10841packageButtonColorAnimation9z6LAg8);
            composerStartRestartGroup.startReplaceGroup(1056051494);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
            boolean z = ((i3 & 7168) == 2048) | ((i3 & 896) == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$SelectPackageButton$2$1
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
                        paywallViewModel.selectPackage(packageInfo);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-731847976, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.SelectPackageButton.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope Button, Composer composer2, int i4) {
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    ComposerKt.sourceInformation(composer2, "C527@19608L1466:Template7.kt#mf3l5c");
                    if ((i4 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-731847976, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton.<anonymous> (Template7.kt:527)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(4.0f));
                    Alignment.Horizontal start = Alignment.INSTANCE.getStart();
                    TemplateConfiguration.PackageInfo packageInfo2 = packageInfo;
                    long j = jM10781getText10d7_KjU;
                    boolean z2 = zAreEqual;
                    TemplateConfiguration.Colors colors2 = colors;
                    PaywallState.Loaded.Legacy legacy3 = legacy;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, start, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -316227191, "C533@19818L724,556@20992L10,550@20556L508:Template7.kt#mf3l5c");
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_42 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(6.0f));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_42, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1739943300, "C534@19940L54,538@20200L10,535@20011L347,543@20376L152:Template7.kt#mf3l5c");
                    Template7Kt.CheckmarkBox(z2, colors2, composer2, 0);
                    String offerName = packageInfo2.getLocalization().getOfferName();
                    if (offerName == null) {
                        offerName = packageInfo2.getRcPackage().getProduct().getTitle();
                    }
                    TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge();
                    String str = offerName;
                    TextKt.m4286Text4IGK_g(str, rowScopeInstance.weight(Modifier.INSTANCE, 1.0f, true), j, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, bodyLarge, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65496);
                    Template7Kt.DiscountBanner(rowScopeInstance, legacy3, packageInfo2, colors2, composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    IntroEligibilityStateViewKt.m10633IntroEligibilityStateViewQETHhvg(packageInfo2.getLocalization().getOfferDetails(), packageInfo2.getLocalization().getOfferDetailsWithIntroOffer(), packageInfo2.getLocalization().getOfferDetailsWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(packageInfo2), j, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), null, null, false, null, composer2, 100663296, TypedValues.TransitionType.TYPE_AUTO_TRANSITION);
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
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup = composerStartRestartGroup;
            ButtonKt.Button((Function0) objRememberedValue2, modifierSemantics$default, false, roundedCornerShapeM2345RoundedCornerShape0680j_4, buttonColorsM3340buttonColorsro_MJ88, null, borderStrokeM1509BorderStrokecXLIe8U, paddingValuesM2031PaddingValuesYgX7TsA, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, 805306368, 292);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.SelectPackageButton.4
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
                    Template7Kt.SelectPackageButton(columnScope, legacy, packageInfo, paywallViewModel, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void Template7(final PaywallState.Loaded.Legacy state, PaywallViewModel paywallViewModel, Composer composer, final int i) {
        int i2;
        final PaywallState.Loaded.Legacy legacy;
        final PaywallViewModel viewModel = paywallViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-305592021);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template7)105@5233L105,109@5364L50,113@5467L44,115@5517L1047:Template7.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(viewModel) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            legacy = state;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-305592021, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7 (Template7.kt:95)");
            }
            TemplateConfiguration.PackageConfiguration packages = state.getTemplateConfiguration().getPackages();
            if (!(packages instanceof TemplateConfiguration.PackageConfiguration.MultiTier)) {
                throw new IllegalArgumentException("The configuration is not MultiTier".toString());
            }
            TemplateConfiguration.PackageConfiguration.MultiTier multiTier = (TemplateConfiguration.PackageConfiguration.MultiTier) packages;
            TemplateConfiguration.TierInfo defaultTier = multiTier.getDefaultTier();
            List<TemplateConfiguration.TierInfo> allTiers = multiTier.getAllTiers();
            composerStartRestartGroup.startReplaceGroup(-1567782808);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(state.getTemplateConfiguration().getMode() != PaywallMode.FOOTER_CONDENSED), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1567778671);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(defaultTier, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            TemplateConfiguration.Colors currentColorsForTier = state.getTemplateConfiguration().getCurrentColorsForTier(Template7$lambda$5(mutableState2), composerStartRestartGroup, 0);
            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(Modifier.INSTANCE, currentColorsForTier.m10776getBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 513305506, "C118@5605L26,141@6258L55,147@6495L52,143@6323L235:Template7.kt#mf3l5c");
            int i4 = i3 & 14;
            if (WindowHelperKt.shouldUseLandscapeLayout(state, composerStartRestartGroup, i4)) {
                composerStartRestartGroup.startReplaceGroup(513322183);
                ComposerKt.sourceInformation(composerStartRestartGroup, "124@5794L114,119@5647L261");
                TemplateConfiguration.TierInfo tierInfoTemplate7$lambda$5 = Template7$lambda$5(mutableState2);
                composerStartRestartGroup.startReplaceGroup(-1091814896);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
                boolean z = i4 == 4;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function1) new Function1<TemplateConfiguration.TierInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.TierInfo tierInfo) {
                            invoke2(tierInfo);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TemplateConfiguration.TierInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableState2.setValue(it);
                            state.selectPackage(Template7Kt.Template7$lambda$5(mutableState2).getDefaultPackage());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i5 = i3 << 3;
                Template7LandscapeContent(columnScopeInstance, state, viewModel, allTiers, tierInfoTemplate7$lambda$5, (Function1) objRememberedValue3, composerStartRestartGroup, (i5 & 896) | 6 | (i5 & 112));
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(513612064);
                ComposerKt.sourceInformation(composerStartRestartGroup, "135@6124L114,129@5938L300");
                boolean zTemplate7$lambda$2 = Template7$lambda$2(mutableState);
                TemplateConfiguration.TierInfo tierInfoTemplate7$lambda$52 = Template7$lambda$5(mutableState2);
                composerStartRestartGroup.startReplaceGroup(-1091804336);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
                boolean z2 = i4 == 4;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function1) new Function1<TemplateConfiguration.TierInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7$2$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.TierInfo tierInfo) {
                            invoke2(tierInfo);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TemplateConfiguration.TierInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableState2.setValue(it);
                            state.selectPackage(Template7Kt.Template7$lambda$5(mutableState2).getDefaultPackage());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i6 = i3 << 3;
                Template7PortraitContent(columnScopeInstance, state, paywallViewModel, zTemplate7$lambda$2, allTiers, tierInfoTemplate7$lambda$52, (Function1) objRememberedValue4, composerStartRestartGroup, 6 | (i6 & 112) | (i6 & 896));
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            int i7 = i3 & 112;
            PurchaseButtonKt.m10664PurchaseButtonhGBTI10(state, paywallViewModel, null, 0.0f, currentColorsForTier, composerStartRestartGroup, i3 & 126, 12);
            legacy = state;
            TemplateConfiguration templateConfiguration = legacy.getTemplateConfiguration();
            composerStartRestartGroup.startReplaceGroup(-1091792526);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7$2$3$1
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
                        Template7Kt.Template7$lambda$3(mutableState, !Template7Kt.Template7$lambda$2(r1));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceGroup();
            FooterKt.Footer(templateConfiguration, paywallViewModel, null, currentColorsForTier, (Function0) objRememberedValue5, composerStartRestartGroup, i7 | 24576, 4);
            viewModel = paywallViewModel;
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    Template7Kt.Template7(legacy, viewModel, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Template7$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TemplateConfiguration.TierInfo Template7$lambda$5(MutableState<TemplateConfiguration.TierInfo> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7LandscapeContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final List<TemplateConfiguration.TierInfo> list, final TemplateConfiguration.TierInfo tierInfo, final Function1<? super TemplateConfiguration.TierInfo, Unit> function1, Composer composer, final int i) {
        int i2;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(2027062712);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template7LandscapeContent)P(2,4,3,1)249@10224L21,250@10273L21,252@10347L44,254@10397L2563:Template7.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(legacy) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(tierInfo) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        if ((74899 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2027062712, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7LandscapeContent (Template7.kt:248)");
            }
            ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            ScrollState scrollStateRememberScrollState2 = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            TemplateConfiguration.Colors currentColorsForTier = legacy.getTemplateConfiguration().getCurrentColorsForTier(tierInfo, composerStartRestartGroup, (i2 >> 12) & 14);
            Arrangement.Horizontal spaceEvenly = Arrangement.Absolute.INSTANCE.getSpaceEvenly();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(PaddingKt.m2041paddingqDBjuR0$default(ColumnScope.weight$default(columnScope, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), 0.0f, 0.0f, 13, null), UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2039paddingVpY3zN4$default);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 791332821, "C262@10728L704,282@11442L1512:Template7.kt#mf3l5c");
            Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(RowScope.weight$default(rowScopeInstance, ScrollKt.verticalScroll$default(Modifier.INSTANCE, scrollStateRememberScrollState, false, null, false, 14, null), 1.0f, false, 2, null), UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.Vertical verticalM1909spacedByD5KLDUw = Arrangement.INSTANCE.m1909spacedByD5KLDUw(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM1909spacedByD5KLDUw, centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2038paddingVpY3zN4);
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
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -705450517, "C273@11233L46,275@11293L26,277@11333L46,279@11393L29:Template7.kt#mf3l5c");
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
            Title(columnScopeInstance, legacy, tierInfo, composerStartRestartGroup, (i2 & 112) | 6 | ((i2 >> 6) & 896));
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
            int i4 = i2 >> 3;
            int i5 = i2 >> 9;
            Features(legacy, tierInfo, composerStartRestartGroup, (i4 & 14) | (i5 & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM2038paddingVpY3zN42 = PaddingKt.m2038paddingVpY3zN4(RowScope.weight$default(rowScopeInstance, ScrollKt.verticalScroll$default(Modifier.INSTANCE, scrollStateRememberScrollState2, false, null, false, 14, null), 1.0f, false, 2, null), UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.Vertical verticalM1909spacedByD5KLDUw2 = Arrangement.INSTANCE.m1909spacedByD5KLDUw(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM1909spacedByD5KLDUw2, centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2038paddingVpY3zN42);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -704716220, "C293@11948L46,311@12694L190,318@12898L46:Template7.kt#mf3l5c");
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceGroup(392910811);
            ComposerKt.sourceInformation(composerStartRestartGroup, "299@12181L70,296@12046L556,308@12620L46");
            if (list.size() > 1) {
                composerStartRestartGroup.startReplaceGroup(392915745);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
                boolean z = (458752 & i2) == 131072;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<TemplateConfiguration.TierInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7LandscapeContent$1$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.TierInfo tierInfo2) {
                            invoke2(tierInfo2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TemplateConfiguration.TierInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function1.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                i3 = 0;
                TierSwitcherKt.m10679TierSwitcherUFBoNtE(list, tierInfo, (Function1) objRememberedValue, getTierSwitcherBackground(currentColorsForTier), getTierSwitcherBackgroundSelected(currentColorsForTier), getTierSwitcherForeground(currentColorsForTier), getTierSwitcherForegroundSelected(currentColorsForTier), composerStartRestartGroup, i5 & 126);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
            } else {
                i3 = 0;
            }
            composerStartRestartGroup.endReplaceGroup();
            AnimatedPackages(legacy, paywallViewModel, false, tierInfo.getPackages(), currentColorsForTier, composerStartRestartGroup, i4 & 126, 4);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, i3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7LandscapeContent.2
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
                    Template7Kt.Template7LandscapeContent(columnScope, legacy, paywallViewModel, list, tierInfo, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7PaywallFooterCondensedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(957146168);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template7PaywallFooterCondensedPreview)688@25638L204:Template7.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(957146168, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7PaywallFooterCondensedPreview (Template7.kt:687)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallFooterCondensedPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate7Offering(), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallFooterCondensedPreview.2
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
                    Template7Kt.Template7PaywallFooterCondensedPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7PaywallFooterPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-323823251);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template7PaywallFooterPreview)677@25166L194:Template7.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-323823251, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7PaywallFooterPreview (Template7.kt:676)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallFooterPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate7Offering(), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallFooterPreview.2
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
                    Template7Kt.Template7PaywallFooterPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7PaywallPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(292324402);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template7PaywallPreview)666@24736L167:Template7.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(292324402, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7PaywallPreview (Template7.kt:665)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate7Offering(), null, false, false, 29, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PaywallPreview.2
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
                    Template7Kt.Template7PaywallPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template7PortraitContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final boolean z, final List<TemplateConfiguration.TierInfo> list, TemplateConfiguration.TierInfo tierInfo, final Function1<? super TemplateConfiguration.TierInfo, Unit> function1, Composer composer, final int i) {
        int i2;
        List<TemplateConfiguration.TierInfo> list2;
        int i3;
        ColumnScopeInstance columnScopeInstance;
        TemplateConfiguration.TierInfo tierInfo2;
        Composer composer2;
        int i4;
        int i5;
        Object obj;
        Composer composer3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1979964246);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template7PortraitContent)P(3,5,1,4,2)167@7189L44,169@7257L21,172@7370L121,170@7283L2237,230@9526L340:Template7.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(legacy) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            list2 = list;
            i2 |= composerStartRestartGroup.changedInstance(list2) ? 16384 : 8192;
        } else {
            list2 = list;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(tierInfo) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((599187 & i2) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            tierInfo2 = tierInfo;
            composer3 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1979964246, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template7PortraitContent (Template7.kt:161)");
            }
            TemplateConfiguration.Images images = legacy.getTemplateConfiguration().getImagesByTier().get(tierInfo.getId());
            Uri headerUri = images != null ? images.getHeaderUri() : null;
            composerStartRestartGroup.startReplaceGroup(-1182000584);
            ComposerKt.sourceInformation(composerStartRestartGroup, "164@7108L22");
            if (PaywallStateKt.isInFullScreenMode(legacy) && headerUri != null) {
                HeaderImage(headerUri, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            int i6 = (i2 >> 15) & 14;
            TemplateConfiguration.Colors currentColorsForTier = legacy.getTemplateConfiguration().getCurrentColorsForTier(tierInfo, composerStartRestartGroup, i6);
            final ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean zIsInFullScreenMode = PaywallStateKt.isInFullScreenMode(legacy);
            composerStartRestartGroup.startReplaceGroup(-1181990216);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
            int i7 = i2 & 14;
            boolean zChanged = (i7 == 4) | composerStartRestartGroup.changed(scrollStateRememberScrollState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7PortraitContent$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Modifier invoke(Modifier conditional) {
                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                        return ColumnScope.weight$default(columnScope, ScrollKt.verticalScroll$default(Modifier.INSTANCE, scrollStateRememberScrollState, false, null, false, 14, null), 1.0f, false, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(ModifierExtensionsKt.conditional(companion, zIsInFullScreenMode, (Function1) objRememberedValue), UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.Vertical verticalM1909spacedByD5KLDUw = Arrangement.INSTANCE.m1909spacedByD5KLDUw(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM1909spacedByD5KLDUw, centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2038paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Uri uri = headerUri;
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -479588460, "C217@9190L233:Template7.kt#mf3l5c");
            composerStartRestartGroup.startReplaceGroup(-1539492651);
            ComposerKt.sourceInformation(composerStartRestartGroup, "188@8076L26");
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                composerStartRestartGroup.startReplaceGroup(-1539491336);
                ComposerKt.sourceInformation(composerStartRestartGroup, "186@7999L50");
                if (uri == null) {
                    composerStartRestartGroup.startReplaceGroup(-1539490146);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "184@7947L17");
                    i3 = 0;
                    if (!legacy.getShouldDisplayDismissButton()) {
                        InsetSpacersKt.StatusBarSpacer(composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, UIConstant.INSTANCE.m10455getIconButtonSizeD9Ej5fM()), composerStartRestartGroup, 0);
                } else {
                    i3 = 0;
                }
                composerStartRestartGroup.endReplaceGroup();
                Title(columnScopeInstance2, legacy, tierInfo, composerStartRestartGroup, 6 | (i2 & 112) | ((i2 >> 9) & 896));
            } else {
                i3 = 0;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1539481725);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            if (list2.size() <= 1) {
                columnScopeInstance = columnScopeInstance2;
                tierInfo2 = tierInfo;
                composer2 = composerStartRestartGroup;
                i4 = i2;
                i5 = i3;
                obj = null;
            } else if (z) {
                composerStartRestartGroup.startReplaceGroup(-479242408);
                ComposerKt.sourceInformation(composerStartRestartGroup, "196@8338L70,193@8203L556");
                composerStartRestartGroup.startReplaceGroup(-1539475708);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template7.kt#9igjgp");
                int i8 = (3670016 & i2) == 1048576 ? 1 : i3;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (i8 != 0 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function1) new Function1<TemplateConfiguration.TierInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt$Template7PortraitContent$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.TierInfo tierInfo3) {
                            invoke2(tierInfo3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TemplateConfiguration.TierInfo it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function1.invoke(it);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function12 = (Function1) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                int i9 = i2;
                int i10 = (i9 >> 12) & 126;
                columnScopeInstance = columnScopeInstance2;
                i4 = i9;
                i5 = i3;
                obj = null;
                TierSwitcherKt.m10679TierSwitcherUFBoNtE(list, tierInfo, function12, getTierSwitcherBackground(currentColorsForTier), getTierSwitcherBackgroundSelected(currentColorsForTier), getTierSwitcherForeground(currentColorsForTier), getTierSwitcherForegroundSelected(currentColorsForTier), composerStartRestartGroup, i10);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
                tierInfo2 = tierInfo;
            } else {
                columnScopeInstance = columnScopeInstance2;
                composer2 = composerStartRestartGroup;
                i4 = i2;
                i5 = i3;
                obj = null;
                composer2.startReplaceGroup(-478662150);
                ComposerKt.sourceInformation(composer2, "205@8797L266");
                TierSwitcherKt.m10678SelectedTierView1wkBAMs(tierInfo, getTierSwitcherBackgroundSelected(currentColorsForTier), getTierSwitcherForegroundSelected(currentColorsForTier), composer2, i6);
                tierInfo2 = tierInfo;
                composer2.endReplaceGroup();
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1539451407);
            ComposerKt.sourceInformation(composer2, "214@9141L29");
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                Features(legacy, tierInfo2, composer2, ((i4 >> 3) & 14) | ((i4 >> 12) & 112));
            }
            composer2.endReplaceGroup();
            Composer composer4 = composer2;
            Object obj2 = obj;
            AnimatedPackages(legacy, paywallViewModel, z, tierInfo2.getPackages(), currentColorsForTier, composer4, (i4 >> 3) & 1022, 0);
            composer4.startReplaceGroup(-1539440657);
            ComposerKt.sourceInformation(composer4, "226@9477L27");
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, i5);
            }
            composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, (Modifier) null, EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, obj2), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, obj2), "Template7.packageSpacing", ComposableSingletons$Template7Kt.INSTANCE.m10853getLambda1$revenuecatui_defaultsBc8Release(), composer4, i7 | 1769472 | ((i4 >> 6) & 112), 2);
            composer3 = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TemplateConfiguration.TierInfo tierInfo3 = tierInfo2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Template7PortraitContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                    invoke(composer5, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i11) {
                    Template7Kt.Template7PortraitContent(columnScope, legacy, paywallViewModel, z, list, tierInfo3, function1, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Title(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.TierInfo tierInfo, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1395216940);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Title)P(1)340@13451L44,344@13606L10,343@13566L351:Template7.kt#mf3l5c");
        if ((i & 48) == 0) {
            i2 = (composerStartRestartGroup.changed(legacy) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(tierInfo) ? 256 : 128;
        }
        if ((i2 & 145) == 144 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1395216940, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Title (Template7.kt:339)");
            }
            TemplateConfiguration.Colors currentColorsForTier = legacy.getTemplateConfiguration().getCurrentColorsForTier(tierInfo, composerStartRestartGroup, (i2 >> 6) & 14);
            ProcessedLocalizedConfiguration processedLocalizedConfigurationSelectedLocalizationForTier = selectedLocalizationForTier(tierInfo);
            composer2 = composerStartRestartGroup;
            MarkdownKt.m10642MarkdownDkhmgE0(processedLocalizedConfigurationSelectedLocalizationForTier.getTitle(), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), currentColorsForTier.m10781getText10d7_KjU(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), 0L, FontWeight.INSTANCE.getBold(), null, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), false, true, false, composer2, 196656, 54, 720);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template7Kt.Title.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    Template7Kt.Title(columnScope, legacy, tierInfo, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final long getFeatureIcon(TemplateConfiguration.Colors colors) {
        return colors.m10773getAccent10d7_KjU();
    }

    private static final long getSelectedDiscountText(TemplateConfiguration.Colors colors) {
        return colors.m10782getText20d7_KjU();
    }

    private static final long getSelectedOutline(TemplateConfiguration.Colors colors) {
        return colors.m10774getAccent20d7_KjU();
    }

    private static final long getTierSwitcherBackground(TemplateConfiguration.Colors colors) {
        Color colorM10784getTierControlBackgroundQN2ZGVo = colors.m10784getTierControlBackgroundQN2ZGVo();
        return colorM10784getTierControlBackgroundQN2ZGVo != null ? colorM10784getTierControlBackgroundQN2ZGVo.m6335unboximpl() : colors.m10773getAccent10d7_KjU();
    }

    private static final long getTierSwitcherBackgroundSelected(TemplateConfiguration.Colors colors) {
        Color colorM10786getTierControlSelectedBackgroundQN2ZGVo = colors.m10786getTierControlSelectedBackgroundQN2ZGVo();
        return colorM10786getTierControlSelectedBackgroundQN2ZGVo != null ? colorM10786getTierControlSelectedBackgroundQN2ZGVo.m6335unboximpl() : getUnselectedDiscountText(colors);
    }

    private static final long getTierSwitcherForeground(TemplateConfiguration.Colors colors) {
        Color colorM10785getTierControlForegroundQN2ZGVo = colors.m10785getTierControlForegroundQN2ZGVo();
        return colorM10785getTierControlForegroundQN2ZGVo != null ? colorM10785getTierControlForegroundQN2ZGVo.m6335unboximpl() : colors.m10781getText10d7_KjU();
    }

    private static final long getTierSwitcherForegroundSelected(TemplateConfiguration.Colors colors) {
        Color colorM10787getTierControlSelectedForegroundQN2ZGVo = colors.m10787getTierControlSelectedForegroundQN2ZGVo();
        return colorM10787getTierControlSelectedForegroundQN2ZGVo != null ? colorM10787getTierControlSelectedForegroundQN2ZGVo.m6335unboximpl() : colors.m10781getText10d7_KjU();
    }

    private static final long getUnselectedDiscountText(TemplateConfiguration.Colors colors) {
        return colors.m10783getText30d7_KjU();
    }

    private static final long getUnselectedOutline(TemplateConfiguration.Colors colors) {
        return colors.m10775getAccent30d7_KjU();
    }

    private static final ProcessedLocalizedConfiguration selectedLocalizationForTier(TemplateConfiguration.TierInfo tierInfo) {
        return tierInfo.getDefaultPackage().getLocalization();
    }
}
