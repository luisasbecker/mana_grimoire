package androidx.constraintlayout.compose;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: MotionDragHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1", f = "MotionDragHandler.kt", i = {}, l = {Videoio.CAP_PROP_OPENNI2_SYNC}, m = "invokeSuspend", n = {}, s = {})
final class MotionDragHandlerKt$motionPointerInput$2$2$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<MotionDragState> $dragChannel;
    final /* synthetic */ TransitionHandler $swipeHandler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MotionDragHandlerKt$motionPointerInput$2$2$1(TransitionHandler transitionHandler, Channel<MotionDragState> channel, Continuation<? super MotionDragHandlerKt$motionPointerInput$2$2$1> continuation) {
        super(2, continuation);
        this.$swipeHandler = transitionHandler;
        this.$dragChannel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MotionDragHandlerKt$motionPointerInput$2$2$1 motionDragHandlerKt$motionPointerInput$2$2$1 = new MotionDragHandlerKt$motionPointerInput$2$2$1(this.$swipeHandler, this.$dragChannel, continuation);
        motionDragHandlerKt$motionPointerInput$2$2$1.L$0 = obj;
        return motionDragHandlerKt$motionPointerInput$2$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((MotionDragHandlerKt$motionPointerInput$2$2$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final VelocityTracker velocityTracker = new VelocityTracker();
            final TransitionHandler transitionHandler = this.$swipeHandler;
            Function1<Offset, Boolean> function1 = new Function1<Offset, Boolean>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Offset offset) {
                    return m9514invokek4lQ0M(offset.m6090unboximpl());
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final Boolean m9514invokek4lQ0M(long j) {
                    return Boolean.valueOf(transitionHandler.m9580onAcceptFirstDownForOnSwipek4lQ0M(j));
                }
            };
            Function1<Offset, Unit> function12 = new Function1<Offset, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m9515invokek4lQ0M(offset.m6090unboximpl());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m9515invokek4lQ0M(long j) {
                    velocityTracker.resetTracking();
                }
            };
            final Channel<MotionDragState> channel = this.$dragChannel;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    channel.mo12955trySendJP2dKIU(MotionDragState.INSTANCE.m9524onDragEndTH1AsA0(velocityTracker.m7743calculateVelocity9UxMQ8M()));
                }
            };
            final Channel<MotionDragState> channel2 = this.$dragChannel;
            Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    channel2.mo12955trySendJP2dKIU(MotionDragState.INSTANCE.m9524onDragEndTH1AsA0(velocityTracker.m7743calculateVelocity9UxMQ8M()));
                }
            };
            final Channel<MotionDragState> channel3 = this.$dragChannel;
            this.label = 1;
            if (MotionDragHandlerKt.detectDragGesturesWhenNeeded(pointerInputScope, function1, function12, function0, function02, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.constraintlayout.compose.MotionDragHandlerKt$motionPointerInput$2$2$1.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                    m9516invokeUv8p0NA(pointerInputChange, offset.m6090unboximpl());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m9516invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                    VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
                    channel3.mo12955trySendJP2dKIU(MotionDragState.INSTANCE.m9523onDragk4lQ0M(j));
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
