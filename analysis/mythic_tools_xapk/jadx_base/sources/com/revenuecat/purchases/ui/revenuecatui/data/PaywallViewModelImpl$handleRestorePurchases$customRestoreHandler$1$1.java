package com.revenuecat.purchases.ui.revenuecatui.data;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.PurchaseLogicResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PaywallViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class PaywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1 extends FunctionReferenceImpl implements Function2<CustomerInfo, Continuation<? super PurchaseLogicResult>, Object>, SuspendFunction {
    PaywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1(Object obj) {
        super(2, obj, PaywallPurchaseLogic.class, "performRestore", "performRestore(Lcom/revenuecat/purchases/CustomerInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CustomerInfo customerInfo, Continuation<? super PurchaseLogicResult> continuation) {
        return ((PaywallPurchaseLogic) this.receiver).performRestore(customerInfo, continuation);
    }
}
