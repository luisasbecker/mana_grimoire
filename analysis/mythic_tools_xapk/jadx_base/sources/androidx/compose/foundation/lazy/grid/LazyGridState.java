package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollIndicatorState;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Density;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: LazyGridState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ÿ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001[\b\u0007\u0018\u0000 «\u00012\u00020\u0001:\u0002«\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB%\b\u0017\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u000bB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\fJ\b\u0010]\u001a\u00020\u0003H\u0002J\"\u0010m\u001a\u00020n2\b\b\u0001\u0010o\u001a\u00020\u00032\b\b\u0002\u0010p\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010qJ\u001a\u0010t\u001a\u00020n2\b\b\u0001\u0010o\u001a\u00020\u00032\b\b\u0002\u0010p\u001a\u00020\u0003J%\u0010u\u001a\u00020n2\u0006\u0010o\u001a\u00020\u00032\u0006\u0010p\u001a\u00020\u00032\u0006\u0010v\u001a\u00020\u0010H\u0000¢\u0006\u0002\bwJA\u0010x\u001a\u00020n2\u0006\u0010y\u001a\u00020z2(\u0010{\u001a$\b\u0001\u0012\u0004\u0012\u00020}\u0012\n\u0012\b\u0012\u0004\u0012\u00020n0~\u0012\u0006\u0012\u0004\u0018\u00010\u007f0|¢\u0006\u0003\b\u0080\u0001H\u0096@¢\u0006\u0003\u0010\u0081\u0001J\u0012\u0010\u0082\u0001\u001a\u00020,2\u0007\u0010\u0083\u0001\u001a\u00020,H\u0016J\u0018\u0010\u0096\u0001\u001a\u00020,2\u0007\u0010\u0097\u0001\u001a\u00020,H\u0000¢\u0006\u0003\b\u0098\u0001J\u001a\u0010\u0099\u0001\u001a\u00020n2\u0007\u0010\u0083\u0001\u001a\u00020,2\u0006\u0010 \u001a\u00020!H\u0002J#\u0010\u009c\u0001\u001a\u00020n2\b\b\u0001\u0010o\u001a\u00020\u00032\b\b\u0002\u0010p\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010qJ,\u0010\u009d\u0001\u001a\u00020n2\u0007\u0010\u009e\u0001\u001a\u00020\u00142\u0007\u0010\u009f\u0001\u001a\u00020\u00102\t\b\u0002\u0010 \u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b¡\u0001J\"\u0010¦\u0001\u001a\u00020\u00032\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010©\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\bª\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0014@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8G¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010-\u001a\u00020,2\u0006\u0010\u000f\u001a\u00020,@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001cR\u0014\u00102\u001a\u0002038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00107\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001cR\u001a\u00109\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0013\"\u0004\b;\u0010<R\"\u0010>\u001a\u0004\u0018\u00010=2\b\u0010\u000f\u001a\u0004\u0018\u00010=@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020BX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020FX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0014\u0010N\u001a\u00020OX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020SX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\R\u0014\u0010^\u001a\u00020_X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u001b\u0010b\u001a\u00020c8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\bf\u0010g*\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020iX\u0080\u0004¢\u0006\n\n\u0002\u0010l\u001a\u0004\bj\u0010kR\u0016\u0010r\u001a\u00020iX\u0080\u0004¢\u0006\n\n\u0002\u0010l\u001a\u0004\bs\u0010kR\u0016\u0010\u0084\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0013R0\u0010\u0086\u0001\u001a\u00020\u00102\u0007\u0010\u0085\u0001\u001a\u00020\u00108V@RX\u0096\u008e\u0002¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010l\u001a\u0005\b\u0087\u0001\u0010\u0013\"\u0005\b\u0088\u0001\u0010<R0\u0010\u008a\u0001\u001a\u00020\u00102\u0007\u0010\u0085\u0001\u001a\u00020\u00108V@RX\u0096\u008e\u0002¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010l\u001a\u0005\b\u008b\u0001\u0010\u0013\"\u0005\b\u008c\u0001\u0010<R\u0016\u0010\u008e\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010\u0013R\u0016\u0010\u0090\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010\u0013R\u001a\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0016\u0010\u009a\u0001\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010\u001cR\u0010\u0010¢\u0001\u001a\u00030£\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010¤\u0001\u001a\u00020,8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010/¨\u0006¬\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "<init>", "(IILandroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;)V", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;II)V", "(II)V", "getPrefetchStrategy$foundation", "()Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation", "()Z", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "executeRequestsInHighPriorityMode", "scrollPosition", "Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation", "()F", "slotsPerLine", "getSlotsPerLine$foundation", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "getDensity$foundation", "()Landroidx/compose/ui/unit/Density;", "scrollableState", "numMeasurePasses", "getNumMeasurePasses$foundation", "prefetchingEnabled", "getPrefetchingEnabled$foundation", "setPrefetchingEnabled$foundation", "(Z)V", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "getItemAnimator$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation$annotations", "()V", "getPrefetchState$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchScope", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "_scrollIndicatorState", "androidx/compose/foundation/lazy/grid/LazyGridState$_scrollIndicatorState$1", "Landroidx/compose/foundation/lazy/grid/LazyGridState$_scrollIndicatorState$1;", "calculateScrollOffset", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation$delegate", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)Ljava/lang/Object;", "getNearestRange$foundation", "()Lkotlin/ranges/IntRange;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation", "()Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/MutableState;", "scrollToItem", "", FirebaseAnalytics.Param.INDEX, "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation", "requestScrollToItem", "snapToItemIndexInternal", "forceRemeasure", "snapToItemIndexInternal$foundation", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "isScrollInProgress", "<set-?>", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "scrollIndicatorState", "Landroidx/compose/foundation/ScrollIndicatorState;", "getScrollIndicatorState", "()Landroidx/compose/foundation/ScrollIndicatorState;", "onScroll", "distance", "onScroll$foundation", "notifyPrefetchOnScroll", "numOfItemsToTeleport", "getNumOfItemsToTeleport", "animateScrollToItem", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation", "Companion", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridState implements ScrollableState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<LazyGridState, ?> Saver = ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            LazyGridState lazyGridState = (LazyGridState) obj2;
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyGridState.getFirstVisibleItemIndex()), Integer.valueOf(lazyGridState.getFirstVisibleItemScrollOffset())});
        }
    }, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return LazyGridState.Saver$lambda$1((List) obj);
        }
    });
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private final LazyGridState$_scrollIndicatorState$1 _scrollIndicatorState;
    private LazyGridMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    /* JADX INFO: renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollBackward;

    /* JADX INFO: renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollForward;
    private boolean executeRequestsInHighPriorityMode;
    private boolean hasLookaheadOccurred;
    private final MutableInteractionSource internalInteractionSource;
    private final LazyLayoutItemAnimator<LazyGridMeasuredItem> itemAnimator;
    private final MutableState<LazyGridMeasureResult> layoutInfoState;
    private final MutableState<Unit> measurementScopeInvalidator;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyGridPrefetchScope prefetchScope;
    private final LazyLayoutPrefetchState prefetchState;
    private final LazyGridPrefetchStrategy prefetchStrategy;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    /* JADX INFO: compiled from: LazyGridState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\fJ\u001f\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\fR\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "saver", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "saver$foundation", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static final LazyGridState saver$lambda$1(LazyGridPrefetchStrategy lazyGridPrefetchStrategy, List list) {
            return new LazyGridState(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue(), lazyGridPrefetchStrategy);
        }

        static final LazyGridState saver$lambda$3(LazyLayoutCacheWindow lazyLayoutCacheWindow, List list) {
            return new LazyGridState(lazyLayoutCacheWindow, ((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
        }

        public final Saver<LazyGridState, ?> getSaver() {
            return LazyGridState.Saver;
        }

        public final Saver<LazyGridState, ?> saver$foundation(final LazyGridPrefetchStrategy prefetchStrategy) {
            return ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    LazyGridState lazyGridState = (LazyGridState) obj2;
                    return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyGridState.getFirstVisibleItemIndex()), Integer.valueOf(lazyGridState.getFirstVisibleItemScrollOffset())});
                }
            }, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyGridState.Companion.saver$lambda$1(prefetchStrategy, (List) obj);
                }
            });
        }

        public final Saver<LazyGridState, ?> saver$foundation(final LazyLayoutCacheWindow cacheWindow) {
            return ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    LazyGridState lazyGridState = (LazyGridState) obj2;
                    return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyGridState.getFirstVisibleItemIndex()), Integer.valueOf(lazyGridState.getFirstVisibleItemScrollOffset())});
                }
            }, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyGridState.Companion.saver$lambda$3(cacheWindow, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridState$animateScrollToItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridState$animateScrollToItem$2", f = "LazyGridState.kt", i = {}, l = {615}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, int i2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$scrollOffset = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = LazyGridState.this.new AnonymousClass2(this.$index, this.$scrollOffset, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScrollScope scrollScope = (ScrollScope) this.L$0;
                this.label = 1;
                if (LazyLayoutScrollScopeKt.animateScrollToItem(LazyGridScrollScopeKt.LazyLayoutScrollScope(LazyGridState.this, scrollScope), this.$index, this.$scrollOffset, LazyGridState.this.getNumOfItemsToTeleport(), LazyGridState.this.getDensity$foundation(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridState$requestScrollToItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridState$requestScrollToItem$1", f = "LazyGridState.kt", i = {}, l = {Videoio.CAP_PROP_XI_HEIGHT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyGridState.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ScrollExtensionsKt.stopScroll$default(LazyGridState.this, (MutatePriority) null, this, 1, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridState.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridState", f = "LazyGridState.kt", i = {0, 0}, l = {496, Videoio.CAP_PROP_XI_TRG_SELECTOR}, m = "scroll", n = {"scrollPriority", "block"}, s = {"L$0", "L$1"}, v = 1)
    static final class C03781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03781(Continuation<? super C03781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyGridState.this.scroll(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridState$scrollToItem$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridState$scrollToItem$2", f = "LazyGridState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03792 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03792(int i, int i2, Continuation<? super C03792> continuation) {
            super(2, continuation);
            this.$index = i;
            this.$scrollOffset = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyGridState.this.new C03792(this.$index, this.$scrollOffset, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((C03792) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LazyGridState.this.snapToItemIndexInternal$foundation(this.$index, this.$scrollOffset, true);
            return Unit.INSTANCE;
        }
    }

    public LazyGridState() {
        this(0, 0, (LazyGridPrefetchStrategy) null, 7, (DefaultConstructorMarker) null);
    }

    public LazyGridState(int i, int i2) {
        this(i, i2, LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, null));
    }

    public /* synthetic */ LazyGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.foundation.lazy.grid.LazyGridState$_scrollIndicatorState$1] */
    public LazyGridState(final int i, int i2, LazyGridPrefetchStrategy lazyGridPrefetchStrategy) {
        this.prefetchStrategy = lazyGridPrefetchStrategy;
        LazyGridScrollPosition lazyGridScrollPosition = new LazyGridScrollPosition(i, i2);
        this.scrollPosition = lazyGridScrollPosition;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyGridStateKt.EmptyLazyGridLayoutInfo, SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(LazyGridState.scrollableState$lambda$0(this.f$0, ((Float) obj).floatValue()));
            }
        });
        this.prefetchingEnabled = true;
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                this.this$0.remeasurement = remeasurement;
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyLayoutItemAnimator<>();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchState = new LazyLayoutPrefetchState(lazyGridPrefetchStrategy.getPrefetchScheduler(), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyGridState.prefetchState$lambda$0(this.f$0, i, (NestedPrefetchScope) obj);
            }
        });
        this.prefetchScope = new LazyGridState$prefetchScope$1(this);
        this._scrollIndicatorState = new ScrollIndicatorState() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$_scrollIndicatorState$1
            @Override // androidx.compose.foundation.ScrollIndicatorState
            public int getContentSize() {
                return LazyGridLayoutInfoKt.calculateContentSize(this.this$0.getLayoutInfo());
            }

            @Override // androidx.compose.foundation.ScrollIndicatorState
            public int getScrollOffset() {
                return this.this$0.calculateScrollOffset();
            }

            @Override // androidx.compose.foundation.ScrollIndicatorState
            public int getViewportSize() {
                return LazyGridLayoutInfoKt.getSingleAxisViewportSize(this.this$0.getLayoutInfo());
            }
        };
        this.pinnedItems = new LazyLayoutPinnedItemList();
        lazyGridScrollPosition.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m2227constructorimpl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m2227constructorimpl$default(null, 1, null);
        this.canScrollForward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollBackward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    public /* synthetic */ LazyGridState(int i, int i2, LazyGridPrefetchStrategy lazyGridPrefetchStrategy, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, null) : lazyGridPrefetchStrategy);
    }

    public LazyGridState(LazyLayoutCacheWindow lazyLayoutCacheWindow, int i, int i2) {
        this(i, i2, new LazyGridCacheWindowPrefetchStrategy(lazyLayoutCacheWindow));
    }

    public /* synthetic */ LazyGridState(LazyLayoutCacheWindow lazyLayoutCacheWindow, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyLayoutCacheWindow, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }

    static final LazyGridState Saver$lambda$1(List list) {
        return new LazyGridState(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.animateScrollToItem(i, i2, continuation);
    }

    public static /* synthetic */ void applyMeasureResult$foundation$default(LazyGridState lazyGridState, LazyGridMeasureResult lazyGridMeasureResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        lazyGridState.applyMeasureResult$foundation(lazyGridMeasureResult, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateScrollOffset() {
        LazyGridLayoutInfo layoutInfo = getLayoutInfo();
        return (LazyGridLayoutInfoKt.visibleLinesAverageMainAxisSize(layoutInfo) * LazyGridLayoutInfoKt.getFirstVisibleItemLineIndex(layoutInfo)) + getFirstVisibleItemScrollOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getNumOfItemsToTeleport() {
        return getSlotsPerLine$foundation() * 100;
    }

    public static /* synthetic */ void getPrefetchState$foundation$annotations() {
    }

    private final void notifyPrefetchOnScroll(float delta, LazyGridLayoutInfo layoutInfo) {
        if (this.prefetchingEnabled) {
            this.prefetchStrategy.onScroll(this.prefetchScope, delta, layoutInfo);
        }
    }

    static final Unit prefetchState$lambda$0(LazyGridState lazyGridState, int i, NestedPrefetchScope nestedPrefetchScope) {
        LazyGridPrefetchStrategy lazyGridPrefetchStrategy = lazyGridState.prefetchStrategy;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null);
        lazyGridPrefetchStrategy.onNestedPrefetch(nestedPrefetchScope, i);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void requestScrollToItem$default(LazyGridState lazyGridState, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        lazyGridState.requestScrollToItem(i, i2);
    }

    public static /* synthetic */ Object scrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.scrollToItem(i, i2, continuation);
    }

    static final float scrollableState$lambda$0(LazyGridState lazyGridState, float f) {
        return -lazyGridState.onScroll$foundation(-f);
    }

    private void setCanScrollBackward(boolean z) {
        this.canScrollBackward.setValue(Boolean.valueOf(z));
    }

    private void setCanScrollForward(boolean z) {
        this.canScrollForward.setValue(Boolean.valueOf(z));
    }

    public final Object animateScrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object objScroll$default = ScrollableState.scroll$default(this, null, new AnonymousClass2(i, i2, null), continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation(LazyGridMeasureResult result, boolean isLookingAhead, boolean visibleItemsStayedTheSame) {
        this.prefetchState.setIdealNestedPrefetchCount$foundation(result.getVisibleItemsInfo().size());
        if (!isLookingAhead && this.hasLookaheadOccurred) {
            this.approachLayoutInfo = result;
            return;
        }
        if (isLookingAhead) {
            this.hasLookaheadOccurred = true;
        }
        this.scrollToBeConsumed -= result.getConsumedScroll();
        this.layoutInfoState.setValue(result);
        setCanScrollBackward(result.getCanScrollBackward());
        setCanScrollForward(result.getCanScrollForward());
        LazyGridScrollPosition lazyGridScrollPosition = this.scrollPosition;
        if (visibleItemsStayedTheSame) {
            lazyGridScrollPosition.updateScrollOffset(result.getFirstVisibleLineScrollOffset());
        } else {
            lazyGridScrollPosition.updateFromMeasureResult(result);
            if (this.prefetchingEnabled) {
                this.prefetchStrategy.onVisibleItemsUpdated(this.prefetchScope, result);
            }
        }
        if (isLookingAhead) {
            this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation(result.getScrollBackAmount(), result.getDensity(), result.getCoroutineScope());
        }
        this.numMeasurePasses++;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    /* JADX INFO: renamed from: getApproachLayoutInfo$foundation, reason: from getter */
    public final LazyGridMeasureResult getApproachLayoutInfo() {
        return this.approachLayoutInfo;
    }

    /* JADX INFO: renamed from: getAwaitLayoutModifier$foundation, reason: from getter */
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier() {
        return this.awaitLayoutModifier;
    }

    /* JADX INFO: renamed from: getBeyondBoundsInfo$foundation, reason: from getter */
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward.getValue()).booleanValue();
    }

    public final Density getDensity$foundation() {
        return this.layoutInfoState.getValue().getDensity();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    /* JADX INFO: renamed from: getHasLookaheadOccurred$foundation, reason: from getter */
    public final boolean getHasLookaheadOccurred() {
        return this.hasLookaheadOccurred;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    /* JADX INFO: renamed from: getInternalInteractionSource$foundation, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
    }

    public final LazyLayoutItemAnimator<LazyGridMeasuredItem> getItemAnimator$foundation() {
        return this.itemAnimator;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    /* JADX INFO: renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation, reason: not valid java name */
    public final MutableState<Unit> m2182getMeasurementScopeInvalidatorzYiylxw$foundation() {
        return this.measurementScopeInvalidator;
    }

    public final IntRange getNearestRange$foundation() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    /* JADX INFO: renamed from: getNumMeasurePasses$foundation, reason: from getter */
    public final int getNumMeasurePasses() {
        return this.numMeasurePasses;
    }

    /* JADX INFO: renamed from: getPinnedItems$foundation, reason: from getter */
    public final LazyLayoutPinnedItemList getPinnedItems() {
        return this.pinnedItems;
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation, reason: not valid java name */
    public final MutableState<Unit> m2183getPlacementScopeInvalidatorzYiylxw$foundation() {
        return this.placementScopeInvalidator;
    }

    /* JADX INFO: renamed from: getPrefetchState$foundation, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    /* JADX INFO: renamed from: getPrefetchStrategy$foundation, reason: from getter */
    public final LazyGridPrefetchStrategy getPrefetchStrategy() {
        return this.prefetchStrategy;
    }

    /* JADX INFO: renamed from: getPrefetchingEnabled$foundation, reason: from getter */
    public final boolean getPrefetchingEnabled() {
        return this.prefetchingEnabled;
    }

    /* JADX INFO: renamed from: getRemeasurement$foundation, reason: from getter */
    public final Remeasurement getRemeasurement() {
        return this.remeasurement;
    }

    /* JADX INFO: renamed from: getRemeasurementModifier$foundation, reason: from getter */
    public final RemeasurementModifier getRemeasurementModifier() {
        return this.remeasurementModifier;
    }

    public final float getScrollDeltaBetweenPasses$foundation() {
        return this._lazyLayoutScrollDeltaBetweenPasses.getScrollDeltaBetweenPasses$foundation();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public ScrollIndicatorState getScrollIndicatorState() {
        return this._scrollIndicatorState;
    }

    /* JADX INFO: renamed from: getScrollToBeConsumed$foundation, reason: from getter */
    public final float getScrollToBeConsumed() {
        return this.scrollToBeConsumed;
    }

    public final int getSlotsPerLine$foundation() {
        return this.layoutInfoState.getValue().getSlotsPerLine();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final float onScroll$foundation(float distance) {
        LazyGridMeasureResult lazyGridMeasureResult;
        if ((distance < 0.0f && !getCanScrollForward()) || (distance > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (!(Math.abs(this.scrollToBeConsumed) <= 0.5f)) {
            InlineClassHelperKt.throwIllegalStateException("entered drag with non-zero pending scroll");
        }
        float f = this.scrollToBeConsumed + distance;
        this.scrollToBeConsumed = f;
        if (Math.abs(f) > 0.5f) {
            float f2 = this.scrollToBeConsumed;
            int iRoundToInt = MathKt.roundToInt(f2);
            LazyGridMeasureResult lazyGridMeasureResultCopyWithScrollDeltaWithoutRemeasure = this.layoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(iRoundToInt, !this.hasLookaheadOccurred);
            if (lazyGridMeasureResultCopyWithScrollDeltaWithoutRemeasure != null && (lazyGridMeasureResult = this.approachLayoutInfo) != null) {
                LazyGridMeasureResult lazyGridMeasureResultCopyWithScrollDeltaWithoutRemeasure2 = lazyGridMeasureResult != null ? lazyGridMeasureResult.copyWithScrollDeltaWithoutRemeasure(iRoundToInt, true) : null;
                if (lazyGridMeasureResultCopyWithScrollDeltaWithoutRemeasure2 != null) {
                    this.approachLayoutInfo = lazyGridMeasureResultCopyWithScrollDeltaWithoutRemeasure2;
                } else {
                    lazyGridMeasureResultCopyWithScrollDeltaWithoutRemeasure = null;
                }
            }
            if (lazyGridMeasureResultCopyWithScrollDeltaWithoutRemeasure != null) {
                applyMeasureResult$foundation(lazyGridMeasureResultCopyWithScrollDeltaWithoutRemeasure, this.hasLookaheadOccurred, true);
                ObservableScopeInvalidator.m2231invalidateScopeimpl(this.placementScopeInvalidator);
                notifyPrefetchOnScroll(f2 - this.scrollToBeConsumed, lazyGridMeasureResultCopyWithScrollDeltaWithoutRemeasure);
            } else {
                Remeasurement remeasurement = this.remeasurement;
                if (remeasurement != null) {
                    remeasurement.forceRemeasure();
                }
                notifyPrefetchOnScroll(f2 - this.scrollToBeConsumed, getLayoutInfo());
            }
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            return distance;
        }
        float f3 = distance - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return f3;
    }

    public final void requestScrollToItem(int index, int scrollOffset) {
        if (isScrollInProgress()) {
            BuildersKt__Builders_commonKt.launch$default(this.layoutInfoState.getValue().getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
        }
        snapToItemIndexInternal$foundation(index, scrollOffset, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006f, code lost:
    
        if (r6.scroll(r7, r8, r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        C03781 c03781;
        if (continuation instanceof C03781) {
            c03781 = (C03781) continuation;
            if ((c03781.label & Integer.MIN_VALUE) != 0) {
                c03781.label -= Integer.MIN_VALUE;
            } else {
                c03781 = new C03781(continuation);
            }
        }
        Object obj = c03781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03781.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.layoutInfoState.getValue() == LazyGridStateKt.EmptyLazyGridLayoutInfo) {
                AwaitFirstLayoutModifier awaitFirstLayoutModifier = this.awaitLayoutModifier;
                c03781.L$0 = mutatePriority;
                c03781.L$1 = function2;
                c03781.label = 1;
                if (awaitFirstLayoutModifier.waitForFirstLayout(c03781) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function22 = (Function2) c03781.L$1;
            MutatePriority mutatePriority2 = (MutatePriority) c03781.L$0;
            ResultKt.throwOnFailure(obj);
            function2 = function22;
            mutatePriority = mutatePriority2;
        }
        ScrollableState scrollableState = this.scrollableState;
        c03781.L$0 = null;
        c03781.L$1 = null;
        c03781.label = 2;
    }

    public final Object scrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object objScroll$default = ScrollableState.scroll$default(this, null, new C03792(i, i2, null), continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    public final void setPrefetchingEnabled$foundation(boolean z) {
        this.prefetchingEnabled = z;
    }

    public final void snapToItemIndexInternal$foundation(int index, int scrollOffset, boolean forceRemeasure) {
        if (this.scrollPosition.getIndex() != index || this.scrollPosition.getScrollOffset() != scrollOffset) {
            this.itemAnimator.reset();
            Object obj = this.prefetchStrategy;
            CacheWindowLogic cacheWindowLogic = obj instanceof CacheWindowLogic ? (CacheWindowLogic) obj : null;
            if (cacheWindowLogic != null) {
                cacheWindowLogic.resetStrategy();
            }
        }
        this.scrollPosition.requestPositionAndForgetLastKnownKey(index, scrollOffset);
        if (!forceRemeasure) {
            ObservableScopeInvalidator.m2231invalidateScopeimpl(this.measurementScopeInvalidator);
            return;
        }
        Remeasurement remeasurement = this.remeasurement;
        if (remeasurement != null) {
            remeasurement.forceRemeasure();
        }
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation(LazyGridItemProvider itemProvider, int firstItemIndex) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider, firstItemIndex);
    }
}
