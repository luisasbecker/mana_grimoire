package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
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
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignmentDeserializer;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: CarouselComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 U2\u00020\u0001:\u0002TUBÇ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"BÅ\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010#J&\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RHÁ\u0001¢\u0006\u0002\bSR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00102\u0012\u0004\b/\u0010%\u001a\u0004\b0\u00101R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010%\u001a\u0004\b:\u0010;R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010%\u001a\u0004\b=\u0010>R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00102\u0012\u0004\b?\u0010%\u001a\u0004\b@\u00101R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010D\u0012\u0004\bA\u0010%\u001a\u0004\bB\u0010CR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00105\u001a\u0004\bK\u00104¨\u0006V"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "seen1", "", "visible", "", "initialPageIndex", "pageAlignment", "Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "pagePeek", "pageSpacing", "", "backgroundColor", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "background", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "shadow", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "pageControl", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "loop", "autoAdvance", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Integer;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Integer;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;)V", "getAutoAdvance$annotations", "()V", "getAutoAdvance", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "getBackground", "()Lcom/revenuecat/purchases/paywalls/components/common/Background;", "getBackgroundColor$annotations", "getBackgroundColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getBorder", "()Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "getInitialPageIndex$annotations", "getInitialPageIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLoop", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getPadding", "getPageAlignment$annotations", "getPageAlignment", "()Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;", "getPageControl$annotations", "getPageControl", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "getPagePeek$annotations", "getPagePeek", "getPageSpacing$annotations", "getPageSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getShadow", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getVisible", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class PartialCarouselComponent implements PartialComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CarouselComponent.AutoAdvancePages autoAdvance;
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Border border;
    private final Integer initialPageIndex;
    private final Boolean loop;
    private final Padding margin;
    private final Padding padding;
    private final VerticalAlignment pageAlignment;
    private final CarouselComponent.PageControl pageControl;
    private final Integer pagePeek;
    private final Float pageSpacing;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Boolean visible;

    /* JADX INFO: compiled from: CarouselComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialCarouselComponent> serializer() {
            return PartialCarouselComponent$$serializer.INSTANCE;
        }
    }

    public PartialCarouselComponent() {
        this((Boolean) null, (Integer) null, (VerticalAlignment) null, (Size) null, (Integer) null, (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (CarouselComponent.PageControl) null, (Boolean) null, (CarouselComponent.AutoAdvancePages) null, 65535, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PartialCarouselComponent(int i, Boolean bool, @SerialName("initial_page_index") Integer num, @SerialName("page_alignment") VerticalAlignment verticalAlignment, Size size, @SerialName("page_peek") Integer num2, @SerialName("page_spacing") Float f, @SerialName("background_color") ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, @SerialName("page_control") CarouselComponent.PageControl pageControl, Boolean bool2, @SerialName("auto_advance") CarouselComponent.AutoAdvancePages autoAdvancePages, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i & 2) == 0) {
            this.initialPageIndex = null;
        } else {
            this.initialPageIndex = num;
        }
        if ((i & 4) == 0) {
            this.pageAlignment = null;
        } else {
            this.pageAlignment = verticalAlignment;
        }
        if ((i & 8) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i & 16) == 0) {
            this.pagePeek = null;
        } else {
            this.pagePeek = num2;
        }
        if ((i & 32) == 0) {
            this.pageSpacing = null;
        } else {
            this.pageSpacing = f;
        }
        if ((i & 64) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i & 128) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i & 256) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i & 512) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
        if ((i & 1024) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i & 2048) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i & 4096) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i & 8192) == 0) {
            this.pageControl = null;
        } else {
            this.pageControl = pageControl;
        }
        if ((i & 16384) == 0) {
            this.loop = null;
        } else {
            this.loop = bool2;
        }
        if ((i & 32768) == 0) {
            this.autoAdvance = null;
        } else {
            this.autoAdvance = autoAdvancePages;
        }
    }

    public PartialCarouselComponent(Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, CarouselComponent.PageControl pageControl, Boolean bool2, CarouselComponent.AutoAdvancePages autoAdvancePages) {
        this.visible = bool;
        this.initialPageIndex = num;
        this.pageAlignment = verticalAlignment;
        this.size = size;
        this.pagePeek = num2;
        this.pageSpacing = f;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = padding2;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.pageControl = pageControl;
        this.loop = bool2;
        this.autoAdvance = autoAdvancePages;
    }

    public /* synthetic */ PartialCarouselComponent(Boolean bool, Integer num, VerticalAlignment verticalAlignment, Size size, Integer num2, Float f, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, CarouselComponent.PageControl pageControl, Boolean bool2, CarouselComponent.AutoAdvancePages autoAdvancePages, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : verticalAlignment, (i & 8) != 0 ? null : size, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : f, (i & 64) != 0 ? null : colorScheme, (i & 128) != 0 ? null : background, (i & 256) != 0 ? null : padding, (i & 512) != 0 ? null : padding2, (i & 1024) != 0 ? null : shape, (i & 2048) != 0 ? null : border, (i & 4096) != 0 ? null : shadow, (i & 8192) != 0 ? null : pageControl, (i & 16384) != 0 ? null : bool2, (i & 32768) != 0 ? null : autoAdvancePages);
    }

    @SerialName("auto_advance")
    public static /* synthetic */ void getAutoAdvance$annotations() {
    }

    @SerialName("background_color")
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @SerialName("initial_page_index")
    public static /* synthetic */ void getInitialPageIndex$annotations() {
    }

    @SerialName("page_alignment")
    public static /* synthetic */ void getPageAlignment$annotations() {
    }

    @SerialName("page_control")
    public static /* synthetic */ void getPageControl$annotations() {
    }

    @SerialName("page_peek")
    public static /* synthetic */ void getPagePeek$annotations() {
    }

    @SerialName("page_spacing")
    public static /* synthetic */ void getPageSpacing$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialCarouselComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.visible != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.initialPageIndex != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.initialPageIndex);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.pageAlignment != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, VerticalAlignmentDeserializer.INSTANCE, self.pageAlignment);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, Size$$serializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.pagePeek != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.pagePeek);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.pageSpacing != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, FloatSerializer.INSTANCE, self.pageSpacing);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, ColorScheme$$serializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.background != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, BackgroundDeserializer.INSTANCE, self.background);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.padding != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, Padding$$serializer.INSTANCE, self.padding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.margin != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, Padding$$serializer.INSTANCE, self.margin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.shape != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, ShapeDeserializer.INSTANCE, self.shape);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.border != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, Border$$serializer.INSTANCE, self.border);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.shadow != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, Shadow$$serializer.INSTANCE, self.shadow);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.pageControl != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, CarouselComponent$PageControl$$serializer.INSTANCE, self.pageControl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.loop != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, BooleanSerializer.INSTANCE, self.loop);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 15) && self.autoAdvance == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, self.autoAdvance);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialCarouselComponent)) {
            return false;
        }
        PartialCarouselComponent partialCarouselComponent = (PartialCarouselComponent) obj;
        return Intrinsics.areEqual(this.visible, partialCarouselComponent.visible) && Intrinsics.areEqual(this.initialPageIndex, partialCarouselComponent.initialPageIndex) && this.pageAlignment == partialCarouselComponent.pageAlignment && Intrinsics.areEqual(this.size, partialCarouselComponent.size) && Intrinsics.areEqual(this.pagePeek, partialCarouselComponent.pagePeek) && Intrinsics.areEqual((Object) this.pageSpacing, (Object) partialCarouselComponent.pageSpacing) && Intrinsics.areEqual(this.backgroundColor, partialCarouselComponent.backgroundColor) && Intrinsics.areEqual(this.background, partialCarouselComponent.background) && Intrinsics.areEqual(this.padding, partialCarouselComponent.padding) && Intrinsics.areEqual(this.margin, partialCarouselComponent.margin) && Intrinsics.areEqual(this.shape, partialCarouselComponent.shape) && Intrinsics.areEqual(this.border, partialCarouselComponent.border) && Intrinsics.areEqual(this.shadow, partialCarouselComponent.shadow) && Intrinsics.areEqual(this.pageControl, partialCarouselComponent.pageControl) && Intrinsics.areEqual(this.loop, partialCarouselComponent.loop) && Intrinsics.areEqual(this.autoAdvance, partialCarouselComponent.autoAdvance);
    }

    public final /* synthetic */ CarouselComponent.AutoAdvancePages getAutoAdvance() {
        return this.autoAdvance;
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ Integer getInitialPageIndex() {
        return this.initialPageIndex;
    }

    public final /* synthetic */ Boolean getLoop() {
        return this.loop;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ VerticalAlignment getPageAlignment() {
        return this.pageAlignment;
    }

    public final /* synthetic */ CarouselComponent.PageControl getPageControl() {
        return this.pageControl;
    }

    public final /* synthetic */ Integer getPagePeek() {
        return this.pagePeek;
    }

    public final /* synthetic */ Float getPageSpacing() {
        return this.pageSpacing;
    }

    public final /* synthetic */ Shadow getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.initialPageIndex;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        VerticalAlignment verticalAlignment = this.pageAlignment;
        int iHashCode3 = (iHashCode2 + (verticalAlignment == null ? 0 : verticalAlignment.hashCode())) * 31;
        Size size = this.size;
        int iHashCode4 = (iHashCode3 + (size == null ? 0 : size.hashCode())) * 31;
        Integer num2 = this.pagePeek;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f = this.pageSpacing;
        int iHashCode6 = (iHashCode5 + (f == null ? 0 : f.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode7 = (iHashCode6 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode8 = (iHashCode7 + (background == null ? 0 : background.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode9 = (iHashCode8 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode10 = (iHashCode9 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Shape shape = this.shape;
        int iHashCode11 = (iHashCode10 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode12 = (iHashCode11 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode13 = (iHashCode12 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        CarouselComponent.PageControl pageControl = this.pageControl;
        int iHashCode14 = (iHashCode13 + (pageControl == null ? 0 : pageControl.hashCode())) * 31;
        Boolean bool2 = this.loop;
        int iHashCode15 = (iHashCode14 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        CarouselComponent.AutoAdvancePages autoAdvancePages = this.autoAdvance;
        return iHashCode15 + (autoAdvancePages != null ? autoAdvancePages.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PartialCarouselComponent(visible=");
        sb.append(this.visible).append(", initialPageIndex=").append(this.initialPageIndex).append(", pageAlignment=").append(this.pageAlignment).append(", size=").append(this.size).append(", pagePeek=").append(this.pagePeek).append(", pageSpacing=").append(this.pageSpacing).append(", backgroundColor=").append(this.backgroundColor).append(", background=").append(this.background).append(", padding=").append(this.padding).append(", margin=").append(this.margin).append(", shape=").append(this.shape).append(", border=");
        sb.append(this.border).append(", shadow=").append(this.shadow).append(", pageControl=").append(this.pageControl).append(", loop=").append(this.loop).append(", autoAdvance=").append(this.autoAdvance).append(')');
        return sb.toString();
    }
}
