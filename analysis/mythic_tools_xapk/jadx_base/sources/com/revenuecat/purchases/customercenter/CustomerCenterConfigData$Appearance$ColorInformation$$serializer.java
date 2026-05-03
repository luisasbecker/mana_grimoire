package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.PaywallColor;
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

/* JADX INFO: compiled from: CustomerCenterConfigData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.Appearance.ColorInformation.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CustomerCenterConfigData$Appearance$ColorInformation$$serializer implements GeneratedSerializer<CustomerCenterConfigData.Appearance.ColorInformation> {
    public static final CustomerCenterConfigData$Appearance$ColorInformation$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$Appearance$ColorInformation$$serializer customerCenterConfigData$Appearance$ColorInformation$$serializer = new CustomerCenterConfigData$Appearance$ColorInformation$$serializer();
        INSTANCE = customerCenterConfigData$Appearance$ColorInformation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance.ColorInformation", customerCenterConfigData$Appearance$ColorInformation$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("accent_color", true);
        pluginGeneratedSerialDescriptor.addElement("text_color", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("button_text_color", true);
        pluginGeneratedSerialDescriptor.addElement("button_background_color", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$Appearance$ColorInformation$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.Appearance.ColorInformation deserialize(Decoder decoder) {
        int i;
        PaywallColor paywallColor;
        PaywallColor paywallColor2;
        PaywallColor paywallColor3;
        PaywallColor paywallColor4;
        PaywallColor paywallColor5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        PaywallColor paywallColor6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            PaywallColor paywallColor7 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor8 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor9 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallColor.Serializer.INSTANCE, null);
            paywallColor = paywallColor7;
            paywallColor4 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallColor.Serializer.INSTANCE, null);
            paywallColor5 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, PaywallColor.Serializer.INSTANCE, null);
            paywallColor3 = paywallColor9;
            paywallColor2 = paywallColor8;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            PaywallColor paywallColor10 = null;
            PaywallColor paywallColor11 = null;
            PaywallColor paywallColor12 = null;
            PaywallColor paywallColor13 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    paywallColor6 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, PaywallColor.Serializer.INSTANCE, paywallColor6);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    paywallColor10 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, PaywallColor.Serializer.INSTANCE, paywallColor10);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    paywallColor11 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallColor.Serializer.INSTANCE, paywallColor11);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    paywallColor12 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallColor.Serializer.INSTANCE, paywallColor12);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    paywallColor13 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, PaywallColor.Serializer.INSTANCE, paywallColor13);
                    i2 |= 16;
                }
            }
            i = i2;
            paywallColor = paywallColor6;
            paywallColor2 = paywallColor10;
            paywallColor3 = paywallColor11;
            paywallColor4 = paywallColor12;
            paywallColor5 = paywallColor13;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CustomerCenterConfigData.Appearance.ColorInformation(i, paywallColor, paywallColor2, paywallColor3, paywallColor4, paywallColor5, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.Appearance.ColorInformation value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CustomerCenterConfigData.Appearance.ColorInformation.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
