package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class UnixLineEndingInputStream extends InputStream {
    private boolean atEos;
    private boolean atSlashCr;
    private boolean atSlashLf;
    private final InputStream in;
    private final boolean lineFeedAtEndOfFile;

    public UnixLineEndingInputStream(InputStream inputStream, boolean z) {
        this.in = inputStream;
        this.lineFeedAtEndOfFile = z;
    }

    private int handleEos(boolean z) {
        if (z || !this.lineFeedAtEndOfFile || this.atSlashLf) {
            return -1;
        }
        this.atSlashLf = true;
        return 10;
    }

    private int readWithUpdate() throws IOException {
        int i = this.in.read();
        boolean z = i == -1;
        this.atEos = z;
        if (z) {
            return i;
        }
        this.atSlashCr = i == 13;
        this.atSlashLf = i == 10;
        return i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.in.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        throw UnsupportedOperationExceptions.mark();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        boolean z = this.atSlashCr;
        if (this.atEos) {
            return handleEos(z);
        }
        int withUpdate = readWithUpdate();
        if (this.atEos) {
            return handleEos(z);
        }
        if (this.atSlashCr) {
            return 10;
        }
        if (!z || !this.atSlashLf) {
            return withUpdate;
        }
        return read();
    }
}
