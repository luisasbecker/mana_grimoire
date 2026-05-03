package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: LateMotionLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.LateMotionLayoutKt$LateMotionLayout$2$1", f = "LateMotionLayout.kt", i = {}, l = {Imgproc.COLOR_YUV2RGB, 98}, m = "invokeSuspend", n = {}, s = {})
final class LateMotionLayoutKt$LateMotionLayout$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animatableProgress;
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ Ref<CompositionSource> $compositionSource;
    final /* synthetic */ MutableIntState $direction;
    final /* synthetic */ MutableState<ConstraintSet> $end;
    final /* synthetic */ Function0<Unit> $finishedAnimationListener;
    final /* synthetic */ MutableState<ConstraintSet> $start;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LateMotionLayoutKt$LateMotionLayout$2$1(Channel<ConstraintSet> channel, MutableIntState mutableIntState, MutableState<ConstraintSet> mutableState, MutableState<ConstraintSet> mutableState2, Ref<CompositionSource> ref, Animatable<Float, AnimationVector1D> animatable, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Continuation<? super LateMotionLayoutKt$LateMotionLayout$2$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$direction = mutableIntState;
        this.$start = mutableState;
        this.$end = mutableState2;
        this.$compositionSource = ref;
        this.$animatableProgress = animatable;
        this.$animationSpec = animationSpec;
        this.$finishedAnimationListener = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LateMotionLayoutKt$LateMotionLayout$2$1(this.$channel, this.$direction, this.$start, this.$end, this.$compositionSource, this.$animatableProgress, this.$animationSpec, this.$finishedAnimationListener, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LateMotionLayoutKt$LateMotionLayout$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r14.$animatableProgress, kotlin.coroutines.jvm.internal.Boxing.boxFloat(r14.$direction.getIntValue()), r14.$animationSpec, null, null, r14, 12, null) == r0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b3 -> B:7:0x0015). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00cd -> B:12:0x0031). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator<ConstraintSet> it;
        ChannelIterator<ConstraintSet> channelIterator;
        Object objHasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            it = this.$channel.iterator();
            this.L$0 = it;
            this.label = 1;
            objHasNext = it.hasNext(this);
            if (objHasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            channelIterator = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            it = channelIterator;
            MutableIntState mutableIntState = this.$direction;
            mutableIntState.setIntValue(mutableIntState.getIntValue() == 1 ? 0 : 1);
            Function0<Unit> function0 = this.$finishedAnimationListener;
            if (function0 != null) {
                function0.invoke();
            }
            this.L$0 = it;
            this.label = 1;
            objHasNext = it.hasNext(this);
            if (objHasNext != coroutine_suspended) {
                channelIterator = it;
                obj = objHasNext;
                if (((Boolean) obj).booleanValue()) {
                    return Unit.INSTANCE;
                }
                ConstraintSet next = channelIterator.next();
                ConstraintSet constraintSet = (ConstraintSet) ChannelResult.m12974getOrNullimpl(this.$channel.mo12962tryReceivePtdJZtk());
                if (constraintSet != null) {
                    next = constraintSet;
                }
                if (Intrinsics.areEqual(next, (this.$direction.getIntValue() == 1 ? this.$start : this.$end).getValue())) {
                    it = channelIterator;
                    this.L$0 = it;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                    }
                } else {
                    if (this.$direction.getIntValue() == 1) {
                        this.$end.setValue(next);
                    } else {
                        this.$start.setValue(next);
                    }
                    this.$compositionSource.setValue(CompositionSource.Content);
                    this.L$0 = channelIterator;
                    this.label = 2;
                }
            }
            return coroutine_suspended;
        }
        channelIterator = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(obj);
        if (((Boolean) obj).booleanValue()) {
        }
    }
}
