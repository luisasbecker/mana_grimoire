package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzags implements zznp {
    UNKNOWN_ERROR(0),
    NO_CONNECTION(1),
    RPC_ERROR(2),
    RPC_RETURNED_MALFORMED_RESULT(3),
    RPC_EXPONENTIAL_BACKOFF_FAILED(5),
    RPC_CLIENT_ERROR(6),
    DIRECTORY_CREATION_FAILED(10),
    FILE_WRITE_FAILED(11),
    FILE_READ_FAILED(12),
    FILE_READ_RETURNED_MALFORMED_DATA(13);

    private final int zzl;

    zzags(int i) {
        this.zzl = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zznp
    public final int zza() {
        return this.zzl;
    }
}
