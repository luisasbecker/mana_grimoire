package sovran.kotlin;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002FGB\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ+\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010!JA\u0010\"\u001a\u00020\u001b\"\u000e\b\u0000\u0010#*\b\u0012\u0004\u0012\u0002H\u001e0$\"\b\b\u0001\u0010\u001e*\u00020\u000e2\u0006\u0010%\u001a\u0002H#2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u001e0 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'JM\u0010\"\u001a\u00020\u001b\"\u0014\b\u0000\u0010#*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H)0(\"\b\b\u0001\u0010\u001e*\u00020\u000e\"\u0004\b\u0002\u0010)2\u0006\u0010%\u001a\u0002H#2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u001e0 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*J9\u0010+\u001a\u00020\u001b\"\b\b\u0000\u0010\u001e*\u00020\u000e2\u0014\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u001e0\r0-2\u0006\u0010.\u001a\u0002H\u001eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/J#\u00100\u001a\u00020\u001b\"\b\b\u0000\u0010\u001e*\u00020\u000e2\u0006\u0010.\u001a\u0002H\u001eH\u0086@ø\u0001\u0000¢\u0006\u0002\u00101J\u0006\u00102\u001a\u00020\u001bJ/\u00103\u001a\b\u0012\u0004\u0012\u00020\t0-\"\b\b\u0000\u00104*\u00020\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H40 H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!Jm\u00105\u001a\u000606j\u0002`7\"\b\b\u0000\u0010\u001e*\u00020\u000e2\u0006\u00108\u001a\u0002092\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u001e0 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=2\"\u0010>\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0@\u0012\u0006\u0012\u0004\u0018\u00010\u00010?H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ7\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0-\"\b\b\u0000\u0010\u001e*\u00020\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u001e0 H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001d\u0010C\u001a\u00020\u001b2\n\u0010D\u001a\u000606j\u0002`7H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010ER\u0016\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u00020\u00118BX\u0082\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0012\u0010\u0019\u001a\u00060\u0015j\u0002`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006H"}, d2 = {"Lsovran/kotlin/Store;", "", "()V", "sovranScope", "Lkotlinx/coroutines/CoroutineScope;", "getSovranScope", "()Lkotlinx/coroutines/CoroutineScope;", "states", "", "Lsovran/kotlin/Store$Container;", "getStates$lib", "()Ljava/util/List;", "subscriptions", "Lsovran/kotlin/Store$Subscription;", "Lsovran/kotlin/State;", "getSubscriptions$lib", "syncQueue", "Lkotlin/coroutines/CoroutineContext;", "getSyncQueue", "()Lkotlin/coroutines/CoroutineContext;", "syncQueueDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CloseableCoroutineDispatcher;", "updateQueue", "getUpdateQueue", "updateQueueDispatcher", "clean", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentState", "StateT", "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "ActionT", "Lsovran/kotlin/Action;", NativeProtocol.WEB_DIALOG_ACTION, "stateClazz", "(Lsovran/kotlin/Action;Lkotlin/reflect/KClass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsovran/kotlin/AsyncAction;", "ResultT", "(Lsovran/kotlin/AsyncAction;Lkotlin/reflect/KClass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notify", "subscribers", "", ServerProtocol.DIALOG_PARAM_STATE, "(Ljava/util/List;Lsovran/kotlin/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provide", "(Lsovran/kotlin/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "statesMatching", ExifInterface.GPS_DIRECTION_TRUE, "subscribe", "", "Lsovran/kotlin/SubscriptionID;", CustomerInfoResponseJsonKeys.SUBSCRIBER, "Lsovran/kotlin/Subscriber;", "initialState", "", "queue", "Lkotlinx/coroutines/CoroutineDispatcher;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lsovran/kotlin/Subscriber;Lkotlin/reflect/KClass;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribersForState", "unsubscribe", "subscriptionID", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", TextFieldImplKt.ContainerId, "Subscription", "lib"}, k = 1, mv = {1, 4, 3})
public final class Store {
    private final CoroutineScope sovranScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
    private final List<Container> states;
    private final List<Subscription<? extends State>> subscriptions;
    private final CoroutineContext syncQueue;
    private final ExecutorCoroutineDispatcher syncQueueDispatcher;
    private final CoroutineContext updateQueue;
    private final ExecutorCoroutineDispatcher updateQueueDispatcher;

    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lsovran/kotlin/Store$Container;", "", ServerProtocol.DIALOG_PARAM_STATE, "Lsovran/kotlin/State;", "(Lsovran/kotlin/State;)V", "getState", "()Lsovran/kotlin/State;", "setState", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "lib"}, k = 1, mv = {1, 4, 3})
    public static final /* data */ class Container {
        private State state;

        public Container(State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        public static /* synthetic */ Container copy$default(Container container, State state, int i, Object obj) {
            if ((i & 1) != 0) {
                state = container.state;
            }
            return container.copy(state);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final State getState() {
            return this.state;
        }

        public final Container copy(State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Container(state);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Container) && Intrinsics.areEqual(this.state, ((Container) other).state);
            }
            return true;
        }

        public final State getState() {
            return this.state;
        }

        public int hashCode() {
            State state = this.state;
            if (state != null) {
                return state.hashCode();
            }
            return 0;
        }

        public final void setState(State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.state = state;
        }

        public String toString() {
            return "Container(state=" + this.state + ")";
        }
    }

    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001f*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001fBJ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eR2\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lsovran/kotlin/Store$Subscription;", "StateT", "Lsovran/kotlin/State;", "", "obj", "Lsovran/kotlin/Subscriber;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/reflect/KClass;", "queue", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lsovran/kotlin/Subscriber;Lkotlin/jvm/functions/Function2;Lkotlin/reflect/KClass;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getHandler", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getKey", "()Lkotlin/reflect/KClass;", "owner", "Ljava/lang/ref/WeakReference;", "getOwner", "()Ljava/lang/ref/WeakReference;", "getQueue", "()Lkotlinx/coroutines/CoroutineDispatcher;", "subscriptionID", "", "Lsovran/kotlin/SubscriptionID;", "getSubscriptionID", "()I", "Companion", "lib"}, k = 1, mv = {1, 4, 3})
    public static final class Subscription<StateT extends State> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static int nextSubscriptionID = 1;
        private final Function2<StateT, Continuation<? super Unit>, Object> handler;
        private final KClass<StateT> key;
        private final WeakReference<Object> owner;
        private final CoroutineDispatcher queue;
        private final int subscriptionID;

        /* JADX INFO: compiled from: Store.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u00060\u0004j\u0002`\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lsovran/kotlin/Store$Subscription$Companion;", "", "()V", "nextSubscriptionID", "", "createNextSubscriptionID", "Lsovran/kotlin/SubscriptionID;", "lib"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int createNextSubscriptionID() {
                int i = Subscription.nextSubscriptionID;
                Subscription.nextSubscriptionID++;
                return i;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Subscription(Subscriber obj, Function2<? super StateT, ? super Continuation<? super Unit>, ? extends Object> handler, KClass<StateT> key, CoroutineDispatcher queue) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(queue, "queue");
            this.handler = handler;
            this.key = key;
            this.queue = queue;
            this.subscriptionID = INSTANCE.createNextSubscriptionID();
            this.owner = new WeakReference<>(obj);
        }

        public final Function2<StateT, Continuation<? super Unit>, Object> getHandler() {
            return this.handler;
        }

        public final KClass<StateT> getKey() {
            return this.key;
        }

        public final WeakReference<Object> getOwner() {
            return this.owner;
        }

        public final CoroutineDispatcher getQueue() {
            return this.queue;
        }

        public final int getSubscriptionID() {
            return this.subscriptionID;
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$clean$2, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store$clean$2", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return Store.this.new AnonymousClass2(completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CollectionsKt.removeAll((List) Store.this.getSubscriptions$lib(), (Function1) new Function1<Subscription<? extends State>, Boolean>() { // from class: sovran.kotlin.Store.clean.2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Subscription<? extends State> subscription) {
                    return Boolean.valueOf(invoke2(subscription));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(Subscription<? extends State> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getOwner().get() == null;
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$currentState$1, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007H\u0086@"}, d2 = {"currentState", "", "StateT", "Lsovran/kotlin/State;", "clazz", "Lkotlin/reflect/KClass;", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store", f = "Store.kt", i = {}, l = {188}, m = "currentState", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Store.this.currentState(null, this);
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$dispatch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@"}, d2 = {"dispatch", "", "ActionT", "Lsovran/kotlin/Action;", "StateT", "Lsovran/kotlin/State;", NativeProtocol.WEB_DIALOG_ACTION, "stateClazz", "Lkotlin/reflect/KClass;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store", f = "Store.kt", i = {0, 0, 0, 1, 1, 1, 2, 2}, l = {134, 138, 146, 147}, m = "dispatch", n = {"this", NativeProtocol.WEB_DIALOG_ACTION, "stateClazz", "this", "stateClazz", ServerProtocol.DIALOG_PARAM_STATE, "this", ServerProtocol.DIALOG_PARAM_STATE}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class C13551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13551(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Store.this.dispatch((Action) null, (KClass) null, this);
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$dispatch$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005*\u00020\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "ActionT", "Lsovran/kotlin/Action;", "StateT", "Lsovran/kotlin/State;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store$dispatch$2", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C13562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ Ref.ObjectRef $state;
        final /* synthetic */ Container $target;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13562(Ref.ObjectRef objectRef, Action action, Container container, Continuation continuation) {
            super(2, continuation);
            this.$state = objectRef;
            this.$action = action;
            this.$target = container;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new C13562(this.$state, this.$action, this.$target, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, sovran.kotlin.State] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = this.$state;
            objectRef.element = this.$action.reduce((State) objectRef.element);
            this.$target.setState((State) this.$state.element);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$dispatch$3, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\u0004\b\u0002\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086@"}, d2 = {"dispatch", "", "ActionT", "Lsovran/kotlin/AsyncAction;", "StateT", "ResultT", "Lsovran/kotlin/State;", NativeProtocol.WEB_DIALOG_ACTION, "stateClazz", "Lkotlin/reflect/KClass;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store", f = "Store.kt", i = {0, 0, 0}, l = {WebmConstants.MkvEbmlElement.BLOCK_GROUP}, m = "dispatch", n = {"this", NativeProtocol.WEB_DIALOG_ACTION, "stateClazz"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Store.this.dispatch((AsyncAction) null, (KClass) null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ResultT] */
    /* JADX INFO: renamed from: sovran.kotlin.Store$dispatch$4, reason: invalid class name */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\u0004\b\u0002\u0010\u00052\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0005H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "ActionT", "Lsovran/kotlin/AsyncAction;", "StateT", "ResultT", "Lsovran/kotlin/State;", "result", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store$dispatch$4", f = "Store.kt", i = {}, l = {WebmConstants.MkvEbmlElement.BLOCK_MORE, WebmConstants.MkvEbmlElement.TRACK_ENTRY, 175}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4<ResultT> extends SuspendLambda implements Function2<ResultT, Continuation<? super Unit>, Object> {
        final /* synthetic */ AsyncAction $action;
        final /* synthetic */ Ref.ObjectRef $state;
        final /* synthetic */ KClass $stateClazz;
        final /* synthetic */ Container $target;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: sovran.kotlin.Store$dispatch$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: Store.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\u0004\b\u0002\u0010\u0005*\u00020\u0007H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "ActionT", "Lsovran/kotlin/AsyncAction;", "StateT", "ResultT", "Lsovran/kotlin/State;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "sovran.kotlin.Store$dispatch$4$1", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Object $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Object obj, Continuation continuation) {
                super(2, continuation);
                this.$result = obj;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
                Intrinsics.checkNotNullParameter(completion, "completion");
                return new AnonymousClass1(this.$result, completion);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [T, sovran.kotlin.State] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                AnonymousClass4.this.$state.element = AnonymousClass4.this.$action.reduce((State) AnonymousClass4.this.$state.element, this.$result);
                AnonymousClass4.this.$target.setState((State) AnonymousClass4.this.$state.element);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Ref.ObjectRef objectRef, AsyncAction asyncAction, Container container, KClass kClass, Continuation continuation) {
            super(2, continuation);
            this.$state = objectRef;
            this.$action = asyncAction;
            this.$target = container;
            this.$stateClazz = kClass;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            AnonymousClass4 anonymousClass4 = Store.this.new AnonymousClass4(this.$state, this.$action, this.$target, this.$stateClazz, completion);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
        
            if (r1.notify((java.util.List) r12, r3, r11) != r0) goto L21;
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
                Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(Store.this.getSovranScope(), Store.this.getUpdateQueue(), null, new AnonymousClass1(this.L$0, null), 2, null);
                this.label = 1;
                if (jobLaunch$default.join(this) != coroutine_suspended) {
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
                ResultKt.throwOnFailure(obj);
                Store store = Store.this;
                State state = (State) this.$state.element;
                this.label = 3;
            }
            Store store2 = Store.this;
            KClass kClass = this.$stateClazz;
            this.label = 2;
            obj = store2.subscribersForState(kClass, this);
            if (obj != coroutine_suspended) {
                Store store3 = Store.this;
                State state2 = (State) this.$state.element;
                this.label = 3;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$notify$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "StateT", "Lsovran/kotlin/State;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store$notify$2", f = "Store.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
    static final class C13572 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2 $handler;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13572(Function2 function2, State state, Continuation continuation) {
            super(2, continuation);
            this.$handler = function2;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new C13572(this.$handler, this.$state, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13572) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 function2 = this.$handler;
                State state = this.$state;
                this.label = 1;
                if (function2.invoke(state, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: sovran.kotlin.Store$provide$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@"}, d2 = {"provide", "", "StateT", "Lsovran/kotlin/State;", ServerProtocol.DIALOG_PARAM_STATE, "continuation", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store", f = "Store.kt", i = {0, 0}, l = {115, 120}, m = "provide", n = {"this", ServerProtocol.DIALOG_PARAM_STATE}, s = {"L$0", "L$1"})
    static final class C13581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13581(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Store.this.provide(null, this);
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$provide$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "StateT", "Lsovran/kotlin/State;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store$provide$2", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C13592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Container $container;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13592(Container container, Continuation continuation) {
            super(2, continuation);
            this.$container = container;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return Store.this.new C13592(this.$container, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13592) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Store.this.getStates$lib().add(this.$container);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$subscribe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u000eH\u0086@"}, d2 = {"subscribe", "", "StateT", "Lsovran/kotlin/State;", CustomerInfoResponseJsonKeys.SUBSCRIBER, "Lsovran/kotlin/Subscriber;", "stateClazz", "Lkotlin/reflect/KClass;", "initialState", "", "queue", "Lkotlinx/coroutines/CoroutineDispatcher;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "Lsovran/kotlin/SubscriptionID;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store", f = "Store.kt", i = {0, 0, 0, 0, 1, 1, 2}, l = {Imgproc.COLOR_RGB2YUV, 87, 88}, m = "subscribe", n = {"this", "stateClazz", FirebaseAnalytics.Param.SUBSCRIPTION, "initialState", "this", FirebaseAnalytics.Param.SUBSCRIPTION, FirebaseAnalytics.Param.SUBSCRIPTION}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$0"})
    static final class C13601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C13601(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Store.this.subscribe(null, null, false, null, null, this);
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$subscribe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "StateT", "Lsovran/kotlin/State;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store$subscribe$2", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C13612 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Subscription $subscription;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13612(Subscription subscription, Continuation continuation) {
            super(2, continuation);
            this.$subscription = subscription;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return Store.this.new C13612(this.$subscription, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13612) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Store.this.getSubscriptions$lib().add(this.$subscription);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: sovran.kotlin.Store$unsubscribe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "sovran.kotlin.Store$unsubscribe$2", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C13622 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $subscriptionID;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13622(int i, Continuation continuation) {
            super(2, continuation);
            this.$subscriptionID = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return Store.this.new C13622(this.$subscriptionID, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C13622) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CollectionsKt.removeAll((List) Store.this.getSubscriptions$lib(), (Function1) new Function1<Subscription<? extends State>, Boolean>() { // from class: sovran.kotlin.Store.unsubscribe.2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Subscription<? extends State> subscription) {
                    return Boolean.valueOf(invoke2(subscription));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(Subscription<? extends State> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getSubscriptionID() == C13622.this.$subscriptionID;
                }
            });
            return Unit.INSTANCE;
        }
    }

    public Store() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        ExecutorCoroutineDispatcher executorCoroutineDispatcherFrom = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        this.syncQueueDispatcher = executorCoroutineDispatcherFrom;
        this.syncQueue = executorCoroutineDispatcherFrom.plus(new CoroutineName("state.sync.sovran.com"));
        ExecutorService executorServiceNewSingleThreadExecutor2 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor2, "Executors.newSingleThreadExecutor()");
        ExecutorCoroutineDispatcher executorCoroutineDispatcherFrom2 = ExecutorsKt.from(executorServiceNewSingleThreadExecutor2);
        this.updateQueueDispatcher = executorCoroutineDispatcherFrom2;
        this.updateQueue = executorCoroutineDispatcherFrom2.plus(new CoroutineName("state.update.sovran.com"));
        this.states = new ArrayList();
        this.subscriptions = new ArrayList();
    }

    private final Object clean(Continuation<? super Unit> continuation) {
        Object objJoin = BuildersKt__Builders_commonKt.launch$default(getSovranScope(), getSyncQueue(), null, new AnonymousClass2(null), 2, null).join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getSovranScope() {
        return this.sovranScope;
    }

    private final CoroutineContext getSyncQueue() {
        return this.syncQueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineContext getUpdateQueue() {
        return this.updateQueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <StateT extends State> Object notify(List<? extends Subscription<? extends StateT>> list, StateT statet, Continuation<? super Unit> continuation) {
        for (Subscription<? extends StateT> subscription : list) {
            Function2<StateT, Continuation<? super Unit>, Object> handler = subscription.getHandler();
            if (!(handler instanceof SuspendFunction ? TypeIntrinsics.isFunctionOfArity(handler, 2) : false)) {
                handler = null;
            }
            if (handler != null && subscription.getOwner().get() != null) {
                BuildersKt__Builders_commonKt.launch$default(getSovranScope(), subscription.getQueue(), null, new C13572(handler, statet, null), 2, null);
            }
        }
        Object objClean = clean(continuation);
        return objClean == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objClean : Unit.INSTANCE;
    }

    private final <T extends State> Object statesMatching(KClass<T> kClass, Continuation<? super List<Container>> continuation) {
        return BuildersKt__Builders_commonKt.async$default(getSovranScope(), getUpdateQueue(), null, new Store$statesMatching$result$1(this, kClass, null), 2, null).await(continuation);
    }

    public static /* synthetic */ Object subscribe$default(Store store, Subscriber subscriber, KClass kClass, boolean z, CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            coroutineDispatcher = Dispatchers.getDefault();
        }
        return store.subscribe(subscriber, kClass, z2, coroutineDispatcher, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <StateT extends State> Object subscribersForState(KClass<StateT> kClass, Continuation<? super List<? extends Subscription<? extends State>>> continuation) {
        return BuildersKt__Builders_commonKt.async$default(getSovranScope(), getSyncQueue(), null, new Store$subscribersForState$result$1(this, kClass, null), 2, null).await(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <StateT extends State> Object currentState(KClass<StateT> kClass, Continuation<? super StateT> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objStatesMatching = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objStatesMatching);
            anonymousClass1.label = 1;
            objStatesMatching = statesMatching(kClass, anonymousClass1);
            if (objStatesMatching == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objStatesMatching);
        }
        List list = (List) objStatesMatching;
        if (list.isEmpty()) {
            return null;
        }
        State state = ((Container) list.get(0)).getState();
        if (state instanceof State) {
            return state;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fa, code lost:
    
        if (r1.notify((java.util.List) r2, r0, r3) != r4) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea A[PHI: r0 r1 r2
      0x00ea: PHI (r0v5 kotlin.jvm.internal.Ref$ObjectRef) = (r0v4 kotlin.jvm.internal.Ref$ObjectRef), (r0v16 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:37:0x00e7, B:17:0x0043] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r1v7 sovran.kotlin.Store) = (r1v15 sovran.kotlin.Store), (r1v16 sovran.kotlin.Store) binds: [B:37:0x00e7, B:17:0x0043] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r2v7 java.lang.Object) = (r2v6 java.lang.Object), (r2v1 java.lang.Object) binds: [B:37:0x00e7, B:17:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <ActionT extends Action<StateT>, StateT extends State> Object dispatch(ActionT actiont, KClass<StateT> kClass, Continuation<? super Unit> continuation) {
        C13551 c13551;
        Object objStatesMatching;
        KClass<StateT> kClass2;
        Action action;
        Store store;
        Ref.ObjectRef objectRef;
        Store store2;
        Store store3 = this;
        if (continuation instanceof C13551) {
            c13551 = (C13551) continuation;
            if ((c13551.label & Integer.MIN_VALUE) != 0) {
                c13551.label -= Integer.MIN_VALUE;
            } else {
                c13551 = store3.new C13551(continuation);
            }
        }
        Object objSubscribersForState = c13551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13551.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSubscribersForState);
            c13551.L$0 = store3;
            c13551.L$1 = actiont;
            c13551.L$2 = kClass;
            c13551.label = 1;
            objStatesMatching = store3.statesMatching(kClass, c13551);
            if (objStatesMatching != coroutine_suspended) {
                kClass2 = kClass;
                action = actiont;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            KClass<StateT> kClass3 = (KClass) c13551.L$2;
            action = (Action) c13551.L$1;
            Store store4 = (Store) c13551.L$0;
            ResultKt.throwOnFailure(objSubscribersForState);
            kClass2 = kClass3;
            store3 = store4;
            objStatesMatching = objSubscribersForState;
        } else {
            if (i == 2) {
                objectRef = (Ref.ObjectRef) c13551.L$2;
                KClass<StateT> kClass4 = (KClass) c13551.L$1;
                Store store5 = (Store) c13551.L$0;
                ResultKt.throwOnFailure(objSubscribersForState);
                kClass2 = kClass4;
                store = store5;
                c13551.L$0 = store;
                c13551.L$1 = objectRef;
                c13551.L$2 = null;
                c13551.label = 3;
                objSubscribersForState = store.subscribersForState(kClass2, c13551);
                store2 = store;
                if (objSubscribersForState != coroutine_suspended) {
                    State state = (State) objectRef.element;
                    c13551.L$0 = null;
                    c13551.L$1 = null;
                    c13551.label = 4;
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objSubscribersForState);
                return Unit.INSTANCE;
            }
            objectRef = (Ref.ObjectRef) c13551.L$1;
            Store store6 = (Store) c13551.L$0;
            ResultKt.throwOnFailure(objSubscribersForState);
            store2 = store6;
            State state2 = (State) objectRef.element;
            c13551.L$0 = null;
            c13551.L$1 = null;
            c13551.label = 4;
        }
        Container container = (Container) CollectionsKt.firstOrNull((List) objStatesMatching);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        State state3 = container != null ? container.getState() : null;
        boolean z = state3 instanceof State;
        T t = state3;
        if (!z) {
            t = 0;
        }
        if (t == 0) {
            return Unit.INSTANCE;
        }
        objectRef2.element = t;
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(store3.getSovranScope(), store3.getUpdateQueue(), null, new C13562(objectRef2, action, container, null), 2, null);
        c13551.L$0 = store3;
        c13551.L$1 = kClass2;
        c13551.L$2 = objectRef2;
        c13551.label = 2;
        if (jobLaunch$default.join(c13551) != coroutine_suspended) {
            store = store3;
            objectRef = objectRef2;
            c13551.L$0 = store;
            c13551.L$1 = objectRef;
            c13551.L$2 = null;
            c13551.label = 3;
            objSubscribersForState = store.subscribersForState(kClass2, c13551);
            store2 = store;
            if (objSubscribersForState != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <ActionT extends AsyncAction<StateT, ResultT>, StateT extends State, ResultT> Object dispatch(ActionT actiont, KClass<StateT> kClass, Continuation<? super Unit> continuation) {
        AnonymousClass3 anonymousClass3;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            if ((anonymousClass3.label & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        }
        Object objStatesMatching = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass3.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objStatesMatching);
            anonymousClass3.L$0 = this;
            anonymousClass3.L$1 = actiont;
            anonymousClass3.L$2 = kClass;
            anonymousClass3.label = 1;
            objStatesMatching = statesMatching(kClass, anonymousClass3);
            if (objStatesMatching == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kClass = (KClass) anonymousClass3.L$2;
            actiont = (ActionT) anonymousClass3.L$1;
            this = (Store) anonymousClass3.L$0;
            ResultKt.throwOnFailure(objStatesMatching);
        }
        Store store = this;
        AsyncAction asyncAction = actiont;
        KClass<StateT> kClass2 = kClass;
        Container container = (Container) CollectionsKt.firstOrNull((List) objStatesMatching);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        State state = container != null ? container.getState() : null;
        T t = state instanceof State ? state : 0;
        if (t == 0) {
            return Unit.INSTANCE;
        }
        objectRef.element = t;
        asyncAction.operation((State) objectRef.element, store.new AnonymousClass4(objectRef, asyncAction, container, kClass2, null));
        return Unit.INSTANCE;
    }

    public final List<Container> getStates$lib() {
        return this.states;
    }

    public final List<Subscription<? extends State>> getSubscriptions$lib() {
        return this.subscriptions;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008e, code lost:
    
        if (r10.join(r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <StateT extends State> Object provide(StateT statet, Continuation<? super Unit> continuation) {
        C13581 c13581;
        if (continuation instanceof C13581) {
            c13581 = (C13581) continuation;
            if ((c13581.label & Integer.MIN_VALUE) != 0) {
                c13581.label -= Integer.MIN_VALUE;
            } else {
                c13581 = new C13581(continuation);
            }
        }
        Object objStatesMatching = c13581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13581.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objStatesMatching);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(statet.getClass());
            c13581.L$0 = this;
            c13581.L$1 = statet;
            c13581.label = 1;
            objStatesMatching = statesMatching(orCreateKotlinClass, c13581);
            if (objStatesMatching != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objStatesMatching);
            return Unit.INSTANCE;
        }
        statet = (StateT) c13581.L$1;
        this = (Store) c13581.L$0;
        ResultKt.throwOnFailure(objStatesMatching);
        if (!((List) objStatesMatching).isEmpty()) {
            return Unit.INSTANCE;
        }
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.getSovranScope(), this.getUpdateQueue(), null, this.new C13592(new Container(statet), null), 2, null);
        c13581.L$0 = null;
        c13581.L$1 = null;
        c13581.label = 2;
    }

    public final void shutdown() {
        this.syncQueueDispatcher.close();
        this.updateQueueDispatcher.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c8, code lost:
    
        if (r1.notify(r5, r2, r3) == r4) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <StateT extends State> Object subscribe(Subscriber subscriber, KClass<StateT> kClass, boolean z, CoroutineDispatcher coroutineDispatcher, Function2<? super StateT, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Integer> continuation) {
        C13601 c13601;
        Subscription subscription;
        boolean z2;
        Store store;
        Subscription subscription2;
        State state;
        Store store2 = this;
        KClass<StateT> kClass2 = kClass;
        if (continuation instanceof C13601) {
            c13601 = (C13601) continuation;
            if ((c13601.label & Integer.MIN_VALUE) != 0) {
                c13601.label -= Integer.MIN_VALUE;
            } else {
                c13601 = store2.new C13601(continuation);
            }
        }
        Object obj = c13601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13601.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            subscription = new Subscription(subscriber, function2, kClass2, coroutineDispatcher);
            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(store2.getSovranScope(), store2.getSyncQueue(), null, store2.new C13612(subscription, null), 2, null);
            c13601.L$0 = store2;
            c13601.L$1 = kClass2;
            c13601.L$2 = subscription;
            z2 = z;
            c13601.Z$0 = z2;
            c13601.label = 1;
            if (jobLaunch$default.join(c13601) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                subscription2 = (Subscription) c13601.L$0;
                ResultKt.throwOnFailure(obj);
                subscription = subscription2;
                return Boxing.boxInt(subscription.getSubscriptionID());
            }
            subscription2 = (Subscription) c13601.L$1;
            Store store3 = (Store) c13601.L$0;
            ResultKt.throwOnFailure(obj);
            store = store3;
            state = (State) obj;
            if (state != null) {
                List listListOf = CollectionsKt.listOf(subscription2);
                c13601.L$0 = subscription2;
                c13601.L$1 = null;
                c13601.label = 3;
            }
            subscription = subscription2;
            return Boxing.boxInt(subscription.getSubscriptionID());
        }
        boolean z3 = c13601.Z$0;
        Subscription subscription3 = (Subscription) c13601.L$2;
        KClass<StateT> kClass3 = (KClass) c13601.L$1;
        Store store4 = (Store) c13601.L$0;
        ResultKt.throwOnFailure(obj);
        z2 = z3;
        subscription = subscription3;
        kClass2 = kClass3;
        store2 = store4;
        if (z2) {
            c13601.L$0 = store2;
            c13601.L$1 = subscription;
            c13601.L$2 = null;
            c13601.label = 2;
            Object objCurrentState = store2.currentState(kClass2, c13601);
            if (objCurrentState != coroutine_suspended) {
                store = store2;
                subscription2 = subscription;
                obj = objCurrentState;
                state = (State) obj;
                if (state != null) {
                }
                subscription = subscription2;
            }
            return coroutine_suspended;
        }
        return Boxing.boxInt(subscription.getSubscriptionID());
    }

    public final Object unsubscribe(int i, Continuation<? super Unit> continuation) {
        Object objJoin = BuildersKt__Builders_commonKt.launch$default(getSovranScope(), getSyncQueue(), null, new C13622(i, null), 2, null).join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }
}
