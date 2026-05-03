package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface IOUnaryOperator<T> extends IOFunction<T, T> {
    static <T> IOUnaryOperator<T> identity() {
        return new IOUnaryOperator() { // from class: org.apache.commons.io.function.IOUnaryOperator$$ExternalSyntheticLambda1
            @Override // org.apache.commons.io.function.IOFunction
            public final Object apply(Object obj) {
                return IOUnaryOperator.lambda$identity$0(obj);
            }
        };
    }

    static /* synthetic */ Object lambda$identity$0(Object obj) throws IOException {
        return obj;
    }

    default UnaryOperator<T> asUnaryOperator() {
        return new UnaryOperator() { // from class: org.apache.commons.io.function.IOUnaryOperator$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Uncheck.apply(this.f$0, obj);
            }
        };
    }
}
