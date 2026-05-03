package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.core.app.NotificationCompat;
import androidx.media3.muxer.WebmConstants;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.internal.ServerProtocol;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: Transformable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J2\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ'\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/foundation/gestures/TransformableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/gestures/TransformableState;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "lockRotationOnZoomPan", "enabled", "<init>", "(Landroidx/compose/foundation/gestures/TransformableState;Lkotlin/jvm/functions/Function1;ZZ)V", "updatedCanPan", AppsFlyerProperties.CHANNEL, "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "onAttach", "", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputModifierMouse", "update", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TransformableNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    private Function1<? super Offset, Boolean> canPan;
    private boolean enabled;
    private boolean lockRotationOnZoomPan;
    private PointerInputModifierNode pointerInputModifierMouse;
    private ScrollConfig scrollConfig;
    private TransformableState state;
    private final Function1<Offset, Boolean> updatedCanPan = new Function1() { // from class: androidx.compose.foundation.gestures.TransformableNode$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(this.f$0.canPan.invoke((Offset) obj).booleanValue());
        }
    };
    private final Channel<TransformEvent> channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    private final SuspendingPointerInputModifierNode pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: Transformable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1", f = "Transformable.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_SuspendingPointerInputModifierNode;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransformableNode this$0;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Transformable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1", f = "Transformable.kt", i = {0, 0, 1}, l = {175, 178}, m = "invokeSuspend", n = {"$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch"}, s = {"L$0", "L$1", "L$0"}, v = 1)
            static final class C00321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;
                final /* synthetic */ TransformableNode this$0;

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Transformable.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1", f = "Transformable.kt", i = {0}, l = {WebmConstants.MkvEbmlElement.CUE_POINT}, m = "invokeSuspend", n = {"$this$transform"}, s = {"L$0"}, v = 1)
                static final class C00331 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Ref.ObjectRef<TransformEvent> $event;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;
                    final /* synthetic */ TransformableNode this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00331(Ref.ObjectRef<TransformEvent> objectRef, TransformableNode transformableNode, Continuation<? super C00331> continuation) {
                        super(2, continuation);
                        this.$event = objectRef;
                        this.this$0 = transformableNode;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00331 c00331 = new C00331(this.$event, this.this$0, continuation);
                        c00331.L$0 = obj;
                        return c00331;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
                        return ((C00331) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0061 -> B:20:0x0064). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        TransformScope transformScope;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            transformScope = (TransformScope) this.L$0;
                            if (!(this.$event.element instanceof TransformEvent.TransformStopped)) {
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Ref.ObjectRef<TransformEvent> objectRef = (Ref.ObjectRef) this.L$1;
                            transformScope = (TransformScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            T t = obj;
                            objectRef.element = t;
                            if (!(this.$event.element instanceof TransformEvent.TransformStopped)) {
                                TransformEvent transformEvent = this.$event.element;
                                TransformEvent.TransformDelta transformDelta = transformEvent instanceof TransformEvent.TransformDelta ? (TransformEvent.TransformDelta) transformEvent : null;
                                if (transformDelta != null) {
                                    transformScope.mo1666transformByd4ec7I(transformDelta.getZoomChange(), transformDelta.getPanChange(), transformDelta.getRotationChange());
                                }
                                objectRef = this.$event;
                                this.L$0 = transformScope;
                                this.L$1 = objectRef;
                                this.label = 1;
                                Object objReceive = this.this$0.channel.receive(this);
                                t = objReceive;
                                if (objReceive == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                objectRef.element = t;
                                if (!(this.$event.element instanceof TransformEvent.TransformStopped)) {
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00321(TransformableNode transformableNode, Continuation<? super C00321> continuation) {
                    super(2, continuation);
                    this.this$0 = transformableNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00321 c00321 = new C00321(this.this$0, continuation);
                    c00321.L$0 = obj;
                    return c00321;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
                
                    if (r9.this$0.state.transform(androidx.compose.foundation.MutatePriority.UserInput, new androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1.AnonymousClass1.C00321.C00331(r4, r9.this$0, null), r9) == r0) goto L23;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0088 -> B:13:0x0036). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    CoroutineScope coroutineScope;
                    T t;
                    CoroutineScope coroutineScope2;
                    Ref.ObjectRef objectRef;
                    Ref.ObjectRef objectRef2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        coroutineScope = (CoroutineScope) this.L$0;
                    } else if (i == 1) {
                        objectRef2 = (Ref.ObjectRef) this.L$2;
                        objectRef = (Ref.ObjectRef) this.L$1;
                        coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        t = obj;
                        objectRef2.element = t;
                        if (objectRef.element instanceof TransformEvent.TransformStarted) {
                            this.L$0 = coroutineScope2;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 2;
                        }
                        coroutineScope = coroutineScope2;
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (CancellationException unused) {
                        }
                        coroutineScope = coroutineScope3;
                    }
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                        objectRef2 = new Ref.ObjectRef();
                        this.L$0 = coroutineScope;
                        this.L$1 = objectRef2;
                        this.L$2 = objectRef2;
                        this.label = 1;
                        Object objReceive = this.this$0.channel.receive(this);
                        if (objReceive != coroutine_suspended) {
                            coroutineScope2 = coroutineScope;
                            t = objReceive;
                            objectRef = objectRef2;
                            objectRef2.element = t;
                            if (objectRef.element instanceof TransformEvent.TransformStarted) {
                            }
                            coroutineScope = coroutineScope2;
                            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Transformable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2", f = "Transformable.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ TransformableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(TransformableNode transformableNode, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = transformableNode;
                    this.$$this$coroutineScope = coroutineScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$$this$coroutineScope, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    try {
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                                this.label = 1;
                                if (TransformableKt.detectZoom(awaitPointerEventScope, this.this$0.lockRotationOnZoomPan, this.this$0.channel, this.this$0.updatedCanPan, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        } catch (CancellationException e) {
                            if (!CoroutineScopeKt.isActive(this.$$this$coroutineScope)) {
                                throw e;
                            }
                        }
                        return Unit.INSTANCE;
                    } finally {
                        this.this$0.channel.mo12955trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PointerInputScope pointerInputScope, TransformableNode transformableNode, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$this_SuspendingPointerInputModifierNode = pointerInputScope;
                this.this$0 = transformableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_SuspendingPointerInputModifierNode, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
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
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new C00321(this.this$0, null), 1, null);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(this.$this_SuspendingPointerInputModifierNode, new AnonymousClass2(this.this$0, coroutineScope, null), this) == coroutine_suspended) {
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

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            Object objCoroutineScope;
            return (this.this$0.enabled && (objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, this.this$0, null), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objCoroutineScope : Unit.INSTANCE;
        }
    }));

    public TransformableNode(TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        this.state = transformableState;
        this.canPan = function1;
        this.lockRotationOnZoomPan = z;
        this.enabled = z2;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.scrollConfig = AndroidScrollable_androidKt.platformScrollConfig(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
        PointerInputModifierNode pointerInputModifierNode = this.pointerInputModifierMouse;
        if (pointerInputModifierNode != null) {
            pointerInputModifierNode.onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo1452onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        final ScrollConfig scrollConfig = this.scrollConfig;
        if (this.enabled) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!PointerType.m7709equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m7714getMouseT8wyACA())) {
                    i++;
                } else if (scrollConfig != null && this.pointerInputModifierMouse == null) {
                    this.pointerInputModifierMouse = (PointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.gestures.TransformableNode$onPointerEvent$2
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objDetectZoomByCtrlMouseScroll = TransformableKt.detectZoomByCtrlMouseScroll(pointerInputScope, this.this$0.channel, scrollConfig, continuation);
                            return objDetectZoomByCtrlMouseScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectZoomByCtrlMouseScroll : Unit.INSTANCE;
                        }
                    }));
                }
            }
        }
        this.pointerInputNode.mo1452onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        PointerInputModifierNode pointerInputModifierNode = this.pointerInputModifierMouse;
        if (pointerInputModifierNode != null) {
            pointerInputModifierNode.mo1452onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        }
    }

    public final void update(TransformableState state, Function1<? super Offset, Boolean> canPan, boolean lockRotationOnZoomPan, boolean enabled) {
        this.canPan = canPan;
        if (Intrinsics.areEqual(this.state, state) && this.enabled == enabled && this.lockRotationOnZoomPan == lockRotationOnZoomPan) {
            return;
        }
        this.state = state;
        this.enabled = enabled;
        this.lockRotationOnZoomPan = lockRotationOnZoomPan;
        this.pointerInputNode.resetPointerInputHandler();
    }
}
