package androidx.camera.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.LiveDataUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.UseCaseUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.FileDescriptorOutputOptions;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.HighSpeedVideoSessionConfig;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.OutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.RotationProvider;
import androidx.camera.view.internal.ScreenFlashUiInfo;
import androidx.camera.view.video.AudioConfig;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class CameraController {
    private static final float AE_SIZE = 0.25f;
    private static final float AF_SIZE = 0.16666667f;
    private static final String CAMERA_NOT_ATTACHED = "Use cases not attached to camera.";
    private static final String CAMERA_NOT_INITIALIZED = "Camera not initialized.";

    @Deprecated
    public static final int COORDINATE_SYSTEM_VIEW_REFERENCED = 1;
    public static final int IMAGE_ANALYSIS = 2;
    public static final int IMAGE_CAPTURE = 1;
    private static final String IMAGE_CAPTURE_DISABLED = "ImageCapture disabled.";
    private static final ImageCapture.ScreenFlash NO_OP_SCREEN_FLASH = new ImageCapture.ScreenFlash() { // from class: androidx.camera.view.CameraController.1
        @Override // androidx.camera.core.ImageCapture.ScreenFlash
        public void apply(long j, ImageCapture.ScreenFlashListener screenFlashListener) {
            screenFlashListener.onCompleted();
        }

        @Override // androidx.camera.core.ImageCapture.ScreenFlash
        public void clear() {
        }
    };
    private static final String PREVIEW_VIEW_NOT_ATTACHED = "PreviewView not attached to CameraController.";
    private static final String TAG = "CameraController";
    public static final int TAP_TO_FOCUS_FAILED = 4;
    public static final int TAP_TO_FOCUS_FOCUSED = 2;
    public static final int TAP_TO_FOCUS_NOT_FOCUSED = 3;
    public static final int TAP_TO_FOCUS_NOT_STARTED = 0;
    public static final int TAP_TO_FOCUS_STARTED = 1;
    public static final int VIDEO_CAPTURE = 4;
    private static final String VIDEO_CAPTURE_DISABLED = "VideoCapture disabled.";
    private static final String VIDEO_RECORDING_UNFINISHED = "Recording video. Only one recording can be active at a time.";
    Recording mActiveRecording;
    private ImageAnalysis.Analyzer mAnalysisAnalyzer;
    private Executor mAnalysisBackgroundExecutor;
    private Executor mAnalysisExecutor;
    private final Context mAppContext;
    private SessionConfig mBoundSessionConfig;
    Camera mCamera;
    ProcessCameraProviderWrapper mCameraProvider;
    CameraSelector mCameraSelector;
    final RotationProvider.Listener mDeviceRotationListener;
    private final Set<CameraEffect> mEffects;
    private int mEnabledUseCases;
    private FocusMeteringResultCallback mFocusMeteringResultCallback;
    ImageAnalysis mImageAnalysis;
    ResolutionSelector mImageAnalysisResolutionSelector;
    OutputSize mImageAnalysisTargetSize;
    ImageCapture mImageCapture;
    Executor mImageCaptureIoExecutor;
    ResolutionSelector mImageCaptureResolutionSelector;
    OutputSize mImageCaptureTargetSize;
    private final ListenableFuture<Void> mInitializationFuture;
    private int mLastKnownRotation;
    private final PendingValue<Boolean> mPendingEnableTorch;
    private final PendingValue<Float> mPendingLinearZoom;
    private final PendingValue<Float> mPendingZoomRatio;
    private boolean mPinchToZoomEnabled;
    Preview mPreview;
    private DynamicRange mPreviewDynamicRange;
    ResolutionSelector mPreviewResolutionSelector;
    OutputSize mPreviewTargetSize;
    Map<Consumer<VideoRecordEvent>, Recording> mRecordingMap;
    private final RotationProvider mRotationProvider;
    private final Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> mScreenFlashUiInfoMap;
    private SessionConfig mSessionConfig;
    Preview.SurfaceProvider mSurfaceProvider;
    private long mTapToFocusAutoCancelDurationNanos;
    private boolean mTapToFocusEnabled;
    final MutableLiveData<TapToFocusInfo> mTapToFocusInfoState;
    final LiveData<Integer> mTapToFocusState;
    private final ForwardingLiveData<Integer> mTorchState;
    VideoCapture<Recorder> mVideoCapture;
    private DynamicRange mVideoCaptureDynamicRange;
    private int mVideoCaptureMirrorMode;
    QualitySelector mVideoCaptureQualitySelector;
    private Range<Integer> mVideoCaptureTargetFrameRate;
    ViewPort mViewPort;
    private final ForwardingLiveData<ZoomState> mZoomState;

    /* JADX INFO: renamed from: androidx.camera.view.CameraController$2, reason: invalid class name */
    class AnonymousClass2 implements Consumer<VideoRecordEvent> {
        final /* synthetic */ Consumer val$listener;
        final /* synthetic */ Executor val$mainExecutor;

        AnonymousClass2(Executor executor, Consumer consumer) {
            this.val$mainExecutor = executor;
            this.val$listener = consumer;
        }

        @Override // androidx.core.util.Consumer
        public void accept(VideoRecordEvent videoRecordEvent) {
            if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
                if (Threads.isMainThread()) {
                    CameraController.this.deactivateRecordingByListener(this);
                } else {
                    this.val$mainExecutor.execute(new Runnable() { // from class: androidx.camera.view.CameraController$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m1191lambda$accept$0$androidxcameraviewCameraController$2();
                        }
                    });
                }
            }
            this.val$listener.accept(videoRecordEvent);
        }

        /* JADX INFO: renamed from: lambda$accept$0$androidx-camera-view-CameraController$2, reason: not valid java name */
        /* synthetic */ void m1191lambda$accept$0$androidxcameraviewCameraController$2() {
            CameraController.this.deactivateRecordingByListener(this);
        }
    }

    static class FocusMeteringResultCallback implements FutureCallback<FocusMeteringResult> {
        private boolean mIsCanceled = false;
        private final Object mLock = new Object();
        private final PointF mTapPoint;
        private final MutableLiveData<TapToFocusInfo> mTapToFocusInfoState;

        FocusMeteringResultCallback(PointF pointF, MutableLiveData<TapToFocusInfo> mutableLiveData) {
            this.mTapPoint = pointF;
            this.mTapToFocusInfoState = mutableLiveData;
        }

        void close() {
            synchronized (this.mLock) {
                this.mIsCanceled = true;
            }
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onFailure(Throwable th) {
            synchronized (this.mLock) {
                if (this.mIsCanceled) {
                    return;
                }
                if (!(th instanceof CameraControl.OperationCanceledException)) {
                    Logger.d(CameraController.TAG, "Tap-to-focus failed.", th);
                    this.mTapToFocusInfoState.postValue(new TapToFocusInfo(4, this.mTapPoint));
                } else {
                    Logger.d(CameraController.TAG, "Tap-to-focus canceled", th);
                    this.mTapToFocusInfoState.postValue(new TapToFocusInfo(0, null));
                    close();
                }
            }
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onSuccess(FocusMeteringResult focusMeteringResult) {
            synchronized (this.mLock) {
                if (this.mIsCanceled) {
                    return;
                }
                if (focusMeteringResult == null) {
                    return;
                }
                Logger.d(CameraController.TAG, "Tap-to-focus onSuccess: " + focusMeteringResult.isFocusSuccessful());
                this.mTapToFocusInfoState.postValue(new TapToFocusInfo(focusMeteringResult.isFocusSuccessful() ? 2 : 3, this.mTapPoint));
            }
        }

        void resetStateAndClose() {
            synchronized (this.mLock) {
                if (this.mIsCanceled) {
                    return;
                }
                Logger.d(CameraController.TAG, "Tap-to-focus reset.");
                this.mTapToFocusInfoState.postValue(new TapToFocusInfo(0, null));
                this.mIsCanceled = true;
            }
        }
    }

    @Deprecated
    public static final class OutputSize {
        public static final int UNASSIGNED_ASPECT_RATIO = -1;
        private final int mAspectRatio;
        private final Size mResolution;

        @Retention(RetentionPolicy.SOURCE)
        public @interface OutputAspectRatio {
        }

        public OutputSize(int i) {
            Preconditions.checkArgument(i != -1);
            this.mAspectRatio = i;
            this.mResolution = null;
        }

        public OutputSize(Size size) {
            Preconditions.checkNotNull(size);
            this.mAspectRatio = -1;
            this.mResolution = size;
        }

        public int getAspectRatio() {
            return this.mAspectRatio;
        }

        public Size getResolution() {
            return this.mResolution;
        }

        public String toString() {
            return "aspect ratio: " + this.mAspectRatio + " resolution: " + this.mResolution;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UseCases {
    }

    CameraController(Context context) {
        this(context, Futures.transform(ProcessCameraProvider.getInstance(context), new Function() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda9
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return new ProcessCameraProviderWrapperImpl((ProcessCameraProvider) obj);
            }
        }, CameraXExecutors.directExecutor()));
    }

    CameraController(Context context, ListenableFuture<ProcessCameraProviderWrapper> listenableFuture) {
        this.mCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
        this.mEnabledUseCases = 3;
        this.mActiveRecording = null;
        this.mRecordingMap = new HashMap();
        this.mVideoCaptureQualitySelector = Recorder.DEFAULT_QUALITY_SELECTOR;
        this.mVideoCaptureMirrorMode = 0;
        this.mVideoCaptureDynamicRange = DynamicRange.UNSPECIFIED;
        this.mPreviewDynamicRange = DynamicRange.UNSPECIFIED;
        this.mVideoCaptureTargetFrameRate = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        this.mLastKnownRotation = -1;
        this.mPinchToZoomEnabled = true;
        this.mTapToFocusEnabled = true;
        this.mZoomState = new ForwardingLiveData<>();
        this.mTorchState = new ForwardingLiveData<>();
        MutableLiveData<TapToFocusInfo> mutableLiveData = new MutableLiveData<>(new TapToFocusInfo(0, null));
        this.mTapToFocusInfoState = mutableLiveData;
        this.mTapToFocusState = LiveDataUtil.map(mutableLiveData, new Function() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda6
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((TapToFocusInfo) obj).getFocusState());
            }
        });
        this.mPendingEnableTorch = new PendingValue<>();
        this.mPendingLinearZoom = new PendingValue<>();
        this.mPendingZoomRatio = new PendingValue<>();
        this.mEffects = new HashSet();
        this.mScreenFlashUiInfoMap = new HashMap();
        this.mTapToFocusAutoCancelDurationNanos = TimeUnit.MILLISECONDS.toNanos(5000L);
        this.mSessionConfig = null;
        this.mBoundSessionConfig = null;
        Context persistentApplicationContext = ContextUtil.getPersistentApplicationContext(context);
        this.mAppContext = persistentApplicationContext;
        this.mPreview = createPreview();
        this.mImageCapture = createImageCapture(null);
        this.mImageAnalysis = createImageAnalysis(null, null, null);
        this.mVideoCapture = createVideoCapture();
        this.mInitializationFuture = Futures.transform(listenableFuture, new Function() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f$0.m1186lambda$new$0$androidxcameraviewCameraController((ProcessCameraProviderWrapper) obj);
            }
        }, CameraXExecutors.mainThreadExecutor());
        this.mRotationProvider = new RotationProvider(persistentApplicationContext);
        this.mDeviceRotationListener = new RotationProvider.Listener() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda8
            @Override // androidx.camera.view.RotationProvider.Listener
            public final void onRotationChanged(int i) {
                this.f$0.m1187lambda$new$1$androidxcameraviewCameraController(i);
            }
        };
    }

    private void checkAudioPermissionGranted() {
        if (PermissionChecker.checkSelfPermission(this.mAppContext, "android.permission.RECORD_AUDIO") == -1) {
            throw new SecurityException("Attempted to start recording with audio, but application does not have RECORD_AUDIO permission granted.");
        }
    }

    private void configureResolution(ImageOutputConfig.Builder<?> builder, ResolutionSelector resolutionSelector, OutputSize outputSize) {
        AspectRatioStrategy viewportAspectRatioStrategy;
        if (resolutionSelector != null) {
            builder.setResolutionSelector(resolutionSelector);
            return;
        }
        if (outputSize != null) {
            setTargetOutputSize(builder, outputSize);
            return;
        }
        ViewPort viewPort = this.mViewPort;
        if (viewPort == null || (viewportAspectRatioStrategy = getViewportAspectRatioStrategy(viewPort)) == null) {
            return;
        }
        builder.setResolutionSelector(new ResolutionSelector.Builder().setAspectRatioStrategy(viewportAspectRatioStrategy).build());
    }

    private FocusMeteringAction createFocusMeteringAction(MeteringPointFactory meteringPointFactory, PointF pointF) {
        FocusMeteringAction.Builder builderAddPoint = new FocusMeteringAction.Builder(meteringPointFactory.createPoint(pointF.x, pointF.y, AF_SIZE), 1).addPoint(meteringPointFactory.createPoint(pointF.x, pointF.y, AE_SIZE), 2);
        long j = this.mTapToFocusAutoCancelDurationNanos;
        return (j > 0 ? builderAddPoint.setAutoCancelDuration(j, TimeUnit.NANOSECONDS) : builderAddPoint.disableAutoCancel()).build();
    }

    private ImageAnalysis createImageAnalysis(Integer num, Integer num2, Integer num3) {
        ImageAnalysis.Builder builder = new ImageAnalysis.Builder();
        if (num != null) {
            builder.setBackpressureStrategy(num.intValue());
        }
        if (num2 != null) {
            builder.setImageQueueDepth(num2.intValue());
        }
        if (num3 != null) {
            builder.setOutputImageFormat(num3.intValue());
        }
        configureResolution(builder, this.mImageAnalysisResolutionSelector, this.mImageAnalysisTargetSize);
        Executor executor = this.mAnalysisBackgroundExecutor;
        if (executor != null) {
            builder.setBackgroundExecutor(executor);
        }
        int i = this.mLastKnownRotation;
        if (i != -1) {
            builder.setTargetRotation(i);
        }
        return builder.build();
    }

    private ImageCapture createImageCapture(Integer num) {
        ImageCapture.Builder builder = new ImageCapture.Builder();
        if (num != null) {
            builder.setCaptureMode(num.intValue());
        }
        configureResolution(builder, this.mImageCaptureResolutionSelector, this.mImageCaptureTargetSize);
        Executor executor = this.mImageCaptureIoExecutor;
        if (executor != null) {
            builder.setIoExecutor(executor);
        }
        int i = this.mLastKnownRotation;
        if (i != -1) {
            builder.setTargetRotation(i);
        }
        return builder.build();
    }

    private Preview createPreview() {
        Preview.Builder builder = new Preview.Builder();
        configureResolution(builder, this.mPreviewResolutionSelector, this.mPreviewTargetSize);
        builder.setDynamicRange(this.mPreviewDynamicRange);
        return builder.build();
    }

    private VideoCapture<Recorder> createVideoCapture() {
        int viewportAspectRatioInt;
        Recorder.Builder qualitySelector = new Recorder.Builder().setQualitySelector(this.mVideoCaptureQualitySelector);
        if (this.mViewPort != null && this.mVideoCaptureQualitySelector == Recorder.DEFAULT_QUALITY_SELECTOR && (viewportAspectRatioInt = getViewportAspectRatioInt(this.mViewPort)) != -1) {
            qualitySelector.setAspectRatio(viewportAspectRatioInt);
        }
        VideoCapture.Builder dynamicRange = new VideoCapture.Builder(qualitySelector.build()).setTargetFrameRate(this.mVideoCaptureTargetFrameRate).setMirrorMode(this.mVideoCaptureMirrorMode).setDynamicRange(this.mVideoCaptureDynamicRange);
        int i = this.mLastKnownRotation;
        if (i != -1) {
            dynamicRange.setTargetRotation(i);
        }
        return dynamicRange.build();
    }

    private void deactivateRecording(Recording recording) {
        if (this.mActiveRecording == recording) {
            this.mActiveRecording = null;
        }
    }

    private String getReadableSelectorString(CameraSelector cameraSelector) {
        if (cameraSelector == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder("CameraSelector{");
        Integer lensFacing = cameraSelector.getLensFacing();
        if (lensFacing != null) {
            int iIntValue = lensFacing.intValue();
            if (iIntValue == 0) {
                sb.append("lensFacing=FRONT");
            } else if (iIntValue == 1) {
                sb.append("lensFacing=BACK");
            } else if (iIntValue != 2) {
                sb.append("lensFacing=UNKNOWN(").append(lensFacing).append(")");
            } else {
                sb.append("lensFacing=EXTERNAL");
            }
        } else {
            sb.append("lensFacing=NOT_SPECIFIED");
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getViewportAspectRatioInt(ViewPort viewPort) {
        int sensorRotationDegrees;
        boolean z;
        int relativeImageRotation;
        Rational aspectRatio;
        ProcessCameraProviderWrapper processCameraProviderWrapper;
        int iSurfaceRotationToDegrees = viewPort == null ? 0 : CameraOrientationUtil.surfaceRotationToDegrees(viewPort.getRotation());
        try {
            processCameraProviderWrapper = this.mCameraProvider;
        } catch (IllegalArgumentException e) {
            e = e;
            sensorRotationDegrees = 0;
        }
        if (processCameraProviderWrapper != null) {
            CameraInfo cameraInfo = processCameraProviderWrapper.getCameraInfo(this.mCameraSelector);
            sensorRotationDegrees = cameraInfo.getSensorRotationDegrees();
            try {
                if (cameraInfo.getLensFacing() != 1) {
                    z = false;
                }
            } catch (IllegalArgumentException e2) {
                e = e2;
                Logger.w(TAG, "Failed to retrieve CameraInfo for selector: " + this.getReadableSelectorString(this.mCameraSelector), e);
            }
            relativeImageRotation = CameraOrientationUtil.getRelativeImageRotation(iSurfaceRotationToDegrees, sensorRotationDegrees, z);
            aspectRatio = viewPort.getAspectRatio();
            if (relativeImageRotation != 90 || relativeImageRotation == 270) {
                aspectRatio = new Rational(aspectRatio.getDenominator(), aspectRatio.getNumerator());
            }
            if (aspectRatio.equals(AspectRatioUtil.ASPECT_RATIO_4_3)) {
                return aspectRatio.equals(AspectRatioUtil.ASPECT_RATIO_16_9) ? 1 : -1;
            }
            return 0;
        }
        sensorRotationDegrees = 0;
        z = true;
        relativeImageRotation = CameraOrientationUtil.getRelativeImageRotation(iSurfaceRotationToDegrees, sensorRotationDegrees, z);
        aspectRatio = viewPort.getAspectRatio();
        if (relativeImageRotation != 90) {
            aspectRatio = new Rational(aspectRatio.getDenominator(), aspectRatio.getNumerator());
        }
        if (aspectRatio.equals(AspectRatioUtil.ASPECT_RATIO_4_3)) {
        }
    }

    private AspectRatioStrategy getViewportAspectRatioStrategy(ViewPort viewPort) {
        int viewportAspectRatioInt = getViewportAspectRatioInt(viewPort);
        if (viewportAspectRatioInt != -1) {
            return new AspectRatioStrategy(viewportAspectRatioInt, 1);
        }
        return null;
    }

    private int initializeStateFromSessionConfig(SessionConfig sessionConfig) {
        List<UseCase> useCases = sessionConfig.getUseCases();
        Preview previewFindPreview = UseCaseUtil.findPreview(useCases);
        int i = 0;
        Preconditions.checkArgument(previewFindPreview != null, "A Preview is required for using CameraController!");
        UseCase useCaseFindVideoCapture = UseCaseUtil.findVideoCapture(useCases);
        if (useCaseFindVideoCapture instanceof VideoCapture) {
            VideoCapture<Recorder> videoCapture = (VideoCapture) useCaseFindVideoCapture;
            Preconditions.checkArgument(videoCapture.getOutput() instanceof Recorder, "To set a SessionConfig to the CameraController, the VideoCapture inside must use a Recorder as its Output!");
            this.mVideoCapture = videoCapture;
            i = 4;
        } else {
            this.mVideoCapture = createVideoCapture();
        }
        this.mPreview = previewFindPreview;
        previewFindPreview.setSurfaceProvider(this.mSurfaceProvider);
        ImageCapture imageCaptureFindImageCapture = UseCaseUtil.findImageCapture(useCases);
        if (imageCaptureFindImageCapture != null) {
            i |= 1;
            this.mImageCapture = imageCaptureFindImageCapture;
        } else {
            this.mImageCapture = createImageCapture(null);
        }
        ImageAnalysis imageAnalysisFindImageAnalysis = UseCaseUtil.findImageAnalysis(useCases);
        if (imageAnalysisFindImageAnalysis == null) {
            this.mImageAnalysis = createImageAnalysis(null, null, null);
            return i;
        }
        int i2 = i | 2;
        this.mImageAnalysis = imageAnalysisFindImageAnalysis;
        return i2;
    }

    private boolean isCameraAttached() {
        return this.mCamera != null;
    }

    private boolean isCameraInitialized() {
        return this.mCameraProvider != null;
    }

    private boolean isConfigurationSupported(CameraSelector cameraSelector, SessionConfig sessionConfig) {
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        CameraInfo cameraInfo = this.mCameraProvider.getCameraInfo(cameraSelector);
        return sessionConfig != null ? cameraInfo.isSessionConfigSupported(sessionConfig) : cameraInfo.isSessionConfigSupported(new SessionConfig.Builder(createUseCaseGroup(false).getUseCases()).build());
    }

    private boolean isOutputSizeEqual(OutputSize outputSize, OutputSize outputSize2) {
        if (outputSize == outputSize2) {
            return true;
        }
        return outputSize != null && outputSize.equals(outputSize2);
    }

    private boolean isPreviewViewAttached() {
        return (this.mSurfaceProvider == null || this.mViewPort == null) ? false : true;
    }

    private boolean isUseCaseEnabled(int i) {
        return (this.mEnabledUseCases & i) != 0;
    }

    private PendingRecording prepareRecording(OutputOptions outputOptions) {
        Recorder recorder = (Recorder) this.mVideoCapture.getOutput();
        if (outputOptions instanceof FileOutputOptions) {
            return recorder.prepareRecording(this.mAppContext, (FileOutputOptions) outputOptions);
        }
        if (outputOptions instanceof FileDescriptorOutputOptions) {
            return recorder.prepareRecording(this.mAppContext, (FileDescriptorOutputOptions) outputOptions);
        }
        if (outputOptions instanceof MediaStoreOutputOptions) {
            return recorder.prepareRecording(this.mAppContext, (MediaStoreOutputOptions) outputOptions);
        }
        throw new IllegalArgumentException("Unsupported OutputOptions type.");
    }

    private void recreateImageAnalysis(Integer num, Integer num2, Integer num3, boolean z) {
        ImageAnalysis.Analyzer analyzer;
        Threads.checkMainThread();
        if (z) {
            unbindAllUseCases();
        }
        ImageAnalysis imageAnalysisCreateImageAnalysis = createImageAnalysis(num, num2, num3);
        this.mImageAnalysis = imageAnalysisCreateImageAnalysis;
        Executor executor = this.mAnalysisExecutor;
        if (executor == null || (analyzer = this.mAnalysisAnalyzer) == null) {
            return;
        }
        imageAnalysisCreateImageAnalysis.setAnalyzer(executor, analyzer);
    }

    private void recreateImageCapture(Integer num, boolean z) {
        if (z) {
            unbindAllUseCases();
        }
        int flashMode = this.mImageCapture.getFlashMode();
        this.mImageCapture = createImageCapture(num);
        setImageCaptureFlashMode(flashMode);
    }

    private void recreatePreview(boolean z) {
        if (z) {
            unbindAllUseCases();
        }
        Preview previewCreatePreview = createPreview();
        this.mPreview = previewCreatePreview;
        Preview.SurfaceProvider surfaceProvider = this.mSurfaceProvider;
        if (surfaceProvider != null) {
            previewCreatePreview.setSurfaceProvider(surfaceProvider);
        }
    }

    private void recreateVideoCapture(boolean z) {
        if (z) {
            unbindAllUseCases();
        }
        this.mVideoCapture = createVideoCapture();
    }

    private void restartCameraIfAnalyzerResolutionChanged(ImageAnalysis.Analyzer analyzer, ImageAnalysis.Analyzer analyzer2) {
        if (Objects.equals(analyzer == null ? null : analyzer.getDefaultTargetResolution(), analyzer2 != null ? analyzer2.getDefaultTargetResolution() : null)) {
            return;
        }
        recreateImageAnalysis(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()), true);
        startCameraAndTrackStates();
    }

    private void setActiveRecording(Recording recording, Consumer<VideoRecordEvent> consumer) {
        this.mRecordingMap.put(consumer, recording);
        this.mActiveRecording = recording;
    }

    private void setTargetOutputSize(ImageOutputConfig.Builder<?> builder, OutputSize outputSize) {
        if (outputSize == null) {
            return;
        }
        if (outputSize.getResolution() != null) {
            builder.setTargetResolution(outputSize.getResolution());
        } else if (outputSize.getAspectRatio() != -1) {
            builder.setTargetAspectRatio(outputSize.getAspectRatio());
        } else {
            Logger.e(TAG, "Invalid target surface size. " + outputSize);
        }
    }

    private float speedUpZoomBy2X(float f) {
        return f > 1.0f ? ((f - 1.0f) * 2.0f) + 1.0f : 1.0f - ((1.0f - f) * 2.0f);
    }

    private void startListeningToRotationEvents() {
        if (this.mRotationProvider.addListener(CameraXExecutors.mainThreadExecutor(), this.mDeviceRotationListener)) {
            return;
        }
        Logger.w(TAG, "The device cannot detect rotation changes.");
    }

    private Recording startRecordingInternal(OutputOptions outputOptions, AudioConfig audioConfig, Executor executor, Consumer<VideoRecordEvent> consumer) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isVideoCaptureEnabled(), VIDEO_CAPTURE_DISABLED);
        Preconditions.checkState(!isRecording(), VIDEO_RECORDING_UNFINISHED);
        Consumer<VideoRecordEvent> consumerWrapListenerToDeactivateRecordingOnFinalized = wrapListenerToDeactivateRecordingOnFinalized(consumer);
        PendingRecording pendingRecordingPrepareRecording = prepareRecording(outputOptions);
        if (audioConfig.getAudioEnabled()) {
            checkAudioPermissionGranted();
            pendingRecordingPrepareRecording.withAudioEnabled();
        }
        Recording recordingStart = pendingRecordingPrepareRecording.start(executor, consumerWrapListenerToDeactivateRecordingOnFinalized);
        setActiveRecording(recordingStart, consumerWrapListenerToDeactivateRecordingOnFinalized);
        return recordingStart;
    }

    private void stopListeningToRotationEvents() {
        this.mRotationProvider.removeListener(this.mDeviceRotationListener);
    }

    private void stopRecording() {
        Threads.checkMainThread();
        Recording recording = this.mActiveRecording;
        if (recording != null) {
            recording.stop();
            deactivateRecording(this.mActiveRecording);
        }
    }

    private void throwExceptionForInvalidScreenFlashCapture() {
        if (getImageCaptureFlashMode() == 3) {
            if (getScreenFlashUiInfoByPriority() == null || getScreenFlashUiInfoByPriority().getScreenFlash() == null) {
                throw new IllegalStateException("No window set in PreviewView despite setting FLASH_MODE_SCREEN");
            }
        }
    }

    private void throwExceptionIfSessionConfigExists(String str) {
        if (this.mSessionConfig != null) {
            throw new IllegalStateException(str + " function call is not allowed when a SessionConfig has been set because this might cause UseCases to be recreated and conflict with the UseCases set by the SessionConfig. Please clear the session config if you want CameraController to help you create and manage the UseCases.");
        }
    }

    private void unbindAllAndRecreate() {
        unbindAllUseCases();
        recreatePreview(false);
        recreateImageCapture(Integer.valueOf(getImageCaptureMode()), false);
        recreateImageAnalysis(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()), false);
        recreateVideoCapture(false);
    }

    private void unbindAllUseCases() {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture);
        }
    }

    private void unbindSessionConfig() {
        SessionConfig sessionConfig;
        if (!isCameraInitialized() || (sessionConfig = this.mBoundSessionConfig) == null) {
            return;
        }
        this.mCameraProvider.unbind(sessionConfig);
    }

    private void validateEffects(Set<CameraEffect> set) {
        UseCaseGroup.Builder builder = new UseCaseGroup.Builder();
        builder.addUseCase(this.mPreview);
        Iterator<CameraEffect> it = set.iterator();
        while (it.hasNext()) {
            builder.addEffect(it.next());
        }
        builder.build();
    }

    private void validateFlashModeScreenConditions(ImageCapture imageCapture, CameraSelector cameraSelector) {
        Integer lensFacing = cameraSelector.getLensFacing();
        if (imageCapture.getFlashMode() == 3 && lensFacing != null && lensFacing.intValue() != 0) {
            throw new IllegalStateException("Not a front camera despite setting FLASH_MODE_SCREEN");
        }
    }

    private Consumer<VideoRecordEvent> wrapListenerToDeactivateRecordingOnFinalized(Consumer<VideoRecordEvent> consumer) {
        return new AnonymousClass2(ContextCompat.getMainExecutor(this.mAppContext), consumer);
    }

    void attachPreviewSurface(Preview.SurfaceProvider surfaceProvider, ViewPort viewPort) {
        Threads.checkMainThread();
        if (this.mSurfaceProvider != surfaceProvider) {
            this.mSurfaceProvider = surfaceProvider;
            this.mPreview.setSurfaceProvider(surfaceProvider);
        }
        boolean z = this.mSessionConfig == null && (this.mViewPort == null || getViewportAspectRatioStrategy(viewPort) != getViewportAspectRatioStrategy(this.mViewPort));
        this.mViewPort = viewPort;
        startListeningToRotationEvents();
        if (z) {
            unbindAllAndRecreate();
        }
        startCameraAndTrackStates();
    }

    public void clearEffects() {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("clearEffects");
        if (this.mCameraProvider != null) {
            unbindAllUseCases();
        }
        this.mEffects.clear();
        startCameraAndTrackStates();
    }

    public void clearImageAnalysisAnalyzer() {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("clearImageAnalysisAnalyzer");
        ImageAnalysis.Analyzer analyzer = this.mAnalysisAnalyzer;
        this.mAnalysisExecutor = null;
        this.mAnalysisAnalyzer = null;
        this.mImageAnalysis.clearAnalyzer();
        restartCameraIfAnalyzerResolutionChanged(analyzer, null);
    }

    void clearPreviewSurface() {
        Threads.checkMainThread();
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            processCameraProviderWrapper.unbind(this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture);
        }
        this.mPreview.setSurfaceProvider(null);
        this.mCamera = null;
        this.mSurfaceProvider = null;
        this.mViewPort = null;
        stopListeningToRotationEvents();
    }

    protected UseCaseGroup createUseCaseGroup(boolean z) {
        if (!isCameraInitialized()) {
            Logger.d(TAG, CAMERA_NOT_INITIALIZED);
            return null;
        }
        if (z && !isPreviewViewAttached()) {
            Logger.d(TAG, PREVIEW_VIEW_NOT_ATTACHED);
            return null;
        }
        if (this.mSessionConfig != null) {
            return null;
        }
        unbindAllUseCases();
        UseCaseGroup.Builder builderAddUseCase = new UseCaseGroup.Builder().addUseCase(this.mPreview);
        if (isImageCaptureEnabled()) {
            builderAddUseCase.addUseCase(this.mImageCapture);
        }
        if (isImageAnalysisEnabled()) {
            builderAddUseCase.addUseCase(this.mImageAnalysis);
        }
        if (isVideoCaptureEnabled()) {
            builderAddUseCase.addUseCase(this.mVideoCapture);
        }
        builderAddUseCase.setViewPort(this.mViewPort);
        Iterator<CameraEffect> it = this.mEffects.iterator();
        while (it.hasNext()) {
            builderAddUseCase.addEffect(it.next());
        }
        return builderAddUseCase.build();
    }

    void deactivateRecordingByListener(Consumer<VideoRecordEvent> consumer) {
        Recording recordingRemove = this.mRecordingMap.remove(consumer);
        if (recordingRemove != null) {
            deactivateRecording(recordingRemove);
        }
    }

    public ListenableFuture<Void> enableTorch(boolean z) {
        Threads.checkMainThread();
        return !isCameraAttached() ? this.mPendingEnableTorch.setValue(Boolean.valueOf(z)) : this.mCamera.getCameraControl().enableTorch(z);
    }

    protected SessionConfig getBoundSessionConfig() {
        if (!isCameraInitialized()) {
            Logger.d(TAG, CAMERA_NOT_INITIALIZED);
            return null;
        }
        if (!isPreviewViewAttached()) {
            Logger.d(TAG, PREVIEW_VIEW_NOT_ATTACHED);
            return null;
        }
        if (this.mSessionConfig == null) {
            return null;
        }
        SessionConfig sessionConfigBuild = new SessionConfig.Builder(this.mSessionConfig).setViewPort(this.mViewPort).build();
        this.mBoundSessionConfig = sessionConfigBuild;
        return sessionConfigBuild;
    }

    public CameraControl getCameraControl() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraControl();
    }

    public CameraInfo getCameraInfo() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraInfo();
    }

    public CameraSelector getCameraSelector() {
        Threads.checkMainThread();
        return this.mCameraSelector;
    }

    public Executor getImageAnalysisBackgroundExecutor() {
        Threads.checkMainThread();
        return this.mSessionConfig != null ? this.mImageAnalysis.getBackgroundExecutor() : this.mAnalysisBackgroundExecutor;
    }

    public int getImageAnalysisBackpressureStrategy() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getBackpressureStrategy();
    }

    public int getImageAnalysisImageQueueDepth() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getImageQueueDepth();
    }

    public int getImageAnalysisOutputImageFormat() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getOutputImageFormat();
    }

    public ResolutionSelector getImageAnalysisResolutionSelector() {
        Threads.checkMainThread();
        return this.mSessionConfig != null ? this.mImageAnalysis.getResolutionSelector() : this.mImageAnalysisResolutionSelector;
    }

    @Deprecated
    public OutputSize getImageAnalysisTargetSize() {
        Threads.checkMainThread();
        if (this.mSessionConfig == null) {
            return this.mImageAnalysisTargetSize;
        }
        return null;
    }

    public int getImageCaptureFlashMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getFlashMode();
    }

    public Executor getImageCaptureIoExecutor() {
        Threads.checkMainThread();
        return this.mSessionConfig != null ? ((ImageCaptureConfig) this.mImageCapture.getCurrentConfig()).getIoExecutor(null) : this.mImageCaptureIoExecutor;
    }

    public int getImageCaptureMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getCaptureMode();
    }

    public ResolutionSelector getImageCaptureResolutionSelector() {
        Threads.checkMainThread();
        return this.mSessionConfig != null ? this.mImageCapture.getResolutionSelector() : this.mImageCaptureResolutionSelector;
    }

    @Deprecated
    public OutputSize getImageCaptureTargetSize() {
        Threads.checkMainThread();
        if (this.mSessionConfig == null) {
            return this.mImageCaptureTargetSize;
        }
        return null;
    }

    public ListenableFuture<Void> getInitializationFuture() {
        return this.mInitializationFuture;
    }

    public DynamicRange getPreviewDynamicRange() {
        Threads.checkMainThread();
        return this.mSessionConfig == null ? this.mPreviewDynamicRange : this.mPreview.getDynamicRange();
    }

    public ResolutionSelector getPreviewResolutionSelector() {
        Threads.checkMainThread();
        return this.mSessionConfig != null ? this.mPreview.getResolutionSelector() : this.mPreviewResolutionSelector;
    }

    @Deprecated
    public OutputSize getPreviewTargetSize() {
        Threads.checkMainThread();
        if (this.mSessionConfig == null) {
            return this.mPreviewTargetSize;
        }
        return null;
    }

    public ScreenFlashUiInfo getScreenFlashUiInfoByPriority() {
        ScreenFlashUiInfo screenFlashUiInfo = this.mScreenFlashUiInfoMap.get(ScreenFlashUiInfo.ProviderType.SCREEN_FLASH_VIEW);
        Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> map = this.mScreenFlashUiInfoMap;
        if (screenFlashUiInfo != null) {
            return map.get(ScreenFlashUiInfo.ProviderType.SCREEN_FLASH_VIEW);
        }
        if (map.get(ScreenFlashUiInfo.ProviderType.PREVIEW_VIEW) != null) {
            return this.mScreenFlashUiInfoMap.get(ScreenFlashUiInfo.ProviderType.PREVIEW_VIEW);
        }
        return null;
    }

    public LiveData<TapToFocusInfo> getTapToFocusInfoState() {
        Threads.checkMainThread();
        return this.mTapToFocusInfoState;
    }

    @Deprecated
    public LiveData<Integer> getTapToFocusState() {
        Threads.checkMainThread();
        return this.mTapToFocusState;
    }

    public LiveData<Integer> getTorchState() {
        Threads.checkMainThread();
        return this.mTorchState;
    }

    public DynamicRange getVideoCaptureDynamicRange() {
        Threads.checkMainThread();
        return this.mSessionConfig != null ? this.mVideoCapture.getDynamicRange() : this.mVideoCaptureDynamicRange;
    }

    public int getVideoCaptureMirrorMode() {
        Threads.checkMainThread();
        return this.mSessionConfig != null ? this.mVideoCapture.getMirrorMode() : this.mVideoCaptureMirrorMode;
    }

    public QualitySelector getVideoCaptureQualitySelector() {
        Threads.checkMainThread();
        return this.mSessionConfig != null ? ((Recorder) this.mVideoCapture.getOutput()).getQualitySelector() : this.mVideoCaptureQualitySelector;
    }

    public Range<Integer> getVideoCaptureTargetFrameRate() {
        Threads.checkMainThread();
        return this.mSessionConfig != null ? this.mVideoCapture.getTargetFrameRate() : this.mVideoCaptureTargetFrameRate;
    }

    public LiveData<ZoomState> getZoomState() {
        Threads.checkMainThread();
        return this.mZoomState;
    }

    public boolean hasCamera(CameraSelector cameraSelector) {
        Threads.checkMainThread();
        Preconditions.checkNotNull(cameraSelector);
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper == null) {
            throw new IllegalStateException("Camera not initialized. Please wait for the initialization future to finish. See #getInitializationFuture().");
        }
        try {
            return processCameraProviderWrapper.hasCamera(cameraSelector);
        } catch (CameraInfoUnavailableException e) {
            Logger.w(TAG, "Failed to check camera availability", e);
            return false;
        }
    }

    public boolean isImageAnalysisEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(2);
    }

    public boolean isImageCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(1);
    }

    public boolean isPinchToZoomEnabled() {
        Threads.checkMainThread();
        return this.mPinchToZoomEnabled;
    }

    public boolean isRecording() {
        Threads.checkMainThread();
        Recording recording = this.mActiveRecording;
        return (recording == null || recording.isClosed()) ? false : true;
    }

    public boolean isTapToFocusEnabled() {
        Threads.checkMainThread();
        return this.mTapToFocusEnabled;
    }

    public boolean isVideoCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(4);
    }

    /* JADX INFO: renamed from: lambda$new$0$androidx-camera-view-CameraController, reason: not valid java name */
    /* synthetic */ Void m1186lambda$new$0$androidxcameraviewCameraController(ProcessCameraProviderWrapper processCameraProviderWrapper) {
        this.mCameraProvider = processCameraProviderWrapper;
        if (this.mSessionConfig == null) {
            unbindAllAndRecreate();
        }
        startCameraAndTrackStates();
        return null;
    }

    /* JADX INFO: renamed from: lambda$new$1$androidx-camera-view-CameraController, reason: not valid java name */
    /* synthetic */ void m1187lambda$new$1$androidxcameraviewCameraController(int i) {
        this.mLastKnownRotation = i;
        this.mImageAnalysis.setTargetRotation(i);
        this.mImageCapture.setTargetRotation(i);
        this.mVideoCapture.setTargetRotation(i);
    }

    /* JADX INFO: renamed from: lambda$setCameraSelector$4$androidx-camera-view-CameraController, reason: not valid java name */
    /* synthetic */ void m1188lambda$setCameraSelector$4$androidxcameraviewCameraController(CameraSelector cameraSelector) {
        this.mCameraSelector = cameraSelector;
    }

    /* JADX INFO: renamed from: lambda$setEnabledUseCases$2$androidx-camera-view-CameraController, reason: not valid java name */
    /* synthetic */ void m1189x2318c9a7(int i, int i2) {
        this.mEnabledUseCases = i;
        Logger.w(TAG, "setEnabledUseCases: failed to enable use cases properly for enabledUseCases = " + Integer.toBinaryString(i2) + ", restoring back previous values " + Integer.toBinaryString(i));
    }

    /* JADX INFO: renamed from: lambda$setSessionConfig$3$androidx-camera-view-CameraController, reason: not valid java name */
    /* synthetic */ void m1190lambda$setSessionConfig$3$androidxcameraviewCameraController(int i, SessionConfig sessionConfig, CameraSelector cameraSelector) {
        this.mEnabledUseCases = i;
        this.mSessionConfig = sessionConfig;
        this.mCameraSelector = cameraSelector;
        if (sessionConfig != null) {
            initializeStateFromSessionConfig(sessionConfig);
        }
        Logger.w(TAG, "Failed to set the session config, restoring back previous values!");
    }

    void onPinchToZoom(float f) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return;
        }
        if (!this.mPinchToZoomEnabled) {
            Logger.d(TAG, "Pinch to zoom disabled.");
            return;
        }
        Logger.d(TAG, "Pinch to zoom with scale: " + f);
        ZoomState value = getZoomState().getValue();
        if (value == null) {
            return;
        }
        setZoomRatio(Math.min(Math.max(value.getZoomRatio() * speedUpZoomBy2X(f), value.getMinZoomRatio()), value.getMaxZoomRatio()));
    }

    void onTapToFocus(MeteringPointFactory meteringPointFactory, float f, float f2) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return;
        }
        if (!this.mTapToFocusEnabled) {
            Logger.d(TAG, "Tap to focus disabled. ");
            return;
        }
        PointF pointF = new PointF(f, f2);
        FocusMeteringAction focusMeteringActionCreateFocusMeteringAction = createFocusMeteringAction(meteringPointFactory, pointF);
        Logger.d(TAG, "Tap to focus started: " + f + ", " + f2);
        FocusMeteringResultCallback focusMeteringResultCallback = this.mFocusMeteringResultCallback;
        if (focusMeteringResultCallback != null) {
            focusMeteringResultCallback.close();
        }
        this.mTapToFocusInfoState.postValue(new TapToFocusInfo(1, pointF));
        final FocusMeteringResultCallback focusMeteringResultCallback2 = new FocusMeteringResultCallback(pointF, this.mTapToFocusInfoState);
        this.mFocusMeteringResultCallback = focusMeteringResultCallback2;
        Futures.addCallback(this.mCamera.getCameraControl().startFocusAndMetering(focusMeteringActionCreateFocusMeteringAction), focusMeteringResultCallback2, CameraXExecutors.directExecutor());
        long millis = TimeUnit.NANOSECONDS.toMillis(this.mTapToFocusAutoCancelDurationNanos);
        Logger.d(TAG, "Tap to focus auto cancel duration: " + millis + " ms");
        if (millis > 0) {
            Handler handler = new Handler(Looper.getMainLooper());
            Objects.requireNonNull(focusMeteringResultCallback2);
            handler.postDelayed(new Runnable() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    focusMeteringResultCallback2.resetStateAndClose();
                }
            }, millis);
        }
    }

    public void setCameraSelector(CameraSelector cameraSelector) {
        Threads.checkMainThread();
        if (this.mCameraSelector == cameraSelector) {
            return;
        }
        validateFlashModeScreenConditions(this.mImageCapture, cameraSelector);
        final CameraSelector cameraSelector2 = this.mCameraSelector;
        this.mCameraSelector = cameraSelector;
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper == null) {
            return;
        }
        SessionConfig sessionConfig = this.mSessionConfig;
        if (sessionConfig != null) {
            processCameraProviderWrapper.unbind(sessionConfig);
        } else {
            processCameraProviderWrapper.unbind(this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture);
        }
        startCameraAndTrackStates(new Runnable() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1188lambda$setCameraSelector$4$androidxcameraviewCameraController(cameraSelector2);
            }
        });
    }

    public void setEffects(Set<CameraEffect> set) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setEffects");
        if (Objects.equals(this.mEffects, set)) {
            return;
        }
        if (this.mCameraProvider != null) {
            unbindAllUseCases();
        }
        validateEffects(set);
        this.mEffects.clear();
        this.mEffects.addAll(set);
        startCameraAndTrackStates();
    }

    public void setEnabledUseCases(final int i) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setEnabledUseCases");
        final int i2 = this.mEnabledUseCases;
        if (i == i2) {
            return;
        }
        this.mEnabledUseCases = i;
        if (!isVideoCaptureEnabled() && isRecording()) {
            stopRecording();
        }
        startCameraAndTrackStates(new Runnable() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1189x2318c9a7(i2, i);
            }
        });
    }

    public void setImageAnalysisAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageAnalysisAnalyzer");
        ImageAnalysis.Analyzer analyzer2 = this.mAnalysisAnalyzer;
        if (analyzer2 == analyzer && this.mAnalysisExecutor == executor) {
            return;
        }
        this.mAnalysisExecutor = executor;
        this.mAnalysisAnalyzer = analyzer;
        this.mImageAnalysis.setAnalyzer(executor, analyzer);
        restartCameraIfAnalyzerResolutionChanged(analyzer2, analyzer);
    }

    public void setImageAnalysisBackgroundExecutor(Executor executor) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageAnalysisBackgroundExecutor");
        if (this.mAnalysisBackgroundExecutor == executor) {
            return;
        }
        this.mAnalysisBackgroundExecutor = executor;
        recreateImageAnalysis(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()), true);
        startCameraAndTrackStates();
    }

    public void setImageAnalysisBackpressureStrategy(int i) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageAnalysisBackpressureStrategy");
        if (this.mImageAnalysis.getBackpressureStrategy() == i) {
            return;
        }
        recreateImageAnalysis(Integer.valueOf(i), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()), true);
        startCameraAndTrackStates();
    }

    public void setImageAnalysisImageQueueDepth(int i) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageAnalysisImageQueueDepth");
        if (this.mImageAnalysis.getImageQueueDepth() == i) {
            return;
        }
        recreateImageAnalysis(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(i), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()), true);
        startCameraAndTrackStates();
    }

    public void setImageAnalysisOutputImageFormat(int i) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageAnalysisOutputImageFormat");
        if (i == this.mImageAnalysis.getOutputImageFormat()) {
            return;
        }
        recreateImageAnalysis(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(i), true);
    }

    public void setImageAnalysisResolutionSelector(ResolutionSelector resolutionSelector) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageAnalysisResolutionSelector");
        if (this.mImageAnalysisResolutionSelector == resolutionSelector) {
            return;
        }
        this.mImageAnalysisResolutionSelector = resolutionSelector;
        recreateImageAnalysis(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()), true);
        startCameraAndTrackStates();
    }

    @Deprecated
    public void setImageAnalysisTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageAnalysisTargetSize");
        if (isOutputSizeEqual(this.mImageAnalysisTargetSize, outputSize)) {
            return;
        }
        this.mImageAnalysisTargetSize = outputSize;
        recreateImageAnalysis(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()), true);
        startCameraAndTrackStates();
    }

    public void setImageCaptureFlashMode(int i) {
        Threads.checkMainThread();
        if (this.mSessionConfig != null && !isImageCaptureEnabled()) {
            throw new IllegalStateException("A SessionConfig is set and it doesn't contain an ImageCapture.");
        }
        if (i == 3) {
            Integer lensFacing = this.mCameraSelector.getLensFacing();
            if (lensFacing != null && lensFacing.intValue() != 0) {
                throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN");
            }
            updateScreenFlashToImageCapture();
        }
        this.mImageCapture.setFlashMode(i);
    }

    public void setImageCaptureIoExecutor(Executor executor) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageCaptureIoExecutor");
        if (this.mImageCaptureIoExecutor == executor) {
            return;
        }
        this.mImageCaptureIoExecutor = executor;
        recreateImageCapture(Integer.valueOf(getImageCaptureMode()), true);
        startCameraAndTrackStates();
    }

    public void setImageCaptureMode(int i) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageCaptureMode");
        if (this.mImageCapture.getCaptureMode() == i) {
            return;
        }
        recreateImageCapture(Integer.valueOf(i), true);
        startCameraAndTrackStates();
    }

    public void setImageCaptureResolutionSelector(ResolutionSelector resolutionSelector) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageCaptureResolutionSelector");
        if (this.mImageCaptureResolutionSelector == resolutionSelector) {
            return;
        }
        this.mImageCaptureResolutionSelector = resolutionSelector;
        recreateImageCapture(Integer.valueOf(getImageCaptureMode()), true);
        startCameraAndTrackStates();
    }

    @Deprecated
    public void setImageCaptureTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setImageCaptureTargetSize");
        if (isOutputSizeEqual(this.mImageCaptureTargetSize, outputSize)) {
            return;
        }
        this.mImageCaptureTargetSize = outputSize;
        recreateImageCapture(Integer.valueOf(getImageCaptureMode()), true);
        startCameraAndTrackStates();
    }

    public ListenableFuture<Void> setLinearZoom(float f) {
        Threads.checkMainThread();
        return !isCameraAttached() ? this.mPendingLinearZoom.setValue(Float.valueOf(f)) : this.mCamera.getCameraControl().setLinearZoom(f);
    }

    public void setPinchToZoomEnabled(boolean z) {
        Threads.checkMainThread();
        this.mPinchToZoomEnabled = z;
    }

    public void setPreviewDynamicRange(DynamicRange dynamicRange) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setPreviewDynamicRange");
        this.mPreviewDynamicRange = dynamicRange;
        recreatePreview(true);
        startCameraAndTrackStates();
    }

    public void setPreviewResolutionSelector(ResolutionSelector resolutionSelector) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setPreviewResolutionSelector");
        if (this.mPreviewResolutionSelector == resolutionSelector) {
            return;
        }
        this.mPreviewResolutionSelector = resolutionSelector;
        recreatePreview(true);
        startCameraAndTrackStates();
    }

    @Deprecated
    public void setPreviewTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setPreviewTargetSize");
        if (isOutputSizeEqual(this.mPreviewTargetSize, outputSize)) {
            return;
        }
        this.mPreviewTargetSize = outputSize;
        recreatePreview(true);
        startCameraAndTrackStates();
    }

    public void setScreenFlashUiInfo(ScreenFlashUiInfo screenFlashUiInfo) {
        ScreenFlashUiInfo screenFlashUiInfoByPriority = getScreenFlashUiInfoByPriority();
        this.mScreenFlashUiInfoMap.put(screenFlashUiInfo.getProviderType(), screenFlashUiInfo);
        ScreenFlashUiInfo screenFlashUiInfoByPriority2 = getScreenFlashUiInfoByPriority();
        if (screenFlashUiInfoByPriority2 == null || screenFlashUiInfoByPriority2.equals(screenFlashUiInfoByPriority)) {
            return;
        }
        updateScreenFlashToImageCapture();
    }

    public void setSessionConfig(SessionConfig sessionConfig, CameraSelector cameraSelector) {
        Threads.checkMainThread();
        if (this.mSessionConfig == sessionConfig && this.mCameraSelector == cameraSelector) {
            return;
        }
        if (sessionConfig instanceof HighSpeedVideoSessionConfig) {
            throw new IllegalArgumentException("CameraController does not support HighSpeedVideoSessionConfig!");
        }
        ImageCapture imageCaptureFindImageCapture = UseCaseUtil.findImageCapture(sessionConfig.getUseCases());
        if (imageCaptureFindImageCapture != null) {
            validateFlashModeScreenConditions(imageCaptureFindImageCapture, cameraSelector);
        }
        if (isRecording()) {
            stopRecording();
        }
        if (this.mSessionConfig != null) {
            unbindSessionConfig();
        } else {
            unbindAllUseCases();
        }
        if (isCameraInitialized() && !isConfigurationSupported(cameraSelector, sessionConfig)) {
            throw new IllegalArgumentException("The camera resolved by the camera selector can not support the session config.");
        }
        final int i = this.mEnabledUseCases;
        this.mEnabledUseCases = initializeStateFromSessionConfig(sessionConfig);
        final SessionConfig sessionConfig2 = this.mSessionConfig;
        final CameraSelector cameraSelector2 = this.mCameraSelector;
        this.mSessionConfig = sessionConfig;
        this.mCameraSelector = cameraSelector;
        startCameraAndTrackStates(new Runnable() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1190lambda$setSessionConfig$3$androidxcameraviewCameraController(i, sessionConfig2, cameraSelector2);
            }
        });
    }

    public void setTapToFocusAutoCancelDuration(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j >= 0, "Tap-to-focus auto-cancellation duration must be at least 0");
        this.mTapToFocusAutoCancelDurationNanos = timeUnit.toNanos(j);
        Logger.d(TAG, "setTapToFocusAutoCancelDuration: " + this.mTapToFocusAutoCancelDurationNanos + " ns set!");
    }

    public void setTapToFocusEnabled(boolean z) {
        Threads.checkMainThread();
        this.mTapToFocusEnabled = z;
    }

    public void setVideoCaptureDynamicRange(DynamicRange dynamicRange) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setVideoCaptureDynamicRange");
        this.mVideoCaptureDynamicRange = dynamicRange;
        recreateVideoCapture(true);
        startCameraAndTrackStates();
    }

    public void setVideoCaptureMirrorMode(int i) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setVideoCaptureMirrorMode");
        this.mVideoCaptureMirrorMode = i;
        recreateVideoCapture(true);
        startCameraAndTrackStates();
    }

    public void setVideoCaptureQualitySelector(QualitySelector qualitySelector) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setVideoCaptureQualitySelector");
        this.mVideoCaptureQualitySelector = qualitySelector;
        recreateVideoCapture(true);
        startCameraAndTrackStates();
    }

    public void setVideoCaptureTargetFrameRate(Range<Integer> range) {
        Threads.checkMainThread();
        throwExceptionIfSessionConfigExists("setVideoCaptureTargetFrameRate");
        this.mVideoCaptureTargetFrameRate = range;
        recreateVideoCapture(true);
        startCameraAndTrackStates();
    }

    public ListenableFuture<Void> setZoomRatio(float f) {
        Threads.checkMainThread();
        return !isCameraAttached() ? this.mPendingZoomRatio.setValue(Float.valueOf(f)) : this.mCamera.getCameraControl().setZoomRatio(f);
    }

    abstract Camera startCamera();

    void startCameraAndTrackStates() {
        startCameraAndTrackStates(null);
    }

    void startCameraAndTrackStates(Runnable runnable) {
        try {
            this.mCamera = startCamera();
            if (!isCameraAttached()) {
                Logger.d(TAG, CAMERA_NOT_ATTACHED);
                return;
            }
            this.mZoomState.setSource(this.mCamera.getCameraInfo().getZoomState());
            this.mTorchState.setSource(this.mCamera.getCameraInfo().getTorchState());
            this.mPendingEnableTorch.propagateIfHasValue(new Function() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda2
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.enableTorch(((Boolean) obj).booleanValue());
                }
            });
            this.mPendingLinearZoom.propagateIfHasValue(new Function() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda3
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.setLinearZoom(((Float) obj).floatValue());
                }
            });
            this.mPendingZoomRatio.propagateIfHasValue(new Function() { // from class: androidx.camera.view.CameraController$$ExternalSyntheticLambda4
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.setZoomRatio(((Float) obj).floatValue());
                }
            });
        } catch (RuntimeException e) {
            if (runnable != null) {
                runnable.run();
            }
            throw e;
        }
    }

    public Recording startRecording(FileDescriptorOutputOptions fileDescriptorOutputOptions, AudioConfig audioConfig, Executor executor, Consumer<VideoRecordEvent> consumer) {
        return startRecordingInternal(fileDescriptorOutputOptions, audioConfig, executor, consumer);
    }

    public Recording startRecording(FileOutputOptions fileOutputOptions, AudioConfig audioConfig, Executor executor, Consumer<VideoRecordEvent> consumer) {
        return startRecordingInternal(fileOutputOptions, audioConfig, executor, consumer);
    }

    public Recording startRecording(MediaStoreOutputOptions mediaStoreOutputOptions, AudioConfig audioConfig, Executor executor, Consumer<VideoRecordEvent> consumer) {
        return startRecordingInternal(mediaStoreOutputOptions, audioConfig, executor, consumer);
    }

    public void takePicture(ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        throwExceptionForInvalidScreenFlashCapture();
        updateMirroringFlagInOutputFileOptions(outputFileOptions);
        this.mImageCapture.m1028lambda$takePicture$2$androidxcameracoreImageCapture(outputFileOptions, executor, onImageSavedCallback);
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        throwExceptionForInvalidScreenFlashCapture();
        this.mImageCapture.m1027lambda$takePicture$1$androidxcameracoreImageCapture(executor, onImageCapturedCallback);
    }

    void updateMirroringFlagInOutputFileOptions(ImageCapture.OutputFileOptions outputFileOptions) {
        if (this.mCameraSelector.getLensFacing() == null || outputFileOptions.getMetadata().isReversedHorizontalSet()) {
            return;
        }
        outputFileOptions.getMetadata().setReversedHorizontal(this.mCameraSelector.getLensFacing().intValue() == 0);
    }

    void updatePreviewViewTransform(Matrix matrix) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer = this.mAnalysisAnalyzer;
        if (analyzer != null && analyzer.getTargetCoordinateSystem() == 1) {
            this.mAnalysisAnalyzer.updateTransform(matrix);
        }
    }

    public void updateScreenFlashToImageCapture() {
        ScreenFlashUiInfo screenFlashUiInfoByPriority = getScreenFlashUiInfoByPriority();
        if (screenFlashUiInfoByPriority == null) {
            Logger.d(TAG, "No ScreenFlash instance set yet, need to wait for controller to be set to either ScreenFlashView or PreviewView");
            this.mImageCapture.setScreenFlash(NO_OP_SCREEN_FLASH);
        } else {
            this.mImageCapture.setScreenFlash(screenFlashUiInfoByPriority.getScreenFlash());
            Logger.d(TAG, "Set ScreenFlash instance to ImageCapture, provided by " + screenFlashUiInfoByPriority.getProviderType().name());
        }
    }
}
