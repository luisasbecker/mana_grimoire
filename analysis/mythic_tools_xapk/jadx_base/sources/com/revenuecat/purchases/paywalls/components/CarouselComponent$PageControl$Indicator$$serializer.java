package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UInt;
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
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: compiled from: CarouselComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/CarouselComponent.PageControl.Indicator.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CarouselComponent$PageControl$Indicator$$serializer implements GeneratedSerializer<CarouselComponent.PageControl.Indicator> {
    public static final CarouselComponent$PageControl$Indicator$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = new CarouselComponent$PageControl$Indicator$$serializer();
        INSTANCE = carouselComponent$PageControl$Indicator$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.CarouselComponent.PageControl.Indicator", carouselComponent$PageControl$Indicator$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("width", false);
        pluginGeneratedSerialDescriptor.addElement("height", false);
        pluginGeneratedSerialDescriptor.addElement("color", false);
        pluginGeneratedSerialDescriptor.addElement("stroke_color", true);
        pluginGeneratedSerialDescriptor.addElement("stroke_width", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CarouselComponent$PageControl$Indicator$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{UIntSerializer.INSTANCE, UIntSerializer.INSTANCE, ColorScheme$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(UIntSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CarouselComponent.PageControl.Indicator deserialize(Decoder decoder) {
        int i;
        UInt uInt;
        UInt uInt2;
        ColorScheme colorScheme;
        ColorScheme colorScheme2;
        UInt uInt3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        UInt uInt4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            UInt uInt5 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, UIntSerializer.INSTANCE, null);
            UInt uInt6 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, UIntSerializer.INSTANCE, null);
            ColorScheme colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, null);
            uInt = uInt5;
            colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, null);
            uInt3 = (UInt) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, UIntSerializer.INSTANCE, null);
            colorScheme = colorScheme3;
            uInt2 = uInt6;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            UInt uInt7 = null;
            ColorScheme colorScheme4 = null;
            ColorScheme colorScheme5 = null;
            UInt uInt8 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    uInt4 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, UIntSerializer.INSTANCE, uInt4);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    uInt7 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, UIntSerializer.INSTANCE, uInt7);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    colorScheme4 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme4);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    colorScheme5 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme5);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    uInt8 = (UInt) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, UIntSerializer.INSTANCE, uInt8);
                    i2 |= 16;
                }
            }
            i = i2;
            uInt = uInt4;
            uInt2 = uInt7;
            colorScheme = colorScheme4;
            colorScheme2 = colorScheme5;
            uInt3 = uInt8;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CarouselComponent.PageControl.Indicator(i, uInt, uInt2, colorScheme, colorScheme2, uInt3, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CarouselComponent.PageControl.Indicator value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CarouselComponent.PageControl.Indicator.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
