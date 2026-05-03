package com.segment.analytics.kotlin.core.platform.plugins;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SegmentDestination.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÇ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\""}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/plugins/SegmentSettings;", "", "seen1", "", "apiKey", "", "apiHost", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getApiHost", "()Ljava/lang/String;", "setApiHost", "(Ljava/lang/String;)V", "getApiKey", "setApiKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final /* data */ class SegmentSettings {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String apiHost;
    private String apiKey;

    /* JADX INFO: compiled from: SegmentDestination.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/segment/analytics/kotlin/core/platform/plugins/SegmentSettings$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/segment/analytics/kotlin/core/platform/plugins/SegmentSettings;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SegmentSettings> serializer() {
            return SegmentSettings$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ SegmentSettings(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, SegmentSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.apiKey = str;
        if ((i & 2) == 0) {
            this.apiHost = null;
        } else {
            this.apiHost = str2;
        }
    }

    public SegmentSettings(String apiKey, String str) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.apiKey = apiKey;
        this.apiHost = str;
    }

    public /* synthetic */ SegmentSettings(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public static /* synthetic */ SegmentSettings copy$default(SegmentSettings segmentSettings, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = segmentSettings.apiKey;
        }
        if ((i & 2) != 0) {
            str2 = segmentSettings.apiHost;
        }
        return segmentSettings.copy(str, str2);
    }

    @JvmStatic
    public static final void write$Self(SegmentSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.apiKey);
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.apiHost == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.apiHost);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getApiHost() {
        return this.apiHost;
    }

    public final SegmentSettings copy(String apiKey, String apiHost) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        return new SegmentSettings(apiKey, apiHost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SegmentSettings)) {
            return false;
        }
        SegmentSettings segmentSettings = (SegmentSettings) other;
        return Intrinsics.areEqual(this.apiKey, segmentSettings.apiKey) && Intrinsics.areEqual(this.apiHost, segmentSettings.apiHost);
    }

    public final String getApiHost() {
        return this.apiHost;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public int hashCode() {
        int iHashCode = this.apiKey.hashCode() * 31;
        String str = this.apiHost;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setApiHost(String str) {
        this.apiHost = str;
    }

    public final void setApiKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.apiKey = str;
    }

    public String toString() {
        return "SegmentSettings(apiKey=" + this.apiKey + ", apiHost=" + this.apiHost + ')';
    }
}
