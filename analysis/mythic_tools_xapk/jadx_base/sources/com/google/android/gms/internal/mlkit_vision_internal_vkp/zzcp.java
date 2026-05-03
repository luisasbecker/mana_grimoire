package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcp {
    public static final zzcp zza = new zzcp("VisionKit", 2);
    private final String zzb = "VisionKit";

    public zzcp(String str, int i) {
    }

    private final boolean zzd(int i) {
        return Log.isLoggable(this.zzb, i);
    }

    private static final String zze(Object obj, String str, Object... objArr) {
        String str2;
        if (obj instanceof String) {
            str2 = (String) obj;
        } else {
            String name = obj.getClass().getName();
            if (obj instanceof Class) {
                name = ((Class) obj).getName();
            }
            String[] strArrSplit = name.split("\\.");
            int length = strArrSplit.length;
            str2 = length == 0 ? "" : strArrSplit[length - 1];
        }
        return "[" + str2 + "] " + str;
    }

    public final void zza(Throwable th, String str, Object... objArr) {
        if (zzd(6)) {
            Log.e(this.zzb, "Error in result from JNI layer", th);
        }
    }

    public final void zzb(@Nullable Object obj, String str, Object... objArr) {
        if (zzd(4)) {
            Log.i(this.zzb, zze(obj, str, objArr));
        }
    }

    public final void zzc(@Nullable Object obj, String str, Object... objArr) {
        if (zzd(5)) {
            Log.w(this.zzb, zze(obj, str, objArr));
        }
    }
}
