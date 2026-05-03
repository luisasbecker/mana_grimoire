package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
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
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
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

/* JADX INFO: compiled from: VideoComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/VideoComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/VideoComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class VideoComponent$$serializer implements GeneratedSerializer<VideoComponent> {
    public static final VideoComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        VideoComponent$$serializer videoComponent$$serializer = new VideoComponent$$serializer();
        INSTANCE = videoComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video", videoComponent$$serializer, 17);
        pluginGeneratedSerialDescriptor.addElement("source", false);
        pluginGeneratedSerialDescriptor.addElement("fallback_source", false);
        pluginGeneratedSerialDescriptor.addElement("visible", false);
        pluginGeneratedSerialDescriptor.addElement("show_controls", false);
        pluginGeneratedSerialDescriptor.addElement("auto_play", false);
        pluginGeneratedSerialDescriptor.addElement("loop", false);
        pluginGeneratedSerialDescriptor.addElement("mute_audio", false);
        pluginGeneratedSerialDescriptor.addElement("size", false);
        pluginGeneratedSerialDescriptor.addElement("fit_mode", false);
        pluginGeneratedSerialDescriptor.addElement("mask_shape", false);
        pluginGeneratedSerialDescriptor.addElement("color_overlay", false);
        pluginGeneratedSerialDescriptor.addElement("padding", false);
        pluginGeneratedSerialDescriptor.addElement("margin", false);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, false);
        pluginGeneratedSerialDescriptor.addElement("shadow", false);
        pluginGeneratedSerialDescriptor.addElement("overrides", false);
        pluginGeneratedSerialDescriptor.addElement("override_source_lid", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private VideoComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ThemeVideoUrls$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ThemeImageUrls$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, Size$$serializer.INSTANCE, FitModeDeserializer.INSTANCE, BuiltinSerializersKt.getNullable(MaskShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(VideoComponent.$childSerializers[15]), BuiltinSerializersKt.getNullable(LocalizationKey$$serializer.INSTANCE)};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.DeserializationStrategy
    public VideoComponent deserialize(Decoder decoder) {
        Padding padding;
        Shadow shadow;
        Border border;
        Padding padding2;
        FitMode fitMode;
        Size size;
        ColorScheme colorScheme;
        ThemeVideoUrls themeVideoUrls;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        List list;
        Boolean bool;
        MaskShape maskShape;
        ThemeImageUrls themeImageUrls;
        char c;
        int i2;
        String str;
        String str2;
        String str3;
        String strM10434unboximpl;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = VideoComponent.$childSerializers;
        int i3 = 10;
        char c2 = '\t';
        char c3 = '\b';
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ThemeVideoUrls themeVideoUrls2 = (ThemeVideoUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 3);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
            boolean zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
            boolean zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Size$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, FitModeDeserializer.INSTANCE, null);
            MaskShape maskShape2 = (MaskShape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, ColorScheme$$serializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Padding$$serializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, Shadow$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, kSerializerArr[15], null);
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, LocalizationKey$$serializer.INSTANCE, null);
            shadow = shadow2;
            bool = bool2;
            strM10434unboximpl = localizationKey != null ? localizationKey.m10434unboximpl() : null;
            colorScheme = colorScheme2;
            maskShape = maskShape2;
            size = size2;
            fitMode = fitMode2;
            border = border2;
            list = list2;
            padding2 = padding4;
            padding = padding3;
            themeImageUrls = themeImageUrls2;
            z = zDecodeBooleanElement;
            z2 = zDecodeBooleanElement4;
            z3 = zDecodeBooleanElement3;
            z4 = zDecodeBooleanElement2;
            i = 131071;
            themeVideoUrls = themeVideoUrls2;
        } else {
            boolean z5 = true;
            int i4 = 0;
            boolean zDecodeBooleanElement5 = false;
            boolean zDecodeBooleanElement6 = false;
            boolean zDecodeBooleanElement7 = false;
            boolean zDecodeBooleanElement8 = false;
            Padding padding5 = null;
            List list3 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            FitMode fitMode3 = null;
            Size size3 = null;
            ColorScheme colorScheme3 = null;
            MaskShape maskShape3 = null;
            ThemeVideoUrls themeVideoUrls3 = null;
            Boolean bool3 = null;
            ThemeImageUrls themeImageUrls3 = null;
            String str4 = null;
            while (z5) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z5 = false;
                        i4 = i4;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 0:
                        themeVideoUrls3 = (ThemeVideoUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, themeVideoUrls3);
                        i4 |= 1;
                        i3 = 10;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 1:
                        themeImageUrls3 = (ThemeImageUrls) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i4 |= 2;
                        i3 = 10;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 2:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, bool3);
                        i4 |= 4;
                        i3 = 10;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 3:
                        zDecodeBooleanElement5 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 3);
                        i4 |= 8;
                        i3 = 10;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 4:
                        zDecodeBooleanElement8 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
                        i4 |= 16;
                        i3 = 10;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 5:
                        zDecodeBooleanElement7 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
                        i4 |= 32;
                        i3 = 10;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 6:
                        c = 7;
                        zDecodeBooleanElement6 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
                        i4 |= 64;
                        i3 = 10;
                        c2 = '\t';
                        str4 = str4;
                        c3 = '\b';
                        break;
                    case 7:
                        c = 7;
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Size$$serializer.INSTANCE, size3);
                        i4 |= 128;
                        i3 = 10;
                        c2 = '\t';
                        str4 = str4;
                        c3 = '\b';
                        break;
                    case 8:
                        fitMode3 = (FitMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, FitModeDeserializer.INSTANCE, fitMode3);
                        i4 |= 256;
                        c3 = '\b';
                        i3 = 10;
                        c2 = '\t';
                        break;
                    case 9:
                        maskShape3 = (MaskShape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i4 |= 512;
                        c2 = '\t';
                        i3 = 10;
                        str = str4;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 10:
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i4 |= 1024;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 11:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Padding$$serializer.INSTANCE, padding5);
                        i4 |= 2048;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 12:
                        obj = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Padding$$serializer.INSTANCE, obj);
                        i4 |= 4096;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 13:
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, Border$$serializer.INSTANCE, border3);
                        i4 |= 8192;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 14:
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, Shadow$$serializer.INSTANCE, shadow3);
                        i4 |= 16384;
                        str2 = str4;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 15:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, kSerializerArr[15], list3);
                        i2 = 32768;
                        str3 = str4;
                        i4 |= i2;
                        str2 = str3;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    case 16:
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, LocalizationKey$$serializer.INSTANCE, str4 != null ? LocalizationKey.m10428boximpl(str4) : null);
                        String strM10434unboximpl2 = localizationKey2 != null ? localizationKey2.m10434unboximpl() : null;
                        i2 = 65536;
                        str3 = strM10434unboximpl2;
                        i4 |= i2;
                        str2 = str3;
                        c2 = '\t';
                        str = str2;
                        str4 = str;
                        c3 = '\b';
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            ThemeVideoUrls themeVideoUrls4 = themeVideoUrls3;
            Boolean bool4 = bool3;
            ThemeImageUrls themeImageUrls4 = themeImageUrls3;
            padding = padding5;
            shadow = shadow3;
            border = border3;
            padding2 = obj;
            fitMode = fitMode3;
            size = size3;
            colorScheme = colorScheme3;
            themeVideoUrls = themeVideoUrls4;
            i = i4;
            z = zDecodeBooleanElement5;
            z2 = zDecodeBooleanElement6;
            z3 = zDecodeBooleanElement7;
            z4 = zDecodeBooleanElement8;
            list = list3;
            bool = bool4;
            maskShape = maskShape3;
            themeImageUrls = themeImageUrls4;
            strM10434unboximpl = str4;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new VideoComponent(i, themeVideoUrls, themeImageUrls, bool, z, z4, z3, z2, size, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, list, strM10434unboximpl, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, VideoComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        VideoComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
