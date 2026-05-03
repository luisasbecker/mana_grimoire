package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
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

/* JADX INFO: compiled from: Background.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/common/Background.Video.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Video;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class Background$Video$$serializer implements GeneratedSerializer<Background.Video> {
    public static final Background$Video$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Background$Video$$serializer background$Video$$serializer = new Background$Video$$serializer();
        INSTANCE = background$Video$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.Background.Video", background$Video$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        pluginGeneratedSerialDescriptor.addElement("fallback_image", false);
        pluginGeneratedSerialDescriptor.addElement("loop", false);
        pluginGeneratedSerialDescriptor.addElement("mute_audio", false);
        pluginGeneratedSerialDescriptor.addElement("fit_mode", true);
        pluginGeneratedSerialDescriptor.addElement("color_overlay", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Background$Video$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ThemeVideoUrls$$serializer.INSTANCE, ThemeImageUrls$$serializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, FitModeDeserializer.INSTANCE, BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Background.Video deserialize(Decoder decoder) {
        int i;
        ThemeVideoUrls themeVideoUrls;
        ThemeImageUrls themeImageUrls;
        FitMode fitMode;
        ColorScheme colorScheme;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 5;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ThemeVideoUrls themeVideoUrls2 = (ThemeVideoUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 2);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 3);
            FitMode fitMode2 = (FitMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, FitModeDeserializer.INSTANCE, null);
            themeVideoUrls = themeVideoUrls2;
            colorScheme = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            z = zDecodeBooleanElement2;
            fitMode = fitMode2;
            z2 = zDecodeBooleanElement;
            themeImageUrls = themeImageUrls2;
            i = 63;
        } else {
            boolean z3 = true;
            boolean zDecodeBooleanElement3 = false;
            i = 0;
            themeVideoUrls = null;
            themeImageUrls = null;
            FitMode fitMode3 = null;
            ColorScheme colorScheme2 = null;
            boolean zDecodeBooleanElement4 = false;
            while (z3) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z3 = false;
                        i2 = 5;
                        break;
                    case 0:
                        themeVideoUrls = (ThemeVideoUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, themeVideoUrls);
                        i |= 1;
                        i2 = 5;
                        break;
                    case 1:
                        themeImageUrls = (ThemeImageUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls);
                        i |= 2;
                        break;
                    case 2:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 2);
                        i |= 4;
                        break;
                    case 3:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 3);
                        i |= 8;
                        break;
                    case 4:
                        fitMode3 = (FitMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, FitModeDeserializer.INSTANCE, fitMode3);
                        i |= 16;
                        break;
                    case 5:
                        colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, ColorScheme$$serializer.INSTANCE, colorScheme2);
                        i |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            fitMode = fitMode3;
            colorScheme = colorScheme2;
            z = zDecodeBooleanElement3;
            z2 = zDecodeBooleanElement4;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new Background.Video(i, themeVideoUrls, themeImageUrls, z2, z, fitMode, colorScheme, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Background.Video value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        Background.Video.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
