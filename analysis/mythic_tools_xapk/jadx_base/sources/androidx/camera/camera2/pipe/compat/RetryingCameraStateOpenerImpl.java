package androidx.camera.camera2.pipe.compat;

import android.os.Build;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.compat.CameraAvailabilityMonitor;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.core.Timestamps;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 %2\u00020\u0001:\u0001%BK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpenerImpl;", "Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpener;", "cameraStateOpener", "Landroidx/camera/camera2/pipe/compat/CameraStateOpener;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "cameraAvailabilityMonitor", "Landroidx/camera/camera2/pipe/compat/CameraAvailabilityMonitor;", "timeSource", "Landroidx/camera/camera2/pipe/core/TimeSource;", "devicePolicyManager", "Landroidx/camera/camera2/pipe/compat/DevicePolicyManagerWrapper;", "audioRestrictionController", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;", "cameraInteropConfig", "Landroidx/camera/camera2/pipe/CameraPipe$CameraInteropConfig;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraStateOpener;Landroidx/camera/camera2/pipe/internal/CameraErrorListener;Landroidx/camera/camera2/pipe/compat/CameraAvailabilityMonitor;Landroidx/camera/camera2/pipe/core/TimeSource;Landroidx/camera/camera2/pipe/compat/DevicePolicyManagerWrapper;Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;Landroidx/camera/camera2/pipe/CameraPipe$CameraInteropConfig;Landroidx/camera/camera2/pipe/core/Threads;)V", "openCameraWithRetry", "Landroidx/camera/camera2/pipe/compat/OpenCameraResult;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "camera2DeviceCloser", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;", "isForegroundObserver", "Lkotlin/Function1;", "", "", "openCameraWithRetry-aeCOTgg", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openAndAwaitCameraWithRetry", "Landroidx/camera/camera2/pipe/compat/AwaitOpenCameraResult;", "openAndAwaitCameraWithRetry-0r8Bogc", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;)Landroidx/camera/camera2/pipe/compat/AwaitOpenCameraResult;", "cancelOpen", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RetryingCameraStateOpenerImpl implements RetryingCameraStateOpener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AudioRestrictionController audioRestrictionController;
    private final CameraAvailabilityMonitor cameraAvailabilityMonitor;
    private final CameraErrorListener cameraErrorListener;
    private final CameraPipe.CameraInteropConfig cameraInteropConfig;
    private final CameraStateOpener cameraStateOpener;
    private final DevicePolicyManagerWrapper devicePolicyManager;
    private final Threads threads;
    private final TimeSource timeSource;

    /* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpenerImpl$Companion;", "", "<init>", "()V", "shouldRetry", "", "errorCode", "Landroidx/camera/camera2/pipe/CameraError;", "attempts", "", "elapsedNs", "Landroidx/camera/camera2/pipe/core/DurationNs;", "camerasDisabledByDevicePolicy", "isForeground", "cameraOpenRetryMaxTimeoutNs", "shouldRetry-rbpwgO0$camera_camera2_pipe", "(IIJZZLandroidx/camera/camera2/pipe/core/DurationNs;)Z", "shouldActivateActiveResume", "shouldActivateActiveResume-8PWMtlg$camera_camera2_pipe", "(ZI)Z", "getRetryTimeoutNs", "activeResumeActivated", "getRetryTimeoutNs-om-7c1s$camera_camera2_pipe", "(ZLandroidx/camera/camera2/pipe/core/DurationNs;)J", "getRetryDelayMs", "", "getRetryDelayMs-t8DbYm4$camera_camera2_pipe", "(JZ)J", "min", "d1", "d2", "min-L1EDjxI", "(JLandroidx/camera/camera2/pipe/core/DurationNs;)J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getRetryTimeoutNs-om-7c1s$camera_camera2_pipe$default, reason: not valid java name */
        public static /* synthetic */ long m850getRetryTimeoutNsom7c1s$camera_camera2_pipe$default(Companion companion, boolean z, DurationNs durationNs, int i, Object obj) {
            if ((i & 2) != 0) {
                durationNs = null;
            }
            return companion.m854getRetryTimeoutNsom7c1s$camera_camera2_pipe(z, durationNs);
        }

        /* JADX INFO: renamed from: min-L1EDjxI, reason: not valid java name */
        private final long m851minL1EDjxI(long d1, DurationNs d2) {
            return (d2 == null || DurationNs.m869compareTozYRVrok(d1, d2.m878unboximpl()) == -1) ? d1 : d2.m878unboximpl();
        }

        /* JADX INFO: renamed from: shouldRetry-rbpwgO0$camera_camera2_pipe$default, reason: not valid java name */
        public static /* synthetic */ boolean m852shouldRetryrbpwgO0$camera_camera2_pipe$default(Companion companion, int i, int i2, long j, boolean z, boolean z2, DurationNs durationNs, int i3, Object obj) {
            if ((i3 & 16) != 0) {
                z2 = true;
            }
            return companion.m856shouldRetryrbpwgO0$camera_camera2_pipe(i, i2, j, z, z2, (i3 & 32) != 0 ? null : durationNs);
        }

        /* JADX INFO: renamed from: getRetryDelayMs-t8DbYm4$camera_camera2_pipe, reason: not valid java name */
        public final long m853getRetryDelayMst8DbYm4$camera_camera2_pipe(long elapsedNs, boolean activeResumeActivated) {
            if (activeResumeActivated && DurationNs.m869compareTozYRVrok(elapsedNs, RetryingCameraStateOpenerKt.activeResumeCameraRetryThresholds[0].m878unboximpl()) >= 0) {
                return DurationNs.m869compareTozYRVrok(elapsedNs, RetryingCameraStateOpenerKt.activeResumeCameraRetryThresholds[1].m878unboximpl()) < 0 ? 2000L : 4000L;
            }
            return 500L;
        }

        /* JADX INFO: renamed from: getRetryTimeoutNs-om-7c1s$camera_camera2_pipe, reason: not valid java name */
        public final long m854getRetryTimeoutNsom7c1s$camera_camera2_pipe(boolean activeResumeActivated, DurationNs cameraOpenRetryMaxTimeoutNs) {
            return !activeResumeActivated ? m851minL1EDjxI(RetryingCameraStateOpenerKt.defaultCameraRetryTimeoutNs, cameraOpenRetryMaxTimeoutNs) : m851minL1EDjxI(RetryingCameraStateOpenerKt.activeResumeCameraRetryTimeoutNs, cameraOpenRetryMaxTimeoutNs);
        }

        /* JADX INFO: renamed from: shouldActivateActiveResume-8PWMtlg$camera_camera2_pipe, reason: not valid java name */
        public final boolean m855shouldActivateActiveResume8PWMtlg$camera_camera2_pipe(boolean isForeground, int errorCode) {
            int i;
            if (!isForeground || 29 > (i = Build.VERSION.SDK_INT) || i >= 33) {
                return false;
            }
            return CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m318getERROR_CAMERA_IN_USEv7Vf74A()) || CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m319getERROR_CAMERA_LIMIT_EXCEEDEDv7Vf74A()) || CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m317getERROR_CAMERA_DISCONNECTEDv7Vf74A());
        }

        /* JADX INFO: renamed from: shouldRetry-rbpwgO0$camera_camera2_pipe, reason: not valid java name */
        public final boolean m856shouldRetryrbpwgO0$camera_camera2_pipe(int errorCode, int attempts, long elapsedNs, boolean camerasDisabledByDevicePolicy, boolean isForeground, DurationNs cameraOpenRetryMaxTimeoutNs) {
            boolean zM855shouldActivateActiveResume8PWMtlg$camera_camera2_pipe = m855shouldActivateActiveResume8PWMtlg$camera_camera2_pipe(isForeground, errorCode);
            if (zM855shouldActivateActiveResume8PWMtlg$camera_camera2_pipe && Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "shouldRetry: Active resume mode is activated");
            }
            if (DurationNs.m869compareTozYRVrok(elapsedNs, m854getRetryTimeoutNsom7c1s$camera_camera2_pipe(zM855shouldActivateActiveResume8PWMtlg$camera_camera2_pipe, cameraOpenRetryMaxTimeoutNs)) > 0) {
                return false;
            }
            if (CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m327getERROR_UNDETERMINEDv7Vf74A())) {
                return attempts <= 1;
            }
            if (CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m318getERROR_CAMERA_IN_USEv7Vf74A())) {
                return Build.VERSION.SDK_INT >= 29 || attempts <= 1;
            }
            if (CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m319getERROR_CAMERA_LIMIT_EXCEEDEDv7Vf74A())) {
                return true;
            }
            if (CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m316getERROR_CAMERA_DISABLEDv7Vf74A())) {
                return !camerasDisabledByDevicePolicy || attempts <= 1;
            }
            if (CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m315getERROR_CAMERA_DEVICEv7Vf74A()) || CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m322getERROR_CAMERA_SERVICEv7Vf74A()) || CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m317getERROR_CAMERA_DISCONNECTEDv7Vf74A()) || CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m325getERROR_ILLEGAL_ARGUMENT_EXCEPTIONv7Vf74A())) {
                return true;
            }
            if (CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m326getERROR_SECURITY_EXCEPTIONv7Vf74A())) {
                return attempts <= 1;
            }
            if (CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m323getERROR_DO_NOT_DISTURB_ENABLEDv7Vf74A())) {
                return false;
            }
            if (CameraError.m307equalsimpl0(errorCode, CameraError.INSTANCE.m328getERROR_UNKNOWN_EXCEPTIONv7Vf74A())) {
                return attempts <= 1;
            }
            if (Log.INSTANCE.getERROR_LOGGABLE()) {
                android.util.Log.e(Log.TAG, "Unexpected CameraError: " + RetryingCameraStateOpenerImpl.INSTANCE);
            }
            return false;
        }
    }

    @Inject
    public RetryingCameraStateOpenerImpl(CameraStateOpener cameraStateOpener, CameraErrorListener cameraErrorListener, CameraAvailabilityMonitor cameraAvailabilityMonitor, TimeSource timeSource, DevicePolicyManagerWrapper devicePolicyManager, AudioRestrictionController audioRestrictionController, CameraPipe.CameraInteropConfig cameraInteropConfig, Threads threads) {
        Intrinsics.checkNotNullParameter(cameraStateOpener, "cameraStateOpener");
        Intrinsics.checkNotNullParameter(cameraErrorListener, "cameraErrorListener");
        Intrinsics.checkNotNullParameter(cameraAvailabilityMonitor, "cameraAvailabilityMonitor");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(devicePolicyManager, "devicePolicyManager");
        Intrinsics.checkNotNullParameter(audioRestrictionController, "audioRestrictionController");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.cameraStateOpener = cameraStateOpener;
        this.cameraErrorListener = cameraErrorListener;
        this.cameraAvailabilityMonitor = cameraAvailabilityMonitor;
        this.timeSource = timeSource;
        this.devicePolicyManager = devicePolicyManager;
        this.audioRestrictionController = audioRestrictionController;
        this.cameraInteropConfig = cameraInteropConfig;
        this.threads = threads;
    }

    @Override // androidx.camera.camera2.pipe.compat.RetryingCameraStateOpener
    public void cancelOpen() {
        this.cameraStateOpener.cancelOpen$camera_camera2_pipe();
    }

    @Override // androidx.camera.camera2.pipe.compat.RetryingCameraStateOpener
    /* JADX INFO: renamed from: openAndAwaitCameraWithRetry-0r8Bogc */
    public AwaitOpenCameraResult mo848openAndAwaitCameraWithRetry0r8Bogc(String cameraId, Camera2DeviceCloser camera2DeviceCloser) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(camera2DeviceCloser, "camera2DeviceCloser");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + "#openAndAwaitCameraWithRetry(" + ((Object) CameraId.m385toStringimpl(cameraId)) + ')');
        }
        return (AwaitOpenCameraResult) BuildersKt.runBlocking(this.threads.getBlockingDispatcher(), new RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2(this, cameraId, camera2DeviceCloser, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0132 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0136 A[Catch: all -> 0x0089, TRY_ENTER, TryCatch #2 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x027e, B:70:0x0286, B:72:0x028e, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x024b, B:20:0x007e), top: B:84:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a7 A[Catch: all -> 0x0089, TryCatch #2 {all -> 0x0089, blocks: (B:14:0x004e, B:68:0x027e, B:70:0x0286, B:72:0x028e, B:35:0x011c, B:39:0x0136, B:41:0x013c, B:43:0x0144, B:46:0x014d, B:48:0x016f, B:50:0x0178, B:52:0x018a, B:56:0x0198, B:58:0x01a7, B:60:0x01af, B:64:0x024b, B:20:0x007e), top: B:84:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0279 -> B:16:0x0058). Please report as a decompilation issue!!! */
    @Override // androidx.camera.camera2.pipe.compat.RetryingCameraStateOpener
    /* JADX INFO: renamed from: openCameraWithRetry-aeCOTgg */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo849openCameraWithRetryaeCOTgg(String str, Camera2DeviceCloser camera2DeviceCloser, Function1<? super Unit, Boolean> function1, Continuation<? super OpenCameraResult> continuation) throws Exception {
        RetryingCameraStateOpenerImpl$openCameraWithRetry$1 retryingCameraStateOpenerImpl$openCameraWithRetry$1;
        Throwable th;
        ?? r5;
        long jMo880nowvQl9yQU;
        Camera2DeviceCloser camera2DeviceCloser2;
        String str2;
        Ref.IntRef intRef;
        Function1<? super Unit, Boolean> function12;
        AutoCloseable autoCloseable;
        CameraAvailabilityMonitor.Session session;
        long j;
        String str3;
        Throwable th2;
        Camera2DeviceCloser camera2DeviceCloser3;
        Function1<? super Unit, Boolean> function13;
        Ref.IntRef intRef2;
        long j2;
        String str4;
        Throwable th3;
        AutoCloseable autoCloseable2;
        CameraAvailabilityMonitor.Session session2;
        OpenCameraResult openCameraResult;
        CameraAvailabilityMonitor.Session session3;
        Object obj;
        Object objM824tryOpenCamera7pD7j80$camera_camera2_pipe;
        if (continuation instanceof RetryingCameraStateOpenerImpl$openCameraWithRetry$1) {
            retryingCameraStateOpenerImpl$openCameraWithRetry$1 = (RetryingCameraStateOpenerImpl$openCameraWithRetry$1) continuation;
            if ((retryingCameraStateOpenerImpl$openCameraWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                retryingCameraStateOpenerImpl$openCameraWithRetry$1.label -= Integer.MIN_VALUE;
            } else {
                retryingCameraStateOpenerImpl$openCameraWithRetry$1 = new RetryingCameraStateOpenerImpl$openCameraWithRetry$1(this, continuation);
            }
        }
        Object objAwaitAvailableCamera = retryingCameraStateOpenerImpl$openCameraWithRetry$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = retryingCameraStateOpenerImpl$openCameraWithRetry$1.label;
        int i2 = 2;
        int i3 = 1;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(objAwaitAvailableCamera);
                    Timestamps timestamps = Timestamps.INSTANCE;
                    jMo880nowvQl9yQU = this.timeSource.mo880nowvQl9yQU();
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    CameraAvailabilityMonitor cameraAvailabilityMonitor = this.cameraAvailabilityMonitor;
                    retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$0 = str;
                    camera2DeviceCloser2 = camera2DeviceCloser;
                    retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$1 = camera2DeviceCloser2;
                    retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$2 = function1;
                    retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$3 = intRef3;
                    retryingCameraStateOpenerImpl$openCameraWithRetry$1.J$0 = jMo880nowvQl9yQU;
                    retryingCameraStateOpenerImpl$openCameraWithRetry$1.label = 1;
                    Object objMo776startMonitoring0r8Bogc = cameraAvailabilityMonitor.mo776startMonitoring0r8Bogc(str, retryingCameraStateOpenerImpl$openCameraWithRetry$1);
                    if (objMo776startMonitoring0r8Bogc != coroutine_suspended) {
                        str2 = str;
                        intRef = intRef3;
                        objAwaitAvailableCamera = objMo776startMonitoring0r8Bogc;
                        function12 = function1;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    jMo880nowvQl9yQU = retryingCameraStateOpenerImpl$openCameraWithRetry$1.J$0;
                    intRef = (Ref.IntRef) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$3;
                    function12 = (Function1) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$2;
                    camera2DeviceCloser2 = (Camera2DeviceCloser) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$1;
                    str2 = (String) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$0;
                    ResultKt.throwOnFailure(objAwaitAvailableCamera);
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        long j3 = retryingCameraStateOpenerImpl$openCameraWithRetry$1.J$0;
                        CameraAvailabilityMonitor.Session session4 = (CameraAvailabilityMonitor.Session) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$5;
                        autoCloseable2 = (AutoCloseable) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$4;
                        intRef2 = (Ref.IntRef) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$3;
                        function13 = (Function1) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$2;
                        camera2DeviceCloser3 = (Camera2DeviceCloser) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$1;
                        str4 = (String) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$0;
                        ResultKt.throwOnFailure(objAwaitAvailableCamera);
                        long j4 = j3;
                        session = session4;
                        Object obj2 = coroutine_suspended;
                        char c = 3;
                        th3 = null;
                        str3 = str4;
                        camera2DeviceCloser2 = camera2DeviceCloser3;
                        if (!((Boolean) objAwaitAvailableCamera).booleanValue() && Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            android.util.Log.d(Log.TAG, "Timeout expired, retrying camera open for camera " + ((Object) CameraId.m385toStringimpl(str3)));
                        }
                        autoCloseable = autoCloseable2;
                        function12 = function13;
                        j = j4;
                        i2 = 2;
                        i3 = 1;
                        th2 = th3;
                        coroutine_suspended = obj2;
                        intRef = intRef2;
                        intRef.element += i3;
                        CameraStateOpener cameraStateOpener = this.cameraStateOpener;
                        int i4 = intRef.element;
                        AudioRestrictionController audioRestrictionController = this.audioRestrictionController;
                        retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$0 = str3;
                        retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$1 = camera2DeviceCloser2;
                        retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$2 = function12;
                        retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$3 = intRef;
                        retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$4 = autoCloseable;
                        retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$5 = session;
                        retryingCameraStateOpenerImpl$openCameraWithRetry$1.J$0 = j;
                        retryingCameraStateOpenerImpl$openCameraWithRetry$1.label = i2;
                        RetryingCameraStateOpenerImpl$openCameraWithRetry$1 retryingCameraStateOpenerImpl$openCameraWithRetry$12 = retryingCameraStateOpenerImpl$openCameraWithRetry$1;
                        CameraAvailabilityMonitor.Session session5 = session;
                        Camera2DeviceCloser camera2DeviceCloser4 = camera2DeviceCloser2;
                        objM824tryOpenCamera7pD7j80$camera_camera2_pipe = cameraStateOpener.m824tryOpenCamera7pD7j80$camera_camera2_pipe(str3, i4, j, camera2DeviceCloser4, audioRestrictionController, retryingCameraStateOpenerImpl$openCameraWithRetry$12);
                        if (objM824tryOpenCamera7pD7j80$camera_camera2_pipe != coroutine_suspended) {
                            intRef2 = intRef;
                            session2 = session5;
                            str4 = str3;
                            j2 = j;
                            camera2DeviceCloser3 = camera2DeviceCloser4;
                            retryingCameraStateOpenerImpl$openCameraWithRetry$1 = retryingCameraStateOpenerImpl$openCameraWithRetry$12;
                            function13 = function12;
                            autoCloseable2 = autoCloseable;
                            objAwaitAvailableCamera = objM824tryOpenCamera7pD7j80$camera_camera2_pipe;
                            th3 = th2;
                            openCameraResult = (OpenCameraResult) objAwaitAvailableCamera;
                            Timestamps timestamps2 = Timestamps.INSTANCE;
                            long jM870constructorimpl = DurationNs.m870constructorimpl(this.timeSource.mo880nowvQl9yQU() - j2);
                            if (openCameraResult.getCameraState() != null) {
                                return openCameraResult;
                            }
                            if (openCameraResult.m832getErrorCodemVEW8x0() == null) {
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Camera open failed without an error. The CameraGraph may have been stopped or closed. Abandoning the camera open attempt.");
                                }
                                return openCameraResult;
                            }
                            boolean zBooleanValue = function13.invoke(Unit.INSTANCE).booleanValue();
                            Companion companion = INSTANCE;
                            int iM311unboximpl = openCameraResult.m832getErrorCodemVEW8x0().m311unboximpl();
                            int i5 = intRef2.element;
                            boolean camerasDisabled = this.devicePolicyManager.getCamerasDisabled();
                            CameraPipe.CameraInteropConfig cameraInteropConfig = this.cameraInteropConfig;
                            boolean zM856shouldRetryrbpwgO0$camera_camera2_pipe = companion.m856shouldRetryrbpwgO0$camera_camera2_pipe(iM311unboximpl, i5, jM870constructorimpl, camerasDisabled, zBooleanValue, cameraInteropConfig != null ? cameraInteropConfig.m410getCameraOpenRetryMaxTimeoutNsQWez1Bs() : null);
                            long j5 = j2;
                            if (zM856shouldRetryrbpwgO0$camera_camera2_pipe) {
                                obj = coroutine_suspended;
                                session3 = session2;
                                if (intRef2.element > 1) {
                                }
                                if (zM856shouldRetryrbpwgO0$camera_camera2_pipe) {
                                    if (Log.INSTANCE.getERROR_LOGGABLE()) {
                                        StringBuilder sbAppend = new StringBuilder().append("Failed to open camera ").append((Object) CameraId.m385toStringimpl(str4)).append(" after ").append(intRef2.element).append(" attempts and ");
                                        Timestamps timestamps3 = Timestamps.INSTANCE;
                                        Timestamps timestamps4 = Timestamps.INSTANCE;
                                        String str5 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Boxing.boxDouble(DurationNs.m870constructorimpl(this.timeSource.mo880nowvQl9yQU() - j5) / 1000000.0d)}, 1));
                                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                        android.util.Log.e(Log.TAG, sbAppend.append(str5).append(". Last error was ").append((Object) CameraError.m310toStringimpl(openCameraResult.m832getErrorCodemVEW8x0().m311unboximpl())).append(FilenameUtils.EXTENSION_SEPARATOR).toString());
                                    }
                                    return openCameraResult;
                                }
                                long jM853getRetryDelayMst8DbYm4$camera_camera2_pipe = companion.m853getRetryDelayMst8DbYm4$camera_camera2_pipe(jM870constructorimpl, companion.m855shouldActivateActiveResume8PWMtlg$camera_camera2_pipe(zBooleanValue, openCameraResult.m832getErrorCodemVEW8x0().m311unboximpl()));
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$0 = str4;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$1 = camera2DeviceCloser3;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$2 = function13;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$3 = intRef2;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$4 = autoCloseable2;
                                CameraAvailabilityMonitor.Session session6 = session3;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$5 = session6;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.J$0 = j5;
                                c = 3;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.label = 3;
                                objAwaitAvailableCamera = session6.awaitAvailableCamera(jM853getRetryDelayMst8DbYm4$camera_camera2_pipe, retryingCameraStateOpenerImpl$openCameraWithRetry$1);
                                obj2 = obj;
                                if (objAwaitAvailableCamera == obj2) {
                                    return obj2;
                                }
                                j4 = j5;
                                session = session6;
                                str3 = str4;
                                camera2DeviceCloser2 = camera2DeviceCloser3;
                                if (!((Boolean) objAwaitAvailableCamera).booleanValue()) {
                                    android.util.Log.d(Log.TAG, "Timeout expired, retrying camera open for camera " + ((Object) CameraId.m385toStringimpl(str3)));
                                }
                                autoCloseable = autoCloseable2;
                                function12 = function13;
                                j = j4;
                                i2 = 2;
                                i3 = 1;
                                th2 = th3;
                                coroutine_suspended = obj2;
                                intRef = intRef2;
                                intRef.element += i3;
                                CameraStateOpener cameraStateOpener2 = this.cameraStateOpener;
                                int i42 = intRef.element;
                                AudioRestrictionController audioRestrictionController2 = this.audioRestrictionController;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$0 = str3;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$1 = camera2DeviceCloser2;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$2 = function12;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$3 = intRef;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$4 = autoCloseable;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$5 = session;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.J$0 = j;
                                retryingCameraStateOpenerImpl$openCameraWithRetry$1.label = i2;
                                RetryingCameraStateOpenerImpl$openCameraWithRetry$1 retryingCameraStateOpenerImpl$openCameraWithRetry$122 = retryingCameraStateOpenerImpl$openCameraWithRetry$1;
                                CameraAvailabilityMonitor.Session session52 = session;
                                Camera2DeviceCloser camera2DeviceCloser42 = camera2DeviceCloser2;
                                objM824tryOpenCamera7pD7j80$camera_camera2_pipe = cameraStateOpener2.m824tryOpenCamera7pD7j80$camera_camera2_pipe(str3, i42, j, camera2DeviceCloser42, audioRestrictionController2, retryingCameraStateOpenerImpl$openCameraWithRetry$122);
                                if (objM824tryOpenCamera7pD7j80$camera_camera2_pipe != coroutine_suspended) {
                                }
                            } else {
                                session3 = session2;
                                obj = coroutine_suspended;
                            }
                            this.cameraErrorListener.mo790onCameraError3M5Xam4(str4, openCameraResult.m832getErrorCodemVEW8x0().m311unboximpl(), zM856shouldRetryrbpwgO0$camera_camera2_pipe);
                            if (zM856shouldRetryrbpwgO0$camera_camera2_pipe) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    j2 = retryingCameraStateOpenerImpl$openCameraWithRetry$1.J$0;
                    session2 = (CameraAvailabilityMonitor.Session) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$5;
                    autoCloseable2 = (AutoCloseable) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$4;
                    Ref.IntRef intRef4 = (Ref.IntRef) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$3;
                    Function1<? super Unit, Boolean> function14 = (Function1) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$2;
                    Camera2DeviceCloser camera2DeviceCloser5 = (Camera2DeviceCloser) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$1;
                    String str6 = (String) retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$0;
                    ResultKt.throwOnFailure(objAwaitAvailableCamera);
                    intRef2 = intRef4;
                    str4 = str6;
                    camera2DeviceCloser3 = camera2DeviceCloser5;
                    function13 = function14;
                    th3 = null;
                    openCameraResult = (OpenCameraResult) objAwaitAvailableCamera;
                    Timestamps timestamps22 = Timestamps.INSTANCE;
                    long jM870constructorimpl2 = DurationNs.m870constructorimpl(this.timeSource.mo880nowvQl9yQU() - j2);
                    if (openCameraResult.getCameraState() != null) {
                    }
                }
                long j6 = jMo880nowvQl9yQU;
                session = (CameraAvailabilityMonitor.Session) autoCloseable;
                j = j6;
                str3 = str2;
                th2 = null;
                intRef.element += i3;
                CameraStateOpener cameraStateOpener22 = this.cameraStateOpener;
                int i422 = intRef.element;
                AudioRestrictionController audioRestrictionController22 = this.audioRestrictionController;
                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$0 = str3;
                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$1 = camera2DeviceCloser2;
                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$2 = function12;
                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$3 = intRef;
                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$4 = autoCloseable;
                retryingCameraStateOpenerImpl$openCameraWithRetry$1.L$5 = session;
                retryingCameraStateOpenerImpl$openCameraWithRetry$1.J$0 = j;
                retryingCameraStateOpenerImpl$openCameraWithRetry$1.label = i2;
                RetryingCameraStateOpenerImpl$openCameraWithRetry$1 retryingCameraStateOpenerImpl$openCameraWithRetry$1222 = retryingCameraStateOpenerImpl$openCameraWithRetry$1;
                CameraAvailabilityMonitor.Session session522 = session;
                Camera2DeviceCloser camera2DeviceCloser422 = camera2DeviceCloser2;
                objM824tryOpenCamera7pD7j80$camera_camera2_pipe = cameraStateOpener22.m824tryOpenCamera7pD7j80$camera_camera2_pipe(str3, i422, j, camera2DeviceCloser422, audioRestrictionController22, retryingCameraStateOpenerImpl$openCameraWithRetry$1222);
                if (objM824tryOpenCamera7pD7j80$camera_camera2_pipe != coroutine_suspended) {
                }
                return coroutine_suspended;
            } catch (Throwable th4) {
                th = th4;
                r5 = autoCloseable;
                try {
                    throw th;
                } finally {
                    AutoCloseableKt.closeFinally(r5, th);
                }
            }
            autoCloseable = (AutoCloseable) objAwaitAvailableCamera;
        } catch (Throwable th5) {
            th = th5;
            r5 = i;
        }
    }
}
