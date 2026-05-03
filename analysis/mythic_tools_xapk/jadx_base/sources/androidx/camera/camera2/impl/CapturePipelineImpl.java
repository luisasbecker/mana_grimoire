package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.view.Surface;
import androidx.camera.camera2.adapter.CaptureConfigAdapter;
import androidx.camera.camera2.adapter.CaptureResultAdapter;
import androidx.camera.camera2.compat.workaround.FlashAvailabilityCheckerKt;
import androidx.camera.camera2.compat.workaround.UseTorchAsFlash;
import androidx.camera.camera2.config.UseCaseCameraScope;
import androidx.camera.camera2.config.UseCaseGraphContext;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.Metadata;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.RequestNumber;
import androidx.camera.camera2.pipe.RequestTemplate;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConvergenceUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.media3.muxer.WebmConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: CapturePipeline.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ß\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001i\b\u0007\u0018\u00002\u00020\u0001:\u0002vwB_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010,\u001a\u0004\u0018\u00010+H\u0082@¢\u0006\u0002\u0010-JL\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/2\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020%2\b\u00107\u001a\u0004\u0018\u000108H\u0082@¢\u0006\u0002\u00109JT\u0010:\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0/2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u00104\u001a\u00020%2\u0006\u00106\u001a\u00020%2\u0006\u00105\u001a\u00020%H\u0096@¢\u0006\u0004\bA\u0010BJ&\u0010C\u001a\u00020D2\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020%H\u0096@¢\u0006\u0002\u0010EJp\u0010F\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/*\b\u0012\u0004\u0012\u0002030/2\b\u00107\u001a\u0004\u0018\u0001082\u001e\b\u0004\u0010G\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I\u0012\u0006\u0012\u0004\u0018\u00010K0H2\u001e\b\u0004\u0010L\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I\u0012\u0006\u0012\u0004\u0018\u00010K0HH\u0082H¢\u0006\u0002\u0010MJD\u0010N\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010OJD\u0010P\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010OJ<\u0010Q\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010RJL\u0010S\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\u0006\u0010T\u001a\u00020U2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/2\u0006\u0010V\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010WJD\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010T\u001a\u00020U2\u0006\u00104\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010YJ<\u0010Z\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010RJ\u0016\u0010[\u001a\u00020J2\u0006\u00104\u001a\u00020%H\u0087@¢\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020J2\u0006\u00104\u001a\u00020%H\u0087@¢\u0006\u0002\u0010\\J\u001e\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020U2\u0006\u0010a\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010bJ+\u0010c\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001a0H2\u0006\u0010a\u001a\u00020\u001aH\u0002J\f\u0010f\u001a\u00020g*\u00020+H\u0002J\u0016\u0010k\u001a\u00020_2\u0006\u0010T\u001a\u00020UH\u0082@¢\u0006\u0002\u0010lJ\u001e\u0010m\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\u0006\u0010n\u001a\u000208H\u0002J\u0016\u0010o\u001a\u00020\u001a2\u0006\u00105\u001a\u00020%H\u0082@¢\u0006\u0002\u0010\\J=\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020U2#\b\u0002\u0010s\u001a\u001d\u0012\u0013\u0012\u00110q¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(t\u0012\u0004\u0012\u00020\u001a0HH\u0082@¢\u0006\u0002\u0010uJ\u0016\u0010a\u001a\u00020\u001a2\u0006\u00106\u001a\u00020%H\u0082@¢\u0006\u0002\u0010\\R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001f\u001a\n  *\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0004\n\u0002\u0010j¨\u0006x"}, d2 = {"Landroidx/camera/camera2/impl/CapturePipelineImpl;", "Landroidx/camera/camera2/impl/CapturePipeline;", "configAdapter", "Landroidx/camera/camera2/adapter/CaptureConfigAdapter;", "flashControl", "Landroidx/camera/camera2/impl/FlashControl;", "torchControl", "Landroidx/camera/camera2/impl/TorchControl;", "videoUsageControl", "Landroidx/camera/camera2/impl/VideoUsageControl;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "requestListener", "Landroidx/camera/camera2/impl/ComboRequestListener;", "useTorchAsFlash", "Landroidx/camera/camera2/compat/workaround/UseTorchAsFlash;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "useCaseCameraStateProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseGraphContext", "Landroidx/camera/camera2/config/UseCaseGraphContext;", "<init>", "(Landroidx/camera/camera2/adapter/CaptureConfigAdapter;Landroidx/camera/camera2/impl/FlashControl;Landroidx/camera/camera2/impl/TorchControl;Landroidx/camera/camera2/impl/VideoUsageControl;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/impl/ComboRequestListener;Landroidx/camera/camera2/compat/workaround/UseTorchAsFlash;Landroidx/camera/camera2/impl/CameraProperties;Ljavax/inject/Provider;Landroidx/camera/camera2/config/UseCaseGraphContext;)V", "hasFlashUnit", "", "getHasFlashUnit", "()Z", "hasFlashUnit$delegate", "Lkotlin/Lazy;", "useCaseCameraState", "kotlin.jvm.PlatformType", "getUseCaseCameraState", "()Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseCameraState$delegate", "template", "", "getTemplate", "()I", "setTemplate", "(I)V", "frameMetadata", "Landroidx/camera/camera2/pipe/FrameMetadata;", "getFrameMetadata", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeCaptureTasks", "", "Lkotlinx/coroutines/Deferred;", "Ljava/lang/Void;", "pipelineTasks", "Landroidx/camera/camera2/impl/CapturePipelineImpl$PipelineTask;", "captureMode", "flashMode", "flashType", "mainCaptureParams", "Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;", "(Ljava/util/List;IIILandroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitStillCaptures", "configs", "Landroidx/camera/core/impl/CaptureConfig;", "requestTemplate", "Landroidx/camera/camera2/pipe/RequestTemplate;", "sessionConfigOptions", "Landroidx/camera/core/impl/Config;", "submitStillCaptures-BvXKQx0", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCameraCapturePipeline", "Landroidx/camera/core/imagecapture/CameraCapturePipeline;", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "preCapture", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "postCapture", "(Ljava/util/List;Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "torchAsFlashCapture", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultCapture", "defaultNoFlashCapture", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "torchApplyCapture", "timeLimitNs", "", "triggerAePreCapture", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;IJLjava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aePreCaptureApplyCapture", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;JILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "screenFlashCapture", "invokeScreenFlashPreCaptureTasks", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeScreenFlashPostCaptureTasks", "lockAf", "Landroidx/camera/camera2/pipe/Result3A;", "convergedTimeLimitNs", "isTorchAsFlash", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConvergeCondition", "Lkotlin/ParameterName;", "name", "toCameraCaptureResult", "Landroidx/camera/core/impl/CameraCaptureResult;", "emptyRequestMetadata", "androidx/camera/camera2/impl/CapturePipelineImpl$emptyRequestMetadata$1", "Landroidx/camera/camera2/impl/CapturePipelineImpl$emptyRequestMetadata$1;", "unlockAf", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitRequestInternal", NativeProtocol.WEB_DIALOG_PARAMS, "isPhysicalFlashRequired", "waitForResult", "Landroidx/camera/camera2/pipe/FrameInfo;", "waitTimeoutNanos", "checker", "totalCaptureResult", "(JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PipelineTask", "MainCaptureParams", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseCaseCameraScope
public final class CapturePipelineImpl implements CapturePipeline {
    private final CaptureConfigAdapter configAdapter;
    private final CapturePipelineImpl$emptyRequestMetadata$1 emptyRequestMetadata;
    private final FlashControl flashControl;
    private FrameMetadata frameMetadata;

    /* JADX INFO: renamed from: hasFlashUnit$delegate, reason: from kotlin metadata */
    private final Lazy hasFlashUnit;
    private final ComboRequestListener requestListener;
    private int template;
    private final UseCaseThreads threads;
    private final TorchControl torchControl;

    /* JADX INFO: renamed from: useCaseCameraState$delegate, reason: from kotlin metadata */
    private final Lazy useCaseCameraState;
    private final Provider<UseCaseCameraState> useCaseCameraStateProvider;
    private final UseCaseGraphContext useCaseGraphContext;
    private final UseTorchAsFlash useTorchAsFlash;
    private final VideoUsageControl videoUsageControl;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000eJ\t\u0010\u0015\u001a\u00020\bHÆ\u0003J4\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;", "", "configs", "", "Landroidx/camera/core/impl/CaptureConfig;", "requestTemplate", "Landroidx/camera/camera2/pipe/RequestTemplate;", "sessionConfigOptions", "Landroidx/camera/core/impl/Config;", "<init>", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConfigs", "()Ljava/util/List;", "getRequestTemplate-fGx8uWA", "()I", "I", "getSessionConfigOptions", "()Landroidx/camera/core/impl/Config;", "component1", "component2", "component2-fGx8uWA", "component3", "copy", "copy-9al78dA", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;)Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class MainCaptureParams {
        private final List<CaptureConfig> configs;
        private final int requestTemplate;
        private final Config sessionConfigOptions;

        private MainCaptureParams(List<CaptureConfig> configs, int i, Config sessionConfigOptions) {
            Intrinsics.checkNotNullParameter(configs, "configs");
            Intrinsics.checkNotNullParameter(sessionConfigOptions, "sessionConfigOptions");
            this.configs = configs;
            this.requestTemplate = i;
            this.sessionConfigOptions = sessionConfigOptions;
        }

        public /* synthetic */ MainCaptureParams(List list, int i, Config config, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, i, config);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-9al78dA$default, reason: not valid java name */
        public static /* synthetic */ MainCaptureParams m81copy9al78dA$default(MainCaptureParams mainCaptureParams, List list, int i, Config config, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = mainCaptureParams.configs;
            }
            if ((i2 & 2) != 0) {
                i = mainCaptureParams.requestTemplate;
            }
            if ((i2 & 4) != 0) {
                config = mainCaptureParams.sessionConfigOptions;
            }
            return mainCaptureParams.m83copy9al78dA(list, i, config);
        }

        public final List<CaptureConfig> component1() {
            return this.configs;
        }

        /* JADX INFO: renamed from: component2-fGx8uWA, reason: not valid java name and from getter */
        public final int getRequestTemplate() {
            return this.requestTemplate;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Config getSessionConfigOptions() {
            return this.sessionConfigOptions;
        }

        /* JADX INFO: renamed from: copy-9al78dA, reason: not valid java name */
        public final MainCaptureParams m83copy9al78dA(List<CaptureConfig> configs, int requestTemplate, Config sessionConfigOptions) {
            Intrinsics.checkNotNullParameter(configs, "configs");
            Intrinsics.checkNotNullParameter(sessionConfigOptions, "sessionConfigOptions");
            return new MainCaptureParams(configs, requestTemplate, sessionConfigOptions, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MainCaptureParams)) {
                return false;
            }
            MainCaptureParams mainCaptureParams = (MainCaptureParams) other;
            return Intrinsics.areEqual(this.configs, mainCaptureParams.configs) && RequestTemplate.m670equalsimpl0(this.requestTemplate, mainCaptureParams.requestTemplate) && Intrinsics.areEqual(this.sessionConfigOptions, mainCaptureParams.sessionConfigOptions);
        }

        public final List<CaptureConfig> getConfigs() {
            return this.configs;
        }

        /* JADX INFO: renamed from: getRequestTemplate-fGx8uWA, reason: not valid java name */
        public final int m84getRequestTemplatefGx8uWA() {
            return this.requestTemplate;
        }

        public final Config getSessionConfigOptions() {
            return this.sessionConfigOptions;
        }

        public int hashCode() {
            return (((this.configs.hashCode() * 31) + RequestTemplate.m672hashCodeimpl(this.requestTemplate)) * 31) + this.sessionConfigOptions.hashCode();
        }

        public String toString() {
            return "MainCaptureParams(configs=" + this.configs + ", requestTemplate=" + ((Object) RequestTemplate.m673toStringimpl(this.requestTemplate)) + ", sessionConfigOptions=" + this.sessionConfigOptions + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/impl/CapturePipelineImpl$PipelineTask;", "", "<init>", "(Ljava/lang/String;I)V", "PRE_CAPTURE", "MAIN_CAPTURE", "POST_CAPTURE", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class PipelineTask {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PipelineTask[] $VALUES;
        public static final PipelineTask PRE_CAPTURE = new PipelineTask("PRE_CAPTURE", 0);
        public static final PipelineTask MAIN_CAPTURE = new PipelineTask("MAIN_CAPTURE", 1);
        public static final PipelineTask POST_CAPTURE = new PipelineTask("POST_CAPTURE", 2);

        private static final /* synthetic */ PipelineTask[] $values() {
            return new PipelineTask[]{PRE_CAPTURE, MAIN_CAPTURE, POST_CAPTURE};
        }

        static {
            PipelineTask[] pipelineTaskArr$values = $values();
            $VALUES = pipelineTaskArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pipelineTaskArr$values);
        }

        private PipelineTask(String str, int i) {
        }

        public static EnumEntries<PipelineTask> getEntries() {
            return $ENTRIES;
        }

        public static PipelineTask valueOf(String str) {
            return (PipelineTask) Enum.valueOf(PipelineTask.class, str);
        }

        public static PipelineTask[] values() {
            return (PipelineTask[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$aePreCaptureApplyCapture$1, reason: invalid class name */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {887, Videoio.CAP_PROP_XI_CC_MATRIX_33, Videoio.CAP_PROP_XI_ACQ_FRAME_BURST_COUNT}, m = "aePreCaptureApplyCapture", n = {"this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "timeLimitNs", "captureMode", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.aePreCaptureApplyCapture(null, 0L, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$defaultCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0}, l = {352, 357, 359, 362}, m = "defaultCapture", n = {"mainCaptureParams", "pipelineTasks", "captureMode"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C02181 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02181(Continuation<? super C02181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.defaultCapture(null, 0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$defaultNoFlashCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0, 0}, l = {378}, m = "defaultNoFlashCapture", n = {"this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "lock3ARequired"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C02191 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02191(Continuation<? super C02191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.defaultNoFlashCapture(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$getFrameMetadata$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {}, l = {WebmConstants.MkvEbmlElement.PIXEL_WIDTH}, m = "getFrameMetadata", n = {}, s = {}, v = 1)
    static final class C02201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02201(Continuation<? super C02201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.getFrameMetadata(this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$invokeCaptureTasks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {1, 1, 1, 1}, l = {216, 217, 218, 220}, m = "invokeCaptureTasks", n = {"pipelineTasks", "mainCaptureParams", "captureMode", "flashMode"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C02211 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02211(Continuation<? super C02211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.invokeCaptureTasks(null, 0, 0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$invokeScreenFlashPostCaptureTasks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 1}, l = {Videoio.CAP_PROP_XI_KNEEPOINT1, 875, 570}, m = "invokeScreenFlashPostCaptureTasks", n = {"captureMode", "captureMode"}, s = {"I$0", "I$0"}, v = 1)
    static final class C02221 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02221(Continuation<? super C02221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.invokeScreenFlashPostCaptureTasks(0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$invokeScreenFlashPreCaptureTasks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 1}, l = {Videoio.CAP_PROP_XI_TRG_DELAY, 871, Videoio.CAP_PROP_XI_BUFFERS_QUEUE_SIZE, 556}, m = "invokeScreenFlashPreCaptureTasks", n = {"captureMode", "captureMode"}, s = {"I$0", "I$0"}, v = 1)
    static final class C02231 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02231(Continuation<? super C02231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.invokeScreenFlashPreCaptureTasks(0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$isPhysicalFlashRequired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {}, l = {772}, m = "isPhysicalFlashRequired", n = {}, s = {}, v = 1)
    static final class C02241 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C02241(Continuation<? super C02241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.isPhysicalFlashRequired(0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$isTorchAsFlash$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/camera/camera2/pipe/FrameMetadata;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$isTorchAsFlash$2", f = "CapturePipeline.kt", i = {}, l = {808}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02252 extends SuspendLambda implements Function1<Continuation<? super FrameMetadata>, Object> {
        int label;

        C02252(Continuation<? super C02252> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CapturePipelineImpl.this.new C02252(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super FrameMetadata> continuation) {
            return ((C02252) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object frameMetadata = CapturePipelineImpl.this.getFrameMetadata(this);
            return frameMetadata == coroutine_suspended ? coroutine_suspended : frameMetadata;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$lockAf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0}, l = {871, Videoio.CAP_PROP_XI_SENSOR_FEATURE_SELECTOR, Videoio.CAP_PROP_XI_FFS_FILE_ID}, m = "lockAf", n = {"convergedTimeLimitNs", "isTorchAsFlash"}, s = {"J$0", "Z$0"}, v = 1)
    static final class C02261 extends ContinuationImpl {
        long J$0;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02261(Continuation<? super C02261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.lockAf(0L, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$screenFlashCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0, 0}, l = {528}, m = "screenFlashCapture", n = {"this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C02271 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02271(Continuation<? super C02271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.screenFlashCapture(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$torchApplyCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5}, l = {Videoio.CAP_PROP_XI_GPI_LEVEL, 895, 416, 421, Videoio.CAP_PROP_XI_SHUTTER_TYPE, Videoio.CAP_PROP_XI_AEAG_ROI_OFFSET_Y}, m = "torchApplyCapture", n = {"this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "timeLimitNs", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "timeLimitNs", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "triggerAePreCapture", "torchOnRequired", "lock3ARequired"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "J$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "Z$0", "I$1", "I$2"}, v = 1)
    static final class C02281 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02281(Continuation<? super C02281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.torchApplyCapture(null, 0, 0L, null, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$torchAsFlashCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0}, l = {330, 331, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS}, m = "torchAsFlashCapture", n = {"mainCaptureParams", "pipelineTasks", "captureMode"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C02291 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02291(Continuation<? super C02291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.torchAsFlashCapture(null, 0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$unlockAf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0}, l = {871, 648, 649}, m = "unlockAf", n = {"timeLimitNs"}, s = {"J$0"}, v = 1)
    static final class C02301 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02301(Continuation<? super C02301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.unlockAf(0L, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0}, l = {793}, m = "waitForResult", n = {"resultListener"}, s = {"L$0"}, v = 1)
    static final class C02311 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02311(Continuation<? super C02311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.waitForResult(0L, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$3, reason: invalid class name */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/camera/camera2/pipe/FrameInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$3", f = "CapturePipeline.kt", i = {}, l = {796}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FrameInfo>, Object> {
        final /* synthetic */ ResultListener $resultListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ResultListener resultListener, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$resultListener = resultListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$resultListener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FrameInfo> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objAwait = this.$resultListener.getResult().await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.camera.camera2.impl.CapturePipelineImpl$emptyRequestMetadata$1] */
    @Inject
    public CapturePipelineImpl(CaptureConfigAdapter configAdapter, FlashControl flashControl, TorchControl torchControl, VideoUsageControl videoUsageControl, UseCaseThreads threads, ComboRequestListener requestListener, UseTorchAsFlash useTorchAsFlash, final CameraProperties cameraProperties, Provider<UseCaseCameraState> useCaseCameraStateProvider, UseCaseGraphContext useCaseGraphContext) {
        Intrinsics.checkNotNullParameter(configAdapter, "configAdapter");
        Intrinsics.checkNotNullParameter(flashControl, "flashControl");
        Intrinsics.checkNotNullParameter(torchControl, "torchControl");
        Intrinsics.checkNotNullParameter(videoUsageControl, "videoUsageControl");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(useTorchAsFlash, "useTorchAsFlash");
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(useCaseCameraStateProvider, "useCaseCameraStateProvider");
        Intrinsics.checkNotNullParameter(useCaseGraphContext, "useCaseGraphContext");
        this.configAdapter = configAdapter;
        this.flashControl = flashControl;
        this.torchControl = torchControl;
        this.videoUsageControl = videoUsageControl;
        this.threads = threads;
        this.requestListener = requestListener;
        this.useTorchAsFlash = useTorchAsFlash;
        this.useCaseCameraStateProvider = useCaseCameraStateProvider;
        this.useCaseGraphContext = useCaseGraphContext;
        this.hasFlashUnit = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(FlashAvailabilityCheckerKt.isFlashAvailable$default(cameraProperties, false, 1, null));
            }
        });
        this.useCaseCameraState = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.useCaseCameraStateProvider.get();
            }
        });
        this.template = 1;
        this.emptyRequestMetadata = new RequestMetadata() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$emptyRequestMetadata$1
            private final int template = RequestTemplate.m668constructorimpl(0);
            private final Map<StreamId, Surface> streams = MapsKt.emptyMap();
            private final boolean repeating = true;
            private final Request request = new Request(CollectionsKt.emptyList(), null, null, null, null, null, 62, null);
            private final long requestNumber = RequestNumber.m661constructorimpl(0);

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public <T> T get(CaptureRequest.Key<T> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return null;
            }

            @Override // androidx.camera.camera2.pipe.Metadata
            public <T> T get(Metadata.Key<T> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return null;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public <T> T getOrDefault(CaptureRequest.Key<T> key, T t) {
                Intrinsics.checkNotNullParameter(key, "key");
                return t;
            }

            @Override // androidx.camera.camera2.pipe.Metadata
            public <T> T getOrDefault(Metadata.Key<T> key, T t) {
                Intrinsics.checkNotNullParameter(key, "key");
                return t;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public boolean getRepeating() {
                return this.repeating;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public Request getRequest() {
                return this.request;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            /* JADX INFO: renamed from: getRequestNumber-my6kx4g, reason: not valid java name and from getter */
            public long getRequestNumber() {
                return this.requestNumber;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public Map<StreamId, Surface> getStreams() {
                return this.streams;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            /* JADX INFO: renamed from: getTemplate-fGx8uWA, reason: not valid java name and from getter */
            public int getTemplate() {
                return this.template;
            }

            @Override // androidx.camera.camera2.pipe.UnsafeWrapper
            public <T> T unwrapAs(KClass<T> type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018d A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:14:0x0047, B:67:0x0185, B:69:0x018d, B:70:0x0196), top: B:112:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object aePreCaptureApplyCapture(MainCaptureParams mainCaptureParams, long j, int i, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        MainCaptureParams mainCaptureParams2;
        int i2;
        CapturePipelineImpl capturePipelineImpl;
        List<? extends PipelineTask> list2;
        MainCaptureParams mainCaptureParams3;
        Object obj;
        int i3;
        long j2;
        CapturePipelineImpl capturePipelineImpl2;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2;
        CameraGraph.Session session;
        Throwable th;
        AutoCloseable autoCloseable3;
        boolean z;
        CapturePipelineImpl capturePipelineImpl3;
        List<? extends PipelineTask> list3;
        boolean z2;
        MainCaptureParams mainCaptureParams4;
        int i4;
        List<? extends PipelineTask> list4;
        List<? extends PipelineTask> list5;
        Continuation continuation2;
        List<Deferred<Void>> listListOf;
        List<? extends PipelineTask> list6 = list;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object obj2 = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = anonymousClass12.label;
        try {
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture");
                    }
                    Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list6);
                    }
                    if (!list6.contains(PipelineTask.PRE_CAPTURE)) {
                        mainCaptureParams2 = mainCaptureParams;
                        i2 = i;
                        capturePipelineImpl = this;
                        if (list6.contains(PipelineTask.MAIN_CAPTURE)) {
                        }
                        if (list6.contains(PipelineTask.POST_CAPTURE)) {
                        }
                        return listListOf;
                    }
                    Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
                    }
                    Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture: Acquiring session for locking 3A");
                    }
                    CameraGraph graph = this.useCaseGraphContext.getGraph();
                    anonymousClass12.L$0 = this;
                    anonymousClass12.L$1 = list6;
                    anonymousClass12.L$2 = mainCaptureParams;
                    anonymousClass12.J$0 = j;
                    anonymousClass12.I$0 = i;
                    anonymousClass12.label = 1;
                    Object objAcquireSession = graph.acquireSession(anonymousClass12);
                    if (objAcquireSession != coroutine_suspended) {
                        list2 = list6;
                        mainCaptureParams3 = mainCaptureParams;
                        obj = objAcquireSession;
                        i3 = i;
                        j2 = j;
                        capturePipelineImpl2 = this;
                    }
                    return coroutine_suspended;
                }
                if (i5 != 1) {
                    if (i5 == 2) {
                        i4 = anonymousClass12.I$0;
                        AutoCloseable autoCloseable4 = (AutoCloseable) anonymousClass12.L$3;
                        mainCaptureParams4 = (MainCaptureParams) anonymousClass12.L$2;
                        List<? extends PipelineTask> list7 = (List) anonymousClass12.L$1;
                        CapturePipelineImpl capturePipelineImpl4 = (CapturePipelineImpl) anonymousClass12.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            autoCloseable2 = autoCloseable4;
                            list4 = list7;
                            capturePipelineImpl = capturePipelineImpl4;
                            anonymousClass12.L$0 = capturePipelineImpl;
                            anonymousClass12.L$1 = list4;
                            anonymousClass12.L$2 = mainCaptureParams4;
                            anonymousClass12.L$3 = autoCloseable2;
                            anonymousClass12.I$0 = i4;
                            anonymousClass12.label = 3;
                            if (((Deferred) obj2).join(anonymousClass12) != coroutine_suspended) {
                                MainCaptureParams mainCaptureParams5 = mainCaptureParams4;
                                list5 = list4;
                                mainCaptureParams2 = mainCaptureParams5;
                                autoCloseable3 = autoCloseable2;
                                Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                }
                                Unit unit = Unit.INSTANCE;
                                AutoCloseableKt.closeFinally(autoCloseable3, null);
                                Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                }
                                i2 = i4;
                                list6 = list5;
                                if (list6.contains(PipelineTask.MAIN_CAPTURE)) {
                                }
                                if (list6.contains(PipelineTask.POST_CAPTURE)) {
                                }
                                return listListOf;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th2) {
                            th = th2;
                            autoCloseable3 = autoCloseable4;
                            throw th;
                        }
                    }
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i4 = anonymousClass12.I$0;
                    autoCloseable3 = (AutoCloseable) anonymousClass12.L$3;
                    mainCaptureParams2 = (MainCaptureParams) anonymousClass12.L$2;
                    list5 = (List) anonymousClass12.L$1;
                    capturePipelineImpl = (CapturePipelineImpl) anonymousClass12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        Camera2Logger camera2Logger52 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture: Locking 3A for capture done");
                        }
                        Unit unit2 = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(autoCloseable3, null);
                        Camera2Logger camera2Logger62 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                        }
                        i2 = i4;
                        list6 = list5;
                        if (list6.contains(PipelineTask.MAIN_CAPTURE)) {
                            Camera2Logger camera2Logger7 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                            }
                            if (mainCaptureParams2 == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            List<Deferred<Void>> listSubmitRequestInternal = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                            Camera2Logger camera2Logger8 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                            }
                            listListOf = listSubmitRequestInternal;
                            continuation2 = null;
                        } else {
                            continuation2 = null;
                            listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                        }
                        if (list6.contains(PipelineTask.POST_CAPTURE)) {
                            BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1(listListOf, continuation2, this, i2), 3, null);
                        }
                        return listListOf;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            AutoCloseableKt.closeFinally(autoCloseable3, th);
                            throw th4;
                        }
                    }
                }
                int i6 = anonymousClass12.I$0;
                long j3 = anonymousClass12.J$0;
                MainCaptureParams mainCaptureParams6 = (MainCaptureParams) anonymousClass12.L$2;
                List<? extends PipelineTask> list8 = (List) anonymousClass12.L$1;
                capturePipelineImpl2 = (CapturePipelineImpl) anonymousClass12.L$0;
                ResultKt.throwOnFailure(obj2);
                i3 = i6;
                mainCaptureParams3 = mainCaptureParams6;
                list2 = list8;
                j2 = j3;
                obj = obj2;
                Object objLock3AForCapture$default = CameraGraph.Session.lock3AForCapture$default(session, z2, z, 0, j2, anonymousClass12, 4, null);
                if (objLock3AForCapture$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mainCaptureParams4 = mainCaptureParams3;
                i4 = i3;
                obj2 = objLock3AForCapture$default;
                capturePipelineImpl = capturePipelineImpl3;
                list4 = list3;
                anonymousClass12.L$0 = capturePipelineImpl;
                anonymousClass12.L$1 = list4;
                anonymousClass12.L$2 = mainCaptureParams4;
                anonymousClass12.L$3 = autoCloseable2;
                anonymousClass12.I$0 = i4;
                anonymousClass12.label = 3;
                if (((Deferred) obj2).join(anonymousClass12) != coroutine_suspended) {
                }
                return coroutine_suspended;
            } catch (Throwable th5) {
                th = th5;
                th = th;
                autoCloseable3 = autoCloseable2;
                throw th;
            }
            session = (CameraGraph.Session) autoCloseable;
            Camera2Logger camera2Logger9 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                try {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture: Locking 3A for capture");
                } catch (Throwable th6) {
                    th = th6;
                    autoCloseable3 = autoCloseable;
                    throw th;
                }
            }
            boolean z3 = i3 == 0;
            z = i3 == 0;
            anonymousClass12.L$0 = capturePipelineImpl2;
            anonymousClass12.L$1 = list2;
            anonymousClass12.L$2 = mainCaptureParams3;
            anonymousClass12.L$3 = autoCloseable;
            anonymousClass12.I$0 = i3;
            anonymousClass12.label = 2;
            capturePipelineImpl3 = capturePipelineImpl2;
            list3 = list2;
            z2 = z3;
            autoCloseable2 = autoCloseable;
        } catch (Throwable th7) {
            th = th7;
            autoCloseable2 = autoCloseable;
            th = th;
            autoCloseable3 = autoCloseable2;
            throw th;
        }
        autoCloseable = (AutoCloseable) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object defaultCapture(MainCaptureParams mainCaptureParams, int i, int i2, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) throws Exception {
        C02181 c02181;
        if (continuation instanceof C02181) {
            c02181 = (C02181) continuation;
            if ((c02181.label & Integer.MIN_VALUE) != 0) {
                c02181.label -= Integer.MIN_VALUE;
            } else {
                c02181 = new C02181(continuation);
            }
        }
        C02181 c021812 = c02181;
        Object objIsPhysicalFlashRequired = c021812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c021812.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
            if (getHasFlashUnit()) {
                c021812.L$0 = mainCaptureParams;
                c021812.L$1 = list;
                c021812.I$0 = i;
                c021812.label = 1;
                objIsPhysicalFlashRequired = isPhysicalFlashRequired(i2, c021812);
                if (objIsPhysicalFlashRequired != coroutine_suspended) {
                }
            } else {
                c021812.label = 4;
                Object objDefaultNoFlashCapture = defaultNoFlashCapture(mainCaptureParams, i, list, c021812);
                if (objDefaultNoFlashCapture != coroutine_suspended) {
                    return objDefaultNoFlashCapture;
                }
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
                return objIsPhysicalFlashRequired;
            }
            if (i3 == 3) {
                ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
                return objIsPhysicalFlashRequired;
            }
            if (i3 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
            return objIsPhysicalFlashRequired;
        }
        i = c021812.I$0;
        list = (List) c021812.L$1;
        mainCaptureParams = (MainCaptureParams) c021812.L$0;
        ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
        MainCaptureParams mainCaptureParams2 = mainCaptureParams;
        int i4 = i;
        List<? extends PipelineTask> list2 = list;
        boolean zBooleanValue = ((Boolean) objIsPhysicalFlashRequired).booleanValue();
        long j = zBooleanValue ? CapturePipelineKt.CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS : CapturePipelineKt.CHECK_3A_TIMEOUT_IN_NS;
        if (zBooleanValue || i4 == 0) {
            c021812.L$0 = null;
            c021812.L$1 = null;
            c021812.label = 2;
            Object objAePreCaptureApplyCapture = aePreCaptureApplyCapture(mainCaptureParams2, j, i4, list2, c021812);
            if (objAePreCaptureApplyCapture != coroutine_suspended) {
                return objAePreCaptureApplyCapture;
            }
        } else {
            c021812.L$0 = null;
            c021812.L$1 = null;
            c021812.label = 3;
            Object objDefaultNoFlashCapture2 = defaultNoFlashCapture(mainCaptureParams2, i4, list2, c021812);
            if (objDefaultNoFlashCapture2 != coroutine_suspended) {
                return objDefaultNoFlashCapture2;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object defaultNoFlashCapture(MainCaptureParams mainCaptureParams, int i, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        C02191 c02191;
        int i2;
        CapturePipelineImpl capturePipelineImpl;
        MainCaptureParams mainCaptureParams2;
        List<Deferred<Void>> listListOf;
        List<? extends PipelineTask> list2 = list;
        if (continuation instanceof C02191) {
            c02191 = (C02191) continuation;
            if ((c02191.label & Integer.MIN_VALUE) != 0) {
                c02191.label -= Integer.MIN_VALUE;
            } else {
                c02191 = new C02191(continuation);
            }
        }
        Object obj = c02191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c02191.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#defaultNoFlashCapture");
            }
            i2 = i == 0 ? 1 : 0;
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list2);
            }
            if (!list2.contains(PipelineTask.PRE_CAPTURE)) {
                capturePipelineImpl = this;
                mainCaptureParams2 = mainCaptureParams;
                if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                }
                if (list2.contains(PipelineTask.POST_CAPTURE)) {
                }
                return listListOf;
            }
            Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
            }
            if (i2 == 0) {
                capturePipelineImpl = this;
                mainCaptureParams2 = mainCaptureParams;
                Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                }
                if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                    Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                    }
                    if (mainCaptureParams2 == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                    Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                    }
                } else {
                    listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                }
                if (list2.contains(PipelineTask.POST_CAPTURE)) {
                    BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$defaultNoFlashCapture$$inlined$invoke$1(listListOf, null, i2 != 0, this), 3, null);
                }
                return listListOf;
            }
            Camera2Logger camera2Logger7 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#defaultNoFlashCapture: Locking 3A");
            }
            long j = CapturePipelineKt.CHECK_3A_TIMEOUT_IN_NS;
            c02191.L$0 = this;
            c02191.L$1 = list2;
            c02191.L$2 = mainCaptureParams;
            c02191.I$0 = i2;
            c02191.label = 1;
            if (lockAf(j, false, c02191) == coroutine_suspended) {
                return coroutine_suspended;
            }
            capturePipelineImpl = this;
            mainCaptureParams2 = mainCaptureParams;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c02191.I$0;
            mainCaptureParams2 = (MainCaptureParams) c02191.L$2;
            List<? extends PipelineTask> list3 = (List) c02191.L$1;
            capturePipelineImpl = (CapturePipelineImpl) c02191.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i4;
            list2 = list3;
        }
        Camera2Logger camera2Logger8 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#defaultNoFlashCapture: Locking 3A done");
        }
        Camera2Logger camera2Logger42 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
        }
        if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
        }
        if (list2.contains(PipelineTask.POST_CAPTURE)) {
        }
        return listListOf;
    }

    private final Function1<FrameMetadata, Boolean> getConvergeCondition(final boolean isTorchAsFlash) {
        return new Function1() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CapturePipelineImpl.getConvergeCondition$lambda$0(this.f$0, isTorchAsFlash, (FrameMetadata) obj));
            }
        };
    }

    static final boolean getConvergeCondition$lambda$0(CapturePipelineImpl capturePipelineImpl, boolean z, FrameMetadata frameMetadata) {
        Intrinsics.checkNotNullParameter(frameMetadata, "frameMetadata");
        return ConvergenceUtils.is3AConverged(capturePipelineImpl.toCameraCaptureResult(frameMetadata), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getFrameMetadata(Continuation<? super FrameMetadata> continuation) {
        C02201 c02201;
        CapturePipelineImpl capturePipelineImpl;
        CapturePipelineImpl capturePipelineImpl2;
        if (continuation instanceof C02201) {
            c02201 = (C02201) continuation;
            if ((c02201.label & Integer.MIN_VALUE) != 0) {
                c02201.label -= Integer.MIN_VALUE;
            } else {
                c02201 = new C02201(continuation);
            }
        }
        C02201 c022012 = c02201;
        Object objWaitForResult$default = c022012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c022012.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWaitForResult$default);
            if (this.frameMetadata != null) {
                capturePipelineImpl = this;
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "getFrameMetadata: frameMetadata = " + capturePipelineImpl.frameMetadata);
                }
                return capturePipelineImpl.frameMetadata;
            }
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "getFrameMetadata: waiting for result");
            }
            long j = CapturePipelineKt.CHECK_FLASH_REQUIRED_TIMEOUT_IN_NS;
            c022012.L$0 = this;
            c022012.label = 1;
            capturePipelineImpl = this;
            objWaitForResult$default = waitForResult$default(capturePipelineImpl, j, null, c022012, 2, null);
            if (objWaitForResult$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            capturePipelineImpl2 = capturePipelineImpl;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            capturePipelineImpl2 = (CapturePipelineImpl) c022012.L$0;
            ResultKt.throwOnFailure(objWaitForResult$default);
            capturePipelineImpl = this;
        }
        FrameInfo frameInfo = (FrameInfo) objWaitForResult$default;
        capturePipelineImpl2.frameMetadata = frameInfo != null ? frameInfo.getMetadata() : null;
        Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
        }
        return capturePipelineImpl.frameMetadata;
    }

    private final boolean getHasFlashUnit() {
        return ((Boolean) this.hasFlashUnit.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UseCaseCameraState getUseCaseCameraState() {
        return (UseCaseCameraState) this.useCaseCameraState.getValue();
    }

    private final Object invoke(List<? extends PipelineTask> list, MainCaptureParams mainCaptureParams, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function1<? super Continuation<? super Unit>, ? extends Object> function12, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        List<Deferred<Void>> listListOf;
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list);
        }
        if (list.contains(PipelineTask.PRE_CAPTURE)) {
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
            }
            function1.invoke(continuation);
            Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
            }
        }
        if (list.contains(PipelineTask.MAIN_CAPTURE)) {
            Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
            }
            if (mainCaptureParams == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            listListOf = submitRequestInternal(mainCaptureParams);
            Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
            }
            Unit unit = Unit.INSTANCE;
        } else {
            listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
        }
        if (list.contains(PipelineTask.POST_CAPTURE)) {
            BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new CapturePipelineImpl$invoke$7$1(listListOf, function12, null), 3, null);
        }
        Unit unit2 = Unit.INSTANCE;
        return listListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeCaptureTasks(List<? extends PipelineTask> list, int i, int i2, int i3, MainCaptureParams mainCaptureParams, Continuation<? super List<? extends Deferred<Void>>> continuation) throws Exception {
        C02211 c02211;
        if (continuation instanceof C02211) {
            c02211 = (C02211) continuation;
            if ((c02211.label & Integer.MIN_VALUE) != 0) {
                c02211.label -= Integer.MIN_VALUE;
            } else {
                c02211 = new C02211(continuation);
            }
        }
        Object objIsTorchAsFlash = c02211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c02211.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(objIsTorchAsFlash);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#invokeCaptureTasks: tasks = " + list + ", captureMode = " + i + ", flashMode = " + i2 + ", flashType = " + i3);
            }
            this.frameMetadata = null;
            if (list.contains(PipelineTask.MAIN_CAPTURE) && mainCaptureParams == null) {
                throw new IllegalStateException("Must not be null for PipelineType.MAIN_CAPTURE".toString());
            }
            if (i2 == 3) {
                c02211.label = 1;
                Object objScreenFlashCapture = screenFlashCapture(mainCaptureParams, i, list, c02211);
                if (objScreenFlashCapture != coroutine_suspended) {
                    return objScreenFlashCapture;
                }
            } else {
                c02211.L$0 = list;
                c02211.L$1 = mainCaptureParams;
                c02211.I$0 = i;
                c02211.I$1 = i2;
                c02211.label = 2;
                objIsTorchAsFlash = isTorchAsFlash(i3, c02211);
                if (objIsTorchAsFlash != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            ResultKt.throwOnFailure(objIsTorchAsFlash);
            return objIsTorchAsFlash;
        }
        if (i4 != 2) {
            if (i4 == 3) {
                ResultKt.throwOnFailure(objIsTorchAsFlash);
                return objIsTorchAsFlash;
            }
            if (i4 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsTorchAsFlash);
            return objIsTorchAsFlash;
        }
        i2 = c02211.I$1;
        i = c02211.I$0;
        mainCaptureParams = (MainCaptureParams) c02211.L$1;
        list = (List) c02211.L$0;
        ResultKt.throwOnFailure(objIsTorchAsFlash);
        List<? extends PipelineTask> list2 = list;
        MainCaptureParams mainCaptureParams2 = mainCaptureParams;
        if (((Boolean) objIsTorchAsFlash).booleanValue()) {
            c02211.L$0 = null;
            c02211.L$1 = null;
            c02211.label = 3;
            Object obj = torchAsFlashCapture(mainCaptureParams2, i, i2, list2, c02211);
            if (obj != coroutine_suspended) {
                return obj;
            }
        } else {
            C02211 c022112 = c02211;
            c022112.L$0 = null;
            c022112.L$1 = null;
            c022112.label = 4;
            Object objDefaultCapture = defaultCapture(mainCaptureParams2, i, i2, list2, c022112);
            if (objDefaultCapture != coroutine_suspended) {
                return objDefaultCapture;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object isPhysicalFlashRequired(int i, Continuation<? super Boolean> continuation) {
        C02241 c02241;
        if (continuation instanceof C02241) {
            c02241 = (C02241) continuation;
            if ((c02241.label & Integer.MIN_VALUE) != 0) {
                c02241.label -= Integer.MIN_VALUE;
            } else {
                c02241 = new C02241(continuation);
            }
        }
        Object frameMetadata = c02241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02241.label;
        boolean z = false;
        if (i2 == 0) {
            ResultKt.throwOnFailure(frameMetadata);
            if (i != 0) {
                if (i == 1) {
                    z = true;
                } else if (i != 2 && i != 3) {
                    throw new AssertionError(i);
                }
                return Boxing.boxBoolean(z);
            }
            c02241.label = 1;
            frameMetadata = getFrameMetadata(c02241);
            if (frameMetadata == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(frameMetadata);
        }
        FrameMetadata frameMetadata2 = (FrameMetadata) frameMetadata;
        if (frameMetadata2 != null) {
            CaptureResult.Key CONTROL_AE_STATE = CaptureResult.CONTROL_AE_STATE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_STATE, "CONTROL_AE_STATE");
            Integer num = (Integer) frameMetadata2.get(CONTROL_AE_STATE);
            if (num != null && num.intValue() == 4) {
            }
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object isTorchAsFlash(int i, Continuation<? super Boolean> continuation) {
        return (getTemplate() == 3 || i == 1) ? Boxing.boxBoolean(true) : this.useTorchAsFlash.shouldUseTorchAsFlash(new C02252(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object lockAf(long j, boolean z, Continuation<? super Result3A> continuation) throws Exception {
        C02261 c02261;
        boolean z2;
        long j2;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2;
        int i;
        Object obj;
        C02261 c022612;
        AutoCloseable autoCloseable3;
        Throwable th;
        if (continuation instanceof C02261) {
            c02261 = (C02261) continuation;
            if ((c02261.label & Integer.MIN_VALUE) != 0) {
                c02261.label -= Integer.MIN_VALUE;
            } else {
                c02261 = new C02261(continuation);
            }
        }
        Object objAcquireSession = c02261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02261.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAcquireSession);
                CameraGraph graph = this.useCaseGraphContext.getGraph();
                c02261.J$0 = j;
                z2 = z;
                c02261.Z$0 = z2;
                c02261.label = 1;
                objAcquireSession = graph.acquireSession(c02261);
                if (objAcquireSession == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j2 = j;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(objAcquireSession);
                        return objAcquireSession;
                    }
                    autoCloseable2 = (AutoCloseable) c02261.L$0;
                    try {
                        ResultKt.throwOnFailure(objAcquireSession);
                        obj = coroutine_suspended;
                        autoCloseable3 = autoCloseable2;
                        c022612 = c02261;
                        i = 3;
                        try {
                            Deferred deferred = (Deferred) objAcquireSession;
                            AutoCloseableKt.closeFinally(autoCloseable3, null);
                            c022612.L$0 = null;
                            c022612.label = i;
                            Object objAwait = deferred.await(c022612);
                            return objAwait != obj ? obj : objAwait;
                        } catch (Throwable th2) {
                            th = th2;
                            autoCloseable2 = autoCloseable3;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                AutoCloseableKt.closeFinally(autoCloseable2, th);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        throw th;
                    }
                }
                z2 = c02261.Z$0;
                long j3 = c02261.J$0;
                ResultKt.throwOnFailure(objAcquireSession);
                j2 = j3;
            }
            Lock3ABehavior lock3ABehaviorM511boximpl = Lock3ABehavior.m511boximpl(Lock3ABehavior.INSTANCE.m518getAFTER_CURRENT_SCANhRqSH3k());
            Function1<FrameMetadata, Boolean> convergeCondition = getConvergeCondition(z2);
            long j4 = CapturePipelineKt.CHECK_3A_TIMEOUT_IN_NS;
            c02261.L$0 = autoCloseable;
            c02261.label = 2;
            C02261 c022613 = c02261;
            i = 3;
            obj = coroutine_suspended;
            Object objM372lock3AtS25XM$default = CameraGraph.Session.m372lock3AtS25XM$default((CameraGraph.Session) autoCloseable, null, null, null, null, null, null, null, lock3ABehaviorM511boximpl, null, null, convergeCondition, null, 0, j2, j4, c022613, 6719, null);
            c022612 = c022613;
            if (objM372lock3AtS25XM$default == obj) {
                return obj;
            }
            autoCloseable3 = autoCloseable;
            objAcquireSession = objM372lock3AtS25XM$default;
            Deferred deferred2 = (Deferred) objAcquireSession;
            AutoCloseableKt.closeFinally(autoCloseable3, null);
            c022612.L$0 = null;
            c022612.label = i;
            Object objAwait2 = deferred2.await(c022612);
            if (objAwait2 != obj) {
            }
        } catch (Throwable th5) {
            th = th5;
            autoCloseable2 = autoCloseable;
            th = th;
            throw th;
        }
        autoCloseable = (AutoCloseable) objAcquireSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object screenFlashCapture(MainCaptureParams mainCaptureParams, int i, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        C02271 c02271;
        CapturePipelineImpl capturePipelineImpl;
        List<Deferred<Void>> listListOf;
        if (continuation instanceof C02271) {
            c02271 = (C02271) continuation;
            if ((c02271.label & Integer.MIN_VALUE) != 0) {
                c02271.label -= Integer.MIN_VALUE;
            } else {
                c02271 = new C02271(continuation);
            }
        }
        Object obj = c02271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02271.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#screenFlashCapture");
            }
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list);
            }
            if (!list.contains(PipelineTask.PRE_CAPTURE)) {
                capturePipelineImpl = this;
                if (list.contains(PipelineTask.MAIN_CAPTURE)) {
                    listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                } else {
                    Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                    }
                    if (mainCaptureParams == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams);
                    Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                    }
                }
                if (list.contains(PipelineTask.POST_CAPTURE)) {
                    BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$screenFlashCapture$$inlined$invoke$1(listListOf, null, this, i), 3, null);
                }
                return listListOf;
            }
            Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
            }
            c02271.L$0 = this;
            c02271.L$1 = list;
            c02271.L$2 = mainCaptureParams;
            c02271.I$0 = i;
            c02271.label = 1;
            if (invokeScreenFlashPreCaptureTasks(i, c02271) == coroutine_suspended) {
                return coroutine_suspended;
            }
            capturePipelineImpl = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c02271.I$0;
            mainCaptureParams = (MainCaptureParams) c02271.L$2;
            list = (List) c02271.L$1;
            capturePipelineImpl = (CapturePipelineImpl) c02271.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
        }
        if (list.contains(PipelineTask.MAIN_CAPTURE)) {
        }
        if (list.contains(PipelineTask.POST_CAPTURE)) {
        }
        return listListOf;
    }

    private final List<Deferred<Void>> submitRequestInternal(MainCaptureParams params) {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#submitRequestInternal; Submitting " + params.getConfigs() + " with CameraPipe");
        }
        ArrayList arrayList = new ArrayList();
        List<CaptureConfig> configs = params.getConfigs();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = configs.iterator();
        while (true) {
            Request requestM27mapToRequestnAberiA = null;
            if (!it.hasNext()) {
                break;
            }
            CaptureConfig captureConfig = (CaptureConfig) it.next();
            final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            arrayList.add(completableDeferredCompletableDeferred$default);
            try {
                requestM27mapToRequestnAberiA = this.configAdapter.m27mapToRequestnAberiA(captureConfig, params.m84getRequestTemplatefGx8uWA(), params.getSessionConfigOptions(), CollectionsKt.listOf(new Request.Listener() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$submitRequestInternal$requests$1$1
                    @Override // androidx.camera.camera2.pipe.Request.Listener
                    public void onAborted(Request request) {
                        Intrinsics.checkNotNullParameter(request, "request");
                        completableDeferredCompletableDeferred$default.completeExceptionally(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", null));
                    }

                    @Override // androidx.camera.camera2.pipe.Request.Listener
                    /* JADX INFO: renamed from: onFailed-CcXjc1I */
                    public void mo30onFailedCcXjc1I(RequestMetadata requestMetadata, long frameNumber, RequestFailure requestFailure) {
                        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                        Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
                        completableDeferredCompletableDeferred$default.completeExceptionally(new ImageCaptureException(2, "Capture request failed with reason " + requestFailure.getReason(), null));
                    }

                    @Override // androidx.camera.camera2.pipe.Request.Listener
                    /* JADX INFO: renamed from: onTotalCaptureResult-CcXjc1I */
                    public void mo31onTotalCaptureResultCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo totalCaptureResult) {
                        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                        Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
                        completableDeferredCompletableDeferred$default.complete(null);
                    }
                }));
            } catch (IllegalStateException e) {
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                IllegalStateException illegalStateException = e;
                if (Logger.isInfoEnabled(Log.TAG)) {
                    android.util.Log.i(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#submitRequestInternal: configAdapter.mapToRequest failed!", illegalStateException);
                }
                completableDeferredCompletableDeferred$default.completeExceptionally(new ImageCaptureException(2, "Capture request failed with reason " + e.getMessage(), illegalStateException));
            }
            if (requestM27mapToRequestnAberiA != null) {
                arrayList2.add(requestM27mapToRequestnAberiA);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return arrayList;
        }
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1(null, this, arrayList, arrayList3), 3, null);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraCaptureResult toCameraCaptureResult(final FrameMetadata frameMetadata) {
        return new CaptureResultAdapter(this.emptyRequestMetadata, frameMetadata.mo483getFrameNumberUgla2oM(), new FrameInfo(frameMetadata, this) { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$toCameraCaptureResult$frameInfo$1
            private final String camera;
            private final FrameMetadata frameMetadata;
            private final long frameNumber;
            private final FrameMetadata metadata;
            private final RequestMetadata requestMetadata;

            {
                this.frameMetadata = frameMetadata;
                this.metadata = frameMetadata;
                this.camera = frameMetadata.getCamera();
                this.frameNumber = frameMetadata.mo483getFrameNumberUgla2oM();
                this.requestMetadata = this.emptyRequestMetadata;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            /* JADX INFO: renamed from: get-EfqyGwQ, reason: not valid java name */
            public FrameMetadata mo87getEfqyGwQ(String camera) {
                Intrinsics.checkNotNullParameter(camera, "camera");
                return this.frameMetadata;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: not valid java name and from getter */
            public String getCamera() {
                return this.camera;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            /* JADX INFO: renamed from: getFrameNumber-Ugla2oM, reason: not valid java name and from getter */
            public long getFrameNumber() {
                return this.frameNumber;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            public FrameMetadata getMetadata() {
                return this.metadata;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            public RequestMetadata getRequestMetadata() {
                return this.requestMetadata;
            }

            @Override // androidx.camera.camera2.pipe.UnsafeWrapper
            public <T> T unwrapAs(KClass<T> type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return null;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object torchApplyCapture(MainCaptureParams mainCaptureParams, int i, long j, List<? extends PipelineTask> list, boolean z, Continuation<? super List<? extends Deferred<Void>>> continuation) throws Exception {
        C02281 c02281;
        int i2;
        MainCaptureParams mainCaptureParams2;
        boolean z2;
        int i3;
        List<? extends PipelineTask> list2;
        CapturePipelineImpl capturePipelineImpl;
        int i4;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        List<? extends PipelineTask> list3;
        int i7;
        long j2;
        long j3;
        boolean z5;
        int i8;
        int i9;
        MainCaptureParams mainCaptureParams3;
        List<? extends PipelineTask> list4;
        CapturePipelineImpl capturePipelineImpl2;
        long j4;
        int i10;
        MainCaptureParams mainCaptureParams4;
        int i11;
        List<? extends PipelineTask> list5;
        CapturePipelineImpl capturePipelineImpl3;
        AutoCloseable autoCloseable;
        Throwable th;
        AutoCloseable autoCloseable2;
        Object objLock3AForCapture$default;
        AutoCloseable autoCloseable3;
        int i12;
        List<? extends PipelineTask> list6;
        CapturePipelineImpl capturePipelineImpl4;
        MainCaptureParams mainCaptureParams5;
        boolean z6;
        CapturePipelineImpl capturePipelineImpl5;
        List<Deferred<Void>> listListOf;
        if (continuation instanceof C02281) {
            c02281 = (C02281) continuation;
            if ((c02281.label & Integer.MIN_VALUE) != 0) {
                c02281.label -= Integer.MIN_VALUE;
            } else {
                c02281 = new C02281(continuation);
            }
        }
        C02281 c022812 = c02281;
        Object objAwait = c022812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c022812.label) {
            case 0:
                ResultKt.throwOnFailure(objAwait);
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture");
                }
                Integer value = this.torchControl.getTorchStateLiveData().getValue();
                i2 = (value != null && value.intValue() == 0) ? 1 : 0;
                int i13 = (i2 != 0 || i == 0) ? 1 : 0;
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list);
                }
                if (!list.contains(PipelineTask.PRE_CAPTURE)) {
                    mainCaptureParams2 = mainCaptureParams;
                    z2 = true;
                    i3 = i;
                    list2 = list;
                    capturePipelineImpl = this;
                    i4 = i13;
                    z3 = z;
                    if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                    }
                    if (list2.contains(PipelineTask.POST_CAPTURE)) {
                    }
                    return listListOf;
                }
                Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
                }
                if (i2 == 0) {
                    mainCaptureParams2 = mainCaptureParams;
                    i5 = i2;
                    capturePipelineImpl = this;
                    i6 = i13;
                    z4 = z;
                    list3 = list;
                    i7 = i;
                    j2 = j;
                    if (z4) {
                    }
                    return coroutine_suspended;
                }
                Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Setting torch");
                }
                Deferred deferredM100setTorchAsyncOup_wC0$camera_camera2$default = TorchControl.m100setTorchAsyncOup_wC0$camera_camera2$default(this.torchControl, TorchControl.TorchMode.INSTANCE.m114getUSED_AS_FLASHIRs_R8(), false, false, 6, null);
                c022812.L$0 = this;
                c022812.L$1 = list;
                mainCaptureParams2 = mainCaptureParams;
                c022812.L$2 = mainCaptureParams2;
                c022812.I$0 = i;
                c022812.J$0 = j;
                c022812.Z$0 = z;
                c022812.I$1 = i2;
                c022812.I$2 = i13;
                c022812.label = 1;
                if (deferredM100setTorchAsyncOup_wC0$camera_camera2$default.join(c022812) != coroutine_suspended) {
                    i5 = i2;
                    capturePipelineImpl = this;
                    i6 = i13;
                    z4 = z;
                    list3 = list;
                    j3 = j;
                    i7 = i;
                    j2 = j3;
                    Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Setting torch done");
                    }
                    if (z4) {
                        Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture");
                        }
                        CameraGraph graph = this.useCaseGraphContext.getGraph();
                        c022812.L$0 = capturePipelineImpl;
                        c022812.L$1 = list3;
                        c022812.L$2 = mainCaptureParams2;
                        c022812.I$0 = i7;
                        c022812.J$0 = j2;
                        c022812.Z$0 = z4;
                        c022812.I$1 = i5;
                        c022812.I$2 = i6;
                        c022812.label = 2;
                        Object objAcquireSession = graph.acquireSession(c022812);
                        if (objAcquireSession != coroutine_suspended) {
                            j4 = j2;
                            i4 = i6;
                            objAwait = objAcquireSession;
                            i10 = i5;
                            mainCaptureParams4 = mainCaptureParams2;
                            i11 = i7;
                            long j5 = j4;
                            list5 = list3;
                            capturePipelineImpl3 = capturePipelineImpl;
                            autoCloseable = (AutoCloseable) objAwait;
                            try {
                                CameraGraph.Session session = (CameraGraph.Session) autoCloseable;
                                boolean z7 = i11 != 0;
                                boolean z8 = i11 != 0;
                                c022812.L$0 = capturePipelineImpl3;
                                c022812.L$1 = list5;
                                c022812.L$2 = mainCaptureParams4;
                                c022812.L$3 = autoCloseable;
                                c022812.I$0 = i11;
                                c022812.Z$0 = z4;
                                c022812.I$1 = i10;
                                c022812.I$2 = i4;
                                c022812.label = 3;
                                boolean z9 = z4;
                                MainCaptureParams mainCaptureParams6 = mainCaptureParams4;
                                z2 = true;
                                objLock3AForCapture$default = CameraGraph.Session.lock3AForCapture$default(session, z7, z8, 0, j5, c022812, 4, null);
                                if (objLock3AForCapture$default != coroutine_suspended) {
                                    autoCloseable3 = autoCloseable;
                                    objAwait = objLock3AForCapture$default;
                                    i12 = i11;
                                    list6 = list5;
                                    capturePipelineImpl4 = capturePipelineImpl3;
                                    mainCaptureParams5 = mainCaptureParams6;
                                    z6 = z9;
                                    c022812.L$0 = capturePipelineImpl4;
                                    c022812.L$1 = list6;
                                    c022812.L$2 = mainCaptureParams5;
                                    c022812.L$3 = autoCloseable3;
                                    c022812.I$0 = i12;
                                    c022812.Z$0 = z6;
                                    c022812.I$1 = i10;
                                    c022812.I$2 = i4;
                                    c022812.label = 4;
                                    objAwait = ((Deferred) objAwait).await(c022812);
                                    if (objAwait != coroutine_suspended) {
                                        z5 = z6;
                                        i8 = i12;
                                        autoCloseable2 = autoCloseable3;
                                        mainCaptureParams2 = mainCaptureParams5;
                                        list2 = list6;
                                        capturePipelineImpl5 = capturePipelineImpl4;
                                        Result3A result3A = (Result3A) objAwait;
                                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                                        Camera2Logger camera2Logger7 = Camera2Logger.INSTANCE;
                                        if (Logger.isDebugEnabled(Log.TAG)) {
                                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture done, result3A = " + result3A);
                                        }
                                        i2 = i10;
                                        capturePipelineImpl = capturePipelineImpl5;
                                        Camera2Logger camera2Logger8 = Camera2Logger.INSTANCE;
                                        if (Logger.isDebugEnabled(Log.TAG)) {
                                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                                        }
                                        i3 = i8;
                                        z3 = z5;
                                        if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                                            listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                                        } else {
                                            Camera2Logger camera2Logger9 = Camera2Logger.INSTANCE;
                                            if (Logger.isDebugEnabled(Log.TAG)) {
                                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                                            }
                                            if (mainCaptureParams2 == null) {
                                                throw new IllegalStateException("Required value was null.".toString());
                                            }
                                            listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                                            Camera2Logger camera2Logger10 = Camera2Logger.INSTANCE;
                                            if (Logger.isDebugEnabled(Log.TAG)) {
                                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                                            }
                                        }
                                        if (list2.contains(PipelineTask.POST_CAPTURE)) {
                                            CoroutineScope sequentialScope = capturePipelineImpl.threads.getSequentialScope();
                                            int i14 = i4;
                                            boolean z10 = i2 != 0 ? z2 : false;
                                            if (i14 == 0) {
                                                z2 = false;
                                            }
                                            BuildersKt__Builders_commonKt.launch$default(sequentialScope, null, null, new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(listListOf, null, z10, this, z3, z2, i3), 3, null);
                                        }
                                        return listListOf;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                autoCloseable2 = autoCloseable;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    AutoCloseableKt.closeFinally(autoCloseable2, th);
                                    throw th3;
                                }
                            }
                        }
                    } else {
                        z2 = true;
                        if (i6 == 0) {
                            i4 = i6;
                            z5 = z4;
                            i2 = i5;
                            i8 = i7;
                            list2 = list3;
                            Camera2Logger camera2Logger82 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                            }
                            i3 = i8;
                            z3 = z5;
                            if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                            }
                            if (list2.contains(PipelineTask.POST_CAPTURE)) {
                            }
                            return listListOf;
                        }
                        if (i7 == 0) {
                            Camera2Logger camera2Logger11 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A");
                            }
                            c022812.L$0 = capturePipelineImpl;
                            c022812.L$1 = list3;
                            c022812.L$2 = mainCaptureParams2;
                            c022812.I$0 = i7;
                            c022812.Z$0 = z4;
                            c022812.I$1 = i5;
                            c022812.I$2 = i6;
                            c022812.label = 5;
                            if (lockAf(j2, true, c022812) != coroutine_suspended) {
                                i4 = i6;
                                z5 = z4;
                                i9 = i5;
                                mainCaptureParams3 = mainCaptureParams2;
                                i8 = i7;
                                list4 = list3;
                                capturePipelineImpl2 = capturePipelineImpl;
                                Camera2Logger camera2Logger12 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A done");
                                }
                                i2 = i9;
                                capturePipelineImpl = capturePipelineImpl2;
                                list2 = list4;
                                mainCaptureParams2 = mainCaptureParams3;
                                Camera2Logger camera2Logger822 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                }
                                i3 = i8;
                                z3 = z5;
                                if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                                }
                                if (list2.contains(PipelineTask.POST_CAPTURE)) {
                                }
                                return listListOf;
                            }
                        } else {
                            Camera2Logger camera2Logger13 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Awaiting 3A convergence");
                            }
                            Function1<FrameInfo, Boolean> function1 = new Function1<FrameInfo, Boolean>() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$torchApplyCapture$3$8
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(FrameInfo it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    return Boolean.valueOf(ConvergenceUtils.is3AConverged(this.this$0.toCameraCaptureResult(it.getMetadata()), true));
                                }
                            };
                            c022812.L$0 = capturePipelineImpl;
                            c022812.L$1 = list3;
                            c022812.L$2 = mainCaptureParams2;
                            c022812.I$0 = i7;
                            c022812.Z$0 = z4;
                            c022812.I$1 = i5;
                            c022812.I$2 = i6;
                            c022812.label = 6;
                            if (waitForResult(j2, function1, c022812) != coroutine_suspended) {
                                i4 = i6;
                                z5 = z4;
                                i9 = i5;
                                mainCaptureParams3 = mainCaptureParams2;
                                i8 = i7;
                                list4 = list3;
                                capturePipelineImpl2 = capturePipelineImpl;
                                Camera2Logger camera2Logger14 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: 3A convergence waiting done");
                                }
                                i2 = i9;
                                capturePipelineImpl = capturePipelineImpl2;
                                list2 = list4;
                                mainCaptureParams2 = mainCaptureParams3;
                                Camera2Logger camera2Logger8222 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                }
                                i3 = i8;
                                z3 = z5;
                                if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                                }
                                if (list2.contains(PipelineTask.POST_CAPTURE)) {
                                }
                                return listListOf;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                int i15 = c022812.I$2;
                int i16 = c022812.I$1;
                z4 = c022812.Z$0;
                long j6 = c022812.J$0;
                i7 = c022812.I$0;
                MainCaptureParams mainCaptureParams7 = (MainCaptureParams) c022812.L$2;
                list3 = (List) c022812.L$1;
                capturePipelineImpl = (CapturePipelineImpl) c022812.L$0;
                ResultKt.throwOnFailure(objAwait);
                i6 = i15;
                j3 = j6;
                i5 = i16;
                mainCaptureParams2 = mainCaptureParams7;
                j2 = j3;
                Camera2Logger camera2Logger52 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                }
                if (z4) {
                }
                return coroutine_suspended;
            case 2:
                i4 = c022812.I$2;
                i10 = c022812.I$1;
                z4 = c022812.Z$0;
                long j7 = c022812.J$0;
                i7 = c022812.I$0;
                MainCaptureParams mainCaptureParams8 = (MainCaptureParams) c022812.L$2;
                list3 = (List) c022812.L$1;
                capturePipelineImpl = (CapturePipelineImpl) c022812.L$0;
                ResultKt.throwOnFailure(objAwait);
                j4 = j7;
                mainCaptureParams4 = mainCaptureParams8;
                i11 = i7;
                long j52 = j4;
                list5 = list3;
                capturePipelineImpl3 = capturePipelineImpl;
                autoCloseable = (AutoCloseable) objAwait;
                CameraGraph.Session session2 = (CameraGraph.Session) autoCloseable;
                if (i11 != 0) {
                }
                if (i11 != 0) {
                }
                c022812.L$0 = capturePipelineImpl3;
                c022812.L$1 = list5;
                c022812.L$2 = mainCaptureParams4;
                c022812.L$3 = autoCloseable;
                c022812.I$0 = i11;
                c022812.Z$0 = z4;
                c022812.I$1 = i10;
                c022812.I$2 = i4;
                c022812.label = 3;
                boolean z92 = z4;
                MainCaptureParams mainCaptureParams62 = mainCaptureParams4;
                z2 = true;
                objLock3AForCapture$default = CameraGraph.Session.lock3AForCapture$default(session2, z7, z8, 0, j52, c022812, 4, null);
                if (objLock3AForCapture$default != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 3:
                i4 = c022812.I$2;
                i10 = c022812.I$1;
                z6 = c022812.Z$0;
                i12 = c022812.I$0;
                autoCloseable3 = (AutoCloseable) c022812.L$3;
                mainCaptureParams5 = (MainCaptureParams) c022812.L$2;
                list6 = (List) c022812.L$1;
                capturePipelineImpl4 = (CapturePipelineImpl) c022812.L$0;
                try {
                    ResultKt.throwOnFailure(objAwait);
                    z2 = true;
                    c022812.L$0 = capturePipelineImpl4;
                    c022812.L$1 = list6;
                    c022812.L$2 = mainCaptureParams5;
                    c022812.L$3 = autoCloseable3;
                    c022812.I$0 = i12;
                    c022812.Z$0 = z6;
                    c022812.I$1 = i10;
                    c022812.I$2 = i4;
                    c022812.label = 4;
                    objAwait = ((Deferred) objAwait).await(c022812);
                    if (objAwait != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (Throwable th4) {
                    th = th4;
                    autoCloseable2 = autoCloseable3;
                    throw th;
                }
            case 4:
                i4 = c022812.I$2;
                i10 = c022812.I$1;
                z5 = c022812.Z$0;
                i8 = c022812.I$0;
                autoCloseable2 = (AutoCloseable) c022812.L$3;
                mainCaptureParams2 = (MainCaptureParams) c022812.L$2;
                list2 = (List) c022812.L$1;
                capturePipelineImpl5 = (CapturePipelineImpl) c022812.L$0;
                try {
                    ResultKt.throwOnFailure(objAwait);
                    z2 = true;
                    Result3A result3A2 = (Result3A) objAwait;
                    AutoCloseableKt.closeFinally(autoCloseable2, null);
                    Camera2Logger camera2Logger72 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                    }
                    i2 = i10;
                    capturePipelineImpl = capturePipelineImpl5;
                    Camera2Logger camera2Logger82222 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                    }
                    i3 = i8;
                    z3 = z5;
                    if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                    }
                    if (list2.contains(PipelineTask.POST_CAPTURE)) {
                    }
                    return listListOf;
                } catch (Throwable th5) {
                    th = th5;
                    throw th;
                }
            case 5:
                i4 = c022812.I$2;
                i9 = c022812.I$1;
                z5 = c022812.Z$0;
                i8 = c022812.I$0;
                mainCaptureParams3 = (MainCaptureParams) c022812.L$2;
                list4 = (List) c022812.L$1;
                capturePipelineImpl2 = (CapturePipelineImpl) c022812.L$0;
                ResultKt.throwOnFailure(objAwait);
                z2 = true;
                Camera2Logger camera2Logger122 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                }
                i2 = i9;
                capturePipelineImpl = capturePipelineImpl2;
                list2 = list4;
                mainCaptureParams2 = mainCaptureParams3;
                Camera2Logger camera2Logger822222 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                }
                i3 = i8;
                z3 = z5;
                if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                }
                if (list2.contains(PipelineTask.POST_CAPTURE)) {
                }
                return listListOf;
            case 6:
                i4 = c022812.I$2;
                i9 = c022812.I$1;
                z5 = c022812.Z$0;
                i8 = c022812.I$0;
                mainCaptureParams3 = (MainCaptureParams) c022812.L$2;
                list4 = (List) c022812.L$1;
                capturePipelineImpl2 = (CapturePipelineImpl) c022812.L$0;
                ResultKt.throwOnFailure(objAwait);
                z2 = true;
                Camera2Logger camera2Logger142 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                }
                i2 = i9;
                capturePipelineImpl = capturePipelineImpl2;
                list2 = list4;
                mainCaptureParams2 = mainCaptureParams3;
                Camera2Logger camera2Logger8222222 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                }
                i3 = i8;
                z3 = z5;
                if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                }
                if (list2.contains(PipelineTask.POST_CAPTURE)) {
                }
                return listListOf;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object torchAsFlashCapture(MainCaptureParams mainCaptureParams, int i, int i2, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) throws Exception {
        C02291 c02291;
        List<? extends PipelineTask> list2;
        Object objDefaultNoFlashCapture;
        if (continuation instanceof C02291) {
            c02291 = (C02291) continuation;
            if ((c02291.label & Integer.MIN_VALUE) != 0) {
                c02291.label -= Integer.MIN_VALUE;
            } else {
                c02291 = new C02291(continuation);
            }
        }
        C02291 c022912 = c02291;
        Object objIsPhysicalFlashRequired = c022912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c022912.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchAsFlashCapture");
            }
            if (getHasFlashUnit()) {
                c022912.L$0 = mainCaptureParams;
                c022912.L$1 = list;
                c022912.I$0 = i;
                c022912.label = 1;
                objIsPhysicalFlashRequired = isPhysicalFlashRequired(i2, c022912);
                if (objIsPhysicalFlashRequired != coroutine_suspended) {
                    list2 = list;
                }
            } else {
                c022912.L$0 = null;
                c022912.L$1 = null;
                c022912.label = 3;
                objDefaultNoFlashCapture = defaultNoFlashCapture(mainCaptureParams, i, list, c022912);
                if (objDefaultNoFlashCapture == coroutine_suspended) {
                    return objDefaultNoFlashCapture;
                }
            }
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
                return objIsPhysicalFlashRequired;
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
            return objIsPhysicalFlashRequired;
        }
        int i4 = c022912.I$0;
        List<? extends PipelineTask> list3 = (List) c022912.L$1;
        MainCaptureParams mainCaptureParams2 = (MainCaptureParams) c022912.L$0;
        ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
        list2 = list3;
        i = i4;
        mainCaptureParams = mainCaptureParams2;
        if (((Boolean) objIsPhysicalFlashRequired).booleanValue()) {
            boolean z = true;
            long j = CapturePipelineKt.CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS;
            if (this.useTorchAsFlash.shouldDisableAePrecapture() || this.videoUsageControl.isInVideoUsage()) {
                z = false;
            }
            c022912.L$0 = null;
            c022912.L$1 = null;
            c022912.label = 2;
            Object obj = torchApplyCapture(mainCaptureParams, i, j, list2, z, c022912);
            return obj == coroutine_suspended ? coroutine_suspended : obj;
        }
        list = list2;
        c022912.L$0 = null;
        c022912.L$1 = null;
        c022912.label = 3;
        objDefaultNoFlashCapture = defaultNoFlashCapture(mainCaptureParams, i, list, c022912);
        if (objDefaultNoFlashCapture == coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r14v0, types: [androidx.camera.camera2.impl.CapturePipelineImpl] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.AutoCloseable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object unlockAf(long j, Continuation<? super Result3A> continuation) throws Exception {
        C02301 c02301;
        long j2;
        if (continuation instanceof C02301) {
            c02301 = (C02301) continuation;
            if ((c02301.label & Integer.MIN_VALUE) != 0) {
                c02301.label -= Integer.MIN_VALUE;
            } else {
                c02301 = new C02301(continuation);
            }
        }
        C02301 c023012 = c02301;
        Object objAcquireSession = c023012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c023012.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAcquireSession);
                CameraGraph graph = this.useCaseGraphContext.getGraph();
                j2 = j;
                c023012.J$0 = j2;
                c023012.label = 1;
                objAcquireSession = graph.acquireSession(c023012);
                if (objAcquireSession != coroutine_suspended) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objAcquireSession);
                    return objAcquireSession;
                }
                AutoCloseable autoCloseable = (AutoCloseable) c023012.L$0;
                ResultKt.throwOnFailure(objAcquireSession);
                this = autoCloseable;
                Deferred deferred = (Deferred) objAcquireSession;
                AutoCloseableKt.closeFinally(this, null);
                c023012.L$0 = null;
                c023012.label = 3;
                Object objAwait = deferred.await(c023012);
                return objAwait != coroutine_suspended ? coroutine_suspended : objAwait;
            }
            j2 = c023012.J$0;
            ResultKt.throwOnFailure(objAcquireSession);
            long j3 = j2;
            AutoCloseable autoCloseable2 = (AutoCloseable) objAcquireSession;
            Boolean boolBoxBoolean = Boxing.boxBoolean(true);
            c023012.L$0 = autoCloseable2;
            c023012.label = 2;
            objAcquireSession = CameraGraph.Session.unlock3A$default((CameraGraph.Session) autoCloseable2, null, boolBoxBoolean, null, null, 0, j3, c023012, 29, null);
            this = autoCloseable2;
            if (objAcquireSession != coroutine_suspended) {
                Deferred deferred2 = (Deferred) objAcquireSession;
                AutoCloseableKt.closeFinally(this, null);
                c023012.L$0 = null;
                c023012.label = 3;
                Object objAwait2 = deferred2.await(c023012);
                if (objAwait2 != coroutine_suspended) {
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForResult(long j, Function1<? super FrameInfo, Boolean> function1, Continuation<? super FrameInfo> continuation) {
        C02311 c02311;
        ResultListener resultListener;
        if (continuation instanceof C02311) {
            c02311 = (C02311) continuation;
            if ((c02311.label & Integer.MIN_VALUE) != 0) {
                c02311.label -= Integer.MIN_VALUE;
            } else {
                c02311 = new C02311(continuation);
            }
        }
        Object obj = c02311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02311.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ResultListener resultListener2 = new ResultListener(j, function1);
            this.requestListener.addListener(resultListener2, this.threads.getSequentialExecutor());
            BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new CapturePipelineImpl$waitForResult$resultListener$1$1(resultListener2, this, null), 3, null);
            long millis = TimeUnit.NANOSECONDS.toMillis(j);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(resultListener2, null);
            c02311.L$0 = resultListener2;
            c02311.label = 1;
            Object objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(millis, anonymousClass3, c02311);
            if (objWithTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objWithTimeoutOrNull;
            resultListener = resultListener2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            resultListener = (ResultListener) c02311.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((FrameInfo) obj) == null) {
            this.requestListener.removeListener(resultListener);
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object waitForResult$default(CapturePipelineImpl capturePipelineImpl, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(CapturePipelineImpl.waitForResult$lambda$0((FrameInfo) obj2));
                }
            };
        }
        return capturePipelineImpl.waitForResult(j, function1, continuation);
    }

    static final boolean waitForResult$lambda$0(FrameInfo frameInfo) {
        Intrinsics.checkNotNullParameter(frameInfo, "<unused var>");
        return true;
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    public Object getCameraCapturePipeline(final int i, final int i2, final int i3, Continuation<? super CameraCapturePipeline> continuation) {
        return new CameraCapturePipeline() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl.getCameraCapturePipeline.2
            @Override // androidx.camera.core.imagecapture.CameraCapturePipeline
            public ListenableFuture<Void> invokePostCapture() {
                final CoroutineScope scope = CapturePipelineImpl.this.threads.getScope();
                final CapturePipelineImpl capturePipelineImpl = CapturePipelineImpl.this;
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1

                    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: CoroutineAdapters.kt */
                    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/adapter/CoroutineAdaptersKt$future$resolver$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1$1", f = "CapturePipeline.kt", i = {}, l = {104, 111}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ int $captureMode$inlined;
                        final /* synthetic */ CallbackToFutureAdapter.Completer $completer;
                        final /* synthetic */ int $flashMode$inlined;
                        final /* synthetic */ int $flashType$inlined;
                        Object L$0;
                        int label;
                        final /* synthetic */ CapturePipelineImpl this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(CallbackToFutureAdapter.Completer completer, Continuation continuation, CapturePipelineImpl capturePipelineImpl, int i, int i2, int i3) {
                            super(2, continuation);
                            this.$completer = completer;
                            this.this$0 = capturePipelineImpl;
                            this.$captureMode$inlined = i;
                            this.$flashMode$inlined = i2;
                            this.$flashType$inlined = i3;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$completer, continuation, this.this$0, this.$captureMode$inlined, this.$flashMode$inlined, this.$flashType$inlined);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
                        
                            if (kotlinx.coroutines.AwaitKt.joinAll((java.util.Collection<? extends kotlinx.coroutines.Job>) r13, r10) == r0) goto L16;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object obj) throws Exception {
                            AnonymousClass1 anonymousClass1;
                            CallbackToFutureAdapter.Completer completer;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                CallbackToFutureAdapter.Completer completer2 = this.$completer;
                                CapturePipelineImpl capturePipelineImpl = this.this$0;
                                List listListOf = CollectionsKt.listOf(CapturePipelineImpl.PipelineTask.POST_CAPTURE);
                                int i2 = this.$captureMode$inlined;
                                int i3 = this.$flashMode$inlined;
                                int i4 = this.$flashType$inlined;
                                this.L$0 = completer2;
                                this.label = 1;
                                anonymousClass1 = this;
                                Object objInvokeCaptureTasks = capturePipelineImpl.invokeCaptureTasks(listListOf, i2, i3, i4, null, anonymousClass1);
                                if (objInvokeCaptureTasks != coroutine_suspended) {
                                    obj = objInvokeCaptureTasks;
                                    completer = completer2;
                                }
                                return coroutine_suspended;
                            }
                            if (i != 1) {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                completer = (CallbackToFutureAdapter.Completer) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                completer.set(null);
                                return Unit.INSTANCE;
                            }
                            CallbackToFutureAdapter.Completer completer3 = (CallbackToFutureAdapter.Completer) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            anonymousClass1 = this;
                            completer = completer3;
                            anonymousClass1.L$0 = completer;
                            anonymousClass1.label = 2;
                        }
                    }

                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer<T> completer) {
                        Intrinsics.checkNotNullParameter(completer, "completer");
                        return BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(completer, null, capturePipelineImpl, i4, i5, i6), 3, null);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
                return future;
            }

            @Override // androidx.camera.core.imagecapture.CameraCapturePipeline
            public ListenableFuture<Void> invokePreCapture() {
                final CoroutineScope scope = CapturePipelineImpl.this.threads.getScope();
                final CapturePipelineImpl capturePipelineImpl = CapturePipelineImpl.this;
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1

                    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: CoroutineAdapters.kt */
                    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/adapter/CoroutineAdaptersKt$future$resolver$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1$1", f = "CapturePipeline.kt", i = {}, l = {104, 111}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ int $captureMode$inlined;
                        final /* synthetic */ CallbackToFutureAdapter.Completer $completer;
                        final /* synthetic */ int $flashMode$inlined;
                        final /* synthetic */ int $flashType$inlined;
                        Object L$0;
                        int label;
                        final /* synthetic */ CapturePipelineImpl this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(CallbackToFutureAdapter.Completer completer, Continuation continuation, CapturePipelineImpl capturePipelineImpl, int i, int i2, int i3) {
                            super(2, continuation);
                            this.$completer = completer;
                            this.this$0 = capturePipelineImpl;
                            this.$captureMode$inlined = i;
                            this.$flashMode$inlined = i2;
                            this.$flashType$inlined = i3;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$completer, continuation, this.this$0, this.$captureMode$inlined, this.$flashMode$inlined, this.$flashType$inlined);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
                        
                            if (kotlinx.coroutines.AwaitKt.joinAll((java.util.Collection<? extends kotlinx.coroutines.Job>) r13, r10) == r0) goto L16;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object obj) throws Exception {
                            AnonymousClass1 anonymousClass1;
                            CallbackToFutureAdapter.Completer completer;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                CallbackToFutureAdapter.Completer completer2 = this.$completer;
                                CapturePipelineImpl capturePipelineImpl = this.this$0;
                                List listListOf = CollectionsKt.listOf(CapturePipelineImpl.PipelineTask.PRE_CAPTURE);
                                int i2 = this.$captureMode$inlined;
                                int i3 = this.$flashMode$inlined;
                                int i4 = this.$flashType$inlined;
                                this.L$0 = completer2;
                                this.label = 1;
                                anonymousClass1 = this;
                                Object objInvokeCaptureTasks = capturePipelineImpl.invokeCaptureTasks(listListOf, i2, i3, i4, null, anonymousClass1);
                                if (objInvokeCaptureTasks != coroutine_suspended) {
                                    obj = objInvokeCaptureTasks;
                                    completer = completer2;
                                }
                                return coroutine_suspended;
                            }
                            if (i != 1) {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                completer = (CallbackToFutureAdapter.Completer) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                completer.set(null);
                                return Unit.INSTANCE;
                            }
                            CallbackToFutureAdapter.Completer completer3 = (CallbackToFutureAdapter.Completer) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            anonymousClass1 = this;
                            completer = completer3;
                            anonymousClass1.L$0 = completer;
                            anonymousClass1.label = 2;
                        }
                    }

                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer<T> completer) {
                        Intrinsics.checkNotNullParameter(completer, "completer");
                        return BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(completer, null, capturePipelineImpl, i4, i5, i6), 3, null);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
                return future;
            }
        };
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    public int getTemplate() {
        return this.template;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0090 A[Catch: all -> 0x00c5, TryCatch #0 {all -> 0x00c5, blocks: (B:33:0x0085, B:35:0x0090, B:39:0x009e), top: B:55:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:14:0x0032, B:43:0x00aa, B:45:0x00b2, B:46:0x00bc), top: B:57:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeScreenFlashPostCaptureTasks(int i, Continuation<? super Unit> continuation) throws Exception {
        C02221 c02221;
        int i2;
        AutoCloseable autoCloseable;
        Throwable th;
        AutoCloseable autoCloseable2;
        CameraGraph.Session session;
        if (continuation instanceof C02221) {
            c02221 = (C02221) continuation;
            if ((c02221.label & Integer.MIN_VALUE) != 0) {
                c02221.label -= Integer.MIN_VALUE;
            } else {
                c02221 = new C02221(continuation);
            }
        }
        Object objAcquireSession = c02221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c02221.label;
        boolean z = true;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objAcquireSession);
            FlashControl flashControl = this.flashControl;
            c02221.I$0 = i;
            c02221.label = 1;
            if (flashControl.stopScreenFlashCaptureTasks(c02221) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                autoCloseable2 = (AutoCloseable) c02221.L$0;
                try {
                    ResultKt.throwOnFailure(objAcquireSession);
                    Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: Unlocking 3A done");
                    }
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(autoCloseable2, null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        AutoCloseableKt.closeFinally(autoCloseable2, th);
                        throw th3;
                    }
                }
            }
            i2 = c02221.I$0;
            ResultKt.throwOnFailure(objAcquireSession);
            autoCloseable = (AutoCloseable) objAcquireSession;
            try {
                session = (CameraGraph.Session) autoCloseable;
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: Unlocking 3A");
                }
                if (i2 == 0) {
                    z = false;
                }
                c02221.L$0 = autoCloseable;
                c02221.label = 3;
                if (session.unlock3APostCapture(z, c02221) != coroutine_suspended) {
                    autoCloseable2 = autoCloseable;
                    Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                    }
                    Unit unit2 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(autoCloseable2, null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th4) {
                th = th4;
                autoCloseable2 = autoCloseable;
                throw th;
            }
        }
        i = c02221.I$0;
        ResultKt.throwOnFailure(objAcquireSession);
        Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: Acquiring session for unlocking 3A");
        }
        CameraGraph graph = this.useCaseGraphContext.getGraph();
        c02221.I$0 = i;
        c02221.label = 2;
        objAcquireSession = graph.acquireSession(c02221);
        if (objAcquireSession != coroutine_suspended) {
            i2 = i;
            autoCloseable = (AutoCloseable) objAcquireSession;
            session = (CameraGraph.Session) autoCloseable;
            Camera2Logger camera2Logger22 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
            }
            if (i2 == 0) {
            }
            c02221.L$0 = autoCloseable;
            c02221.label = 3;
            if (session.unlock3APostCapture(z, c02221) != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c0, code lost:
    
        if (r0 != r2) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[Catch: all -> 0x00ea, TryCatch #1 {all -> 0x00ea, blocks: (B:34:0x0088, B:36:0x0093, B:37:0x009d, B:41:0x00a5), top: B:62:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.camera.camera2.impl.CapturePipelineImpl] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeScreenFlashPreCaptureTasks(int i, Continuation<? super Unit> continuation) throws Exception {
        C02231 c02231;
        Throwable th;
        ?? r15;
        int i2;
        int i3;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2;
        if (continuation instanceof C02231) {
            c02231 = (C02231) continuation;
            if ((c02231.label & Integer.MIN_VALUE) != 0) {
                c02231.label -= Integer.MIN_VALUE;
            } else {
                c02231 = new C02231(continuation);
            }
        }
        C02231 c022312 = c02231;
        Object objAcquireSession = c022312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c022312.label;
        boolean z = true;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(objAcquireSession);
                FlashControl flashControl = this.flashControl;
                i2 = i;
                c022312.I$0 = i2;
                c022312.label = 1;
                if (flashControl.startScreenFlashCaptureTasks(c022312) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i4 == 1) {
                i2 = c022312.I$0;
                ResultKt.throwOnFailure(objAcquireSession);
            } else {
                if (i4 == 2) {
                    i3 = c022312.I$0;
                    ResultKt.throwOnFailure(objAcquireSession);
                    autoCloseable = (AutoCloseable) objAcquireSession;
                    try {
                        CameraGraph.Session session = (CameraGraph.Session) autoCloseable;
                        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPreCapture: Locking 3A for capture");
                        }
                        long j = CapturePipelineKt.CHECK_3A_WITH_SCREEN_FLASH_TIMEOUT_IN_NS;
                        if (i3 == 0) {
                            z = false;
                        }
                        c022312.L$0 = autoCloseable;
                        c022312.label = 3;
                        objAcquireSession = CameraGraph.Session.lock3AForCapture$default(session, z, true, 0, j, c022312, 4, null);
                        if (objAcquireSession != coroutine_suspended) {
                            autoCloseable2 = autoCloseable;
                            c022312.L$0 = autoCloseable2;
                            c022312.label = 4;
                            objAcquireSession = ((Deferred) objAcquireSession).await(c022312);
                            this = autoCloseable2;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th2) {
                        th = th2;
                        r15 = autoCloseable;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            AutoCloseableKt.closeFinally(r15, th);
                            throw th3;
                        }
                    }
                }
                if (i4 != 3) {
                    if (i4 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AutoCloseable autoCloseable3 = (AutoCloseable) c022312.L$0;
                    ResultKt.throwOnFailure(objAcquireSession);
                    this = autoCloseable3;
                    Result3A result3A = (Result3A) objAcquireSession;
                    Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPreCapture: Locking 3A for capture done, result3A = " + result3A);
                    }
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(this, null);
                    return Unit.INSTANCE;
                }
                AutoCloseable autoCloseable4 = (AutoCloseable) c022312.L$0;
                ResultKt.throwOnFailure(objAcquireSession);
                autoCloseable2 = autoCloseable4;
                c022312.L$0 = autoCloseable2;
                c022312.label = 4;
                objAcquireSession = ((Deferred) objAcquireSession).await(c022312);
                this = autoCloseable2;
            }
            CameraGraph graph = this.useCaseGraphContext.getGraph();
            c022312.I$0 = i2;
            c022312.label = 2;
            objAcquireSession = graph.acquireSession(c022312);
            if (objAcquireSession != coroutine_suspended) {
                i3 = i2;
                autoCloseable = (AutoCloseable) objAcquireSession;
                CameraGraph.Session session2 = (CameraGraph.Session) autoCloseable;
                Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                }
                long j2 = CapturePipelineKt.CHECK_3A_WITH_SCREEN_FLASH_TIMEOUT_IN_NS;
                if (i3 == 0) {
                }
                c022312.L$0 = autoCloseable;
                c022312.label = 3;
                objAcquireSession = CameraGraph.Session.lock3AForCapture$default(session2, z, true, 0, j2, c022312, 4, null);
                if (objAcquireSession != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th4) {
            th = th4;
            r15 = this;
        }
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    public void setTemplate(int i) {
        this.template = i;
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    /* JADX INFO: renamed from: submitStillCaptures-BvXKQx0 */
    public Object mo55submitStillCapturesBvXKQx0(List<CaptureConfig> list, int i, Config config, int i2, int i3, int i4, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        return invokeCaptureTasks(CollectionsKt.listOf((Object[]) new PipelineTask[]{PipelineTask.PRE_CAPTURE, PipelineTask.MAIN_CAPTURE, PipelineTask.POST_CAPTURE}), i2, i4, i3, new MainCaptureParams(list, i, config, null), continuation);
    }
}
