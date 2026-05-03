package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
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
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: VideoComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@SerialName("video")
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0002XYB×\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\b\u0001\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0014\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001e\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%B¯\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0014\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010&J&\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VHÁ\u0001¢\u0006\u0002\bWR\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010(\u001a\u0004\b.\u0010/R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010(\u001a\u0004\b1\u00102R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010(\u001a\u0004\b4\u00105R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010(\u001a\u0004\b:\u0010;R\u001c\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010(\u001a\u0004\b=\u0010*R&\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010A\u0012\u0004\b>\u0010(\u001a\u0004\b?\u0010@R\u001f\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bD\u00108R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010(\u001a\u0004\bH\u0010*R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010O\u001a\u0004\bM\u0010N\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/VideoComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "source", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "fallbackSource", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "visible", "", "showControls", "autoplay", "loop", "muteAudio", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "fitMode", "Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "maskShape", "Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "colorOverlay", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "shadow", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "overrides", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lcom/revenuecat/purchases/paywalls/components/PartialVideoComponent;", "overrideSourceLid", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Ljava/lang/Boolean;ZZZZLcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Ljava/lang/Boolean;ZZZZLcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoplay$annotations", "()V", "getAutoplay", "()Z", "getBorder", "()Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "getColorOverlay$annotations", "getColorOverlay", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getFallbackSource$annotations", "getFallbackSource", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "getFitMode$annotations", "getFitMode", "()Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "getLoop", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getMaskShape$annotations", "getMaskShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "getMuteAudio$annotations", "getMuteAudio", "getOverrideSourceLid-sa7TU9Q$annotations", "getOverrideSourceLid-sa7TU9Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getOverrides", "()Ljava/util/List;", "getPadding", "getShadow", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "getShowControls$annotations", "getShowControls", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSource", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class VideoComponent implements PaywallComponent {
    private final boolean autoplay;
    private final Border border;
    private final ColorScheme colorOverlay;
    private final ThemeImageUrls fallbackSource;
    private final FitMode fitMode;
    private final boolean loop;
    private final Padding margin;
    private final MaskShape maskShape;
    private final boolean muteAudio;
    private final String overrideSourceLid;
    private final List<ComponentOverride<PartialVideoComponent>> overrides;
    private final Padding padding;
    private final Shadow shadow;
    private final boolean showControls;
    private final Size size;
    private final ThemeVideoUrls source;
    private final Boolean visible;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(ComponentOverride.INSTANCE.serializer(PartialVideoComponent$$serializer.INSTANCE)), null};

    /* JADX INFO: compiled from: VideoComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/VideoComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/VideoComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<VideoComponent> serializer() {
            return VideoComponent$$serializer.INSTANCE;
        }
    }

    private VideoComponent(int i, ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, Boolean bool, boolean z, boolean z2, boolean z3, boolean z4, Size size, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, List<ComponentOverride<PartialVideoComponent>> list, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (65535 != (i & 65535)) {
            PluginExceptionsKt.throwMissingFieldException(i, 65535, VideoComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.source = themeVideoUrls;
        this.fallbackSource = themeImageUrls;
        this.visible = bool;
        this.showControls = z;
        this.autoplay = z2;
        this.loop = z3;
        this.muteAudio = z4;
        this.size = size;
        this.fitMode = fitMode;
        this.maskShape = maskShape;
        this.colorOverlay = colorScheme;
        this.padding = padding;
        this.margin = padding2;
        this.border = border;
        this.shadow = shadow;
        this.overrides = list;
        this.overrideSourceLid = (i & 65536) == 0 ? null : str;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ VideoComponent(int i, ThemeVideoUrls themeVideoUrls, @SerialName("fallback_source") ThemeImageUrls themeImageUrls, Boolean bool, @SerialName("show_controls") boolean z, @SerialName("auto_play") boolean z2, boolean z3, @SerialName("mute_audio") boolean z4, Size size, @SerialName("fit_mode") FitMode fitMode, @SerialName("mask_shape") MaskShape maskShape, @SerialName("color_overlay") ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, List list, @SerialName("override_source_lid") String str, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, themeVideoUrls, themeImageUrls, bool, z, z2, z3, z4, size, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, (List<ComponentOverride<PartialVideoComponent>>) list, str, serializationConstructorMarker);
    }

    private VideoComponent(ThemeVideoUrls source, ThemeImageUrls themeImageUrls, Boolean bool, boolean z, boolean z2, boolean z3, boolean z4, Size size, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, List<ComponentOverride<PartialVideoComponent>> list, String str) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(fitMode, "fitMode");
        this.source = source;
        this.fallbackSource = themeImageUrls;
        this.visible = bool;
        this.showControls = z;
        this.autoplay = z2;
        this.loop = z3;
        this.muteAudio = z4;
        this.size = size;
        this.fitMode = fitMode;
        this.maskShape = maskShape;
        this.colorOverlay = colorScheme;
        this.padding = padding;
        this.margin = padding2;
        this.border = border;
        this.shadow = shadow;
        this.overrides = list;
        this.overrideSourceLid = str;
    }

    public /* synthetic */ VideoComponent(ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, Boolean bool, boolean z, boolean z2, boolean z3, boolean z4, Size size, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(themeVideoUrls, themeImageUrls, bool, z, z2, z3, z4, size, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, list, (i & 65536) != 0 ? null : str, null);
    }

    public /* synthetic */ VideoComponent(ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, Boolean bool, boolean z, boolean z2, boolean z3, boolean z4, Size size, FitMode fitMode, MaskShape maskShape, ColorScheme colorScheme, Padding padding, Padding padding2, Border border, Shadow shadow, List list, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(themeVideoUrls, themeImageUrls, bool, z, z2, z3, z4, size, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, list, str);
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
    public static /* synthetic */ void m10390getOverrideSourceLidsa7TU9Q$annotations() {
    }

    @SerialName("show_controls")
    public static /* synthetic */ void getShowControls$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(VideoComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, ThemeVideoUrls$$serializer.INSTANCE, self.source);
        output.encodeNullableSerializableElement(serialDesc, 1, ThemeImageUrls$$serializer.INSTANCE, self.fallbackSource);
        output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.visible);
        output.encodeBooleanElement(serialDesc, 3, self.showControls);
        output.encodeBooleanElement(serialDesc, 4, self.autoplay);
        output.encodeBooleanElement(serialDesc, 5, self.loop);
        output.encodeBooleanElement(serialDesc, 6, self.muteAudio);
        output.encodeSerializableElement(serialDesc, 7, Size$$serializer.INSTANCE, self.size);
        output.encodeSerializableElement(serialDesc, 8, FitModeDeserializer.INSTANCE, self.fitMode);
        output.encodeNullableSerializableElement(serialDesc, 9, MaskShapeDeserializer.INSTANCE, self.maskShape);
        output.encodeNullableSerializableElement(serialDesc, 10, ColorScheme$$serializer.INSTANCE, self.colorOverlay);
        output.encodeNullableSerializableElement(serialDesc, 11, Padding$$serializer.INSTANCE, self.padding);
        output.encodeNullableSerializableElement(serialDesc, 12, Padding$$serializer.INSTANCE, self.margin);
        output.encodeNullableSerializableElement(serialDesc, 13, Border$$serializer.INSTANCE, self.border);
        output.encodeNullableSerializableElement(serialDesc, 14, Shadow$$serializer.INSTANCE, self.shadow);
        output.encodeNullableSerializableElement(serialDesc, 15, kSerializerArr[15], self.overrides);
        if (!output.shouldEncodeElementDefault(serialDesc, 16) && self.overrideSourceLid == null) {
            return;
        }
        LocalizationKey$$serializer localizationKey$$serializer = LocalizationKey$$serializer.INSTANCE;
        String str = self.overrideSourceLid;
        output.encodeNullableSerializableElement(serialDesc, 16, localizationKey$$serializer, str != null ? LocalizationKey.m10428boximpl(str) : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        boolean zM10431equalsimpl0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoComponent)) {
            return false;
        }
        VideoComponent videoComponent = (VideoComponent) obj;
        if (!Intrinsics.areEqual(this.source, videoComponent.source) || !Intrinsics.areEqual(this.fallbackSource, videoComponent.fallbackSource) || !Intrinsics.areEqual(this.visible, videoComponent.visible) || this.showControls != videoComponent.showControls || this.autoplay != videoComponent.autoplay || this.loop != videoComponent.loop || this.muteAudio != videoComponent.muteAudio || !Intrinsics.areEqual(this.size, videoComponent.size) || this.fitMode != videoComponent.fitMode || !Intrinsics.areEqual(this.maskShape, videoComponent.maskShape) || !Intrinsics.areEqual(this.colorOverlay, videoComponent.colorOverlay) || !Intrinsics.areEqual(this.padding, videoComponent.padding) || !Intrinsics.areEqual(this.margin, videoComponent.margin) || !Intrinsics.areEqual(this.border, videoComponent.border) || !Intrinsics.areEqual(this.shadow, videoComponent.shadow) || !Intrinsics.areEqual(this.overrides, videoComponent.overrides)) {
            return false;
        }
        String str = this.overrideSourceLid;
        String str2 = videoComponent.overrideSourceLid;
        if (str == null) {
            zM10431equalsimpl0 = str2 == null;
        } else if (str2 != null) {
            zM10431equalsimpl0 = LocalizationKey.m10431equalsimpl0(str, str2);
        }
        return zM10431equalsimpl0;
    }

    public final /* synthetic */ boolean getAutoplay() {
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

    public final /* synthetic */ boolean getLoop() {
        return this.loop;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ MaskShape getMaskShape() {
        return this.maskShape;
    }

    public final /* synthetic */ boolean getMuteAudio() {
        return this.muteAudio;
    }

    /* JADX INFO: renamed from: getOverrideSourceLid-sa7TU9Q, reason: not valid java name and from getter */
    public final /* synthetic */ String getOverrideSourceLid() {
        return this.overrideSourceLid;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Shadow getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ boolean getShowControls() {
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
        int iHashCode = this.source.hashCode() * 31;
        ThemeImageUrls themeImageUrls = this.fallbackSource;
        int iHashCode2 = (iHashCode + (themeImageUrls == null ? 0 : themeImageUrls.hashCode())) * 31;
        Boolean bool = this.visible;
        int iHashCode3 = (((((((((((((iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + Boolean.hashCode(this.showControls)) * 31) + Boolean.hashCode(this.autoplay)) * 31) + Boolean.hashCode(this.loop)) * 31) + Boolean.hashCode(this.muteAudio)) * 31) + this.size.hashCode()) * 31) + this.fitMode.hashCode()) * 31;
        MaskShape maskShape = this.maskShape;
        int iHashCode4 = (iHashCode3 + (maskShape == null ? 0 : maskShape.hashCode())) * 31;
        ColorScheme colorScheme = this.colorOverlay;
        int iHashCode5 = (iHashCode4 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode6 = (iHashCode5 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode7 = (iHashCode6 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Border border = this.border;
        int iHashCode8 = (iHashCode7 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode9 = (iHashCode8 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        List<ComponentOverride<PartialVideoComponent>> list = this.overrides;
        int iHashCode10 = (iHashCode9 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.overrideSourceLid;
        return iHashCode10 + (str != null ? LocalizationKey.m10432hashCodeimpl(str) : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoComponent(source=");
        sb.append(this.source).append(", fallbackSource=").append(this.fallbackSource).append(", visible=").append(this.visible).append(", showControls=").append(this.showControls).append(", autoplay=").append(this.autoplay).append(", loop=").append(this.loop).append(", muteAudio=").append(this.muteAudio).append(", size=").append(this.size).append(", fitMode=").append(this.fitMode).append(", maskShape=").append(this.maskShape).append(", colorOverlay=").append(this.colorOverlay).append(", padding=");
        StringBuilder sbAppend = sb.append(this.padding).append(", margin=").append(this.margin).append(", border=").append(this.border).append(", shadow=").append(this.shadow).append(", overrides=").append(this.overrides).append(", overrideSourceLid=");
        String str = this.overrideSourceLid;
        sbAppend.append((Object) (str == null ? AbstractJsonLexerKt.NULL : LocalizationKey.m10433toStringimpl(str))).append(')');
        return sb.toString();
    }
}
