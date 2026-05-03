package com.segment.analytics.kotlin.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.segment.analytics.kotlin.core.BaseEvent", f = "Events.kt", i = {0}, l = {93}, m = "applyBaseEventData$core", n = {"this"}, s = {"L$0"})
final class BaseEvent$applyBaseEventData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseEvent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseEvent$applyBaseEventData$1(BaseEvent baseEvent, Continuation<? super BaseEvent$applyBaseEventData$1> continuation) {
        super(continuation);
        this.this$0 = baseEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.applyBaseEventData$core(null, this);
    }
}
