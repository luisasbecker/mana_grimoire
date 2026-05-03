package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface IOBooleanSupplier {
    default BooleanSupplier asBooleanSupplier() {
        return new BooleanSupplier() { // from class: org.apache.commons.io.function.IOBooleanSupplier$$ExternalSyntheticLambda0
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return Uncheck.getAsBoolean(this.f$0);
            }
        };
    }

    boolean getAsBoolean() throws IOException;
}
