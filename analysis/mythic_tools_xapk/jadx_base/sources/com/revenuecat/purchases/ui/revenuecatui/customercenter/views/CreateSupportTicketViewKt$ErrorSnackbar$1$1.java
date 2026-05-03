package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.State;
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

/* JADX INFO: compiled from: CreateSupportTicketView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$ErrorSnackbar$1$1", f = "CreateSupportTicketView.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
final class CreateSupportTicketViewKt$ErrorSnackbar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Unit>> $currentOnErrorShow$delegate;
    final /* synthetic */ String $errorMessage;
    final /* synthetic */ SnackbarHostState $errorSnackbarHostState;
    final /* synthetic */ boolean $hasError;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CreateSupportTicketViewKt$ErrorSnackbar$1$1(boolean z, SnackbarHostState snackbarHostState, String str, State<? extends Function0<Unit>> state, Continuation<? super CreateSupportTicketViewKt$ErrorSnackbar$1$1> continuation) {
        super(2, continuation);
        this.$hasError = z;
        this.$errorSnackbarHostState = snackbarHostState;
        this.$errorMessage = str;
        this.$currentOnErrorShow$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateSupportTicketViewKt$ErrorSnackbar$1$1(this.$hasError, this.$errorSnackbarHostState, this.$errorMessage, this.$currentOnErrorShow$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateSupportTicketViewKt$ErrorSnackbar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$hasError) {
                this.label = 1;
                if (SnackbarHostState.showSnackbar$default(this.$errorSnackbarHostState, this.$errorMessage, null, false, null, this, 14, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CreateSupportTicketViewKt.ErrorSnackbar$lambda$26(this.$currentOnErrorShow$delegate).invoke();
        return Unit.INSTANCE;
    }
}
