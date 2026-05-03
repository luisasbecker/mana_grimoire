package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyStaggeredGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0082\b\u001a£\u0001\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102\u001a,\u00103\u001a\u00020\u0015*\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0001H\u0002\u001aK\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010@\u001aG\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00012\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001aR\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001a\u00020\u0001H\u0082\b\u001a7\u0010L\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001a(\u0010O\u001a\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001a\u0014\u0010S\u001a\u00020\u0011*\u0002072\u0006\u0010T\u001a\u00020\u001aH\u0002\u001a\u001b\u0010U\u001a\u00020\u001a*\u0002072\u0006\u0010V\u001a\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0016\u0010Y\u001a\u00020\u001a*\u0002072\b\b\u0002\u0010Z\u001a\u00020\u001aH\u0000\u001a2\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001a\f\u0010]\u001a\u00020\u001a*\u000207H\u0002\u001a!\u0010^\u001a\u000207*\u0002072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b\u001a\u001c\u0010_\u001a\u00020\u0011*\u0002042\u0006\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020\u001aH\u0002\u001a\u001c\u0010b\u001a\u00020\u001a*\u0002042\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "withDebugLogging", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "position", "Lkotlin/Function2;", "calculateExtraItems", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", NativeProtocol.WEB_DIALOG_ACTION, "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", "transform", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int iIntValue = pinnedItems.get(size).intValue();
                    if (function12.invoke(Integer.valueOf(iIntValue)).booleanValue()) {
                        long jM2257getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(iIntValue, jM2257getSpanRangelOCCd4c);
                        function1.invoke(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ);
                        arrayList.add(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int iIntValue2 = pinnedItems.get(i2).intValue();
                if (function12.invoke(Integer.valueOf(iIntValue2)).booleanValue()) {
                    long jM2257getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(iIntValue2, jM2257getSpanRangelOCCd4c2);
                    function1.invoke(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2);
                    arrayList.add(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i, int i2, int i3) {
        int size = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            size += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(size);
        while (true) {
            for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i4 = -1;
                    int i5 = Integer.MAX_VALUE;
                    for (int i6 = 0; i6 < length; i6++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemFirstOrNull = arrayDequeArr[i6].firstOrNull();
                        int index = lazyStaggeredGridMeasuredItemFirstOrNull != null ? lazyStaggeredGridMeasuredItemFirstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i5 > index) {
                            i4 = i6;
                            i5 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemRemoveFirst = arrayDequeArr[i4].removeFirst();
                    if (lazyStaggeredGridMeasuredItemRemoveFirst.getLane() == i4) {
                        long jM2272constructorimpl = SpanRange.m2272constructorimpl(lazyStaggeredGridMeasuredItemRemoveFirst.getLane(), lazyStaggeredGridMeasuredItemRemoveFirst.getSpan());
                        int iM2262maxInRangejy6DScQ = m2262maxInRangejy6DScQ(iArr, jM2272constructorimpl);
                        int i7 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i4];
                        if (lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSize() + iM2262maxInRangejy6DScQ >= i2 && iM2262maxInRangejy6DScQ <= i3) {
                            lazyStaggeredGridMeasuredItemRemoveFirst.position(iM2262maxInRangejy6DScQ, i7, i);
                            arrayList.add(lazyStaggeredGridMeasuredItemRemoveFirst);
                        }
                        int i8 = (int) (jM2272constructorimpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
                        for (int i9 = (int) (jM2272constructorimpl >> 32); i9 < i8; i9++) {
                            iArr[i9] = lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSizeWithSpacings() + iM2262maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    private static final void debugLog(Function0<String> function0) {
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            int i3 = iArr[length];
            if (i3 >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), i3)) {
                if (lazyStaggeredGridMeasureContext.getLaneInfo().getLane(i3) == -2) {
                    int length2 = iArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            i4 = -1;
                            break;
                        } else if (iArr[i4] == i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    int i5 = i4 + 1;
                    if (i5 <= length) {
                        while (true) {
                            if (iArr[i5] == i3) {
                                iArr[i5] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, i3, i5);
                            }
                            if (i5 == length) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                    length = i4;
                }
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(i3, length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                function1.invoke(list.get(i));
            }
            return;
        }
        int size2 = list.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i2 = size2 - 1;
            function1.invoke(list.get(size2));
            if (i2 < 0) {
                return;
            } else {
                size2 = i2;
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (!z) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                function1.invoke(list.get(i2));
            }
            return;
        }
        int size2 = list.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i3 = size2 - 1;
            function1.invoke(list.get(size2));
            if (i3 < 0) {
                return;
            } else {
                size2 = i3;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    /* JADX INFO: renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m2261forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int iIntValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > iIntValue) {
                i = i3;
                i2 = iIntValue;
            }
        }
        return i;
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2, boolean z, Function2<? super LazyStaggeredGridMeasuredItem, ? super Integer, Unit> function2) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int iMin;
        int size;
        int i3;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        if (z && lazyStaggeredGridMeasureContext.getApproachLayoutInfo() != null && !lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
            int size2 = visibleItemsInfo.size();
            while (true) {
                size2--;
                if (-1 >= size2) {
                    lazyStaggeredGridItemInfo = null;
                    break;
                }
                if (visibleItemsInfo.get(size2).getIndex() > i && (size2 == 0 || visibleItemsInfo.get(size2 - 1).getIndex() <= i)) {
                    break;
                }
            }
            lazyStaggeredGridItemInfo = visibleItemsInfo.get(size2);
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List) lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (iMin = Math.min(lazyStaggeredGridItemInfo3.getIndex(), i2 - 1))) {
                ArrayList arrayList = null;
                while (true) {
                    if (arrayList != null) {
                        int size3 = arrayList.size();
                        for (int i4 = 0; i4 < size3; i4++) {
                            if (arrayList.get(i4).getIndex() == index) {
                                break;
                            }
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        List<LazyStaggeredGridItemInfo> visibleItemsInfo2 = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
                        size = visibleItemsInfo2.size();
                        i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                lazyStaggeredGridItemInfo2 = null;
                                break;
                            }
                            lazyStaggeredGridItemInfo2 = visibleItemsInfo2.get(i3);
                            if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                                break;
                            }
                            i3++;
                        }
                        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = lazyStaggeredGridItemInfo2;
                        int lane = lazyStaggeredGridItemInfo4 == null ? lazyStaggeredGridItemInfo4.getLane() : 0;
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                        arrayList.add(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ);
                        int[] positions = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                        function2.invoke(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ, Integer.valueOf(positions.length > lane ? positions[lane] : 0));
                    } else {
                        if (arrayList == null) {
                        }
                        List<LazyStaggeredGridItemInfo> visibleItemsInfo22 = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
                        size = visibleItemsInfo22.size();
                        i3 = 0;
                        while (true) {
                            if (i3 < size) {
                            }
                            i3++;
                        }
                        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo42 = lazyStaggeredGridItemInfo2;
                        if (lazyStaggeredGridItemInfo42 == null) {
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                        arrayList.add(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2);
                        int[] positions2 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                        function2.invoke(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2, Integer.valueOf(positions2.length > lane ? positions2[lane] : 0));
                    }
                    if (index == iMin) {
                        return arrayList;
                    }
                    index++;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m2262maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        int iMax = Integer.MIN_VALUE;
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            iMax = Math.max(iMax, iArr[i2]);
        }
        return iMax;
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x02fd, code lost:
    
        r6 = indexOfMinValue$default(r9, 0, 1, null);
        r7 = indexOfMaxValue(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0308, code lost:
    
        if (r6 == r7) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030e, code lost:
    
        if (r9[r6] != r9[r7]) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0310, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0312, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0313, code lost:
    
        r7 = r28[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0316, code lost:
    
        if (r7 != (-1)) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0318, code lost:
    
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0319, code lost:
    
        r7 = findPreviousItemIndex(r0, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x031d, code lost:
    
        if (r7 >= 0) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x031f, code lost:
    
        r10 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0321, code lost:
    
        if (r1 != false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0327, code lost:
    
        if (measure$lambda$0$misalignedStart(r10, r0, r9, r6) == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0329, code lost:
    
        if (r50 == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x032b, code lost:
    
        r0.getLaneInfo().reset();
        r1 = r10.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0336, code lost:
    
        if (r3 >= r1) goto L568;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0338, code lost:
    
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x033f, code lost:
    
        r1 = r9.length;
        r3 = new int[r1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0343, code lost:
    
        if (r4 >= r1) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0345, code lost:
    
        r3[r4] = r9[r6];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0353, code lost:
    
        return measure(r0, r27, r2, r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0354, code lost:
    
        r11 = r27;
        r24 = r2;
        r28 = r3;
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x035e, code lost:
    
        r11 = r27;
        r10 = r28;
        r25 = r1;
        r24 = r2;
        r1 = r0.m2257getSpanRangelOCCd4c(r0.getItemProvider(), r7, r6);
        r6 = r0.getLaneInfo();
        r30 = r12;
        r27 = r13;
        r12 = (int) (r1 & androidx.media3.muxer.MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        r28 = r3;
        r13 = r4;
        r3 = (int) (r1 >> r18);
        r4 = r12 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0382, code lost:
    
        if (r4 == 1) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0384, code lost:
    
        r29 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0387, code lost:
    
        r29 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0389, code lost:
    
        if (r29 == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x038b, code lost:
    
        r15 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x038d, code lost:
    
        r15 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x038e, code lost:
    
        r6.setLane(r7, r15);
        r6 = r0.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(r7, r1);
        r1 = m2262maxInRangejy6DScQ(r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x039e, code lost:
    
        if (r4 == 1) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03a0, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03a2, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03a3, code lost:
    
        if (r2 == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03a5, code lost:
    
        r2 = r0.getLaneInfo().getGaps(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03ae, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03af, code lost:
    
        if (r3 >= r12) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x03b3, code lost:
    
        if (r9[r3] == r1) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03b5, code lost:
    
        r25 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03b7, code lost:
    
        r49[r3].addFirst(r6);
        r10[r3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03be, code lost:
    
        if (r2 != null) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03c0, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03c2, code lost:
    
        r4 = r2[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x03c4, code lost:
    
        r9[r3] = (r1 + r6.getMainAxisSizeWithSpacings()) + r4;
        r3 = r3 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:334:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x072f A[LOOP:21: B:317:0x0684->B:357:0x072f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x07c8  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x07f8  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0739 A[EDGE_INSN: B:542:0x0739->B:358:0x0739 BREAK  A[LOOP:21: B:317:0x0684->B:357:0x072f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        char c;
        int i2;
        int iIndexOf;
        int i3;
        int i4;
        int i5;
        int[] iArr3;
        int i6;
        int[] iArr4;
        int i7;
        int i8;
        int i9;
        int i10;
        String str;
        int i11;
        int i12;
        int[] iArr5;
        boolean z2;
        int i13;
        int i14;
        int i15;
        int i16;
        String str2;
        int[] iArr6;
        float f;
        int[] iArr7;
        List listEmptyList;
        List<LazyStaggeredGridMeasuredItem> list;
        int[] iArr8;
        float f2;
        ArrayList arrayList;
        int i17;
        int i18;
        boolean z3;
        int i19;
        boolean z4;
        boolean z5;
        ArrayList arrayList2;
        List<Integer> list2;
        boolean z6;
        boolean z7;
        boolean z8;
        int i20;
        int i21;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int iMin;
        boolean z9;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        boolean z10;
        boolean z11;
        int i22;
        int[] gaps;
        LazyStaggeredGridLaneInfo lazyStaggeredGridLaneInfo;
        int i23;
        boolean z12;
        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext2.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext2.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext2.getLaneCount() == 0) {
            int iM9069getMinWidthimpl = Constraints.m9069getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints());
            int iM9068getMinHeightimpl = Constraints.m9068getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints());
            lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().onMeasured(0, iM9069getMinWidthimpl, iM9068getMinHeightimpl, new ArrayList(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.getIsVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.getIsInLookaheadScope(), 0, 0, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
            if (!measureScope.isLookingAhead()) {
                long jM2206getMinSizeToFitDisappearingItemsYbymL2g = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().m2206getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m9283equalsimpl0(jM2206getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                    iM9069getMinWidthimpl = ConstraintsKt.m9084constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (jM2206getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    iM9068getMinHeightimpl = ConstraintsKt.m9083constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (jM2206getMinSizeToFitDisappearingItemsYbymL2g & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
                }
            }
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, iM9069getMinWidthimpl, iM9068getMinHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyStaggeredGridMeasureKt.measure$lambda$0$0((Placeable.PlacementScope) obj);
                }
            }, 4, null), 0.0f, false, lazyStaggeredGridMeasureContext.getIsVertical(), false, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, itemCount, CollectionsKt.emptyList(), IntSize.m9280constructorimpl((((long) Constraints.m9068getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Constraints.m9069getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints())) << 32)), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        String str3 = "copyOf(...)";
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf2, "copyOf(...)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext2, iArrCopyOf, itemCount);
        offsetBy(iArrCopyOf2, -i);
        int laneCount = lazyStaggeredGridMeasureContext2.getLaneCount();
        ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
        for (int i24 = 0; i24 < laneCount; i24++) {
            arrayDequeArr[i24] = new ArrayDeque(16);
        }
        offsetBy(iArrCopyOf2, -lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        boolean z13 = false;
        while (true) {
            if (!measure$lambda$0$hasSpaceBeforeFirst(iArrCopyOf, iArrCopyOf2, lazyStaggeredGridMeasureContext2)) {
                c = ' ';
                i2 = 0;
                iIndexOf = -1;
                break;
            }
            iIndexOf = indexOfMaxValue(iArrCopyOf);
            c = ' ';
            int i25 = iArrCopyOf[iIndexOf];
            int length = iArrCopyOf2.length;
            for (int i26 = 0; i26 < length; i26++) {
                if (iArrCopyOf[i26] != iArrCopyOf[iIndexOf]) {
                    int i27 = iArrCopyOf2[i26];
                    int i28 = iArrCopyOf2[iIndexOf];
                    if (i27 < i28) {
                        iArrCopyOf2[i26] = i28;
                    }
                }
            }
            i2 = 0;
            int iFindPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i25, iIndexOf);
            if (iFindPreviousItemIndex < 0) {
                break;
            }
            long jM2257getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iFindPreviousItemIndex, iIndexOf);
            LazyStaggeredGridLaneInfo laneInfo = lazyStaggeredGridMeasureContext2.getLaneInfo();
            int i29 = (int) (jM2257getSpanRangelOCCd4c & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            ArrayDeque[] arrayDequeArr2 = arrayDequeArr;
            boolean z14 = z13;
            int i30 = (int) (jM2257getSpanRangelOCCd4c >> 32);
            int i31 = i29 - i30;
            laneInfo.setLane(iFindPreviousItemIndex, i31 != 1 ? -2 : i30);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(iFindPreviousItemIndex, jM2257getSpanRangelOCCd4c);
            int iM2262maxInRangejy6DScQ = m2262maxInRangejy6DScQ(iArrCopyOf2, jM2257getSpanRangelOCCd4c);
            int[] gaps2 = i31 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(iFindPreviousItemIndex) : null;
            boolean z15 = z14;
            while (i30 < i29) {
                iArrCopyOf[i30] = iFindPreviousItemIndex;
                int mainAxisSizeWithSpacings = iM2262maxInRangejy6DScQ + lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ.getMainAxisSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[i30]);
                iArrCopyOf2[i30] = mainAxisSizeWithSpacings;
                if (lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + mainAxisSizeWithSpacings <= 0) {
                    z15 = true;
                }
                i30++;
            }
            arrayDequeArr = arrayDequeArr2;
            z13 = z15;
        }
        ArrayDeque[] arrayDequeArr3 = arrayDequeArr;
        boolean z16 = z13;
        int i32 = -lazyStaggeredGridMeasureContext2.getBeforeContentPadding();
        int i33 = iArrCopyOf2[i2];
        if (i33 < i32) {
            offsetBy(iArrCopyOf2, i32 - i33);
            i3 = i - (i32 - i33);
        } else {
            i3 = i;
        }
        offsetBy(iArrCopyOf2, lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i34 = -1;
        if (iIndexOf == -1) {
            iIndexOf = ArraysKt.indexOf(iArrCopyOf, i2);
        }
        if (iIndexOf != -1 && measure$lambda$0$misalignedStart(iArrCopyOf, lazyStaggeredGridMeasureContext2, iArrCopyOf2, iIndexOf) && z) {
            lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
            int length2 = iArrCopyOf.length;
            int[] iArr9 = new int[length2];
            int i35 = 0;
            while (i35 < length2) {
                iArr9[i35] = i34;
                i35++;
                i34 = -1;
            }
            int length3 = iArrCopyOf2.length;
            int[] iArr10 = new int[length3];
            for (int i36 = 0; i36 < length3; i36++) {
                iArr10[i36] = iArrCopyOf2[iIndexOf];
            }
            return measure(lazyStaggeredGridMeasureContext2, i3, iArr9, iArr10, false);
        }
        int[] iArrCopyOf3 = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf3, "copyOf(...)");
        int length4 = iArrCopyOf2.length;
        int[] iArr11 = new int[length4];
        for (int i37 = 0; i37 < length4; i37++) {
            iArr11[i37] = -iArrCopyOf2[i37];
        }
        int mainAxisSpacing = lazyStaggeredGridMeasureContext2.getMainAxisSpacing() + i32;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext2.getAfterContentPadding(), 0);
        ArrayDeque[] arrayDequeArr4 = arrayDequeArr3;
        int iIndexOfMinValue$default = indexOfMinValue$default(iArrCopyOf3, 0, 1, null);
        int laneCount2 = 0;
        while (iIndexOfMinValue$default != -1 && laneCount2 < lazyStaggeredGridMeasureContext2.getLaneCount()) {
            int i38 = iArrCopyOf3[iIndexOfMinValue$default];
            int iIndexOfMinValue = indexOfMinValue(iArrCopyOf3, i38);
            laneCount2++;
            if (i38 >= 0) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope = measureScope;
                int i39 = i3;
                long jM2257getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i38, iIndexOfMinValue$default);
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(i38, jM2257getSpanRangelOCCd4c2);
                LazyStaggeredGridLaneInfo laneInfo2 = lazyStaggeredGridMeasureContext2.getLaneInfo();
                int[] iArr12 = iArrCopyOf;
                int[] iArr13 = iArrCopyOf2;
                int i40 = (int) (jM2257getSpanRangelOCCd4c2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
                int i41 = itemCount;
                int i42 = (int) (jM2257getSpanRangelOCCd4c2 >> c);
                int i43 = i40 - i42;
                if (i43 != 1) {
                    lazyStaggeredGridLaneInfo = laneInfo2;
                    i23 = -2;
                } else {
                    lazyStaggeredGridLaneInfo = laneInfo2;
                    i23 = i42;
                }
                lazyStaggeredGridLaneInfo.setLane(i38, i23);
                int iM2262maxInRangejy6DScQ2 = m2262maxInRangejy6DScQ(iArr11, jM2257getSpanRangelOCCd4c2);
                for (int i44 = i42; i44 < i40; i44++) {
                    iArr11[i44] = lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2.getMainAxisSizeWithSpacings() + iM2262maxInRangejy6DScQ2;
                    iArrCopyOf3[i44] = i38;
                    arrayDequeArr4[i44].addLast(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2);
                }
                if (iM2262maxInRangejy6DScQ2 >= mainAxisSpacing || iArr11[i42] > mainAxisSpacing) {
                    z12 = z16;
                } else {
                    lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ2.setVisible(false);
                    z12 = true;
                }
                if (i43 != 1) {
                    z16 = z12;
                    laneCount2 = lazyStaggeredGridMeasureContext2.getLaneCount();
                    iIndexOfMinValue$default = iIndexOfMinValue;
                } else {
                    z16 = z12;
                    iIndexOfMinValue$default = iIndexOfMinValue;
                    laneCount2 = laneCount2;
                }
                measureScope = lazyLayoutMeasureScope;
                i3 = i39;
                iArrCopyOf = iArr12;
                iArrCopyOf2 = iArr13;
                itemCount = i41;
            } else {
                iIndexOfMinValue$default = iIndexOfMinValue;
            }
        }
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = measureScope;
        int i45 = i3;
        int[] iArr14 = iArrCopyOf;
        int[] iArr15 = iArrCopyOf2;
        int i46 = itemCount;
        loop9: while (true) {
            int i47 = 0;
            while (true) {
                if (i47 >= length4) {
                    for (int i48 = 0; i48 < laneCount; i48++) {
                        if (!arrayDequeArr4[i48].isEmpty()) {
                            i4 = i46;
                            i5 = 1;
                            break loop9;
                        }
                    }
                } else {
                    int i49 = iArr11[i47];
                    if (i49 < iCoerceAtLeast || i49 <= 0) {
                        break;
                    }
                    i47++;
                }
            }
            i5 = 1;
            int iIndexOfMinValue$default2 = indexOfMinValue$default(iArr11, 0, 1, null);
            int iMaxOrThrow = ArraysKt.maxOrThrow(iArrCopyOf3) + 1;
            i4 = i46;
            if (iMaxOrThrow >= i4) {
                break;
            }
            int i50 = length4;
            String str4 = str3;
            boolean z17 = z16;
            ArrayDeque[] arrayDequeArr5 = arrayDequeArr4;
            int i51 = iCoerceAtLeast;
            LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope2;
            int i52 = i45;
            long jM2257getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext2.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iMaxOrThrow, iIndexOfMinValue$default2);
            LazyStaggeredGridLaneInfo laneInfo3 = lazyStaggeredGridMeasureContext2.getLaneInfo();
            int[] iArr16 = iArrCopyOf3;
            int i53 = (int) (jM2257getSpanRangelOCCd4c3 & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
            int i54 = (int) (jM2257getSpanRangelOCCd4c3 >> c);
            int i55 = i53 - i54;
            laneInfo3.setLane(iMaxOrThrow, i55 != 1 ? -2 : i54);
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(iMaxOrThrow, jM2257getSpanRangelOCCd4c3);
            int iM2262maxInRangejy6DScQ3 = m2262maxInRangejy6DScQ(iArr11, jM2257getSpanRangelOCCd4c3);
            if (i55 != 1) {
                gaps = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(iMaxOrThrow);
                if (gaps == null) {
                    gaps = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                }
            } else {
                gaps = null;
            }
            for (int i56 = i54; i56 < i53; i56++) {
                if (gaps != null) {
                    gaps[i56] = iM2262maxInRangejy6DScQ3 - iArr11[i56];
                }
                iArr16[i56] = iMaxOrThrow;
                iArr11[i56] = iM2262maxInRangejy6DScQ3 + lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ3.getMainAxisSizeWithSpacings();
                arrayDequeArr5[i56].addLast(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ3);
            }
            lazyStaggeredGridMeasureContext.getLaneInfo().setGaps(iMaxOrThrow, gaps);
            if (iM2262maxInRangejy6DScQ3 < mainAxisSpacing && iArr11[i54] <= mainAxisSpacing) {
                lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ3.setVisible(false);
            }
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            iArrCopyOf3 = iArr16;
            z16 = z17;
            i46 = i4;
            str3 = str4;
            lazyLayoutMeasureScope2 = lazyLayoutMeasureScope3;
            iCoerceAtLeast = i51;
            arrayDequeArr4 = arrayDequeArr5;
            length4 = i50;
            i45 = i52;
        }
        int i57 = 0;
        while (i57 < laneCount) {
            ArrayDeque arrayDeque = arrayDequeArr4[i57];
            while (arrayDeque.size() > i5 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIsVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps3 = lazyStaggeredGridMeasuredItem.getSpan() != i5 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr15[i57] = iArr15[i57] - (lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i57]));
                i5 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr14[i57] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i57++;
            i5 = 1;
        }
        int length5 = iArrCopyOf3.length;
        int i58 = 0;
        while (true) {
            if (i58 >= length5) {
                break;
            }
            if (iArrCopyOf3[i58] == i4 - 1) {
                offsetBy(iArr11, -lazyStaggeredGridMeasureContext2.getMainAxisSpacing());
                break;
            }
            i58++;
        }
        int i59 = 0;
        while (true) {
            if (i59 >= length4) {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() - iArr11[indexOfMaxValue(iArr11)];
                iArr3 = iArr15;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr11, mainAxisAvailableSize);
                boolean z18 = false;
                loop31: while (true) {
                    int length6 = iArr3.length;
                    int i60 = 0;
                    while (true) {
                        if (i60 >= length6) {
                            i6 = i45;
                            iArr4 = iArr14;
                            i7 = mainAxisAvailableSize;
                            i8 = i4;
                            i9 = iCoerceAtLeast;
                            break loop31;
                        }
                        if (iArr3[i60] < lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) {
                            break;
                        }
                        i60++;
                        length4 = length4;
                        iArr14 = iArr14;
                        i45 = i45;
                    }
                    str3 = str2;
                    mainAxisAvailableSize = i13;
                    z18 = z2;
                    length4 = i15;
                    iCoerceAtLeast = i16;
                    i4 = i14;
                    iArr14 = iArr5;
                    i45 = i12;
                }
                i10 = length4;
                str = str3;
                if (z18 && z) {
                    lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                    return measure(lazyStaggeredGridMeasureContext2, i6, iArr4, iArr3, false);
                }
                i11 = i6 + i7;
                int i61 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                if (i61 < 0) {
                    i11 += i61;
                    offsetBy(iArr11, i61);
                    offsetBy(iArr3, -i61);
                }
            } else {
                if (iArr11[i59] >= lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    i8 = i4;
                    i11 = i45;
                    i6 = i11;
                    iArr4 = iArr14;
                    iArr3 = iArr15;
                    i9 = iCoerceAtLeast;
                    i10 = length4;
                    str = str3;
                    break;
                }
                i59++;
            }
        }
        float fScrollToBeConsumed$foundation = lazyStaggeredGridMeasureContext2.getState().scrollToBeConsumed$foundation(lazyLayoutMeasureScope2.isLookingAhead());
        if (MathKt.getSign(Math.round(fScrollToBeConsumed$foundation)) != MathKt.getSign(i11) || Math.abs(Math.round(fScrollToBeConsumed$foundation)) < Math.abs(i11)) {
            iArr6 = iArr4;
            f = fScrollToBeConsumed$foundation;
        } else {
            iArr6 = iArr4;
            f = i11;
        }
        float f3 = fScrollToBeConsumed$foundation - f;
        float f4 = 0.0f;
        if (lazyLayoutMeasureScope2.isLookingAhead() && i11 > i6 && f3 <= 0.0f) {
            f4 = (i11 - i6) + f3;
        }
        float f5 = f4;
        int[] iArrCopyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf4, str);
        int length7 = iArrCopyOf4.length;
        for (int i62 = 0; i62 < length7; i62++) {
            iArrCopyOf4[i62] = -iArrCopyOf4[i62];
        }
        if (lazyStaggeredGridMeasureContext2.getBeforeContentPadding() > lazyStaggeredGridMeasureContext2.getMainAxisSpacing()) {
            for (int i63 = 0; i63 < laneCount; i63++) {
                ArrayDeque arrayDeque2 = arrayDequeArr4[i63];
                int size = arrayDeque2.size();
                int i64 = 0;
                while (i64 < size) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i64);
                    int[] gaps4 = lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int mainAxisSizeWithSpacings2 = lazyStaggeredGridMeasuredItem3.getMainAxisSizeWithSpacings() + (gaps4 == null ? 0 : gaps4[i63]);
                    if (i64 == CollectionsKt.getLastIndex(arrayDeque2) || (i22 = iArr3[i63]) == 0 || i22 < mainAxisSizeWithSpacings2) {
                        break;
                    }
                    iArr3[i63] = i22 - mainAxisSizeWithSpacings2;
                    i64++;
                    iArr6[i63] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i64)).getIndex();
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext2.getBeforeContentPadding() + lazyStaggeredGridMeasureContext2.getAfterContentPadding();
        int iM9067getMaxWidthimpl = lazyStaggeredGridMeasureContext2.getIsVertical() ? Constraints.m9067getMaxWidthimpl(lazyStaggeredGridMeasureContext2.getConstraints()) : ConstraintsKt.m9084constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr11) + beforeContentPadding);
        int iM9083constrainHeightK40F9xA = lazyStaggeredGridMeasureContext2.getIsVertical() ? ConstraintsKt.m9083constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr11) + beforeContentPadding) : Constraints.m9066getMaxHeightimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        int afterContentPadding = lazyStaggeredGridMeasureContext2.getAfterContentPadding() + (Math.min(lazyStaggeredGridMeasureContext2.getIsVertical() ? iM9083constrainHeightK40F9xA : iM9067getMaxWidthimpl, lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i65 = iArrCopyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size2 = pinnedItems.size() - 1;
        if (size2 >= 0) {
            int i66 = size2;
            ArrayList arrayList3 = null;
            while (true) {
                int i67 = i66 - 1;
                int iIntValue = pinnedItems.get(i66).intValue();
                int lane = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue);
                int i68 = i65;
                if (lane == -2 || lane == -1) {
                    for (int i69 = 0; i69 < laneCount; i69++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = (LazyStaggeredGridMeasuredItem) arrayDequeArr4[i69].firstOrNull();
                        if (!((lazyStaggeredGridMeasuredItem4 != null ? lazyStaggeredGridMeasuredItem4.getIndex() : -1) > iIntValue)) {
                            z11 = false;
                            break;
                        }
                    }
                    z11 = true;
                } else {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = (LazyStaggeredGridMeasuredItem) arrayDequeArr4[lane].firstOrNull();
                    if ((lazyStaggeredGridMeasuredItem5 != null ? lazyStaggeredGridMeasuredItem5.getIndex() : -1) <= iIntValue) {
                        z11 = false;
                        break;
                    }
                    z11 = true;
                }
                if (z11) {
                    iArr7 = iArrCopyOf4;
                    long jM2257getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue, 0);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(iIntValue, jM2257getSpanRangelOCCd4c4);
                    int mainAxisSizeWithSpacings3 = i68 - lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ4.getMainAxisSizeWithSpacings();
                    lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ4.position(mainAxisSizeWithSpacings3, 0, afterContentPadding);
                    arrayList3.add(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ4);
                    i65 = mainAxisSizeWithSpacings3;
                } else {
                    iArr7 = iArrCopyOf4;
                    i65 = i68;
                }
                if (i67 < 0) {
                    break;
                }
                i66 = i67;
                iArrCopyOf4 = iArr7;
            }
            listEmptyList = arrayList3;
        } else {
            iArr7 = iArrCopyOf4;
            listEmptyList = null;
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list3 = listEmptyList;
        int[] iArr17 = iArr7;
        int i70 = i9;
        List<LazyStaggeredGridMeasuredItem> listCalculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext2, arrayDequeArr4, iArr17, afterContentPadding, i32, i70);
        int mainAxisSizeWithSpacings4 = iArr17[0];
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem6 = (LazyStaggeredGridMeasuredItem) CollectionsKt.lastOrNull((List) listCalculateVisibleItems);
        int index2 = lazyStaggeredGridMeasuredItem6 != null ? lazyStaggeredGridMeasuredItem6.getIndex() : -1;
        if (!lazyLayoutMeasureScope2.isLookingAhead() || lazyStaggeredGridMeasureContext2.getApproachLayoutInfo() == null || lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            list = listCalculateVisibleItems;
            iArr8 = iArr6;
            f2 = f5;
            arrayList = null;
        } else {
            List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo();
            for (int size3 = visibleItemsInfo.size() - 1; -1 < size3; size3--) {
                if (visibleItemsInfo.get(size3).getIndex() > index2 && (size3 == 0 || visibleItemsInfo.get(size3 - 1).getIndex() <= index2)) {
                    lazyStaggeredGridItemInfo = visibleItemsInfo.get(size3);
                    break;
                }
            }
            lazyStaggeredGridItemInfo = null;
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List) lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (iMin = Math.min(lazyStaggeredGridItemInfo3.getIndex(), i8 - 1))) {
                int i71 = index;
                int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings4;
                ArrayList arrayList4 = null;
                while (true) {
                    if (arrayList4 != null) {
                        int size4 = arrayList4.size();
                        list = listCalculateVisibleItems;
                        int i72 = 0;
                        while (true) {
                            if (i72 >= size4) {
                                z10 = false;
                                break;
                            }
                            int i73 = i72;
                            if (((LazyStaggeredGridMeasuredItem) arrayList4.get(i72)).getIndex() == i71) {
                                z10 = true;
                                break;
                            }
                            i72 = i73 + 1;
                        }
                        z9 = z10;
                        if (z9) {
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                            }
                            List<LazyStaggeredGridItemInfo> visibleItemsInfo2 = lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo();
                            int size5 = visibleItemsInfo2.size();
                            iArr8 = iArr6;
                            int i74 = 0;
                            while (true) {
                                if (i74 >= size5) {
                                    lazyStaggeredGridItemInfo2 = null;
                                    break;
                                }
                                LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = visibleItemsInfo2.get(i74);
                                List<LazyStaggeredGridItemInfo> list4 = visibleItemsInfo2;
                                if (lazyStaggeredGridItemInfo4.getIndex() == i71) {
                                    lazyStaggeredGridItemInfo2 = lazyStaggeredGridItemInfo4;
                                    break;
                                }
                                i74++;
                                visibleItemsInfo2 = list4;
                            }
                            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo5 = lazyStaggeredGridItemInfo2;
                            int lane2 = lazyStaggeredGridItemInfo5 != null ? lazyStaggeredGridItemInfo5.getLane() : 0;
                            f2 = f5;
                            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(i71, lazyStaggeredGridMeasureContext2.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i71, lane2));
                            arrayList4.add(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ5);
                            int[] positions = lazyStaggeredGridMeasureContext2.getResolvedSlots().getPositions();
                            lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ5.position(mainAxisSizeWithSpacings5, positions.length > lane2 ? positions[lane2] : 0, afterContentPadding);
                            mainAxisSizeWithSpacings5 += lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ5.getMainAxisSizeWithSpacings();
                        } else {
                            iArr8 = iArr6;
                            f2 = f5;
                        }
                        if (i71 != iMin) {
                            break;
                        }
                        i71++;
                        listCalculateVisibleItems = list;
                        iArr6 = iArr8;
                        f5 = f2;
                    } else {
                        list = listCalculateVisibleItems;
                    }
                    if (z9) {
                    }
                    if (i71 != iMin) {
                    }
                }
                arrayList = arrayList4;
                mainAxisSizeWithSpacings4 = mainAxisSizeWithSpacings5;
            }
        }
        List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size6 = pinnedItems2.size();
        int i75 = 0;
        ArrayList arrayListEmptyList = null;
        while (i75 < size6) {
            int iIntValue2 = pinnedItems2.get(i75).intValue();
            int i76 = i8;
            if (iIntValue2 >= i76) {
                arrayList2 = arrayList;
                list2 = pinnedItems2;
            } else {
                if (arrayList != null) {
                    int size7 = arrayList.size();
                    list2 = pinnedItems2;
                    int i77 = 0;
                    while (true) {
                        if (i77 >= size7) {
                            arrayList2 = arrayList;
                            z8 = false;
                            break;
                        }
                        arrayList2 = arrayList;
                        if (((LazyStaggeredGridMeasuredItem) arrayList.get(i77)).getIndex() == iIntValue2) {
                            z8 = true;
                            break;
                        }
                        i77++;
                        arrayList = arrayList2;
                    }
                    z6 = z8;
                    if (!z6) {
                        z7 = false;
                        break;
                    }
                    int lane3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(iIntValue2);
                    if (lane3 == -2 || lane3 == -1) {
                        for (int i78 : iArrCopyOf3) {
                            if (i78 < iIntValue2) {
                            }
                        }
                        z7 = true;
                    } else {
                        if (iArrCopyOf3[lane3] >= iIntValue2) {
                            z7 = false;
                            break;
                        }
                        z7 = true;
                    }
                    if (z7) {
                        i20 = size6;
                        long jM2257getSpanRangelOCCd4c5 = lazyStaggeredGridMeasureContext2.m2257getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), iIntValue2, 0);
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = new ArrayList();
                        }
                        i21 = i75;
                        List list5 = arrayListEmptyList;
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ6 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m2266getAndMeasurejy6DScQ(iIntValue2, jM2257getSpanRangelOCCd4c5);
                        lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ6.position(mainAxisSizeWithSpacings4, 0, afterContentPadding);
                        mainAxisSizeWithSpacings4 += lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ6.getMainAxisSizeWithSpacings();
                        list5.add(lazyStaggeredGridMeasuredItemM2266getAndMeasurejy6DScQ6);
                        arrayListEmptyList = list5;
                    } else {
                        i20 = size6;
                        i21 = i75;
                    }
                    i75 = i21 + 1;
                    pinnedItems2 = list2;
                    size6 = i20;
                    arrayList = arrayList2;
                    i8 = i76;
                } else {
                    arrayList2 = arrayList;
                    list2 = pinnedItems2;
                }
                if (!z6) {
                    z7 = false;
                    break;
                }
                if (z7) {
                }
                i75 = i21 + 1;
                pinnedItems2 = list2;
                size6 = i20;
                arrayList = arrayList2;
                i8 = i76;
            }
            z7 = false;
            if (z7) {
            }
            i75 = i21 + 1;
            pinnedItems2 = list2;
            size6 = i20;
            arrayList = arrayList2;
            i8 = i76;
        }
        int i79 = i8;
        ArrayList arrayList5 = arrayList;
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        final ArrayList arrayList6 = new ArrayList();
        arrayList6.addAll(list3);
        arrayList6.addAll(list);
        if (arrayList5 != null) {
            arrayList6.addAll(arrayList5);
        }
        arrayList6.addAll(arrayListEmptyList);
        lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().onMeasured((int) f, iM9067getMaxWidthimpl, iM9083constrainHeightK40F9xA, arrayList6, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.getIsVertical(), lazyLayoutMeasureScope2.isLookingAhead(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.getIsInLookaheadScope(), ArraysKt.minOrThrow(iArr3), ArraysKt.maxOrThrow(iArr11) + beforeContentPadding, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
        if (!lazyLayoutMeasureScope2.isLookingAhead()) {
            long jM2206getMinSizeToFitDisappearingItemsYbymL2g2 = lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().m2206getMinSizeToFitDisappearingItemsYbymL2g();
            if (IntSize.m9283equalsimpl0(jM2206getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m9290getZeroYbymL2g())) {
                i17 = iM9067getMaxWidthimpl;
                i18 = iM9083constrainHeightK40F9xA;
            } else {
                int i80 = lazyStaggeredGridMeasureContext2.getIsVertical() ? iM9083constrainHeightK40F9xA : iM9067getMaxWidthimpl;
                int iM9084constrainWidthK40F9xA = ConstraintsKt.m9084constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), Math.max(iM9067getMaxWidthimpl, (int) (jM2206getMinSizeToFitDisappearingItemsYbymL2g2 >> c)));
                int iM9083constrainHeightK40F9xA2 = ConstraintsKt.m9083constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), Math.max(iM9083constrainHeightK40F9xA, (int) (jM2206getMinSizeToFitDisappearingItemsYbymL2g2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
                int i81 = lazyStaggeredGridMeasureContext2.getIsVertical() ? iM9083constrainHeightK40F9xA2 : iM9084constrainWidthK40F9xA;
                if (i81 != i80) {
                    int size8 = arrayList6.size();
                    for (int i82 = 0; i82 < size8; i82++) {
                        ((LazyStaggeredGridMeasuredItem) arrayList6.get(i82)).updateMainAxisLayoutSize(i81);
                    }
                }
                i17 = iM9084constrainWidthK40F9xA;
                i18 = iM9083constrainHeightK40F9xA2;
            }
        }
        int i83 = i10;
        int i84 = 0;
        while (true) {
            if (i84 >= i83) {
                z3 = false;
                break;
            }
            if (iArr11[i84] > lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                z3 = true;
                break;
            }
            i84++;
        }
        if (!z3) {
            int length8 = iArrCopyOf3.length;
            int i85 = 0;
            while (true) {
                if (i85 >= length8) {
                    z5 = true;
                    break;
                }
                if (!(iArrCopyOf3[i85] < i79 + (-1))) {
                    z5 = false;
                    break;
                }
                i85++;
            }
            if (z5) {
                i19 = i79;
                z4 = true;
            } else {
                i19 = i79;
                z4 = false;
            }
        }
        final LazyLayoutMeasureScope lazyLayoutMeasureScope4 = lazyLayoutMeasureScope2;
        return new LazyStaggeredGridMeasureResult(iArr8, iArr3, f, MeasureScope.layout$default(lazyLayoutMeasureScope2, i17, i18, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyStaggeredGridMeasureKt.measure$lambda$0$37(lazyStaggeredGridMeasureContext2, arrayList6, lazyLayoutMeasureScope4, (Placeable.PlacementScope) obj);
            }
        }, 4, null), f2, z4, lazyStaggeredGridMeasureContext2.getIsVertical(), z16, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope4, i19, list, IntSize.m9280constructorimpl((((long) i18) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i17) << c)), i32, i70, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37(final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, final List list, final LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyStaggeredGridMeasureKt.measure$lambda$0$37$0(list, lazyStaggeredGridMeasureContext, lazyLayoutMeasureScope, (Placeable.PlacementScope) obj);
            }
        });
        ObservableScopeInvalidator.m2224attachToScopeimpl(lazyStaggeredGridMeasureContext.getState().m2270getPlacementScopeInvalidatorzYiylxw$foundation());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37$0(List list, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyStaggeredGridMeasuredItem) list.get(i)).place(placementScope, lazyStaggeredGridMeasureContext, lazyLayoutMeasureScope.isLookingAhead());
        }
        return Unit.INSTANCE;
    }

    private static final boolean measure$lambda$0$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$0$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    /* JADX INFO: renamed from: measureStaggeredGrid-C6celF4, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m2263measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int iM2262maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo, graphicsContext, null);
        int[] iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
        if (iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i5 = 0;
            while (i5 < laneCount) {
                if (i5 >= iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length || (iM2262maxInRangejy6DScQ = iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation[i5]) == -1) {
                    iM2262maxInRangejy6DScQ = i5 == 0 ? 0 : m2262maxInRangejy6DScQ(iArr, SpanRange.m2272constructorimpl(0, i5)) + 1;
                }
                iArr[i5] = iM2262maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i5], i5);
                i5++;
            }
            iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i6 = 0;
            while (i6 < laneCount2) {
                iArr2[i6] = i6 < scrollOffsets.length ? scrollOffsets[i6] : i6 == 0 ? 0 : iArr2[i6 - 1];
                i6++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.scrollToBeConsumed$foundation(z4)), iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation, scrollOffsets, true);
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }
}
