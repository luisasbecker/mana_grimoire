package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzde {
    static void zza(zzjd zzjdVar, BillingResult billingResult, zzcz zzczVar, int i, int i2) {
        int i3 = zzcy.zza;
        zzczVar.zzb(zzcy.zzb(zzjdVar, i, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), i2);
    }

    static void zzb(zzjd zzjdVar, BillingResult billingResult, zzcz zzczVar, int i, int i2, String str) {
        int i3 = zzcy.zza;
        zzczVar.zzb(zzcy.zzb(zzjdVar, i, billingResult, str, zzjk.BROADCAST_ACTION_UNSPECIFIED), i2);
    }
}
