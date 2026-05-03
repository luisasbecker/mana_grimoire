package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CustomerCenterViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$state$1", f = "CustomerCenterViewModel.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
final class CustomerCenterViewModelImpl$state$1 extends SuspendLambda implements Function2<FlowCollector<? super CustomerCenterState>, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CustomerCenterViewModelImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomerCenterViewModelImpl$state$1(CustomerCenterViewModelImpl customerCenterViewModelImpl, Continuation<? super CustomerCenterViewModelImpl$state$1> continuation) {
        super(2, continuation);
        this.this$0 = customerCenterViewModelImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerCenterViewModelImpl$state$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CustomerCenterState> flowCollector, Continuation<? super Unit> continuation) {
        return ((CustomerCenterViewModelImpl$state$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CustomerCenterState customerCenterState = (CustomerCenterState) this.this$0._state.getValue();
            if ((customerCenterState instanceof CustomerCenterState.NotLoaded) || (customerCenterState instanceof CustomerCenterState.Loading) || (customerCenterState instanceof CustomerCenterState.Error)) {
                this.label = 1;
                if (this.this$0.loadCustomerCenter(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
