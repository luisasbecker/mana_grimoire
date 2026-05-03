package com.revenuecat.purchases.paywalls.events;

import androidx.core.app.NotificationCompat;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PaywallStoredEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/events/PaywallStoredEvent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallStoredEvent$$serializer implements GeneratedSerializer<PaywallStoredEvent> {
    public static final PaywallStoredEvent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallStoredEvent$$serializer paywallStoredEvent$$serializer = new PaywallStoredEvent$$serializer();
        INSTANCE = paywallStoredEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.events.PaywallStoredEvent", paywallStoredEvent$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement(NotificationCompat.CATEGORY_EVENT, false);
        pluginGeneratedSerialDescriptor.addElement("userID", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallStoredEvent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallEvent$$serializer.INSTANCE, StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallStoredEvent deserialize(Decoder decoder) {
        PaywallEvent paywallEvent;
        String strDecodeStringElement;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            paywallEvent = (PaywallEvent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, PaywallEvent$$serializer.INSTANCE, null);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            paywallEvent = null;
            String strDecodeStringElement2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    paywallEvent = (PaywallEvent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, PaywallEvent$$serializer.INSTANCE, paywallEvent);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                    i2 |= 2;
                }
            }
            strDecodeStringElement = strDecodeStringElement2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallStoredEvent(i, paywallEvent, strDecodeStringElement, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallStoredEvent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallStoredEvent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
