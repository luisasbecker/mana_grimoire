package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TierSwitcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\\\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"SelectedTierView", "", "selectedTier", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;", "backgroundSelectedColor", "Landroidx/compose/ui/graphics/Color;", "foregroundSelectedColor", "SelectedTierView-1wkBAMs", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;JJLandroidx/compose/runtime/Composer;I)V", "TierSwitcher", "tiers", "", "onTierSelected", "Lkotlin/Function1;", "backgroundColor", "foregroundColor", "TierSwitcher-UFBoNtE", "(Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;Lkotlin/jvm/functions/Function1;JJJJLandroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release", "totalWidthPx", "", "totalHeightRowDp", "Landroidx/compose/ui/unit/Dp;", "backgroundColorState", "backgroundSelectedColorState", "foregroundColorState", "foregroundSelectedColorState", "indicatorOffset"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TierSwitcherKt {
    /* JADX INFO: renamed from: SelectedTierView-1wkBAMs, reason: not valid java name */
    public static final void m10678SelectedTierView1wkBAMs(final TemplateConfiguration.TierInfo selectedTier, final long j, final long j2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(selectedTier, "selectedTier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-474734628);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectedTierView)P(2,0:c#ui.graphics.Color,1:c#ui.graphics.Color)53@2184L566:TierSwitcher.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(selectedTier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-474734628, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SelectedTierView (TierSwitcher.kt:52)");
            }
            Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(BackgroundKt.m1482backgroundbw27NRU(Modifier.INSTANCE, j, RoundedCornerShapeKt.RoundedCornerShape(50)), TierSwitcherUIConstants.INSTANCE.m10684getTierHorizontalPaddingD9Ej5fM(), TierSwitcherUIConstants.INSTANCE.m10687getTierVerticalPaddingD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689999210, "C67@2712L10,64@2589L155:TierSwitcher.kt#51odh9");
            composer2 = composerStartRestartGroup;
            TextKt.m4286Text4IGK_g(selectedTier.getName(), (Modifier) null, j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composer2, i2 & 896, 0, 65530);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$SelectedTierView$2
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
                    TierSwitcherKt.m10678SelectedTierView1wkBAMs(selectedTier, j, j2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: TierSwitcher-UFBoNtE, reason: not valid java name */
    public static final void m10679TierSwitcherUFBoNtE(final List<TemplateConfiguration.TierInfo> tiers, TemplateConfiguration.TierInfo tierInfo, final Function1<? super TemplateConfiguration.TierInfo, Unit> onTierSelected, final long j, final long j2, final long j3, final long j4, Composer composer, final int i) {
        Composer composer2;
        final TemplateConfiguration.TierInfo selectedTier = tierInfo;
        Intrinsics.checkNotNullParameter(tiers, "tiers");
        Intrinsics.checkNotNullParameter(selectedTier, "selectedTier");
        Intrinsics.checkNotNullParameter(onTierSelected, "onTierSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(1054819874);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TierSwitcher)P(6,5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)84@3207L30,85@3266L34,87@3370L7,89@3411L158,94@3610L174,99@3817L158,104@4016L174,115@4396L65,110@4196L2503:TierSwitcher.kt#51odh9");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(tiers) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(selectedTier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onTierSelected) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j4) ? 1048576 : 524288;
        }
        if ((i2 & 599187) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1054819874, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcher (TierSwitcher.kt:82)");
            }
            int iIndexOf = tiers.indexOf(tierInfo);
            composerStartRestartGroup.startReplaceGroup(-1638624750);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TierSwitcher.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            int i3 = i2;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue = mutableStateMutableStateOf$default;
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1638622858);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TierSwitcher.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m9112boximpl(Dp.m9114constructorimpl(40.0f)), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Density density = (Density) objConsume;
            State<Color> stateM1353animateColorAsStateeuL9pac = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(j, UIConstant.INSTANCE.getDefaultColorAnimation(), "backgroundColor", null, composerStartRestartGroup, ((i3 >> 9) & 14) | 384, 8);
            State<Color> stateM1353animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(j2, UIConstant.INSTANCE.getDefaultColorAnimation(), "backgroundSelectedColor", null, composerStartRestartGroup, ((i3 >> 12) & 14) | 384, 8);
            State<Color> stateM1353animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(j3, UIConstant.INSTANCE.getDefaultColorAnimation(), "foregroundColor", null, composerStartRestartGroup, ((i3 >> 15) & 14) | 384, 8);
            State<Color> stateM1353animateColorAsStateeuL9pac4 = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(j4, UIConstant.INSTANCE.getDefaultColorAnimation(), "foregroundSelectedColor", null, composerStartRestartGroup, ((i3 >> 18) & 14) | 384, 8);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.RoundedCornerShape(50)), TierSwitcher_UFBoNtE$lambda$7(stateM1353animateColorAsStateeuL9pac), null, 2, null), 0.0f, 1, null);
            composerStartRestartGroup.startReplaceGroup(-1638586667);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TierSwitcher.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function1) new Function1<IntSize, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$TierSwitcher$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                        m10680invokeozmzZPI(intSize.m9289unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m10680invokeozmzZPI(long j5) {
                        TierSwitcherKt.TierSwitcher_UFBoNtE$lambda$3(mutableState, IntSize.m9285getWidthimpl(j5));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierFillMaxWidth$default, (Function1) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1529755018, "C120@4581L84,122@4675L402,136@5276L93,132@5087L1606:TierSwitcher.kt#51odh9");
            float fM9114constructorimpl = Dp.m9114constructorimpl(density.mo1621toDpu2uoSUM(TierSwitcher_UFBoNtE$lambda$2(mutableState) / tiers.size()) * iIndexOf);
            String str = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            float f = 0.0f;
            String str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
            State<Dp> stateM1380animateDpAsStateAjpBEmI = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(fM9114constructorimpl, null, "tier_switcher", null, composerStartRestartGroup, 384, 10);
            Composer composer3 = composerStartRestartGroup;
            BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m2037padding3ABfNKs(SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth(OffsetKt.m1997offsetVpY3zN4$default(Modifier.INSTANCE, TierSwitcher_UFBoNtE$lambda$20$lambda$13(stateM1380animateDpAsStateAjpBEmI), 0.0f, 2, null), 1.0f / tiers.size()), TierSwitcher_UFBoNtE$lambda$5(mutableState2)), TierSwitcherUIConstants.INSTANCE.m10683getSelectedTierPaddingD9Ej5fM()), RoundedCornerShapeKt.RoundedCornerShape(50)), TierSwitcher_UFBoNtE$lambda$8(stateM1353animateColorAsStateeuL9pac2), null, 2, null), composer3, 0);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            Modifier.Companion companion = Modifier.INSTANCE;
            composer3.startReplaceGroup(1157748976);
            ComposerKt.sourceInformation(composer3, "CC(remember):TierSwitcher.kt#9igjgp");
            boolean zChanged = composer3.changed(density);
            Object objRememberedValue4 = composer3.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function1) new Function1<IntSize, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$TierSwitcher$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                        m10681invokeozmzZPI(intSize.m9289unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m10681invokeozmzZPI(long j5) {
                        TierSwitcherKt.TierSwitcher_UFBoNtE$lambda$6(mutableState2, density.mo1621toDpu2uoSUM(IntSize.m9284getHeightimpl(j5)));
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            }
            composer3.endReplaceGroup();
            Modifier modifierM2071heightInVpY3zN4$default = SizeKt.m2071heightInVpY3zN4$default(IntrinsicKt.height(OnRemeasuredModifierKt.onSizeChanged(companion, (Function1) objRememberedValue4), IntrinsicSize.Max), TierSwitcherUIConstants.INSTANCE.m10682getMinimumHeightD9Ej5fM(), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composer3, 54);
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM2071heightInVpY3zN4$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, str);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -205405893, "C:TierSwitcher.kt#51odh9");
            composer3.startReplaceGroup(686110850);
            ComposerKt.sourceInformation(composer3, "*150@5859L39,151@5926L76,143@5549L1120");
            for (final TemplateConfiguration.TierInfo tierInfo2 : tiers) {
                Alignment center = Alignment.INSTANCE.getCenter();
                RowScopeInstance rowScopeInstance2 = rowScopeInstance;
                Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), f, 1, null);
                composer3.startReplaceGroup(-606775784);
                ComposerKt.sourceInformation(composer3, "CC(remember):TierSwitcher.kt#9igjgp");
                Object objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue5;
                composer3.endReplaceGroup();
                composer3.startReplaceGroup(-606773603);
                ComposerKt.sourceInformation(composer3, "CC(remember):TierSwitcher.kt#9igjgp");
                boolean zChanged2 = ((i3 & 896) == 256) | composer3.changed(tierInfo2);
                Object objRememberedValue6 = composer3.rememberedValue();
                if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$TierSwitcher$2$2$1$2$1
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
                            onTierSelected.invoke(tierInfo2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                composer3.endReplaceGroup();
                Modifier modifierM1514clickableO2vRcR0$default = ClickableKt.m1514clickableO2vRcR0$default(modifierFillMaxHeight$default, mutableInteractionSource, null, false, null, null, (Function0) objRememberedValue6, 28, null);
                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, str2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierM1514clickableO2vRcR0$default);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, str);
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor3);
                } else {
                    composer3.useNode();
                }
                Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer3);
                Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -2081153548, "C157@6138L10,155@6044L607:TierSwitcher.kt#51odh9");
                String str3 = str2;
                Composer composer4 = composer3;
                TextKt.m4286Text4IGK_g(tierInfo2.getName(), PaddingKt.m2038paddingVpY3zN4(Modifier.INSTANCE, TierSwitcherUIConstants.INSTANCE.m10685getTierTextPaddingHorizontalD9Ej5fM(), TierSwitcherUIConstants.INSTANCE.m10686getTierTextPaddingVerticalD9Ej5fM()), Intrinsics.areEqual(tierInfo, tierInfo2) ? TierSwitcher_UFBoNtE$lambda$10(stateM1353animateColorAsStateeuL9pac4) : TierSwitcher_UFBoNtE$lambda$9(stateM1353animateColorAsStateeuL9pac3), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodyMedium(), composer4, 48, 0, 65016);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                str2 = str3;
                rowScopeInstance = rowScopeInstance2;
                str = str;
                composer3 = composer4;
                f = 0.0f;
            }
            selectedTier = tierInfo;
            composer2 = composer3;
            composer2.endReplaceGroup();
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.TierSwitcherKt$TierSwitcher$3
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

                public final void invoke(Composer composer5, int i4) {
                    TierSwitcherKt.m10679TierSwitcherUFBoNtE(tiers, selectedTier, onTierSelected, j, j2, j3, j4, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final long TierSwitcher_UFBoNtE$lambda$10(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    private static final int TierSwitcher_UFBoNtE$lambda$2(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final float TierSwitcher_UFBoNtE$lambda$20$lambda$13(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TierSwitcher_UFBoNtE$lambda$3(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final float TierSwitcher_UFBoNtE$lambda$5(MutableState<Dp> mutableState) {
        return mutableState.getValue().m9128unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TierSwitcher_UFBoNtE$lambda$6(MutableState<Dp> mutableState, float f) {
        mutableState.setValue(Dp.m9112boximpl(f));
    }

    private static final long TierSwitcher_UFBoNtE$lambda$7(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    private static final long TierSwitcher_UFBoNtE$lambda$8(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    private static final long TierSwitcher_UFBoNtE$lambda$9(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }
}
