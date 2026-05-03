package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.models.Checksum$$serializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UInt;
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
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: compiled from: VideoUrls.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/VideoUrls.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class VideoUrls$$serializer implements GeneratedSerializer<VideoUrls> {
    public static final VideoUrls$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        VideoUrls$$serializer videoUrls$$serializer = new VideoUrls$$serializer();
        INSTANCE = videoUrls$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.VideoUrls", videoUrls$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("width", false);
        pluginGeneratedSerialDescriptor.addElement("height", false);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        pluginGeneratedSerialDescriptor.addElement("checksum", true);
        pluginGeneratedSerialDescriptor.addElement("url_low_res", true);
        pluginGeneratedSerialDescriptor.addElement("checksum_low_res", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private VideoUrls$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{UIntSerializer.INSTANCE, UIntSerializer.INSTANCE, URLSerializer.INSTANCE, BuiltinSerializersKt.getNullable(Checksum$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(URLSerializer.INSTANCE), BuiltinSerializersKt.getNullable(Checksum$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public VideoUrls deserialize(Decoder decoder) {
        URL url;
        Checksum checksum;
        URL url2;
        Checksum checksum2;
        UInt uInt;
        UInt uInt2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 5;
        UInt uInt3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            UInt uInt4 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, UIntSerializer.INSTANCE, null);
            UInt uInt5 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, UIntSerializer.INSTANCE, null);
            URL url3 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, URLSerializer.INSTANCE, null);
            Checksum checksum3 = (Checksum) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Checksum$$serializer.INSTANCE, null);
            URL url4 = (URL) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, URLSerializer.INSTANCE, null);
            uInt = uInt4;
            checksum = (Checksum) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, Checksum$$serializer.INSTANCE, null);
            checksum2 = checksum3;
            url = url4;
            url2 = url3;
            uInt2 = uInt5;
            i = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            UInt uInt6 = null;
            URL url5 = null;
            Checksum checksum4 = null;
            URL url6 = null;
            Checksum checksum5 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 5;
                        break;
                    case 0:
                        uInt3 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, UIntSerializer.INSTANCE, uInt3);
                        i3 |= 1;
                        i2 = 5;
                        break;
                    case 1:
                        uInt6 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, UIntSerializer.INSTANCE, uInt6);
                        i3 |= 2;
                        break;
                    case 2:
                        url5 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, URLSerializer.INSTANCE, url5);
                        i3 |= 4;
                        break;
                    case 3:
                        checksum4 = (Checksum) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Checksum$$serializer.INSTANCE, checksum4);
                        i3 |= 8;
                        break;
                    case 4:
                        url6 = (URL) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, URLSerializer.INSTANCE, url6);
                        i3 |= 16;
                        break;
                    case 5:
                        checksum5 = (Checksum) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, Checksum$$serializer.INSTANCE, checksum5);
                        i3 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            url = url6;
            checksum = checksum5;
            url2 = url5;
            checksum2 = checksum4;
            uInt = uInt3;
            uInt2 = uInt6;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new VideoUrls(i, uInt, uInt2, url2, checksum2, url, checksum, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, VideoUrls value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        VideoUrls.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
