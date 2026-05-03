package ai.onnxruntime;

import java.util.Map;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class OrtHardwareDevice {
    private final int deviceId;
    private final Map<String, String> metadata;
    private final long nativeHandle;
    private final OrtHardwareDeviceType type;
    private final String vendor;
    private final int vendorId;

    public enum OrtHardwareDeviceType {
        CPU(0),
        GPU(1),
        NPU(2);

        private static final Logger logger = Logger.getLogger(OrtHardwareDeviceType.class.getName());
        private static final OrtHardwareDeviceType[] values = new OrtHardwareDeviceType[3];
        private final int value;

        static {
            for (OrtHardwareDeviceType ortHardwareDeviceType : values()) {
                values[ortHardwareDeviceType.value] = ortHardwareDeviceType;
            }
        }

        OrtHardwareDeviceType(int i) {
            this.value = i;
        }

        public static OrtHardwareDeviceType mapFromInt(int i) {
            if (i >= 0) {
                OrtHardwareDeviceType[] ortHardwareDeviceTypeArr = values;
                if (i < ortHardwareDeviceTypeArr.length) {
                    return ortHardwareDeviceTypeArr[i];
                }
            }
            logger.warning("Unknown device type '" + i + "' setting to CPU");
            return CPU;
        }

        public int getValue() {
            return this.value;
        }
    }

    OrtHardwareDevice(long j) {
        this.nativeHandle = j;
        this.type = OrtHardwareDeviceType.mapFromInt(getDeviceType(OnnxRuntime.ortApiHandle, j));
        this.vendorId = getVendorId(OnnxRuntime.ortApiHandle, j);
        this.vendor = getVendor(OnnxRuntime.ortApiHandle, j);
        this.deviceId = getDeviceId(OnnxRuntime.ortApiHandle, j);
        this.metadata = OrtUtil.convertToMap(getMetadata(OnnxRuntime.ortApiHandle, j));
    }

    private static native int getDeviceId(long j, long j2);

    private static native int getDeviceType(long j, long j2);

    private static native String[][] getMetadata(long j, long j2);

    private static native String getVendor(long j, long j2);

    private static native int getVendorId(long j, long j2);

    public int getDeviceId() {
        return this.deviceId;
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    long getNativeHandle() {
        return this.nativeHandle;
    }

    public OrtHardwareDeviceType getType() {
        return this.type;
    }

    public String getVendor() {
        return this.vendor;
    }

    public int getVendorId() {
        return this.vendorId;
    }

    public String toString() {
        return "OrtHardwareDevice{type=" + this.type + ", vendorId=" + this.vendorId + ", vendor='" + this.vendor + "', deviceId=" + this.deviceId + ", metadata=" + this.metadata + AbstractJsonLexerKt.END_OBJ;
    }
}
