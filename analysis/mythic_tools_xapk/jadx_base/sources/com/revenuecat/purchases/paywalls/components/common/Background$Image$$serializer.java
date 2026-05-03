package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: Background.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/common/Background.Image.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Image;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class Background$Image$$serializer implements GeneratedSerializer<Background.Image> {
    public static final Background$Image$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Background$Image$$serializer background$Image$$serializer = new Background$Image$$serializer();
        INSTANCE = background$Image$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.Background.Image", background$Image$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        pluginGeneratedSerialDescriptor.addElement("fit_mode", true);
        pluginGeneratedSerialDescriptor.addElement("color_overlay", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Background$Image$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ThemeImageUrls$$serializer.INSTANCE, FitModeDeserializer.INSTANCE, BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Background.Image deserialize(Decoder decoder) {
        int i;
        ThemeImageUrls themeImageUrls;
        FitMode fitMode;
        ColorScheme colorScheme;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        ThemeImageUrls themeImageUrls2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ThemeImageUrls themeImageUrls3 = (ThemeImageUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, FitModeDeserializer.INSTANCE, null);
            themeImageUrls = themeImageUrls3;
            colorScheme = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, null);
            fitMode = fitMode2;
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            FitMode fitMode3 = null;
            ColorScheme colorScheme2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    themeImageUrls2 = (ThemeImageUrls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    fitMode3 = (FitMode) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, FitModeDeserializer.INSTANCE, fitMode3);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme2);
                    i2 |= 4;
                }
            }
            i = i2;
            themeImageUrls = themeImageUrls2;
            fitMode = fitMode3;
            colorScheme = colorScheme2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new Background.Image(i, themeImageUrls, fitMode, colorScheme, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Background.Image value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        Background.Image.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
