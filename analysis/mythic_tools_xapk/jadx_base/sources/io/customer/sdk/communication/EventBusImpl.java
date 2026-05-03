package io.customer.sdk.communication;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import io.customer.sdk.core.di.SDKComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: EventBus.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0016JG\u0010\u0019\u001a\u00020\r\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u0004*\u00020\u00012$\b\b\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001cH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0017H\u0016JI\u0010\u0019\u001a\u00020\r\"\b\b\u0000\u0010\u001a*\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001a0\"2\"\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001cH\u0016¢\u0006\u0002\u0010#R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"Lio/customer/sdk/communication/EventBusImpl;", "Lio/customer/sdk/communication/EventBus;", "sharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/customer/sdk/communication/Event;", "<init>", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "flow", "Lkotlinx/coroutines/flow/SharedFlow;", "getFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "jobs", "", "Lkotlinx/coroutines/Job;", "getJobs", "()Ljava/util/List;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "eventChannel", "Lkotlinx/coroutines/channels/Channel;", "publish", "", NotificationCompat.CATEGORY_EVENT, "subscribe", ExifInterface.GPS_DIRECTION_TRUE, NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lio/customer/sdk/communication/EventBus;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "removeAllSubscriptions", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventBusImpl implements EventBus {
    private final Channel<Event> eventChannel;
    private final List<Job> jobs;
    private final CoroutineScope scope;
    private final MutableSharedFlow<Event> sharedFlow;

    /* JADX INFO: renamed from: io.customer.sdk.communication.EventBusImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventBus.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.customer.sdk.communication.EventBusImpl$1", f = "EventBus.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventBusImpl.this.new AnonymousClass1(continuation);
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
                Flow flowConsumeAsFlow = FlowKt.consumeAsFlow(EventBusImpl.this.eventChannel);
                final EventBusImpl eventBusImpl = EventBusImpl.this;
                this.label = 1;
                if (flowConsumeAsFlow.collect(new FlowCollector() { // from class: io.customer.sdk.communication.EventBusImpl.1.1
                    public final Object emit(Event event, Continuation<? super Unit> continuation) {
                        eventBusImpl.sharedFlow.tryEmit(event);
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Event) obj2, (Continuation<? super Unit>) continuation);
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

    /* JADX WARN: Multi-variable type inference failed */
    public EventBusImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public EventBusImpl(MutableSharedFlow<Event> sharedFlow) {
        Intrinsics.checkNotNullParameter(sharedFlow, "sharedFlow");
        this.sharedFlow = sharedFlow;
        this.jobs = new ArrayList();
        CoroutineScope eventBusScope = SDKComponent.INSTANCE.getScopeProvider().getEventBusScope();
        this.scope = eventBusScope;
        this.eventChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(eventBusScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public /* synthetic */ EventBusImpl(MutableSharedFlow mutableSharedFlow, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SharedFlowKt.MutableSharedFlow$default(100, 0, null, 6, null) : mutableSharedFlow);
    }

    @Override // io.customer.sdk.communication.EventBus
    public SharedFlow<Event> getFlow() {
        return this.sharedFlow;
    }

    public final List<Job> getJobs() {
        return this.jobs;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // io.customer.sdk.communication.EventBus
    public void publish(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventChannel.mo12955trySendJP2dKIU(event);
    }

    @Override // io.customer.sdk.communication.EventBus
    public void removeAllSubscriptions() {
        synchronized (this.jobs) {
            Iterator<T> it = this.jobs.iterator();
            while (it.hasNext()) {
                Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
            }
            this.jobs.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final /* synthetic */ <T extends Event> Job subscribe(EventBus eventBus, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(eventBus, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return eventBus.subscribe(Reflection.getOrCreateKotlinClass(Event.class), action);
    }

    @Override // io.customer.sdk.communication.EventBus
    public <T extends Event> Job subscribe(KClass<T> type, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(action, "action");
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new EventBusImpl$subscribe$job$1(this, type, action, null), 3, null);
        synchronized (this.jobs) {
            this.jobs.add(jobLaunch$default);
        }
        return jobLaunch$default;
    }
}
