package io.customer.sdk.core.pipeline;

import io.customer.base.internal.InternalCustomerIOApi;
import io.customer.sdk.core.di.SDKComponent;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdentifyHookRegistry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"identifyHookRegistry", "Lio/customer/sdk/core/pipeline/IdentifyHookRegistry;", "Lio/customer/sdk/core/di/SDKComponent;", "getIdentifyHookRegistry$annotations", "(Lio/customer/sdk/core/di/SDKComponent;)V", "getIdentifyHookRegistry", "(Lio/customer/sdk/core/di/SDKComponent;)Lio/customer/sdk/core/pipeline/IdentifyHookRegistry;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IdentifyHookRegistryKt {
    public static final IdentifyHookRegistry getIdentifyHookRegistry(SDKComponent sDKComponent) {
        IdentifyHookRegistry identifyHookRegistry;
        Object objPutIfAbsent;
        Intrinsics.checkNotNullParameter(sDKComponent, "<this>");
        SDKComponent sDKComponent2 = sDKComponent;
        ConcurrentHashMap<String, Object> overrides = sDKComponent2.getOverrides();
        String name = IdentifyHookRegistry.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof IdentifyHookRegistry)) {
            obj = null;
        }
        IdentifyHookRegistry identifyHookRegistry2 = (IdentifyHookRegistry) obj;
        if (identifyHookRegistry2 != null) {
            return identifyHookRegistry2;
        }
        synchronized (sDKComponent2.getSingletons()) {
            String name2 = IdentifyHookRegistry.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = sDKComponent2.getSingletons();
            Object identifyHookRegistry3 = singletons.get(name2);
            if (identifyHookRegistry3 == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (identifyHookRegistry3 = new IdentifyHookRegistry()))) != null) {
                identifyHookRegistry3 = objPutIfAbsent;
            }
            if (identifyHookRegistry3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.sdk.core.pipeline.IdentifyHookRegistry");
            }
            identifyHookRegistry = (IdentifyHookRegistry) identifyHookRegistry3;
        }
        return identifyHookRegistry;
    }

    @InternalCustomerIOApi
    public static /* synthetic */ void getIdentifyHookRegistry$annotations(SDKComponent sDKComponent) {
    }
}
