package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.muxer.MuxerUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyGrid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyGridItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridSlotsProvider $slots;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ StickyItemsPlacement $stickyItemsScrollBehavior;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: Multi-variable type inference failed */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1(LazyGridState lazyGridState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyGridItemProvider> function0, LazyGridSlotsProvider lazyGridSlotsProvider, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement) {
        this.$state = lazyGridState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$slots = lazyGridSlotsProvider;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
        this.$stickyItemsScrollBehavior = stickyItemsPlacement;
    }

    static final ArrayList measure_0kLqBqw$lambda$2(LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, int i) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = lazyGridSpanLayoutProvider.getLineConfiguration(i);
        int firstItemIndex = lineConfiguration.getFirstItemIndex();
        ArrayList arrayList = new ArrayList(lineConfiguration.getSpans().size());
        List<GridItemSpan> spans = lineConfiguration.getSpans();
        int size = spans.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int iM2161getCurrentLineSpanimpl = GridItemSpan.m2161getCurrentLineSpanimpl(spans.get(i3).getPackedValue());
            arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m9054boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m2181childConstraintsJhjzzOo$foundation(i2, iM2161getCurrentLineSpanimpl))));
            firstItemIndex++;
            i2 += iM2161getCurrentLineSpanimpl;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r21v1, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
    /* JADX WARN: Type inference failed for: r26v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* JADX INFO: renamed from: measure-0kLqBqw */
    public final MeasureResult mo2139measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        float spacing;
        int i;
        long jM9236constructorimpl;
        int lineIndexOfItem;
        int firstVisibleItemScrollOffset;
        ObservableScopeInvalidator.m2224attachToScopeimpl(this.$state.m2182getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$state.getHasLookaheadOccurred() || lazyLayoutMeasureScope.isLookingAhead();
        CheckScrollableContainerConstraintsKt.m1510checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        boolean z2 = this.$isVertical;
        PaddingValues paddingValues = this.$contentPadding;
        int i2 = z2 ? lazyLayoutMeasureScope.mo1618roundToPx0680j_4(paddingValues.mo1987calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo1618roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
        boolean z3 = this.$isVertical;
        PaddingValues paddingValues2 = this.$contentPadding;
        int i3 = z3 ? lazyLayoutMeasureScope.mo1618roundToPx0680j_4(paddingValues2.mo1988calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo1618roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()));
        int i4 = lazyLayoutMeasureScope.mo1618roundToPx0680j_4(this.$contentPadding.getTop());
        int i5 = lazyLayoutMeasureScope.mo1618roundToPx0680j_4(this.$contentPadding.getBottom());
        int i6 = i4 + i5;
        final int i7 = i2 + i3;
        boolean z4 = this.$isVertical;
        int i8 = z4 ? i6 : i7;
        int i9 = (!z4 || this.$reverseLayout) ? (z4 && this.$reverseLayout) ? i5 : (z4 || this.$reverseLayout) ? i3 : i2 : i4;
        final int i10 = i8 - i9;
        long jM9086offsetNN6EwU = ConstraintsKt.m9086offsetNN6EwU(j, -i7, -i6);
        final LazyGridItemProvider lazyGridItemProviderInvoke = this.$itemProviderLambda.invoke();
        final LazyGridSpanLayoutProvider spanLayoutProvider = lazyGridItemProviderInvoke.getSpanLayoutProvider();
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        final LazyGridSlots lazyGridSlotsMo2165invoke0kLqBqw = this.$slots.mo2165invoke0kLqBqw(lazyLayoutMeasureScope2, jM9086offsetNN6EwU);
        int length = lazyGridSlotsMo2165invoke0kLqBqw.getSizes().length;
        spanLayoutProvider.setSlotsPerLine(length);
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical == null) {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                throw new KotlinNothingValueException();
            }
            spacing = vertical.getSpacing();
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal == null) {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                throw new KotlinNothingValueException();
            }
            spacing = horizontal.getSpacing();
        }
        final int i11 = lazyLayoutMeasureScope.mo1618roundToPx0680j_4(spacing);
        final int itemCount = lazyGridItemProviderInvoke.getItemCount();
        int iM9066getMaxHeightimpl = this.$isVertical ? Constraints.m9066getMaxHeightimpl(j) - i6 : Constraints.m9067getMaxWidthimpl(j) - i7;
        if (!this.$reverseLayout || iM9066getMaxHeightimpl > 0) {
            i = i6;
            jM9236constructorimpl = IntOffset.m9236constructorimpl((((long) i2) << 32) | (((long) i4) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        } else {
            boolean z5 = this.$isVertical;
            if (!z5) {
                i2 += iM9066getMaxHeightimpl;
            }
            if (z5) {
                i4 += iM9066getMaxHeightimpl;
            }
            i = i6;
            jM9236constructorimpl = IntOffset.m9236constructorimpl((((long) i4) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i2) << 32));
        }
        final LazyGridState lazyGridState = this.$state;
        final boolean z6 = this.$isVertical;
        final boolean z7 = this.$reverseLayout;
        final int i12 = i9;
        final long j2 = jM9236constructorimpl;
        final ?? r26 = new LazyGridMeasuredItemProvider(lazyGridItemProviderInvoke, lazyLayoutMeasureScope, i11, lazyGridState, z6, z7, i12, i10, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
            final /* synthetic */ int $afterContentPadding;
            final /* synthetic */ int $beforeContentPadding;
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ boolean $reverseLayout;
            final /* synthetic */ LazyGridState $state;
            final /* synthetic */ LazyLayoutMeasureScope $this_LazyLayoutMeasurePolicy;
            final /* synthetic */ long $visualItemOffset;

            {
                this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScope;
                this.$state = lazyGridState;
                this.$isVertical = z6;
                this.$reverseLayout = z7;
                this.$beforeContentPadding = i12;
                this.$afterContentPadding = i10;
                this.$visualItemOffset = j2;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
            /* JADX INFO: renamed from: createItem-O3s9Psw, reason: not valid java name */
            public LazyGridMeasuredItem mo2174createItemO3s9Psw(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables, long constraints, int lane, int span) {
                return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_LazyLayoutMeasurePolicy.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, this.$state.getItemAnimator$foundation(), constraints, lane, span, null);
            }
        };
        final boolean z8 = this.$isVertical;
        final ?? r21 = new LazyGridMeasuredLineProvider(z8, lazyGridSlotsMo2165invoke0kLqBqw, itemCount, i11, r26, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ LazyGridSlots $resolvedSlots;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(z8, lazyGridSlotsMo2165invoke0kLqBqw, itemCount, i11, r26, spanLayoutProvider);
                this.$isVertical = z8;
                this.$resolvedSlots = lazyGridSlotsMo2165invoke0kLqBqw;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
            public LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
            }
        };
        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyGridKt$rememberLazyGridMeasurePolicy$1$1.measure_0kLqBqw$lambda$2(spanLayoutProvider, r21, ((Integer) obj).intValue());
            }
        };
        Function1 function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(spanLayoutProvider.getLineIndexOfItem(((Integer) obj).intValue()));
            }
        };
        Snapshot.Companion companion = Snapshot.INSTANCE;
        LazyGridState lazyGridState2 = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation = lazyGridState2.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyGridItemProviderInvoke, lazyGridState2.getFirstVisibleItemIndex());
            if (iUpdateScrollPositionIfTheFirstItemWasMoved$foundation < itemCount || itemCount <= 0) {
                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(iUpdateScrollPositionIfTheFirstItemWasMoved$foundation);
                firstVisibleItemScrollOffset = lazyGridState2.getFirstVisibleItemScrollOffset();
            } else {
                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                firstVisibleItemScrollOffset = 0;
            }
            int i13 = lineIndexOfItem;
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider = (LazyGridMeasuredLineProvider) r21;
            final int i14 = i;
            LazyGridMeasureResult lazyGridMeasureResultM2177measureLazyGridt1x4au0 = LazyGridMeasureKt.m2177measureLazyGridt1x4au0(itemCount, lazyGridMeasuredLineProvider, (LazyGridMeasuredItemProvider) r26, iM9066getMaxHeightimpl, i9, i10, i11, i13, firstVisibleItemScrollOffset, (lazyLayoutMeasureScope.isLookingAhead() || !z) ? this.$state.getScrollToBeConsumed() : this.$state.getScrollDeltaBetweenPasses$foundation(), jM9086offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope2, this.$state.getItemAnimator$foundation(), length, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProviderInvoke, this.$state.getPinnedItems(), this.$state.getBeyondBoundsInfo()), z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getApproachLayoutInfo(), this.$coroutineScope, this.$state.m2183getPlacementScopeInvalidatorzYiylxw$foundation(), this.$graphicsContext, function1, function12, this.$stickyItemsScrollBehavior, new Function3() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
                    long j3 = j;
                    return lazyLayoutMeasureScope3.layout(ConstraintsKt.m9084constrainWidthK40F9xA(j3, ((Integer) obj).intValue() + i7), ConstraintsKt.m9083constrainHeightK40F9xA(j3, ((Integer) obj2).intValue() + i14), MapsKt.emptyMap(), (Function1) obj3);
                }
            });
            LazyGridState.applyMeasureResult$foundation$default(this.$state, lazyGridMeasureResultM2177measureLazyGridt1x4au0, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            Object prefetchStrategy = this.$state.getPrefetchStrategy();
            CacheWindowLogic cacheWindowLogic = prefetchStrategy instanceof CacheWindowLogic ? (CacheWindowLogic) prefetchStrategy : null;
            if (cacheWindowLogic != null) {
                LazyGridKt.keepAroundItems(cacheWindowLogic, lazyGridMeasureResultM2177measureLazyGridt1x4au0.getOrientation(), lazyGridMeasureResultM2177measureLazyGridt1x4au0.getVisibleItemsInfo(), lazyGridMeasuredLineProvider);
            }
            return lazyGridMeasureResultM2177measureLazyGridt1x4au0;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
