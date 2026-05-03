package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Scrollable2D.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$onScrollStopped$performFling$1", f = "Scrollable2D.kt", i = {0, 1, 1, 2, 2}, l = {378, 381, 384}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"}, v = 1)
final class ScrollingLogic2D$onScrollStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic2D this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic2D$onScrollStopped$performFling$1(ScrollingLogic2D scrollingLogic2D, Continuation<? super ScrollingLogic2D$onScrollStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic2D;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic2D$onScrollStopped$performFling$1 scrollingLogic2D$onScrollStopped$performFling$1 = new ScrollingLogic2D$onScrollStopped$performFling$1(this.this$0, continuation);
        scrollingLogic2D$onScrollStopped$performFling$1.J$0 = ((Velocity) obj).getPackedValue();
        return scrollingLogic2D$onScrollStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m1819invokesFctU(velocity.getPackedValue(), continuation);
    }

    /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m1819invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic2D$onScrollStopped$performFling$1) create(Velocity.m9343boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7501dispatchPreFlingQWom1Mo;
        long j;
        long jM9355minusAH228Gc;
        Object objMo1780doFlingAnimationQWom1Mo;
        Object objM7499dispatchPostFlingRZ2iAVY;
        long j2;
        long j3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j4 = this.J$0;
            this.J$0 = j4;
            this.label = 1;
            objM7501dispatchPreFlingQWom1Mo = this.this$0.nestedScrollDispatcher.m7501dispatchPreFlingQWom1Mo(j4, this);
            if (objM7501dispatchPreFlingQWom1Mo != coroutine_suspended) {
                j = j4;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = this.J$1;
                j2 = this.J$0;
                ResultKt.throwOnFailure(obj);
                objM7499dispatchPostFlingRZ2iAVY = obj;
                return Velocity.m9343boximpl(Velocity.m9355minusAH228Gc(j2, Velocity.m9355minusAH228Gc(j3, ((Velocity) objM7499dispatchPostFlingRZ2iAVY).getPackedValue())));
            }
            long j5 = this.J$1;
            long j6 = this.J$0;
            ResultKt.throwOnFailure(obj);
            jM9355minusAH228Gc = j5;
            j = j6;
            objMo1780doFlingAnimationQWom1Mo = obj;
            long packedValue = ((Velocity) objMo1780doFlingAnimationQWom1Mo).getPackedValue();
            this.J$0 = j;
            this.J$1 = packedValue;
            this.label = 3;
            objM7499dispatchPostFlingRZ2iAVY = this.this$0.nestedScrollDispatcher.m7499dispatchPostFlingRZ2iAVY(Velocity.m9355minusAH228Gc(jM9355minusAH228Gc, packedValue), packedValue, this);
            if (objM7499dispatchPostFlingRZ2iAVY != coroutine_suspended) {
                j2 = j;
                j3 = packedValue;
                return Velocity.m9343boximpl(Velocity.m9355minusAH228Gc(j2, Velocity.m9355minusAH228Gc(j3, ((Velocity) objM7499dispatchPostFlingRZ2iAVY).getPackedValue())));
            }
            return coroutine_suspended;
        }
        j = this.J$0;
        ResultKt.throwOnFailure(obj);
        objM7501dispatchPreFlingQWom1Mo = obj;
        jM9355minusAH228Gc = Velocity.m9355minusAH228Gc(j, ((Velocity) objM7501dispatchPreFlingQWom1Mo).getPackedValue());
        this.J$0 = j;
        this.J$1 = jM9355minusAH228Gc;
        this.label = 2;
        objMo1780doFlingAnimationQWom1Mo = this.this$0.mo1780doFlingAnimationQWom1Mo(jM9355minusAH228Gc, this);
        if (objMo1780doFlingAnimationQWom1Mo != coroutine_suspended) {
            long packedValue2 = ((Velocity) objMo1780doFlingAnimationQWom1Mo).getPackedValue();
            this.J$0 = j;
            this.J$1 = packedValue2;
            this.label = 3;
            objM7499dispatchPostFlingRZ2iAVY = this.this$0.nestedScrollDispatcher.m7499dispatchPostFlingRZ2iAVY(Velocity.m9355minusAH228Gc(jM9355minusAH228Gc, packedValue2), packedValue2, this);
            if (objM7499dispatchPostFlingRZ2iAVY != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }
}
