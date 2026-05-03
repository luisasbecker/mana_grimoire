package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: BoxWithConstraints.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"BoxWithConstraints", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BoxWithConstraintsKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BoxWithConstraints(Modifier modifier, Alignment alignment, boolean z, final Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Alignment alignment2;
        int i4;
        boolean z2;
        Modifier.Companion companion;
        Alignment topStart;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(380139498);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxWithConstraints)N(modifier,contentAlignment,propagateMinConstraints,content)63@3275L271,63@3248L298:BoxWithConstraints.kt#2w3rfo");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                alignment2 = alignment;
                i3 |= composerStartRestartGroup.changed(alignment2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    topStart = i6 != 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(380139498, i3, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:61)");
                    }
                    final MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, z2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 241849337, "CC(remember):BoxWithConstraints.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(measurePolicyMaybeCachedBoxMeasurePolicy) | ((i3 & 7168) == 2048);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0(measurePolicyMaybeCachedBoxMeasurePolicy, function3, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SubcomposeLayoutKt.SubcomposeLayout(companion, (Function2) objRememberedValue, composerStartRestartGroup, i3 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    topStart = alignment2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final Alignment alignment3 = topStart;
                    final boolean z3 = z2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxWithConstraintsKt.BoxWithConstraints$lambda$1(modifier3, alignment3, z3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        alignment2 = alignment;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult BoxWithConstraints$lambda$0$0(MeasurePolicy measurePolicy, final Function3 function3, SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        final BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = new BoxWithConstraintsScopeImpl(subcomposeMeasureScope, constraints.getValue(), null);
        return measurePolicy.mo1260measure3p2s80s(subcomposeMeasureScope, subcomposeMeasureScope.subcompose(Unit.INSTANCE, ComposableLambdaKt.composableLambdaInstance(-431986394, true, new Function2() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BoxWithConstraintsKt.BoxWithConstraints$lambda$0$0$0(function3, boxWithConstraintsScopeImpl, (Composer) obj, ((Integer) obj2).intValue());
            }
        })), constraints.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxWithConstraints$lambda$0$0$0(Function3 function3, BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@3463L9:BoxWithConstraints.kt#2w3rfo");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-431986394, i, -1, "androidx.compose.foundation.layout.BoxWithConstraints.<anonymous>.<anonymous>.<anonymous> (BoxWithConstraints.kt:66)");
            }
            function3.invoke(boxWithConstraintsScopeImpl, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit BoxWithConstraints$lambda$1(Modifier modifier, Alignment alignment, boolean z, Function3 function3, int i, int i2, Composer composer, int i3) {
        BoxWithConstraints(modifier, alignment, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
