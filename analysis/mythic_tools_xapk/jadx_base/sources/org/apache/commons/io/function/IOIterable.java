package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes7.dex */
public interface IOIterable<T> {
    default void forEach(IOConsumer<? super T> iOConsumer) throws IOException {
        iterator().forEachRemaining((IOConsumer) Objects.requireNonNull(iOConsumer));
    }

    IOIterator<T> iterator();

    default IOSpliterator<T> spliterator() {
        return IOSpliteratorAdapter.adapt((Spliterator) new UncheckedIOIterable(this).spliterator());
    }

    Iterable<T> unwrap();
}
