package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.GraphState;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Permissions;
import androidx.camera.camera2.pipe.core.PruningProcessingQueue;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.Token;
import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: Camera2DeviceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0003_`aB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJK\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020$0&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0004\b+\u0010,J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020'0.2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0004\b/\u00100J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020'0.2\u0006\u00102\u001a\u00020$H\u0016J\u001b\u00103\u001a\u00020'2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019H\u0001¢\u0006\u0002\b5J\f\u00106\u001a\u00020'*\u00020\u0014H\u0002J\u0016\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020'2\u0006\u00108\u001a\u00020;H\u0082@¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020'2\u0006\u00108\u001a\u00020>H\u0082@¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\u00020'2\u0006\u00108\u001a\u00020AH\u0082@¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020EH\u0082@¢\u0006\u0002\u0010FJ \u0010G\u001a\u00020H2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020;H\u0082@¢\u0006\u0004\bJ\u0010KJB\u0010L\u001a\u00020M2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020$0&2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0004\bN\u0010OJ\u001c\u0010P\u001a\u00020'2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001e0RH\u0082@¢\u0006\u0002\u0010SJ\u001c\u0010T\u001a\u00020'2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001a0 H\u0082@¢\u0006\u0002\u0010VJ<\u0010W\u001a\u0004\u0018\u00010X\"\u0004\b\u0000\u0010Y*\b\u0012\u0004\u0012\u0002HY0 2\u0006\u0010Z\u001a\u00020X2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u0002HY\u0012\u0004\u0012\u00020$0&H\u0082\b¢\u0006\u0002\u0010\\J,\u0010]\u001a\b\u0012\u0004\u0012\u0002HY0 \"\u0004\b\u0000\u0010Y*\b\u0012\u0004\u0012\u0002HY0\u00192\f\u0010^\u001a\b\u0012\u0004\u0012\u00020X0RH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager;", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceManager;", NativeProtocol.RESULT_ARGS_PERMISSIONS, "Landroidx/camera/camera2/pipe/core/Permissions;", "retryingCameraStateOpener", "Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpener;", "camera2DeviceCloser", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;", "camera2ErrorProcessor", "Landroidx/camera/camera2/pipe/compat/Camera2ErrorProcessor;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "<init>", "(Landroidx/camera/camera2/pipe/core/Permissions;Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpener;Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;Landroidx/camera/camera2/pipe/compat/Camera2ErrorProcessor;Landroidx/camera/camera2/pipe/core/Threads;)V", "getThreads", "()Landroidx/camera/camera2/pipe/core/Threads;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "queue", "Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;", "Landroidx/camera/camera2/pipe/compat/CameraRequest;", "activeCameras", "", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "pendingRequestOpens", "", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$PendingRequestOpen;", "open", "Landroidx/camera/camera2/pipe/compat/VirtualCamera;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "sharedCameraIds", "", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "isPrewarm", "", "isForegroundObserver", "Lkotlin/Function1;", "", "open-zDSwpeU", "(Ljava/lang/String;Ljava/util/List;Landroidx/camera/camera2/pipe/graph/GraphListener;ZLkotlin/jvm/functions/Function1;)Landroidx/camera/camera2/pipe/compat/VirtualCamera;", "prewarm", "prewarm-EfqyGwQ", "(Ljava/lang/String;)V", "close", "Lkotlinx/coroutines/Deferred;", "close-EfqyGwQ", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "closeAll", "forceCancelOpen", "prune", "requests", "prune$camera_camera2_pipe", "onRemoved", "process", "request", "(Landroidx/camera/camera2/pipe/compat/CameraRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRequestOpen", "Landroidx/camera/camera2/pipe/compat/RequestOpen;", "(Landroidx/camera/camera2/pipe/compat/RequestOpen;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRequestClose", "Landroidx/camera/camera2/pipe/compat/RequestClose;", "(Landroidx/camera/camera2/pipe/compat/RequestClose;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRequestCloseById", "Landroidx/camera/camera2/pipe/compat/RequestCloseById;", "(Landroidx/camera/camera2/pipe/compat/RequestCloseById;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRequestCloseAll", "requestCloseAll", "Landroidx/camera/camera2/pipe/compat/RequestCloseAll;", "(Landroidx/camera/camera2/pipe/compat/RequestCloseAll;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveActiveCamera", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult;", "requestOpen", "retrieveActiveCamera-RzXb1QE", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/RequestOpen;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openCameraWithRetry", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult;", "openCameraWithRetry-zDSwpeU", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectPendingRequestOpens", "cameraIds", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectPendingRequestOpens", "pendingRequestOpensToDisconnect", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstFromIndexOrNull", "", ExifInterface.GPS_DIRECTION_TRUE, FirebaseAnalytics.Param.INDEX, "predicate", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "removeIndices", "indices", "PendingRequestOpen", "RetrieveActiveCameraResult", "OpenVirtualCameraResult", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PruningCamera2DeviceManager implements Camera2DeviceManager {
    private final Set<ActiveCamera> activeCameras;
    private final Camera2DeviceCloser camera2DeviceCloser;
    private final Camera2ErrorProcessor camera2ErrorProcessor;
    private final List<PendingRequestOpen> pendingRequestOpens;
    private final Permissions permissions;
    private final PruningProcessingQueue<CameraRequest> queue;
    private final RetryingCameraStateOpener retryingCameraStateOpener;
    private final CoroutineScope scope;
    private final Threads threads;

    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult;", "", "Success", "Error", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult$Error;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult$Success;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private interface OpenVirtualCameraResult {

        /* JADX INFO: compiled from: Camera2DeviceManager.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b\tJ\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\b\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult$Error;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult;", "lastCameraError", "Landroidx/camera/camera2/pipe/CameraError;", "<init>", "(Landroidx/camera/camera2/pipe/CameraError;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLastCameraError-mVEW8x0", "()Landroidx/camera/camera2/pipe/CameraError;", "component1", "component1-mVEW8x0", "copy", "copy-TPqeGZw", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Error implements OpenVirtualCameraResult {
            private final CameraError lastCameraError;

            private Error(CameraError cameraError) {
                this.lastCameraError = cameraError;
            }

            public /* synthetic */ Error(CameraError cameraError, DefaultConstructorMarker defaultConstructorMarker) {
                this(cameraError);
            }

            /* JADX INFO: renamed from: copy-TPqeGZw$default, reason: not valid java name */
            public static /* synthetic */ Error m838copyTPqeGZw$default(Error error, CameraError cameraError, int i, Object obj) {
                if ((i & 1) != 0) {
                    cameraError = error.lastCameraError;
                }
                return error.m840copyTPqeGZw(cameraError);
            }

            /* JADX INFO: renamed from: component1-mVEW8x0, reason: not valid java name and from getter */
            public final CameraError getLastCameraError() {
                return this.lastCameraError;
            }

            /* JADX INFO: renamed from: copy-TPqeGZw, reason: not valid java name */
            public final Error m840copyTPqeGZw(CameraError lastCameraError) {
                return new Error(lastCameraError, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.lastCameraError, ((Error) other).lastCameraError);
            }

            /* JADX INFO: renamed from: getLastCameraError-mVEW8x0, reason: not valid java name */
            public final CameraError m841getLastCameraErrormVEW8x0() {
                return this.lastCameraError;
            }

            public int hashCode() {
                CameraError cameraError = this.lastCameraError;
                if (cameraError == null) {
                    return 0;
                }
                return CameraError.m308hashCodeimpl(cameraError.m311unboximpl());
            }

            public String toString() {
                return "Error(lastCameraError=" + this.lastCameraError + ')';
            }
        }

        /* JADX INFO: compiled from: Camera2DeviceManager.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult$Success;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$OpenVirtualCameraResult;", "activeCamera", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "<init>", "(Landroidx/camera/camera2/pipe/compat/ActiveCamera;)V", "getActiveCamera", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Success implements OpenVirtualCameraResult {
            private final ActiveCamera activeCamera;

            public Success(ActiveCamera activeCamera) {
                Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
                this.activeCamera = activeCamera;
            }

            public static /* synthetic */ Success copy$default(Success success, ActiveCamera activeCamera, int i, Object obj) {
                if ((i & 1) != 0) {
                    activeCamera = success.activeCamera;
                }
                return success.copy(activeCamera);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }

            public final Success copy(ActiveCamera activeCamera) {
                Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
                return new Success(activeCamera);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && Intrinsics.areEqual(this.activeCamera, ((Success) other).activeCamera);
            }

            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }

            public int hashCode() {
                return this.activeCamera.hashCode();
            }

            public String toString() {
                return "Success(activeCamera=" + this.activeCamera + ')';
            }
        }
    }

    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$PendingRequestOpen;", "", "request", "Landroidx/camera/camera2/pipe/compat/RequestOpen;", "activeCamera", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "token", "Landroidx/camera/camera2/pipe/core/Token;", "<init>", "(Landroidx/camera/camera2/pipe/compat/RequestOpen;Landroidx/camera/camera2/pipe/compat/ActiveCamera;Landroidx/camera/camera2/pipe/core/Token;)V", "getRequest", "()Landroidx/camera/camera2/pipe/compat/RequestOpen;", "getActiveCamera", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "getToken", "()Landroidx/camera/camera2/pipe/core/Token;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class PendingRequestOpen {
        private final ActiveCamera activeCamera;
        private final RequestOpen request;
        private final Token token;

        public PendingRequestOpen(RequestOpen request, ActiveCamera activeCamera, Token token) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
            Intrinsics.checkNotNullParameter(token, "token");
            this.request = request;
            this.activeCamera = activeCamera;
            this.token = token;
        }

        public final ActiveCamera getActiveCamera() {
            return this.activeCamera;
        }

        public final RequestOpen getRequest() {
            return this.request;
        }

        public final Token getToken() {
            return this.token;
        }
    }

    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult;", "", "Success", "Error", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult$Error;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult$Success;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private interface RetrieveActiveCameraResult {

        /* JADX INFO: compiled from: Camera2DeviceManager.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b\tJ\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\b\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult$Error;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult;", "lastCameraError", "Landroidx/camera/camera2/pipe/CameraError;", "<init>", "(Landroidx/camera/camera2/pipe/CameraError;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLastCameraError-mVEW8x0", "()Landroidx/camera/camera2/pipe/CameraError;", "component1", "component1-mVEW8x0", "copy", "copy-TPqeGZw", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Error implements RetrieveActiveCameraResult {
            private final CameraError lastCameraError;

            private Error(CameraError cameraError) {
                this.lastCameraError = cameraError;
            }

            public /* synthetic */ Error(CameraError cameraError, DefaultConstructorMarker defaultConstructorMarker) {
                this(cameraError);
            }

            /* JADX INFO: renamed from: copy-TPqeGZw$default, reason: not valid java name */
            public static /* synthetic */ Error m842copyTPqeGZw$default(Error error, CameraError cameraError, int i, Object obj) {
                if ((i & 1) != 0) {
                    cameraError = error.lastCameraError;
                }
                return error.m844copyTPqeGZw(cameraError);
            }

            /* JADX INFO: renamed from: component1-mVEW8x0, reason: not valid java name and from getter */
            public final CameraError getLastCameraError() {
                return this.lastCameraError;
            }

            /* JADX INFO: renamed from: copy-TPqeGZw, reason: not valid java name */
            public final Error m844copyTPqeGZw(CameraError lastCameraError) {
                return new Error(lastCameraError, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.lastCameraError, ((Error) other).lastCameraError);
            }

            /* JADX INFO: renamed from: getLastCameraError-mVEW8x0, reason: not valid java name */
            public final CameraError m845getLastCameraErrormVEW8x0() {
                return this.lastCameraError;
            }

            public int hashCode() {
                CameraError cameraError = this.lastCameraError;
                if (cameraError == null) {
                    return 0;
                }
                return CameraError.m308hashCodeimpl(cameraError.m311unboximpl());
            }

            public String toString() {
                return "Error(lastCameraError=" + this.lastCameraError + ')';
            }
        }

        /* JADX INFO: compiled from: Camera2DeviceManager.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult$Success;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$RetrieveActiveCameraResult;", "activeCamera", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "token", "Landroidx/camera/camera2/pipe/core/Token;", "<init>", "(Landroidx/camera/camera2/pipe/compat/ActiveCamera;Landroidx/camera/camera2/pipe/core/Token;)V", "getActiveCamera", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "getToken", "()Landroidx/camera/camera2/pipe/core/Token;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Success implements RetrieveActiveCameraResult {
            private final ActiveCamera activeCamera;
            private final Token token;

            public Success(ActiveCamera activeCamera, Token token) {
                Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
                Intrinsics.checkNotNullParameter(token, "token");
                this.activeCamera = activeCamera;
                this.token = token;
            }

            public static /* synthetic */ Success copy$default(Success success, ActiveCamera activeCamera, Token token, int i, Object obj) {
                if ((i & 1) != 0) {
                    activeCamera = success.activeCamera;
                }
                if ((i & 2) != 0) {
                    token = success.token;
                }
                return success.copy(activeCamera, token);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Token getToken() {
                return this.token;
            }

            public final Success copy(ActiveCamera activeCamera, Token token) {
                Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
                Intrinsics.checkNotNullParameter(token, "token");
                return new Success(activeCamera, token);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.activeCamera, success.activeCamera) && Intrinsics.areEqual(this.token, success.token);
            }

            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }

            public final Token getToken() {
                return this.token;
            }

            public int hashCode() {
                return (this.activeCamera.hashCode() * 31) + this.token.hashCode();
            }

            public String toString() {
                return "Success(activeCamera=" + this.activeCamera + ", token=" + this.token + ')';
            }
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$connectPendingRequestOpens$1, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0}, l = {TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO}, m = "connectPendingRequestOpens", n = {"pendingRequestOpen"}, s = {"L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.connectPendingRequestOpens(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0}, l = {Videoio.CAP_PROP_XI_IS_COOLED, Videoio.CAP_PROP_XI_HOUS_TEMP}, m = "processRequestClose", n = {"request"}, s = {"L$0"}, v = 1)
    static final class C02501 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02501(Continuation<? super C02501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.processRequestClose(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0, 1}, l = {493, Videoio.CAP_PROP_XI_TRG_SELECTOR}, m = "processRequestCloseAll", n = {"requestCloseAll", "requestCloseAll"}, s = {"L$0", "L$0"}, v = 1)
    static final class C02511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02511(Continuation<? super C02511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.processRequestCloseAll(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0, 0, 1}, l = {Videoio.CAP_PROP_XI_SHARPNESS, Videoio.CAP_PROP_XI_CC_MATRIX_12}, m = "processRequestCloseById", n = {"request", "cameraId", "request"}, s = {"L$0", "L$1", "L$0"}, v = 1)
    static final class C02521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02521(Continuation<? super C02521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.processRequestCloseById(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestOpen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2DeviceManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", i = {0, 0, 0, 1, 1, 2, 2, 3}, l = {391, 398, 404, Videoio.CAP_PROP_XI_SHUTTER_TYPE, Videoio.CAP_PROP_XI_SENSOR_TAPS, Videoio.CAP_PROP_XI_BPC}, m = "processRequestOpen", n = {"request", "cameraIdToOpen", "camerasToClose", "request", "cameraIdToOpen", "request", "cameraIdToOpen", "request"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0"}, v = 1)
    static final class C02531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02531(Continuation<? super C02531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PruningCamera2DeviceManager.this.processRequestOpen(null, this);
        }
    }

    @Inject
    public PruningCamera2DeviceManager(Permissions permissions, RetryingCameraStateOpener retryingCameraStateOpener, Camera2DeviceCloser camera2DeviceCloser, Camera2ErrorProcessor camera2ErrorProcessor, Threads threads) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(retryingCameraStateOpener, "retryingCameraStateOpener");
        Intrinsics.checkNotNullParameter(camera2DeviceCloser, "camera2DeviceCloser");
        Intrinsics.checkNotNullParameter(camera2ErrorProcessor, "camera2ErrorProcessor");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.permissions = permissions;
        this.retryingCameraStateOpener = retryingCameraStateOpener;
        this.camera2DeviceCloser = camera2DeviceCloser;
        this.camera2ErrorProcessor = camera2ErrorProcessor;
        this.threads = threads;
        CoroutineScope cameraPipeScope = threads.getCameraPipeScope();
        this.scope = cameraPipeScope;
        this.queue = PruningProcessingQueue.INSTANCE.processIn(new PruningProcessingQueue(0, new PruningCamera2DeviceManager$queue$1(this), null, new PruningCamera2DeviceManager$queue$2(this, null), 5, null), cameraPipeScope);
        this.activeCameras = new LinkedHashSet();
        this.pendingRequestOpens = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fe, code lost:
    
        throw new java.lang.IllegalStateException("Check failed.");
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0115 -> B:46:0x0118). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connectPendingRequestOpens(Set<CameraId> set, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Iterator it;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<PendingRequestOpen> list = this.pendingRequestOpens;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (set.contains(CameraId.m379boximpl(((PendingRequestOpen) obj2).getRequest().getVirtualCamera().getCameraId()))) {
                    arrayList.add(obj2);
                }
            }
            it = arrayList.iterator();
            if (it.hasNext()) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PendingRequestOpen pendingRequestOpen = (PendingRequestOpen) anonymousClass1.L$1;
            it = (Iterator) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            this.pendingRequestOpens.remove(pendingRequestOpen);
            if (it.hasNext()) {
                pendingRequestOpen = (PendingRequestOpen) it.next();
                RequestOpen request = pendingRequestOpen.getRequest();
                List listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(CameraId.m379boximpl(request.getVirtualCamera().getCameraId())), (Iterable) request.getSharedCameraIds());
                if (!(listPlus instanceof Collection) || !listPlus.isEmpty()) {
                    Iterator it2 = listPlus.iterator();
                    loop0: while (it2.hasNext()) {
                        String strM386unboximpl = ((CameraId) it2.next()).m386unboximpl();
                        Set<ActiveCamera> set2 = this.activeCameras;
                        if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                            Iterator<T> it3 = set2.iterator();
                            while (it3.hasNext()) {
                                if (CameraId.m382equalsimpl0(((ActiveCamera) it3.next()).m751getCameraIdDz_R5H8(), strM386unboximpl)) {
                                    break;
                                }
                            }
                            break loop0;
                        }
                        break;
                    }
                }
                ActiveCamera activeCamera = pendingRequestOpen.getActiveCamera();
                VirtualCameraState virtualCamera = request.getVirtualCamera();
                Token token = pendingRequestOpen.getToken();
                anonymousClass1.L$0 = it;
                anonymousClass1.L$1 = pendingRequestOpen;
                anonymousClass1.label = 1;
                if (activeCamera.connectTo(virtualCamera, token, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.pendingRequestOpens.remove(pendingRequestOpen);
                if (it.hasNext()) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object disconnectPendingRequestOpens(List<PendingRequestOpen> list, Continuation<? super Unit> continuation) {
        for (PendingRequestOpen pendingRequestOpen : list) {
            pendingRequestOpen.getToken().release();
            this.pendingRequestOpens.remove(pendingRequestOpen);
        }
        return Unit.INSTANCE;
    }

    private final <T> Integer firstFromIndexOrNull(List<? extends T> list, int i, Function1<? super T, Boolean> function1) {
        int size = list.size();
        while (i < size) {
            if (function1.invoke(list.get(i)).booleanValue()) {
                return Integer.valueOf(i);
            }
            i++;
        }
        return null;
    }

    private final void onRemoved(CameraRequest cameraRequest) {
        if (cameraRequest instanceof RequestOpen) {
            VirtualCamera.m861disconnectTPqeGZw$default(((RequestOpen) cameraRequest).getVirtualCamera(), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: openCameraWithRetry-zDSwpeU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m836openCameraWithRetryzDSwpeU(String str, List<CameraId> list, Function1<? super Unit, Boolean> function1, CoroutineScope coroutineScope, Continuation<? super OpenVirtualCameraResult> continuation) {
        PruningCamera2DeviceManager$openCameraWithRetry$1 pruningCamera2DeviceManager$openCameraWithRetry$1;
        if (continuation instanceof PruningCamera2DeviceManager$openCameraWithRetry$1) {
            pruningCamera2DeviceManager$openCameraWithRetry$1 = (PruningCamera2DeviceManager$openCameraWithRetry$1) continuation;
            if ((pruningCamera2DeviceManager$openCameraWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                pruningCamera2DeviceManager$openCameraWithRetry$1.label -= Integer.MIN_VALUE;
            } else {
                pruningCamera2DeviceManager$openCameraWithRetry$1 = new PruningCamera2DeviceManager$openCameraWithRetry$1(this, continuation);
            }
        }
        Object objMo849openCameraWithRetryaeCOTgg = pruningCamera2DeviceManager$openCameraWithRetry$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = pruningCamera2DeviceManager$openCameraWithRetry$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo849openCameraWithRetryaeCOTgg);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Opening " + ((Object) CameraId.m385toStringimpl(str)) + " with retries...");
            }
            RetryingCameraStateOpener retryingCameraStateOpener = this.retryingCameraStateOpener;
            Camera2DeviceCloser camera2DeviceCloser = this.camera2DeviceCloser;
            pruningCamera2DeviceManager$openCameraWithRetry$1.L$0 = str;
            pruningCamera2DeviceManager$openCameraWithRetry$1.L$1 = list;
            pruningCamera2DeviceManager$openCameraWithRetry$1.L$2 = coroutineScope;
            pruningCamera2DeviceManager$openCameraWithRetry$1.label = 1;
            objMo849openCameraWithRetryaeCOTgg = retryingCameraStateOpener.mo849openCameraWithRetryaeCOTgg(str, camera2DeviceCloser, function1, pruningCamera2DeviceManager$openCameraWithRetry$1);
            if (objMo849openCameraWithRetryaeCOTgg == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) pruningCamera2DeviceManager$openCameraWithRetry$1.L$2;
            list = (List) pruningCamera2DeviceManager$openCameraWithRetry$1.L$1;
            str = (String) pruningCamera2DeviceManager$openCameraWithRetry$1.L$0;
            ResultKt.throwOnFailure(objMo849openCameraWithRetryaeCOTgg);
        }
        OpenCameraResult openCameraResult = (OpenCameraResult) objMo849openCameraWithRetryaeCOTgg;
        return openCameraResult.getCameraState() == null ? new OpenVirtualCameraResult.Error(openCameraResult.m832getErrorCodemVEW8x0(), null) : new OpenVirtualCameraResult.Success(new ActiveCamera(openCameraResult.getCameraState(), CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends CameraId>) list, CameraId.m379boximpl(str))), coroutineScope, new Function1() { // from class: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PruningCamera2DeviceManager.openCameraWithRetry_zDSwpeU$lambda$1(this.f$0, (ActiveCamera) obj);
            }
        }));
    }

    static final Unit openCameraWithRetry_zDSwpeU$lambda$1(PruningCamera2DeviceManager pruningCamera2DeviceManager, ActiveCamera activeCamera) {
        Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
        pruningCamera2DeviceManager.queue.tryEmit(new RequestClose(activeCamera));
        return Unit.INSTANCE;
    }

    static final boolean prewarm_EfqyGwQ$lambda$0(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<unused var>");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object process(CameraRequest cameraRequest, Continuation<? super Unit> continuation) {
        if (cameraRequest instanceof RequestOpen) {
            Object objProcessRequestOpen = processRequestOpen((RequestOpen) cameraRequest, continuation);
            return objProcessRequestOpen == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessRequestOpen : Unit.INSTANCE;
        }
        if (cameraRequest instanceof RequestClose) {
            Object objProcessRequestClose = processRequestClose((RequestClose) cameraRequest, continuation);
            return objProcessRequestClose == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessRequestClose : Unit.INSTANCE;
        }
        if (cameraRequest instanceof RequestCloseById) {
            Object objProcessRequestCloseById = processRequestCloseById((RequestCloseById) cameraRequest, continuation);
            return objProcessRequestCloseById == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessRequestCloseById : Unit.INSTANCE;
        }
        if (!(cameraRequest instanceof RequestCloseAll)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objProcessRequestCloseAll = processRequestCloseAll((RequestCloseAll) cameraRequest, continuation);
        return objProcessRequestCloseAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessRequestCloseAll : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d5, code lost:
    
        if (r8.awaitClosed(r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processRequestClose(RequestClose requestClose, Continuation<? super Unit> continuation) {
        C02501 c02501;
        if (continuation instanceof C02501) {
            c02501 = (C02501) continuation;
            if ((c02501.label & Integer.MIN_VALUE) != 0) {
                c02501.label -= Integer.MIN_VALUE;
            } else {
                c02501 = new C02501(continuation);
            }
        }
        Object obj = c02501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02501.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String strM751getCameraIdDz_R5H8 = requestClose.getActiveCamera().m751getCameraIdDz_R5H8();
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "PruningCamera2DeviceManager#processRequestClose(" + ((Object) CameraId.m385toStringimpl(strM751getCameraIdDz_R5H8)) + ')');
            }
            if (this.activeCameras.contains(requestClose.getActiveCamera())) {
                this.activeCameras.remove(requestClose.getActiveCamera());
            }
            List<PendingRequestOpen> list = this.pendingRequestOpens;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (Intrinsics.areEqual(((PendingRequestOpen) obj2).getActiveCamera(), requestClose.getActiveCamera())) {
                    arrayList.add(obj2);
                }
            }
            c02501.L$0 = requestClose;
            c02501.label = 1;
            if (disconnectPendingRequestOpens(arrayList, c02501) != coroutine_suspended) {
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
        requestClose = (RequestClose) c02501.L$0;
        ResultKt.throwOnFailure(obj);
        requestClose.getActiveCamera().close();
        ActiveCamera activeCamera = requestClose.getActiveCamera();
        c02501.L$0 = null;
        c02501.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        if (disconnectPendingRequestOpens(r7, r0) == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processRequestCloseAll(RequestCloseAll requestCloseAll, Continuation<? super Unit> continuation) {
        C02511 c02511;
        RequestCloseAll requestCloseAll2;
        Iterator<ActiveCamera> it;
        if (continuation instanceof C02511) {
            c02511 = (C02511) continuation;
            if ((c02511.label & Integer.MIN_VALUE) != 0) {
                c02511.label -= Integer.MIN_VALUE;
            } else {
                c02511 = new C02511(continuation);
            }
        }
        Object obj = c02511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02511.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "PruningCamera2DeviceManager#processRequestCloseAll()");
            }
            List<PendingRequestOpen> list = this.pendingRequestOpens;
            c02511.L$0 = requestCloseAll;
            c02511.label = 1;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) c02511.L$1;
                requestCloseAll2 = (RequestCloseAll) c02511.L$0;
                ResultKt.throwOnFailure(obj);
                while (it.hasNext()) {
                    ActiveCamera next = it.next();
                    c02511.L$0 = requestCloseAll2;
                    c02511.L$1 = it;
                    c02511.label = 2;
                    if (next.awaitClosed(c02511) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.activeCameras.clear();
                requestCloseAll2.getDeferred().complete(Unit.INSTANCE);
                return Unit.INSTANCE;
            }
            requestCloseAll = (RequestCloseAll) c02511.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Iterator<ActiveCamera> it2 = this.activeCameras.iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
        requestCloseAll2 = requestCloseAll;
        it = this.activeCameras.iterator();
        while (it.hasNext()) {
        }
        this.activeCameras.clear();
        requestCloseAll2.getDeferred().complete(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processRequestCloseById(RequestCloseById requestCloseById, Continuation<? super Unit> continuation) {
        C02521 c02521;
        RequestCloseById requestCloseById2;
        String str;
        Object next;
        RequestCloseById requestCloseById3;
        if (continuation instanceof C02521) {
            c02521 = (C02521) continuation;
            if ((c02521.label & Integer.MIN_VALUE) != 0) {
                c02521.label -= Integer.MIN_VALUE;
            } else {
                c02521 = new C02521(continuation);
            }
        }
        Object obj = c02521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02521.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String activeCameraId = requestCloseById.getActiveCameraId();
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "PruningCamera2DeviceManager#processRequestCloseById(" + ((Object) CameraId.m385toStringimpl(requestCloseById.getActiveCameraId())) + ')');
            }
            List<PendingRequestOpen> list = this.pendingRequestOpens;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (CameraId.m382equalsimpl0(((PendingRequestOpen) obj2).getRequest().getVirtualCamera().getCameraId(), activeCameraId)) {
                    arrayList.add(obj2);
                }
            }
            c02521.L$0 = requestCloseById;
            c02521.L$1 = activeCameraId;
            c02521.label = 1;
            if (disconnectPendingRequestOpens(arrayList, c02521) != coroutine_suspended) {
                requestCloseById2 = requestCloseById;
                str = activeCameraId;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            requestCloseById3 = (RequestCloseById) c02521.L$0;
            ResultKt.throwOnFailure(obj);
            requestCloseById2 = requestCloseById3;
            requestCloseById2.getDeferred().complete(Unit.INSTANCE);
            return Unit.INSTANCE;
        }
        str = (String) c02521.L$1;
        requestCloseById2 = (RequestCloseById) c02521.L$0;
        ResultKt.throwOnFailure(obj);
        Iterator<T> it = this.activeCameras.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (CameraId.m382equalsimpl0(((ActiveCamera) next).m751getCameraIdDz_R5H8(), str)) {
                break;
            }
        }
        ActiveCamera activeCamera = (ActiveCamera) next;
        if (activeCamera != null) {
            this.activeCameras.remove(activeCamera);
            activeCamera.close();
            c02521.L$0 = requestCloseById2;
            c02521.L$1 = null;
            c02521.label = 2;
            if (activeCamera.awaitClosed(c02521) != coroutine_suspended) {
                requestCloseById3 = requestCloseById2;
                requestCloseById2 = requestCloseById3;
            }
            return coroutine_suspended;
        }
        requestCloseById2.getDeferred().complete(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02de, code lost:
    
        if (connectPendingRequestOpens(r11, r0) != r1) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02ff, code lost:
    
        if (r12.connectTo(r10, r0, r2) == r1) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017d A[LOOP:3: B:50:0x0177->B:52:0x017d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processRequestOpen(RequestOpen requestOpen, Continuation<? super Unit> continuation) {
        C02531 c02531;
        String cameraId;
        ArrayList arrayList;
        RequestOpen requestOpen2;
        List list;
        Iterator it;
        Iterator it2;
        Object objM837retrieveActiveCameraRzXb1QE;
        C02531 c025312;
        Object obj;
        String str;
        RequestOpen requestOpen3;
        RetrieveActiveCameraResult retrieveActiveCameraResult;
        if (continuation instanceof C02531) {
            c02531 = (C02531) continuation;
            if ((c02531.label & Integer.MIN_VALUE) != 0) {
                c02531.label -= Integer.MIN_VALUE;
            } else {
                c02531 = new C02531(continuation);
            }
        }
        Object obj2 = c02531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02531.label) {
            case 0:
                ResultKt.throwOnFailure(obj2);
                cameraId = requestOpen.getVirtualCamera().getCameraId();
                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                    android.util.Log.i(Log.TAG, "PruningCamera2DeviceManager#processRequestOpen(" + ((Object) CameraId.m385toStringimpl(cameraId)) + ')');
                }
                if (requestOpen.getSharedCameraIds().isEmpty()) {
                    Set<ActiveCamera> set = this.activeCameras;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : set) {
                        if (!CameraId.m382equalsimpl0(((ActiveCamera) obj3).m751getCameraIdDz_R5H8(), cameraId)) {
                            arrayList2.add(obj3);
                        }
                    }
                    arrayList = arrayList2;
                } else {
                    Set set2 = CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends CameraId>) requestOpen.getSharedCameraIds(), CameraId.m379boximpl(requestOpen.getVirtualCamera().getCameraId())));
                    Set<ActiveCamera> set3 = this.activeCameras;
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj4 : set3) {
                        if (!Intrinsics.areEqual(((ActiveCamera) obj4).getAllCameraIds$camera_camera2_pipe(), set2)) {
                            arrayList3.add(obj4);
                        }
                    }
                    arrayList = arrayList3;
                }
                ArrayList arrayList4 = arrayList;
                if (arrayList4.isEmpty()) {
                    requestOpen2 = requestOpen;
                    String str2 = cameraId;
                    this.camera2ErrorProcessor.m791setActiveVirtualCamera0r8Bogc$camera_camera2_pipe(str2, requestOpen2.getVirtualCamera());
                    c02531.L$0 = requestOpen2;
                    c02531.L$1 = str2;
                    c02531.L$2 = null;
                    c02531.label = 3;
                    objM837retrieveActiveCameraRzXb1QE = m837retrieveActiveCameraRzXb1QE(str2, requestOpen2, c02531);
                    if (objM837retrieveActiveCameraRzXb1QE != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                this.activeCameras.removeAll(arrayList4);
                List<PendingRequestOpen> list2 = this.pendingRequestOpens;
                ArrayList arrayList5 = new ArrayList();
                for (Object obj5 : list2) {
                    if (arrayList.contains(((PendingRequestOpen) obj5).getActiveCamera())) {
                        arrayList5.add(obj5);
                    }
                }
                c02531.L$0 = requestOpen;
                c02531.L$1 = cameraId;
                c02531.L$2 = arrayList;
                c02531.label = 1;
                if (disconnectPendingRequestOpens(arrayList5, c02531) != coroutine_suspended) {
                    ArrayList arrayList6 = arrayList;
                    requestOpen2 = requestOpen;
                    list = arrayList6;
                    it = list.iterator();
                    while (it.hasNext()) {
                        ((ActiveCamera) it.next()).close();
                    }
                    it2 = list.iterator();
                    while (it2.hasNext()) {
                        ActiveCamera activeCamera = (ActiveCamera) it2.next();
                        c02531.L$0 = requestOpen2;
                        c02531.L$1 = cameraId;
                        c02531.L$2 = it2;
                        c02531.label = 2;
                        if (activeCamera.awaitClosed(c02531) == coroutine_suspended) {
                        }
                    }
                    String str22 = cameraId;
                    this.camera2ErrorProcessor.m791setActiveVirtualCamera0r8Bogc$camera_camera2_pipe(str22, requestOpen2.getVirtualCamera());
                    c02531.L$0 = requestOpen2;
                    c02531.L$1 = str22;
                    c02531.L$2 = null;
                    c02531.label = 3;
                    objM837retrieveActiveCameraRzXb1QE = m837retrieveActiveCameraRzXb1QE(str22, requestOpen2, c02531);
                    if (objM837retrieveActiveCameraRzXb1QE != coroutine_suspended) {
                        c025312 = c02531;
                        obj = objM837retrieveActiveCameraRzXb1QE;
                        str = str22;
                        requestOpen3 = requestOpen2;
                        retrieveActiveCameraResult = (RetrieveActiveCameraResult) obj;
                        if (!(retrieveActiveCameraResult instanceof RetrieveActiveCameraResult.Error)) {
                            RetrieveActiveCameraResult.Error error = (RetrieveActiveCameraResult.Error) retrieveActiveCameraResult;
                            if (error.m845getLastCameraErrormVEW8x0() != null) {
                                if (Log.INSTANCE.getERROR_LOGGABLE()) {
                                    android.util.Log.e(Log.TAG, "Failed to retrieve active camera for " + ((Object) CameraId.m385toStringimpl(str)) + ". Last camera error was " + ((Object) CameraError.m310toStringimpl(error.m845getLastCameraErrormVEW8x0().m311unboximpl())));
                                }
                            } else if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to retrieve active camera for " + ((Object) CameraId.m385toStringimpl(str)) + ". Camera might have been closed during opening.");
                            }
                            return Unit.INSTANCE;
                        }
                        if (!(retrieveActiveCameraResult instanceof RetrieveActiveCameraResult.Success)) {
                            throw new IllegalStateException("Check failed.");
                        }
                        RetrieveActiveCameraResult.Success success = (RetrieveActiveCameraResult.Success) retrieveActiveCameraResult;
                        ActiveCamera activeCamera2 = success.getActiveCamera();
                        Token token = success.getToken();
                        if (!requestOpen3.getSharedCameraIds().isEmpty()) {
                            List<CameraId> sharedCameraIds = requestOpen3.getSharedCameraIds();
                            if (!(sharedCameraIds instanceof Collection) || !sharedCameraIds.isEmpty()) {
                                Iterator<T> it3 = sharedCameraIds.iterator();
                                while (it3.hasNext()) {
                                    String strM386unboximpl = ((CameraId) it3.next()).m386unboximpl();
                                    List<PendingRequestOpen> list3 = this.pendingRequestOpens;
                                    if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                                        Iterator<T> it4 = list3.iterator();
                                        while (it4.hasNext()) {
                                            if (CameraId.m382equalsimpl0(((PendingRequestOpen) it4.next()).getActiveCamera().m751getCameraIdDz_R5H8(), strM386unboximpl)) {
                                            }
                                            break;
                                        }
                                    }
                                    this.pendingRequestOpens.add(new PendingRequestOpen(requestOpen3, activeCamera2, token));
                                    return Unit.INSTANCE;
                                }
                            }
                            if (requestOpen3.isPrewarm()) {
                                throw new IllegalStateException("Check failed.");
                            }
                            VirtualCameraState virtualCamera = requestOpen3.getVirtualCamera();
                            c025312.L$0 = requestOpen3;
                            c025312.L$1 = null;
                            c025312.label = 4;
                            if (activeCamera2.connectTo(virtualCamera, token, c025312) != coroutine_suspended) {
                                c02531 = c025312;
                                Set<CameraId> set4 = CollectionsKt.toSet(requestOpen3.getSharedCameraIds());
                                c02531.L$0 = null;
                                c02531.label = 5;
                            }
                        } else {
                            if (requestOpen3.isPrewarm()) {
                                token.release();
                                return Unit.INSTANCE;
                            }
                            VirtualCameraState virtualCamera2 = requestOpen3.getVirtualCamera();
                            c025312.L$0 = null;
                            c025312.L$1 = null;
                            c025312.label = 6;
                        }
                    }
                    break;
                }
                return coroutine_suspended;
            case 1:
                list = (List) c02531.L$2;
                cameraId = (String) c02531.L$1;
                requestOpen2 = (RequestOpen) c02531.L$0;
                ResultKt.throwOnFailure(obj2);
                it = list.iterator();
                while (it.hasNext()) {
                }
                it2 = list.iterator();
                while (it2.hasNext()) {
                }
                String str222 = cameraId;
                this.camera2ErrorProcessor.m791setActiveVirtualCamera0r8Bogc$camera_camera2_pipe(str222, requestOpen2.getVirtualCamera());
                c02531.L$0 = requestOpen2;
                c02531.L$1 = str222;
                c02531.L$2 = null;
                c02531.label = 3;
                objM837retrieveActiveCameraRzXb1QE = m837retrieveActiveCameraRzXb1QE(str222, requestOpen2, c02531);
                if (objM837retrieveActiveCameraRzXb1QE != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 2:
                it2 = (Iterator) c02531.L$2;
                cameraId = (String) c02531.L$1;
                requestOpen2 = (RequestOpen) c02531.L$0;
                ResultKt.throwOnFailure(obj2);
                while (it2.hasNext()) {
                }
                String str2222 = cameraId;
                this.camera2ErrorProcessor.m791setActiveVirtualCamera0r8Bogc$camera_camera2_pipe(str2222, requestOpen2.getVirtualCamera());
                c02531.L$0 = requestOpen2;
                c02531.L$1 = str2222;
                c02531.L$2 = null;
                c02531.label = 3;
                objM837retrieveActiveCameraRzXb1QE = m837retrieveActiveCameraRzXb1QE(str2222, requestOpen2, c02531);
                if (objM837retrieveActiveCameraRzXb1QE != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 3:
                String str3 = (String) c02531.L$1;
                RequestOpen requestOpen4 = (RequestOpen) c02531.L$0;
                ResultKt.throwOnFailure(obj2);
                str = str3;
                requestOpen3 = requestOpen4;
                c025312 = c02531;
                obj = obj2;
                retrieveActiveCameraResult = (RetrieveActiveCameraResult) obj;
                if (!(retrieveActiveCameraResult instanceof RetrieveActiveCameraResult.Error)) {
                }
                break;
            case 4:
                requestOpen3 = (RequestOpen) c02531.L$0;
                ResultKt.throwOnFailure(obj2);
                Set<CameraId> set42 = CollectionsKt.toSet(requestOpen3.getSharedCameraIds());
                c02531.L$0 = null;
                c02531.label = 5;
                break;
            case 5:
                ResultKt.throwOnFailure(obj2);
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prune$lambda$2$0(CompletableDeferred completableDeferred, Throwable th) {
        completableDeferred.complete(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    static final Unit prune$lambda$6(CameraRequest cameraRequest, Throwable th) {
        ((RequestCloseById) cameraRequest).getDeferred().complete(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    private final <T> List<T> removeIndices(List<T> list, Set<Integer> set) {
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.sorted(set).iterator();
        while (it.hasNext()) {
            arrayList.add(list.remove(((Number) it.next()).intValue() - arrayList.size()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
    
        r9 = r7.acquire();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
    
        if (r9 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        r0 = r7;
        r1 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0087, code lost:
    
        r7.close();
        r12.L$0 = r8;
        r12.L$1 = r15;
        r12.L$2 = r3;
        r12.L$3 = r7;
        r12.label = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0098, code lost:
    
        if (r7.awaitClosed(r12) != r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
    
        r7 = r15;
        r15 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a7, code lost:
    
        r9 = r15.getSharedCameraIds();
        r10 = r15.isForegroundObserver();
        r11 = r14.scope;
        r12.L$0 = r8;
        r12.L$1 = r15;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.label = 2;
        r0 = m836openCameraWithRetryzDSwpeU(r8, r9, r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c0, code lost:
    
        if (r0 != r2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c3, code lost:
    
        r1 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a5 A[EDGE_INSN: B:62:0x00a5->B:29:0x00a5 BREAK  A[LOOP:0: B:17:0x0068->B:65:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009b -> B:28:0x009e). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: retrieveActiveCamera-RzXb1QE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m837retrieveActiveCameraRzXb1QE(String str, RequestOpen requestOpen, Continuation<? super RetrieveActiveCameraResult> continuation) {
        PruningCamera2DeviceManager$retrieveActiveCamera$1 pruningCamera2DeviceManager$retrieveActiveCamera$1;
        String str2;
        RequestOpen requestOpen2;
        Iterator<ActiveCamera> it;
        PruningCamera2DeviceManager$retrieveActiveCamera$1 pruningCamera2DeviceManager$retrieveActiveCamera$12;
        ActiveCamera activeCamera;
        Token token;
        if (continuation instanceof PruningCamera2DeviceManager$retrieveActiveCamera$1) {
            pruningCamera2DeviceManager$retrieveActiveCamera$1 = (PruningCamera2DeviceManager$retrieveActiveCamera$1) continuation;
            if ((pruningCamera2DeviceManager$retrieveActiveCamera$1.label & Integer.MIN_VALUE) != 0) {
                pruningCamera2DeviceManager$retrieveActiveCamera$1.label -= Integer.MIN_VALUE;
            } else {
                pruningCamera2DeviceManager$retrieveActiveCamera$1 = new PruningCamera2DeviceManager$retrieveActiveCamera$1(this, continuation);
            }
        }
        Object objM836openCameraWithRetryzDSwpeU = pruningCamera2DeviceManager$retrieveActiveCamera$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = pruningCamera2DeviceManager$retrieveActiveCamera$1.label;
        CameraError cameraError = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (i == 0) {
            ResultKt.throwOnFailure(objM836openCameraWithRetryzDSwpeU);
            str2 = str;
            requestOpen2 = requestOpen;
            it = this.activeCameras.iterator();
            pruningCamera2DeviceManager$retrieveActiveCamera$12 = pruningCamera2DeviceManager$retrieveActiveCamera$1;
            activeCamera = null;
            token = null;
            while (true) {
                if (!it.hasNext()) {
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ActiveCamera activeCamera2 = (ActiveCamera) pruningCamera2DeviceManager$retrieveActiveCamera$1.L$3;
            it = (Iterator) pruningCamera2DeviceManager$retrieveActiveCamera$1.L$2;
            RequestOpen requestOpen3 = (RequestOpen) pruningCamera2DeviceManager$retrieveActiveCamera$1.L$1;
            str2 = (String) pruningCamera2DeviceManager$retrieveActiveCamera$1.L$0;
            ResultKt.throwOnFailure(objM836openCameraWithRetryzDSwpeU);
            pruningCamera2DeviceManager$retrieveActiveCamera$12 = pruningCamera2DeviceManager$retrieveActiveCamera$1;
            activeCamera = null;
            token = null;
            this.activeCameras.remove(activeCamera2);
            requestOpen2 = requestOpen3;
            while (true) {
                if (!it.hasNext()) {
                    ActiveCamera next = it.next();
                    if (CameraId.m382equalsimpl0(next.m751getCameraIdDz_R5H8(), str2)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            return coroutine_suspended;
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        requestOpen2 = (RequestOpen) pruningCamera2DeviceManager$retrieveActiveCamera$1.L$1;
        String str3 = (String) pruningCamera2DeviceManager$retrieveActiveCamera$1.L$0;
        ResultKt.throwOnFailure(objM836openCameraWithRetryzDSwpeU);
        OpenVirtualCameraResult openVirtualCameraResult = (OpenVirtualCameraResult) objM836openCameraWithRetryzDSwpeU;
        if (!(openVirtualCameraResult instanceof OpenVirtualCameraResult.Success)) {
            if (!(openVirtualCameraResult instanceof OpenVirtualCameraResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "PruningCameraDeviceManager: Failed to open " + ((Object) CameraId.m385toStringimpl(str3)));
            }
            OpenVirtualCameraResult.Error error = (OpenVirtualCameraResult.Error) openVirtualCameraResult;
            requestOpen2.getVirtualCamera().mo862disconnectTPqeGZw(error.m841getLastCameraErrormVEW8x0());
            return new RetrieveActiveCameraResult.Error(error.m841getLastCameraErrormVEW8x0(), objArr == true ? 1 : 0);
        }
        activeCamera = ((OpenVirtualCameraResult.Success) openVirtualCameraResult).getActiveCamera();
        Token tokenAcquire = activeCamera.acquire();
        if (tokenAcquire == null) {
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "PruningCameraDeviceManager: Failed to open " + ((Object) CameraId.m385toStringimpl(str3)) + ": Camera may have been closed (possibly due to an error) immediately after opening");
            }
            requestOpen2.getVirtualCamera().mo862disconnectTPqeGZw(null);
            return new RetrieveActiveCameraResult.Error(cameraError, objArr2 == true ? 1 : 0);
        }
        if (Log.INSTANCE.getINFO_LOGGABLE()) {
            android.util.Log.i(Log.TAG, "PruningCameraDeviceManager: " + ((Object) CameraId.m385toStringimpl(str3)) + " opened successfully");
        }
        this.activeCameras.add(activeCamera);
        token = tokenAcquire;
        if (token != null) {
            return new RetrieveActiveCameraResult.Success(activeCamera, token);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2DeviceManager
    /* JADX INFO: renamed from: close-EfqyGwQ */
    public Deferred<Unit> mo787closeEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        RequestCloseById requestCloseById = new RequestCloseById(cameraId, null);
        if (!this.queue.tryEmit(requestCloseById)) {
            if (Log.INSTANCE.getERROR_LOGGABLE()) {
                android.util.Log.e(Log.TAG, "Camera close by ID request failed for " + ((Object) CameraId.m385toStringimpl(cameraId)) + '!');
            }
            requestCloseById.getDeferred().complete(Unit.INSTANCE);
        }
        return requestCloseById.getDeferred();
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2DeviceManager
    public Deferred<Unit> closeAll(boolean forceCancelOpen) {
        if (forceCancelOpen) {
            this.retryingCameraStateOpener.cancelOpen();
        }
        RequestCloseAll requestCloseAll = new RequestCloseAll();
        if (!this.queue.tryEmit(requestCloseAll)) {
            if (Log.INSTANCE.getERROR_LOGGABLE()) {
                android.util.Log.e(Log.TAG, "Camera close all request failed!");
            }
            requestCloseAll.getDeferred().complete(Unit.INSTANCE);
        }
        return requestCloseAll.getDeferred();
    }

    public final Threads getThreads() {
        return this.threads;
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2DeviceManager
    /* JADX INFO: renamed from: open-zDSwpeU */
    public VirtualCamera mo788openzDSwpeU(String cameraId, List<CameraId> sharedCameraIds, GraphListener graphListener, boolean isPrewarm, Function1<? super Unit, Boolean> isForegroundObserver) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(sharedCameraIds, "sharedCameraIds");
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(isForegroundObserver, "isForegroundObserver");
        VirtualCameraState virtualCameraState = new VirtualCameraState(cameraId, graphListener, this.scope, null);
        if (this.queue.tryEmit(new RequestOpen(virtualCameraState, sharedCameraIds, graphListener, isPrewarm, isForegroundObserver))) {
            return virtualCameraState;
        }
        if (Log.INSTANCE.getERROR_LOGGABLE()) {
            android.util.Log.e(Log.TAG, "Camera open request failed for " + ((Object) CameraId.m385toStringimpl(cameraId)) + '!');
        }
        graphListener.onGraphError(new GraphState.GraphStateError(CameraError.INSTANCE.m320getERROR_CAMERA_OPENERv7Vf74A(), false, null));
        return null;
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2DeviceManager
    /* JADX INFO: renamed from: prewarm-EfqyGwQ */
    public void mo789prewarmEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        mo788openzDSwpeU(cameraId, CollectionsKt.emptyList(), NoOpGraphListener.INSTANCE, true, new Function1() { // from class: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(PruningCamera2DeviceManager.prewarm_EfqyGwQ$lambda$0((Unit) obj));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void prune$camera_camera2_pipe(List<CameraRequest> requests) {
        boolean z;
        int iNextIndex;
        Integer numValueOf;
        boolean zContains;
        Intrinsics.checkNotNullParameter(requests, "requests");
        List<CameraRequest> list = requests;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((CameraRequest) obj) instanceof RequestClose) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        requests.removeAll(arrayList2);
        Iterator it = CollectionsKt.reversed(arrayList2).iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            } else {
                requests.add(0, (CameraRequest) it.next());
            }
        }
        ListIterator<CameraRequest> listIterator = requests.listIterator(requests.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous() instanceof RequestCloseAll) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            } else {
                iNextIndex = -1;
                break;
            }
        }
        if (iNextIndex > 0) {
            CameraRequest cameraRequest = requests.get(iNextIndex);
            Intrinsics.checkNotNull(cameraRequest, "null cannot be cast to non-null type androidx.camera.camera2.pipe.compat.RequestCloseAll");
            RequestCloseAll requestCloseAll = (RequestCloseAll) cameraRequest;
            for (int i = 0; i < iNextIndex; i++) {
                CameraRequest cameraRequestRemove = requests.remove(0);
                final CompletableDeferred<Unit> deferred = cameraRequestRemove instanceof RequestCloseById ? ((RequestCloseById) cameraRequestRemove).getDeferred() : cameraRequestRemove instanceof RequestCloseAll ? ((RequestCloseAll) cameraRequestRemove).getDeferred() : null;
                if (deferred != null) {
                    requestCloseAll.getDeferred().invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PruningCamera2DeviceManager.prune$lambda$2$0(deferred, (Throwable) obj2);
                        }
                    });
                }
                onRemoved(cameraRequestRemove);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        for (final CameraRequest cameraRequest2 : list) {
            int i3 = i2 + 1;
            if (cameraRequest2 instanceof RequestOpen) {
                RequestOpen requestOpen = (RequestOpen) cameraRequest2;
                String cameraId = requestOpen.getVirtualCamera().getCameraId();
                Set set = CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends CameraId>) requestOpen.getSharedCameraIds(), CameraId.m379boximpl(cameraId)));
                int size = requests.size();
                int i4 = i3;
                while (i4 < size) {
                    CameraRequest cameraRequest3 = requests.get(i4);
                    if (cameraRequest3 instanceof RequestCloseById) {
                        zContains = set.contains(CameraId.m379boximpl(((RequestCloseById) cameraRequest3).getActiveCameraId()));
                    } else if (cameraRequest3 instanceof RequestOpen) {
                        boolean z2 = (requestOpen.isPrewarm() || !((RequestOpen) cameraRequest3).isPrewarm()) ? true : z;
                        RequestOpen requestOpen2 = (RequestOpen) cameraRequest3;
                        String cameraId2 = requestOpen2.getVirtualCamera().getCameraId();
                        Set set2 = CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends CameraId>) requestOpen2.getSharedCameraIds(), CameraId.m379boximpl(cameraId2)));
                        if (z2 && (CameraId.m382equalsimpl0(cameraId, cameraId2) || !Intrinsics.areEqual(set, set2))) {
                            zContains = true;
                        }
                    } else {
                        zContains = false;
                    }
                    if (zContains) {
                        numValueOf = Integer.valueOf(i4);
                        break;
                    } else {
                        i4++;
                        z = false;
                    }
                }
                numValueOf = null;
            } else if (cameraRequest2 instanceof RequestCloseById) {
                int size2 = requests.size();
                for (int i5 = i3; i5 < size2; i5++) {
                    CameraRequest cameraRequest4 = requests.get(i5);
                    if ((cameraRequest4 instanceof RequestCloseById) && CameraId.m382equalsimpl0(((RequestCloseById) cameraRequest4).getActiveCameraId(), ((RequestCloseById) cameraRequest2).getActiveCameraId())) {
                        numValueOf = Integer.valueOf(i5);
                        break;
                    }
                }
                numValueOf = null;
            } else {
                numValueOf = null;
            }
            if (numValueOf != null) {
                CameraRequest cameraRequest5 = requests.get(numValueOf.intValue());
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, cameraRequest2 + " is pruned by " + cameraRequest5);
                }
                linkedHashSet.add(Integer.valueOf(i2));
                if ((cameraRequest2 instanceof RequestCloseById) && (cameraRequest5 instanceof RequestCloseById)) {
                    ((RequestCloseById) cameraRequest5).getDeferred().invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PruningCamera2DeviceManager.prune$lambda$6(cameraRequest2, (Throwable) obj2);
                        }
                    });
                }
            }
            i2 = i3;
            z = false;
        }
        Iterator it2 = removeIndices(requests, linkedHashSet).iterator();
        while (it2.hasNext()) {
            onRemoved((CameraRequest) it2.next());
        }
    }
}
