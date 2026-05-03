package com.segment.analytics.kotlin.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&BI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB;\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÇ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006'"}, d2 = {"Lcom/segment/analytics/kotlin/core/DestinationMetadata;", "", "seen1", "", "bundled", "", "", "unbundled", "bundledIds", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBundled", "()Ljava/util/List;", "setBundled", "(Ljava/util/List;)V", "getBundledIds", "setBundledIds", "getUnbundled", "setUnbundled", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final /* data */ class DestinationMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<String> bundled;
    private List<String> bundledIds;
    private List<String> unbundled;

    /* JADX INFO: compiled from: Events.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/segment/analytics/kotlin/core/DestinationMetadata$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/segment/analytics/kotlin/core/DestinationMetadata;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DestinationMetadata> serializer() {
            return DestinationMetadata$$serializer.INSTANCE;
        }
    }

    public DestinationMetadata() {
        this((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DestinationMetadata(int i, List list, List list2, List list3, SerializationConstructorMarker serializationConstructorMarker) {
        this.bundled = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
        if ((i & 2) == 0) {
            this.unbundled = CollectionsKt.emptyList();
        } else {
            this.unbundled = list2;
        }
        if ((i & 4) == 0) {
            this.bundledIds = CollectionsKt.emptyList();
        } else {
            this.bundledIds = list3;
        }
    }

    public DestinationMetadata(List<String> list, List<String> list2, List<String> list3) {
        this.bundled = list;
        this.unbundled = list2;
        this.bundledIds = list3;
    }

    public /* synthetic */ DestinationMetadata(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DestinationMetadata copy$default(DestinationMetadata destinationMetadata, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = destinationMetadata.bundled;
        }
        if ((i & 2) != 0) {
            list2 = destinationMetadata.unbundled;
        }
        if ((i & 4) != 0) {
            list3 = destinationMetadata.bundledIds;
        }
        return destinationMetadata.copy(list, list2, list3);
    }

    @JvmStatic
    public static final void write$Self(DestinationMetadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.bundled, CollectionsKt.emptyList())) {
            output.encodeNullableSerializableElement(serialDesc, 0, new ArrayListSerializer(StringSerializer.INSTANCE), self.bundled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.unbundled, CollectionsKt.emptyList())) {
            output.encodeNullableSerializableElement(serialDesc, 1, new ArrayListSerializer(StringSerializer.INSTANCE), self.unbundled);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.bundledIds, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, new ArrayListSerializer(StringSerializer.INSTANCE), self.bundledIds);
    }

    public final List<String> component1() {
        return this.bundled;
    }

    public final List<String> component2() {
        return this.unbundled;
    }

    public final List<String> component3() {
        return this.bundledIds;
    }

    public final DestinationMetadata copy(List<String> bundled, List<String> unbundled, List<String> bundledIds) {
        return new DestinationMetadata(bundled, unbundled, bundledIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DestinationMetadata)) {
            return false;
        }
        DestinationMetadata destinationMetadata = (DestinationMetadata) other;
        return Intrinsics.areEqual(this.bundled, destinationMetadata.bundled) && Intrinsics.areEqual(this.unbundled, destinationMetadata.unbundled) && Intrinsics.areEqual(this.bundledIds, destinationMetadata.bundledIds);
    }

    public final List<String> getBundled() {
        return this.bundled;
    }

    public final List<String> getBundledIds() {
        return this.bundledIds;
    }

    public final List<String> getUnbundled() {
        return this.unbundled;
    }

    public int hashCode() {
        List<String> list = this.bundled;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.unbundled;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.bundledIds;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setBundled(List<String> list) {
        this.bundled = list;
    }

    public final void setBundledIds(List<String> list) {
        this.bundledIds = list;
    }

    public final void setUnbundled(List<String> list) {
        this.unbundled = list;
    }

    public String toString() {
        return "DestinationMetadata(bundled=" + this.bundled + ", unbundled=" + this.unbundled + ", bundledIds=" + this.bundledIds + ')';
    }
}
