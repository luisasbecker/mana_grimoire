package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimePickerDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a·\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u009f\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001aQ\u0010\u001a\u001a\u00020\u00012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"TimePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", Constants.GP_IAP_TITLE, "modifier", "Landroidx/compose/ui/Modifier;", DiagnosticsEntry.PROPERTIES_KEY, "Landroidx/compose/ui/window/DialogProperties;", "modeToggleButton", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "TimePickerDialog-FItCLgY", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TimePickerDialogLayout", "TimePickerDialogLayout-3csKH6Y", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TimePickerCustomLayout", "actions", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimePickerDialogKt {
    public static final void TimePickerCustomLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-493479138);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimePickerCustomLayout)N(title,actions,content)132@5459L238,138@5723L4285,234@10014L56:TimePickerDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-493479138, i2, -1, "androidx.compose.material3.TimePickerCustomLayout (TimePickerDialog.kt:130)");
            }
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(468305759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerDialogKt$TimePickerCustomLayout$content$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C133@5473L54,134@5540L58,135@5611L76:TimePickerDialog.kt#uh7d8r");
                    if (!composer2.shouldExecute((i3 & 3) != 2, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(468305759, i3, -1, "androidx.compose.material3.TimePickerCustomLayout.<anonymous> (TimePickerDialog.kt:133)");
                    }
                    Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, Constants.GP_IAP_TITLE);
                    Function2<Composer, Integer, Unit> function23 = function2;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierLayoutId);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1033675543, "C133@5518L7:TimePickerDialog.kt#uh7d8r");
                    function23.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "actions");
                    Function2<Composer, Integer, Unit> function24 = function22;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierLayoutId2);
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
                    Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1586475714, "C134@5587L9:TimePickerDialog.kt#uh7d8r");
                    function24.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierLayoutId3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "timePickerContent");
                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierLayoutId3);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1787029541, "CC(remember):TimePickerDialog.kt#9igjgp");
            TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1 timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue = TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            composableLambdaRememberComposableLambda.invoke(composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogKt.TimePickerCustomLayout$lambda$3(function2, function22, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TimePickerCustomLayout$lambda$3(Function2 function2, Function2 function22, Function3 function3, int i, Composer composer, int i2) {
        TimePickerCustomLayout(function2, function22, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0112  */
    /* JADX INFO: renamed from: TimePickerDialog-FItCLgY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4317TimePickerDialogFItCLgY(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, DialogProperties dialogProperties, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long j, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i4;
        Modifier modifier2;
        int i5;
        DialogProperties dialogProperties2;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i8;
        int i9;
        Composer composer2;
        final Modifier modifier3;
        final DialogProperties dialogProperties3;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Shape shape2;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape shape3;
        final long containerColor;
        final Shape shape4;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        int i10;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        Composer composerStartRestartGroup = composer.startRestartGroup(951250327);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimePickerDialog)N(onDismissRequest,confirmButton,title,modifier,properties,modeToggleButton,dismissButton,shape,containerColor:c#ui.graphics.Color,content)80@3861L347,80@3792L416:TimePickerDialog.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function25 = function2;
        } else {
            function25 = function2;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function25) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                function26 = function22;
                i3 |= composerStartRestartGroup.changedInstance(function26) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        dialogProperties2 = dialogProperties;
                        i3 |= composerStartRestartGroup.changed(dialogProperties2) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else {
                        if ((196608 & i) == 0) {
                            function27 = function23;
                            i3 |= composerStartRestartGroup.changedInstance(function27) ? 131072 : 65536;
                        }
                        i7 = i2 & 64;
                        if (i7 == 0) {
                            if ((1572864 & i) == 0) {
                                function28 = function24;
                                i3 |= composerStartRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                            }
                            if ((i & 12582912) == 0) {
                                i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(shape)) ? 8388608 : 4194304;
                            }
                            if ((i & 100663296) != 0) {
                                i8 = i3 | (((i2 & 256) == 0 && composerStartRestartGroup.changed(j)) ? 67108864 : 33554432);
                            } else {
                                i8 = i3;
                            }
                            int i11 = i8;
                            if ((i2 & 512) == 0) {
                                i9 = i11 | 805306368;
                            } else if ((i & 805306368) == 0) {
                                i9 = i11 | (composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456);
                            } else {
                                i9 = i11;
                            }
                            if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier3 = modifier2;
                                dialogProperties3 = dialogProperties2;
                                function29 = function27;
                                function210 = function28;
                                shape2 = shape;
                                j2 = j;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "76@3659L5,77@3719L14");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    DialogProperties dialogProperties4 = i5 != 0 ? new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null) : dialogProperties2;
                                    if (i6 != 0) {
                                        function27 = null;
                                    }
                                    if (i7 != 0) {
                                        function28 = null;
                                    }
                                    if ((i2 & 128) != 0) {
                                        shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                        i9 &= -29360129;
                                    } else {
                                        shape3 = shape;
                                    }
                                    if ((i2 & 256) != 0) {
                                        i9 &= -234881025;
                                        shape4 = shape3;
                                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    } else {
                                        containerColor = j;
                                        shape4 = shape3;
                                    }
                                    function211 = function27;
                                    i10 = i9;
                                    dialogProperties2 = dialogProperties4;
                                    modifier4 = modifier2;
                                    function212 = function28;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 128) != 0) {
                                        i9 &= -29360129;
                                    }
                                    if ((i2 & 256) != 0) {
                                        i9 &= -234881025;
                                    }
                                    shape4 = shape;
                                    containerColor = j;
                                    function211 = function27;
                                    function212 = function28;
                                    i10 = i9;
                                    modifier4 = modifier2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(951250327, i10, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:79)");
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function213 = function26;
                                AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerDialogKt$TimePickerDialog$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i12) {
                                        ComposerKt.sourceInformation(composer3, "C81@3871L331:TimePickerDialog.kt#uh7d8r");
                                        if (!composer3.shouldExecute((i12 & 3) != 2, i12 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(296331566, i12, -1, "androidx.compose.material3.TimePickerDialog.<anonymous> (TimePickerDialog.kt:81)");
                                        }
                                        TimePickerDialogKt.m4318TimePickerDialogLayout3csKH6Y(function25, function213, modifier4, function211, function212, shape4, containerColor, function3, composer3, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i10 >> 9) & 112) | (i10 & 14) | 384, 0);
                                composer2 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                dialogProperties3 = dialogProperties2;
                                modifier3 = modifier4;
                                function29 = function211;
                                function210 = function212;
                                shape2 = shape4;
                                j2 = containerColor;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function0, function2, function22, modifier3, dialogProperties3, function29, function210, shape2, j2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 1572864;
                        function28 = function24;
                        if ((i & 12582912) == 0) {
                        }
                        if ((i & 100663296) != 0) {
                        }
                        int i112 = i8;
                        if ((i2 & 512) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    function27 = function23;
                    i7 = i2 & 64;
                    if (i7 == 0) {
                    }
                    function28 = function24;
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) != 0) {
                    }
                    int i1122 = i8;
                    if ((i2 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                dialogProperties2 = dialogProperties;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                function27 = function23;
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                function28 = function24;
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) != 0) {
                }
                int i11222 = i8;
                if ((i2 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            dialogProperties2 = dialogProperties;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            function27 = function23;
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            function28 = function24;
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) != 0) {
            }
            int i112222 = i8;
            if ((i2 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function26 = function22;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        dialogProperties2 = dialogProperties;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        function27 = function23;
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        function28 = function24;
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) != 0) {
        }
        int i1122222 = i8;
        if ((i2 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i9 & 306783379) == 306783378, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX INFO: renamed from: TimePickerDialogLayout-3csKH6Y, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4318TimePickerDialogLayout3csKH6Y(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long j, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Shape shape2;
        long containerColor;
        int i7;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-401873644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimePickerDialogLayout)N(confirmButton,title,modifier,modeToggleButton,dismissButton,shape,containerColor:c#ui.graphics.Color,content)109@4835L408,105@4660L583:TimePickerDialog.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                function25 = function22;
                i3 |= composerStartRestartGroup.changedInstance(function25) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        function26 = function23;
                        i3 |= composerStartRestartGroup.changedInstance(function26) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            function27 = function24;
                            i3 |= composerStartRestartGroup.changedInstance(function27) ? 16384 : 8192;
                        }
                        if ((196608 & i) == 0) {
                            if ((i2 & 32) == 0) {
                                shape2 = shape;
                                int i10 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                                i3 |= i10;
                            } else {
                                shape2 = shape;
                            }
                            i3 |= i10;
                        } else {
                            shape2 = shape;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                containerColor = j;
                                int i11 = composerStartRestartGroup.changed(containerColor) ? 1048576 : 524288;
                                i3 |= i11;
                            } else {
                                containerColor = j;
                            }
                            i3 |= i11;
                        } else {
                            containerColor = j;
                        }
                        if ((i2 & 128) == 0) {
                            if ((i & 12582912) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                            }
                            i7 = i3;
                            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i7 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                function28 = function26;
                                function29 = function27;
                                j2 = containerColor;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "101@4527L5,102@4587L14");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        function26 = null;
                                    }
                                    if (i6 != 0) {
                                        function27 = null;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i8 = i7 & (-458753);
                                        shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    } else {
                                        i8 = i7;
                                    }
                                    if ((i2 & 64) != 0) {
                                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                        i9 = i8 & (-3670017);
                                    } else {
                                        i9 = i8;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    i9 = (i2 & 32) != 0 ? i7 & (-458753) : i7;
                                    if ((i2 & 64) != 0) {
                                        i9 &= -3670017;
                                    }
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:104)");
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
                                final Function2<? super Composer, ? super Integer, Unit> function211 = function25;
                                final Function2<? super Composer, ? super Integer, Unit> function212 = function26;
                                long j3 = containerColor;
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m4145SurfaceT9BRK9s(BackgroundKt.m1482backgroundbw27NRU(modifier2, containerColor, shape2), shape2, 0L, 0L, DialogTokens.INSTANCE.m4917getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerDialogKt$TimePickerDialogLayout$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i12) {
                                        ComposerKt.sourceInformation(composer3, "C112@4918L277,110@4845L392:TimePickerDialog.kt#uh7d8r");
                                        if (!composer3.shouldExecute((i12 & 3) != 2, i12 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1522143641, i12, -1, "androidx.compose.material3.TimePickerDialogLayout.<anonymous> (TimePickerDialog.kt:110)");
                                        }
                                        Function2<Composer, Integer, Unit> function213 = function211;
                                        final Function2<Composer, Integer, Unit> function214 = function212;
                                        final Function2<Composer, Integer, Unit> function215 = function210;
                                        final Function2<Composer, Integer, Unit> function216 = function2;
                                        TimePickerDialogKt.TimePickerCustomLayout(function213, ComposableLambdaKt.rememberComposableLambda(2122920701, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerDialogKt$TimePickerDialogLayout$1.1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i13) {
                                                ComposerKt.sourceInformation(composer4, "C113@4936L245:TimePickerDialog.kt#uh7d8r");
                                                if (!composer4.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2122920701, i13, -1, "androidx.compose.material3.TimePickerDialogLayout.<anonymous>.<anonymous> (TimePickerDialog.kt:113)");
                                                }
                                                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                Function2<Composer, Integer, Unit> function217 = function214;
                                                Function2<Composer, Integer, Unit> function218 = function215;
                                                Function2<Composer, Integer, Unit> function219 = function216;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer4, 0);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default);
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                if (!(composer4.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer4.startReusableNode();
                                                if (composer4.getInserting()) {
                                                    composer4.createNode(constructor);
                                                } else {
                                                    composer4.useNode();
                                                }
                                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer4);
                                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 675820093, "C115@5045L38,117@5148L15:TimePickerDialog.kt#uh7d8r");
                                                if (function217 == null) {
                                                    composer4.startReplaceGroup(675833080);
                                                } else {
                                                    composer4.startReplaceGroup(2100011049);
                                                    ComposerKt.sourceInformation(composer4, "114@5016L8");
                                                    function217.invoke(composer4, 0);
                                                }
                                                composer4.endReplaceGroup();
                                                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, 0);
                                                if (function218 == null) {
                                                    composer4.startReplaceGroup(675935256);
                                                } else {
                                                    composer4.startReplaceGroup(2100014345);
                                                    ComposerKt.sourceInformation(composer4, "116@5119L8");
                                                    function218.invoke(composer4, 0);
                                                }
                                                composer4.endReplaceGroup();
                                                function219.invoke(composer4, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                composer4.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer3, 54), function3, composer3, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composer2, ((i9 >> 12) & 112) | 12607488, 108);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function29 = function210;
                                function28 = function26;
                                j2 = j3;
                            }
                            final Modifier modifier3 = modifier2;
                            final Shape shape3 = shape2;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$1(function2, function22, modifier3, function28, function29, shape3, j2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 12582912;
                        i7 = i3;
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i7 & 1)) {
                        }
                        final Modifier modifier32 = modifier2;
                        final Shape shape32 = shape2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    function27 = function24;
                    if ((196608 & i) == 0) {
                    }
                    if ((1572864 & i) == 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    i7 = i3;
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i7 & 1)) {
                    }
                    final Modifier modifier322 = modifier2;
                    final Shape shape322 = shape2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function26 = function23;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                function27 = function24;
                if ((196608 & i) == 0) {
                }
                if ((1572864 & i) == 0) {
                }
                if ((i2 & 128) == 0) {
                }
                i7 = i3;
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i7 & 1)) {
                }
                final Modifier modifier3222 = modifier2;
                final Shape shape3222 = shape2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function26 = function23;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function27 = function24;
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            i7 = i3;
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i7 & 1)) {
            }
            final Modifier modifier32222 = modifier2;
            final Shape shape32222 = shape2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function25 = function22;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function26 = function23;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function27 = function24;
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        i7 = i3;
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i7 & 1)) {
        }
        final Modifier modifier322222 = modifier2;
        final Shape shape322222 = shape2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit TimePickerDialogLayout_3csKH6Y$lambda$1(Function2 function2, Function2 function22, Modifier modifier, Function2 function23, Function2 function24, Shape shape, long j, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4318TimePickerDialogLayout3csKH6Y(function2, function22, modifier, function23, function24, shape, j, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TimePickerDialog_FItCLgY$lambda$0(Function0 function0, Function2 function2, Function2 function22, Modifier modifier, DialogProperties dialogProperties, Function2 function23, Function2 function24, Shape shape, long j, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4317TimePickerDialogFItCLgY(function0, function2, function22, modifier, dialogProperties, function23, function24, shape, j, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
