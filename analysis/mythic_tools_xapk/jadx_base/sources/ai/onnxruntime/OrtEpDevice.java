package ai.onnxruntime;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class OrtEpDevice {
    private final OrtHardwareDevice device;
    private final Map<String, String> epMetadata;
    private final String epName;
    private final Map<String, String> epOptions;
    private final String epVendor;
    private final long nativeHandle;

    OrtEpDevice(long j) {
        this.nativeHandle = j;
        this.epName = getEpName(OnnxRuntime.ortApiHandle, j);
        this.epVendor = getEpVendor(OnnxRuntime.ortApiHandle, j);
        this.epMetadata = OrtUtil.convertToMap(getEpMetadata(OnnxRuntime.ortApiHandle, j));
        this.epOptions = OrtUtil.convertToMap(getEpOptions(OnnxRuntime.ortApiHandle, j));
        this.device = new OrtHardwareDevice(getDeviceHandle(OnnxRuntime.ortApiHandle, j));
    }

    private static native long getDeviceHandle(long j, long j2);

    private static native String[][] getEpMetadata(long j, long j2);

    private static native String getEpName(long j, long j2);

    private static native String[][] getEpOptions(long j, long j2);

    private static native String getEpVendor(long j, long j2);

    public OrtHardwareDevice getDevice() {
        return this.device;
    }

    public Map<String, String> getEpMetadata() {
        return this.epMetadata;
    }

    public String getEpName() {
        return this.epName;
    }

    public Map<String, String> getEpOptions() {
        return this.epOptions;
    }

    public String getEpVendor() {
        return this.epVendor;
    }

    long getNativeHandle() {
        return this.nativeHandle;
    }

    public String toString() {
        return "OrtEpDevice{epName='" + this.epName + "', epVendor='" + this.epVendor + "', epMetadata=" + this.epMetadata + ", epOptions=" + this.epOptions + ", device=" + this.device + AbstractJsonLexerKt.END_OBJ;
    }
}
