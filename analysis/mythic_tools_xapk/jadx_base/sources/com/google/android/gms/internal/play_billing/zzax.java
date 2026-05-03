package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzax extends zzat implements zzay {
    public static zzay zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
        return iInterfaceQueryLocalInterface instanceof zzay ? (zzay) iInterfaceQueryLocalInterface : new zzaw(iBinder);
    }

    @Override // com.google.android.gms.internal.play_billing.zzat
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        throw null;
    }
}
