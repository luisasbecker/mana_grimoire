package com.segment.analytics.kotlin.android.plugins;

import com.segment.analytics.kotlin.core.Storage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$trackApplicationLifecycleEvents$3", f = "AndroidLifecyclePlugin.kt", i = {}, l = {265, 266}, m = "invokeSuspend", n = {}, s = {})
final class AndroidLifecyclePlugin$trackApplicationLifecycleEvents$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentBuild;
    final /* synthetic */ String $currentVersion;
    int label;
    final /* synthetic */ AndroidLifecyclePlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidLifecyclePlugin$trackApplicationLifecycleEvents$3(AndroidLifecyclePlugin androidLifecyclePlugin, String str, String str2, Continuation<? super AndroidLifecyclePlugin$trackApplicationLifecycleEvents$3> continuation) {
        super(1, continuation);
        this.this$0 = androidLifecyclePlugin;
        this.$currentVersion = str;
        this.$currentBuild = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AndroidLifecyclePlugin$trackApplicationLifecycleEvents$3(this.this$0, this.$currentVersion, this.$currentBuild, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AndroidLifecyclePlugin$trackApplicationLifecycleEvents$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        if (r2.write(com.segment.analytics.kotlin.core.Storage.Constants.AppBuild, r8.$currentBuild, r8) == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Storage storage = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Storage storage2 = this.this$0.storage;
            if (storage2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storage");
                storage2 = null;
            }
            Storage.Constants constants = Storage.Constants.AppVersion;
            String currentVersion = this.$currentVersion;
            Intrinsics.checkNotNullExpressionValue(currentVersion, "currentVersion");
            this.label = 1;
            if (storage2.write(constants, currentVersion, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        Storage storage3 = this.this$0.storage;
        if (storage3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
        } else {
            storage = storage3;
        }
        this.label = 2;
    }
}
