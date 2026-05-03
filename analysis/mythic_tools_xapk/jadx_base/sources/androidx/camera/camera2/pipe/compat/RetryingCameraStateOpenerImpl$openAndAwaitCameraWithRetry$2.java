package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/camera/camera2/pipe/compat/AwaitOpenCameraResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2", f = "RetryingCameraStateOpener.kt", i = {1}, l = {497, TypedValues.PositionType.TYPE_PERCENT_WIDTH}, m = "invokeSuspend", n = {"androidCameraState"}, s = {"L$0"}, v = 1)
final class RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AwaitOpenCameraResult>, Object> {
    final /* synthetic */ Camera2DeviceCloser $camera2DeviceCloser;
    final /* synthetic */ String $cameraId;
    Object L$0;
    int label;
    final /* synthetic */ RetryingCameraStateOpenerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2(RetryingCameraStateOpenerImpl retryingCameraStateOpenerImpl, String str, Camera2DeviceCloser camera2DeviceCloser, Continuation<? super RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2> continuation) {
        super(2, continuation);
        this.this$0 = retryingCameraStateOpenerImpl;
        this.$cameraId = str;
        this.$camera2DeviceCloser = camera2DeviceCloser;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2(this.this$0, this.$cameraId, this.$camera2DeviceCloser, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AwaitOpenCameraResult> continuation) {
        return ((RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object objM847openCameraWithRetryaeCOTgg$default;
        Object objFirst;
        AndroidCameraState androidCameraState;
        CameraState cameraState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            objM847openCameraWithRetryaeCOTgg$default = RetryingCameraStateOpener.m847openCameraWithRetryaeCOTgg$default(this.this$0, this.$cameraId, this.$camera2DeviceCloser, null, this, 4, null);
            if (objM847openCameraWithRetryaeCOTgg$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            androidCameraState = (AndroidCameraState) this.L$0;
            ResultKt.throwOnFailure(obj);
            objFirst = obj;
            cameraState = (CameraState) objFirst;
            if (cameraState instanceof CameraStateOpen) {
                Log log = Log.INSTANCE;
                String str = this.$cameraId;
                if (log.getERROR_LOGGABLE()) {
                    android.util.Log.e(Log.TAG, "Failed to open " + ((Object) CameraId.m385toStringimpl(str)) + '!');
                }
                return new AwaitOpenCameraResult(null, null);
            }
            Log log2 = Log.INSTANCE;
            String str2 = this.$cameraId;
            if (log2.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, ((Object) CameraId.m385toStringimpl(str2)) + " opened successfully.");
            }
            return new AwaitOpenCameraResult(((CameraStateOpen) cameraState).getCameraDevice(), androidCameraState);
        }
        ResultKt.throwOnFailure(obj);
        objM847openCameraWithRetryaeCOTgg$default = obj;
        AndroidCameraState cameraState2 = ((OpenCameraResult) objM847openCameraWithRetryaeCOTgg$default).getCameraState();
        if (cameraState2 == null) {
            Log log3 = Log.INSTANCE;
            String str3 = this.$cameraId;
            if (log3.getERROR_LOGGABLE()) {
                android.util.Log.e(Log.TAG, "Failed to open " + ((Object) CameraId.m385toStringimpl(str3)) + '!');
            }
            return new AwaitOpenCameraResult(null, null);
        }
        this.L$0 = cameraState2;
        this.label = 2;
        objFirst = FlowKt.first(cameraState2.getState(), new RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2$cameraState$1(null), this);
        if (objFirst != coroutine_suspended) {
            androidCameraState = cameraState2;
            cameraState = (CameraState) objFirst;
            if (cameraState instanceof CameraStateOpen) {
            }
        }
        return coroutine_suspended;
    }
}
