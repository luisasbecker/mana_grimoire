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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PaywallComponentsData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/common/PaywallComponentsData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallComponentsData$$serializer implements GeneratedSerializer<PaywallComponentsData> {
    public static final PaywallComponentsData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallComponentsData$$serializer paywallComponentsData$$serializer = new PaywallComponentsData$$serializer();
        INSTANCE = paywallComponentsData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData", paywallComponentsData$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("template_name", false);
        pluginGeneratedSerialDescriptor.addElement("asset_base_url", false);
        pluginGeneratedSerialDescriptor.addElement("components_config", false);
        pluginGeneratedSerialDescriptor.addElement("components_localizations", false);
        pluginGeneratedSerialDescriptor.addElement("default_locale", false);
        pluginGeneratedSerialDescriptor.addElement("revision", true);
        pluginGeneratedSerialDescriptor.addElement("zero_decimal_place_countries", true);
        pluginGeneratedSerialDescriptor.addElement("exit_offers", true);
        pluginGeneratedSerialDescriptor.addElement("play_store_product_change_mode", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallComponentsData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, URLSerializer.INSTANCE, ComponentsConfig$$serializer.INSTANCE, PaywallComponentsData.$childSerializers[4], LocaleId$$serializer.INSTANCE, IntSerializer.INSTANCE, GoogleListSerializer.INSTANCE, BuiltinSerializersKt.getNullable(ExitOffers$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ProductChangeConfigSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponentsData deserialize(Decoder decoder) {
        Map map;
        List list;
        ProductChangeConfig productChangeConfig;
        String str;
        int i;
        String str2;
        String str3;
        URL url;
        int i2;
        ExitOffers exitOffers;
        ComponentsConfig componentsConfig;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PaywallComponentsData.$childSerializers;
        int i3 = 9;
        int i4 = 7;
        int i5 = 6;
        int i6 = 4;
        ProductChangeConfig productChangeConfig2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            URL url2 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, URLSerializer.INSTANCE, null);
            ComponentsConfig componentsConfig2 = (ComponentsConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, ComponentsConfig$$serializer.INSTANCE, null);
            Map map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            LocaleId localeId = (LocaleId) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, LocaleId$$serializer.INSTANCE, null);
            String strM10398unboximpl = localeId != null ? localeId.m10398unboximpl() : null;
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 6);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, GoogleListSerializer.INSTANCE, null);
            ExitOffers exitOffers2 = (ExitOffers) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ExitOffers$$serializer.INSTANCE, null);
            map = map2;
            str = str4;
            productChangeConfig = (ProductChangeConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, ProductChangeConfigSerializer.INSTANCE, null);
            list = list2;
            i = iDecodeIntElement;
            str2 = strM10398unboximpl;
            componentsConfig = componentsConfig2;
            exitOffers = exitOffers2;
            url = url2;
            i2 = 1023;
            str3 = strDecodeStringElement;
        } else {
            boolean z = true;
            int i7 = 0;
            int iDecodeIntElement2 = 0;
            Map map3 = null;
            ExitOffers exitOffers3 = null;
            ComponentsConfig componentsConfig3 = null;
            List list3 = null;
            String str5 = null;
            String strM10398unboximpl2 = null;
            URL url3 = null;
            String strDecodeStringElement2 = null;
            while (z) {
                int i8 = i6;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        i6 = i8;
                        z = false;
                        i4 = 7;
                        i5 = 6;
                        break;
                    case 0:
                        i6 = i8;
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str5);
                        i7 |= 1;
                        i3 = 9;
                        i4 = 7;
                        i5 = 6;
                        break;
                    case 1:
                        i6 = i8;
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i7 |= 2;
                        i3 = 9;
                        i4 = 7;
                        i5 = 6;
                        break;
                    case 2:
                        i6 = i8;
                        url3 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, URLSerializer.INSTANCE, url3);
                        i7 |= 4;
                        i3 = 9;
                        i4 = 7;
                        i5 = 6;
                        break;
                    case 3:
                        i6 = i8;
                        componentsConfig3 = (ComponentsConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, ComponentsConfig$$serializer.INSTANCE, componentsConfig3);
                        i7 |= 8;
                        i3 = 9;
                        i4 = 7;
                        break;
                    case 4:
                        i6 = i8;
                        map3 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i6, kSerializerArr[i8], map3);
                        i7 |= 16;
                        i3 = 9;
                        break;
                    case 5:
                        LocaleId localeId2 = (LocaleId) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, LocaleId$$serializer.INSTANCE, strM10398unboximpl2 != null ? LocaleId.m10392boximpl(strM10398unboximpl2) : null);
                        strM10398unboximpl2 = localeId2 != null ? localeId2.m10398unboximpl() : null;
                        i7 |= 32;
                        i6 = i8;
                        i3 = 9;
                        break;
                    case 6:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, i5);
                        i7 |= 64;
                        i6 = i8;
                        break;
                    case 7:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, GoogleListSerializer.INSTANCE, list3);
                        i7 |= 128;
                        i6 = i8;
                        break;
                    case 8:
                        exitOffers3 = (ExitOffers) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ExitOffers$$serializer.INSTANCE, exitOffers3);
                        i7 |= 256;
                        i6 = i8;
                        break;
                    case 9:
                        productChangeConfig2 = (ProductChangeConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, ProductChangeConfigSerializer.INSTANCE, productChangeConfig2);
                        i7 |= 512;
                        i6 = i8;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            URL url4 = url3;
            map = map3;
            list = list3;
            productChangeConfig = productChangeConfig2;
            str = str5;
            i = iDecodeIntElement2;
            str2 = strM10398unboximpl2;
            str3 = strDecodeStringElement2;
            url = url4;
            i2 = i7;
            exitOffers = exitOffers3;
            componentsConfig = componentsConfig3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallComponentsData(i2, str, str3, url, componentsConfig, map, str2, i, list, exitOffers, productChangeConfig, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponentsData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallComponentsData.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
