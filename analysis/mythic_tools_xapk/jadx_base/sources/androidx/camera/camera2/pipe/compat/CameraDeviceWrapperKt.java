package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraDevice;
import android.os.Trace;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Timestamps;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraDeviceWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0003"}, d2 = {"closeWithTrace", "", "Landroid/hardware/camera2/CameraDevice;", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CameraDeviceWrapperKt {
    public static final void closeWithTrace(CameraDevice cameraDevice) {
        if (cameraDevice != null) {
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "Closing Camera " + cameraDevice.getId());
            }
            Debug debug = Debug.INSTANCE;
            String str = "CXCP#CameraDevice-" + cameraDevice.getId() + "#close";
            long jMo880nowvQl9yQU = debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU();
            try {
                Trace.beginSection(str);
                try {
                    cameraDevice.close();
                } catch (NullPointerException e) {
                    NullPointerException nullPointerException = e;
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "NPE encountered during CameraDevice.close()", nullPointerException);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.endSection();
                long jM870constructorimpl = DurationNs.m870constructorimpl(debug.getSystemTimeSource$camera_camera2_pipe().mo880nowvQl9yQU() - jMo880nowvQl9yQU);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sbAppend = new StringBuilder().append(str).append(" - ");
                    Timestamps timestamps = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM870constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    android.util.Log.d(Log.TAG, sbAppend.append(str2).toString());
                }
            }
        }
    }
}
