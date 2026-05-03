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

/* JADX INFO: compiled from: CreateDeckBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$onViewCreated$10$afterTextChanged$2", f = "CreateDeckBottomSheetFragment.kt", i = {}, l = {1304, 1305}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CreateDeckBottomSheetFragment$onViewCreated$10$afterTextChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newQuery;
    int label;
    final /* synthetic */ CreateDeckBottomSheetFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CreateDeckBottomSheetFragment$onViewCreated$10$afterTextChanged$2(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, String str, Continuation<? super CreateDeckBottomSheetFragment$onViewCreated$10$afterTextChanged$2> continuation) {
        super(2, continuation);
        this.this$0 = createDeckBottomSheetFragment;
        this.$newQuery = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateDeckBottomSheetFragment$onViewCreated$10$afterTextChanged$2(this.this$0, this.$newQuery, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateDeckBottomSheetFragment$onViewCreated$10$afterTextChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        if (r5.this$0.performCommanderSearch(r5.$newQuery, r5) == r0) goto L15;
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
