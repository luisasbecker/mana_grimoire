package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class AlertDialogKt$AlertDialogFlowRow$1$1 implements MeasurePolicy {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-crossAxisSpacing$0, reason: not valid java name */
    final /* synthetic */ float f63$$v$c$androidxcomposeuiunitDp$crossAxisSpacing$0;

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-mainAxisSpacing$0, reason: not valid java name */
    final /* synthetic */ float f64$$v$c$androidxcomposeuiunitDp$mainAxisSpacing$0;

    AlertDialogKt$AlertDialogFlowRow$1$1(float f, float f2) {
        this.f64$$v$c$androidxcomposeuiunitDp$mainAxisSpacing$0 = f;
        this.f63$$v$c$androidxcomposeuiunitDp$crossAxisSpacing$0 = f2;
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f, long j, Placeable placeable) {
        return list.isEmpty() || (intRef.element + measureScope.mo1618roundToPx0680j_4(f)) + placeable.getWidth() <= Constraints.m9067getMaxWidthimpl(j);
    }

    static final Unit measure_3p2s80s$lambda$1(List list, MeasureScope measureScope, float f, int i, List list2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            List list3 = (List) list.get(i2);
            int size2 = list3.size();
            int[] iArr = new int[size2];
            int i3 = 0;
            while (i3 < size2) {
                iArr[i3] = ((Placeable) list3.get(i3)).getWidth() + (i3 < CollectionsKt.getLastIndex(list3) ? measureScope.mo1618roundToPx0680j_4(f) : 0);
                i3++;
            }
            int[] iArr2 = new int[size2];
            Arrangement.INSTANCE.getBottom().arrange(measureScope, i, iArr, iArr2);
            int size3 = list3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) list3.get(i4), iArr2[i4], ((Number) list2.get(i2)).intValue(), 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }

    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
        if (!list.isEmpty()) {
            intRef.element += measureScope.mo1618roundToPx0680j_4(f);
        }
        list.add(0, CollectionsKt.toList(list2));
        list3.add(Integer.valueOf(intRef2.element));
        list4.add(Integer.valueOf(intRef.element));
        intRef.element += intRef2.element;
        intRef3.element = Math.max(intRef3.element, intRef4.element);
        list2.clear();
        intRef4.element = 0;
        intRef2.element = 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1260measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        float f;
        List<? extends Measurable> list2 = list;
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        ArrayList arrayList4 = new ArrayList();
        Ref.IntRef intRef3 = new Ref.IntRef();
        Ref.IntRef intRef4 = new Ref.IntRef();
        long jConstraints$default = ConstraintsKt.Constraints$default(0, Constraints.m9067getMaxWidthimpl(j), 0, 0, 13, null);
        float f2 = this.f64$$v$c$androidxcomposeuiunitDp$mainAxisSpacing$0;
        float f3 = this.f63$$v$c$androidxcomposeuiunitDp$crossAxisSpacing$0;
        int size = list2.size();
        int i = 0;
        while (i < size) {
            Placeable placeableMo7769measureBRTryo0 = list2.get(i).mo7769measureBRTryo0(jConstraints$default);
            int i2 = size;
            int i3 = i;
            Ref.IntRef intRef5 = intRef3;
            ArrayList arrayList5 = arrayList4;
            long j2 = jConstraints$default;
            if (measure_3p2s80s$canAddToCurrentSequence(arrayList5, intRef5, measureScope, f2, j, placeableMo7769measureBRTryo0)) {
                f = f3;
            } else {
                f = f3;
                measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope, f, arrayList5, arrayList2, intRef4, arrayList3, intRef, intRef5);
                arrayList5 = arrayList5;
            }
            if (!arrayList5.isEmpty()) {
                intRef5.element += measureScope.mo1618roundToPx0680j_4(f2);
            }
            arrayList5.add(placeableMo7769measureBRTryo0);
            intRef5.element += placeableMo7769measureBRTryo0.getWidth();
            intRef4.element = Math.max(intRef4.element, placeableMo7769measureBRTryo0.getHeight());
            i = i3 + 1;
            f3 = f;
            arrayList4 = arrayList5;
            intRef3 = intRef5;
            jConstraints$default = j2;
            size = i2;
            list2 = list;
        }
        Ref.IntRef intRef6 = intRef3;
        ArrayList arrayList6 = arrayList4;
        if (!arrayList6.isEmpty()) {
            measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope, this.f63$$v$c$androidxcomposeuiunitDp$crossAxisSpacing$0, arrayList6, arrayList2, intRef4, arrayList3, intRef, intRef6);
        }
        final int iM9067getMaxWidthimpl = Constraints.m9067getMaxWidthimpl(j) != Integer.MAX_VALUE ? Constraints.m9067getMaxWidthimpl(j) : Math.max(intRef.element, Constraints.m9069getMinWidthimpl(j));
        int iMax = Math.max(intRef2.element, Constraints.m9068getMinHeightimpl(j));
        final float f4 = this.f64$$v$c$androidxcomposeuiunitDp$mainAxisSpacing$0;
        return MeasureScope.layout$default(measureScope, iM9067getMaxWidthimpl, iMax, null, new Function1() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AlertDialogKt$AlertDialogFlowRow$1$1.measure_3p2s80s$lambda$1(arrayList, measureScope, f4, iM9067getMaxWidthimpl, arrayList3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
