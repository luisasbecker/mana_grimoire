package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzsw implements zzbw {
    UNKNOWN_ERROR(0),
    NO_CONNECTION(1),
    RPC_ERROR(2),
    RPC_RETURNED_INVALID_RESULT(3),
    RPC_RETURNED_MALFORMED_RESULT(4),
    RPC_EXPONENTIAL_BACKOFF_FAILED(5),
    DIRECTORY_CREATION_FAILED(10),
    FILE_WRITE_FAILED_DISK_FULL(11),
    FILE_WRITE_FAILED(12),
    FILE_READ_FAILED(13),
    FILE_READ_RETURNED_INVALID_DATA(14),
    FILE_READ_RETURNED_MALFORMED_DATA(15);

    private final int zzn;

    zzsw(int i) {
        this.zzn = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzbw
    public final int zza() {
        return this.zzn;
    }
}
