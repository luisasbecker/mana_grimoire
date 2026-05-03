package com.android.billingclient.api;

import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdz {
    private final List zza;
    private final BillingResult zzb;

    public zzdz(BillingResult billingResult, List list) {
        this.zza = list;
        this.zzb = billingResult;
    }

    public final BillingResult zza() {
        return this.zzb;
    }

    public final List zzb() {
        return this.zza;
    }
}
