package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzy extends zzat implements zzz {
    public zzy() {
        super("com.android.vending.billing.IInAppBillingCreateExternalPaymentReportingDetailsCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzat
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzau.zza(parcel, Bundle.CREATOR);
        enforceNoDataAvail(parcel);
        zza(bundle);
        return true;
    }
}
