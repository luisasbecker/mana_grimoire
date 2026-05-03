package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzwq implements zzbep {
    static final zzbep zza = new zzwq();

    private zzwq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbep
    public final boolean zza(int i) {
        if (i == 0 || i == 1 || i == 2) {
            return true;
        }
        switch (i) {
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 256:
            case 512:
            case 1024:
            case 2048:
            case 4096:
                break;
        }
        return true;
    }
}
