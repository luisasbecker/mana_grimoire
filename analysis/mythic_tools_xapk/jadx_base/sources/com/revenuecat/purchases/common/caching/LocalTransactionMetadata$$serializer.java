package com.revenuecat.purchases.common.caching;

import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.ReceiptInfo$$serializer;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData$$serializer;
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

/* JADX INFO: compiled from: LocalTransactionMetadata.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/caching/LocalTransactionMetadata.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadata;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class LocalTransactionMetadata$$serializer implements GeneratedSerializer<LocalTransactionMetadata> {
    public static final LocalTransactionMetadata$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        LocalTransactionMetadata$$serializer localTransactionMetadata$$serializer = new LocalTransactionMetadata$$serializer();
        INSTANCE = localTransactionMetadata$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.caching.LocalTransactionMetadata", localTransactionMetadata$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("token", false);
        pluginGeneratedSerialDescriptor.addElement("receipt_info", false);
        pluginGeneratedSerialDescriptor.addElement("paywall_data", true);
        pluginGeneratedSerialDescriptor.addElement("purchases_are_completed_by", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LocalTransactionMetadata$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, ReceiptInfo$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallPostReceiptData$$serializer.INSTANCE), LocalTransactionMetadata.$childSerializers[3]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalTransactionMetadata deserialize(Decoder decoder) {
        int i;
        String str;
        ReceiptInfo receiptInfo;
        PaywallPostReceiptData paywallPostReceiptData;
        PurchasesAreCompletedBy purchasesAreCompletedBy;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = LocalTransactionMetadata.$childSerializers;
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            ReceiptInfo receiptInfo2 = (ReceiptInfo) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, ReceiptInfo$$serializer.INSTANCE, null);
            PaywallPostReceiptData paywallPostReceiptData2 = (PaywallPostReceiptData) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallPostReceiptData$$serializer.INSTANCE, null);
            purchasesAreCompletedBy = (PurchasesAreCompletedBy) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            str = strDecodeStringElement2;
            paywallPostReceiptData = paywallPostReceiptData2;
            i = 15;
            receiptInfo = receiptInfo2;
        } else {
            boolean z = true;
            int i2 = 0;
            ReceiptInfo receiptInfo3 = null;
            PaywallPostReceiptData paywallPostReceiptData3 = null;
            PurchasesAreCompletedBy purchasesAreCompletedBy2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    receiptInfo3 = (ReceiptInfo) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, ReceiptInfo$$serializer.INSTANCE, receiptInfo3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    paywallPostReceiptData3 = (PaywallPostReceiptData) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallPostReceiptData$$serializer.INSTANCE, paywallPostReceiptData3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    purchasesAreCompletedBy2 = (PurchasesAreCompletedBy) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], purchasesAreCompletedBy2);
                    i2 |= 8;
                }
            }
            i = i2;
            str = strDecodeStringElement;
            receiptInfo = receiptInfo3;
            paywallPostReceiptData = paywallPostReceiptData3;
            purchasesAreCompletedBy = purchasesAreCompletedBy2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new LocalTransactionMetadata(i, str, receiptInfo, paywallPostReceiptData, purchasesAreCompletedBy, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalTransactionMetadata value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        LocalTransactionMetadata.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
