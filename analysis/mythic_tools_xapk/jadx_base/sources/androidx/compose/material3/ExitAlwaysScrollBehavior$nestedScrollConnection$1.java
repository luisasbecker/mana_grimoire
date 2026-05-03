package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/compose/material3/ExitAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExitAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitAlwaysScrollBehavior this$0;

    ExitAlwaysScrollBehavior$nestedScrollConnection$1(ExitAlwaysScrollBehavior exitAlwaysScrollBehavior) {
        this.this$0 = exitAlwaysScrollBehavior;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1791onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        long j3;
        if (continuation instanceof ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) {
            exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = (ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) continuation;
            if ((exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
            }
        }
        ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12 = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        Object objMo1791onPostFlingRZ2iAVY = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo1791onPostFlingRZ2iAVY);
            if (Velocity.m9353getYimpl(j2) > 0.0f && (this.this$0.getState().getHeightOffset() == 0.0f || this.this$0.getState().getHeightOffset() == this.this$0.getState().getHeightOffsetLimit())) {
                this.this$0.getState().setContentOffset(0.0f);
            }
            exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0 = j2;
            exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label = 1;
            objMo1791onPostFlingRZ2iAVY = super.mo1791onPostFlingRZ2iAVY(j, j2, exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12);
            if (objMo1791onPostFlingRZ2iAVY != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0;
            ResultKt.throwOnFailure(objMo1791onPostFlingRZ2iAVY);
            return Velocity.m9343boximpl(Velocity.m9356plusAH228Gc(j3, ((Velocity) objMo1791onPostFlingRZ2iAVY).getPackedValue()));
        }
        j2 = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0;
        ResultKt.throwOnFailure(objMo1791onPostFlingRZ2iAVY);
        long packedValue = ((Velocity) objMo1791onPostFlingRZ2iAVY).getPackedValue();
        BottomAppBarState state = this.this$0.getState();
        float fM9353getYimpl = Velocity.m9353getYimpl(j2);
        DecayAnimationSpec<Float> flingAnimationSpec = this.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> snapAnimationSpec = this.this$0.getSnapAnimationSpec();
        exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.J$0 = packedValue;
        exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12.label = 2;
        objMo1791onPostFlingRZ2iAVY = AppBarKt.settleAppBarBottom(state, fM9353getYimpl, flingAnimationSpec, snapAnimationSpec, exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$12);
        if (objMo1791onPostFlingRZ2iAVY != coroutine_suspended) {
            j3 = packedValue;
            return Velocity.m9343boximpl(Velocity.m9356plusAH228Gc(j3, ((Velocity) objMo1791onPostFlingRZ2iAVY).getPackedValue()));
        }
        return coroutine_suspended;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo1792onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m6096getZeroF1C5BW0();
        }
        BottomAppBarState state = this.this$0.getState();
        float contentOffset = state.getContentOffset();
        int i = (int) (consumed & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        state.setContentOffset(contentOffset + Float.intBitsToFloat(i));
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Float.intBitsToFloat(i));
        return Offset.INSTANCE.m6096getZeroF1C5BW0();
    }
}
