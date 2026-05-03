package com.android.billingclient.api;

import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbs implements BillingClientStateListener {
    final /* synthetic */ com.google.android.gms.internal.play_billing.zzp zza;
    final /* synthetic */ BillingClientImpl zzb;

    zzbs(BillingClientImpl billingClientImpl, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        this.zza = zzpVar;
        Objects.requireNonNull(billingClientImpl);
        this.zzb = billingClientImpl;
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection attempt failed.");
        try {
            this.zza.zzb(zzdc.zzj);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        if (billingClientImpl.zzH != null) {
            billingClientImpl.zzao(new Runnable() { // from class: com.android.billingclient.api.zzbq
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.zza.zzb.zzH.onBillingServiceDisconnected();
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception calling onBillingServiceDisconnected.", th2);
                    }
                }
            });
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(final BillingResult billingResult) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection finished with result: " + billingResult.getResponseCode());
        try {
            this.zza.zzb(billingResult);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        if (billingClientImpl.zzH != null) {
            billingClientImpl.zzao(new Runnable() { // from class: com.android.billingclient.api.zzbr
                @Override // java.lang.Runnable
                public final void run() {
                    zzbs zzbsVar = this.zza;
                    try {
                        zzbsVar.zzb.zzH.onBillingSetupFinished(billingResult);
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception calling onBillingSetupFinished.", th2);
                    }
                }
            });
        }
    }
}
