package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.core.SystemClockOffsets;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class SharedCameraGraphModules_Companion_ProvideSystemClockOffsetsFactory implements Factory<SystemClockOffsets> {

    private static final class InstanceHolder {
        static final SharedCameraGraphModules_Companion_ProvideSystemClockOffsetsFactory INSTANCE = new SharedCameraGraphModules_Companion_ProvideSystemClockOffsetsFactory();

        private InstanceHolder() {
        }
    }

    public static SharedCameraGraphModules_Companion_ProvideSystemClockOffsetsFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SystemClockOffsets provideSystemClockOffsets() {
        return (SystemClockOffsets) Preconditions.checkNotNullFromProvides(SharedCameraGraphModules.INSTANCE.provideSystemClockOffsets());
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SystemClockOffsets get() {
        return provideSystemClockOffsets();
    }
}
