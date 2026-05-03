package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraBackendFactory;
import androidx.camera.camera2.pipe.CameraBackendId;
import androidx.camera.camera2.pipe.CameraBackends;
import androidx.camera.camera2.pipe.CameraContext;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.SurfaceTracker;
import androidx.camera.camera2.pipe.graph.GraphProcessorImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraGraphComponent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b!\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/camera/camera2/pipe/config/InternalCameraGraphModules;", "", "<init>", "()V", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public abstract class InternalCameraGraphModules {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: CameraGraphComponent.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J@\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¨\u0006\u0019"}, d2 = {"Landroidx/camera/camera2/pipe/config/InternalCameraGraphModules$Companion;", "", "<init>", "()V", "provideCameraBackend", "Landroidx/camera/camera2/pipe/CameraBackend;", "cameraBackends", "Landroidx/camera/camera2/pipe/CameraBackends;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "cameraContext", "Landroidx/camera/camera2/pipe/CameraContext;", "provideCameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraBackend", "provideCameraController", "Landroidx/camera/camera2/pipe/CameraController;", "graphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "graphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessorImpl;", "streamGraph", "Landroidx/camera/camera2/pipe/StreamGraph;", "surfaceTracker", "Landroidx/camera/camera2/pipe/SurfaceTracker;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @CameraGraphScope
        @Provides
        public final CameraBackend provideCameraBackend(CameraBackends cameraBackends, CameraGraph.Config graphConfig, CameraContext cameraContext) {
            Intrinsics.checkNotNullParameter(cameraBackends, "cameraBackends");
            Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
            Intrinsics.checkNotNullParameter(cameraContext, "cameraContext");
            CameraBackendFactory customCameraBackend = graphConfig.getCustomCameraBackend();
            if (customCameraBackend != null) {
                return customCameraBackend.create(cameraContext);
            }
            String strM339getCameraBackendIdAKmI2lo = graphConfig.m339getCameraBackendIdAKmI2lo();
            if (strM339getCameraBackendIdAKmI2lo == null) {
                return cameraBackends.getDefault();
            }
            CameraBackend cameraBackendMo222getSG3A4s8 = cameraBackends.mo222getSG3A4s8(strM339getCameraBackendIdAKmI2lo);
            if (cameraBackendMo222getSG3A4s8 != null) {
                return cameraBackendMo222getSG3A4s8;
            }
            throw new IllegalStateException(("Failed to initialize " + ((Object) CameraBackendId.m220toStringimpl(strM339getCameraBackendIdAKmI2lo)) + " from " + graphConfig).toString());
        }

        @CameraGraphScope
        @Provides
        public final CameraController provideCameraController(CameraGraphId graphId, CameraGraph.Config graphConfig, CameraBackend cameraBackend, CameraContext cameraContext, GraphProcessorImpl graphProcessor, StreamGraph streamGraph, SurfaceTracker surfaceTracker) {
            Intrinsics.checkNotNullParameter(graphId, "graphId");
            Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
            Intrinsics.checkNotNullParameter(cameraBackend, "cameraBackend");
            Intrinsics.checkNotNullParameter(cameraContext, "cameraContext");
            Intrinsics.checkNotNullParameter(graphProcessor, "graphProcessor");
            Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
            Intrinsics.checkNotNullParameter(surfaceTracker, "surfaceTracker");
            return cameraBackend.createCameraController(cameraContext, graphId, graphConfig, graphProcessor, streamGraph, surfaceTracker);
        }

        @CameraGraphScope
        @Provides
        public final CameraMetadata provideCameraMetadata(CameraGraph.Config graphConfig, CameraBackend cameraBackend) {
            Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
            Intrinsics.checkNotNullParameter(cameraBackend, "cameraBackend");
            CameraMetadata cameraMetadataMo202awaitCameraMetadataEfqyGwQ = cameraBackend.mo202awaitCameraMetadataEfqyGwQ(graphConfig.m338getCameraDz_R5H8());
            if (cameraMetadataMo202awaitCameraMetadataEfqyGwQ != null) {
                return cameraMetadataMo202awaitCameraMetadataEfqyGwQ;
            }
            throw new IllegalStateException(("Failed to load metadata for " + ((Object) CameraId.m385toStringimpl(graphConfig.m338getCameraDz_R5H8())) + '!').toString());
        }
    }
}
