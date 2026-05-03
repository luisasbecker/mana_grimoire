package com.studiolaganne.lengendarylens;

import androidx.media3.common.MimeTypes;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SkinManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/studiolaganne/lengendarylens/MessageData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/studiolaganne/lengendarylens/MessageData;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class MessageData$$serializer implements GeneratedSerializer<MessageData> {
    public static final int $stable;
    public static final MessageData$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MessageData$$serializer messageData$$serializer = new MessageData$$serializer();
        INSTANCE = messageData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.studiolaganne.lengendarylens.MessageData", messageData$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(MimeTypes.BASE_TYPE_IMAGE, true);
        pluginGeneratedSerialDescriptor.addElement("text", true);
        pluginGeneratedSerialDescriptor.addElement("color", true);
        pluginGeneratedSerialDescriptor.addElement("imagePlacement", true);
        pluginGeneratedSerialDescriptor.addElement("animation", true);
        pluginGeneratedSerialDescriptor.addElement("fullscreenImage", true);
        pluginGeneratedSerialDescriptor.addElement("dimColor", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private MessageData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LottieDefinition$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final MessageData deserialize(Decoder decoder) {
        String str;
        String str2;
        LottieDefinition lottieDefinition;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 6;
        int i3 = 5;
        String str7 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            LottieDefinition lottieDefinition2 = (LottieDefinition) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LottieDefinition$$serializer.INSTANCE, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            str6 = str8;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            str2 = str11;
            str3 = str10;
            lottieDefinition = lottieDefinition2;
            str4 = str9;
            str5 = strDecodeStringElement;
            i = 127;
        } else {
            boolean z = true;
            int i4 = 0;
            String str12 = null;
            String strDecodeStringElement2 = null;
            String str13 = null;
            String str14 = null;
            LottieDefinition lottieDefinition3 = null;
            String str15 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 5;
                        break;
                    case 0:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str7);
                        i4 |= 1;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 1:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str13);
                        i4 |= 4;
                        break;
                    case 3:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str14);
                        i4 |= 8;
                        break;
                    case 4:
                        lottieDefinition3 = (LottieDefinition) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LottieDefinition$$serializer.INSTANCE, lottieDefinition3);
                        i4 |= 16;
                        break;
                    case 5:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str15);
                        i4 |= 32;
                        break;
                    case 6:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str12);
                        i4 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str12;
            str2 = str15;
            lottieDefinition = lottieDefinition3;
            str3 = str14;
            str4 = str13;
            str5 = strDecodeStringElement2;
            str6 = str7;
            i = i4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MessageData(i, str6, str5, str4, str3, lottieDefinition, str2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, MessageData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        MessageData.write$Self$app_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
