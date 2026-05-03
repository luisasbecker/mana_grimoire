package androidx.camera.camera2.pipe.internal;

import android.os.Build;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameReference;
import androidx.camera.camera2.pipe.ImageSourceConfig;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStatus;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import androidx.camera.camera2.pipe.internal.FrameState;
import androidx.camera.camera2.pipe.internal.OutputMatcher;
import androidx.camera.camera2.pipe.internal.OutputResult;
import androidx.camera.camera2.pipe.media.ClosingFinalizer;
import androidx.camera.camera2.pipe.media.ExpectedOutputsListener;
import androidx.camera.camera2.pipe.media.ImageListener;
import androidx.camera.camera2.pipe.media.ImageSource;
import androidx.camera.camera2.pipe.media.ImageWrapper;
import androidx.camera.camera2.pipe.media.NoOpFinalizer;
import androidx.camera.camera2.pipe.media.OutputImage;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameDistributor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 <2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002;<B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ'\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J'\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b+\u0010,J/\u0010-\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0014H\u0016¢\u0006\u0004\b0\u00101J'\u00102\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020 2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0011\u001a \u0012\u0004\u0012\u00020\u0013\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000f0\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006="}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameDistributor;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroidx/camera/camera2/pipe/Request$Listener;", "streamGraphImpl", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "frameCaptureQueue", "Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;", "isCameraTimebaseRealtime", "", "realtimeToMonotonicOffsetNs", "", "<init>", "(Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;ZJ)V", "frameInfoDistributor", "Landroidx/camera/camera2/pipe/internal/OutputDistributor;", "Landroidx/camera/camera2/pipe/FrameInfo;", "imageDistributors", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroidx/camera/camera2/pipe/OutputId;", "Landroidx/camera/camera2/pipe/media/OutputImage;", "imageStreams", "", "Landroidx/camera/camera2/pipe/CameraStream;", "frameStartedListener", "Landroidx/camera/camera2/pipe/internal/FrameDistributor$FrameStartedListener;", "getFrameStartedListener", "()Landroidx/camera/camera2/pipe/internal/FrameDistributor$FrameStartedListener;", "setFrameStartedListener", "(Landroidx/camera/camera2/pipe/internal/FrameDistributor$FrameStartedListener;)V", "onStarted", "", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", DiagnosticsEntry.TIMESTAMP_KEY, "Landroidx/camera/camera2/pipe/CameraTimestamp;", "onStarted-uGKBvU4", "(Landroidx/camera/camera2/pipe/RequestMetadata;JJ)V", "onComplete", "result", "onComplete-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameInfo;)V", "onBufferLost", "streamId", "outputId", "onBufferLost-iiEMlm4", "(Landroidx/camera/camera2/pipe/RequestMetadata;JII)V", "onFailed", "requestFailure", "Landroidx/camera/camera2/pipe/RequestFailure;", "onFailed-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/RequestFailure;)V", "onAborted", "request", "Landroidx/camera/camera2/pipe/Request;", "close", "FrameStartedListener", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameDistributor implements AutoCloseable, Request.Listener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final FrameCaptureQueue frameCaptureQueue;
    private final OutputDistributor<FrameInfo> frameInfoDistributor;
    private FrameStartedListener frameStartedListener;
    private final Map<StreamId, Map<OutputId, OutputDistributor<OutputImage>>> imageDistributors;
    private final Set<CameraStream> imageStreams;
    private final StreamGraphImpl streamGraphImpl;

    /* JADX INFO: compiled from: FrameDistributor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\r*\u00020\tH\u0082\bJ\r\u0010\u0013\u001a\u00020\r*\u00020\tH\u0082\bJ\r\u0010\u0014\u001a\u00020\r*\u00020\tH\u0082\bJ\r\u0010\u0015\u001a\u00020\r*\u00020\u000bH\u0082\bJ\r\u0010\u0016\u001a\u00020\r*\u00020\u000bH\u0082\b¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameDistributor$Companion;", "", "<init>", "()V", "selectTimestampMatcher", "Landroidx/camera/camera2/pipe/internal/OutputMatcher;", "cameraStreamId", "Landroidx/camera/camera2/pipe/StreamId;", "cameraStreamConfig", "Landroidx/camera/camera2/pipe/CameraStream$Config;", "imageSourceConfig", "Landroidx/camera/camera2/pipe/ImageSourceConfig;", "isCameraTimebaseRealtime", "", "realtimeToMonotonicOffsetNs", "", "selectTimestampMatcher-5y4XNsE", "(ILandroidx/camera/camera2/pipe/CameraStream$Config;Landroidx/camera/camera2/pipe/ImageSourceConfig;ZJ)Landroidx/camera/camera2/pipe/internal/OutputMatcher;", "isRealtimeTimebase", "isSensorTimebase", "isDefaultTimebase", "isVideoEncodeUsage", "isHwComposerUsage", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isDefaultTimebase(CameraStream.Config config) {
            if (Build.VERSION.SDK_INT < 33) {
                return true;
            }
            List<OutputStream.Config> outputs = config.getOutputs();
            if ((outputs instanceof Collection) && outputs.isEmpty()) {
                return true;
            }
            for (OutputStream.Config config2 : outputs) {
                if (config2.getTimestampBase() != null) {
                    OutputStream.TimestampBase timestampBaseM559getTimestampBasepcPfPbY = config2.getTimestampBase();
                    if (!(timestampBaseM559getTimestampBasepcPfPbY == null ? false : OutputStream.TimestampBase.m630equalsimpl0(timestampBaseM559getTimestampBasepcPfPbY.m633unboximpl(), OutputStream.TimestampBase.INSTANCE.m635getTIMESTAMP_BASE_DEFAULT6HVI0MA()))) {
                        return false;
                    }
                }
            }
            return true;
        }

        private final boolean isHwComposerUsage(ImageSourceConfig imageSourceConfig) {
            return (Build.VERSION.SDK_INT < 33 || imageSourceConfig.getUsageFlags() == null || (imageSourceConfig.getUsageFlags().longValue() & 2048) == 0) ? false : true;
        }

        private final boolean isRealtimeTimebase(CameraStream.Config config) {
            if (Build.VERSION.SDK_INT >= 33) {
                List<OutputStream.Config> outputs = config.getOutputs();
                if (!(outputs instanceof Collection) || !outputs.isEmpty()) {
                    Iterator<T> it = outputs.iterator();
                    while (it.hasNext()) {
                        OutputStream.TimestampBase timestampBaseM559getTimestampBasepcPfPbY = ((OutputStream.Config) it.next()).getTimestampBase();
                        if (timestampBaseM559getTimestampBasepcPfPbY == null ? false : OutputStream.TimestampBase.m630equalsimpl0(timestampBaseM559getTimestampBasepcPfPbY.m633unboximpl(), OutputStream.TimestampBase.INSTANCE.m637getTIMESTAMP_BASE_REALTIME6HVI0MA())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private final boolean isSensorTimebase(CameraStream.Config config) {
            if (Build.VERSION.SDK_INT >= 33) {
                List<OutputStream.Config> outputs = config.getOutputs();
                if (!(outputs instanceof Collection) || !outputs.isEmpty()) {
                    Iterator<T> it = outputs.iterator();
                    while (it.hasNext()) {
                        OutputStream.TimestampBase timestampBaseM559getTimestampBasepcPfPbY = ((OutputStream.Config) it.next()).getTimestampBase();
                        if (timestampBaseM559getTimestampBasepcPfPbY == null ? false : OutputStream.TimestampBase.m630equalsimpl0(timestampBaseM559getTimestampBasepcPfPbY.m633unboximpl(), OutputStream.TimestampBase.INSTANCE.m638getTIMESTAMP_BASE_SENSOR6HVI0MA())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private final boolean isVideoEncodeUsage(ImageSourceConfig imageSourceConfig) {
            return (Build.VERSION.SDK_INT < 29 || imageSourceConfig.getUsageFlags() == null || (imageSourceConfig.getUsageFlags().longValue() & 65536) == 0) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0124  */
        @JvmStatic
        /* JADX INFO: renamed from: selectTimestampMatcher-5y4XNsE, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final OutputMatcher m961selectTimestampMatcher5y4XNsE(int cameraStreamId, CameraStream.Config cameraStreamConfig, ImageSourceConfig imageSourceConfig, boolean isCameraTimebaseRealtime, long realtimeToMonotonicOffsetNs) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (!isCameraTimebaseRealtime) {
                if (Build.VERSION.SDK_INT >= 33) {
                    List<OutputStream.Config> outputs = cameraStreamConfig.getOutputs();
                    if (!(outputs instanceof Collection) || !outputs.isEmpty()) {
                        Iterator<T> it = outputs.iterator();
                        while (it.hasNext()) {
                            OutputStream.TimestampBase timestampBaseM559getTimestampBasepcPfPbY = ((OutputStream.Config) it.next()).getTimestampBase();
                            if (timestampBaseM559getTimestampBasepcPfPbY == null ? false : OutputStream.TimestampBase.m630equalsimpl0(timestampBaseM559getTimestampBasepcPfPbY.m633unboximpl(), OutputStream.TimestampBase.INSTANCE.m637getTIMESTAMP_BASE_REALTIME6HVI0MA())) {
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    android.util.Log.d(Log.TAG, "Configuring " + ((Object) StreamId.m749toStringimpl(cameraStreamId)) + " with inexact monotonic-to-realtime timestamp matching rules.");
                                }
                                return OutputMatcher.Companion.forTimestampsWithOffset$default(OutputMatcher.INSTANCE, -realtimeToMonotonicOffsetNs, 0L, 2, null);
                            }
                        }
                    }
                }
                return OutputMatcher.INSTANCE.getEXACT();
            }
            if (Build.VERSION.SDK_INT >= 33) {
                List<OutputStream.Config> outputs2 = cameraStreamConfig.getOutputs();
                if (!(outputs2 instanceof Collection) || !outputs2.isEmpty()) {
                    for (OutputStream.Config config : outputs2) {
                        if (config.getTimestampBase() != null) {
                            OutputStream.TimestampBase timestampBaseM559getTimestampBasepcPfPbY2 = config.getTimestampBase();
                            boolean z4 = timestampBaseM559getTimestampBasepcPfPbY2 == null ? false : OutputStream.TimestampBase.m630equalsimpl0(timestampBaseM559getTimestampBasepcPfPbY2.m633unboximpl(), OutputStream.TimestampBase.INSTANCE.m635getTIMESTAMP_BASE_DEFAULT6HVI0MA());
                            if (!z4) {
                                break;
                            }
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 29 || imageSourceConfig.getUsageFlags() == null || (imageSourceConfig.getUsageFlags().longValue() & 65536) == 0) {
                        if (!((Build.VERSION.SDK_INT >= 33 || imageSourceConfig.getUsageFlags() == null || (imageSourceConfig.getUsageFlags().longValue() & 2048) == 0) ? false : true)) {
                            return OutputMatcher.INSTANCE.getEXACT();
                        }
                    }
                } else if (Build.VERSION.SDK_INT >= 29) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        if (!((Build.VERSION.SDK_INT >= 33 || imageSourceConfig.getUsageFlags() == null || (imageSourceConfig.getUsageFlags().longValue() & 2048) == 0) ? false : true)) {
                        }
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 33) {
                List<OutputStream.Config> outputs3 = cameraStreamConfig.getOutputs();
                if ((outputs3 instanceof Collection) && outputs3.isEmpty()) {
                    z2 = false;
                    if (!z2) {
                    }
                } else {
                    Iterator<T> it2 = outputs3.iterator();
                    while (it2.hasNext()) {
                        OutputStream.TimestampBase timestampBaseM559getTimestampBasepcPfPbY3 = ((OutputStream.Config) it2.next()).getTimestampBase();
                        if (timestampBaseM559getTimestampBasepcPfPbY3 == null ? false : OutputStream.TimestampBase.m630equalsimpl0(timestampBaseM559getTimestampBasepcPfPbY3.m633unboximpl(), OutputStream.TimestampBase.INSTANCE.m637getTIMESTAMP_BASE_REALTIME6HVI0MA())) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            List<OutputStream.Config> outputs4 = cameraStreamConfig.getOutputs();
                            if ((outputs4 instanceof Collection) && outputs4.isEmpty()) {
                                z = false;
                                if (z) {
                                }
                            } else {
                                Iterator<T> it3 = outputs4.iterator();
                                while (it3.hasNext()) {
                                    OutputStream.TimestampBase timestampBaseM559getTimestampBasepcPfPbY4 = ((OutputStream.Config) it3.next()).getTimestampBase();
                                    if (timestampBaseM559getTimestampBasepcPfPbY4 == null ? false : OutputStream.TimestampBase.m630equalsimpl0(timestampBaseM559getTimestampBasepcPfPbY4.m633unboximpl(), OutputStream.TimestampBase.INSTANCE.m638getTIMESTAMP_BASE_SENSOR6HVI0MA())) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                                if (z) {
                                    z3 = true;
                                }
                            }
                        }
                        if (!z3) {
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                android.util.Log.d(Log.TAG, "Configuring " + ((Object) StreamId.m749toStringimpl(cameraStreamId)) + " with inexact realtime-to-monotonic timestamp matching rules.");
                            }
                            return OutputMatcher.Companion.forTimestampsWithOffset$default(OutputMatcher.INSTANCE, realtimeToMonotonicOffsetNs, 0L, 2, null);
                        }
                    }
                }
            }
            return OutputMatcher.INSTANCE.getEXACT();
        }
    }

    /* JADX INFO: compiled from: FrameDistributor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameDistributor$FrameStartedListener;", "", "onFrameStarted", "", "frameReference", "Landroidx/camera/camera2/pipe/FrameReference;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface FrameStartedListener {
        void onFrameStarted(FrameReference frameReference);
    }

    public FrameDistributor(StreamGraphImpl streamGraphImpl, FrameCaptureQueue frameCaptureQueue, boolean z, long j) {
        Intrinsics.checkNotNullParameter(streamGraphImpl, "streamGraphImpl");
        Intrinsics.checkNotNullParameter(frameCaptureQueue, "frameCaptureQueue");
        this.streamGraphImpl = streamGraphImpl;
        this.frameCaptureQueue = frameCaptureQueue;
        this.frameInfoDistributor = new OutputDistributor<>(0, NoOpFinalizer.INSTANCE, OutputMatcher.INSTANCE.getEXACT(), 1, null);
        Map<StreamId, ImageSource> imageSourceMap$camera_camera2_pipe = streamGraphImpl.getImageSourceMap$camera_camera2_pipe();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(imageSourceMap$camera_camera2_pipe.size()));
        Iterator<T> it = imageSourceMap$camera_camera2_pipe.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            int iM750unboximpl = ((StreamId) entry.getKey()).m750unboximpl();
            final ImageSource imageSource = (ImageSource) entry.getValue();
            final CameraStream cameraStream = this.streamGraphImpl.m737getaKI5c8E(iM750unboximpl);
            if (cameraStream == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            CameraStream.Config configM938getCameraStreamConfigaKI5c8E = this.streamGraphImpl.m938getCameraStreamConfigaKI5c8E(iM750unboximpl);
            Intrinsics.checkNotNull(configM938getCameraStreamConfigaKI5c8E);
            ImageSourceConfig imageSourceConfig = configM938getCameraStreamConfigaKI5c8E.getImageSourceConfig();
            Intrinsics.checkNotNull(imageSourceConfig);
            OutputMatcher outputMatcherM961selectTimestampMatcher5y4XNsE = INSTANCE.m961selectTimestampMatcher5y4XNsE(iM750unboximpl, configM938getCameraStreamConfigaKI5c8E, imageSourceConfig, z, j);
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            for (OutputStream outputStream : cameraStream.getOutputs()) {
                mapCreateMapBuilder.put(OutputId.m524boximpl(outputStream.getId()), new OutputDistributor(0, ClosingFinalizer.INSTANCE, outputMatcherM961selectTimestampMatcher5y4XNsE, 1, null));
            }
            final Map mapBuild = MapsKt.build(mapCreateMapBuilder);
            imageSource.setImageListener(new ImageListener() { // from class: androidx.camera.camera2.pipe.internal.FrameDistributor$imageDistributors$1$1
                @Override // androidx.camera.camera2.pipe.media.ImageListener
                /* JADX INFO: renamed from: onImage-2cgRUCs, reason: not valid java name */
                public final void mo962onImage2cgRUCs(int i, int i2, long j2, ImageWrapper imageWrapper) {
                    OutputDistributor<OutputImage> outputDistributor = mapBuild.get(OutputId.m524boximpl(i2));
                    ImageSource imageSource2 = imageSource;
                    if (outputDistributor == null) {
                        throw new IllegalStateException(("Received unexpected images on " + imageSource2 + " from (" + ((Object) StreamId.m749toStringimpl(i)) + ", " + ((Object) OutputId.m529toStringimpl(i2)) + ')').toString());
                    }
                    OutputDistributor<OutputImage> outputDistributor2 = outputDistributor;
                    if (imageWrapper != null) {
                        OutputResult.Companion companion = OutputResult.INSTANCE;
                        outputDistributor2.m979onOutputResultDvZWqE8(j2, OutputResult.m991constructorimpl(OutputImage.INSTANCE.m1014fromAQuxepk(i, i2, imageWrapper)));
                    } else {
                        OutputResult.Companion companion2 = OutputResult.INSTANCE;
                        outputDistributor2.m979onOutputResultDvZWqE8(j2, OutputResult.m991constructorimpl(OutputStatus.m531boximpl(OutputStatus.INSTANCE.m540getERROR_OUTPUT_DROPPEDU7r42EA())));
                    }
                }
            });
            imageSource.setExpectedOutputsListener(new ExpectedOutputsListener() { // from class: androidx.camera.camera2.pipe.internal.FrameDistributor$$ExternalSyntheticLambda0
                @Override // androidx.camera.camera2.pipe.media.ExpectedOutputsListener
                public final void onExpectedOutputs(long j2, Set set) {
                    FrameDistributor.imageDistributors$lambda$0$1(cameraStream, mapBuild, j2, set);
                }
            });
            linkedHashMap.put(key, mapBuild);
        }
        this.imageDistributors = linkedHashMap;
        Set setKeySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
        Iterator it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            CameraStream cameraStream2 = this.streamGraphImpl.m737getaKI5c8E(((StreamId) it2.next()).m750unboximpl());
            if (cameraStream2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            arrayList.add(cameraStream2);
        }
        this.imageStreams = CollectionsKt.toSet(arrayList);
        this.frameStartedListener = new FrameStartedListener() { // from class: androidx.camera.camera2.pipe.internal.FrameDistributor$$ExternalSyntheticLambda1
            @Override // androidx.camera.camera2.pipe.internal.FrameDistributor.FrameStartedListener
            public final void onFrameStarted(FrameReference frameReference) {
                Intrinsics.checkNotNullParameter(frameReference, "it");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imageDistributors$lambda$0$1(CameraStream cameraStream, Map map, long j, Set outputIds) {
        Intrinsics.checkNotNullParameter(outputIds, "outputIds");
        List<OutputStream> outputs = cameraStream.getOutputs();
        int size = outputs.size();
        for (int i = 0; i < size; i++) {
            int id = outputs.get(i).getId();
            if (!outputIds.contains(OutputId.m524boximpl(id))) {
                Object obj = map.get(OutputId.m524boximpl(id));
                if (obj == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                OutputResult.Companion companion = OutputResult.INSTANCE;
                ((OutputDistributor) obj).m979onOutputResultDvZWqE8(j, OutputResult.m991constructorimpl(OutputStatus.m531boximpl(OutputStatus.INSTANCE.m544getUNAVAILABLEU7r42EA())));
            }
        }
    }

    @JvmStatic
    /* JADX INFO: renamed from: selectTimestampMatcher-5y4XNsE, reason: not valid java name */
    private static final OutputMatcher m959selectTimestampMatcher5y4XNsE(int i, CameraStream.Config config, ImageSourceConfig imageSourceConfig, boolean z, long j) {
        return INSTANCE.m961selectTimestampMatcher5y4XNsE(i, config, imageSourceConfig, z, j);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.frameCaptureQueue.close();
        this.frameInfoDistributor.close();
        Iterator<Map<OutputId, OutputDistributor<OutputImage>>> it = this.imageDistributors.values().iterator();
        while (it.hasNext()) {
            Iterator<OutputDistributor<OutputImage>> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().close();
            }
        }
    }

    public final FrameStartedListener getFrameStartedListener() {
        return this.frameStartedListener;
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    public void onAborted(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        FrameCaptureQueue.FrameCaptureImpl frameCaptureImplRemove = this.frameCaptureQueue.remove(request);
        if (frameCaptureImplRemove != null) {
            frameCaptureImplRemove.m957completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m539getERROR_OUTPUT_ABORTEDU7r42EA());
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onBufferLost-iiEMlm4 */
    public void mo63onBufferLostiiEMlm4(RequestMetadata requestMetadata, long frameNumber, int streamId, int outputId) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Map<OutputId, OutputDistributor<OutputImage>> map = this.imageDistributors.get(StreamId.m744boximpl(streamId));
        if (map == null) {
            return;
        }
        CameraStream.Config configM938getCameraStreamConfigaKI5c8E = this.streamGraphImpl.m938getCameraStreamConfigaKI5c8E(streamId);
        if (configM938getCameraStreamConfigaKI5c8E == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        ImageSourceConfig imageSourceConfig = configM938getCameraStreamConfigaKI5c8E.getImageSourceConfig();
        if (imageSourceConfig != null && imageSourceConfig.getEnableConcurrentOutputs()) {
            OutputDistributor<OutputImage> outputDistributor = map.get(OutputId.m524boximpl(outputId));
            if (outputDistributor == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            outputDistributor.m978onOutputFailureVw7M1qk(frameNumber);
            return;
        }
        if (!map.containsKey(OutputId.m524boximpl(outputId))) {
            throw new IllegalStateException("Check failed.");
        }
        Iterator<OutputDistributor<OutputImage>> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().m978onOutputFailureVw7M1qk(frameNumber);
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onComplete-CcXjc1I */
    public void mo29onCompleteCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo result) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(result, "result");
        OutputDistributor<FrameInfo> outputDistributor = this.frameInfoDistributor;
        OutputResult.Companion companion = OutputResult.INSTANCE;
        outputDistributor.m979onOutputResultDvZWqE8(frameNumber, OutputResult.m991constructorimpl(result));
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onFailed-CcXjc1I */
    public void mo30onFailedCcXjc1I(RequestMetadata requestMetadata, long frameNumber, RequestFailure requestFailure) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
        OutputDistributor<FrameInfo> outputDistributor = this.frameInfoDistributor;
        OutputResult.Companion companion = OutputResult.INSTANCE;
        outputDistributor.m979onOutputResultDvZWqE8(frameNumber, OutputResult.m991constructorimpl(OutputStatus.m531boximpl(OutputStatus.INSTANCE.m541getERROR_OUTPUT_FAILEDU7r42EA())));
        if (requestFailure.getWasImageCaptured()) {
            return;
        }
        Iterator<StreamId> it = requestMetadata.getStreams().keySet().iterator();
        while (it.hasNext()) {
            Map<OutputId, OutputDistributor<OutputImage>> map = this.imageDistributors.get(StreamId.m744boximpl(it.next().m750unboximpl()));
            if (map != null) {
                Iterator<OutputDistributor<OutputImage>> it2 = map.values().iterator();
                while (it2.hasNext()) {
                    it2.next().m978onOutputFailureVw7M1qk(frameNumber);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onStarted-uGKBvU4 */
    public void mo67onStarteduGKBvU4(RequestMetadata requestMetadata, long frameNumber, long timestamp) {
        FrameCaptureQueue.FrameCaptureImpl frameCaptureImplRemove;
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        FrameState frameState = new FrameState(requestMetadata, frameNumber, timestamp, this.imageStreams, null);
        this.frameInfoDistributor.m980onOutputStartedqGubWw0(frameNumber, timestamp, frameNumber, frameState.getFrameInfoOutput());
        int size = frameState.getImageOutputs().size();
        for (int i = 0; i < size; i++) {
            FrameState.ImageOutput imageOutput = frameState.getImageOutputs().get(i);
            Map<OutputId, OutputDistributor<OutputImage>> map = this.imageDistributors.get(StreamId.m744boximpl(imageOutput.getStreamId()));
            if (map == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            OutputDistributor<OutputImage> outputDistributor = map.get(OutputId.m524boximpl(imageOutput.getOutputId()));
            if (outputDistributor == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            OutputDistributor<OutputImage> outputDistributor2 = outputDistributor;
            outputDistributor2.m980onOutputStartedqGubWw0(frameNumber, timestamp, timestamp, imageOutput);
            if (!requestMetadata.getStreams().keySet().contains(StreamId.m744boximpl(imageOutput.getStreamId()))) {
                outputDistributor2.m978onOutputFailureVw7M1qk(frameState.getFrameNumber());
            }
        }
        FrameImpl frameImpl = new FrameImpl(frameState, null, 2, 0 == true ? 1 : 0);
        this.frameStartedListener.onFrameStarted(frameImpl);
        if (requestMetadata.getRepeating() || (frameCaptureImplRemove = this.frameCaptureQueue.remove(requestMetadata.getRequest())) == null) {
            frameImpl.close();
        } else {
            frameCaptureImplRemove.completeWith(frameImpl);
        }
    }

    public final void setFrameStartedListener(FrameStartedListener frameStartedListener) {
        Intrinsics.checkNotNullParameter(frameStartedListener, "<set-?>");
        this.frameStartedListener = frameStartedListener;
    }
}
