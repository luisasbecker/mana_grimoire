package com.segment.analytics.kotlin.core.compat;

import androidx.media3.common.MimeTypes;
import com.segment.analytics.kotlin.core.Configuration;
import com.segment.analytics.kotlin.core.RequestFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConfigurationBuilder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/segment/analytics/kotlin/core/compat/ConfigurationBuilder;", "", "writeKey", "", "(Ljava/lang/String;)V", "configuration", "Lcom/segment/analytics/kotlin/core/Configuration;", "build", "setApiHost", "apiHost", "setApplication", MimeTypes.BASE_TYPE_APPLICATION, "setAutoAddSegmentDestination", "autoAddSegmentDestination", "", "setCdnHost", "cdnHost", "setCollectDeviceId", "collectDeviceId", "setFlushAt", "flushAt", "", "setFlushInterval", "flushInterval", "setRequestFactory", "requestFactory", "Lcom/segment/analytics/kotlin/core/RequestFactory;", "setTrackApplicationLifecycleEvents", "trackApplicationLifecycleEvents", "setTrackDeepLinks", "trackDeepLinks", "setUseLifecycleObserver", "useLifecycleObserver", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConfigurationBuilder {
    private final Configuration configuration;

    public ConfigurationBuilder(String writeKey) {
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        this.configuration = new Configuration(writeKey, null, null, false, false, false, false, 0, 0, null, null, false, null, null, null, null, 65534, null);
    }

    /* JADX INFO: renamed from: build, reason: from getter */
    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final ConfigurationBuilder setApiHost(String apiHost) {
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        this.configuration.setApiHost(apiHost);
        return this;
    }

    public final ConfigurationBuilder setApplication(Object application) {
        this.configuration.setApplication(application);
        return this;
    }

    public final ConfigurationBuilder setAutoAddSegmentDestination(boolean autoAddSegmentDestination) {
        this.configuration.setAutoAddSegmentDestination(autoAddSegmentDestination);
        return this;
    }

    public final ConfigurationBuilder setCdnHost(String cdnHost) {
        Intrinsics.checkNotNullParameter(cdnHost, "cdnHost");
        this.configuration.setCdnHost(cdnHost);
        return this;
    }

    public final ConfigurationBuilder setCollectDeviceId(boolean collectDeviceId) {
        this.configuration.setCollectDeviceId(collectDeviceId);
        return this;
    }

    public final ConfigurationBuilder setFlushAt(int flushAt) {
        this.configuration.setFlushAt(flushAt);
        return this;
    }

    public final ConfigurationBuilder setFlushInterval(int flushInterval) {
        this.configuration.setFlushInterval(flushInterval);
        return this;
    }

    public final ConfigurationBuilder setRequestFactory(RequestFactory requestFactory) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        this.configuration.setRequestFactory(requestFactory);
        return this;
    }

    public final ConfigurationBuilder setTrackApplicationLifecycleEvents(boolean trackApplicationLifecycleEvents) {
        this.configuration.setTrackApplicationLifecycleEvents(trackApplicationLifecycleEvents);
        return this;
    }

    public final ConfigurationBuilder setTrackDeepLinks(boolean trackDeepLinks) {
        this.configuration.setTrackDeepLinks(trackDeepLinks);
        return this;
    }

    public final ConfigurationBuilder setUseLifecycleObserver(boolean useLifecycleObserver) {
        this.configuration.setUseLifecycleObserver(useLifecycleObserver);
        return this;
    }
}
