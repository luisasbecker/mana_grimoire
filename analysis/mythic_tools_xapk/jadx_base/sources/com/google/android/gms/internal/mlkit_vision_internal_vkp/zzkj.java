package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzkj {
    public static int zza(int i, int i2, String str) {
        String strZza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZza = zzkp.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strZza = zzkp.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzh(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    public static Object zzc(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static void zzd(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zze(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? zzh(i, i3, "start index") : (i2 < 0 || i2 > i3) ? zzh(i2, i3, "end index") : zzkp.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static void zzf(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zzg(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzh(int i, int i2, String str) {
        if (i < 0) {
            return zzkp.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzkp.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
