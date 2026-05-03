package com.revenuecat.purchases;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.UiConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: UiConfig.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/CustomVariableDefinitionSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/UiConfig$CustomVariableDefinition;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomVariableDefinitionSerializer implements KSerializer<UiConfig.CustomVariableDefinition> {
    public static final CustomVariableDefinitionSerializer INSTANCE = new CustomVariableDefinitionSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("CustomVariableDefinition", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.CustomVariableDefinitionSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            invoke2(classSerialDescriptorBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            buildClassSerialDescriptor.element("type", StringSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
            buildClassSerialDescriptor.element("default_value", StringSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        }
    });

    private CustomVariableDefinitionSerializer() {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    @Override // kotlinx.serialization.DeserializationStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UiConfig.CustomVariableDefinition deserialize(Decoder decoder) {
        String content;
        Object doubleOrNull;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!(decoder instanceof JsonDecoder)) {
            throw new IllegalArgumentException("CustomVariableDefinition can only be deserialized from JSON".toString());
        }
        JsonObject jsonObject = JsonElementKt.getJsonObject(((JsonDecoder) decoder).decodeJsonElement());
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) "type");
        if (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null || (content = jsonPrimitive.getContent()) == null) {
            content = TypedValues.Custom.S_STRING;
        }
        Object obj = jsonObject.get((Object) "default_value");
        JsonPrimitive jsonPrimitive2 = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive2 == null) {
            return new UiConfig.CustomVariableDefinition(content, "");
        }
        int iHashCode = content.hashCode();
        if (iHashCode != -1034364087) {
            if (iHashCode != -891985903) {
                if (iHashCode == 64711720 && content.equals(TypedValues.Custom.S_BOOLEAN)) {
                    doubleOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive2);
                    if (doubleOrNull == null && (doubleOrNull = StringsKt.toBooleanStrictOrNull(jsonPrimitive2.getContent())) == null) {
                        doubleOrNull = jsonPrimitive2.getContent();
                    }
                } else {
                    doubleOrNull = jsonPrimitive2.getContent();
                }
            } else if (content.equals(TypedValues.Custom.S_STRING)) {
                doubleOrNull = jsonPrimitive2.getContent();
            }
        } else if (content.equals("number")) {
            doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive2);
            if (doubleOrNull == null && (doubleOrNull = StringsKt.toDoubleOrNull(jsonPrimitive2.getContent())) == null) {
                doubleOrNull = jsonPrimitive2.getContent();
            }
        }
        return new UiConfig.CustomVariableDefinition(content, doubleOrNull);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UiConfig.CustomVariableDefinition value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException("Serialization of CustomVariableDefinition is not implemented as it is not needed.".toString());
    }
}
