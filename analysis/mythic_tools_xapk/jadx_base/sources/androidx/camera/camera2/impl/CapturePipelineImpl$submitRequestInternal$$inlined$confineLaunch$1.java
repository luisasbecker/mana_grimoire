package androidx.camera.camera2.impl;

import androidx.camera.camera2.compat.workaround.StillCaptureFlowKt;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Logger;
import androidx.media3.muxer.WebmConstants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UseCaseThreads.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/impl/UseCaseThreads$confineLaunch$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1", f = "CapturePipeline.kt", i = {0}, l = {210, 246, WebmConstants.MkvEbmlElement.CUE_TRACK}, m = "invokeSuspend", n = {"requiresStopRepeating"}, s = {"L$0"}, v = 1)
public final class CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $deferredList$inlined;
    final /* synthetic */ List $requests$inlined;
    Object L$0;
    int label;
    final /* synthetic */ CapturePipelineImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1(Continuation continuation, CapturePipelineImpl capturePipelineImpl, List list, List list2) {
        super(2, continuation);
        this.this$0 = capturePipelineImpl;
        this.$deferredList$inlined = list;
        this.$requests$inlined = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1(continuation, this.this$0, this.$deferredList$inlined, this.$requests$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bc, code lost:
    
        if (r11.tryStartRepeating(r10) != r1) goto L50;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Exception {
        Ref.BooleanRef booleanRef;
        AutoCloseable autoCloseable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException unused) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isInfoEnabled(Log.TAG)) {
                android.util.Log.i(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#submitRequestInternal: CameraGraph.Session could not be acquired, requests may need re-submission");
            }
            Iterator it = this.$deferredList$inlined.iterator();
            while (it.hasNext()) {
                ((CompletableDeferred) it.next()).completeExceptionally(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", null));
            }
        }
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#submitRequestInternal: Acquiring session for submitting requests");
                }
                booleanRef = new Ref.BooleanRef();
                CameraGraph graph = this.this$0.useCaseGraphContext.getGraph();
                this.L$0 = booleanRef;
                this.label = 1;
                obj = graph.acquireSession(this);
                if (obj == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                booleanRef = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                UseCaseCameraState useCaseCameraState = this.this$0.getUseCaseCameraState();
                this.label = 3;
            }
            CameraGraph.Session session = (CameraGraph.Session) autoCloseable;
            booleanRef.element = StillCaptureFlowKt.shouldStopRepeatingBeforeCapture(this.$requests$inlined);
            if (booleanRef.element) {
                session.stopRepeating();
            }
            Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#submitRequestInternal: Submitting " + this.$requests$inlined);
            }
            session.submit(this.$requests$inlined);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(autoCloseable, null);
            if (booleanRef.element) {
                List list = this.$deferredList$inlined;
                this.L$0 = null;
                this.label = 2;
                if (AwaitKt.joinAll(list, this) != coroutine_suspended) {
                    UseCaseCameraState useCaseCameraState2 = this.this$0.getUseCaseCameraState();
                    this.label = 3;
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } finally {
        }
        autoCloseable = (AutoCloseable) obj;
    }
}
