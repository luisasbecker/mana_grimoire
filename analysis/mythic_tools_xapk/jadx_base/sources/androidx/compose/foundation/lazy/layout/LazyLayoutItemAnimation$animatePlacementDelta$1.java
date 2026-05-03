package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1", f = "LazyLayoutItemAnimation.kt", i = {0}, l = {141, 148}, m = "invokeSuspend", n = {"finalSpec"}, s = {"L$0"}, v = 1)
final class LazyLayoutItemAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutItemAnimation$animatePlacementDelta$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j, Continuation<? super LazyLayoutItemAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j;
    }

    static final Unit invokeSuspend$lambda$0(LazyLayoutItemAnimation lazyLayoutItemAnimation, long j, Animatable animatable) {
        lazyLayoutItemAnimation.m2196setPlacementDeltagyyYBs(IntOffset.m9245minusqkQi6aY(((IntOffset) animatable.getValue()).m9251unboximpl(), j));
        lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutItemAnimation$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a9, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r13.this$0.placementDeltaAnimation, androidx.compose.ui.unit.IntOffset.m9233boximpl(r3), r1, null, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1$$ExternalSyntheticLambda0(r14, r3), r13, 4, null) != r0) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SpringSpec springSpec;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            boolean zIsRunning = this.this$0.placementDeltaAnimation.isRunning();
            springSpec = this.$spec;
            if (zIsRunning) {
                springSpec = springSpec instanceof SpringSpec ? (SpringSpec) springSpec : LazyLayoutItemAnimationKt.InterruptionSpec;
            }
            if (this.this$0.placementDeltaAnimation.isRunning()) {
                final long jM9245minusqkQi6aY = IntOffset.m9245minusqkQi6aY(((IntOffset) this.this$0.placementDeltaAnimation.getValue()).m9251unboximpl(), this.$totalDelta);
                final LazyLayoutItemAnimation lazyLayoutItemAnimation = this.this$0;
                this.L$0 = null;
                this.label = 2;
            } else {
                this.L$0 = springSpec;
                this.label = 1;
                if (this.this$0.placementDeltaAnimation.snapTo(IntOffset.m9233boximpl(this.$totalDelta), this) == coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.setPlacementAnimationInProgress(false);
            this.this$0.isRunningMovingAwayAnimation = false;
            return Unit.INSTANCE;
        }
        springSpec = (FiniteAnimationSpec) this.L$0;
        ResultKt.throwOnFailure(obj);
        this.this$0.onLayerPropertyChanged.invoke();
        final long jM9245minusqkQi6aY2 = IntOffset.m9245minusqkQi6aY(((IntOffset) this.this$0.placementDeltaAnimation.getValue()).m9251unboximpl(), this.$totalDelta);
        final LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.this$0;
        this.L$0 = null;
        this.label = 2;
    }
}
