package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.IntSupplier;

/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface IOIntSupplier {
    default IntSupplier asIntSupplier() {
        return new IntSupplier() { // from class: org.apache.commons.io.function.IOIntSupplier$$ExternalSyntheticLambda0
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return Uncheck.getAsInt(this.f$0);
            }
        };
    }

    int getAsInt() throws IOException;
}
