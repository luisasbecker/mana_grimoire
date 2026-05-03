package ai.onnxruntime;

import ai.onnxruntime.OrtSession;
import java.nio.ByteBuffer;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public final class OrtModelCompilationOptions implements AutoCloseable {
    private ByteBuffer buffer;
    private boolean closed = false;
    private final long nativeHandle;

    public enum OrtCompileApiFlags implements OrtFlags {
        NONE(0),
        ERROR_IF_NO_NODES_COMPILED(1),
        ERROR_IF_OUTPUT_FILE_EXISTS(2);

        public final int value;

        OrtCompileApiFlags(int i) {
            this.value = i;
        }

        @Override // ai.onnxruntime.OrtFlags
        public int getValue() {
            return this.value;
        }
    }

    OrtModelCompilationOptions(long j) {
        this.nativeHandle = j;
    }

    private void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("Trying to use a closed OrtModelCompilationOptions.");
        }
    }

    private static native void close(long j, long j2);

    private static native void compileModel(long j, long j2, long j3, long j4) throws OrtException;

    private static native long createFromSessionOptions(long j, long j2, long j3, long j4) throws OrtException;

    public static OrtModelCompilationOptions createFromSessionOptions(OrtEnvironment ortEnvironment, OrtSession.SessionOptions sessionOptions) throws OrtException {
        return new OrtModelCompilationOptions(createFromSessionOptions(OnnxRuntime.ortApiHandle, OnnxRuntime.ortCompileApiHandle, ortEnvironment.getNativeHandle(), sessionOptions.getNativeHandle()));
    }

    private static native void setCompilationFlags(long j, long j2, long j3, int i) throws OrtException;

    private static native void setEpContextEmbedMode(long j, long j2, long j3, boolean z) throws OrtException;

    private static native void setInputModelFromBuffer(long j, long j2, long j3, ByteBuffer byteBuffer, long j4, long j5) throws OrtException;

    private static native void setInputModelPath(long j, long j2, long j3, String str) throws OrtException;

    private static native void setOutputExternalInitializersPath(long j, long j2, long j3, String str, long j4) throws OrtException;

    private static native void setOutputModelPath(long j, long j2, long j3, String str) throws OrtException;

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            throw new IllegalStateException("Trying to close a closed OrtModelCompilationOptions.");
        }
        close(OnnxRuntime.ortCompileApiHandle, this.nativeHandle);
        this.closed = true;
    }

    public void compileModel() throws OrtException {
        checkClosed();
        compileModel(OnnxRuntime.ortApiHandle, OnnxRuntime.ortCompileApiHandle, OrtEnvironment.getEnvironment().getNativeHandle(), this.nativeHandle);
    }

    public void setCompilationFlags(EnumSet<OrtCompileApiFlags> enumSet) throws OrtException {
        checkClosed();
        setCompilationFlags(OnnxRuntime.ortApiHandle, OnnxRuntime.ortCompileApiHandle, this.nativeHandle, OrtFlags.aggregateToInt(enumSet));
    }

    public void setEpContextEmbedMode(boolean z) throws OrtException {
        checkClosed();
        setEpContextEmbedMode(OnnxRuntime.ortApiHandle, OnnxRuntime.ortCompileApiHandle, this.nativeHandle, z);
    }

    public void setInputModelFromBuffer(ByteBuffer byteBuffer) throws OrtException {
        checkClosed();
        if (byteBuffer.isDirect()) {
            this.buffer = byteBuffer;
        } else {
            this.buffer = ByteBuffer.allocateDirect(byteBuffer.remaining());
            int iPosition = byteBuffer.position();
            this.buffer.put(byteBuffer);
            this.buffer.rewind();
            byteBuffer.position(iPosition);
        }
        setInputModelFromBuffer(OnnxRuntime.ortApiHandle, OnnxRuntime.ortCompileApiHandle, this.nativeHandle, this.buffer, this.buffer.position(), this.buffer.remaining());
    }

    public void setInputModelPath(String str) throws OrtException {
        checkClosed();
        setInputModelPath(OnnxRuntime.ortApiHandle, OnnxRuntime.ortCompileApiHandle, this.nativeHandle, str);
    }

    public void setOutputExternalInitializersPath(String str, long j) throws OrtException {
        checkClosed();
        setOutputExternalInitializersPath(OnnxRuntime.ortApiHandle, OnnxRuntime.ortCompileApiHandle, this.nativeHandle, str, j);
    }

    public void setOutputModelPath(String str) throws OrtException {
        checkClosed();
        setOutputModelPath(OnnxRuntime.ortApiHandle, OnnxRuntime.ortCompileApiHandle, this.nativeHandle, str);
    }
}
