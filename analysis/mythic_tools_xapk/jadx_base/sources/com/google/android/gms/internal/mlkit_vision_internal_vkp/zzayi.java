package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzayi extends LazyInstanceMap {
    private zzayi() {
        throw null;
    }

    /* synthetic */ zzayi(zzayh zzayhVar) {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzaxu zzaxuVar = (zzaxu) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzaxz(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzaxv(MlKitContext.getInstance().getApplicationContext(), zzaxuVar), zzaxuVar.zzb());
    }
}
