package com.google.android.libraries.intelligence.acceleration;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.libraries.intelligence.acceleration.process.zzf;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public class ProcessStateObserver implements LifecycleObserver {
    private static final ProcessStateObserver zza = new ProcessStateObserver();

    ProcessStateObserver() {
    }

    public static ProcessStateObserver zza() {
        return zza;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        Analytics.zza(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        Analytics.zza(true);
    }

    public final void zzb() {
        try {
            Analytics.zzb();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                zzf.zza().getLifecycle().addObserver(this);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.libraries.intelligence.acceleration.zze
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzf.zza().getLifecycle().addObserver(this.zza);
                    }
                });
            }
        } catch (UnsatisfiedLinkError unused) {
            throw new UnsatisfiedLinkError("Make sure analytics_jni_lib is loaded. For VisionKit Pipeline, analytics_jni_lib can be loaded by setting `include_acceleration_analytics` of `pipeline_android_library` to `True` and this method should be called after initializing Pipeline.java.");
        }
    }
}
