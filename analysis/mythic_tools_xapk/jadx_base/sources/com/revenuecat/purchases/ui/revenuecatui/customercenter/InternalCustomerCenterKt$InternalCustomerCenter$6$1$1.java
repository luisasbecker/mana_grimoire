package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: InternalCustomerCenter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class InternalCustomerCenterKt$InternalCustomerCenter$6$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    InternalCustomerCenterKt$InternalCustomerCenter$6$1$1(Object obj) {
        super(0, obj, CustomerCenterViewModel.class, "clearActionError", "clearActionError()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((CustomerCenterViewModel) this.receiver).clearActionError();
    }
}
