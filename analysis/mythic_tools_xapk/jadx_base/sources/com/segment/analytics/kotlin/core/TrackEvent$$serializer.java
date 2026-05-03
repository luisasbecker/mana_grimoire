package com.segment.analytics.kotlin.core;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
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
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: compiled from: Events.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/segment/analytics/kotlin/core/TrackEvent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/segment/analytics/kotlin/core/TrackEvent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class TrackEvent$$serializer implements GeneratedSerializer<TrackEvent> {
    public static final TrackEvent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TrackEvent$$serializer trackEvent$$serializer = new TrackEvent$$serializer();
        INSTANCE = trackEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("track", trackEvent$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.PROPERTIES_KEY, false);
        pluginGeneratedSerialDescriptor.addElement(NotificationCompat.CATEGORY_EVENT, false);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("messageId", false);
        pluginGeneratedSerialDescriptor.addElement("anonymousId", false);
        pluginGeneratedSerialDescriptor.addElement("integrations", false);
        pluginGeneratedSerialDescriptor.addElement("context", false);
        pluginGeneratedSerialDescriptor.addElement("userId", true);
        pluginGeneratedSerialDescriptor.addElement("_metadata", true);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.TIMESTAMP_KEY, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TrackEvent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{JsonObjectSerializer.INSTANCE, StringSerializer.INSTANCE, EventType.INSTANCE.serializer(), StringSerializer.INSTANCE, StringSerializer.INSTANCE, JsonObjectSerializer.INSTANCE, JsonObjectSerializer.INSTANCE, StringSerializer.INSTANCE, DestinationMetadata$$serializer.INSTANCE, StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TrackEvent deserialize(Decoder decoder) {
        Object objDecodeSerializableElement;
        Object objDecodeSerializableElement2;
        int i;
        Object objDecodeSerializableElement3;
        Object objDecodeSerializableElement4;
        Object objDecodeSerializableElement5;
        String strDecodeStringElement;
        String str;
        String strDecodeStringElement2;
        String str2;
        String strDecodeStringElement3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 9;
        int i3 = 7;
        Object objDecodeSerializableElement6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, JsonObjectSerializer.INSTANCE, null);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            Object objDecodeSerializableElement7 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, EventType.INSTANCE.serializer(), null);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, JsonObjectSerializer.INSTANCE, null);
            objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, JsonObjectSerializer.INSTANCE, null);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 7);
            Object objDecodeSerializableElement8 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, DestinationMetadata$$serializer.INSTANCE, null);
            str2 = strDecodeStringElement5;
            i = 1023;
            strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
            objDecodeSerializableElement2 = objDecodeSerializableElement7;
            objDecodeSerializableElement = objDecodeSerializableElement8;
            str = strDecodeStringElement4;
        } else {
            boolean z = true;
            int i4 = 0;
            objDecodeSerializableElement = null;
            Object objDecodeSerializableElement9 = null;
            Object objDecodeSerializableElement10 = null;
            String strDecodeStringElement6 = null;
            objDecodeSerializableElement2 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 7;
                        break;
                    case 0:
                        objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, JsonObjectSerializer.INSTANCE, objDecodeSerializableElement6);
                        i4 |= 1;
                        i2 = 9;
                        i3 = 7;
                        break;
                    case 1:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i4 |= 2;
                        i2 = 9;
                        i3 = 7;
                        break;
                    case 2:
                        objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, EventType.INSTANCE.serializer(), objDecodeSerializableElement2);
                        i4 |= 4;
                        i2 = 9;
                        i3 = 7;
                        break;
                    case 3:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i4 |= 8;
                        break;
                    case 4:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i4 |= 16;
                        break;
                    case 5:
                        objDecodeSerializableElement10 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, JsonObjectSerializer.INSTANCE, objDecodeSerializableElement10);
                        i4 |= 32;
                        break;
                    case 6:
                        objDecodeSerializableElement9 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, JsonObjectSerializer.INSTANCE, objDecodeSerializableElement9);
                        i4 |= 64;
                        break;
                    case 7:
                        strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i3);
                        i4 |= 128;
                        break;
                    case 8:
                        objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, DestinationMetadata$$serializer.INSTANCE, objDecodeSerializableElement);
                        i4 |= 256;
                        break;
                    case 9:
                        strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i2);
                        i4 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i4;
            objDecodeSerializableElement3 = objDecodeSerializableElement9;
            objDecodeSerializableElement4 = objDecodeSerializableElement10;
            objDecodeSerializableElement5 = objDecodeSerializableElement6;
            strDecodeStringElement = strDecodeStringElement6;
            str = strDecodeStringElement7;
            strDecodeStringElement2 = strDecodeStringElement8;
            str2 = strDecodeStringElement9;
            strDecodeStringElement3 = strDecodeStringElement10;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new TrackEvent(i, (JsonObject) objDecodeSerializableElement5, strDecodeStringElement, (EventType) objDecodeSerializableElement2, str, strDecodeStringElement2, (JsonObject) objDecodeSerializableElement4, (JsonObject) objDecodeSerializableElement3, str2, (DestinationMetadata) objDecodeSerializableElement, strDecodeStringElement3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TrackEvent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TrackEvent.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
