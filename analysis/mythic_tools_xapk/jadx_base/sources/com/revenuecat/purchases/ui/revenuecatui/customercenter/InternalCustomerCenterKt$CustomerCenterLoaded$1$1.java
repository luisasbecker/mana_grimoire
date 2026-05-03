package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.State;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InternalCustomerCenter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterLoaded$1$1", f = "InternalCustomerCenter.kt", i = {}, l = {423}, m = "invokeSuspend", n = {}, s = {})
final class InternalCustomerCenterKt$CustomerCenterLoaded$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<String> $latestMessage$delegate;
    final /* synthetic */ State<Function1<CustomerCenterAction, Unit>> $latestOnAction$delegate;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ CustomerCenterState.Success $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    InternalCustomerCenterKt$CustomerCenterLoaded$1$1(CustomerCenterState.Success success, SnackbarHostState snackbarHostState, State<String> state, State<? extends Function1<? super CustomerCenterAction, Unit>> state2, Continuation<? super InternalCustomerCenterKt$CustomerCenterLoaded$1$1> continuation) {
        super(2, continuation);
        this.$state = success;
        this.$snackbarHostState = snackbarHostState;
        this.$latestMessage$delegate = state;
        this.$latestOnAction$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InternalCustomerCenterKt$CustomerCenterLoaded$1$1(this.$state, this.$snackbarHostState, this.$latestMessage$delegate, this.$latestOnAction$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InternalCustomerCenterKt$CustomerCenterLoaded$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$state.getShowSupportTicketSuccessSnackbar()) {
                this.label = 1;
                if (SnackbarHostState.showSnackbar$default(this.$snackbarHostState, InternalCustomerCenterKt.CustomerCenterLoaded$lambda$14(this.$latestMessage$delegate), null, false, null, this, 14, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        InternalCustomerCenterKt.CustomerCenterLoaded$lambda$13(this.$latestOnAction$delegate).invoke(CustomerCenterAction.DismissSupportTicketSuccessSnackbar.INSTANCE);
        return Unit.INSTANCE;
    }
}
