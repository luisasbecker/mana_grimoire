package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.StandardOpenOption;
import org.apache.commons.io.build.AbstractStreamBuilder;

/* JADX INFO: loaded from: classes7.dex */
public final class RandomAccessFileOutputStream extends OutputStream {
    private final RandomAccessFile randomAccessFile;

    public static final class Builder extends AbstractStreamBuilder<RandomAccessFileOutputStream, Builder> {
        private Builder() {
            setOpenOptions(StandardOpenOption.WRITE);
        }

        @Override // org.apache.commons.io.function.IOSupplier
        public RandomAccessFileOutputStream get() throws IOException {
            return new RandomAccessFileOutputStream(this);
        }
    }

    private RandomAccessFileOutputStream(Builder builder) throws IOException {
        this.randomAccessFile = builder.getRandomAccessFile();
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.randomAccessFile.close();
        super.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.randomAccessFile.getChannel().force(true);
        super.flush();
    }

    public RandomAccessFile getRandomAccessFile() {
        return this.randomAccessFile;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.randomAccessFile.write(i);
    }
}
