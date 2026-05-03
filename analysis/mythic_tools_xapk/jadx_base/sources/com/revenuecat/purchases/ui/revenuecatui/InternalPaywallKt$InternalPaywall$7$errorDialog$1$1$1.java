package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: InternalPaywall.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class InternalPaywallKt$InternalPaywall$7$errorDialog$1$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    InternalPaywallKt$InternalPaywall$7$errorDialog$1$1$1(Object obj) {
        super(0, obj, PaywallViewModel.class, "clearActionError", "clearActionError()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((PaywallViewModel) this.receiver).clearActionError();
    }
}
