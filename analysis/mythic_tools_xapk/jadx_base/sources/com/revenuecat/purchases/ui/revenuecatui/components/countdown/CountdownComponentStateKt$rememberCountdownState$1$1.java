package com.revenuecat.purchases.ui.revenuecatui.components.countdown;

import androidx.compose.runtime.MutableState;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: CountdownComponentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1", f = "CountdownComponentState.kt", i = {0}, l = {92}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
final class CountdownComponentStateKt$rememberCountdownState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<CountdownTime> $countdownTime$delegate;
    final /* synthetic */ MutableState<Boolean> $isCountingEnabled$delegate;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Date $targetDate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: CountdownComponentState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1", f = "CountdownComponentState.kt", i = {}, l = {Imgproc.COLOR_LBGR2Lab}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Boolean> $isCountingEnabled$delegate;
        final /* synthetic */ LifecycleOwner $lifecycleOwner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LifecycleOwner lifecycleOwner, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lifecycleOwner = lifecycleOwner;
            this.$isCountingEnabled$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$lifecycleOwner, this.$isCountingEnabled$delegate, continuation);
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
                final StateFlow<Lifecycle.State> currentStateFlow = this.$lifecycleOwner.getLifecycle().getCurrentStateFlow();
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt$rememberCountdownState$1$1$1$invokeSuspend$$inlined$map$1$2", f = "CountdownComponentState.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label -= Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                Boolean boolBoxBoolean = Boxing.boxBoolean(((Lifecycle.State) obj).isAtLeast(Lifecycle.State.STARTED));
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(boolBoxBoolean, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                        Object objCollect = currentStateFlow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                final MutableState<Boolean> mutableState = this.$isCountingEnabled$delegate;
                this.label = 1;
                if (flowDistinctUntilChanged.collect(new FlowCollector() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentStateKt.rememberCountdownState.1.1.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        CountdownComponentStateKt.rememberCountdownState$lambda$6(mutableState, z);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountdownComponentStateKt$rememberCountdownState$1$1(Date date, LifecycleOwner lifecycleOwner, MutableState<Boolean> mutableState, MutableState<CountdownTime> mutableState2, Continuation<? super CountdownComponentStateKt$rememberCountdownState$1$1> continuation) {
        super(2, continuation);
        this.$targetDate = date;
        this.$lifecycleOwner = lifecycleOwner;
        this.$isCountingEnabled$delegate = mutableState;
        this.$countdownTime$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CountdownComponentStateKt$rememberCountdownState$1$1 countdownComponentStateKt$rememberCountdownState$1$1 = new CountdownComponentStateKt$rememberCountdownState$1$1(this.$targetDate, this.$lifecycleOwner, this.$isCountingEnabled$delegate, this.$countdownTime$delegate, continuation);
        countdownComponentStateKt$rememberCountdownState$1$1.L$0 = obj;
        return countdownComponentStateKt$rememberCountdownState$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CountdownComponentStateKt$rememberCountdownState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(this.$lifecycleOwner, this.$isCountingEnabled$delegate, null), 3, null);
            coroutineScope = coroutineScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        do {
            if (JobKt.isActive(coroutineScope.getCoroutineContext())) {
                if (CountdownComponentStateKt.rememberCountdownState$lambda$5(this.$isCountingEnabled$delegate)) {
                    long time = this.$targetDate.getTime() - new Date().getTime();
                    MutableState<CountdownTime> mutableState = this.$countdownTime$delegate;
                    if (time <= 0) {
                        mutableState.setValue(CountdownTime.INSTANCE.getZERO());
                    } else {
                        mutableState.setValue(CountdownTime.INSTANCE.fromInterval(time));
                    }
                }
                Duration.Companion companion = Duration.INSTANCE;
                this.L$0 = coroutineScope;
                this.label = 1;
            }
            return Unit.INSTANCE;
        } while (DelayKt.m12943delayVtjQ1oo(DurationKt.toDuration(1, DurationUnit.SECONDS), this) != coroutine_suspended);
        return coroutine_suspended;
    }
}
