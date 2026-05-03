package ai.onnxruntime;

import androidx.collection.SieveCacheKt;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class OrtUtil {
    private static final Logger logger = Logger.getLogger(OrtUtil.class.getName());

    /* JADX INFO: renamed from: ai.onnxruntime.OrtUtil$1, reason: invalid class name */
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
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UINT8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.INT64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.UNKNOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.FLOAT16.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$ai$onnxruntime$OnnxJavaType[OnnxJavaType.BFLOAT16.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static final class BufferTuple {
        final long byteSize;
        final Buffer data;
        final boolean isCopy;
        final int pos;
        final long size;

        BufferTuple(Buffer buffer, int i, long j, long j2, boolean z) {
            this.data = buffer;
            this.pos = i;
            this.byteSize = j;
            this.size = j2;
            this.isCopy = z;
        }
    }

    private OrtUtil() {
    }

    static int capacityFromSize(int i) {
        return (int) ((((double) i) / 0.75d) + 1.0d);
    }

    static Buffer convertArrayToBuffer(TensorInfo tensorInfo, Object obj) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(((int) tensorInfo.numElements) * tensorInfo.type.size).order(ByteOrder.nativeOrder());
        ByteBuffer byteBufferAsFloatBuffer = byteBufferOrder;
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[tensorInfo.type.ordinal()]) {
            case 1:
                byteBufferAsFloatBuffer = byteBufferOrder.asFloatBuffer();
                break;
            case 2:
                byteBufferAsFloatBuffer = byteBufferOrder.asDoubleBuffer();
                break;
            case 3:
            case 4:
            case 8:
                break;
            case 5:
            case 11:
            case 12:
                byteBufferAsFloatBuffer = byteBufferOrder.asShortBuffer();
                break;
            case 6:
                byteBufferAsFloatBuffer = byteBufferOrder.asIntBuffer();
                break;
            case 7:
                byteBufferAsFloatBuffer = byteBufferOrder.asLongBuffer();
                break;
            case 9:
            case 10:
            default:
                throw new IllegalArgumentException("Unexpected type, expected Java primitive found " + tensorInfo.type);
        }
        fillBufferFromArray(tensorInfo, obj, 0, byteBufferAsFloatBuffer);
        if (byteBufferAsFloatBuffer.remaining() != 0) {
            throw new IllegalArgumentException("Failed to copy all elements into the buffer, expected to copy " + tensorInfo.numElements + " into a buffer of capacity " + byteBufferAsFloatBuffer.capacity() + " but had " + byteBufferAsFloatBuffer.remaining() + " values left over.");
        }
        byteBufferAsFloatBuffer.rewind();
        return byteBufferAsFloatBuffer;
    }

    static Object convertBoxedPrimitiveToArray(OnnxJavaType onnxJavaType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[onnxJavaType.ordinal()]) {
            case 1:
                return new float[]{((Float) obj).floatValue()};
            case 2:
                return new double[]{((Double) obj).doubleValue()};
            case 3:
            case 4:
                return new byte[]{((Byte) obj).byteValue()};
            case 5:
                return new short[]{((Short) obj).shortValue()};
            case 6:
                return new int[]{((Integer) obj).intValue()};
            case 7:
                return new long[]{((Long) obj).longValue()};
            case 8:
                return new boolean[]{((Boolean) obj).booleanValue()};
            default:
                return null;
        }
    }

    static Buffer convertBoxedPrimitiveToBuffer(OnnxJavaType onnxJavaType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[onnxJavaType.ordinal()]) {
            case 1:
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(onnxJavaType.size).order(ByteOrder.nativeOrder()).asFloatBuffer();
                floatBufferAsFloatBuffer.put(0, ((Float) obj).floatValue());
                return floatBufferAsFloatBuffer;
            case 2:
                DoubleBuffer doubleBufferAsDoubleBuffer = ByteBuffer.allocateDirect(onnxJavaType.size).order(ByteOrder.nativeOrder()).asDoubleBuffer();
                doubleBufferAsDoubleBuffer.put(0, ((Double) obj).doubleValue());
                return doubleBufferAsDoubleBuffer;
            case 3:
            case 4:
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(onnxJavaType.size).order(ByteOrder.nativeOrder());
                byteBufferOrder.put(0, ((Byte) obj).byteValue());
                return byteBufferOrder;
            case 5:
            case 11:
            case 12:
                ShortBuffer shortBufferAsShortBuffer = ByteBuffer.allocateDirect(onnxJavaType.size).order(ByteOrder.nativeOrder()).asShortBuffer();
                shortBufferAsShortBuffer.put(0, ((Short) obj).shortValue());
                return shortBufferAsShortBuffer;
            case 6:
                IntBuffer intBufferAsIntBuffer = ByteBuffer.allocateDirect(onnxJavaType.size).order(ByteOrder.nativeOrder()).asIntBuffer();
                intBufferAsIntBuffer.put(0, ((Integer) obj).intValue());
                return intBufferAsIntBuffer;
            case 7:
                LongBuffer longBufferAsLongBuffer = ByteBuffer.allocateDirect(onnxJavaType.size).order(ByteOrder.nativeOrder()).asLongBuffer();
                longBufferAsLongBuffer.put(0, ((Long) obj).longValue());
                return longBufferAsLongBuffer;
            case 8:
                ByteBuffer byteBufferOrder2 = ByteBuffer.allocateDirect(onnxJavaType.size).order(ByteOrder.nativeOrder());
                byteBufferOrder2.put(0, ((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                return byteBufferOrder2;
            case 9:
            case 10:
            default:
                return null;
        }
    }

    static Map<String, String> convertToMap(String[][] strArr) {
        if (strArr.length != 2) {
            throw new IllegalArgumentException("Invalid zipped string, must have two arrays.");
        }
        if (strArr[0].length != strArr[1].length) {
            throw new IllegalArgumentException("Invalid zipped string, must have two arrays of the same length.");
        }
        HashMap map = new HashMap(capacityFromSize(strArr[0].length));
        int i = 0;
        while (true) {
            String[] strArr2 = strArr[0];
            if (i >= strArr2.length) {
                return Collections.unmodifiableMap(map);
            }
            map.put(strArr2[i], strArr[1][i]);
            i++;
        }
    }

    public static long elementCount(long[] jArr) {
        long j = 1;
        for (long j2 : jArr) {
            if (j2 < 0) {
                throw new IllegalArgumentException("Received negative value in shape " + Arrays.toString(jArr) + " .");
            }
            j *= j2;
        }
        return j;
    }

    static void fillArrayFromBuffer(TensorInfo tensorInfo, Buffer buffer, int i, Object obj) {
        if (i != tensorInfo.shape.length - 1) {
            long j = tensorInfo.shape[i];
            long length = Array.getLength(obj);
            if (j != length) {
                throw new IllegalArgumentException("Mismatch in array sizes, expected " + j + " at dim " + i + " from shape " + Arrays.toString(tensorInfo.shape) + ", found " + length);
            }
            for (int i2 = 0; i2 < length; i2++) {
                fillArrayFromBuffer(tensorInfo, buffer, i + 1, Array.get(obj, i2));
            }
            return;
        }
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[tensorInfo.type.ordinal()]) {
            case 1:
            case 11:
            case 12:
                ((FloatBuffer) buffer).get((float[]) obj);
                return;
            case 2:
                ((DoubleBuffer) buffer).get((double[]) obj);
                return;
            case 3:
            case 4:
                ((ByteBuffer) buffer).get((byte[]) obj);
                return;
            case 5:
                ((ShortBuffer) buffer).get((short[]) obj);
                return;
            case 6:
                ((IntBuffer) buffer).get((int[]) obj);
                return;
            case 7:
                ((LongBuffer) buffer).get((long[]) obj);
                return;
            case 8:
                boolean[] zArr = (boolean[]) obj;
                ByteBuffer byteBuffer = (ByteBuffer) buffer;
                for (int i3 = 0; i3 < zArr.length; i3++) {
                    zArr[i3] = byteBuffer.get() != 0;
                }
                return;
            case 9:
            case 10:
                throw new IllegalArgumentException("Unexpected type, expected Java primitive found " + tensorInfo.type);
            default:
                return;
        }
    }

    private static void fillBufferFromArray(TensorInfo tensorInfo, Object obj, int i, Buffer buffer) {
        int i2 = 0;
        if (i != tensorInfo.shape.length - 1) {
            long j = tensorInfo.shape[i];
            long length = Array.getLength(obj);
            if (j != length) {
                throw new IllegalArgumentException("Mismatch in array sizes, expected " + j + " at dim " + i + " from shape " + Arrays.toString(tensorInfo.shape) + ", found " + length);
            }
            while (i2 < length) {
                fillBufferFromArray(tensorInfo, Array.get(obj, i2), i + 1, buffer);
                i2++;
            }
            return;
        }
        switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[tensorInfo.type.ordinal()]) {
            case 1:
                ((FloatBuffer) buffer).put((float[]) obj);
                return;
            case 2:
                ((DoubleBuffer) buffer).put((double[]) obj);
                return;
            case 3:
            case 4:
                ((ByteBuffer) buffer).put((byte[]) obj);
                return;
            case 5:
            case 11:
            case 12:
                ((ShortBuffer) buffer).put((short[]) obj);
                return;
            case 6:
                ((IntBuffer) buffer).put((int[]) obj);
                return;
            case 7:
                ((LongBuffer) buffer).put((long[]) obj);
                return;
            case 8:
                boolean[] zArr = (boolean[]) obj;
                ByteBuffer byteBuffer = (ByteBuffer) buffer;
                while (i2 < zArr.length) {
                    byteBuffer.put(zArr[i2] ? (byte) 1 : (byte) 0);
                    i2++;
                }
                return;
            case 9:
            case 10:
                throw new IllegalArgumentException("Unexpected type, expected Java primitive found " + tensorInfo.type);
            default:
                return;
        }
    }

    private static void flattenString(Object[] objArr, ArrayList<String> arrayList) {
        for (Object obj : objArr) {
            Class<?> cls = obj.getClass();
            if (!cls.isArray()) {
                throw new IllegalStateException("Found an element type where there should have been an array. Class = " + cls);
            }
            if (cls.getComponentType().isArray()) {
                flattenString((Object[]) obj, arrayList);
            } else {
                if (!cls.getComponentType().equals(String.class)) {
                    throw new IllegalStateException("Found a non-String, non-array element type, " + cls);
                }
                arrayList.addAll(Arrays.asList((String[]) obj));
            }
        }
    }

    public static String[] flattenString(Object obj) {
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        ArrayList arrayList = new ArrayList();
        flattenString((Object[]) obj, arrayList);
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static Object newBooleanArray(long[] jArr) {
        return Array.newInstance((Class<?>) Boolean.TYPE, transformShape(jArr));
    }

    public static Object newByteArray(long[] jArr) {
        return Array.newInstance((Class<?>) Byte.TYPE, transformShape(jArr));
    }

    public static Object newDoubleArray(long[] jArr) {
        return Array.newInstance((Class<?>) Double.TYPE, transformShape(jArr));
    }

    public static Object newFloatArray(long[] jArr) {
        return Array.newInstance((Class<?>) Float.TYPE, transformShape(jArr));
    }

    public static Object newIntArray(long[] jArr) {
        return Array.newInstance((Class<?>) Integer.TYPE, transformShape(jArr));
    }

    public static Object newLongArray(long[] jArr) {
        return Array.newInstance((Class<?>) Long.TYPE, transformShape(jArr));
    }

    public static Object newShortArray(long[] jArr) {
        return Array.newInstance((Class<?>) Short.TYPE, transformShape(jArr));
    }

    public static Object newStringArray(long[] jArr) {
        return Array.newInstance((Class<?>) String.class, transformShape(jArr));
    }

    static BufferTuple prepareBuffer(Buffer buffer, OnnxJavaType onnxJavaType) {
        Buffer bufferPut;
        Buffer buffer2;
        int iPosition;
        if (onnxJavaType == OnnxJavaType.STRING || onnxJavaType == OnnxJavaType.UNKNOWN) {
            throw new IllegalStateException("Cannot create a " + onnxJavaType + " tensor from a buffer");
        }
        int i = buffer instanceof ByteBuffer ? 1 : onnxJavaType.size;
        long j = i;
        if (((long) buffer.remaining()) * j > SieveCacheKt.NodeLinkMask - (j * 8)) {
            throw new IllegalStateException("Cannot allocate a direct buffer of the requested size and type, size " + buffer.remaining() + ", type = " + onnxJavaType);
        }
        int iRemaining = buffer.remaining() * i;
        if (buffer.isDirect()) {
            buffer2 = buffer;
            iPosition = buffer.position() * i;
        } else {
            int iPosition2 = buffer.position();
            ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iRemaining).order(ByteOrder.nativeOrder());
            switch (AnonymousClass1.$SwitchMap$ai$onnxruntime$OnnxJavaType[onnxJavaType.ordinal()]) {
                case 1:
                    bufferPut = byteBufferOrder.asFloatBuffer().put((FloatBuffer) buffer);
                    break;
                case 2:
                    bufferPut = byteBufferOrder.asDoubleBuffer().put((DoubleBuffer) buffer);
                    break;
                case 3:
                case 4:
                case 8:
                    bufferPut = byteBufferOrder.put((ByteBuffer) buffer);
                    break;
                case 5:
                case 11:
                case 12:
                    bufferPut = byteBufferOrder.asShortBuffer().put((ShortBuffer) buffer);
                    break;
                case 6:
                    bufferPut = byteBufferOrder.asIntBuffer().put((IntBuffer) buffer);
                    break;
                case 7:
                    bufferPut = byteBufferOrder.asLongBuffer().put((LongBuffer) buffer);
                    break;
                case 9:
                case 10:
                default:
                    throw new IllegalStateException("Impossible to reach here, managed to cast a buffer as an incorrect type, found " + onnxJavaType);
            }
            buffer.position(iPosition2);
            bufferPut.rewind();
            buffer2 = bufferPut;
            iPosition = 0;
        }
        return new BufferTuple(buffer2, iPosition, iRemaining, buffer.remaining(), buffer2 != buffer);
    }

    private static int reshape(Object obj, Object obj2, int i) {
        if (!obj2.getClass().isArray()) {
            throw new IllegalStateException("Found element type when expecting an array. Class " + obj2.getClass());
        }
        for (Object obj3 : (Object[]) obj2) {
            Class<?> cls = obj3.getClass();
            if (!cls.isArray()) {
                throw new IllegalStateException("Found element type when expecting an array. Class " + cls);
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() || componentType == String.class) {
                int length = Array.getLength(obj3);
                System.arraycopy(obj, i, obj3, 0, length);
                i += length;
            } else {
                i = reshape(obj, obj3, i);
            }
        }
        return i;
    }

    public static Object reshape(byte[] bArr, long[] jArr) {
        Object objNewByteArray = newByteArray(jArr);
        reshape(bArr, objNewByteArray, 0);
        return objNewByteArray;
    }

    public static Object reshape(double[] dArr, long[] jArr) {
        Object objNewDoubleArray = newDoubleArray(jArr);
        reshape(dArr, objNewDoubleArray, 0);
        return objNewDoubleArray;
    }

    public static Object reshape(float[] fArr, long[] jArr) {
        Object objNewFloatArray = newFloatArray(jArr);
        reshape(fArr, objNewFloatArray, 0);
        return objNewFloatArray;
    }

    public static Object reshape(int[] iArr, long[] jArr) {
        Object objNewIntArray = newIntArray(jArr);
        reshape(iArr, objNewIntArray, 0);
        return objNewIntArray;
    }

    public static Object reshape(long[] jArr, long[] jArr2) {
        Object objNewLongArray = newLongArray(jArr2);
        reshape(jArr, objNewLongArray, 0);
        return objNewLongArray;
    }

    public static Object reshape(String[] strArr, long[] jArr) {
        Object objNewStringArray = newStringArray(jArr);
        reshape(strArr, objNewStringArray, 0);
        return objNewStringArray;
    }

    public static Object reshape(short[] sArr, long[] jArr) {
        Object objNewShortArray = newShortArray(jArr);
        reshape(sArr, objNewShortArray, 0);
        return objNewShortArray;
    }

    public static Object reshape(boolean[] zArr, long[] jArr) {
        Object objNewBooleanArray = newBooleanArray(jArr);
        reshape(zArr, objNewBooleanArray, 0);
        return objNewBooleanArray;
    }

    public static int[] transformShape(long[] jArr) {
        if (jArr.length == 0 || jArr.length > 8) {
            throw new IllegalArgumentException("Arrays with less than 1 and greater than 8 dimensions are not supported.");
        }
        int[] iArr = new int[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            long j = jArr[i];
            if (j < 0 || j > SieveCacheKt.NodeLinkMask) {
                throw new IllegalArgumentException("Invalid shape for a Java array, expected non-negative entries smaller than Integer.MAX_VALUE. Found " + Arrays.toString(jArr));
            }
            iArr[i] = (int) j;
        }
        return iArr;
    }

    public static long[] transformShape(int[] iArr) {
        if (iArr.length == 0 || iArr.length > 8) {
            throw new IllegalArgumentException("Arrays with less than 1 and greater than 8 dimensions are not supported.");
        }
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            long j = iArr[i];
            if (j < 1) {
                throw new IllegalArgumentException("Invalid shape for a Java array, expected positive entries smaller than Integer.MAX_VALUE. Found " + Arrays.toString(iArr));
            }
            jArr[i] = j;
        }
        return jArr;
    }

    static String[][] unpackMap(Map<String, String> map) {
        String[] strArr = new String[map.size()];
        String[] strArr2 = new String[map.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Invalid map, keys and values must not be null, found key = " + entry.getKey() + ", value = " + entry.getValue());
            }
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new String[][]{strArr, strArr2};
    }

    public static boolean validateShape(long[] jArr) {
        boolean z = true;
        for (int i = 0; i < jArr.length; i++) {
            long j = jArr[i];
            z = z & (j > 0) & (((long) ((int) j)) == j);
        }
        return z && jArr.length <= 8;
    }
}
