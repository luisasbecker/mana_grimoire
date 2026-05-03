package com.revenuecat.purchases.paywalls.components;

import com.facebook.appevents.internal.Constants;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: TimelineComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/TimelineComponent.Item.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class TimelineComponent$Item$$serializer implements GeneratedSerializer<TimelineComponent.Item> {
    public static final TimelineComponent$Item$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TimelineComponent$Item$$serializer timelineComponent$Item$$serializer = new TimelineComponent$Item$$serializer();
        INSTANCE = timelineComponent$Item$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.TimelineComponent.Item", timelineComponent$Item$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(Constants.GP_IAP_TITLE, false);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("icon", false);
        pluginGeneratedSerialDescriptor.addElement("connector", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TimelineComponent$Item$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{TextComponent$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(TextComponent$$serializer.INSTANCE), IconComponent$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(TimelineComponent$Connector$$serializer.INSTANCE), TimelineComponent.Item.$childSerializers[5]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TimelineComponent.Item deserialize(Decoder decoder) {
        TimelineComponent.Connector connector;
        List list;
        TextComponent textComponent;
        IconComponent iconComponent;
        TextComponent textComponent2;
        Boolean bool;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = TimelineComponent.Item.$childSerializers;
        int i2 = 3;
        TextComponent textComponent3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            TextComponent textComponent4 = (TextComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, TextComponent$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            TextComponent textComponent5 = (TextComponent) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, TextComponent$$serializer.INSTANCE, null);
            IconComponent iconComponent2 = (IconComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, IconComponent$$serializer.INSTANCE, null);
            TimelineComponent.Connector connector2 = (TimelineComponent.Connector) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, TimelineComponent$Connector$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            textComponent2 = textComponent4;
            iconComponent = iconComponent2;
            connector = connector2;
            textComponent = textComponent5;
            i = 63;
            bool = bool2;
        } else {
            boolean z = true;
            int i3 = 0;
            Boolean bool3 = null;
            TextComponent textComponent6 = null;
            IconComponent iconComponent3 = null;
            TimelineComponent.Connector connector3 = null;
            List list2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 3;
                        break;
                    case 0:
                        textComponent3 = (TextComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, TextComponent$$serializer.INSTANCE, textComponent3);
                        i3 |= 1;
                        i2 = 3;
                        break;
                    case 1:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool3);
                        i3 |= 2;
                        break;
                    case 2:
                        textComponent6 = (TextComponent) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, TextComponent$$serializer.INSTANCE, textComponent6);
                        i3 |= 4;
                        break;
                    case 3:
                        iconComponent3 = (IconComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i2, IconComponent$$serializer.INSTANCE, iconComponent3);
                        i3 |= 8;
                        break;
                    case 4:
                        connector3 = (TimelineComponent.Connector) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, TimelineComponent$Connector$$serializer.INSTANCE, connector3);
                        i3 |= 16;
                        break;
                    case 5:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], list2);
                        i3 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            connector = connector3;
            list = list2;
            textComponent = textComponent6;
            iconComponent = iconComponent3;
            textComponent2 = textComponent3;
            bool = bool3;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new TimelineComponent.Item(i, textComponent2, bool, textComponent, iconComponent, connector, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TimelineComponent.Item value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TimelineComponent.Item.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
