package com.revenuecat.purchases.common.networking;

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

/* JADX INFO: compiled from: WebBillingProductsResponse.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/networking/WebBillingPurchaseOption.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/networking/WebBillingPurchaseOption;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class WebBillingPurchaseOption$$serializer implements GeneratedSerializer<WebBillingPurchaseOption> {
    public static final WebBillingPurchaseOption$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WebBillingPurchaseOption$$serializer webBillingPurchaseOption$$serializer = new WebBillingPurchaseOption$$serializer();
        INSTANCE = webBillingPurchaseOption$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.networking.WebBillingPurchaseOption", webBillingPurchaseOption$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("base_price", true);
        pluginGeneratedSerialDescriptor.addElement("base", true);
        pluginGeneratedSerialDescriptor.addElement("trial", true);
        pluginGeneratedSerialDescriptor.addElement("intro_price", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WebBillingPurchaseOption$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(WebBillingPrice$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(WebBillingPhase$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(WebBillingPhase$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(WebBillingPhase$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WebBillingPurchaseOption deserialize(Decoder decoder) {
        int i;
        WebBillingPrice webBillingPrice;
        WebBillingPhase webBillingPhase;
        WebBillingPhase webBillingPhase2;
        WebBillingPhase webBillingPhase3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        WebBillingPrice webBillingPrice2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            WebBillingPrice webBillingPrice3 = (WebBillingPrice) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, null);
            WebBillingPhase webBillingPhase4 = (WebBillingPhase) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, WebBillingPhase$$serializer.INSTANCE, null);
            WebBillingPhase webBillingPhase5 = (WebBillingPhase) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, WebBillingPhase$$serializer.INSTANCE, null);
            webBillingPrice = webBillingPrice3;
            webBillingPhase3 = (WebBillingPhase) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, WebBillingPhase$$serializer.INSTANCE, null);
            webBillingPhase2 = webBillingPhase5;
            webBillingPhase = webBillingPhase4;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            WebBillingPhase webBillingPhase6 = null;
            WebBillingPhase webBillingPhase7 = null;
            WebBillingPhase webBillingPhase8 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    webBillingPrice2 = (WebBillingPrice) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, webBillingPrice2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    webBillingPhase6 = (WebBillingPhase) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, WebBillingPhase$$serializer.INSTANCE, webBillingPhase6);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    webBillingPhase7 = (WebBillingPhase) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, WebBillingPhase$$serializer.INSTANCE, webBillingPhase7);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    webBillingPhase8 = (WebBillingPhase) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, WebBillingPhase$$serializer.INSTANCE, webBillingPhase8);
                    i2 |= 8;
                }
            }
            i = i2;
            webBillingPrice = webBillingPrice2;
            webBillingPhase = webBillingPhase6;
            webBillingPhase2 = webBillingPhase7;
            webBillingPhase3 = webBillingPhase8;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new WebBillingPurchaseOption(i, webBillingPrice, webBillingPhase, webBillingPhase2, webBillingPhase3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WebBillingPurchaseOption value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        WebBillingPurchaseOption.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
