package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: coroutinesExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$1 extends FunctionReferenceImpl implements Function1<AmazonLWAConsentStatus, Unit> {
    CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$1(Object obj) {
        super(1, obj, ContinuationKt.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AmazonLWAConsentStatus amazonLWAConsentStatus) {
        invoke2(amazonLWAConsentStatus);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AmazonLWAConsentStatus p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Continuation continuation = (Continuation) this.receiver;
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m11445constructorimpl(p0));
    }
}
