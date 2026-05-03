package com.revenuecat.purchases.paywalls.components;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: PackageComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013HÁ\u0001¢\u0006\u0002\b\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialPackageComponent;", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "seen1", "", "visible", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;)V", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class PartialPackageComponent implements PartialComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean visible;

    /* JADX INFO: compiled from: PackageComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialPackageComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialPackageComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialPackageComponent> serializer() {
            return PartialPackageComponent$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PartialPackageComponent() {
        this((Boolean) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PartialPackageComponent(int i, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
    }

    public PartialPackageComponent(Boolean bool) {
        this.visible = bool;
    }

    public /* synthetic */ PartialPackageComponent(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialPackageComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.visible == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.visible);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PartialPackageComponent) && Intrinsics.areEqual(this.visible, ((PartialPackageComponent) obj).visible);
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "PartialPackageComponent(visible=" + this.visible + ')';
    }
}
