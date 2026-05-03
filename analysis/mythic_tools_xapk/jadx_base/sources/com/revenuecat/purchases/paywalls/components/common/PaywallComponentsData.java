package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import java.util.List;
import java.util.Map;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PaywallComponentsData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 A2\u00020\u0001:\u0002@AB©\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\"\b\u0001\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f\u0018\u00010\f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aB\u0083\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f0\f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u001bJ&\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>HÁ\u0001¢\u0006\u0002\b?R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\"R4\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f0\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010%R$\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010)\u0012\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010(R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010,R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001d\u001a\u0004\b/\u00100R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001d\u001a\u0004\b4\u0010(R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001d\u001a\u0004\b6\u00107\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "", "seen1", "", "id", "", "templateName", "assetBaseURL", "Ljava/net/URL;", "componentsConfig", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentsConfig;", "componentsLocalizations", "", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "defaultLocaleIdentifier", "revision", "zeroDecimalPlaceCountries", "", "exitOffers", "Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;", "productChangeConfig", "Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/net/URL;Lcom/revenuecat/purchases/paywalls/components/common/ComponentsConfig;Ljava/util/Map;Ljava/lang/String;ILjava/util/List;Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Lcom/revenuecat/purchases/paywalls/components/common/ComponentsConfig;Ljava/util/Map;Ljava/lang/String;ILjava/util/List;Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAssetBaseURL$annotations", "()V", "getAssetBaseURL", "()Ljava/net/URL;", "getComponentsConfig$annotations", "getComponentsConfig", "()Lcom/revenuecat/purchases/paywalls/components/common/ComponentsConfig;", "getComponentsLocalizations$annotations", "getComponentsLocalizations", "()Ljava/util/Map;", "getDefaultLocaleIdentifier-uqtKvyA$annotations", "getDefaultLocaleIdentifier-uqtKvyA", "()Ljava/lang/String;", "Ljava/lang/String;", "getExitOffers$annotations", "getExitOffers", "()Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;", "getId", "getProductChangeConfig$annotations", "getProductChangeConfig", "()Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "getRevision", "()I", "getTemplateName$annotations", "getTemplateName", "getZeroDecimalPlaceCountries$annotations", "getZeroDecimalPlaceCountries", "()Ljava/util/List;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class PaywallComponentsData {
    private final URL assetBaseURL;
    private final ComponentsConfig componentsConfig;
    private final Map<LocaleId, Map<LocalizationKey, LocalizationData>> componentsLocalizations;
    private final String defaultLocaleIdentifier;
    private final ExitOffers exitOffers;
    private final String id;
    private final ProductChangeConfig productChangeConfig;
    private final int revision;
    private final String templateName;
    private final List<String> zeroDecimalPlaceCountries;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, new LinkedHashMapSerializer(LocaleId$$serializer.INSTANCE, new LinkedHashMapSerializer(LocalizationKey$$serializer.INSTANCE, LocalizationDataSerializer.INSTANCE)), null, null, null, null, null};

    /* JADX INFO: compiled from: PaywallComponentsData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PaywallComponentsData> serializer() {
            return PaywallComponentsData$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaywallComponentsData(int i, String str, String str2, URL url, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> map, String str3, int i2, List<String> list, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, SerializationConstructorMarker serializationConstructorMarker) {
        if (62 != (i & 62)) {
            PluginExceptionsKt.throwMissingFieldException(i, 62, PaywallComponentsData$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
        this.templateName = str2;
        this.assetBaseURL = url;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = map;
        this.defaultLocaleIdentifier = str3;
        if ((i & 64) == 0) {
            this.revision = 0;
        } else {
            this.revision = i2;
        }
        if ((i & 128) == 0) {
            this.zeroDecimalPlaceCountries = CollectionsKt.emptyList();
        } else {
            this.zeroDecimalPlaceCountries = list;
        }
        if ((i & 256) == 0) {
            this.exitOffers = null;
        } else {
            this.exitOffers = exitOffers;
        }
        if ((i & 512) == 0) {
            this.productChangeConfig = null;
        } else {
            this.productChangeConfig = productChangeConfig;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PaywallComponentsData(int i, String str, @SerialName("template_name") String str2, @SerialName("asset_base_url") @Serializable(with = URLSerializer.class) URL url, @SerialName("components_config") ComponentsConfig componentsConfig, @SerialName("components_localizations") Map map, @SerialName("default_locale") String str3, int i2, @SerialName("zero_decimal_place_countries") @Serializable(with = GoogleListSerializer.class) List list, @SerialName("exit_offers") ExitOffers exitOffers, @SerialName("play_store_product_change_mode") @Serializable(with = ProductChangeConfigSerializer.class) ProductChangeConfig productChangeConfig, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, url, componentsConfig, (Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>>) map, str3, i2, (List<String>) list, exitOffers, productChangeConfig, serializationConstructorMarker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaywallComponentsData(String str, String templateName, URL assetBaseURL, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> componentsLocalizations, String defaultLocaleIdentifier, int i, List<String> zeroDecimalPlaceCountries, ExitOffers exitOffers, ProductChangeConfig productChangeConfig) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(componentsConfig, "componentsConfig");
        Intrinsics.checkNotNullParameter(componentsLocalizations, "componentsLocalizations");
        Intrinsics.checkNotNullParameter(defaultLocaleIdentifier, "defaultLocaleIdentifier");
        Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        this.id = str;
        this.templateName = templateName;
        this.assetBaseURL = assetBaseURL;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = componentsLocalizations;
        this.defaultLocaleIdentifier = defaultLocaleIdentifier;
        this.revision = i;
        this.zeroDecimalPlaceCountries = zeroDecimalPlaceCountries;
        this.exitOffers = exitOffers;
        this.productChangeConfig = productChangeConfig;
    }

    public /* synthetic */ PaywallComponentsData(String str, String str2, URL url, ComponentsConfig componentsConfig, Map map, String str3, int i, List list, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, str2, url, componentsConfig, map, str3, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? CollectionsKt.emptyList() : list, (i2 & 256) != 0 ? null : exitOffers, (i2 & 512) != 0 ? null : productChangeConfig, null);
    }

    public /* synthetic */ PaywallComponentsData(String str, String str2, URL url, ComponentsConfig componentsConfig, Map map, String str3, int i, List list, ExitOffers exitOffers, ProductChangeConfig productChangeConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, url, componentsConfig, map, str3, i, list, exitOffers, productChangeConfig);
    }

    @SerialName("asset_base_url")
    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    @SerialName("components_config")
    public static /* synthetic */ void getComponentsConfig$annotations() {
    }

    @SerialName("components_localizations")
    public static /* synthetic */ void getComponentsLocalizations$annotations() {
    }

    @SerialName("default_locale")
    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA$annotations, reason: not valid java name */
    public static /* synthetic */ void m10437getDefaultLocaleIdentifieruqtKvyA$annotations() {
    }

    @SerialName("exit_offers")
    public static /* synthetic */ void getExitOffers$annotations() {
    }

    @SerialName("play_store_product_change_mode")
    @Serializable(with = ProductChangeConfigSerializer.class)
    public static /* synthetic */ void getProductChangeConfig$annotations() {
    }

    @SerialName("template_name")
    public static /* synthetic */ void getTemplateName$annotations() {
    }

    @SerialName("zero_decimal_place_countries")
    @Serializable(with = GoogleListSerializer.class)
    public static /* synthetic */ void getZeroDecimalPlaceCountries$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallComponentsData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
        }
        output.encodeStringElement(serialDesc, 1, self.templateName);
        output.encodeSerializableElement(serialDesc, 2, URLSerializer.INSTANCE, self.assetBaseURL);
        output.encodeSerializableElement(serialDesc, 3, ComponentsConfig$$serializer.INSTANCE, self.componentsConfig);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.componentsLocalizations);
        output.encodeSerializableElement(serialDesc, 5, LocaleId$$serializer.INSTANCE, LocaleId.m10392boximpl(self.defaultLocaleIdentifier));
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.revision != 0) {
            output.encodeIntElement(serialDesc, 6, self.revision);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.zeroDecimalPlaceCountries, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 7, GoogleListSerializer.INSTANCE, self.zeroDecimalPlaceCountries);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.exitOffers != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, ExitOffers$$serializer.INSTANCE, self.exitOffers);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.productChangeConfig == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, ProductChangeConfigSerializer.INSTANCE, self.productChangeConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallComponentsData)) {
            return false;
        }
        PaywallComponentsData paywallComponentsData = (PaywallComponentsData) obj;
        return Intrinsics.areEqual(this.id, paywallComponentsData.id) && Intrinsics.areEqual(this.templateName, paywallComponentsData.templateName) && Intrinsics.areEqual(this.assetBaseURL, paywallComponentsData.assetBaseURL) && Intrinsics.areEqual(this.componentsConfig, paywallComponentsData.componentsConfig) && Intrinsics.areEqual(this.componentsLocalizations, paywallComponentsData.componentsLocalizations) && LocaleId.m10395equalsimpl0(this.defaultLocaleIdentifier, paywallComponentsData.defaultLocaleIdentifier) && this.revision == paywallComponentsData.revision && Intrinsics.areEqual(this.zeroDecimalPlaceCountries, paywallComponentsData.zeroDecimalPlaceCountries) && Intrinsics.areEqual(this.exitOffers, paywallComponentsData.exitOffers) && Intrinsics.areEqual(this.productChangeConfig, paywallComponentsData.productChangeConfig);
    }

    public final /* synthetic */ URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final /* synthetic */ ComponentsConfig getComponentsConfig() {
        return this.componentsConfig;
    }

    public final /* synthetic */ Map getComponentsLocalizations() {
        return this.componentsLocalizations;
    }

    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA, reason: not valid java name and from getter */
    public final /* synthetic */ String getDefaultLocaleIdentifier() {
        return this.defaultLocaleIdentifier;
    }

    public final /* synthetic */ ExitOffers getExitOffers() {
        return this.exitOffers;
    }

    public final /* synthetic */ String getId() {
        return this.id;
    }

    public final /* synthetic */ ProductChangeConfig getProductChangeConfig() {
        return this.productChangeConfig;
    }

    public final /* synthetic */ int getRevision() {
        return this.revision;
    }

    public final /* synthetic */ String getTemplateName() {
        return this.templateName;
    }

    public final /* synthetic */ List getZeroDecimalPlaceCountries() {
        return this.zeroDecimalPlaceCountries;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.templateName.hashCode()) * 31) + this.assetBaseURL.hashCode()) * 31) + this.componentsConfig.hashCode()) * 31) + this.componentsLocalizations.hashCode()) * 31) + LocaleId.m10396hashCodeimpl(this.defaultLocaleIdentifier)) * 31) + this.revision) * 31) + this.zeroDecimalPlaceCountries.hashCode()) * 31;
        ExitOffers exitOffers = this.exitOffers;
        int iHashCode2 = (iHashCode + (exitOffers == null ? 0 : exitOffers.hashCode())) * 31;
        ProductChangeConfig productChangeConfig = this.productChangeConfig;
        return iHashCode2 + (productChangeConfig != null ? productChangeConfig.hashCode() : 0);
    }

    public String toString() {
        return "PaywallComponentsData(id=" + this.id + ", templateName=" + this.templateName + ", assetBaseURL=" + this.assetBaseURL + ", componentsConfig=" + this.componentsConfig + ", componentsLocalizations=" + this.componentsLocalizations + ", defaultLocaleIdentifier=" + ((Object) LocaleId.m10397toStringimpl(this.defaultLocaleIdentifier)) + ", revision=" + this.revision + ", zeroDecimalPlaceCountries=" + this.zeroDecimalPlaceCountries + ", exitOffers=" + this.exitOffers + ", productChangeConfig=" + this.productChangeConfig + ')';
    }
}
