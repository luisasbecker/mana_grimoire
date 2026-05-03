package androidx.camera.camera2.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class VideoUsageControl_Factory implements Factory<VideoUsageControl> {

    private static final class InstanceHolder {
        static final VideoUsageControl_Factory INSTANCE = new VideoUsageControl_Factory();

        private InstanceHolder() {
        }
    }

    public static VideoUsageControl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static VideoUsageControl newInstance() {
        return new VideoUsageControl();
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VideoUsageControl get() {
        return newInstance();
    }
}
