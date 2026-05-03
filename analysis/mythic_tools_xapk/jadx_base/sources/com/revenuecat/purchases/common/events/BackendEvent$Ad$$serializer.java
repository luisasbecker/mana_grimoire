package com.revenuecat.purchases.common.events;

import com.appsflyer.AdRevenueScheme;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: BackendEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/events/BackendEvent.Ad.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class BackendEvent$Ad$$serializer implements GeneratedSerializer<BackendEvent.Ad> {
    public static final BackendEvent$Ad$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$Ad$$serializer backendEvent$Ad$$serializer = new BackendEvent$Ad$$serializer();
        INSTANCE = backendEvent$Ad$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ad", backendEvent$Ad$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("version", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("timestamp_ms", false);
        pluginGeneratedSerialDescriptor.addElement("network_name", true);
        pluginGeneratedSerialDescriptor.addElement("mediator_name", false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.AD_FORMAT, true);
        pluginGeneratedSerialDescriptor.addElement(AdRevenueScheme.PLACEMENT, false);
        pluginGeneratedSerialDescriptor.addElement("ad_unit_id", false);
        pluginGeneratedSerialDescriptor.addElement("impression_id", false);
        pluginGeneratedSerialDescriptor.addElement("app_user_id", false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("revenue_micros", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.CURRENCY, true);
        pluginGeneratedSerialDescriptor.addElement("precision", true);
        pluginGeneratedSerialDescriptor.addElement("mediator_error_code", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$Ad$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.Ad deserialize(Decoder decoder) {
        String str;
        Long l;
        Integer num;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        long j;
        String str9;
        String str10;
        String str11;
        String str12;
        int i;
        int i2;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i3 = 11;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 3);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 10);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
            Long l2 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, LongSerializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, null);
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, IntSerializer.INSTANCE, null);
            str8 = strDecodeStringElement6;
            str7 = strDecodeStringElement5;
            str2 = str16;
            str12 = str15;
            str6 = strDecodeStringElement4;
            l = l2;
            str11 = str17;
            j = jDecodeLongElement;
            str4 = strDecodeStringElement2;
            i2 = iDecodeIntElement;
            str9 = str14;
            str5 = strDecodeStringElement3;
            str3 = strDecodeStringElement;
            str = str13;
            i = 65535;
        } else {
            int i4 = 0;
            int i5 = 15;
            boolean z = true;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            String str21 = null;
            Long l3 = null;
            String str22 = null;
            Integer num2 = null;
            String str23 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            String strDecodeStringElement11 = null;
            long jDecodeLongElement2 = 0;
            int iDecodeIntElement2 = 0;
            String strDecodeStringElement12 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i5 = 15;
                        break;
                    case 0:
                        strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 |= 1;
                        i5 = 15;
                        i3 = 11;
                        break;
                    case 1:
                        i4 |= 2;
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
                        i5 = 15;
                        i3 = 11;
                        break;
                    case 2:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i4 |= 4;
                        i5 = 15;
                        i3 = 11;
                        break;
                    case 3:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 3);
                        i4 |= 8;
                        i5 = 15;
                        i3 = 11;
                        break;
                    case 4:
                        str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str19);
                        i4 |= 16;
                        i5 = 15;
                        i3 = 11;
                        break;
                    case 5:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
                        i4 |= 32;
                        i5 = 15;
                        i3 = 11;
                        break;
                    case 6:
                        str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str18);
                        i4 |= 64;
                        i5 = 15;
                        i3 = 11;
                        break;
                    case 7:
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str22);
                        i4 |= 128;
                        i5 = 15;
                        i3 = 11;
                        break;
                    case 8:
                        c = '\t';
                        strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
                        i4 |= 256;
                        i5 = 15;
                        break;
                    case 9:
                        c = '\t';
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str23);
                        i4 |= 512;
                        i5 = 15;
                        break;
                    case 10:
                        strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 10);
                        i4 |= 1024;
                        i5 = 15;
                        break;
                    case 11:
                        strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i3);
                        i4 |= 2048;
                        i5 = 15;
                        break;
                    case 12:
                        l3 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, LongSerializer.INSTANCE, l3);
                        i4 |= 4096;
                        i5 = 15;
                        break;
                    case 13:
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str21);
                        i4 |= 8192;
                        i5 = 15;
                        break;
                    case 14:
                        str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, str20);
                        i4 |= 16384;
                        i5 = 15;
                        break;
                    case 15:
                        num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i5, IntSerializer.INSTANCE, num2);
                        i4 |= 32768;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str19;
            l = l3;
            num = num2;
            str2 = str23;
            str3 = strDecodeStringElement12;
            str4 = strDecodeStringElement7;
            str5 = strDecodeStringElement8;
            str6 = strDecodeStringElement9;
            str7 = strDecodeStringElement10;
            str8 = strDecodeStringElement11;
            j = jDecodeLongElement2;
            str9 = str18;
            str10 = str20;
            str11 = str21;
            str12 = str22;
            i = i4;
            i2 = iDecodeIntElement2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new BackendEvent.Ad(i, str3, i2, str4, j, str, str5, str9, str12, str6, str2, str7, str8, l, str11, str10, num, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.Ad value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        BackendEvent.Ad.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
