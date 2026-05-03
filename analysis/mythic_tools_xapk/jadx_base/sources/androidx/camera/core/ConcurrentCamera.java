package androidx.camera.core;

import androidx.lifecycle.LifecycleOwner;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConcurrentCamera {
    private List<Camera> mCameras;

    public static final class SingleCameraConfig {
        private CameraSelector mCameraSelector;
        private CompositionSettings mCompositionSettings;
        private LifecycleOwner mLifecycleOwner;
        private UseCaseGroup mUseCaseGroup;

        public SingleCameraConfig(CameraSelector cameraSelector, UseCaseGroup useCaseGroup, CompositionSettings compositionSettings, LifecycleOwner lifecycleOwner) {
            this.mCameraSelector = cameraSelector;
            this.mUseCaseGroup = useCaseGroup;
            this.mCompositionSettings = compositionSettings;
            this.mLifecycleOwner = lifecycleOwner;
        }

        public SingleCameraConfig(CameraSelector cameraSelector, UseCaseGroup useCaseGroup, LifecycleOwner lifecycleOwner) {
            this(cameraSelector, useCaseGroup, CompositionSettings.DEFAULT, lifecycleOwner);
        }

        public CameraSelector getCameraSelector() {
            return this.mCameraSelector;
        }

        public CompositionSettings getCompositionSettings() {
            return this.mCompositionSettings;
        }

        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        public UseCaseGroup getUseCaseGroup() {
            return this.mUseCaseGroup;
        }
    }

    public ConcurrentCamera(List<Camera> list) {
        this.mCameras = list;
    }

    public List<Camera> getCameras() {
        return this.mCameras;
    }
}
