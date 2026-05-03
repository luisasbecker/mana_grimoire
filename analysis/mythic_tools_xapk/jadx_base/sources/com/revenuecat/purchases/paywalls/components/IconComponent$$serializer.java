package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: IconComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/IconComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/IconComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class IconComponent$$serializer implements GeneratedSerializer<IconComponent> {
    public static final IconComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        IconComponent$$serializer iconComponent$$serializer = new IconComponent$$serializer();
        INSTANCE = iconComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("icon", iconComponent$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("base_url", false);
        pluginGeneratedSerialDescriptor.addElement("icon_name", false);
        pluginGeneratedSerialDescriptor.addElement("formats", false);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("color", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("icon_background", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IconComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, IconComponent$Formats$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), Size$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(IconComponent$IconBackground$$serializer.INSTANCE), IconComponent.$childSerializers[9]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public IconComponent deserialize(Decoder decoder) {
        IconComponent.Formats formats;
        List list;
        IconComponent.IconBackground iconBackground;
        Padding padding;
        ColorScheme colorScheme;
        Padding padding2;
        String str;
        Boolean bool;
        String strDecodeStringElement;
        Size size;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = IconComponent.$childSerializers;
        int i2 = 9;
        String strDecodeStringElement2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            IconComponent.Formats formats2 = (IconComponent.Formats) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, IconComponent$Formats$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, Size$$serializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, null);
            IconComponent.IconBackground iconBackground2 = (IconComponent.IconBackground) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, kSerializerArr[9], null);
            padding = padding4;
            padding2 = padding3;
            colorScheme = colorScheme2;
            bool = bool2;
            iconBackground = iconBackground2;
            size = size2;
            formats = formats2;
            i = 1023;
            str = strDecodeStringElement3;
        } else {
            boolean z = true;
            int i3 = 0;
            List list2 = null;
            IconComponent.IconBackground iconBackground3 = null;
            Padding padding5 = null;
            ColorScheme colorScheme3 = null;
            Padding padding6 = null;
            Size size3 = null;
            Boolean bool3 = null;
            formats = null;
            String strDecodeStringElement4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                        break;
                    case 0:
                        i3 |= 1;
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i2 = 9;
                        break;
                    case 1:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i3 |= 2;
                        i2 = 9;
                        break;
                    case 2:
                        formats = (IconComponent.Formats) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, IconComponent$Formats$$serializer.INSTANCE, formats);
                        i3 |= 4;
                        i2 = 9;
                        break;
                    case 3:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool3);
                        i3 |= 8;
                        i2 = 9;
                        break;
                    case 4:
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, Size$$serializer.INSTANCE, size3);
                        i3 |= 16;
                        i2 = 9;
                        break;
                    case 5:
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i3 |= 32;
                        i2 = 9;
                        break;
                    case 6:
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, Padding$$serializer.INSTANCE, padding6);
                        i3 |= 64;
                        i2 = 9;
                        break;
                    case 7:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 128;
                        i2 = 9;
                        break;
                    case 8:
                        iconBackground3 = (IconComponent.IconBackground) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, iconBackground3);
                        i3 |= 256;
                        i2 = 9;
                        break;
                    case 9:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i2, kSerializerArr[i2], list2);
                        i3 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            list = list2;
            iconBackground = iconBackground3;
            padding = padding5;
            colorScheme = colorScheme3;
            padding2 = padding6;
            str = strDecodeStringElement2;
            bool = bool3;
            strDecodeStringElement = strDecodeStringElement4;
            size = size3;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new IconComponent(i, str, strDecodeStringElement, formats, bool, size, colorScheme, padding2, padding, iconBackground, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, IconComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        IconComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
