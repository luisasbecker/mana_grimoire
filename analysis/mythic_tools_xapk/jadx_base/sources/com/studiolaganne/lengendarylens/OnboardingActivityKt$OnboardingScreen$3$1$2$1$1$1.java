package com.studiolaganne.lengendarylens;

import androidx.compose.foundation.pager.PagerState;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OnboardingActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.OnboardingActivityKt$OnboardingScreen$3$1$2$1$1$1", f = "OnboardingActivity.kt", i = {}, l = {WebmConstants.MkvEbmlElement.TIMESTAMP}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OnboardingActivityKt$OnboardingScreen$3$1$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingActivityKt$OnboardingScreen$3$1$2$1$1$1(PagerState pagerState, Continuation<? super OnboardingActivityKt$OnboardingScreen$3$1$2$1$1$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingActivityKt$OnboardingScreen$3$1$2$1$1$1(this.$pagerState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingActivityKt$OnboardingScreen$3$1$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PagerState pagerState = this.$pagerState;
            this.label = 1;
            if (PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + 1, 0.0f, null, this, 6, null) == coroutine_suspended) {
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
