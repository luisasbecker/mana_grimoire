package io.customer.sdk;

import android.app.Application;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.core.platform.policies.FlushPolicy;
import io.customer.datapipelines.config.ScreenView;
import io.customer.sdk.core.module.CustomerIOModule;
import io.customer.sdk.core.module.CustomerIOModuleConfig;
import io.customer.sdk.core.util.CioLogLevel;
import io.customer.sdk.data.model.Region;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerIOConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b@\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001b0\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u00107\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b8J\u000e\u00109\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b:J\u000e\u0010;\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b<J\u000e\u0010=\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b>J\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b@J\u0010\u0010A\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\bBJ\u000e\u0010C\u001a\u00020\rHÀ\u0003¢\u0006\u0002\bDJ\u000e\u0010E\u001a\u00020\rHÀ\u0003¢\u0006\u0002\bFJ\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÀ\u0003¢\u0006\u0002\bHJ\u000e\u0010I\u001a\u00020\u0013HÀ\u0003¢\u0006\u0002\bJJ\u000e\u0010K\u001a\u00020\u0013HÀ\u0003¢\u0006\u0002\bLJ\u000e\u0010M\u001a\u00020\u0013HÀ\u0003¢\u0006\u0002\bNJ\u000e\u0010O\u001a\u00020\u0013HÀ\u0003¢\u0006\u0002\bPJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\bRJ\u000e\u0010S\u001a\u00020\u0019HÀ\u0003¢\u0006\u0002\bTJ\u001c\u0010U\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001b0\u0010HÀ\u0003¢\u0006\u0002\bVJÃ\u0001\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001b0\u0010HÆ\u0001J\u0013\u0010X\u001a\u00020\u00132\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\rHÖ\u0001J\t\u0010[\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010\u000e\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u0010\u0014\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0014\u0010\u0015\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0014\u0010\u0016\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0014\u0010\u0018\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001b0\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-¨\u0006\\"}, d2 = {"Lio/customer/sdk/CustomerIOConfig;", "", "applicationContext", "Landroid/app/Application;", "cdpApiKey", "", "logLevel", "Lio/customer/sdk/core/util/CioLogLevel;", "region", "Lio/customer/sdk/data/model/Region;", "apiHost", "cdnHost", "flushAt", "", "flushInterval", "flushPolicies", "", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "autoAddCustomerIODestination", "", "trackApplicationLifecycleEvents", "autoTrackDeviceAttributes", "autoTrackActivityScreens", "migrationSiteId", "screenViewUse", "Lio/customer/datapipelines/config/ScreenView;", "modules", "Lio/customer/sdk/core/module/CustomerIOModule;", "Lio/customer/sdk/core/module/CustomerIOModuleConfig;", "<init>", "(Landroid/app/Application;Ljava/lang/String;Lio/customer/sdk/core/util/CioLogLevel;Lio/customer/sdk/data/model/Region;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;ZZZZLjava/lang/String;Lio/customer/datapipelines/config/ScreenView;Ljava/util/List;)V", "getApplicationContext$datapipelines_release", "()Landroid/app/Application;", "getCdpApiKey$datapipelines_release", "()Ljava/lang/String;", "getLogLevel$datapipelines_release", "()Lio/customer/sdk/core/util/CioLogLevel;", "getRegion$datapipelines_release", "()Lio/customer/sdk/data/model/Region;", "getApiHost$datapipelines_release", "getCdnHost$datapipelines_release", "getFlushAt$datapipelines_release", "()I", "getFlushInterval$datapipelines_release", "getFlushPolicies$datapipelines_release", "()Ljava/util/List;", "getAutoAddCustomerIODestination$datapipelines_release", "()Z", "getTrackApplicationLifecycleEvents$datapipelines_release", "getAutoTrackDeviceAttributes$datapipelines_release", "getAutoTrackActivityScreens$datapipelines_release", "getMigrationSiteId$datapipelines_release", "getScreenViewUse$datapipelines_release", "()Lio/customer/datapipelines/config/ScreenView;", "getModules$datapipelines_release", "component1", "component1$datapipelines_release", "component2", "component2$datapipelines_release", "component3", "component3$datapipelines_release", "component4", "component4$datapipelines_release", "component5", "component5$datapipelines_release", "component6", "component6$datapipelines_release", "component7", "component7$datapipelines_release", "component8", "component8$datapipelines_release", "component9", "component9$datapipelines_release", "component10", "component10$datapipelines_release", "component11", "component11$datapipelines_release", "component12", "component12$datapipelines_release", "component13", "component13$datapipelines_release", "component14", "component14$datapipelines_release", "component15", "component15$datapipelines_release", "component16", "component16$datapipelines_release", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CustomerIOConfig {
    private final String apiHost;
    private final Application applicationContext;
    private final boolean autoAddCustomerIODestination;
    private final boolean autoTrackActivityScreens;
    private final boolean autoTrackDeviceAttributes;
    private final String cdnHost;
    private final String cdpApiKey;
    private final int flushAt;
    private final int flushInterval;
    private final List<FlushPolicy> flushPolicies;
    private final CioLogLevel logLevel;
    private final String migrationSiteId;
    private final List<CustomerIOModule<? extends CustomerIOModuleConfig>> modules;
    private final Region region;
    private final ScreenView screenViewUse;
    private final boolean trackApplicationLifecycleEvents;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomerIOConfig(Application applicationContext, String cdpApiKey, CioLogLevel logLevel, Region region, String str, String str2, int i, int i2, List<? extends FlushPolicy> flushPolicies, boolean z, boolean z2, boolean z3, boolean z4, String str3, ScreenView screenViewUse, List<? extends CustomerIOModule<? extends CustomerIOModuleConfig>> modules) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(cdpApiKey, "cdpApiKey");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(flushPolicies, "flushPolicies");
        Intrinsics.checkNotNullParameter(screenViewUse, "screenViewUse");
        Intrinsics.checkNotNullParameter(modules, "modules");
        this.applicationContext = applicationContext;
        this.cdpApiKey = cdpApiKey;
        this.logLevel = logLevel;
        this.region = region;
        this.apiHost = str;
        this.cdnHost = str2;
        this.flushAt = i;
        this.flushInterval = i2;
        this.flushPolicies = flushPolicies;
        this.autoAddCustomerIODestination = z;
        this.trackApplicationLifecycleEvents = z2;
        this.autoTrackDeviceAttributes = z3;
        this.autoTrackActivityScreens = z4;
        this.migrationSiteId = str3;
        this.screenViewUse = screenViewUse;
        this.modules = modules;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerIOConfig copy$default(CustomerIOConfig customerIOConfig, Application application, String str, CioLogLevel cioLogLevel, Region region, String str2, String str3, int i, int i2, List list, boolean z, boolean z2, boolean z3, boolean z4, String str4, ScreenView screenView, List list2, int i3, Object obj) {
        Application application2 = (i3 & 1) != 0 ? customerIOConfig.applicationContext : application;
        return customerIOConfig.copy(application2, (i3 & 2) != 0 ? customerIOConfig.cdpApiKey : str, (i3 & 4) != 0 ? customerIOConfig.logLevel : cioLogLevel, (i3 & 8) != 0 ? customerIOConfig.region : region, (i3 & 16) != 0 ? customerIOConfig.apiHost : str2, (i3 & 32) != 0 ? customerIOConfig.cdnHost : str3, (i3 & 64) != 0 ? customerIOConfig.flushAt : i, (i3 & 128) != 0 ? customerIOConfig.flushInterval : i2, (i3 & 256) != 0 ? customerIOConfig.flushPolicies : list, (i3 & 512) != 0 ? customerIOConfig.autoAddCustomerIODestination : z, (i3 & 1024) != 0 ? customerIOConfig.trackApplicationLifecycleEvents : z2, (i3 & 2048) != 0 ? customerIOConfig.autoTrackDeviceAttributes : z3, (i3 & 4096) != 0 ? customerIOConfig.autoTrackActivityScreens : z4, (i3 & 8192) != 0 ? customerIOConfig.migrationSiteId : str4, (i3 & 16384) != 0 ? customerIOConfig.screenViewUse : screenView, (i3 & 32768) != 0 ? customerIOConfig.modules : list2);
    }

    /* JADX INFO: renamed from: component1$datapipelines_release, reason: from getter */
    public final Application getApplicationContext() {
        return this.applicationContext;
    }

    /* JADX INFO: renamed from: component10$datapipelines_release, reason: from getter */
    public final boolean getAutoAddCustomerIODestination() {
        return this.autoAddCustomerIODestination;
    }

    /* JADX INFO: renamed from: component11$datapipelines_release, reason: from getter */
    public final boolean getTrackApplicationLifecycleEvents() {
        return this.trackApplicationLifecycleEvents;
    }

    /* JADX INFO: renamed from: component12$datapipelines_release, reason: from getter */
    public final boolean getAutoTrackDeviceAttributes() {
        return this.autoTrackDeviceAttributes;
    }

    /* JADX INFO: renamed from: component13$datapipelines_release, reason: from getter */
    public final boolean getAutoTrackActivityScreens() {
        return this.autoTrackActivityScreens;
    }

    /* JADX INFO: renamed from: component14$datapipelines_release, reason: from getter */
    public final String getMigrationSiteId() {
        return this.migrationSiteId;
    }

    /* JADX INFO: renamed from: component15$datapipelines_release, reason: from getter */
    public final ScreenView getScreenViewUse() {
        return this.screenViewUse;
    }

    public final List<CustomerIOModule<? extends CustomerIOModuleConfig>> component16$datapipelines_release() {
        return this.modules;
    }

    /* JADX INFO: renamed from: component2$datapipelines_release, reason: from getter */
    public final String getCdpApiKey() {
        return this.cdpApiKey;
    }

    /* JADX INFO: renamed from: component3$datapipelines_release, reason: from getter */
    public final CioLogLevel getLogLevel() {
        return this.logLevel;
    }

    /* JADX INFO: renamed from: component4$datapipelines_release, reason: from getter */
    public final Region getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component5$datapipelines_release, reason: from getter */
    public final String getApiHost() {
        return this.apiHost;
    }

    /* JADX INFO: renamed from: component6$datapipelines_release, reason: from getter */
    public final String getCdnHost() {
        return this.cdnHost;
    }

    /* JADX INFO: renamed from: component7$datapipelines_release, reason: from getter */
    public final int getFlushAt() {
        return this.flushAt;
    }

    /* JADX INFO: renamed from: component8$datapipelines_release, reason: from getter */
    public final int getFlushInterval() {
        return this.flushInterval;
    }

    public final List<FlushPolicy> component9$datapipelines_release() {
        return this.flushPolicies;
    }

    public final CustomerIOConfig copy(Application applicationContext, String cdpApiKey, CioLogLevel logLevel, Region region, String apiHost, String cdnHost, int flushAt, int flushInterval, List<? extends FlushPolicy> flushPolicies, boolean autoAddCustomerIODestination, boolean trackApplicationLifecycleEvents, boolean autoTrackDeviceAttributes, boolean autoTrackActivityScreens, String migrationSiteId, ScreenView screenViewUse, List<? extends CustomerIOModule<? extends CustomerIOModuleConfig>> modules) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(cdpApiKey, "cdpApiKey");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(flushPolicies, "flushPolicies");
        Intrinsics.checkNotNullParameter(screenViewUse, "screenViewUse");
        Intrinsics.checkNotNullParameter(modules, "modules");
        return new CustomerIOConfig(applicationContext, cdpApiKey, logLevel, region, apiHost, cdnHost, flushAt, flushInterval, flushPolicies, autoAddCustomerIODestination, trackApplicationLifecycleEvents, autoTrackDeviceAttributes, autoTrackActivityScreens, migrationSiteId, screenViewUse, modules);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomerIOConfig)) {
            return false;
        }
        CustomerIOConfig customerIOConfig = (CustomerIOConfig) other;
        return Intrinsics.areEqual(this.applicationContext, customerIOConfig.applicationContext) && Intrinsics.areEqual(this.cdpApiKey, customerIOConfig.cdpApiKey) && this.logLevel == customerIOConfig.logLevel && Intrinsics.areEqual(this.region, customerIOConfig.region) && Intrinsics.areEqual(this.apiHost, customerIOConfig.apiHost) && Intrinsics.areEqual(this.cdnHost, customerIOConfig.cdnHost) && this.flushAt == customerIOConfig.flushAt && this.flushInterval == customerIOConfig.flushInterval && Intrinsics.areEqual(this.flushPolicies, customerIOConfig.flushPolicies) && this.autoAddCustomerIODestination == customerIOConfig.autoAddCustomerIODestination && this.trackApplicationLifecycleEvents == customerIOConfig.trackApplicationLifecycleEvents && this.autoTrackDeviceAttributes == customerIOConfig.autoTrackDeviceAttributes && this.autoTrackActivityScreens == customerIOConfig.autoTrackActivityScreens && Intrinsics.areEqual(this.migrationSiteId, customerIOConfig.migrationSiteId) && Intrinsics.areEqual(this.screenViewUse, customerIOConfig.screenViewUse) && Intrinsics.areEqual(this.modules, customerIOConfig.modules);
    }

    public final String getApiHost$datapipelines_release() {
        return this.apiHost;
    }

    public final Application getApplicationContext$datapipelines_release() {
        return this.applicationContext;
    }

    public final boolean getAutoAddCustomerIODestination$datapipelines_release() {
        return this.autoAddCustomerIODestination;
    }

    public final boolean getAutoTrackActivityScreens$datapipelines_release() {
        return this.autoTrackActivityScreens;
    }

    public final boolean getAutoTrackDeviceAttributes$datapipelines_release() {
        return this.autoTrackDeviceAttributes;
    }

    public final String getCdnHost$datapipelines_release() {
        return this.cdnHost;
    }

    public final String getCdpApiKey$datapipelines_release() {
        return this.cdpApiKey;
    }

    public final int getFlushAt$datapipelines_release() {
        return this.flushAt;
    }

    public final int getFlushInterval$datapipelines_release() {
        return this.flushInterval;
    }

    public final List<FlushPolicy> getFlushPolicies$datapipelines_release() {
        return this.flushPolicies;
    }

    public final CioLogLevel getLogLevel$datapipelines_release() {
        return this.logLevel;
    }

    public final String getMigrationSiteId$datapipelines_release() {
        return this.migrationSiteId;
    }

    public final List<CustomerIOModule<? extends CustomerIOModuleConfig>> getModules$datapipelines_release() {
        return this.modules;
    }

    public final Region getRegion$datapipelines_release() {
        return this.region;
    }

    public final ScreenView getScreenViewUse$datapipelines_release() {
        return this.screenViewUse;
    }

    public final boolean getTrackApplicationLifecycleEvents$datapipelines_release() {
        return this.trackApplicationLifecycleEvents;
    }

    public int hashCode() {
        int iHashCode = ((((((this.applicationContext.hashCode() * 31) + this.cdpApiKey.hashCode()) * 31) + this.logLevel.hashCode()) * 31) + this.region.hashCode()) * 31;
        String str = this.apiHost;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cdnHost;
        int iHashCode3 = (((((((((((((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.flushAt)) * 31) + Integer.hashCode(this.flushInterval)) * 31) + this.flushPolicies.hashCode()) * 31) + Boolean.hashCode(this.autoAddCustomerIODestination)) * 31) + Boolean.hashCode(this.trackApplicationLifecycleEvents)) * 31) + Boolean.hashCode(this.autoTrackDeviceAttributes)) * 31) + Boolean.hashCode(this.autoTrackActivityScreens)) * 31;
        String str3 = this.migrationSiteId;
        return ((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.screenViewUse.hashCode()) * 31) + this.modules.hashCode();
    }

    public String toString() {
        return "CustomerIOConfig(applicationContext=" + this.applicationContext + ", cdpApiKey=" + this.cdpApiKey + ", logLevel=" + this.logLevel + ", region=" + this.region + ", apiHost=" + this.apiHost + ", cdnHost=" + this.cdnHost + ", flushAt=" + this.flushAt + ", flushInterval=" + this.flushInterval + ", flushPolicies=" + this.flushPolicies + ", autoAddCustomerIODestination=" + this.autoAddCustomerIODestination + ", trackApplicationLifecycleEvents=" + this.trackApplicationLifecycleEvents + ", autoTrackDeviceAttributes=" + this.autoTrackDeviceAttributes + ", autoTrackActivityScreens=" + this.autoTrackActivityScreens + ", migrationSiteId=" + this.migrationSiteId + ", screenViewUse=" + this.screenViewUse + ", modules=" + this.modules + ")";
    }
}
