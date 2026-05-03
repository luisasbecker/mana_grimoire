package androidx.camera.camera2.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class ComboRequestListener_Factory implements Factory<ComboRequestListener> {

    private static final class InstanceHolder {
        static final ComboRequestListener_Factory INSTANCE = new ComboRequestListener_Factory();

        private InstanceHolder() {
        }
    }

    public static ComboRequestListener_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ComboRequestListener newInstance() {
        return new ComboRequestListener();
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ComboRequestListener get() {
        return newInstance();
    }
}
