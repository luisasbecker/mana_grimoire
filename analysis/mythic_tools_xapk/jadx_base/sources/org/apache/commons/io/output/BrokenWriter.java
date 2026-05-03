package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import java.util.function.Supplier;
import org.apache.commons.io.function.Erase;

/* JADX INFO: loaded from: classes7.dex */
public class BrokenWriter extends Writer {
    public static final BrokenWriter INSTANCE = new BrokenWriter();
    private final Supplier<Throwable> exceptionSupplier;

    public BrokenWriter() {
        this((Supplier<Throwable>) new Supplier() { // from class: org.apache.commons.io.output.BrokenWriter$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return BrokenWriter.lambda$new$0();
            }
        });
    }

    @Deprecated
    public BrokenWriter(final IOException iOException) {
        this((Supplier<Throwable>) new Supplier() { // from class: org.apache.commons.io.output.BrokenWriter$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return BrokenWriter.lambda$new$1(iOException);
            }
        });
    }

    public BrokenWriter(final Throwable th) {
        this((Supplier<Throwable>) new Supplier() { // from class: org.apache.commons.io.output.BrokenWriter$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return BrokenWriter.lambda$new$2(th);
            }
        });
    }

    public BrokenWriter(Supplier<Throwable> supplier) {
        this.exceptionSupplier = supplier;
    }

    static /* synthetic */ Throwable lambda$new$0() {
        return new IOException("Broken writer");
    }

    static /* synthetic */ Throwable lambda$new$1(IOException iOException) {
        return iOException;
    }

    static /* synthetic */ Throwable lambda$new$2(Throwable th) {
        return th;
    }

    private RuntimeException rethrow() {
        return Erase.rethrow(this.exceptionSupplier.get());
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw rethrow();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        throw rethrow();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        throw rethrow();
    }
}
