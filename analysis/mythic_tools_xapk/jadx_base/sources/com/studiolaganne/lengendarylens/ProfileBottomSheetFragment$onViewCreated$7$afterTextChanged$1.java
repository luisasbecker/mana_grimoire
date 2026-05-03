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

/* JADX INFO: compiled from: ProfileBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.ProfileBottomSheetFragment$onViewCreated$7$afterTextChanged$1", f = "ProfileBottomSheetFragment.kt", i = {}, l = {620}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ProfileBottomSheetFragment$onViewCreated$7$afterTextChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newQuery;
    int label;
    final /* synthetic */ ProfileBottomSheetFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileBottomSheetFragment$onViewCreated$7$afterTextChanged$1(ProfileBottomSheetFragment profileBottomSheetFragment, String str, Continuation<? super ProfileBottomSheetFragment$onViewCreated$7$afterTextChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = profileBottomSheetFragment;
        this.$newQuery = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileBottomSheetFragment$onViewCreated$7$afterTextChanged$1(this.this$0, this.$newQuery, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileBottomSheetFragment$onViewCreated$7$afterTextChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(750L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.performSearch(this.$newQuery);
        return Unit.INSTANCE;
    }
}
