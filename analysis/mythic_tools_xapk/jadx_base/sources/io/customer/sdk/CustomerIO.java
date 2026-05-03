package io.customer.sdk;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.segment.analytics.kotlin.android.AndroidAnalyticsKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.BaseEvent;
import com.segment.analytics.kotlin.core.Configuration;
import com.segment.analytics.kotlin.core.EventsKt;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LogKind;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LogMessage;
import com.segment.analytics.kotlin.core.utilities.AnySerializerKt;
import com.segment.analytics.kotlin.core.utilities.EventTransformer;
import io.customer.base.internal.InternalCustomerIOApi;
import io.customer.datapipelines.config.DataPipelinesModuleConfig;
import io.customer.datapipelines.di.SDKComponentExtKt;
import io.customer.datapipelines.extensions.AnalyticsExtKt;
import io.customer.datapipelines.extensions.JsonExtensionsKt;
import io.customer.datapipelines.extensions.TrackMetricExtKt;
import io.customer.datapipelines.migration.TrackingMigrationProcessor;
import io.customer.datapipelines.plugins.ApplicationLifecyclePlugin;
import io.customer.datapipelines.plugins.AutoTrackDeviceAttributesPlugin;
import io.customer.datapipelines.plugins.AutomaticActivityScreenTrackingPlugin;
import io.customer.datapipelines.plugins.AutomaticApplicationLifecycleTrackingPlugin;
import io.customer.datapipelines.plugins.ContextPlugin;
import io.customer.datapipelines.plugins.CustomerIODestination;
import io.customer.datapipelines.plugins.IdentifyContextPlugin;
import io.customer.datapipelines.plugins.ScreenFilterPlugin;
import io.customer.sdk.communication.Event;
import io.customer.sdk.communication.EventBus;
import io.customer.sdk.core.di.AndroidSDKComponent;
import io.customer.sdk.core.di.SDKComponent;
import io.customer.sdk.core.module.CustomerIOModule;
import io.customer.sdk.core.module.CustomerIOModuleConfig;
import io.customer.sdk.core.pipeline.DataPipeline;
import io.customer.sdk.core.pipeline.IdentifyHookRegistryKt;
import io.customer.sdk.core.util.CioLogLevel;
import io.customer.sdk.core.util.Logger;
import io.customer.sdk.data.model.Settings;
import io.customer.sdk.data.store.DeviceStore;
import io.customer.sdk.data.store.GlobalPreferenceStore;
import io.customer.sdk.events.TrackMetric;
import io.customer.sdk.util.EventNames;
import io.customer.tracking.migration.MigrationProcessor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: CustomerIO.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002#&\u0018\u0000 k2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001kB%\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020.H\u0016J \u0010=\u001a\u00020.2\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020403j\u0002`5H\u0016J1\u0010?\u001a\u00020.\"\u0004\b\u0000\u0010@2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u0002H@2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002H@0DH\u0014¢\u0006\u0002\u0010EJ1\u0010F\u001a\u00020.\"\u0004\b\u0000\u0010G2\u0006\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u0002HG2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HG0DH\u0014¢\u0006\u0002\u0010EJ`\u0010J\u001a\u00020.\"\u0004\b\u0000\u0010G2\u0006\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u0002HG2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HG0D2-\u0010K\u001a)\u0012\u0015\u0012\u0013\u0018\u00010M¢\u0006\f\bN\u0012\b\bH\u0012\u0004\b\b(O\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u00010Lj\u0004\u0018\u0001`PH\u0002¢\u0006\u0002\u0010QJ1\u0010R\u001a\u00020.\"\u0004\b\u0000\u0010G2\u0006\u0010S\u001a\u00020\u000f2\u0006\u0010I\u001a\u0002HG2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HG0DH\u0014¢\u0006\u0002\u0010EJ\b\u0010T\u001a\u00020.H\u0014J \u0010a\u001a\u00020.2\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020403j\u0002`5H\u0016J\u0010\u0010b\u001a\u00020.2\u0006\u0010c\u001a\u00020\u000fH\u0014J,\u0010d\u001a\u00020.2\b\u0010e\u001a\u0004\u0018\u00010\u000f2\u0018\b\u0002\u0010f\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020403j\u0002`5H\u0002J\b\u0010g\u001a\u00020.H\u0014J7\u0010h\u001a\u00020.2-\u0010K\u001a)\u0012\u0015\u0012\u0013\u0018\u00010M¢\u0006\f\bN\u0012\b\bH\u0012\u0004\b\b(O\u0012\u0006\u0012\u0004\u0018\u00010M\u0018\u00010Lj\u0004\u0018\u0001`PH\u0002J\u0010\u0010i\u001a\u00020.2\u0006\u0010O\u001a\u00020jH\u0014R\u0014\u0010\u0007\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0014\u0010(\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000RJ\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020403j\u0002`52\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020403j\u0002`58V@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010U\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0011R\u0014\u0010W\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u0011R\u0016\u0010A\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0011R\u0014\u0010Z\u001a\u00020[8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\\RJ\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020403j\u0002`52\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020403j\u0002`58V@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\b^\u00108\u001a\u0004\b_\u0010:\"\u0004\b`\u0010<¨\u0006l"}, d2 = {"Lio/customer/sdk/CustomerIO;", "Lio/customer/sdk/core/module/CustomerIOModule;", "Lio/customer/datapipelines/config/DataPipelinesModuleConfig;", "Lio/customer/sdk/DataPipelineInstance;", "Lio/customer/sdk/core/pipeline/DataPipeline;", "androidSDKComponent", "Lio/customer/sdk/core/di/AndroidSDKComponent;", "moduleConfig", "overrideAnalytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "<init>", "(Lio/customer/sdk/core/di/AndroidSDKComponent;Lio/customer/datapipelines/config/DataPipelinesModuleConfig;Lcom/segment/analytics/kotlin/core/Analytics;)V", "getModuleConfig", "()Lio/customer/datapipelines/config/DataPipelinesModuleConfig;", "moduleName", "", "getModuleName", "()Ljava/lang/String;", "logger", "Lio/customer/sdk/core/util/Logger;", "dataPipelinesLogger", "Lio/customer/sdk/DataPipelinesLogger;", "globalPreferenceStore", "Lio/customer/sdk/data/store/GlobalPreferenceStore;", "deviceStore", "Lio/customer/sdk/data/store/DeviceStore;", "eventBus", "Lio/customer/sdk/communication/EventBus;", "migrationProcessor", "Lio/customer/tracking/migration/MigrationProcessor;", "getMigrationProcessor$datapipelines_release", "()Lio/customer/tracking/migration/MigrationProcessor;", "setMigrationProcessor$datapipelines_release", "(Lio/customer/tracking/migration/MigrationProcessor;)V", "errorLogger", "io/customer/sdk/CustomerIO$errorLogger$1", "Lio/customer/sdk/CustomerIO$errorLogger$1;", "segmentLogger", "io/customer/sdk/CustomerIO$segmentLogger$1", "Lio/customer/sdk/CustomerIO$segmentLogger$1;", "analytics", "getAnalytics$datapipelines_release", "()Lcom/segment/analytics/kotlin/core/Analytics;", "contextPlugin", "Lio/customer/datapipelines/plugins/ContextPlugin;", "postUserIdentificationEvents", "", "subscribeToJourneyEvents", "migrateTrackingEvents", "initialize", "value", "", "", "Lio/customer/sdk/data/model/CustomAttributes;", "profileAttributes", "getProfileAttributes$annotations", "()V", "getProfileAttributes", "()Ljava/util/Map;", "setProfileAttributesDeprecated", "(Ljava/util/Map;)V", "setProfileAttributes", "attributes", "identifyImpl", "Traits", "userId", "traits", "serializationStrategy", "Lkotlinx/serialization/SerializationStrategy;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)V", "trackImpl", ExifInterface.GPS_DIRECTION_TRUE, "name", DiagnosticsEntry.PROPERTIES_KEY, "track", "enrichment", "Lkotlin/Function1;", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "Lkotlin/ParameterName;", NotificationCompat.CATEGORY_EVENT, "Lcom/segment/analytics/kotlin/core/platform/EnrichmentClosure;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;Lkotlin/jvm/functions/Function1;)V", "screenImpl", Constants.GP_IAP_TITLE, "clearIdentifyImpl", "registeredDeviceToken", "getRegisteredDeviceToken", "anonymousId", "getAnonymousId", "getUserId", "isUserIdentified", "", "()Z", "deviceAttributes", "getDeviceAttributes$annotations", "getDeviceAttributes", "setDeviceAttributesDeprecated", "setDeviceAttributes", "registerDeviceTokenImpl", "deviceToken", "trackDeviceAttributes", "token", "customAddedAttributes", "deleteDeviceTokenImpl", "deleteDeviceToken", "trackMetricImpl", "Lio/customer/sdk/events/TrackMetric;", "Companion", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomerIO extends DataPipelineInstance implements CustomerIOModule<DataPipelinesModuleConfig>, DataPipeline {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String MODULE_NAME = "DataPipelines";
    private static volatile CustomerIO instance;
    private final Analytics analytics;
    private final ContextPlugin contextPlugin;
    private final DataPipelinesLogger dataPipelinesLogger;
    private final DeviceStore deviceStore;
    private final CustomerIO$errorLogger$1 errorLogger;
    private final EventBus eventBus;
    private final GlobalPreferenceStore globalPreferenceStore;
    private final Logger logger;
    private MigrationProcessor migrationProcessor;
    private final DataPipelinesModuleConfig moduleConfig;
    private final String moduleName;
    private final CustomerIO$segmentLogger$1 segmentLogger;

    /* JADX INFO: compiled from: CustomerIO.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\b\u0010\u0011\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/customer/sdk/CustomerIO$Companion;", "", "<init>", "()V", "MODULE_NAME", "", "instance", "Lio/customer/sdk/CustomerIO;", "initialize", "", "config", "Lio/customer/sdk/CustomerIOConfig;", "createInstance", "androidSDKComponent", "Lio/customer/sdk/core/di/AndroidSDKComponent;", "moduleConfig", "Lio/customer/datapipelines/config/DataPipelinesModuleConfig;", "clearInstance", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @InternalCustomerIOApi
        private final synchronized CustomerIO createInstance(AndroidSDKComponent androidSDKComponent, DataPipelinesModuleConfig moduleConfig) {
            DataPipelinesLogger dataPipelinesLogger = SDKComponentExtKt.getDataPipelinesLogger(SDKComponent.INSTANCE);
            CustomerIO customerIO = CustomerIO.instance;
            if (customerIO != null) {
                dataPipelinesLogger.coreSdkAlreadyInitialized();
                return customerIO;
            }
            Function1<DataPipelinesModuleConfig, Analytics> analyticsFactory = SDKComponentExtKt.getAnalyticsFactory(SDKComponent.INSTANCE);
            CustomerIO customerIO2 = new CustomerIO(androidSDKComponent, moduleConfig, analyticsFactory != null ? analyticsFactory.invoke(moduleConfig) : null, null);
            Companion companion = CustomerIO.INSTANCE;
            CustomerIO.instance = customerIO2;
            return customerIO2;
        }

        @InternalCustomerIOApi
        public final void clearInstance() {
            SDKComponent.INSTANCE.reset();
            CustomerIO.instance = null;
        }

        @JvmStatic
        public final void initialize(CustomerIOConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            AndroidSDKComponent androidSDKComponentAndroid = SDKComponent.INSTANCE.android();
            Map<String, CustomerIOModule<? extends CustomerIOModuleConfig>> modules = SDKComponent.INSTANCE.getModules();
            DataPipelinesLogger dataPipelinesLogger = SDKComponentExtKt.getDataPipelinesLogger(SDKComponent.INSTANCE);
            SDKComponent.INSTANCE.getLogger().setLogLevel(config.getLogLevel$datapipelines_release());
            dataPipelinesLogger.coreSdkInitStart();
            modules.put(CustomerIO.MODULE_NAME, createInstance(androidSDKComponentAndroid, new DataPipelinesModuleConfig(config.getCdpApiKey$datapipelines_release(), config.getRegion$datapipelines_release(), config.getApiHost$datapipelines_release(), config.getCdnHost$datapipelines_release(), config.getFlushAt$datapipelines_release(), config.getFlushInterval$datapipelines_release(), config.getFlushPolicies$datapipelines_release(), config.getAutoAddCustomerIODestination$datapipelines_release(), config.getTrackApplicationLifecycleEvents$datapipelines_release(), config.getAutoTrackDeviceAttributes$datapipelines_release(), config.getAutoTrackActivityScreens$datapipelines_release(), config.getMigrationSiteId$datapipelines_release(), config.getScreenViewUse$datapipelines_release())));
            List<CustomerIOModule<? extends CustomerIOModuleConfig>> modules$datapipelines_release = config.getModules$datapipelines_release();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(modules$datapipelines_release, 10)), 16));
            for (Object obj : modules$datapipelines_release) {
                linkedHashMap.put(((CustomerIOModule) obj).getModuleName(), obj);
            }
            modules.putAll(linkedHashMap);
            Iterator<Map.Entry<String, CustomerIOModule<? extends CustomerIOModuleConfig>>> it = modules.entrySet().iterator();
            while (it.hasNext()) {
                CustomerIOModule<? extends CustomerIOModuleConfig> value = it.next().getValue();
                dataPipelinesLogger.moduleInitStart(value);
                value.initialize();
                dataPipelinesLogger.moduleInitSuccess(value);
            }
            dataPipelinesLogger.coreSdkInitSuccess();
        }

        @JvmStatic
        public final CustomerIO instance() {
            CustomerIO customerIO = CustomerIO.instance;
            if (customerIO != null) {
                return customerIO;
            }
            throw new IllegalStateException("CustomerIO is not initialized. CustomerIO.initialize() must be called before obtaining SDK instance.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [io.customer.sdk.CustomerIO$errorLogger$1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [io.customer.sdk.CustomerIO$segmentLogger$1] */
    private CustomerIO(AndroidSDKComponent androidSDKComponent, DataPipelinesModuleConfig dataPipelinesModuleConfig, Analytics analytics) {
        Object objPutIfAbsent;
        this.moduleConfig = dataPipelinesModuleConfig;
        this.moduleName = MODULE_NAME;
        Logger logger = SDKComponent.INSTANCE.getLogger();
        this.logger = logger;
        this.dataPipelinesLogger = SDKComponentExtKt.getDataPipelinesLogger(SDKComponent.INSTANCE);
        this.globalPreferenceStore = androidSDKComponent.getGlobalPreferenceStore();
        DeviceStore deviceStore = androidSDKComponent.getDeviceStore();
        this.deviceStore = deviceStore;
        this.eventBus = SDKComponent.INSTANCE.getEventBus();
        ?? r1 = new Function1<Throwable, Unit>() { // from class: io.customer.sdk.CustomerIO$errorLogger$1
            private final Logger logger = SDKComponent.INSTANCE.getLogger();

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public void invoke2(Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Logger logger2 = this.logger;
                String message = error.getMessage();
                if (message == null) {
                    message = ExceptionsKt.stackTraceToString(error);
                }
                Logger.DefaultImpls.error$default(logger2, message, null, null, 6, null);
            }
        };
        this.errorLogger = r1;
        ?? r2 = new com.segment.analytics.kotlin.core.platform.plugins.logger.Logger() { // from class: io.customer.sdk.CustomerIO$segmentLogger$1
            private final Logger logger = SDKComponent.INSTANCE.getLogger();

            /* JADX INFO: compiled from: CustomerIO.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LogKind.values().length];
                    try {
                        iArr[LogKind.ERROR.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LogKind.WARNING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[LogKind.DEBUG.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.segment.analytics.kotlin.core.platform.plugins.logger.Logger
            public void parseLog(LogMessage log) {
                Intrinsics.checkNotNullParameter(log, "log");
                String message = log.getMessage();
                int i = WhenMappings.$EnumSwitchMapping$0[log.getKind().ordinal()];
                if (i == 1) {
                    Logger.DefaultImpls.error$default(this.logger, message, null, null, 6, null);
                } else if (i == 2) {
                    Logger.DefaultImpls.info$default(this.logger, message, null, 2, null);
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Logger.DefaultImpls.debug$default(this.logger, message, null, 2, null);
                }
            }
        };
        this.segmentLogger = r2;
        analytics = analytics == null ? AndroidAnalyticsKt.Analytics(getModuleConfig().getCdpApiKey(), androidSDKComponent.getApplicationContext(), AnalyticsExtKt.updateAnalyticsConfig(getModuleConfig(), (Function1) r1)) : analytics;
        this.analytics = analytics;
        ContextPlugin contextPlugin = new ContextPlugin(deviceStore, null, 2, 0 == true ? 1 : 0);
        this.contextPlugin = contextPlugin;
        Analytics.INSTANCE.setDebugLogsEnabled(logger.getLogLevel() == CioLogLevel.DEBUG);
        Analytics.INSTANCE.setLogger((com.segment.analytics.kotlin.core.platform.plugins.logger.Logger) r2);
        analytics.add(contextPlugin);
        if (getModuleConfig().getAutoAddCustomerIODestination()) {
            analytics.add(new CustomerIODestination());
        }
        if (getModuleConfig().getAutoTrackDeviceAttributes()) {
            analytics.add(new AutoTrackDeviceAttributesPlugin());
        }
        analytics.add(new ScreenFilterPlugin(getModuleConfig().getScreenViewUse()));
        analytics.add(new IdentifyContextPlugin(IdentifyHookRegistryKt.getIdentifyHookRegistry(SDKComponent.INSTANCE), logger));
        analytics.add(new ApplicationLifecyclePlugin());
        SDKComponent sDKComponent = SDKComponent.INSTANCE;
        synchronized (sDKComponent.getSingletons()) {
            String name = DataPipeline.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            ConcurrentHashMap<String, Object> singletons = sDKComponent.getSingletons();
            CustomerIO customerIO = singletons.get(name);
            if (customerIO == null && (objPutIfAbsent = singletons.putIfAbsent(name, (customerIO = this))) != null) {
                customerIO = objPutIfAbsent;
            }
            if (customerIO == null) {
                throw new NullPointerException("null cannot be cast to non-null type io.customer.sdk.core.pipeline.DataPipeline");
            }
        }
        subscribeToJourneyEvents();
        postUserIdentificationEvents();
    }

    /* synthetic */ CustomerIO(AndroidSDKComponent androidSDKComponent, DataPipelinesModuleConfig dataPipelinesModuleConfig, Analytics analytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidSDKComponent, dataPipelinesModuleConfig, (i & 4) != 0 ? null : analytics);
    }

    public /* synthetic */ CustomerIO(AndroidSDKComponent androidSDKComponent, DataPipelinesModuleConfig dataPipelinesModuleConfig, Analytics analytics, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidSDKComponent, dataPipelinesModuleConfig, analytics);
    }

    static final BaseEvent clearIdentifyImpl$lambda$10(String str, BaseEvent baseEvent) {
        if (baseEvent == null) {
            return null;
        }
        baseEvent.setUserId(String.valueOf(str));
        return baseEvent;
    }

    private final void deleteDeviceToken(Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Logger.DefaultImpls.info$default(this.logger, "deleting device token", null, 2, null);
        String deviceToken$datapipelines_release = this.contextPlugin.getDeviceToken();
        if (deviceToken$datapipelines_release == null || StringsKt.isBlank(deviceToken$datapipelines_release)) {
            Logger.DefaultImpls.debug$default(this.logger, "No device token found to delete.", null, 2, null);
            return;
        }
        JsonObject emptyJsonObject = EventsKt.getEmptyJsonObject();
        AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        track(EventNames.DEVICE_DELETE, emptyJsonObject, JsonObject.INSTANCE.serializer(), enrichment);
    }

    @Deprecated(message = "Use setDeviceAttributes() function instead")
    public static /* synthetic */ void getDeviceAttributes$annotations() {
    }

    @Deprecated(message = "Use setProfileAttributes() function instead")
    public static /* synthetic */ void getProfileAttributes$annotations() {
    }

    static final BaseEvent identifyImpl$lambda$8(String str, BaseEvent baseEvent) {
        if (baseEvent == null) {
            return null;
        }
        if (str != null) {
            baseEvent.setUserId(str);
        }
        return baseEvent;
    }

    @JvmStatic
    public static final void initialize(CustomerIOConfig customerIOConfig) {
        INSTANCE.initialize(customerIOConfig);
    }

    @JvmStatic
    public static final CustomerIO instance() {
        return INSTANCE.instance();
    }

    private final void migrateTrackingEvents() {
        String migrationSiteId = getModuleConfig().getMigrationSiteId();
        String str = migrationSiteId;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        Logger.DefaultImpls.info$default(this.logger, "Migration site id found, migrating data from previous version.", null, 2, null);
        this.migrationProcessor = new TrackingMigrationProcessor(this.analytics, migrationSiteId);
    }

    private final void postUserIdentificationEvents() {
        this.eventBus.publish(new Event.UserChangedEvent(this.analytics.userId(), this.analytics.anonymousId()));
    }

    private final void subscribeToJourneyEvents() {
        this.eventBus.subscribe(Reflection.getOrCreateKotlinClass(Event.TrackPushMetricEvent.class), new CustomerIO$subscribeToJourneyEvents$$inlined$subscribe$1(new Function1() { // from class: io.customer.sdk.CustomerIO$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomerIO.subscribeToJourneyEvents$lambda$1(this.f$0, (Event.TrackPushMetricEvent) obj);
            }
        }));
        this.eventBus.subscribe(Reflection.getOrCreateKotlinClass(Event.TrackInAppMetricEvent.class), new CustomerIO$subscribeToJourneyEvents$$inlined$subscribe$2(new Function1() { // from class: io.customer.sdk.CustomerIO$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomerIO.subscribeToJourneyEvents$lambda$2(this.f$0, (Event.TrackInAppMetricEvent) obj);
            }
        }));
        this.eventBus.subscribe(Reflection.getOrCreateKotlinClass(Event.RegisterDeviceTokenEvent.class), new CustomerIO$subscribeToJourneyEvents$$inlined$subscribe$3(new Function1() { // from class: io.customer.sdk.CustomerIO$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomerIO.subscribeToJourneyEvents$lambda$3(this.f$0, (Event.RegisterDeviceTokenEvent) obj);
            }
        }));
    }

    static final Unit subscribeToJourneyEvents$lambda$1(CustomerIO customerIO, Event.TrackPushMetricEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        customerIO.trackMetric(new TrackMetric.Push(it.getEvent(), it.getDeliveryId(), it.getDeviceToken()));
        return Unit.INSTANCE;
    }

    static final Unit subscribeToJourneyEvents$lambda$2(CustomerIO customerIO, Event.TrackInAppMetricEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        customerIO.trackMetric(new TrackMetric.InApp(it.getEvent(), it.getDeliveryID(), it.getParams()));
        return Unit.INSTANCE;
    }

    static final Unit subscribeToJourneyEvents$lambda$3(CustomerIO customerIO, Event.RegisterDeviceTokenEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        customerIO.registerDeviceToken(it.getToken());
        return Unit.INSTANCE;
    }

    private final <T> void track(String name, T properties, SerializationStrategy<? super T> serializationStrategy, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Logger.DefaultImpls.debug$default(this.logger, "track an event with name " + name + " and attributes " + properties, null, 2, null);
        this.analytics.track(name, properties, serializationStrategy, enrichment);
    }

    private final void trackDeviceAttributes(String token, Map<String, ? extends Object> customAddedAttributes) {
        String str = token;
        if (str == null || StringsKt.isBlank(str)) {
            this.dataPipelinesLogger.logTrackingDevicesAttributesWithoutValidToken();
            return;
        }
        final String deviceToken$datapipelines_release = this.contextPlugin.getDeviceToken();
        if (deviceToken$datapipelines_release != null && !Intrinsics.areEqual(deviceToken$datapipelines_release, token)) {
            this.dataPipelinesLogger.logPushTokenRefreshed();
            deleteDeviceToken(new Function1() { // from class: io.customer.sdk.CustomerIO$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CustomerIO.trackDeviceAttributes$lambda$11(deviceToken$datapipelines_release, (BaseEvent) obj);
                }
            });
        }
        if (getModuleConfig().getAutoTrackDeviceAttributes()) {
            customAddedAttributes = MapsKt.plus(this.deviceStore.buildDeviceAttributes(), customAddedAttributes);
        }
        this.contextPlugin.setDeviceToken$datapipelines_release(token);
        Logger.DefaultImpls.info$default(this.logger, "updating device attributes: " + customAddedAttributes, null, 2, null);
        track(EventNames.DEVICE_UPDATE, customAddedAttributes);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void trackDeviceAttributes$default(CustomerIO customerIO, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        customerIO.trackDeviceAttributes(str, map);
    }

    static final BaseEvent trackDeviceAttributes$lambda$11(String str, BaseEvent baseEvent) {
        if (baseEvent == null) {
            return null;
        }
        Json.INSTANCE.getSerializersModule();
        return EventTransformer.putInContextUnderKey(baseEvent, AndroidContextPlugin.DEVICE_KEY, "token", str, StringSerializer.INSTANCE);
    }

    @Override // io.customer.sdk.DataPipelineInstance
    protected void clearIdentifyImpl() {
        Logger.DefaultImpls.info$default(this.logger, "resetting user profile with id " + getUserId(), null, 2, null);
        Logger.DefaultImpls.debug$default(this.logger, "deleting device token to remove device from user profile", null, 2, null);
        final String userId = getUserId();
        deleteDeviceToken(new Function1() { // from class: io.customer.sdk.CustomerIO$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CustomerIO.clearIdentifyImpl$lambda$10(userId, (BaseEvent) obj);
            }
        });
        Logger.DefaultImpls.debug$default(this.logger, "resetting user profile", null, 2, null);
        this.eventBus.publish(Event.ResetEvent.INSTANCE);
        this.analytics.reset();
        this.eventBus.publish(new Event.UserChangedEvent(null, this.analytics.anonymousId()));
    }

    @Override // io.customer.sdk.DataPipelineInstance
    protected void deleteDeviceTokenImpl() {
        deleteDeviceToken(null);
    }

    /* JADX INFO: renamed from: getAnalytics$datapipelines_release, reason: from getter */
    public final Analytics getAnalytics() {
        return this.analytics;
    }

    @Override // io.customer.sdk.DataPipelineInstance
    public String getAnonymousId() {
        return this.analytics.anonymousId();
    }

    @Override // io.customer.sdk.DataPipelineInstance
    public Map<String, Object> getDeviceAttributes() {
        return MapsKt.emptyMap();
    }

    /* JADX INFO: renamed from: getMigrationProcessor$datapipelines_release, reason: from getter */
    public final MigrationProcessor getMigrationProcessor() {
        return this.migrationProcessor;
    }

    @Override // io.customer.sdk.core.module.CustomerIOModule
    public DataPipelinesModuleConfig getModuleConfig() {
        return this.moduleConfig;
    }

    @Override // io.customer.sdk.core.module.CustomerIOModule
    public String getModuleName() {
        return this.moduleName;
    }

    @Override // io.customer.sdk.DataPipelineInstance
    public Map<String, Object> getProfileAttributes() {
        JsonObject jsonObjectTraits = this.analytics.traits();
        return jsonObjectTraits != null ? jsonObjectTraits : MapsKt.emptyMap();
    }

    @Override // io.customer.sdk.DataPipelineInstance
    public String getRegisteredDeviceToken() {
        return this.globalPreferenceStore.getDeviceToken();
    }

    @Override // io.customer.sdk.DataPipelineInstance
    public String getUserId() {
        return this.analytics.userId();
    }

    @Override // io.customer.sdk.DataPipelineInstance
    protected <Traits> void identifyImpl(String userId, Traits traits, SerializationStrategy<? super Traits> serializationStrategy) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        if (StringsKt.isBlank(userId)) {
            Logger.DefaultImpls.debug$default(this.logger, "Profile cannot be identified: Identifier is blank. Please retry with a valid, non-empty identifier.", null, 2, null);
            return;
        }
        final String userId2 = getUserId();
        String str = userId2;
        if (str == null || StringsKt.isBlank(str)) {
            userId2 = null;
        }
        boolean z = (userId2 == null || Intrinsics.areEqual(userId2, userId)) ? false : true;
        boolean z2 = userId2 == null;
        if (z) {
            Logger.DefaultImpls.info$default(this.logger, "changing profile from id " + userId2 + " to " + userId, null, 2, null);
            if (getRegisteredDeviceToken() != null) {
                this.dataPipelinesLogger.logDeletingTokenDueToNewProfileIdentification();
                deleteDeviceToken(new Function1() { // from class: io.customer.sdk.CustomerIO$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomerIO.identifyImpl$lambda$8(userId2, (BaseEvent) obj);
                    }
                });
            }
        }
        Logger.DefaultImpls.info$default(this.logger, "identify profile with identifier " + userId + " and traits " + traits, null, 2, null);
        Analytics.identify$default(this.analytics, userId, traits, serializationStrategy, null, 8, null);
        this.eventBus.publish(new Event.UserChangedEvent(userId, this.analytics.anonymousId()));
        if (z2 || z) {
            Logger.DefaultImpls.debug$default(this.logger, "first time identified or changing identified profile", null, 2, null);
            String registeredDeviceToken = getRegisteredDeviceToken();
            if (registeredDeviceToken != null) {
                this.dataPipelinesLogger.automaticTokenRegistrationForNewProfile(registeredDeviceToken, userId);
                trackDeviceAttributes$default(this, registeredDeviceToken, null, 2, null);
            }
        }
    }

    @Override // io.customer.sdk.core.module.CustomerIOModule
    public void initialize() {
        Logger.DefaultImpls.debug$default(this.logger, "CustomerIO SDK initialized with DataPipelines module.", null, 2, null);
        migrateTrackingEvents();
        Configuration configuration = this.analytics.getConfiguration();
        this.globalPreferenceStore.saveSettings(new Settings(configuration.getWriteKey(), configuration.getApiHost()));
        if (getModuleConfig().getAutoTrackActivityScreens()) {
            this.analytics.add(new AutomaticActivityScreenTrackingPlugin());
        }
        if (getModuleConfig().getTrackApplicationLifecycleEvents()) {
            this.analytics.add(new AutomaticApplicationLifecycleTrackingPlugin());
        }
    }

    @Override // io.customer.sdk.core.pipeline.DataPipeline
    public boolean isUserIdentified() {
        String strUserId = this.analytics.userId();
        return !(strUserId == null || strUserId.length() == 0);
    }

    @Override // io.customer.sdk.DataPipelineInstance
    protected void registerDeviceTokenImpl(String deviceToken) {
        Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
        boolean zIsBlank = StringsKt.isBlank(deviceToken);
        DataPipelinesLogger dataPipelinesLogger = this.dataPipelinesLogger;
        if (zIsBlank) {
            dataPipelinesLogger.logStoringBlankPushToken();
            return;
        }
        dataPipelinesLogger.logStoringDevicePushToken(deviceToken, getUserId());
        this.globalPreferenceStore.saveDeviceToken(deviceToken);
        this.dataPipelinesLogger.logRegisteringPushToken(deviceToken, getUserId());
        trackDeviceAttributes$default(this, deviceToken, null, 2, null);
    }

    @Override // io.customer.sdk.DataPipelineInstance
    protected <T> void screenImpl(String title, T properties, SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        Logger.DefaultImpls.debug$default(this.logger, "track a screen with title " + title + ", properties " + properties, null, 2, null);
        this.eventBus.publish(new Event.ScreenViewedEvent(title));
        Analytics.screen$default(this.analytics, title, properties, serializationStrategy, null, null, 24, null);
    }

    @Override // io.customer.sdk.DataPipelineInstance
    public void setDeviceAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        trackDeviceAttributes(getRegisteredDeviceToken(), attributes);
    }

    public void setDeviceAttributesDeprecated(Map<String, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setDeviceAttributes(value);
    }

    public final void setMigrationProcessor$datapipelines_release(MigrationProcessor migrationProcessor) {
        this.migrationProcessor = migrationProcessor;
    }

    @Override // io.customer.sdk.DataPipelineInstance
    public void setProfileAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        String userId = getUserId();
        if (userId != null) {
            identify(userId, attributes);
            return;
        }
        Logger.DefaultImpls.debug$default(this.logger, "No user profile found, updating sanitized traits for anonymous user " + this.analytics.anonymousId(), null, 2, null);
        this.analytics.identify(JsonExtensionsKt.sanitizeForJson$default(attributes, null, 1, null), new LinkedHashMapSerializer(StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(SerializersKt.noCompiledSerializer(AnySerializerKt.getJsonAnySerializer().getSerializersModule(), Reflection.getOrCreateKotlinClass(Object.class)))), (Function1<? super BaseEvent, ? extends BaseEvent>) null);
    }

    public void setProfileAttributesDeprecated(Map<String, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setProfileAttributes(value);
    }

    @Override // io.customer.sdk.DataPipelineInstance
    protected <T> void trackImpl(String name, T properties, SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        track(name, properties, serializationStrategy, null);
    }

    @Override // io.customer.sdk.DataPipelineInstance
    protected void trackMetricImpl(TrackMetric event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Logger.DefaultImpls.info$default(this.logger, TrackMetricExtKt.getType(event) + " metric received for " + event.getMetric() + " event", null, 2, null);
        Logger.DefaultImpls.debug$default(this.logger, "tracking " + TrackMetricExtKt.getType(event) + " metric event with properties " + event, null, 2, null);
        track(EventNames.METRIC_DELIVERY, TrackMetricExtKt.asMap(event));
    }
}
