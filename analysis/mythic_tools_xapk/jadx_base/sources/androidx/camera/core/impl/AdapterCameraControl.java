package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.utils.SessionProcessorUtil;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public class AdapterCameraControl extends ForwardingCameraControl {
    private final CameraControlInternal mCameraControl;
    private final SessionProcessor mSessionProcessor;

    public AdapterCameraControl(CameraControlInternal cameraControlInternal, SessionProcessor sessionProcessor) {
        super(cameraControlInternal);
        this.mCameraControl = cameraControlInternal;
        this.mSessionProcessor = sessionProcessor;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Void> cancelFocusAndMetering() {
        return this.mCameraControl.cancelFocusAndMetering();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Void> enableTorch(boolean z) {
        return !SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 6) ? Futures.immediateFailedFuture(new IllegalStateException("Torch is not supported")) : this.mCameraControl.enableTorch(z);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.impl.CameraControlInternal
    public CameraControlInternal getImplementation() {
        return this.mCameraControl;
    }

    public SessionProcessor getSessionProcessor() {
        return this.mSessionProcessor;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Integer> setExposureCompensationIndex(int i) {
        return !SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 7) ? Futures.immediateFailedFuture(new IllegalStateException("ExposureCompensation is not supported")) : this.mCameraControl.setExposureCompensationIndex(i);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Void> setLinearZoom(float f) {
        Range<Float> extensionZoomRange;
        if (!SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 0)) {
            return Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported"));
        }
        SessionProcessor sessionProcessor = this.mSessionProcessor;
        if (sessionProcessor != null && (extensionZoomRange = sessionProcessor.getExtensionZoomRange()) != null) {
            return (f > 1.0f || f < 0.0f) ? Futures.immediateFailedFuture(new IllegalArgumentException("Requested linearZoom " + f + " is not within valid range [0..1]")) : this.mCameraControl.setZoomRatio(AdapterCameraInfo.getZoomRatioByPercentage(f, ((Float) extensionZoomRange.getLower()).floatValue(), ((Float) extensionZoomRange.getUpper()).floatValue()));
        }
        return this.mCameraControl.setLinearZoom(f);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Void> setZoomRatio(float f) {
        Range<Float> extensionZoomRange;
        if (!SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 0)) {
            return Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported"));
        }
        SessionProcessor sessionProcessor = this.mSessionProcessor;
        return (sessionProcessor == null || (extensionZoomRange = sessionProcessor.getExtensionZoomRange()) == null || (f >= ((Float) extensionZoomRange.getLower()).floatValue() && f <= ((Float) extensionZoomRange.getUpper()).floatValue())) ? this.mCameraControl.setZoomRatio(f) : Futures.immediateFailedFuture(new IllegalArgumentException("Requested zoomRatio " + f + " is not within valid range [" + extensionZoomRange.getLower() + " , " + extensionZoomRange.getUpper() + "]"));
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        FocusMeteringAction modifiedFocusMeteringAction = SessionProcessorUtil.getModifiedFocusMeteringAction(this.mSessionProcessor, focusMeteringAction);
        return modifiedFocusMeteringAction == null ? Futures.immediateFailedFuture(new IllegalStateException("FocusMetering is not supported")) : this.mCameraControl.startFocusAndMetering(modifiedFocusMeteringAction);
    }
}
