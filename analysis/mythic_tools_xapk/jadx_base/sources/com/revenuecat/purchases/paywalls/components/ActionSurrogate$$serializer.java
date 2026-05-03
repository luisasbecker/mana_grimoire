package com.revenuecat.purchases.paywalls.components;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
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

/* JADX INFO: compiled from: ButtonComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/ActionSurrogate.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ActionSurrogate;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class ActionSurrogate$$serializer implements GeneratedSerializer<ActionSurrogate> {
    public static final ActionSurrogate$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ActionSurrogate$$serializer actionSurrogate$$serializer = new ActionSurrogate$$serializer();
        INSTANCE = actionSurrogate$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.ActionSurrogate", actionSurrogate$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.DESTINATION, true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("sheet", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ActionSurrogate$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ActionTypeSurrogateDeserializer.INSTANCE, BuiltinSerializersKt.getNullable(DestinationSurrogateDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(UrlSurrogate$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ButtonComponent$Destination$Sheet$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ActionSurrogate deserialize(Decoder decoder) {
        int i;
        ActionTypeSurrogate actionTypeSurrogate;
        DestinationSurrogate destinationSurrogate;
        UrlSurrogate urlSurrogate;
        ButtonComponent.Destination.Sheet sheet;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        ActionTypeSurrogate actionTypeSurrogate2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ActionTypeSurrogate actionTypeSurrogate3 = (ActionTypeSurrogate) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ActionTypeSurrogateDeserializer.INSTANCE, null);
            DestinationSurrogate destinationSurrogate2 = (DestinationSurrogate) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, DestinationSurrogateDeserializer.INSTANCE, null);
            UrlSurrogate urlSurrogate2 = (UrlSurrogate) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, UrlSurrogate$$serializer.INSTANCE, null);
            actionTypeSurrogate = actionTypeSurrogate3;
            sheet = (ButtonComponent.Destination.Sheet) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, null);
            urlSurrogate = urlSurrogate2;
            destinationSurrogate = destinationSurrogate2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            DestinationSurrogate destinationSurrogate3 = null;
            UrlSurrogate urlSurrogate3 = null;
            ButtonComponent.Destination.Sheet sheet2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    actionTypeSurrogate2 = (ActionTypeSurrogate) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ActionTypeSurrogateDeserializer.INSTANCE, actionTypeSurrogate2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    destinationSurrogate3 = (DestinationSurrogate) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, DestinationSurrogateDeserializer.INSTANCE, destinationSurrogate3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    urlSurrogate3 = (UrlSurrogate) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, UrlSurrogate$$serializer.INSTANCE, urlSurrogate3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    sheet2 = (ButtonComponent.Destination.Sheet) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, sheet2);
                    i2 |= 8;
                }
            }
            i = i2;
            actionTypeSurrogate = actionTypeSurrogate2;
            destinationSurrogate = destinationSurrogate3;
            urlSurrogate = urlSurrogate3;
            sheet = sheet2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new ActionSurrogate(i, actionTypeSurrogate, destinationSurrogate, urlSurrogate, sheet, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ActionSurrogate value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        ActionSurrogate.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
