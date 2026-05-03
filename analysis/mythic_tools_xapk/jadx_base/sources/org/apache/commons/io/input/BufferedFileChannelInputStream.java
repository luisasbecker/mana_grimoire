package org.apache.commons.io.input;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.apache.commons.io.build.AbstractStreamBuilder;

/* JADX INFO: loaded from: classes7.dex */
public final class BufferedFileChannelInputStream extends InputStream {
    private final ByteBuffer byteBuffer;
    private final FileChannel fileChannel;

    public static class Builder extends AbstractStreamBuilder<BufferedFileChannelInputStream, Builder> {
        private FileChannel fileChannel;

        @Override // org.apache.commons.io.function.IOSupplier
        public BufferedFileChannelInputStream get() throws IOException {
            return new BufferedFileChannelInputStream(this);
        }

        public Builder setFileChannel(FileChannel fileChannel) {
            this.fileChannel = fileChannel;
            return this;
        }
    }

    @Deprecated
    public BufferedFileChannelInputStream(File file) throws IOException {
        this(file, 8192);
    }

    @Deprecated
    public BufferedFileChannelInputStream(File file, int i) throws IOException {
        this(file.toPath(), i);
    }

    @Deprecated
    public BufferedFileChannelInputStream(Path path) throws IOException {
        this(path, 8192);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public BufferedFileChannelInputStream(Path path, int i) throws IOException {
        this(((Builder) builder().setPath(path)).setBufferSize(i));
    }

    private BufferedFileChannelInputStream(Builder builder) throws IOException {
        this.fileChannel = builder.fileChannel != null ? builder.fileChannel : FileChannel.open(builder.getPath(), StandardOpenOption.READ);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(builder.getBufferSize());
        this.byteBuffer = byteBufferAllocateDirect;
        byteBufferAllocateDirect.flip();
    }

    public static Builder builder() {
        return new Builder();
    }

    private void clean(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            cleanDirectBuffer(byteBuffer);
        }
    }

    private void cleanDirectBuffer(ByteBuffer byteBuffer) {
        if (ByteBufferCleaner.isSupported()) {
            ByteBufferCleaner.clean(byteBuffer);
        }
    }

    private boolean refill() throws IOException {
        Input.checkOpen(this.fileChannel.isOpen());
        if (this.byteBuffer.hasRemaining()) {
            return true;
        }
        this.byteBuffer.clear();
        int i = 0;
        while (i == 0) {
            i = this.fileChannel.read(this.byteBuffer);
        }
        this.byteBuffer.flip();
        return i >= 0;
    }

    private long skipFromFileChannel(long j) throws IOException {
        long jPosition = this.fileChannel.position();
        long size = this.fileChannel.size();
        long j2 = size - jPosition;
        FileChannel fileChannel = this.fileChannel;
        if (j > j2) {
            fileChannel.position(size);
            return j2;
        }
        fileChannel.position(jPosition + j);
        return j;
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        if (!this.fileChannel.isOpen()) {
            return 0;
        }
        if (!refill()) {
            return 0;
        }
        return this.byteBuffer.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            this.fileChannel.close();
        } finally {
            clean(this.byteBuffer);
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (!refill()) {
            return -1;
        }
        return this.byteBuffer.get() & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i >= 0 && i2 >= 0 && (i3 = i + i2) >= 0) {
            if (i3 <= bArr.length) {
                if (!refill()) {
                    return -1;
                }
                int iMin = Math.min(i2, this.byteBuffer.remaining());
                this.byteBuffer.get(bArr, i, iMin);
                return iMin;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        long jRemaining = this.byteBuffer.remaining();
        ByteBuffer byteBuffer = this.byteBuffer;
        if (jRemaining >= j) {
            byteBuffer.position(byteBuffer.position() + ((int) j));
            return j;
        }
        long jRemaining2 = byteBuffer.remaining();
        this.byteBuffer.position(0);
        this.byteBuffer.flip();
        return jRemaining2 + skipFromFileChannel(j - jRemaining2);
    }
}
