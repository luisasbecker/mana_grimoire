package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableState;
import com.google.firebase.analytics.FirebaseAnalytics;
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
@DebugMetadata(c = "com.studiolaganne.lengendarylens.OnboardingActivityKt$OnboardingScreen$1$1", f = "OnboardingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OnboardingActivityKt$OnboardingScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FirebaseAnalytics $firebaseAnalytics;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ MutableState<Boolean> $showContent$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingActivityKt$OnboardingScreen$1$1(FirebaseAnalytics firebaseAnalytics, MutableState<Boolean> mutableState, PagerState pagerState, Continuation<? super OnboardingActivityKt$OnboardingScreen$1$1> continuation) {
        super(2, continuation);
        this.$firebaseAnalytics = firebaseAnalytics;
        this.$showContent$delegate = mutableState;
        this.$pagerState = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingActivityKt$OnboardingScreen$1$1(this.$firebaseAnalytics, this.$showContent$delegate, this.$pagerState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingActivityKt$OnboardingScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (OnboardingActivityKt.OnboardingScreen$lambda$4(this.$showContent$delegate)) {
            Bundle bundle = new Bundle();
            PagerState pagerState = this.$pagerState;
            bundle.putInt("page_number", pagerState.getCurrentPage());
            bundle.putString("page_name", OnboardingActivityKt.getPageName(pagerState.getCurrentPage()));
            this.$firebaseAnalytics.logEvent("onboarding_page_viewed", bundle);
        }
        return Unit.INSTANCE;
    }
}
