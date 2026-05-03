package ai.onnxruntime;

import ai.onnxruntime.OnnxValue;
import ai.onnxruntime.OrtUtil;
import ai.onnxruntime.TensorInfo;
import ai.onnxruntime.platform.Fp16Conversions;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Optional;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class OnnxTensor extends OnnxTensorLike {
    private static final Logger logger = Logger.getLogger(OnnxTensor.class.getName());
    private final Buffer buffer;
    private final boolean ownsBuffer;

    /* JADX INFO: renamed from: ai.onnxruntime.OnnxTensor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ai$onnxruntime$OnnxJavaType;

        static {
            int[] iArr = new int[OnnxJavaType.values().length];
            $SwitchMap$ai$onnxruntime$OnnxJavaType = iArr;
            try {
                iArr[OnnxJavaType.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BOOL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UINT8.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BFLOAT16.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.FLOAT16.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT16.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UNKNOWN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    OnnxTensor(long j, long j2, TensorInfo tensorInfo) {
        this(j, j2, tensorInfo, null, false);
    }

    OnnxTensor(long j, long j2, TensorInfo tensorInfo, Buffer buffer, boolean z) {
        super(j, j2, tensorInfo);
        this.buffer = buffer;
        this.ownsBuffer = z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0078, code lost:
    
        if ((r4 instanceof java.nio.ByteBuffer) != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Buffer castBuffer(Buffer buffer) {
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[this.info.type.ordinal()]) {
            case 1:
                if (!(buffer instanceof FloatBuffer)) {
                    if (buffer instanceof ByteBuffer) {
                        return ((ByteBuffer) buffer).asFloatBuffer();
                    }
                    throw new IllegalStateException("Invalid buffer type for cast operation, found " + buffer.getClass() + " expected something convertible to " + this.info.type);
                }
                return buffer;
            case 2:
                if (!(buffer instanceof DoubleBuffer)) {
                    if (buffer instanceof ByteBuffer) {
                        return ((ByteBuffer) buffer).asDoubleBuffer();
                    }
                    throw new IllegalStateException("Invalid buffer type for cast operation, found " + buffer.getClass() + " expected something convertible to " + this.info.type);
                }
                return buffer;
            case 3:
            case 4:
            case 5:
                break;
            case 6:
                if (buffer instanceof ShortBuffer) {
                    return Fp16Conversions.convertBf16BufferToFloatBuffer((ShortBuffer) buffer);
                }
                if (buffer instanceof ByteBuffer) {
                    return Fp16Conversions.convertBf16BufferToFloatBuffer(((ByteBuffer) buffer).asShortBuffer());
                }
                throw new IllegalStateException("Invalid buffer type for cast operation, found " + buffer.getClass() + " expected something convertible to " + this.info.type);
            case 7:
                if (buffer instanceof ShortBuffer) {
                    return Fp16Conversions.convertFp16BufferToFloatBuffer((ShortBuffer) buffer);
                }
                if (buffer instanceof ByteBuffer) {
                    return Fp16Conversions.convertFp16BufferToFloatBuffer(((ByteBuffer) buffer).asShortBuffer());
                }
                throw new IllegalStateException("Invalid buffer type for cast operation, found " + buffer.getClass() + " expected something convertible to " + this.info.type);
            case 8:
                if (!(buffer instanceof ShortBuffer)) {
                    if (buffer instanceof ByteBuffer) {
                        return ((ByteBuffer) buffer).asShortBuffer();
                    }
                    throw new IllegalStateException("Invalid buffer type for cast operation, found " + buffer.getClass() + " expected something convertible to " + this.info.type);
                }
                return buffer;
            case 9:
                if (!(buffer instanceof IntBuffer)) {
                    if (buffer instanceof ByteBuffer) {
                        return ((ByteBuffer) buffer).asIntBuffer();
                    }
                    throw new IllegalStateException("Invalid buffer type for cast operation, found " + buffer.getClass() + " expected something convertible to " + this.info.type);
                }
                return buffer;
            case 10:
                if (!(buffer instanceof LongBuffer)) {
                    if (buffer instanceof ByteBuffer) {
                        return ((ByteBuffer) buffer).asLongBuffer();
                    }
                    throw new IllegalStateException("Invalid buffer type for cast operation, found " + buffer.getClass() + " expected something convertible to " + this.info.type);
                }
                return buffer;
            default:
                throw new IllegalStateException("Invalid buffer type for cast operation, found " + buffer.getClass() + " expected something convertible to " + this.info.type);
        }
    }

    private native void close(long j, long j2);

    private static native long createString(long j, long j2, String str) throws OrtException;

    private static native long createStringTensor(long j, long j2, Object[] objArr, long[] jArr) throws OrtException;

    private static OnnxTensor createTensor(OnnxJavaType onnxJavaType, OrtAllocator ortAllocator, Buffer buffer, long[] jArr) throws OrtException {
        OrtUtil.BufferTuple bufferTuplePrepareBuffer = OrtUtil.prepareBuffer(buffer, onnxJavaType);
        TensorInfo tensorInfoConstructFromBuffer = TensorInfo.constructFromBuffer(bufferTuplePrepareBuffer.data, jArr, onnxJavaType);
        return new OnnxTensor(createTensorFromBuffer(OnnxRuntime.ortApiHandle, ortAllocator.handle, bufferTuplePrepareBuffer.data, bufferTuplePrepareBuffer.pos, bufferTuplePrepareBuffer.byteSize, jArr, tensorInfoConstructFromBuffer.onnxType.value), ortAllocator.handle, tensorInfoConstructFromBuffer, bufferTuplePrepareBuffer.data, bufferTuplePrepareBuffer.isCopy);
    }

    static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, Object obj) throws OrtException {
        Buffer bufferConvertArrayToBuffer;
        if (ortAllocator.isClosed()) {
            throw new IllegalStateException("Trying to create an OnnxTensor with a closed OrtAllocator.");
        }
        TensorInfo tensorInfoConstructFromJavaArray = TensorInfo.constructFromJavaArray(obj);
        if (tensorInfoConstructFromJavaArray.type == OnnxJavaType.STRING) {
            return tensorInfoConstructFromJavaArray.shape.length == 0 ? new OnnxTensor(createString(OnnxRuntime.ortApiHandle, ortAllocator.handle, (String) obj), ortAllocator.handle, tensorInfoConstructFromJavaArray) : new OnnxTensor(createStringTensor(OnnxRuntime.ortApiHandle, ortAllocator.handle, OrtUtil.flattenString(obj), tensorInfoConstructFromJavaArray.shape), ortAllocator.handle, tensorInfoConstructFromJavaArray);
        }
        if (tensorInfoConstructFromJavaArray.shape.length == 0) {
            bufferConvertArrayToBuffer = OrtUtil.convertBoxedPrimitiveToBuffer(tensorInfoConstructFromJavaArray.type, obj);
            if (bufferConvertArrayToBuffer == null) {
                throw new OrtException("Failed to convert a boxed primitive to an array, this is an error with the ORT Java API, please report this message & stack trace. JavaType = " + tensorInfoConstructFromJavaArray.type + ", object = " + obj);
            }
        } else {
            bufferConvertArrayToBuffer = OrtUtil.convertArrayToBuffer(tensorInfoConstructFromJavaArray, obj);
        }
        Buffer buffer = bufferConvertArrayToBuffer;
        return new OnnxTensor(createTensorFromBuffer(OnnxRuntime.ortApiHandle, ortAllocator.handle, buffer, 0, ((long) tensorInfoConstructFromJavaArray.type.size) * tensorInfoConstructFromJavaArray.numElements, tensorInfoConstructFromJavaArray.shape, tensorInfoConstructFromJavaArray.onnxType.value), ortAllocator.handle, tensorInfoConstructFromJavaArray, buffer, true);
    }

    static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, ByteBuffer byteBuffer, long[] jArr) throws OrtException {
        return createTensor(ortEnvironment, ortAllocator, byteBuffer, jArr, OnnxJavaType.INT8);
    }

    static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, ByteBuffer byteBuffer, long[] jArr, OnnxJavaType onnxJavaType) throws OrtException {
        if (ortAllocator.isClosed()) {
            throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
        }
        return createTensor(onnxJavaType, ortAllocator, byteBuffer, jArr);
    }

    static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, DoubleBuffer doubleBuffer, long[] jArr) throws OrtException {
        if (ortAllocator.isClosed()) {
            throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
        }
        return createTensor(OnnxJavaType.DOUBLE, ortAllocator, doubleBuffer, jArr);
    }

    static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, FloatBuffer floatBuffer, long[] jArr) throws OrtException {
        if (ortAllocator.isClosed()) {
            throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
        }
        return createTensor(OnnxJavaType.FLOAT, ortAllocator, floatBuffer, jArr);
    }

    static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, IntBuffer intBuffer, long[] jArr) throws OrtException {
        if (ortAllocator.isClosed()) {
            throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
        }
        return createTensor(OnnxJavaType.INT32, ortAllocator, intBuffer, jArr);
    }

    static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, LongBuffer longBuffer, long[] jArr) throws OrtException {
        if (ortAllocator.isClosed()) {
            throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
        }
        return createTensor(OnnxJavaType.INT64, ortAllocator, longBuffer, jArr);
    }

    static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, ShortBuffer shortBuffer, long[] jArr, OnnxJavaType onnxJavaType) throws OrtException {
        if (ortAllocator.isClosed()) {
            throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
        }
        if (onnxJavaType == OnnxJavaType.BFLOAT16 || onnxJavaType == OnnxJavaType.FLOAT16 || onnxJavaType == OnnxJavaType.INT16) {
            return createTensor(onnxJavaType, ortAllocator, shortBuffer, jArr);
        }
        throw new IllegalArgumentException("Only int16, float16 or bfloat16 tensors can be created from ShortBuffer.");
    }

    static OnnxTensor createTensor(OrtEnvironment ortEnvironment, OrtAllocator ortAllocator, String[] strArr, long[] jArr) throws OrtException {
        if (ortAllocator.isClosed()) {
            throw new IllegalStateException("Trying to create an OnnxTensor on a closed OrtAllocator.");
        }
        return new OnnxTensor(createStringTensor(OnnxRuntime.ortApiHandle, ortAllocator.handle, strArr, jArr), ortAllocator.handle, new TensorInfo(jArr, OnnxJavaType.STRING, TensorInfo.OnnxTensorType.ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING));
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, Object obj) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, obj);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, ByteBuffer byteBuffer, long[] jArr) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, byteBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, ByteBuffer byteBuffer, long[] jArr, OnnxJavaType onnxJavaType) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, byteBuffer, jArr, onnxJavaType);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, DoubleBuffer doubleBuffer, long[] jArr) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, doubleBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, FloatBuffer floatBuffer, long[] jArr) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, floatBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, IntBuffer intBuffer, long[] jArr) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, intBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, LongBuffer longBuffer, long[] jArr) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, longBuffer, jArr);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, ShortBuffer shortBuffer, long[] jArr) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, shortBuffer, jArr, OnnxJavaType.INT16);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, ShortBuffer shortBuffer, long[] jArr, OnnxJavaType onnxJavaType) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, shortBuffer, jArr, onnxJavaType);
    }

    public static OnnxTensor createTensor(OrtEnvironment ortEnvironment, String[] strArr, long[] jArr) throws OrtException {
        return createTensor(ortEnvironment, ortEnvironment.defaultAllocator, strArr, jArr);
    }

    private static native long createTensorFromBuffer(long j, long j2, Buffer buffer, int i, long j3, long[] jArr, int i2) throws OrtException;

    private static Buffer duplicate(Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            return ((ByteBuffer) buffer).duplicate().order(ByteOrder.nativeOrder());
        }
        if (buffer instanceof ShortBuffer) {
            return ((ShortBuffer) buffer).duplicate();
        }
        if (buffer instanceof IntBuffer) {
            return ((IntBuffer) buffer).duplicate();
        }
        if (buffer instanceof LongBuffer) {
            return ((LongBuffer) buffer).duplicate();
        }
        if (buffer instanceof FloatBuffer) {
            return ((FloatBuffer) buffer).duplicate();
        }
        if (buffer instanceof DoubleBuffer) {
            return ((DoubleBuffer) buffer).duplicate();
        }
        throw new IllegalStateException("Unknown buffer type " + buffer.getClass());
    }

    private native boolean getBool(long j, long j2) throws OrtException;

    private ByteBuffer getBuffer() {
        return getBuffer(OnnxRuntime.ortApiHandle, this.nativeHandle).order(ByteOrder.nativeOrder());
    }

    private native ByteBuffer getBuffer(long j, long j2);

    private native byte getByte(long j, long j2, int i) throws OrtException;

    private native double getDouble(long j, long j2) throws OrtException;

    private native float getFloat(long j, long j2, int i) throws OrtException;

    private native int getInt(long j, long j2, int i) throws OrtException;

    private native long getLong(long j, long j2, int i) throws OrtException;

    private native short getShort(long j, long j2, int i) throws OrtException;

    private native String getString(long j, long j2) throws OrtException;

    private native void getStringArray(long j, long j2, String[] strArr) throws OrtException;

    @Override // ai.onnxruntime.OnnxValue, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.closed) {
            logger.warning("Closing an already closed tensor.");
        } else {
            close(OnnxRuntime.ortApiHandle, this.nativeHandle);
            this.closed = true;
        }
    }

    public Optional<Buffer> getBufferRef() {
        return Optional.ofNullable(duplicate(this.buffer));
    }

    public ByteBuffer getByteBuffer() {
        checkClosed();
        if (this.info.type == OnnxJavaType.STRING) {
            return null;
        }
        ByteBuffer buffer = getBuffer();
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(buffer.capacity()).order(ByteOrder.nativeOrder());
        byteBufferOrder.put(buffer);
        byteBufferOrder.rewind();
        return byteBufferOrder;
    }

    public DoubleBuffer getDoubleBuffer() {
        checkClosed();
        if (this.info.type != OnnxJavaType.DOUBLE) {
            return null;
        }
        DoubleBuffer doubleBufferAsDoubleBuffer = getBuffer().asDoubleBuffer();
        DoubleBuffer doubleBufferAllocate = DoubleBuffer.allocate(doubleBufferAsDoubleBuffer.capacity());
        doubleBufferAllocate.put(doubleBufferAsDoubleBuffer);
        doubleBufferAllocate.rewind();
        return doubleBufferAllocate;
    }

    public FloatBuffer getFloatBuffer() {
        checkClosed();
        if (this.info.type == OnnxJavaType.FLOAT) {
            FloatBuffer floatBufferAsFloatBuffer = getBuffer().asFloatBuffer();
            FloatBuffer floatBufferAllocate = FloatBuffer.allocate(floatBufferAsFloatBuffer.capacity());
            floatBufferAllocate.put(floatBufferAsFloatBuffer);
            floatBufferAllocate.rewind();
            return floatBufferAllocate;
        }
        if (this.info.type == OnnxJavaType.FLOAT16) {
            return Fp16Conversions.convertFp16BufferToFloatBuffer(getBuffer().asShortBuffer());
        }
        if (this.info.type == OnnxJavaType.BFLOAT16) {
            return Fp16Conversions.convertBf16BufferToFloatBuffer(getBuffer().asShortBuffer());
        }
        return null;
    }

    public IntBuffer getIntBuffer() {
        checkClosed();
        if (this.info.type != OnnxJavaType.INT32) {
            return null;
        }
        IntBuffer intBufferAsIntBuffer = getBuffer().asIntBuffer();
        IntBuffer intBufferAllocate = IntBuffer.allocate(intBufferAsIntBuffer.capacity());
        intBufferAllocate.put(intBufferAsIntBuffer);
        intBufferAllocate.rewind();
        return intBufferAllocate;
    }

    public LongBuffer getLongBuffer() {
        checkClosed();
        if (this.info.type != OnnxJavaType.INT64) {
            return null;
        }
        LongBuffer longBufferAsLongBuffer = getBuffer().asLongBuffer();
        LongBuffer longBufferAllocate = LongBuffer.allocate(longBufferAsLongBuffer.capacity());
        longBufferAllocate.put(longBufferAsLongBuffer);
        longBufferAllocate.rewind();
        return longBufferAllocate;
    }

    public ShortBuffer getShortBuffer() {
        checkClosed();
        if (this.info.type != OnnxJavaType.INT16 && this.info.type != OnnxJavaType.FLOAT16 && this.info.type != OnnxJavaType.BFLOAT16) {
            return null;
        }
        ShortBuffer shortBufferAsShortBuffer = getBuffer().asShortBuffer();
        ShortBuffer shortBufferAllocate = ShortBuffer.allocate(shortBufferAsShortBuffer.capacity());
        shortBufferAllocate.put(shortBufferAsShortBuffer);
        shortBufferAllocate.rewind();
        return shortBufferAllocate;
    }

    @Override // ai.onnxruntime.OnnxValue
    public OnnxValue.OnnxValueType getType() {
        return OnnxValue.OnnxValueType.ONNX_TYPE_TENSOR;
    }

    @Override // ai.onnxruntime.OnnxValue
    public Object getValue() throws OrtException {
        checkClosed();
        if (!this.info.isScalar()) {
            Object objMakeCarrier = this.info.makeCarrier();
            if (this.info.getNumElements() > 0) {
                if (this.info.type == OnnxJavaType.STRING) {
                    String[] strArr = (String[]) objMakeCarrier;
                    getStringArray(OnnxRuntime.ortApiHandle, this.nativeHandle, strArr);
                    if (this.info.shape.length != 1) {
                        return OrtUtil.reshape(strArr, this.info.shape);
                    }
                } else {
                    Buffer buffer = this.buffer;
                    OrtUtil.fillArrayFromBuffer(this.info, buffer == null ? castBuffer(getBuffer()) : castBuffer(duplicate(buffer)), 0, objMakeCarrier);
                }
            }
            return objMakeCarrier;
        }
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[this.info.type.ordinal()]) {
            case 1:
                return Float.valueOf(getFloat(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 2:
                return Double.valueOf(getDouble(OnnxRuntime.ortApiHandle, this.nativeHandle));
            case 3:
                return Boolean.valueOf(getBool(OnnxRuntime.ortApiHandle, this.nativeHandle));
            case 4:
            case 5:
                return Byte.valueOf(getByte(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 6:
                return Float.valueOf(Fp16Conversions.bf16ToFloat(getShort(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value)));
            case 7:
                return Float.valueOf(Fp16Conversions.fp16ToFloat(getShort(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value)));
            case 8:
                return Short.valueOf(getShort(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 9:
                return Integer.valueOf(getInt(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 10:
                return Long.valueOf(getLong(OnnxRuntime.ortApiHandle, this.nativeHandle, this.info.onnxType.value));
            case 11:
                return getString(OnnxRuntime.ortApiHandle, this.nativeHandle);
            default:
                throw new OrtException("Extracting the value of an invalid Tensor.");
        }
    }

    public boolean ownsBuffer() {
        return this.ownsBuffer;
    }

    public String toString() {
        return "OnnxTensor(info=" + this.info.toString() + ",closed=" + this.closed + ")";
    }
}
