package com.studiolaganne.lengendarylens;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SkinManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/studiolaganne/lengendarylens/LottieDefinition.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/studiolaganne/lengendarylens/LottieDefinition;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class LottieDefinition$$serializer implements GeneratedSerializer<LottieDefinition> {
    public static final int $stable;
    public static final LottieDefinition$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LottieDefinition$$serializer lottieDefinition$$serializer = new LottieDefinition$$serializer();
        INSTANCE = lottieDefinition$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.studiolaganne.lengendarylens.LottieDefinition", lottieDefinition$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("file", true);
        pluginGeneratedSerialDescriptor.addElement("alpha", true);
        pluginGeneratedSerialDescriptor.addElement("scale", true);
        pluginGeneratedSerialDescriptor.addElement("speed", true);
        pluginGeneratedSerialDescriptor.addElement("loop", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private LottieDefinition$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final LottieDefinition deserialize(Decoder decoder) {
        int i;
        String str;
        Float f;
        Float f2;
        Float f3;
        Boolean bool;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            Float f4 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FloatSerializer.INSTANCE, null);
            Float f5 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, FloatSerializer.INSTANCE, null);
            str = strDecodeStringElement2;
            f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, FloatSerializer.INSTANCE, null);
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BooleanSerializer.INSTANCE, null);
            f2 = f5;
            f = f4;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            Float f6 = null;
            Float f7 = null;
            Float f8 = null;
            Boolean bool2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    f6 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FloatSerializer.INSTANCE, f6);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    f7 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, FloatSerializer.INSTANCE, f7);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    f8 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, FloatSerializer.INSTANCE, f8);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BooleanSerializer.INSTANCE, bool2);
                    i2 |= 16;
                }
            }
            i = i2;
            str = strDecodeStringElement;
            f = f6;
            f2 = f7;
            f3 = f8;
            bool = bool2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LottieDefinition(i, str, f, f2, f3, bool, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, LottieDefinition value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        LottieDefinition.write$Self$app_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
