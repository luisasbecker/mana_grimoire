package androidx.camera.camera2.pipe.core;

import androidx.exifinterface.media.ExifInterface;
import com.appsflyer.AppsFlyerProperties;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: ProcessingQueue.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u0000 %*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001%BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\bH\u0082@¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/camera/camera2/pipe/core/ProcessingQueue;", ExifInterface.GPS_DIRECTION_TRUE, "", "capacity", "", "onUnprocessedElements", "Lkotlin/Function1;", "", "", "process", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getCapacity", "()I", "Lkotlin/jvm/functions/Function2;", "started", "Lkotlinx/atomicfu/AtomicBoolean;", AppsFlyerProperties.CHANNEL, "Lkotlinx/coroutines/channels/Channel;", "queue", "Lkotlin/collections/ArrayDeque;", "emit", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitChecked", "(Ljava/lang/Object;)V", "tryEmit", "", "(Ljava/lang/Object;)Z", "processingLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "releaseUnprocessedElements", "cause", "", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProcessingQueue<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int capacity;
    private final Channel<T> channel;
    private final Function1<List<? extends T>, Unit> onUnprocessedElements;
    private final Function2<List<T>, Continuation<? super Unit>, Object> process;
    private final ArrayDeque<T> queue;
    private final AtomicBoolean started;

    /* JADX INFO: compiled from: ProcessingQueue.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/core/ProcessingQueue$Companion;", "", "<init>", "()V", "processIn", "Landroidx/camera/camera2/pipe/core/ProcessingQueue;", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Lkotlinx/coroutines/CoroutineScope;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> ProcessingQueue<T> processIn(ProcessingQueue<T> processingQueue, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(processingQueue, "<this>");
            Intrinsics.checkNotNullParameter(scope, "scope");
            if (!((ProcessingQueue) processingQueue).started.compareAndSet(false, true)) {
                throw new IllegalStateException("ProcessingQueue cannot be re-started!".toString());
            }
            if (BuildersKt__Builders_commonKt.launch$default(scope, null, null, new ProcessingQueue$Companion$processIn$job$1(processingQueue, null), 3, null).isCancelled()) {
                processingQueue.releaseUnprocessedElements(null);
            }
            return processingQueue;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.ProcessingQueue$processingLoop$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProcessingQueue.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.ProcessingQueue", f = "ProcessingQueue.kt", i = {1}, l = {102, Imgproc.COLOR_YUV2RGB_YVYU}, m = "processingLoop", n = {"size"}, s = {"I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProcessingQueue<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ProcessingQueue<T> processingQueue, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = processingQueue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.processingLoop(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProcessingQueue(int i, Function1<? super List<? extends T>, Unit> onUnprocessedElements, Function2<? super List<T>, ? super Continuation<? super Unit>, ? extends Object> process) {
        Intrinsics.checkNotNullParameter(onUnprocessedElements, "onUnprocessedElements");
        Intrinsics.checkNotNullParameter(process, "process");
        this.capacity = i;
        this.onUnprocessedElements = onUnprocessedElements;
        this.process = process;
        this.started = AtomicFU.atomic(false);
        this.channel = ChannelKt.Channel$default(i, null, new Function1() { // from class: androidx.camera.camera2.pipe.core.ProcessingQueue$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProcessingQueue.channel$lambda$0(this.f$0, obj);
            }
        }, 2, null);
        this.queue = new ArrayDeque<>();
    }

    public /* synthetic */ ProcessingQueue(int i, Function1 function1, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Integer.MAX_VALUE : i, (i2 & 2) != 0 ? new Function1() { // from class: androidx.camera.camera2.pipe.core.ProcessingQueue$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProcessingQueue._init_$lambda$0((List) obj);
            }
        } : function1, function2);
    }

    static final Unit _init_$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    static final Unit channel$lambda$0(ProcessingQueue processingQueue, Object obj) {
        processingQueue.queue.add(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        if (r7.invoke(r5, r0) == r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
    
        if (r2 == r6.queue.size()) goto L22;
     */
    /* JADX WARN: Path cross not found for [B:22:0x0040, B:26:0x0050], limit reached: 41 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[Catch: all -> 0x003b, TRY_ENTER, TryCatch #0 {all -> 0x003b, blocks: (B:13:0x002b, B:36:0x0089, B:26:0x0050, B:28:0x005a, B:29:0x0060, B:32:0x0068, B:33:0x0076, B:22:0x0040, B:25:0x004b, B:17:0x0037), top: B:41:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:13:0x002b, B:36:0x0089, B:26:0x0050, B:28:0x005a, B:29:0x0060, B:32:0x0068, B:33:0x0076, B:22:0x0040, B:25:0x004b, B:17:0x0037), top: B:41:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:13:0x002b, B:36:0x0089, B:26:0x0050, B:28:0x005a, B:29:0x0060, B:32:0x0068, B:33:0x0076, B:22:0x0040, B:25:0x004b, B:17:0x0037), top: B:41:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0086 -> B:36:0x0089). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processingLoop(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objReceive;
        ArrayDeque<T> arrayDeque;
        int size;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Channel<T> channel = this.channel;
                anonymousClass1.label = 1;
                objReceive = channel.receive(anonymousClass1);
                if (objReceive == coroutine_suspended) {
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    this.queue.add((T) obj);
                    if (this.queue.isEmpty()) {
                        Object obj2 = this.channel.mo12962tryReceivePtdJZtk();
                        while (true) {
                            boolean zM12979isSuccessimpl = ChannelResult.m12979isSuccessimpl(obj2);
                            arrayDeque = this.queue;
                            if (!zM12979isSuccessimpl) {
                                break;
                            }
                            arrayDeque.add((T) ChannelResult.m12975getOrThrowimpl(obj2));
                            obj2 = this.channel.mo12962tryReceivePtdJZtk();
                        }
                        size = arrayDeque.size();
                        Function2<List<T>, Continuation<? super Unit>, Object> function2 = this.process;
                        ArrayDeque<T> arrayDeque2 = this.queue;
                        anonymousClass1.I$0 = size;
                        anonymousClass1.label = 2;
                    } else {
                        Channel<T> channel2 = this.channel;
                        anonymousClass1.label = 1;
                        objReceive = channel2.receive(anonymousClass1);
                        if (objReceive == coroutine_suspended) {
                            this.queue.add((T) objReceive);
                            if (this.queue.isEmpty()) {
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                size = anonymousClass1.I$0;
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable th) {
            releaseUnprocessedElements(th);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseUnprocessedElements(Throwable cause) {
        ArrayDeque<T> arrayDeque;
        if (this.channel.close(cause)) {
            Object obj = this.channel.mo12962tryReceivePtdJZtk();
            while (true) {
                boolean zM12979isSuccessimpl = ChannelResult.m12979isSuccessimpl(obj);
                arrayDeque = this.queue;
                if (!zM12979isSuccessimpl) {
                    break;
                }
                arrayDeque.add((T) ChannelResult.m12975getOrThrowimpl(obj));
                obj = this.channel.mo12962tryReceivePtdJZtk();
            }
            if (arrayDeque.isEmpty()) {
                return;
            }
            this.onUnprocessedElements.invoke(CollectionsKt.toMutableList((Collection) this.queue));
            this.queue.clear();
        }
    }

    public final Object emit(T t, Continuation<? super Unit> continuation) {
        Object objSend = this.channel.send(t, continuation);
        return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
    }

    public final void emitChecked(T element) {
        Object obj = this.channel.mo12955trySendJP2dKIU(element);
        if (!ChannelResult.m12979isSuccessimpl(obj)) {
            throw new IllegalStateException(("Failed to emit item to ProcessingQueue!: " + ((Object) ChannelResult.m12980toStringimpl(obj))).toString());
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final boolean tryEmit(T element) {
        return ChannelResult.m12979isSuccessimpl(this.channel.mo12955trySendJP2dKIU(element));
    }
}
