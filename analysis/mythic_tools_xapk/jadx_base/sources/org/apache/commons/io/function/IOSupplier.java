package org.apache.commons.io.function;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface IOSupplier<T> {
    default Supplier<T> asSupplier() {
        return new Supplier() { // from class: org.apache.commons.io.function.IOSupplier$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.getUnchecked();
            }
        };
    }

    T get() throws IOException;

    default T getUnchecked() throws UncheckedIOException {
        return (T) Uncheck.get(this);
    }
}
