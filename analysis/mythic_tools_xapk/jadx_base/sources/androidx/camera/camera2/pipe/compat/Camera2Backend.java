package androidx.camera.camera2.pipe.compat;

import android.content.Context;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraBackendId;
import androidx.camera.camera2.pipe.CameraContext;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.ConfigQueryResult;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.SurfaceTracker;
import androidx.camera.camera2.pipe.compat.AndroidOutputConfiguration;
import androidx.camera.camera2.pipe.compat.Camera2CameraController;
import androidx.camera.camera2.pipe.config.Camera2ControllerComponent;
import androidx.camera.camera2.pipe.config.Camera2ControllerConfig;
import androidx.camera.camera2.pipe.config.CameraPipeContext;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import androidx.camera.featurecombinationquery.CameraDeviceSetupCompat;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: Camera2Backend.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B;\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0096@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016J\u0016\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0#\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0096@¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020-2\u0006\u0010&\u001a\u00020\u001dH\u0016¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020-012\u0006\u0010&\u001a\u00020\u001dH\u0016¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020-H\u0016J\u0017\u00105\u001a\u00020-2\u0006\u0010&\u001a\u00020\u001dH\u0016¢\u0006\u0004\b6\u0010/J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0096@¢\u0006\u0004\b;\u0010<J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u001c2\u0006\u00109\u001a\u00020:H\u0003J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020-01H\u0016J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020-01H\u0016J8\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u00020:2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0016J\u0017\u0010L\u001a\u00020-2\u0006\u0010&\u001a\u00020\u001dH\u0016¢\u0006\u0004\bM\u0010/J\u0010\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006P"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2Backend;", "Landroidx/camera/camera2/pipe/CameraBackend;", "Landroidx/camera/camera2/pipe/compat/Camera2CameraController$ShutdownListener;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "camera2DeviceCache", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCache;", "camera2MetadataCache", "Landroidx/camera/camera2/pipe/compat/Camera2MetadataCache;", "camera2DeviceManager", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceManager;", "camera2CameraControllerComponent", "Landroidx/camera/camera2/pipe/config/Camera2ControllerComponent$Builder;", "cameraPipeContext", "Landroid/content/Context;", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/compat/Camera2DeviceCache;Landroidx/camera/camera2/pipe/compat/Camera2MetadataCache;Landroidx/camera/camera2/pipe/compat/Camera2DeviceManager;Landroidx/camera/camera2/pipe/config/Camera2ControllerComponent$Builder;Landroid/content/Context;)V", "lock", "", "activeCameraControllers", "", "Landroidx/camera/camera2/pipe/CameraController;", "id", "Landroidx/camera/camera2/pipe/CameraBackendId;", "getId-QwmhuAM", "()Ljava/lang/String;", "cameraIds", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraIds", "()Lkotlinx/coroutines/flow/Flow;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraIds", "awaitConcurrentCameraIds", "", "getCameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraId", "getCameraMetadata-0r8Bogc", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraMetadata", "awaitCameraMetadata-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "disconnect", "", "disconnect-EfqyGwQ", "(Ljava/lang/String;)V", "disconnectAsync", "Lkotlinx/coroutines/Deferred;", "disconnectAsync-EfqyGwQ", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "disconnectAll", "prewarmIsConfigSupported", "prewarmIsConfigSupported-EfqyGwQ", "isConfigSupported", "Landroidx/camera/camera2/pipe/ConfigQueryResult;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "isConfigSupported-NpXggIU", "(Landroidx/camera/camera2/pipe/CameraGraph$Config;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildOutputConfiguration", "Landroid/hardware/camera2/params/OutputConfiguration;", "disconnectAllAsync", "shutdownAsync", "createCameraController", "cameraContext", "Landroidx/camera/camera2/pipe/CameraContext;", "graphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "streamGraph", "Landroidx/camera/camera2/pipe/StreamGraph;", "surfaceTracker", "Landroidx/camera/camera2/pipe/SurfaceTracker;", "prewarm", "prewarm-EfqyGwQ", "onControllerClosed", "cameraController", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2Backend implements CameraBackend, Camera2CameraController.ShutdownListener {
    private final Set<CameraController> activeCameraControllers;
    private final Camera2ControllerComponent.Builder camera2CameraControllerComponent;
    private final Camera2DeviceCache camera2DeviceCache;
    private final Camera2DeviceManager camera2DeviceManager;
    private final Camera2MetadataCache camera2MetadataCache;
    private final Context cameraPipeContext;
    private final Object lock;
    private final Threads threads;

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2Backend$shutdownAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2Backend.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2Backend$shutdownAsync$2", f = "Camera2Backend.kt", i = {0}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, 196}, m = "invokeSuspend", n = {"controller"}, s = {"L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Camera2Backend.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
        
            if (r8 == r0) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00c8, code lost:
        
            if (r7.this$0.camera2DeviceManager.closeAll(true).await(r7) == r0) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0073 -> B:23:0x0076). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Set set;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = Camera2Backend.this.lock;
                Camera2Backend camera2Backend = Camera2Backend.this;
                synchronized (obj2) {
                    set = camera2Backend.activeCameraControllers;
                }
                it = set.iterator();
                if (it.hasNext()) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            CameraController cameraController = (CameraController) this.L$1;
            it = (Iterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (!((Boolean) obj).booleanValue() && Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to await closure from " + cameraController + '!');
            }
            if (it.hasNext()) {
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Camera2Backend#shutdownAsync: Closing all cameras (if any)");
                }
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
            } else {
                cameraController = (CameraController) it.next();
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Camera2Backend#shutdownAsync: Awaiting closure from " + cameraController);
                }
                this.L$0 = it;
                this.L$1 = cameraController;
                this.label = 1;
                obj = cameraController.awaitClosed(this);
            }
            return coroutine_suspended;
        }
    }

    @Inject
    public Camera2Backend(Threads threads, Camera2DeviceCache camera2DeviceCache, Camera2MetadataCache camera2MetadataCache, Camera2DeviceManager camera2DeviceManager, Camera2ControllerComponent.Builder camera2CameraControllerComponent, @CameraPipeContext Context cameraPipeContext) {
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(camera2DeviceCache, "camera2DeviceCache");
        Intrinsics.checkNotNullParameter(camera2MetadataCache, "camera2MetadataCache");
        Intrinsics.checkNotNullParameter(camera2DeviceManager, "camera2DeviceManager");
        Intrinsics.checkNotNullParameter(camera2CameraControllerComponent, "camera2CameraControllerComponent");
        Intrinsics.checkNotNullParameter(cameraPipeContext, "cameraPipeContext");
        this.threads = threads;
        this.camera2DeviceCache = camera2DeviceCache;
        this.camera2MetadataCache = camera2MetadataCache;
        this.camera2DeviceManager = camera2DeviceManager;
        this.camera2CameraControllerComponent = camera2CameraControllerComponent;
        this.cameraPipeContext = cameraPipeContext;
        this.lock = new Object();
        this.activeCameraControllers = new LinkedHashSet();
    }

    private final List<OutputConfiguration> buildOutputConfiguration(CameraGraph.Config graphConfig) {
        OutputConfiguration outputConfiguration;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<CameraStream.Config> it = graphConfig.getStreams().iterator();
        while (it.hasNext()) {
            for (OutputStream.Config config : it.next().getOutputs()) {
                AndroidOutputConfiguration.Companion companion = AndroidOutputConfiguration.INSTANCE;
                Integer numValueOf = Integer.valueOf(config.getFormat());
                OutputStream.OutputType sURFACE_DEFERRED_FOR_QUERY_ONLY$camera_camera2_pipe = OutputStream.OutputType.INSTANCE.getSURFACE_DEFERRED_FOR_QUERY_ONLY$camera_camera2_pipe();
                OutputStream.MirrorMode mirrorMode = config.getMirrorMode();
                OutputStream.TimestampBase timestampBase = config.getTimestampBase();
                OutputStream.DynamicRangeProfile dynamicRangeProfile = config.getDynamicRangeProfile();
                OutputStream.StreamUseCase streamUseCase = config.getStreamUseCase();
                List<OutputStream.SensorPixelMode> sensorPixelModes = config.getSensorPixelModes();
                Size size = config.getSize();
                String camera = config.getCamera();
                OutputConfigurationWrapper outputConfigurationWrapperM768creategWWoySg$default = AndroidOutputConfiguration.Companion.m768creategWWoySg$default(companion, null, numValueOf, sURFACE_DEFERRED_FOR_QUERY_ONLY$camera_camera2_pipe, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, sensorPixelModes, size, false, 0, !(camera == null ? false : CameraId.m382equalsimpl0(camera, graphConfig.m338getCameraDz_R5H8())) ? config.getCamera() : null, 1536, null);
                if (outputConfigurationWrapperM768creategWWoySg$default != null && (outputConfiguration = (OutputConfiguration) outputConfigurationWrapperM768creategWWoySg$default.unwrapAs(Reflection.getOrCreateKotlinClass(OutputConfiguration.class))) != null) {
                    linkedHashSet.add(outputConfiguration);
                }
            }
        }
        return CollectionsKt.toList(linkedHashSet);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    public List<CameraId> awaitCameraIds() {
        return this.camera2DeviceCache.awaitCameraIds();
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    /* JADX INFO: renamed from: awaitCameraMetadata-EfqyGwQ */
    public CameraMetadata mo202awaitCameraMetadataEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        return this.camera2MetadataCache.mo799awaitCameraMetadataEfqyGwQ(cameraId);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    public Set<Set<CameraId>> awaitConcurrentCameraIds() {
        return this.camera2DeviceCache.awaitConcurrentCameraIds();
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    public CameraController createCameraController(CameraContext cameraContext, CameraGraphId graphId, CameraGraph.Config graphConfig, GraphListener graphListener, StreamGraph streamGraph, SurfaceTracker surfaceTracker) {
        Intrinsics.checkNotNullParameter(cameraContext, "cameraContext");
        Intrinsics.checkNotNullParameter(graphId, "graphId");
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        Intrinsics.checkNotNullParameter(surfaceTracker, "surfaceTracker");
        CameraController cameraController = this.camera2CameraControllerComponent.camera2ControllerConfig(new Camera2ControllerConfig(this, graphId, graphConfig, graphListener, (StreamGraphImpl) streamGraph, surfaceTracker, this)).build().cameraController();
        synchronized (this.lock) {
            this.activeCameraControllers.add(cameraController);
        }
        return cameraController;
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    /* JADX INFO: renamed from: disconnect-EfqyGwQ */
    public void mo203disconnectEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        this.camera2DeviceManager.mo787closeEfqyGwQ(cameraId);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    public void disconnectAll() {
        Camera2DeviceManager.closeAll$default(this.camera2DeviceManager, false, 1, null);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    public Deferred<Unit> disconnectAllAsync() {
        return Camera2DeviceManager.closeAll$default(this.camera2DeviceManager, false, 1, null);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    /* JADX INFO: renamed from: disconnectAsync-EfqyGwQ */
    public Deferred<Unit> mo204disconnectAsyncEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        return this.camera2DeviceManager.mo787closeEfqyGwQ(cameraId);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    public Object getCameraIds(Continuation<? super List<CameraId>> continuation) {
        return this.camera2DeviceCache.getCameraIds(continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    public Flow<List<CameraId>> getCameraIds() {
        return this.camera2DeviceCache.getCameraIds();
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    /* JADX INFO: renamed from: getCameraMetadata-0r8Bogc */
    public Object mo205getCameraMetadata0r8Bogc(String str, Continuation<? super CameraMetadata> continuation) {
        return this.camera2MetadataCache.mo801getCameraMetadata0r8Bogc(str, continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    /* JADX INFO: renamed from: getId-QwmhuAM */
    public String mo206getIdQwmhuAM() {
        return CameraBackendId.m216constructorimpl("CXCP-Camera2");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.CameraBackend
    /* JADX INFO: renamed from: isConfigSupported-NpXggIU */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo207isConfigSupportedNpXggIU(CameraGraph.Config config, Continuation<? super ConfigQueryResult> continuation) {
        Camera2Backend$isConfigSupported$1 camera2Backend$isConfigSupported$1;
        CameraGraph.Config config2;
        CameraDeviceSetupCompat cameraDeviceSetupCompat;
        SessionConfiguration sessionConfiguration;
        Integer numBoxInt;
        CaptureRequest.Builder builderCreateCaptureRequest;
        CameraDeviceSetupCompat.SupportQueryResult supportQueryResultIsSessionConfigurationSupported;
        if (continuation instanceof Camera2Backend$isConfigSupported$1) {
            camera2Backend$isConfigSupported$1 = (Camera2Backend$isConfigSupported$1) continuation;
            if ((camera2Backend$isConfigSupported$1.label & Integer.MIN_VALUE) != 0) {
                camera2Backend$isConfigSupported$1.label -= Integer.MIN_VALUE;
            } else {
                camera2Backend$isConfigSupported$1 = new Camera2Backend$isConfigSupported$1(this, continuation);
            }
        }
        Object objM785getOrInitializeDeviceSetupCompat0r8Bogc = camera2Backend$isConfigSupported$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = camera2Backend$isConfigSupported$1.label;
        int iM342getSessionMode2uNL3no = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(objM785getOrInitializeDeviceSetupCompat0r8Bogc);
            if (Build.VERSION.SDK_INT < 35) {
                return ConfigQueryResult.m422boximpl(ConfigQueryResult.INSTANCE.m430getUNKNOWNXp6DSB4());
            }
            Camera2DeviceCache camera2DeviceCache = this.camera2DeviceCache;
            String strM338getCameraDz_R5H8 = config.m338getCameraDz_R5H8();
            camera2Backend$isConfigSupported$1.L$0 = config;
            camera2Backend$isConfigSupported$1.label = 1;
            objM785getOrInitializeDeviceSetupCompat0r8Bogc = camera2DeviceCache.m785getOrInitializeDeviceSetupCompat0r8Bogc(strM338getCameraDz_R5H8, camera2Backend$isConfigSupported$1);
            if (objM785getOrInitializeDeviceSetupCompat0r8Bogc != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sessionConfiguration = (SessionConfiguration) camera2Backend$isConfigSupported$1.L$2;
            cameraDeviceSetupCompat = (CameraDeviceSetupCompat) camera2Backend$isConfigSupported$1.L$1;
            config2 = (CameraGraph.Config) camera2Backend$isConfigSupported$1.L$0;
            ResultKt.throwOnFailure(objM785getOrInitializeDeviceSetupCompat0r8Bogc);
            Camera2DeviceSetupWrapper camera2DeviceSetupWrapper = (Camera2DeviceSetupWrapper) objM785getOrInitializeDeviceSetupCompat0r8Bogc;
            numBoxInt = null;
            builderCreateCaptureRequest = camera2DeviceSetupWrapper == null ? camera2DeviceSetupWrapper.createCaptureRequest(config2.m343getSessionTemplatefGx8uWA()) : null;
            if (builderCreateCaptureRequest != null) {
                for (Map.Entry<?, Object> entry : config2.getSessionParameters().entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    CaptureRequest.Key key2 = key instanceof CaptureRequest.Key ? (CaptureRequest.Key) key : null;
                    if (key2 != null) {
                        builderCreateCaptureRequest.set(key2, value);
                    }
                }
                CaptureRequest captureRequestBuild = builderCreateCaptureRequest.build();
                Intrinsics.checkNotNullExpressionValue(captureRequestBuild, "build(...)");
                Api28Compat.setSessionParameters(sessionConfiguration, captureRequestBuild);
            }
            if (cameraDeviceSetupCompat != null && (supportQueryResultIsSessionConfigurationSupported = cameraDeviceSetupCompat.isSessionConfigurationSupported(sessionConfiguration)) != null) {
                numBoxInt = Boxing.boxInt(supportQueryResultIsSessionConfigurationSupported.getSupported());
            }
            return numBoxInt == null ? ConfigQueryResult.m422boximpl(ConfigQueryResult.m423constructorimpl(numBoxInt.intValue())) : ConfigQueryResult.m422boximpl(ConfigQueryResult.INSTANCE.m430getUNKNOWNXp6DSB4());
        }
        config = (CameraGraph.Config) camera2Backend$isConfigSupported$1.L$0;
        ResultKt.throwOnFailure(objM785getOrInitializeDeviceSetupCompat0r8Bogc);
        CameraDeviceSetupCompat cameraDeviceSetupCompat2 = (CameraDeviceSetupCompat) objM785getOrInitializeDeviceSetupCompat0r8Bogc;
        int iM342getSessionMode2uNL3no2 = config.m342getSessionMode2uNL3no();
        if (CameraGraph.OperatingMode.m363equalsimpl0(iM342getSessionMode2uNL3no2, CameraGraph.OperatingMode.INSTANCE.m370getNORMAL2uNL3no())) {
            iM342getSessionMode2uNL3no = 0;
        } else if (!CameraGraph.OperatingMode.m363equalsimpl0(iM342getSessionMode2uNL3no2, CameraGraph.OperatingMode.INSTANCE.m369getHIGH_SPEED2uNL3no())) {
            if (CameraGraph.OperatingMode.m363equalsimpl0(iM342getSessionMode2uNL3no2, CameraGraph.OperatingMode.INSTANCE.m368getEXTENSION2uNL3no())) {
                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                    android.util.Log.i(Log.TAG, "Unsupported session mode: " + ((Object) CameraGraph.OperatingMode.m365toStringimpl(config.m342getSessionMode2uNL3no())));
                }
                return ConfigQueryResult.m422boximpl(ConfigQueryResult.INSTANCE.m430getUNKNOWNXp6DSB4());
            }
            iM342getSessionMode2uNL3no = config.m342getSessionMode2uNL3no();
        }
        SessionConfiguration sessionConfigurationNewSessionConfiguration = Api35Compat.newSessionConfiguration(iM342getSessionMode2uNL3no, buildOutputConfiguration(config));
        Camera2DeviceCache camera2DeviceCache2 = this.camera2DeviceCache;
        String strM338getCameraDz_R5H82 = config.m338getCameraDz_R5H8();
        camera2Backend$isConfigSupported$1.L$0 = config;
        camera2Backend$isConfigSupported$1.L$1 = cameraDeviceSetupCompat2;
        camera2Backend$isConfigSupported$1.L$2 = sessionConfigurationNewSessionConfiguration;
        camera2Backend$isConfigSupported$1.label = 2;
        Object objM786getOrInitializeDeviceSetupWrapper0r8Bogc = camera2DeviceCache2.m786getOrInitializeDeviceSetupWrapper0r8Bogc(strM338getCameraDz_R5H82, camera2Backend$isConfigSupported$1);
        if (objM786getOrInitializeDeviceSetupWrapper0r8Bogc != coroutine_suspended) {
            config2 = config;
            cameraDeviceSetupCompat = cameraDeviceSetupCompat2;
            objM785getOrInitializeDeviceSetupCompat0r8Bogc = objM786getOrInitializeDeviceSetupWrapper0r8Bogc;
            sessionConfiguration = sessionConfigurationNewSessionConfiguration;
            Camera2DeviceSetupWrapper camera2DeviceSetupWrapper2 = (Camera2DeviceSetupWrapper) objM785getOrInitializeDeviceSetupCompat0r8Bogc;
            numBoxInt = null;
            if (camera2DeviceSetupWrapper2 == null) {
            }
            if (builderCreateCaptureRequest != null) {
            }
            if (cameraDeviceSetupCompat != null) {
                numBoxInt = Boxing.boxInt(supportQueryResultIsSessionConfigurationSupported.getSupported());
            }
            if (numBoxInt == null) {
            }
        }
        return coroutine_suspended;
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2CameraController.ShutdownListener
    public void onControllerClosed(CameraController cameraController) {
        Intrinsics.checkNotNullParameter(cameraController, "cameraController");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, cameraController + " finalized");
        }
        synchronized (this.lock) {
            this.activeCameraControllers.remove(cameraController);
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    /* JADX INFO: renamed from: prewarm-EfqyGwQ */
    public void mo208prewarmEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        this.camera2DeviceManager.mo789prewarmEfqyGwQ(cameraId);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    /* JADX INFO: renamed from: prewarmIsConfigSupported-EfqyGwQ */
    public void mo210prewarmIsConfigSupportedEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        if (Build.VERSION.SDK_INT < 35) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.threads.getCameraPipeScope(), null, null, new Camera2Backend$prewarmIsConfigSupported$1(this, cameraId, null), 3, null);
    }

    @Override // androidx.camera.camera2.pipe.CameraBackend
    public Deferred<Unit> shutdownAsync() {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "Camera2Backend#shutdownAsync");
        }
        this.camera2DeviceCache.shutdown();
        return BuildersKt__Builders_commonKt.async$default(this.threads.getCameraPipeScope(), null, null, new AnonymousClass2(null), 3, null);
    }
}
