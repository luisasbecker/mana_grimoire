package com.segment.analytics.kotlin.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: Telemetry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,Ba\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rBI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003JU\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J!\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÇ\u0001R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/segment/analytics/kotlin/core/RemoteMetric;", "", "seen1", "", "type", "", "metric", "value", "tags", "", "log", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/util/Map;)V", "getLog", "()Ljava/util/Map;", "getMetric", "()Ljava/lang/String;", "getTags", "getType", "getValue", "()I", "setValue", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final /* data */ class RemoteMetric {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, String> log;
    private final String metric;
    private final Map<String, String> tags;
    private final String type;
    private int value;

    /* JADX INFO: compiled from: Telemetry.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/segment/analytics/kotlin/core/RemoteMetric$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/segment/analytics/kotlin/core/RemoteMetric;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<RemoteMetric> serializer() {
            return RemoteMetric$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RemoteMetric(int i, String str, String str2, int i2, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, RemoteMetric$$serializer.INSTANCE.getDescriptor());
        }
        this.type = str;
        this.metric = str2;
        this.value = i2;
        this.tags = map;
        if ((i & 16) == 0) {
            this.log = null;
        } else {
            this.log = map2;
        }
    }

    public RemoteMetric(String type, String metric, int i, Map<String, String> tags, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.type = type;
        this.metric = metric;
        this.value = i;
        this.tags = tags;
        this.log = map;
    }

    public /* synthetic */ RemoteMetric(String str, String str2, int i, Map map, Map map2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, map, (i2 & 16) != 0 ? null : map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoteMetric copy$default(RemoteMetric remoteMetric, String str, String str2, int i, Map map, Map map2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = remoteMetric.type;
        }
        if ((i2 & 2) != 0) {
            str2 = remoteMetric.metric;
        }
        if ((i2 & 4) != 0) {
            i = remoteMetric.value;
        }
        if ((i2 & 8) != 0) {
            map = remoteMetric.tags;
        }
        if ((i2 & 16) != 0) {
            map2 = remoteMetric.log;
        }
        Map map3 = map2;
        int i3 = i;
        return remoteMetric.copy(str, str2, i3, map, map3);
    }

    @JvmStatic
    public static final void write$Self(RemoteMetric self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.type);
        output.encodeStringElement(serialDesc, 1, self.metric);
        output.encodeIntElement(serialDesc, 2, self.value);
        output.encodeSerializableElement(serialDesc, 3, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), self.tags);
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.log == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), self.log);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMetric() {
        return this.metric;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public final Map<String, String> component4() {
        return this.tags;
    }

    public final Map<String, String> component5() {
        return this.log;
    }

    public final RemoteMetric copy(String type, String metric, int value, Map<String, String> tags, Map<String, String> log) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(metric, "metric");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new RemoteMetric(type, metric, value, tags, log);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteMetric)) {
            return false;
        }
        RemoteMetric remoteMetric = (RemoteMetric) other;
        return Intrinsics.areEqual(this.type, remoteMetric.type) && Intrinsics.areEqual(this.metric, remoteMetric.metric) && this.value == remoteMetric.value && Intrinsics.areEqual(this.tags, remoteMetric.tags) && Intrinsics.areEqual(this.log, remoteMetric.log);
    }

    public final Map<String, String> getLog() {
        return this.log;
    }

    public final String getMetric() {
        return this.metric;
    }

    public final Map<String, String> getTags() {
        return this.tags;
    }

    public final String getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = ((((((this.type.hashCode() * 31) + this.metric.hashCode()) * 31) + Integer.hashCode(this.value)) * 31) + this.tags.hashCode()) * 31;
        Map<String, String> map = this.log;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public final void setValue(int i) {
        this.value = i;
    }

    public String toString() {
        return "RemoteMetric(type=" + this.type + ", metric=" + this.metric + ", value=" + this.value + ", tags=" + this.tags + ", log=" + this.log + ')';
    }
}
