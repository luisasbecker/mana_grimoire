package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface IOComparator<T> {
    default Comparator<T> asComparator() {
        return new Comparator() { // from class: org.apache.commons.io.function.IOComparator$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Uncheck.compare(this.f$0, obj, obj2);
            }
        };
    }

    int compare(T t, T t2) throws IOException;
}
