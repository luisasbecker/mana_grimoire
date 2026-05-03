package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.CharBuffer;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.IOBooleanSupplier;
import org.apache.commons.io.function.IOFunction;
import org.apache.commons.io.function.IOIntConsumer;
import org.apache.commons.io.function.IOIntSupplier;
import org.apache.commons.io.function.IORunnable;
import org.apache.commons.io.function.IOSupplier;
import org.apache.commons.io.function.IOTriFunction;
import org.apache.commons.io.function.Uncheck;

/* JADX INFO: loaded from: classes7.dex */
public final class UncheckedFilterReader extends FilterReader {

    public static class Builder extends AbstractStreamBuilder<UncheckedFilterReader, Builder> {
        @Override // org.apache.commons.io.function.IOSupplier
        public UncheckedFilterReader get() {
            return (UncheckedFilterReader) Uncheck.get(new IOSupplier() { // from class: org.apache.commons.io.input.UncheckedFilterReader$Builder$$ExternalSyntheticLambda0
                @Override // org.apache.commons.io.function.IOSupplier
                public final Object get() {
                    return this.f$0.m13304x24463752();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$get$0$org-apache-commons-io-input-UncheckedFilterReader$Builder, reason: not valid java name */
        /* synthetic */ UncheckedFilterReader m13304x24463752() throws IOException {
            return new UncheckedFilterReader(this);
        }
    }

    private UncheckedFilterReader(Builder builder) throws IOException {
        super(builder.getReader());
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws UncheckedIOException {
        Uncheck.run(new IORunnable() { // from class: org.apache.commons.io.input.UncheckedFilterReader$$ExternalSyntheticLambda3
            @Override // org.apache.commons.io.function.IORunnable
            public final void run() throws IOException {
                this.f$0.m13295lambda$close$0$orgapachecommonsioinputUncheckedFilterReader();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$close$0$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ void m13295lambda$close$0$orgapachecommonsioinputUncheckedFilterReader() throws IOException {
        super.close();
    }

    /* JADX INFO: renamed from: lambda$mark$1$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ void m13296lambda$mark$1$orgapachecommonsioinputUncheckedFilterReader(int i) throws IOException {
        super.mark(i);
    }

    /* JADX INFO: renamed from: lambda$read$2$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ int m13297lambda$read$2$orgapachecommonsioinputUncheckedFilterReader() throws IOException {
        return super.read();
    }

    /* JADX INFO: renamed from: lambda$read$3$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ Integer m13298lambda$read$3$orgapachecommonsioinputUncheckedFilterReader(char[] cArr) throws IOException {
        return Integer.valueOf(super.read(cArr));
    }

    /* JADX INFO: renamed from: lambda$read$4$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ Integer m13299lambda$read$4$orgapachecommonsioinputUncheckedFilterReader(char[] cArr, int i, int i2) throws IOException {
        return Integer.valueOf(super.read(cArr, i, i2));
    }

    /* JADX INFO: renamed from: lambda$read$5$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ Integer m13300lambda$read$5$orgapachecommonsioinputUncheckedFilterReader(CharBuffer charBuffer) throws IOException {
        return Integer.valueOf(super.read(charBuffer));
    }

    /* JADX INFO: renamed from: lambda$ready$6$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ boolean m13301lambda$ready$6$orgapachecommonsioinputUncheckedFilterReader() throws IOException {
        return super.ready();
    }

    /* JADX INFO: renamed from: lambda$reset$7$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ void m13302lambda$reset$7$orgapachecommonsioinputUncheckedFilterReader() throws IOException {
        super.reset();
    }

    /* JADX INFO: renamed from: lambda$skip$8$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ Long m13303lambda$skip$8$orgapachecommonsioinputUncheckedFilterReader(long j) throws IOException {
        return Long.valueOf(super.skip(j));
    }

    @Override // java.io.FilterReader, java.io.Reader
    public void mark(int i) throws UncheckedIOException {
        Uncheck.accept(new IOIntConsumer() { // from class: org.apache.commons.io.input.UncheckedFilterReader$$ExternalSyntheticLambda6
            @Override // org.apache.commons.io.function.IOIntConsumer
            public final void accept(int i2) throws IOException {
                this.f$0.m13296lambda$mark$1$orgapachecommonsioinputUncheckedFilterReader(i2);
            }
        }, i);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws UncheckedIOException {
        return Uncheck.getAsInt(new IOIntSupplier() { // from class: org.apache.commons.io.input.UncheckedFilterReader$$ExternalSyntheticLambda0
            @Override // org.apache.commons.io.function.IOIntSupplier
            public final int getAsInt() {
                return this.f$0.m13297lambda$read$2$orgapachecommonsioinputUncheckedFilterReader();
            }
        });
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new IOFunction() { // from class: org.apache.commons.io.input.UncheckedFilterReader$$ExternalSyntheticLambda2
            @Override // org.apache.commons.io.function.IOFunction
            public final Object apply(Object obj) {
                return this.f$0.m13300lambda$read$5$orgapachecommonsioinputUncheckedFilterReader((CharBuffer) obj);
            }
        }, charBuffer)).intValue();
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new IOFunction() { // from class: org.apache.commons.io.input.UncheckedFilterReader$$ExternalSyntheticLambda4
            @Override // org.apache.commons.io.function.IOFunction
            public final Object apply(Object obj) {
                return this.f$0.m13298lambda$read$3$orgapachecommonsioinputUncheckedFilterReader((char[]) obj);
            }
        }, cArr)).intValue();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new IOTriFunction() { // from class: org.apache.commons.io.input.UncheckedFilterReader$$ExternalSyntheticLambda1
            @Override // org.apache.commons.io.function.IOTriFunction
            public final Object apply(Object obj, Object obj2, Object obj3) {
                return this.f$0.m13299lambda$read$4$orgapachecommonsioinputUncheckedFilterReader((char[]) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            }
        }, cArr, Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() throws UncheckedIOException {
        return Uncheck.getAsBoolean(new IOBooleanSupplier() { // from class: org.apache.commons.io.input.UncheckedFilterReader$$ExternalSyntheticLambda5
            @Override // org.apache.commons.io.function.IOBooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.m13301lambda$ready$6$orgapachecommonsioinputUncheckedFilterReader();
            }
        });
    }

    @Override // java.io.FilterReader, java.io.Reader
    public void reset() throws UncheckedIOException {
        Uncheck.run(new IORunnable() { // from class: org.apache.commons.io.input.UncheckedFilterReader$$ExternalSyntheticLambda7
            @Override // org.apache.commons.io.function.IORunnable
            public final void run() throws IOException {
                this.f$0.m13302lambda$reset$7$orgapachecommonsioinputUncheckedFilterReader();
            }
        });
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long j) throws UncheckedIOException {
        return ((Long) Uncheck.apply(new IOFunction() { // from class: org.apache.commons.io.input.UncheckedFilterReader$$ExternalSyntheticLambda8
            @Override // org.apache.commons.io.function.IOFunction
            public final Object apply(Object obj) {
                return this.f$0.m13303lambda$skip$8$orgapachecommonsioinputUncheckedFilterReader(((Long) obj).longValue());
            }
        }, Long.valueOf(j))).longValue();
    }
}
