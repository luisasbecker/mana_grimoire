package com.segment.analytics.kotlin.core;

import androidx.media3.common.MimeTypes;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.core.platform.policies.FlushPolicy;
import com.segment.analytics.kotlin.core.utilities.ConcreteStorageProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\bI\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aj\u0004\u0018\u0001`\u001d¢\u0006\u0002\u0010\u001eJ\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010S\u001a\u00020\bHÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0018HÆ\u0003J\u001d\u0010W\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aj\u0004\u0018\u0001`\u001dHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\t\u0010Z\u001a\u00020\bHÆ\u0003J\t\u0010[\u001a\u00020\bHÆ\u0003J\t\u0010\\\u001a\u00020\bHÆ\u0003J\t\u0010]\u001a\u00020\bHÆ\u0003J\t\u0010^\u001a\u00020\rHÆ\u0003J\t\u0010_\u001a\u00020\rHÆ\u0003JÇ\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aj\u0004\u0018\u0001`\u001dHÆ\u0001J\u0013\u0010a\u001a\u00020\b2\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020\rHÖ\u0001J\u0006\u0010d\u001a\u00020\bJ\t\u0010e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0014\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R.\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aj\u0004\u0018\u0001`\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010(\"\u0004\bJ\u0010*R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010(\"\u0004\bL\u0010*R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010(\"\u0004\bN\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010 ¨\u0006f"}, d2 = {"Lcom/segment/analytics/kotlin/core/Configuration;", "", "writeKey", "", MimeTypes.BASE_TYPE_APPLICATION, "storageProvider", "Lcom/segment/analytics/kotlin/core/StorageProvider;", "collectDeviceId", "", "trackApplicationLifecycleEvents", "useLifecycleObserver", "trackDeepLinks", "flushAt", "", "flushInterval", "flushPolicies", "", "Lcom/segment/analytics/kotlin/core/platform/policies/FlushPolicy;", "defaultSettings", "Lcom/segment/analytics/kotlin/core/Settings;", "autoAddSegmentDestination", "apiHost", "cdnHost", "requestFactory", "Lcom/segment/analytics/kotlin/core/RequestFactory;", "errorHandler", "Lkotlin/Function1;", "", "", "Lcom/segment/analytics/kotlin/core/ErrorHandler;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/segment/analytics/kotlin/core/StorageProvider;ZZZZIILjava/util/List;Lcom/segment/analytics/kotlin/core/Settings;ZLjava/lang/String;Ljava/lang/String;Lcom/segment/analytics/kotlin/core/RequestFactory;Lkotlin/jvm/functions/Function1;)V", "getApiHost", "()Ljava/lang/String;", "setApiHost", "(Ljava/lang/String;)V", "getApplication", "()Ljava/lang/Object;", "setApplication", "(Ljava/lang/Object;)V", "getAutoAddSegmentDestination", "()Z", "setAutoAddSegmentDestination", "(Z)V", "getCdnHost", "setCdnHost", "getCollectDeviceId", "setCollectDeviceId", "getDefaultSettings", "()Lcom/segment/analytics/kotlin/core/Settings;", "setDefaultSettings", "(Lcom/segment/analytics/kotlin/core/Settings;)V", "getErrorHandler", "()Lkotlin/jvm/functions/Function1;", "setErrorHandler", "(Lkotlin/jvm/functions/Function1;)V", "getFlushAt", "()I", "setFlushAt", "(I)V", "getFlushInterval", "setFlushInterval", "getFlushPolicies", "()Ljava/util/List;", "setFlushPolicies", "(Ljava/util/List;)V", "getRequestFactory", "()Lcom/segment/analytics/kotlin/core/RequestFactory;", "setRequestFactory", "(Lcom/segment/analytics/kotlin/core/RequestFactory;)V", "getStorageProvider", "()Lcom/segment/analytics/kotlin/core/StorageProvider;", "setStorageProvider", "(Lcom/segment/analytics/kotlin/core/StorageProvider;)V", "getTrackApplicationLifecycleEvents", "setTrackApplicationLifecycleEvents", "getTrackDeepLinks", "setTrackDeepLinks", "getUseLifecycleObserver", "setUseLifecycleObserver", "getWriteKey", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "isValid", InAppPurchaseConstants.METHOD_TO_STRING, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Configuration {
    private String apiHost;
    private Object application;
    private boolean autoAddSegmentDestination;
    private String cdnHost;
    private boolean collectDeviceId;
    private Settings defaultSettings;
    private Function1<? super Throwable, Unit> errorHandler;
    private int flushAt;
    private int flushInterval;
    private List<? extends FlushPolicy> flushPolicies;
    private RequestFactory requestFactory;
    private StorageProvider storageProvider;
    private boolean trackApplicationLifecycleEvents;
    private boolean trackDeepLinks;
    private boolean useLifecycleObserver;
    private final String writeKey;

    public Configuration(String writeKey, Object obj, StorageProvider storageProvider, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, List<? extends FlushPolicy> flushPolicies, Settings settings, boolean z5, String apiHost, String cdnHost, RequestFactory requestFactory, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(storageProvider, "storageProvider");
        Intrinsics.checkNotNullParameter(flushPolicies, "flushPolicies");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        Intrinsics.checkNotNullParameter(cdnHost, "cdnHost");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        this.writeKey = writeKey;
        this.application = obj;
        this.storageProvider = storageProvider;
        this.collectDeviceId = z;
        this.trackApplicationLifecycleEvents = z2;
        this.useLifecycleObserver = z3;
        this.trackDeepLinks = z4;
        this.flushAt = i;
        this.flushInterval = i2;
        this.flushPolicies = flushPolicies;
        this.defaultSettings = settings;
        this.autoAddSegmentDestination = z5;
        this.apiHost = apiHost;
        this.cdnHost = cdnHost;
        this.requestFactory = requestFactory;
        this.errorHandler = function1;
    }

    public /* synthetic */ Configuration(String str, Object obj, StorageProvider storageProvider, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, List list, Settings settings, boolean z5, String str2, String str3, RequestFactory requestFactory, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : obj, (i3 & 4) != 0 ? ConcreteStorageProvider.INSTANCE : storageProvider, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) == 0 ? z4 : false, (i3 & 128) != 0 ? 20 : i, (i3 & 256) != 0 ? 30 : i2, (i3 & 512) != 0 ? CollectionsKt.emptyList() : list, (i3 & 1024) != 0 ? null : settings, (i3 & 2048) != 0 ? true : z5, (i3 & 4096) != 0 ? Constants.DEFAULT_API_HOST : str2, (i3 & 8192) != 0 ? Constants.DEFAULT_CDN_HOST : str3, (i3 & 16384) != 0 ? new RequestFactory() : requestFactory, (i3 & 32768) != 0 ? null : function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, Object obj, StorageProvider storageProvider, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, List list, Settings settings, boolean z5, String str2, String str3, RequestFactory requestFactory, Function1 function1, int i3, Object obj2) {
        String str4 = (i3 & 1) != 0 ? configuration.writeKey : str;
        return configuration.copy(str4, (i3 & 2) != 0 ? configuration.application : obj, (i3 & 4) != 0 ? configuration.storageProvider : storageProvider, (i3 & 8) != 0 ? configuration.collectDeviceId : z, (i3 & 16) != 0 ? configuration.trackApplicationLifecycleEvents : z2, (i3 & 32) != 0 ? configuration.useLifecycleObserver : z3, (i3 & 64) != 0 ? configuration.trackDeepLinks : z4, (i3 & 128) != 0 ? configuration.flushAt : i, (i3 & 256) != 0 ? configuration.flushInterval : i2, (i3 & 512) != 0 ? configuration.flushPolicies : list, (i3 & 1024) != 0 ? configuration.defaultSettings : settings, (i3 & 2048) != 0 ? configuration.autoAddSegmentDestination : z5, (i3 & 4096) != 0 ? configuration.apiHost : str2, (i3 & 8192) != 0 ? configuration.cdnHost : str3, (i3 & 16384) != 0 ? configuration.requestFactory : requestFactory, (i3 & 32768) != 0 ? configuration.errorHandler : function1);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getWriteKey() {
        return this.writeKey;
    }

    public final List<FlushPolicy> component10() {
        return this.flushPolicies;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Settings getDefaultSettings() {
        return this.defaultSettings;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getAutoAddSegmentDestination() {
        return this.autoAddSegmentDestination;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getApiHost() {
        return this.apiHost;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getCdnHost() {
        return this.cdnHost;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final RequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public final Function1<Throwable, Unit> component16() {
        return this.errorHandler;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StorageProvider getStorageProvider() {
        return this.storageProvider;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCollectDeviceId() {
        return this.collectDeviceId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getTrackApplicationLifecycleEvents() {
        return this.trackApplicationLifecycleEvents;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getUseLifecycleObserver() {
        return this.useLifecycleObserver;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getTrackDeepLinks() {
        return this.trackDeepLinks;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getFlushAt() {
        return this.flushAt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getFlushInterval() {
        return this.flushInterval;
    }

    public final Configuration copy(String writeKey, Object application, StorageProvider storageProvider, boolean collectDeviceId, boolean trackApplicationLifecycleEvents, boolean useLifecycleObserver, boolean trackDeepLinks, int flushAt, int flushInterval, List<? extends FlushPolicy> flushPolicies, Settings defaultSettings, boolean autoAddSegmentDestination, String apiHost, String cdnHost, RequestFactory requestFactory, Function1<? super Throwable, Unit> errorHandler) {
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(storageProvider, "storageProvider");
        Intrinsics.checkNotNullParameter(flushPolicies, "flushPolicies");
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        Intrinsics.checkNotNullParameter(cdnHost, "cdnHost");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        return new Configuration(writeKey, application, storageProvider, collectDeviceId, trackApplicationLifecycleEvents, useLifecycleObserver, trackDeepLinks, flushAt, flushInterval, flushPolicies, defaultSettings, autoAddSegmentDestination, apiHost, cdnHost, requestFactory, errorHandler);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) other;
        return Intrinsics.areEqual(this.writeKey, configuration.writeKey) && Intrinsics.areEqual(this.application, configuration.application) && Intrinsics.areEqual(this.storageProvider, configuration.storageProvider) && this.collectDeviceId == configuration.collectDeviceId && this.trackApplicationLifecycleEvents == configuration.trackApplicationLifecycleEvents && this.useLifecycleObserver == configuration.useLifecycleObserver && this.trackDeepLinks == configuration.trackDeepLinks && this.flushAt == configuration.flushAt && this.flushInterval == configuration.flushInterval && Intrinsics.areEqual(this.flushPolicies, configuration.flushPolicies) && Intrinsics.areEqual(this.defaultSettings, configuration.defaultSettings) && this.autoAddSegmentDestination == configuration.autoAddSegmentDestination && Intrinsics.areEqual(this.apiHost, configuration.apiHost) && Intrinsics.areEqual(this.cdnHost, configuration.cdnHost) && Intrinsics.areEqual(this.requestFactory, configuration.requestFactory) && Intrinsics.areEqual(this.errorHandler, configuration.errorHandler);
    }

    public final String getApiHost() {
        return this.apiHost;
    }

    public final Object getApplication() {
        return this.application;
    }

    public final boolean getAutoAddSegmentDestination() {
        return this.autoAddSegmentDestination;
    }

    public final String getCdnHost() {
        return this.cdnHost;
    }

    public final boolean getCollectDeviceId() {
        return this.collectDeviceId;
    }

    public final Settings getDefaultSettings() {
        return this.defaultSettings;
    }

    public final Function1<Throwable, Unit> getErrorHandler() {
        return this.errorHandler;
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

    public final RequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public final StorageProvider getStorageProvider() {
        return this.storageProvider;
    }

    public final boolean getTrackApplicationLifecycleEvents() {
        return this.trackApplicationLifecycleEvents;
    }

    public final boolean getTrackDeepLinks() {
        return this.trackDeepLinks;
    }

    public final boolean getUseLifecycleObserver() {
        return this.useLifecycleObserver;
    }

    public final String getWriteKey() {
        return this.writeKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = this.writeKey.hashCode() * 31;
        Object obj = this.application;
        int iHashCode2 = (((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.storageProvider.hashCode()) * 31;
        boolean z = this.collectDeviceId;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z2 = this.trackApplicationLifecycleEvents;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i2 = (i + r12) * 31;
        boolean z3 = this.useLifecycleObserver;
        ?? r13 = z3;
        if (z3) {
            r13 = 1;
        }
        int i3 = (i2 + r13) * 31;
        boolean z4 = this.trackDeepLinks;
        ?? r14 = z4;
        if (z4) {
            r14 = 1;
        }
        int iHashCode3 = (((((((i3 + r14) * 31) + Integer.hashCode(this.flushAt)) * 31) + Integer.hashCode(this.flushInterval)) * 31) + this.flushPolicies.hashCode()) * 31;
        Settings settings = this.defaultSettings;
        int iHashCode4 = (iHashCode3 + (settings == null ? 0 : settings.hashCode())) * 31;
        boolean z5 = this.autoAddSegmentDestination;
        int iHashCode5 = (((((((iHashCode4 + (z5 ? 1 : z5)) * 31) + this.apiHost.hashCode()) * 31) + this.cdnHost.hashCode()) * 31) + this.requestFactory.hashCode()) * 31;
        Function1<? super Throwable, Unit> function1 = this.errorHandler;
        return iHashCode5 + (function1 != null ? function1.hashCode() : 0);
    }

    public final boolean isValid() {
        return (StringsKt.isBlank(this.writeKey) || this.application == null) ? false : true;
    }

    public final void setApiHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.apiHost = str;
    }

    public final void setApplication(Object obj) {
        this.application = obj;
    }

    public final void setAutoAddSegmentDestination(boolean z) {
        this.autoAddSegmentDestination = z;
    }

    public final void setCdnHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cdnHost = str;
    }

    public final void setCollectDeviceId(boolean z) {
        this.collectDeviceId = z;
    }

    public final void setDefaultSettings(Settings settings) {
        this.defaultSettings = settings;
    }

    public final void setErrorHandler(Function1<? super Throwable, Unit> function1) {
        this.errorHandler = function1;
    }

    public final void setFlushAt(int i) {
        this.flushAt = i;
    }

    public final void setFlushInterval(int i) {
        this.flushInterval = i;
    }

    public final void setFlushPolicies(List<? extends FlushPolicy> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.flushPolicies = list;
    }

    public final void setRequestFactory(RequestFactory requestFactory) {
        Intrinsics.checkNotNullParameter(requestFactory, "<set-?>");
        this.requestFactory = requestFactory;
    }

    public final void setStorageProvider(StorageProvider storageProvider) {
        Intrinsics.checkNotNullParameter(storageProvider, "<set-?>");
        this.storageProvider = storageProvider;
    }

    public final void setTrackApplicationLifecycleEvents(boolean z) {
        this.trackApplicationLifecycleEvents = z;
    }

    public final void setTrackDeepLinks(boolean z) {
        this.trackDeepLinks = z;
    }

    public final void setUseLifecycleObserver(boolean z) {
        this.useLifecycleObserver = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Configuration(writeKey=");
        sb.append(this.writeKey).append(", application=").append(this.application).append(", storageProvider=").append(this.storageProvider).append(", collectDeviceId=").append(this.collectDeviceId).append(", trackApplicationLifecycleEvents=").append(this.trackApplicationLifecycleEvents).append(", useLifecycleObserver=").append(this.useLifecycleObserver).append(", trackDeepLinks=").append(this.trackDeepLinks).append(", flushAt=").append(this.flushAt).append(", flushInterval=").append(this.flushInterval).append(", flushPolicies=").append(this.flushPolicies).append(", defaultSettings=").append(this.defaultSettings).append(", autoAddSegmentDestination=");
        sb.append(this.autoAddSegmentDestination).append(", apiHost=").append(this.apiHost).append(", cdnHost=").append(this.cdnHost).append(", requestFactory=").append(this.requestFactory).append(", errorHandler=").append(this.errorHandler).append(')');
        return sb.toString();
    }
}
