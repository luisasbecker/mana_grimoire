package io.customer.datapipelines.di;

import com.segment.analytics.kotlin.core.Analytics;
import io.customer.datapipelines.config.DataPipelinesModuleConfig;
import io.customer.sdk.DataPipelinesLogger;
import io.customer.sdk.core.di.SDKComponent;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: SDKComponentExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"5\u0010\u0000\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0001*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"analyticsFactory", "Lkotlin/Function1;", "Lio/customer/datapipelines/config/DataPipelinesModuleConfig;", "Lkotlin/ParameterName;", "name", "moduleConfig", "Lcom/segment/analytics/kotlin/core/Analytics;", "Lio/customer/sdk/core/di/SDKComponent;", "getAnalyticsFactory", "(Lio/customer/sdk/core/di/SDKComponent;)Lkotlin/jvm/functions/Function1;", "dataPipelinesLogger", "Lio/customer/sdk/DataPipelinesLogger;", "getDataPipelinesLogger", "(Lio/customer/sdk/core/di/SDKComponent;)Lio/customer/sdk/DataPipelinesLogger;", "datapipelines_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SDKComponentExtKt {
    public static final Function1<DataPipelinesModuleConfig, Analytics> getAnalyticsFactory(SDKComponent sDKComponent) {
        String name;
        Intrinsics.checkNotNullParameter(sDKComponent, "<this>");
        SDKComponent sDKComponent2 = sDKComponent;
        String strName = SDKComponentKeys.AnalyticsFactory.name();
        ConcurrentHashMap<String, Object> overrides = sDKComponent2.getOverrides();
        if (strName == null) {
            name = Function1.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        } else {
            name = strName;
        }
        Object obj = overrides.get(name);
        if (!TypeIntrinsics.isFunctionOfArity(obj, 1)) {
            obj = null;
        }
        Function1<DataPipelinesModuleConfig, Analytics> function1 = (Function1) obj;
        if (function1 != null) {
            return function1;
        }
        ConcurrentHashMap<String, Object> singletons = sDKComponent2.getSingletons();
        if (strName == null) {
            strName = Function1.class.getName();
            Intrinsics.checkNotNullExpressionValue(strName, "getName(...)");
        }
        Object obj2 = singletons.get(strName);
        return (Function1) (TypeIntrinsics.isFunctionOfArity(obj2, 1) ? obj2 : null);
    }

    public static final DataPipelinesLogger getDataPipelinesLogger(SDKComponent sDKComponent) {
        DataPipelinesLogger dataPipelinesLogger;
        Object objPutIfAbsent;
        Intrinsics.checkNotNullParameter(sDKComponent, "<this>");
        SDKComponent sDKComponent2 = sDKComponent;
        ConcurrentHashMap<String, Object> overrides = sDKComponent2.getOverrides();
        String name = DataPipelinesLogger.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Object obj = overrides.get(name);
        if (!(obj instanceof DataPipelinesLogger)) {
            obj = null;
        }
        DataPipelinesLogger dataPipelinesLogger2 = (DataPipelinesLogger) obj;
        if (dataPipelinesLogger2 != null) {
            return dataPipelinesLogger2;
        }
        synchronized (sDKComponent2.getSingletons()) {
            String name2 = DataPipelinesLogger.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = sDKComponent2.getSingletons();
            Object dataPipelinesLogger3 = singletons.get(name2);
            if (dataPipelinesLogger3 == null && (objPutIfAbsent = singletons.putIfAbsent(name2, (dataPipelinesLogger3 = new DataPipelinesLogger(sDKComponent.getLogger())))) != null) {
                dataPipelinesLogger3 = objPutIfAbsent;
            }
            if (dataPipelinesLogger3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.sdk.DataPipelinesLogger");
            }
            dataPipelinesLogger = (DataPipelinesLogger) dataPipelinesLogger3;
        }
        return dataPipelinesLogger;
    }
}
