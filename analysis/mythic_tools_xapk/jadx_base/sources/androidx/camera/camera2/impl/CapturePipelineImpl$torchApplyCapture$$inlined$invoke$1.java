package androidx.camera.camera2.impl;

import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CapturePipeline.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/impl/CapturePipelineImpl$invoke$7$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1", f = "CapturePipeline.kt", i = {}, l = {312, 898, 900, 907}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $captureMode$inlined;
    final /* synthetic */ List $captureSignal;
    final /* synthetic */ boolean $lock3ARequired$inlined;
    final /* synthetic */ boolean $torchOnRequired$inlined;
    final /* synthetic */ boolean $triggerAePreCapture$inlined;
    Object L$0;
    int label;
    final /* synthetic */ CapturePipelineImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(List list, Continuation continuation, boolean z, CapturePipelineImpl capturePipelineImpl, boolean z2, boolean z3, int i) {
        super(2, continuation);
        this.$captureSignal = list;
        this.$torchOnRequired$inlined = z;
        this.this$0 = capturePipelineImpl;
        this.$triggerAePreCapture$inlined = z2;
        this.$lock3ARequired$inlined = z3;
        this.$captureMode$inlined = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(this.$captureSignal, continuation, this.$torchOnRequired$inlined, this.this$0, this.$triggerAePreCapture$inlined, this.$lock3ARequired$inlined, this.$captureMode$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0121, code lost:
    
        if (r15.unlockAf(r3, r14) == r0) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Exception {
        AutoCloseable autoCloseable;
        Throwable th;
        AutoCloseable autoCloseable2;
        CameraGraph.Session session;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: Waiting for POST_CAPTURE signal");
            }
            this.label = 1;
            if (AwaitKt.joinAll(this.$captureSignal, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                autoCloseable = (AutoCloseable) obj;
                try {
                    session = (CameraGraph.Session) autoCloseable;
                    if (this.$captureMode$inlined == 0) {
                        z = false;
                    }
                    this.L$0 = autoCloseable;
                    this.label = 3;
                    if (session.unlock3APostCapture(z, this) != coroutine_suspended) {
                        autoCloseable2 = autoCloseable;
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseable2 = autoCloseable;
                    throw th;
                }
            }
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Unlocking 3A done");
                }
                return Unit.INSTANCE;
            }
            autoCloseable2 = (AutoCloseable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                Unit unit2 = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(autoCloseable2, null);
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    AutoCloseableKt.closeFinally(autoCloseable2, th);
                    throw th4;
                }
            }
        }
        ResultKt.throwOnFailure(obj);
        Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: Waiting for POST_CAPTURE signal done");
        }
        if (this.$torchOnRequired$inlined) {
            Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Unsetting torch");
            }
            TorchControl.m100setTorchAsyncOup_wC0$camera_camera2$default(this.this$0.torchControl, TorchControl.TorchMode.INSTANCE.m112getOFFIRs_R8(), false, false, 6, null);
            Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Unsetting torch done");
            }
        }
        if (!this.$triggerAePreCapture$inlined) {
            if (this.$lock3ARequired$inlined && this.$captureMode$inlined == 0) {
                Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Unlocking 3A");
                }
                CapturePipelineImpl capturePipelineImpl = this.this$0;
                long j = CapturePipelineKt.CHECK_3A_TIMEOUT_IN_NS;
                this.label = 4;
            }
            return Unit.INSTANCE;
        }
        Camera2Logger camera2Logger7 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Unlocking 3A for capture");
        }
        CameraGraph graph = this.this$0.useCaseGraphContext.getGraph();
        this.label = 2;
        obj = graph.acquireSession(this);
        if (obj != coroutine_suspended) {
            autoCloseable = (AutoCloseable) obj;
            session = (CameraGraph.Session) autoCloseable;
            if (this.$captureMode$inlined == 0) {
            }
            this.L$0 = autoCloseable;
            this.label = 3;
            if (session.unlock3APostCapture(z, this) != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }
}
