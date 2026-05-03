package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
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

/* JADX INFO: compiled from: CarouselComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/CarouselComponent.PageControl.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CarouselComponent$PageControl$$serializer implements GeneratedSerializer<CarouselComponent.PageControl> {
    public static final CarouselComponent$PageControl$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CarouselComponent$PageControl$$serializer carouselComponent$PageControl$$serializer = new CarouselComponent$PageControl$$serializer();
        INSTANCE = carouselComponent$PageControl$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.CarouselComponent.PageControl", carouselComponent$PageControl$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("position", false);
        pluginGeneratedSerialDescriptor.addElement("spacing", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("shape", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, false);
        pluginGeneratedSerialDescriptor.addElement("default", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CarouselComponent$PageControl$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{CarouselPageControlPositionDeserializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CarouselComponent.PageControl deserialize(Decoder decoder) {
        ColorScheme colorScheme;
        Border border;
        CarouselComponent.PageControl.Position position;
        Shape shape;
        Padding padding;
        CarouselComponent.PageControl.Indicator indicator;
        Integer num;
        Shadow shadow;
        Padding padding2;
        CarouselComponent.PageControl.Indicator indicator2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 9;
        CarouselComponent.PageControl.Position position2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            CarouselComponent.PageControl.Position position3 = (CarouselComponent.PageControl.Position) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, CarouselPageControlPositionDeserializer.INSTANCE, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Padding$$serializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Shadow$$serializer.INSTANCE, null);
            CarouselComponent.PageControl.Indicator indicator3 = (CarouselComponent.PageControl.Indicator) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, null);
            shape = shape2;
            i = 1023;
            indicator = (CarouselComponent.PageControl.Indicator) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, null);
            shadow = shadow2;
            border = border2;
            indicator2 = indicator3;
            num = num2;
            colorScheme = colorScheme2;
            padding2 = padding3;
            padding = padding4;
            position = position3;
        } else {
            boolean z = true;
            int i3 = 0;
            CarouselComponent.PageControl.Indicator indicator4 = null;
            CarouselComponent.PageControl.Indicator indicator5 = null;
            Border border3 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            colorScheme = null;
            Padding padding5 = null;
            Integer num3 = null;
            Padding padding6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                        break;
                    case 0:
                        position2 = (CarouselComponent.PageControl.Position) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, CarouselPageControlPositionDeserializer.INSTANCE, position2);
                        i3 |= 1;
                        i2 = 9;
                        break;
                    case 1:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, num3);
                        i3 |= 2;
                        i2 = 9;
                        break;
                    case 2:
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, Padding$$serializer.INSTANCE, padding6);
                        i3 |= 4;
                        i2 = 9;
                        break;
                    case 3:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 8;
                        i2 = 9;
                        break;
                    case 4:
                        colorScheme = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme);
                        i3 |= 16;
                        i2 = 9;
                        break;
                    case 5:
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ShapeDeserializer.INSTANCE, shape3);
                        i3 |= 32;
                        i2 = 9;
                        break;
                    case 6:
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, Border$$serializer.INSTANCE, border3);
                        i3 |= 64;
                        i2 = 9;
                        break;
                    case 7:
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Shadow$$serializer.INSTANCE, shadow3);
                        i3 |= 128;
                        i2 = 9;
                        break;
                    case 8:
                        indicator5 = (CarouselComponent.PageControl.Indicator) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, indicator5);
                        i3 |= 256;
                        break;
                    case 9:
                        indicator4 = (CarouselComponent.PageControl.Indicator) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i2, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, indicator4);
                        i3 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            CarouselComponent.PageControl.Position position4 = position2;
            border = border3;
            position = position4;
            Padding padding7 = padding5;
            shape = shape3;
            padding = padding7;
            indicator = indicator4;
            num = num3;
            shadow = shadow3;
            padding2 = padding6;
            indicator2 = indicator5;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CarouselComponent.PageControl(i, position, num, padding2, padding, colorScheme, shape, border, shadow, indicator2, indicator, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CarouselComponent.PageControl value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CarouselComponent.PageControl.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
