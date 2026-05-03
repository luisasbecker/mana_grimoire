package androidx.camera.camera2.pipe;

import android.hardware.camera2.CameraAccessException;
import android.os.Build;
import androidx.camera.camera2.pipe.core.Log;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraError.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/CameraError;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "isDisconnected", "", "isDisconnected-impl", "(I)Z", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class CameraError {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ERROR_UNDETERMINED = m305constructorimpl(0);
    private static final int ERROR_CAMERA_IN_USE = m305constructorimpl(1);
    private static final int ERROR_CAMERA_LIMIT_EXCEEDED = m305constructorimpl(2);
    private static final int ERROR_CAMERA_DISABLED = m305constructorimpl(3);
    private static final int ERROR_CAMERA_DEVICE = m305constructorimpl(4);
    private static final int ERROR_CAMERA_SERVICE = m305constructorimpl(5);
    private static final int ERROR_CAMERA_DISCONNECTED = m305constructorimpl(6);
    private static final int ERROR_ILLEGAL_ARGUMENT_EXCEPTION = m305constructorimpl(7);
    private static final int ERROR_SECURITY_EXCEPTION = m305constructorimpl(8);
    private static final int ERROR_GRAPH_CONFIG = m305constructorimpl(9);
    private static final int ERROR_DO_NOT_DISTURB_ENABLED = m305constructorimpl(10);
    private static final int ERROR_UNKNOWN_EXCEPTION = m305constructorimpl(11);
    private static final int ERROR_CAMERA_OPENER = m305constructorimpl(12);
    private static final int ERROR_CAMERA_OPEN_TIMEOUT = m305constructorimpl(13);

    /* JADX INFO: compiled from: CameraError.kt */
    @kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0004\b&\u0010'J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0004\b&\u0010*J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0004\b&\u0010-J\u0015\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b0J\u0010\u00101\u001a\u00020/2\u0006\u0010$\u001a\u00020%H\u0002R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\u0013\u0010!\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\"\u0010\u0007¨\u00062"}, d2 = {"Landroidx/camera/camera2/pipe/CameraError$Companion;", "", "<init>", "()V", "ERROR_UNDETERMINED", "Landroidx/camera/camera2/pipe/CameraError;", "getERROR_UNDETERMINED-v7Vf74A", "()I", "I", "ERROR_CAMERA_IN_USE", "getERROR_CAMERA_IN_USE-v7Vf74A", "ERROR_CAMERA_LIMIT_EXCEEDED", "getERROR_CAMERA_LIMIT_EXCEEDED-v7Vf74A", "ERROR_CAMERA_DISABLED", "getERROR_CAMERA_DISABLED-v7Vf74A", "ERROR_CAMERA_DEVICE", "getERROR_CAMERA_DEVICE-v7Vf74A", "ERROR_CAMERA_SERVICE", "getERROR_CAMERA_SERVICE-v7Vf74A", "ERROR_CAMERA_DISCONNECTED", "getERROR_CAMERA_DISCONNECTED-v7Vf74A", "ERROR_ILLEGAL_ARGUMENT_EXCEPTION", "getERROR_ILLEGAL_ARGUMENT_EXCEPTION-v7Vf74A", "ERROR_SECURITY_EXCEPTION", "getERROR_SECURITY_EXCEPTION-v7Vf74A", "ERROR_GRAPH_CONFIG", "getERROR_GRAPH_CONFIG-v7Vf74A", "ERROR_DO_NOT_DISTURB_ENABLED", "getERROR_DO_NOT_DISTURB_ENABLED-v7Vf74A", "ERROR_UNKNOWN_EXCEPTION", "getERROR_UNKNOWN_EXCEPTION-v7Vf74A", "ERROR_CAMERA_OPENER", "getERROR_CAMERA_OPENER-v7Vf74A", "ERROR_CAMERA_OPEN_TIMEOUT", "getERROR_CAMERA_OPEN_TIMEOUT-v7Vf74A", "from", "throwable", "", "from-PVuDhNw$camera_camera2_pipe", "(Ljava/lang/Throwable;)I", "exception", "Landroid/hardware/camera2/CameraAccessException;", "(Landroid/hardware/camera2/CameraAccessException;)I", "stateCallbackError", "", "(I)I", "shouldHandleDoNotDisturbException", "", "shouldHandleDoNotDisturbException$camera_camera2_pipe", "isDoNotDisturbException", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isDoNotDisturbException(Throwable throwable) {
            if (!(throwable instanceof RuntimeException)) {
                return false;
            }
            StackTraceElement[] stackTrace = ((RuntimeException) throwable).getStackTrace();
            Intrinsics.checkNotNull(stackTrace);
            return Intrinsics.areEqual(!(stackTrace.length == 0) ? stackTrace[0].getMethodName() : null, "_enableShutterSound");
        }

        /* JADX INFO: renamed from: from-PVuDhNw$camera_camera2_pipe, reason: not valid java name */
        public final int m312fromPVuDhNw$camera_camera2_pipe(int stateCallbackError) {
            if (stateCallbackError == 1) {
                return m318getERROR_CAMERA_IN_USEv7Vf74A();
            }
            if (stateCallbackError == 2) {
                return m319getERROR_CAMERA_LIMIT_EXCEEDEDv7Vf74A();
            }
            if (stateCallbackError == 3) {
                return m316getERROR_CAMERA_DISABLEDv7Vf74A();
            }
            if (stateCallbackError == 4) {
                return m315getERROR_CAMERA_DEVICEv7Vf74A();
            }
            if (stateCallbackError == 5) {
                return m322getERROR_CAMERA_SERVICEv7Vf74A();
            }
            throw new IllegalArgumentException("Unexpected StateCallback error code: " + stateCallbackError);
        }

        /* JADX INFO: renamed from: from-PVuDhNw$camera_camera2_pipe, reason: not valid java name */
        public final int m313fromPVuDhNw$camera_camera2_pipe(CameraAccessException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            int reason = exception.getReason();
            if (reason == 1) {
                return m316getERROR_CAMERA_DISABLEDv7Vf74A();
            }
            if (reason == 2) {
                return m317getERROR_CAMERA_DISCONNECTEDv7Vf74A();
            }
            if (reason == 3) {
                return m327getERROR_UNDETERMINEDv7Vf74A();
            }
            if (reason == 4) {
                return m318getERROR_CAMERA_IN_USEv7Vf74A();
            }
            if (reason == 5) {
                return m319getERROR_CAMERA_LIMIT_EXCEEDEDv7Vf74A();
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Unexpected CameraAccessException: " + exception);
            }
            return m328getERROR_UNKNOWN_EXCEPTIONv7Vf74A();
        }

        /* JADX INFO: renamed from: from-PVuDhNw$camera_camera2_pipe, reason: not valid java name */
        public final int m314fromPVuDhNw$camera_camera2_pipe(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            if (throwable instanceof CameraAccessException) {
                return m313fromPVuDhNw$camera_camera2_pipe((CameraAccessException) throwable);
            }
            if (throwable instanceof IllegalArgumentException) {
                return m325getERROR_ILLEGAL_ARGUMENT_EXCEPTIONv7Vf74A();
            }
            if (throwable instanceof SecurityException) {
                return m326getERROR_SECURITY_EXCEPTIONv7Vf74A();
            }
            if (shouldHandleDoNotDisturbException$camera_camera2_pipe(throwable)) {
                return m323getERROR_DO_NOT_DISTURB_ENABLEDv7Vf74A();
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Unexpected throwable: " + throwable);
            }
            return m328getERROR_UNKNOWN_EXCEPTIONv7Vf74A();
        }

        /* JADX INFO: renamed from: getERROR_CAMERA_DEVICE-v7Vf74A, reason: not valid java name */
        public final int m315getERROR_CAMERA_DEVICEv7Vf74A() {
            return CameraError.ERROR_CAMERA_DEVICE;
        }

        /* JADX INFO: renamed from: getERROR_CAMERA_DISABLED-v7Vf74A, reason: not valid java name */
        public final int m316getERROR_CAMERA_DISABLEDv7Vf74A() {
            return CameraError.ERROR_CAMERA_DISABLED;
        }

        /* JADX INFO: renamed from: getERROR_CAMERA_DISCONNECTED-v7Vf74A, reason: not valid java name */
        public final int m317getERROR_CAMERA_DISCONNECTEDv7Vf74A() {
            return CameraError.ERROR_CAMERA_DISCONNECTED;
        }

        /* JADX INFO: renamed from: getERROR_CAMERA_IN_USE-v7Vf74A, reason: not valid java name */
        public final int m318getERROR_CAMERA_IN_USEv7Vf74A() {
            return CameraError.ERROR_CAMERA_IN_USE;
        }

        /* JADX INFO: renamed from: getERROR_CAMERA_LIMIT_EXCEEDED-v7Vf74A, reason: not valid java name */
        public final int m319getERROR_CAMERA_LIMIT_EXCEEDEDv7Vf74A() {
            return CameraError.ERROR_CAMERA_LIMIT_EXCEEDED;
        }

        /* JADX INFO: renamed from: getERROR_CAMERA_OPENER-v7Vf74A, reason: not valid java name */
        public final int m320getERROR_CAMERA_OPENERv7Vf74A() {
            return CameraError.ERROR_CAMERA_OPENER;
        }

        /* JADX INFO: renamed from: getERROR_CAMERA_OPEN_TIMEOUT-v7Vf74A, reason: not valid java name */
        public final int m321getERROR_CAMERA_OPEN_TIMEOUTv7Vf74A() {
            return CameraError.ERROR_CAMERA_OPEN_TIMEOUT;
        }

        /* JADX INFO: renamed from: getERROR_CAMERA_SERVICE-v7Vf74A, reason: not valid java name */
        public final int m322getERROR_CAMERA_SERVICEv7Vf74A() {
            return CameraError.ERROR_CAMERA_SERVICE;
        }

        /* JADX INFO: renamed from: getERROR_DO_NOT_DISTURB_ENABLED-v7Vf74A, reason: not valid java name */
        public final int m323getERROR_DO_NOT_DISTURB_ENABLEDv7Vf74A() {
            return CameraError.ERROR_DO_NOT_DISTURB_ENABLED;
        }

        /* JADX INFO: renamed from: getERROR_GRAPH_CONFIG-v7Vf74A, reason: not valid java name */
        public final int m324getERROR_GRAPH_CONFIGv7Vf74A() {
            return CameraError.ERROR_GRAPH_CONFIG;
        }

        /* JADX INFO: renamed from: getERROR_ILLEGAL_ARGUMENT_EXCEPTION-v7Vf74A, reason: not valid java name */
        public final int m325getERROR_ILLEGAL_ARGUMENT_EXCEPTIONv7Vf74A() {
            return CameraError.ERROR_ILLEGAL_ARGUMENT_EXCEPTION;
        }

        /* JADX INFO: renamed from: getERROR_SECURITY_EXCEPTION-v7Vf74A, reason: not valid java name */
        public final int m326getERROR_SECURITY_EXCEPTIONv7Vf74A() {
            return CameraError.ERROR_SECURITY_EXCEPTION;
        }

        /* JADX INFO: renamed from: getERROR_UNDETERMINED-v7Vf74A, reason: not valid java name */
        public final int m327getERROR_UNDETERMINEDv7Vf74A() {
            return CameraError.ERROR_UNDETERMINED;
        }

        /* JADX INFO: renamed from: getERROR_UNKNOWN_EXCEPTION-v7Vf74A, reason: not valid java name */
        public final int m328getERROR_UNKNOWN_EXCEPTIONv7Vf74A() {
            return CameraError.ERROR_UNKNOWN_EXCEPTION;
        }

        public final boolean shouldHandleDoNotDisturbException$camera_camera2_pipe(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return Build.VERSION.SDK_INT == 28 && isDoNotDisturbException(throwable);
        }
    }

    private /* synthetic */ CameraError(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CameraError m304boximpl(int i) {
        return new CameraError(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m305constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m306equalsimpl(int i, Object obj) {
        return (obj instanceof CameraError) && i == ((CameraError) obj).m311unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m307equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m308hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: isDisconnected-impl, reason: not valid java name */
    public static final boolean m309isDisconnectedimpl(int i) {
        return m307equalsimpl0(i, ERROR_CAMERA_DISCONNECTED) || m307equalsimpl0(i, ERROR_CAMERA_IN_USE) || m307equalsimpl0(i, ERROR_CAMERA_LIMIT_EXCEEDED);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m310toStringimpl(int i) {
        return "CameraError(" + (m307equalsimpl0(i, ERROR_UNDETERMINED) ? "ERROR_UNDETERMINED" : m307equalsimpl0(i, ERROR_CAMERA_IN_USE) ? "ERROR_CAMERA_IN_USE" : m307equalsimpl0(i, ERROR_CAMERA_LIMIT_EXCEEDED) ? "ERROR_CAMERA_LIMIT_EXCEEDED" : m307equalsimpl0(i, ERROR_CAMERA_DISABLED) ? "ERROR_CAMERA_DISABLED" : m307equalsimpl0(i, ERROR_CAMERA_DEVICE) ? "ERROR_CAMERA_DEVICE" : m307equalsimpl0(i, ERROR_CAMERA_SERVICE) ? "ERROR_CAMERA_SERVICE" : m307equalsimpl0(i, ERROR_CAMERA_DISCONNECTED) ? "ERROR_CAMERA_DISCONNECTED" : m307equalsimpl0(i, ERROR_ILLEGAL_ARGUMENT_EXCEPTION) ? "ERROR_ILLEGAL_ARGUMENT_EXCEPTION" : m307equalsimpl0(i, ERROR_SECURITY_EXCEPTION) ? "ERROR_SECURITY_EXCEPTION" : m307equalsimpl0(i, ERROR_GRAPH_CONFIG) ? "ERROR_GRAPH_CONFIG" : m307equalsimpl0(i, ERROR_DO_NOT_DISTURB_ENABLED) ? "ERROR_DO_NOT_DISTURB_ENABLED" : m307equalsimpl0(i, ERROR_UNKNOWN_EXCEPTION) ? "ERROR_UNKNOWN_EXCEPTION" : m307equalsimpl0(i, ERROR_CAMERA_OPENER) ? "ERROR_CAMERA_OPENER" : m307equalsimpl0(i, ERROR_CAMERA_OPEN_TIMEOUT) ? "ERROR_CAMERA_OPEN_TIMEOUT" : "ERROR_UNKNOWN") + ')';
    }

    public boolean equals(Object obj) {
        return m306equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m308hashCodeimpl(this.value);
    }

    public String toString() {
        return m310toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m311unboximpl() {
        return this.value;
    }
}
