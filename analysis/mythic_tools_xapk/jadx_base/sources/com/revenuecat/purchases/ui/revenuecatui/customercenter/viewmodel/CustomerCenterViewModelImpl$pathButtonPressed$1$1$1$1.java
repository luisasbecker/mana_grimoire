package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import android.content.Context;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CustomerCenterViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1", f = "CustomerCenterViewModel.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
final class CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option $it;
    final /* synthetic */ CustomerCenterConfigData.HelpPath $path;
    final /* synthetic */ PurchaseInformation $purchaseInformation;
    int label;
    final /* synthetic */ CustomerCenterViewModelImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1(CustomerCenterViewModelImpl customerCenterViewModelImpl, Context context, PurchaseInformation purchaseInformation, CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option, CustomerCenterConfigData.HelpPath helpPath, Continuation<? super CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = customerCenterViewModelImpl;
        this.$context = context;
        this.$purchaseInformation = purchaseInformation;
        this.$it = option;
        this.$path = helpPath;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1(this.this$0, this.$context, this.$purchaseInformation, this.$it, this.$path, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CustomerCenterViewModelImpl customerCenterViewModelImpl = this.this$0;
            Context context = this.$context;
            PurchaseInformation purchaseInformation = this.$purchaseInformation;
            StoreProduct product = purchaseInformation != null ? purchaseInformation.getProduct() : null;
            this.label = 1;
            obj = customerCenterViewModelImpl.handlePromotionalOffer(context, product, this.$it.getPromotionalOffer(), this.$path, this.$purchaseInformation, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!((Boolean) obj).booleanValue()) {
            this.this$0.goBackToMain();
            this.this$0.mainPathAction(this.$path, this.$context, this.$purchaseInformation);
        }
        return Unit.INSTANCE;
    }
}
