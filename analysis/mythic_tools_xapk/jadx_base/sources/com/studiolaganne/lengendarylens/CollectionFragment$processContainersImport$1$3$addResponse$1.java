package com.studiolaganne.lengendarylens;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

/* JADX INFO: compiled from: CollectionFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lcom/studiolaganne/lengendarylens/MTCardListResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.CollectionFragment$processContainersImport$1$3$addResponse$1", f = "CollectionFragment.kt", i = {}, l = {663}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionFragment$processContainersImport$1$3$addResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<MTCardListResponse>>, Object> {
    final /* synthetic */ List<MTFullCard> $cards;
    final /* synthetic */ MTUser $currentUser;
    int label;
    final /* synthetic */ CollectionFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionFragment$processContainersImport$1$3$addResponse$1(CollectionFragment collectionFragment, MTUser mTUser, List<MTFullCard> list, Continuation<? super CollectionFragment$processContainersImport$1$3$addResponse$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionFragment;
        this.$currentUser = mTUser;
        this.$cards = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionFragment$processContainersImport$1$3$addResponse$1(this.this$0, this.$currentUser, this.$cards, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<MTCardListResponse>> continuation) {
        return ((CollectionFragment$processContainersImport$1$3$addResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objAddCardsToContainerSync = this.this$0.addCardsToContainerSync(this.$currentUser.getId(), 4, this.$cards, this);
        return objAddCardsToContainerSync == coroutine_suspended ? coroutine_suspended : objAddCardsToContainerSync;
    }
}
