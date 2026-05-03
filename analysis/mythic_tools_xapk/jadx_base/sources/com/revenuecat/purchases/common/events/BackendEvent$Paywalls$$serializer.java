package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: BackendEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/events/BackendEvent.Paywalls.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class BackendEvent$Paywalls$$serializer implements GeneratedSerializer<BackendEvent.Paywalls> {
    public static final BackendEvent$Paywalls$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$Paywalls$$serializer backendEvent$Paywalls$$serializer = new BackendEvent$Paywalls$$serializer();
        INSTANCE = backendEvent$Paywalls$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("paywalls", backendEvent$Paywalls$$serializer, 18);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("version", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("app_user_id", false);
        pluginGeneratedSerialDescriptor.addElement("session_id", false);
        pluginGeneratedSerialDescriptor.addElement("offering_id", false);
        pluginGeneratedSerialDescriptor.addElement("paywall_id", false);
        pluginGeneratedSerialDescriptor.addElement("paywall_revision", false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.TIMESTAMP_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("display_mode", false);
        pluginGeneratedSerialDescriptor.addElement("dark_mode", false);
        pluginGeneratedSerialDescriptor.addElement(AndroidContextPlugin.LOCALE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("exit_offer_type", true);
        pluginGeneratedSerialDescriptor.addElement("exit_offering_id", true);
        pluginGeneratedSerialDescriptor.addElement("package_id", true);
        pluginGeneratedSerialDescriptor.addElement("product_id", true);
        pluginGeneratedSerialDescriptor.addElement("error_code", true);
        pluginGeneratedSerialDescriptor.addElement("error_message", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$Paywalls$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.Paywalls deserialize(Decoder decoder) {
        int iDecodeIntElement;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z;
        String str9;
        Integer num;
        String str10;
        String str11;
        String str12;
        int i;
        long j;
        String str13;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
            str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            int iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 7);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 8);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 10);
            String strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, null);
            iDecodeIntElement = iDecodeIntElement2;
            i2 = 262143;
            i = iDecodeIntElement3;
            str12 = strDecodeStringElement5;
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, IntSerializer.INSTANCE, null);
            str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, null);
            str10 = str17;
            str3 = strDecodeStringElement;
            str7 = strDecodeStringElement6;
            str = str14;
            str6 = strDecodeStringElement4;
            j = jDecodeLongElement;
            str11 = str16;
            str2 = str15;
            str8 = strDecodeStringElement7;
            z = zDecodeBooleanElement;
            str5 = strDecodeStringElement3;
            str4 = strDecodeStringElement2;
        } else {
            int i4 = 0;
            int i5 = 17;
            boolean zDecodeBooleanElement2 = false;
            int iDecodeIntElement4 = 0;
            boolean z2 = true;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            Integer num2 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            String strDecodeStringElement11 = null;
            String strDecodeStringElement12 = null;
            String strDecodeStringElement13 = null;
            long jDecodeLongElement2 = 0;
            iDecodeIntElement = 0;
            String strDecodeStringElement14 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        strDecodeStringElement14 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 |= 1;
                        i5 = 17;
                        break;
                    case 1:
                        i4 |= 2;
                        iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
                        i5 = 17;
                        break;
                    case 2:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i4 |= 4;
                        i5 = 17;
                        break;
                    case 3:
                        strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i4 |= 8;
                        i5 = 17;
                        break;
                    case 4:
                        strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i4 |= 16;
                        i5 = 17;
                        break;
                    case 5:
                        strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
                        i4 |= 32;
                        i5 = 17;
                        break;
                    case 6:
                        str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str19);
                        i4 |= 64;
                        i5 = 17;
                        break;
                    case 7:
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 7);
                        i4 |= 128;
                        i5 = 17;
                        break;
                    case 8:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 8);
                        i4 |= 256;
                        i5 = 17;
                        break;
                    case 9:
                        strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
                        i4 |= 512;
                        i5 = 17;
                        break;
                    case 10:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 10);
                        i4 |= 1024;
                        i5 = 17;
                        break;
                    case 11:
                        strDecodeStringElement13 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
                        i4 |= 2048;
                        i5 = 17;
                        break;
                    case 12:
                        str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str18);
                        i4 |= 4096;
                        i5 = 17;
                        break;
                    case 13:
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str22);
                        i4 |= 8192;
                        i5 = 17;
                        break;
                    case 14:
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, str23);
                        i4 |= 16384;
                        i5 = 17;
                        break;
                    case 15:
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str21);
                        i3 = 32768;
                        i4 |= i3;
                        i5 = 17;
                        break;
                    case 16:
                        num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, IntSerializer.INSTANCE, num2);
                        i3 = 65536;
                        i4 |= i3;
                        i5 = 17;
                        break;
                    case 17:
                        str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i5, StringSerializer.INSTANCE, str20);
                        i4 |= 131072;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str18;
            str2 = str22;
            str3 = strDecodeStringElement14;
            str4 = strDecodeStringElement8;
            str5 = strDecodeStringElement9;
            str6 = strDecodeStringElement10;
            str7 = strDecodeStringElement12;
            str8 = strDecodeStringElement13;
            z = zDecodeBooleanElement2;
            str9 = str20;
            num = num2;
            str10 = str21;
            str11 = str23;
            str12 = strDecodeStringElement11;
            i = iDecodeIntElement4;
            j = jDecodeLongElement2;
            str13 = str19;
            i2 = i4;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new BackendEvent.Paywalls(i2, str3, iDecodeIntElement, str4, str5, str6, str12, str13, i, j, str7, z, str8, str, str2, str11, str10, num, str9, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.Paywalls value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        BackendEvent.Paywalls.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
