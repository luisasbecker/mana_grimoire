package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.muxer.WebmConstants;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0001\u0018\u0000 N2\u00020\u0001:\u0001NB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010B\u001a\u00020\bJ\u001d\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u001a¢\u0006\u0004\bI\u0010JJ\u0006\u0010K\u001a\u00020\bJ\u0006\u0010L\u001a\u00020\bJ\u0006\u0010M\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR+\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R+\u0010#\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\"\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010 R+\u0010&\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010 R+\u0010)\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\"\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010 R\u001c\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00102\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u00106\u001a\u0004\u0018\u0001052\b\u0010\u0019\u001a\u0004\u0018\u000105@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020;0:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020=0:X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010>\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00138F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010\"\u001a\u0004\b?\u0010.\"\u0004\b@\u00100R\u001c\u0010C\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\bD\u0010.\"\u0004\bE\u00100¨\u0006O"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "onLayerPropertyChanged", "Lkotlin/Function0;", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function0;)V", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setFadeInSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "getPlacementSpec", "setPlacementSpec", "fadeOutSpec", "getFadeOutSpec", "setFadeOutSpec", "value", "", "isRunningMovingAwayAnimation", "()Z", "<set-?>", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "(Z)V", "isPlacementAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isAppearanceAnimationInProgress", "setAppearanceAnimationInProgress", "isAppearanceAnimationInProgress$delegate", "isDisappearanceAnimationInProgress", "setDisappearanceAnimationInProgress", "isDisappearanceAnimationInProgress$delegate", "isDisappearanceAnimationFinished", "setDisappearanceAnimationFinished", "isDisappearanceAnimationFinished$delegate", "rawOffset", "getRawOffset-nOcc-ac", "()J", "setRawOffset--gyyYBs", "(J)V", "J", "finalOffset", "getFinalOffset-nOcc-ac", "setFinalOffset--gyyYBs", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "visibilityAnimation", "Landroidx/compose/animation/core/AnimationVector1D;", "placementDelta", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta$delegate", "cancelPlacementAnimation", "lookaheadOffset", "getLookaheadOffset-nOcc-ac", "setLookaheadOffset--gyyYBs", "animatePlacementDelta", "delta", "isMovingAway", "animatePlacementDelta-ar5cAso", "(JZ)V", "animateAppearance", "animateDisappearance", "release", "Companion", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutItemAnimation {
    private final CoroutineScope coroutineScope;
    private FiniteAnimationSpec<Float> fadeInSpec;
    private FiniteAnimationSpec<Float> fadeOutSpec;
    private long finalOffset;
    private final GraphicsContext graphicsContext;

    /* JADX INFO: renamed from: isAppearanceAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isAppearanceAnimationInProgress;

    /* JADX INFO: renamed from: isDisappearanceAnimationFinished$delegate, reason: from kotlin metadata */
    private final MutableState isDisappearanceAnimationFinished;

    /* JADX INFO: renamed from: isDisappearanceAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isDisappearanceAnimationInProgress;

    /* JADX INFO: renamed from: isPlacementAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isPlacementAnimationInProgress;
    private boolean isRunningMovingAwayAnimation;
    private GraphicsLayer layer;
    private long lookaheadOffset;
    private final Function0<Unit> onLayerPropertyChanged;

    /* JADX INFO: renamed from: placementDelta$delegate, reason: from kotlin metadata */
    private final MutableState placementDelta;
    private final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private FiniteAnimationSpec<IntOffset> placementSpec;
    private long rawOffset;
    private final Animatable<Float, AnimationVector1D> visibilityAnimation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final long NotInitialized = IntOffset.m9236constructorimpl(9223372034707292159L);

    /* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation$Companion;", "", "<init>", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m2205getNotInitializednOccac() {
            return LazyLayoutItemAnimation.NotInitialized;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {WebmConstants.MkvEbmlElement.PREV_SIZE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LazyLayoutItemAnimation.this.visibilityAnimation.snapTo(Boxing.boxFloat(1.0f), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2", f = "LazyLayoutItemAnimation.kt", i = {}, l = {WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS, 185}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ boolean $shouldResetValue;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<Float> finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$shouldResetValue = z;
            this.this$0 = lazyLayoutItemAnimation;
            this.$spec = finiteAnimationSpec;
            this.$layer = graphicsLayer;
        }

        static final Unit invokeSuspend$lambda$0(GraphicsLayer graphicsLayer, LazyLayoutItemAnimation lazyLayoutItemAnimation, Animatable animatable) {
            graphicsLayer.setAlpha(((Number) animatable.getValue()).floatValue());
            lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$shouldResetValue, this.this$0, this.$spec, this.$layer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
        
            if (r13 == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$shouldResetValue) {
                        this.label = 1;
                        if (this.this$0.visibilityAnimation.snapTo(Boxing.boxFloat(0.0f), this) == coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.this$0.setAppearanceAnimationInProgress(false);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Animatable animatable = this.this$0.visibilityAnimation;
                Float fBoxFloat = Boxing.boxFloat(1.0f);
                FiniteAnimationSpec<Float> finiteAnimationSpec = this.$spec;
                final GraphicsLayer graphicsLayer = this.$layer;
                final LazyLayoutItemAnimation lazyLayoutItemAnimation = this.this$0;
                this.label = 2;
                obj = Animatable.animateTo$default(animatable, fBoxFloat, finiteAnimationSpec, null, new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return LazyLayoutItemAnimation.AnonymousClass2.invokeSuspend$lambda$0(graphicsLayer, lazyLayoutItemAnimation, (Animatable) obj2);
                    }
                }, this, 4, null);
            } catch (Throwable th) {
                this.this$0.setAppearanceAnimationInProgress(false);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03801(FiniteAnimationSpec<Float> finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation<? super C03801> continuation) {
            super(2, continuation);
            this.$spec = finiteAnimationSpec;
            this.$layer = graphicsLayer;
        }

        static final Unit invokeSuspend$lambda$0(GraphicsLayer graphicsLayer, LazyLayoutItemAnimation lazyLayoutItemAnimation, Animatable animatable) {
            graphicsLayer.setAlpha(((Number) animatable.getValue()).floatValue());
            lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new C03801(this.$spec, this.$layer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = LazyLayoutItemAnimation.this.visibilityAnimation;
                    Float fBoxFloat = Boxing.boxFloat(0.0f);
                    FiniteAnimationSpec<Float> finiteAnimationSpec = this.$spec;
                    final GraphicsLayer graphicsLayer = this.$layer;
                    final LazyLayoutItemAnimation lazyLayoutItemAnimation = LazyLayoutItemAnimation.this;
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fBoxFloat, finiteAnimationSpec, null, new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return LazyLayoutItemAnimation.C03801.invokeSuspend$lambda$0(graphicsLayer, lazyLayoutItemAnimation, (Animatable) obj2);
                        }
                    }, this, 4, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                LazyLayoutItemAnimation.this.setDisappearanceAnimationFinished(true);
                LazyLayoutItemAnimation.this.setDisappearanceAnimationInProgress(false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                LazyLayoutItemAnimation.this.setDisappearanceAnimationInProgress(false);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$cancelPlacementAnimation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$cancelPlacementAnimation$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03811(Continuation<? super C03811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new C03811(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LazyLayoutItemAnimation.this.placementDeltaAnimation.snapTo(IntOffset.m9233boximpl(IntOffset.INSTANCE.m9253getZeronOccac()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LazyLayoutItemAnimation.this.m2196setPlacementDeltagyyYBs(IntOffset.INSTANCE.m9253getZeronOccac());
            LazyLayoutItemAnimation.this.setPlacementAnimationInProgress(false);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03821(Continuation<? super C03821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new C03821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LazyLayoutItemAnimation.this.placementDeltaAnimation.stop(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$2", f = "LazyLayoutItemAnimation.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03832 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03832(Continuation<? super C03832> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new C03832(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03832) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LazyLayoutItemAnimation.this.visibilityAnimation.stop(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayoutItemAnimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$3", f = "LazyLayoutItemAnimation.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutItemAnimation.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LazyLayoutItemAnimation.this.visibilityAnimation.stop(this) == coroutine_suspended) {
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

    public LazyLayoutItemAnimation(CoroutineScope coroutineScope, GraphicsContext graphicsContext, Function0<Unit> function0) {
        this.coroutineScope = coroutineScope;
        this.graphicsContext = graphicsContext;
        this.onLayerPropertyChanged = function0;
        this.isPlacementAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isAppearanceAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isDisappearanceAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isDisappearanceAnimationFinished = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        long j = NotInitialized;
        this.rawOffset = j;
        this.finalOffset = IntOffset.INSTANCE.m9253getZeronOccac();
        this.layer = graphicsContext != null ? graphicsContext.createGraphicsLayer() : null;
        String str = null;
        this.placementDeltaAnimation = new Animatable<>(IntOffset.m9233boximpl(IntOffset.INSTANCE.m9253getZeronOccac()), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), null, str, 12, null);
        this.visibilityAnimation = new Animatable<>(Float.valueOf(1.0f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), str, null, 12, null);
        this.placementDelta = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m9233boximpl(IntOffset.INSTANCE.m9253getZeronOccac()), null, 2, null);
        this.lookaheadOffset = j;
    }

    public /* synthetic */ LazyLayoutItemAnimation(CoroutineScope coroutineScope, GraphicsContext graphicsContext, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i & 2) != 0 ? null : graphicsContext, (i & 4) != 0 ? new Function0() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        } : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAppearanceAnimationInProgress(boolean z) {
        this.isAppearanceAnimationInProgress.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDisappearanceAnimationFinished(boolean z) {
        this.isDisappearanceAnimationFinished.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDisappearanceAnimationInProgress(boolean z) {
        this.isDisappearanceAnimationInProgress.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPlacementAnimationInProgress(boolean z) {
        this.isPlacementAnimationInProgress.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setPlacementDelta--gyyYBs, reason: not valid java name */
    public final void m2196setPlacementDeltagyyYBs(long j) {
        this.placementDelta.setValue(IntOffset.m9233boximpl(j));
    }

    public final void animateAppearance() {
        GraphicsLayer graphicsLayer = this.layer;
        FiniteAnimationSpec<Float> finiteAnimationSpec = this.fadeInSpec;
        if (isAppearanceAnimationInProgress() || finiteAnimationSpec == null || graphicsLayer == null) {
            if (isDisappearanceAnimationInProgress()) {
                if (graphicsLayer != null) {
                    graphicsLayer.setAlpha(1.0f);
                }
                BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                return;
            }
            return;
        }
        setAppearanceAnimationInProgress(true);
        boolean zIsDisappearanceAnimationInProgress = isDisappearanceAnimationInProgress();
        boolean z = !zIsDisappearanceAnimationInProgress;
        if (!zIsDisappearanceAnimationInProgress) {
            graphicsLayer.setAlpha(0.0f);
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass2(z, this, finiteAnimationSpec, graphicsLayer, null), 3, null);
    }

    public final void animateDisappearance() {
        GraphicsLayer graphicsLayer = this.layer;
        FiniteAnimationSpec<Float> finiteAnimationSpec = this.fadeOutSpec;
        if (graphicsLayer == null || isDisappearanceAnimationInProgress() || finiteAnimationSpec == null) {
            return;
        }
        setDisappearanceAnimationInProgress(true);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03801(finiteAnimationSpec, graphicsLayer, null), 3, null);
    }

    /* JADX INFO: renamed from: animatePlacementDelta-ar5cAso, reason: not valid java name */
    public final void m2197animatePlacementDeltaar5cAso(long delta, boolean isMovingAway) {
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec = this.placementSpec;
        if (finiteAnimationSpec == null) {
            return;
        }
        long jM9245minusqkQi6aY = IntOffset.m9245minusqkQi6aY(m2200getPlacementDeltanOccac(), delta);
        m2196setPlacementDeltagyyYBs(jM9245minusqkQi6aY);
        setPlacementAnimationInProgress(true);
        this.isRunningMovingAwayAnimation = isMovingAway;
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$animatePlacementDelta$1(this, finiteAnimationSpec, jM9245minusqkQi6aY, null), 3, null);
    }

    public final void cancelPlacementAnimation() {
        if (isPlacementAnimationInProgress()) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03811(null), 3, null);
        }
    }

    public final FiniteAnimationSpec<Float> getFadeInSpec() {
        return this.fadeInSpec;
    }

    public final FiniteAnimationSpec<Float> getFadeOutSpec() {
        return this.fadeOutSpec;
    }

    /* JADX INFO: renamed from: getFinalOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getFinalOffset() {
        return this.finalOffset;
    }

    public final GraphicsLayer getLayer() {
        return this.layer;
    }

    /* JADX INFO: renamed from: getLookaheadOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getLookaheadOffset() {
        return this.lookaheadOffset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public final long m2200getPlacementDeltanOccac() {
        return ((IntOffset) this.placementDelta.getValue()).m9251unboximpl();
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    /* JADX INFO: renamed from: getRawOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getRawOffset() {
        return this.rawOffset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isAppearanceAnimationInProgress() {
        return ((Boolean) this.isAppearanceAnimationInProgress.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDisappearanceAnimationFinished() {
        return ((Boolean) this.isDisappearanceAnimationFinished.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDisappearanceAnimationInProgress() {
        return ((Boolean) this.isDisappearanceAnimationInProgress.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isPlacementAnimationInProgress() {
        return ((Boolean) this.isPlacementAnimationInProgress.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: isRunningMovingAwayAnimation, reason: from getter */
    public final boolean getIsRunningMovingAwayAnimation() {
        return this.isRunningMovingAwayAnimation;
    }

    public final void release() {
        GraphicsContext graphicsContext;
        if (isPlacementAnimationInProgress()) {
            setPlacementAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03821(null), 3, null);
        }
        if (isAppearanceAnimationInProgress()) {
            setAppearanceAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03832(null), 3, null);
        }
        if (isDisappearanceAnimationInProgress()) {
            setDisappearanceAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass3(null), 3, null);
        }
        this.isRunningMovingAwayAnimation = false;
        m2196setPlacementDeltagyyYBs(IntOffset.INSTANCE.m9253getZeronOccac());
        this.rawOffset = NotInitialized;
        GraphicsLayer graphicsLayer = this.layer;
        if (graphicsLayer != null && (graphicsContext = this.graphicsContext) != null) {
            graphicsContext.releaseGraphicsLayer(graphicsLayer);
        }
        this.layer = null;
        this.fadeInSpec = null;
        this.fadeOutSpec = null;
        this.placementSpec = null;
    }

    public final void setFadeInSpec(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.fadeInSpec = finiteAnimationSpec;
    }

    public final void setFadeOutSpec(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.fadeOutSpec = finiteAnimationSpec;
    }

    /* JADX INFO: renamed from: setFinalOffset--gyyYBs, reason: not valid java name */
    public final void m2202setFinalOffsetgyyYBs(long j) {
        this.finalOffset = j;
    }

    /* JADX INFO: renamed from: setLookaheadOffset--gyyYBs, reason: not valid java name */
    public final void m2203setLookaheadOffsetgyyYBs(long j) {
        this.lookaheadOffset = j;
    }

    public final void setPlacementSpec(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        this.placementSpec = finiteAnimationSpec;
    }

    /* JADX INFO: renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public final void m2204setRawOffsetgyyYBs(long j) {
        this.rawOffset = j;
    }
}
