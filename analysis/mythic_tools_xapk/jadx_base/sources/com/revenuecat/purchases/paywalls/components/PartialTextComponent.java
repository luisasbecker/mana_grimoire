package com.revenuecat.purchases.paywalls.components;

import androidx.core.provider.FontsContractCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.FontAlias$$serializer;
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
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: TextComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002CDB\u009f\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aB\u0095\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u001bJ&\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AHÁ\u0001¢\u0006\u0002\bBR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010#R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010(\u0012\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010'R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010+R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010(\u0012\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010'R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001d\u001a\u0004\b/\u00100R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b6\u0010\u001d\u001a\u0004\b7\u0010#R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "seen1", "", "visible", "", "text", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "color", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "backgroundColor", "fontName", "Lcom/revenuecat/purchases/FontAlias;", "fontWeight", "Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;", "fontWeightInt", "fontSize", "horizontalAlignment", "Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor$annotations", "()V", "getBackgroundColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getColor", "getFontName-ARcRonI$annotations", "getFontName-ARcRonI", "()Ljava/lang/String;", "Ljava/lang/String;", "getFontSize$annotations", "getFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFontWeight$annotations", "getFontWeight", "()Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;", "getFontWeightInt$annotations", "getFontWeightInt", "getHorizontalAlignment$annotations", "getHorizontalAlignment", "()Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getPadding", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getText-sa7TU9Q$annotations", "getText-sa7TU9Q", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class PartialTextComponent implements PartialComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ColorScheme backgroundColor;
    private final ColorScheme color;
    private final String fontName;
    private final Integer fontSize;
    private final FontWeight fontWeight;
    private final Integer fontWeightInt;
    private final HorizontalAlignment horizontalAlignment;
    private final Padding margin;
    private final Padding padding;
    private final Size size;
    private final String text;
    private final Boolean visible;

    /* JADX INFO: compiled from: TextComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialTextComponent> serializer() {
            return PartialTextComponent$$serializer.INSTANCE;
        }
    }

    private PartialTextComponent(int i, Boolean bool, String str, ColorScheme colorScheme, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, Integer num2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, SerializationConstructorMarker serializationConstructorMarker) {
        this.visible = (i & 1) == 0 ? true : bool;
        if ((i & 2) == 0) {
            this.text = null;
        } else {
            this.text = str;
        }
        if ((i & 4) == 0) {
            this.color = null;
        } else {
            this.color = colorScheme;
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
            this.fontWeight = null;
        } else {
            this.fontWeight = fontWeight;
        }
        if ((i & 64) == 0) {
            this.fontWeightInt = null;
        } else {
            this.fontWeightInt = num;
        }
        if ((i & 128) == 0) {
            this.fontSize = null;
        } else {
            this.fontSize = num2;
        }
        if ((i & 256) == 0) {
            this.horizontalAlignment = null;
        } else {
            this.horizontalAlignment = horizontalAlignment;
        }
        if ((i & 512) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i & 1024) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i & 2048) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PartialTextComponent(int i, Boolean bool, @SerialName("text_lid") String str, ColorScheme colorScheme, @SerialName("background_color") ColorScheme colorScheme2, @SerialName("font_name") String str2, @SerialName(FontsContractCompat.Columns.WEIGHT) FontWeight fontWeight, @SerialName("font_weight_int") Integer num, @SerialName(ViewHierarchyConstants.TEXT_SIZE) @Serializable(with = FontSizeSerializer.class) Integer num2, @SerialName(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT) HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bool, str, colorScheme, colorScheme2, str2, fontWeight, num, num2, horizontalAlignment, size, padding, padding2, serializationConstructorMarker);
    }

    private PartialTextComponent(Boolean bool, String str, ColorScheme colorScheme, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, Integer num2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2) {
        this.visible = bool;
        this.text = str;
        this.color = colorScheme;
        this.backgroundColor = colorScheme2;
        this.fontName = str2;
        this.fontWeight = fontWeight;
        this.fontWeightInt = num;
        this.fontSize = num2;
        this.horizontalAlignment = horizontalAlignment;
        this.size = size;
        this.padding = padding;
        this.margin = padding2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PartialTextComponent(Boolean bool, String str, ColorScheme colorScheme, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, Integer num2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Boolean bool2 = (i & 1) != 0 ? true : bool;
        String str3 = (i & 2) != 0 ? null : str;
        ColorScheme colorScheme3 = (i & 4) != 0 ? null : colorScheme;
        ColorScheme colorScheme4 = (i & 8) != 0 ? null : colorScheme2;
        String str4 = (i & 16) != 0 ? null : str2;
        FontWeight fontWeight2 = (i & 32) != 0 ? null : fontWeight;
        Integer num3 = (i & 64) != 0 ? null : num;
        Integer num4 = (i & 128) != 0 ? null : num2;
        HorizontalAlignment horizontalAlignment2 = (i & 256) != 0 ? null : horizontalAlignment;
        Size size2 = (i & 512) != 0 ? null : size;
        Padding padding3 = (i & 1024) != 0 ? null : padding;
        this(bool2, str3, colorScheme3, colorScheme4, str4, fontWeight2, num3, num4, horizontalAlignment2, size2, padding3, (i & 2048) == 0 ? padding2 : null, null);
    }

    public /* synthetic */ PartialTextComponent(Boolean bool, String str, ColorScheme colorScheme, ColorScheme colorScheme2, String str2, FontWeight fontWeight, Integer num, Integer num2, HorizontalAlignment horizontalAlignment, Size size, Padding padding, Padding padding2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, str, colorScheme, colorScheme2, str2, fontWeight, num, num2, horizontalAlignment, size, padding, padding2);
    }

    @SerialName("background_color")
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @SerialName("font_name")
    /* JADX INFO: renamed from: getFontName-ARcRonI$annotations, reason: not valid java name */
    public static /* synthetic */ void m10374getFontNameARcRonI$annotations() {
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
    /* JADX INFO: renamed from: getText-sa7TU9Q$annotations, reason: not valid java name */
    public static /* synthetic */ void m10375getTextsa7TU9Q$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialTextComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual((Object) self.visible, (Object) true)) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.text != null) {
            LocalizationKey$$serializer localizationKey$$serializer = LocalizationKey$$serializer.INSTANCE;
            String str = self.text;
            output.encodeNullableSerializableElement(serialDesc, 1, localizationKey$$serializer, str != null ? LocalizationKey.m10428boximpl(str) : null);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.color != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, ColorScheme$$serializer.INSTANCE, self.color);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, ColorScheme$$serializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fontName != null) {
            FontAlias$$serializer fontAlias$$serializer = FontAlias$$serializer.INSTANCE;
            String str2 = self.fontName;
            output.encodeNullableSerializableElement(serialDesc, 4, fontAlias$$serializer, str2 != null ? FontAlias.m10270boximpl(str2) : null);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.fontWeight != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, FontWeightDeserializer.INSTANCE, self.fontWeight);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.fontWeightInt != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.fontWeightInt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.fontSize != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, FontSizeSerializer.INSTANCE, self.fontSize);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.horizontalAlignment != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, HorizontalAlignmentDeserializer.INSTANCE, self.horizontalAlignment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, Size$$serializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.padding != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, Padding$$serializer.INSTANCE, self.padding);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 11) && self.margin == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 11, Padding$$serializer.INSTANCE, self.margin);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        boolean zM10431equalsimpl0;
        boolean zM10273equalsimpl0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialTextComponent)) {
            return false;
        }
        PartialTextComponent partialTextComponent = (PartialTextComponent) obj;
        if (!Intrinsics.areEqual(this.visible, partialTextComponent.visible)) {
            return false;
        }
        String str = this.text;
        String str2 = partialTextComponent.text;
        if (str == null) {
            zM10431equalsimpl0 = str2 == null;
        } else if (str2 != null) {
            zM10431equalsimpl0 = LocalizationKey.m10431equalsimpl0(str, str2);
        }
        if (!zM10431equalsimpl0 || !Intrinsics.areEqual(this.color, partialTextComponent.color) || !Intrinsics.areEqual(this.backgroundColor, partialTextComponent.backgroundColor)) {
            return false;
        }
        String str3 = this.fontName;
        String str4 = partialTextComponent.fontName;
        if (str3 == null) {
            zM10273equalsimpl0 = str4 == null;
        } else if (str4 != null) {
            zM10273equalsimpl0 = FontAlias.m10273equalsimpl0(str3, str4);
        }
        return zM10273equalsimpl0 && this.fontWeight == partialTextComponent.fontWeight && Intrinsics.areEqual(this.fontWeightInt, partialTextComponent.fontWeightInt) && Intrinsics.areEqual(this.fontSize, partialTextComponent.fontSize) && this.horizontalAlignment == partialTextComponent.horizontalAlignment && Intrinsics.areEqual(this.size, partialTextComponent.size) && Intrinsics.areEqual(this.padding, partialTextComponent.padding) && Intrinsics.areEqual(this.margin, partialTextComponent.margin);
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

    public final /* synthetic */ Integer getFontSize() {
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

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: getText-sa7TU9Q, reason: not valid java name and from getter */
    public final /* synthetic */ String getText() {
        return this.text;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.text;
        int iM10432hashCodeimpl = (iHashCode + (str == null ? 0 : LocalizationKey.m10432hashCodeimpl(str))) * 31;
        ColorScheme colorScheme = this.color;
        int iHashCode2 = (iM10432hashCodeimpl + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        ColorScheme colorScheme2 = this.backgroundColor;
        int iHashCode3 = (iHashCode2 + (colorScheme2 == null ? 0 : colorScheme2.hashCode())) * 31;
        String str2 = this.fontName;
        int iM10274hashCodeimpl = (iHashCode3 + (str2 == null ? 0 : FontAlias.m10274hashCodeimpl(str2))) * 31;
        FontWeight fontWeight = this.fontWeight;
        int iHashCode4 = (iM10274hashCodeimpl + (fontWeight == null ? 0 : fontWeight.hashCode())) * 31;
        Integer num = this.fontWeightInt;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.fontSize;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        HorizontalAlignment horizontalAlignment = this.horizontalAlignment;
        int iHashCode7 = (iHashCode6 + (horizontalAlignment == null ? 0 : horizontalAlignment.hashCode())) * 31;
        Size size = this.size;
        int iHashCode8 = (iHashCode7 + (size == null ? 0 : size.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode9 = (iHashCode8 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        return iHashCode9 + (padding2 != null ? padding2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PartialTextComponent(visible=");
        StringBuilder sbAppend = sb.append(this.visible).append(", text=");
        String str = this.text;
        String strM10275toStringimpl = AbstractJsonLexerKt.NULL;
        StringBuilder sbAppend2 = sbAppend.append((Object) (str == null ? AbstractJsonLexerKt.NULL : LocalizationKey.m10433toStringimpl(str))).append(", color=").append(this.color).append(", backgroundColor=").append(this.backgroundColor).append(", fontName=");
        String str2 = this.fontName;
        if (str2 != null) {
            strM10275toStringimpl = FontAlias.m10275toStringimpl(str2);
        }
        sbAppend2.append((Object) strM10275toStringimpl).append(", fontWeight=").append(this.fontWeight).append(", fontWeightInt=").append(this.fontWeightInt).append(", fontSize=").append(this.fontSize).append(", horizontalAlignment=").append(this.horizontalAlignment).append(", size=").append(this.size).append(", padding=").append(this.padding).append(", margin=");
        sb.append(this.margin).append(')');
        return sb.toString();
    }
}
