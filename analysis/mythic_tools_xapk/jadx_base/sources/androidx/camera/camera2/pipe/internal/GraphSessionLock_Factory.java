package androidx.camera.camera2.pipe.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class GraphSessionLock_Factory implements Factory<GraphSessionLock> {

    private static final class InstanceHolder {
        static final GraphSessionLock_Factory INSTANCE = new GraphSessionLock_Factory();

        private InstanceHolder() {
        }
    }

    public static GraphSessionLock_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GraphSessionLock newInstance() {
        return new GraphSessionLock();
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GraphSessionLock get() {
        return newInstance();
    }
}
