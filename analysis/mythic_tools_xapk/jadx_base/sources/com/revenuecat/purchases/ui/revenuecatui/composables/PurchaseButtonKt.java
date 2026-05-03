package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.app.Activity;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.TestTag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: PurchaseButton.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016\u001a$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a!\u0010\u001e\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020\u001aX\u008a\u0084\u0002"}, d2 = {TestTag.PURCHASE_BUTTON_TAG, "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "childModifier", "Landroidx/compose/ui/Modifier;", "horizontalPadding", "Landroidx/compose/ui/unit/Dp;", "colors", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "PurchaseButton-hGBTI10", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;FLcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;II)V", "packages", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;", "selectedPackage", "Landroidx/compose/runtime/MutableState;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "PurchaseButton-WH-ejsw", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;Landroidx/compose/runtime/MutableState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PurchaseButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "buttonBrush", "Landroidx/compose/ui/graphics/Brush;", "primaryColor", "Landroidx/compose/ui/graphics/Color;", "secondaryColor", "buttonBrush-A47ccPs", "(JLandroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Brush;", "LoadingSpinner", "Landroidx/compose/foundation/layout/BoxScope;", "shouldShow", "", "(Landroidx/compose/foundation/layout/BoxScope;ZLcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release", "labelOpacity", "", "primaryCTAColor", "secondaryCTAColorState"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchaseButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadingSpinner(final BoxScope boxScope, boolean z, final TemplateConfiguration.Colors colors, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-268216038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingSpinner)P(1)189@8278L160,183@7978L460:PurchaseButton.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(colors) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            z2 = z;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-268216038, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.LoadingSpinner (PurchaseButton.kt:182)");
            }
            z2 = z;
            AnimatedVisibilityKt.AnimatedVisibility(z2, boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), "PurchaseButton.LoadingSpinner", ComposableLambdaKt.rememberComposableLambda(-1498164238, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.LoadingSpinner.1
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
                    ComposerKt.sourceInformation(composer2, "C190@8288L144:PurchaseButton.kt#51odh9");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1498164238, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.LoadingSpinner.<anonymous> (PurchaseButton.kt:190)");
                    }
                    ProgressIndicatorKt.m3947CircularProgressIndicatorLxG7B9w(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), colors.m10778getCallToActionForeground0d7_KjU(), 0.0f, 0L, 0, composer2, 0, 28);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 221184, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.LoadingSpinner.2
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
                    PurchaseButtonKt.LoadingSpinner(boxScope, z2, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x022b  */
    /* JADX INFO: renamed from: PurchaseButton-WH-ejsw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10663PurchaseButtonWHejsw(final TemplateConfiguration.Colors colors, final TemplateConfiguration.PackageConfiguration packageConfiguration, final MutableState<TemplateConfiguration.PackageInfo> mutableState, final PaywallViewModel paywallViewModel, final float f, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Activity activity;
        final Modifier modifier3;
        Color colorM10779getCallToActionSecondaryBackgroundQN2ZGVo;
        Color colorM6315boximpl;
        boolean z;
        Object objRememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-366633237);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseButton)P(1,3,4,5,2:c#ui.unit.Dp)77@3413L4141:PurchaseButton.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(colors) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(packageConfiguration) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(mutableState) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changed(paywallViewModel) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
                }
                if ((74899 & i3) == 74898 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                } else {
                    Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-366633237, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton (PurchaseButton.kt:76)");
                    }
                    Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), f, 0.0f, 2, null), TestTag.PURCHASE_BUTTON_TAG);
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1608141983, "C85@3736L7,87@3773L213,93@4019L188,101@4477L232,111@4951L552,123@5561L47,124@5653L5,127@5786L168,126@5701L47,131@5966L1582,108@4822L2726:PurchaseButton.kt#51odh9");
                    ProvidableCompositionLocal<Activity> localActivity = HelperFunctionsKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localActivity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    activity = (Activity) objConsume;
                    modifier3 = companion;
                    final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(!paywallViewModel.getActionInProgress().getValue().booleanValue() ? 0.0f : 1.0f, UIConstant.INSTANCE.defaultAnimation(), 0.0f, "PurchaseButton.label", null, composerStartRestartGroup, 3072, 20);
                    State<Color> stateM1353animateColorAsStateeuL9pac = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(colors.m10777getCallToActionBackground0d7_KjU(), UIConstant.INSTANCE.getDefaultColorAnimation(), "primaryCTAColor", null, composerStartRestartGroup, 384, 8);
                    Color colorM10779getCallToActionSecondaryBackgroundQN2ZGVo2 = colors.m10779getCallToActionSecondaryBackgroundQN2ZGVo();
                    State<Color> stateM1353animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(colorM10779getCallToActionSecondaryBackgroundQN2ZGVo2 == null ? colorM10779getCallToActionSecondaryBackgroundQN2ZGVo2.m6335unboximpl() : colors.m10777getCallToActionBackground0d7_KjU(), UIConstant.INSTANCE.getDefaultColorAnimation(), "secondaryCTAColor", null, composerStartRestartGroup, 384, 8);
                    colorM10779getCallToActionSecondaryBackgroundQN2ZGVo = colors.m10779getCallToActionSecondaryBackgroundQN2ZGVo();
                    if (colorM10779getCallToActionSecondaryBackgroundQN2ZGVo == null) {
                        colorM10779getCallToActionSecondaryBackgroundQN2ZGVo.m6335unboximpl();
                        colorM6315boximpl = Color.m6315boximpl(PurchaseButton_WH_ejsw$lambda$6$lambda$2(stateM1353animateColorAsStateeuL9pac2));
                    } else {
                        colorM6315boximpl = null;
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
                    composerStartRestartGroup.startReplaceGroup(329006731);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PurchaseButton.kt#9igjgp");
                    z = (i3 & 896) != 256;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$1$1
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
                                TemplateConfiguration.PackageInfo value = mutableState.getValue();
                                SemanticsPropertiesKt.setText(semantics, new AnnotatedString(IntroEligibilityStateViewKt.introEligibilityText(PackageExtensionsKt.getOfferEligibility(value), value.getLocalization().getCallToActionWithIntroOffer(), value.getLocalization().getCallToActionWithMultipleIntroOffers(), value.getLocalization().getCallToAction()), null, null, 6, null));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierBackground$default = BackgroundKt.background$default(SemanticsModifierKt.semantics(modifierFillMaxWidth$default, true, (Function1) objRememberedValue), m10666buttonBrushA47ccPs(PurchaseButton_WH_ejsw$lambda$6$lambda$1(stateM1353animateColorAsStateeuL9pac), colorM6315boximpl, composerStartRestartGroup, 0), ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, ButtonDefaults.$stable), 0.0f, 4, null);
                    ButtonColors buttonColorsM3340buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3340buttonColorsro_MJ88(Color.INSTANCE.m6360getTransparent0d7_KjU(), colors.m10778getCallToActionForeground0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 12);
                    composerStartRestartGroup.startReplaceGroup(329030226);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PurchaseButton.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(activity) | ((i3 & 7168) != 2048);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$2$1
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
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ButtonKt.Button((Function0) objRememberedValue2, modifierBackground$default, false, null, buttonColorsM3340buttonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1286977873, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope Button, Composer composer2, int i5) {
                            Intrinsics.checkNotNullParameter(Button, "$this$Button");
                            ComposerKt.sourceInformation(composer2, "C132@5980L1558:PurchaseButton.kt#51odh9");
                            if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1286977873, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous>.<anonymous> (PurchaseButton.kt:132)");
                            }
                            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                }
                            });
                            TemplateConfiguration.PackageConfiguration packageConfiguration2 = packageConfiguration;
                            MutableState<TemplateConfiguration.PackageInfo> mutableState2 = mutableState;
                            final TemplateConfiguration.Colors colors2 = colors;
                            final State<Float> state = stateAnimateFloatAsState;
                            PaywallViewModel paywallViewModel2 = paywallViewModel;
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierClearAndSetSemantics);
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
                            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 973708921, "C139@6286L940,136@6139L1087,157@7244L280:PurchaseButton.kt#51odh9");
                            ConsistentPackageContentViewKt.ConsistentPackageContentView(packageConfiguration2.getAll(), mutableState2.getValue(), ComposableLambdaKt.rememberComposableLambda(98081200, true, new Function3<TemplateConfiguration.PackageInfo, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.PackageInfo packageInfo, Composer composer3, Integer num) {
                                    invoke(packageInfo, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(TemplateConfiguration.PackageInfo it, Composer composer3, int i6) {
                                    int i7;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    ComposerKt.sourceInformation(composer3, "C148@6876L10,141@6363L845:PurchaseButton.kt#51odh9");
                                    if ((i6 & 6) == 0) {
                                        i7 = i6 | (composer3.changed(it) ? 4 : 2);
                                    } else {
                                        i7 = i6;
                                    }
                                    if ((i7 & 19) == 18 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(98081200, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PurchaseButton.kt:140)");
                                    }
                                    ProcessedLocalizedConfiguration localization = it.getLocalization();
                                    IntroEligibilityStateViewKt.m10633IntroEligibilityStateViewQETHhvg(localization.getCallToAction(), localization.getCallToActionWithIntroOffer(), localization.getCallToActionWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(it), colors2.m10778getCallToActionForeground0d7_KjU(), MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), FontWeight.INSTANCE.getSemiBold(), TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), false, AlphaKt.alpha(PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(Dp.m9114constructorimpl(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM() * 2.0f) / 3.0f), 1, null), PurchaseButtonKt.PurchaseButton_WH_ejsw$lambda$6$lambda$0(state)), composer3, 102236160, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, 384);
                            Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierMatchParentSize);
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor3);
                            } else {
                                composer2.useNode();
                            }
                            Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer2);
                            Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1870285429, "C161@7428L78:PurchaseButton.kt#51odh9");
                            PurchaseButtonKt.LoadingSpinner(boxScopeInstance2, paywallViewModel2.getActionInProgress().getValue().booleanValue(), colors2, composer2, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
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
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, Videoio.CAP_PROP_XI_CC_MATRIX_31);
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
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$4
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
                            PurchaseButtonKt.m10663PurchaseButtonWHejsw(colors, packageConfiguration, mutableState, paywallViewModel, f, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                Modifier modifierTestTag2 = TestTagKt.testTag(PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), f, 0.0f, 2, null), TestTag.PURCHASE_BUTTON_TAG);
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1608141983, "C85@3736L7,87@3773L213,93@4019L188,101@4477L232,111@4951L552,123@5561L47,124@5653L5,127@5786L168,126@5701L47,131@5966L1582,108@4822L2726:PurchaseButton.kt#51odh9");
                    ProvidableCompositionLocal<Activity> localActivity2 = HelperFunctionsKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localActivity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    activity = (Activity) objConsume2;
                    modifier3 = companion;
                    final State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!paywallViewModel.getActionInProgress().getValue().booleanValue() ? 0.0f : 1.0f, UIConstant.INSTANCE.defaultAnimation(), 0.0f, "PurchaseButton.label", null, composerStartRestartGroup, 3072, 20);
                    State<Color> stateM1353animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(colors.m10777getCallToActionBackground0d7_KjU(), UIConstant.INSTANCE.getDefaultColorAnimation(), "primaryCTAColor", null, composerStartRestartGroup, 384, 8);
                    Color colorM10779getCallToActionSecondaryBackgroundQN2ZGVo22 = colors.m10779getCallToActionSecondaryBackgroundQN2ZGVo();
                    State<Color> stateM1353animateColorAsStateeuL9pac22 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(colorM10779getCallToActionSecondaryBackgroundQN2ZGVo22 == null ? colorM10779getCallToActionSecondaryBackgroundQN2ZGVo22.m6335unboximpl() : colors.m10777getCallToActionBackground0d7_KjU(), UIConstant.INSTANCE.getDefaultColorAnimation(), "secondaryCTAColor", null, composerStartRestartGroup, 384, 8);
                    colorM10779getCallToActionSecondaryBackgroundQN2ZGVo = colors.m10779getCallToActionSecondaryBackgroundQN2ZGVo();
                    if (colorM10779getCallToActionSecondaryBackgroundQN2ZGVo == null) {
                    }
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
                    composerStartRestartGroup.startReplaceGroup(329006731);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PurchaseButton.kt#9igjgp");
                    if ((i3 & 896) != 256) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$1$1
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
                                TemplateConfiguration.PackageInfo value = mutableState.getValue();
                                SemanticsPropertiesKt.setText(semantics, new AnnotatedString(IntroEligibilityStateViewKt.introEligibilityText(PackageExtensionsKt.getOfferEligibility(value), value.getLocalization().getCallToActionWithIntroOffer(), value.getLocalization().getCallToActionWithMultipleIntroOffers(), value.getLocalization().getCallToAction()), null, null, 6, null));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierBackground$default2 = BackgroundKt.background$default(SemanticsModifierKt.semantics(modifierFillMaxWidth$default2, true, (Function1) objRememberedValue), m10666buttonBrushA47ccPs(PurchaseButton_WH_ejsw$lambda$6$lambda$1(stateM1353animateColorAsStateeuL9pac3), colorM6315boximpl, composerStartRestartGroup, 0), ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, ButtonDefaults.$stable), 0.0f, 4, null);
                        ButtonColors buttonColorsM3340buttonColorsro_MJ882 = ButtonDefaults.INSTANCE.m3340buttonColorsro_MJ88(Color.INSTANCE.m6360getTransparent0d7_KjU(), colors.m10778getCallToActionForeground0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 12);
                        composerStartRestartGroup.startReplaceGroup(329030226);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PurchaseButton.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(activity) | ((i3 & 7168) != 2048);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$2$1
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
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            composerStartRestartGroup.endReplaceGroup();
                            ButtonKt.Button((Function0) objRememberedValue2, modifierBackground$default2, false, null, buttonColorsM3340buttonColorsro_MJ882, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1286977873, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                                    invoke(rowScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope Button, Composer composer2, int i5) {
                                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                                    ComposerKt.sourceInformation(composer2, "C132@5980L1558:PurchaseButton.kt#51odh9");
                                    if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1286977873, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous>.<anonymous> (PurchaseButton.kt:132)");
                                    }
                                    Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                                        }
                                    });
                                    TemplateConfiguration.PackageConfiguration packageConfiguration2 = packageConfiguration;
                                    MutableState<TemplateConfiguration.PackageInfo> mutableState2 = mutableState;
                                    final TemplateConfiguration.Colors colors2 = colors;
                                    final State<Float> state = stateAnimateFloatAsState2;
                                    PaywallViewModel paywallViewModel2 = paywallViewModel;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap22 = composer2.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composer2, modifierClearAndSetSemantics);
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
                                    Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier22, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 973708921, "C139@6286L940,136@6139L1087,157@7244L280:PurchaseButton.kt#51odh9");
                                    ConsistentPackageContentViewKt.ConsistentPackageContentView(packageConfiguration2.getAll(), mutableState2.getValue(), ComposableLambdaKt.rememberComposableLambda(98081200, true, new Function3<TemplateConfiguration.PackageInfo, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.PackageInfo packageInfo, Composer composer3, Integer num) {
                                            invoke(packageInfo, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(TemplateConfiguration.PackageInfo it, Composer composer3, int i6) {
                                            int i7;
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            ComposerKt.sourceInformation(composer3, "C148@6876L10,141@6363L845:PurchaseButton.kt#51odh9");
                                            if ((i6 & 6) == 0) {
                                                i7 = i6 | (composer3.changed(it) ? 4 : 2);
                                            } else {
                                                i7 = i6;
                                            }
                                            if ((i7 & 19) == 18 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(98081200, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PurchaseButton.kt:140)");
                                            }
                                            ProcessedLocalizedConfiguration localization = it.getLocalization();
                                            IntroEligibilityStateViewKt.m10633IntroEligibilityStateViewQETHhvg(localization.getCallToAction(), localization.getCallToActionWithIntroOffer(), localization.getCallToActionWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(it), colors2.m10778getCallToActionForeground0d7_KjU(), MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), FontWeight.INSTANCE.getSemiBold(), TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), false, AlphaKt.alpha(PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9114constructorimpl(Dp.m9114constructorimpl(UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM() * 2.0f) / 3.0f), 1, null), PurchaseButtonKt.PurchaseButton_WH_ejsw$lambda$6$lambda$0(state)), composer3, 102236160, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer2, 54), composer2, 384);
                                    Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierMatchParentSize);
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor3);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer2);
                                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                        composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                        composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                    }
                                    Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 1870285429, "C161@7428L78:PurchaseButton.kt#51odh9");
                                    PurchaseButtonKt.LoadingSpinner(boxScopeInstance2, paywallViewModel2.getActionInProgress().getValue().booleanValue(), colors2, composer2, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
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
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, Videoio.CAP_PROP_XI_CC_MATRIX_31);
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
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        if ((74899 & i3) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0136  */
    /* JADX INFO: renamed from: PurchaseButton-hGBTI10, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10664PurchaseButtonhGBTI10(final PaywallState.Loaded.Legacy state, final PaywallViewModel viewModel, Modifier modifier, float f, TemplateConfiguration.Colors colors, Composer composer, final int i, final int i2) {
        int i3;
        float fM10451getDefaultHorizontalPaddingD9Ej5fM;
        TemplateConfiguration.Colors colors2;
        final Modifier modifier2;
        final TemplateConfiguration.Colors currentColors;
        final float f2;
        final Modifier modifier3;
        final TemplateConfiguration.Colors colors3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(885662377);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseButton)P(3,4!1,2:c#ui.unit.Dp)55@2733L313,55@2658L388:PurchaseButton.kt#51odh9");
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
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                fM10451getDefaultHorizontalPaddingD9Ej5fM = f;
                int i5 = composerStartRestartGroup.changed(fM10451getDefaultHorizontalPaddingD9Ej5fM) ? 2048 : 1024;
                i3 |= i5;
            } else {
                fM10451getDefaultHorizontalPaddingD9Ej5fM = f;
            }
            i3 |= i5;
        } else {
            fM10451getDefaultHorizontalPaddingD9Ej5fM = f;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                colors2 = colors;
                int i6 = composerStartRestartGroup.changed(colors2) ? 16384 : 8192;
                i3 |= i6;
            } else {
                colors2 = colors;
            }
            i3 |= i6;
        } else {
            colors2 = colors;
        }
        if ((i3 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier;
            f2 = fM10451getDefaultHorizontalPaddingD9Ej5fM;
            colors3 = colors2;
        } else {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "53@2630L18");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier;
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    fM10451getDefaultHorizontalPaddingD9Ej5fM = UIConstant.INSTANCE.m10451getDefaultHorizontalPaddingD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    currentColors = state.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0);
                    modifier2 = companion;
                    f2 = fM10451getDefaultHorizontalPaddingD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(885662377, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton (PurchaseButton.kt:54)");
                    }
                    DisableTouchesComposableKt.DisableTouchesComposable(viewModel.getActionInProgress().getValue().booleanValue(), ComposableLambdaKt.rememberComposableLambda(22366153, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i7) {
                            ComposerKt.sourceInformation(composer2, "C56@2743L297:PurchaseButton.kt#51odh9");
                            if ((i7 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(22366153, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous> (PurchaseButton.kt:56)");
                            }
                            PurchaseButtonKt.m10663PurchaseButtonWHejsw(currentColors, state.getTemplateConfiguration().getPackages(), state.getSelectedPackage(), viewModel, f2, modifier2, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    colors3 = currentColors;
                } else {
                    modifier2 = companion;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                modifier2 = modifier;
            }
            f2 = fM10451getDefaultHorizontalPaddingD9Ej5fM;
            currentColors = colors2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            DisableTouchesComposableKt.DisableTouchesComposable(viewModel.getActionInProgress().getValue().booleanValue(), ComposableLambdaKt.rememberComposableLambda(22366153, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    ComposerKt.sourceInformation(composer2, "C56@2743L297:PurchaseButton.kt#51odh9");
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(22366153, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous> (PurchaseButton.kt:56)");
                    }
                    PurchaseButtonKt.m10663PurchaseButtonWHejsw(currentColors, state.getTemplateConfiguration().getPackages(), state.getSelectedPackage(), viewModel, f2, modifier2, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            colors3 = currentColors;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    PurchaseButtonKt.m10664PurchaseButtonhGBTI10(state, viewModel, modifier3, f2, colors3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchaseButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1498117025);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseButtonPreview)204@8701L87:PurchaseButton.kt#51odh9");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1498117025, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonPreview (PurchaseButton.kt:199)");
            }
            MockViewModel mockViewModel = new MockViewModel(null, TestData.INSTANCE.getTemplate2Offering(), null, true, false, 21, null);
            PaywallState.Loaded.Legacy legacyLoadedLegacyState = mockViewModel.loadedLegacyState();
            if (legacyLoadedLegacyState != null) {
                m10664PurchaseButtonhGBTI10(legacyLoadedLegacyState, mockViewModel, null, 0.0f, null, composerStartRestartGroup, 0, 28);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.PurchaseButtonPreview.1
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
                    PurchaseButtonKt.PurchaseButtonPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float PurchaseButton_WH_ejsw$lambda$6$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long PurchaseButton_WH_ejsw$lambda$6$lambda$1(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    private static final long PurchaseButton_WH_ejsw$lambda$6$lambda$2(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /* JADX INFO: renamed from: buttonBrush-A47ccPs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Brush m10666buttonBrushA47ccPs(long j, Color color, Composer composer, int i) {
        SolidColor solidColor;
        ComposerKt.sourceInformationMarkerStart(composer, -58833710, "C(buttonBrush)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color):PurchaseButton.kt#51odh9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-58833710, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.buttonBrush (PurchaseButton.kt:170)");
        }
        if (color != null) {
            solidColor = Brush.Companion.m6280verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m6315boximpl(j), Color.m6315boximpl(color.m6335unboximpl())}), 0.0f, 0.0f, 0, 14, (Object) null);
            if (solidColor == null) {
                solidColor = new SolidColor(j, null);
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return solidColor;
    }
}
