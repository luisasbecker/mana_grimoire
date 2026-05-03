package org.apache.commons.io.function;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface IORunnable {
    static IORunnable noop() {
        return Constants.IO_RUNNABLE;
    }

    default Runnable asRunnable() {
        return new Runnable() { // from class: org.apache.commons.io.function.IORunnable$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Uncheck.run(this.f$0);
            }
        };
    }

    void run() throws IOException;
}
