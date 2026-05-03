package com.revenuecat.purchases.customercenter;

import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
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

/* JADX INFO: compiled from: CustomerCenterConfigData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer implements GeneratedSerializer<CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer> {
    public static final CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer = new CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer", customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("android_offer_id", false);
        pluginGeneratedSerialDescriptor.addElement("eligible", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.GP_IAP_TITLE, false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", false);
        pluginGeneratedSerialDescriptor.addElement("product_mapping", false);
        pluginGeneratedSerialDescriptor.addElement("cross_product_promotions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializerArr[4], kSerializerArr[5]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer deserialize(Decoder decoder) {
        Map map;
        Map map2;
        String str;
        String str2;
        boolean z;
        String str3;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            Map map3 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            str3 = strDecodeStringElement;
            str2 = strDecodeStringElement3;
            str = strDecodeStringElement2;
            i = 63;
            map = map3;
            z = zDecodeBooleanElement;
        } else {
            boolean z2 = true;
            int i2 = 0;
            String strDecodeStringElement4 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            Map map4 = null;
            Map map5 = null;
            boolean zDecodeBooleanElement2 = false;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        continue;
                    case 0:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i2 |= 1;
                        continue;
                    case 1:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i2 |= 8;
                        break;
                    case 4:
                        map4 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], map4);
                        i2 |= 16;
                        break;
                    case 5:
                        map5 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], map5);
                        i2 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            map = map4;
            map2 = map5;
            str = strDecodeStringElement5;
            str2 = strDecodeStringElement6;
            z = zDecodeBooleanElement2;
            str3 = strDecodeStringElement4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer(i, str3, z, str, str2, map, map2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
