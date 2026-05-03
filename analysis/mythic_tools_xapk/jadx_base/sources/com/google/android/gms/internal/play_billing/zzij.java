package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzij {
    static /* bridge */ /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzgc {
        if (zze(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || zze(b3) || zze(b4)) {
            throw new zzgc("Protocol message had invalid UTF-8.");
        }
        int i2 = ((b & 7) << 18) | ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016 A[PHI: r2
      0x0016: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0011, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* bridge */ /* synthetic */ void zzb(byte b, byte b2, byte b3, char[] cArr, int i) throws zzgc {
        if (!zze(b2)) {
            if (b != -32) {
                if (b != -19) {
                    if (!zze(b3)) {
                        cArr[i] = (char) (((b & Ascii.SI) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                        return;
                    }
                } else if (b2 < -96) {
                    b = -19;
                    if (!zze(b3)) {
                    }
                }
            } else if (b2 >= -96) {
                b = -32;
                if (b != -19) {
                }
            }
        }
        throw new zzgc("Protocol message had invalid UTF-8.");
    }

    static /* bridge */ /* synthetic */ void zzc(byte b, byte b2, char[] cArr, int i) throws zzgc {
        if (b < -62 || zze(b2)) {
            throw new zzgc("Protocol message had invalid UTF-8.");
        }
        cArr[i] = (char) (((b & Ascii.US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }

    static /* bridge */ /* synthetic */ boolean zzd(byte b) {
        return b >= 0;
    }

    private static boolean zze(byte b) {
        return b > -65;
    }
}
