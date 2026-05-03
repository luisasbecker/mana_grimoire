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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: BrowseListFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$16$afterTextChanged$1", f = "BrowseListFragment.kt", i = {}, l = {1943, 1944}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BrowseListFragment$onViewCreated$16$afterTextChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newQuery;
    int label;
    final /* synthetic */ BrowseListFragment this$0;

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$16$afterTextChanged$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrowseListFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$16$afterTextChanged$1$1", f = "BrowseListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newQuery;
        int label;
        final /* synthetic */ BrowseListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BrowseListFragment browseListFragment, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = browseListFragment;
            this.$newQuery = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$newQuery, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.exitSelectionMode();
            this.this$0.updateFiltersAndRefreshList(this.$newQuery);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrowseListFragment$onViewCreated$16$afterTextChanged$1(BrowseListFragment browseListFragment, String str, Continuation<? super BrowseListFragment$onViewCreated$16$afterTextChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = browseListFragment;
        this.$newQuery = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrowseListFragment$onViewCreated$16$afterTextChanged$1(this.this$0, this.$newQuery, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BrowseListFragment$onViewCreated$16$afterTextChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.studiolaganne.lengendarylens.BrowseListFragment$onViewCreated$16$afterTextChanged$1.AnonymousClass1(r6.this$0, r6.$newQuery, null), r6) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.getContext() == null) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            if (DelayKt.delay(750L, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 2;
    }
}
