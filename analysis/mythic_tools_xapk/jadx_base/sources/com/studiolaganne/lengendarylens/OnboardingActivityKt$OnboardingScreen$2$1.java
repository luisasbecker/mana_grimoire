package com.studiolaganne.lengendarylens;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: OnboardingActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.OnboardingActivityKt$OnboardingScreen$2$1", f = "OnboardingActivity.kt", i = {}, l = {128, 130}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OnboardingActivityKt$OnboardingScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $animationDuration;
    final /* synthetic */ MutableState<Boolean> $animationStarted$delegate;
    final /* synthetic */ MutableState<Boolean> $showContent$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingActivityKt$OnboardingScreen$2$1(int i, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super OnboardingActivityKt$OnboardingScreen$2$1> continuation) {
        super(2, continuation);
        this.$animationDuration = i;
        this.$animationStarted$delegate = mutableState;
        this.$showContent$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingActivityKt$OnboardingScreen$2$1(this.$animationDuration, this.$animationStarted$delegate, this.$showContent$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingActivityKt$OnboardingScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(((long) r8.$animationDuration) + 100, r8) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(1000L, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            OnboardingActivityKt.OnboardingScreen$lambda$5(this.$showContent$delegate, true);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        OnboardingActivityKt.OnboardingScreen$lambda$2(this.$animationStarted$delegate, true);
        this.label = 2;
    }
}
