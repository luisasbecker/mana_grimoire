package androidx.camera.camera2.impl;

import androidx.camera.camera2.pipe.CameraControls3A;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: UseCaseCameraRequestControl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1", f = "UseCaseCameraRequestControl.kt", i = {}, l = {749, 497, 497, 761}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1 extends SuspendLambda implements Function1<Continuation<? super Deferred<? extends Result3A>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ UseCaseCameraRequestControlImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, Continuation<? super UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1> continuation) {
        super(1, continuation);
        this.this$0 = useCaseCameraRequestControlImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Deferred<? extends Result3A>> continuation) {
        return invoke2((Continuation<? super Deferred<Result3A>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Deferred<Result3A>> continuation) {
        return ((UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0108, code lost:
    
        if (r0 != r11) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f4 A[PHI: r13
      0x00f4: PHI (r13v5 ??) = (r13v19 ??), (r13v16 ??) binds: [B:64:0x00f1, B:14:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Throwable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Exception {
        CompletableDeferred completableDeferred;
        ?? r13;
        Object objAcquireSession;
        ?? r132;
        Object objAcquireSession2;
        AutoCloseable autoCloseable;
        Throwable th;
        AutoCloseable autoCloseable2;
        Throwable th2;
        AutoCloseable autoCloseable3;
        CameraGraph.Session session;
        Boolean boolBoxBoolean;
        Boolean boolBoxBoolean2;
        Boolean boolBoxBoolean3;
        Object objUnlock3A$default;
        AutoCloseable autoCloseable4;
        Throwable th3;
        Throwable th4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ?? r133 = 4;
        try {
            try {
                try {
                    try {
                    } catch (CancellationException e) {
                        e = e;
                        r133 = 0;
                        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                        CancellationException cancellationException = e;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Cannot acquire the CameraGraph.Session", cancellationException);
                        }
                        completableDeferred = UseCaseCameraRequestControlImpl.submitFailedResult;
                        ?? r134 = r133;
                        this.L$0 = r134;
                        this.label = 3;
                        r13 = r134;
                        if (completableDeferred.await(this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                } catch (CancellationException e2) {
                    e = e2;
                    Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                    CancellationException cancellationException2 = e;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                    }
                    completableDeferred = UseCaseCameraRequestControlImpl.submitFailedResult;
                    ?? r1342 = r133;
                    this.L$0 = r1342;
                    this.label = 3;
                    r13 = r1342;
                    if (completableDeferred.await(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl#cancelFocusAndMeteringAsync");
                            }
                            this.label = 1;
                            objAcquireSession2 = this.this$0.useCaseGraphContext.getGraph().acquireSession(this);
                            if (objAcquireSession2 == coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                            objAcquireSession2 = obj;
                        } else {
                            if (i == 2) {
                                autoCloseable4 = (AutoCloseable) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    objUnlock3A$default = obj;
                                    th3 = null;
                                } catch (Throwable th5) {
                                    th4 = th5;
                                    th3 = null;
                                    autoCloseable3 = autoCloseable4;
                                    th2 = th4;
                                    r133 = th3;
                                    try {
                                        throw th2;
                                    } finally {
                                        AutoCloseableKt.closeFinally(autoCloseable3, th2);
                                    }
                                }
                                try {
                                    completableDeferred = (Deferred) objUnlock3A$default;
                                    this.L$0 = r1342;
                                    this.label = 3;
                                    r13 = r1342;
                                    if (completableDeferred.await(this) != coroutine_suspended) {
                                        this.label = 4;
                                        objAcquireSession = this.this$0.useCaseGraphContext.getGraph().acquireSession(this);
                                        r132 = r13;
                                    }
                                    return coroutine_suspended;
                                } catch (Throwable th6) {
                                    th4 = th6;
                                    autoCloseable3 = autoCloseable4;
                                    th2 = th4;
                                    r133 = th3;
                                    throw th2;
                                }
                            }
                            if (i == 3) {
                                ResultKt.throwOnFailure(obj);
                                r13 = 0;
                                this.label = 4;
                                objAcquireSession = this.this$0.useCaseGraphContext.getGraph().acquireSession(this);
                                r132 = r13;
                            } else {
                                if (i != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                objAcquireSession = obj;
                                r132 = 0;
                                AutoCloseable autoCloseable5 = (AutoCloseable) objAcquireSession;
                                try {
                                    UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1 useCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1 = this;
                                    Deferred deferredM260update3AydBZfZg$default = CameraControls3A.m260update3AydBZfZg$default((CameraGraph.Session) autoCloseable5, null, null, null, ArraysKt.asList(CameraGraph.Constants3A.INSTANCE.getMETERING_REGIONS_DEFAULT()), ArraysKt.asList(CameraGraph.Constants3A.INSTANCE.getMETERING_REGIONS_DEFAULT()), ArraysKt.asList(CameraGraph.Constants3A.INSTANCE.getMETERING_REGIONS_DEFAULT()), 7, null);
                                    AutoCloseableKt.closeFinally(autoCloseable5, r132);
                                    return deferredM260update3AydBZfZg$default;
                                } finally {
                                }
                            }
                        }
                        objUnlock3A$default = CameraGraph.Session.unlock3A$default(session, boolBoxBoolean, boolBoxBoolean2, boolBoxBoolean3, null, 0, 0L, this, 56, null);
                        if (objUnlock3A$default != coroutine_suspended) {
                            autoCloseable4 = autoCloseable2;
                            th3 = th;
                            completableDeferred = (Deferred) objUnlock3A$default;
                            this.L$0 = r1342;
                            this.label = 3;
                            r13 = r1342;
                            if (completableDeferred.await(this) != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th7) {
                        th = th7;
                        th2 = th;
                        autoCloseable3 = autoCloseable2;
                        r133 = th;
                        throw th2;
                    }
                    boolBoxBoolean2 = Boxing.boxBoolean(true);
                    boolBoxBoolean3 = Boxing.boxBoolean(true);
                    this.L$0 = autoCloseable;
                    this.label = 2;
                    autoCloseable2 = autoCloseable;
                    th = null;
                } catch (Throwable th8) {
                    th = th8;
                    autoCloseable2 = autoCloseable;
                    th = null;
                }
                session = (CameraGraph.Session) autoCloseable;
                UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1 useCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$12 = this;
                boolBoxBoolean = Boxing.boxBoolean(true);
            } catch (Throwable th9) {
                th = th9;
                th = null;
                autoCloseable2 = autoCloseable;
            }
            autoCloseable = (AutoCloseable) objAcquireSession2;
        } catch (CancellationException e3) {
            Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
            CancellationException cancellationException3 = e3;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Cannot acquire the CameraGraph.Session", cancellationException3);
            }
            return UseCaseCameraRequestControlImpl.submitFailedResult;
        }
    }
}
