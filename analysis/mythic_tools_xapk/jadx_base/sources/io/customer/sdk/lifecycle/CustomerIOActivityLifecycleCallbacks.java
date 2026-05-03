package io.customer.sdk.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.media3.common.MimeTypes;
import io.customer.sdk.core.di.SDKComponent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: CustomerIOActivityLifecycleCallbacks.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ@\u0010\u000e\u001a\u00020\n23\u0010\u000f\u001a/\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u001a\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lio/customer/sdk/lifecycle/CustomerIOActivityLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "lifecycleEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/customer/sdk/lifecycle/LifecycleStateChange;", "subscriberScope", "Lkotlinx/coroutines/CoroutineScope;", "register", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "unregister", "subscribe", "block", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "sendEventToCallbacks", "", "activity", "Landroid/app/Activity;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "bundle", "Landroid/os/Bundle;", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "onActivityDestroyed", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomerIOActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private final MutableSharedFlow<LifecycleStateChange> lifecycleEvents = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
    private final CoroutineScope subscriberScope = SDKComponent.INSTANCE.getScopeProvider().getLifecycleListenerScope();

    /* JADX INFO: renamed from: io.customer.sdk.lifecycle.CustomerIOActivityLifecycleCallbacks$subscribe$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomerIOActivityLifecycleCallbacks.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.customer.sdk.lifecycle.CustomerIOActivityLifecycleCallbacks$subscribe$1", f = "CustomerIOActivityLifecycleCallbacks.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, SharedFlow<LifecycleStateChange>, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CustomerIOActivityLifecycleCallbacks this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function3<? super CoroutineScope, ? super SharedFlow<LifecycleStateChange>, ? super Continuation<? super Unit>, ? extends Object> function3, CustomerIOActivityLifecycleCallbacks customerIOActivityLifecycleCallbacks, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.this$0 = customerIOActivityLifecycleCallbacks;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, this.this$0, continuation);
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
                Function3<CoroutineScope, SharedFlow<LifecycleStateChange>, Continuation<? super Unit>, Object> function3 = this.$block;
                MutableSharedFlow mutableSharedFlow = this.this$0.lifecycleEvents;
                this.label = 1;
                if (function3.invoke(coroutineScope, mutableSharedFlow, this) == coroutine_suspended) {
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

    private final boolean sendEventToCallbacks(Activity activity, Lifecycle.Event event, Bundle bundle) {
        return this.lifecycleEvents.tryEmit(new LifecycleStateChange(new WeakReference(activity), event, bundle));
    }

    static /* synthetic */ boolean sendEventToCallbacks$default(CustomerIOActivityLifecycleCallbacks customerIOActivityLifecycleCallbacks, Activity activity, Lifecycle.Event event, Bundle bundle, int i, Object obj) {
        if ((i & 4) != 0) {
            bundle = null;
        }
        return customerIOActivityLifecycleCallbacks.sendEventToCallbacks(activity, event, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        sendEventToCallbacks(activity, Lifecycle.Event.ON_CREATE, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        sendEventToCallbacks$default(this, activity, Lifecycle.Event.ON_DESTROY, null, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        sendEventToCallbacks$default(this, activity, Lifecycle.Event.ON_PAUSE, null, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        sendEventToCallbacks$default(this, activity, Lifecycle.Event.ON_RESUME, null, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        sendEventToCallbacks$default(this, activity, Lifecycle.Event.ON_START, null, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        sendEventToCallbacks$default(this, activity, Lifecycle.Event.ON_STOP, null, 4, null);
    }

    public final void register(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        application.registerActivityLifecycleCallbacks(this);
    }

    public final void subscribe(Function3<? super CoroutineScope, ? super SharedFlow<LifecycleStateChange>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BuildersKt__Builders_commonKt.launch$default(this.subscriberScope, null, null, new AnonymousClass1(block, this, null), 3, null);
    }

    public final void unregister(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        application.unregisterActivityLifecycleCallbacks(this);
        CoroutineScopeKt.cancel$default(this.subscriberScope, null, 1, null);
    }
}
