package com.revenuecat.purchases.ui.revenuecatui.components;

import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: LoadedPaywallComponents.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1", f = "LoadedPaywallComponents.kt", i = {}, l = {Imgproc.COLOR_BGR2YUV}, m = "invokeSuspend", n = {}, s = {})
final class LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PaywallAction.External, Continuation<? super Unit>, Object> $clickHandler;
    final /* synthetic */ PaywallState.Loaded.Components $state;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1(PaywallState.Loaded.Components components, Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1> continuation) {
        super(2, continuation);
        this.$state = components;
        this.$clickHandler = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1 loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1 = new LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1(this.$state, this.$clickHandler, continuation);
        loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1.L$0 = obj;
        return loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
        return ((LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (LoadedPaywallComponentsKt.handleClick((PaywallAction) this.L$0, this.$state, this.$clickHandler, this) == coroutine_suspended) {
                return coroutine_suspended;
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
