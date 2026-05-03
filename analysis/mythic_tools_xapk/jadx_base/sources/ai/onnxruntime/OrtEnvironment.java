package ai.onnxruntime;

import ai.onnxruntime.OrtSession;
import ai.onnxruntime.OrtTrainingSession;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class OrtEnvironment implements AutoCloseable {
    public static final String DEFAULT_NAME = "ort-java";
    private static volatile OrtEnvironment INSTANCE;
    private static volatile OrtLoggingLevel curLogLevel;
    private static volatile String curLoggingName;
    private static final Logger logger = Logger.getLogger(OrtEnvironment.class.getName());
    final OrtAllocator defaultAllocator;
    final long nativeHandle;

    public enum OrtCompiledModelCompatibility {
        EP_NOT_APPLICABLE(0),
        EP_SUPPORTED_OPTIMAL(1),
        EP_SUPPORTED_PREFER_RECOMPILATION(2),
        EP_UNSUPPORTED(3);

        private static final Logger logger = Logger.getLogger(OrtCompiledModelCompatibility.class.getName());
        private static final OrtCompiledModelCompatibility[] values = new OrtCompiledModelCompatibility[4];
        private final int value;

        static {
            for (OrtCompiledModelCompatibility ortCompiledModelCompatibility : values()) {
                values[ortCompiledModelCompatibility.value] = ortCompiledModelCompatibility;
            }
        }

        OrtCompiledModelCompatibility(int i) {
            this.value = i;
        }

        public static OrtCompiledModelCompatibility mapFromInt(int i) {
            if (i >= 0) {
                OrtCompiledModelCompatibility[] ortCompiledModelCompatibilityArr = values;
                if (i < ortCompiledModelCompatibilityArr.length) {
                    return ortCompiledModelCompatibilityArr[i];
                }
            }
            logger.warning("Unknown model compatibility " + i + " setting to EP_UNSUPPORTED");
            return EP_UNSUPPORTED;
        }

        public int getValue() {
            return this.value;
        }
    }

    private static final class OrtEnvCloser implements Runnable {
        private final long apiHandle;
        private final long nativeHandle;

        OrtEnvCloser(long j, long j2) {
            this.apiHandle = j;
            this.nativeHandle = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                OrtEnvironment.close(this.apiHandle, this.nativeHandle);
            } catch (OrtException e) {
                System.err.println("Error closing OrtEnvironment, " + e);
            }
        }
    }

    public static final class ThreadingOptions implements AutoCloseable {
        private boolean closed = false;
        private final long nativeHandle = createThreadingOptions(OnnxRuntime.ortApiHandle);

        static {
            try {
                OnnxRuntime.init();
            } catch (IOException e) {
                throw new RuntimeException("Failed to load onnx-runtime library", e);
            }
        }

        private void checkClosed() {
            if (this.closed) {
                throw new IllegalStateException("Trying to use a closed ThreadingOptions");
            }
        }

        private native void closeThreadingOptions(long j, long j2);

        private static native long createThreadingOptions(long j);

        private native void setGlobalDenormalAsZero(long j, long j2) throws OrtException;

        private native void setGlobalInterOpNumThreads(long j, long j2, int i) throws OrtException;

        private native void setGlobalIntraOpNumThreads(long j, long j2, int i) throws OrtException;

        private native void setGlobalSpinControl(long j, long j2, int i) throws OrtException;

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                throw new IllegalStateException("Trying to close a closed ThreadingOptions.");
            }
            closeThreadingOptions(OnnxRuntime.ortApiHandle, this.nativeHandle);
            this.closed = true;
        }

        public void setGlobalDenormalAsZero() throws OrtException {
            checkClosed();
            setGlobalDenormalAsZero(OnnxRuntime.ortApiHandle, this.nativeHandle);
        }

        public void setGlobalInterOpNumThreads(int i) throws OrtException {
            checkClosed();
            if (i < 0) {
                throw new IllegalArgumentException("Number of threads must be non-negative.");
            }
            setGlobalInterOpNumThreads(OnnxRuntime.ortApiHandle, this.nativeHandle, i);
        }

        public void setGlobalIntraOpNumThreads(int i) throws OrtException {
            checkClosed();
            if (i < 0) {
                throw new IllegalArgumentException("Number of threads must be non-negative.");
            }
            setGlobalIntraOpNumThreads(OnnxRuntime.ortApiHandle, this.nativeHandle, i);
        }

        public void setGlobalSpinControl(boolean z) throws OrtException {
            checkClosed();
            setGlobalSpinControl(OnnxRuntime.ortApiHandle, this.nativeHandle, z ? 1 : 0);
        }
    }

    static {
        try {
            OnnxRuntime.init();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load onnx-runtime library", e);
        }
    }

    private OrtEnvironment() throws OrtException {
        this(OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING, "java-default");
    }

    private OrtEnvironment(OrtLoggingLevel ortLoggingLevel, String str) throws OrtException {
        long jCreateHandle = createHandle(OnnxRuntime.ortApiHandle, ortLoggingLevel.getValue(), str);
        this.nativeHandle = jCreateHandle;
        this.defaultAllocator = new OrtAllocator(getDefaultAllocator(OnnxRuntime.ortApiHandle), true);
        Runtime.getRuntime().addShutdownHook(new Thread(new OrtEnvCloser(OnnxRuntime.ortApiHandle, jCreateHandle)));
    }

    private OrtEnvironment(OrtLoggingLevel ortLoggingLevel, String str, ThreadingOptions threadingOptions) throws OrtException {
        long jCreateHandle = createHandle(OnnxRuntime.ortApiHandle, ortLoggingLevel.getValue(), str, threadingOptions.nativeHandle);
        this.nativeHandle = jCreateHandle;
        this.defaultAllocator = new OrtAllocator(getDefaultAllocator(OnnxRuntime.ortApiHandle), true);
        Runtime.getRuntime().addShutdownHook(new Thread(new OrtEnvCloser(OnnxRuntime.ortApiHandle, jCreateHandle)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void close(long j, long j2) throws OrtException;

    private static native long createHandle(long j, int i, String str) throws OrtException;

    private static native long createHandle(long j, int i, String str, long j2) throws OrtException;

    public static EnumSet<OrtProvider> getAvailableProviders() {
        return OnnxRuntime.providers.clone();
    }

    private static native long getDefaultAllocator(long j) throws OrtException;

    public static synchronized OrtEnvironment getEnvironment() {
        if (INSTANCE == null) {
            return getEnvironment(OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING, DEFAULT_NAME);
        }
        return INSTANCE;
    }

    public static OrtEnvironment getEnvironment(OrtLoggingLevel ortLoggingLevel) {
        return getEnvironment(ortLoggingLevel, DEFAULT_NAME);
    }

    public static synchronized OrtEnvironment getEnvironment(OrtLoggingLevel ortLoggingLevel, String str) {
        if (INSTANCE == null) {
            try {
                INSTANCE = new OrtEnvironment(ortLoggingLevel, str);
                curLogLevel = ortLoggingLevel;
                curLoggingName = str;
            } catch (OrtException e) {
                throw new IllegalStateException("Failed to create OrtEnvironment", e);
            }
        } else if (ortLoggingLevel.getValue() != curLogLevel.getValue() || !str.equals(curLoggingName)) {
            logger.warning("Tried to change OrtEnvironment's logging level or name while a reference exists.");
        }
        return INSTANCE;
    }

    public static synchronized OrtEnvironment getEnvironment(OrtLoggingLevel ortLoggingLevel, String str, ThreadingOptions threadingOptions) {
        if (INSTANCE != null) {
            throw new IllegalStateException("Tried to specify the thread pool when creating an OrtEnvironment, but one already exists.");
        }
        try {
            INSTANCE = new OrtEnvironment(ortLoggingLevel, str, threadingOptions);
            curLogLevel = ortLoggingLevel;
            curLoggingName = str;
        } catch (OrtException e) {
            throw new IllegalStateException("Failed to create OrtEnvironment", e);
        }
        return INSTANCE;
    }

    public static OrtEnvironment getEnvironment(String str) {
        return getEnvironment(OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING, str);
    }

    private static native long[] getEpDevices(long j, long j2) throws OrtException;

    private static native int getModelCompatibilityForEpDevices(long j, long[] jArr, String str) throws OrtException;

    private static native void registerExecutionProviderLibrary(long j, long j2, String str, String str2) throws OrtException;

    private static native void setTelemetry(long j, long j2, boolean z) throws OrtException;

    private static native void unregisterExecutionProviderLibrary(long j, long j2, String str) throws OrtException;

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    public OrtSession createSession(String str) throws OrtException {
        return createSession(str, new OrtSession.SessionOptions());
    }

    OrtSession createSession(String str, OrtAllocator ortAllocator, OrtSession.SessionOptions sessionOptions) throws OrtException {
        Objects.requireNonNull(str, "model path must not be null");
        return new OrtSession(this, str, ortAllocator, sessionOptions);
    }

    public OrtSession createSession(String str, OrtSession.SessionOptions sessionOptions) throws OrtException {
        return createSession(str, this.defaultAllocator, sessionOptions);
    }

    public OrtSession createSession(ByteBuffer byteBuffer) throws OrtException {
        return createSession(byteBuffer, new OrtSession.SessionOptions());
    }

    OrtSession createSession(ByteBuffer byteBuffer, OrtAllocator ortAllocator, OrtSession.SessionOptions sessionOptions) throws OrtException {
        Objects.requireNonNull(byteBuffer, "model array must not be null");
        if (byteBuffer.remaining() == 0) {
            throw new OrtException("Invalid model buffer, no elements remaining.");
        }
        if (byteBuffer.isDirect()) {
            return new OrtSession(this, byteBuffer, ortAllocator, sessionOptions);
        }
        throw new OrtException("ByteBuffer is not direct.");
    }

    public OrtSession createSession(ByteBuffer byteBuffer, OrtSession.SessionOptions sessionOptions) throws OrtException {
        return createSession(byteBuffer, this.defaultAllocator, sessionOptions);
    }

    public OrtSession createSession(byte[] bArr) throws OrtException {
        return createSession(bArr, new OrtSession.SessionOptions());
    }

    OrtSession createSession(byte[] bArr, OrtAllocator ortAllocator, OrtSession.SessionOptions sessionOptions) throws OrtException {
        Objects.requireNonNull(bArr, "model array must not be null");
        return new OrtSession(this, bArr, ortAllocator, sessionOptions);
    }

    public OrtSession createSession(byte[] bArr, OrtSession.SessionOptions sessionOptions) throws OrtException {
        return createSession(bArr, this.defaultAllocator, sessionOptions);
    }

    public OrtTrainingSession createTrainingSession(String str, String str2, String str3, String str4) throws OrtException {
        return createTrainingSession(str, str2, str3, str4, new OrtSession.SessionOptions());
    }

    OrtTrainingSession createTrainingSession(String str, String str2, String str3, String str4, OrtAllocator ortAllocator, OrtSession.SessionOptions sessionOptions) throws OrtException {
        if (!OnnxRuntime.trainingEnabled) {
            throw new IllegalStateException("Training is not enabled in this build of ONNX Runtime.");
        }
        Objects.requireNonNull(str2, "train path must not be null");
        return new OrtTrainingSession(this, ortAllocator, sessionOptions, OrtTrainingSession.OrtCheckpointState.loadCheckpoint(str), str2, str3, str4);
    }

    public OrtTrainingSession createTrainingSession(String str, String str2, String str3, String str4, OrtSession.SessionOptions sessionOptions) throws OrtException {
        return createTrainingSession(str, str2, str3, str4, this.defaultAllocator, sessionOptions);
    }

    public List<OrtEpDevice> getEpDevices() throws OrtException {
        long[] epDevices = getEpDevices(OnnxRuntime.ortApiHandle, this.nativeHandle);
        ArrayList arrayList = new ArrayList();
        for (long j : epDevices) {
            arrayList.add(new OrtEpDevice(j));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public OrtCompiledModelCompatibility getModelCompatibilityForEpDevices(List<OrtEpDevice> list, String str) throws OrtException {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Must supply at least one OrtEpDevice");
        }
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).getNativeHandle();
        }
        return OrtCompiledModelCompatibility.mapFromInt(getModelCompatibilityForEpDevices(OnnxRuntime.ortApiHandle, jArr, str));
    }

    long getNativeHandle() {
        return this.nativeHandle;
    }

    public String getVersion() {
        return OnnxRuntime.version();
    }

    public boolean isTrainingEnabled() {
        return OnnxRuntime.trainingEnabled;
    }

    public void registerExecutionProviderLibrary(String str, String str2) throws OrtException {
        registerExecutionProviderLibrary(OnnxRuntime.ortApiHandle, this.nativeHandle, str, str2);
    }

    public void setTelemetry(boolean z) throws OrtException {
        setTelemetry(OnnxRuntime.ortApiHandle, this.nativeHandle, z);
    }

    public String toString() {
        return "OrtEnvironment(name=" + curLoggingName + ",logLevel=" + curLogLevel + ",version=" + getVersion() + ")";
    }

    public void unregisterExecutionProviderLibrary(String str) throws OrtException {
        unregisterExecutionProviderLibrary(OnnxRuntime.ortApiHandle, this.nativeHandle, str);
    }
}
