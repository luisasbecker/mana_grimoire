package com.revenuecat.purchases.paywalls.components;

import androidx.core.provider.FontsContractCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.FontAlias$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignmentDeserializer;
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

/* JADX INFO: compiled from: TextComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialTextComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PartialTextComponent$$serializer implements GeneratedSerializer<PartialTextComponent> {
    public static final PartialTextComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialTextComponent$$serializer partialTextComponent$$serializer = new PartialTextComponent$$serializer();
        INSTANCE = partialTextComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialTextComponent", partialTextComponent$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("text_lid", true);
        pluginGeneratedSerialDescriptor.addElement("color", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("font_name", true);
        pluginGeneratedSerialDescriptor.addElement(FontsContractCompat.Columns.WEIGHT, true);
        pluginGeneratedSerialDescriptor.addElement("font_weight_int", true);
        pluginGeneratedSerialDescriptor.addElement(ViewHierarchyConstants.TEXT_SIZE, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialTextComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LocalizationKey$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FontAlias$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FontWeightDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FontSizeSerializer.INSTANCE), BuiltinSerializersKt.getNullable(HorizontalAlignmentDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Size$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialTextComponent deserialize(Decoder decoder) {
        Boolean bool;
        HorizontalAlignment horizontalAlignment;
        Integer num;
        Size size;
        Padding padding;
        Padding padding2;
        String str;
        String str2;
        ColorScheme colorScheme;
        int i;
        Integer num2;
        FontWeight fontWeight;
        ColorScheme colorScheme2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 11;
        int i3 = 10;
        int i4 = 9;
        int i5 = 8;
        Padding padding3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, LocalizationKey$$serializer.INSTANCE, null);
            String strM10434unboximpl = localizationKey != null ? localizationKey.m10434unboximpl() : null;
            ColorScheme colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, null);
            ColorScheme colorScheme4 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, null);
            FontAlias fontAlias = (FontAlias) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FontAlias$$serializer.INSTANCE, null);
            String strM10276unboximpl = fontAlias != null ? fontAlias.m10276unboximpl() : null;
            FontWeight fontWeight2 = (FontWeight) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, FontWeightDeserializer.INSTANCE, null);
            Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, null);
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, FontSizeSerializer.INSTANCE, null);
            HorizontalAlignment horizontalAlignment2 = (HorizontalAlignment) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Size$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Padding$$serializer.INSTANCE, null);
            fontWeight = fontWeight2;
            i = 4095;
            padding2 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Padding$$serializer.INSTANCE, null);
            padding = padding4;
            size = size2;
            num = num4;
            num2 = num3;
            horizontalAlignment = horizontalAlignment2;
            str2 = strM10434unboximpl;
            str = strM10276unboximpl;
            colorScheme2 = colorScheme3;
            colorScheme = colorScheme4;
        } else {
            boolean z = true;
            int i6 = 0;
            bool = null;
            HorizontalAlignment horizontalAlignment3 = null;
            Integer num5 = null;
            FontWeight fontWeight3 = null;
            Integer num6 = null;
            Size size3 = null;
            Padding padding5 = null;
            ColorScheme colorScheme5 = null;
            String strM10276unboximpl2 = null;
            ColorScheme colorScheme6 = null;
            String strM10434unboximpl2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 10;
                        i4 = 9;
                        i5 = 8;
                        break;
                    case 0:
                        bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool);
                        i6 |= 1;
                        i2 = 11;
                        i3 = 10;
                        i4 = 9;
                        i5 = 8;
                        break;
                    case 1:
                        ColorScheme colorScheme7 = colorScheme5;
                        ColorScheme colorScheme8 = colorScheme6;
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, LocalizationKey$$serializer.INSTANCE, strM10434unboximpl2 != null ? LocalizationKey.m10428boximpl(strM10434unboximpl2) : null);
                        strM10434unboximpl2 = localizationKey2 != null ? localizationKey2.m10434unboximpl() : null;
                        i6 |= 2;
                        colorScheme6 = colorScheme8;
                        colorScheme5 = colorScheme7;
                        i2 = 11;
                        i3 = 10;
                        i4 = 9;
                        i5 = 8;
                        break;
                    case 2:
                        colorScheme6 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme6);
                        i6 |= 4;
                        i2 = 11;
                        i3 = 10;
                        i4 = 9;
                        break;
                    case 3:
                        colorScheme5 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme5);
                        i6 |= 8;
                        i2 = 11;
                        i3 = 10;
                        break;
                    case 4:
                        FontAlias fontAlias2 = (FontAlias) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FontAlias$$serializer.INSTANCE, strM10276unboximpl2 != null ? FontAlias.m10270boximpl(strM10276unboximpl2) : null);
                        strM10276unboximpl2 = fontAlias2 != null ? fontAlias2.m10276unboximpl() : null;
                        i6 |= 16;
                        i2 = 11;
                        i3 = 10;
                        break;
                    case 5:
                        fontWeight3 = (FontWeight) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, FontWeightDeserializer.INSTANCE, fontWeight3);
                        i6 |= 32;
                        i2 = 11;
                        break;
                    case 6:
                        num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, num5);
                        i6 |= 64;
                        i2 = 11;
                        break;
                    case 7:
                        num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, FontSizeSerializer.INSTANCE, num6);
                        i6 |= 128;
                        i2 = 11;
                        break;
                    case 8:
                        horizontalAlignment3 = (HorizontalAlignment) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i5, HorizontalAlignmentDeserializer.INSTANCE, horizontalAlignment3);
                        i6 |= 256;
                        break;
                    case 9:
                        size3 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i4, Size$$serializer.INSTANCE, size3);
                        i6 |= 512;
                        break;
                    case 10:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, Padding$$serializer.INSTANCE, padding5);
                        i6 |= 1024;
                        break;
                    case 11:
                        padding3 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, Padding$$serializer.INSTANCE, padding3);
                        i6 |= 2048;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            ColorScheme colorScheme9 = colorScheme5;
            horizontalAlignment = horizontalAlignment3;
            num = num6;
            size = size3;
            padding = padding5;
            padding2 = padding3;
            str = strM10276unboximpl2;
            str2 = strM10434unboximpl2;
            colorScheme = colorScheme9;
            i = i6;
            num2 = num5;
            fontWeight = fontWeight3;
            colorScheme2 = colorScheme6;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PartialTextComponent(i, bool, str2, colorScheme2, colorScheme, str, fontWeight, num2, num, horizontalAlignment, size, padding, padding2, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialTextComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PartialTextComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
