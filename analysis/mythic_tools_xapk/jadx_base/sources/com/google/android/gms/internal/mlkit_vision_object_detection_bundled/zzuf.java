package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzuf {
    private final String zza;

    zzuf(String str) {
        Preconditions.checkNotNull(str, "Null FID");
        int length = str.length();
        Preconditions.checkArgument(length == 22, "Invalid FID: must be exactly 22 characters: ".concat(String.valueOf(str)));
        char cCharAt = str.charAt(0);
        Preconditions.checkArgument(cCharAt >= 'c' && cCharAt <= 'f', "Invalid FID: must start with [c-f]: ".concat(String.valueOf(str)));
        for (int i = 0; i < length; i++) {
            char cCharAt2 = str.charAt(i);
            Preconditions.checkArgument((cCharAt2 >= '0' && cCharAt2 <= '9') || (cCharAt2 >= 'a' && cCharAt2 <= 'z') || ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || cCharAt2 == '-' || cCharAt2 == '_'), "Invalid FID: must contain only URL-safe base-64 characters: ".concat(String.valueOf(str)));
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzuf) {
            return this.zza.equals(((zzuf) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String zza() {
        return this.zza;
    }
}
