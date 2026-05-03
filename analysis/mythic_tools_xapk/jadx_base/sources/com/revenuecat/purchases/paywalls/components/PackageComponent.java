package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.paywalls.components.common.ResilientPromoOfferConfigSerializer;
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: PackageComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@SerialName("package")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.Be\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013BK\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e¢\u0006\u0002\u0010\u0014J&\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÁ\u0001¢\u0006\u0002\b,R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0006\u0010\u0017R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#¨\u0006/"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PackageComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "packageId", "", "isSelectedByDefault", "", "stack", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "playStoreOffer", "Lcom/revenuecat/purchases/paywalls/components/common/PromoOfferConfig;", "visible", "overrides", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lcom/revenuecat/purchases/paywalls/components/PartialPackageComponent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/common/PromoOfferConfig;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ZLcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/common/PromoOfferConfig;Ljava/lang/Boolean;Ljava/util/List;)V", "isSelectedByDefault$annotations", "()V", "()Z", "getOverrides", "()Ljava/util/List;", "getPackageId$annotations", "getPackageId", "()Ljava/lang/String;", "getPlayStoreOffer$annotations", "getPlayStoreOffer", "()Lcom/revenuecat/purchases/paywalls/components/common/PromoOfferConfig;", "getStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class PackageComponent implements PaywallComponent {
    private final boolean isSelectedByDefault;
    private final List<ComponentOverride<PartialPackageComponent>> overrides;
    private final String packageId;
    private final PromoOfferConfig playStoreOffer;
    private final StackComponent stack;
    private final Boolean visible;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(ComponentOverride.INSTANCE.serializer(PartialPackageComponent$$serializer.INSTANCE))};

    /* JADX INFO: compiled from: PackageComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PackageComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PackageComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PackageComponent> serializer() {
            return PackageComponent$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PackageComponent(int i, @SerialName("package_id") String str, @SerialName("is_selected_by_default") boolean z, StackComponent stackComponent, @SerialName("play_store_offer") @Serializable(with = ResilientPromoOfferConfigSerializer.class) PromoOfferConfig promoOfferConfig, Boolean bool, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, PackageComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.packageId = str;
        this.isSelectedByDefault = z;
        this.stack = stackComponent;
        if ((i & 8) == 0) {
            this.playStoreOffer = null;
        } else {
            this.playStoreOffer = promoOfferConfig;
        }
        if ((i & 16) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i & 32) == 0) {
            this.overrides = CollectionsKt.emptyList();
        } else {
            this.overrides = list;
        }
    }

    public PackageComponent(String packageId, boolean z, StackComponent stack, PromoOfferConfig promoOfferConfig, Boolean bool, List<ComponentOverride<PartialPackageComponent>> overrides) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.packageId = packageId;
        this.isSelectedByDefault = z;
        this.stack = stack;
        this.playStoreOffer = promoOfferConfig;
        this.visible = bool;
        this.overrides = overrides;
    }

    public /* synthetic */ PackageComponent(String str, boolean z, StackComponent stackComponent, PromoOfferConfig promoOfferConfig, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, stackComponent, (i & 8) != 0 ? null : promoOfferConfig, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    @SerialName("package_id")
    public static /* synthetic */ void getPackageId$annotations() {
    }

    @SerialName("play_store_offer")
    @Serializable(with = ResilientPromoOfferConfigSerializer.class)
    public static /* synthetic */ void getPlayStoreOffer$annotations() {
    }

    @SerialName("is_selected_by_default")
    public static /* synthetic */ void isSelectedByDefault$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PackageComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.packageId);
        output.encodeBooleanElement(serialDesc, 1, self.isSelectedByDefault);
        output.encodeSerializableElement(serialDesc, 2, StackComponent$$serializer.INSTANCE, self.stack);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.playStoreOffer != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, ResilientPromoOfferConfigSerializer.INSTANCE, self.playStoreOffer);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.visible != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.visible);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.overrides, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PackageComponent)) {
            return false;
        }
        PackageComponent packageComponent = (PackageComponent) obj;
        return Intrinsics.areEqual(this.packageId, packageComponent.packageId) && this.isSelectedByDefault == packageComponent.isSelectedByDefault && Intrinsics.areEqual(this.stack, packageComponent.stack) && Intrinsics.areEqual(this.playStoreOffer, packageComponent.playStoreOffer) && Intrinsics.areEqual(this.visible, packageComponent.visible) && Intrinsics.areEqual(this.overrides, packageComponent.overrides);
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ String getPackageId() {
        return this.packageId;
    }

    public final /* synthetic */ PromoOfferConfig getPlayStoreOffer() {
        return this.playStoreOffer;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((this.packageId.hashCode() * 31) + Boolean.hashCode(this.isSelectedByDefault)) * 31) + this.stack.hashCode()) * 31;
        PromoOfferConfig promoOfferConfig = this.playStoreOffer;
        int iHashCode2 = (iHashCode + (promoOfferConfig == null ? 0 : promoOfferConfig.hashCode())) * 31;
        Boolean bool = this.visible;
        return ((iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    /* JADX INFO: renamed from: isSelectedByDefault, reason: from getter */
    public final /* synthetic */ boolean getIsSelectedByDefault() {
        return this.isSelectedByDefault;
    }

    public String toString() {
        return "PackageComponent(packageId=" + this.packageId + ", isSelectedByDefault=" + this.isSelectedByDefault + ", stack=" + this.stack + ", playStoreOffer=" + this.playStoreOffer + ", visible=" + this.visible + ", overrides=" + this.overrides + ')';
    }
}
