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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerIOBuilder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "Use CustomerIOConfigBuilder and CustomerIO.initialize() instead", replaceWith = @ReplaceWith(expression = "CustomerIOConfigBuilder(applicationContext, cdpApiKey).build().let { CustomerIO.initialize(it) }", imports = {"io.customer.sdk.CustomerIOConfigBuilder", "io.customer.sdk.CustomerIO"}))
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013J\u0014\u0010\u0015\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u001fJ\u001e\u0010$\u001a\u00020\u0000\"\b\b\u0000\u0010%*\u00020\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0\nJ\u0006\u0010'\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lio/customer/sdk/CustomerIOBuilder;", "", "applicationContext", "Landroid/app/Application;", "cdpApiKey", "", "<init>", "(Landroid/app/Application;Ljava/lang/String;)V", "registeredModules", "", "Lio/customer/sdk/core/module/CustomerIOModule;", "Lio/customer/sdk/core/module/CustomerIOModuleConfig;", "logLevel", "Lio/customer/sdk/core/util/CioLogLevel;", "region", "Lio/customer/sdk/data/model/Region;", "apiHost", "cdnHost", "flushAt", "", "flushInterval", "flushPolicies", "", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "autoAddCustomerIODestination", "", "trackApplicationLifecycleEvents", "autoTrackDeviceAttributes", "autoTrackActivityScreens", "migrationSiteId", "screenViewUse", "Lio/customer/datapipelines/config/ScreenView;", FirebaseAnalytics.Param.LEVEL, "autoAdd", "track", "screenView", "addCustomerIOModule", "Config", "module", "build", "Lio/customer/sdk/CustomerIO;", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomerIOBuilder {
    private String apiHost;
    private final Application applicationContext;
    private boolean autoAddCustomerIODestination;
    private boolean autoTrackActivityScreens;
    private boolean autoTrackDeviceAttributes;
    private String cdnHost;
    private final String cdpApiKey;
    private int flushAt;
    private int flushInterval;
    private List<? extends FlushPolicy> flushPolicies;
    private CioLogLevel logLevel;
    private String migrationSiteId;
    private Region region;
    private final List<CustomerIOModule<? extends CustomerIOModuleConfig>> registeredModules;
    private ScreenView screenViewUse;
    private boolean trackApplicationLifecycleEvents;

    public CustomerIOBuilder(Application applicationContext, String cdpApiKey) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(cdpApiKey, "cdpApiKey");
        this.applicationContext = applicationContext;
        this.cdpApiKey = cdpApiKey;
        SDKComponentExtKt.setupAndroidComponent(SDKComponent.INSTANCE, applicationContext);
        this.registeredModules = new ArrayList();
        this.logLevel = CustomerIOConfigBuilder.INSTANCE.getLogLevel();
        this.region = CustomerIOConfigBuilder.INSTANCE.getRegion();
        this.apiHost = CustomerIOConfigBuilder.INSTANCE.getApiHost();
        this.cdnHost = CustomerIOConfigBuilder.INSTANCE.getCdnHost();
        this.flushAt = CustomerIOConfigBuilder.INSTANCE.getFlushAt();
        this.flushInterval = CustomerIOConfigBuilder.INSTANCE.getFlushInterval();
        this.flushPolicies = CustomerIOConfigBuilder.INSTANCE.getFlushPolicies();
        this.autoAddCustomerIODestination = CustomerIOConfigBuilder.INSTANCE.getAutoAddCustomerIODestination();
        this.trackApplicationLifecycleEvents = CustomerIOConfigBuilder.INSTANCE.getTrackApplicationLifecycleEvents();
        this.autoTrackDeviceAttributes = CustomerIOConfigBuilder.INSTANCE.getAutoTrackDeviceAttributes();
        this.autoTrackActivityScreens = CustomerIOConfigBuilder.INSTANCE.getAutoTrackActivityScreens();
        this.migrationSiteId = CustomerIOConfigBuilder.INSTANCE.getMigrationSiteId();
        this.screenViewUse = CustomerIOConfigBuilder.INSTANCE.getScreenViewUse();
    }

    public final <Config extends CustomerIOModuleConfig> CustomerIOBuilder addCustomerIOModule(CustomerIOModule<Config> module) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.registeredModules.add(module);
        return this;
    }

    public final CustomerIOBuilder apiHost(String apiHost) {
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        this.apiHost = apiHost;
        return this;
    }

    public final CustomerIOBuilder autoAddCustomerIODestination(boolean autoAdd) {
        this.autoAddCustomerIODestination = autoAdd;
        return this;
    }

    public final CustomerIOBuilder autoTrackActivityScreens(boolean track) {
        this.autoTrackActivityScreens = track;
        return this;
    }

    public final CustomerIOBuilder autoTrackDeviceAttributes(boolean track) {
        this.autoTrackDeviceAttributes = track;
        return this;
    }

    public final CustomerIO build() {
        CustomerIO.INSTANCE.initialize(new CustomerIOConfig(this.applicationContext, this.cdpApiKey, this.logLevel, this.region, this.apiHost, this.cdnHost, this.flushAt, this.flushInterval, this.flushPolicies, this.autoAddCustomerIODestination, this.trackApplicationLifecycleEvents, this.autoTrackDeviceAttributes, this.autoTrackActivityScreens, this.migrationSiteId, this.screenViewUse, CollectionsKt.toList(this.registeredModules)));
        return CustomerIO.INSTANCE.instance();
    }

    public final CustomerIOBuilder cdnHost(String cdnHost) {
        Intrinsics.checkNotNullParameter(cdnHost, "cdnHost");
        this.cdnHost = cdnHost;
        return this;
    }

    public final CustomerIOBuilder flushAt(int flushAt) {
        this.flushAt = flushAt;
        return this;
    }

    public final CustomerIOBuilder flushInterval(int flushInterval) {
        this.flushInterval = flushInterval;
        return this;
    }

    public final CustomerIOBuilder flushPolicies(List<? extends FlushPolicy> flushPolicies) {
        Intrinsics.checkNotNullParameter(flushPolicies, "flushPolicies");
        this.flushPolicies = flushPolicies;
        return this;
    }

    public final CustomerIOBuilder logLevel(CioLogLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.logLevel = level;
        return this;
    }

    public final CustomerIOBuilder migrationSiteId(String migrationSiteId) {
        this.migrationSiteId = migrationSiteId;
        return this;
    }

    public final CustomerIOBuilder region(Region region) {
        Intrinsics.checkNotNullParameter(region, "region");
        this.region = region;
        return this;
    }

    public final CustomerIOBuilder screenViewUse(ScreenView screenView) {
        Intrinsics.checkNotNullParameter(screenView, "screenView");
        this.screenViewUse = screenView;
        return this;
    }

    public final CustomerIOBuilder trackApplicationLifecycleEvents(boolean track) {
        this.trackApplicationLifecycleEvents = track;
        return this;
    }
}
