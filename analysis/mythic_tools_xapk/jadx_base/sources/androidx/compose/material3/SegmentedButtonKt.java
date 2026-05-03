package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SegmentedButton.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u009b\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001c\u001a\u0091\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001d\u001a\u008b\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001e\u001aA\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0016¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b$\u0010%\u001aA\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0016¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b'\u0010%\u001a;\u0010(\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u00101\u001a\u000202X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00103\u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u00104¨\u00065"}, d2 = {"SegmentedButton", "", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "shape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", Constants.ScionAnalytics.PARAM_LABEL, "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SingleChoiceSegmentedButtonRow", "space", "Landroidx/compose/ui/unit/Dp;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/ExtensionFunctionType;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MultiChoiceSegmentedButtonRow", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButtonContent", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "CheckedZIndexFactor", "", "IconSpacing", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    private static final float IconSpacing = Dp.m9114constructorimpl(8.0f);

    /* JADX INFO: renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m4038MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, final Function3<? super MultiChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1844783038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiChoiceSegmentedButtonRow)N(modifier,space:c#ui.unit.Dp,content)368@16414L412:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m4036getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1844783038, i3, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:367)");
            }
            Modifier modifierWidth = IntrinsicKt.width(SizeKt.m2068defaultMinSizeVpY3zN4$default(modifier, 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m5182getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(-f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 714807460, "C376@16739L57,377@16811L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2101268635, "CC(remember):SegmentedButton.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MultiChoiceSegmentedButtonScopeWrapper(rowScopeInstance);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function3.invoke((MultiChoiceSegmentedButtonScopeWrapper) objRememberedValue, composerStartRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
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
        }
        final Modifier modifier2 = modifier;
        final float f2 = f;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.MultiChoiceSegmentedButtonRow_uFdPcIQ$lambda$13(modifier2, f2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit MultiChoiceSegmentedButtonRow_uFdPcIQ$lambda$13(Modifier modifier, float f, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4038MultiChoiceSegmentedButtonRowuFdPcIQ(modifier, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "kept for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void SegmentedButton(final MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope, final boolean z, final Function1 function1, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, final Function2 function22, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function1 function12;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        SegmentedButtonColors segmentedButtonColors2;
        BorderStroke borderStrokeM4033borderStrokel07J4OM$default;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        int i8;
        int i9;
        int i10;
        final Function2 function2RememberComposableLambda;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier3;
        final boolean z4;
        final SegmentedButtonColors segmentedButtonColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SegmentedButtonColors segmentedButtonColorsColors;
        Modifier modifier4;
        int i11;
        SegmentedButtonColors segmentedButtonColors4;
        Composer composerStartRestartGroup = composer.startRestartGroup(2065856961);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButton)N(checked,onCheckedChange,shape,modifier,enabled,colors,border,interactionSource,icon,label)267@12589L377:SegmentedButton.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(multiChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                function12 = function1;
                i4 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
            }
            if ((i3 & 4) == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
                }
                i5 = i3 & 8;
                if (i5 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        modifier2 = modifier;
                        i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                    }
                    i6 = i3 & 16;
                    if (i6 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((196608 & i) == 0) {
                            z3 = z2;
                            i4 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i3 & 32) == 0) {
                                segmentedButtonColors2 = segmentedButtonColors;
                                int i12 = composerStartRestartGroup.changed(segmentedButtonColors2) ? 1048576 : 524288;
                                i4 |= i12;
                            } else {
                                segmentedButtonColors2 = segmentedButtonColors;
                            }
                            i4 |= i12;
                        } else {
                            segmentedButtonColors2 = segmentedButtonColors;
                        }
                        if ((i & 12582912) == 0) {
                            borderStrokeM4033borderStrokel07J4OM$default = borderStroke;
                            i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(borderStrokeM4033borderStrokel07J4OM$default)) ? 8388608 : 4194304;
                        } else {
                            borderStrokeM4033borderStrokel07J4OM$default = borderStroke;
                        }
                        i7 = i3 & 128;
                        if (i7 != 0) {
                            i4 |= 100663296;
                            mutableInteractionSource2 = mutableInteractionSource;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if ((i & 100663296) == 0) {
                                i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                            }
                        }
                        i8 = i3 & 256;
                        if (i8 == 0) {
                            if ((i & 805306368) == 0) {
                                i9 = i8;
                                i4 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            }
                            if ((i3 & 512) == 0) {
                                i10 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i10 = i2 | (composerStartRestartGroup.changedInstance(function22) ? 4 : 2);
                            } else {
                                i10 = i2;
                            }
                            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                function2RememberComposableLambda = function2;
                                borderStroke2 = borderStrokeM4033borderStrokel07J4OM$default;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier3 = modifier2;
                                z4 = z3;
                                segmentedButtonColors3 = segmentedButtonColors2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "260@12290L8,264@12503L41");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                    if (i6 != 0) {
                                        z3 = true;
                                    }
                                    if ((i3 & 32) != 0) {
                                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                        i4 &= -3670017;
                                    } else {
                                        segmentedButtonColorsColors = segmentedButtonColors2;
                                    }
                                    if ((i3 & 64) != 0) {
                                        borderStrokeM4033borderStrokel07J4OM$default = SegmentedButtonDefaults.m4033borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4017borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                                        i4 = (-29360129) & i4;
                                    }
                                    MutableInteractionSource mutableInteractionSource4 = i7 != 0 ? null : mutableInteractionSource2;
                                    if (i9 != 0) {
                                        mutableInteractionSource3 = mutableInteractionSource4;
                                        segmentedButtonColors4 = segmentedButtonColorsColors;
                                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.8
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                invoke(composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i13) {
                                                ComposerKt.sourceInformation(composer2, "C264@12529L13:SegmentedButton.kt#uh7d8r");
                                                if (!composer2.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1867102712, i13, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:264)");
                                                }
                                                SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer2, 3072, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                        modifier4 = companion;
                                        i11 = i4;
                                    } else {
                                        modifier4 = companion;
                                        mutableInteractionSource3 = mutableInteractionSource4;
                                        i11 = i4;
                                        segmentedButtonColors4 = segmentedButtonColorsColors;
                                        function2RememberComposableLambda = function2;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 32) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 64) != 0) {
                                        i4 &= -29360129;
                                    }
                                    function2RememberComposableLambda = function2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    i11 = i4;
                                    modifier4 = modifier2;
                                    segmentedButtonColors4 = segmentedButtonColors2;
                                }
                                BorderStroke borderStroke3 = borderStrokeM4033borderStrokel07J4OM$default;
                                boolean z5 = z3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2065856961, i11, i10, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
                                }
                                SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function12, shape, modifier4, z5, segmentedButtonColors4, borderStroke3, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function22, composerStartRestartGroup, ((i11 << 3) & 1879048192) | (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11), ((i11 >> 27) & 14) | ((i10 << 3) & 112), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                borderStroke2 = borderStroke3;
                                segmentedButtonColors3 = segmentedButtonColors4;
                                z4 = z5;
                                modifier3 = modifier4;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SegmentedButtonKt.SegmentedButton$lambda$6(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z4, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function22, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 805306368;
                        i9 = i8;
                        if ((i3 & 512) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z3 = z2;
                    if ((1572864 & i) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i3 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    if ((i3 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                modifier2 = modifier;
                i6 = i3 & 16;
                if (i6 == 0) {
                }
                z3 = z2;
                if ((1572864 & i) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i3 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i5 = i3 & 8;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            z3 = z2;
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i3 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function12 = function1;
        if ((i3 & 4) == 0) {
        }
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        z3 = z2;
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i3 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SegmentedButton(final MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope, final boolean z, final Function1<? super Boolean, Unit> function1, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        SegmentedButtonColors segmentedButtonColorsColors;
        BorderStroke borderStrokeM4033borderStrokel07J4OM$default;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z4;
        final SegmentedButtonColors segmentedButtonColors2;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SegmentedButtonColors segmentedButtonColors3;
        BorderStroke borderStroke3;
        final PaddingValues paddingValues3;
        MutableInteractionSource mutableInteractionSource3;
        int i14;
        final Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(697872538);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButton)N(checked,onCheckedChange,shape,modifier,enabled,colors,border,contentPadding,interactionSource,icon,label)147@7453L25,166@8056L101,149@7484L673:SegmentedButton.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(multiChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
            }
            if ((i3 & 4) == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
                }
                i5 = i3 & 8;
                if (i5 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        modifier2 = modifier;
                        i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                    }
                    i6 = i3 & 16;
                    if (i6 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        z3 = z2;
                    } else {
                        z3 = z2;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                        }
                    }
                    if ((i & 1572864) != 0) {
                        segmentedButtonColorsColors = segmentedButtonColors;
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(segmentedButtonColorsColors)) ? 1048576 : 524288;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors;
                    }
                    if ((i & 12582912) != 0) {
                        borderStrokeM4033borderStrokel07J4OM$default = borderStroke;
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(borderStrokeM4033borderStrokel07J4OM$default)) ? 8388608 : 4194304;
                    } else {
                        borderStrokeM4033borderStrokel07J4OM$default = borderStroke;
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= composerStartRestartGroup.changed(paddingValues) ? 67108864 : 33554432;
                    }
                    i8 = i3 & 256;
                    if (i8 != 0) {
                        if ((i & 805306368) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                        }
                        i10 = i3 & 512;
                        if (i10 != 0) {
                            i12 = i2 | 6;
                            i11 = i10;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        if ((i3 & 1024) != 0) {
                            i12 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i12 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
                        }
                        i13 = i12;
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "135@6790L8,140@7079L41");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i6 != 0) {
                                    z3 = true;
                                }
                                if ((i3 & 32) != 0) {
                                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i4 &= -3670017;
                                }
                                if ((i3 & 64) != 0) {
                                    borderStrokeM4033borderStrokel07J4OM$default = SegmentedButtonDefaults.m4033borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4017borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                                    i4 &= -29360129;
                                }
                                PaddingValues contentPadding = i7 != 0 ? SegmentedButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                MutableInteractionSource mutableInteractionSource5 = i9 != 0 ? null : mutableInteractionSource;
                                if (i11 != 0) {
                                    modifier2 = companion;
                                    segmentedButtonColors3 = segmentedButtonColorsColors;
                                    borderStroke3 = borderStrokeM4033borderStrokel07J4OM$default;
                                    mutableInteractionSource3 = mutableInteractionSource5;
                                    i14 = i4;
                                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1181873313, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i15) {
                                            ComposerKt.sourceInformation(composer3, "C140@7105L13:SegmentedButton.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i15 & 3) != 2, i15 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1181873313, i15, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:140)");
                                            }
                                            SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer3, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54);
                                    paddingValues3 = contentPadding;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(697872538, i14, i13, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:142)");
                                    }
                                    if (mutableInteractionSource3 != null) {
                                        composerStartRestartGroup.startReplaceGroup(-1615180959);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "144@7242L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 640634049, "CC(remember):SegmentedButton.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(640633398);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    int i15 = i14;
                                    Modifier modifier4 = modifier2;
                                    int i16 = ((i15 >> 3) & 126) | ((i15 >> 6) & 7168) | ((i15 << 3) & 57344) | (1879048192 & (i15 << 6));
                                    Function2<? super Composer, ? super Integer, Unit> function24 = function2RememberComposableLambda;
                                    boolean z5 = z3;
                                    SegmentedButtonColors segmentedButtonColors4 = segmentedButtonColors3;
                                    PaddingValues paddingValues4 = paddingValues3;
                                    composer2 = composerStartRestartGroup;
                                    SurfaceKt.m4147Surfaced85dljk(z, function1, SizeKt.m2067defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier4, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource4, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m3349getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m3348getMinHeightD9Ej5fM()), z5, shape, segmentedButtonColors3.m4018containerColorWaAFU9c$material3(z3, z), segmentedButtonColors3.m4019contentColorWaAFU9c$material3(z3, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(1717860164, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.2
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i17) {
                                            ComposerKt.sourceInformation(composer3, "C167@8066L85:SegmentedButton.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i17 & 3) != 2, i17 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1717860164, i17, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:167)");
                                            }
                                            SegmentedButtonKt.SegmentedButtonContent(function2RememberComposableLambda, function22, paddingValues3, composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54), composer2, i16, 48, 384);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    segmentedButtonColors2 = segmentedButtonColors4;
                                    paddingValues2 = paddingValues4;
                                    z4 = z5;
                                    borderStroke2 = borderStroke3;
                                    modifier3 = modifier4;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    function23 = function24;
                                } else {
                                    modifier2 = companion;
                                    segmentedButtonColors3 = segmentedButtonColorsColors;
                                    borderStroke3 = borderStrokeM4033borderStrokel07J4OM$default;
                                    paddingValues3 = contentPadding;
                                    mutableInteractionSource3 = mutableInteractionSource5;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 32) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -29360129;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                segmentedButtonColors3 = segmentedButtonColorsColors;
                                borderStroke3 = borderStrokeM4033borderStrokel07J4OM$default;
                                paddingValues3 = paddingValues;
                            }
                            i14 = i4;
                            function2RememberComposableLambda = function2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (mutableInteractionSource3 != null) {
                            }
                            int i152 = i14;
                            Modifier modifier42 = modifier2;
                            int i162 = ((i152 >> 3) & 126) | ((i152 >> 6) & 7168) | ((i152 << 3) & 57344) | (1879048192 & (i152 << 6));
                            Function2<? super Composer, ? super Integer, Unit> function242 = function2RememberComposableLambda;
                            boolean z52 = z3;
                            SegmentedButtonColors segmentedButtonColors42 = segmentedButtonColors3;
                            PaddingValues paddingValues42 = paddingValues3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m4147Surfaced85dljk(z, function1, SizeKt.m2067defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(multiChoiceSegmentedButtonRowScope, modifier42, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource4, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m3349getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m3348getMinHeightD9Ej5fM()), z52, shape, segmentedButtonColors3.m4018containerColorWaAFU9c$material3(z3, z), segmentedButtonColors3.m4019contentColorWaAFU9c$material3(z3, z), 0.0f, 0.0f, borderStroke3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(1717860164, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i17) {
                                    ComposerKt.sourceInformation(composer3, "C167@8066L85:SegmentedButton.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i17 & 3) != 2, i17 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1717860164, i17, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:167)");
                                    }
                                    SegmentedButtonKt.SegmentedButtonContent(function2RememberComposableLambda, function22, paddingValues3, composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composer2, i162, 48, 384);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            segmentedButtonColors2 = segmentedButtonColors42;
                            paddingValues2 = paddingValues42;
                            z4 = z52;
                            borderStroke2 = borderStroke3;
                            modifier3 = modifier42;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            function23 = function242;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            z4 = z3;
                            segmentedButtonColors2 = segmentedButtonColorsColors;
                            borderStroke2 = borderStrokeM4033borderStrokel07J4OM$default;
                            modifier3 = modifier2;
                            paddingValues2 = paddingValues;
                            function23 = function2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$1(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier3, z4, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function23, function22, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 805306368;
                    i9 = i8;
                    i10 = i3 & 512;
                    if (i10 != 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    i13 = i12;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                modifier2 = modifier;
                i6 = i3 & 16;
                if (i6 == 0) {
                }
                if ((i & 1572864) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i3 & 512;
                if (i10 != 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                i13 = i12;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i5 = i3 & 8;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            if ((i & 1572864) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3 & 512;
            if (i10 != 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            i13 = i12;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3 & 512;
        if (i10 != 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        i13 = i12;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "kept for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void SegmentedButton(final SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, final boolean z, final Function0 function0, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, final Function2 function22, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0 function02;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        SegmentedButtonColors segmentedButtonColors2;
        BorderStroke borderStrokeM4033borderStrokel07J4OM$default;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        int i8;
        int i9;
        int i10;
        final Function2 function2RememberComposableLambda;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier3;
        final boolean z4;
        final SegmentedButtonColors segmentedButtonColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SegmentedButtonColors segmentedButtonColorsColors;
        Modifier modifier4;
        int i11;
        SegmentedButtonColors segmentedButtonColors4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1723786701);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButton)N(selected,onClick,shape,modifier,enabled,colors,border,interactionSource,icon,label)297@13618L363:SegmentedButton.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(singleChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                function02 = function0;
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
            }
            if ((i3 & 4) == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
                }
                i5 = i3 & 8;
                if (i5 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        modifier2 = modifier;
                        i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                    }
                    i6 = i3 & 16;
                    if (i6 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((196608 & i) == 0) {
                            z3 = z2;
                            i4 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i3 & 32) == 0) {
                                segmentedButtonColors2 = segmentedButtonColors;
                                int i12 = composerStartRestartGroup.changed(segmentedButtonColors2) ? 1048576 : 524288;
                                i4 |= i12;
                            } else {
                                segmentedButtonColors2 = segmentedButtonColors;
                            }
                            i4 |= i12;
                        } else {
                            segmentedButtonColors2 = segmentedButtonColors;
                        }
                        if ((i & 12582912) == 0) {
                            borderStrokeM4033borderStrokel07J4OM$default = borderStroke;
                            i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(borderStrokeM4033borderStrokel07J4OM$default)) ? 8388608 : 4194304;
                        } else {
                            borderStrokeM4033borderStrokel07J4OM$default = borderStroke;
                        }
                        i7 = i3 & 128;
                        if (i7 != 0) {
                            i4 |= 100663296;
                            mutableInteractionSource2 = mutableInteractionSource;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if ((i & 100663296) == 0) {
                                i4 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                            }
                        }
                        i8 = i3 & 256;
                        if (i8 == 0) {
                            if ((i & 805306368) == 0) {
                                i9 = i8;
                                i4 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            }
                            if ((i3 & 512) == 0) {
                                i10 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i10 = i2 | (composerStartRestartGroup.changedInstance(function22) ? 4 : 2);
                            } else {
                                i10 = i2;
                            }
                            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                function2RememberComposableLambda = function2;
                                borderStroke2 = borderStrokeM4033borderStrokel07J4OM$default;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier3 = modifier2;
                                z4 = z3;
                                segmentedButtonColors3 = segmentedButtonColors2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "290@13317L8,294@13531L42");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                    if (i6 != 0) {
                                        z3 = true;
                                    }
                                    if ((i3 & 32) != 0) {
                                        segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                        i4 &= -3670017;
                                    } else {
                                        segmentedButtonColorsColors = segmentedButtonColors2;
                                    }
                                    if ((i3 & 64) != 0) {
                                        borderStrokeM4033borderStrokel07J4OM$default = SegmentedButtonDefaults.m4033borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4017borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                                        i4 = (-29360129) & i4;
                                    }
                                    MutableInteractionSource mutableInteractionSource4 = i7 != 0 ? null : mutableInteractionSource2;
                                    if (i9 != 0) {
                                        mutableInteractionSource3 = mutableInteractionSource4;
                                        segmentedButtonColors4 = segmentedButtonColorsColors;
                                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(61121126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.10
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                invoke(composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i13) {
                                                ComposerKt.sourceInformation(composer2, "C294@13557L14:SegmentedButton.kt#uh7d8r");
                                                if (!composer2.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(61121126, i13, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:294)");
                                                }
                                                SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer2, 3072, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composerStartRestartGroup, 54);
                                        modifier4 = companion;
                                        i11 = i4;
                                    } else {
                                        modifier4 = companion;
                                        mutableInteractionSource3 = mutableInteractionSource4;
                                        i11 = i4;
                                        segmentedButtonColors4 = segmentedButtonColorsColors;
                                        function2RememberComposableLambda = function2;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 32) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 64) != 0) {
                                        i4 &= -29360129;
                                    }
                                    function2RememberComposableLambda = function2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    i11 = i4;
                                    modifier4 = modifier2;
                                    segmentedButtonColors4 = segmentedButtonColors2;
                                }
                                BorderStroke borderStroke3 = borderStrokeM4033borderStrokel07J4OM$default;
                                boolean z5 = z3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1723786701, i11, i10, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
                                }
                                SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function02, shape, modifier4, z5, segmentedButtonColors4, borderStroke3, SegmentedButtonDefaults.INSTANCE.getContentPadding(), mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) function2RememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) function22, composerStartRestartGroup, ((i11 << 3) & 1879048192) | (i11 & 14) | 100663296 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11), ((i11 >> 27) & 14) | ((i10 << 3) & 112), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                borderStroke2 = borderStroke3;
                                segmentedButtonColors3 = segmentedButtonColors4;
                                z4 = z5;
                                modifier3 = modifier4;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SegmentedButtonKt.SegmentedButton$lambda$7(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z4, segmentedButtonColors3, borderStroke2, mutableInteractionSource3, function2RememberComposableLambda, function22, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 805306368;
                        i9 = i8;
                        if ((i3 & 512) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z3 = z2;
                    if ((1572864 & i) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i3 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    if ((i3 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                modifier2 = modifier;
                i6 = i3 & 16;
                if (i6 == 0) {
                }
                z3 = z2;
                if ((1572864 & i) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i3 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i5 = i3 & 8;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            z3 = z2;
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i3 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function02 = function0;
        if ((i3 & 4) == 0) {
        }
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        z3 = z2;
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i3 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SegmentedButton(final SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, final boolean z, final Function0<Unit> function0, final Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        SegmentedButtonColors segmentedButtonColorsColors;
        BorderStroke borderStrokeM4033borderStrokel07J4OM$default;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z4;
        final SegmentedButtonColors segmentedButtonColors2;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SegmentedButtonColors segmentedButtonColors3;
        BorderStroke borderStroke3;
        final PaddingValues paddingValues3;
        MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        int i14;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1532041126);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButton)N(selected,onClick,shape,modifier,enabled,colors,border,contentPadding,interactionSource,icon,label)227@11214L25,238@11577L27,247@11859L67,229@11245L681:SegmentedButton.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(singleChoiceSegmentedButtonRowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
            }
            if ((i3 & 4) == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
                }
                i5 = i3 & 8;
                if (i5 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        modifier2 = modifier;
                        i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                    }
                    i6 = i3 & 16;
                    if (i6 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        z3 = z2;
                    } else {
                        z3 = z2;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                        }
                    }
                    if ((i & 1572864) != 0) {
                        segmentedButtonColorsColors = segmentedButtonColors;
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(segmentedButtonColorsColors)) ? 1048576 : 524288;
                    } else {
                        segmentedButtonColorsColors = segmentedButtonColors;
                    }
                    if ((i & 12582912) != 0) {
                        borderStrokeM4033borderStrokel07J4OM$default = borderStroke;
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(borderStrokeM4033borderStrokel07J4OM$default)) ? 8388608 : 4194304;
                    } else {
                        borderStrokeM4033borderStrokel07J4OM$default = borderStroke;
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= composerStartRestartGroup.changed(paddingValues) ? 67108864 : 33554432;
                    }
                    i8 = i3 & 256;
                    if (i8 != 0) {
                        if ((i & 805306368) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                        }
                        i10 = i3 & 512;
                        if (i10 != 0) {
                            i12 = i2 | 6;
                            i11 = i10;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        if ((i3 & 1024) != 0) {
                            i12 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i12 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
                        }
                        i13 = i12;
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "215@10547L8,220@10837L42");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i6 != 0) {
                                    z3 = true;
                                }
                                if ((i3 & 32) != 0) {
                                    segmentedButtonColorsColors = SegmentedButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i4 &= -3670017;
                                }
                                if ((i3 & 64) != 0) {
                                    borderStrokeM4033borderStrokel07J4OM$default = SegmentedButtonDefaults.m4033borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, segmentedButtonColorsColors.m4017borderColorWaAFU9c$material3(z3, z), 0.0f, 2, null);
                                    i4 &= -29360129;
                                }
                                PaddingValues contentPadding = i7 != 0 ? SegmentedButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                MutableInteractionSource mutableInteractionSource5 = i9 != 0 ? null : mutableInteractionSource;
                                if (i11 != 0) {
                                    Modifier modifier4 = companion;
                                    int i15 = i4;
                                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.4
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i16) {
                                            ComposerKt.sourceInformation(composer3, "C220@10863L14:SegmentedButton.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-643804033, i16, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:220)");
                                            }
                                            SegmentedButtonDefaults.INSTANCE.Icon(z, null, null, composer3, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54);
                                    segmentedButtonColors3 = segmentedButtonColorsColors;
                                    i14 = i15;
                                    modifier2 = modifier4;
                                    borderStroke3 = borderStrokeM4033borderStrokel07J4OM$default;
                                    paddingValues3 = contentPadding;
                                    mutableInteractionSource3 = mutableInteractionSource5;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1532041126, i14, i13, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:222)");
                                    }
                                    if (mutableInteractionSource3 != null) {
                                        composerStartRestartGroup.startReplaceGroup(-1579561419);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "224@11001L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882237587, "CC(remember):SegmentedButton.kt#9igjgp");
                                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-882238238);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    long jM4018containerColorWaAFU9c$material3 = segmentedButtonColors3.m4018containerColorWaAFU9c$material3(z3, z);
                                    int i16 = i14;
                                    long jM4019contentColorWaAFU9c$material3 = segmentedButtonColors3.m4019contentColorWaAFU9c$material3(z3, z);
                                    SegmentedButtonColors segmentedButtonColors4 = segmentedButtonColors3;
                                    Modifier modifier5 = modifier2;
                                    Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier5, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource4, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m3349getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m3348getMinHeightD9Ej5fM());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882219167, "CC(remember):SegmentedButton.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return SegmentedButtonKt.SegmentedButton$lambda$4$lambda$3((SemanticsPropertyReceiver) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Function2<? super Composer, ? super Integer, Unit> function24 = function2RememberComposableLambda;
                                    boolean z5 = z3;
                                    PaddingValues paddingValues4 = paddingValues3;
                                    composer2 = composerStartRestartGroup;
                                    SurfaceKt.m4146Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(modifierM2067defaultMinSizeVpY3zN4, false, (Function1) objRememberedValue, 1, null), z5, shape, jM4018containerColorWaAFU9c$material3, jM4019contentColorWaAFU9c$material3, 0.0f, 0.0f, borderStroke3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1208080836, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.6
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i17) {
                                            ComposerKt.sourceInformation(composer3, "C248@11869L51:SegmentedButton.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i17 & 3) != 2, i17 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1208080836, i17, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:248)");
                                            }
                                            SegmentedButtonKt.SegmentedButtonContent(function2RememberComposableLambda, function22, paddingValues3, composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54), composer2, ((i16 >> 3) & 126) | ((i16 >> 6) & 7168) | ((i16 << 3) & 57344) | (1879048192 & (i16 << 6)), 48, 384);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    segmentedButtonColors2 = segmentedButtonColors4;
                                    z4 = z5;
                                    borderStroke2 = borderStroke3;
                                    modifier3 = modifier5;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    function23 = function24;
                                    paddingValues2 = paddingValues4;
                                } else {
                                    modifier2 = companion;
                                    segmentedButtonColors3 = segmentedButtonColorsColors;
                                    borderStroke3 = borderStrokeM4033borderStrokel07J4OM$default;
                                    paddingValues3 = contentPadding;
                                    mutableInteractionSource3 = mutableInteractionSource5;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 32) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -29360129;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                segmentedButtonColors3 = segmentedButtonColorsColors;
                                borderStroke3 = borderStrokeM4033borderStrokel07J4OM$default;
                                paddingValues3 = paddingValues;
                            }
                            i14 = i4;
                            function2RememberComposableLambda = function2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (mutableInteractionSource3 != null) {
                            }
                            long jM4018containerColorWaAFU9c$material32 = segmentedButtonColors3.m4018containerColorWaAFU9c$material3(z3, z);
                            int i162 = i14;
                            long jM4019contentColorWaAFU9c$material32 = segmentedButtonColors3.m4019contentColorWaAFU9c$material3(z3, z);
                            SegmentedButtonColors segmentedButtonColors42 = segmentedButtonColors3;
                            Modifier modifier52 = modifier2;
                            Modifier modifierM2067defaultMinSizeVpY3zN42 = SizeKt.m2067defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default(singleChoiceSegmentedButtonRowScope, modifier52, 1.0f, false, 2, null), z, interactionCountAsState(mutableInteractionSource4, composerStartRestartGroup, 0)), ButtonDefaults.INSTANCE.m3349getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m3348getMinHeightD9Ej5fM());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -882219167, "CC(remember):SegmentedButton.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Function2<? super Composer, ? super Integer, Unit> function242 = function2RememberComposableLambda;
                            boolean z52 = z3;
                            PaddingValues paddingValues42 = paddingValues3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m4146Surfaced85dljk(z, function0, SemanticsModifierKt.semantics$default(modifierM2067defaultMinSizeVpY3zN42, false, (Function1) objRememberedValue, 1, null), z52, shape, jM4018containerColorWaAFU9c$material32, jM4019contentColorWaAFU9c$material32, 0.0f, 0.0f, borderStroke3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1208080836, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i17) {
                                    ComposerKt.sourceInformation(composer3, "C248@11869L51:SegmentedButton.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i17 & 3) != 2, i17 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1208080836, i17, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:248)");
                                    }
                                    SegmentedButtonKt.SegmentedButtonContent(function2RememberComposableLambda, function22, paddingValues3, composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composer2, ((i162 >> 3) & 126) | ((i162 >> 6) & 7168) | ((i162 << 3) & 57344) | (1879048192 & (i162 << 6)), 48, 384);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            segmentedButtonColors2 = segmentedButtonColors42;
                            z4 = z52;
                            borderStroke2 = borderStroke3;
                            modifier3 = modifier52;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            function23 = function242;
                            paddingValues2 = paddingValues42;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            z4 = z3;
                            segmentedButtonColors2 = segmentedButtonColorsColors;
                            borderStroke2 = borderStrokeM4033borderStrokel07J4OM$default;
                            modifier3 = modifier2;
                            paddingValues2 = paddingValues;
                            function23 = function2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SegmentedButtonKt.SegmentedButton$lambda$5(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier3, z4, segmentedButtonColors2, borderStroke2, paddingValues2, mutableInteractionSource2, function23, function22, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 805306368;
                    i9 = i8;
                    i10 = i3 & 512;
                    if (i10 != 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    i13 = i12;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                modifier2 = modifier;
                i6 = i3 & 16;
                if (i6 == 0) {
                }
                if ((i & 1572864) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i3 & 512;
                if (i10 != 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                i13 = i12;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i5 = i3 & 8;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            if ((i & 1572864) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3 & 512;
            if (i10 != 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            i13 = i12;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3 & 512;
        if (i10 != 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        i13 = i12;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit SegmentedButton$lambda$1(MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope, boolean z, Function1 function1, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function2 function2, Function2 function22, int i, int i2, int i3, Composer composer, int i4) {
        SegmentedButton(multiChoiceSegmentedButtonRowScope, z, (Function1<? super Boolean, Unit>) function1, shape, modifier, z2, segmentedButtonColors, borderStroke, paddingValues, mutableInteractionSource, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButton$lambda$4$lambda$3(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8332getRadioButtono7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButton$lambda$5(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, boolean z, Function0 function0, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function2 function2, Function2 function22, int i, int i2, int i3, Composer composer, int i4) {
        SegmentedButton(singleChoiceSegmentedButtonRowScope, z, (Function0<Unit>) function0, shape, modifier, z2, segmentedButtonColors, borderStroke, paddingValues, mutableInteractionSource, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButton$lambda$6(MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope, boolean z, Function1 function1, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, Function2 function22, int i, int i2, int i3, Composer composer, int i4) {
        SegmentedButton(multiChoiceSegmentedButtonRowScope, z, function1, shape, modifier, z2, segmentedButtonColors, borderStroke, mutableInteractionSource, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButton$lambda$7(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, boolean z, Function0 function0, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2 function2, Function2 function22, int i, int i2, int i3, Composer composer, int i4) {
        SegmentedButton(singleChoiceSegmentedButtonRowScope, z, function0, shape, modifier, z2, segmentedButtonColors, borderStroke, mutableInteractionSource, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SegmentedButtonContent(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1069265073);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButtonContent)N(icon,content,contentPadding)387@16992L743:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1069265073, i2, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:386)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, paddingValues);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 314731321, "C388@17149L5,390@17293L12,391@17343L386,391@17314L415:SegmentedButton.kt#uh7d8r");
            TextStyle value = TypographyKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            TextKt.ProvideTextStyle(value, ComposableLambdaKt.rememberComposableLambda(-1372614088, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButtonContent$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C392@17369L24,393@17426L98,397@17538L181:SegmentedButton.kt#uh7d8r");
                    if (!composer2.shouldExecute((i3 & 3) != 2, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1372614088, i3, -1, "androidx.compose.material3.SegmentedButtonContent.<anonymous>.<anonymous> (SegmentedButton.kt:392)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer2, 683737348, "CC(remember):Effects.kt#9igjgp");
                    Object objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -527175942, "CC(remember):SegmentedButton.kt#9igjgp");
                    FiniteAnimationSpec<Integer> finiteAnimationSpec = finiteAnimationSpecValue;
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new SegmentedButtonContentMeasurePolicy(coroutineScope, finiteAnimationSpec);
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    SegmentedButtonContentMeasurePolicy segmentedButtonContentMeasurePolicy = (SegmentedButtonContentMeasurePolicy) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierHeight = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
                    List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function2, function22});
                    ComposerKt.sourceInformationMarkerStart(composer2, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                    ComposerKt.sourceInformationMarkerStart(composer2, -290764973, "CC(remember):Layout.kt#9igjgp");
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(segmentedButtonContentMeasurePolicy);
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierHeight);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                    Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts.invoke(composer2, 0);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SegmentedButtonContent$lambda$15(function2, function22, paddingValues, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SegmentedButtonContent$lambda$15(Function2 function2, Function2 function22, PaddingValues paddingValues, int i, Composer composer, int i2) {
        SegmentedButtonContent(function2, function22, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m4039SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier modifier, float f, final Function3<? super SingleChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(2041406825);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SingleChoiceSegmentedButtonRow)N(modifier,space:c#ui.unit.Dp,content)332@14963L448:SegmentedButton.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                f = SegmentedButtonDefaults.INSTANCE.m4036getBorderWidthD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2041406825, i3, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:331)");
            }
            Modifier modifierWidth = IntrinsicKt.width(SizeKt.m2068defaultMinSizeVpY3zN4$default(SelectableGroupKt.selectableGroup(modifier), 0.0f, OutlinedSegmentedButtonTokens.INSTANCE.m5182getContainerHeightD9Ej5fM(), 1, null), IntrinsicSize.Min);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(-f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1183792256, "C341@15323L58,342@15396L9:SegmentedButton.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 176734527, "CC(remember):SegmentedButton.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SingleChoiceSegmentedButtonScopeWrapper(rowScopeInstance);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function3.invoke((SingleChoiceSegmentedButtonScopeWrapper) objRememberedValue, composerStartRestartGroup, Integer.valueOf(((i3 >> 3) & 112) | 6));
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
        }
        final Modifier modifier2 = modifier;
        final float f2 = f;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonKt.SingleChoiceSegmentedButtonRow_uFdPcIQ$lambda$10(modifier2, f2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SingleChoiceSegmentedButtonRow_uFdPcIQ$lambda$10(Modifier modifier, float f, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4039SingleChoiceSegmentedButtonRowuFdPcIQ(modifier, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final State<Integer> interactionCountAsState(InteractionSource interactionSource, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 281890131, "C(interactionCountAsState)460@19902L33,461@19961L499,461@19940L520:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(281890131, i, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:459)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 313479764, "CC(remember):SegmentedButton.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 313482118, "CC(remember):SegmentedButton.kt#9igjgp");
        int i2 = i & 14;
        boolean z = ((i2 ^ 6) > 4 && composer.changed(interactionSource)) || (i & 6) == 4;
        SegmentedButtonKt$interactionCountAsState$1$1 segmentedButtonKt$interactionCountAsState$1$1RememberedValue = composer.rememberedValue();
        if (z || segmentedButtonKt$interactionCountAsState$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            segmentedButtonKt$interactionCountAsState$1$1RememberedValue = new SegmentedButtonKt$interactionCountAsState$1$1(interactionSource, mutableIntState, null);
            composer.updateRememberedValue(segmentedButtonKt$interactionCountAsState$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) segmentedButtonKt$interactionCountAsState$1$1RememberedValue, composer, i2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableIntState;
    }

    private static final Modifier interactionZIndex(Modifier modifier, final boolean z, final State<Integer> state) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SegmentedButtonKt.interactionZIndex$lambda$19(state, z, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    static final MeasureResult interactionZIndex$lambda$19(final State state, final boolean z, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.SegmentedButtonKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SegmentedButtonKt.interactionZIndex$lambda$19$lambda$18(state, z, placeableMo7769measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit interactionZIndex$lambda$19$lambda$18(State state, boolean z, Placeable placeable, Placeable.PlacementScope placementScope) {
        placementScope.place(placeable, 0, 0, ((Number) state.getValue()).floatValue() + (z ? CheckedZIndexFactor : 0.0f));
        return Unit.INSTANCE;
    }
}
