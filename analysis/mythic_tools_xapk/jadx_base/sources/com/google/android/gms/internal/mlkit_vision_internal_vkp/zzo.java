package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;
import androidx.core.content.PermissionChecker;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzo extends zzv {
    zzo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzv
    protected final int zza(Context context, zzu zzuVar, boolean z) {
        return (zzuVar.zza.getAuthority().lastIndexOf(64) < 0 || PermissionChecker.checkSelfPermission(context, "android.permission.INTERACT_ACROSS_USERS") != 0) ? 3 : 2;
    }
}
