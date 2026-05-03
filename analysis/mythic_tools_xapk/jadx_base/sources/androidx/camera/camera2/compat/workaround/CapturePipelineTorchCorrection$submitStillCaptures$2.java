package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.TorchControl;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: CapturePipelineTorchCorrection.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$2", f = "CapturePipelineTorchCorrection.kt", i = {}, l = {86, 88, 89}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CapturePipelineTorchCorrection$submitStillCaptures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Deferred<Void>> $deferredResults;
    int label;
    final /* synthetic */ CapturePipelineTorchCorrection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CapturePipelineTorchCorrection$submitStillCaptures$2(List<? extends Deferred<Void>> list, CapturePipelineTorchCorrection capturePipelineTorchCorrection, Continuation<? super CapturePipelineTorchCorrection$submitStillCaptures$2> continuation) {
        super(2, continuation);
        this.$deferredResults = list;
        this.this$0 = capturePipelineTorchCorrection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CapturePipelineTorchCorrection$submitStillCaptures$2(this.$deferredResults, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CapturePipelineTorchCorrection$submitStillCaptures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0089, code lost:
    
        if (androidx.camera.camera2.impl.TorchControl.m100setTorchAsyncOup_wC0$camera_camera2$default(r11.this$0.torchControl, androidx.camera.camera2.impl.TorchControl.TorchMode.INSTANCE.m114getUSED_AS_FLASHIRs_R8(), false, false, 6, null).join(r11) != r0) goto L24;
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
            if (AwaitKt.joinAll(this.$deferredResults, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Re-enable Torch to correct the Torch state, done");
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 3;
        }
        Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Re-enable Torch to correct the Torch state");
        }
        this.label = 2;
        if (TorchControl.m100setTorchAsyncOup_wC0$camera_camera2$default(this.this$0.torchControl, TorchControl.TorchMode.INSTANCE.m112getOFFIRs_R8(), false, false, 6, null).join(this) != coroutine_suspended) {
            this.label = 3;
        }
        return coroutine_suspended;
    }
}
