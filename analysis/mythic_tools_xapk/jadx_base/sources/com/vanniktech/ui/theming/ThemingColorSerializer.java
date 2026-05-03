package com.vanniktech.ui.theming;

import com.vanniktech.ui.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: ThemingColor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/vanniktech/ui/theming/ThemingColorSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/vanniktech/ui/theming/ThemingColor;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThemingColorSerializer implements KSerializer<ThemingColor> {
    public static final ThemingColorSerializer INSTANCE = new ThemingColorSerializer();

    private ThemingColorSerializer() {
    }

    static final Unit _get_descriptor_$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        buildClassSerialDescriptor.element("light", Color.INSTANCE.serializer().getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.element("dark", Color.INSTANCE.serializer().getDescriptor(), CollectionsKt.emptyList(), false);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ThemingColor deserialize(Decoder decoder) {
        ThemingColor themingColor;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ThemingColorSerializer themingColorSerializer = INSTANCE;
            themingColor = new ThemingColor(((Color) CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, themingColorSerializer.getDescriptor(), 0, Color.INSTANCE.serializer(), null, 8, null)).m11388unboximpl(), ((Color) CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, themingColorSerializer.getDescriptor(), 1, Color.INSTANCE.serializer(), null, 8, null)).m11388unboximpl(), null);
        } else {
            Color color = null;
            Color color2 = null;
            while (true) {
                ThemingColorSerializer themingColorSerializer2 = INSTANCE;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(themingColorSerializer2.getDescriptor());
                if (iDecodeElementIndex != -1) {
                    if (iDecodeElementIndex == 0) {
                        color = (Color) CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, themingColorSerializer2.getDescriptor(), iDecodeElementIndex, Color.INSTANCE.serializer(), null, 8, null);
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new IllegalStateException(("Unexpected index: " + iDecodeElementIndex).toString());
                        }
                        color2 = (Color) CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, themingColorSerializer2.getDescriptor(), iDecodeElementIndex, Color.INSTANCE.serializer(), null, 8, null);
                    }
                } else {
                    if (color == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    int iM11388unboximpl = color.m11388unboximpl();
                    if (color2 == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    themingColor = new ThemingColor(iM11388unboximpl, color2.m11388unboximpl(), null);
                }
            }
        }
        compositeDecoderBeginStructure.endStructure(descriptor);
        return themingColor;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return SerialDescriptorsKt.buildClassSerialDescriptor("ThemingColor", new SerialDescriptor[0], new Function1() { // from class: com.vanniktech.ui.theming.ThemingColorSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ThemingColorSerializer._get_descriptor_$lambda$0((ClassSerialDescriptorBuilder) obj);
            }
        });
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ThemingColor value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
        ThemingColorSerializer themingColorSerializer = INSTANCE;
        compositeEncoderBeginStructure.encodeSerializableElement(themingColorSerializer.getDescriptor(), 0, Color.INSTANCE.serializer(), Color.m11370boximpl(value.m11407getLightoEAH0UE()));
        compositeEncoderBeginStructure.encodeSerializableElement(themingColorSerializer.getDescriptor(), 1, Color.INSTANCE.serializer(), Color.m11370boximpl(value.m11406getDarkoEAH0UE()));
        compositeEncoderBeginStructure.endStructure(descriptor);
    }
}
