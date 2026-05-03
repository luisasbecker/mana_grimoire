package ai.onnxruntime;

import ai.onnxruntime.OnnxValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class OnnxMap implements OnnxValue {
    private static final Logger logger = Logger.getLogger(OnnxMap.class.getName());
    final long allocatorHandle;
    private boolean closed;
    private final MapInfo info;
    final long nativeHandle;
    private final boolean stringKeys;
    private final OnnxMapValueType valueType;

    /* JADX INFO: renamed from: ai.onnxruntime.OnnxMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ai$onnxruntime$OnnxJavaType;
        static final /* synthetic */ int[] $SwitchMap$ai$onnxruntime$OnnxMap$OnnxMapValueType;

        static {
            int[] iArr = new int[OnnxMapValueType.values().length];
            $SwitchMap$ai$onnxruntime$OnnxMap$OnnxMapValueType = iArr;
            try {
                iArr[OnnxMapValueType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxMap$OnnxMapValueType[OnnxMapValueType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxMap$OnnxMapValueType[OnnxMapValueType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxMap$OnnxMapValueType[OnnxMapValueType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OnnxJavaType.values().length];
            $SwitchMap$ai$onnxruntime$OnnxJavaType = iArr2;
            try {
                iArr2[OnnxJavaType.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UINT8.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT8.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT16.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BOOL.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UNKNOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public enum OnnxMapValueType {
        INVALID(0),
        STRING(1),
        LONG(2),
        FLOAT(3),
        DOUBLE(4);

        private static final OnnxMapValueType[] values = new OnnxMapValueType[5];
        final int value;

        static {
            for (OnnxMapValueType onnxMapValueType : values()) {
                values[onnxMapValueType.value] = onnxMapValueType;
            }
        }

        OnnxMapValueType(int i) {
            this.value = i;
        }

        public static OnnxMapValueType mapFromInt(int i) {
            if (i > 0) {
                OnnxMapValueType[] onnxMapValueTypeArr = values;
                if (i < onnxMapValueTypeArr.length) {
                    return onnxMapValueTypeArr[i];
                }
            }
            return INVALID;
        }

        public static OnnxMapValueType mapFromOnnxJavaType(OnnxJavaType onnxJavaType) {
            int i = AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[onnxJavaType.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? INVALID : STRING : LONG : DOUBLE : FLOAT;
        }
    }

    static {
        try {
            OnnxRuntime.init();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load onnx-runtime library", e);
        }
    }

    OnnxMap(long j, long j2, MapInfo mapInfo) {
        this.nativeHandle = j;
        this.allocatorHandle = j2;
        this.info = mapInfo;
        this.stringKeys = mapInfo.keyType == OnnxJavaType.STRING;
        this.valueType = OnnxMapValueType.mapFromOnnxJavaType(mapInfo.valueType);
        this.closed = false;
    }

    private native void close(long j, long j2);

    private native double[] getDoubleValues(long j, long j2, long j3) throws OrtException;

    private native float[] getFloatValues(long j, long j2, long j3) throws OrtException;

    private native long[] getLongKeys(long j, long j2, long j3) throws OrtException;

    private native long[] getLongValues(long j, long j2, long j3) throws OrtException;

    private Object[] getMapKeys() throws OrtException {
        return this.stringKeys ? getStringKeys(OnnxRuntime.ortApiHandle, this.nativeHandle, this.allocatorHandle) : Arrays.stream(getLongKeys(OnnxRuntime.ortApiHandle, this.nativeHandle, this.allocatorHandle)).boxed().toArray();
    }

    private Object[] getMapValues() throws OrtException {
        int i = AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxMap$OnnxMapValueType[this.valueType.ordinal()];
        if (i == 1) {
            return getStringValues(OnnxRuntime.ortApiHandle, this.nativeHandle, this.allocatorHandle);
        }
        if (i == 2) {
            return Arrays.stream(getLongValues(OnnxRuntime.ortApiHandle, this.nativeHandle, this.allocatorHandle)).boxed().toArray();
        }
        if (i != 3) {
            if (i == 4) {
                return Arrays.stream(getDoubleValues(OnnxRuntime.ortApiHandle, this.nativeHandle, this.allocatorHandle)).boxed().toArray();
            }
            throw new RuntimeException("Invalid or unknown valueType: " + this.valueType);
        }
        float[] floatValues = getFloatValues(OnnxRuntime.ortApiHandle, this.nativeHandle, this.allocatorHandle);
        Float[] fArr = new Float[floatValues.length];
        for (int i2 = 0; i2 < floatValues.length; i2++) {
            fArr[i2] = Float.valueOf(floatValues[i2]);
        }
        return fArr;
    }

    private native String[] getStringKeys(long j, long j2, long j3) throws OrtException;

    private native String[] getStringValues(long j, long j2, long j3) throws OrtException;

    protected void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("Trying to use a closed OnnxValue");
        }
    }

    @Override // ai.onnxruntime.OnnxValue, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.closed) {
            logger.warning("Closing an already closed map.");
        } else {
            close(OnnxRuntime.ortApiHandle, this.nativeHandle);
            this.closed = true;
        }
    }

    @Override // ai.onnxruntime.OnnxValue
    public MapInfo getInfo() {
        return this.info;
    }

    @Override // ai.onnxruntime.OnnxValue
    public OnnxValue.OnnxValueType getType() {
        return OnnxValue.OnnxValueType.ONNX_TYPE_MAP;
    }

    @Override // ai.onnxruntime.OnnxValue
    public Map<? extends Object, ? extends Object> getValue() throws OrtException {
        checkClosed();
        Object[] mapKeys = getMapKeys();
        Object[] mapValues = getMapValues();
        HashMap map = new HashMap(OrtUtil.capacityFromSize(mapKeys.length));
        for (int i = 0; i < mapKeys.length; i++) {
            map.put(mapKeys[i], mapValues[i]);
        }
        return map;
    }

    @Override // ai.onnxruntime.OnnxValue
    public synchronized boolean isClosed() {
        return this.closed;
    }

    public int size() {
        return this.info.size;
    }

    public String toString() {
        return "ONNXMap(size=" + size() + ",info=" + this.info.toString() + ")";
    }
}
