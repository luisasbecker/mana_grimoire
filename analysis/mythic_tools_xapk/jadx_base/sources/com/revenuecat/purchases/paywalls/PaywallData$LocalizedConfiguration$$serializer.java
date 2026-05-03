package com.revenuecat.purchases.paywalls;

import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.paywalls.PaywallData;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PaywallData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.LocalizedConfiguration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallData$LocalizedConfiguration$$serializer implements GeneratedSerializer<PaywallData.LocalizedConfiguration> {
    public static final PaywallData$LocalizedConfiguration$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$LocalizedConfiguration$$serializer paywallData$LocalizedConfiguration$$serializer = new PaywallData$LocalizedConfiguration$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration", paywallData$LocalizedConfiguration$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement(Constants.GP_IAP_TITLE, false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_with_intro_offer", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_with_multiple_intro_offers", true);
        pluginGeneratedSerialDescriptor.addElement("offer_details", true);
        pluginGeneratedSerialDescriptor.addElement("offer_details_with_intro_offer", true);
        pluginGeneratedSerialDescriptor.addElement("offer_details_with_multiple_intro_offers", true);
        pluginGeneratedSerialDescriptor.addElement("offer_name", true);
        pluginGeneratedSerialDescriptor.addElement("features", true);
        pluginGeneratedSerialDescriptor.addElement("tier_name", true);
        pluginGeneratedSerialDescriptor.addElement("offer_overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$LocalizedConfiguration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PaywallData.LocalizedConfiguration.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), kSerializerArr[9], BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), kSerializerArr[11]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.LocalizedConfiguration deserialize(Decoder decoder) {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        String str6;
        Map map;
        String str7;
        String str8;
        String str9;
        String str10;
        List list;
        KSerializer[] kSerializerArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr2 = PaywallData.LocalizedConfiguration.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, EmptyStringToNullSerializer.INSTANCE, null);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, EmptyStringToNullSerializer.INSTANCE, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, EmptyStringToNullSerializer.INSTANCE, null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, EmptyStringToNullSerializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, EmptyStringToNullSerializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, kSerializerArr2[9], null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, EmptyStringToNullSerializer.INSTANCE, null);
            map = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, kSerializerArr2[11], null);
            str5 = str18;
            str2 = str17;
            str6 = strDecodeStringElement2;
            list = list2;
            str7 = str15;
            str = str13;
            i = 4095;
            str3 = str14;
            str8 = str12;
            str4 = str11;
            str10 = strDecodeStringElement;
            str9 = str16;
        } else {
            int i2 = 11;
            List list3 = null;
            String str19 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            str = null;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            int i3 = 9;
            boolean z = true;
            Map map2 = null;
            String str24 = null;
            int i4 = 0;
            String str25 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 0:
                        kSerializerArr = kSerializerArr2;
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 |= 1;
                        kSerializerArr2 = kSerializerArr;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 1:
                        kSerializerArr = kSerializerArr2;
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, EmptyStringToNullSerializer.INSTANCE, str25);
                        i4 |= 2;
                        kSerializerArr2 = kSerializerArr;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 2:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i4 |= 4;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 3:
                        str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, str24);
                        i4 |= 8;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 4:
                        str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, str);
                        i4 |= 16;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 5:
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, EmptyStringToNullSerializer.INSTANCE, str21);
                        i4 |= 32;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 6:
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, EmptyStringToNullSerializer.INSTANCE, str23);
                        i4 |= 64;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 7:
                        str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, EmptyStringToNullSerializer.INSTANCE, str20);
                        i4 |= 128;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 8:
                        str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, EmptyStringToNullSerializer.INSTANCE, str19);
                        i4 |= 256;
                        i2 = 11;
                        i3 = 9;
                        break;
                    case 9:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i3, kSerializerArr2[i3], list3);
                        i4 |= 512;
                        i2 = 11;
                        break;
                    case 10:
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, EmptyStringToNullSerializer.INSTANCE, str22);
                        i4 |= 1024;
                        i2 = 11;
                        break;
                    case 11:
                        map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i2, kSerializerArr2[i2], map2);
                        i4 |= 2048;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str26 = str25;
            str2 = str19;
            i = i4;
            str3 = str21;
            str4 = str26;
            String str27 = strDecodeStringElement4;
            str5 = str22;
            str6 = str27;
            map = map2;
            str7 = str23;
            str8 = str24;
            str9 = str20;
            str10 = strDecodeStringElement3;
            list = list3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallData.LocalizedConfiguration(i, str10, str4, str6, str8, str, str3, str7, str9, str2, list, str5, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.LocalizedConfiguration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallData.LocalizedConfiguration.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
