package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ao extends am {
    ao(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(axVar, taskCompletionSource);
    }

    @Override // com.google.android.play.core.assetpacks.am, com.google.android.play.core.assetpacks.internal.h
    public final void e(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.e(bundle, bundle2);
        this.f224a.trySetResult((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
