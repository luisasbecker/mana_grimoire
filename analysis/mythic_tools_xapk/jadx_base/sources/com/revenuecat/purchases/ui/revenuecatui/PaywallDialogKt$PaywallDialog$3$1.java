package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.runtime.MutableState;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: PaywallDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$3$1", f = "PaywallDialog.kt", i = {}, l = {Imgproc.COLOR_RGB2YUV}, m = "invokeSuspend", n = {}, s = {})
final class PaywallDialogKt$PaywallDialog$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<OfferingSelection> $currentDialogOffering$delegate;
    final /* synthetic */ Function0<Unit> $dismissDialog;
    final /* synthetic */ MutableState<OfferingSelection> $pendingExitOffering$delegate;
    final /* synthetic */ Function1<CustomerInfo, Boolean> $shouldDisplayBlock;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PaywallDialogKt$PaywallDialog$3$1(Function1<? super CustomerInfo, Boolean> function1, Function0<Unit> function0, MutableState<OfferingSelection> mutableState, MutableState<OfferingSelection> mutableState2, Continuation<? super PaywallDialogKt$PaywallDialog$3$1> continuation) {
        super(2, continuation);
        this.$shouldDisplayBlock = function1;
        this.$dismissDialog = function0;
        this.$currentDialogOffering$delegate = mutableState;
        this.$pendingExitOffering$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallDialogKt$PaywallDialog$3$1(this.$shouldDisplayBlock, this.$dismissDialog, this.$currentDialogOffering$delegate, this.$pendingExitOffering$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallDialogKt$PaywallDialog$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (PaywallDialogKt.PaywallDialog$lambda$5(this.$currentDialogOffering$delegate) == null && PaywallDialogKt.PaywallDialog$lambda$8(this.$pendingExitOffering$delegate) != null) {
                Function1<CustomerInfo, Boolean> function1 = this.$shouldDisplayBlock;
                if (function1 != null) {
                    this.label = 1;
                    obj = HelperFunctionsKt.shouldDisplayPaywall(function1, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.$currentDialogOffering$delegate.setValue(PaywallDialogKt.PaywallDialog$lambda$8(this.$pendingExitOffering$delegate));
                    this.$pendingExitOffering$delegate.setValue(null);
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (((Boolean) obj).booleanValue()) {
            this.$currentDialogOffering$delegate.setValue(PaywallDialogKt.PaywallDialog$lambda$8(this.$pendingExitOffering$delegate));
        } else {
            this.$dismissDialog.invoke();
        }
        this.$pendingExitOffering$delegate.setValue(null);
        return Unit.INSTANCE;
    }
}
