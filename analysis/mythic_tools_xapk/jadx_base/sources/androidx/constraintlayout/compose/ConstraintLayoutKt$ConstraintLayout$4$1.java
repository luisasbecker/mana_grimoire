package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.media3.muxer.WebmConstants;
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

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
@DebugMetadata(c = "androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$4$1", f = "ConstraintLayout.kt", i = {}, l = {774, 784}, m = "invokeSuspend", n = {}, s = {})
public final class ConstraintLayoutKt$ConstraintLayout$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $animateChangesSpec;
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ MutableIntState $direction;
    final /* synthetic */ MutableState<ConstraintSet> $endConstraint$delegate;
    final /* synthetic */ Function0<Unit> $finishedAnimationListener;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $progress;
    final /* synthetic */ MutableState<ConstraintSet> $startConstraint$delegate;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayoutKt$ConstraintLayout$4$1(Channel<ConstraintSet> channel, MutableIntState mutableIntState, Animatable<Float, AnimationVector1D> animatable, AnimationSpec<Float> animationSpec, Function0<Unit> function0, MutableState<ConstraintSet> mutableState, MutableState<ConstraintSet> mutableState2, Continuation<? super ConstraintLayoutKt$ConstraintLayout$4$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$direction = mutableIntState;
        this.$progress = animatable;
        this.$animateChangesSpec = animationSpec;
        this.$finishedAnimationListener = function0;
        this.$startConstraint$delegate = mutableState;
        this.$endConstraint$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConstraintLayoutKt$ConstraintLayout$4$1(this.$channel, this.$direction, this.$progress, this.$animateChangesSpec, this.$finishedAnimationListener, this.$startConstraint$delegate, this.$endConstraint$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConstraintLayoutKt$ConstraintLayout$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ae, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r14.$progress, kotlin.coroutines.jvm.internal.Boxing.boxFloat(r14.$direction.getIntValue()), r14.$animateChangesSpec, null, null, r14, 12, null) == r0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ae -> B:7:0x0015). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00c8 -> B:12:0x0031). Please report as a decompilation issue!!! */
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
                if (Intrinsics.areEqual(next, this.$direction.getIntValue() == 1 ? ConstraintLayoutKt.m9441ConstraintLayout$lambda17(this.$startConstraint$delegate) : ConstraintLayoutKt.m9443ConstraintLayout$lambda20(this.$endConstraint$delegate))) {
                    it = channelIterator;
                    this.L$0 = it;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                    }
                } else {
                    if (this.$direction.getIntValue() == 1) {
                        this.$endConstraint$delegate.setValue(next);
                    } else {
                        this.$startConstraint$delegate.setValue(next);
                    }
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
