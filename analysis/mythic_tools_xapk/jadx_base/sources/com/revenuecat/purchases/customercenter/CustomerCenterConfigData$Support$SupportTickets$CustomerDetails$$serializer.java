package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: CustomerCenterConfigData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.Support.SupportTickets.CustomerDetails.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer implements GeneratedSerializer<CustomerCenterConfigData.Support.SupportTickets.CustomerDetails> {
    public static final CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer customerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer = new CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer();
        INSTANCE = customerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.CustomerDetails", customerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("active_entitlements", true);
        pluginGeneratedSerialDescriptor.addElement("app_user_id", true);
        pluginGeneratedSerialDescriptor.addElement("att_consent", true);
        pluginGeneratedSerialDescriptor.addElement("country", true);
        pluginGeneratedSerialDescriptor.addElement("device_version", true);
        pluginGeneratedSerialDescriptor.addElement("email", true);
        pluginGeneratedSerialDescriptor.addElement("facebook_anon_id", true);
        pluginGeneratedSerialDescriptor.addElement("idfa", true);
        pluginGeneratedSerialDescriptor.addElement("idfv", true);
        pluginGeneratedSerialDescriptor.addElement("ip", true);
        pluginGeneratedSerialDescriptor.addElement("last_opened", true);
        pluginGeneratedSerialDescriptor.addElement("last_seen_app_version", true);
        pluginGeneratedSerialDescriptor.addElement("total_spent", true);
        pluginGeneratedSerialDescriptor.addElement("user_since", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData.Support.SupportTickets.CustomerDetails deserialize(Decoder decoder) {
        boolean zDecodeBooleanElement;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean zDecodeBooleanElement2;
        boolean zDecodeBooleanElement3;
        boolean z9;
        boolean z10;
        boolean z11;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 0;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            boolean zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 0);
            boolean zDecodeBooleanElement5 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 1);
            boolean zDecodeBooleanElement6 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 2);
            boolean zDecodeBooleanElement7 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 3);
            boolean zDecodeBooleanElement8 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
            boolean zDecodeBooleanElement9 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
            boolean zDecodeBooleanElement10 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
            boolean zDecodeBooleanElement11 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 7);
            boolean zDecodeBooleanElement12 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 8);
            boolean zDecodeBooleanElement13 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 9);
            boolean zDecodeBooleanElement14 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 10);
            boolean zDecodeBooleanElement15 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 11);
            z9 = zDecodeBooleanElement4;
            z11 = zDecodeBooleanElement5;
            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 12);
            z10 = zDecodeBooleanElement15;
            z = zDecodeBooleanElement14;
            z3 = zDecodeBooleanElement13;
            z5 = zDecodeBooleanElement11;
            z7 = zDecodeBooleanElement10;
            z8 = zDecodeBooleanElement9;
            z4 = zDecodeBooleanElement7;
            zDecodeBooleanElement = zDecodeBooleanElement12;
            z6 = zDecodeBooleanElement8;
            z2 = zDecodeBooleanElement6;
            zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 13);
            i = 16383;
        } else {
            int i3 = 13;
            boolean zDecodeBooleanElement16 = false;
            boolean zDecodeBooleanElement17 = false;
            boolean zDecodeBooleanElement18 = false;
            boolean zDecodeBooleanElement19 = false;
            boolean zDecodeBooleanElement20 = false;
            boolean zDecodeBooleanElement21 = false;
            boolean zDecodeBooleanElement22 = false;
            boolean zDecodeBooleanElement23 = false;
            boolean zDecodeBooleanElement24 = false;
            boolean zDecodeBooleanElement25 = false;
            zDecodeBooleanElement = false;
            boolean zDecodeBooleanElement26 = false;
            boolean zDecodeBooleanElement27 = false;
            boolean zDecodeBooleanElement28 = false;
            boolean z12 = true;
            while (z12) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z12 = false;
                        i3 = 13;
                        break;
                    case 0:
                        zDecodeBooleanElement16 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 0);
                        i2 |= 1;
                        i3 = 13;
                        break;
                    case 1:
                        zDecodeBooleanElement17 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        zDecodeBooleanElement27 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        zDecodeBooleanElement25 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 3);
                        i2 |= 8;
                        break;
                    case 4:
                        zDecodeBooleanElement26 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
                        i2 |= 16;
                        break;
                    case 5:
                        zDecodeBooleanElement24 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
                        i2 |= 32;
                        break;
                    case 6:
                        zDecodeBooleanElement23 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
                        i2 |= 64;
                        break;
                    case 7:
                        zDecodeBooleanElement22 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 7);
                        i2 |= 128;
                        break;
                    case 8:
                        zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 8);
                        i2 |= 256;
                        break;
                    case 9:
                        zDecodeBooleanElement21 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 9);
                        i2 |= 512;
                        break;
                    case 10:
                        zDecodeBooleanElement20 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 10);
                        i2 |= 1024;
                        break;
                    case 11:
                        zDecodeBooleanElement19 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 11);
                        i2 |= 2048;
                        break;
                    case 12:
                        zDecodeBooleanElement18 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 12);
                        i2 |= 4096;
                        break;
                    case 13:
                        zDecodeBooleanElement28 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, i3);
                        i2 |= 8192;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            boolean z13 = zDecodeBooleanElement27;
            z = zDecodeBooleanElement20;
            z2 = z13;
            boolean z14 = zDecodeBooleanElement26;
            z3 = zDecodeBooleanElement21;
            z4 = zDecodeBooleanElement25;
            z5 = zDecodeBooleanElement22;
            z6 = z14;
            boolean z15 = zDecodeBooleanElement24;
            z7 = zDecodeBooleanElement23;
            z8 = z15;
            zDecodeBooleanElement2 = zDecodeBooleanElement18;
            zDecodeBooleanElement3 = zDecodeBooleanElement28;
            z9 = zDecodeBooleanElement16;
            z10 = zDecodeBooleanElement19;
            z11 = zDecodeBooleanElement17;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CustomerCenterConfigData.Support.SupportTickets.CustomerDetails(i, z9, z11, z2, z4, z6, z8, z7, z5, zDecodeBooleanElement, z3, z, z10, zDecodeBooleanElement2, zDecodeBooleanElement3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData.Support.SupportTickets.CustomerDetails value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CustomerCenterConfigData.Support.SupportTickets.CustomerDetails.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
