package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
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
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: MotionLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$3$1", f = "MotionLayout.kt", i = {}, l = {473, Videoio.CAP_PROP_XI_CC_MATRIX_10}, m = "invokeSuspend", n = {}, s = {})
final class MotionLayoutKt$MotionLayoutCore$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $animateToEnd$delegate;
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ MutableState<ConstraintSet> $end$delegate;
    final /* synthetic */ Function0<Unit> $finishedAnimationListener;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $progress;
    final /* synthetic */ MutableState<ConstraintSet> $start$delegate;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MotionLayoutKt$MotionLayoutCore$3$1(Channel<ConstraintSet> channel, Animatable<Float, AnimationVector1D> animatable, AnimationSpec<Float> animationSpec, Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<ConstraintSet> mutableState2, MutableState<ConstraintSet> mutableState3, Continuation<? super MotionLayoutKt$MotionLayoutCore$3$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$progress = animatable;
        this.$animationSpec = animationSpec;
        this.$finishedAnimationListener = function0;
        this.$animateToEnd$delegate = mutableState;
        this.$start$delegate = mutableState2;
        this.$end$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MotionLayoutKt$MotionLayoutCore$3$1(this.$channel, this.$progress, this.$animationSpec, this.$finishedAnimationListener, this.$animateToEnd$delegate, this.$start$delegate, this.$end$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MotionLayoutKt$MotionLayoutCore$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b3, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r16.$progress, kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6), r16.$animationSpec, null, null, r16, 12, null) == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[PHI: r2 r5
      0x0043: PHI (r2v3 kotlinx.coroutines.channels.ChannelIterator<androidx.constraintlayout.compose.ConstraintSet>) = 
      (r2v4 kotlinx.coroutines.channels.ChannelIterator<androidx.constraintlayout.compose.ConstraintSet>)
      (r2v7 kotlinx.coroutines.channels.ChannelIterator<androidx.constraintlayout.compose.ConstraintSet>)
     binds: [B:12:0x003f, B:9:0x0021] A[DONT_GENERATE, DONT_INLINE]
      0x0043: PHI (r5v0 java.lang.Object) = (r5v10 java.lang.Object), (r5v13 java.lang.Object) binds: [B:12:0x003f, B:9:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0086 -> B:11:0x0034). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b3 -> B:37:0x00b6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator<ConstraintSet> it;
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
            it = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$24(this.$animateToEnd$delegate, !MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$23(r5));
            Function0<Unit> function0 = this.$finishedAnimationListener;
            if (function0 != null) {
                function0.invoke();
            }
            this.L$0 = it;
            this.label = 1;
            objHasNext = it.hasNext(this);
            if (objHasNext != coroutine_suspended) {
                if (((Boolean) objHasNext).booleanValue()) {
                    return Unit.INSTANCE;
                }
                ConstraintSet next = it.next();
                ConstraintSet constraintSet = (ConstraintSet) ChannelResult.m12974getOrNullimpl(this.$channel.mo12962tryReceivePtdJZtk());
                if (constraintSet != null) {
                    next = constraintSet;
                }
                float f = MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$23(this.$animateToEnd$delegate) ? 1.0f : 0.0f;
                if (Intrinsics.areEqual(next, MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$23(this.$animateToEnd$delegate) ? MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$14(this.$start$delegate) : MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$17(this.$end$delegate))) {
                    this.L$0 = it;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                    }
                } else {
                    if (MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$23(this.$animateToEnd$delegate)) {
                        this.$end$delegate.setValue(next);
                    } else {
                        this.$start$delegate.setValue(next);
                    }
                    this.L$0 = it;
                    this.label = 2;
                }
            }
            return coroutine_suspended;
        }
        it = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(obj);
        objHasNext = obj;
        if (((Boolean) objHasNext).booleanValue()) {
        }
    }
}
