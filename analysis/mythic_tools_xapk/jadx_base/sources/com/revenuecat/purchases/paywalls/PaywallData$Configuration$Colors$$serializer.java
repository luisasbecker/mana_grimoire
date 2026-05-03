package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
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

/* JADX INFO: compiled from: PaywallData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.Colors.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallData$Configuration$Colors$$serializer implements GeneratedSerializer<PaywallData.Configuration.Colors> {
    public static final PaywallData$Configuration$Colors$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = new PaywallData$Configuration$Colors$$serializer();
        INSTANCE = paywallData$Configuration$Colors$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Colors", paywallData$Configuration$Colors$$serializer, 15);
        pluginGeneratedSerialDescriptor.addElement("background", false);
        pluginGeneratedSerialDescriptor.addElement("text_1", false);
        pluginGeneratedSerialDescriptor.addElement("text_2", true);
        pluginGeneratedSerialDescriptor.addElement("text_3", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_background", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_foreground", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_secondary_background", true);
        pluginGeneratedSerialDescriptor.addElement("accent_1", true);
        pluginGeneratedSerialDescriptor.addElement("accent_2", true);
        pluginGeneratedSerialDescriptor.addElement("accent_3", true);
        pluginGeneratedSerialDescriptor.addElement("close_button", true);
        pluginGeneratedSerialDescriptor.addElement("tier_control_background", true);
        pluginGeneratedSerialDescriptor.addElement("tier_control_foreground", true);
        pluginGeneratedSerialDescriptor.addElement("tier_control_selected_background", true);
        pluginGeneratedSerialDescriptor.addElement("tier_control_selected_foreground", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$Colors$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallColor.Serializer.INSTANCE, PaywallColor.Serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), PaywallColor.Serializer.INSTANCE, PaywallColor.Serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.Configuration.Colors deserialize(Decoder decoder) {
        int i;
        PaywallColor paywallColor;
        PaywallColor paywallColor2;
        PaywallColor paywallColor3;
        PaywallColor paywallColor4;
        PaywallColor paywallColor5;
        PaywallColor paywallColor6;
        PaywallColor paywallColor7;
        PaywallColor paywallColor8;
        PaywallColor paywallColor9;
        PaywallColor paywallColor10;
        PaywallColor paywallColor11;
        PaywallColor paywallColor12;
        PaywallColor paywallColor13;
        PaywallColor paywallColor14;
        PaywallColor paywallColor15;
        PaywallColor paywallColor16;
        PaywallColor paywallColor17;
        PaywallColor paywallColor18;
        PaywallColor paywallColor19;
        PaywallColor paywallColor20;
        PaywallColor paywallColor21;
        PaywallColor paywallColor22;
        PaywallColor paywallColor23;
        PaywallColor paywallColor24;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            PaywallColor paywallColor25 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor26 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor27 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor28 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor29 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor30 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor31 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor32 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor33 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor34 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor35 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor36 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor37 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, PaywallColor.Serializer.INSTANCE, null);
            i = 32767;
            paywallColor = paywallColor35;
            paywallColor7 = paywallColor25;
            paywallColor5 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, PaywallColor.Serializer.INSTANCE, null);
            paywallColor6 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, PaywallColor.Serializer.INSTANCE, null);
            paywallColor3 = paywallColor36;
            paywallColor14 = paywallColor33;
            paywallColor8 = paywallColor37;
            paywallColor4 = paywallColor34;
            paywallColor9 = paywallColor31;
            paywallColor13 = paywallColor28;
            paywallColor2 = paywallColor26;
            paywallColor11 = paywallColor30;
            paywallColor10 = paywallColor29;
            paywallColor12 = paywallColor32;
            paywallColor15 = paywallColor27;
        } else {
            boolean z = true;
            PaywallColor paywallColor38 = null;
            PaywallColor paywallColor39 = null;
            PaywallColor paywallColor40 = null;
            PaywallColor paywallColor41 = null;
            PaywallColor paywallColor42 = null;
            PaywallColor paywallColor43 = null;
            PaywallColor paywallColor44 = null;
            PaywallColor paywallColor45 = null;
            PaywallColor paywallColor46 = null;
            PaywallColor paywallColor47 = null;
            PaywallColor paywallColor48 = null;
            PaywallColor paywallColor49 = null;
            PaywallColor paywallColor50 = null;
            PaywallColor paywallColor51 = null;
            i = 0;
            PaywallColor paywallColor52 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        paywallColor19 = paywallColor50;
                        paywallColor20 = paywallColor51;
                        paywallColor21 = paywallColor52;
                        paywallColor22 = paywallColor38;
                        z = false;
                        paywallColor52 = paywallColor21;
                        paywallColor38 = paywallColor22;
                        paywallColor51 = paywallColor20;
                        paywallColor50 = paywallColor19;
                        break;
                    case 0:
                        PaywallColor paywallColor53 = paywallColor51;
                        paywallColor22 = paywallColor38;
                        paywallColor19 = paywallColor50;
                        paywallColor21 = paywallColor52;
                        paywallColor20 = paywallColor53;
                        paywallColor49 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, PaywallColor.Serializer.INSTANCE, paywallColor49);
                        i |= 1;
                        paywallColor52 = paywallColor21;
                        paywallColor38 = paywallColor22;
                        paywallColor51 = paywallColor20;
                        paywallColor50 = paywallColor19;
                        break;
                    case 1:
                        paywallColor19 = paywallColor50;
                        paywallColor23 = paywallColor52;
                        i |= 2;
                        paywallColor24 = paywallColor38;
                        paywallColor51 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, PaywallColor.Serializer.INSTANCE, paywallColor51);
                        paywallColor38 = paywallColor24;
                        paywallColor52 = paywallColor23;
                        paywallColor50 = paywallColor19;
                        break;
                    case 2:
                        PaywallColor paywallColor54 = paywallColor38;
                        PaywallColor paywallColor55 = paywallColor50;
                        paywallColor23 = paywallColor52;
                        paywallColor19 = paywallColor55;
                        paywallColor24 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallColor.Serializer.INSTANCE, paywallColor54);
                        i |= 4;
                        paywallColor38 = paywallColor24;
                        paywallColor52 = paywallColor23;
                        paywallColor50 = paywallColor19;
                        break;
                    case 3:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor48 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallColor.Serializer.INSTANCE, paywallColor48);
                        i |= 8;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 4:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor45 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, PaywallColor.Serializer.INSTANCE, paywallColor45);
                        i |= 16;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 5:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor47 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, PaywallColor.Serializer.INSTANCE, paywallColor47);
                        i |= 32;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 6:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor44 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, PaywallColor.Serializer.INSTANCE, paywallColor44);
                        i |= 64;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 7:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor43 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, PaywallColor.Serializer.INSTANCE, paywallColor43);
                        i |= 128;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 8:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor42 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, PaywallColor.Serializer.INSTANCE, paywallColor42);
                        i |= 256;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 9:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor46 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, PaywallColor.Serializer.INSTANCE, paywallColor46);
                        i |= 512;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 10:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor41 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, PaywallColor.Serializer.INSTANCE, paywallColor41);
                        i |= 1024;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 11:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor40 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, PaywallColor.Serializer.INSTANCE, paywallColor40);
                        i |= 2048;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 12:
                        paywallColor16 = paywallColor38;
                        paywallColor17 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor39 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, PaywallColor.Serializer.INSTANCE, paywallColor39);
                        i |= 4096;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 13:
                        paywallColor16 = paywallColor38;
                        PaywallColor paywallColor56 = paywallColor50;
                        paywallColor18 = paywallColor52;
                        paywallColor17 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, PaywallColor.Serializer.INSTANCE, paywallColor56);
                        i |= 8192;
                        paywallColor52 = paywallColor18;
                        paywallColor50 = paywallColor17;
                        paywallColor38 = paywallColor16;
                        break;
                    case 14:
                        paywallColor16 = paywallColor38;
                        paywallColor52 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, PaywallColor.Serializer.INSTANCE, paywallColor52);
                        i |= 16384;
                        paywallColor38 = paywallColor16;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            PaywallColor paywallColor57 = paywallColor50;
            PaywallColor paywallColor58 = paywallColor52;
            PaywallColor paywallColor59 = paywallColor49;
            paywallColor = paywallColor41;
            paywallColor2 = paywallColor51;
            paywallColor3 = paywallColor40;
            paywallColor4 = paywallColor46;
            paywallColor5 = paywallColor57;
            paywallColor6 = paywallColor58;
            paywallColor7 = paywallColor59;
            paywallColor8 = paywallColor39;
            paywallColor9 = paywallColor44;
            paywallColor10 = paywallColor45;
            paywallColor11 = paywallColor47;
            paywallColor12 = paywallColor43;
            paywallColor13 = paywallColor48;
            paywallColor14 = paywallColor42;
            paywallColor15 = paywallColor38;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallData.Configuration.Colors(i, paywallColor7, paywallColor2, paywallColor15, paywallColor13, paywallColor10, paywallColor11, paywallColor9, paywallColor12, paywallColor14, paywallColor4, paywallColor, paywallColor3, paywallColor8, paywallColor5, paywallColor6, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.Configuration.Colors value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallData.Configuration.Colors.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
