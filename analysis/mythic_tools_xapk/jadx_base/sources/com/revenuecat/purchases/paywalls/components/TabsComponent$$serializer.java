package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
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

/* JADX INFO: compiled from: TabsComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/TabsComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class TabsComponent$$serializer implements GeneratedSerializer<TabsComponent> {
    public static final TabsComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TabsComponent$$serializer tabsComponent$$serializer = new TabsComponent$$serializer();
        INSTANCE = tabsComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("tabs", tabsComponent$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("background", true);
        pluginGeneratedSerialDescriptor.addElement("shape", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement("control", false);
        pluginGeneratedSerialDescriptor.addElement("tabs", false);
        pluginGeneratedSerialDescriptor.addElement("default_tab_id", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TabsComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = TabsComponent.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), Size$$serializer.INSTANCE, Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), kSerializerArr[9], kSerializerArr[10], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), kSerializerArr[12]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TabsComponent deserialize(Decoder decoder) {
        int i;
        List list;
        Size size;
        TabsComponent.TabControl tabControl;
        Shadow shadow;
        Border border;
        Background background;
        List list2;
        Shape shape;
        ColorScheme colorScheme;
        String str;
        Padding padding;
        Padding padding2;
        Boolean bool;
        Boolean bool2;
        List list3;
        int i2;
        List list4;
        Padding padding3;
        int i3;
        List list5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = TabsComponent.$childSerializers;
        Boolean bool3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, Size$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, Padding$$serializer.INSTANCE, null);
            Padding padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Padding$$serializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, Shadow$$serializer.INSTANCE, null);
            TabsComponent.TabControl tabControl2 = (TabsComponent.TabControl) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, kSerializerArr[9], null);
            List list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, kSerializerArr[10], null);
            i = 8191;
            size = size2;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            bool = bool4;
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 12, kSerializerArr[12], null);
            border = border2;
            shape = shape2;
            background = background2;
            padding = padding5;
            shadow = shadow2;
            colorScheme = colorScheme2;
            padding2 = padding4;
            list2 = list6;
            tabControl = tabControl2;
        } else {
            int i4 = 12;
            int i5 = 0;
            Padding padding6 = null;
            Size size3 = null;
            TabsComponent.TabControl tabControl3 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            Background background3 = null;
            List list7 = null;
            Shape shape3 = null;
            ColorScheme colorScheme3 = null;
            int i6 = 10;
            int i7 = 9;
            boolean z = true;
            List list8 = null;
            String str2 = null;
            Padding padding7 = null;
            while (z) {
                int i8 = i4;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        padding3 = padding6;
                        i3 = i5;
                        list5 = list8;
                        z = false;
                        list8 = list5;
                        padding6 = padding3;
                        i7 = 9;
                        i6 = 10;
                        i5 = i3;
                        i4 = 12;
                        break;
                    case 0:
                        int i9 = i5;
                        list5 = list8;
                        padding3 = padding6;
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool3);
                        i3 = i9 | 1;
                        list8 = list5;
                        padding6 = padding3;
                        i7 = 9;
                        i6 = 10;
                        i5 = i3;
                        i4 = 12;
                        break;
                    case 1:
                        bool2 = bool3;
                        int i10 = i5;
                        list3 = list8;
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, Size$$serializer.INSTANCE, size3);
                        i2 = i10 | 2;
                        list8 = list3;
                        i4 = 12;
                        i7 = 9;
                        i6 = 10;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 2:
                        bool2 = bool3;
                        int i11 = i5;
                        list3 = list8;
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, Padding$$serializer.INSTANCE, padding6);
                        i2 = i11 | 4;
                        list8 = list3;
                        i4 = 12;
                        i7 = 9;
                        i6 = 10;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 3:
                        bool2 = bool3;
                        int i12 = i5;
                        list3 = list8;
                        padding7 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Padding$$serializer.INSTANCE, padding7);
                        i2 = i12 | 8;
                        list8 = list3;
                        i4 = 12;
                        i7 = 9;
                        i6 = 10;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 4:
                        bool2 = bool3;
                        int i13 = i5;
                        list3 = list8;
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i2 = i13 | 16;
                        list8 = list3;
                        i4 = 12;
                        i7 = 9;
                        i6 = 10;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 5:
                        bool2 = bool3;
                        int i14 = i5;
                        list3 = list8;
                        background3 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BackgroundDeserializer.INSTANCE, background3);
                        i2 = i14 | 32;
                        list8 = list3;
                        i4 = 12;
                        i7 = 9;
                        i6 = 10;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 6:
                        bool2 = bool3;
                        int i15 = i5;
                        list3 = list8;
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, ShapeDeserializer.INSTANCE, shape3);
                        i2 = i15 | 64;
                        list8 = list3;
                        i4 = 12;
                        i7 = 9;
                        i6 = 10;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 7:
                        bool2 = bool3;
                        int i16 = i5;
                        list3 = list8;
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Border$$serializer.INSTANCE, border3);
                        i2 = i16 | 128;
                        list8 = list3;
                        i4 = 12;
                        i7 = 9;
                        i6 = 10;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 8:
                        bool2 = bool3;
                        int i17 = i5;
                        list3 = list8;
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, Shadow$$serializer.INSTANCE, shadow3);
                        i2 = i17 | 256;
                        list8 = list3;
                        i4 = 12;
                        i7 = 9;
                        i6 = 10;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 9:
                        bool2 = bool3;
                        int i18 = i5;
                        tabControl3 = (TabsComponent.TabControl) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i7, kSerializerArr[i7], tabControl3);
                        i2 = i18 | 512;
                        list8 = list8;
                        i4 = 12;
                        i6 = 10;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 10:
                        bool2 = bool3;
                        int i19 = i5;
                        list4 = list8;
                        list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i6, kSerializerArr[i6], list7);
                        i2 = i19 | 1024;
                        list8 = list4;
                        i4 = 12;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 11:
                        bool2 = bool3;
                        int i20 = i5;
                        list4 = list8;
                        str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str2);
                        i2 = i20 | 2048;
                        list8 = list4;
                        i4 = 12;
                        i5 = i2;
                        bool3 = bool2;
                        break;
                    case 12:
                        bool2 = bool3;
                        list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i8, kSerializerArr[i8], list8);
                        i5 |= 4096;
                        i4 = i8;
                        bool3 = bool2;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i5;
            list = list8;
            size = size3;
            tabControl = tabControl3;
            shadow = shadow3;
            border = border3;
            background = background3;
            list2 = list7;
            shape = shape3;
            colorScheme = colorScheme3;
            str = str2;
            padding = padding7;
            padding2 = padding6;
            bool = bool3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new TabsComponent(i, bool, size, padding2, padding, colorScheme, background, shape, border, shadow, tabControl, list2, str, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TabsComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TabsComponent.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
