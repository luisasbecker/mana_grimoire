package io.customer.datapipelines.config;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.core.platform.policies.FlushPolicy;
import io.customer.datapipelines.extensions.RegionExtKt;
import io.customer.sdk.core.module.CustomerIOModuleConfig;
import io.customer.sdk.data.model.Region;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataPipelinesModuleConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010+\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0011\u0010)\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019¨\u0006,"}, d2 = {"Lio/customer/datapipelines/config/DataPipelinesModuleConfig;", "Lio/customer/sdk/core/module/CustomerIOModuleConfig;", "cdpApiKey", "", "region", "Lio/customer/sdk/data/model/Region;", "apiHostOverride", "cdnHostOverride", "flushAt", "", "flushInterval", "flushPolicies", "", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "autoAddCustomerIODestination", "", "trackApplicationLifecycleEvents", "autoTrackDeviceAttributes", "autoTrackActivityScreens", "migrationSiteId", "screenViewUse", "Lio/customer/datapipelines/config/ScreenView;", "<init>", "(Ljava/lang/String;Lio/customer/sdk/data/model/Region;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;ZZZZLjava/lang/String;Lio/customer/datapipelines/config/ScreenView;)V", "getCdpApiKey", "()Ljava/lang/String;", "getFlushAt", "()I", "getFlushInterval", "getFlushPolicies", "()Ljava/util/List;", "getAutoAddCustomerIODestination", "()Z", "getTrackApplicationLifecycleEvents", "getAutoTrackDeviceAttributes", "getAutoTrackActivityScreens", "getMigrationSiteId", "getScreenViewUse", "()Lio/customer/datapipelines/config/ScreenView;", "apiHost", "getApiHost", "cdnHost", "getCdnHost", InAppPurchaseConstants.METHOD_TO_STRING, "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataPipelinesModuleConfig implements CustomerIOModuleConfig {
    private final String apiHost;
    private final boolean autoAddCustomerIODestination;
    private final boolean autoTrackActivityScreens;
    private final boolean autoTrackDeviceAttributes;
    private final String cdnHost;
    private final String cdpApiKey;
    private final int flushAt;
    private final int flushInterval;
    private final List<FlushPolicy> flushPolicies;
    private final String migrationSiteId;
    private final ScreenView screenViewUse;
    private final boolean trackApplicationLifecycleEvents;

    /* JADX WARN: Multi-variable type inference failed */
    public DataPipelinesModuleConfig(String cdpApiKey, Region region, String str, String str2, int i, int i2, List<? extends FlushPolicy> flushPolicies, boolean z, boolean z2, boolean z3, boolean z4, String str3, ScreenView screenViewUse) {
        Intrinsics.checkNotNullParameter(cdpApiKey, "cdpApiKey");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(flushPolicies, "flushPolicies");
        Intrinsics.checkNotNullParameter(screenViewUse, "screenViewUse");
        this.cdpApiKey = cdpApiKey;
        this.flushAt = i;
        this.flushInterval = i2;
        this.flushPolicies = flushPolicies;
        this.autoAddCustomerIODestination = z;
        this.trackApplicationLifecycleEvents = z2;
        this.autoTrackDeviceAttributes = z3;
        this.autoTrackActivityScreens = z4;
        this.migrationSiteId = str3;
        this.screenViewUse = screenViewUse;
        this.apiHost = str == null ? RegionExtKt.apiHost(region) : str;
        this.cdnHost = str2 == null ? RegionExtKt.cdnHost(region) : str2;
    }

    public /* synthetic */ DataPipelinesModuleConfig(String str, Region region, String str2, String str3, int i, int i2, List list, boolean z, boolean z2, boolean z3, boolean z4, String str4, ScreenView screenView, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, region, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, i, i2, list, z, z2, z3, z4, (i3 & 2048) != 0 ? null : str4, screenView);
    }

    public final String getApiHost() {
        return this.apiHost;
    }

    public final boolean getAutoAddCustomerIODestination() {
        return this.autoAddCustomerIODestination;
    }

    public final boolean getAutoTrackActivityScreens() {
        return this.autoTrackActivityScreens;
    }

    public final boolean getAutoTrackDeviceAttributes() {
        return this.autoTrackDeviceAttributes;
    }

    public final String getCdnHost() {
        return this.cdnHost;
    }

    public final String getCdpApiKey() {
        return this.cdpApiKey;
    }

    public final int getFlushAt() {
        return this.flushAt;
    }

    public final int getFlushInterval() {
        return this.flushInterval;
    }

    public final List<FlushPolicy> getFlushPolicies() {
        return this.flushPolicies;
    }

    public final String getMigrationSiteId() {
        return this.migrationSiteId;
    }

    public final ScreenView getScreenViewUse() {
        return this.screenViewUse;
    }

    public final boolean getTrackApplicationLifecycleEvents() {
        return this.trackApplicationLifecycleEvents;
    }

    public String toString() {
        return "DataPipelinesModuleConfig(cdpApiKey='[Redacted]', flushAt=" + this.flushAt + ", flushInterval=" + this.flushInterval + ", flushPolicies=" + this.flushPolicies + ", autoAddCustomerIODestination=" + this.autoAddCustomerIODestination + ", trackApplicationLifecycleEvents=" + this.trackApplicationLifecycleEvents + ", autoTrackDeviceAttributes=" + this.autoTrackDeviceAttributes + ", autoTrackActivityScreens=" + this.autoTrackActivityScreens + ", migrationSiteId=[Redacted], screenViewUse=" + this.screenViewUse + ", apiHost='" + this.apiHost + "', cdnHost='" + this.cdnHost + "')";
    }
}
