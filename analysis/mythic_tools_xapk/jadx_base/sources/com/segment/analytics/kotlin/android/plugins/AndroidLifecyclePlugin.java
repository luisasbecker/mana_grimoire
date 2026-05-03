package com.segment.analytics.kotlin.android.plugins;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.common.MimeTypes;
import com.segment.analytics.kotlin.android.utilities.DeepLinkUtils;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Configuration;
import com.segment.analytics.kotlin.core.ErrorsKt;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.Storage;
import com.segment.analytics.kotlin.core.platform.Plugin;
import io.customer.sdk.util.EventNames;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010*\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00102\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J.\u00105\u001a\u0002062\u001c\u00107\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"09\u0012\u0006\u0012\u0004\u0018\u00010:08H\u0002ø\u0001\u0000¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u00020\"2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\"0>H\u0002J\u0010\u0010?\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\r\u0010@\u001a\u00020\"H\u0000¢\u0006\u0002\bAJ\u0012\u0010B\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0006\u0010C\u001a\u00020\"R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lcom/segment/analytics/kotlin/android/plugins/AndroidLifecyclePlugin;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "()V", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "setAnalytics", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "firstLaunch", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isChangingActivityConfigurations", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "numberOfActivities", "Ljava/util/concurrent/atomic/AtomicInteger;", "packageInfo", "Landroid/content/pm/PackageInfo;", "shouldTrackApplicationLifecycleEvents", "", "storage", "Lcom/segment/analytics/kotlin/core/Storage;", "trackDeepLinks", "trackedApplicationLifecycleEvents", "type", "Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "getType", "()Lcom/segment/analytics/kotlin/core/platform/Plugin$Type;", "useLifecycleObserver", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "runOnAnalyticsThread", "Lkotlinx/coroutines/Job;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "runOnMainThread", "closure", "Lkotlin/Function0;", "setup", "trackApplicationLifecycleEvents", "trackApplicationLifecycleEvents$android_release", "trackDeepLink", "unregisterListeners", "Companion", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidLifecyclePlugin implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver, Plugin {
    private static final String BUILD_KEY = "build";
    private static final String VERSION_KEY = "version";
    public Analytics analytics;
    private Application application;
    private Lifecycle lifecycle;
    private PackageInfo packageInfo;
    private Storage storage;
    private boolean useLifecycleObserver;
    private static final LifecycleOwner stubOwner = new LifecycleOwner() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$Companion$stubOwner$1
        private Lifecycle stubLifecycle = new Lifecycle() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$Companion$stubOwner$1$stubLifecycle$1
            @Override // androidx.lifecycle.Lifecycle
            public void addObserver(LifecycleObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
            }

            @Override // androidx.lifecycle.Lifecycle
            /* JADX INFO: renamed from: getCurrentState */
            public Lifecycle.State getState() {
                return Lifecycle.State.DESTROYED;
            }

            @Override // androidx.lifecycle.Lifecycle
            public void removeObserver(LifecycleObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
            }
        };

        @Override // androidx.lifecycle.LifecycleOwner
        /* JADX INFO: renamed from: getLifecycle, reason: from getter */
        public Lifecycle getStubLifecycle() {
            return this.stubLifecycle;
        }

        public final Lifecycle getStubLifecycle() {
            return this.stubLifecycle;
        }

        public final void setStubLifecycle(Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "<set-?>");
            this.stubLifecycle = lifecycle;
        }
    };
    private final Plugin.Type type = Plugin.Type.Utility;
    private boolean shouldTrackApplicationLifecycleEvents = true;
    private boolean trackDeepLinks = true;
    private final AtomicBoolean trackedApplicationLifecycleEvents = new AtomicBoolean(false);
    private final AtomicInteger numberOfActivities = new AtomicInteger(1);
    private final AtomicBoolean firstLaunch = new AtomicBoolean(false);
    private final AtomicBoolean isChangingActivityConfigurations = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityCreated$1", f = "AndroidLifecyclePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Bundle $bundle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, Bundle bundle, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$activity = activity;
            this.$bundle = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AndroidLifecyclePlugin.this.new AnonymousClass1(this.$activity, this.$bundle, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Analytics analytics = AndroidLifecyclePlugin.this.getAnalytics();
            final Activity activity = this.$activity;
            final Bundle bundle = this.$bundle;
            analytics.applyClosureToPlugins(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin.onActivityCreated.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                    invoke2(plugin);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Plugin plugin) {
                    if (plugin instanceof AndroidLifecycle) {
                        ((AndroidLifecycle) plugin).onActivityCreated(activity, bundle);
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityDestroyed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityDestroyed$1", f = "AndroidLifecyclePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10661 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10661(Activity activity, Continuation<? super C10661> continuation) {
            super(1, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AndroidLifecyclePlugin.this.new C10661(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10661) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Analytics analytics = AndroidLifecyclePlugin.this.getAnalytics();
            final Activity activity = this.$activity;
            analytics.applyClosureToPlugins(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin.onActivityDestroyed.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                    invoke2(plugin);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Plugin plugin) {
                    if (plugin instanceof AndroidLifecycle) {
                        ((AndroidLifecycle) plugin).onActivityDestroyed(activity);
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityPaused$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityPaused$1", f = "AndroidLifecyclePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10671 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10671(Activity activity, Continuation<? super C10671> continuation) {
            super(1, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AndroidLifecyclePlugin.this.new C10671(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10671) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Analytics analytics = AndroidLifecyclePlugin.this.getAnalytics();
            final Activity activity = this.$activity;
            analytics.applyClosureToPlugins(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin.onActivityPaused.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                    invoke2(plugin);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Plugin plugin) {
                    if (plugin instanceof AndroidLifecycle) {
                        ((AndroidLifecycle) plugin).onActivityPaused(activity);
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityResumed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityResumed$1", f = "AndroidLifecyclePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10681 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10681(Activity activity, Continuation<? super C10681> continuation) {
            super(1, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AndroidLifecyclePlugin.this.new C10681(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10681) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Analytics analytics = AndroidLifecyclePlugin.this.getAnalytics();
            final Activity activity = this.$activity;
            analytics.applyClosureToPlugins(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin.onActivityResumed.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                    invoke2(plugin);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Plugin plugin) {
                    if (plugin instanceof AndroidLifecycle) {
                        ((AndroidLifecycle) plugin).onActivityResumed(activity);
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivitySaveInstanceState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivitySaveInstanceState$1", f = "AndroidLifecyclePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10691 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Bundle $bundle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10691(Activity activity, Bundle bundle, Continuation<? super C10691> continuation) {
            super(1, continuation);
            this.$activity = activity;
            this.$bundle = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AndroidLifecyclePlugin.this.new C10691(this.$activity, this.$bundle, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10691) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Analytics analytics = AndroidLifecyclePlugin.this.getAnalytics();
            final Activity activity = this.$activity;
            final Bundle bundle = this.$bundle;
            analytics.applyClosureToPlugins(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin.onActivitySaveInstanceState.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                    invoke2(plugin);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Plugin plugin) {
                    if (plugin instanceof AndroidLifecycle) {
                        ((AndroidLifecycle) plugin).onActivitySaveInstanceState(activity, bundle);
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityStarted$1", f = "AndroidLifecyclePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10701 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10701(Activity activity, Continuation<? super C10701> continuation) {
            super(1, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AndroidLifecyclePlugin.this.new C10701(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10701) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Analytics analytics = AndroidLifecyclePlugin.this.getAnalytics();
            final Activity activity = this.$activity;
            analytics.applyClosureToPlugins(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin.onActivityStarted.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                    invoke2(plugin);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Plugin plugin) {
                    if (plugin instanceof AndroidLifecycle) {
                        ((AndroidLifecycle) plugin).onActivityStarted(activity);
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityStopped$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$onActivityStopped$1", f = "AndroidLifecyclePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10711 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10711(Activity activity, Continuation<? super C10711> continuation) {
            super(1, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AndroidLifecyclePlugin.this.new C10711(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10711) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Analytics analytics = AndroidLifecyclePlugin.this.getAnalytics();
            final Activity activity = this.$activity;
            analytics.applyClosureToPlugins(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin.onActivityStopped.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                    invoke2(plugin);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Plugin plugin) {
                    if (plugin instanceof AndroidLifecycle) {
                        ((AndroidLifecycle) plugin).onActivityStopped(activity);
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$runOnMainThread$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidLifecyclePlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin$runOnMainThread$1", f = "AndroidLifecyclePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $closure;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10721(Function0<Unit> function0, Continuation<? super C10721> continuation) {
            super(2, continuation);
            this.$closure = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10721(this.$closure, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$closure.invoke();
            return Unit.INSTANCE;
        }
    }

    private final Job runOnAnalyticsThread(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Analytics analytics = getAnalytics();
        return BuildersKt__Builders_commonKt.launch$default(analytics.getAnalyticsScope(), analytics.getAnalyticsDispatcher(), null, new AndroidLifecyclePlugin$runOnAnalyticsThread$1$1(block, null), 2, null);
    }

    private final void runOnMainThread(Function0<Unit> closure) {
        BuildersKt__Builders_commonKt.launch$default(getAnalytics().getAnalyticsScope(), Dispatchers.getMain(), null, new C10721(closure, null), 2, null);
    }

    private final void trackDeepLink(Activity activity) {
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent != null) {
            Uri referrer = AndroidLifecyclePluginKt.getReferrer(activity);
            new DeepLinkUtils(getAnalytics()).trackDeepLinkFrom(referrer != null ? referrer.toString() : null, intent);
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public BaseEvent execute(BaseEvent baseEvent) {
        return Plugin.DefaultImpls.execute(this, baseEvent);
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public Plugin.Type getType() {
        return this.type;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        runOnAnalyticsThread(new AnonymousClass1(activity, bundle, null));
        if (!this.useLifecycleObserver) {
            onCreate(stubOwner);
        }
        if (this.trackDeepLinks) {
            trackDeepLink(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        runOnAnalyticsThread(new C10661(activity, null));
        if (this.useLifecycleObserver) {
            return;
        }
        onDestroy(stubOwner);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        runOnAnalyticsThread(new C10671(activity, null));
        if (this.useLifecycleObserver) {
            return;
        }
        onPause(stubOwner);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        runOnAnalyticsThread(new C10681(activity, null));
        if (this.useLifecycleObserver) {
            return;
        }
        onStart(stubOwner);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        runOnAnalyticsThread(new C10691(activity, bundle, null));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        runOnAnalyticsThread(new C10701(activity, null));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        runOnAnalyticsThread(new C10711(activity, null));
        if (this.useLifecycleObserver) {
            return;
        }
        onStop(stubOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.trackedApplicationLifecycleEvents.getAndSet(true) || !this.shouldTrackApplicationLifecycleEvents) {
            return;
        }
        this.numberOfActivities.set(0);
        this.firstLaunch.set(true);
        trackApplicationLifecycleEvents$android_release();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.shouldTrackApplicationLifecycleEvents && this.numberOfActivities.incrementAndGet() == 1 && !this.isChangingActivityConfigurations.get()) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            if (this.firstLaunch.get()) {
                PackageInfo packageInfo = this.packageInfo;
                PackageInfo packageInfo2 = null;
                if (packageInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("packageInfo");
                    packageInfo = null;
                }
                JsonElementBuildersKt.put(jsonObjectBuilder, "version", packageInfo.versionName);
                PackageInfo packageInfo3 = this.packageInfo;
                if (packageInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("packageInfo");
                } else {
                    packageInfo2 = packageInfo3;
                }
                JsonElementBuildersKt.put(jsonObjectBuilder, "build", AndroidLifecyclePluginKt.getVersionCode(packageInfo2).toString());
            }
            JsonElementBuildersKt.put(jsonObjectBuilder, "from_background", Boolean.valueOf(true ^ this.firstLaunch.getAndSet(false)));
            Analytics.track$default(getAnalytics(), "Application Opened", jsonObjectBuilder.build(), (Function1) null, 4, (Object) null);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.shouldTrackApplicationLifecycleEvents && this.numberOfActivities.decrementAndGet() == 0 && !this.isChangingActivityConfigurations.get()) {
            Analytics.track$default(getAnalytics(), EventNames.APPLICATION_BACKGROUNDED, (JsonObject) null, (Function1) null, 6, (Object) null);
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setAnalytics(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "<set-?>");
        this.analytics = analytics;
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void setup(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Plugin.DefaultImpls.setup(this, analytics);
        Configuration configuration = analytics.getConfiguration();
        Object application = configuration.getApplication();
        Application application2 = null;
        Application application3 = application instanceof Application ? (Application) application : null;
        if (application3 == null) {
            throw new IllegalStateException("no android application context registered".toString());
        }
        this.application = application3;
        this.shouldTrackApplicationLifecycleEvents = configuration.getTrackApplicationLifecycleEvents();
        this.trackDeepLinks = configuration.getTrackDeepLinks();
        this.useLifecycleObserver = configuration.getUseLifecycleObserver();
        this.storage = analytics.getStorage();
        Application application4 = this.application;
        if (application4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
            application4 = null;
        }
        PackageManager packageManager = application4.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "application.packageManager");
        try {
            Application application5 = this.application;
            if (application5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
                application5 = null;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(application5.getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "{\n            packageMan…packageName, 0)\n        }");
            this.packageInfo = packageInfo;
            Application application6 = this.application;
            if (application6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
            } else {
                application2 = application6;
            }
            application2.registerActivityLifecycleCallbacks(this);
            if (this.useLifecycleObserver) {
                this.lifecycle = ProcessLifecycleOwner.INSTANCE.get().getStubLifecycle();
                runOnMainThread(new Function0<Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin.setup.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Lifecycle lifecycle = AndroidLifecyclePlugin.this.lifecycle;
                        if (lifecycle == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lifecycle");
                            lifecycle = null;
                        }
                        lifecycle.addObserver(AndroidLifecyclePlugin.this);
                    }
                });
            }
        } catch (PackageManager.NameNotFoundException unused) {
            StringBuilder sb = new StringBuilder("Package not found: ");
            Application application7 = this.application;
            if (application7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
            } else {
                application2 = application7;
            }
            AssertionError assertionError = new AssertionError(sb.append(application2.getPackageName()).toString());
            ErrorsKt.reportInternalError(analytics, assertionError);
            throw assertionError;
        }
    }

    public final void trackApplicationLifecycleEvents$android_release() {
        PackageInfo packageInfo = this.packageInfo;
        if (packageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packageInfo");
            packageInfo = null;
        }
        String str = packageInfo.versionName;
        String string = AndroidLifecyclePluginKt.getVersionCode(packageInfo).toString();
        Storage storage = this.storage;
        if (storage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            storage = null;
        }
        String str2 = storage.read(Storage.Constants.AppVersion);
        Storage storage2 = this.storage;
        if (storage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            storage2 = null;
        }
        String str3 = storage2.read(Storage.Constants.AppBuild);
        Storage storage3 = this.storage;
        if (storage3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
            storage3 = null;
        }
        String str4 = storage3.read(Storage.Constants.LegacyAppBuild);
        if (str3 == null && str4 == null) {
            Analytics analytics = getAnalytics();
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder, "version", str);
            JsonElementBuildersKt.put(jsonObjectBuilder, "build", string);
            Unit unit = Unit.INSTANCE;
            Analytics.track$default(analytics, "Application Installed", jsonObjectBuilder.build(), (Function1) null, 4, (Object) null);
        } else if (!Intrinsics.areEqual(string, str3)) {
            Analytics analytics2 = getAnalytics();
            JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder2, "version", str);
            JsonElementBuildersKt.put(jsonObjectBuilder2, "build", string);
            JsonElementBuildersKt.put(jsonObjectBuilder2, "previous_version", str2);
            JsonElementBuildersKt.put(jsonObjectBuilder2, "previous_build", String.valueOf(str3));
            Unit unit2 = Unit.INSTANCE;
            Analytics.track$default(analytics2, "Application Updated", jsonObjectBuilder2.build(), (Function1) null, 4, (Object) null);
        }
        runOnAnalyticsThread(new AndroidLifecyclePlugin$trackApplicationLifecycleEvents$3(this, str, string, null));
    }

    public final void unregisterListeners() {
        Application application = this.application;
        if (application == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
            application = null;
        }
        application.unregisterActivityLifecycleCallbacks(this);
        if (this.useLifecycleObserver) {
            runOnMainThread(new Function0<Unit>() { // from class: com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin.unregisterListeners.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Lifecycle lifecycle = AndroidLifecyclePlugin.this.lifecycle;
                    if (lifecycle == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lifecycle");
                        lifecycle = null;
                    }
                    lifecycle.removeObserver(AndroidLifecyclePlugin.this);
                }
            });
        }
    }

    @Override // com.segment.analytics.kotlin.core.platform.Plugin
    public void update(Settings settings, Plugin.UpdateType updateType) {
        Plugin.DefaultImpls.update(this, settings, updateType);
    }
}
