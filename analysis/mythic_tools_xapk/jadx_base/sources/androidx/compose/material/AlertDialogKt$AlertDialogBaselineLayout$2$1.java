package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.facebook.appevents.internal.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class AlertDialogKt$AlertDialogBaselineLayout$2$1 implements MeasurePolicy {
    public static final AlertDialogKt$AlertDialogBaselineLayout$2$1 INSTANCE = new AlertDialogKt$AlertDialogBaselineLayout$2$1();

    AlertDialogKt$AlertDialogBaselineLayout$2$1() {
    }

    static final Unit measure_3p2s80s$lambda$7(Placeable placeable, int i, Placeable placeable2, int i2, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable2, 0, i2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable;
        Measurable measurable2;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        final int i;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                measurable = null;
                break;
            }
            measurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), Constants.GP_IAP_TITLE)) {
                break;
            }
            i2++;
        }
        Measurable measurable3 = measurable;
        final Placeable placeableMo7769measureBRTryo0 = measurable3 != null ? measurable3.mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
        int size2 = list2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "text")) {
                break;
            }
            i3++;
        }
        Measurable measurable4 = measurable2;
        final Placeable placeableMo7769measureBRTryo02 = measurable4 != null ? measurable4.mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
        int iMax = Math.max(placeableMo7769measureBRTryo0 != null ? placeableMo7769measureBRTryo0.getWidth() : 0, placeableMo7769measureBRTryo02 != null ? placeableMo7769measureBRTryo02.getWidth() : 0);
        if (placeableMo7769measureBRTryo0 == null) {
            iIntValue = 0;
        } else {
            int iIntValue4 = Integer.valueOf(placeableMo7769measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())).intValue();
            Integer numValueOf = iIntValue4 == Integer.MIN_VALUE ? null : Integer.valueOf(iIntValue4);
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            }
        }
        if (placeableMo7769measureBRTryo0 == null) {
            iIntValue2 = 0;
        } else {
            int i4 = placeableMo7769measureBRTryo0.get(AlignmentLineKt.getLastBaseline());
            Integer numValueOf2 = i4 == Integer.MIN_VALUE ? null : Integer.valueOf(i4);
            if (numValueOf2 != null) {
                iIntValue2 = numValueOf2.intValue();
            }
        }
        final int i5 = measureScope.mo1617roundToPxR2X_6o(AlertDialogKt.TitleBaselineDistanceFromTop) - iIntValue;
        if (placeableMo7769measureBRTryo02 == null) {
            iIntValue3 = 0;
        } else {
            int i6 = placeableMo7769measureBRTryo02.get(AlignmentLineKt.getFirstBaseline());
            Integer numValueOf3 = i6 != Integer.MIN_VALUE ? Integer.valueOf(i6) : null;
            if (numValueOf3 != null) {
                iIntValue3 = numValueOf3.intValue();
            }
        }
        int i7 = placeableMo7769measureBRTryo0 == null ? measureScope.mo1617roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTop) : measureScope.mo1617roundToPxR2X_6o(AlertDialogKt.TextBaselineDistanceFromTitle);
        int height = placeableMo7769measureBRTryo0 != null ? placeableMo7769measureBRTryo0.getHeight() + i5 : 0;
        if (placeableMo7769measureBRTryo0 == null) {
            i = i7 - iIntValue3;
        } else {
            i = (iIntValue2 == 0 ? height - iIntValue3 : (i5 + iIntValue2) - iIntValue3) + i7;
        }
        if (placeableMo7769measureBRTryo02 != null) {
            if (iIntValue2 == 0) {
                height = (placeableMo7769measureBRTryo02.getHeight() + i7) - iIntValue3;
            } else {
                height = ((placeableMo7769measureBRTryo02.getHeight() + i7) - iIntValue3) - ((placeableMo7769measureBRTryo0 != null ? placeableMo7769measureBRTryo0.getHeight() : 0) - iIntValue2);
            }
        }
        return MeasureScope.layout$default(measureScope, iMax, height + height, null, new Function1() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AlertDialogKt$AlertDialogBaselineLayout$2$1.measure_3p2s80s$lambda$7(placeableMo7769measureBRTryo0, i5, placeableMo7769measureBRTryo02, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
