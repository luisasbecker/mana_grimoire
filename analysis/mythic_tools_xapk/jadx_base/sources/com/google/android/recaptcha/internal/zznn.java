package com.google.android.recaptcha.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes4.dex */
public class zznn extends IOException {
    private boolean zza;

    public zznn(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zznn(String str) {
        super(str);
    }

    final void zza() {
        this.zza = true;
    }

    final boolean zzb() {
        return this.zza;
    }
}
