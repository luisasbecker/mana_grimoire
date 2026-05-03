package com.segment.analytics.kotlin.android.plugins;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidContextPlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin$loadDeviceId$1$task$1", f = "AndroidContextPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AndroidContextPlugin$loadDeviceId$1$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ boolean $collectDeviceId;
    final /* synthetic */ String $fallbackDeviceId;
    int label;
    final /* synthetic */ AndroidContextPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidContextPlugin$loadDeviceId$1$task$1(AndroidContextPlugin androidContextPlugin, boolean z, String str, Continuation<? super AndroidContextPlugin$loadDeviceId$1$task$1> continuation) {
        super(2, continuation);
        this.this$0 = androidContextPlugin;
        this.$collectDeviceId = z;
        this.$fallbackDeviceId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidContextPlugin$loadDeviceId$1$task$1(this.this$0, this.$collectDeviceId, this.$fallbackDeviceId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((AndroidContextPlugin$loadDeviceId$1$task$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.this$0.getDeviceId$android_release(this.$collectDeviceId, this.$fallbackDeviceId);
    }
}
