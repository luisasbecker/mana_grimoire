package ai.onnxruntime;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class OrtLoraAdapter implements AutoCloseable {
    private boolean closed = false;
    private final long nativeHandle;

    static {
        try {
            OnnxRuntime.init();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load onnx-runtime library", e);
        }
    }

    private OrtLoraAdapter(long j) {
        this.nativeHandle = j;
    }

    private static native void close(long j, long j2);

    public static OrtLoraAdapter create(String str) throws OrtException {
        return create(str, (OrtAllocator) null);
    }

    static OrtLoraAdapter create(String str, OrtAllocator ortAllocator) throws OrtException {
        return new OrtLoraAdapter(createLoraAdapter(OnnxRuntime.ortApiHandle, str, ortAllocator == null ? 0L : ortAllocator.handle));
    }

    public static OrtLoraAdapter create(ByteBuffer byteBuffer) throws OrtException {
        return create(byteBuffer, (OrtAllocator) null);
    }

    static OrtLoraAdapter create(ByteBuffer byteBuffer, OrtAllocator ortAllocator) throws OrtException {
        Objects.requireNonNull(byteBuffer, "LoRA buffer must not be null");
        if (byteBuffer.remaining() == 0) {
            throw new OrtException("Invalid LoRA buffer, no elements remaining.");
        }
        if (!byteBuffer.isDirect()) {
            throw new OrtException("ByteBuffer is not direct.");
        }
        return new OrtLoraAdapter(createLoraAdapterFromBuffer(OnnxRuntime.ortApiHandle, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), ortAllocator == null ? 0L : ortAllocator.handle));
    }

    public static OrtLoraAdapter create(byte[] bArr) throws OrtException {
        return create(bArr, (OrtAllocator) null);
    }

    static OrtLoraAdapter create(byte[] bArr, OrtAllocator ortAllocator) throws OrtException {
        Objects.requireNonNull(bArr, "LoRA array must not be null");
        return new OrtLoraAdapter(createLoraAdapterFromArray(OnnxRuntime.ortApiHandle, bArr, ortAllocator == null ? 0L : ortAllocator.handle));
    }

    private static native long createLoraAdapter(long j, String str, long j2) throws OrtException;

    private static native long createLoraAdapterFromArray(long j, byte[] bArr, long j2) throws OrtException;

    private static native long createLoraAdapterFromBuffer(long j, ByteBuffer byteBuffer, int i, int i2, long j2) throws OrtException;

    void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("Trying to use a closed OrtLoraAdapter");
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            throw new IllegalStateException("Trying to close an already closed OrtLoraAdapter");
        }
        close(OnnxRuntime.ortApiHandle, this.nativeHandle);
        this.closed = true;
    }

    long getNativeHandle() {
        return this.nativeHandle;
    }
}
