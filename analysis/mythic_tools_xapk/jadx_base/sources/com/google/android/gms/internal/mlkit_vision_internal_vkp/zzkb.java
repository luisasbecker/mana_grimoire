package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzkb {
    public static boolean zza(CharSequence charSequence, CharSequence charSequence2) {
        int iZzb;
        int length = charSequence.length();
        if (charSequence == "application/x-protobuf") {
            return true;
        }
        if (length != "application/x-protobuf".length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            char cCharAt2 = "application/x-protobuf".charAt(i);
            if (cCharAt != cCharAt2 && ((iZzb = zzb(cCharAt)) >= 26 || iZzb != zzb(cCharAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int zzb(char c) {
        return (char) ((c | ' ') - 97);
    }
}
