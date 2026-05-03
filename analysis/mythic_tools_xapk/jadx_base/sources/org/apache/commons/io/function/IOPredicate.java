package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface IOPredicate<T> {
    static <T> IOPredicate<T> alwaysFalse() {
        return (IOPredicate<T>) Constants.IO_PREDICATE_FALSE;
    }

    static <T> IOPredicate<T> alwaysTrue() {
        return (IOPredicate<T>) Constants.IO_PREDICATE_TRUE;
    }

    static <T> IOPredicate<T> isEqual(final Object obj) {
        return obj == null ? new IOPredicate() { // from class: org.apache.commons.io.function.IOPredicate$$ExternalSyntheticLambda1
            @Override // org.apache.commons.io.function.IOPredicate
            public final boolean test(Object obj2) {
                return Objects.isNull(obj2);
            }
        } : new IOPredicate() { // from class: org.apache.commons.io.function.IOPredicate$$ExternalSyntheticLambda2
            @Override // org.apache.commons.io.function.IOPredicate
            public final boolean test(Object obj2) {
                return obj.equals(obj2);
            }
        };
    }

    static /* synthetic */ boolean lambda$and$1(IOPredicate iOPredicate, IOPredicate iOPredicate2, Object obj) throws IOException {
        return iOPredicate.test(obj) && iOPredicate2.test(obj);
    }

    static /* synthetic */ boolean lambda$negate$3(IOPredicate iOPredicate, Object obj) throws IOException {
        return !iOPredicate.test(obj);
    }

    static /* synthetic */ boolean lambda$or$4(IOPredicate iOPredicate, IOPredicate iOPredicate2, Object obj) throws IOException {
        return iOPredicate.test(obj) || iOPredicate2.test(obj);
    }

    default IOPredicate<T> and(final IOPredicate<? super T> iOPredicate) {
        Objects.requireNonNull(iOPredicate);
        return new IOPredicate() { // from class: org.apache.commons.io.function.IOPredicate$$ExternalSyntheticLambda4
            @Override // org.apache.commons.io.function.IOPredicate
            public final boolean test(Object obj) {
                return IOPredicate.lambda$and$1(this.f$0, iOPredicate, obj);
            }
        };
    }

    default Predicate<T> asPredicate() {
        return new Predicate() { // from class: org.apache.commons.io.function.IOPredicate$$ExternalSyntheticLambda5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Uncheck.test(this.f$0, obj);
            }
        };
    }

    default IOPredicate<T> negate() {
        return new IOPredicate() { // from class: org.apache.commons.io.function.IOPredicate$$ExternalSyntheticLambda0
            @Override // org.apache.commons.io.function.IOPredicate
            public final boolean test(Object obj) {
                return IOPredicate.lambda$negate$3(this.f$0, obj);
            }
        };
    }

    default IOPredicate<T> or(final IOPredicate<? super T> iOPredicate) {
        Objects.requireNonNull(iOPredicate);
        return new IOPredicate() { // from class: org.apache.commons.io.function.IOPredicate$$ExternalSyntheticLambda3
            @Override // org.apache.commons.io.function.IOPredicate
            public final boolean test(Object obj) {
                return IOPredicate.lambda$or$4(this.f$0, iOPredicate, obj);
            }
        };
    }

    boolean test(T t) throws IOException;
}
