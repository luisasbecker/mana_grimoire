package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
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

/* JADX INFO: compiled from: TabsComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialTabsComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialTabsComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PartialTabsComponent$$serializer implements GeneratedSerializer<PartialTabsComponent> {
    public static final PartialTabsComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialTabsComponent$$serializer partialTabsComponent$$serializer = new PartialTabsComponent$$serializer();
        INSTANCE = partialTabsComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialTabsComponent", partialTabsComponent$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("background", true);
        pluginGeneratedSerialDescriptor.addElement("shape", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialTabsComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(Size$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialTabsComponent deserialize(Decoder decoder) {
        Shape shape;
        Size size;
        Background background;
        Padding padding;
        int i;
        Shadow shadow;
        Boolean bool;
        ColorScheme colorScheme;
        Padding padding2;
        Border border;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 7;
        Boolean bool2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, Size$$serializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Padding$$serializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ShapeDeserializer.INSTANCE, null);
            padding = padding3;
            size = size2;
            border = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Border$$serializer.INSTANCE, null);
            shape = shape2;
            background = background2;
            shadow = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, Shadow$$serializer.INSTANCE, null);
            colorScheme = colorScheme2;
            i = 511;
            bool = bool3;
            padding2 = padding4;
        } else {
            boolean z = true;
            int i3 = 0;
            Border border2 = null;
            Shadow shadow2 = null;
            Shape shape3 = null;
            Background background3 = null;
            ColorScheme colorScheme3 = null;
            Size size3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                        break;
                    case 0:
                        bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool2);
                        i3 |= 1;
                        i2 = 7;
                        break;
                    case 1:
                        size3 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, Size$$serializer.INSTANCE, size3);
                        i3 |= 2;
                        i2 = 7;
                        break;
                    case 2:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 4;
                        i2 = 7;
                        break;
                    case 3:
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Padding$$serializer.INSTANCE, padding6);
                        i3 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i3 |= 16;
                        i2 = 7;
                        break;
                    case 5:
                        background3 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BackgroundDeserializer.INSTANCE, background3);
                        i3 |= 32;
                        i2 = 7;
                        break;
                    case 6:
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ShapeDeserializer.INSTANCE, shape3);
                        i3 |= 64;
                        break;
                    case 7:
                        border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, Border$$serializer.INSTANCE, border2);
                        i3 |= 128;
                        break;
                    case 8:
                        shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, Shadow$$serializer.INSTANCE, shadow2);
                        i3 |= 256;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            Padding padding7 = padding5;
            shape = shape3;
            size = size3;
            background = background3;
            padding = padding7;
            i = i3;
            shadow = shadow2;
            bool = bool2;
            colorScheme = colorScheme3;
            padding2 = padding6;
            border = border2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PartialTabsComponent(i, bool, size, padding, padding2, colorScheme, background, shape, border, shadow, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialTabsComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PartialTabsComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
