package androidx.camera.core.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class CameraThreadConfig {
    public static CameraThreadConfig create(Executor executor, Handler handler) {
        return new AutoValue_CameraThreadConfig(executor, handler);
    }

    public abstract Executor getCameraExecutor();

    public abstract Handler getSchedulerHandler();
}
