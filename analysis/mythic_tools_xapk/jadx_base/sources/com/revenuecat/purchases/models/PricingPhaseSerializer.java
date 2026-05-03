package com.revenuecat.purchases.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: PricingPhase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/models/PricingPhaseSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/models/PricingPhase;", "()V", "BILLING_CYCLE_COUNT_INDEX", "", "BILLING_PERIOD_INDEX", "PRICE_INDEX", "RECURRENCE_MODE_INDEX", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "nullableIntSerializer", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PricingPhaseSerializer implements KSerializer<PricingPhase> {
    private static final int BILLING_CYCLE_COUNT_INDEX = 2;
    private static final int BILLING_PERIOD_INDEX = 0;
    private static final int PRICE_INDEX = 3;
    private static final int RECURRENCE_MODE_INDEX = 1;
    public static final PricingPhaseSerializer INSTANCE = new PricingPhaseSerializer();
    private static final KSerializer<Integer> nullableIntSerializer = BuiltinSerializersKt.getNullable(BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE));
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("PricingPhase", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.models.PricingPhaseSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            invoke2(classSerialDescriptorBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "billing_period", PeriodSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "recurrence_mode", RecurrenceModeSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "billing_cycle_count", PricingPhaseSerializer.nullableIntSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, FirebaseAnalytics.Param.PRICE, PriceSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
        }
    });

    private PricingPhaseSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PricingPhase deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        Period period = null;
        RecurrenceMode recurrenceMode = null;
        Integer num = null;
        Price price = null;
        while (true) {
            PricingPhaseSerializer pricingPhaseSerializer = INSTANCE;
            int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pricingPhaseSerializer.getDescriptor());
            if (iDecodeElementIndex == -1) {
                Intrinsics.checkNotNull(period);
                Intrinsics.checkNotNull(recurrenceMode);
                Intrinsics.checkNotNull(price);
                PricingPhase pricingPhase = new PricingPhase(period, recurrenceMode, num, price);
                compositeDecoderBeginStructure.endStructure(descriptor2);
                return pricingPhase;
            }
            if (iDecodeElementIndex == 0) {
                period = (Period) CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, pricingPhaseSerializer.getDescriptor(), 0, PeriodSerializer.INSTANCE, null, 8, null);
            } else if (iDecodeElementIndex == 1) {
                recurrenceMode = (RecurrenceMode) CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, pricingPhaseSerializer.getDescriptor(), 1, RecurrenceModeSerializer.INSTANCE, null, 8, null);
            } else if (iDecodeElementIndex == 2) {
                num = (Integer) CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, pricingPhaseSerializer.getDescriptor(), 2, nullableIntSerializer, null, 8, null);
            } else {
                if (iDecodeElementIndex != 3) {
                    throw new IllegalStateException(("Unexpected index: " + iDecodeElementIndex).toString());
                }
                price = (Price) CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, pricingPhaseSerializer.getDescriptor(), 3, PriceSerializer.INSTANCE, null, 8, null);
            }
        }
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PricingPhase value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PricingPhaseSerializer pricingPhaseSerializer = INSTANCE;
        compositeEncoderBeginStructure.encodeSerializableElement(pricingPhaseSerializer.getDescriptor(), 0, PeriodSerializer.INSTANCE, value.getBillingPeriod());
        compositeEncoderBeginStructure.encodeSerializableElement(pricingPhaseSerializer.getDescriptor(), 1, RecurrenceModeSerializer.INSTANCE, value.getRecurrenceMode());
        compositeEncoderBeginStructure.encodeSerializableElement(pricingPhaseSerializer.getDescriptor(), 2, nullableIntSerializer, value.getBillingCycleCount());
        compositeEncoderBeginStructure.encodeSerializableElement(pricingPhaseSerializer.getDescriptor(), 3, PriceSerializer.INSTANCE, value.getPrice());
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }
}
