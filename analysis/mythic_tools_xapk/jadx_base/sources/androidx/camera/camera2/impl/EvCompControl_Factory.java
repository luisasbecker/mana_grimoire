package androidx.camera.camera2.impl;

import androidx.camera.camera2.compat.EvCompCompat;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class EvCompControl_Factory implements Factory<EvCompControl> {
    private final Provider<EvCompCompat> compatProvider;

    private EvCompControl_Factory(Provider<EvCompCompat> provider) {
        this.compatProvider = provider;
    }

    public static EvCompControl_Factory create(Provider<EvCompCompat> provider) {
        return new EvCompControl_Factory(provider);
    }

    public static EvCompControl newInstance(EvCompCompat evCompCompat) {
        return new EvCompControl(evCompCompat);
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public EvCompControl get() {
        return newInstance(this.compatProvider.get());
    }
}
