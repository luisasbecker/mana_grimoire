package com.segment.analytics.kotlin.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: Telemetry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class Telemetry$subscribe$2 extends FunctionReferenceImpl implements Function2<System, Continuation<? super Unit>, Object>, SuspendFunction {
    Telemetry$subscribe$2(Object obj) {
        super(2, obj, Telemetry.class, "systemUpdate", "systemUpdate(Lcom/segment/analytics/kotlin/core/System;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(System system, Continuation<? super Unit> continuation) {
        return ((Telemetry) this.receiver).systemUpdate(system, continuation);
    }
}
