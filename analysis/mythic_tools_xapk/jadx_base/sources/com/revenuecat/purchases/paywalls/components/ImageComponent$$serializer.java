package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.media3.common.MimeTypes;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
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

/* JADX INFO: compiled from: ImageComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/ImageComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ImageComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class ImageComponent$$serializer implements GeneratedSerializer<ImageComponent> {
    public static final ImageComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ImageComponent$$serializer imageComponent$$serializer = new ImageComponent$$serializer();
        INSTANCE = imageComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(MimeTypes.BASE_TYPE_IMAGE, imageComponent$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("source", false);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("override_source_lid", true);
        pluginGeneratedSerialDescriptor.addElement("mask_shape", true);
        pluginGeneratedSerialDescriptor.addElement("color_overlay", true);
        pluginGeneratedSerialDescriptor.addElement("fit_mode", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ImageComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ThemeImageUrls$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), Size$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(LocalizationKey$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(MaskShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), FitModeDeserializer.INSTANCE, Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), ImageComponent.$childSerializers[11]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ImageComponent deserialize(Decoder decoder) {
        Padding padding;
        Padding padding2;
        List list;
        Border border;
        Shadow shadow;
        String str;
        MaskShape maskShape;
        int i;
        FitMode fitMode;
        ThemeImageUrls themeImageUrls;
        ColorScheme colorScheme;
        Boolean bool;
        Size size;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = ImageComponent.$childSerializers;
        int i2 = 10;
        int i3 = 9;
        int i4 = 8;
        List list2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, Size$$serializer.INSTANCE, null);
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, null);
            String strM10434unboximpl = localizationKey != null ? localizationKey.m10434unboximpl() : null;
            MaskShape maskShape2 = (MaskShape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, FitModeDeserializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, Padding$$serializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, kSerializerArr[11], null);
            shadow = shadow2;
            border = border2;
            padding2 = padding3;
            fitMode = fitMode2;
            padding = padding4;
            bool = bool2;
            colorScheme = colorScheme2;
            i = 4095;
            maskShape = maskShape2;
            size = size2;
            str = strM10434unboximpl;
            themeImageUrls = themeImageUrls2;
        } else {
            int i5 = 11;
            Padding padding5 = null;
            FitMode fitMode3 = null;
            ColorScheme colorScheme3 = null;
            Padding padding6 = null;
            ThemeImageUrls themeImageUrls3 = null;
            String strM10434unboximpl2 = null;
            MaskShape maskShape3 = null;
            Size size3 = null;
            Boolean bool3 = null;
            boolean z = true;
            int i6 = 0;
            Border border3 = null;
            Shadow shadow3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i5 = 11;
                        i3 = 9;
                        i4 = 8;
                        kSerializerArr = kSerializerArr;
                        break;
                    case 0:
                        themeImageUrls3 = (ThemeImageUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i6 |= 1;
                        kSerializerArr = kSerializerArr;
                        i5 = 11;
                        i2 = 10;
                        i3 = 9;
                        i4 = 8;
                        break;
                    case 1:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool3);
                        i6 |= 2;
                        i5 = 11;
                        i2 = 10;
                        i3 = 9;
                        i4 = 8;
                        break;
                    case 2:
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, Size$$serializer.INSTANCE, size3);
                        i6 |= 4;
                        i5 = 11;
                        i2 = 10;
                        i3 = 9;
                        break;
                    case 3:
                        MaskShape maskShape4 = maskShape3;
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, strM10434unboximpl2 != null ? LocalizationKey.m10428boximpl(strM10434unboximpl2) : null);
                        strM10434unboximpl2 = localizationKey2 != null ? localizationKey2.m10434unboximpl() : null;
                        i6 |= 8;
                        maskShape3 = maskShape4;
                        i5 = 11;
                        i2 = 10;
                        i3 = 9;
                        break;
                    case 4:
                        maskShape3 = (MaskShape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i6 |= 16;
                        i5 = 11;
                        i2 = 10;
                        break;
                    case 5:
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i6 |= 32;
                        i5 = 11;
                        break;
                    case 6:
                        fitMode3 = (FitMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, FitModeDeserializer.INSTANCE, fitMode3);
                        i6 |= 64;
                        i5 = 11;
                        break;
                    case 7:
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i6 |= 128;
                        i5 = 11;
                        break;
                    case 8:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, Padding$$serializer.INSTANCE, padding5);
                        i6 |= 256;
                        break;
                    case 9:
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, Border$$serializer.INSTANCE, border3);
                        i6 |= 512;
                        break;
                    case 10:
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, Shadow$$serializer.INSTANCE, shadow3);
                        i6 |= 1024;
                        break;
                    case 11:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i5, kSerializerArr[i5], list2);
                        i6 |= 2048;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            ThemeImageUrls themeImageUrls4 = themeImageUrls3;
            padding = padding5;
            padding2 = padding6;
            list = list2;
            border = border3;
            shadow = shadow3;
            str = strM10434unboximpl2;
            maskShape = maskShape3;
            i = i6;
            fitMode = fitMode3;
            themeImageUrls = themeImageUrls4;
            colorScheme = colorScheme3;
            bool = bool3;
            size = size3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new ImageComponent(i, themeImageUrls, bool, size, str, maskShape, colorScheme, fitMode, padding2, padding, border, shadow, list, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ImageComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        ImageComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
