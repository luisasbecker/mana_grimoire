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
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
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

/* JADX INFO: compiled from: VideoComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 R2\u00020\u0001:\u0002QRBÉ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010!BÅ\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\"J&\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OHÁ\u0001¢\u0006\u0002\bPR \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010$\u001a\u0004\b+\u0010,R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010$\u001a\u0004\b.\u0010/R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010$\u001a\u0004\b1\u00102R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010'\u001a\u0004\b3\u0010&R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010$\u001a\u0004\b7\u00108R \u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b9\u0010$\u001a\u0004\b:\u0010&R&\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010>\u0012\u0004\b;\u0010$\u001a\u0004\b<\u0010=R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b?\u00105R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR \u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\bB\u0010$\u001a\u0004\bC\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010'\u001a\u0004\bH\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialVideoComponent;", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "seen1", "", "source", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "fallbackSource", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "visible", "", "showControls", "autoplay", "loop", "muteAudio", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "fitMode", "Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "maskShape", "Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "colorOverlay", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "shadow", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "overrideSourceLid", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoplay$annotations", "()V", "getAutoplay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBorder", "()Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "getColorOverlay$annotations", "getColorOverlay", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getFallbackSource$annotations", "getFallbackSource", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "getFitMode$annotations", "getFitMode", "()Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "getLoop", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getMaskShape$annotations", "getMaskShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "getMuteAudio$annotations", "getMuteAudio", "getOverrideSourceLid-sa7TU9Q$annotations", "getOverrideSourceLid-sa7TU9Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getPadding", "getShadow", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "getShowControls$annotations", "getShowControls", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSource", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "getVisible", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class PartialVideoComponent implements PartialComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean autoplay;
    private final Border border;
    private final ColorScheme colorOverlay;
    private final ThemeImageUrls fallbackSource;
    private final FitMode fitMode;
    private final Boolean loop;
    private final Padding margin;
    private final MaskShape maskShape;
    private final Boolean muteAudio;
    private final String overrideSourceLid;
    private final Padding padding;
    private final Shadow shadow;
    private final Boolean showControls;
    private final Size size;
    private final ThemeVideoUrls source;
    private final Boolean visible;

    /* JADX INFO: compiled from: VideoComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialVideoComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialVideoComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialVideoComponent> serializer() {
            return PartialVideoComponent$$serializer.INSTANCE;
        }
    }

    private PartialVideoComponent(int i, ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Size size, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.source = null;
        } else {
            this.source = themeVideoUrls;
        }
        if ((i & 2) == 0) {
            this.fallbackSource = null;
        } else {
            this.fallbackSource = themeImageUrls;
        }
        if ((i & 4) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i & 8) == 0) {
            this.showControls = null;
        } else {
            this.showControls = bool2;
        }
        if ((i & 16) == 0) {
            this.autoplay = null;
        } else {
            this.autoplay = bool3;
        }
        if ((i & 32) == 0) {
            this.loop = null;
        } else {
            this.loop = bool4;
        }
        if ((i & 64) == 0) {
            this.muteAudio = null;
        } else {
            this.muteAudio = bool5;
        }
        if ((i & 128) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i & 256) == 0) {
            this.fitMode = null;
        } else {
            this.fitMode = fitMode;
        }
        if ((i & 512) == 0) {
            this.maskShape = null;
        } else {
            this.maskShape = maskShape;
        }
        if ((i & 1024) == 0) {
            this.colorOverlay = null;
        } else {
            this.colorOverlay = colorScheme;
        }
        if ((i & 2048) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i & 4096) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
        if ((i & 8192) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i & 16384) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i & 32768) == 0) {
            this.overrideSourceLid = null;
        } else {
            this.overrideSourceLid = str;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PartialVideoComponent(int i, ThemeVideoUrls themeVideoUrls, @SerialName("fallback_source") ThemeImageUrls themeImageUrls, Boolean bool, @SerialName("show_controls") Boolean bool2, @SerialName("auto_play") Boolean bool3, Boolean bool4, @SerialName("mute_audio") Boolean bool5, Size size, @SerialName("fit_mode") FitMode fitMode, @SerialName("mask_shape") MaskShape maskShape, @SerialName("color_overlay") ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, @SerialName("override_source_lid") String str, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, themeVideoUrls, themeImageUrls, bool, bool2, bool3, bool4, bool5, size, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, str, serializationConstructorMarker);
    }

    private PartialVideoComponent(ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Size size, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, String str) {
        this.source = themeVideoUrls;
        this.fallbackSource = themeImageUrls;
        this.visible = bool;
        this.showControls = bool2;
        this.autoplay = bool3;
        this.loop = bool4;
        this.muteAudio = bool5;
        this.size = size;
        this.fitMode = fitMode;
        this.maskShape = maskShape;
        this.colorOverlay = colorScheme;
        this.padding = padding;
        this.margin = padding2;
        this.border = border;
        this.shadow = shadow;
        this.overrideSourceLid = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PartialVideoComponent(ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Size size, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ThemeVideoUrls themeVideoUrls2 = (i & 1) != 0 ? null : themeVideoUrls;
        ThemeImageUrls themeImageUrls2 = (i & 2) != 0 ? null : themeImageUrls;
        Boolean bool6 = (i & 4) != 0 ? null : bool;
        Boolean bool7 = (i & 8) != 0 ? null : bool2;
        Boolean bool8 = (i & 16) != 0 ? null : bool3;
        Boolean bool9 = (i & 32) != 0 ? null : bool4;
        Boolean bool10 = (i & 64) != 0 ? null : bool5;
        Size size2 = (i & 128) != 0 ? null : size;
        FitMode fitMode2 = (i & 256) != 0 ? null : fitMode;
        MaskShape maskShape2 = (i & 512) != 0 ? null : maskShape;
        ColorScheme colorScheme2 = (i & 1024) != 0 ? null : colorScheme;
        Padding padding3 = (i & 2048) != 0 ? null : padding;
        Padding padding4 = (i & 4096) != 0 ? null : padding2;
        Border border2 = (i & 8192) != 0 ? null : border;
        ThemeImageUrls themeImageUrls3 = themeImageUrls2;
        Boolean bool11 = bool6;
        Boolean bool12 = bool7;
        Boolean bool13 = bool8;
        Boolean bool14 = bool9;
        Boolean bool15 = bool10;
        Size size3 = size2;
        FitMode fitMode3 = fitMode2;
        MaskShape maskShape3 = maskShape2;
        ColorScheme colorScheme3 = colorScheme2;
        Padding padding5 = padding3;
        Padding padding6 = padding4;
        Border border3 = border2;
        this(themeVideoUrls2, themeImageUrls3, bool11, bool12, bool13, bool14, bool15, size3, fitMode3, maskShape3, colorScheme3, padding5, padding6, border3, (i & 16384) != 0 ? null : shadow, (i & 32768) != 0 ? null : str, null);
    }

    public /* synthetic */ PartialVideoComponent(ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Size size, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(themeVideoUrls, themeImageUrls, bool, bool2, bool3, bool4, bool5, size, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, str);
    }

    @SerialName("auto_play")
    public static /* synthetic */ void getAutoplay$annotations() {
    }

    @SerialName("color_overlay")
    public static /* synthetic */ void getColorOverlay$annotations() {
    }

    @SerialName("fallback_source")
    public static /* synthetic */ void getFallbackSource$annotations() {
    }

    @SerialName("fit_mode")
    public static /* synthetic */ void getFitMode$annotations() {
    }

    @SerialName("mask_shape")
    public static /* synthetic */ void getMaskShape$annotations() {
    }

    @SerialName("mute_audio")
    public static /* synthetic */ void getMuteAudio$annotations() {
    }

    @SerialName("override_source_lid")
    /* JADX INFO: renamed from: getOverrideSourceLid-sa7TU9Q$annotations, reason: not valid java name */
    public static /* synthetic */ void m10378getOverrideSourceLidsa7TU9Q$annotations() {
    }

    @SerialName("show_controls")
    public static /* synthetic */ void getShowControls$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialVideoComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.source != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, ThemeVideoUrls$$serializer.INSTANCE, self.source);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.fallbackSource != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ThemeImageUrls$$serializer.INSTANCE, self.fallbackSource);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.visible != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.showControls != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.showControls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.autoplay != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.autoplay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.loop != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.loop);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.muteAudio != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.muteAudio);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, Size$$serializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.fitMode != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, FitModeDeserializer.INSTANCE, self.fitMode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.maskShape != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, MaskShapeDeserializer.INSTANCE, self.maskShape);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.colorOverlay != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, ColorScheme$$serializer.INSTANCE, self.colorOverlay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.padding != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, Padding$$serializer.INSTANCE, self.padding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.margin != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, Padding$$serializer.INSTANCE, self.margin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.border != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, Border$$serializer.INSTANCE, self.border);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.shadow != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, Shadow$$serializer.INSTANCE, self.shadow);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 15) && self.overrideSourceLid == null) {
            return;
        }
        LocalizationKey$$serializer localizationKey$$serializer = LocalizationKey$$serializer.INSTANCE;
        String str = self.overrideSourceLid;
        output.encodeNullableSerializableElement(serialDesc, 15, localizationKey$$serializer, str != null ? LocalizationKey.m10428boximpl(str) : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        boolean zM10431equalsimpl0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialVideoComponent)) {
            return false;
        }
        PartialVideoComponent partialVideoComponent = (PartialVideoComponent) obj;
        if (!Intrinsics.areEqual(this.source, partialVideoComponent.source) || !Intrinsics.areEqual(this.fallbackSource, partialVideoComponent.fallbackSource) || !Intrinsics.areEqual(this.visible, partialVideoComponent.visible) || !Intrinsics.areEqual(this.showControls, partialVideoComponent.showControls) || !Intrinsics.areEqual(this.autoplay, partialVideoComponent.autoplay) || !Intrinsics.areEqual(this.loop, partialVideoComponent.loop) || !Intrinsics.areEqual(this.muteAudio, partialVideoComponent.muteAudio) || !Intrinsics.areEqual(this.size, partialVideoComponent.size) || this.fitMode != partialVideoComponent.fitMode || !Intrinsics.areEqual(this.maskShape, partialVideoComponent.maskShape) || !Intrinsics.areEqual(this.colorOverlay, partialVideoComponent.colorOverlay) || !Intrinsics.areEqual(this.padding, partialVideoComponent.padding) || !Intrinsics.areEqual(this.margin, partialVideoComponent.margin) || !Intrinsics.areEqual(this.border, partialVideoComponent.border) || !Intrinsics.areEqual(this.shadow, partialVideoComponent.shadow)) {
            return false;
        }
        String str = this.overrideSourceLid;
        String str2 = partialVideoComponent.overrideSourceLid;
        if (str == null) {
            zM10431equalsimpl0 = str2 == null;
        } else if (str2 != null) {
            zM10431equalsimpl0 = LocalizationKey.m10431equalsimpl0(str, str2);
        }
        return zM10431equalsimpl0;
    }

    public final /* synthetic */ Boolean getAutoplay() {
        return this.autoplay;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ ColorScheme getColorOverlay() {
        return this.colorOverlay;
    }

    public final /* synthetic */ ThemeImageUrls getFallbackSource() {
        return this.fallbackSource;
    }

    public final /* synthetic */ FitMode getFitMode() {
        return this.fitMode;
    }

    public final /* synthetic */ Boolean getLoop() {
        return this.loop;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ MaskShape getMaskShape() {
        return this.maskShape;
    }

    public final /* synthetic */ Boolean getMuteAudio() {
        return this.muteAudio;
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

    public final /* synthetic */ Boolean getShowControls() {
        return this.showControls;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ ThemeVideoUrls getSource() {
        return this.source;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        ThemeVideoUrls themeVideoUrls = this.source;
        int iHashCode = (themeVideoUrls == null ? 0 : themeVideoUrls.hashCode()) * 31;
        ThemeImageUrls themeImageUrls = this.fallbackSource;
        int iHashCode2 = (iHashCode + (themeImageUrls == null ? 0 : themeImageUrls.hashCode())) * 31;
        Boolean bool = this.visible;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.showControls;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.autoplay;
        int iHashCode5 = (iHashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.loop;
        int iHashCode6 = (iHashCode5 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.muteAudio;
        int iHashCode7 = (iHashCode6 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Size size = this.size;
        int iHashCode8 = (iHashCode7 + (size == null ? 0 : size.hashCode())) * 31;
        FitMode fitMode = this.fitMode;
        int iHashCode9 = (iHashCode8 + (fitMode == null ? 0 : fitMode.hashCode())) * 31;
        MaskShape maskShape = this.maskShape;
        int iHashCode10 = (iHashCode9 + (maskShape == null ? 0 : maskShape.hashCode())) * 31;
        ColorScheme colorScheme = this.colorOverlay;
        int iHashCode11 = (iHashCode10 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode12 = (iHashCode11 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode13 = (iHashCode12 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Border border = this.border;
        int iHashCode14 = (iHashCode13 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode15 = (iHashCode14 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        String str = this.overrideSourceLid;
        return iHashCode15 + (str != null ? LocalizationKey.m10432hashCodeimpl(str) : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PartialVideoComponent(source=");
        sb.append(this.source).append(", fallbackSource=").append(this.fallbackSource).append(", visible=").append(this.visible).append(", showControls=").append(this.showControls).append(", autoplay=").append(this.autoplay).append(", loop=").append(this.loop).append(", muteAudio=").append(this.muteAudio).append(", size=").append(this.size).append(", fitMode=").append(this.fitMode).append(", maskShape=").append(this.maskShape).append(", colorOverlay=").append(this.colorOverlay).append(", padding=");
        StringBuilder sbAppend = sb.append(this.padding).append(", margin=").append(this.margin).append(", border=").append(this.border).append(", shadow=").append(this.shadow).append(", overrideSourceLid=");
        String str = this.overrideSourceLid;
        sbAppend.append((Object) (str == null ? AbstractJsonLexerKt.NULL : LocalizationKey.m10433toStringimpl(str))).append(')');
        return sb.toString();
    }
}
