package androidx.compose.material;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class ListItemKt$OffsetToBaselineOrCenter$1$1 implements MeasurePolicy {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-offset$0, reason: not valid java name */
    final /* synthetic */ float f76$$v$c$androidxcomposeuiunitDp$offset$0;

    ListItemKt$OffsetToBaselineOrCenter$1$1(float f) {
        this.f76$$v$c$androidxcomposeuiunitDp$offset$0 = f;
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int iMax;
        final int iM9243getYimpl;
        final Placeable placeableMo7769measureBRTryo0 = list.get(0).mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
        int i = placeableMo7769measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
        if (i != Integer.MIN_VALUE) {
            iM9243getYimpl = measureScope.mo1618roundToPx0680j_4(this.f76$$v$c$androidxcomposeuiunitDp$offset$0) - i;
            iMax = Math.max(Constraints.m9068getMinHeightimpl(j), placeableMo7769measureBRTryo0.getHeight() + iM9243getYimpl);
        } else {
            iMax = Math.max(Constraints.m9068getMinHeightimpl(j), placeableMo7769measureBRTryo0.getHeight());
            iM9243getYimpl = IntOffset.m9243getYimpl(Alignment.INSTANCE.getCenter().mo5799alignKFBX0sM(IntSize.INSTANCE.m9290getZeroYbymL2g(), IntSize.m9280constructorimpl(((long) (iMax - placeableMo7769measureBRTryo0.getHeight())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE), measureScope.getLayoutDirection()));
        }
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), iMax, null, new Function1() { // from class: androidx.compose.material.ListItemKt$OffsetToBaselineOrCenter$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListItemKt$OffsetToBaselineOrCenter$1$1.measure_3p2s80s$lambda$0(placeableMo7769measureBRTryo0, iM9243getYimpl, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
