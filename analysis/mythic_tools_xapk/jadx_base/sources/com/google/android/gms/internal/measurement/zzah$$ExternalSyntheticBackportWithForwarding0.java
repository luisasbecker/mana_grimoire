package com.google.android.gms.internal.measurement;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzah$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ BigDecimal m(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }

    public static /* synthetic */ boolean m(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
