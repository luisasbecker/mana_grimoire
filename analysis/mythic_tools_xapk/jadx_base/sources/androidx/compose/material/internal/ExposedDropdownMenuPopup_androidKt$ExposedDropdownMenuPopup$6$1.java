package androidx.compose.material.internal;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1 implements MeasurePolicy {
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ PopupLayout $popupLayout;

    ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1(PopupLayout popupLayout, LayoutDirection layoutDirection) {
        this.$popupLayout = popupLayout;
        this.$layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        this.$popupLayout.setParentLayoutDirection(this.$layoutDirection);
        return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Unit.INSTANCE;
            }
        }, 4, null);
    }
}
