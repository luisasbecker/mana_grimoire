package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tab.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class TabKt$TabBaselineLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX WARN: Multi-variable type inference failed */
    TabKt$TabBaselineLayout$2$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.$text = function2;
        this.$icon = function22;
    }

    static final Unit measure_3p2s80s$lambda$2(Placeable placeable, Placeable placeable2, MeasureScope measureScope, int i, int i2, Integer num, Integer num2, Placeable.PlacementScope placementScope) {
        if (placeable != null && placeable2 != null) {
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Intrinsics.checkNotNull(num2);
            TabKt.placeTextAndIcon(placementScope, measureScope, placeable, placeable2, i, i2, iIntValue, num2.intValue());
        } else if (placeable != null) {
            TabKt.placeTextOrIcon(placementScope, placeable, i2);
        } else if (placeable2 != null) {
            TabKt.placeTextOrIcon(placementScope, placeable2, i2);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1260measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final Placeable placeableMo7769measureBRTryo0;
        final Placeable placeableMo7769measureBRTryo02;
        if (this.$text != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Measurable measurable = list.get(i);
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "text")) {
                    placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                }
            }
            ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
            throw new KotlinNothingValueException();
        }
        placeableMo7769measureBRTryo0 = null;
        if (this.$icon != null) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Measurable measurable2 = list.get(i2);
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                    placeableMo7769measureBRTryo02 = measurable2.mo7769measureBRTryo0(j);
                }
            }
            ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
            throw new KotlinNothingValueException();
        }
        placeableMo7769measureBRTryo02 = null;
        final int iMax = Math.max(placeableMo7769measureBRTryo0 != null ? placeableMo7769measureBRTryo0.getWidth() : 0, placeableMo7769measureBRTryo02 != null ? placeableMo7769measureBRTryo02.getWidth() : 0);
        final int i3 = measureScope.mo1618roundToPx0680j_4((placeableMo7769measureBRTryo0 == null || placeableMo7769measureBRTryo02 == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight);
        Integer numValueOf = placeableMo7769measureBRTryo0 != null ? Integer.valueOf(placeableMo7769measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())) : null;
        final Integer numValueOf2 = placeableMo7769measureBRTryo0 != null ? Integer.valueOf(placeableMo7769measureBRTryo0.get(AlignmentLineKt.getLastBaseline())) : null;
        final Integer num = numValueOf;
        return MeasureScope.layout$default(measureScope, iMax, i3, null, new Function1() { // from class: androidx.compose.material.TabKt$TabBaselineLayout$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabKt$TabBaselineLayout$2$1.measure_3p2s80s$lambda$2(placeableMo7769measureBRTryo0, placeableMo7769measureBRTryo02, measureScope, iMax, i3, num, numValueOf2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
