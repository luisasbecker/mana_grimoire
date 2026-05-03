package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AppBarDsl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00020\r*\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/OverflowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/material3/AppBarOverflowState;", "maxItemCount", "", "isVertical", "", "<init>", "(Landroidx/compose/material3/AppBarOverflowState;IZ)V", "getMaxItemCount", "()I", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OverflowMeasurePolicy implements MultiContentMeasurePolicy {
    public static final int $stable = 0;
    private final boolean isVertical;
    private final int maxItemCount;
    private final AppBarOverflowState overflowState;

    public OverflowMeasurePolicy(AppBarOverflowState appBarOverflowState, int i, boolean z) {
        this.overflowState = appBarOverflowState;
        this.maxItemCount = i;
        this.isVertical = z;
    }

    public /* synthetic */ OverflowMeasurePolicy(AppBarOverflowState appBarOverflowState, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(appBarOverflowState, i, (i2 & 4) != 0 ? false : z);
    }

    static final Unit measure_3p2s80s$lambda$11(List list, List list2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        int i = 0;
        int height = 0;
        while (i < size) {
            Placeable placeable = (Placeable) list.get(i);
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, 0, height, 0.0f, 4, null);
            height += placeable.getHeight();
            i++;
            placementScope = placementScope2;
        }
        Placeable.PlacementScope placementScope3 = placementScope;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Placeable.PlacementScope.placeRelative$default(placementScope3, (Placeable) list2.get(i2), 0, height, 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$14(List list, List list2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        int i = 0;
        int width = 0;
        while (i < size) {
            Placeable placeable = (Placeable) list.get(i);
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, width, 0, 0.0f, 4, null);
            width += placeable.getWidth();
            i++;
            placementScope = placementScope2;
        }
        Placeable.PlacementScope placementScope3 = placementScope;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Placeable.PlacementScope.placeRelative$default(placementScope3, (Placeable) list2.get(i2), width, 0, 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }

    public final int getMaxItemCount() {
        return this.maxItemCount;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MeasureResult mo1981measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Integer numValueOf;
        int iIntValue;
        int i;
        final ArrayList arrayList;
        final ArrayList arrayList2;
        Integer numValueOf2;
        int iIntValue2;
        Integer numValueOf3;
        int iMax;
        Integer numValueOf4;
        Integer numValueOf5;
        Integer numValueOf6;
        Integer numValueOf7;
        long jM9057copyZbe2FdA$default;
        Integer numValueOf8;
        int iIntValue3 = 0;
        long jM9057copyZbe2FdA$default2 = Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list.get(0);
        int i2 = 1;
        List<? extends Measurable> list3 = list.get(1);
        this.overflowState.setTotalItemCount(list2.size());
        if (this.isVertical) {
            if (list3.isEmpty()) {
                numValueOf8 = null;
            } else {
                numValueOf8 = Integer.valueOf(list3.get(0).maxIntrinsicHeight(Constraints.m9067getMaxWidthimpl(j)));
                int lastIndex = CollectionsKt.getLastIndex(list3);
                if (1 <= lastIndex) {
                    int i3 = 1;
                    while (true) {
                        Integer numValueOf9 = Integer.valueOf(list3.get(i3).maxIntrinsicHeight(Constraints.m9067getMaxWidthimpl(j)));
                        if (numValueOf9.compareTo(numValueOf8) > 0) {
                            numValueOf8 = numValueOf9;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            }
            Integer num = numValueOf8;
            iIntValue = num != null ? num.intValue() : 0;
        } else {
            if (list3.isEmpty()) {
                numValueOf = null;
            } else {
                numValueOf = Integer.valueOf(list3.get(0).maxIntrinsicWidth(Constraints.m9066getMaxHeightimpl(j)));
                int lastIndex2 = CollectionsKt.getLastIndex(list3);
                if (1 <= lastIndex2) {
                    int i4 = 1;
                    while (true) {
                        Integer numValueOf10 = Integer.valueOf(list3.get(i4).maxIntrinsicWidth(Constraints.m9066getMaxHeightimpl(j)));
                        if (numValueOf10.compareTo(numValueOf) > 0) {
                            numValueOf = numValueOf10;
                        }
                        if (i4 == lastIndex2) {
                            break;
                        }
                        i4++;
                    }
                }
            }
            Integer num2 = numValueOf;
            if (num2 != null) {
                iIntValue = num2.intValue();
            }
        }
        int iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(this.isVertical ? Constraints.m9066getMaxHeightimpl(j) : Constraints.m9067getMaxWidthimpl(j), iIntValue);
        ArrayList arrayList3 = new ArrayList();
        int size = list2.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= size) {
                i = i2;
                break;
            }
            Placeable placeableMo7769measureBRTryo0 = list2.get(i5).mo7769measureBRTryo0(jM9057copyZbe2FdA$default2);
            int i7 = i5 == CollectionsKt.getLastIndex(list2) ? i2 : 0;
            i = i2;
            if (i7 == 0 && i5 == this.maxItemCount - 1) {
                break;
            }
            int height = this.isVertical ? placeableMo7769measureBRTryo0.getHeight() : placeableMo7769measureBRTryo0.getWidth();
            if (height > iSubtractConstraintSafely && (i7 == 0 || height > iSubtractConstraintSafely + iIntValue)) {
                break;
            }
            arrayList3.add(placeableMo7769measureBRTryo0);
            i6 += height;
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, height);
            i5++;
            i2 = i;
        }
        this.overflowState.setVisibleItemCount(arrayList3.size());
        if (arrayList3.size() != list2.size()) {
            if (this.isVertical) {
                arrayList = arrayList3;
                jM9057copyZbe2FdA$default = Constraints.m9057copyZbe2FdA$default(jM9057copyZbe2FdA$default2, 0, 0, 0, iSubtractConstraintSafely + iIntValue, 7, null);
            } else {
                arrayList = arrayList3;
                jM9057copyZbe2FdA$default = Constraints.m9057copyZbe2FdA$default(jM9057copyZbe2FdA$default2, 0, iSubtractConstraintSafely + iIntValue, 0, 0, 13, null);
            }
            ArrayList arrayList4 = new ArrayList(list3.size());
            int size2 = list3.size();
            for (int i8 = 0; i8 < size2; i8++) {
                arrayList4.add(list3.get(i8).mo7769measureBRTryo0(jM9057copyZbe2FdA$default));
            }
            arrayList2 = arrayList4;
        } else {
            arrayList = arrayList3;
            arrayList2 = null;
        }
        if (this.isVertical) {
            if (arrayList2 == null) {
                iIntValue2 = 0;
            } else {
                if (arrayList2.isEmpty()) {
                    numValueOf7 = null;
                } else {
                    numValueOf7 = Integer.valueOf(((Placeable) arrayList2.get(0)).getHeight());
                    int lastIndex3 = CollectionsKt.getLastIndex(arrayList2);
                    if (i <= lastIndex3) {
                        int i9 = 1;
                        while (true) {
                            Integer numValueOf11 = Integer.valueOf(((Placeable) arrayList2.get(i9)).getHeight());
                            if (numValueOf11.compareTo(numValueOf7) > 0) {
                                numValueOf7 = numValueOf11;
                            }
                            if (i9 == lastIndex3) {
                                break;
                            }
                            i9++;
                        }
                    }
                }
                Integer num3 = numValueOf7;
                if (num3 != null) {
                    iIntValue2 = num3.intValue();
                }
            }
        } else if (arrayList2 != null) {
            if (arrayList2.isEmpty()) {
                numValueOf2 = null;
            } else {
                numValueOf2 = Integer.valueOf(((Placeable) arrayList2.get(0)).getWidth());
                int lastIndex4 = CollectionsKt.getLastIndex(arrayList2);
                if (1 <= lastIndex4) {
                    int i10 = 1;
                    while (true) {
                        Integer numValueOf12 = Integer.valueOf(((Placeable) arrayList2.get(i10)).getWidth());
                        if (numValueOf12.compareTo(numValueOf2) > 0) {
                            numValueOf2 = numValueOf12;
                        }
                        if (i10 == lastIndex4) {
                            break;
                        }
                        i10++;
                    }
                }
            }
            Integer num4 = numValueOf2;
            if (num4 != null) {
                iIntValue2 = num4.intValue();
            }
        }
        int i11 = i6 + iIntValue2;
        if (this.isVertical) {
            if (arrayList.isEmpty()) {
                numValueOf5 = null;
            } else {
                numValueOf5 = Integer.valueOf(((Placeable) arrayList.get(0)).getWidth());
                int lastIndex5 = CollectionsKt.getLastIndex(arrayList);
                if (1 <= lastIndex5) {
                    int i12 = 1;
                    while (true) {
                        Integer numValueOf13 = Integer.valueOf(((Placeable) arrayList.get(i12)).getWidth());
                        if (numValueOf13.compareTo(numValueOf5) > 0) {
                            numValueOf5 = numValueOf13;
                        }
                        if (i12 == lastIndex5) {
                            break;
                        }
                        i12++;
                    }
                }
            }
            Integer num5 = numValueOf5;
            int iIntValue4 = num5 != null ? num5.intValue() : 0;
            if (arrayList2 != null) {
                if (arrayList2.isEmpty()) {
                    numValueOf6 = null;
                } else {
                    numValueOf6 = Integer.valueOf(((Placeable) arrayList2.get(0)).getWidth());
                    int lastIndex6 = CollectionsKt.getLastIndex(arrayList2);
                    if (1 <= lastIndex6) {
                        Integer num6 = numValueOf6;
                        int i13 = 1;
                        while (true) {
                            Integer numValueOf14 = Integer.valueOf(((Placeable) arrayList2.get(i13)).getWidth());
                            if (numValueOf14.compareTo(num6) > 0) {
                                num6 = numValueOf14;
                            }
                            if (i13 == lastIndex6) {
                                break;
                            }
                            i13++;
                        }
                        numValueOf6 = num6;
                    }
                }
                Integer num7 = numValueOf6;
                if (num7 != null) {
                    iIntValue3 = num7.intValue();
                }
            }
            iMax = Math.max(iIntValue4, iIntValue3);
        } else {
            if (arrayList.isEmpty()) {
                numValueOf3 = null;
            } else {
                numValueOf3 = Integer.valueOf(((Placeable) arrayList.get(0)).getHeight());
                int lastIndex7 = CollectionsKt.getLastIndex(arrayList);
                if (1 <= lastIndex7) {
                    int i14 = 1;
                    while (true) {
                        Integer numValueOf15 = Integer.valueOf(((Placeable) arrayList.get(i14)).getHeight());
                        if (numValueOf15.compareTo(numValueOf3) > 0) {
                            numValueOf3 = numValueOf15;
                        }
                        if (i14 == lastIndex7) {
                            break;
                        }
                        i14++;
                    }
                }
            }
            Integer num8 = numValueOf3;
            int iIntValue5 = num8 != null ? num8.intValue() : 0;
            if (arrayList2 != null) {
                if (arrayList2.isEmpty()) {
                    numValueOf4 = null;
                } else {
                    numValueOf4 = Integer.valueOf(((Placeable) arrayList2.get(0)).getHeight());
                    int lastIndex8 = CollectionsKt.getLastIndex(arrayList2);
                    int i15 = 1;
                    if (1 <= lastIndex8) {
                        while (true) {
                            Integer numValueOf16 = Integer.valueOf(((Placeable) arrayList2.get(i15)).getHeight());
                            if (numValueOf16.compareTo(numValueOf4) > 0) {
                                numValueOf4 = numValueOf16;
                            }
                            if (i15 == lastIndex8) {
                                break;
                            }
                            i15++;
                        }
                    }
                }
                Integer num9 = numValueOf4;
                if (num9 != null) {
                    iIntValue3 = num9.intValue();
                }
            }
            iMax = Math.max(iIntValue5, iIntValue3);
        }
        return this.isVertical ? MeasureScope.layout$default(measureScope, ConstraintsKt.m9084constrainWidthK40F9xA(j, iMax), ConstraintsKt.m9083constrainHeightK40F9xA(j, i11), null, new Function1() { // from class: androidx.compose.material3.OverflowMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OverflowMeasurePolicy.measure_3p2s80s$lambda$11(arrayList, arrayList2, (Placeable.PlacementScope) obj);
            }
        }, 4, null) : MeasureScope.layout$default(measureScope, ConstraintsKt.m9084constrainWidthK40F9xA(j, i11), ConstraintsKt.m9083constrainHeightK40F9xA(j, iMax), null, new Function1() { // from class: androidx.compose.material3.OverflowMeasurePolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OverflowMeasurePolicy.measure_3p2s80s$lambda$14(arrayList, arrayList2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
