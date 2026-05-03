package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.Frame;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStatus;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.internal.FrameState;
import androidx.camera.camera2.pipe.media.OutputImage;
import androidx.camera.camera2.pipe.media.SharedOutputImage;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* JADX INFO: compiled from: FrameImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u0012H\u0004J\u0010\u0010(\u001a\u0004\u0018\u00010)H\u0096@¢\u0006\u0002\u0010*J\n\u0010+\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u00103J\u001a\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u00020\fH\u0096@¢\u0006\u0004\b5\u00100J\u0019\u00101\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b6\u00103J\u001e\u00107\u001a\b\u0012\u0004\u0012\u00020-082\u0006\u0010.\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b9\u00100J\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020-082\u0006\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010=\u001a\u00020$2\u0006\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b@\u0010?J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020EH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001cR\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006F"}, d2 = {"Landroidx/camera/camera2/pipe/internal/FrameImpl;", "Landroidx/camera/camera2/pipe/Frame;", "frameState", "Landroidx/camera/camera2/pipe/internal/FrameState;", "imageStreams", "", "Landroidx/camera/camera2/pipe/StreamId;", "<init>", "(Landroidx/camera/camera2/pipe/internal/FrameState;Ljava/util/Set;)V", "getImageStreams", "()Ljava/util/Set;", "outputStreams", "Landroidx/camera/camera2/pipe/OutputId;", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "tryAcquire", "streamFilter", "close", "", "release", "", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "getRequestMetadata", "()Landroidx/camera/camera2/pipe/RequestMetadata;", "frameId", "Landroidx/camera/camera2/pipe/FrameId;", "getFrameId-OMxQvVY", "()J", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "getFrameNumber-Ugla2oM", "frameTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "getFrameTimestamp-LS1Wq50", "frameInfoStatus", "Landroidx/camera/camera2/pipe/OutputStatus;", "getFrameInfoStatus-U7r42EA", "()I", "finalize", "awaitFrameInfo", "Landroidx/camera/camera2/pipe/FrameInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFrameInfo", "awaitImage", "Landroidx/camera/camera2/pipe/media/OutputImage;", "streamId", "awaitImage-NYG5g8E", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImage", "getImage-aKI5c8E", "(I)Landroidx/camera/camera2/pipe/media/OutputImage;", "outputId", "awaitImage-A9nWXxg", "getImage-iYJqvbA", "awaitImages", "", "awaitImages-NYG5g8E", "getImages", "getImages-aKI5c8E", "(I)Ljava/util/List;", "imageStatus", "imageStatus-Oo2lJfM", "(I)I", "imageStatus-BWjvHWQ", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/camera2/pipe/Frame$Listener;", InAppPurchaseConstants.METHOD_TO_STRING, "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameImpl implements Frame {
    private final AtomicBoolean closed;
    private final FrameState frameState;
    private final Set<StreamId> imageStreams;
    private final Set<OutputId> outputStreams;

    public FrameImpl(FrameState frameState, Set<StreamId> imageStreams) {
        Intrinsics.checkNotNullParameter(frameState, "frameState");
        Intrinsics.checkNotNullParameter(imageStreams, "imageStreams");
        this.frameState = frameState;
        this.imageStreams = imageStreams;
        List<FrameState.ImageOutput> imageOutputs = frameState.getImageOutputs();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageOutputs, 10));
        Iterator<T> it = imageOutputs.iterator();
        while (it.hasNext()) {
            arrayList.add(OutputId.m524boximpl(((FrameState.ImageOutput) it.next()).getOutputId()));
        }
        this.outputStreams = CollectionsKt.toSet(arrayList);
        this.closed = AtomicFU.atomic(false);
    }

    public /* synthetic */ FrameImpl(FrameState frameState, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            List<FrameState.ImageOutput> imageOutputs = frameState.getImageOutputs();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageOutputs, 10));
            Iterator<T> it = imageOutputs.iterator();
            while (it.hasNext()) {
                arrayList.add(StreamId.m744boximpl(((FrameState.ImageOutput) it.next()).getStreamId()));
            }
            set = CollectionsKt.toSet(arrayList);
        }
        this(frameState, set);
    }

    private final boolean release() {
        if (!this.closed.compareAndSet(false, true)) {
            return false;
        }
        this.frameState.getFrameInfoOutput().decrement();
        int size = this.frameState.getImageOutputs().size();
        for (int i = 0; i < size; i++) {
            FrameState.ImageOutput imageOutput = this.frameState.getImageOutputs().get(i);
            if (getImageStreams().contains(StreamId.m744boximpl(imageOutput.getStreamId()))) {
                imageOutput.decrement();
            }
        }
        return true;
    }

    @Override // androidx.camera.camera2.pipe.Frame
    public void addListener(Frame.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.closed.getValue()) {
            throw new IllegalStateException(("Cannot add Frame.Listener, " + this + " is closed!").toString());
        }
        this.frameState.addListener(listener);
    }

    @Override // androidx.camera.camera2.pipe.Frame
    public Object awaitFrameInfo(Continuation<? super FrameInfo> continuation) {
        if (this.closed.getValue()) {
            return null;
        }
        return this.frameState.getFrameInfoOutput().await(continuation);
    }

    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: awaitImage-A9nWXxg */
    public Object mo454awaitImageA9nWXxg(int i, Continuation<? super OutputImage> continuation) {
        Object next;
        if (this.closed.getValue() || !this.outputStreams.contains(OutputId.m524boximpl(i))) {
            return null;
        }
        Iterator<T> it = this.frameState.getImageOutputs().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (OutputId.m527equalsimpl0(((FrameState.ImageOutput) next).getOutputId(), i)) {
                break;
            }
        }
        FrameState.ImageOutput imageOutput = (FrameState.ImageOutput) next;
        if (imageOutput == null) {
            return null;
        }
        Object objAwait = imageOutput.await(continuation);
        return objAwait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwait : (SharedOutputImage) objAwait;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009a -> B:32:0x009d). Please report as a decompilation issue!!! */
    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: awaitImage-NYG5g8E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo455awaitImageNYG5g8E(int i, Continuation<? super OutputImage> continuation) {
        FrameImpl$awaitImage$1 frameImpl$awaitImage$1;
        Iterator it;
        if (continuation instanceof FrameImpl$awaitImage$1) {
            frameImpl$awaitImage$1 = (FrameImpl$awaitImage$1) continuation;
            if ((frameImpl$awaitImage$1.label & Integer.MIN_VALUE) != 0) {
                frameImpl$awaitImage$1.label -= Integer.MIN_VALUE;
            } else {
                frameImpl$awaitImage$1 = new FrameImpl$awaitImage$1(this, continuation);
            }
        }
        Object objAwait = frameImpl$awaitImage$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = frameImpl$awaitImage$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            if (this.closed.getValue() || !getImageStreams().contains(StreamId.m744boximpl(i))) {
                return null;
            }
            List<FrameState.ImageOutput> imageOutputs = this.frameState.getImageOutputs();
            ArrayList arrayList = new ArrayList();
            for (Object obj : imageOutputs) {
                if (StreamId.m747equalsimpl0(((FrameState.ImageOutput) obj).getStreamId(), i)) {
                    arrayList.add(obj);
                }
            }
            it = arrayList.iterator();
            if (it.hasNext()) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) frameImpl$awaitImage$1.L$0;
            ResultKt.throwOnFailure(objAwait);
            SharedOutputImage sharedOutputImage = (SharedOutputImage) objAwait;
            if (sharedOutputImage != null) {
                return sharedOutputImage;
            }
            if (it.hasNext()) {
                FrameState.ImageOutput imageOutput = (FrameState.ImageOutput) it.next();
                frameImpl$awaitImage$1.L$0 = it;
                frameImpl$awaitImage$1.label = 1;
                objAwait = imageOutput.await(frameImpl$awaitImage$1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                SharedOutputImage sharedOutputImage2 = (SharedOutputImage) objAwait;
                if (sharedOutputImage2 != null) {
                }
                if (it.hasNext()) {
                    return null;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b4 -> B:34:0x00b7). Please report as a decompilation issue!!! */
    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: awaitImages-NYG5g8E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo456awaitImagesNYG5g8E(int i, Continuation<? super List<? extends OutputImage>> continuation) {
        FrameImpl$awaitImages$1 frameImpl$awaitImages$1;
        Collection arrayList;
        Iterator it;
        if (continuation instanceof FrameImpl$awaitImages$1) {
            frameImpl$awaitImages$1 = (FrameImpl$awaitImages$1) continuation;
            if ((frameImpl$awaitImages$1.label & Integer.MIN_VALUE) != 0) {
                frameImpl$awaitImages$1.label -= Integer.MIN_VALUE;
            } else {
                frameImpl$awaitImages$1 = new FrameImpl$awaitImages$1(this, continuation);
            }
        }
        Object objAwait = frameImpl$awaitImages$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = frameImpl$awaitImages$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            if (!this.closed.getValue() && getImageStreams().contains(StreamId.m744boximpl(i))) {
                List<FrameState.ImageOutput> imageOutputs = this.frameState.getImageOutputs();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : imageOutputs) {
                    if (StreamId.m747equalsimpl0(((FrameState.ImageOutput) obj).getStreamId(), i)) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = new ArrayList();
                it = arrayList2.iterator();
                if (it.hasNext()) {
                }
            }
            return CollectionsKt.emptyList();
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        it = (Iterator) frameImpl$awaitImages$1.L$1;
        arrayList = (Collection) frameImpl$awaitImages$1.L$0;
        ResultKt.throwOnFailure(objAwait);
        SharedOutputImage sharedOutputImage = (SharedOutputImage) objAwait;
        if (sharedOutputImage != null) {
            arrayList.add(sharedOutputImage);
        }
        if (it.hasNext()) {
            FrameState.ImageOutput imageOutput = (FrameState.ImageOutput) it.next();
            frameImpl$awaitImages$1.L$0 = arrayList;
            frameImpl$awaitImages$1.L$1 = it;
            frameImpl$awaitImages$1.label = 1;
            objAwait = imageOutput.await(frameImpl$awaitImages$1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            SharedOutputImage sharedOutputImage2 = (SharedOutputImage) objAwait;
            if (sharedOutputImage2 != null) {
            }
            if (it.hasNext()) {
                return (List) arrayList;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        release();
    }

    protected final void finalize() {
        if (release() && Log.INSTANCE.getERROR_LOGGABLE()) {
            android.util.Log.e(Log.TAG, "Failed to close " + this + "! This indicates a memory leak and could cause the camera to stall, or images to be lost.");
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: getFrameId-OMxQvVY */
    public long mo492getFrameIdOMxQvVY() {
        return this.frameState.getFrameId();
    }

    @Override // androidx.camera.camera2.pipe.Frame
    public FrameInfo getFrameInfo() {
        if (this.closed.getValue()) {
            return null;
        }
        return this.frameState.getFrameInfoOutput().outputOrNull();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: getFrameInfoStatus-U7r42EA */
    public int mo493getFrameInfoStatusU7r42EA() {
        return this.closed.getValue() ? OutputStatus.INSTANCE.m544getUNAVAILABLEU7r42EA() : this.frameState.getFrameInfoOutput().m970getStatusU7r42EA();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: getFrameNumber-Ugla2oM */
    public long mo494getFrameNumberUgla2oM() {
        return this.frameState.getFrameNumber();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: getFrameTimestamp-LS1Wq50 */
    public long mo495getFrameTimestampLS1Wq50() {
        return this.frameState.getFrameTimestamp();
    }

    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: getImage-aKI5c8E */
    public OutputImage mo457getImageaKI5c8E(int streamId) {
        if (this.closed.getValue() || !getImageStreams().contains(StreamId.m744boximpl(streamId))) {
            return null;
        }
        List<FrameState.ImageOutput> imageOutputs = this.frameState.getImageOutputs();
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageOutputs) {
            if (StreamId.m747equalsimpl0(((FrameState.ImageOutput) obj).getStreamId(), streamId)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SharedOutputImage sharedOutputImageOutputOrNull = ((FrameState.ImageOutput) it.next()).outputOrNull();
            if (sharedOutputImageOutputOrNull != null) {
                return sharedOutputImageOutputOrNull;
            }
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: getImage-iYJqvbA */
    public OutputImage mo458getImageiYJqvbA(int outputId) {
        Object next;
        if (this.closed.getValue() || !this.outputStreams.contains(OutputId.m524boximpl(outputId))) {
            return null;
        }
        Iterator<T> it = this.frameState.getImageOutputs().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (OutputId.m527equalsimpl0(((FrameState.ImageOutput) next).getOutputId(), outputId)) {
                break;
            }
        }
        FrameState.ImageOutput imageOutput = (FrameState.ImageOutput) next;
        return imageOutput != null ? imageOutput.outputOrNull() : null;
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    public Set<StreamId> getImageStreams() {
        return this.imageStreams;
    }

    @Override // androidx.camera.camera2.pipe.Frame
    /* JADX INFO: renamed from: getImages-aKI5c8E */
    public List<OutputImage> mo459getImagesaKI5c8E(int streamId) {
        if (!this.closed.getValue() && getImageStreams().contains(StreamId.m744boximpl(streamId))) {
            List<FrameState.ImageOutput> imageOutputs = this.frameState.getImageOutputs();
            ArrayList arrayList = new ArrayList();
            for (Object obj : imageOutputs) {
                if (StreamId.m747equalsimpl0(((FrameState.ImageOutput) obj).getStreamId(), streamId)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SharedOutputImage sharedOutputImageOutputOrNull = ((FrameState.ImageOutput) it.next()).outputOrNull();
                if (sharedOutputImageOutputOrNull != null) {
                    arrayList2.add(sharedOutputImageOutputOrNull);
                }
            }
            return arrayList2;
        }
        return CollectionsKt.emptyList();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    public RequestMetadata getRequestMetadata() {
        return this.frameState.getRequestMetadata();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: imageStatus-BWjvHWQ */
    public int mo496imageStatusBWjvHWQ(int outputId) {
        Object next;
        if (this.closed.getValue() || !this.outputStreams.contains(OutputId.m524boximpl(outputId))) {
            return OutputStatus.INSTANCE.m544getUNAVAILABLEU7r42EA();
        }
        Iterator<T> it = this.frameState.getImageOutputs().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (OutputId.m527equalsimpl0(((FrameState.ImageOutput) next).getOutputId(), outputId)) {
                break;
            }
        }
        FrameState.ImageOutput imageOutput = (FrameState.ImageOutput) next;
        return imageOutput != null ? imageOutput.m970getStatusU7r42EA() : OutputStatus.INSTANCE.m544getUNAVAILABLEU7r42EA();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    /* JADX INFO: renamed from: imageStatus-Oo2lJfM */
    public int mo497imageStatusOo2lJfM(int streamId) {
        if (this.closed.getValue() || !getImageStreams().contains(StreamId.m744boximpl(streamId))) {
            return OutputStatus.INSTANCE.m544getUNAVAILABLEU7r42EA();
        }
        List<FrameState.ImageOutput> imageOutputs = this.frameState.getImageOutputs();
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageOutputs) {
            if (StreamId.m747equalsimpl0(((FrameState.ImageOutput) obj).getStreamId(), streamId)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(OutputStatus.m531boximpl(((FrameState.ImageOutput) it.next()).m970getStatusU7r42EA()));
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            throw new IllegalStateException(("No matching outputs found with " + ((Object) StreamId.m749toStringimpl(streamId)) + ". This is unexpected.").toString());
        }
        if (arrayList4.size() == 1) {
            return ((OutputStatus) arrayList4.get(0)).m537unboximpl();
        }
        ArrayList arrayList5 = arrayList4;
        boolean z = arrayList5 instanceof Collection;
        if (!z || !arrayList5.isEmpty()) {
            Iterator it2 = arrayList5.iterator();
            while (it2.hasNext()) {
                if (OutputStatus.m534equalsimpl0(((OutputStatus) it2.next()).m537unboximpl(), OutputStatus.INSTANCE.m543getPENDINGU7r42EA())) {
                    return OutputStatus.INSTANCE.m543getPENDINGU7r42EA();
                }
            }
        }
        if (!z || !arrayList5.isEmpty()) {
            Iterator it3 = arrayList5.iterator();
            while (it3.hasNext()) {
                if (OutputStatus.m534equalsimpl0(((OutputStatus) it3.next()).m537unboximpl(), OutputStatus.INSTANCE.m538getAVAILABLEU7r42EA())) {
                    return OutputStatus.INSTANCE.m538getAVAILABLEU7r42EA();
                }
            }
        }
        if (!z || !arrayList5.isEmpty()) {
            Iterator it4 = arrayList5.iterator();
            while (it4.hasNext()) {
                if (!OutputStatus.m534equalsimpl0(((OutputStatus) it4.next()).m537unboximpl(), ((OutputStatus) CollectionsKt.first((List) arrayList4)).m537unboximpl())) {
                    return OutputStatus.INSTANCE.m544getUNAVAILABLEU7r42EA();
                }
            }
        }
        return ((OutputStatus) CollectionsKt.first((List) arrayList4)).m537unboximpl();
    }

    public String toString() {
        return this.frameState.toString();
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    public /* bridge */ /* synthetic */ Frame tryAcquire(Set set) {
        return tryAcquire((Set<StreamId>) set);
    }

    @Override // androidx.camera.camera2.pipe.FrameReference
    public FrameImpl tryAcquire(Set<StreamId> streamFilter) {
        boolean z;
        if (this.closed.getValue() || !this.frameState.getFrameInfoOutput().increment()) {
            return null;
        }
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        Iterator<FrameState.ImageOutput> it = this.frameState.getImageOutputs().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            FrameState.ImageOutput next = it.next();
            int streamId = next.getStreamId();
            if (getImageStreams().contains(StreamId.m744boximpl(streamId)) && (streamFilter == null || streamFilter.contains(StreamId.m744boximpl(streamId)))) {
                if (!next.increment()) {
                    z = false;
                    break;
                }
                setCreateSetBuilder.add(StreamId.m744boximpl(streamId));
            }
        }
        Set setBuild = SetsKt.build(setCreateSetBuilder);
        if (z) {
            return new FrameImpl(this.frameState, setBuild);
        }
        this.frameState.getFrameInfoOutput().decrement();
        for (FrameState.ImageOutput imageOutput : this.frameState.getImageOutputs()) {
            if (setBuild.contains(StreamId.m744boximpl(imageOutput.getStreamId()))) {
                imageOutput.decrement();
            }
        }
        return null;
    }
}
