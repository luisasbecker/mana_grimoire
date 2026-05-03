package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.DefaultButtonElevation$elevation$2$1", f = "Button.kt", i = {}, l = {Videoio.CAP_PROP_XI_BUFFERS_QUEUE_SIZE, Videoio.CAP_PROP_XI_HDR_KNEEPOINT_COUNT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DefaultButtonElevation$elevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ DefaultButtonElevation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultButtonElevation$elevation$2$1(Animatable<Dp, AnimationVector1D> animatable, float f, boolean z, DefaultButtonElevation defaultButtonElevation, Interaction interaction, Continuation<? super DefaultButtonElevation$elevation$2$1> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z;
        this.this$0 = defaultButtonElevation;
        this.$interaction = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultButtonElevation$elevation$2$1(this.$animatable, this.$target, this.$enabled, this.this$0, this.$interaction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultButtonElevation$elevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (r1.snapTo(androidx.compose.ui.unit.Dp.m9112boximpl(r6.$target), r6) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a9, code lost:
    
        if (androidx.compose.material.ElevationKt.m3034animateElevationrAjV9yQ(r6.$animatable, r6.$target, r3, r6.$interaction, r6) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Dp.m9119equalsimpl0(this.$animatable.getTargetValue().m9128unboximpl(), this.$target)) {
                boolean z = this.$enabled;
                Animatable<Dp, AnimationVector1D> animatable = this.$animatable;
                if (z) {
                    float fM9128unboximpl = animatable.getTargetValue().m9128unboximpl();
                    FocusInteraction.Focus focus = null;
                    if (Dp.m9119equalsimpl0(fM9128unboximpl, this.this$0.pressedElevation)) {
                        focus = new PressInteraction.Press(Offset.INSTANCE.m6096getZeroF1C5BW0(), null);
                    } else if (Dp.m9119equalsimpl0(fM9128unboximpl, this.this$0.hoveredElevation)) {
                        focus = new HoverInteraction.Enter();
                    } else if (Dp.m9119equalsimpl0(fM9128unboximpl, this.this$0.focusedElevation)) {
                        focus = new FocusInteraction.Focus();
                    }
                    this.label = 2;
                } else {
                    this.label = 1;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
