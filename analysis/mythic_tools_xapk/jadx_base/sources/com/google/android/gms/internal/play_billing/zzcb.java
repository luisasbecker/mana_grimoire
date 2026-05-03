package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcb {
    public static Object zza(Iterable iterable, Object obj) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }
}
