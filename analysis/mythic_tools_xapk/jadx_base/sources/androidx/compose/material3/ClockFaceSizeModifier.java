package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/material3/ClockFaceSizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClockFaceSizeModifier implements LayoutModifier {
    public static final int $stable = 0;

    static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo2417measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float f = measureScope.mo1621toDpu2uoSUM(Constraints.m9066getMaxHeightimpl(j));
        int i = measureScope.mo1618roundToPx0680j_4(Dp.m9113compareTo0680j_4(f, TimePickerKt.TimePickerMaxHeight) >= 0 ? TimePickerTokens.INSTANCE.m5400getClockDialContainerSizeD9Ej5fM() : Dp.m9113compareTo0680j_4(f, TimePickerKt.TimePickerMidHeight) >= 0 ? TimePickerKt.ClockDialMidContainerSize : TimePickerKt.getClockDialMinContainerSize());
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(Constraints.INSTANCE.m9077fixedJhjzzOo(i, i));
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.ClockFaceSizeModifier$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ClockFaceSizeModifier.measure_3p2s80s$lambda$0(placeableMo7769measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
