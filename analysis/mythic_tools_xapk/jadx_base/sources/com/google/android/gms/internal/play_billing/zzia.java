package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzia extends RuntimeException {
    public zzia(zzhb zzhbVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzgc zza() {
        return new zzgc(getMessage());
    }
}
