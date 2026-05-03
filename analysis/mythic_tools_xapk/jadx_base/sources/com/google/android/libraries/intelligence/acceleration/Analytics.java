package com.google.android.libraries.intelligence.acceleration;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class Analytics {
    private static native boolean nativeIsProcessInBackground();

    private static native void nativeNotifyProcessLifecycleState(boolean z);

    public static void zza(boolean z) {
        nativeNotifyProcessLifecycleState(z);
    }

    static boolean zzb() {
        return nativeIsProcessInBackground();
    }
}
