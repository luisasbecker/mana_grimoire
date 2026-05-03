package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteractionRelease$1$1", f = "Clickable.kt", i = {1}, l = {1669, 1674, 1675}, m = "invokeSuspend", n = {"release"}, s = {"L$0"}, v = 1)
final class AbstractClickableNode$handlePressInteractionRelease$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-geometry-Offset$-offset$0, reason: not valid java name */
    final /* synthetic */ long f6$$v$c$androidxcomposeuigeometryOffset$offset$0;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Job $job;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractClickableNode$handlePressInteractionRelease$1$1(Job job, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super AbstractClickableNode$handlePressInteractionRelease$1$1> continuation) {
        super(2, continuation);
        this.$job = job;
        this.f6$$v$c$androidxcomposeuigeometryOffset$offset$0 = j;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbstractClickableNode$handlePressInteractionRelease$1$1(this.$job, this.f6$$v$c$androidxcomposeuigeometryOffset$offset$0, this.$interactionSource, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteractionRelease$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        if (r7.$interactionSource.emit(r1, r7) != r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PressInteraction.Release release;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$job.join(this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            release = (PressInteraction.Release) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 3;
        }
        PressInteraction.Press press = new PressInteraction.Press(this.f6$$v$c$androidxcomposeuigeometryOffset$offset$0, null);
        release = new PressInteraction.Release(press);
        this.L$0 = release;
        this.label = 2;
        if (this.$interactionSource.emit(press, this) != coroutine_suspended) {
            this.L$0 = null;
            this.label = 3;
        }
        return coroutine_suspended;
    }
}
