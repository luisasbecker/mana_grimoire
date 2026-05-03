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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: TextComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/TextComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class TextComponent$$serializer implements GeneratedSerializer<TextComponent> {
    public static final TextComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TextComponent$$serializer textComponent$$serializer = new TextComponent$$serializer();
        INSTANCE = textComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("text", textComponent$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("text_lid", false);
        pluginGeneratedSerialDescriptor.addElement("color", false);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("font_name", true);
        pluginGeneratedSerialDescriptor.addElement(FontsContractCompat.Columns.WEIGHT, true);
        pluginGeneratedSerialDescriptor.addElement("font_weight_int", true);
        pluginGeneratedSerialDescriptor.addElement(ViewHierarchyConstants.TEXT_SIZE, true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TextComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LocalizationKey$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FontAlias$$serializer.INSTANCE), FontWeightDeserializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), FontSizeSerializer.INSTANCE, HorizontalAlignmentDeserializer.INSTANCE, Size$$serializer.INSTANCE, Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, TextComponent.$childSerializers[12]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TextComponent deserialize(Decoder decoder) {
        Integer num;
        Padding padding;
        Size size;
        Boolean bool;
        FontWeight fontWeight;
        Padding padding2;
        List list;
        int i;
        ColorScheme colorScheme;
        int i2;
        ColorScheme colorScheme2;
        HorizontalAlignment horizontalAlignment;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = TextComponent.$childSerializers;
        int i3 = 9;
        int i4 = 7;
        int i5 = 8;
        Size size2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, null);
            String strM10434unboximpl = localizationKey != null ? localizationKey.m10434unboximpl() : null;
            ColorScheme colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, ColorScheme$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            ColorScheme colorScheme4 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, null);
            FontAlias fontAlias = (FontAlias) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FontAlias$$serializer.INSTANCE, null);
            String strM10276unboximpl = fontAlias != null ? fontAlias.m10276unboximpl() : null;
            FontWeight fontWeight2 = (FontWeight) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, FontWeightDeserializer.INSTANCE, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, null);
            int iIntValue = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, FontSizeSerializer.INSTANCE, 0)).intValue();
            HorizontalAlignment horizontalAlignment2 = (HorizontalAlignment) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, null);
            Size size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, Size$$serializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, Padding$$serializer.INSTANCE, null);
            padding = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, Padding$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 12, kSerializerArr[12], null);
            i = iIntValue;
            size = size3;
            horizontalAlignment = horizontalAlignment2;
            num = num2;
            fontWeight = fontWeight2;
            padding2 = padding3;
            str = strM10276unboximpl;
            colorScheme2 = colorScheme3;
            str2 = strM10434unboximpl;
            colorScheme = colorScheme4;
            i2 = 8191;
            bool = bool2;
        } else {
            int i6 = 0;
            int i7 = 12;
            Integer num3 = null;
            Padding padding4 = null;
            String strM10434unboximpl2 = null;
            FontWeight fontWeight3 = null;
            Padding padding5 = null;
            List list2 = null;
            ColorScheme colorScheme5 = null;
            String strM10276unboximpl2 = null;
            Boolean bool3 = null;
            ColorScheme colorScheme6 = null;
            int i8 = 1;
            int i9 = 0;
            int iIntValue2 = 0;
            HorizontalAlignment horizontalAlignment3 = null;
            while (i8 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        i8 = i6;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        break;
                    case 0:
                        ColorScheme colorScheme7 = colorScheme5;
                        Boolean bool4 = bool3;
                        ColorScheme colorScheme8 = colorScheme6;
                        int i10 = i6;
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i10, LocalizationKey$$serializer.INSTANCE, strM10434unboximpl2 != null ? LocalizationKey.m10428boximpl(strM10434unboximpl2) : null);
                        strM10434unboximpl2 = localizationKey2 != null ? localizationKey2.m10434unboximpl() : null;
                        i9 |= 1;
                        colorScheme5 = colorScheme7;
                        bool3 = bool4;
                        colorScheme6 = colorScheme8;
                        i6 = i10;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        break;
                    case 1:
                        colorScheme6 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, ColorScheme$$serializer.INSTANCE, colorScheme6);
                        i9 |= 2;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        break;
                    case 2:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, bool3);
                        i9 |= 4;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        break;
                    case 3:
                        colorScheme5 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme5);
                        i9 |= 8;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        break;
                    case 4:
                        FontAlias fontAlias2 = (FontAlias) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FontAlias$$serializer.INSTANCE, strM10276unboximpl2 != null ? FontAlias.m10270boximpl(strM10276unboximpl2) : null);
                        strM10276unboximpl2 = fontAlias2 != null ? fontAlias2.m10276unboximpl() : null;
                        i9 |= 16;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 12;
                        break;
                    case 5:
                        fontWeight3 = (FontWeight) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, FontWeightDeserializer.INSTANCE, fontWeight3);
                        i9 |= 32;
                        i3 = 9;
                        i4 = 7;
                        i7 = 12;
                        break;
                    case 6:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, num3);
                        i9 |= 64;
                        i3 = 9;
                        i7 = 12;
                        break;
                    case 7:
                        iIntValue2 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, FontSizeSerializer.INSTANCE, Integer.valueOf(iIntValue2))).intValue();
                        i9 |= 128;
                        i3 = 9;
                        i7 = 12;
                        break;
                    case 8:
                        horizontalAlignment3 = (HorizontalAlignment) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i5, HorizontalAlignmentDeserializer.INSTANCE, horizontalAlignment3);
                        i9 |= 256;
                        i7 = 12;
                        break;
                    case 9:
                        size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i3, Size$$serializer.INSTANCE, size2);
                        i9 |= 512;
                        i7 = 12;
                        break;
                    case 10:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, Padding$$serializer.INSTANCE, padding5);
                        i9 |= 1024;
                        i7 = 12;
                        break;
                    case 11:
                        padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, Padding$$serializer.INSTANCE, padding4);
                        i9 |= 2048;
                        i7 = 12;
                        break;
                    case 12:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i7, kSerializerArr[i7], list2);
                        i9 |= 4096;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            ColorScheme colorScheme9 = colorScheme5;
            num = num3;
            padding = padding4;
            size = size2;
            bool = bool3;
            fontWeight = fontWeight3;
            padding2 = padding5;
            list = list2;
            i = iIntValue2;
            colorScheme = colorScheme9;
            i2 = i9;
            colorScheme2 = colorScheme6;
            horizontalAlignment = horizontalAlignment3;
            str = strM10276unboximpl2;
            str2 = strM10434unboximpl2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new TextComponent(i2, str2, colorScheme2, bool, colorScheme, str, fontWeight, num, i, horizontalAlignment, size, padding2, padding, list, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TextComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TextComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
