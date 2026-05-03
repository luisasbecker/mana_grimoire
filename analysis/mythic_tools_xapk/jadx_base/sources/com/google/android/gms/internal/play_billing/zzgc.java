package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzgc extends IOException {
    public zzgc(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzgc(String str) {
        super(str);
    }
}
