package com.revenuecat.purchases.customercenter;

import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CustomerCenterConfigData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.HelpPath.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CustomerCenterConfigData$HelpPath$$serializer implements GeneratedSerializer<CustomerCenterConfigData.HelpPath> {
    public static final CustomerCenterConfigData$HelpPath$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$HelpPath$$serializer customerCenterConfigData$HelpPath$$serializer = new CustomerCenterConfigData$HelpPath$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath", customerCenterConfigData$HelpPath$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.GP_IAP_TITLE, false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("promotional_offer", true);
        pluginGeneratedSerialDescriptor.addElement("feedback_survey", true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("open_method", true);
        pluginGeneratedSerialDescriptor.addElement("action_identifier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$HelpPath$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CustomerCenterConfigData.HelpPath.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializerArr[2], BuiltinSerializersKt.getNullable(CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[6]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.HelpPath deserialize(Decoder decoder) {
        String str;
        String str2;
        CustomerCenterConfigData.HelpPath.PathType pathType;
        CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey;
        String str3;
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer;
        String str4;
        CustomerCenterConfigData.HelpPath.OpenMethod openMethod;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = CustomerCenterConfigData.HelpPath.$childSerializers;
        int i3 = 7;
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            CustomerCenterConfigData.HelpPath.PathType pathType2 = (CustomerCenterConfigData.HelpPath.PathType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer2 = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, null);
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey2 = (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            openMethod = (CustomerCenterConfigData.HelpPath.OpenMethod) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            str = str5;
            promotionalOffer = promotionalOffer2;
            feedbackSurvey = feedbackSurvey2;
            pathType = pathType2;
            str3 = strDecodeStringElement3;
            str2 = strDecodeStringElement2;
            i = 255;
        } else {
            int i4 = 2;
            boolean z = true;
            int i5 = 0;
            String str6 = null;
            CustomerCenterConfigData.HelpPath.OpenMethod openMethod2 = null;
            String str7 = null;
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey3 = null;
            String strDecodeStringElement4 = null;
            CustomerCenterConfigData.HelpPath.PathType pathType3 = null;
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        i2 = i4;
                        z = false;
                        i4 = i2;
                        i3 = 7;
                        break;
                    case 0:
                        i2 = i4;
                        i5 |= 1;
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 = i2;
                        i3 = 7;
                        break;
                    case 1:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i5 |= 2;
                        i3 = 7;
                        break;
                    case 2:
                        pathType3 = (CustomerCenterConfigData.HelpPath.PathType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, kSerializerArr[i4], pathType3);
                        i5 |= 4;
                        i3 = 7;
                        break;
                    case 3:
                        promotionalOffer3 = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, promotionalOffer3);
                        i5 |= 8;
                        i3 = 7;
                        break;
                    case 4:
                        feedbackSurvey3 = (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, feedbackSurvey3);
                        i5 |= 16;
                        i3 = 7;
                        break;
                    case 5:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str7);
                        i5 |= 32;
                        break;
                    case 6:
                        openMethod2 = (CustomerCenterConfigData.HelpPath.OpenMethod) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, kSerializerArr[6], openMethod2);
                        i5 |= 64;
                        break;
                    case 7:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, StringSerializer.INSTANCE, str6);
                        i5 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer4 = promotionalOffer3;
            str = str7;
            str2 = strDecodeStringElement;
            pathType = pathType3;
            feedbackSurvey = feedbackSurvey3;
            str3 = strDecodeStringElement4;
            promotionalOffer = promotionalOffer4;
            str4 = str6;
            openMethod = openMethod2;
            i = i5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CustomerCenterConfigData.HelpPath(i, str2, str3, pathType, promotionalOffer, feedbackSurvey, str, openMethod, str4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.HelpPath value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CustomerCenterConfigData.HelpPath.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
