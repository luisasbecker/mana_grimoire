package com.revenuecat.purchases.common;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PresentedOfferingContextSerializer;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.ReplacementModeSerializer;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PeriodSerializer;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ReceiptInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/ReceiptInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class ReceiptInfo$$serializer implements GeneratedSerializer<ReceiptInfo> {
    public static final ReceiptInfo$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ReceiptInfo$$serializer receiptInfo$$serializer = new ReceiptInfo$$serializer();
        INSTANCE = receiptInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.ReceiptInfo", receiptInfo$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("productIDs", false);
        pluginGeneratedSerialDescriptor.addElement(com.facebook.appevents.internal.Constants.GP_IAP_PURCHASE_TIME, true);
        pluginGeneratedSerialDescriptor.addElement("presentedOfferingContext", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.PRICE, true);
        pluginGeneratedSerialDescriptor.addElement("formattedPrice", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.CURRENCY, true);
        pluginGeneratedSerialDescriptor.addElement(TypedValues.CycleType.S_WAVE_PERIOD, true);
        pluginGeneratedSerialDescriptor.addElement(com.facebook.appevents.internal.Constants.GP_IAP_SUBSCRIPTION_PRICING_PHASES, true);
        pluginGeneratedSerialDescriptor.addElement("replacementMode", true);
        pluginGeneratedSerialDescriptor.addElement("platformProductIds", true);
        pluginGeneratedSerialDescriptor.addElement("sdkOriginated", true);
        pluginGeneratedSerialDescriptor.addElement("storeUserID", true);
        pluginGeneratedSerialDescriptor.addElement("marketplace", true);
        pluginGeneratedSerialDescriptor.addElement(TypedValues.TransitionType.S_DURATION, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ReceiptInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = ReceiptInfo.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PresentedOfferingContextSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PeriodSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[7]), BuiltinSerializersKt.getNullable(ReplacementModeSerializer.INSTANCE), kSerializerArr[9], BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ReceiptInfo deserialize(Decoder decoder) {
        int i;
        String str;
        List list;
        Double d;
        String str2;
        String str3;
        Period period;
        String str4;
        ReplacementMode replacementMode;
        Long l;
        List list2;
        String str5;
        PresentedOfferingContext presentedOfferingContext;
        boolean z;
        List list3;
        String str6;
        PresentedOfferingContext presentedOfferingContext2;
        String str7;
        Long l2;
        String str8;
        Long l3;
        Long l4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = ReceiptInfo.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            Long l5 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, LongSerializer.INSTANCE, null);
            PresentedOfferingContext presentedOfferingContext3 = (PresentedOfferingContext) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PresentedOfferingContextSerializer.INSTANCE, null);
            Double d2 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, DoubleSerializer.INSTANCE, null);
            str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            Period period2 = (Period) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, PeriodSerializer.INSTANCE, null);
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], null);
            ReplacementMode replacementMode2 = (ReplacementMode) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ReplacementModeSerializer.INSTANCE, null);
            List list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, kSerializerArr[9], null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 10);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            i = 16383;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            z = zDecodeBooleanElement;
            list2 = list5;
            str2 = str10;
            list = list6;
            period = period2;
            str4 = str9;
            replacementMode = replacementMode2;
            list3 = list4;
            l = l5;
            d = d2;
            presentedOfferingContext = presentedOfferingContext3;
        } else {
            boolean zDecodeBooleanElement2 = false;
            boolean z2 = true;
            String str11 = null;
            PresentedOfferingContext presentedOfferingContext4 = null;
            String str12 = null;
            List list7 = null;
            Period period3 = null;
            String str13 = null;
            List list8 = null;
            String str14 = null;
            Double d3 = null;
            List list9 = null;
            int i2 = 9;
            int i3 = 7;
            i = 0;
            Long l6 = null;
            String str15 = null;
            ReplacementMode replacementMode3 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        str6 = str11;
                        presentedOfferingContext2 = presentedOfferingContext4;
                        z2 = false;
                        str11 = str6;
                        presentedOfferingContext4 = presentedOfferingContext2;
                        i3 = 7;
                        i2 = 9;
                        break;
                    case 0:
                        i |= 1;
                        list9 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], list9);
                        presentedOfferingContext4 = presentedOfferingContext4;
                        i3 = 7;
                        i2 = 9;
                        l6 = l6;
                        str11 = str11;
                        break;
                    case 1:
                        str6 = str11;
                        presentedOfferingContext2 = presentedOfferingContext4;
                        l6 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, LongSerializer.INSTANCE, l6);
                        i |= 2;
                        str11 = str6;
                        presentedOfferingContext4 = presentedOfferingContext2;
                        i3 = 7;
                        i2 = 9;
                        break;
                    case 2:
                        str7 = str11;
                        l2 = l6;
                        presentedOfferingContext4 = (PresentedOfferingContext) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PresentedOfferingContextSerializer.INSTANCE, presentedOfferingContext4);
                        i |= 4;
                        str11 = str7;
                        l6 = l2;
                        i3 = 7;
                        i2 = 9;
                        break;
                    case 3:
                        str7 = str11;
                        l2 = l6;
                        d3 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, DoubleSerializer.INSTANCE, d3);
                        i |= 8;
                        str11 = str7;
                        l6 = l2;
                        i3 = 7;
                        i2 = 9;
                        break;
                    case 4:
                        str7 = str11;
                        l2 = l6;
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str13);
                        i |= 16;
                        str11 = str7;
                        l6 = l2;
                        i3 = 7;
                        i2 = 9;
                        break;
                    case 5:
                        str7 = str11;
                        l2 = l6;
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str14);
                        i |= 32;
                        str11 = str7;
                        l6 = l2;
                        i3 = 7;
                        i2 = 9;
                        break;
                    case 6:
                        str7 = str11;
                        l2 = l6;
                        period3 = (Period) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, PeriodSerializer.INSTANCE, period3);
                        i |= 64;
                        str11 = str7;
                        l6 = l2;
                        i3 = 7;
                        i2 = 9;
                        break;
                    case 7:
                        str8 = str11;
                        l3 = l6;
                        list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, kSerializerArr[i3], list7);
                        i |= 128;
                        str11 = str8;
                        l6 = l3;
                        i2 = 9;
                        break;
                    case 8:
                        str8 = str11;
                        l3 = l6;
                        replacementMode3 = (ReplacementMode) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ReplacementModeSerializer.INSTANCE, replacementMode3);
                        i |= 256;
                        str11 = str8;
                        l6 = l3;
                        i2 = 9;
                        break;
                    case 9:
                        l4 = l6;
                        list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i2, kSerializerArr[i2], list8);
                        i |= 512;
                        str11 = str11;
                        l6 = l4;
                        break;
                    case 10:
                        l4 = l6;
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 10);
                        i |= 1024;
                        l6 = l4;
                        break;
                    case 11:
                        l4 = l6;
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str15);
                        i |= 2048;
                        l6 = l4;
                        break;
                    case 12:
                        l4 = l6;
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str12);
                        i |= 4096;
                        l6 = l4;
                        break;
                    case 13:
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str11);
                        i |= 8192;
                        l6 = l6;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            PresentedOfferingContext presentedOfferingContext5 = presentedOfferingContext4;
            List list10 = list9;
            str = str12;
            list = list8;
            d = d3;
            str2 = str15;
            str3 = str11;
            period = period3;
            str4 = str14;
            replacementMode = replacementMode3;
            l = l6;
            list2 = list7;
            str5 = str13;
            presentedOfferingContext = presentedOfferingContext5;
            z = zDecodeBooleanElement2;
            list3 = list10;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new ReceiptInfo(i, list3, l, presentedOfferingContext, d, str5, str4, period, list2, replacementMode, list, z, str2, str, str3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ReceiptInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        ReceiptInfo.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
