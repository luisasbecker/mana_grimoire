package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: TimelineComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialTimelineComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PartialTimelineComponent$$serializer implements GeneratedSerializer<PartialTimelineComponent> {
    public static final PartialTimelineComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialTimelineComponent$$serializer partialTimelineComponent$$serializer = new PartialTimelineComponent$$serializer();
        INSTANCE = partialTimelineComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialTimelineComponent", partialTimelineComponent$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("item_spacing", true);
        pluginGeneratedSerialDescriptor.addElement("text_spacing", true);
        pluginGeneratedSerialDescriptor.addElement("column_gutter", true);
        pluginGeneratedSerialDescriptor.addElement("icon_alignment", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialTimelineComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(TimelineIconAlignmentDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Size$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialTimelineComponent deserialize(Decoder decoder) {
        Padding padding;
        Boolean bool;
        Integer num;
        TimelineComponent.IconAlignment iconAlignment;
        Size size;
        Integer num2;
        Integer num3;
        Padding padding2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 7;
        Boolean bool2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, null);
            Integer num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            Integer num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, null);
            TimelineComponent.IconAlignment iconAlignment2 = (TimelineComponent.IconAlignment) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, TimelineIconAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, Size$$serializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, Padding$$serializer.INSTANCE, null);
            padding2 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, null);
            padding = padding3;
            size = size2;
            num3 = num6;
            iconAlignment = iconAlignment2;
            num = num5;
            i = 255;
            num2 = num4;
            bool = bool3;
        } else {
            boolean z = true;
            int i3 = 0;
            Padding padding4 = null;
            Padding padding5 = null;
            Size size3 = null;
            Integer num7 = null;
            Integer num8 = null;
            Integer num9 = null;
            TimelineComponent.IconAlignment iconAlignment3 = null;
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
                        num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, num7);
                        i3 |= 2;
                        i2 = 7;
                        break;
                    case 2:
                        num8 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num8);
                        i3 |= 4;
                        i2 = 7;
                        break;
                    case 3:
                        num9 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, num9);
                        i3 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        iconAlignment3 = (TimelineComponent.IconAlignment) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, TimelineIconAlignmentDeserializer.INSTANCE, iconAlignment3);
                        i3 |= 16;
                        break;
                    case 5:
                        size3 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, Size$$serializer.INSTANCE, size3);
                        i3 |= 32;
                        break;
                    case 6:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 64;
                        break;
                    case 7:
                        padding4 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, Padding$$serializer.INSTANCE, padding4);
                        i3 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            TimelineComponent.IconAlignment iconAlignment4 = iconAlignment3;
            padding = padding5;
            bool = bool2;
            num = num8;
            iconAlignment = iconAlignment4;
            Integer num10 = num9;
            size = size3;
            num2 = num7;
            num3 = num10;
            padding2 = padding4;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PartialTimelineComponent(i, bool, num2, num, num3, iconAlignment, size, padding, padding2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialTimelineComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PartialTimelineComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
