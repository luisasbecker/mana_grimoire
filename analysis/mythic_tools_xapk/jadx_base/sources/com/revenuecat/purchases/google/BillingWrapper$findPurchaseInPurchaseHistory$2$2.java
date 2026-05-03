package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BillingWrapper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class BillingWrapper$findPurchaseInPurchaseHistory$2$2 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
    BillingWrapper$findPurchaseInPurchaseHistory$2$2(Object obj) {
        super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super BillingClient, ? extends Unit> function1) {
        invoke2((Function1<? super BillingClient, Unit>) function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function1<? super BillingClient, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((BillingWrapper) this.receiver).withConnectedClient(p0);
    }
}
