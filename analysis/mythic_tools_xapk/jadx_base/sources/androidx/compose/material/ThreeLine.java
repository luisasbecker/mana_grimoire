package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J|\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00172\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001cR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ThreeLine;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "F", "IconMinPaddedWidth", "IconLeftPadding", "IconThreeLineVerticalPadding", "ContentLeftPadding", "ContentRightPadding", "ThreeLineBaselineFirstOffset", "ThreeLineBaselineSecondOffset", "ThreeLineBaselineThirdOffset", "ThreeLineTrailingTopPadding", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ThreeLine {
    public static final ThreeLine INSTANCE = new ThreeLine();
    private static final float MinHeight = Dp.m9114constructorimpl(88.0f);
    private static final float IconMinPaddedWidth = Dp.m9114constructorimpl(40.0f);
    private static final float IconLeftPadding = Dp.m9114constructorimpl(16.0f);
    private static final float IconThreeLineVerticalPadding = Dp.m9114constructorimpl(16.0f);
    private static final float ContentLeftPadding = Dp.m9114constructorimpl(16.0f);
    private static final float ContentRightPadding = Dp.m9114constructorimpl(16.0f);
    private static final float ThreeLineBaselineFirstOffset = Dp.m9114constructorimpl(28.0f);
    private static final float ThreeLineBaselineSecondOffset = Dp.m9114constructorimpl(20.0f);
    private static final float ThreeLineBaselineThirdOffset = Dp.m9114constructorimpl(20.0f);
    private static final float ThreeLineTrailingTopPadding = Dp.m9114constructorimpl(16.0f);
    private static final float TrailingRightPadding = Dp.m9114constructorimpl(16.0f);

    private ThreeLine() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListItem$lambda$0$1(Function2 function2, Function2 function22, Function2 function23, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C339@12443L6,340@12466L15:ListItem.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-595668326, i, -1, "androidx.compose.material.ThreeLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:338)");
            }
            if (function2 != null) {
                composer.startReplaceGroup(-1206609496);
                ComposerKt.sourceInformation(composer, "338@12412L14");
                function2.invoke(composer, 0);
            } else {
                composer.startReplaceGroup(1237497160);
            }
            composer.endReplaceGroup();
            function22.invoke(composer, 0);
            function23.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit ListItem$lambda$1(ThreeLine threeLine, Modifier modifier, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, int i, int i2, Composer composer, int i3) {
        threeLine.ListItem(modifier, function2, function22, function23, function24, function25, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public final void ListItem(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier.Companion companion;
        Composer composerStartRestartGroup = composer.startRestartGroup(1651890924);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ListItem)N(modifier,icon,text,secondaryText,overlineText,trailing)315@11400L1426:ListItem.kt#jmzs0o");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function25) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 1048576 : 524288;
        }
        int i5 = i3;
        if (composerStartRestartGroup.shouldExecute((599187 & i5) != 599186, i5 & 1)) {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1651890924, i5, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:314)");
            }
            Modifier modifierM2071heightInVpY3zN4$default = SizeKt.m2071heightInVpY3zN4$default(companion, MinHeight, 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2071heightInVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2022193121, "C337@12368L127,330@12037L458:ListItem.kt#jmzs0o");
            if (function2 != null) {
                composerStartRestartGroup.startReplaceGroup(2022185866);
                ComposerKt.sourceInformation(composerStartRestartGroup, "318@11557L453");
                float f = IconLeftPadding;
                float fM9114constructorimpl = Dp.m9114constructorimpl(f + IconMinPaddedWidth);
                Modifier modifierM2087sizeInqDBjuR0$default = SizeKt.m2087sizeInqDBjuR0$default(Modifier.INSTANCE, fM9114constructorimpl, fM9114constructorimpl, 0.0f, 0.0f, 12, null);
                float f2 = IconThreeLineVerticalPadding;
                Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(modifierM2087sizeInqDBjuR0$default, f, f2, 0.0f, f2, 4, null);
                Alignment centerStart = Alignment.INSTANCE.getCenterStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 253322476, "C327@11986L6:ListItem.kt#jmzs0o");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(2010787538);
            }
            composerStartRestartGroup.endReplaceGroup();
            float f3 = ThreeLineBaselineFirstOffset;
            ListItemKt.BaselinesOffsetColumn(CollectionsKt.listOf((Object[]) new Dp[]{Dp.m9112boximpl(f3), Dp.m9112boximpl(ThreeLineBaselineSecondOffset), Dp.m9112boximpl(ThreeLineBaselineThirdOffset)}), PaddingKt.m2041paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, null), ComposableLambdaKt.rememberComposableLambda(-595668326, true, new Function2() { // from class: androidx.compose.material.ThreeLine$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThreeLine.ListItem$lambda$0$1(function24, function22, function23, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (function25 != null) {
                composerStartRestartGroup.startReplaceGroup(2023227156);
                ComposerKt.sourceInformation(composerStartRestartGroup, "343@12548L254");
                float f4 = ThreeLineTrailingTopPadding;
                ListItemKt.m3069OffsetToBaselineOrCenterKz89ssw(Dp.m9114constructorimpl(f3 - f4), PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, f4, TrailingRightPadding, 0.0f, 9, null), function25, composerStartRestartGroup, ((i5 >> 9) & 896) | 54, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(2010787538);
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
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ThreeLine$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThreeLine.ListItem$lambda$1(this.f$0, companion, function2, function22, function23, function24, function25, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
