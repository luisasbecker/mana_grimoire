package io.customer.datapipelines.extensions;

import com.segment.analytics.kotlin.core.Configuration;
import com.segment.analytics.kotlin.core.EventsKt;
import com.segment.analytics.kotlin.core.Settings;
import io.customer.datapipelines.config.DataPipelinesModuleConfig;
import io.customer.datapipelines.plugins.CustomerIODestinationKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* JADX INFO: compiled from: AnalyticsExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\u001a?\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001j\u0004\u0018\u0001`\tH\u0000¨\u0006\n"}, d2 = {"updateAnalyticsConfig", "Lkotlin/Function1;", "Lcom/segment/analytics/kotlin/core/Configuration;", "", "Lkotlin/ExtensionFunctionType;", "moduleConfig", "Lio/customer/datapipelines/config/DataPipelinesModuleConfig;", "errorHandler", "", "Lcom/segment/analytics/kotlin/core/ErrorHandler;", "datapipelines_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsExtKt {
    public static final Function1<Configuration, Unit> updateAnalyticsConfig(final DataPipelinesModuleConfig moduleConfig, final Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(moduleConfig, "moduleConfig");
        return new Function1() { // from class: io.customer.datapipelines.extensions.AnalyticsExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnalyticsExtKt.updateAnalyticsConfig$lambda$2(moduleConfig, function1, (Configuration) obj);
            }
        };
    }

    public static /* synthetic */ Function1 updateAnalyticsConfig$default(DataPipelinesModuleConfig dataPipelinesModuleConfig, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return updateAnalyticsConfig(dataPipelinesModuleConfig, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final Unit updateAnalyticsConfig$lambda$2(DataPipelinesModuleConfig dataPipelinesModuleConfig, Function1 function1, Configuration configuration) {
        Settings settings;
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        configuration.setFlushAt(dataPipelinesModuleConfig.getFlushAt());
        configuration.setFlushInterval(dataPipelinesModuleConfig.getFlushInterval());
        configuration.setFlushPolicies(dataPipelinesModuleConfig.getFlushPolicies());
        configuration.setAutoAddSegmentDestination(false);
        Settings defaultSettings = configuration.getDefaultSettings();
        if (defaultSettings != null) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            jsonObjectBuilder.put(CustomerIODestinationKt.CUSTOMER_IO_DATA_PIPELINES, EventsKt.getEmptyJsonObject());
            Unit unit = Unit.INSTANCE;
            settings = Settings.copy$default(defaultSettings, jsonObjectBuilder.build(), null, null, null, null, null, 62, null);
            if (settings == null) {
                JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
                jsonObjectBuilder2.put(CustomerIODestinationKt.CUSTOMER_IO_DATA_PIPELINES, EventsKt.getEmptyJsonObject());
                settings = new Settings(jsonObjectBuilder2.build(), (JsonObject) null, (JsonObject) null, (JsonObject) null, (JsonObject) null, (JsonObject) null, 62, (DefaultConstructorMarker) null);
            }
        }
        configuration.setDefaultSettings(settings);
        configuration.setTrackApplicationLifecycleEvents(dataPipelinesModuleConfig.getTrackApplicationLifecycleEvents());
        configuration.setApiHost(dataPipelinesModuleConfig.getApiHost());
        configuration.setCdnHost(dataPipelinesModuleConfig.getCdnHost());
        configuration.setErrorHandler(function1);
        return Unit.INSTANCE;
    }
}
