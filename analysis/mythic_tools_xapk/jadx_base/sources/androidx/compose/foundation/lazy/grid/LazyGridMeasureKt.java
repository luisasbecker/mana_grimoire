package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutStickyItemsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.MuxerUtil;
import androidx.window.reflection.WindowExtensionsConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aü\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*23\u0010+\u001a/\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011000 0,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00030,2\b\u00103\u001a\u0004\u0018\u0001042/\u00105\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080,¢\u0006\u0002\b9\u0012\u0004\u0012\u00020:06H\u0000¢\u0006\u0004\b;\u0010<\u001aA\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130,H\u0082\b\u001aF\u0010?\u001a\b\u0012\u0004\u0012\u00020@0 2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00132\f\u0010B\u001a\b\u0012\u0004\u0012\u00020@0 2\b\u0010C\u001a\u0004\u0018\u00010$H\u0002\u001a\u008c\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001d0E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020@0 2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a+\u0010N\u001a\u000208\"\u0004\b\u0000\u0010O*\b\u0012\u0004\u0012\u0002HO0E2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0QH\u0002¢\u0006\u0002\u0010R¨\u0006S"}, d2 = {"measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "slotsPerLine", "pinnedItems", "", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "Lkotlin/Pair;", "lineIndexProvider", "itemIndex", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", WindowExtensionsConstants.LAYOUT_PACKAGE, "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-t1x4au0", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "calculateExtraItems", "filter", "linesRetainedForLookahead", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lastVisibleItemIndex", "visibleLines", "lastApproachLayoutInfo", "calculateItemsOffsets", "", "lines", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "addAllFromArray", ExifInterface.GPS_DIRECTION_TRUE, "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridMeasureKt {
    private static final <T> void addAllFromArray(List<T> list, T[] tArr) {
        for (T t : tArr) {
            list.add(t);
        }
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, Function1<? super Integer, Boolean> function1) {
        LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider2;
        int size = list.size();
        ArrayList arrayList = null;
        int i = 0;
        while (i < size) {
            int iIntValue = list.get(i).intValue();
            if (function1.invoke(Integer.valueOf(iIntValue)).booleanValue()) {
                int iSpanOf = lazyGridMeasuredLineProvider.spanOf(iIntValue);
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                LazyGridMeasuredItem lazyGridMeasuredItemMo2152getAndMeasurehBUhpc = lazyGridMeasuredItemProvider2.mo2152getAndMeasurehBUhpc(iIntValue, 0, iSpanOf, lazyGridMeasuredLineProvider.m2181childConstraintsJhjzzOo$foundation(0, iSpanOf));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyGridMeasuredItemMo2152getAndMeasurehBUhpc);
            } else {
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
            }
            i++;
            lazyGridMeasuredItemProvider = lazyGridMeasuredItemProvider2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
            }
        }
        List<LazyGridMeasuredLine> list4 = list;
        int size = list4.size();
        int length = 0;
        for (int i7 = 0; i7 < size; i7++) {
            length += list.get(i7).getItems().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.throwIllegalArgumentException("no items");
            }
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i8 = 0; i8 < size2; i8++) {
                iArr[i8] = list.get(calculateItemsOffsets$reverseAware(i8, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            if (z) {
                if (vertical == null) {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement");
                    throw new KotlinNothingValueException();
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement");
                    throw new KotlinNothingValueException();
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int mainAxisSize = iArr2[first];
                    LazyGridMeasuredLine lazyGridMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        mainAxisSize = (i6 - mainAxisSize) - lazyGridMeasuredLine.getMainAxisSize();
                    }
                    addAllFromArray(arrayList, lazyGridMeasuredLine.position(mainAxisSize, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size() - 1;
            if (size3 >= 0) {
                int mainAxisSizeWithSpacings = i5;
                while (true) {
                    int i9 = size3 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size3);
                    mainAxisSizeWithSpacings -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyGridMeasuredItem.position(mainAxisSizeWithSpacings, 0, i, i2);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i9 < 0) {
                        break;
                    }
                    size3 = i9;
                }
            }
            int size4 = list4.size();
            int mainAxisSizeWithSpacings2 = i5;
            for (int i10 = 0; i10 < size4; i10++) {
                LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(i10);
                addAllFromArray(arrayList, lazyGridMeasuredLine2.position(mainAxisSizeWithSpacings2, i, i2));
                mainAxisSizeWithSpacings2 += lazyGridMeasuredLine2.getMainAxisSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i11 = 0; i11 < size5; i11++) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i11);
                lazyGridMeasuredItem2.position(mainAxisSizeWithSpacings2, 0, i, i2);
                arrayList.add(lazyGridMeasuredItem2);
                mainAxisSizeWithSpacings2 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0 A[LOOP:1: B:25:0x0072->B:39:0x00b0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b3 A[EDGE_INSN: B:49:0x00b3->B:40:0x00b3 BREAK  A[LOOP:1: B:25:0x0072->B:39:0x00b0], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<LazyGridMeasuredLine> linesRetainedForLookahead(int i, int i2, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, boolean z, List<LazyGridMeasuredLine> list, LazyGridLayoutInfo lazyGridLayoutInfo) {
        LazyGridItemInfo lazyGridItemInfo;
        int index;
        int iMin;
        ArrayList arrayList = null;
        if (z && lazyGridLayoutInfo != null && !lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            List<LazyGridItemInfo> visibleItemsInfo = lazyGridLayoutInfo.getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    lazyGridItemInfo = null;
                    break;
                }
                if (visibleItemsInfo.get(size).getIndex() > i && (size == 0 || visibleItemsInfo.get(size - 1).getIndex() <= i)) {
                    break;
                }
            }
            lazyGridItemInfo = visibleItemsInfo.get(size);
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.last((List) lazyGridLayoutInfo.getVisibleItemsInfo());
            LazyGridMeasuredLine lazyGridMeasuredLine = (LazyGridMeasuredLine) CollectionsKt.lastOrNull((List) list);
            int index2 = lazyGridMeasuredLine != null ? lazyGridMeasuredLine.getIndex() + 1 : 0;
            if (lazyGridItemInfo != null && (index = lazyGridItemInfo.getIndex()) <= (iMin = Math.min(lazyGridItemInfo2.getIndex(), i2 - 1))) {
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            for (LazyGridMeasuredItem lazyGridMeasuredItem : arrayList.get(i3).getItems()) {
                                if (lazyGridMeasuredItem.getIndex() == index) {
                                    break;
                                }
                            }
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(index2);
                        index2++;
                        arrayList.add(andMeasure);
                        if (index != iMin) {
                            break;
                        }
                        index++;
                    } else {
                        if (arrayList == null) {
                        }
                        LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(index2);
                        index2++;
                        arrayList.add(andMeasure2);
                        if (index != iMin) {
                        }
                    }
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x021d  */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [int] */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX INFO: renamed from: measureLazyGrid-t1x4au0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyGridMeasureResult m2177measureLazyGridt1x4au0(int i, final LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, boolean z3, final boolean z4, LazyGridLayoutInfo lazyGridLayoutInfo, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, Function1<? super Integer, Integer> function12, StickyItemsPlacement stickyItemsPlacement, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i9;
        int i10;
        int i11;
        float f2;
        float f3;
        int i12;
        LazyGridMeasuredLine lazyGridMeasuredLine;
        int i13;
        int index;
        int size;
        ArrayList arrayListEmptyList;
        List listEmptyList;
        int i14;
        int i15;
        ArrayDeque arrayDeque;
        List<LazyGridMeasuredLine> listLinesRetainedForLookahead;
        int size2;
        int i16;
        int size3;
        int i17;
        List listPlus;
        final LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider2;
        int i18;
        boolean z5;
        Arrangement.Horizontal horizontal2;
        Density density2;
        int i19;
        Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function32;
        int i20;
        int i21;
        boolean z6;
        List list2;
        int i22;
        int i23;
        int i24;
        float f4;
        ArrayDeque arrayDeque2;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        LazyGridMeasuredItem[] items2;
        LazyGridMeasuredItem lazyGridMeasuredItem2;
        int i30;
        int i31;
        int i32;
        int i33 = i;
        boolean z7 = true;
        if (!(i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
        }
        if (i33 <= 0) {
            int iM9069getMinWidthimpl = Constraints.m9069getMinWidthimpl(j);
            int iM9068getMinHeightimpl = Constraints.m9068getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, iM9069getMinWidthimpl, iM9068getMinHeightimpl, new ArrayList(), lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, z4, i8, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z4) {
                long jM2206getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m2206getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m9283equalsimpl0(jM2206getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                    iM9069getMinWidthimpl = ConstraintsKt.m9084constrainWidthK40F9xA(j, (int) (jM2206getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    iM9068getMinHeightimpl = ConstraintsKt.m9083constrainHeightK40F9xA(j, (int) (jM2206getMinSizeToFitDisappearingItemsYbymL2g & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                }
            }
            return new LazyGridMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(iM9069getMinWidthimpl), Integer.valueOf(iM9068getMinHeightimpl), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Unit.INSTANCE;
                }
            }), 0.0f, false, coroutineScope, density, i8, function1, function12, CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int iRound = Math.round(f);
        int i34 = i7 - iRound;
        if (i6 == 0 && i34 < 0) {
            iRound += i34;
            i34 = 0;
        }
        ArrayDeque arrayDeque3 = new ArrayDeque();
        int i35 = -i3;
        int i36 = (i5 < 0 ? i5 : 0) + i35;
        int mainAxisSizeWithSpacings = i34 + i36;
        int i37 = i6;
        while (mainAxisSizeWithSpacings < 0 && i37 > 0) {
            i37--;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i37);
            arrayDeque3.add(0, andMeasure);
            mainAxisSizeWithSpacings += andMeasure.getMainAxisSizeWithSpacings();
        }
        if (mainAxisSizeWithSpacings < i36) {
            iRound -= i36 - mainAxisSizeWithSpacings;
            mainAxisSizeWithSpacings = i36;
        }
        int i38 = mainAxisSizeWithSpacings - i36;
        int i39 = i2 + i4;
        int i40 = i37;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i39, 0);
        int mainAxisSizeWithSpacings2 = -i38;
        int i41 = i40;
        int i42 = i35;
        int i43 = 0;
        boolean z8 = false;
        while (i43 < arrayDeque3.size()) {
            if (mainAxisSizeWithSpacings2 >= iCoerceAtLeast) {
                arrayDeque3.remove(i43);
                Unit unit = Unit.INSTANCE;
                z8 = true;
            } else {
                i41++;
                mainAxisSizeWithSpacings2 += ((LazyGridMeasuredLine) arrayDeque3.get(i43)).getMainAxisSizeWithSpacings();
                Integer.valueOf(i43);
                i43++;
            }
        }
        int mainAxisSizeWithSpacings3 = i38;
        boolean z9 = z8;
        int i44 = i41;
        while (i44 < i33 && (mainAxisSizeWithSpacings2 < iCoerceAtLeast || mainAxisSizeWithSpacings2 <= 0 || arrayDeque3.isEmpty())) {
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i44);
            if (andMeasure2.isEmpty()) {
                break;
            }
            mainAxisSizeWithSpacings2 += andMeasure2.getMainAxisSizeWithSpacings();
            if (mainAxisSizeWithSpacings2 <= i36) {
                i30 = iCoerceAtLeast;
                i31 = i44;
                if (((LazyGridMeasuredItem) ArraysKt.last(andMeasure2.getItems())).getIndex() != i - 1) {
                    i32 = i31 + 1;
                    mainAxisSizeWithSpacings3 -= andMeasure2.getMainAxisSizeWithSpacings();
                    Unit unit2 = Unit.INSTANCE;
                    z9 = true;
                }
                iCoerceAtLeast = i30;
                i40 = i32;
                i44 = i31 + 1;
                i33 = i;
            } else {
                i30 = iCoerceAtLeast;
                i31 = i44;
            }
            Boolean.valueOf(arrayDeque3.add(andMeasure2));
            i32 = i40;
            iCoerceAtLeast = i30;
            i40 = i32;
            i44 = i31 + 1;
            i33 = i;
        }
        if (mainAxisSizeWithSpacings2 < i2) {
            int i45 = i2 - mainAxisSizeWithSpacings2;
            mainAxisSizeWithSpacings3 -= i45;
            mainAxisSizeWithSpacings2 += i45;
            int i46 = i40;
            while (mainAxisSizeWithSpacings3 < i3 && i46 > 0) {
                i46--;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i46);
                arrayDeque3.add(0, andMeasure3);
                mainAxisSizeWithSpacings3 += andMeasure3.getMainAxisSizeWithSpacings();
            }
            i9 = i45 + iRound;
            if (mainAxisSizeWithSpacings3 < 0) {
                i9 += mainAxisSizeWithSpacings3;
                i10 = mainAxisSizeWithSpacings2 + mainAxisSizeWithSpacings3;
                i11 = 0;
            }
            float f5 = (MathKt.getSign(Math.round(f)) == MathKt.getSign(i9) || Math.abs(Math.round(f)) < Math.abs(i9)) ? f : i9;
            f2 = f - f5;
            f3 = 0.0f;
            if (z4 && i9 > iRound && f2 <= 0.0f) {
                f3 = (i9 - iRound) + f2;
            }
            float f6 = f3;
            if (!(i11 < 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("negative initial offset");
            }
            i12 = -i11;
            LazyGridMeasuredLine lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque3.firstOrNull();
            int index2 = (lazyGridMeasuredLine2 != null || (items2 = lazyGridMeasuredLine2.getItems()) == null || (lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(items2)) == null) ? 0 : lazyGridMeasuredItem2.getIndex();
            lazyGridMeasuredLine = (LazyGridMeasuredLine) arrayDeque3.lastOrNull();
            if (lazyGridMeasuredLine != null || (items = lazyGridMeasuredLine.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) {
                i13 = i12;
                index = 0;
            } else {
                i13 = i12;
                index = lazyGridMeasuredItem.getIndex();
            }
            List<Integer> list3 = list;
            size = list3.size();
            arrayListEmptyList = null;
            listEmptyList = null;
            i14 = 0;
            while (i14 < size) {
                int i47 = index;
                int iIntValue = list.get(i14).intValue();
                if (iIntValue < 0 || iIntValue >= index2) {
                    f4 = f5;
                    arrayDeque2 = arrayDeque3;
                    i25 = i10;
                    i26 = size;
                    i27 = i14;
                    i28 = i39;
                    i29 = i42;
                } else {
                    i26 = size;
                    int iSpanOf = lazyGridMeasuredLineProvider.spanOf(iIntValue);
                    i27 = i14;
                    f4 = f5;
                    arrayDeque2 = arrayDeque3;
                    i29 = i42;
                    i28 = i39;
                    i25 = i10;
                    LazyGridMeasuredItem lazyGridMeasuredItemMo2152getAndMeasurehBUhpc = lazyGridMeasuredItemProvider.mo2152getAndMeasurehBUhpc(iIntValue, 0, iSpanOf, lazyGridMeasuredLineProvider.m2181childConstraintsJhjzzOo$foundation(0, iSpanOf));
                    ArrayList arrayList = listEmptyList == null ? new ArrayList() : listEmptyList;
                    arrayList.add(lazyGridMeasuredItemMo2152getAndMeasurehBUhpc);
                    listEmptyList = arrayList;
                }
                i14 = i27 + 1;
                arrayDeque3 = arrayDeque2;
                i10 = i25;
                f5 = f4;
                size = i26;
                i42 = i29;
                i39 = i28;
                index = i47;
            }
            i15 = index;
            float f7 = f5;
            arrayDeque = arrayDeque3;
            int i48 = i10;
            int i49 = i39;
            int i50 = i42;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            ArrayDeque arrayDeque4 = arrayDeque;
            int i51 = index2;
            listLinesRetainedForLookahead = linesRetainedForLookahead(i15, i, lazyGridMeasuredLineProvider, z4, arrayDeque4, lazyGridLayoutInfo);
            int i52 = i;
            LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider2 = lazyGridMeasuredLineProvider;
            size2 = list3.size();
            i16 = 0;
            while (i16 < size2) {
                int iIntValue2 = list.get(i16).intValue();
                if (i15 + 1 > iIntValue2 || iIntValue2 >= i52) {
                    i23 = size2;
                } else {
                    if (z4) {
                        int size4 = listLinesRetainedForLookahead.size();
                        int i53 = 0;
                        while (i53 < size4) {
                            int i54 = i53;
                            LazyGridMeasuredItem[] items3 = listLinesRetainedForLookahead.get(i53).getItems();
                            int i55 = size2;
                            int length = items3.length;
                            int i56 = 0;
                            while (i56 < length) {
                                int i57 = i56;
                                if (items3[i56].getIndex() == iIntValue2) {
                                    i23 = i55;
                                } else {
                                    i56 = i57 + 1;
                                }
                            }
                            i53 = i54 + 1;
                            size2 = i55;
                        }
                    }
                    int i58 = i16;
                    int iSpanOf2 = lazyGridMeasuredLineProvider2.spanOf(iIntValue2);
                    i23 = size2;
                    i24 = i58;
                    LazyGridMeasuredItem lazyGridMeasuredItemMo2152getAndMeasurehBUhpc2 = lazyGridMeasuredItemProvider.mo2152getAndMeasurehBUhpc(iIntValue2, 0, iSpanOf2, lazyGridMeasuredLineProvider2.m2181childConstraintsJhjzzOo$foundation(0, iSpanOf2));
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = new ArrayList();
                    }
                    List list4 = arrayListEmptyList;
                    list4.add(lazyGridMeasuredItemMo2152getAndMeasurehBUhpc2);
                    arrayListEmptyList = list4;
                    i16 = i24 + 1;
                    i52 = i;
                    lazyGridMeasuredLineProvider2 = lazyGridMeasuredLineProvider;
                    size2 = i23;
                }
                i24 = i16;
                i16 = i24 + 1;
                i52 = i;
                lazyGridMeasuredLineProvider2 = lazyGridMeasuredLineProvider;
                size2 = i23;
            }
            if (arrayListEmptyList == null) {
                arrayListEmptyList = CollectionsKt.emptyList();
            }
            List list5 = arrayListEmptyList;
            if (i3 <= 0 || i5 < 0) {
                size3 = arrayDeque.size();
                i17 = 0;
                while (i17 < size3) {
                    int mainAxisSizeWithSpacings4 = ((LazyGridMeasuredLine) arrayDeque.get(i17)).getMainAxisSizeWithSpacings();
                    if (i11 == 0 || mainAxisSizeWithSpacings4 > i11 || i17 == CollectionsKt.getLastIndex(arrayDeque4)) {
                        break;
                    }
                    i11 -= mainAxisSizeWithSpacings4;
                    i17++;
                    lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque.get(i17);
                }
            }
            int i59 = i11;
            LazyGridMeasuredLine lazyGridMeasuredLine3 = lazyGridMeasuredLine2;
            int iM9067getMaxWidthimpl = !z ? Constraints.m9067getMaxWidthimpl(j) : ConstraintsKt.m9084constrainWidthK40F9xA(j, i48);
            int iM9083constrainHeightK40F9xA = !z ? ConstraintsKt.m9083constrainHeightK40F9xA(j, i48) : Constraints.m9066getMaxHeightimpl(j);
            if (listLinesRetainedForLookahead.isEmpty()) {
                listPlus = CollectionsKt.plus((Collection) arrayDeque, (Iterable) listLinesRetainedForLookahead);
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                i18 = i2;
                z5 = z;
                horizontal2 = horizontal;
                density2 = density;
                i19 = i48;
                function32 = function3;
                i20 = iM9067getMaxWidthimpl;
                i21 = i13;
                z6 = false;
                list2 = listEmptyList;
            } else {
                listPlus = arrayDeque4;
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                i18 = i2;
                horizontal2 = horizontal;
                density2 = density;
                i19 = i48;
                function32 = function3;
                i20 = iM9067getMaxWidthimpl;
                i21 = i13;
                z6 = false;
                list2 = listEmptyList;
                z5 = z;
            }
            final List<LazyGridMeasuredItem> listCalculateItemsOffsets = calculateItemsOffsets(listPlus, list2, list5, i20, iM9083constrainHeightK40F9xA, i19, i18, i21, z5, vertical, horizontal2, z2, density2);
            int i60 = i19;
            int i61 = i18;
            lazyLayoutItemAnimator.onMeasured((int) f7, i20, iM9083constrainHeightK40F9xA, listCalculateItemsOffsets, lazyGridMeasuredItemProvider2.getKeyIndexMap(), lazyGridMeasuredItemProvider2, z, z4, i8, z3, i59, i60, coroutineScope, graphicsContext);
            if (z4) {
                long jM2206getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m2206getMinSizeToFitDisappearingItemsYbymL2g();
                if (IntSize.m9283equalsimpl0(jM2206getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                    i22 = i20;
                } else {
                    int i62 = z ? iM9083constrainHeightK40F9xA : i20;
                    int iM9084constrainWidthK40F9xA = ConstraintsKt.m9084constrainWidthK40F9xA(j, Math.max(i20, (int) (jM2206getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                    iM9083constrainHeightK40F9xA = ConstraintsKt.m9083constrainHeightK40F9xA(j, Math.max(iM9083constrainHeightK40F9xA, (int) (jM2206getMinSizeToFitDisappearingItemsYbymL2g2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
                    int i63 = z ? iM9083constrainHeightK40F9xA : iM9084constrainWidthK40F9xA;
                    if (i63 != i62) {
                        int size5 = listCalculateItemsOffsets.size();
                        for (?? r3 = z6; r3 < size5; r3++) {
                            listCalculateItemsOffsets.get(r3).updateMainAxisLayoutSize(i63);
                        }
                    }
                    i22 = iM9084constrainWidthK40F9xA;
                }
            }
            int i64 = iM9083constrainHeightK40F9xA;
            final List listApplyStickyItems = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, i51, i15, listCalculateItemsOffsets, lazyGridMeasuredItemProvider2.getHeaderIndices(), i3, i4, i22, i64, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$7(lazyGridMeasuredLineProvider, lazyGridMeasuredItemProvider2, ((Integer) obj).intValue());
                }
            });
            if (i15 == i - 1 && i60 <= i61) {
                z7 = z6;
            }
            return new LazyGridMeasureResult(lazyGridMeasuredLine3, i59, z7, f7, function32.invoke(Integer.valueOf(i22), Integer.valueOf(i64), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$8(mutableState, listCalculateItemsOffsets, listApplyStickyItems, z4, (Placeable.PlacementScope) obj);
                }
            }), f6, z9, coroutineScope, density, i8, function1, function12, LazyLayoutMeasuredItemKt.updatedVisibleItems(i51, i15, listCalculateItemsOffsets, listApplyStickyItems), i50, i49, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        i9 = iRound;
        i10 = mainAxisSizeWithSpacings2;
        i11 = mainAxisSizeWithSpacings3;
        if (MathKt.getSign(Math.round(f)) == MathKt.getSign(i9)) {
        }
        f2 = f - f5;
        f3 = 0.0f;
        if (z4) {
            f3 = (i9 - iRound) + f2;
        }
        float f62 = f3;
        if (!(i11 < 0)) {
        }
        i12 = -i11;
        LazyGridMeasuredLine lazyGridMeasuredLine22 = (LazyGridMeasuredLine) arrayDeque3.firstOrNull();
        if (lazyGridMeasuredLine22 != null) {
        }
        lazyGridMeasuredLine = (LazyGridMeasuredLine) arrayDeque3.lastOrNull();
        if (lazyGridMeasuredLine != null) {
            i13 = i12;
            index = 0;
        }
        List<Integer> list32 = list;
        size = list32.size();
        arrayListEmptyList = null;
        listEmptyList = null;
        i14 = 0;
        while (i14 < size) {
        }
        i15 = index;
        float f72 = f5;
        arrayDeque = arrayDeque3;
        int i482 = i10;
        int i492 = i39;
        int i502 = i42;
        if (listEmptyList == null) {
        }
        ArrayDeque arrayDeque42 = arrayDeque;
        int i512 = index2;
        listLinesRetainedForLookahead = linesRetainedForLookahead(i15, i, lazyGridMeasuredLineProvider, z4, arrayDeque42, lazyGridLayoutInfo);
        int i522 = i;
        LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider22 = lazyGridMeasuredLineProvider;
        size2 = list32.size();
        i16 = 0;
        while (i16 < size2) {
        }
        if (arrayListEmptyList == null) {
        }
        List list52 = arrayListEmptyList;
        if (i3 <= 0) {
            size3 = arrayDeque.size();
            i17 = 0;
            while (i17 < size3) {
            }
        }
        int i592 = i11;
        LazyGridMeasuredLine lazyGridMeasuredLine32 = lazyGridMeasuredLine22;
        int iM9067getMaxWidthimpl2 = !z ? Constraints.m9067getMaxWidthimpl(j) : ConstraintsKt.m9084constrainWidthK40F9xA(j, i482);
        int iM9083constrainHeightK40F9xA2 = !z ? ConstraintsKt.m9083constrainHeightK40F9xA(j, i482) : Constraints.m9066getMaxHeightimpl(j);
        if (listLinesRetainedForLookahead.isEmpty()) {
        }
        final List listCalculateItemsOffsets2 = calculateItemsOffsets(listPlus, list2, list52, i20, iM9083constrainHeightK40F9xA2, i19, i18, i21, z5, vertical, horizontal2, z2, density2);
        int i602 = i19;
        int i612 = i18;
        lazyLayoutItemAnimator.onMeasured((int) f72, i20, iM9083constrainHeightK40F9xA2, listCalculateItemsOffsets2, lazyGridMeasuredItemProvider2.getKeyIndexMap(), lazyGridMeasuredItemProvider2, z, z4, i8, z3, i592, i602, coroutineScope, graphicsContext);
        if (z4) {
        }
        int i642 = iM9083constrainHeightK40F9xA2;
        final List listApplyStickyItems2 = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, i512, i15, listCalculateItemsOffsets2, lazyGridMeasuredItemProvider2.getHeaderIndices(), i3, i4, i22, i642, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$7(lazyGridMeasuredLineProvider, lazyGridMeasuredItemProvider2, ((Integer) obj).intValue());
            }
        });
        if (i15 == i - 1) {
            z7 = z6;
        }
        return new LazyGridMeasureResult(lazyGridMeasuredLine32, i592, z7, f72, function32.invoke(Integer.valueOf(i22), Integer.valueOf(i642), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$8(mutableState, listCalculateItemsOffsets2, listApplyStickyItems2, z4, (Placeable.PlacementScope) obj);
            }
        }), f62, z9, coroutineScope, density, i8, function1, function12, LazyLayoutMeasuredItemKt.updatedVisibleItems(i512, i15, listCalculateItemsOffsets2, listApplyStickyItems2), i502, i492, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
    }

    static final LazyGridMeasuredItem measureLazyGrid_t1x4au0$lambda$7(LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i) {
        int iSpanOf = lazyGridMeasuredLineProvider.spanOf(i);
        return lazyGridMeasuredItemProvider.mo2152getAndMeasurehBUhpc(i, 0, iSpanOf, lazyGridMeasuredLineProvider.m2181childConstraintsJhjzzOo$foundation(0, iSpanOf));
    }

    static final Unit measureLazyGrid_t1x4au0$lambda$8(MutableState mutableState, final List list, final List list2, final boolean z, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$8$0(list, list2, z, (Placeable.PlacementScope) obj);
            }
        });
        ObservableScopeInvalidator.m2224attachToScopeimpl(mutableState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyGrid_t1x4au0$lambda$8$0(List list, List list2, boolean z, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyGridMeasuredItem) list.get(i)).place(placementScope, z);
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((LazyGridMeasuredItem) list2.get(i2)).place(placementScope, z);
        }
        return Unit.INSTANCE;
    }
}
