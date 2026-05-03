package com.google.android.gms.internal.mlkit_language_id_common;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:language-id-common@@16.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzj {
    private static final Logger zza = Logger.getLogger(zzj.class.getName());
    private static final zzi zzb = new zzi(null);

    private zzj() {
    }

    static boolean zza(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }
}
