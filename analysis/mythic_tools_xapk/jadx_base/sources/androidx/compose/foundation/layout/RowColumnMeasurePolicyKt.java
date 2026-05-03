package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: RowColumnMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RowColumnMeasurePolicyKt {
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MeasureResult measure(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, MeasureScope measureScope, List<? extends Measurable> list, Placeable[] placeableArr, int i6, int i7, int[] iArr, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        FlowLayoutData flowLayoutData;
        int i13;
        int i14;
        int iIntValue;
        int i15;
        int i16;
        FlowLayoutData flowLayoutData2;
        int[] iArr2;
        int i17;
        long j;
        RowColumnMeasurePolicy rowColumnMeasurePolicy2;
        int i18;
        long j2 = i5;
        int i19 = i7 - i6;
        int[] iArr3 = new int[i19];
        int i20 = i6;
        float f = 0.0f;
        int i21 = 0;
        int i22 = 0;
        boolean z = false;
        int i23 = 0;
        int i24 = 0;
        while (true) {
            boolean z2 = true;
            if (i20 >= i7) {
                break;
            }
            Measurable measurable = list.get(i20);
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (!z && !RowColumnImplKt.isRelative(rowColumnParentData)) {
                z2 = false;
            }
            if (weight > 0.0f) {
                f += weight;
                i23++;
                iArr2 = iArr3;
                i17 = i20;
                j = j2;
            } else {
                Integer numValueOf = (i4 == Integer.MAX_VALUE || rowColumnParentData == null || (flowLayoutData2 = rowColumnParentData.getFlowLayoutData()) == null) ? null : Integer.valueOf(Math.round(flowLayoutData2.getFillCrossAxisFraction() * i4));
                int i25 = i3 - i24;
                Placeable placeableMo7769measureBRTryo0 = placeableArr[i20];
                if (placeableMo7769measureBRTryo0 == null) {
                    i17 = i20;
                    j = j2;
                    i18 = i22;
                    iArr2 = iArr3;
                    rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
                    placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(RowColumnMeasurePolicy.m2062createConstraintsxF2OJ5Q$default(rowColumnMeasurePolicy2, 0, numValueOf != null ? numValueOf.intValue() : 0, i3 != Integer.MAX_VALUE ? i25 < 0 ? 0 : i25 : Integer.MAX_VALUE, numValueOf != null ? numValueOf.intValue() : i4, false, 16, null));
                } else {
                    iArr2 = iArr3;
                    i17 = i20;
                    j = j2;
                    rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
                    i18 = i22;
                }
                int iMainAxisSize = rowColumnMeasurePolicy2.mainAxisSize(placeableMo7769measureBRTryo0);
                int iCrossAxisSize = rowColumnMeasurePolicy2.crossAxisSize(placeableMo7769measureBRTryo0);
                iArr2[i17 - i6] = iMainAxisSize;
                int i26 = i25 - iMainAxisSize;
                if (i26 < 0) {
                    i26 = 0;
                }
                int iMin = Math.min(i5, i26);
                i24 += iMainAxisSize + iMin;
                int iMax = Math.max(i18, iCrossAxisSize);
                placeableArr[i17] = placeableMo7769measureBRTryo0;
                i21 = iMin;
                i22 = iMax;
            }
            i20 = i17 + 1;
            z = z2;
            iArr3 = iArr2;
            j2 = j;
        }
        int[] iArr4 = iArr3;
        long j3 = j2;
        RowColumnMeasurePolicy rowColumnMeasurePolicy3 = rowColumnMeasurePolicy;
        int i27 = i22;
        if (i23 == 0) {
            i24 -= i21;
            i11 = 0;
            i10 = 0;
        } else {
            long j4 = j3 * ((long) (i23 - 1));
            long jRound = ((long) ((i3 != Integer.MAX_VALUE ? i3 : i) - i24)) - j4;
            if (jRound < 0) {
                jRound = 0;
            }
            float f2 = jRound / f;
            for (int i28 = i6; i28 < i7; i28++) {
                jRound -= (long) Math.round(RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(list.get(i28))) * f2);
            }
            int i29 = i6;
            int i30 = 0;
            while (i29 < i7) {
                if (placeableArr[i29] == null) {
                    Measurable measurable2 = list.get(i29);
                    RowColumnParentData rowColumnParentData2 = RowColumnImplKt.getRowColumnParentData(measurable2);
                    float weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    Integer numValueOf2 = (i4 == i9 || rowColumnParentData2 == null || (flowLayoutData = rowColumnParentData2.getFlowLayoutData()) == null) ? null : Integer.valueOf(Math.round(flowLayoutData.getFillCrossAxisFraction() * i4));
                    if (!(weight2 > 0.0f)) {
                        InlineClassHelperKt.throwIllegalStateException("All weights <= 0 should have placeables");
                    }
                    int sign = MathKt.getSign(jRound);
                    long j5 = jRound - ((long) sign);
                    int i31 = 0;
                    int iMax2 = Math.max(0, Math.round(weight2 * f2) + sign);
                    if (RowColumnImplKt.getFill(rowColumnParentData2)) {
                        i13 = Integer.MAX_VALUE;
                        if (iMax2 != Integer.MAX_VALUE) {
                            i14 = 0;
                            i31 = iMax2;
                        }
                        if (numValueOf2 == null) {
                            i12 = i13;
                            iIntValue = numValueOf2.intValue();
                        } else {
                            i12 = i13;
                            iIntValue = i14;
                        }
                        rowColumnMeasurePolicy3 = rowColumnMeasurePolicy;
                        Placeable placeableMo7769measureBRTryo02 = measurable2.mo7769measureBRTryo0(rowColumnMeasurePolicy3.mo1939createConstraintsxF2OJ5Q(i31, iIntValue, iMax2, numValueOf2 == null ? numValueOf2.intValue() : i4, true));
                        int iMainAxisSize2 = rowColumnMeasurePolicy3.mainAxisSize(placeableMo7769measureBRTryo02);
                        int iCrossAxisSize2 = rowColumnMeasurePolicy3.crossAxisSize(placeableMo7769measureBRTryo02);
                        iArr4[i29 - i6] = iMainAxisSize2;
                        i30 += iMainAxisSize2;
                        int iMax3 = Math.max(i27, iCrossAxisSize2);
                        placeableArr[i29] = placeableMo7769measureBRTryo02;
                        i27 = iMax3;
                        jRound = j5;
                    } else {
                        i13 = Integer.MAX_VALUE;
                    }
                    i14 = 0;
                    if (numValueOf2 == null) {
                    }
                    rowColumnMeasurePolicy3 = rowColumnMeasurePolicy;
                    Placeable placeableMo7769measureBRTryo022 = measurable2.mo7769measureBRTryo0(rowColumnMeasurePolicy3.mo1939createConstraintsxF2OJ5Q(i31, iIntValue, iMax2, numValueOf2 == null ? numValueOf2.intValue() : i4, true));
                    int iMainAxisSize22 = rowColumnMeasurePolicy3.mainAxisSize(placeableMo7769measureBRTryo022);
                    int iCrossAxisSize22 = rowColumnMeasurePolicy3.crossAxisSize(placeableMo7769measureBRTryo022);
                    iArr4[i29 - i6] = iMainAxisSize22;
                    i30 += iMainAxisSize22;
                    int iMax32 = Math.max(i27, iCrossAxisSize22);
                    placeableArr[i29] = placeableMo7769measureBRTryo022;
                    i27 = iMax32;
                    jRound = j5;
                } else {
                    i12 = i9;
                }
                i29++;
                i9 = i12;
            }
            i10 = 0;
            i11 = (int) (((long) i30) + j4);
            int i32 = i3 - i24;
            if (i11 < 0) {
                i11 = 0;
            }
            if (i11 > i32) {
                i11 = i32;
            }
        }
        int i33 = i27;
        if (z) {
            int iMax4 = i10;
            int iMax5 = iMax4;
            for (int i34 = i6; i34 < i7; i34++) {
                Placeable placeable = placeableArr[i34];
                Intrinsics.checkNotNull(placeable);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(placeable));
                Integer numCalculateAlignmentLinePosition$foundation_layout = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout(placeable) : null;
                if (numCalculateAlignmentLinePosition$foundation_layout != null) {
                    int iIntValue2 = numCalculateAlignmentLinePosition$foundation_layout.intValue();
                    int iCrossAxisSize3 = rowColumnMeasurePolicy3.crossAxisSize(placeable);
                    iMax4 = Math.max(iMax4, iIntValue2 != Integer.MIN_VALUE ? numCalculateAlignmentLinePosition$foundation_layout.intValue() : i10);
                    if (iIntValue2 == Integer.MIN_VALUE) {
                        iIntValue2 = iCrossAxisSize3;
                    }
                    iMax5 = Math.max(iMax5, iCrossAxisSize3 - iIntValue2);
                }
            }
            int i35 = iMax5;
            i16 = iMax4;
            i15 = i35;
        } else {
            i15 = i10;
            i16 = i15;
        }
        int i36 = i24 + i11;
        if (i36 < 0) {
            i36 = i10;
        }
        int iMax6 = Math.max(i36, i);
        int iMax7 = Math.max(i33, Math.max(i2, i15 + i16));
        int[] iArr5 = new int[i19];
        rowColumnMeasurePolicy3.populateMainAxisPositions(iMax6, iArr4, iArr5, measureScope);
        return rowColumnMeasurePolicy3.placeHelper(placeableArr, measureScope, i16, iArr5, iMax6, iMax7, iArr, i8, i6, i7);
    }
}
