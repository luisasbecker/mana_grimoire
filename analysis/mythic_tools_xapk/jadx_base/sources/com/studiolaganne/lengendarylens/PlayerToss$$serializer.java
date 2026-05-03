package com.studiolaganne.lengendarylens;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/studiolaganne/lengendarylens/PlayerToss.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/studiolaganne/lengendarylens/PlayerToss;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class PlayerToss$$serializer implements GeneratedSerializer<PlayerToss> {
    public static final int $stable;
    public static final PlayerToss$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerToss$$serializer playerToss$$serializer = new PlayerToss$$serializer();
        INSTANCE = playerToss$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.studiolaganne.lengendarylens.PlayerToss", playerToss$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("enMessage", true);
        pluginGeneratedSerialDescriptor.addElement("frMessage", true);
        pluginGeneratedSerialDescriptor.addElement("backgroundColor", true);
        pluginGeneratedSerialDescriptor.addElement("borderColor", true);
        pluginGeneratedSerialDescriptor.addElement("enChallenges", true);
        pluginGeneratedSerialDescriptor.addElement("frChallenges", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private PlayerToss$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = PlayerToss.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(MessageData$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(MessageData$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), lazyArr[5].getValue(), lazyArr[6].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PlayerToss deserialize(Decoder decoder) {
        List list;
        String str;
        MessageData messageData;
        String str2;
        List list2;
        MessageData messageData2;
        String str3;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = PlayerToss.$childSerializers;
        int i2 = 3;
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            MessageData messageData3 = (MessageData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MessageData$$serializer.INSTANCE, null);
            MessageData messageData4 = (MessageData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MessageData$$serializer.INSTANCE, null);
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            str3 = str4;
            str2 = str5;
            messageData = messageData4;
            list2 = list3;
            messageData2 = messageData3;
            str = strDecodeStringElement2;
            i = 127;
        } else {
            boolean z = true;
            int i3 = 0;
            List list4 = null;
            List list5 = null;
            MessageData messageData5 = null;
            MessageData messageData6 = null;
            String str6 = null;
            String str7 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                        i2 = 3;
                        break;
                    case 1:
                        messageData5 = (MessageData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MessageData$$serializer.INSTANCE, messageData5);
                        i3 |= 2;
                        i2 = 3;
                        break;
                    case 2:
                        messageData6 = (MessageData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MessageData$$serializer.INSTANCE, messageData6);
                        i3 |= 4;
                        i2 = 3;
                        break;
                    case 3:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str6);
                        i3 |= 8;
                        break;
                    case 4:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str7);
                        i3 |= 16;
                        break;
                    case 5:
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), list5);
                        i3 |= 32;
                        break;
                    case 6:
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list4);
                        i3 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str8 = str7;
            list = list4;
            str = strDecodeStringElement;
            messageData = messageData6;
            str2 = str8;
            String str9 = str6;
            list2 = list5;
            messageData2 = messageData5;
            str3 = str9;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerToss(i, str, messageData2, messageData, str3, str2, list2, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PlayerToss value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        PlayerToss.write$Self$app_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
