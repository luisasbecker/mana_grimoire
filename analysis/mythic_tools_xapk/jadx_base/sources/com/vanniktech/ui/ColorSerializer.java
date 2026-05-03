package com.vanniktech.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/vanniktech/ui/ColorSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/vanniktech/ui/Color;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-3BSO9UY", "(Lkotlinx/serialization/encoding/Decoder;)I", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-xAbW3D8", "(Lkotlinx/serialization/encoding/Encoder;I)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorSerializer implements KSerializer<Color> {
    public static final ColorSerializer INSTANCE = new ColorSerializer();

    private ColorSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return Color.m11370boximpl(m11396deserialize3BSO9UY(decoder));
    }

    /* JADX INFO: renamed from: deserialize-3BSO9UY, reason: not valid java name */
    public int m11396deserialize3BSO9UY(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return ColorKt.getColor(decoder.decodeInt());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return SerialDescriptorsKt.PrimitiveSerialDescriptor("Color", PrimitiveKind.STRING.INSTANCE);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m11397serializexAbW3D8(encoder, ((Color) obj).m11388unboximpl());
    }

    /* JADX INFO: renamed from: serialize-xAbW3D8, reason: not valid java name */
    public void m11397serializexAbW3D8(Encoder encoder, int value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInt(value);
    }
}
