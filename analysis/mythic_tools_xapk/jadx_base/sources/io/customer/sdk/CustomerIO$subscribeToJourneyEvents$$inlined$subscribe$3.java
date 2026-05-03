package io.customer.sdk;

import io.customer.sdk.communication.Event;
import io.customer.sdk.communication.EventBusKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventBus.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CustomerIO$subscribeToJourneyEvents$$inlined$subscribe$3 extends FunctionReferenceImpl implements Function2<Event.RegisterDeviceTokenEvent, Continuation<? super Unit>, Object>, SuspendFunction {
    public CustomerIO$subscribeToJourneyEvents$$inlined$subscribe$3(Object obj) {
        super(2, obj, Intrinsics.Kotlin.class, "suspendConversion0", "subscribe$suspendConversion0(Lkotlin/jvm/functions/Function1;Lio/customer/sdk/communication/Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Event.RegisterDeviceTokenEvent registerDeviceTokenEvent, Continuation<? super Unit> continuation) {
        return EventBusKt.subscribe$suspendConversion0((Function1) this.receiver, registerDeviceTokenEvent, continuation);
    }
}
