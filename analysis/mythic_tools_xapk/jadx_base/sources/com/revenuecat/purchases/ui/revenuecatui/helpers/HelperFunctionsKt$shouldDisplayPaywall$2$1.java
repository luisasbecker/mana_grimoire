package com.revenuecat.purchases.ui.revenuecatui.helpers;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: HelperFunctions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class HelperFunctionsKt$shouldDisplayPaywall$2$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    HelperFunctionsKt$shouldDisplayPaywall$2$1(Object obj) {
        super(1, obj, ContinuationKt.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Continuation continuation = (Continuation) this.receiver;
        Result.Companion companion = kotlin.Result.INSTANCE;
        continuation.resumeWith(kotlin.Result.m11445constructorimpl(boolValueOf));
    }
}
