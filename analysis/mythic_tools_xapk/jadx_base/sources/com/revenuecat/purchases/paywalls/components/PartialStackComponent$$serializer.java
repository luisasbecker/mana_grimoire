package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: StackComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialStackComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialStackComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PartialStackComponent$$serializer implements GeneratedSerializer<PartialStackComponent> {
    public static final PartialStackComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialStackComponent$$serializer partialStackComponent$$serializer = new PartialStackComponent$$serializer();
        INSTANCE = partialStackComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialStackComponent", partialStackComponent$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("dimension", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("spacing", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("background", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("shape", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement("badge", true);
        pluginGeneratedSerialDescriptor.addElement("overflow", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialStackComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PartialStackComponent.$childSerializers[1]), BuiltinSerializersKt.getNullable(Size$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Badge$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StackOverflowDeserializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialStackComponent deserialize(Decoder decoder) {
        ColorScheme colorScheme;
        int i;
        Shape shape;
        Dimension dimension;
        Border border;
        Background background;
        Padding padding;
        Float f;
        Padding padding2;
        Size size;
        Badge badge;
        StackComponent.Overflow overflow;
        Shadow shadow;
        Boolean bool;
        StackComponent.Overflow overflow2;
        Boolean bool2;
        Dimension dimension2;
        Dimension dimension3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PartialStackComponent.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Dimension dimension4 = (Dimension) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, Size$$serializer.INSTANCE, null);
            Float f2 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, FloatSerializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            Badge badge2 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Badge$$serializer.INSTANCE, null);
            i = 8191;
            overflow = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StackOverflowDeserializer.INSTANCE, null);
            shadow = shadow2;
            border = border2;
            shape = shape2;
            badge = badge2;
            bool = bool3;
            padding2 = padding4;
            background = background2;
            f = f2;
            colorScheme = colorScheme2;
            dimension = dimension4;
            padding = padding3;
            size = size2;
        } else {
            StackComponent.Overflow overflow3 = null;
            Badge badge3 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            colorScheme = null;
            Border border3 = null;
            Background background3 = null;
            Float f3 = null;
            Boolean bool4 = null;
            int i2 = 1;
            boolean z = true;
            i = 0;
            Dimension dimension5 = null;
            Size size3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        overflow2 = overflow3;
                        bool2 = bool4;
                        dimension2 = dimension5;
                        z = false;
                        dimension5 = dimension2;
                        bool4 = bool2;
                        overflow3 = overflow2;
                        i2 = 1;
                        break;
                    case 0:
                        overflow2 = overflow3;
                        Boolean bool5 = bool4;
                        dimension2 = dimension5;
                        bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool5);
                        i |= 1;
                        dimension5 = dimension2;
                        bool4 = bool2;
                        overflow3 = overflow2;
                        i2 = 1;
                        break;
                    case 1:
                        Dimension dimension6 = dimension5;
                        int i3 = i2;
                        dimension5 = (Dimension) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, kSerializerArr[i2], dimension6);
                        i |= 2;
                        i2 = i3;
                        overflow3 = overflow3;
                        break;
                    case 2:
                        dimension3 = dimension5;
                        size3 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, Size$$serializer.INSTANCE, size3);
                        i |= 4;
                        dimension5 = dimension3;
                        break;
                    case 3:
                        dimension3 = dimension5;
                        f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, FloatSerializer.INSTANCE, f3);
                        i |= 8;
                        dimension5 = dimension3;
                        break;
                    case 4:
                        dimension3 = dimension5;
                        colorScheme = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme);
                        i |= 16;
                        dimension5 = dimension3;
                        break;
                    case 5:
                        dimension3 = dimension5;
                        background3 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BackgroundDeserializer.INSTANCE, background3);
                        i |= 32;
                        dimension5 = dimension3;
                        break;
                    case 6:
                        dimension3 = dimension5;
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, Padding$$serializer.INSTANCE, padding6);
                        i |= 64;
                        dimension5 = dimension3;
                        break;
                    case 7:
                        dimension3 = dimension5;
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, padding5);
                        i |= 128;
                        dimension5 = dimension3;
                        break;
                    case 8:
                        dimension3 = dimension5;
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ShapeDeserializer.INSTANCE, shape3);
                        i |= 256;
                        dimension5 = dimension3;
                        break;
                    case 9:
                        dimension3 = dimension5;
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Border$$serializer.INSTANCE, border3);
                        i |= 512;
                        dimension5 = dimension3;
                        break;
                    case 10:
                        dimension3 = dimension5;
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Shadow$$serializer.INSTANCE, shadow3);
                        i |= 1024;
                        dimension5 = dimension3;
                        break;
                    case 11:
                        dimension3 = dimension5;
                        badge3 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Badge$$serializer.INSTANCE, badge3);
                        i |= 2048;
                        dimension5 = dimension3;
                        break;
                    case 12:
                        overflow3 = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StackOverflowDeserializer.INSTANCE, overflow3);
                        i |= 4096;
                        dimension5 = dimension5;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            StackComponent.Overflow overflow4 = overflow3;
            Boolean bool6 = bool4;
            Size size4 = size3;
            shape = shape3;
            dimension = dimension5;
            border = border3;
            background = background3;
            padding = padding6;
            f = f3;
            padding2 = padding5;
            size = size4;
            badge = badge3;
            overflow = overflow4;
            shadow = shadow3;
            bool = bool6;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PartialStackComponent(i, bool, dimension, size, f, colorScheme, background, padding, padding2, shape, border, shadow, badge, overflow, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialStackComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PartialStackComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
