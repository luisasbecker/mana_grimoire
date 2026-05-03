package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.CameraTimestamp;
import androidx.camera.camera2.pipe.FrameNumber;
import androidx.camera.camera2.pipe.OutputStatus;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.internal.OutputResult;
import androidx.camera.camera2.pipe.media.Finalizer;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* JADX INFO: compiled from: OutputDistributor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u000278B'\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00112\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u0014¢\u0006\u0004\b/\u00100J\"\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a022\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0003J,\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a022\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0002J\b\u00106\u001a\u00020\u001fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputDistributor;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "maximumCachedOutputs", "", "outputFinalizer", "Landroidx/camera/camera2/pipe/media/Finalizer;", "outputMatcher", "Landroidx/camera/camera2/pipe/internal/OutputMatcher;", "<init>", "(ILandroidx/camera/camera2/pipe/media/Finalizer;Landroidx/camera/camera2/pipe/internal/OutputMatcher;)V", "lock", "", "closed", "", "cameraOutputSequenceNumbers", "", "newestCameraOutputNumber", "newestFrameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "J", "lastFailedFrameNumber", "lastFailedCameraOutputNumber", "startedOutputs", "", "Landroidx/camera/camera2/pipe/internal/OutputDistributor$StartedOutput;", "availableOutputs", "", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "onOutputStarted", "", "cameraFrameNumber", "cameraTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "cameraOutputNumber", "outputListener", "Landroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;", "onOutputStarted-qGubWw0", "(JJJLandroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;)V", "onOutputResult", "outputNumber", "outputResult", "onOutputResult-DvZWqE8", "(JLjava/lang/Object;)V", "onOutputFailure", "frameNumber", "onOutputFailure-Vw7M1qk", "(J)V", "removeOutputsOlderThan", "", "output", "isOutOfOrder", "cameraOutputSequence", "close", "OutputListener", "StartedOutput", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OutputDistributor<T> implements AutoCloseable {
    private final Map<Long, OutputResult<T>> availableOutputs;
    private long cameraOutputSequenceNumbers;
    private boolean closed;
    private long lastFailedCameraOutputNumber;
    private long lastFailedFrameNumber;
    private final Object lock;
    private final int maximumCachedOutputs;
    private long newestCameraOutputNumber;
    private long newestFrameNumber;
    private final Finalizer<T> outputFinalizer;
    private final OutputMatcher outputMatcher;
    private final List<StartedOutput<T>> startedOutputs;

    /* JADX INFO: compiled from: OutputDistributor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;", ExifInterface.GPS_DIRECTION_TRUE, "", "onOutputComplete", "", "cameraFrameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "cameraTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "cameraOutputSequence", "", "outputNumber", "outputResult", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "onOutputComplete-3ejhThk", "(JJJJLjava/lang/Object;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OutputListener<T> {
        /* JADX INFO: renamed from: onOutputComplete-3ejhThk */
        void mo969onOutputComplete3ejhThk(long cameraFrameNumber, long cameraTimestamp, long cameraOutputSequence, long outputNumber, Object outputResult);
    }

    /* JADX INFO: compiled from: OutputDistributor.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\b#\u0010$J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\u0010\u0010&\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b'\u0010\u0012J\u0010\u0010(\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b)\u0010\u0012J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010\rHÂ\u0003JX\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rHÆ\u0001¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u00102\u001a\u000203HÖ\u0081\u0004J\n\u00104\u001a\u000205HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputDistributor$StartedOutput;", ExifInterface.GPS_DIRECTION_TRUE, "", "isOutOfOrder", "", "cameraFrameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "cameraTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "cameraOutputSequence", "", "cameraOutputNumber", "outputListener", "Landroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;", "<init>", "(ZJJJJLandroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getCameraFrameNumber-Ugla2oM", "()J", "J", "getCameraTimestamp-LS1Wq50", "getCameraOutputSequence", "getCameraOutputNumber", "complete", "Lkotlinx/atomicfu/AtomicBoolean;", "completeWithFailure", "", "failureReason", "Landroidx/camera/camera2/pipe/OutputStatus;", "completeWithFailure-tXNfJfc", "(I)V", "completeWith", "outputNumber", "outputResult", "Landroidx/camera/camera2/pipe/internal/OutputResult;", "completeWith-DvZWqE8", "(JLjava/lang/Object;)V", "component1", "component2", "component2-Ugla2oM", "component3", "component3-LS1Wq50", "component4", "component5", "component6", "copy", "copy-HscHeSQ", "(ZJJJJLandroidx/camera/camera2/pipe/internal/OutputDistributor$OutputListener;)Landroidx/camera/camera2/pipe/internal/OutputDistributor$StartedOutput;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class StartedOutput<T> {
        private final long cameraFrameNumber;
        private final long cameraOutputNumber;
        private final long cameraOutputSequence;
        private final long cameraTimestamp;
        private final AtomicBoolean complete;
        private final boolean isOutOfOrder;
        private final OutputListener<T> outputListener;

        private StartedOutput(boolean z, long j, long j2, long j3, long j4, OutputListener<T> outputListener) {
            Intrinsics.checkNotNullParameter(outputListener, "outputListener");
            this.isOutOfOrder = z;
            this.cameraFrameNumber = j;
            this.cameraTimestamp = j2;
            this.cameraOutputSequence = j3;
            this.cameraOutputNumber = j4;
            this.outputListener = outputListener;
            this.complete = AtomicFU.atomic(false);
        }

        public /* synthetic */ StartedOutput(boolean z, long j, long j2, long j3, long j4, OutputListener outputListener, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, j, j2, j3, j4, outputListener);
        }

        private final OutputListener<T> component6() {
            return this.outputListener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-HscHeSQ$default, reason: not valid java name */
        public static /* synthetic */ StartedOutput m981copyHscHeSQ$default(StartedOutput startedOutput, boolean z, long j, long j2, long j3, long j4, OutputListener outputListener, int i, Object obj) {
            if ((i & 1) != 0) {
                z = startedOutput.isOutOfOrder;
            }
            if ((i & 2) != 0) {
                j = startedOutput.cameraFrameNumber;
            }
            if ((i & 4) != 0) {
                j2 = startedOutput.cameraTimestamp;
            }
            if ((i & 8) != 0) {
                j3 = startedOutput.cameraOutputSequence;
            }
            if ((i & 16) != 0) {
                j4 = startedOutput.cameraOutputNumber;
            }
            if ((i & 32) != 0) {
                outputListener = startedOutput.outputListener;
            }
            OutputListener outputListener2 = outputListener;
            long j5 = j4;
            long j6 = j3;
            return startedOutput.m986copyHscHeSQ(z, j, j2, j6, j5, outputListener2);
        }

        /* JADX INFO: renamed from: completeWith-DvZWqE8, reason: not valid java name */
        public final void m982completeWithDvZWqE8(long outputNumber, Object outputResult) {
            if (!this.complete.compareAndSet(false, true)) {
                throw new IllegalStateException(("Output " + this.cameraOutputSequence + " at " + ((Object) FrameNumber.m489toStringimpl(this.cameraFrameNumber)) + " for " + outputNumber + " was completed multiple times!").toString());
            }
            this.outputListener.mo969onOutputComplete3ejhThk(this.cameraFrameNumber, this.cameraTimestamp, this.cameraOutputSequence, outputNumber, outputResult);
        }

        /* JADX INFO: renamed from: completeWithFailure-tXNfJfc, reason: not valid java name */
        public final void m983completeWithFailuretXNfJfc(int failureReason) {
            OutputResult.Companion companion = OutputResult.INSTANCE;
            m982completeWithDvZWqE8(-1L, OutputResult.m991constructorimpl(OutputStatus.m531boximpl(failureReason)));
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsOutOfOrder() {
            return this.isOutOfOrder;
        }

        /* JADX INFO: renamed from: component2-Ugla2oM, reason: not valid java name and from getter */
        public final long getCameraFrameNumber() {
            return this.cameraFrameNumber;
        }

        /* JADX INFO: renamed from: component3-LS1Wq50, reason: not valid java name and from getter */
        public final long getCameraTimestamp() {
            return this.cameraTimestamp;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getCameraOutputSequence() {
            return this.cameraOutputSequence;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getCameraOutputNumber() {
            return this.cameraOutputNumber;
        }

        /* JADX INFO: renamed from: copy-HscHeSQ, reason: not valid java name */
        public final StartedOutput<T> m986copyHscHeSQ(boolean isOutOfOrder, long cameraFrameNumber, long cameraTimestamp, long cameraOutputSequence, long cameraOutputNumber, OutputListener<T> outputListener) {
            Intrinsics.checkNotNullParameter(outputListener, "outputListener");
            return new StartedOutput<>(isOutOfOrder, cameraFrameNumber, cameraTimestamp, cameraOutputSequence, cameraOutputNumber, outputListener, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartedOutput)) {
                return false;
            }
            StartedOutput startedOutput = (StartedOutput) other;
            return this.isOutOfOrder == startedOutput.isOutOfOrder && FrameNumber.m487equalsimpl0(this.cameraFrameNumber, startedOutput.cameraFrameNumber) && CameraTimestamp.m417equalsimpl0(this.cameraTimestamp, startedOutput.cameraTimestamp) && this.cameraOutputSequence == startedOutput.cameraOutputSequence && this.cameraOutputNumber == startedOutput.cameraOutputNumber && Intrinsics.areEqual(this.outputListener, startedOutput.outputListener);
        }

        /* JADX INFO: renamed from: getCameraFrameNumber-Ugla2oM, reason: not valid java name */
        public final long m987getCameraFrameNumberUgla2oM() {
            return this.cameraFrameNumber;
        }

        public final long getCameraOutputNumber() {
            return this.cameraOutputNumber;
        }

        public final long getCameraOutputSequence() {
            return this.cameraOutputSequence;
        }

        /* JADX INFO: renamed from: getCameraTimestamp-LS1Wq50, reason: not valid java name */
        public final long m988getCameraTimestampLS1Wq50() {
            return this.cameraTimestamp;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.isOutOfOrder) * 31) + FrameNumber.m488hashCodeimpl(this.cameraFrameNumber)) * 31) + CameraTimestamp.m418hashCodeimpl(this.cameraTimestamp)) * 31) + Long.hashCode(this.cameraOutputSequence)) * 31) + Long.hashCode(this.cameraOutputNumber)) * 31) + this.outputListener.hashCode();
        }

        public final boolean isOutOfOrder() {
            return this.isOutOfOrder;
        }

        public String toString() {
            return "StartedOutput(isOutOfOrder=" + this.isOutOfOrder + ", cameraFrameNumber=" + ((Object) FrameNumber.m489toStringimpl(this.cameraFrameNumber)) + ", cameraTimestamp=" + ((Object) CameraTimestamp.m419toStringimpl(this.cameraTimestamp)) + ", cameraOutputSequence=" + this.cameraOutputSequence + ", cameraOutputNumber=" + this.cameraOutputNumber + ", outputListener=" + this.outputListener + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OutputDistributor(int i, Finalizer<? super T> outputFinalizer, OutputMatcher outputMatcher) {
        Intrinsics.checkNotNullParameter(outputFinalizer, "outputFinalizer");
        Intrinsics.checkNotNullParameter(outputMatcher, "outputMatcher");
        this.maximumCachedOutputs = i;
        this.outputFinalizer = outputFinalizer;
        this.outputMatcher = outputMatcher;
        this.lock = new Object();
        this.cameraOutputSequenceNumbers = 1L;
        this.newestCameraOutputNumber = Long.MIN_VALUE;
        this.newestFrameNumber = FrameNumber.m485constructorimpl(Long.MIN_VALUE);
        this.lastFailedFrameNumber = Long.MIN_VALUE;
        this.lastFailedCameraOutputNumber = Long.MIN_VALUE;
        this.startedOutputs = new ArrayList();
        this.availableOutputs = new LinkedHashMap();
    }

    public /* synthetic */ OutputDistributor(int i, Finalizer finalizer, OutputMatcher outputMatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i, finalizer, outputMatcher);
    }

    private final List<StartedOutput<T>> removeOutputsOlderThan(StartedOutput<T> output) {
        return removeOutputsOlderThan(output.isOutOfOrder(), output.getCameraOutputSequence(), output.getCameraOutputNumber());
    }

    private final List<StartedOutput<T>> removeOutputsOlderThan(boolean isOutOfOrder, long cameraOutputSequence, long cameraOutputNumber) {
        List<StartedOutput<T>> list = this.startedOutputs;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            StartedOutput startedOutput = (StartedOutput) t;
            if (startedOutput.isOutOfOrder() == isOutOfOrder && startedOutput.getCameraOutputSequence() < cameraOutputSequence && startedOutput.getCameraOutputNumber() < cameraOutputNumber) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        this.startedOutputs.removeAll(arrayList2);
        return arrayList2;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            List mutableList = CollectionsKt.toMutableList((Collection) this.availableOutputs.values());
            this.availableOutputs.clear();
            List mutableList2 = CollectionsKt.toMutableList((Collection) this.startedOutputs);
            this.startedOutputs.clear();
            Unit unit = Unit.INSTANCE;
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                Object result = ((OutputResult) it.next()).getResult();
                Finalizer<T> finalizer = this.outputFinalizer;
                if (!OutputResult.m994getAvailableimpl(result)) {
                    result = null;
                }
                finalizer.finalize((T) result);
            }
            Iterator it2 = mutableList2.iterator();
            while (it2.hasNext()) {
                ((StartedOutput) it2.next()).m983completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m539getERROR_OUTPUT_ABORTEDU7r42EA());
            }
        }
    }

    /* JADX INFO: renamed from: onOutputFailure-Vw7M1qk, reason: not valid java name */
    public final void m978onOutputFailureVw7M1qk(long frameNumber) {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.lastFailedFrameNumber = frameNumber;
            Iterator<T> it = this.startedOutputs.iterator();
            StartedOutput startedOutput = null;
            boolean z = false;
            StartedOutput startedOutput2 = null;
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        break;
                    }
                } else {
                    T next = it.next();
                    if (FrameNumber.m487equalsimpl0(((StartedOutput) next).m987getCameraFrameNumberUgla2oM(), frameNumber)) {
                        if (z) {
                            break;
                        }
                        z = true;
                        startedOutput2 = next;
                    }
                }
            }
            startedOutput2 = null;
            StartedOutput startedOutput3 = startedOutput2;
            if (startedOutput3 != null) {
                this.lastFailedCameraOutputNumber = startedOutput3.getCameraOutputNumber();
                this.startedOutputs.remove(startedOutput3);
                Unit unit = Unit.INSTANCE;
                startedOutput = startedOutput3;
            }
            if (startedOutput != null) {
                startedOutput.m983completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m541getERROR_OUTPUT_FAILEDU7r42EA());
            }
        }
    }

    /* JADX INFO: renamed from: onOutputResult-DvZWqE8, reason: not valid java name */
    public final void m979onOutputResultDvZWqE8(long outputNumber, Object outputResult) {
        OutputResult<T> outputResultM990boximpl;
        List<StartedOutput<T>> listRemoveOutputsOlderThan;
        T next;
        synchronized (this.lock) {
            if (this.closed || this.outputMatcher.fuzzyEqual(this.lastFailedCameraOutputNumber, outputNumber)) {
                outputResultM990boximpl = OutputResult.m990boximpl(outputResult);
            } else {
                Iterator<T> it = this.startedOutputs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = (T) null;
                        break;
                    } else {
                        next = it.next();
                        if (this.outputMatcher.fuzzyEqual(((StartedOutput) next).getCameraOutputNumber(), outputNumber)) {
                            break;
                        }
                    }
                }
                StartedOutput<T> startedOutput = next;
                if (startedOutput != null) {
                    listRemoveOutputsOlderThan = removeOutputsOlderThan(startedOutput);
                    startedOutput.m982completeWithDvZWqE8(outputNumber, outputResult);
                    this.startedOutputs.remove(startedOutput);
                    outputResultM990boximpl = null;
                } else {
                    this.availableOutputs.put(Long.valueOf(outputNumber), OutputResult.m990boximpl(outputResult));
                    if (this.availableOutputs.size() > this.maximumCachedOutputs) {
                        outputResultM990boximpl = this.availableOutputs.remove(Long.valueOf(((Number) CollectionsKt.first(this.availableOutputs.keySet())).longValue()));
                    } else {
                        outputResultM990boximpl = null;
                        listRemoveOutputsOlderThan = null;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            listRemoveOutputsOlderThan = null;
            Unit unit2 = Unit.INSTANCE;
        }
        OutputResult<T> outputResult2 = outputResultM990boximpl;
        if (outputResult2 != null) {
            Object result = outputResult2.getResult();
            Object obj = OutputResult.m994getAvailableimpl(result) ? result : null;
            if (obj != null) {
                this.outputFinalizer.finalize((T) obj);
            }
        }
        if (listRemoveOutputsOlderThan != null) {
            Iterator<T> it2 = listRemoveOutputsOlderThan.iterator();
            while (it2.hasNext()) {
                ((StartedOutput) it2.next()).m983completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m542getERROR_OUTPUT_MISSINGU7r42EA());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a5  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: onOutputStarted-qGubWw0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m980onOutputStartedqGubWw0(long cameraFrameNumber, long cameraTimestamp, long cameraOutputNumber, OutputListener<T> outputListener) {
        T next;
        boolean z;
        OutputDistributor<T> outputDistributor;
        T next2;
        T t;
        Long l;
        List<StartedOutput<T>> listRemoveOutputsOlderThan;
        boolean z2;
        OutputResult<T> outputResultRemove;
        OutputResult outputResult;
        Object objM991constructorimpl;
        T next3;
        Intrinsics.checkNotNullParameter(outputListener, "outputListener");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            Iterator<T> it = this.startedOutputs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                } else {
                    next = it.next();
                    if (FrameNumber.m487equalsimpl0(((StartedOutput) next).m987getCameraFrameNumberUgla2oM(), cameraFrameNumber)) {
                        break;
                    }
                }
            }
            StartedOutput startedOutput = next;
            if (startedOutput != null) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "onOutputStarted was invoked multiple times with a previously started output!onOutputStarted with " + ((Object) FrameNumber.m489toStringimpl(cameraFrameNumber)) + ", " + ((Object) CameraTimestamp.m419toStringimpl(cameraTimestamp)) + ", " + cameraOutputNumber + ". Previously started output: " + startedOutput + ". Ignoring.");
                }
                return;
            }
            boolean z3 = this.closed;
            long j = this.cameraOutputSequenceNumbers;
            this.cameraOutputSequenceNumbers = 1 + j;
            if (z3 || this.lastFailedFrameNumber == cameraFrameNumber || this.lastFailedCameraOutputNumber == cameraOutputNumber) {
                z = z3;
                outputDistributor = this;
                Iterator<T> it2 = outputDistributor.availableOutputs.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = (T) null;
                        break;
                    } else {
                        next2 = it2.next();
                        if (outputDistributor.outputMatcher.fuzzyEqual(cameraOutputNumber, ((Number) next2).longValue())) {
                            break;
                        }
                    }
                }
                Long l2 = next2;
                if (l2 != null) {
                    l2.longValue();
                    t = (T) outputDistributor.availableOutputs.remove(l2);
                } else {
                    t = null;
                }
                objectRef.element = t;
                l = l2;
                listRemoveOutputsOlderThan = null;
                z2 = true;
            } else {
                boolean z4 = cameraFrameNumber < this.newestFrameNumber;
                if (!z4) {
                    this.newestFrameNumber = cameraFrameNumber;
                }
                boolean z5 = cameraOutputNumber < this.newestCameraOutputNumber;
                if (!z5) {
                    this.newestCameraOutputNumber = cameraOutputNumber;
                }
                boolean z6 = z4 || z5;
                Iterator<T> it3 = this.availableOutputs.keySet().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z = z3;
                        next3 = (T) null;
                        break;
                    } else {
                        next3 = it3.next();
                        z = z3;
                        if (this.outputMatcher.fuzzyEqual(cameraOutputNumber, ((Number) next3).longValue())) {
                            break;
                        } else {
                            z3 = z;
                        }
                    }
                }
                Long l3 = next3;
                if (l3 != null) {
                    outputResultRemove = this.availableOutputs.remove(l3);
                    listRemoveOutputsOlderThan = removeOutputsOlderThan(z6, j, cameraOutputNumber);
                    outputDistributor = this;
                    l = l3;
                    z2 = true;
                    Unit unit = Unit.INSTANCE;
                    if (listRemoveOutputsOlderThan != null) {
                        Iterator<T> it4 = listRemoveOutputsOlderThan.iterator();
                        while (it4.hasNext()) {
                            ((StartedOutput) it4.next()).m983completeWithFailuretXNfJfc(OutputStatus.INSTANCE.m542getERROR_OUTPUT_MISSINGU7r42EA());
                        }
                    }
                    outputResult = (OutputResult) objectRef.element;
                    if (outputResult != null) {
                        Object result = outputResult.getResult();
                        if (!OutputResult.m994getAvailableimpl(result)) {
                            result = null;
                        }
                        if (result != null) {
                            outputDistributor.outputFinalizer.finalize((T) result);
                        }
                    }
                    if (z2) {
                        return;
                    }
                    if (z) {
                        OutputResult.Companion companion = OutputResult.INSTANCE;
                        objM991constructorimpl = OutputResult.m991constructorimpl(OutputStatus.m531boximpl(OutputStatus.INSTANCE.m539getERROR_OUTPUT_ABORTEDU7r42EA()));
                    } else {
                        OutputResult<T> outputResult2 = outputResultRemove;
                        if (outputResult2 != null) {
                            objM991constructorimpl = outputResult2.getResult();
                        } else {
                            OutputResult.Companion companion2 = OutputResult.INSTANCE;
                            objM991constructorimpl = OutputResult.m991constructorimpl(OutputStatus.m531boximpl(OutputStatus.INSTANCE.m541getERROR_OUTPUT_FAILEDU7r42EA()));
                        }
                    }
                    outputListener.mo969onOutputComplete3ejhThk(cameraFrameNumber, cameraTimestamp, j, l != null ? l.longValue() : -1L, objM991constructorimpl);
                    return;
                }
                outputDistributor = this;
                List<StartedOutput<T>> list = outputDistributor.startedOutputs;
                StartedOutput<T> startedOutput2 = new StartedOutput<>(z6, cameraFrameNumber, cameraTimestamp, j, cameraOutputNumber, outputListener, null);
                j = j;
                list.add(startedOutput2);
                z2 = false;
                l = null;
                listRemoveOutputsOlderThan = null;
            }
            outputResultRemove = null;
            Unit unit2 = Unit.INSTANCE;
            if (listRemoveOutputsOlderThan != null) {
            }
            outputResult = (OutputResult) objectRef.element;
            if (outputResult != null) {
            }
            if (z2) {
            }
        }
    }
}
