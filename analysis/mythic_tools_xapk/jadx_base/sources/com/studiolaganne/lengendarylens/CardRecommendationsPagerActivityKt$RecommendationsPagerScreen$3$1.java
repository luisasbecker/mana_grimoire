package com.studiolaganne.lengendarylens;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CardRecommendationsPagerActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1", f = "CardRecommendationsPagerActivity.kt", i = {}, l = {382}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnapshotStateList<MTFullCard> $cards;
    final /* synthetic */ MutableIntState $currentPage$delegate;
    final /* synthetic */ String $deviceLocale;
    final /* synthetic */ MutableState<Boolean> $hasMorePages$delegate;
    final /* synthetic */ MutableState<Boolean> $isLoadingMore$delegate;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ PagerPaginationState $paginationState;
    final /* synthetic */ MutableState<Integer> $totalCards$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1(PagerState pagerState, SnapshotStateList<MTFullCard> snapshotStateList, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, PagerPaginationState pagerPaginationState, MutableIntState mutableIntState, MutableState<Integer> mutableState3, String str, Continuation<? super CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$cards = snapshotStateList;
        this.$hasMorePages$delegate = mutableState;
        this.$isLoadingMore$delegate = mutableState2;
        this.$paginationState = pagerPaginationState;
        this.$currentPage$delegate = mutableIntState;
        this.$totalCards$delegate = mutableState3;
        this.$deviceLocale = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1(this.$pagerState, this.$cards, this.$hasMorePages$delegate, this.$isLoadingMore$delegate, this.$paginationState, this.$currentPage$delegate, this.$totalCards$delegate, this.$deviceLocale, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final PagerState pagerState = this.$pagerState;
            Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Integer.valueOf(pagerState.getCurrentPage());
                }
            });
            final SnapshotStateList<MTFullCard> snapshotStateList = this.$cards;
            final MutableState<Boolean> mutableState = this.$hasMorePages$delegate;
            final MutableState<Boolean> mutableState2 = this.$isLoadingMore$delegate;
            final PagerPaginationState pagerPaginationState = this.$paginationState;
            final MutableIntState mutableIntState = this.$currentPage$delegate;
            final MutableState<Integer> mutableState3 = this.$totalCards$delegate;
            final String str = this.$deviceLocale;
            this.label = 1;
            if (flowSnapshotFlow.collect(new FlowCollector() { // from class: com.studiolaganne.lengendarylens.CardRecommendationsPagerActivityKt$RecommendationsPagerScreen$3$1.2
                public final Object emit(int i2, Continuation<? super Unit> continuation) {
                    if (CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$9(mutableState) && !CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$lambda$15(mutableState2) && i2 >= snapshotStateList.size() - 3) {
                        CardRecommendationsPagerActivityKt.RecommendationsPagerScreen$loadNextPage(pagerPaginationState, mutableState2, mutableState, mutableIntState, snapshotStateList, mutableState3, str);
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Number) obj2).intValue(), (Continuation<? super Unit>) continuation);
                }
            }, this) == coroutine_suspended) {
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
