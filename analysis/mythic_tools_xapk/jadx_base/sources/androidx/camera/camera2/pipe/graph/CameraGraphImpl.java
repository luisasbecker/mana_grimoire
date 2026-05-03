package androidx.camera.camera2.pipe.graph;

import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.os.Trace;
import android.view.Surface;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.AwbMode;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.FrameNumber;
import androidx.camera.camera2.pipe.GraphState;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.compat.AudioRestrictionController;
import androidx.camera.camera2.pipe.config.CameraGraphScope;
import androidx.camera.camera2.pipe.config.ForCameraGraph;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Token;
import androidx.camera.camera2.pipe.internal.CameraGraphParametersImpl;
import androidx.camera.camera2.pipe.internal.CameraGraphRequestListenersImpl;
import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: CameraGraphImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u008b\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0004\b\"\u0010#J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020DH\u0016J\u000e\u0010F\u001a\u00020GH\u0096@¢\u0006\u0002\u0010HJ\n\u0010I\u001a\u0004\u0018\u00010GH\u0016JC\u0010J\u001a\u0002HK\"\u0004\b\u0000\u0010K2-\u0010L\u001a)\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020G\u0012\n\u0012\b\u0012\u0004\u0012\u0002HK0N\u0012\u0006\u0012\u0004\u0018\u00010O0M¢\u0006\u0002\bPH\u0096@¢\u0006\u0002\u0010QJP\u0010R\u001a\b\u0012\u0004\u0012\u0002HK0S\"\u0004\b\u0000\u0010K2\u0006\u0010T\u001a\u00020\u001f2-\u0010L\u001a)\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020G\u0012\n\u0012\b\u0012\u0004\u0012\u0002HK0N\u0012\u0006\u0012\u0004\u0018\u00010O0M¢\u0006\u0002\bPH\u0016¢\u0006\u0002\u0010UJ!\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016¢\u0006\u0004\b[\u0010\\J\u0017\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020_H\u0016¢\u0006\u0004\b`\u0010aJa\u0010b\u001a\b\u0012\u0004\u0012\u00020c0S2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010i2\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010k2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010k2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010kH\u0016¢\u0006\u0002\boJa\u0010p\u001a\b\u0012\u0004\u0012\u00020c0S2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010i2\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010k2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010k2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010kH\u0016¢\u0006\u0002\bqJ\u000e\u0010r\u001a\b\u0012\u0004\u0012\u00020c0SH\u0016J\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020c0S2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016¢\u0006\u0002\btJÓ\u0001\u0010u\u001a\b\u0012\u0004\u0012\u00020c0S2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010i2\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010k2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010k2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010k2\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010w2\b\u0010y\u001a\u0004\u0018\u00010w2\b\u0010z\u001a\u0004\u0018\u00010e2\u0014\u0010{\u001a\u0010\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020>\u0018\u00010|2\u0014\u0010~\u001a\u0010\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020>\u0018\u00010|2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0003\b\u0084\u0001J`\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020c0S2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010>2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010>2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010>2\u0015\u0010\u0089\u0001\u001a\u0010\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020>\u0018\u00010|2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\b\u0010\u008a\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0003\u0010\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020DH\u0016J\n\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0016J\u0014\u0010\u008f\u0001\u001a\u00030\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002JL\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u0002HK0S\"\u0004\b\u0000\u0010K2/\u0010\u0094\u0001\u001a*\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HK0S0N\u0012\u0006\u0012\u0004\u0018\u00010O0\u0095\u0001¢\u0006\u0002\bPH\u0002¢\u0006\u0003\u0010\u0096\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\b\u0012\u0004\u0012\u000202018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u000207068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020;068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u00109R$\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u00020>@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006\u0097\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/graph/CameraGraphImpl;", "Landroidx/camera/camera2/pipe/CameraGraph;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "metadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "graphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "streamGraph", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "surfaceGraph", "Landroidx/camera/camera2/pipe/graph/SurfaceGraph;", "cameraController", "Landroidx/camera/camera2/pipe/CameraController;", "frameDistributor", "Landroidx/camera/camera2/pipe/internal/FrameDistributor;", "frameCaptureQueue", "Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;", "audioRestrictionController", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;", "id", "Landroidx/camera/camera2/pipe/CameraGraphId;", "parameters", "Landroidx/camera/camera2/pipe/internal/CameraGraphParametersImpl;", "listeners", "Landroidx/camera/camera2/pipe/internal/CameraGraphRequestListenersImpl;", "sessionLock", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "graphScope", "Lkotlinx/coroutines/CoroutineScope;", "controller3A", "Landroidx/camera/camera2/pipe/graph/Controller3A;", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph$Config;Landroidx/camera/camera2/pipe/CameraMetadata;Landroidx/camera/camera2/pipe/graph/GraphProcessor;Landroidx/camera/camera2/pipe/graph/GraphListener;Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;Landroidx/camera/camera2/pipe/graph/SurfaceGraph;Landroidx/camera/camera2/pipe/CameraController;Landroidx/camera/camera2/pipe/internal/FrameDistributor;Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;Landroidx/camera/camera2/pipe/CameraGraphId;Landroidx/camera/camera2/pipe/internal/CameraGraphParametersImpl;Landroidx/camera/camera2/pipe/internal/CameraGraphRequestListenersImpl;Landroidx/camera/camera2/pipe/internal/GraphSessionLock;Lkotlinx/coroutines/CoroutineScope;Landroidx/camera/camera2/pipe/graph/Controller3A;)V", "getId", "()Landroidx/camera/camera2/pipe/CameraGraphId;", "getParameters", "()Landroidx/camera/camera2/pipe/internal/CameraGraphParametersImpl;", "getListeners", "()Landroidx/camera/camera2/pipe/internal/CameraGraphRequestListenersImpl;", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "streams", "Landroidx/camera/camera2/pipe/StreamGraph;", "getStreams", "()Landroidx/camera/camera2/pipe/StreamGraph;", "graphState", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/camera/camera2/pipe/GraphState;", "getGraphState", "()Lkotlinx/coroutines/flow/StateFlow;", "latestFrameNumber", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/camera/camera2/pipe/FrameNumber;", "getLatestFrameNumber", "()Lkotlinx/coroutines/flow/Flow;", "latestFrameInfo", "Landroidx/camera/camera2/pipe/FrameInfo;", "getLatestFrameInfo", "value", "", "isForeground", "()Z", "setForeground", "(Z)V", "start", "", "stop", "acquireSession", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSessionOrNull", "useSession", ExifInterface.GPS_DIRECTION_TRUE, NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useSessionIn", "Lkotlinx/coroutines/Deferred;", "scope", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/Deferred;", "setSurface", "stream", "Landroidx/camera/camera2/pipe/StreamId;", "surface", "Landroid/view/Surface;", "setSurface-NYG5g8E", "(ILandroid/view/Surface;)V", "updateAudioRestrictionMode", "mode", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "updateAudioRestrictionMode-LwUUkyU", "(I)V", "update3A", "Landroidx/camera/camera2/pipe/Result3A;", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "aeRegions", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "update3A-ydBZfZg", "submit3A", "submit3A-ydBZfZg", "setTorchOn", "setTorchOff", "setTorchOff-NqN7i0k", "lock3A", "aeLockBehavior", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "convergedCondition", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "lockedCondition", "frameLimit", "", "convergedTimeLimitNs", "", "lockedTimeLimitNs", "lock3A-vIrNa9k", "unlock3A", "ae", "af", "awb", "unlockedCondition", "timeLimitNs", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;IJ)Lkotlinx/coroutines/Deferred;", "close", InAppPurchaseConstants.METHOD_TO_STRING, "", "createSessionFromToken", "Landroidx/camera/camera2/pipe/graph/CameraGraphSessionImpl;", "token", "Landroidx/camera/camera2/pipe/core/Token;", "withSessionLockAsync", "block", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraGraphImpl implements CameraGraph {
    private final AudioRestrictionController audioRestrictionController;
    private final CameraController cameraController;
    private final AtomicBoolean closed;
    private final Controller3A controller3A;
    private final FrameCaptureQueue frameCaptureQueue;
    private final FrameDistributor frameDistributor;
    private final GraphListener graphListener;
    private final GraphProcessor graphProcessor;
    private final CoroutineScope graphScope;
    private final CameraGraphId id;
    private boolean isForeground;
    private final CameraGraphRequestListenersImpl listeners;
    private final CameraGraphParametersImpl parameters;
    private final GraphSessionLock sessionLock;
    private final StreamGraphImpl streamGraph;
    private final SurfaceGraph surfaceGraph;

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.CameraGraphImpl$acquireSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: CameraGraphImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl", f = "CameraGraphImpl.kt", i = {}, l = {175}, m = "acquireSession", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraGraphImpl.this.acquireSession(this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.CameraGraphImpl$setTorchOn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraGraphImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$setTorchOn$1", f = "CameraGraphImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Result3A>>, Object> {
        int label;

        C02621(Continuation<? super C02621> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraGraphImpl.this.new C02621(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends Result3A>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Deferred<Result3A>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Deferred<Result3A>> continuation) {
            return ((C02621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return CameraGraphImpl.this.controller3A.setTorchOn();
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.CameraGraphImpl$unlock3A$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraGraphImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$unlock3A$1", f = "CameraGraphImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Result3A>>, Object> {
        final /* synthetic */ Boolean $ae;
        final /* synthetic */ Boolean $af;
        final /* synthetic */ Boolean $awb;
        final /* synthetic */ int $frameLimit;
        final /* synthetic */ long $timeLimitNs;
        final /* synthetic */ Function1<FrameMetadata, Boolean> $unlockedCondition;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02631(Boolean bool, Boolean bool2, Boolean bool3, Function1<? super FrameMetadata, Boolean> function1, int i, long j, Continuation<? super C02631> continuation) {
            super(2, continuation);
            this.$ae = bool;
            this.$af = bool2;
            this.$awb = bool3;
            this.$unlockedCondition = function1;
            this.$frameLimit = i;
            this.$timeLimitNs = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraGraphImpl.this.new C02631(this.$ae, this.$af, this.$awb, this.$unlockedCondition, this.$frameLimit, this.$timeLimitNs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends Result3A>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Deferred<Result3A>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Deferred<Result3A>> continuation) {
            return ((C02631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return CameraGraphImpl.this.controller3A.unlock3A(this.$ae, this.$af, this.$awb, this.$unlockedCondition, this.$frameLimit, Boxing.boxLong(this.$timeLimitNs));
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.CameraGraphImpl$useSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraGraphImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl", f = "CameraGraphImpl.kt", i = {0}, l = {188, 191}, m = "useSession", n = {NativeProtocol.WEB_DIALOG_ACTION}, s = {"L$0"}, v = 1)
    static final class C02641<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02641(Continuation<? super C02641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraGraphImpl.this.useSession(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.CameraGraphImpl$useSessionIn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraGraphImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "token", "Landroidx/camera/camera2/pipe/core/Token;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$useSessionIn$1", f = "CameraGraphImpl.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02651<T> extends SuspendLambda implements Function2<Token, Continuation<? super T>, Object> {
        final /* synthetic */ Function3<CoroutineScope, CameraGraph.Session, Continuation<? super T>, Object> $action;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02651(Function3<? super CoroutineScope, ? super CameraGraph.Session, ? super Continuation<? super T>, ? extends Object> function3, Continuation<? super C02651> continuation) {
            super(2, continuation);
            this.$action = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02651 c02651 = CameraGraphImpl.this.new C02651(this.$action, continuation);
            c02651.L$0 = obj;
            return c02651;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Token token, Continuation<? super T> continuation) {
            return ((C02651) create(token, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            Throwable th;
            AutoCloseable autoCloseable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                autoCloseable = (AutoCloseable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    AutoCloseableKt.closeFinally(autoCloseable, null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        AutoCloseableKt.closeFinally(autoCloseable, th);
                        throw th3;
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            CameraGraphSessionImpl cameraGraphSessionImplCreateSessionFromToken = CameraGraphImpl.this.createSessionFromToken((Token) this.L$0);
            try {
                CameraGraphImpl$useSessionIn$1$1$1 cameraGraphImpl$useSessionIn$1$1$1 = new CameraGraphImpl$useSessionIn$1$1$1(this.$action, cameraGraphSessionImplCreateSessionFromToken, null);
                this.L$0 = cameraGraphSessionImplCreateSessionFromToken;
                this.label = 1;
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(cameraGraphImpl$useSessionIn$1$1$1, this);
                if (objCoroutineScope == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objCoroutineScope;
                autoCloseable = cameraGraphSessionImplCreateSessionFromToken;
                AutoCloseableKt.closeFinally(autoCloseable, null);
                return obj;
            } catch (Throwable th4) {
                th = th4;
                autoCloseable = cameraGraphSessionImplCreateSessionFromToken;
                throw th;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.CameraGraphImpl$withSessionLockAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraGraphImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", ExifInterface.GPS_DIRECTION_TRUE, "it", "Landroidx/camera/camera2/pipe/core/Token;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$withSessionLockAsync$1", f = "CameraGraphImpl.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02661<T> extends SuspendLambda implements Function2<Token, Continuation<? super Deferred<? extends T>>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Deferred<? extends T>>, Object> $block;
        int label;

        /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.CameraGraphImpl$withSessionLockAsync$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CameraGraphImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$withSessionLockAsync$1$1", f = "CameraGraphImpl.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C00071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends T>>, Object> {
            final /* synthetic */ Function2<CoroutineScope, Continuation<? super Deferred<? extends T>>, Object> $block;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00071(Function2<? super CoroutineScope, ? super Continuation<? super Deferred<? extends T>>, ? extends Object> function2, Continuation<? super C00071> continuation) {
                super(2, continuation);
                this.$block = function2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00071 c00071 = new C00071(this.$block, continuation);
                c00071.L$0 = obj;
                return c00071;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends T>> continuation) {
                return ((C00071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Function2<CoroutineScope, Continuation<? super Deferred<? extends T>>, Object> function2 = this.$block;
                this.label = 1;
                Object objInvoke = function2.invoke(coroutineScope, this);
                return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02661(Function2<? super CoroutineScope, ? super Continuation<? super Deferred<? extends T>>, ? extends Object> function2, Continuation<? super C02661> continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02661(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Token token, Continuation<? super Deferred<? extends T>> continuation) {
            return ((C02661) create(token, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00071(this.$block, null), this);
            return objCoroutineScope == coroutine_suspended ? coroutine_suspended : objCoroutineScope;
        }
    }

    @Inject
    public CameraGraphImpl(CameraGraph.Config graphConfig, CameraMetadata metadata, GraphProcessor graphProcessor, GraphListener graphListener, StreamGraphImpl streamGraph, SurfaceGraph surfaceGraph, CameraController cameraController, FrameDistributor frameDistributor, FrameCaptureQueue frameCaptureQueue, AudioRestrictionController audioRestrictionController, CameraGraphId id, CameraGraphParametersImpl parameters, CameraGraphRequestListenersImpl listeners, GraphSessionLock sessionLock, @ForCameraGraph CoroutineScope graphScope, Controller3A controller3A) {
        CameraGraph.Config config;
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(graphProcessor, "graphProcessor");
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        Intrinsics.checkNotNullParameter(surfaceGraph, "surfaceGraph");
        Intrinsics.checkNotNullParameter(cameraController, "cameraController");
        Intrinsics.checkNotNullParameter(frameDistributor, "frameDistributor");
        Intrinsics.checkNotNullParameter(frameCaptureQueue, "frameCaptureQueue");
        Intrinsics.checkNotNullParameter(audioRestrictionController, "audioRestrictionController");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        Intrinsics.checkNotNullParameter(sessionLock, "sessionLock");
        Intrinsics.checkNotNullParameter(graphScope, "graphScope");
        Intrinsics.checkNotNullParameter(controller3A, "controller3A");
        this.graphProcessor = graphProcessor;
        this.graphListener = graphListener;
        this.streamGraph = streamGraph;
        this.surfaceGraph = surfaceGraph;
        this.cameraController = cameraController;
        this.frameDistributor = frameDistributor;
        this.frameCaptureQueue = frameCaptureQueue;
        this.audioRestrictionController = audioRestrictionController;
        this.id = id;
        this.parameters = parameters;
        this.listeners = listeners;
        this.sessionLock = sessionLock;
        this.graphScope = graphScope;
        this.controller3A = controller3A;
        this.closed = AtomicFU.atomic(false);
        if (Log.INSTANCE.getINFO_LOGGABLE()) {
            config = graphConfig;
            android.util.Log.i(Log.TAG, Debug.INSTANCE.formatCameraGraphProperties(metadata, config, this));
        } else {
            config = graphConfig;
        }
        if (CameraGraph.OperatingMode.m363equalsimpl0(config.m342getSessionMode2uNL3no(), CameraGraph.OperatingMode.INSTANCE.m369getHIGH_SPEED2uNL3no())) {
            if (streamGraph.getOutputs().isEmpty()) {
                throw new IllegalArgumentException("Cannot create a HIGH_SPEED CameraGraph without outputs.".toString());
            }
            if (streamGraph.getOutputs().size() > 2) {
                throw new IllegalArgumentException(("Cannot create a HIGH_SPEED CameraGraph with more than two outputs. Configured outputs are " + streamGraph.getOutputs()).toString());
            }
            List<OutputStream> outputs = streamGraph.getOutputs();
            if (!(outputs instanceof Collection) || !outputs.isEmpty()) {
                Iterator<T> it = outputs.iterator();
                while (it.hasNext()) {
                    if (!((OutputStream) it.next()).isValidForHighSpeedOperatingMode()) {
                        throw new IllegalArgumentException(("HIGH_SPEED CameraGraph must only contain Preview and/or Video streams. Configured outputs are " + this.streamGraph.getOutputs()).toString());
                    }
                }
            }
        }
        if (config.getInput() != null) {
            if (config.getInput().isEmpty()) {
                throw new IllegalArgumentException("At least one InputConfiguration is required for reprocessing".toString());
            }
            if (Build.VERSION.SDK_INT < 31 && config.getInput().size() > 1) {
                throw new IllegalArgumentException("Multi resolution reprocessing not supported under Android S".toString());
            }
        }
        if (!this.streamGraph.getImageSourceMap$camera_camera2_pipe().isEmpty()) {
            this.surfaceGraph.maybeUpdateSurfaces$camera_camera2_pipe();
        }
        this.isForeground = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraGraphSessionImpl createSessionFromToken(Token token) {
        return new CameraGraphSessionImpl(token, this.graphProcessor, this.controller3A, this.frameCaptureQueue, getParameters(), getListeners());
    }

    private final <T> Deferred<T> withSessionLockAsync(Function2<? super CoroutineScope, ? super Continuation<? super Deferred<? extends T>>, ? extends Object> block) {
        return this.sessionLock.withTokenInAsync$camera_camera2_pipe(this.graphScope, new C02661(block, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object acquireSession(Continuation<? super CameraGraph.Session> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAcquireToken$camera_camera2_pipe = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAcquireToken$camera_camera2_pipe);
            GraphSessionLock graphSessionLock = this.sessionLock;
            anonymousClass1.label = 1;
            objAcquireToken$camera_camera2_pipe = graphSessionLock.acquireToken$camera_camera2_pipe(anonymousClass1);
            if (objAcquireToken$camera_camera2_pipe == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAcquireToken$camera_camera2_pipe);
        }
        return createSessionFromToken((Token) objAcquireToken$camera_camera2_pipe);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public CameraGraph.Session acquireSessionOrNull() {
        Token tokenTryAcquireToken$camera_camera2_pipe = this.sessionLock.tryAcquireToken$camera_camera2_pipe();
        if (tokenTryAcquireToken$camera_camera2_pipe == null) {
            return null;
        }
        return createSessionFromToken(tokenTryAcquireToken$camera_camera2_pipe);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closed.compareAndSet(false, true)) {
            Debug debug = Debug.INSTANCE;
            Trace.beginSection(this + "#close");
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "Closing " + this);
            }
            this.graphProcessor.close();
            this.cameraController.close();
            this.frameDistributor.close();
            this.frameCaptureQueue.close();
            this.surfaceGraph.close();
            this.streamGraph.close();
            this.audioRestrictionController.removeCameraGraph(this);
            CoroutineScopeKt.cancel$default(this.graphScope, null, 1, null);
            Debug debug2 = Debug.INSTANCE;
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public StateFlow<GraphState> getGraphState() {
        return this.graphProcessor.getGraphState();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public CameraGraphId getId() {
        return this.id;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public Flow<FrameInfo> getLatestFrameInfo() {
        return FlowKt.callbackFlow(new CameraGraphImpl$latestFrameInfo$1(this, null));
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public Flow<FrameNumber> getLatestFrameNumber() {
        return FlowKt.callbackFlow(new CameraGraphImpl$latestFrameNumber$1(this, null));
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public CameraGraphRequestListenersImpl getListeners() {
        return this.listeners;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public CameraGraphParametersImpl getParameters() {
        return this.parameters;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public StreamGraph getStreams() {
        return this.streamGraph;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /* JADX INFO: renamed from: isForeground, reason: from getter */
    public boolean getIsForeground() {
        return this.isForeground;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /* JADX INFO: renamed from: lock3A-vIrNa9k */
    public Deferred<Result3A> mo376lock3AvIrNa9k(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions, Lock3ABehavior aeLockBehavior, Lock3ABehavior afLockBehavior, Lock3ABehavior awbLockBehavior, AeMode afTriggerStartAeMode, Function1<? super FrameMetadata, Boolean> convergedCondition, Function1<? super FrameMetadata, Boolean> lockedCondition, int frameLimit, long convergedTimeLimitNs, long lockedTimeLimitNs) {
        return withSessionLockAsync(new CameraGraphImpl$lock3A$1(this, aeRegions, afRegions, awbRegions, aeLockBehavior, afLockBehavior, awbLockBehavior, afTriggerStartAeMode, convergedCondition, lockedCondition, frameLimit, convergedTimeLimitNs, lockedTimeLimitNs, null));
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public void setForeground(boolean z) {
        this.isForeground = z;
        this.cameraController.setForeground(z);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /* JADX INFO: renamed from: setSurface-NYG5g8E */
    public void mo377setSurfaceNYG5g8E(int stream, Surface surface) {
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(((Object) StreamId.m749toStringimpl(stream)) + "#setSurface");
        if (surface != null && !surface.isValid() && Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, this + "#setSurface: " + surface + " is invalid");
        }
        this.surfaceGraph.m951setNYG5g8E(stream, surface);
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: setTorchOff-NqN7i0k */
    public Deferred<Result3A> mo261setTorchOffNqN7i0k(AeMode aeMode) {
        return withSessionLockAsync(new CameraGraphImpl$setTorchOff$1(this, aeMode, null));
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    public Deferred<Result3A> setTorchOn() {
        return withSessionLockAsync(new C02621(null));
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public void start() {
        if (this.closed.getValue()) {
            throw new IllegalStateException(("Cannot start " + this + " after calling close()").toString());
        }
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(this + "#start");
        if (Log.INSTANCE.getINFO_LOGGABLE()) {
            android.util.Log.i(Log.TAG, "Starting " + this);
        }
        this.graphListener.onGraphStarting();
        this.cameraController.start();
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public void stop() {
        if (this.closed.getValue()) {
            throw new IllegalStateException(("Cannot stop " + this + " after calling close()").toString());
        }
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(this + "#stop");
        if (Log.INSTANCE.getINFO_LOGGABLE()) {
            android.util.Log.i(Log.TAG, "Stopping " + this);
        }
        this.graphListener.onGraphStopping();
        this.cameraController.stop();
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: submit3A-ydBZfZg */
    public Deferred<Result3A> mo262submit3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        return withSessionLockAsync(new CameraGraphImpl$submit3A$1(this, aeMode, afMode, awbMode, aeRegions, afRegions, awbRegions, null));
    }

    public String toString() {
        return getId().getName();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public Deferred<Result3A> unlock3A(Boolean ae, Boolean af, Boolean awb, Function1<? super FrameMetadata, Boolean> unlockedCondition, int frameLimit, long timeLimitNs) {
        return withSessionLockAsync(new C02631(ae, af, awb, unlockedCondition, frameLimit, timeLimitNs, null));
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: update3A-ydBZfZg */
    public Deferred<Result3A> mo263update3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        return withSessionLockAsync(new CameraGraphImpl$update3A$1(this, aeMode, afMode, awbMode, aeRegions, afRegions, awbRegions, null));
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /* JADX INFO: renamed from: updateAudioRestrictionMode-LwUUkyU */
    public void mo378updateAudioRestrictionModeLwUUkyU(int mode) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.audioRestrictionController.mo773updateCameraGraphAudioRestrictionModeTyYSX5E(this, mode);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
    
        if (r8 == r1) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.camera.camera2.pipe.graph.CameraGraphImpl] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object useSession(Function3<? super CoroutineScope, ? super CameraGraph.Session, ? super Continuation<? super T>, ? extends Object> function3, Continuation<? super T> continuation) throws Exception {
        C02641 c02641;
        if (continuation instanceof C02641) {
            c02641 = (C02641) continuation;
            if ((c02641.label & Integer.MIN_VALUE) != 0) {
                c02641.label -= Integer.MIN_VALUE;
            } else {
                c02641 = new C02641(continuation);
            }
        }
        Object objAcquireSession = c02641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02641.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAcquireSession);
                c02641.L$0 = function3;
                c02641.label = 1;
                objAcquireSession = acquireSession(c02641);
                if (objAcquireSession != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AutoCloseable autoCloseable = (AutoCloseable) c02641.L$0;
                ResultKt.throwOnFailure(objAcquireSession);
                this = autoCloseable;
                AutoCloseableKt.closeFinally(this, null);
                return objAcquireSession;
            }
            function3 = (Function3) c02641.L$0;
            ResultKt.throwOnFailure(objAcquireSession);
            AutoCloseable autoCloseable2 = (AutoCloseable) objAcquireSession;
            CameraGraphImpl$useSession$2$1 cameraGraphImpl$useSession$2$1 = new CameraGraphImpl$useSession$2$1(function3, (CameraGraph.Session) autoCloseable2, null);
            c02641.L$0 = autoCloseable2;
            c02641.label = 2;
            objAcquireSession = CoroutineScopeKt.coroutineScope(cameraGraphImpl$useSession$2$1, c02641);
            this = autoCloseable2;
        } finally {
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public <T> Deferred<T> useSessionIn(CoroutineScope scope, Function3<? super CoroutineScope, ? super CameraGraph.Session, ? super Continuation<? super T>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(action, "action");
        return this.sessionLock.withTokenIn$camera_camera2_pipe(scope, new C02651(action, null));
    }
}
