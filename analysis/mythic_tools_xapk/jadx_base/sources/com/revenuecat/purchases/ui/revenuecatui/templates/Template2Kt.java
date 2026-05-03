package com.revenuecat.purchases.ui.revenuecatui.templates;

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
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
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
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.IconImageKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.InsetSpacersKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetailsKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallBackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconName;
import com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.AnimationsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.TestTag;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WindowHelperKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: Template2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010\u001a\u001d\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u0012\u001a,\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a'\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001d\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001b\u001a,\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0017\u001a1\u0010 \u001a\u00020\u0001*\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010$\u001a1\u0010%\u001a\u00020\u0001*\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010&\u001a1\u0010'\u001a\u00020\u0001*\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010&\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006(²\u0006\n\u0010)\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"AnimatedPackages", "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "packageSelectionVisible", "", "landscapeLayout", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "childModifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;ZZLcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "CheckmarkBox", "isSelected", "colors", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "(ZLcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;I)V", "IconImage", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Subtitle", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "Subtitle-8iNrtrE", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroidx/compose/ui/Modifier;ILandroidx/compose/runtime/Composer;II)V", "Template2", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Template2PaywallFooterCondensedPreview", "(Landroidx/compose/runtime/Composer;I)V", "Template2PaywallFooterPreview", "Template2PaywallPreview", "Title", "Title-8iNrtrE", "SelectPackageButton", "Landroidx/compose/foundation/layout/ColumnScope;", "packageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Template2LandscapeContent", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Template2PortraitContent", "revenuecatui_defaultsBc8Release", "packageSelectorVisible"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Template2Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnimatedPackages(final PaywallState.Loaded.Legacy legacy, final boolean z, final boolean z2, final PaywallViewModel paywallViewModel, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1799464452);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedPackages)P(3,2,1,4)307@11472L1315:Template2.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(legacy) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1799464452, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages (Template2.kt:301)");
            }
            Alignment topStart = PaywallStateKt.isInFullScreenMode(legacy) ? Alignment.INSTANCE.getTopStart() : Alignment.INSTANCE.getBottomCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 394516308, "C313@11871L43,308@11531L383,322@12189L592,317@11924L857:Template2.kt#mf3l5c");
            AnimatedVisibilityKt.AnimatedVisibility(!z, (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(0, 200, null, 5, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(0, 200, null, 5, null), 0.0f, 2, null), "OfferDetailsVisibility", ComposableLambdaKt.rememberComposableLambda(4658274, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$AnimatedPackages$1$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation(composer2, "C314@11885L19:Template2.kt#mf3l5c");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(4658274, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages.<anonymous>.<anonymous> (Template2.kt:314)");
                    }
                    OfferDetailsKt.OfferDetails(legacy, null, composer2, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 224640, 2);
            AnimatedVisibilityKt.AnimatedVisibility(z, (Modifier) null, EnterExitTransitionKt.expandVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null), EnterExitTransitionKt.shrinkVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null), "SelectPackagesVisibility", ComposableLambdaKt.rememberComposableLambda(1995133977, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$AnimatedPackages$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation(composer2, "C323@12203L568:Template2.kt#mf3l5c");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1995133977, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.AnimatedPackages.<anonymous>.<anonymous> (Template2.kt:323)");
                    }
                    Arrangement.Vertical verticalM1909spacedByD5KLDUw = Arrangement.INSTANCE.m1909spacedByD5KLDUw(z2 ? Dp.m9114constructorimpl(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM() / 2.0f) : UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterVertically());
                    PaywallState.Loaded.Legacy legacy2 = legacy;
                    PaywallViewModel paywallViewModel2 = paywallViewModel;
                    Modifier modifier2 = modifier;
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -1111458417, "C:Template2.kt#mf3l5c");
                    composer2.startReplaceGroup(1488168427);
                    ComposerKt.sourceInformation(composer2, "*334@12674L65");
                    Iterator<T> it = legacy2.getTemplateConfiguration().getPackages().getAll().iterator();
                    while (it.hasNext()) {
                        Template2Kt.SelectPackageButton(columnScopeInstance, legacy2, (TemplateConfiguration.PackageInfo) it.next(), paywallViewModel2, modifier2, composer2, 6);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 224640, 2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.AnimatedPackages.2
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
                    Template2Kt.AnimatedPackages(legacy, z, z2, paywallViewModel, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CheckmarkBox(final boolean z, final TemplateConfiguration.Colors colors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1250819500);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckmarkBox)P(1)420@15939L350:Template2.kt#mf3l5c");
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
                ComposerKt.traceEventStart(1250819500, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CheckmarkBox (Template2.kt:419)");
            }
            Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Template2UIConstants.INSTANCE.m10858getCheckmarkSizeD9Ej5fM()), RoundedCornerShapeKt.getCircleShape()), Color.m6324copywmQWz5c$default(colors.m10774getAccent20d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1869122748, "C:Template2.kt#mf3l5c");
            composerStartRestartGroup.startReplaceGroup(1030125607);
            ComposerKt.sourceInformation(composerStartRestartGroup, "427@16197L76");
            if (z) {
                PaywallIconKt.m10655PaywallIconFNF3uiM(PaywallIconName.CHECK_CIRCLE, null, colors.m10773getAccent10d7_KjU(), composerStartRestartGroup, 6, 2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.CheckmarkBox.2
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
                    Template2Kt.CheckmarkBox(z, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IconImage(final PaywallState.Loaded.Legacy legacy, Modifier modifier, Composer composer, final int i) {
        int i2;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-951232294);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconImage)P(1)250@9813L233:Template2.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(legacy) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-951232294, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.IconImage (Template2.kt:249)");
            }
            modifier2 = modifier;
            IconImageKt.m10632IconImagedjqsMU(legacy.getTemplateConfiguration().getImages().getIconUri(), Template2UIConstants.INSTANCE.m10860getMaxIconWidthD9Ej5fM(), Template2UIConstants.INSTANCE.m10859getIconCornerRadiusD9Ej5fM(), modifier2, composerStartRestartGroup, ((i2 << 6) & 7168) | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.IconImage.1
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
                    Template2Kt.IconImage(legacy, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectPackageButton(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.PackageInfo packageInfo, final PaywallViewModel paywallViewModel, final Modifier modifier, Composer composer, final int i) {
        int i2;
        int i3;
        BorderStroke borderStrokeM1509BorderStrokecXLIe8U;
        Composer composerStartRestartGroup = composer.startRestartGroup(1238280660);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectPackageButton)P(2,1,3)349@13082L18,352@13198L47,353@13273L154,358@13454L149,377@13997L53,382@14228L67,381@14154L40,389@14574L1259,372@13837L1996:Template2.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(legacy) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(packageInfo) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        int i4 = i2;
        if ((i4 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1238280660, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton (Template2.kt:348)");
            }
            TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0);
            final boolean zAreEqual = Intrinsics.areEqual(packageInfo, legacy.getSelectedPackage().getValue());
            float fPackageButtonActionInProgressOpacityAnimation = AnimationsKt.packageButtonActionInProgressOpacityAnimation(paywallViewModel, composerStartRestartGroup, (i4 >> 9) & 14);
            int i5 = (i4 >> 3) & 126;
            long jM10841packageButtonColorAnimation9z6LAg8 = AnimationsKt.m10841packageButtonColorAnimation9z6LAg8(legacy, packageInfo, currentColors.m10774getAccent20d7_KjU(), currentColors.m10776getBackground0d7_KjU(), composerStartRestartGroup, i5);
            final long jM10841packageButtonColorAnimation9z6LAg82 = AnimationsKt.m10841packageButtonColorAnimation9z6LAg8(legacy, packageInfo, currentColors.m10773getAccent10d7_KjU(), currentColors.m10781getText10d7_KjU(), composerStartRestartGroup, i5);
            if (zAreEqual) {
                borderStrokeM1509BorderStrokecXLIe8U = null;
                i3 = i4;
            } else {
                i3 = i4;
                borderStrokeM1509BorderStrokecXLIe8U = BorderStrokeKt.m1509BorderStrokecXLIe8U(UIConstant.INSTANCE.m10452getDefaultPackageBorderWidthD9Ej5fM(), Color.m6324copywmQWz5c$default(currentColors.m10781getText10d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null));
            }
            Modifier modifierAlign = columnScope.align(AlphaKt.alpha(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), fPackageButtonActionInProgressOpacityAnimation), Alignment.INSTANCE.getStart());
            composerStartRestartGroup.startReplaceGroup(1055888883);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template2.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(zAreEqual);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$SelectPackageButton$1$1
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
            Modifier modifierTestTag = TestTagKt.testTag(SemanticsModifierKt.semantics$default(modifierAlign, false, (Function1) objRememberedValue, 1, null), TestTag.INSTANCE.selectButtonTestTag(packageInfo.getRcPackage().getIdentifier()));
            ButtonColors buttonColorsM3340buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3340buttonColorsro_MJ88(jM10841packageButtonColorAnimation9z6LAg8, jM10841packageButtonColorAnimation9z6LAg82, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12);
            RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(UIConstant.INSTANCE.m10453getDefaultPackageCornerRadiusD9Ej5fM());
            PaddingValues paddingValuesM2031PaddingValuesYgX7TsA = PaddingKt.m2031PaddingValuesYgX7TsA(UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
            composerStartRestartGroup.startReplaceGroup(1055893894);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template2.kt#9igjgp");
            boolean z = ((i3 & 7168) == 2048) | ((i3 & 896) == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$SelectPackageButton$2$1
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
            ButtonKt.Button((Function0) objRememberedValue2, modifierTestTag, false, roundedCornerShapeM2345RoundedCornerShape0680j_4, buttonColorsM3340buttonColorsro_MJ88, null, borderStrokeM1509BorderStrokecXLIe8U, paddingValuesM2031PaddingValuesYgX7TsA, null, ComposableLambdaKt.rememberComposableLambda(760289252, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.SelectPackageButton.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope Button, Composer composer2, int i6) {
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    ComposerKt.sourceInformation(composer2, "C390@14584L1243:Template2.kt#mf3l5c");
                    if ((i6 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(760289252, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton.<anonymous> (Template2.kt:390)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(4.0f));
                    Alignment.Horizontal start = Alignment.INSTANCE.getStart();
                    TemplateConfiguration.PackageInfo packageInfo2 = packageInfo;
                    long j = jM10841packageButtonColorAnimation9z6LAg82;
                    boolean z2 = zAreEqual;
                    PaywallState.Loaded.Legacy legacy2 = legacy;
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -321217912, "C396@14794L502,411@15745L10,405@15309L508:Template2.kt#mf3l5c");
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -1744933990, "C397@14969L13,397@14916L67,401@15189L10,398@15000L282:Template2.kt#mf3l5c");
                    Template2Kt.CheckmarkBox(z2, PaywallStateKt.getCurrentColors(legacy2, composer2, 0), composer2, 0);
                    String offerName = packageInfo2.getLocalization().getOfferName();
                    if (offerName == null) {
                        offerName = packageInfo2.getRcPackage().getProduct().getTitle();
                    }
                    TextKt.m4286Text4IGK_g(offerName, (Modifier) null, j, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 292);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.SelectPackageButton.4
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
                    Template2Kt.SelectPackageButton(columnScope, legacy, packageInfo, paywallViewModel, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0104  */
    /* JADX INFO: renamed from: Subtitle-8iNrtrE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10854Subtitle8iNrtrE(PaywallState.Loaded.Legacy legacy, final Modifier modifier, int i, Composer composer, final int i2, final int i3) {
        PaywallState.Loaded.Legacy legacy2;
        int i4;
        Modifier modifier2;
        int iM8992getCentere0LSkKk;
        final int i5;
        String subtitle;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(993910968);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Subtitle)P(1!,2:c#ui.text.style.TextAlign)283@10769L10,287@10965L18,282@10729L376:Template2.kt#mf3l5c");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            legacy2 = legacy;
        } else if ((i2 & 6) == 0) {
            legacy2 = legacy;
            i4 = (composerStartRestartGroup.changed(legacy2) ? 4 : 2) | i2;
        } else {
            legacy2 = legacy;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
        }
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                iM8992getCentere0LSkKk = i;
                int i6 = composerStartRestartGroup.changed(iM8992getCentere0LSkKk) ? 256 : 128;
                i4 |= i6;
            } else {
                iM8992getCentere0LSkKk = i;
            }
            i4 |= i6;
        } else {
            iM8992getCentere0LSkKk = i;
        }
        if ((i4 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            i5 = iM8992getCentere0LSkKk;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i3 & 4) != 0) {
                    iM8992getCentere0LSkKk = TextAlign.INSTANCE.m8992getCentere0LSkKk();
                    i4 &= -897;
                }
                int i7 = iM8992getCentere0LSkKk;
                int i8 = i4;
                i5 = i7;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(993910968, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Subtitle (Template2.kt:281)");
                }
                TextStyle titleLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge();
                FontWeight normal = FontWeight.INSTANCE.getNormal();
                subtitle = PaywallStateKt.getSelectedLocalization(legacy2).getSubtitle();
                if (subtitle == null) {
                    subtitle = "";
                }
                composer2 = composerStartRestartGroup;
                MarkdownKt.m10642MarkdownDkhmgE0(subtitle, modifier2, legacy2.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0).m10781getText10d7_KjU(), titleLarge, 0L, normal, null, null, TextAlign.m8985boximpl(i5), false, true, false, composer2, (i8 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i8 << 18) & 234881024), 54, 720);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                }
                int i72 = iM8992getCentere0LSkKk;
                int i82 = i4;
                i5 = i72;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle titleLarge2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge();
                FontWeight normal2 = FontWeight.INSTANCE.getNormal();
                subtitle = PaywallStateKt.getSelectedLocalization(legacy2).getSubtitle();
                if (subtitle == null) {
                }
                composer2 = composerStartRestartGroup;
                MarkdownKt.m10642MarkdownDkhmgE0(subtitle, modifier2, legacy2.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0).m10781getText10d7_KjU(), titleLarge2, 0L, normal2, null, null, TextAlign.m8985boximpl(i5), false, true, false, composer2, (i82 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i82 << 18) & 234881024), 54, 720);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final PaywallState.Loaded.Legacy legacy3 = legacy2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$Subtitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i9) {
                    Template2Kt.m10854Subtitle8iNrtrE(legacy3, modifier, i5, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Template2(final PaywallState.Loaded.Legacy state, final PaywallViewModel viewModel, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Composer composerM5595constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        Object objRememberedValue;
        Modifier modifier3;
        String str;
        Object objRememberedValue2;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1075558368);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template2)P(1,2)93@4611L1477:Template2.kt#mf3l5c");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(viewModel) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i3;
            if ((i4 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier5 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1075558368, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2 (Template2.kt:92)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1229937831, "C94@4625L46,96@4681L1401:Template2.kt#mf3l5c");
                PaywallBackgroundKt.PaywallBackground(boxScopeInstance, state.getTemplateConfiguration(), composerStartRestartGroup, 6);
                Arrangement.HorizontalOrVertical spaceAround = !PaywallStateKt.isInFullScreenMode(state) ? Arrangement.INSTANCE.getSpaceAround() : Arrangement.INSTANCE.getTop();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceAround, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor2);
                }
                composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1759103798, "C99@4823L17,100@4883L121,104@5028L26,125@6005L52,121@5809L263:Template2.kt#mf3l5c");
                InsetSpacersKt.StatusBarSpacer(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceGroup(913086833);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template2.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(state.getTemplateConfiguration().getMode() != PaywallMode.FOOTER_CONDENSED), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                if (WindowHelperKt.shouldUseLandscapeLayout(state, composerStartRestartGroup, i4 & 14)) {
                    Modifier modifier6 = modifier5;
                    composerStartRestartGroup.startReplaceGroup(-1758773153);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "107@5194L81,109@5293L423,118@5734L47");
                    int i6 = i4 << 3;
                    Template2PortraitContent(columnScopeInstance, state, viewModel, Template2$lambda$5$lambda$4$lambda$1(mutableState), modifier6, composerStartRestartGroup, (i6 & 896) | (i6 & 112) | 6 | ((i4 << 6) & 57344));
                    modifier3 = modifier6;
                    AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, Template2$lambda$5$lambda$4$lambda$1(mutableState), (Modifier) null, EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), "Template2.packageSpacing", ComposableSingletons$Template2Kt.INSTANCE.m10850getLambda1$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 1769478, 2);
                    int i7 = i4 & 1022;
                    str = "CC(remember):Template2.kt#9igjgp";
                    mutableState = mutableState;
                    i4 = i4;
                    PurchaseButtonKt.m10664PurchaseButtonhGBTI10(state, viewModel, modifier3, 0.0f, null, composerStartRestartGroup, i7, 24);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1758907848);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "105@5074L82");
                    int i8 = i4 << 3;
                    Template2LandscapeContent(columnScopeInstance, state, viewModel, Template2$lambda$5$lambda$4$lambda$1(mutableState), modifier5, composerStartRestartGroup, (57344 & (i4 << 6)) | (i8 & 896) | 6 | (i8 & 112));
                    modifier3 = modifier5;
                    composerStartRestartGroup.endReplaceGroup();
                    str = "CC(remember):Template2.kt#9igjgp";
                }
                TemplateConfiguration templateConfiguration = state.getTemplateConfiguration();
                composerStartRestartGroup.startReplaceGroup(913122668);
                ComposerKt.sourceInformation(composerStartRestartGroup, str);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$Template2$1$1$1$1
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
                            Template2Kt.Template2$lambda$5$lambda$4$lambda$2(mutableState, !Template2Kt.Template2$lambda$5$lambda$4$lambda$1(r1));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                FooterKt.Footer(templateConfiguration, viewModel, modifier3, null, (Function0) objRememberedValue2, composerStartRestartGroup, (i4 & 112) | 24576 | (i4 & 896), 8);
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
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        Template2Kt.Template2(state, viewModel, modifier4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 147) == 146) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1229937831, "C94@4625L46,96@4681L1401:Template2.kt#mf3l5c");
                PaywallBackgroundKt.PaywallBackground(boxScopeInstance2, state.getTemplateConfiguration(), composerStartRestartGroup, 6);
                if (!PaywallStateKt.isInFullScreenMode(state)) {
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Modifier.Companion companion22 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(spaceAround, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion22);
                Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl2.getInserting()) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier22, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1759103798, "C99@4823L17,100@4883L121,104@5028L26,125@6005L52,121@5809L263:Template2.kt#mf3l5c");
                    InsetSpacersKt.StatusBarSpacer(composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceGroup(913086833);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template2.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableState<Boolean> mutableState2 = (MutableState) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    if (WindowHelperKt.shouldUseLandscapeLayout(state, composerStartRestartGroup, i4 & 14)) {
                    }
                    TemplateConfiguration templateConfiguration2 = state.getTemplateConfiguration();
                    composerStartRestartGroup.startReplaceGroup(913122668);
                    ComposerKt.sourceInformation(composerStartRestartGroup, str);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    FooterKt.Footer(templateConfiguration2, viewModel, modifier3, null, (Function0) objRememberedValue2, composerStartRestartGroup, (i4 & 112) | 24576 | (i4 & 896), 8);
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
                    }
                    modifier4 = modifier3;
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Template2$lambda$5$lambda$4$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2$lambda$5$lambda$4$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2LandscapeContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final boolean z, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1667751062);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template2LandscapeContent)P(2,3,1)189@7792L21,190@7841L21,192@7868L1830:Template2.kt#mf3l5c");
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
            i2 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        int i3 = i2;
        if ((i3 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1667751062, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2LandscapeContent (Template2.kt:188)");
            }
            ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            ScrollState scrollStateRememberScrollState2 = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            Arrangement.Horizontal spaceEvenly = Arrangement.Absolute.INSTANCE.getSpaceEvenly();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(ColumnScope.weight$default(columnScope, Modifier.INSTANCE, 1.0f, false, 2, null), UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2038paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2045596729, "C199@8183L684,219@8877L815:Template2.kt#mf3l5c");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, ScrollKt.verticalScroll$default(Modifier.INSTANCE, scrollStateRememberScrollState, false, null, false, 14, null), 0.5f, false, 2, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.Vertical verticalM1909spacedByD5KLDUw = Arrangement.INSTANCE.m1909spacedByD5KLDUw(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM1909spacedByD5KLDUw, centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 120371811, "C206@8527L46,208@8587L31,210@8632L44,212@8690L46,214@8750L47,216@8811L46:Template2.kt#mf3l5c");
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
            int i4 = i3 >> 3;
            int i5 = i4 & 14;
            int i6 = ((i3 >> 9) & 112) | i5;
            IconImage(legacy, modifier, composerStartRestartGroup, i6);
            m10855Title8iNrtrE(legacy, modifier, TextAlign.INSTANCE.m8997getStarte0LSkKk(), composerStartRestartGroup, i6, 0);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
            m10854Subtitle8iNrtrE(legacy, modifier, TextAlign.INSTANCE.m8997getStarte0LSkKk(), composerStartRestartGroup, i6, 0);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, ScrollKt.verticalScroll$default(Modifier.INSTANCE, scrollStateRememberScrollState2, false, null, false, 14, null), 0.5f, false, 2, null);
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.Vertical verticalM1909spacedByD5KLDUw2 = Arrangement.INSTANCE.m1909spacedByD5KLDUw(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(verticalM1909spacedByD5KLDUw2, centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 121065281, "C226@9222L46,228@9282L193,236@9489L46,238@9549L73,240@9636L46:Template2.kt#mf3l5c");
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
            int i7 = i3 >> 6;
            AnimatedPackages(legacy, z, true, paywallViewModel, modifier, composerStartRestartGroup, i5 | 384 | (i7 & 112) | ((i3 << 3) & 7168) | (57344 & i3));
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
            PurchaseButtonKt.m10664PurchaseButtonhGBTI10(legacy, paywallViewModel, modifier, Dp.m9114constructorimpl(0.0f), null, composerStartRestartGroup, i5 | 3072 | (i4 & 112) | (i7 & 896), 16);
            composerStartRestartGroup = composerStartRestartGroup;
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, Modifier.INSTANCE, 0.5f, false, 2, null), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2LandscapeContent.2
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
                    Template2Kt.Template2LandscapeContent(columnScope, legacy, paywallViewModel, z, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2PaywallFooterCondensedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-741508648);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template2PaywallFooterCondensedPreview)466@17615L204:Template2.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-741508648, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2PaywallFooterCondensedPreview (Template2.kt:465)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallFooterCondensedPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate2Offering(), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallFooterCondensedPreview.2
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
                    Template2Kt.Template2PaywallFooterCondensedPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2PaywallFooterPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1374736823);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template2PaywallFooterPreview)456@17202L194:Template2.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1374736823, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2PaywallFooterPreview (Template2.kt:455)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallFooterPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate2Offering(), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallFooterPreview.2
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
                    Template2Kt.Template2PaywallFooterPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2PaywallPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(44645436);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template2PaywallPreview)446@16831L167:Template2.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(44645436, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2PaywallPreview (Template2.kt:445)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate2Offering(), null, false, false, 29, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PaywallPreview.2
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
                    Template2Kt.Template2PaywallPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template2PortraitContent(final ColumnScope columnScope, final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final boolean z, final Modifier modifier, Composer composer, final int i) {
        int i2;
        PaywallViewModel paywallViewModel2;
        boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(75198122);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template2PortraitContent)P(2,3,1)139@6325L69,141@6418L21,144@6531L121,142@6444L1088:Template2.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(legacy) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            paywallViewModel2 = paywallViewModel;
            i2 |= composerStartRestartGroup.changed(paywallViewModel2) ? 256 : 128;
        } else {
            paywallViewModel2 = paywallViewModel;
        }
        if ((i & 3072) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        } else {
            z2 = z;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        int i3 = i2;
        if ((i3 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(75198122, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template2PortraitContent (Template2.kt:138)");
            }
            SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM()), composerStartRestartGroup, 0);
            final ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean zIsInFullScreenMode = PaywallStateKt.isInFullScreenMode(legacy);
            composerStartRestartGroup.startReplaceGroup(-491622595);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template2.kt#9igjgp");
            boolean zChanged = ((i3 & 14) == 4) | composerStartRestartGroup.changed(scrollStateRememberScrollState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$Template2PortraitContent$1$1
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2060511244, "C167@7265L170:Template2.kt#mf3l5c");
            composerStartRestartGroup.startReplaceGroup(-1596100152);
            ComposerKt.sourceInformation(composerStartRestartGroup, "154@7006L27,156@7047L31,158@7092L27,160@7133L27,162@7174L30,164@7218L27");
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                int i4 = ((i3 >> 9) & 112) | ((i3 >> 3) & 14);
                IconImage(legacy, modifier, composerStartRestartGroup, i4);
                m10855Title8iNrtrE(legacy, modifier, 0, composerStartRestartGroup, i4, 4);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                m10854Subtitle8iNrtrE(legacy, modifier, 0, composerStartRestartGroup, i4, 4);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            AnimatedPackages(legacy, z2, false, paywallViewModel2, modifier, composerStartRestartGroup, ((i3 >> 3) & 14) | 384 | ((i3 >> 6) & 112) | ((i3 << 3) & 7168) | (57344 & i3));
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.startReplaceGroup(-1596084908);
            ComposerKt.sourceInformation(composerStartRestartGroup, "176@7489L27");
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt.Template2PortraitContent.3
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
                    Template2Kt.Template2PortraitContent(columnScope, legacy, paywallViewModel, z, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0100  */
    /* JADX INFO: renamed from: Title-8iNrtrE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10855Title8iNrtrE(PaywallState.Loaded.Legacy legacy, final Modifier modifier, int i, Composer composer, final int i2, final int i3) {
        PaywallState.Loaded.Legacy legacy2;
        int i4;
        Modifier modifier2;
        int iM8992getCentere0LSkKk;
        final int i5;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1979998300);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Title)P(1!,2:c#ui.text.style.TextAlign)265@10242L10,269@10430L18,264@10202L368:Template2.kt#mf3l5c");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            legacy2 = legacy;
        } else if ((i2 & 6) == 0) {
            legacy2 = legacy;
            i4 = (composerStartRestartGroup.changed(legacy2) ? 4 : 2) | i2;
        } else {
            legacy2 = legacy;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
        }
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                iM8992getCentere0LSkKk = i;
                int i6 = composerStartRestartGroup.changed(iM8992getCentere0LSkKk) ? 256 : 128;
                i4 |= i6;
            } else {
                iM8992getCentere0LSkKk = i;
            }
            i4 |= i6;
        } else {
            iM8992getCentere0LSkKk = i;
        }
        if ((i4 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
            i5 = iM8992getCentere0LSkKk;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i3 & 4) != 0) {
                    iM8992getCentere0LSkKk = TextAlign.INSTANCE.m8992getCentere0LSkKk();
                    i4 &= -897;
                }
                int i7 = iM8992getCentere0LSkKk;
                int i8 = i4;
                i5 = i7;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1979998300, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Title (Template2.kt:263)");
                }
                composer2 = composerStartRestartGroup;
                MarkdownKt.m10642MarkdownDkhmgE0(PaywallStateKt.getSelectedLocalization(legacy2).getTitle(), modifier2, legacy2.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0).m10781getText10d7_KjU(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getDisplaySmall(), 0L, FontWeight.INSTANCE.getBlack(), null, null, TextAlign.m8985boximpl(i5), false, true, false, composer2, (i8 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i8 << 18) & 234881024), 54, 720);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                }
                int i72 = iM8992getCentere0LSkKk;
                int i82 = i4;
                i5 = i72;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = composerStartRestartGroup;
                MarkdownKt.m10642MarkdownDkhmgE0(PaywallStateKt.getSelectedLocalization(legacy2).getTitle(), modifier2, legacy2.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0).m10781getText10d7_KjU(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getDisplaySmall(), 0L, FontWeight.INSTANCE.getBlack(), null, null, TextAlign.m8985boximpl(i5), false, true, false, composer2, (i82 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i82 << 18) & 234881024), 54, 720);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final PaywallState.Loaded.Legacy legacy3 = legacy2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt$Title$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i9) {
                    Template2Kt.m10855Title8iNrtrE(legacy3, modifier, i5, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }
}
