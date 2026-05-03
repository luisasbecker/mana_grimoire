package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.muxer.MuxerUtil;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyList.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyListItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ StickyItemsPlacement $stickyItemsPlacement;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: Multi-variable type inference failed */
    LazyListKt$rememberLazyListMeasurePolicy$1$1(LazyListState lazyListState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyListItemProvider> function0, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2) {
        this.$state = lazyListState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$beyondBoundsItemCount = i;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
        this.$stickyItemsPlacement = stickyItemsPlacement;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
    public final MeasureResult mo2139measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        float spacing;
        long jM9236constructorimpl;
        ObservableScopeInvalidator.m2224attachToScopeimpl(this.$state.m2155getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$state.getHasLookaheadOccurred() || lazyLayoutMeasureScope.isLookingAhead();
        CheckScrollableContainerConstraintsKt.m1510checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        boolean z2 = this.$isVertical;
        PaddingValues paddingValues = this.$contentPadding;
        int i = z2 ? lazyLayoutMeasureScope.mo1618roundToPx0680j_4(paddingValues.mo1987calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo1618roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
        boolean z3 = this.$isVertical;
        PaddingValues paddingValues2 = this.$contentPadding;
        int i2 = z3 ? lazyLayoutMeasureScope.mo1618roundToPx0680j_4(paddingValues2.mo1988calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo1618roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()));
        int i3 = lazyLayoutMeasureScope.mo1618roundToPx0680j_4(this.$contentPadding.getTop());
        int i4 = lazyLayoutMeasureScope.mo1618roundToPx0680j_4(this.$contentPadding.getBottom());
        final int i5 = i3 + i4;
        final int i6 = i + i2;
        boolean z4 = this.$isVertical;
        int i7 = z4 ? i5 : i6;
        final int i8 = (!z4 || this.$reverseLayout) ? (z4 && this.$reverseLayout) ? i4 : (z4 || this.$reverseLayout) ? i2 : i : i3;
        final int i9 = i7 - i8;
        final long jM9086offsetNN6EwU = ConstraintsKt.m9086offsetNN6EwU(j, -i6, -i5);
        final LazyListItemProvider lazyListItemProviderInvoke = this.$itemProviderLambda.invoke();
        lazyListItemProviderInvoke.getItemScope().setMaxSize(Constraints.m9067getMaxWidthimpl(jM9086offsetNN6EwU), Constraints.m9066getMaxHeightimpl(jM9086offsetNN6EwU));
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
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                throw new KotlinNothingValueException();
            }
            spacing = horizontal.getSpacing();
        }
        final int i10 = lazyLayoutMeasureScope.mo1618roundToPx0680j_4(spacing);
        final int itemCount = lazyListItemProviderInvoke.getItemCount();
        int iM9066getMaxHeightimpl = this.$isVertical ? Constraints.m9066getMaxHeightimpl(j) - i5 : Constraints.m9067getMaxWidthimpl(j) - i6;
        if (!this.$reverseLayout || iM9066getMaxHeightimpl > 0) {
            jM9236constructorimpl = IntOffset.m9236constructorimpl((((long) i3) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i) << 32));
        } else {
            boolean z5 = this.$isVertical;
            if (!z5) {
                i += iM9066getMaxHeightimpl;
            }
            if (z5) {
                i3 += iM9066getMaxHeightimpl;
            }
            jM9236constructorimpl = IntOffset.m9236constructorimpl((((long) i3) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i) << 32));
        }
        final boolean z6 = this.$isVertical;
        final Alignment.Horizontal horizontal2 = this.$horizontalAlignment;
        final long j2 = jM9236constructorimpl;
        final Alignment.Vertical vertical2 = this.$verticalAlignment;
        final boolean z7 = this.$reverseLayout;
        final LazyListState lazyListState = this.$state;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(jM9086offsetNN6EwU, z6, lazyListItemProviderInvoke, lazyLayoutMeasureScope, itemCount, i10, horizontal2, vertical2, z7, i8, i9, j2, lazyListState) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
            final /* synthetic */ int $afterContentPadding;
            final /* synthetic */ int $beforeContentPadding;
            final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ int $itemsCount;
            final /* synthetic */ boolean $reverseLayout;
            final /* synthetic */ int $spaceBetweenItems;
            final /* synthetic */ LazyListState $state;
            final /* synthetic */ LazyLayoutMeasureScope $this_LazyLayoutMeasurePolicy;
            final /* synthetic */ Alignment.Vertical $verticalAlignment;
            final /* synthetic */ long $visualItemOffset;

            {
                this.$isVertical = z6;
                this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScope;
                this.$itemsCount = itemCount;
                this.$spaceBetweenItems = i10;
                this.$horizontalAlignment = horizontal2;
                this.$verticalAlignment = vertical2;
                this.$reverseLayout = z7;
                this.$beforeContentPadding = i8;
                this.$afterContentPadding = i9;
                this.$visualItemOffset = j2;
                this.$state = lazyListState;
            }

            @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
            /* JADX INFO: renamed from: createItem-X9ElhV4, reason: not valid java name */
            public LazyListMeasuredItem mo2140createItemX9ElhV4(int index, Object key, Object contentType, List<? extends Placeable> placeables, long constraints) {
                return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_LazyLayoutMeasurePolicy.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation(), constraints, null);
            }
        };
        Snapshot.Companion companion = Snapshot.INSTANCE;
        LazyListState lazyListState2 = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int iUpdateScrollPositionIfTheFirstItemWasMoved$foundation = lazyListState2.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyListItemProviderInvoke, lazyListState2.getFirstVisibleItemIndex());
            int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            LazyListMeasureResult lazyListMeasureResultM2145measureLazyList_s_dbAc = LazyListMeasureKt.m2145measureLazyList_s_dbAc(itemCount, lazyListMeasuredItemProvider2, iM9066getMaxHeightimpl, i8, i9, i10, iUpdateScrollPositionIfTheFirstItemWasMoved$foundation, firstVisibleItemScrollOffset, (lazyLayoutMeasureScope.isLookingAhead() || !z) ? this.$state.getScrollToBeConsumed() : this.$state.getScrollDeltaBetweenPasses$foundation(), jM9086offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$state.getItemAnimator$foundation(), this.$beyondBoundsItemCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProviderInvoke, this.$state.getPinnedItems(), this.$state.getBeyondBoundsInfo()), z, lazyLayoutMeasureScope.isLookingAhead(), this.$coroutineScope, this.$state.m2156getPlacementScopeInvalidatorzYiylxw$foundation(), this.$graphicsContext, this.$stickyItemsPlacement, new Function3() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    long j3 = j;
                    return lazyLayoutMeasureScope2.layout(ConstraintsKt.m9084constrainWidthK40F9xA(j3, ((Integer) obj).intValue() + i6), ConstraintsKt.m9083constrainHeightK40F9xA(j3, ((Integer) obj2).intValue() + i5), MapsKt.emptyMap(), (Function1) obj3);
                }
            });
            LazyListState.applyMeasureResult$foundation$default(this.$state, lazyListMeasureResultM2145measureLazyList_s_dbAc, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            Object prefetchStrategy = this.$state.getPrefetchStrategy();
            CacheWindowLogic cacheWindowLogic = prefetchStrategy instanceof CacheWindowLogic ? (CacheWindowLogic) prefetchStrategy : null;
            if (cacheWindowLogic != null) {
                LazyListKt.keepAroundItems(cacheWindowLogic, lazyListMeasureResultM2145measureLazyList_s_dbAc.getVisibleItemsInfo(), lazyListMeasuredItemProvider2);
            }
            return lazyListMeasureResultM2145measureLazyList_s_dbAc;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
