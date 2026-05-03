package com.revenuecat.purchases.paywalls.components;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
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

/* JADX INFO: compiled from: ButtonComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/UrlSurrogate.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/UrlSurrogate;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class UrlSurrogate$$serializer implements GeneratedSerializer<UrlSurrogate> {
    public static final UrlSurrogate$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        UrlSurrogate$$serializer urlSurrogate$$serializer = new UrlSurrogate$$serializer();
        INSTANCE = urlSurrogate$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.UrlSurrogate", urlSurrogate$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("url_lid", false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.METHOD, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UrlSurrogate$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LocalizationKey$$serializer.INSTANCE, UrlMethodDeserializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public UrlSurrogate deserialize(Decoder decoder) {
        String strM10434unboximpl;
        ButtonComponent.UrlMethod urlMethod;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, null);
            strM10434unboximpl = localizationKey != null ? localizationKey.m10434unboximpl() : null;
            urlMethod = (ButtonComponent.UrlMethod) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, UrlMethodDeserializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            strM10434unboximpl = null;
            ButtonComponent.UrlMethod urlMethod2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, strM10434unboximpl != null ? LocalizationKey.m10428boximpl(strM10434unboximpl) : null);
                    strM10434unboximpl = localizationKey2 != null ? localizationKey2.m10434unboximpl() : null;
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    urlMethod2 = (ButtonComponent.UrlMethod) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, UrlMethodDeserializer.INSTANCE, urlMethod2);
                    i2 |= 2;
                }
            }
            urlMethod = urlMethod2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new UrlSurrogate(i, strM10434unboximpl, urlMethod, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UrlSurrogate value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        UrlSurrogate.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
