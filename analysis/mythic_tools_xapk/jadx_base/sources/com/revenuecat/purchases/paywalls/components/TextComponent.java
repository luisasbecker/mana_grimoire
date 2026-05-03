package com.revenuecat.purchases.paywalls.components;

import androidx.core.provider.FontsContractCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.FontAlias$$serializer;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignmentDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: TextComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@SerialName("text")
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 K2\u00020\u0001:\u0002JKB³\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0014\u0010\u0018\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0018\u00010\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eB\u0097\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019¢\u0006\u0002\u0010\u001fJ&\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HHÁ\u0001¢\u0006\u0002\bIR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u0012\u0004\b%\u0010!\u001a\u0004\b&\u0010'R\u001c\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010+R\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010.R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00102\u0012\u0004\b/\u0010!\u001a\u0004\b0\u00101R\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010!\u001a\u0004\b4\u00105R\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b:\u00107R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R$\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010(\u0012\u0004\b=\u0010!\u001a\u0004\b>\u0010'R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010A\u001a\u0004\b?\u0010@\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006L"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "text", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "color", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "visible", "", "backgroundColor", "fontName", "Lcom/revenuecat/purchases/FontAlias;", "fontWeight", "Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;", "fontWeightInt", "fontSize", "horizontalAlignment", "Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", "overrides", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;Ljava/lang/Integer;ILcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;Ljava/lang/Integer;ILcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor$annotations", "()V", "getBackgroundColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getColor", "getFontName-ARcRonI$annotations", "getFontName-ARcRonI", "()Ljava/lang/String;", "Ljava/lang/String;", "getFontSize$annotations", "getFontSize", "()I", "getFontWeight$annotations", "getFontWeight", "()Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;", "getFontWeightInt$annotations", "getFontWeightInt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHorizontalAlignment$annotations", "getHorizontalAlignment", "()Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getOverrides", "()Ljava/util/List;", "getPadding", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getText-z7Tp-4o$annotations", "getText-z7Tp-4o", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class TextComponent implements PaywallComponent {
    private final ColorScheme backgroundColor;
    private final ColorScheme color;
    private final String fontName;
    private final int fontSize;
    private final FontWeight fontWeight;
    private final Integer fontWeightInt;
    private final HorizontalAlignment horizontalAlignment;
    private final Padding margin;
    private final List<ComponentOverride<PartialTextComponent>> overrides;
    private final Padding padding;
    private final Size size;
    private final String text;
    private final Boolean visible;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.INSTANCE.serializer(PartialTextComponent$$serializer.INSTANCE))};

    /* JADX INFO: compiled from: TextComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TextComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TextComponent> serializer() {
            return TextComponent$$serializer.INSTANCE;
        }
    }

    private TextComponent(int i, String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List<ComponentOverride<PartialTextComponent>> list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, TextComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.text = str;
        this.color = colorScheme;
        if ((i & 4) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i & 8) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme2;
        }
        if ((i & 16) == 0) {
            this.fontName = null;
        } else {
            this.fontName = str2;
        }
        if ((i & 32) == 0) {
            this.fontWeight = FontWeight.REGULAR;
        } else {
            this.fontWeight = fontWeight;
        }
        if ((i & 64) == 0) {
            this.fontWeightInt = null;
        } else {
            this.fontWeightInt = num;
        }
        if ((i & 128) == 0) {
            this.fontSize = 15;
        } else {
            this.fontSize = i2;
        }
        if ((i & 256) == 0) {
            this.horizontalAlignment = HorizontalAlignment.CENTER;
        } else {
            this.horizontalAlignment = horizontalAlignment;
        }
        if ((i & 512) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i & 1024) == 0) {
            this.padding = Padding.INSTANCE.getZero();
        } else {
            this.padding = padding;
        }
        if ((i & 2048) == 0) {
            this.margin = Padding.INSTANCE.getZero();
        } else {
            this.margin = padding2;
        }
        this.overrides = (i & 4096) == 0 ? CollectionsKt.emptyList() : list;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TextComponent(int i, @SerialName("text_lid") String str, ColorScheme colorScheme, Boolean bool, @SerialName("background_color") ColorScheme colorScheme2, @SerialName("font_name") String str2, @SerialName(FontsContractCompat.Columns.WEIGHT) FontWeight fontWeight, @SerialName("font_weight_int") Integer num, @SerialName(ViewHierarchyConstants.TEXT_SIZE) @Serializable(with = FontSizeSerializer.class) int i2, @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT) HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List list, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, colorScheme, bool, colorScheme2, str2, fontWeight, num, i2, horizontalAlignment, size, padding, padding2, (List<ComponentOverride<PartialTextComponent>>) list, serializationConstructorMarker);
    }

    private TextComponent(String text, ColorScheme color, Boolean bool, ColorScheme colorScheme, String str, FontWeight fontWeight, Integer num, int i, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding margin, List<ComponentOverride<PartialTextComponent>> overrides) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.text = text;
        this.color = color;
        this.visible = bool;
        this.backgroundColor = colorScheme;
        this.fontName = str;
        this.fontWeight = fontWeight;
        this.fontWeightInt = num;
        this.fontSize = i;
        this.horizontalAlignment = horizontalAlignment;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.overrides = overrides;
    }

    public /* synthetic */ TextComponent(String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, colorScheme, (i2 & 4) != 0 ? null : bool, (i2 & 8) != 0 ? null : colorScheme2, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? FontWeight.REGULAR : fontWeight, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? 15 : i, (i2 & 256) != 0 ? HorizontalAlignment.CENTER : horizontalAlignment, (i2 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i2 & 1024) != 0 ? Padding.INSTANCE.getZero() : padding, (i2 & 2048) != 0 ? Padding.INSTANCE.getZero() : padding2, (i2 & 4096) != 0 ? CollectionsKt.emptyList() : list, null);
    }

    public /* synthetic */ TextComponent(String str, ColorScheme colorScheme, Boolean bool, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, int i, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, colorScheme, bool, colorScheme2, str2, fontWeight, num, i, horizontalAlignment, size, padding, padding2, list);
    }

    @SerialName("background_color")
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @SerialName("font_name")
    /* JADX INFO: renamed from: getFontName-ARcRonI$annotations, reason: not valid java name */
    public static /* synthetic */ void m10385getFontNameARcRonI$annotations() {
    }

    @SerialName(ViewHierarchyConstants.TEXT_SIZE)
    @Serializable(with = FontSizeSerializer.class)
    public static /* synthetic */ void getFontSize$annotations() {
    }

    @SerialName(FontsContractCompat.Columns.WEIGHT)
    public static /* synthetic */ void getFontWeight$annotations() {
    }

    @SerialName("font_weight_int")
    public static /* synthetic */ void getFontWeightInt$annotations() {
    }

    @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT)
    public static /* synthetic */ void getHorizontalAlignment$annotations() {
    }

    @SerialName("text_lid")
    /* JADX INFO: renamed from: getText-z7Tp-4o$annotations, reason: not valid java name */
    public static /* synthetic */ void m10386getTextz7Tp4o$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TextComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m10428boximpl(self.text));
        output.encodeSerializableElement(serialDesc, 1, ColorScheme$$serializer.INSTANCE, self.color);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.visible != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, ColorScheme$$serializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fontName != null) {
            FontAlias$$serializer fontAlias$$serializer = FontAlias$$serializer.INSTANCE;
            String str = self.fontName;
            output.encodeNullableSerializableElement(serialDesc, 4, fontAlias$$serializer, str != null ? FontAlias.m10270boximpl(str) : null);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.fontWeight != FontWeight.REGULAR) {
            output.encodeSerializableElement(serialDesc, 5, FontWeightDeserializer.INSTANCE, self.fontWeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.fontWeightInt != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.fontWeightInt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.fontSize != 15) {
            output.encodeSerializableElement(serialDesc, 7, FontSizeSerializer.INSTANCE, Integer.valueOf(self.fontSize));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.horizontalAlignment != HorizontalAlignment.CENTER) {
            output.encodeSerializableElement(serialDesc, 8, HorizontalAlignmentDeserializer.INSTANCE, self.horizontalAlignment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            output.encodeSerializableElement(serialDesc, 9, Size$$serializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.padding, Padding.INSTANCE.getZero())) {
            output.encodeSerializableElement(serialDesc, 10, Padding$$serializer.INSTANCE, self.padding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.margin, Padding.INSTANCE.getZero())) {
            output.encodeSerializableElement(serialDesc, 11, Padding$$serializer.INSTANCE, self.margin);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 12) && Intrinsics.areEqual(self.overrides, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 12, kSerializerArr[12], self.overrides);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        boolean zM10273equalsimpl0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextComponent)) {
            return false;
        }
        TextComponent textComponent = (TextComponent) obj;
        if (!LocalizationKey.m10431equalsimpl0(this.text, textComponent.text) || !Intrinsics.areEqual(this.color, textComponent.color) || !Intrinsics.areEqual(this.visible, textComponent.visible) || !Intrinsics.areEqual(this.backgroundColor, textComponent.backgroundColor)) {
            return false;
        }
        String str = this.fontName;
        String str2 = textComponent.fontName;
        if (str == null) {
            zM10273equalsimpl0 = str2 == null;
        } else if (str2 != null) {
            zM10273equalsimpl0 = FontAlias.m10273equalsimpl0(str, str2);
        }
        return zM10273equalsimpl0 && this.fontWeight == textComponent.fontWeight && Intrinsics.areEqual(this.fontWeightInt, textComponent.fontWeightInt) && this.fontSize == textComponent.fontSize && this.horizontalAlignment == textComponent.horizontalAlignment && Intrinsics.areEqual(this.size, textComponent.size) && Intrinsics.areEqual(this.padding, textComponent.padding) && Intrinsics.areEqual(this.margin, textComponent.margin) && Intrinsics.areEqual(this.overrides, textComponent.overrides);
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ ColorScheme getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: getFontName-ARcRonI, reason: not valid java name and from getter */
    public final /* synthetic */ String getFontName() {
        return this.fontName;
    }

    public final /* synthetic */ int getFontSize() {
        return this.fontSize;
    }

    public final /* synthetic */ FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final /* synthetic */ Integer getFontWeightInt() {
        return this.fontWeightInt;
    }

    public final /* synthetic */ HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: getText-z7Tp-4o, reason: not valid java name and from getter */
    public final /* synthetic */ String getText() {
        return this.text;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iM10432hashCodeimpl = ((LocalizationKey.m10432hashCodeimpl(this.text) * 31) + this.color.hashCode()) * 31;
        Boolean bool = this.visible;
        int iHashCode = (iM10432hashCodeimpl + (bool == null ? 0 : bool.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode2 = (iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        String str = this.fontName;
        int iM10274hashCodeimpl = (((iHashCode2 + (str == null ? 0 : FontAlias.m10274hashCodeimpl(str))) * 31) + this.fontWeight.hashCode()) * 31;
        Integer num = this.fontWeightInt;
        return ((((((((((((iM10274hashCodeimpl + (num != null ? num.hashCode() : 0)) * 31) + this.fontSize) * 31) + this.horizontalAlignment.hashCode()) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TextComponent(text=");
        StringBuilder sbAppend = sb.append((Object) LocalizationKey.m10433toStringimpl(this.text)).append(", color=").append(this.color).append(", visible=").append(this.visible).append(", backgroundColor=").append(this.backgroundColor).append(", fontName=");
        String str = this.fontName;
        sbAppend.append((Object) (str == null ? AbstractJsonLexerKt.NULL : FontAlias.m10275toStringimpl(str))).append(", fontWeight=").append(this.fontWeight).append(", fontWeightInt=").append(this.fontWeightInt).append(", fontSize=").append(this.fontSize).append(", horizontalAlignment=").append(this.horizontalAlignment).append(", size=").append(this.size).append(", padding=").append(this.padding).append(", margin=");
        sb.append(this.margin).append(", overrides=").append(this.overrides).append(')');
        return sb.toString();
    }
}
