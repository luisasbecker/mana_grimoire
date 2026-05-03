package io.customer.sdk.core.di;

import com.facebook.appevents.codeless.internal.Constants;
import io.customer.sdk.communication.EventBus;
import io.customer.sdk.communication.EventBusImpl;
import io.customer.sdk.core.environment.BuildEnvironment;
import io.customer.sdk.core.environment.DefaultBuildEnvironment;
import io.customer.sdk.core.module.CustomerIOModule;
import io.customer.sdk.core.module.CustomerIOModuleConfig;
import io.customer.sdk.core.util.DispatchersProvider;
import io.customer.sdk.core.util.LogcatLogger;
import io.customer.sdk.core.util.Logger;
import io.customer.sdk.core.util.LoggerImpl;
import io.customer.sdk.core.util.ScopeProvider;
import io.customer.sdk.core.util.SdkDispatchers;
import io.customer.sdk.core.util.SdkScopeProvider;
import io.customer.sdk.lifecycle.CustomerIOActivityLifecycleCallbacks;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: compiled from: SDKComponent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010(\u001a\u00020)H\u0016R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lio/customer/sdk/core/di/SDKComponent;", "Lio/customer/sdk/core/di/DiGraph;", "<init>", "()V", "modules", "", "", "Lio/customer/sdk/core/module/CustomerIOModule;", "Lio/customer/sdk/core/module/CustomerIOModuleConfig;", "getModules", "()Ljava/util/Map;", "activityLifecycleCallbacks", "Lio/customer/sdk/lifecycle/CustomerIOActivityLifecycleCallbacks;", "getActivityLifecycleCallbacks", "()Lio/customer/sdk/lifecycle/CustomerIOActivityLifecycleCallbacks;", "androidSDKComponent", "Lio/customer/sdk/core/di/AndroidSDKComponent;", "getAndroidSDKComponent$core_release", "()Lio/customer/sdk/core/di/AndroidSDKComponent;", Constants.PLATFORM, "buildEnvironment", "Lio/customer/sdk/core/environment/BuildEnvironment;", "getBuildEnvironment", "()Lio/customer/sdk/core/environment/BuildEnvironment;", "logger", "Lio/customer/sdk/core/util/Logger;", "getLogger", "()Lio/customer/sdk/core/util/Logger;", "eventBus", "Lio/customer/sdk/communication/EventBus;", "getEventBus", "()Lio/customer/sdk/communication/EventBus;", "dispatchersProvider", "Lio/customer/sdk/core/util/DispatchersProvider;", "getDispatchersProvider", "()Lio/customer/sdk/core/util/DispatchersProvider;", "scopeProvider", "Lio/customer/sdk/core/util/ScopeProvider;", "getScopeProvider", "()Lio/customer/sdk/core/util/ScopeProvider;", "reset", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SDKComponent extends DiGraph {
    public static final SDKComponent INSTANCE = new SDKComponent();
    private static final Map<String, CustomerIOModule<? extends CustomerIOModuleConfig>> modules = new LinkedHashMap();

    private SDKComponent() {
    }

    public final AndroidSDKComponent android() {
        AndroidSDKComponent androidSDKComponent$core_release = getAndroidSDKComponent$core_release();
        if (androidSDKComponent$core_release != null) {
            return androidSDKComponent$core_release;
        }
        throw new IllegalStateException("AndroidSDKComponent is not initialized. Make sure to initialize SDK components with context before accessing it.");
    }

    public final CustomerIOActivityLifecycleCallbacks getActivityLifecycleCallbacks() {
        CustomerIOActivityLifecycleCallbacks customerIOActivityLifecycleCallbacks;
        Object objPutIfAbsent;
        SDKComponent sDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = sDKComponent.getOverrides();
        String name = CustomerIOActivityLifecycleCallbacks.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof CustomerIOActivityLifecycleCallbacks)) {
            obj = null;
        }
        CustomerIOActivityLifecycleCallbacks customerIOActivityLifecycleCallbacks2 = (CustomerIOActivityLifecycleCallbacks) obj;
        if (customerIOActivityLifecycleCallbacks2 != null) {
            return customerIOActivityLifecycleCallbacks2;
        }
        synchronized (sDKComponent.getSingletons()) {
            String name2 = CustomerIOActivityLifecycleCallbacks.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = sDKComponent.getSingletons();
            Object customerIOActivityLifecycleCallbacks3 = singletons.get(name2);
            if (customerIOActivityLifecycleCallbacks3 == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (customerIOActivityLifecycleCallbacks3 = new CustomerIOActivityLifecycleCallbacks()))) != null) {
                customerIOActivityLifecycleCallbacks3 = objPutIfAbsent;
            }
            if (customerIOActivityLifecycleCallbacks3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.sdk.lifecycle.CustomerIOActivityLifecycleCallbacks");
            }
            customerIOActivityLifecycleCallbacks = (CustomerIOActivityLifecycleCallbacks) customerIOActivityLifecycleCallbacks3;
        }
        return customerIOActivityLifecycleCallbacks;
    }

    public final AndroidSDKComponent getAndroidSDKComponent$core_release() {
        SDKComponent sDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = sDKComponent.getOverrides();
        String name = AndroidSDKComponent.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof AndroidSDKComponent)) {
            obj = null;
        }
        AndroidSDKComponent androidSDKComponent = (AndroidSDKComponent) obj;
        if (androidSDKComponent != null) {
            return androidSDKComponent;
        }
        ConcurrentHashMap<String, Object> singletons = sDKComponent.getSingletons();
        String name2 = AndroidSDKComponent.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        Object obj2 = singletons.get(name2);
        return (AndroidSDKComponent) (obj2 instanceof AndroidSDKComponent ? obj2 : null);
    }

    public final BuildEnvironment getBuildEnvironment() {
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        String name = BuildEnvironment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof BuildEnvironment)) {
            obj = null;
        }
        BuildEnvironment buildEnvironment = (BuildEnvironment) obj;
        return buildEnvironment == null ? new DefaultBuildEnvironment() : buildEnvironment;
    }

    public final DispatchersProvider getDispatchersProvider() {
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        String name = DispatchersProvider.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof DispatchersProvider)) {
            obj = null;
        }
        DispatchersProvider dispatchersProvider = (DispatchersProvider) obj;
        return dispatchersProvider == null ? new SdkDispatchers() : dispatchersProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final EventBus getEventBus() {
        EventBus eventBus;
        Object objPutIfAbsent;
        SDKComponent sDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = sDKComponent.getOverrides();
        String name = EventBus.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        MutableSharedFlow mutableSharedFlow = null;
        Object[] objArr = 0;
        if (!(obj instanceof EventBus)) {
            obj = null;
        }
        EventBus eventBus2 = (EventBus) obj;
        if (eventBus2 != null) {
            return eventBus2;
        }
        synchronized (sDKComponent.getSingletons()) {
            String name2 = EventBus.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = sDKComponent.getSingletons();
            EventBusImpl eventBusImpl = singletons.get(name2);
            if (eventBusImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (eventBusImpl = new EventBusImpl(mutableSharedFlow, 1, objArr == true ? 1 : 0)))) != null) {
                eventBusImpl = objPutIfAbsent;
            }
            if (eventBusImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.sdk.communication.EventBus");
            }
            eventBus = (EventBus) eventBusImpl;
        }
        return eventBus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Logger getLogger() {
        Logger logger;
        Object objPutIfAbsent;
        SDKComponent sDKComponent = this;
        ConcurrentHashMap<String, Object> overrides = sDKComponent.getOverrides();
        String name = Logger.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        LogcatLogger logcatLogger = null;
        Object[] objArr = 0;
        if (!(obj instanceof Logger)) {
            obj = null;
        }
        Logger logger2 = (Logger) obj;
        if (logger2 != null) {
            return logger2;
        }
        synchronized (sDKComponent.getSingletons()) {
            String name2 = Logger.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = sDKComponent.getSingletons();
            LoggerImpl loggerImpl = singletons.get(name2);
            if (loggerImpl == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (loggerImpl = new LoggerImpl(INSTANCE.getBuildEnvironment(), logcatLogger, 2, objArr == true ? 1 : 0)))) != null) {
                loggerImpl = objPutIfAbsent;
            }
            if (loggerImpl == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.sdk.core.util.Logger");
            }
            logger = (Logger) loggerImpl;
        }
        return logger;
    }

    public final Map<String, CustomerIOModule<? extends CustomerIOModuleConfig>> getModules() {
        return modules;
    }

    public final ScopeProvider getScopeProvider() {
        ConcurrentHashMap<String, Object> overrides = getOverrides();
        String name = ScopeProvider.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof ScopeProvider)) {
            obj = null;
        }
        ScopeProvider scopeProvider = (ScopeProvider) obj;
        return scopeProvider == null ? new SdkScopeProvider(INSTANCE.getDispatchersProvider()) : scopeProvider;
    }

    @Override // io.customer.sdk.core.di.DiGraph
    public void reset() {
        AndroidSDKComponent androidSDKComponent$core_release = getAndroidSDKComponent$core_release();
        if (androidSDKComponent$core_release != null) {
            androidSDKComponent$core_release.reset();
        }
        modules.clear();
        getEventBus().removeAllSubscriptions();
        super.reset();
    }
}
