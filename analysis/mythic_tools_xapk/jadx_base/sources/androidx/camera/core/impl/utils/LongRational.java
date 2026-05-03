package androidx.camera.core.impl.utils;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

/* JADX INFO: loaded from: classes.dex */
final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    LongRational(double d) {
        this((long) (d * 10000.0d), 10000L);
    }

    LongRational(long j, long j2) {
        this.mNumerator = j;
        this.mDenominator = j2;
    }

    long getDenominator() {
        return this.mDenominator;
    }

    long getNumerator() {
        return this.mNumerator;
    }

    double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    public String toString() {
        return this.mNumerator + DomExceptionUtils.SEPARATOR + this.mDenominator;
    }
}
