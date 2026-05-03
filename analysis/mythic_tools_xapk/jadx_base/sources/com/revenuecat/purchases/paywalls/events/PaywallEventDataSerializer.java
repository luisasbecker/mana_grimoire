package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PresentedOfferingContextSerializer;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.utils.serializers.UUIDSerializer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: PaywallEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEventDataSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "()V", "DARK_MODE_INDEX", "", "DISPLAY_MODE_INDEX", "ERROR_CODE_INDEX", "ERROR_MESSAGE_INDEX", "EXIT_OFFERING_IDENTIFIER_INDEX", "EXIT_OFFER_TYPE_INDEX", "LOCALE_IDENTIFIER_INDEX", "PACKAGE_IDENTIFIER_INDEX", "PAYWALL_IDENTIFIER_INDEX", "PAYWALL_REVISION_INDEX", "PRESENTED_OFFERING_CONTEXT_INDEX", "PRODUCT_IDENTIFIER_INDEX", "SESSION_IDENTIFIER_INDEX", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "nullableExitOfferTypeSerializer", "Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "nullableIntSerializer", "nullableStringSerializer", "", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallEventDataSerializer implements KSerializer<PaywallEvent.Data> {
    private static final int DARK_MODE_INDEX = 6;
    private static final int DISPLAY_MODE_INDEX = 4;
    private static final int ERROR_CODE_INDEX = 11;
    private static final int ERROR_MESSAGE_INDEX = 12;
    private static final int EXIT_OFFERING_IDENTIFIER_INDEX = 8;
    private static final int EXIT_OFFER_TYPE_INDEX = 7;
    private static final int LOCALE_IDENTIFIER_INDEX = 5;
    private static final int PACKAGE_IDENTIFIER_INDEX = 9;
    private static final int PAYWALL_IDENTIFIER_INDEX = 0;
    private static final int PAYWALL_REVISION_INDEX = 2;
    private static final int PRESENTED_OFFERING_CONTEXT_INDEX = 1;
    private static final int PRODUCT_IDENTIFIER_INDEX = 10;
    private static final int SESSION_IDENTIFIER_INDEX = 3;
    public static final PaywallEventDataSerializer INSTANCE = new PaywallEventDataSerializer();
    private static final KSerializer<String> nullableStringSerializer = BuiltinSerializersKt.getNullable(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
    private static final KSerializer<Integer> nullableIntSerializer = BuiltinSerializersKt.getNullable(BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE));
    private static final KSerializer<ExitOfferType> nullableExitOfferTypeSerializer = BuiltinSerializersKt.getNullable(ExitOfferType.INSTANCE.serializer());
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("PaywallEvent.Data", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventDataSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            invoke2(classSerialDescriptorBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "paywallIdentifier", PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "presentedOfferingContext", PresentedOfferingContextSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "paywallRevision", BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "sessionIdentifier", UUIDSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "displayMode", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "localeIdentifier", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "darkMode", BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "exitOfferType", PaywallEventDataSerializer.nullableExitOfferTypeSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "exitOfferingIdentifier", PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "packageIdentifier", PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "productIdentifier", PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "errorCode", PaywallEventDataSerializer.nullableIntSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "errorMessage", PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "offeringIdentifier", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        }
    });

    private PaywallEventDataSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallEvent.Data deserialize(Decoder decoder) {
        PresentedOfferingContext presentedOfferingContext;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!(decoder instanceof JsonDecoder)) {
            throw new SerializationException("PaywallEvent.Data only supports JSON deserialization");
        }
        JsonDecoder jsonDecoder = (JsonDecoder) decoder;
        JsonObject jsonObject = JsonElementKt.getJsonObject(jsonDecoder.decodeJsonElement());
        if (jsonObject.containsKey((Object) "presentedOfferingContext")) {
            Json json = jsonDecoder.getJson();
            PresentedOfferingContextSerializer presentedOfferingContextSerializer = PresentedOfferingContextSerializer.INSTANCE;
            Object obj = jsonObject.get((Object) "presentedOfferingContext");
            Intrinsics.checkNotNull(obj);
            presentedOfferingContext = (PresentedOfferingContext) json.decodeFromJsonElement(presentedOfferingContextSerializer, (JsonElement) obj);
        } else {
            if (!jsonObject.containsKey((Object) "offeringIdentifier")) {
                throw new SerializationException("Missing offering context information");
            }
            Object obj2 = jsonObject.get((Object) "offeringIdentifier");
            Intrinsics.checkNotNull(obj2);
            presentedOfferingContext = new PresentedOfferingContext(JsonElementKt.getJsonPrimitive((JsonElement) obj2).getContent());
        }
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) "paywallIdentifier");
        String str = jsonElement != null ? (String) jsonDecoder.getJson().decodeFromJsonElement(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), jsonElement) : null;
        Json json2 = jsonDecoder.getJson();
        KSerializer<Integer> kSerializerSerializer = BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE);
        Object obj3 = jsonObject.get((Object) "paywallRevision");
        Intrinsics.checkNotNull(obj3);
        int iIntValue = ((Number) json2.decodeFromJsonElement(kSerializerSerializer, (JsonElement) obj3)).intValue();
        Json json3 = jsonDecoder.getJson();
        UUIDSerializer uUIDSerializer = UUIDSerializer.INSTANCE;
        Object obj4 = jsonObject.get((Object) "sessionIdentifier");
        Intrinsics.checkNotNull(obj4);
        UUID uuid = (UUID) json3.decodeFromJsonElement(uUIDSerializer, (JsonElement) obj4);
        Json json4 = jsonDecoder.getJson();
        KSerializer<String> kSerializerSerializer2 = BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE);
        Object obj5 = jsonObject.get((Object) "displayMode");
        Intrinsics.checkNotNull(obj5);
        String str2 = (String) json4.decodeFromJsonElement(kSerializerSerializer2, (JsonElement) obj5);
        Json json5 = jsonDecoder.getJson();
        KSerializer<String> kSerializerSerializer3 = BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE);
        Object obj6 = jsonObject.get((Object) "localeIdentifier");
        Intrinsics.checkNotNull(obj6);
        String str3 = (String) json5.decodeFromJsonElement(kSerializerSerializer3, (JsonElement) obj6);
        Json json6 = jsonDecoder.getJson();
        KSerializer<Boolean> kSerializerSerializer4 = BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE);
        Object obj7 = jsonObject.get((Object) "darkMode");
        Intrinsics.checkNotNull(obj7);
        boolean zBooleanValue = ((Boolean) json6.decodeFromJsonElement(kSerializerSerializer4, (JsonElement) obj7)).booleanValue();
        JsonElement jsonElement2 = (JsonElement) jsonObject.get((Object) "exitOfferType");
        ExitOfferType exitOfferType = jsonElement2 != null ? (ExitOfferType) jsonDecoder.getJson().decodeFromJsonElement(ExitOfferType.INSTANCE.serializer(), jsonElement2) : null;
        JsonElement jsonElement3 = (JsonElement) jsonObject.get((Object) "exitOfferingIdentifier");
        String str4 = jsonElement3 != null ? (String) jsonDecoder.getJson().decodeFromJsonElement(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), jsonElement3) : null;
        JsonElement jsonElement4 = (JsonElement) jsonObject.get((Object) "packageIdentifier");
        String str5 = jsonElement4 != null ? (String) jsonDecoder.getJson().decodeFromJsonElement(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), jsonElement4) : null;
        JsonElement jsonElement5 = (JsonElement) jsonObject.get((Object) "productIdentifier");
        String str6 = jsonElement5 != null ? (String) jsonDecoder.getJson().decodeFromJsonElement(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), jsonElement5) : null;
        JsonElement jsonElement6 = (JsonElement) jsonObject.get((Object) "errorCode");
        Integer numValueOf = jsonElement6 != null ? Integer.valueOf(((Number) jsonDecoder.getJson().decodeFromJsonElement(BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE), jsonElement6)).intValue()) : null;
        JsonElement jsonElement7 = (JsonElement) jsonObject.get((Object) "errorMessage");
        return new PaywallEvent.Data(str, presentedOfferingContext, iIntValue, uuid, str2, str3, zBooleanValue, exitOfferType, str4, str5, str6, numValueOf, jsonElement7 != null ? (String) jsonDecoder.getJson().decodeFromJsonElement(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), jsonElement7) : null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallEvent.Data value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        String paywallIdentifier = value.getPaywallIdentifier();
        if (paywallIdentifier != null) {
            compositeEncoderBeginStructure.encodeStringElement(INSTANCE.getDescriptor(), 0, paywallIdentifier);
        }
        PaywallEventDataSerializer paywallEventDataSerializer = INSTANCE;
        compositeEncoderBeginStructure.encodeSerializableElement(paywallEventDataSerializer.getDescriptor(), 1, PresentedOfferingContextSerializer.INSTANCE, value.getPresentedOfferingContext());
        compositeEncoderBeginStructure.encodeIntElement(paywallEventDataSerializer.getDescriptor(), 2, value.getPaywallRevision());
        compositeEncoderBeginStructure.encodeSerializableElement(paywallEventDataSerializer.getDescriptor(), 3, UUIDSerializer.INSTANCE, value.getSessionIdentifier());
        compositeEncoderBeginStructure.encodeStringElement(paywallEventDataSerializer.getDescriptor(), 4, value.getDisplayMode());
        compositeEncoderBeginStructure.encodeStringElement(paywallEventDataSerializer.getDescriptor(), 5, value.getLocaleIdentifier());
        compositeEncoderBeginStructure.encodeBooleanElement(paywallEventDataSerializer.getDescriptor(), 6, value.getDarkMode());
        ExitOfferType exitOfferType = value.getExitOfferType();
        if (exitOfferType != null) {
            compositeEncoderBeginStructure.encodeSerializableElement(paywallEventDataSerializer.getDescriptor(), 7, ExitOfferType.INSTANCE.serializer(), exitOfferType);
        }
        String exitOfferingIdentifier = value.getExitOfferingIdentifier();
        if (exitOfferingIdentifier != null) {
            compositeEncoderBeginStructure.encodeStringElement(paywallEventDataSerializer.getDescriptor(), 8, exitOfferingIdentifier);
        }
        String packageIdentifier = value.getPackageIdentifier();
        if (packageIdentifier != null) {
            compositeEncoderBeginStructure.encodeStringElement(paywallEventDataSerializer.getDescriptor(), 9, packageIdentifier);
        }
        String productIdentifier = value.getProductIdentifier();
        if (productIdentifier != null) {
            compositeEncoderBeginStructure.encodeStringElement(paywallEventDataSerializer.getDescriptor(), 10, productIdentifier);
        }
        Integer errorCode = value.getErrorCode();
        if (errorCode != null) {
            compositeEncoderBeginStructure.encodeIntElement(paywallEventDataSerializer.getDescriptor(), 11, errorCode.intValue());
        }
        String errorMessage = value.getErrorMessage();
        if (errorMessage != null) {
            compositeEncoderBeginStructure.encodeStringElement(paywallEventDataSerializer.getDescriptor(), 12, errorMessage);
        }
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }
}
