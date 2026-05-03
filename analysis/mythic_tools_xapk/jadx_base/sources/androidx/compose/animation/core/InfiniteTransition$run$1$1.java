package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: InfiniteTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.InfiniteTransition$run$1$1", f = "InfiniteTransition.kt", i = {0, 0, 1, 1}, l = {172, 193}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "durationScale", "$this$LaunchedEffect", "durationScale"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
final class InfiniteTransition$run$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<State<Long>> $toolingOverride;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InfiniteTransition this$0;

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: InfiniteTransition.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.InfiniteTransition$run$1$1$3", f = "InfiniteTransition.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Float, Continuation<? super Boolean>, Object> {
        /* synthetic */ float F$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.F$0 = ((Number) obj).floatValue();
            return anonymousClass3;
        }

        public final Object invoke(float f, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass3) create(Float.valueOf(f), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Float f, Continuation<? super Boolean> continuation) {
            return invoke(f.floatValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.F$0 > 0.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InfiniteTransition$run$1$1(MutableState<State<Long>> mutableState, InfiniteTransition infiniteTransition, Continuation<? super InfiniteTransition$run$1$1> continuation) {
        super(2, continuation);
        this.$toolingOverride = mutableState;
        this.this$0 = infiniteTransition;
    }

    static final Unit invokeSuspend$lambda$0(MutableState mutableState, InfiniteTransition infiniteTransition, Ref.FloatRef floatRef, CoroutineScope coroutineScope, long j) {
        State state = (State) mutableState.getValue();
        long jLongValue = state != null ? ((Number) state.getValue()).longValue() : j;
        if (infiniteTransition.startTimeNanos == Long.MIN_VALUE || floatRef.element != SuspendAnimationKt.getDurationScale(coroutineScope.getCoroutineContext())) {
            infiniteTransition.startTimeNanos = j;
            MutableVector mutableVector = infiniteTransition._animations;
            Object[] objArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                ((InfiniteTransition.TransitionAnimationState) objArr[i]).reset$animation_core();
            }
            floatRef.element = SuspendAnimationKt.getDurationScale(coroutineScope.getCoroutineContext());
        }
        if (floatRef.element == 0.0f) {
            MutableVector mutableVector2 = infiniteTransition._animations;
            Object[] objArr2 = mutableVector2.content;
            int size2 = mutableVector2.getSize();
            for (int i2 = 0; i2 < size2; i2++) {
                ((InfiniteTransition.TransitionAnimationState) objArr2[i2]).skipToEnd$animation_core();
            }
        } else {
            infiniteTransition.onFrame((long) ((jLongValue - infiniteTransition.startTimeNanos) / floatRef.element));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InfiniteTransition$run$1$1 infiniteTransition$run$1$1 = new InfiniteTransition$run$1$1(this.$toolingOverride, this.this$0, continuation);
        infiniteTransition$run$1$1.L$0 = obj;
        return infiniteTransition$run$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InfiniteTransition$run$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Path cross not found for [B:11:0x0040, B:16:0x0060], limit reached: 18 */
    /* JADX WARN: Path cross not found for [B:16:0x0060, B:11:0x0040], limit reached: 18 */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[PHI: r1 r8
      0x0059: PHI (r1v2 kotlin.jvm.internal.Ref$FloatRef) = (r1v3 kotlin.jvm.internal.Ref$FloatRef), (r1v5 kotlin.jvm.internal.Ref$FloatRef) binds: [B:12:0x0056, B:9:0x0023] A[DONT_GENERATE, DONT_INLINE]
      0x0059: PHI (r8v3 kotlinx.coroutines.CoroutineScope) = (r8v4 kotlinx.coroutines.CoroutineScope), (r8v5 kotlinx.coroutines.CoroutineScope) binds: [B:12:0x0056, B:9:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005e -> B:11:0x0040). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007e -> B:11:0x0040). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        final CoroutineScope coroutineScope;
        final Ref.FloatRef floatRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            floatRef = new Ref.FloatRef();
            floatRef.element = 1.0f;
        } else if (i == 1) {
            floatRef = (Ref.FloatRef) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope2;
            if (floatRef.element == 0.0f) {
                this.L$0 = coroutineScope;
                this.L$1 = floatRef;
                this.label = 2;
                if (FlowKt.first(SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.animation.core.InfiniteTransition$run$1$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(SuspendAnimationKt.getDurationScale(coroutineScope.getCoroutineContext()));
                    }
                }), new AnonymousClass3(null), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) this.L$1;
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope3;
        }
        final MutableState<State<Long>> mutableState = this.$toolingOverride;
        final InfiniteTransition infiniteTransition = this.this$0;
        this.L$0 = coroutineScope;
        this.L$1 = floatRef;
        this.label = 1;
        if (InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(new Function1() { // from class: androidx.compose.animation.core.InfiniteTransition$run$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return InfiniteTransition$run$1$1.invokeSuspend$lambda$0(mutableState, infiniteTransition, floatRef, coroutineScope, ((Long) obj2).longValue());
            }
        }, this) != coroutine_suspended) {
            if (floatRef.element == 0.0f) {
            }
            final MutableState mutableState2 = this.$toolingOverride;
            final InfiniteTransition infiniteTransition2 = this.this$0;
            this.L$0 = coroutineScope;
            this.L$1 = floatRef;
            this.label = 1;
            if (InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(new Function1() { // from class: androidx.compose.animation.core.InfiniteTransition$run$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return InfiniteTransition$run$1$1.invokeSuspend$lambda$0(mutableState2, infiniteTransition2, floatRef, coroutineScope, ((Long) obj2).longValue());
                }
            }, this) != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }
}
