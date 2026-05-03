package com.revenuecat.purchases.customercenter;

import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CustomerCenterConfigData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.Screen.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CustomerCenterConfigData$Screen$$serializer implements GeneratedSerializer<CustomerCenterConfigData.Screen> {
    public static final CustomerCenterConfigData$Screen$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$Screen$$serializer customerCenterConfigData$Screen$$serializer = new CustomerCenterConfigData$Screen$$serializer();
        INSTANCE = customerCenterConfigData$Screen$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen", customerCenterConfigData$Screen$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.GP_IAP_TITLE, false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", true);
        pluginGeneratedSerialDescriptor.addElement("paths", false);
        pluginGeneratedSerialDescriptor.addElement("offering", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$Screen$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{CustomerCenterConfigData.Screen.$childSerializers[0], StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE), HelpPathsSerializer.INSTANCE, BuiltinSerializersKt.getNullable(CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.Screen deserialize(Decoder decoder) {
        int i;
        CustomerCenterConfigData.Screen.ScreenType screenType;
        String str;
        String str2;
        List list;
        CustomerCenterConfigData.ScreenOffering screenOffering;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = CustomerCenterConfigData.Screen.$childSerializers;
        int i2 = 0;
        CustomerCenterConfigData.Screen.ScreenType screenType2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            CustomerCenterConfigData.Screen.ScreenType screenType3 = (CustomerCenterConfigData.Screen.ScreenType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, null);
            screenType = screenType3;
            str = strDecodeStringElement;
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, HelpPathsSerializer.INSTANCE, null);
            screenOffering = (CustomerCenterConfigData.ScreenOffering) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, null);
            str2 = str3;
            i = 31;
        } else {
            int i3 = 1;
            int i4 = 0;
            String strDecodeStringElement2 = null;
            String str4 = null;
            List list2 = null;
            CustomerCenterConfigData.ScreenOffering screenOffering2 = null;
            while (i3 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                int i5 = i2;
                if (iDecodeElementIndex == -1) {
                    i2 = i5;
                    i3 = i2;
                } else if (iDecodeElementIndex != 0) {
                    if (iDecodeElementIndex == 1) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i4 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, str4);
                        i4 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, HelpPathsSerializer.INSTANCE, list2);
                        i4 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        screenOffering2 = (CustomerCenterConfigData.ScreenOffering) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, screenOffering2);
                        i4 |= 16;
                    }
                    i2 = i5;
                } else {
                    screenType2 = (CustomerCenterConfigData.Screen.ScreenType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i5, kSerializerArr[i5], screenType2);
                    i4 |= 1;
                    i2 = i5;
                }
            }
            i = i4;
            screenType = screenType2;
            str = strDecodeStringElement2;
            str2 = str4;
            list = list2;
            screenOffering = screenOffering2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CustomerCenterConfigData.Screen(i, screenType, str, str2, list, screenOffering, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.Screen value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CustomerCenterConfigData.Screen.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
