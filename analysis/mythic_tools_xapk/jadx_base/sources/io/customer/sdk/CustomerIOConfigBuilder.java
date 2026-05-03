package io.customer.sdk;

import android.app.Application;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.core.platform.policies.FlushPolicy;
import io.customer.datapipelines.config.ScreenView;
import io.customer.sdk.core.di.SDKComponent;
import io.customer.sdk.core.di.SDKComponentExtKt;
import io.customer.sdk.core.module.CustomerIOModule;
import io.customer.sdk.core.module.CustomerIOModuleConfig;
import io.customer.sdk.core.util.CioLogLevel;
import io.customer.sdk.data.model.Region;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerIOConfigBuilder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0013J\u0014\u0010\u0017\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00002\u0006\u00100\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u001cJ\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0005J\u000e\u0010&\u001a\u00020\u00002\u0006\u00101\u001a\u00020'J\u001e\u00102\u001a\u00020\u0000\"\b\b\u0000\u00103*\u00020,2\f\u00104\u001a\b\u0012\u0004\u0012\u0002H30+J\u0006\u00105\u001a\u000206R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\b\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0004\n\u0002\b\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\b\u000fR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\b\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\b\u0014R\u0010\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\b\u0016R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\b\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\b\u001dR\u0010\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\b\u001fR\u0010\u0010 \u001a\u00020\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\b!R\u0010\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\b#R\u0012\u0010$\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\b%R\u0010\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0004\n\u0002\b(R\u001e\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020,0+0*X\u0082\u0004¢\u0006\u0004\n\u0002\b-¨\u00068"}, d2 = {"Lio/customer/sdk/CustomerIOConfigBuilder;", "", "applicationContext", "Landroid/app/Application;", "cdpApiKey", "", "<init>", "(Landroid/app/Application;Ljava/lang/String;)V", "logLevel", "Lio/customer/sdk/core/util/CioLogLevel;", "logLevel$1", "region", "Lio/customer/sdk/data/model/Region;", "region$1", "apiHost", "apiHost$1", "cdnHost", "cdnHost$1", "flushAt", "", "flushAt$1", "flushInterval", "flushInterval$1", "flushPolicies", "", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "flushPolicies$1", "autoAddCustomerIODestination", "", "autoAddCustomerIODestination$1", "trackApplicationLifecycleEvents", "trackApplicationLifecycleEvents$1", "autoTrackDeviceAttributes", "autoTrackDeviceAttributes$1", "autoTrackActivityScreens", "autoTrackActivityScreens$1", "migrationSiteId", "migrationSiteId$1", "screenViewUse", "Lio/customer/datapipelines/config/ScreenView;", "screenViewUse$1", "modules", "", "Lio/customer/sdk/core/module/CustomerIOModule;", "Lio/customer/sdk/core/module/CustomerIOModuleConfig;", "modules$1", FirebaseAnalytics.Param.LEVEL, "autoAdd", "track", "screenView", "addCustomerIOModule", "Config", "module", "build", "Lio/customer/sdk/CustomerIOConfig;", "Defaults", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomerIOConfigBuilder {
    private static final String apiHost = null;
    private static final boolean autoTrackActivityScreens = false;
    private static final String cdnHost = null;
    private static final String migrationSiteId = null;

    /* JADX INFO: renamed from: apiHost$1, reason: from kotlin metadata */
    private String apiHost;
    private final Application applicationContext;

    /* JADX INFO: renamed from: autoAddCustomerIODestination$1, reason: from kotlin metadata */
    private boolean autoAddCustomerIODestination;

    /* JADX INFO: renamed from: autoTrackActivityScreens$1, reason: from kotlin metadata */
    private boolean autoTrackActivityScreens;

    /* JADX INFO: renamed from: autoTrackDeviceAttributes$1, reason: from kotlin metadata */
    private boolean autoTrackDeviceAttributes;

    /* JADX INFO: renamed from: cdnHost$1, reason: from kotlin metadata */
    private String cdnHost;
    private final String cdpApiKey;

    /* JADX INFO: renamed from: flushAt$1, reason: from kotlin metadata */
    private int flushAt;

    /* JADX INFO: renamed from: flushInterval$1, reason: from kotlin metadata */
    private int flushInterval;

    /* JADX INFO: renamed from: flushPolicies$1, reason: from kotlin metadata */
    private List<? extends FlushPolicy> flushPolicies;

    /* JADX INFO: renamed from: logLevel$1, reason: from kotlin metadata */
    private CioLogLevel logLevel;

    /* JADX INFO: renamed from: migrationSiteId$1, reason: from kotlin metadata */
    private String migrationSiteId;

    /* JADX INFO: renamed from: modules$1, reason: from kotlin metadata */
    private final List<CustomerIOModule<? extends CustomerIOModuleConfig>> modules;

    /* JADX INFO: renamed from: region$1, reason: from kotlin metadata */
    private Region region;

    /* JADX INFO: renamed from: screenViewUse$1, reason: from kotlin metadata */
    private ScreenView screenViewUse;

    /* JADX INFO: renamed from: trackApplicationLifecycleEvents$1, reason: from kotlin metadata */
    private boolean trackApplicationLifecycleEvents;

    /* JADX INFO: renamed from: Defaults, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CioLogLevel logLevel = CioLogLevel.INSTANCE.getDEFAULT();
    private static final Region region = Region.US.INSTANCE;
    private static final int flushAt = 20;
    private static final int flushInterval = 30;
    private static final List<FlushPolicy> flushPolicies = CollectionsKt.emptyList();
    private static final boolean autoAddCustomerIODestination = true;
    private static final boolean trackApplicationLifecycleEvents = true;
    private static final boolean autoTrackDeviceAttributes = true;
    private static final ScreenView screenViewUse = ScreenView.All.INSTANCE;
    private static final List<CustomerIOModule<? extends CustomerIOModuleConfig>> modules = CollectionsKt.emptyList();

    /* JADX INFO: renamed from: io.customer.sdk.CustomerIOConfigBuilder$Defaults, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CustomerIOConfigBuilder.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u001eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0014\u0010%\u001a\u00020\u001eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0013\u0010'\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001f\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020/0.0\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001c¨\u00061"}, d2 = {"Lio/customer/sdk/CustomerIOConfigBuilder$Defaults;", "", "<init>", "()V", "logLevel", "Lio/customer/sdk/core/util/CioLogLevel;", "getLogLevel", "()Lio/customer/sdk/core/util/CioLogLevel;", "region", "Lio/customer/sdk/data/model/Region;", "getRegion", "()Lio/customer/sdk/data/model/Region;", "apiHost", "", "getApiHost", "()Ljava/lang/String;", "cdnHost", "getCdnHost", "flushAt", "", "getFlushAt", "()I", "flushInterval", "getFlushInterval", "flushPolicies", "", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "getFlushPolicies", "()Ljava/util/List;", "autoAddCustomerIODestination", "", "getAutoAddCustomerIODestination", "()Z", "trackApplicationLifecycleEvents", "getTrackApplicationLifecycleEvents", "autoTrackDeviceAttributes", "getAutoTrackDeviceAttributes", "autoTrackActivityScreens", "getAutoTrackActivityScreens", "migrationSiteId", "getMigrationSiteId", "screenViewUse", "Lio/customer/datapipelines/config/ScreenView;", "getScreenViewUse", "()Lio/customer/datapipelines/config/ScreenView;", "modules", "Lio/customer/sdk/core/module/CustomerIOModule;", "Lio/customer/sdk/core/module/CustomerIOModuleConfig;", "getModules", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getApiHost() {
            return CustomerIOConfigBuilder.apiHost;
        }

        public final boolean getAutoAddCustomerIODestination() {
            return CustomerIOConfigBuilder.autoAddCustomerIODestination;
        }

        public final boolean getAutoTrackActivityScreens() {
            return CustomerIOConfigBuilder.autoTrackActivityScreens;
        }

        public final boolean getAutoTrackDeviceAttributes() {
            return CustomerIOConfigBuilder.autoTrackDeviceAttributes;
        }

        public final String getCdnHost() {
            return CustomerIOConfigBuilder.cdnHost;
        }

        public final int getFlushAt() {
            return CustomerIOConfigBuilder.flushAt;
        }

        public final int getFlushInterval() {
            return CustomerIOConfigBuilder.flushInterval;
        }

        public final List<FlushPolicy> getFlushPolicies() {
            return CustomerIOConfigBuilder.flushPolicies;
        }

        public final CioLogLevel getLogLevel() {
            return CustomerIOConfigBuilder.logLevel;
        }

        public final String getMigrationSiteId() {
            return CustomerIOConfigBuilder.migrationSiteId;
        }

        public final List<CustomerIOModule<? extends CustomerIOModuleConfig>> getModules() {
            return CustomerIOConfigBuilder.modules;
        }

        public final Region getRegion() {
            return CustomerIOConfigBuilder.region;
        }

        public final ScreenView getScreenViewUse() {
            return CustomerIOConfigBuilder.screenViewUse;
        }

        public final boolean getTrackApplicationLifecycleEvents() {
            return CustomerIOConfigBuilder.trackApplicationLifecycleEvents;
        }
    }

    public CustomerIOConfigBuilder(Application applicationContext, String cdpApiKey) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(cdpApiKey, "cdpApiKey");
        this.applicationContext = applicationContext;
        this.cdpApiKey = cdpApiKey;
        SDKComponentExtKt.setupAndroidComponent(SDKComponent.INSTANCE, applicationContext);
        this.logLevel = logLevel;
        this.region = region;
        this.apiHost = apiHost;
        this.cdnHost = cdnHost;
        this.flushAt = flushAt;
        this.flushInterval = flushInterval;
        this.flushPolicies = flushPolicies;
        this.autoAddCustomerIODestination = autoAddCustomerIODestination;
        this.trackApplicationLifecycleEvents = trackApplicationLifecycleEvents;
        this.autoTrackDeviceAttributes = autoTrackDeviceAttributes;
        this.autoTrackActivityScreens = autoTrackActivityScreens;
        this.migrationSiteId = migrationSiteId;
        this.screenViewUse = screenViewUse;
        this.modules = new ArrayList();
    }

    public final <Config extends CustomerIOModuleConfig> CustomerIOConfigBuilder addCustomerIOModule(CustomerIOModule<Config> module) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.modules.add(module);
        return this;
    }

    public final CustomerIOConfigBuilder apiHost(String apiHost2) {
        Intrinsics.checkNotNullParameter(apiHost2, "apiHost");
        this.apiHost = apiHost2;
        return this;
    }

    public final CustomerIOConfigBuilder autoAddCustomerIODestination(boolean autoAdd) {
        this.autoAddCustomerIODestination = autoAdd;
        return this;
    }

    public final CustomerIOConfigBuilder autoTrackActivityScreens(boolean track) {
        this.autoTrackActivityScreens = track;
        return this;
    }

    public final CustomerIOConfigBuilder autoTrackDeviceAttributes(boolean track) {
        this.autoTrackDeviceAttributes = track;
        return this;
    }

    public final CustomerIOConfig build() {
        return new CustomerIOConfig(this.applicationContext, this.cdpApiKey, this.logLevel, this.region, this.apiHost, this.cdnHost, this.flushAt, this.flushInterval, this.flushPolicies, this.autoAddCustomerIODestination, this.trackApplicationLifecycleEvents, this.autoTrackDeviceAttributes, this.autoTrackActivityScreens, this.migrationSiteId, this.screenViewUse, CollectionsKt.toList(this.modules));
    }

    public final CustomerIOConfigBuilder cdnHost(String cdnHost2) {
        Intrinsics.checkNotNullParameter(cdnHost2, "cdnHost");
        this.cdnHost = cdnHost2;
        return this;
    }

    public final CustomerIOConfigBuilder flushAt(int flushAt2) {
        this.flushAt = flushAt2;
        return this;
    }

    public final CustomerIOConfigBuilder flushInterval(int flushInterval2) {
        this.flushInterval = flushInterval2;
        return this;
    }

    public final CustomerIOConfigBuilder flushPolicies(List<? extends FlushPolicy> flushPolicies2) {
        Intrinsics.checkNotNullParameter(flushPolicies2, "flushPolicies");
        this.flushPolicies = flushPolicies2;
        return this;
    }

    public final CustomerIOConfigBuilder logLevel(CioLogLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.logLevel = level;
        return this;
    }

    public final CustomerIOConfigBuilder migrationSiteId(String migrationSiteId2) {
        this.migrationSiteId = migrationSiteId2;
        return this;
    }

    public final CustomerIOConfigBuilder region(Region region2) {
        Intrinsics.checkNotNullParameter(region2, "region");
        this.region = region2;
        return this;
    }

    public final CustomerIOConfigBuilder screenViewUse(ScreenView screenView) {
        Intrinsics.checkNotNullParameter(screenView, "screenView");
        this.screenViewUse = screenView;
        return this;
    }

    public final CustomerIOConfigBuilder trackApplicationLifecycleEvents(boolean track) {
        this.trackApplicationLifecycleEvents = track;
        return this;
    }
}
