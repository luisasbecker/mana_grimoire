package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PaywallData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallData$$serializer implements GeneratedSerializer<PaywallData> {
    public static final PaywallData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$$serializer paywallData$$serializer = new PaywallData$$serializer();
        INSTANCE = paywallData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData", paywallData$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("template_name", false);
        pluginGeneratedSerialDescriptor.addElement("config", false);
        pluginGeneratedSerialDescriptor.addElement("asset_base_url", false);
        pluginGeneratedSerialDescriptor.addElement("revision", true);
        pluginGeneratedSerialDescriptor.addElement("localized_strings", false);
        pluginGeneratedSerialDescriptor.addElement("localized_strings_by_tier", true);
        pluginGeneratedSerialDescriptor.addElement("zero_decimal_place_countries", true);
        pluginGeneratedSerialDescriptor.addElement("default_locale", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PaywallData.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, PaywallData$Configuration$$serializer.INSTANCE, URLSerializer.INSTANCE, IntSerializer.INSTANCE, kSerializerArr[5], kSerializerArr[6], GoogleListSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData deserialize(Decoder decoder) {
        URL url;
        int i;
        String str;
        PaywallData.Configuration configuration;
        String str2;
        int i2;
        Map map;
        List list;
        Map map2;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PaywallData.$childSerializers;
        int i3 = 7;
        int i4 = 8;
        int i5 = 6;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            PaywallData.Configuration configuration2 = (PaywallData.Configuration) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, PaywallData$Configuration$$serializer.INSTANCE, null);
            URL url2 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, URLSerializer.INSTANCE, null);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 4);
            Map map3 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            map = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            str2 = str4;
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, GoogleListSerializer.INSTANCE, null);
            url = url2;
            str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            i2 = iDecodeIntElement;
            configuration = configuration2;
            map2 = map3;
            str = strDecodeStringElement;
            i = 511;
        } else {
            int i6 = 5;
            boolean z = true;
            int iDecodeIntElement2 = 0;
            Map map4 = null;
            List list2 = null;
            Map map5 = null;
            String str5 = null;
            URL url3 = null;
            String str6 = null;
            String strDecodeStringElement2 = null;
            int i7 = 0;
            PaywallData.Configuration configuration3 = null;
            while (z) {
                int i8 = i5;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = 8;
                        i5 = 6;
                        i6 = 5;
                        break;
                    case 0:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str6);
                        i7 |= 1;
                        i3 = 7;
                        i4 = 8;
                        i5 = 6;
                        i6 = 5;
                        break;
                    case 1:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i7 |= 2;
                        i3 = 7;
                        i4 = 8;
                        i5 = 6;
                        i6 = 5;
                        break;
                    case 2:
                        configuration3 = (PaywallData.Configuration) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, PaywallData$Configuration$$serializer.INSTANCE, configuration3);
                        i7 |= 4;
                        i3 = 7;
                        i4 = 8;
                        i5 = 6;
                        i6 = 5;
                        break;
                    case 3:
                        url3 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, URLSerializer.INSTANCE, url3);
                        i7 |= 8;
                        i3 = 7;
                        i4 = 8;
                        i5 = 6;
                        i6 = 5;
                        break;
                    case 4:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 4);
                        i7 |= 16;
                        i3 = 7;
                        i5 = 6;
                        break;
                    case 5:
                        map5 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i6, kSerializerArr[i6], map5);
                        i7 |= 32;
                        i3 = 7;
                        i5 = 6;
                        break;
                    case 6:
                        map4 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i8, kSerializerArr[i8], map4);
                        i7 |= 64;
                        i5 = i8;
                        i3 = 7;
                        break;
                    case 7:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i3, GoogleListSerializer.INSTANCE, list2);
                        i7 |= 128;
                        i5 = i8;
                        break;
                    case 8:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i4, StringSerializer.INSTANCE, str5);
                        i7 |= 256;
                        i5 = i8;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str7 = strDecodeStringElement2;
            url = url3;
            i = i7;
            str = str7;
            String str8 = str6;
            configuration = configuration3;
            str2 = str8;
            i2 = iDecodeIntElement2;
            map = map4;
            list = list2;
            map2 = map5;
            str3 = str5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallData(i, str2, str, configuration, url, i2, map2, map, list, str3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallData.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
