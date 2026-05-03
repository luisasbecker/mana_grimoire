package io.customer.datapipelines.plugins;

import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.System;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: CustomerIODestination.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.customer.datapipelines.plugins.CustomerIODestination$setup$2$1", f = "CustomerIODestination.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
final class CustomerIODestination$setup$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Analytics $this_with;
    int label;
    final /* synthetic */ CustomerIODestination this$0;

    /* JADX INFO: renamed from: io.customer.datapipelines.plugins.CustomerIODestination$setup$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomerIODestination.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function2<System, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass1(Object obj) {
            super(2, obj, CustomerIODestination.class, "onEnableToggled", "onEnableToggled$datapipelines_release(Lcom/segment/analytics/kotlin/core/System;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(System system, Continuation<? super Unit> continuation) {
            return CustomerIODestination$setup$2$1.invokeSuspend$onEnableToggled((CustomerIODestination) this.receiver, system, continuation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomerIODestination$setup$2$1(Analytics analytics, CustomerIODestination customerIODestination, Continuation<? super CustomerIODestination$setup$2$1> continuation) {
        super(2, continuation);
        this.$this_with = analytics;
        this.this$0 = customerIODestination;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object invokeSuspend$onEnableToggled(CustomerIODestination customerIODestination, System system, Continuation continuation) {
        customerIODestination.onEnableToggled$datapipelines_release(system);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerIODestination$setup$2$1(this.$this_with, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomerIODestination$setup$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (Store.subscribe$default(this.$this_with.getStore(), this.this$0, Reflection.getOrCreateKotlinClass(System.class), true, null, new AnonymousClass1(this.this$0), this, 8, null) == coroutine_suspended) {
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
