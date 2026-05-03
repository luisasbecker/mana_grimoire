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
import java.util.List;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/StackComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class StackComponent$$serializer implements GeneratedSerializer<StackComponent> {
    public static final StackComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        StackComponent$$serializer stackComponent$$serializer = new StackComponent$$serializer();
        INSTANCE = stackComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("stack", stackComponent$$serializer, 15);
        pluginGeneratedSerialDescriptor.addElement("components", false);
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
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StackComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = StackComponent.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), kSerializerArr[2], Size$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE), Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Badge$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StackOverflowDeserializer.INSTANCE), kSerializerArr[14]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StackComponent deserialize(Decoder decoder) {
        Float f;
        Border border;
        Shape shape;
        ColorScheme colorScheme;
        StackComponent.Overflow overflow;
        Badge badge;
        List list;
        Shadow shadow;
        Padding padding;
        Background background;
        Size size;
        Boolean bool;
        Padding padding2;
        Dimension dimension;
        List list2;
        int i;
        Boolean bool2;
        StackComponent.Overflow overflow2;
        List list3;
        List list4;
        Boolean bool3;
        Boolean bool4;
        List list5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = StackComponent.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            Boolean bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Dimension dimension2 = (Dimension) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Size$$serializer.INSTANCE, null);
            Float f2 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FloatSerializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BackgroundDeserializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, Padding$$serializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Shadow$$serializer.INSTANCE, null);
            Badge badge2 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Badge$$serializer.INSTANCE, null);
            overflow = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StackOverflowDeserializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 14, kSerializerArr[14], null);
            border = border2;
            padding2 = padding3;
            badge = badge2;
            shadow = shadow2;
            bool = bool5;
            shape = shape2;
            padding = padding4;
            colorScheme = colorScheme2;
            size = size2;
            f = f2;
            background = background2;
            dimension = dimension2;
            i = 32767;
            list2 = list6;
        } else {
            int i2 = 14;
            boolean z = true;
            List list7 = null;
            Dimension dimension3 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            Background background3 = null;
            f = null;
            Shape shape3 = null;
            ColorScheme colorScheme3 = null;
            Badge badge3 = null;
            StackComponent.Overflow overflow3 = null;
            List list8 = null;
            int i3 = 2;
            int i4 = 0;
            Boolean bool6 = null;
            Size size3 = null;
            while (z) {
                int i5 = i2;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        overflow2 = overflow3;
                        list3 = list7;
                        list4 = list8;
                        bool3 = bool6;
                        z = false;
                        bool6 = bool3;
                        i2 = 14;
                        i3 = 2;
                        list8 = list4;
                        list7 = list3;
                        overflow3 = overflow2;
                        break;
                    case 0:
                        overflow2 = overflow3;
                        list3 = list7;
                        List list9 = list8;
                        bool3 = bool6;
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], list9);
                        i4 |= 1;
                        bool6 = bool3;
                        i2 = 14;
                        i3 = 2;
                        list8 = list4;
                        list7 = list3;
                        overflow3 = overflow2;
                        break;
                    case 1:
                        overflow2 = overflow3;
                        bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool6);
                        i4 |= 2;
                        badge3 = badge3;
                        list7 = list7;
                        i2 = 14;
                        i3 = 2;
                        overflow3 = overflow2;
                        break;
                    case 2:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        dimension3 = (Dimension) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i3, kSerializerArr[i3], dimension3);
                        i4 |= 4;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 3:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Size$$serializer.INSTANCE, size3);
                        i4 |= 8;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 4:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        f = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FloatSerializer.INSTANCE, f);
                        i4 |= 16;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 5:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i4 |= 32;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 6:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        background3 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BackgroundDeserializer.INSTANCE, background3);
                        i4 |= 64;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 7:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i4 |= 128;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 8:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, Padding$$serializer.INSTANCE, padding5);
                        i4 |= 256;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 9:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, ShapeDeserializer.INSTANCE, shape3);
                        i4 |= 512;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 10:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Border$$serializer.INSTANCE, border3);
                        i4 |= 1024;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 11:
                        bool4 = bool6;
                        overflow2 = overflow3;
                        list5 = list7;
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Shadow$$serializer.INSTANCE, shadow3);
                        i4 |= 2048;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 12:
                        bool4 = bool6;
                        StackComponent.Overflow overflow4 = overflow3;
                        list5 = list7;
                        overflow2 = overflow4;
                        badge3 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Badge$$serializer.INSTANCE, badge3);
                        i4 |= 4096;
                        list7 = list5;
                        bool6 = bool4;
                        i2 = 14;
                        overflow3 = overflow2;
                        break;
                    case 13:
                        bool2 = bool6;
                        i4 |= 8192;
                        list7 = list7;
                        i2 = 14;
                        overflow3 = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StackOverflowDeserializer.INSTANCE, overflow3);
                        bool6 = bool2;
                        break;
                    case 14:
                        bool2 = bool6;
                        list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i5, kSerializerArr[i5], list7);
                        i4 |= 16384;
                        i2 = i5;
                        bool6 = bool2;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            StackComponent.Overflow overflow5 = overflow3;
            border = border3;
            shape = shape3;
            colorScheme = colorScheme3;
            overflow = overflow5;
            badge = badge3;
            list = list7;
            shadow = shadow3;
            padding = padding5;
            background = background3;
            size = size3;
            bool = bool6;
            padding2 = padding6;
            dimension = dimension3;
            list2 = list8;
            i = i4;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new StackComponent(i, list2, bool, dimension, size, f, colorScheme, background, padding2, padding, shape, border, shadow, badge, overflow, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StackComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        StackComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
