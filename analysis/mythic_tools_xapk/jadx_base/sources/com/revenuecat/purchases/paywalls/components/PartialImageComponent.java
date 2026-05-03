package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ImageComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 B2\u00020\u0001:\u0002ABB\u008f\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bB\u0089\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u001cJ&\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?HÁ\u0001¢\u0006\u0002\b@R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010 \u001a\u0004\b$\u0010%R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010 \u001a\u0004\b)\u0010*R&\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010.\u0012\u0004\b+\u0010 \u001a\u0004\b,\u0010-R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialImageComponent;", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "seen1", "", "visible", "", "source", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "overrideSourceLid", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "fitMode", "Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "maskShape", "Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "colorOverlay", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "shadow", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBorder", "()Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "getColorOverlay$annotations", "()V", "getColorOverlay", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getFitMode$annotations", "getFitMode", "()Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getMaskShape$annotations", "getMaskShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "getOverrideSourceLid-sa7TU9Q$annotations", "getOverrideSourceLid-sa7TU9Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getPadding", "getShadow", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSource", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class PartialImageComponent implements PartialComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Border border;
    private final ColorScheme colorOverlay;
    private final FitMode fitMode;
    private final Padding margin;
    private final MaskShape maskShape;
    private final String overrideSourceLid;
    private final Padding padding;
    private final Shadow shadow;
    private final Size size;
    private final ThemeImageUrls source;
    private final Boolean visible;

    /* JADX INFO: compiled from: ImageComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialImageComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialImageComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialImageComponent> serializer() {
            return PartialImageComponent$$serializer.INSTANCE;
        }
    }

    private PartialImageComponent(int i, Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, SerializationConstructorMarker serializationConstructorMarker) {
        this.visible = (i & 1) == 0 ? true : bool;
        if ((i & 2) == 0) {
            this.source = null;
        } else {
            this.source = themeImageUrls;
        }
        if ((i & 4) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i & 8) == 0) {
            this.overrideSourceLid = null;
        } else {
            this.overrideSourceLid = str;
        }
        if ((i & 16) == 0) {
            this.fitMode = null;
        } else {
            this.fitMode = fitMode;
        }
        if ((i & 32) == 0) {
            this.maskShape = null;
        } else {
            this.maskShape = maskShape;
        }
        if ((i & 64) == 0) {
            this.colorOverlay = null;
        } else {
            this.colorOverlay = colorScheme;
        }
        if ((i & 128) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i & 256) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
        if ((i & 512) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i & 1024) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PartialImageComponent(int i, Boolean bool, ThemeImageUrls themeImageUrls, Size size, @SerialName("override_source_lid") String str, @SerialName("fit_mode") FitMode fitMode, @SerialName("mask_shape") MaskShape maskShape, @SerialName("color_overlay") ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bool, themeImageUrls, size, str, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, serializationConstructorMarker);
    }

    private PartialImageComponent(Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow) {
        this.visible = bool;
        this.source = themeImageUrls;
        this.size = size;
        this.overrideSourceLid = str;
        this.fitMode = fitMode;
        this.maskShape = maskShape;
        this.colorOverlay = colorScheme;
        this.padding = padding;
        this.margin = padding2;
        this.border = border;
        this.shadow = shadow;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PartialImageComponent(Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Boolean bool2 = (i & 1) != 0 ? true : bool;
        ThemeImageUrls themeImageUrls2 = (i & 2) != 0 ? null : themeImageUrls;
        Size size2 = (i & 4) != 0 ? null : size;
        String str2 = (i & 8) != 0 ? null : str;
        FitMode fitMode2 = (i & 16) != 0 ? null : fitMode;
        MaskShape maskShape2 = (i & 32) != 0 ? null : maskShape;
        ColorScheme colorScheme2 = (i & 64) != 0 ? null : colorScheme;
        Padding padding3 = (i & 128) != 0 ? null : padding;
        Padding padding4 = (i & 256) != 0 ? null : padding2;
        Border border2 = (i & 512) != 0 ? null : border;
        this(bool2, themeImageUrls2, size2, str2, fitMode2, maskShape2, colorScheme2, padding3, padding4, border2, (i & 1024) == 0 ? shadow : null, null);
    }

    public /* synthetic */ PartialImageComponent(Boolean bool, ThemeImageUrls themeImageUrls, Size size, String str, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, themeImageUrls, size, str, fitMode, maskShape, colorScheme, padding, padding2, border, shadow);
    }

    @SerialName("color_overlay")
    public static /* synthetic */ void getColorOverlay$annotations() {
    }

    @SerialName("fit_mode")
    public static /* synthetic */ void getFitMode$annotations() {
    }

    @SerialName("mask_shape")
    public static /* synthetic */ void getMaskShape$annotations() {
    }

    @SerialName("override_source_lid")
    /* JADX INFO: renamed from: getOverrideSourceLid-sa7TU9Q$annotations, reason: not valid java name */
    public static /* synthetic */ void m10372getOverrideSourceLidsa7TU9Q$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialImageComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual((Object) self.visible, (Object) true)) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.source != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ThemeImageUrls$$serializer.INSTANCE, self.source);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, Size$$serializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.overrideSourceLid != null) {
            LocalizationKey$$serializer localizationKey$$serializer = LocalizationKey$$serializer.INSTANCE;
            String str = self.overrideSourceLid;
            output.encodeNullableSerializableElement(serialDesc, 3, localizationKey$$serializer, str != null ? LocalizationKey.m10428boximpl(str) : null);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fitMode != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, FitModeDeserializer.INSTANCE, self.fitMode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.maskShape != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, MaskShapeDeserializer.INSTANCE, self.maskShape);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.colorOverlay != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, ColorScheme$$serializer.INSTANCE, self.colorOverlay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.padding != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, Padding$$serializer.INSTANCE, self.padding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.margin != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, Padding$$serializer.INSTANCE, self.margin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.border != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, Border$$serializer.INSTANCE, self.border);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && self.shadow == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 10, Shadow$$serializer.INSTANCE, self.shadow);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        boolean zM10431equalsimpl0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialImageComponent)) {
            return false;
        }
        PartialImageComponent partialImageComponent = (PartialImageComponent) obj;
        if (!Intrinsics.areEqual(this.visible, partialImageComponent.visible) || !Intrinsics.areEqual(this.source, partialImageComponent.source) || !Intrinsics.areEqual(this.size, partialImageComponent.size)) {
            return false;
        }
        String str = this.overrideSourceLid;
        String str2 = partialImageComponent.overrideSourceLid;
        if (str == null) {
            zM10431equalsimpl0 = str2 == null;
        } else if (str2 != null) {
            zM10431equalsimpl0 = LocalizationKey.m10431equalsimpl0(str, str2);
        }
        return zM10431equalsimpl0 && this.fitMode == partialImageComponent.fitMode && Intrinsics.areEqual(this.maskShape, partialImageComponent.maskShape) && Intrinsics.areEqual(this.colorOverlay, partialImageComponent.colorOverlay) && Intrinsics.areEqual(this.padding, partialImageComponent.padding) && Intrinsics.areEqual(this.margin, partialImageComponent.margin) && Intrinsics.areEqual(this.border, partialImageComponent.border) && Intrinsics.areEqual(this.shadow, partialImageComponent.shadow);
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ ColorScheme getColorOverlay() {
        return this.colorOverlay;
    }

    public final /* synthetic */ FitMode getFitMode() {
        return this.fitMode;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ MaskShape getMaskShape() {
        return this.maskShape;
    }

    /* JADX INFO: renamed from: getOverrideSourceLid-sa7TU9Q, reason: not valid java name and from getter */
    public final /* synthetic */ String getOverrideSourceLid() {
        return this.overrideSourceLid;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Shadow getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ ThemeImageUrls getSource() {
        return this.source;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        ThemeImageUrls themeImageUrls = this.source;
        int iHashCode2 = (iHashCode + (themeImageUrls == null ? 0 : themeImageUrls.hashCode())) * 31;
        Size size = this.size;
        int iHashCode3 = (iHashCode2 + (size == null ? 0 : size.hashCode())) * 31;
        String str = this.overrideSourceLid;
        int iM10432hashCodeimpl = (iHashCode3 + (str == null ? 0 : LocalizationKey.m10432hashCodeimpl(str))) * 31;
        FitMode fitMode = this.fitMode;
        int iHashCode4 = (iM10432hashCodeimpl + (fitMode == null ? 0 : fitMode.hashCode())) * 31;
        MaskShape maskShape = this.maskShape;
        int iHashCode5 = (iHashCode4 + (maskShape == null ? 0 : maskShape.hashCode())) * 31;
        ColorScheme colorScheme = this.colorOverlay;
        int iHashCode6 = (iHashCode5 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode7 = (iHashCode6 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode8 = (iHashCode7 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Border border = this.border;
        int iHashCode9 = (iHashCode8 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        return iHashCode9 + (shadow != null ? shadow.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PartialImageComponent(visible=");
        StringBuilder sbAppend = sb.append(this.visible).append(", source=").append(this.source).append(", size=").append(this.size).append(", overrideSourceLid=");
        String str = this.overrideSourceLid;
        sbAppend.append((Object) (str == null ? AbstractJsonLexerKt.NULL : LocalizationKey.m10433toStringimpl(str))).append(", fitMode=").append(this.fitMode).append(", maskShape=").append(this.maskShape).append(", colorOverlay=").append(this.colorOverlay).append(", padding=").append(this.padding).append(", margin=").append(this.margin).append(", border=").append(this.border).append(", shadow=").append(this.shadow).append(')');
        return sb.toString();
    }
}
