package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: CollectionFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.CollectionFragment$processContainersImport$1$containerId$newContainerId$1", f = "CollectionFragment.kt", i = {}, l = {Videoio.CAP_PROP_XI_BUFFERS_QUEUE_SIZE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionFragment$processContainersImport$1$containerId$newContainerId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ MTUser $currentUser;
    final /* synthetic */ MTEditListBody $editBody;
    int label;
    final /* synthetic */ CollectionFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionFragment$processContainersImport$1$containerId$newContainerId$1(CollectionFragment collectionFragment, MTUser mTUser, MTEditListBody mTEditListBody, Continuation<? super CollectionFragment$processContainersImport$1$containerId$newContainerId$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionFragment;
        this.$currentUser = mTUser;
        this.$editBody = mTEditListBody;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionFragment$processContainersImport$1$containerId$newContainerId$1(this.this$0, this.$currentUser, this.$editBody, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((CollectionFragment$processContainersImport$1$containerId$newContainerId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object objCreateContainerSync = this.this$0.createContainerSync(this.$currentUser.getId(), this.$editBody, this);
        return objCreateContainerSync == coroutine_suspended ? coroutine_suspended : objCreateContainerSync;
    }
}
