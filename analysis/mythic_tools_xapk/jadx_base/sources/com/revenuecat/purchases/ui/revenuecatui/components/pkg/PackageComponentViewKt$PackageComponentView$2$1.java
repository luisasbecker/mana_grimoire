package com.revenuecat.purchases.ui.revenuecatui.components.pkg;

import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.style.PackageComponentStyle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PackageComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt$PackageComponentView$2$1", f = "PackageComponentView.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
public final class PackageComponentViewKt$PackageComponentView$2$1 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PaywallAction, Continuation<? super Unit>, Object> $clickHandler;
    final /* synthetic */ PackageComponentStyle $style;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PackageComponentViewKt$PackageComponentView$2$1(PackageComponentStyle packageComponentStyle, Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super PackageComponentViewKt$PackageComponentView$2$1> continuation) {
        super(2, continuation);
        this.$style = packageComponentStyle;
        this.$clickHandler = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PackageComponentViewKt$PackageComponentView$2$1 packageComponentViewKt$PackageComponentView$2$1 = new PackageComponentViewKt$PackageComponentView$2$1(this.$style, this.$clickHandler, continuation);
        packageComponentViewKt$PackageComponentView$2$1.L$0 = obj;
        return packageComponentViewKt$PackageComponentView$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
        return ((PackageComponentViewKt$PackageComponentView$2$1) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PaywallAction paywallAction = (PaywallAction) this.L$0;
            if (!this.$style.isSelectable()) {
                Function2<PaywallAction, Continuation<? super Unit>, Object> function2 = this.$clickHandler;
                this.label = 1;
                if (function2.invoke(paywallAction, this) == coroutine_suspended) {
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
