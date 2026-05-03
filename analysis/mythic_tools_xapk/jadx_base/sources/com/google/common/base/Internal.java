package com.google.common.base;

import java.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class Internal {
    private Internal() {
    }

    static long toNanosSaturated(Duration duration) {
        try {
            return duration.toNanos();
        } catch (ArithmeticException unused) {
            return duration.isNegative() ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
    }
}
