package com.revenuecat.purchases.paywalls.events;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: PaywallEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/events/PaywallEvent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallEvent$$serializer implements GeneratedSerializer<PaywallEvent> {
    public static final PaywallEvent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallEvent$$serializer paywallEvent$$serializer = new PaywallEvent$$serializer();
        INSTANCE = paywallEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.events.PaywallEvent", paywallEvent$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("creationData", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallEvent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallEvent$CreationData$$serializer.INSTANCE, PaywallEventDataSerializer.INSTANCE, PaywallEvent.$childSerializers[2]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallEvent deserialize(Decoder decoder) {
        int i;
        PaywallEvent.CreationData creationData;
        PaywallEvent.Data data;
        PaywallEventType paywallEventType;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PaywallEvent.$childSerializers;
        PaywallEvent.CreationData creationData2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            PaywallEvent.CreationData creationData3 = (PaywallEvent.CreationData) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, PaywallEvent$CreationData$$serializer.INSTANCE, null);
            PaywallEvent.Data data2 = (PaywallEvent.Data) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, PaywallEventDataSerializer.INSTANCE, null);
            paywallEventType = (PaywallEventType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            creationData = creationData3;
            i = 7;
            data = data2;
        } else {
            boolean z = true;
            int i2 = 0;
            PaywallEvent.Data data3 = null;
            PaywallEventType paywallEventType2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    creationData2 = (PaywallEvent.CreationData) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, PaywallEvent$CreationData$$serializer.INSTANCE, creationData2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    data3 = (PaywallEvent.Data) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, PaywallEventDataSerializer.INSTANCE, data3);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    paywallEventType2 = (PaywallEventType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], paywallEventType2);
                    i2 |= 4;
                }
            }
            i = i2;
            creationData = creationData2;
            data = data3;
            paywallEventType = paywallEventType2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallEvent(i, creationData, data, paywallEventType, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallEvent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallEvent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
