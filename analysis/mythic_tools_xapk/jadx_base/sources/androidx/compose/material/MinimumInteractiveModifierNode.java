package androidx.compose.material;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: InteractiveComponentSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/MinimumInteractiveModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MinimumInteractiveModifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    public static final int $stable = Modifier.Node.$stable;

    static final Unit measure_3p2s80s$lambda$0(int i, Placeable placeable, int i2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, MathKt.roundToInt((i - placeable.getWidth()) / 2.0f), MathKt.roundToInt((i2 - placeable.getHeight()) / 2.0f), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1288measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        boolean z = getIsAttached() && ((Boolean) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement())).booleanValue();
        long j2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize;
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(j);
        final int iMax = z ? Math.max(placeableMo7769measureBRTryo0.getWidth(), measureScope.mo1618roundToPx0680j_4(DpSize.m9212getWidthD9Ej5fM(j2))) : placeableMo7769measureBRTryo0.getWidth();
        final int iMax2 = z ? Math.max(placeableMo7769measureBRTryo0.getHeight(), measureScope.mo1618roundToPx0680j_4(DpSize.m9210getHeightD9Ej5fM(j2))) : placeableMo7769measureBRTryo0.getHeight();
        return MeasureScope.layout$default(measureScope, iMax, iMax2, null, new Function1() { // from class: androidx.compose.material.MinimumInteractiveModifierNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MinimumInteractiveModifierNode.measure_3p2s80s$lambda$0(iMax, placeableMo7769measureBRTryo0, iMax2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
