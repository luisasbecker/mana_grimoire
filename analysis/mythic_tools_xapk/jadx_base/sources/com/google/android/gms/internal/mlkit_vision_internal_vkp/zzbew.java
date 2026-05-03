package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public class zzbew extends IOException {
    private boolean zza;

    public zzbew(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzbew(String str) {
        super(str);
    }

    final void zza() {
        this.zza = true;
    }

    final boolean zzb() {
        return this.zza;
    }
}
