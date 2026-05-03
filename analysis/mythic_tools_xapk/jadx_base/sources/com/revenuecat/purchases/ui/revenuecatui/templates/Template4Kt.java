package com.revenuecat.purchases.ui.revenuecatui.templates;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.composables.AutoResizedTextKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.ConsistentPackageContentViewKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.InsetSpacersKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallBackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconName;
import com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProviderKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Template4.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\r\u001a,\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001a\u001a/\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001d\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u001d\u0010 \u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001a\u001a\r\u0010!\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\"\u001a\r\u0010#\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\"\u001a\r\u0010$\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%²\u0006\n\u0010&\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"CheckmarkBox", "", "isSelected", "", "colors", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DiscountRelativeToMostExpensivePerMonth", "text", "", "selected", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;ZLandroidx/compose/runtime/Composer;I)V", "OfferName", "packageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "textColor", "Landroidx/compose/ui/graphics/Color;", "OfferName-3IgeMak", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Packages", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;I)V", "SelectPackageButton", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectPackageButtonContent", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;I)V", "Template4", "Template4MainContent", "Template4PaywallFooterCondensedPreview", "(Landroidx/compose/runtime/Composer;I)V", "Template4PaywallFooterPreview", "Template4PaywallPreview", "revenuecatui_defaultsBc8Release", "packageSelectorVisible"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Template4Kt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CheckmarkBox(final boolean z, final TemplateConfiguration.Colors colors, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2025803939);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckmarkBox)P(1)435@16985L455:Template4.kt#mf3l5c");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(colors) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2025803939, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CheckmarkBox (Template4.kt:434)");
                }
                Modifier modifierClip = ClipKt.clip(SizeKt.m2083size3ABfNKs(modifier4, Template4UIConstants.INSTANCE.m10872getCheckmarkSizeD9Ej5fM()), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1870074262, "C444@17334L100,440@17120L314:Template4.kt#mf3l5c");
                AnimatedVisibilityKt.AnimatedVisibility(z, (Modifier) null, EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-2128395201, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$CheckmarkBox$1$1
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
                        ComposerKt.sourceInformation(composer2, "C445@17348L76:Template4.kt#mf3l5c");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2128395201, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CheckmarkBox.<anonymous>.<anonymous> (Template4.kt:445)");
                        }
                        PaywallIconKt.m10655PaywallIconFNF3uiM(PaywallIconName.CHECK_CIRCLE, null, colors.m10773getAccent10d7_KjU(), composer2, 6, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.CheckmarkBox.2
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
                        Template4Kt.CheckmarkBox(z, colors, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            Modifier modifierClip2 = ClipKt.clip(SizeKt.m2083size3ABfNKs(modifier4, Template4UIConstants.INSTANCE.m10872getCheckmarkSizeD9Ej5fM()), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1870074262, "C444@17334L100,440@17120L314:Template4.kt#mf3l5c");
                AnimatedVisibilityKt.AnimatedVisibility(z, (Modifier) null, EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-2128395201, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$CheckmarkBox$1$1
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
                        ComposerKt.sourceInformation(composer2, "C445@17348L76:Template4.kt#mf3l5c");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2128395201, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.CheckmarkBox.<anonymous>.<anonymous> (Template4.kt:445)");
                        }
                        PaywallIconKt.m10655PaywallIconFNF3uiM(PaywallIconName.CHECK_CIRCLE, null, colors.m10773getAccent10d7_KjU(), composer2, 6, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DiscountRelativeToMostExpensivePerMonth(final String str, final TemplateConfiguration.Colors colors, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1807074170);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DiscountRelativeToMostExpensivePerMonth)P(2)374@15321L10,371@15172L493:Template4.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(colors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1807074170, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.DiscountRelativeToMostExpensivePerMonth (Template4.kt:370)");
            }
            if (str != null) {
                String upperCase = str.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (upperCase == null) {
                    upperCase = "";
                }
                AutoResizedTextKt.m10616AutoResizedTextW72HBGU(upperCase, SemanticsModifierKt.clearAndSetSemantics(PaddingKt.m2038paddingVpY3zN4(Modifier.INSTANCE, UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), Template4UIConstants.INSTANCE.m10873getDiscountVerticalPaddingD9Ej5fM()), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.DiscountRelativeToMostExpensivePerMonth.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                    }
                }), z ? colors.m10782getText20d7_KjU() : colors.m10783getText30d7_KjU(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), FontWeight.INSTANCE.getBold(), TextAlign.INSTANCE.m8992getCentere0LSkKk(), composerStartRestartGroup, 24576, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.DiscountRelativeToMostExpensivePerMonth.2
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
                    Template4Kt.DiscountRelativeToMostExpensivePerMonth(str, colors, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: OfferName-3IgeMak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10869OfferName3IgeMak(TemplateConfiguration.PackageInfo packageInfo, final long j, Modifier modifier, Composer composer, final int i, final int i2) {
        TemplateConfiguration.PackageInfo packageInfo2;
        int i3;
        long j2;
        Modifier modifier2;
        Object offerName;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        String str;
        Modifier modifier3;
        Composer composer2;
        Composer composer3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(681923225);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OfferName)P(1,2:c#ui.graphics.Color)405@16214L619:Template4.kt#mf3l5c");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            packageInfo2 = packageInfo;
        } else if ((i & 6) == 0) {
            packageInfo2 = packageInfo;
            i3 = (composerStartRestartGroup.changed(packageInfo2) ? 4 : 2) | i;
        } else {
            packageInfo2 = packageInfo;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            j2 = j;
        } else {
            j2 = j;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
            }
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
                    ComposerKt.traceEventStart(681923225, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.OfferName (Template4.kt:391)");
                }
                Object title = packageInfo2.getRcPackage().getProduct().getTitle();
                offerName = packageInfo2.getLocalization().getOfferName();
                Object obj = null;
                if (offerName != null) {
                    List listSplit$default = StringsKt.split$default((CharSequence) offerName, new String[]{" "}, false, 2, 2, (Object) null);
                    if (listSplit$default.size() == 2) {
                        obj = listSplit$default.get(0);
                        title = listSplit$default.get(1);
                    } else {
                        title = offerName;
                    }
                }
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -436168505, "C422@16710L10,419@16609L218:Template4.kt#mf3l5c");
                str = (String) obj;
                composerStartRestartGroup.startReplaceGroup(-152617202);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*413@16461L10,410@16355L234");
                if (str != null) {
                    Modifier modifier5 = companion;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                } else {
                    TextStyle titleLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge();
                    modifier3 = companion;
                    TextKt.m4286Text4IGK_g(str, (Modifier) null, j2, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, titleLarge, composerStartRestartGroup, ((i3 << 3) & 896) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 64986);
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceGroup();
                composer3 = composer2;
                TextKt.m4286Text4IGK_g((String) title, (Modifier) null, j, 0L, (FontStyle) null, FontWeight.INSTANCE.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer3, ((i3 << 3) & 896) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 64986);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer3 = composerStartRestartGroup;
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final TemplateConfiguration.PackageInfo packageInfo3 = packageInfo2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$OfferName$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i5) {
                        Template4Kt.m10869OfferName3IgeMak(packageInfo3, j, modifier4, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            Object title2 = packageInfo2.getRcPackage().getProduct().getTitle();
            offerName = packageInfo2.getLocalization().getOfferName();
            Object obj2 = null;
            if (offerName != null) {
            }
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -436168505, "C422@16710L10,419@16609L218:Template4.kt#mf3l5c");
                str = (String) obj2;
                composerStartRestartGroup.startReplaceGroup(-152617202);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*413@16461L10,410@16355L234");
                if (str != null) {
                }
                composer2.endReplaceGroup();
                composer3 = composer2;
                TextKt.m4286Text4IGK_g((String) title2, (Modifier) null, j, 0L, (FontStyle) null, FontWeight.INSTANCE.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge(), composer3, ((i3 << 3) & 896) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 64986);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Packages(final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2132177050);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Packages)233@10257L975,233@10238L994:Template4.kt#mf3l5c");
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
                ComposerKt.traceEventStart(2132177050, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Packages (Template4.kt:217)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(null, null, false, ComposableLambdaKt.rememberComposableLambda(-1700467196, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Packages.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                    ComposerKt.sourceInformation(composer2, "C240@10558L21,236@10412L814:Template4.kt#mf3l5c");
                    if ((i3 & 6) == 0) {
                        i3 |= composer2.changed(BoxWithConstraints) ? 4 : 2;
                    }
                    if ((i3 & 19) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1700467196, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Packages.<anonymous> (Template4.kt:234)");
                    }
                    float fPackages$packageWidth = Template4Kt.Packages$packageWidth(BoxWithConstraints, legacy.getTemplateConfiguration().getPackages().getAll().size());
                    Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(ScrollKt.horizontalScroll$default(SizeKt.fillMaxWidth$default(IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min), 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null), Template4UIConstants.INSTANCE.m10876getPackagesHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Template4UIConstants.INSTANCE.m10875getPackageHorizontalSpacingD9Ej5fM());
                    PaywallState.Loaded.Legacy legacy2 = legacy;
                    PaywallViewModel paywallViewModel2 = paywallViewModel;
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, 6);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1873007865, "C:Template4.kt#mf3l5c");
                    composer2.startReplaceGroup(632318323);
                    ComposerKt.sourceInformation(composer2, "*250@11023L179");
                    Iterator<T> it = legacy2.getTemplateConfiguration().getPackages().getAll().iterator();
                    while (it.hasNext()) {
                        Template4Kt.SelectPackageButton(legacy2, (TemplateConfiguration.PackageInfo) it.next(), paywallViewModel2, SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, fPackages$packageWidth), composer2, 0, 0);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Packages.2
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
                    Template4Kt.Packages(legacy, paywallViewModel, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Packages$packageWidth(BoxWithConstraintsScope boxWithConstraintsScope, float f) {
        float fPackages$packagesToDisplay = Packages$packagesToDisplay(f);
        float fM9114constructorimpl = Dp.m9114constructorimpl(Template4UIConstants.INSTANCE.m10876getPackagesHorizontalPaddingD9Ej5fM() * 2.0f);
        return Dp.m9114constructorimpl(Dp.m9114constructorimpl(Dp.m9114constructorimpl(boxWithConstraintsScope.mo1933getMaxWidthD9Ej5fM() - fM9114constructorimpl) - Dp.m9114constructorimpl(Template4UIConstants.INSTANCE.m10875getPackageHorizontalSpacingD9Ej5fM() * (fPackages$packagesToDisplay - 1.0f))) / fPackages$packagesToDisplay);
    }

    private static final float Packages$packagesToDisplay(float f) {
        return Math.min(Math.min(3.5f, f), 3.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0376  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SelectPackageButton(PaywallState.Loaded.Legacy legacy, final TemplateConfiguration.PackageInfo packageInfo, final PaywallViewModel paywallViewModel, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean zAreEqual;
        int i5;
        final String strLocalizedDiscount;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Composer composerM5595constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean zChanged;
        Object objRememberedValue;
        boolean z;
        Object objRememberedValue2;
        PaywallState.Loaded.Legacy legacy2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1542474718);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectPackageButton)P(2,1,3)269@11521L18,272@11637L47,273@11711L151,287@12166L2067:Template4.kt#mf3l5c");
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
            i3 |= composerStartRestartGroup.changed(packageInfo) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(paywallViewModel) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i3;
            if ((i4 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1542474718, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton (Template4.kt:268)");
                }
                final TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0);
                zAreEqual = Intrinsics.areEqual(packageInfo, legacy.getSelectedPackage().getValue());
                float fPackageButtonActionInProgressOpacityAnimation = AnimationsKt.packageButtonActionInProgressOpacityAnimation(paywallViewModel, composerStartRestartGroup, (i4 >> 6) & 14);
                int i7 = i4 & 14;
                i5 = i4 & 112;
                long jM10841packageButtonColorAnimation9z6LAg8 = AnimationsKt.m10841packageButtonColorAnimation9z6LAg8(legacy, packageInfo, currentColors.m10773getAccent10d7_KjU(), currentColors.m10774getAccent20d7_KjU(), composerStartRestartGroup, i4 & 126);
                Modifier modifierClip = ClipKt.clip(modifier4, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM()));
                strLocalizedDiscount = VariableDataProviderKt.localizedDiscount(packageInfo, paywallViewModel.getResourceProvider());
                if (packageInfo.getLocalization().getOfferBadge() != null) {
                    modifierClip = BackgroundKt.m1483backgroundbw27NRU$default(modifierClip, jM10841packageButtonColorAnimation9z6LAg8, null, 2, null);
                }
                Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierClip, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.SelectPackageButton.1
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
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1632075139, "C292@12336L100,294@12446L1781:Template4.kt#mf3l5c");
                DiscountRelativeToMostExpensivePerMonth(strLocalizedDiscount, currentColors, zAreEqual, composerStartRestartGroup, 0);
                Modifier modifierM1494borderxT4_qwU = BorderKt.m1494borderxT4_qwU(Modifier.INSTANCE, UIConstant.INSTANCE.m10452getDefaultPackageBorderWidthD9Ej5fM(), jM10841packageButtonColorAnimation9z6LAg8, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM()));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1494borderxT4_qwU);
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
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -323114554, "C*308@13079L7,309@13133L237,318@13517L48,317@13435L40,324@13860L79,304@12872L1067,330@14039L13,328@13953L264:Template4.kt#mf3l5c");
                Modifier modifierAlpha = AlphaKt.alpha(modifier4, fPackageButtonActionInProgressOpacityAnimation);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(modifierAlpha, Dp.m9112boximpl(((Density) objConsume).mo1621toDpu2uoSUM(1)).m9128unboximpl());
                composerStartRestartGroup.startReplaceGroup(-841699799);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template4.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(zAreEqual) | composerStartRestartGroup.changed(strLocalizedDiscount);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$SelectPackageButton$2$1$2$1
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
                            String str = strLocalizedDiscount;
                            if (str != null) {
                                SemanticsPropertiesKt.setText(semantics, new AnnotatedString(str, null, null, 6, null));
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SemanticsModifierKt.semantics$default(modifierM2037padding3ABfNKs, false, (Function1) objRememberedValue, 1, null), 0.0f, 1, null);
                Modifier modifier5 = modifier4;
                boolean z2 = false;
                ButtonColors buttonColorsM3340buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3340buttonColorsro_MJ88(currentColors.m10776getBackground0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14);
                RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM());
                PaddingValues paddingValuesM2031PaddingValuesYgX7TsA = PaddingKt.m2031PaddingValuesYgX7TsA(UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
                composerStartRestartGroup.startReplaceGroup(-841690332);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template4.kt#9igjgp");
                boolean z3 = (i4 & 896) != 256;
                if (i5 == 32) {
                    z2 = true;
                }
                z = z3 | z2;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$SelectPackageButton$2$1$3$1
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
                ButtonKt.Button((Function0) objRememberedValue2, modifierFillMaxHeight$default, false, roundedCornerShapeM2345RoundedCornerShape0680j_4, buttonColorsM3340buttonColorsro_MJ88, null, null, paddingValuesM2031PaddingValuesYgX7TsA, null, ComposableLambdaKt.rememberComposableLambda(-1357178314, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$SelectPackageButton$2$1$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope Button, Composer composer2, int i8) {
                        Intrinsics.checkNotNullParameter(Button, "$this$Button");
                        ComposerKt.sourceInformation(composer2, "C325@13878L47:Template4.kt#mf3l5c");
                        if ((i8 & 17) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1357178314, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton.<anonymous>.<anonymous>.<anonymous> (Template4.kt:325)");
                        }
                        Template4Kt.SelectPackageButtonContent(packageInfo, currentColors, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 356);
                legacy2 = legacy;
                composerStartRestartGroup = composerStartRestartGroup;
                CheckmarkBox(zAreEqual, PaywallStateKt.getCurrentColors(legacy2, composerStartRestartGroup, i7), PaddingKt.m2037padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), Template4UIConstants.INSTANCE.m10871getCheckmarkPaddingD9Ej5fM()), composerStartRestartGroup, 0, 0);
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
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                legacy2 = legacy;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final PaywallState.Loaded.Legacy legacy3 = legacy2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.SelectPackageButton.3
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
                        Template4Kt.SelectPackageButton(legacy3, packageInfo, paywallViewModel, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 1171) == 1170) {
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final TemplateConfiguration.Colors currentColors2 = legacy.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0);
            zAreEqual = Intrinsics.areEqual(packageInfo, legacy.getSelectedPackage().getValue());
            float fPackageButtonActionInProgressOpacityAnimation2 = AnimationsKt.packageButtonActionInProgressOpacityAnimation(paywallViewModel, composerStartRestartGroup, (i4 >> 6) & 14);
            int i72 = i4 & 14;
            i5 = i4 & 112;
            long jM10841packageButtonColorAnimation9z6LAg82 = AnimationsKt.m10841packageButtonColorAnimation9z6LAg8(legacy, packageInfo, currentColors2.m10773getAccent10d7_KjU(), currentColors2.m10774getAccent20d7_KjU(), composerStartRestartGroup, i4 & 126);
            Modifier modifierClip2 = ClipKt.clip(modifier4, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM()));
            strLocalizedDiscount = VariableDataProviderKt.localizedDiscount(packageInfo, paywallViewModel.getResourceProvider());
            if (packageInfo.getLocalization().getOfferBadge() != null) {
            }
            Modifier modifierSemantics2 = SemanticsModifierKt.semantics(modifierClip2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.SelectPackageButton.1
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
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1632075139, "C292@12336L100,294@12446L1781:Template4.kt#mf3l5c");
                DiscountRelativeToMostExpensivePerMonth(strLocalizedDiscount, currentColors2, zAreEqual, composerStartRestartGroup, 0);
                Modifier modifierM1494borderxT4_qwU2 = BorderKt.m1494borderxT4_qwU(Modifier.INSTANCE, UIConstant.INSTANCE.m10452getDefaultPackageBorderWidthD9Ej5fM(), jM10841packageButtonColorAnimation9z6LAg82, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM()));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1494borderxT4_qwU2);
                Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl2.getInserting()) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier22, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -323114554, "C*308@13079L7,309@13133L237,318@13517L48,317@13435L40,324@13860L79,304@12872L1067,330@14039L13,328@13953L264:Template4.kt#mf3l5c");
                    Modifier modifierAlpha2 = AlphaKt.alpha(modifier4, fPackageButtonActionInProgressOpacityAnimation2);
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM2037padding3ABfNKs2 = PaddingKt.m2037padding3ABfNKs(modifierAlpha2, Dp.m9112boximpl(((Density) objConsume2).mo1621toDpu2uoSUM(1)).m9128unboximpl());
                    composerStartRestartGroup.startReplaceGroup(-841699799);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template4.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(zAreEqual) | composerStartRestartGroup.changed(strLocalizedDiscount);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$SelectPackageButton$2$1$2$1
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
                                String str = strLocalizedDiscount;
                                if (str != null) {
                                    SemanticsPropertiesKt.setText(semantics, new AnnotatedString(str, null, null, 6, null));
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(SemanticsModifierKt.semantics$default(modifierM2037padding3ABfNKs2, false, (Function1) objRememberedValue, 1, null), 0.0f, 1, null);
                        Modifier modifier52 = modifier4;
                        boolean z22 = false;
                        ButtonColors buttonColorsM3340buttonColorsro_MJ882 = ButtonDefaults.INSTANCE.m3340buttonColorsro_MJ88(currentColors2.m10776getBackground0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14);
                        RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_42 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM());
                        PaddingValues paddingValuesM2031PaddingValuesYgX7TsA2 = PaddingKt.m2031PaddingValuesYgX7TsA(UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
                        composerStartRestartGroup.startReplaceGroup(-841690332);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template4.kt#9igjgp");
                        if ((i4 & 896) != 256) {
                        }
                        if (i5 == 32) {
                        }
                        z = z3 | z22;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$SelectPackageButton$2$1$3$1
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
                            composerStartRestartGroup.endReplaceGroup();
                            ButtonKt.Button((Function0) objRememberedValue2, modifierFillMaxHeight$default2, false, roundedCornerShapeM2345RoundedCornerShape0680j_42, buttonColorsM3340buttonColorsro_MJ882, null, null, paddingValuesM2031PaddingValuesYgX7TsA2, null, ComposableLambdaKt.rememberComposableLambda(-1357178314, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$SelectPackageButton$2$1$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                                    invoke(rowScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope Button, Composer composer2, int i8) {
                                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                                    ComposerKt.sourceInformation(composer2, "C325@13878L47:Template4.kt#mf3l5c");
                                    if ((i8 & 17) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1357178314, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButton.<anonymous>.<anonymous>.<anonymous> (Template4.kt:325)");
                                    }
                                    Template4Kt.SelectPackageButtonContent(packageInfo, currentColors2, composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 356);
                            legacy2 = legacy;
                            composerStartRestartGroup = composerStartRestartGroup;
                            CheckmarkBox(zAreEqual, PaywallStateKt.getCurrentColors(legacy2, composerStartRestartGroup, i72), PaddingKt.m2037padding3ABfNKs(boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), Template4UIConstants.INSTANCE.m10871getCheckmarkPaddingD9Ej5fM()), composerStartRestartGroup, 0, 0);
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
                            modifier3 = modifier52;
                        }
                    }
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectPackageButtonContent(final TemplateConfiguration.PackageInfo packageInfo, final TemplateConfiguration.Colors colors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2102143927);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectPackageButtonContent)P(1)344@14391L620:Template4.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(packageInfo) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(2102143927, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.SelectPackageButtonContent (Template4.kt:343)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Template4UIConstants.INSTANCE.m10874getPackageButtonContentVerticalSpacingD9Ej5fM());
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 365318469, "C348@14585L193,359@14928L10,356@14788L217:Template4.kt#mf3l5c");
            m10869OfferName3IgeMak(packageInfo, colors.m10781getText10d7_KjU(), ColumnScope.weight$default(columnScopeInstance, SizeKt.wrapContentSize$default(Modifier.INSTANCE, null, false, 3, null), 1.0f, false, 2, null), composerStartRestartGroup, i2 & 14, 0);
            TextKt.m4286Text4IGK_g(packageInfo.getRcPackage().getProduct().getPrice().getFormatted(), (Modifier) null, colors.m10781getText10d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.SelectPackageButtonContent.2
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
                    Template4Kt.SelectPackageButtonContent(packageInfo, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void Template4(final PaywallState.Loaded.Legacy state, final PaywallViewModel viewModel, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(596926027);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template4):Template4.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(viewModel) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(596926027, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4 (Template4.kt:102)");
            }
            if (PaywallStateKt.isInFullScreenMode(state)) {
                composerStartRestartGroup.startReplaceGroup(-1356655279);
                ComposerKt.sourceInformation(composerStartRestartGroup, "104@5295L26,106@5331L1221");
                int i3 = i2 & 14;
                boolean zShouldUseLandscapeLayout = WindowHelperKt.shouldUseLandscapeLayout(state, composerStartRestartGroup, i3);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                final BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2044743210, "C116@5632L80,119@5764L533,131@6336L13,114@5538L1004:Template4.kt#mf3l5c");
                composerStartRestartGroup.startReplaceGroup(-1319514881);
                ComposerKt.sourceInformation(composerStartRestartGroup, "111@5464L46");
                if (!zShouldUseLandscapeLayout) {
                    PaywallBackgroundKt.PaywallBackground(boxScopeInstance, state.getTemplateConfiguration(), composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier.Companion companion = Modifier.INSTANCE;
                composerStartRestartGroup.startReplaceGroup(-1319508245);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template4.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Modifier invoke(Modifier conditional) {
                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                            return boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierConditional = ModifierExtensionsKt.conditional(companion, zShouldUseLandscapeLayout, (Function1) objRememberedValue);
                boolean z = !zShouldUseLandscapeLayout;
                composerStartRestartGroup.startReplaceGroup(-1319503568);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template4.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4$1$2$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Modifier invoke(Modifier conditional) {
                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                            return ClipKt.clip(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), RoundedCornerShapeKt.m2346RoundedCornerShapea9UjIt4(UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM(), UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM(), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(0.0f)));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierM1483backgroundbw27NRU$default = BackgroundKt.m1483backgroundbw27NRU$default(ModifierExtensionsKt.conditional(modifierConditional, z, (Function1) objRememberedValue2), PaywallStateKt.getCurrentColors(state, composerStartRestartGroup, i3).m10776getBackground0d7_KjU(), null, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1483backgroundbw27NRU$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2027915236, "C136@6490L38:Template4.kt#mf3l5c");
                composerStartRestartGroup.startReplaceGroup(-1458604088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "134@6438L17");
                if (zShouldUseLandscapeLayout) {
                    InsetSpacersKt.StatusBarSpacer(composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                Template4MainContent(state, viewModel, composerStartRestartGroup, i2 & 126);
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
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1355397392);
                ComposerKt.sourceInformation(composerStartRestartGroup, "140@6574L38");
                Template4MainContent(state, viewModel, composerStartRestartGroup, i2 & 126);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4.2
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
                    Template4Kt.Template4(state, viewModel, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4MainContent(final PaywallState.Loaded.Legacy legacy, PaywallViewModel paywallViewModel, Composer composer, final int i) {
        int i2;
        int i3;
        String str;
        SnapshotMutationPolicy snapshotMutationPolicy;
        String str2;
        String str3;
        Composer composer2;
        String str4;
        final PaywallState.Loaded.Legacy legacy2;
        final PaywallViewModel paywallViewModel2 = paywallViewModel;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1408056045);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template4MainContent)149@6789L18,151@6813L2503:Template4.kt#mf3l5c");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(legacy) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            legacy2 = legacy;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1408056045, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4MainContent (Template4.kt:148)");
            }
            final TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0);
            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM(), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM());
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1534167451, "C171@7679L113,175@7802L1256,203@9068L32,208@9247L52,205@9110L200:Template4.kt#mf3l5c");
            composerStartRestartGroup.startReplaceGroup(-1434964265);
            ComposerKt.sourceInformation(composerStartRestartGroup, "160@7228L10,159@7180L449");
            if (PaywallStateKt.isInFullScreenMode(legacy)) {
                i3 = i2;
                str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                str = "C88@4444L9:Column.kt#2w3rfo";
                str4 = "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo";
                snapshotMutationPolicy = null;
                MarkdownKt.m10642MarkdownDkhmgE0(PaywallStateKt.getSelectedLocalization(legacy).getTitle(), PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, 2, null), currentColors.m10781getText10d7_KjU(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getDisplaySmall(), 0L, FontWeight.INSTANCE.getBlack(), null, null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), false, true, false, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 54, 720);
                composer2 = composerStartRestartGroup;
            } else {
                i3 = i2;
                str = "C88@4444L9:Column.kt#2w3rfo";
                snapshotMutationPolicy = null;
                str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                composer2 = composerStartRestartGroup;
                str4 = "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo";
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1434945388);
            ComposerKt.sourceInformation(composer2, "CC(remember):Template4.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(legacy.getTemplateConfiguration().getMode() != PaywallMode.FOOTER_CONDENSED), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                composer2.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            composer2.endReplaceGroup();
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, str4);
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str2);
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
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384784025, str);
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -809972692, "C181@8159L58,176@7875L342,185@8231L154,189@8443L605,189@8399L649:Template4.kt#mf3l5c");
            Composer composer3 = composer2;
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance2, Template4MainContent$lambda$9$lambda$5(mutableState), (Modifier) null, EnterExitTransitionKt.expandVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null), EnterExitTransitionKt.shrinkVertically$default(null, Alignment.INSTANCE.getBottom(), false, null, 13, null), "SelectPackagesVisibility", ComposableLambdaKt.rememberComposableLambda(492758735, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4MainContent$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer4, Integer num) {
                    invoke(animatedVisibilityScope, composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer4, int i4) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation(composer4, "C182@8177L26:Template4.kt#mf3l5c");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(492758735, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4MainContent.<anonymous>.<anonymous>.<anonymous> (Template4.kt:182)");
                    }
                    Template4Kt.Packages(legacy, paywallViewModel2, composer4, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer3, 1797126, 2);
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance2, Template4MainContent$lambda$9$lambda$5(mutableState), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$Template4Kt.INSTANCE.m10851getLambda1$revenuecatui_defaultsBc8Release(), composer3, 1572870, 30);
            composerStartRestartGroup = composer3;
            ConsistentPackageContentViewKt.ConsistentPackageContentView(legacy, ComposableLambdaKt.rememberComposableLambda(-1316875667, true, new Function3<TemplateConfiguration.PackageInfo, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4MainContent$1$1$2
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.PackageInfo packageInfo, Composer composer4, Integer num) {
                    invoke(packageInfo, composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(TemplateConfiguration.PackageInfo it, Composer composer4, int i4) {
                    int i5;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation(composer4, "C196@8888L10,190@8461L573:Template4.kt#mf3l5c");
                    if ((i4 & 6) == 0) {
                        i5 = i4 | (composer4.changed(it) ? 4 : 2);
                    } else {
                        i5 = i4;
                    }
                    if ((i5 & 19) == 18 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1316875667, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4MainContent.<anonymous>.<anonymous>.<anonymous> (Template4.kt:190)");
                    }
                    IntroEligibilityStateViewKt.m10633IntroEligibilityStateViewQETHhvg(it.getLocalization().getOfferDetails(), it.getLocalization().getOfferDetailsWithIntroOffer(), it.getLocalization().getOfferDetailsWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(it), currentColors.m10781getText10d7_KjU(), MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getBodyMedium(), null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), false, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer4, 805306368, 320);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 48);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = i3 & 112;
            PurchaseButtonKt.m10664PurchaseButtonhGBTI10(legacy, paywallViewModel2, null, 0.0f, null, composerStartRestartGroup, i3 & 126, 28);
            legacy2 = legacy;
            TemplateConfiguration templateConfiguration = legacy2.getTemplateConfiguration();
            composerStartRestartGroup.startReplaceGroup(-1434895273);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Template4.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt$Template4MainContent$1$2$1
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
                        Template4Kt.Template4MainContent$lambda$9$lambda$6(mutableState, !Template4Kt.Template4MainContent$lambda$9$lambda$5(r1));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            paywallViewModel2 = paywallViewModel;
            FooterKt.Footer(templateConfiguration, paywallViewModel2, null, null, (Function0) objRememberedValue2, composerStartRestartGroup, i4 | 24576, 12);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4MainContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i5) {
                    Template4Kt.Template4MainContent(legacy2, paywallViewModel2, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Template4MainContent$lambda$9$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4MainContent$lambda$9$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4PaywallFooterCondensedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1780033640);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template4PaywallFooterCondensedPreview)486@18918L204:Template4.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1780033640, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4PaywallFooterCondensedPreview (Template4.kt:485)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallFooterCondensedPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER_CONDENSED, TestData.INSTANCE.getTemplate4Offering(), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallFooterCondensedPreview.2
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
                    Template4Kt.Template4PaywallFooterCondensedPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4PaywallFooterPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1022674125);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template4PaywallFooterPreview)475@18418L194:Template4.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1022674125, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4PaywallFooterPreview (Template4.kt:474)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallFooterPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(PaywallMode.FOOTER, TestData.INSTANCE.getTemplate4Offering(), null, false, false, 28, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallFooterPreview.2
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
                    Template4Kt.Template4PaywallFooterPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Template4PaywallPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1574269896);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Template4PaywallPreview)464@17963L167:Template4.kt#mf3l5c");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1574269896, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.Template4PaywallPreview (Template4.kt:463)");
            }
            InternalPaywallKt.InternalPaywall(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallPreview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }).build(), new MockViewModel(null, TestData.INSTANCE.getTemplate4Offering(), null, false, false, 29, null), composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.Template4Kt.Template4PaywallPreview.2
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
                    Template4Kt.Template4PaywallPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
