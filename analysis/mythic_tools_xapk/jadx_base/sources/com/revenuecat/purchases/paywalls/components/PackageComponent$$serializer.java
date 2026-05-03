package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.paywalls.components.common.ResilientPromoOfferConfigSerializer;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PackageComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/PackageComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PackageComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PackageComponent$$serializer implements GeneratedSerializer<PackageComponent> {
    public static final PackageComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PackageComponent$$serializer packageComponent$$serializer = new PackageComponent$$serializer();
        INSTANCE = packageComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("package", packageComponent$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("package_id", false);
        pluginGeneratedSerialDescriptor.addElement("is_selected_by_default", false);
        pluginGeneratedSerialDescriptor.addElement("stack", false);
        pluginGeneratedSerialDescriptor.addElement("play_store_offer", true);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PackageComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, StackComponent$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ResilientPromoOfferConfigSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), PackageComponent.$childSerializers[5]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PackageComponent deserialize(Decoder decoder) {
        Boolean bool;
        List list;
        StackComponent stackComponent;
        PromoOfferConfig promoOfferConfig;
        boolean z;
        String str;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PackageComponent.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 1);
            StackComponent stackComponent2 = (StackComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, StackComponent$$serializer.INSTANCE, null);
            PromoOfferConfig promoOfferConfig2 = (PromoOfferConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ResilientPromoOfferConfigSerializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            str = strDecodeStringElement;
            promoOfferConfig = promoOfferConfig2;
            bool = bool2;
            stackComponent = stackComponent2;
            i = 63;
            z = zDecodeBooleanElement;
        } else {
            boolean z2 = true;
            int i2 = 0;
            String strDecodeStringElement2 = null;
            StackComponent stackComponent3 = null;
            PromoOfferConfig promoOfferConfig3 = null;
            Boolean bool3 = null;
            List list2 = null;
            boolean zDecodeBooleanElement2 = false;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        continue;
                    case 0:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i2 |= 1;
                        continue;
                    case 1:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        stackComponent3 = (StackComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, StackComponent$$serializer.INSTANCE, stackComponent3);
                        i2 |= 4;
                        break;
                    case 3:
                        promoOfferConfig3 = (PromoOfferConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ResilientPromoOfferConfigSerializer.INSTANCE, promoOfferConfig3);
                        i2 |= 8;
                        break;
                    case 4:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool3);
                        i2 |= 16;
                        break;
                    case 5:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], list2);
                        i2 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            bool = bool3;
            list = list2;
            stackComponent = stackComponent3;
            promoOfferConfig = promoOfferConfig3;
            z = zDecodeBooleanElement2;
            str = strDecodeStringElement2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PackageComponent(i, str, z, stackComponent, promoOfferConfig, bool, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PackageComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PackageComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
