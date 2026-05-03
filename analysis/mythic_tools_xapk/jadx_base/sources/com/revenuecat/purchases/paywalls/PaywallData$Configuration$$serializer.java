package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PaywallData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallData$Configuration$$serializer implements GeneratedSerializer<PaywallData.Configuration> {
    public static final PaywallData$Configuration$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$Configuration$$serializer paywallData$Configuration$$serializer = new PaywallData$Configuration$$serializer();
        INSTANCE = paywallData$Configuration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration", paywallData$Configuration$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("packages", true);
        pluginGeneratedSerialDescriptor.addElement("default_package", true);
        pluginGeneratedSerialDescriptor.addElement("images_webp", true);
        pluginGeneratedSerialDescriptor.addElement("images", true);
        pluginGeneratedSerialDescriptor.addElement("images_by_tier", true);
        pluginGeneratedSerialDescriptor.addElement("blurred_background_image", true);
        pluginGeneratedSerialDescriptor.addElement("display_restore_purchases", true);
        pluginGeneratedSerialDescriptor.addElement("tos_url", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_url", true);
        pluginGeneratedSerialDescriptor.addElement("colors", false);
        pluginGeneratedSerialDescriptor.addElement("colors_by_tier", true);
        pluginGeneratedSerialDescriptor.addElement("tiers", true);
        pluginGeneratedSerialDescriptor.addElement("default_tier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PaywallData.Configuration.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallData$Configuration$Images$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallData$Configuration$Images$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[4]), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(OptionalURLSerializer.INSTANCE), BuiltinSerializersKt.getNullable(OptionalURLSerializer.INSTANCE), PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(kSerializerArr[10]), BuiltinSerializersKt.getNullable(kSerializerArr[11]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.Configuration deserialize(Decoder decoder) {
        List list;
        PaywallData.Configuration.Images images;
        int i;
        String str;
        String str2;
        Map map;
        PaywallData.Configuration.ColorInformation colorInformation;
        URL url;
        Map map2;
        List list2;
        PaywallData.Configuration.Images images2;
        boolean z;
        URL url2;
        boolean z2;
        KSerializer[] kSerializerArr;
        KSerializer[] kSerializerArr2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr3 = PaywallData.Configuration.$childSerializers;
        int i2 = 10;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr3[0], null);
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            PaywallData.Configuration.Images images3 = (PaywallData.Configuration.Images) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, null);
            PaywallData.Configuration.Images images4 = (PaywallData.Configuration.Images) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, null);
            Map map3 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr3[4], null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
            URL url3 = (URL) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, OptionalURLSerializer.INSTANCE, null);
            URL url4 = (URL) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, OptionalURLSerializer.INSTANCE, null);
            PaywallData.Configuration.ColorInformation colorInformation2 = (PaywallData.Configuration.ColorInformation) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, null);
            Map map4 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, kSerializerArr3[10], null);
            str = str3;
            list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, kSerializerArr3[11], null);
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            colorInformation = colorInformation2;
            url2 = url3;
            z = zDecodeBooleanElement2;
            z2 = zDecodeBooleanElement;
            images2 = images4;
            url = url4;
            images = images3;
            i = 8191;
            map = map4;
            map2 = map3;
        } else {
            int i3 = 0;
            int i4 = 12;
            boolean zDecodeBooleanElement3 = false;
            String str4 = null;
            Map map5 = null;
            PaywallData.Configuration.ColorInformation colorInformation3 = null;
            URL url5 = null;
            Map map6 = null;
            List list3 = null;
            PaywallData.Configuration.Images images5 = null;
            List list4 = null;
            String str5 = null;
            int i5 = 4;
            boolean z3 = true;
            boolean zDecodeBooleanElement4 = false;
            URL url6 = null;
            PaywallData.Configuration.Images images6 = null;
            while (z3) {
                int i6 = i2;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z3 = false;
                        i3 = i3;
                        i2 = 10;
                        i5 = 4;
                        str5 = str5;
                        i4 = 12;
                        break;
                    case 0:
                        kSerializerArr = kSerializerArr3;
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], list4);
                        i3 |= 1;
                        str5 = str5;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 12;
                        i2 = 10;
                        i5 = 4;
                        break;
                    case 1:
                        kSerializerArr = kSerializerArr3;
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str5);
                        i3 |= 2;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 12;
                        i2 = 10;
                        i5 = 4;
                        break;
                    case 2:
                        kSerializerArr = kSerializerArr3;
                        images6 = (PaywallData.Configuration.Images) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, images6);
                        i3 |= 4;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 12;
                        i2 = 10;
                        i5 = 4;
                        break;
                    case 3:
                        kSerializerArr = kSerializerArr3;
                        images5 = (PaywallData.Configuration.Images) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, images5);
                        i3 |= 8;
                        kSerializerArr3 = kSerializerArr;
                        i4 = 12;
                        i2 = 10;
                        i5 = 4;
                        break;
                    case 4:
                        kSerializerArr2 = kSerializerArr3;
                        map6 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i5, kSerializerArr2[i5], map6);
                        i3 |= 16;
                        kSerializerArr3 = kSerializerArr2;
                        i4 = 12;
                        i2 = 10;
                        break;
                    case 5:
                        kSerializerArr2 = kSerializerArr3;
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
                        i3 |= 32;
                        kSerializerArr3 = kSerializerArr2;
                        i4 = 12;
                        i2 = 10;
                        break;
                    case 6:
                        kSerializerArr2 = kSerializerArr3;
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
                        i3 |= 64;
                        kSerializerArr3 = kSerializerArr2;
                        i4 = 12;
                        i2 = 10;
                        break;
                    case 7:
                        kSerializerArr2 = kSerializerArr3;
                        url6 = (URL) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, OptionalURLSerializer.INSTANCE, url6);
                        i3 |= 128;
                        kSerializerArr3 = kSerializerArr2;
                        i4 = 12;
                        i2 = 10;
                        break;
                    case 8:
                        kSerializerArr2 = kSerializerArr3;
                        url5 = (URL) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, OptionalURLSerializer.INSTANCE, url5);
                        i3 |= 256;
                        kSerializerArr3 = kSerializerArr2;
                        i4 = 12;
                        i2 = 10;
                        break;
                    case 9:
                        kSerializerArr2 = kSerializerArr3;
                        colorInformation3 = (PaywallData.Configuration.ColorInformation) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, colorInformation3);
                        i3 |= 512;
                        kSerializerArr3 = kSerializerArr2;
                        i4 = 12;
                        i2 = 10;
                        break;
                    case 10:
                        map5 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i6, kSerializerArr3[i6], map5);
                        i3 |= 1024;
                        i2 = i6;
                        kSerializerArr3 = kSerializerArr3;
                        i4 = 12;
                        break;
                    case 11:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, kSerializerArr3[11], list3);
                        i3 |= 2048;
                        i2 = i6;
                        i4 = 12;
                        break;
                    case 12:
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i4, StringSerializer.INSTANCE, str4);
                        i3 |= 4096;
                        i2 = i6;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str6 = str5;
            int i7 = i3;
            list = list4;
            images = images6;
            i = i7;
            str = str6;
            str2 = str4;
            map = map5;
            colorInformation = colorInformation3;
            url = url5;
            map2 = map6;
            list2 = list3;
            images2 = images5;
            z = zDecodeBooleanElement4;
            url2 = url6;
            z2 = zDecodeBooleanElement3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallData.Configuration(i, list, str, images, images2, map2, z2, z, url2, url, colorInformation, map, list2, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.Configuration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallData.Configuration.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
