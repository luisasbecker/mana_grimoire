package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbt extends ResultReceiver {
    final /* synthetic */ LaunchExternalLinkResponseListener zza;
    final /* synthetic */ BillingClientImpl zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbt(BillingClientImpl billingClientImpl, Handler handler, LaunchExternalLinkResponseListener launchExternalLinkResponseListener) {
        super(handler);
        this.zza = launchExternalLinkResponseListener;
        Objects.requireNonNull(billingClientImpl);
        this.zzb = billingClientImpl;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(i);
        if (i != 0) {
            if (bundle == null) {
                this.zzb.zzaZ(this.zza, zzdc.zzh, zzjd.NULL_BUNDLE_IN_LAUNCH_EXTERNAL_LINK_RESULT_RECEIVER, null);
                return;
            }
            builderNewBuilder.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzk(bundle, "BillingClient"));
            int i2 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
            BillingClientImpl billingClientImpl = this.zzb;
            zzjd zzjdVarZzb = i2 != 0 ? zzjd.zzb(i2) : zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            BillingResult billingResultBuild = builderNewBuilder.build();
            String string = bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS");
            int i3 = zzcy.zza;
            billingClientImpl.zzbc(zzcy.zzb(zzjdVarZzb, 37, billingResultBuild, string, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        }
        this.zza.onLaunchExternalLinkResponse(builderNewBuilder.build());
    }
}
