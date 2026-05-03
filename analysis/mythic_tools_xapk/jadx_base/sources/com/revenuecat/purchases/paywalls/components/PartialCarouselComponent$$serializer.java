package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
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
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignmentDeserializer;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: CarouselComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialCarouselComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PartialCarouselComponent$$serializer implements GeneratedSerializer<PartialCarouselComponent> {
    public static final PartialCarouselComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialCarouselComponent$$serializer partialCarouselComponent$$serializer = new PartialCarouselComponent$$serializer();
        INSTANCE = partialCarouselComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialCarouselComponent", partialCarouselComponent$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("initial_page_index", true);
        pluginGeneratedSerialDescriptor.addElement("page_alignment", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("page_peek", true);
        pluginGeneratedSerialDescriptor.addElement("page_spacing", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("background", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("shape", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement("page_control", true);
        pluginGeneratedSerialDescriptor.addElement("loop", true);
        pluginGeneratedSerialDescriptor.addElement("auto_advance", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialCarouselComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(VerticalAlignmentDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Size$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CarouselComponent$PageControl$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CarouselComponent$AutoAdvancePages$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialCarouselComponent deserialize(Decoder decoder) {
        int i;
        Shape shape;
        Integer num;
        Border border;
        Padding padding;
        Boolean bool;
        CarouselComponent.PageControl pageControl;
        CarouselComponent.AutoAdvancePages autoAdvancePages;
        Boolean bool2;
        Shadow shadow;
        Padding padding2;
        ColorScheme colorScheme;
        Integer num2;
        Float f;
        VerticalAlignment verticalAlignment;
        Background background;
        Size size;
        VerticalAlignment verticalAlignment2;
        Boolean bool3;
        Integer num3;
        CarouselComponent.AutoAdvancePages autoAdvancePages2;
        Size size2;
        Boolean bool4;
        VerticalAlignment verticalAlignment3;
        CarouselComponent.AutoAdvancePages autoAdvancePages3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Boolean bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, null);
            VerticalAlignment verticalAlignment4 = (VerticalAlignment) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, VerticalAlignmentDeserializer.INSTANCE, null);
            Size size3 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Size$$serializer.INSTANCE, null);
            Integer num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, null);
            Float f2 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, FloatSerializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, BackgroundDeserializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Padding$$serializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Shadow$$serializer.INSTANCE, null);
            CarouselComponent.PageControl pageControl2 = (CarouselComponent.PageControl) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, CarouselComponent$PageControl$$serializer.INSTANCE, null);
            i = 65535;
            shape = shape2;
            bool2 = bool5;
            f = f2;
            num2 = num5;
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, BooleanSerializer.INSTANCE, null);
            autoAdvancePages = (CarouselComponent.AutoAdvancePages) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, null);
            border = border2;
            background = background2;
            pageControl = pageControl2;
            shadow = shadow2;
            verticalAlignment = verticalAlignment4;
            padding = padding4;
            padding2 = padding3;
            num = num4;
            colorScheme = colorScheme2;
            size = size3;
        } else {
            boolean z = true;
            Size size4 = null;
            VerticalAlignment verticalAlignment5 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Background background3 = null;
            ColorScheme colorScheme3 = null;
            Integer num6 = null;
            Padding padding6 = null;
            Float f3 = null;
            Boolean bool6 = null;
            CarouselComponent.PageControl pageControl3 = null;
            Boolean bool7 = null;
            Integer num7 = null;
            i = 0;
            CarouselComponent.AutoAdvancePages autoAdvancePages4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        bool3 = bool7;
                        num3 = num7;
                        autoAdvancePages2 = autoAdvancePages4;
                        size2 = size4;
                        z = false;
                        autoAdvancePages4 = autoAdvancePages2;
                        size4 = size2;
                        bool7 = bool3;
                        num7 = num3;
                        break;
                    case 0:
                        bool3 = bool7;
                        autoAdvancePages2 = autoAdvancePages4;
                        Integer num8 = num7;
                        size2 = size4;
                        num3 = num8;
                        bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool6);
                        i |= 1;
                        autoAdvancePages4 = autoAdvancePages2;
                        size4 = size2;
                        bool7 = bool3;
                        num7 = num3;
                        break;
                    case 1:
                        bool4 = bool7;
                        i |= 2;
                        size4 = size4;
                        num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, num7);
                        autoAdvancePages4 = autoAdvancePages4;
                        bool7 = bool4;
                        break;
                    case 2:
                        bool4 = bool7;
                        verticalAlignment5 = (VerticalAlignment) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, VerticalAlignmentDeserializer.INSTANCE, verticalAlignment5);
                        i |= 4;
                        pageControl3 = pageControl3;
                        autoAdvancePages4 = autoAdvancePages4;
                        bool7 = bool4;
                        break;
                    case 3:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        size4 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Size$$serializer.INSTANCE, size4);
                        i |= 8;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 4:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num6);
                        i |= 16;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 5:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, FloatSerializer.INSTANCE, f3);
                        i |= 32;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 6:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i |= 64;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 7:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        background3 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, BackgroundDeserializer.INSTANCE, background3);
                        i |= 128;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 8:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, Padding$$serializer.INSTANCE, padding5);
                        i |= 256;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 9:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Padding$$serializer.INSTANCE, padding6);
                        i |= 512;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 10:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, ShapeDeserializer.INSTANCE, shape3);
                        i |= 1024;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 11:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Border$$serializer.INSTANCE, border3);
                        i |= 2048;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 12:
                        verticalAlignment3 = verticalAlignment5;
                        bool4 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Shadow$$serializer.INSTANCE, shadow3);
                        i |= 4096;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 13:
                        verticalAlignment3 = verticalAlignment5;
                        Boolean bool8 = bool7;
                        autoAdvancePages3 = autoAdvancePages4;
                        bool4 = bool8;
                        pageControl3 = (CarouselComponent.PageControl) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, CarouselComponent$PageControl$$serializer.INSTANCE, pageControl3);
                        i |= 8192;
                        autoAdvancePages4 = autoAdvancePages3;
                        verticalAlignment5 = verticalAlignment3;
                        bool7 = bool4;
                        break;
                    case 14:
                        verticalAlignment2 = verticalAlignment5;
                        i |= 16384;
                        autoAdvancePages4 = autoAdvancePages4;
                        bool7 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, BooleanSerializer.INSTANCE, bool7);
                        verticalAlignment5 = verticalAlignment2;
                        break;
                    case 15:
                        verticalAlignment2 = verticalAlignment5;
                        autoAdvancePages4 = (CarouselComponent.AutoAdvancePages) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, autoAdvancePages4);
                        i |= 32768;
                        verticalAlignment5 = verticalAlignment2;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            Integer num9 = num7;
            Size size5 = size4;
            Boolean bool9 = bool6;
            shape = shape3;
            num = num9;
            border = border3;
            padding = padding6;
            bool = bool7;
            pageControl = pageControl3;
            autoAdvancePages = autoAdvancePages4;
            bool2 = bool9;
            shadow = shadow3;
            padding2 = padding5;
            colorScheme = colorScheme3;
            num2 = num6;
            f = f3;
            verticalAlignment = verticalAlignment5;
            background = background3;
            size = size5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PartialCarouselComponent(i, bool2, num, verticalAlignment, size, num2, f, colorScheme, background, padding2, padding, shape, border, shadow, pageControl, bool, autoAdvancePages, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialCarouselComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PartialCarouselComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
