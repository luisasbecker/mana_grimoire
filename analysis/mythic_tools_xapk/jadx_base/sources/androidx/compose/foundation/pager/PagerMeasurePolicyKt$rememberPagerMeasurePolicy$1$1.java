package androidx.compose.foundation.pager;

import androidx.collection.IntObjectMapKt;
import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PagerMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-unit-Dp$-pageSpacing$0, reason: not valid java name */
    final /* synthetic */ float f55$$v$c$androidxcomposeuiunitDp$pageSpacing$0;
    final /* synthetic */ int $beyondViewportPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ SnapPosition $snapPosition;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(PagerState pagerState, Orientation orientation, PaddingValues paddingValues, boolean z, float f, PageSize pageSize, Function0<PagerLazyLayoutItemProvider> function0, Function0<Integer> function02, Alignment.Vertical vertical, Alignment.Horizontal horizontal, int i, SnapPosition snapPosition, CoroutineScope coroutineScope) {
        this.$state = pagerState;
        this.$orientation = orientation;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.f55$$v$c$androidxcomposeuiunitDp$pageSpacing$0 = f;
        this.$pageSize = pageSize;
        this.$itemProviderLambda = function0;
        this.$pageCount = function02;
        this.$verticalAlignment = vertical;
        this.$horizontalAlignment = horizontal;
        this.$beyondViewportPageCount = i;
        this.$snapPosition = snapPosition;
        this.$coroutineScope = coroutineScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* JADX INFO: renamed from: measure-0kLqBqw */
    public final MeasureResult mo2139measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        long jM9236constructorimpl;
        ObservableScopeInvalidator.m2224attachToScopeimpl(this.$state.m2300getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$orientation == Orientation.Vertical;
        CheckScrollableContainerConstraintsKt.m1510checkScrollableContainerConstraintsK40F9xA(j, z ? Orientation.Vertical : Orientation.Horizontal);
        PaddingValues paddingValues = this.$contentPadding;
        int i2 = z ? lazyLayoutMeasureScope.mo1618roundToPx0680j_4(paddingValues.mo1987calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo1618roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
        PaddingValues paddingValues2 = this.$contentPadding;
        int i3 = z ? lazyLayoutMeasureScope.mo1618roundToPx0680j_4(paddingValues2.mo1988calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo1618roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()));
        int i4 = lazyLayoutMeasureScope.mo1618roundToPx0680j_4(this.$contentPadding.getTop());
        int i5 = lazyLayoutMeasureScope.mo1618roundToPx0680j_4(this.$contentPadding.getBottom());
        final int i6 = i4 + i5;
        final int i7 = i2 + i3;
        int i8 = z ? i6 : i7;
        int i9 = (!z || this.$reverseLayout) ? (z && this.$reverseLayout) ? i5 : (z || this.$reverseLayout) ? i3 : i2 : i4;
        int i10 = i8 - i9;
        long jM9086offsetNN6EwU = ConstraintsKt.m9086offsetNN6EwU(j, -i7, -i6);
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        this.$state.setDensity$foundation(lazyLayoutMeasureScope2);
        int i11 = lazyLayoutMeasureScope.mo1618roundToPx0680j_4(this.f55$$v$c$androidxcomposeuiunitDp$pageSpacing$0);
        int iM9066getMaxHeightimpl = z ? Constraints.m9066getMaxHeightimpl(j) - i6 : Constraints.m9067getMaxWidthimpl(j) - i7;
        if (!this.$reverseLayout || iM9066getMaxHeightimpl > 0) {
            i = i11;
            jM9236constructorimpl = IntOffset.m9236constructorimpl((((long) i2) << 32) | (((long) i4) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        } else {
            if (!z) {
                i2 += iM9066getMaxHeightimpl;
            }
            if (z) {
                i4 += iM9066getMaxHeightimpl;
            }
            i = i11;
            jM9236constructorimpl = IntOffset.m9236constructorimpl((((long) i4) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i2) << 32));
        }
        long j2 = jM9236constructorimpl;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(this.$pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope2, iM9066getMaxHeightimpl, i), 0);
        this.$state.m2304setPremeasureConstraintsBRTryo0$foundation(ConstraintsKt.Constraints$default(0, this.$orientation == Orientation.Vertical ? Constraints.m9067getMaxWidthimpl(jM9086offsetNN6EwU) : iCoerceAtLeast, 0, this.$orientation != Orientation.Vertical ? Constraints.m9066getMaxHeightimpl(jM9086offsetNN6EwU) : iCoerceAtLeast, 5, null));
        PagerLazyLayoutItemProvider pagerLazyLayoutItemProviderInvoke = this.$itemProviderLambda.invoke();
        int i12 = iM9066getMaxHeightimpl + i9 + i10;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        PagerState pagerState = this.$state;
        SnapPosition snapPosition = this.$snapPosition;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int iMatchScrollPositionWithKey$foundation = pagerState.matchScrollPositionWithKey$foundation(pagerLazyLayoutItemProviderInvoke, pagerState.getCurrentPage());
            int i13 = i;
            int iCurrentPageOffset = PagerKt.currentPageOffset(snapPosition, i12, iCoerceAtLeast, i13, i9, i10, pagerState.getCurrentPage(), pagerState.getCurrentPageOffsetFraction(), pagerState.getPageCount());
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            PagerMeasureResult pagerMeasureResultM2297measurePager7L1iB3k = PagerMeasureKt.m2297measurePager7L1iB3k(lazyLayoutMeasureScope, this.$pageCount.invoke().intValue(), pagerLazyLayoutItemProviderInvoke, iM9066getMaxHeightimpl, i9, i10, i13, iMatchScrollPositionWithKey$foundation, iCurrentPageOffset, jM9086offsetNN6EwU, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, j2, iCoerceAtLeast, this.$beyondViewportPageCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(pagerLazyLayoutItemProviderInvoke, this.$state.getPinnedPages(), this.$state.getBeyondBoundsInfo()), this.$snapPosition, this.$state.m2301getPlacementScopeInvalidatorzYiylxw$foundation(), this.$coroutineScope, lazyLayoutMeasureScope2, new Function3() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
                    long j3 = j;
                    return lazyLayoutMeasureScope3.layout(ConstraintsKt.m9084constrainWidthK40F9xA(j3, ((Integer) obj).intValue() + i7), ConstraintsKt.m9083constrainHeightK40F9xA(j3, ((Integer) obj2).intValue() + i6), MapsKt.emptyMap(), (Function1) obj3);
                }
            }, IntObjectMapKt.mutableIntObjectMapOf());
            PagerState.applyMeasureResult$foundation$default(this.$state, pagerMeasureResultM2297measurePager7L1iB3k, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            PagerMeasurePolicyKt.keepAroundItems(lazyLayoutMeasureScope, this.$state.getCacheWindowLogic(), pagerMeasureResultM2297measurePager7L1iB3k.getVisiblePagesInfo());
            return pagerMeasureResultM2297measurePager7L1iB3k;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
