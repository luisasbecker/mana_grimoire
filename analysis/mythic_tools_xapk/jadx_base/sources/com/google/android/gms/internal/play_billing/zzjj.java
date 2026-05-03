package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzjj implements zzfx {
    static final zzfx zza = new zzjj();

    private zzjj() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final boolean zza(int i) {
        return (i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : zzjk.ALTERNATIVE_BILLING_ACTION : zzjk.LOCAL_PURCHASES_UPDATED_ACTION : zzjk.PURCHASES_UPDATED_ACTION : zzjk.BROADCAST_ACTION_UNSPECIFIED) != null;
    }
}
