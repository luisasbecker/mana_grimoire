package androidx.camera.camera2.pipe.compat;

import android.graphics.ColorSpace;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.ExtensionSessionConfiguration;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.view.Surface;
import androidx.camera.camera2.pipe.AudioRestrictionMode;
import androidx.camera.camera2.pipe.CameraColorSpace;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraInterop;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.RequestsKt;
import androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper;
import androidx.camera.camera2.pipe.compat.CameraExtensionSessionWrapper;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.Timestamps;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: CameraDeviceWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0017J&\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001e\u0010%\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001e\u0010&\u001a\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J&\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020(0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020,H\u0017J\u0019\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0004\u0018\u00010.2\u0006\u00104\u001a\u000205H\u0016J\u000f\u00106\u001a\u000207H\u0017¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u000207H\u0017¢\u0006\u0004\b=\u0010>J\b\u0010?\u001a\u00020;H\u0016J\b\u0010@\u001a\u00020;H\u0016J'\u0010A\u001a\u0004\u0018\u0001HB\"\b\b\u0000\u0010B*\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002HB0EH\u0016¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020HH\u0016J.\u0010I\u001a\u0004\u0018\u0001HB\"\u0004\b\u0000\u0010B2\u0006\u0010J\u001a\u00020H2\u000e\b\u0004\u0010K\u001a\b\u0012\u0004\u0012\u0002HB0LH\u0082\b¢\u0006\u0002\u0010MJ\u001e\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170O2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\f\u0010P\u001a\u00020;*\u00020\u0017H\u0002J\f\u0010Q\u001a\u00020;*\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraDevice;", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "interopCaptureSessionListener", "Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "<init>", "(Landroidx/camera/camera2/pipe/CameraMetadata;Landroid/hardware/camera2/CameraDevice;Ljava/lang/String;Landroidx/camera/camera2/pipe/internal/CameraErrorListener;Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;Landroidx/camera/camera2/pipe/core/Threads;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "_lastStateCallback", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/compat/SessionStateCallback;", "createCaptureSession", "", "outputs", "", "Landroid/view/Surface;", "stateCallback", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "createExtensionSession", "config", "Landroidx/camera/camera2/pipe/compat/ExtensionSessionConfigData;", "createReprocessableCaptureSession", "input", "Landroid/hardware/camera2/params/InputConfiguration;", "createConstrainedHighSpeedCaptureSession", "createCaptureSessionByOutputConfigurations", "outputConfigurations", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "createReprocessableCaptureSessionByConfigurations", "inputConfig", "Landroidx/camera/camera2/pipe/compat/InputConfigData;", "Landroidx/camera/camera2/pipe/compat/SessionConfigData;", "createCaptureRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "template", "Landroidx/camera/camera2/pipe/RequestTemplate;", "createCaptureRequest-2PPcXtw", "(I)Landroid/hardware/camera2/CaptureRequest$Builder;", "createReprocessCaptureRequest", "inputResult", "Landroid/hardware/camera2/TotalCaptureResult;", "getCameraAudioRestriction", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "getCameraAudioRestriction-_b5Q8KE", "()I", "onCameraAudioRestrictionUpdated", "", "mode", "onCameraAudioRestrictionUpdated-LwUUkyU", "(I)V", "onDeviceClosing", "onDeviceClosed", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", InAppPurchaseConstants.METHOD_TO_STRING, "", "instrumentAndCatch", "fnName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "checkAndSetStateCallback", "Lkotlin/Pair;", "onSessionDisconnectedWithTrace", "onSessionFinalizedWithTrace", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidCameraDevice implements CameraDeviceWrapper {
    private final AtomicRef<SessionStateCallback> _lastStateCallback;
    private final CameraDevice cameraDevice;
    private final CameraErrorListener cameraErrorListener;
    private final String cameraId;
    private final CameraMetadata cameraMetadata;
    private final AtomicBoolean closed;
    private final CameraInterop.CaptureSessionListener interopCaptureSessionListener;
    private final Threads threads;

    private AndroidCameraDevice(CameraMetadata cameraMetadata, CameraDevice cameraDevice, String cameraId, CameraErrorListener cameraErrorListener, CameraInterop.CaptureSessionListener captureSessionListener, Threads threads) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(cameraErrorListener, "cameraErrorListener");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.cameraMetadata = cameraMetadata;
        this.cameraDevice = cameraDevice;
        this.cameraId = cameraId;
        this.cameraErrorListener = cameraErrorListener;
        this.interopCaptureSessionListener = captureSessionListener;
        this.threads = threads;
        this.closed = AtomicFU.atomic(false);
        this._lastStateCallback = AtomicFU.atomic((Object) null);
    }

    public /* synthetic */ AndroidCameraDevice(CameraMetadata cameraMetadata, CameraDevice cameraDevice, String str, CameraErrorListener cameraErrorListener, CameraInterop.CaptureSessionListener captureSessionListener, Threads threads, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cameraMetadata, cameraDevice, str, cameraErrorListener, (i & 16) != 0 ? null : captureSessionListener, threads, null);
    }

    public /* synthetic */ AndroidCameraDevice(CameraMetadata cameraMetadata, CameraDevice cameraDevice, String str, CameraErrorListener cameraErrorListener, CameraInterop.CaptureSessionListener captureSessionListener, Threads threads, DefaultConstructorMarker defaultConstructorMarker) {
        this(cameraMetadata, cameraDevice, str, cameraErrorListener, captureSessionListener, threads);
    }

    private final Pair<Boolean, SessionStateCallback> checkAndSetStateCallback(SessionStateCallback stateCallback) {
        if (!this.closed.getValue()) {
            return new Pair<>(true, this._lastStateCallback.getAndSet(stateCallback));
        }
        onSessionFinalizedWithTrace(stateCallback);
        return new Pair<>(false, null);
    }

    private final <T> T instrumentAndCatch(String fnName, Function0<? extends T> block) throws Throwable {
        double d;
        String cameraId;
        T tInvoke;
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#" + fnName + Soundex.SILENT_MARKER + getCameraId();
        long jMo880nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            Trace.beginSection(str);
            cameraId = getCameraId();
            d = 1000000.0d;
        } catch (Throwable th) {
            th = th;
            d = 1000000.0d;
        }
        try {
            CameraErrorListener cameraErrorListener = this.cameraErrorListener;
            try {
                tInvoke = block.invoke();
            } catch (Exception e) {
                if (e instanceof CameraAccessException) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                    }
                    cameraErrorListener.mo790onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                } else if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                    }
                    cameraErrorListener.mo790onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                } else {
                    if (!(e instanceof IllegalStateException)) {
                        throw e;
                    }
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                    }
                }
                tInvoke = null;
            }
            Trace.endSection();
            long jM870constructorimpl = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sbAppend = new StringBuilder().append(str).append(" - ");
                Timestamps timestamps = Timestamps.INSTANCE;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl / 1000000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                android.util.Log.d(Log.TAG, sbAppend.append(str2).toString());
            }
            return tInvoke;
        } catch (Throwable th2) {
            th = th2;
            Trace.endSection();
            long jM870constructorimpl2 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sbAppend2 = new StringBuilder().append(str).append(" - ");
                Timestamps timestamps2 = Timestamps.INSTANCE;
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl2 / d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                android.util.Log.d(Log.TAG, sbAppend2.append(str3).toString());
            }
            throw th;
        }
    }

    private final void onSessionDisconnectedWithTrace(SessionStateCallback sessionStateCallback) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(this + "#onSessionDisconnected");
            sessionStateCallback.onSessionDisconnected();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final void onSessionFinalizedWithTrace(SessionStateCallback sessionStateCallback) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(this + "#onSessionFinalized");
            sessionStateCallback.onSessionFinalized();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /* JADX INFO: renamed from: createCaptureRequest-2PPcXtw, reason: not valid java name */
    public CaptureRequest.Builder mo753createCaptureRequest2PPcXtw(int template) throws Throwable {
        double d;
        CaptureRequest.Builder builderCreateCaptureRequest;
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#createCaptureRequest-" + getCameraId();
        long jMo880nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            Trace.beginSection(str);
            String cameraId = getCameraId();
            d = 1000000.0d;
            try {
                CameraErrorListener cameraErrorListener = this.cameraErrorListener;
                try {
                    builderCreateCaptureRequest = this.cameraDevice.createCaptureRequest(template);
                } catch (Exception e) {
                    if (e instanceof CameraAccessException) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                        }
                        cameraErrorListener.mo790onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                    } else if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                        }
                        cameraErrorListener.mo790onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                    } else {
                        if (!(e instanceof IllegalStateException)) {
                            throw e;
                        }
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                        }
                    }
                    builderCreateCaptureRequest = null;
                }
                Trace.endSection();
                long jM870constructorimpl = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sbAppend = new StringBuilder().append(str).append(" - ");
                    Timestamps timestamps = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    android.util.Log.d(Log.TAG, sbAppend.append(str2).toString());
                }
                return builderCreateCaptureRequest;
            } catch (Throwable th) {
                th = th;
                Trace.endSection();
                long jM870constructorimpl2 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sbAppend2 = new StringBuilder().append(str).append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl2 / d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    android.util.Log.d(Log.TAG, sbAppend2.append(str3).toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d = 1000000.0d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029f A[Catch: all -> 0x03a3, TryCatch #2 {all -> 0x03a3, blocks: (B:24:0x00d5, B:26:0x00e4, B:28:0x00ea, B:29:0x00fa, B:30:0x012c, B:33:0x0138, B:35:0x013e, B:43:0x018d, B:45:0x01a0, B:46:0x01c4, B:48:0x01ca, B:49:0x01d8, B:50:0x01e6, B:52:0x01ec, B:54:0x01fe, B:56:0x020b, B:57:0x020f, B:59:0x022b, B:61:0x0234, B:62:0x0237, B:64:0x0239, B:65:0x023c, B:36:0x0142, B:38:0x014a, B:40:0x0169, B:42:0x0171, B:89:0x029b, B:91:0x029f, B:93:0x02a7, B:94:0x02c1, B:97:0x02cf, B:99:0x02d3, B:101:0x02d7, B:103:0x02db, B:106:0x02e0, B:108:0x02e4, B:110:0x02ec, B:111:0x02f2, B:112:0x02f3, B:114:0x02fb, B:115:0x0315), top: B:140:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02cf A[Catch: all -> 0x03a3, TryCatch #2 {all -> 0x03a3, blocks: (B:24:0x00d5, B:26:0x00e4, B:28:0x00ea, B:29:0x00fa, B:30:0x012c, B:33:0x0138, B:35:0x013e, B:43:0x018d, B:45:0x01a0, B:46:0x01c4, B:48:0x01ca, B:49:0x01d8, B:50:0x01e6, B:52:0x01ec, B:54:0x01fe, B:56:0x020b, B:57:0x020f, B:59:0x022b, B:61:0x0234, B:62:0x0237, B:64:0x0239, B:65:0x023c, B:36:0x0142, B:38:0x014a, B:40:0x0169, B:42:0x0171, B:89:0x029b, B:91:0x029f, B:93:0x02a7, B:94:0x02c1, B:97:0x02cf, B:99:0x02d3, B:101:0x02d7, B:103:0x02db, B:106:0x02e0, B:108:0x02e4, B:110:0x02ec, B:111:0x02f2, B:112:0x02f3, B:114:0x02fb, B:115:0x0315), top: B:140:0x0059 }] */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.camera.camera2.pipe.compat.SessionConfigData, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean createCaptureSession(SessionConfigData config) throws Throwable {
        String str;
        Debug debug;
        ?? r6;
        ?? r3;
        String str2;
        String str3;
        String str4;
        String cameraId;
        CameraErrorListener cameraErrorListener;
        String str5;
        String str6;
        Debug debug2;
        String str7;
        String str8;
        CameraErrorListener cameraErrorListener2;
        boolean z;
        boolean z2;
        Unit unit;
        ?? r32;
        int sessionType;
        ArrayList arrayList;
        Executor executor;
        CameraErrorListener cameraErrorListener3;
        ?? r33 = "%.3f ms";
        ?? config2 = config;
        Intrinsics.checkNotNullParameter(config2, "config");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(config2.getStateCallback());
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
            Unit unit2 = Unit.INSTANCE;
        }
        Debug debug3 = Debug.INSTANCE;
        String str9 = "CXCP#createCaptureSession-" + getCameraId();
        long jMo880nowvQl9yQU = debug3.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str9);
                cameraId = getCameraId();
                cameraErrorListener = this.cameraErrorListener;
                try {
                    try {
                        sessionType = config2.getSessionType();
                        List<OutputConfigurationWrapper> outputConfigurations = config2.getOutputConfigurations();
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(outputConfigurations, 10));
                        Iterator it = outputConfigurations.iterator();
                        while (it.hasNext()) {
                            arrayList2.add((OutputConfiguration) ((OutputConfigurationWrapper) it.next()).unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class)));
                        }
                        arrayList = arrayList2;
                        executor = config2.getExecutor();
                    } catch (Exception e) {
                        e = e;
                        str5 = "format(...)";
                        str6 = "%.3f ms";
                        debug2 = debug3;
                        str7 = str9;
                    }
                } catch (Throwable th) {
                    th = th;
                    str4 = "format(...)";
                    str3 = "%.3f ms";
                    debug = debug3;
                    config2 = str9;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            str = "%.3f ms";
            debug = debug3;
            r6 = str9;
            r3 = 1;
            str2 = "format(...)";
            Trace.endSection();
            long jM870constructorimpl = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sbAppend = new StringBuilder().append(r6).append(" - ");
                Timestamps timestamps = Timestamps.INSTANCE;
                String str10 = String.format(null, str, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl / 1000000.0d)}, (int) r3));
                Intrinsics.checkNotNullExpressionValue(str10, str2);
                android.util.Log.d(Log.TAG, sbAppend.append(str10).toString());
            }
            throw th;
        }
        try {
            AndroidCameraDevice androidCameraDevice = this;
            try {
                try {
                    CameraCaptureSessionWrapper.StateCallback stateCallback = config2.getStateCallback();
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        debug2 = debug3;
                        cameraErrorListener3 = cameraErrorListener;
                        str7 = str9;
                        str8 = cameraId;
                    }
                    try {
                        debug2 = debug3;
                        str7 = str9;
                        str8 = cameraId;
                        cameraErrorListener2 = cameraErrorListener;
                        str5 = "format(...)";
                        str6 = "%.3f ms";
                        z = true;
                        r32 = 1;
                    } catch (Exception e3) {
                        e = e3;
                        debug2 = debug3;
                        str7 = str9;
                        str8 = cameraId;
                        cameraErrorListener3 = cameraErrorListener;
                        str5 = "format(...)";
                        str6 = "%.3f ms";
                        cameraErrorListener2 = cameraErrorListener3;
                        z = true;
                        if (e instanceof CameraAccessException) {
                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                            }
                            cameraErrorListener2.mo790onCameraError3M5Xam4(str8, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                        } else {
                            if (!(e instanceof IllegalArgumentException) && !(e instanceof SecurityException) && !(e instanceof UnsupportedOperationException) && !(e instanceof NullPointerException)) {
                                if (!(e instanceof IllegalStateException)) {
                                    throw e;
                                }
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                }
                            }
                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                            }
                            z2 = false;
                            cameraErrorListener2.mo790onCameraError3M5Xam4(str8, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                            unit = null;
                            r32 = z;
                            Trace.endSection();
                            long jM870constructorimpl2 = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            }
                            if (unit == null) {
                            }
                            if (unit == null) {
                            }
                        }
                        z2 = false;
                        unit = null;
                        r32 = z;
                        Trace.endSection();
                        long jM870constructorimpl22 = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        }
                        if (unit == null) {
                        }
                        if (unit == null) {
                        }
                    }
                    try {
                        SessionConfiguration sessionConfigurationNewSessionConfiguration = Api28Compat.newSessionConfiguration(sessionType, arrayList, executor, new AndroidCaptureSessionStateCallback(androidCameraDevice, stateCallback, sessionStateCallbackComponent2, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads.getCamera2Handler()));
                        if (config.getInputConfiguration() != null) {
                            if (Build.VERSION.SDK_INT >= 31) {
                                Api28Compat.setInputConfiguration(sessionConfigurationNewSessionConfiguration, Api31Compat.newInputConfiguration(config.getInputConfiguration(), getCameraId()));
                            } else {
                                Api28Compat.setInputConfiguration(sessionConfigurationNewSessionConfiguration, new InputConfiguration(((InputConfigData) CollectionsKt.single((List) config.getInputConfiguration())).getWidth(), ((InputConfigData) CollectionsKt.single((List) config.getInputConfiguration())).getHeight(), ((InputConfigData) CollectionsKt.single((List) config.getInputConfiguration())).getFormat()));
                            }
                        }
                        String strM860getSessionColorSpacedxVZaPA = config.m860getSessionColorSpacedxVZaPA();
                        if (Build.VERSION.SDK_INT >= 34 && strM860getSessionColorSpacedxVZaPA != null) {
                            ColorSpace.Named namedM229toColorSpaceNamedimpl = CameraColorSpace.m229toColorSpaceNamedimpl(strM860getSessionColorSpacedxVZaPA);
                            if (namedM229toColorSpaceNamedimpl != null) {
                                Api34Compat.setColorSpace(sessionConfigurationNewSessionConfiguration, namedM229toColorSpaceNamedimpl);
                            } else if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Provided session color space " + strM860getSessionColorSpacedxVZaPA + " is not supported");
                            }
                        } else if (strM860getSessionColorSpacedxVZaPA != null && Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to set session color space to " + strM860getSessionColorSpacedxVZaPA + ", at least API level 34 is required");
                        }
                        Debug debug4 = Debug.INSTANCE;
                        try {
                            Trace.beginSection("createCaptureRequest");
                            CaptureRequest.Builder builderCreateCaptureRequest = this.cameraDevice.createCaptureRequest(config.getSessionTemplateId());
                            Trace.endSection();
                            Intrinsics.checkNotNullExpressionValue(builderCreateCaptureRequest, "trace(...)");
                            Set<CaptureRequest.Key<?>> sessionKeys = this.cameraMetadata.getSessionKeys();
                            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sessionKeys, 10));
                            Iterator it2 = sessionKeys.iterator();
                            while (it2.hasNext()) {
                                arrayList3.add(((CaptureRequest.Key) it2.next()).getName());
                            }
                            ArrayList arrayList4 = arrayList3;
                            for (Map.Entry<?, Object> entry : config.getSessionParameters().entrySet()) {
                                Object key = entry.getKey();
                                Object value = entry.getValue();
                                if ((key instanceof CaptureRequest.Key) && arrayList4.contains(((CaptureRequest.Key) key).getName())) {
                                    RequestsKt.writeParameter(builderCreateCaptureRequest, key, value);
                                }
                            }
                            CaptureRequest captureRequestBuild = builderCreateCaptureRequest.build();
                            Intrinsics.checkNotNullExpressionValue(captureRequestBuild, "build(...)");
                            Api28Compat.setSessionParameters(sessionConfigurationNewSessionConfiguration, captureRequestBuild);
                            Debug debug5 = Debug.INSTANCE;
                            try {
                                Trace.beginSection("Api28Compat.createCaptureSession");
                                Api28Compat.createCaptureSession(this.cameraDevice, sessionConfigurationNewSessionConfiguration);
                                Unit unit3 = Unit.INSTANCE;
                                Trace.endSection();
                                unit = Unit.INSTANCE;
                                z2 = false;
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Exception e4) {
                        e = e4;
                        if (e instanceof CameraAccessException) {
                        }
                        z2 = false;
                        unit = null;
                        r32 = z;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str3 = "%.3f ms";
                    debug = debug3;
                    config2 = str9;
                    r33 = 1;
                    str4 = "format(...)";
                    str2 = str4;
                    str = str3;
                    r3 = r33;
                    r6 = config2;
                    Trace.endSection();
                    long jM870constructorimpl3 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                str6 = "%.3f ms";
                debug2 = debug3;
                str8 = cameraId;
                cameraErrorListener2 = cameraErrorListener;
                str7 = str9;
                z = true;
                str5 = "format(...)";
            }
        } catch (Exception e6) {
            e = e6;
            str5 = "format(...)";
            str6 = "%.3f ms";
            debug2 = debug3;
            str7 = str9;
            str8 = cameraId;
            cameraErrorListener2 = cameraErrorListener;
            z = true;
            if (e instanceof CameraAccessException) {
            }
            z2 = false;
            unit = null;
            r32 = z;
            Trace.endSection();
            long jM870constructorimpl222 = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            }
            if (unit == null) {
            }
            if (unit == null) {
            }
        } catch (Throwable th5) {
            th = th5;
            str4 = "format(...)";
            str3 = "%.3f ms";
            debug = debug3;
            config2 = str9;
            r33 = 1;
            str2 = str4;
            str = str3;
            r3 = r33;
            r6 = config2;
            Trace.endSection();
            long jM870constructorimpl32 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            }
            throw th;
        }
        Trace.endSection();
        long jM870constructorimpl2222 = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            StringBuilder sbAppend2 = new StringBuilder().append(str7).append(" - ");
            Timestamps timestamps2 = Timestamps.INSTANCE;
            String str11 = String.format(null, str6, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl2222 / 1000000.0d)}, (int) r32));
            Intrinsics.checkNotNullExpressionValue(str11, str5);
            android.util.Log.d(Log.TAG, sbAppend2.append(str11).toString());
        }
        if (unit == null) {
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
            }
            if (sessionStateCallbackComponent2 != null) {
                onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                Unit unit4 = Unit.INSTANCE;
            }
        }
        return unit == null ? r32 : z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0114 A[Catch: all -> 0x020c, TryCatch #6 {all -> 0x020c, blocks: (B:17:0x009d, B:38:0x0110, B:40:0x0114, B:42:0x011c, B:43:0x0130, B:46:0x013e, B:48:0x0142, B:50:0x0146, B:52:0x014a, B:55:0x014f, B:57:0x0153, B:59:0x015b, B:60:0x0161, B:61:0x0162, B:63:0x016a, B:64:0x017e), top: B:91:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013e A[Catch: all -> 0x020c, TryCatch #6 {all -> 0x020c, blocks: (B:17:0x009d, B:38:0x0110, B:40:0x0114, B:42:0x011c, B:43:0x0130, B:46:0x013e, B:48:0x0142, B:50:0x0146, B:52:0x014a, B:55:0x014f, B:57:0x0153, B:59:0x015b, B:60:0x0161, B:61:0x0162, B:63:0x016a, B:64:0x017e), top: B:91:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x022e  */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v9, types: [int] */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.camera.camera2.pipe.compat.AndroidCameraDevice] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.StringBuilder] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean createCaptureSession(List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        ?? r1;
        String str;
        String str2;
        ?? r11;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z;
        String str11;
        boolean z2;
        CameraErrorListener cameraErrorListener;
        boolean z3;
        Unit unit;
        ?? r112;
        CameraDeviceWrapper cameraDeviceWrapper;
        CameraErrorListener cameraErrorListener2;
        CameraInterop.CaptureSessionListener captureSessionListener;
        Handler camera2Handler;
        ?? r12 = this;
        ?? r113 = " - ";
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = r12.checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            r12.onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug = Debug.INSTANCE;
        String str12 = "CXCP#createCaptureSession-" + r12.getCameraId();
        long jMo880nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str12);
                String cameraId = r12.getCameraId();
                CameraErrorListener cameraErrorListener3 = r12.cameraErrorListener;
                try {
                    CameraDevice cameraDevice = r12.cameraDevice;
                    try {
                        try {
                            try {
                                cameraDeviceWrapper = (CameraDeviceWrapper) r12;
                                cameraErrorListener2 = r12.cameraErrorListener;
                            } catch (Exception e) {
                                e = e;
                                str10 = " - ";
                                str7 = str12;
                                z = true;
                                str8 = "format(...)";
                                str9 = "%.3f ms";
                                str11 = cameraId;
                                z2 = z;
                                cameraErrorListener = cameraErrorListener3;
                                if (e instanceof CameraAccessException) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                    }
                                    cameraErrorListener.mo790onCameraError3M5Xam4(str11, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                } else {
                                    if (!(e instanceof IllegalArgumentException) && !(e instanceof SecurityException) && !(e instanceof UnsupportedOperationException) && !(e instanceof NullPointerException)) {
                                        if (!(e instanceof IllegalStateException)) {
                                            throw e;
                                        }
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                        }
                                    }
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                    }
                                    z3 = false;
                                    cameraErrorListener.mo790onCameraError3M5Xam4(str11, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                    unit = null;
                                    r112 = z2;
                                    Trace.endSection();
                                    long jM870constructorimpl = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    }
                                    if (unit == null) {
                                    }
                                    if (unit == null) {
                                    }
                                }
                                z3 = false;
                                unit = null;
                                r112 = z2;
                                Trace.endSection();
                                long jM870constructorimpl2 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                }
                                if (unit == null) {
                                }
                                if (unit == null) {
                                }
                            }
                            try {
                                captureSessionListener = r12.interopCaptureSessionListener;
                                camera2Handler = r12.threads.getCamera2Handler();
                                str7 = str12;
                                str8 = "format(...)";
                                str11 = cameraId;
                                str10 = " - ";
                                z2 = true;
                                str9 = "%.3f ms";
                                cameraErrorListener = cameraErrorListener3;
                            } catch (Exception e2) {
                                e = e2;
                                str7 = str12;
                                str8 = "format(...)";
                                str11 = cameraId;
                                str10 = " - ";
                                z2 = true;
                                str9 = "%.3f ms";
                                cameraErrorListener = cameraErrorListener3;
                                if (e instanceof CameraAccessException) {
                                }
                                z3 = false;
                                unit = null;
                                r112 = z2;
                                Trace.endSection();
                                long jM870constructorimpl22 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                }
                                if (unit == null) {
                                }
                                if (unit == null) {
                                }
                            }
                            try {
                                cameraDevice.createCaptureSession(outputs, new AndroidCaptureSessionStateCallback(cameraDeviceWrapper, stateCallback, sessionStateCallbackComponent2, cameraErrorListener2, captureSessionListener, camera2Handler), this.threads.getCamera2Handler());
                                unit = Unit.INSTANCE;
                                z3 = false;
                                r112 = z2;
                            } catch (Exception e3) {
                                e = e3;
                                if (e instanceof CameraAccessException) {
                                }
                                z3 = false;
                                unit = null;
                                r112 = z2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            str4 = " - ";
                            r12 = str12;
                            r113 = 1;
                            str6 = "format(...)";
                            str5 = "%.3f ms";
                            str = str6;
                            str3 = str5;
                            str2 = str4;
                            r1 = r12;
                            r11 = r113;
                            Trace.endSection();
                            long jM870constructorimpl3 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                StringBuilder sbAppend = new StringBuilder().append(r1).append(str2);
                                Timestamps timestamps = Timestamps.INSTANCE;
                                String str13 = String.format(null, str3, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl3 / 1000000.0d)}, (int) r11));
                                Intrinsics.checkNotNullExpressionValue(str13, str);
                                android.util.Log.d(Log.TAG, sbAppend.append(str13).toString());
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str9 = "%.3f ms";
                        str10 = " - ";
                        str7 = str12;
                        z2 = true;
                        cameraErrorListener = cameraErrorListener3;
                        str8 = "format(...)";
                        str11 = cameraId;
                    } catch (Throwable th2) {
                        th = th2;
                        str5 = "%.3f ms";
                        str4 = " - ";
                        r12 = str12;
                        r113 = 1;
                        str6 = "format(...)";
                    }
                } catch (Exception e5) {
                    e = e5;
                    str7 = str12;
                    str8 = "format(...)";
                    str9 = "%.3f ms";
                    str10 = " - ";
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    r12 = str12;
                    str6 = "format(...)";
                    str5 = "%.3f ms";
                    str4 = " - ";
                    r113 = 1;
                }
                Trace.endSection();
                long jM870constructorimpl222 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sbAppend2 = new StringBuilder().append(str7).append(str10);
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str14 = String.format(null, str9, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl222 / 1000000.0d)}, (int) r112));
                    Intrinsics.checkNotNullExpressionValue(str14, str8);
                    android.util.Log.d(Log.TAG, sbAppend2.append(str14).toString());
                }
                if (unit == null) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                    }
                    if (sessionStateCallbackComponent2 != null) {
                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                    }
                }
                return unit == null ? r112 : z3;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            r1 = str12;
            str = "format(...)";
            str2 = " - ";
            r11 = 1;
            str3 = "%.3f ms";
            Trace.endSection();
            long jM870constructorimpl32 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f8 A[Catch: all -> 0x01f8, TryCatch #3 {all -> 0x01f8, blocks: (B:20:0x00c0, B:34:0x00f4, B:36:0x00f8, B:38:0x0100, B:39:0x011a, B:42:0x0128, B:44:0x012c, B:46:0x0130, B:48:0x0134, B:51:0x0139, B:53:0x013d, B:55:0x0145, B:56:0x014b, B:57:0x014c, B:59:0x0154, B:60:0x016e), top: B:88:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0128 A[Catch: all -> 0x01f8, TryCatch #3 {all -> 0x01f8, blocks: (B:20:0x00c0, B:34:0x00f4, B:36:0x00f8, B:38:0x0100, B:39:0x011a, B:42:0x0128, B:44:0x012c, B:46:0x0130, B:48:0x0134, B:51:0x0139, B:53:0x013d, B:55:0x0145, B:56:0x014b, B:57:0x014c, B:59:0x0154, B:60:0x016e), top: B:88:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0219  */
    /* JADX WARN: Type inference failed for: r13v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v7, types: [int] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean createCaptureSessionByOutputConfigurations(List<? extends OutputConfigurationWrapper> outputConfigurations, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        String str;
        Debug debug;
        ?? r9;
        String str2;
        String str3;
        Debug debug2;
        boolean z;
        CameraErrorListener cameraErrorListener;
        boolean z2;
        Unit unit;
        ?? r92;
        CameraDevice cameraDevice;
        ArrayList arrayList;
        ?? r93 = "format(...)";
        Intrinsics.checkNotNullParameter(outputConfigurations, "outputConfigurations");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug3 = Debug.INSTANCE;
        String str4 = "CXCP#createCaptureSessionByOutputConfigurations-" + getCameraId();
        long jMo880nowvQl9yQU = debug3.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str4);
                String cameraId = getCameraId();
                CameraErrorListener cameraErrorListener2 = this.cameraErrorListener;
                try {
                    try {
                        cameraDevice = this.cameraDevice;
                        List<? extends OutputConfigurationWrapper> list = outputConfigurations;
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add((OutputConfiguration) ((OutputConfigurationWrapper) it.next()).unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class)));
                        }
                        str2 = cameraId;
                        try {
                            try {
                                debug2 = debug3;
                                cameraErrorListener = cameraErrorListener2;
                                str3 = "format(...)";
                                z = true;
                                r92 = 1;
                            } catch (Exception e) {
                                e = e;
                                debug2 = debug3;
                                cameraErrorListener = cameraErrorListener2;
                                str3 = "format(...)";
                                z = true;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str3 = "format(...)";
                            debug2 = debug3;
                            z = true;
                            cameraErrorListener = cameraErrorListener2;
                            if (e instanceof CameraAccessException) {
                                if (!(e instanceof IllegalArgumentException) && !(e instanceof SecurityException) && !(e instanceof UnsupportedOperationException) && !(e instanceof NullPointerException)) {
                                    if (!(e instanceof IllegalStateException)) {
                                        throw e;
                                    }
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                    }
                                }
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                }
                                z2 = false;
                                cameraErrorListener.mo790onCameraError3M5Xam4(str2, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                unit = null;
                                r92 = z;
                                Trace.endSection();
                                long jM870constructorimpl = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                }
                                if (unit == null) {
                                }
                                if (unit != null) {
                                }
                            } else {
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                }
                                cameraErrorListener.mo790onCameraError3M5Xam4(str2, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                            }
                            z2 = false;
                            unit = null;
                            r92 = z;
                            Trace.endSection();
                            long jM870constructorimpl2 = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            }
                            if (unit == null) {
                            }
                            if (unit != null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        debug = debug3;
                        r93 = 1;
                        str = "format(...)";
                        r9 = r93;
                        Trace.endSection();
                        long jM870constructorimpl3 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            StringBuilder sbAppend = new StringBuilder().append(str4).append(" - ");
                            Timestamps timestamps = Timestamps.INSTANCE;
                            String str5 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl3 / 1000000.0d)}, (int) r9));
                            Intrinsics.checkNotNullExpressionValue(str5, str);
                            android.util.Log.d(Log.TAG, sbAppend.append(str5).toString());
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    str2 = cameraId;
                }
                try {
                    Api24Compat.createCaptureSessionByOutputConfigurations(cameraDevice, arrayList, new AndroidCaptureSessionStateCallback(this, stateCallback, sessionStateCallbackComponent2, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads.getCamera2Handler()), this.threads.getCamera2Handler());
                    unit = Unit.INSTANCE;
                    z2 = false;
                } catch (Exception e4) {
                    e = e4;
                    if (e instanceof CameraAccessException) {
                    }
                    z2 = false;
                    unit = null;
                    r92 = z;
                }
                Trace.endSection();
                long jM870constructorimpl22 = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sbAppend2 = new StringBuilder().append(str4).append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str6 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl22 / 1000000.0d)}, (int) r92));
                    Intrinsics.checkNotNullExpressionValue(str6, str3);
                    android.util.Log.d(Log.TAG, sbAppend2.append(str6).toString());
                }
                if (unit == null) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                    }
                    if (sessionStateCallbackComponent2 != null) {
                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                    }
                }
                return unit != null ? r92 : z2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            str = "format(...)";
            debug = debug3;
            r9 = 1;
            Trace.endSection();
            long jM870constructorimpl32 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0114 A[Catch: all -> 0x020c, TryCatch #6 {all -> 0x020c, blocks: (B:17:0x009d, B:38:0x0110, B:40:0x0114, B:42:0x011c, B:43:0x0130, B:46:0x013e, B:48:0x0142, B:50:0x0146, B:52:0x014a, B:55:0x014f, B:57:0x0153, B:59:0x015b, B:60:0x0161, B:61:0x0162, B:63:0x016a, B:64:0x017e), top: B:91:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013e A[Catch: all -> 0x020c, TryCatch #6 {all -> 0x020c, blocks: (B:17:0x009d, B:38:0x0110, B:40:0x0114, B:42:0x011c, B:43:0x0130, B:46:0x013e, B:48:0x0142, B:50:0x0146, B:52:0x014a, B:55:0x014f, B:57:0x0153, B:59:0x015b, B:60:0x0161, B:61:0x0162, B:63:0x016a, B:64:0x017e), top: B:91:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x022e  */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v9, types: [int] */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.camera.camera2.pipe.compat.AndroidCameraDevice] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.StringBuilder] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean createConstrainedHighSpeedCaptureSession(List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        ?? r1;
        String str;
        String str2;
        ?? r11;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z;
        String str11;
        boolean z2;
        CameraErrorListener cameraErrorListener;
        boolean z3;
        Unit unit;
        ?? r112;
        CameraDeviceWrapper cameraDeviceWrapper;
        CameraErrorListener cameraErrorListener2;
        CameraInterop.CaptureSessionListener captureSessionListener;
        Handler camera2Handler;
        ?? r12 = this;
        ?? r113 = " - ";
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = r12.checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            r12.onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug = Debug.INSTANCE;
        String str12 = "CXCP#createConstrainedHighSpeedCaptureSession-" + r12.getCameraId();
        long jMo880nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str12);
                String cameraId = r12.getCameraId();
                CameraErrorListener cameraErrorListener3 = r12.cameraErrorListener;
                try {
                    CameraDevice cameraDevice = r12.cameraDevice;
                    try {
                        try {
                            try {
                                cameraDeviceWrapper = (CameraDeviceWrapper) r12;
                                cameraErrorListener2 = r12.cameraErrorListener;
                            } catch (Exception e) {
                                e = e;
                                str10 = " - ";
                                str7 = str12;
                                z = true;
                                str8 = "format(...)";
                                str9 = "%.3f ms";
                                str11 = cameraId;
                                z2 = z;
                                cameraErrorListener = cameraErrorListener3;
                                if (e instanceof CameraAccessException) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                    }
                                    cameraErrorListener.mo790onCameraError3M5Xam4(str11, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                } else {
                                    if (!(e instanceof IllegalArgumentException) && !(e instanceof SecurityException) && !(e instanceof UnsupportedOperationException) && !(e instanceof NullPointerException)) {
                                        if (!(e instanceof IllegalStateException)) {
                                            throw e;
                                        }
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                        }
                                    }
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                    }
                                    z3 = false;
                                    cameraErrorListener.mo790onCameraError3M5Xam4(str11, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                    unit = null;
                                    r112 = z2;
                                    Trace.endSection();
                                    long jM870constructorimpl = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    }
                                    if (unit == null) {
                                    }
                                    if (unit == null) {
                                    }
                                }
                                z3 = false;
                                unit = null;
                                r112 = z2;
                                Trace.endSection();
                                long jM870constructorimpl2 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                }
                                if (unit == null) {
                                }
                                if (unit == null) {
                                }
                            }
                            try {
                                captureSessionListener = r12.interopCaptureSessionListener;
                                camera2Handler = r12.threads.getCamera2Handler();
                                str7 = str12;
                                str8 = "format(...)";
                                str11 = cameraId;
                                str10 = " - ";
                                z2 = true;
                                str9 = "%.3f ms";
                                cameraErrorListener = cameraErrorListener3;
                            } catch (Exception e2) {
                                e = e2;
                                str7 = str12;
                                str8 = "format(...)";
                                str11 = cameraId;
                                str10 = " - ";
                                z2 = true;
                                str9 = "%.3f ms";
                                cameraErrorListener = cameraErrorListener3;
                                if (e instanceof CameraAccessException) {
                                }
                                z3 = false;
                                unit = null;
                                r112 = z2;
                                Trace.endSection();
                                long jM870constructorimpl22 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                }
                                if (unit == null) {
                                }
                                if (unit == null) {
                                }
                            }
                            try {
                                cameraDevice.createConstrainedHighSpeedCaptureSession(outputs, new AndroidCaptureSessionStateCallback(cameraDeviceWrapper, stateCallback, sessionStateCallbackComponent2, cameraErrorListener2, captureSessionListener, camera2Handler), this.threads.getCamera2Handler());
                                unit = Unit.INSTANCE;
                                z3 = false;
                                r112 = z2;
                            } catch (Exception e3) {
                                e = e3;
                                if (e instanceof CameraAccessException) {
                                }
                                z3 = false;
                                unit = null;
                                r112 = z2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            str4 = " - ";
                            r12 = str12;
                            r113 = 1;
                            str6 = "format(...)";
                            str5 = "%.3f ms";
                            str = str6;
                            str3 = str5;
                            str2 = str4;
                            r1 = r12;
                            r11 = r113;
                            Trace.endSection();
                            long jM870constructorimpl3 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                StringBuilder sbAppend = new StringBuilder().append(r1).append(str2);
                                Timestamps timestamps = Timestamps.INSTANCE;
                                String str13 = String.format(null, str3, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl3 / 1000000.0d)}, (int) r11));
                                Intrinsics.checkNotNullExpressionValue(str13, str);
                                android.util.Log.d(Log.TAG, sbAppend.append(str13).toString());
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str9 = "%.3f ms";
                        str10 = " - ";
                        str7 = str12;
                        z2 = true;
                        cameraErrorListener = cameraErrorListener3;
                        str8 = "format(...)";
                        str11 = cameraId;
                    } catch (Throwable th2) {
                        th = th2;
                        str5 = "%.3f ms";
                        str4 = " - ";
                        r12 = str12;
                        r113 = 1;
                        str6 = "format(...)";
                    }
                } catch (Exception e5) {
                    e = e5;
                    str7 = str12;
                    str8 = "format(...)";
                    str9 = "%.3f ms";
                    str10 = " - ";
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    r12 = str12;
                    str6 = "format(...)";
                    str5 = "%.3f ms";
                    str4 = " - ";
                    r113 = 1;
                }
                Trace.endSection();
                long jM870constructorimpl222 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sbAppend2 = new StringBuilder().append(str7).append(str10);
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str14 = String.format(null, str9, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl222 / 1000000.0d)}, (int) r112));
                    Intrinsics.checkNotNullExpressionValue(str14, str8);
                    android.util.Log.d(Log.TAG, sbAppend2.append(str14).toString());
                }
                if (unit == null) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to create capture session from " + this.cameraDevice + ". Finalizing previous session");
                    }
                    if (sessionStateCallbackComponent2 != null) {
                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                    }
                }
                return unit == null ? r112 : z3;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            r1 = str12;
            str = "format(...)";
            str2 = " - ";
            r11 = 1;
            str3 = "%.3f ms";
            Trace.endSection();
            long jM870constructorimpl32 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0196 A[Catch: all -> 0x0298, TryCatch #9 {all -> 0x0298, blocks: (B:30:0x00d7, B:32:0x00e6, B:34:0x00ec, B:36:0x00fe, B:37:0x0102, B:38:0x010d, B:39:0x010e, B:65:0x0192, B:67:0x0196, B:69:0x019e, B:70:0x01b8, B:73:0x01c6, B:75:0x01ca, B:77:0x01ce, B:79:0x01d2, B:82:0x01d7, B:84:0x01db, B:86:0x01e3, B:87:0x01e9, B:88:0x01ea, B:90:0x01f2, B:91:0x020c), top: B:125:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c6 A[Catch: all -> 0x0298, TryCatch #9 {all -> 0x0298, blocks: (B:30:0x00d7, B:32:0x00e6, B:34:0x00ec, B:36:0x00fe, B:37:0x0102, B:38:0x010d, B:39:0x010e, B:65:0x0192, B:67:0x0196, B:69:0x019e, B:70:0x01b8, B:73:0x01c6, B:75:0x01ca, B:77:0x01ce, B:79:0x01d2, B:82:0x01d7, B:84:0x01db, B:86:0x01e3, B:87:0x01e9, B:88:0x01ea, B:90:0x01f2, B:91:0x020c), top: B:125:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0267  */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.camera.camera2.pipe.core.Debug] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1, types: [androidx.camera.camera2.pipe.core.Debug] */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v13 */
    /* JADX WARN: Type inference failed for: r25v14 */
    /* JADX WARN: Type inference failed for: r25v15 */
    /* JADX WARN: Type inference failed for: r25v16 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v18 */
    /* JADX WARN: Type inference failed for: r25v19 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6, types: [androidx.camera.camera2.pipe.core.Debug] */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean createExtensionSession(ExtensionSessionConfigData config) throws Throwable {
        String str;
        ?? r25;
        ?? r3;
        ?? r15;
        String str2;
        ?? r252;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        CameraErrorListener cameraErrorListener;
        ?? r253;
        boolean z;
        String str8;
        boolean z2;
        Unit unit;
        ?? r254;
        ?? r32;
        ?? r33 = "%.3f ms";
        Intrinsics.checkNotNullParameter(config, "config");
        CameraExtensionSessionWrapper.StateCallback extensionStateCallback = config.getExtensionStateCallback();
        if (extensionStateCallback == null) {
            throw new IllegalStateException("extensionStateCallback must be set to create Extension session".toString());
        }
        if (config.getExtensionMode() == null) {
            throw new IllegalStateException("extensionMode must be set to create Extension session".toString());
        }
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(extensionStateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        ?? r152 = Debug.INSTANCE;
        String str9 = "CXCP#createExtensionSession-" + getCameraId();
        long jMo880nowvQl9yQU = r152.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str9);
                String cameraId = getCameraId();
                CameraErrorListener cameraErrorListener2 = this.cameraErrorListener;
                try {
                    try {
                        int iIntValue = config.getExtensionMode().intValue();
                        List<OutputConfigurationWrapper> outputConfigurations = config.getOutputConfigurations();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(outputConfigurations, 10));
                        Iterator it = outputConfigurations.iterator();
                        while (it.hasNext()) {
                            arrayList.add((OutputConfiguration) ((OutputConfigurationWrapper) it.next()).unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class)));
                        }
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                        } catch (Exception e) {
                                            e = e;
                                            str5 = "format(...)";
                                            cameraErrorListener = cameraErrorListener2;
                                            r253 = r152;
                                            str8 = str9;
                                            str7 = cameraId;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        str5 = "format(...)";
                                        str7 = cameraId;
                                        cameraErrorListener = cameraErrorListener2;
                                        r253 = r152;
                                        str8 = str9;
                                    }
                                    try {
                                        str5 = "format(...)";
                                        r253 = r152;
                                        str8 = str9;
                                        str7 = cameraId;
                                        cameraErrorListener = cameraErrorListener2;
                                        str6 = "%.3f ms";
                                        z = true;
                                        r32 = 1;
                                    } catch (Exception e3) {
                                        e = e3;
                                        str5 = "format(...)";
                                        r253 = r152;
                                        str8 = str9;
                                        str7 = cameraId;
                                        cameraErrorListener = cameraErrorListener2;
                                        str6 = "%.3f ms";
                                        z = true;
                                        if (e instanceof CameraAccessException) {
                                            if (!(e instanceof IllegalArgumentException) && !(e instanceof SecurityException) && !(e instanceof UnsupportedOperationException) && !(e instanceof NullPointerException)) {
                                                if (!(e instanceof IllegalStateException)) {
                                                    throw e;
                                                }
                                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                                    android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                                }
                                            }
                                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                            }
                                            z2 = false;
                                            cameraErrorListener.mo790onCameraError3M5Xam4(str7, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                            unit = null;
                                            r32 = z;
                                            r254 = r253;
                                            Trace.endSection();
                                            long jM870constructorimpl = DurationNs.m870constructorimpl(r254.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            }
                                            if (unit == null) {
                                            }
                                            if (unit != null) {
                                            }
                                        } else {
                                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                                android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                            }
                                            cameraErrorListener.mo790onCameraError3M5Xam4(str7, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z);
                                        }
                                        z2 = false;
                                        unit = null;
                                        r32 = z;
                                        r254 = r253;
                                        Trace.endSection();
                                        long jM870constructorimpl2 = DurationNs.m870constructorimpl(r254.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        }
                                        if (unit == null) {
                                        }
                                        if (unit != null) {
                                        }
                                    }
                                    try {
                                        ExtensionSessionConfiguration extensionSessionConfigurationNewExtensionSessionConfiguration = Api31Compat.newExtensionSessionConfiguration(iIntValue, arrayList, config.getExecutor(), new AndroidExtensionSessionStateCallback(this, extensionStateCallback, sessionStateCallbackComponent2, this.cameraErrorListener, this.interopCaptureSessionListener, config.getExecutor()));
                                        if (config.getPostviewOutputConfiguration() != null && Build.VERSION.SDK_INT >= 34) {
                                            OutputConfiguration outputConfiguration = (OutputConfiguration) config.getPostviewOutputConfiguration().unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class));
                                            if (outputConfiguration == null) {
                                                throw new IllegalStateException("Failed to unwrap Postview OutputConfiguration".toString());
                                            }
                                            Api34Compat.setPostviewOutputConfiguration(extensionSessionConfigurationNewExtensionSessionConfiguration, outputConfiguration);
                                        }
                                        Api31Compat.createExtensionCaptureSession(this.cameraDevice, extensionSessionConfigurationNewExtensionSessionConfiguration);
                                        unit = Unit.INSTANCE;
                                        z2 = false;
                                        r254 = r253;
                                    } catch (Exception e4) {
                                        e = e4;
                                        if (e instanceof CameraAccessException) {
                                        }
                                        z2 = false;
                                        unit = null;
                                        r32 = z;
                                        r254 = r253;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    str4 = "format(...)";
                                    r252 = r152;
                                    r152 = str9;
                                    str3 = "%.3f ms";
                                    r33 = 1;
                                    str2 = str4;
                                    str = str3;
                                    r3 = r33;
                                    r15 = r152;
                                    r25 = r252;
                                    Trace.endSection();
                                    long jM870constructorimpl3 = DurationNs.m870constructorimpl(r25.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        StringBuilder sbAppend = new StringBuilder().append(r15).append(" - ");
                                        Timestamps timestamps = Timestamps.INSTANCE;
                                        String str10 = String.format(null, str, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl3 / 1000000.0d)}, (int) r3));
                                        Intrinsics.checkNotNullExpressionValue(str10, str2);
                                        android.util.Log.d(Log.TAG, sbAppend.append(str10).toString());
                                    }
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                str5 = "format(...)";
                                str6 = "%.3f ms";
                                str7 = cameraId;
                                cameraErrorListener = cameraErrorListener2;
                                r253 = r152;
                                z = true;
                                str8 = str9;
                            } catch (Throwable th2) {
                                th = th2;
                                str4 = "format(...)";
                                str3 = "%.3f ms";
                                r252 = r152;
                                r33 = 1;
                                r152 = str9;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str5 = "format(...)";
                            str6 = "%.3f ms";
                            str7 = cameraId;
                            cameraErrorListener = cameraErrorListener2;
                            r253 = r152;
                            z = true;
                            str8 = str9;
                        } catch (Throwable th3) {
                            th = th3;
                            str4 = "format(...)";
                            str3 = "%.3f ms";
                            r252 = r152;
                            r33 = 1;
                            r152 = str9;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str4 = "format(...)";
                        str3 = "%.3f ms";
                        r252 = r152;
                        r33 = 1;
                        r152 = str9;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str5 = "format(...)";
                    str6 = "%.3f ms";
                    str7 = cameraId;
                    cameraErrorListener = cameraErrorListener2;
                    r253 = r152;
                    z = true;
                    str8 = str9;
                }
                Trace.endSection();
                long jM870constructorimpl22 = DurationNs.m870constructorimpl(r254.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sbAppend2 = new StringBuilder().append(str8).append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str11 = String.format(null, str6, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl22 / 1000000.0d)}, (int) r32));
                    Intrinsics.checkNotNullExpressionValue(str11, str5);
                    android.util.Log.d(Log.TAG, sbAppend2.append(str11).toString());
                }
                if (unit == null) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to create extension session from " + this.cameraDevice + ". Finalizing previous session");
                    }
                    if (sessionStateCallbackComponent2 != null) {
                        onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                    }
                }
                return unit != null ? r32 : z2;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            str = "%.3f ms";
            r25 = r152;
            r3 = 1;
            r15 = str9;
            str2 = "format(...)";
            Trace.endSection();
            long jM870constructorimpl32 = DurationNs.m870constructorimpl(r25.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            }
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public CaptureRequest.Builder createReprocessCaptureRequest(TotalCaptureResult inputResult) throws Throwable {
        double d;
        String cameraId;
        CaptureRequest.Builder builderCreateReprocessCaptureRequest;
        Intrinsics.checkNotNullParameter(inputResult, "inputResult");
        Debug debug = Debug.INSTANCE;
        String str = "CXCP#createReprocessCaptureRequest-" + getCameraId();
        long jMo880nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            Trace.beginSection(str);
            cameraId = getCameraId();
            d = 1000000.0d;
        } catch (Throwable th) {
            th = th;
            d = 1000000.0d;
        }
        try {
            CameraErrorListener cameraErrorListener = this.cameraErrorListener;
            try {
                builderCreateReprocessCaptureRequest = this.cameraDevice.createReprocessCaptureRequest(inputResult);
            } catch (Exception e) {
                if (e instanceof CameraAccessException) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                    }
                    cameraErrorListener.mo790onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                } else if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                    }
                    cameraErrorListener.mo790onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                } else {
                    if (!(e instanceof IllegalStateException)) {
                        throw e;
                    }
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                    }
                }
                builderCreateReprocessCaptureRequest = null;
            }
            Trace.endSection();
            long jM870constructorimpl = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sbAppend = new StringBuilder().append(str).append(" - ");
                Timestamps timestamps = Timestamps.INSTANCE;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl / 1000000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                android.util.Log.d(Log.TAG, sbAppend.append(str2).toString());
            }
            return builderCreateReprocessCaptureRequest;
        } catch (Throwable th2) {
            th = th2;
            Trace.endSection();
            long jM870constructorimpl2 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sbAppend2 = new StringBuilder().append(str).append(" - ");
                Timestamps timestamps2 = Timestamps.INSTANCE;
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl2 / d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                android.util.Log.d(Log.TAG, sbAppend2.append(str3).toString());
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    /* JADX WARN: Type inference failed for: r12v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12, types: [boolean] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public boolean createReprocessableCaptureSession(InputConfiguration input, List<? extends Surface> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        String str;
        String str2;
        String str3;
        ?? r12;
        Locale locale;
        boolean z;
        String str4;
        String str5;
        String str6;
        boolean z2;
        String str7;
        boolean z3;
        Unit unit;
        ?? r122;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug = Debug.INSTANCE;
        String str8 = "CXCP#createReprocessableCaptureSession-" + getCameraId();
        long jMo880nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            Trace.beginSection(str8);
            String cameraId = getCameraId();
            CameraErrorListener cameraErrorListener = this.cameraErrorListener;
            try {
                try {
                    try {
                        str5 = "%.3f ms";
                        str4 = str8;
                        str7 = cameraId;
                        str6 = " - ";
                        z2 = true;
                        try {
                            try {
                                this.cameraDevice.createReprocessableCaptureSession(input, outputs, new AndroidCaptureSessionStateCallback(this, stateCallback, sessionStateCallbackComponent2, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads.getCamera2Handler()), this.threads.getCamera2Handler());
                                unit = Unit.INSTANCE;
                                z3 = false;
                                r122 = z2;
                            } catch (Exception e) {
                                e = e;
                                if (e instanceof CameraAccessException) {
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                    }
                                    cameraErrorListener.mo790onCameraError3M5Xam4(str7, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                                } else {
                                    if (!(e instanceof IllegalArgumentException) && !(e instanceof SecurityException) && !(e instanceof UnsupportedOperationException) && !(e instanceof NullPointerException)) {
                                        if (!(e instanceof IllegalStateException)) {
                                            throw e;
                                        }
                                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                            android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                        }
                                    }
                                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                        android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                    }
                                    z3 = false;
                                    cameraErrorListener.mo790onCameraError3M5Xam4(str7, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                    unit = null;
                                    r122 = z2;
                                }
                                z3 = false;
                                unit = null;
                                r122 = z2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            str = "format(...)";
                            str3 = str6;
                            str2 = str5;
                            str8 = str4;
                            z = z2;
                            locale = null;
                            r12 = z;
                            Trace.endSection();
                            long jM870constructorimpl = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                StringBuilder sbAppend = new StringBuilder().append(str8).append(str3);
                                Timestamps timestamps = Timestamps.INSTANCE;
                                String str9 = String.format(locale, str2, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl / 1000000.0d)}, (int) r12));
                                Intrinsics.checkNotNullExpressionValue(str9, str);
                                android.util.Log.d(Log.TAG, sbAppend.append(str9).toString());
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str5 = "%.3f ms";
                        str4 = str8;
                        str7 = cameraId;
                        str6 = " - ";
                        z2 = true;
                    } catch (Throwable th2) {
                        th = th2;
                        str5 = "%.3f ms";
                        str4 = str8;
                        str6 = " - ";
                        z2 = true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    str5 = "%.3f ms";
                    str4 = str8;
                    str7 = cameraId;
                    str6 = " - ";
                    z2 = true;
                } catch (Throwable th3) {
                    th = th3;
                    str5 = "%.3f ms";
                    str4 = str8;
                    str6 = " - ";
                    z2 = true;
                }
            } catch (Exception e4) {
                e = e4;
                str4 = str8;
                str5 = "%.3f ms";
                str6 = " - ";
                z2 = true;
                str7 = cameraId;
            } catch (Throwable th4) {
                th = th4;
                z = true;
                str = "format(...)";
                str3 = " - ";
                str2 = "%.3f ms";
            }
            Trace.endSection();
            long jM870constructorimpl2 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                StringBuilder sbAppend2 = new StringBuilder().append(str4).append(str6);
                Timestamps timestamps2 = Timestamps.INSTANCE;
                String str10 = String.format(null, str5, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl2 / 1000000.0d)}, (int) r122));
                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                android.util.Log.d(Log.TAG, sbAppend2.append(str10).toString());
            }
            if (unit == null) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to create reprocess session from " + this.cameraDevice + ". Finalizing previous session");
                }
                if (sessionStateCallbackComponent2 != null) {
                    onSessionFinalizedWithTrace(sessionStateCallbackComponent2);
                }
            }
            return unit != null ? r122 : z3;
        } catch (Throwable th5) {
            th = th5;
            str = "format(...)";
            str2 = "%.3f ms";
            str3 = " - ";
            r12 = 1;
            locale = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0132 A[Catch: all -> 0x0234, TryCatch #1 {all -> 0x0234, blocks: (B:37:0x012e, B:39:0x0132, B:41:0x013a, B:42:0x0154, B:45:0x0162, B:47:0x0166, B:49:0x016a, B:51:0x016e, B:54:0x0173, B:56:0x0177, B:58:0x017f, B:59:0x0185, B:60:0x0186, B:62:0x018e, B:63:0x01a8, B:23:0x00e5), top: B:88:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0162 A[Catch: all -> 0x0234, TryCatch #1 {all -> 0x0234, blocks: (B:37:0x012e, B:39:0x0132, B:41:0x013a, B:42:0x0154, B:45:0x0162, B:47:0x0166, B:49:0x016a, B:51:0x016e, B:54:0x0173, B:56:0x0177, B:58:0x017f, B:59:0x0185, B:60:0x0186, B:62:0x018e, B:63:0x01a8, B:23:0x00e5), top: B:88:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0256  */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [int] */
    /* JADX WARN: Type inference failed for: r13v2, types: [boolean] */
    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean createReprocessableCaptureSessionByConfigurations(InputConfigData inputConfig, List<? extends OutputConfigurationWrapper> outputs, CameraCaptureSessionWrapper.StateCallback stateCallback) throws Throwable {
        String str;
        String str2;
        Debug debug;
        ?? r10;
        SessionStateCallback sessionStateCallback;
        CameraErrorListener cameraErrorListener;
        String str3;
        String str4;
        Debug debug2;
        ?? r102;
        Unit unit;
        boolean z;
        String str5;
        boolean z2;
        SessionStateCallback sessionStateCallback2;
        ?? r103 = "%.3f ms";
        Intrinsics.checkNotNullParameter(inputConfig, "inputConfig");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(stateCallback, "stateCallback");
        Pair<Boolean, SessionStateCallback> pairCheckAndSetStateCallback = checkAndSetStateCallback(stateCallback);
        boolean zBooleanValue = pairCheckAndSetStateCallback.component1().booleanValue();
        SessionStateCallback sessionStateCallbackComponent2 = pairCheckAndSetStateCallback.component2();
        if (!zBooleanValue) {
            return false;
        }
        if (sessionStateCallbackComponent2 != null) {
            onSessionDisconnectedWithTrace(sessionStateCallbackComponent2);
        }
        Debug debug3 = Debug.INSTANCE;
        String str6 = "CXCP#createReprocessableCaptureSessionByConfigurations-" + getCameraId();
        long jMo880nowvQl9yQU = debug3.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
        try {
            try {
                Trace.beginSection(str6);
                String cameraId = getCameraId();
                CameraErrorListener cameraErrorListener2 = this.cameraErrorListener;
                try {
                    try {
                        CameraDevice cameraDevice = this.cameraDevice;
                        InputConfiguration inputConfiguration = new InputConfiguration(inputConfig.getWidth(), inputConfig.getHeight(), inputConfig.getFormat());
                        List<? extends OutputConfigurationWrapper> list = outputs;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            try {
                                sessionStateCallback2 = sessionStateCallbackComponent2;
                                try {
                                    arrayList.add((OutputConfiguration) ((OutputConfigurationWrapper) it.next()).unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class)));
                                    sessionStateCallbackComponent2 = sessionStateCallback2;
                                } catch (Exception e) {
                                    e = e;
                                    cameraErrorListener = cameraErrorListener2;
                                    str3 = "format(...)";
                                    str4 = "%.3f ms";
                                    debug2 = debug3;
                                    sessionStateCallback = sessionStateCallback2;
                                    z2 = true;
                                    str5 = cameraId;
                                    if (e instanceof CameraAccessException) {
                                    }
                                    z = false;
                                    unit = null;
                                    r102 = z2;
                                    Trace.endSection();
                                    long jM870constructorimpl = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    }
                                    if (unit == null) {
                                    }
                                    if (unit != null) {
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                sessionStateCallback2 = sessionStateCallbackComponent2;
                                cameraErrorListener = cameraErrorListener2;
                                str3 = "format(...)";
                                str4 = "%.3f ms";
                                debug2 = debug3;
                                sessionStateCallback = sessionStateCallback2;
                                z2 = true;
                                str5 = cameraId;
                                if (e instanceof CameraAccessException) {
                                }
                                z = false;
                                unit = null;
                                r102 = z2;
                                Trace.endSection();
                                long jM870constructorimpl2 = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                }
                                if (unit == null) {
                                }
                                if (unit != null) {
                                }
                            }
                        }
                        sessionStateCallback2 = sessionStateCallbackComponent2;
                        ArrayList arrayList2 = arrayList;
                        try {
                            cameraErrorListener = cameraErrorListener2;
                            str3 = "format(...)";
                            debug2 = debug3;
                            str5 = cameraId;
                            str4 = "%.3f ms";
                            sessionStateCallback = sessionStateCallback2;
                            z2 = true;
                            r102 = 1;
                        } catch (Exception e3) {
                            e = e3;
                            cameraErrorListener = cameraErrorListener2;
                            str3 = "format(...)";
                            debug2 = debug3;
                            str5 = cameraId;
                            sessionStateCallback = sessionStateCallback2;
                            str4 = "%.3f ms";
                            z2 = true;
                        }
                        try {
                            Api24Compat.createReprocessableCaptureSessionByConfigurations(cameraDevice, inputConfiguration, arrayList2, new AndroidCaptureSessionStateCallback(this, stateCallback, sessionStateCallback, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads.getCamera2Handler()), this.threads.getCamera2Handler());
                            unit = Unit.INSTANCE;
                            z = false;
                        } catch (Exception e4) {
                            e = e4;
                            if (e instanceof CameraAccessException) {
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                                }
                                cameraErrorListener.mo790onCameraError3M5Xam4(str5, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), z2);
                            } else {
                                if (!(e instanceof IllegalArgumentException) && !(e instanceof SecurityException) && !(e instanceof UnsupportedOperationException) && !(e instanceof NullPointerException)) {
                                    if (!(e instanceof IllegalStateException)) {
                                        throw e;
                                    }
                                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                        android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                                    }
                                }
                                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                    android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                                }
                                z = false;
                                cameraErrorListener.mo790onCameraError3M5Xam4(str5, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                                unit = null;
                                r102 = z2;
                            }
                            z = false;
                            unit = null;
                            r102 = z2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        debug = debug3;
                        r103 = 1;
                        str = "format(...)";
                        str2 = "%.3f ms";
                        r10 = r103;
                        Trace.endSection();
                        long jM870constructorimpl3 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            StringBuilder sbAppend = new StringBuilder().append(str6).append(" - ");
                            Timestamps timestamps = Timestamps.INSTANCE;
                            String str7 = String.format(null, str2, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl3 / 1000000.0d)}, (int) r10));
                            Intrinsics.checkNotNullExpressionValue(str7, str);
                            android.util.Log.d(Log.TAG, sbAppend.append(str7).toString());
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    sessionStateCallback = sessionStateCallbackComponent2;
                    cameraErrorListener = cameraErrorListener2;
                    str3 = "format(...)";
                    str4 = "%.3f ms";
                    debug2 = debug3;
                }
                Trace.endSection();
                long jM870constructorimpl22 = DurationNs.m870constructorimpl(debug2.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sbAppend2 = new StringBuilder().append(str6).append(" - ");
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    String str8 = String.format(null, str4, Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl22 / 1000000.0d)}, (int) r102));
                    Intrinsics.checkNotNullExpressionValue(str8, str3);
                    android.util.Log.d(Log.TAG, sbAppend2.append(str8).toString());
                }
                if (unit == null) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to create reprocess session from " + this.cameraDevice + ". Finalizing previous session");
                    }
                    if (sessionStateCallback != null) {
                        onSessionFinalizedWithTrace(sessionStateCallback);
                    }
                }
                return unit != null ? r102 : z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            str = "format(...)";
            str2 = "%.3f ms";
            debug = debug3;
            r10 = 1;
            Trace.endSection();
            long jM870constructorimpl32 = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            }
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /* JADX INFO: renamed from: getCameraAudioRestriction-_b5Q8KE, reason: not valid java name */
    public int mo754getCameraAudioRestriction_b5Q8KE() {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("getCameraAudioRestriction");
            return AudioRestrictionMode.m168constructorimpl(Api30Compat.getCameraAudioRestriction(this.cameraDevice));
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    /* JADX INFO: renamed from: getCameraId-Dz_R5H8, reason: not valid java name and from getter */
    public String getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.camera2.pipe.compat.AudioRestrictionController.Listener
    /* JADX INFO: renamed from: onCameraAudioRestrictionUpdated-LwUUkyU, reason: not valid java name */
    public void mo756onCameraAudioRestrictionUpdatedLwUUkyU(int mode) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("setCameraAudioRestriction");
            String cameraId = getCameraId();
            CameraErrorListener cameraErrorListener = this.cameraErrorListener;
            try {
                Api30Compat.setCameraAudioRestriction(this.cameraDevice, mode);
                Unit unit = Unit.INSTANCE;
            } catch (Exception e) {
                if (e instanceof CameraAccessException) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to execute call: Camera encountered an error: " + e.getMessage());
                    }
                    cameraErrorListener.mo790onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) e), true);
                } else if ((e instanceof IllegalArgumentException) || (e instanceof SecurityException) || (e instanceof UnsupportedOperationException) || (e instanceof NullPointerException)) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to execute call: Unexpected exception: " + e.getMessage());
                    }
                    cameraErrorListener.mo790onCameraError3M5Xam4(cameraId, CameraError.INSTANCE.m324getERROR_GRAPH_CONFIGv7Vf74A(), false);
                } else {
                    if (!(e instanceof IllegalStateException)) {
                        throw e;
                    }
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Failed to execute call: Camera may be closed");
                    }
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public void onDeviceClosed() {
        if (!this.closed.getValue()) {
            throw new IllegalStateException("Check failed.");
        }
        SessionStateCallback andSet = this._lastStateCallback.getAndSet(null);
        if (andSet != null) {
            onSessionFinalizedWithTrace(andSet);
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraDeviceWrapper
    public void onDeviceClosing() {
        SessionStateCallback value;
        if (!this.closed.compareAndSet(false, true) || (value = this._lastStateCallback.getValue()) == null) {
            return;
        }
        onSessionDisconnectedWithTrace(value);
    }

    public String toString() {
        return "AndroidCameraDevice(camera=" + ((Object) CameraId.m385toStringimpl(getCameraId())) + ')';
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraDevice.class))) {
            return null;
        }
        Object obj = this.cameraDevice;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.AndroidCameraDevice.unwrapAs");
        return (T) obj;
    }
}
