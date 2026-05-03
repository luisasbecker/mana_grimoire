package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedVideoPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoComponentStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002Bé\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010&\u001a\u00020\n\u0012\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(¢\u0006\u0002\u0010+J\u0015\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003J\t\u0010Q\u001a\u00020\u0012HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\t\u0010V\u001a\u00020\u001dHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010!HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0002\u0010MJ\u000b\u0010Z\u001a\u0004\u0018\u00010%HÆ\u0003J\u0017\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004HÆ\u0003J\t\u0010\\\u001a\u00020\nHÆ\u0003J\u0015\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(HÆ\u0003J\t\u0010^\u001a\u00020\nHÆ\u0003J\t\u0010_\u001a\u00020\nHÆ\u0003J\t\u0010`\u001a\u00020\nHÆ\u0003J\t\u0010a\u001a\u00020\nHÆ\u0003J\t\u0010b\u001a\u00020\u000fHÆ\u0003J\t\u0010c\u001a\u00020\nHÆ\u0003J\t\u0010d\u001a\u00020\u0012HÆ\u0003J\u0096\u0002\u0010e\u001a\u00020\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020\n2\u0014\b\u0002\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(HÆ\u0001¢\u0006\u0002\u0010fJ\u0013\u0010g\u001a\u00020\n2\b\u0010h\u001a\u0004\u0018\u00010iHÖ\u0003J\t\u0010j\u001a\u00020#HÖ\u0001J\t\u0010k\u001a\u00020lHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010&\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u0016\u0010$\u001a\u0004\u0018\u00010%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001d\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b?\u00107R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0016\u0010 \u001a\u0004\u0018\u00010!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bH\u0010-R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00103R\u0018\u0010\"\u001a\u0004\u0018\u00010#X\u0096\u0004¢\u0006\n\n\u0002\u0010N\u001a\u0004\bL\u0010MR\u0014\u0010\u0010\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010-¨\u0006m"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", "sources", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "fallbackSources", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "showControls", "", "autoplay", "loop", "muteAudio", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "visible", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "overlay", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "tabIndex", "", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "ignoreTopWindowInsets", "overrides", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedVideoPartial;", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;ZZZZLcom/revenuecat/purchases/paywalls/components/properties/Size;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Landroidx/compose/ui/layout/ContentScale;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;ZLjava/util/List;)V", "getAutoplay", "()Z", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getFallbackSources", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "getIgnoreTopWindowInsets", "getLoop", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "getMuteAudio", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOverlay", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getOverrides", "()Ljava/util/List;", "getPadding", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getShowControls", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSources", "getTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVisible", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;ZZZZLcom/revenuecat/purchases/paywalls/components/properties/Size;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Landroidx/compose/ui/layout/ContentScale;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;ZLjava/util/List;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VideoComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final boolean autoplay;
    private final BorderStyles border;
    private final ContentScale contentScale;
    private final NonEmptyMap<LocaleId, ThemeImageUrls> fallbackSources;
    private final boolean ignoreTopWindowInsets;
    private final boolean loop;
    private final PaddingValues margin;
    private final boolean muteAudio;
    private final OfferEligibility offerEligibility;
    private final ColorStyles overlay;
    private final List<PresentedOverride<PresentedVideoPartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final boolean showControls;
    private final Size size;
    private final NonEmptyMap<LocaleId, ThemeVideoUrls> sources;
    private final Integer tabIndex;
    private final boolean visible;

    public VideoComponentStyle(NonEmptyMap<LocaleId, ThemeVideoUrls> sources, NonEmptyMap<LocaleId, ThemeImageUrls> nonEmptyMap, boolean z, boolean z2, boolean z3, boolean z4, Size size, boolean z5, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r19, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z6, List<PresentedOverride<PresentedVideoPartial>> overrides) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.sources = sources;
        this.fallbackSources = nonEmptyMap;
        this.showControls = z;
        this.autoplay = z2;
        this.loop = z3;
        this.muteAudio = z4;
        this.size = size;
        this.visible = z5;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.overlay = colorStyles;
        this.contentScale = contentScale;
        this.rcPackage = r19;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.ignoreTopWindowInsets = z6;
        this.overrides = overrides;
    }

    public /* synthetic */ VideoComponentStyle(NonEmptyMap nonEmptyMap, NonEmptyMap nonEmptyMap2, boolean z, boolean z2, boolean z3, boolean z4, Size size, boolean z5, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r40, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z6, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, nonEmptyMap2, z, z2, z3, z4, size, z5, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, colorStyles, contentScale, r40, (i & 65536) != 0 ? null : resolvedOffer, num, (i & 262144) != 0 ? null : offerEligibility, (i & 524288) != 0 ? false : z6, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoComponentStyle copy$default(VideoComponentStyle videoComponentStyle, NonEmptyMap nonEmptyMap, NonEmptyMap nonEmptyMap2, boolean z, boolean z2, boolean z3, boolean z4, Size size, boolean z5, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r33, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z6, List list, int i, Object obj) {
        List list2;
        boolean z7;
        NonEmptyMap nonEmptyMap3 = (i & 1) != 0 ? videoComponentStyle.sources : nonEmptyMap;
        NonEmptyMap nonEmptyMap4 = (i & 2) != 0 ? videoComponentStyle.fallbackSources : nonEmptyMap2;
        boolean z8 = (i & 4) != 0 ? videoComponentStyle.showControls : z;
        boolean z9 = (i & 8) != 0 ? videoComponentStyle.autoplay : z2;
        boolean z10 = (i & 16) != 0 ? videoComponentStyle.loop : z3;
        boolean z11 = (i & 32) != 0 ? videoComponentStyle.muteAudio : z4;
        Size size2 = (i & 64) != 0 ? videoComponentStyle.size : size;
        boolean z12 = (i & 128) != 0 ? videoComponentStyle.visible : z5;
        PaddingValues paddingValues3 = (i & 256) != 0 ? videoComponentStyle.padding : paddingValues;
        PaddingValues paddingValues4 = (i & 512) != 0 ? videoComponentStyle.margin : paddingValues2;
        Shape shape2 = (i & 1024) != 0 ? videoComponentStyle.shape : shape;
        BorderStyles borderStyles2 = (i & 2048) != 0 ? videoComponentStyle.border : borderStyles;
        ShadowStyles shadowStyles2 = (i & 4096) != 0 ? videoComponentStyle.shadow : shadowStyles;
        ColorStyles colorStyles2 = (i & 8192) != 0 ? videoComponentStyle.overlay : colorStyles;
        NonEmptyMap nonEmptyMap5 = nonEmptyMap3;
        ContentScale contentScale2 = (i & 16384) != 0 ? videoComponentStyle.contentScale : contentScale;
        Package r19 = (i & 32768) != 0 ? videoComponentStyle.rcPackage : r33;
        ResolvedOffer resolvedOffer2 = (i & 65536) != 0 ? videoComponentStyle.resolvedOffer : resolvedOffer;
        Integer num2 = (i & 131072) != 0 ? videoComponentStyle.tabIndex : num;
        OfferEligibility offerEligibility2 = (i & 262144) != 0 ? videoComponentStyle.offerEligibility : offerEligibility;
        boolean z13 = (i & 524288) != 0 ? videoComponentStyle.ignoreTopWindowInsets : z6;
        if ((i & 1048576) != 0) {
            z7 = z13;
            list2 = videoComponentStyle.overrides;
        } else {
            list2 = list;
            z7 = z13;
        }
        return videoComponentStyle.copy(nonEmptyMap5, nonEmptyMap4, z8, z9, z10, z11, size2, z12, paddingValues3, paddingValues4, shape2, borderStyles2, shadowStyles2, colorStyles2, contentScale2, r19, resolvedOffer2, num2, offerEligibility2, z7, list2);
    }

    public final NonEmptyMap<LocaleId, ThemeVideoUrls> component1() {
        return this.sources;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final PaddingValues getMargin() {
        return this.margin;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final BorderStyles getBorder() {
        return this.border;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final ShadowStyles getShadow() {
        return this.shadow;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final ColorStyles getOverlay() {
        return this.overlay;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Package getRcPackage() {
        return this.rcPackage;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getTabIndex() {
        return this.tabIndex;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final NonEmptyMap<LocaleId, ThemeImageUrls> component2() {
        return this.fallbackSources;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getIgnoreTopWindowInsets() {
        return this.ignoreTopWindowInsets;
    }

    public final List<PresentedOverride<PresentedVideoPartial>> component21() {
        return this.overrides;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowControls() {
        return this.showControls;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getAutoplay() {
        return this.autoplay;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getLoop() {
        return this.loop;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getMuteAudio() {
        return this.muteAudio;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final PaddingValues getPadding() {
        return this.padding;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i);
    }

    public final VideoComponentStyle copy(NonEmptyMap<LocaleId, ThemeVideoUrls> sources, NonEmptyMap<LocaleId, ThemeImageUrls> fallbackSources, boolean showControls, boolean autoplay, boolean loop, boolean muteAudio, Size size, boolean visible, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles border, ShadowStyles shadow, ColorStyles overlay, ContentScale contentScale, Package rcPackage, ResolvedOffer resolvedOffer, Integer tabIndex, OfferEligibility offerEligibility, boolean ignoreTopWindowInsets, List<PresentedOverride<PresentedVideoPartial>> overrides) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new VideoComponentStyle(sources, fallbackSources, showControls, autoplay, loop, muteAudio, size, visible, padding, margin, shape, border, shadow, overlay, contentScale, rcPackage, resolvedOffer, tabIndex, offerEligibility, ignoreTopWindowInsets, overrides);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoComponentStyle)) {
            return false;
        }
        VideoComponentStyle videoComponentStyle = (VideoComponentStyle) other;
        return Intrinsics.areEqual(this.sources, videoComponentStyle.sources) && Intrinsics.areEqual(this.fallbackSources, videoComponentStyle.fallbackSources) && this.showControls == videoComponentStyle.showControls && this.autoplay == videoComponentStyle.autoplay && this.loop == videoComponentStyle.loop && this.muteAudio == videoComponentStyle.muteAudio && Intrinsics.areEqual(this.size, videoComponentStyle.size) && this.visible == videoComponentStyle.visible && Intrinsics.areEqual(this.padding, videoComponentStyle.padding) && Intrinsics.areEqual(this.margin, videoComponentStyle.margin) && Intrinsics.areEqual(this.shape, videoComponentStyle.shape) && Intrinsics.areEqual(this.border, videoComponentStyle.border) && Intrinsics.areEqual(this.shadow, videoComponentStyle.shadow) && Intrinsics.areEqual(this.overlay, videoComponentStyle.overlay) && Intrinsics.areEqual(this.contentScale, videoComponentStyle.contentScale) && Intrinsics.areEqual(this.rcPackage, videoComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, videoComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, videoComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, videoComponentStyle.offerEligibility) && this.ignoreTopWindowInsets == videoComponentStyle.ignoreTopWindowInsets && Intrinsics.areEqual(this.overrides, videoComponentStyle.overrides);
    }

    public final /* synthetic */ boolean getAutoplay() {
        return this.autoplay;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ ContentScale getContentScale() {
        return this.contentScale;
    }

    public final /* synthetic */ NonEmptyMap getFallbackSources() {
        return this.fallbackSources;
    }

    public final /* synthetic */ boolean getIgnoreTopWindowInsets() {
        return this.ignoreTopWindowInsets;
    }

    public final /* synthetic */ boolean getLoop() {
        return this.loop;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    public final /* synthetic */ boolean getMuteAudio() {
        return this.muteAudio;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final /* synthetic */ ColorStyles getOverlay() {
        return this.overlay;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public String getPackageUniqueId() {
        return PackageContext.DefaultImpls.getPackageUniqueId(this);
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return this.padding;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Package getRcPackage() {
        return this.rcPackage;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    public final /* synthetic */ ShadowStyles getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    public final /* synthetic */ boolean getShowControls() {
        return this.showControls;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ NonEmptyMap getSources() {
        return this.sources;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = this.sources.hashCode() * 31;
        NonEmptyMap<LocaleId, ThemeImageUrls> nonEmptyMap = this.fallbackSources;
        int iHashCode2 = (((((((((((((((((iHashCode + (nonEmptyMap == null ? 0 : nonEmptyMap.hashCode())) * 31) + Boolean.hashCode(this.showControls)) * 31) + Boolean.hashCode(this.autoplay)) * 31) + Boolean.hashCode(this.loop)) * 31) + Boolean.hashCode(this.muteAudio)) * 31) + this.size.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode3 = (iHashCode2 + (shape == null ? 0 : shape.hashCode())) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode4 = (iHashCode3 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        int iHashCode5 = (iHashCode4 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        ColorStyles colorStyles = this.overlay;
        int iHashCode6 = (((iHashCode5 + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31) + this.contentScale.hashCode()) * 31;
        Package r1 = this.rcPackage;
        int iHashCode7 = (iHashCode6 + (r1 == null ? 0 : r1.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode8 = (iHashCode7 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return ((((iHashCode9 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + Boolean.hashCode(this.ignoreTopWindowInsets)) * 31) + this.overrides.hashCode();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoComponentStyle(sources=");
        sb.append(this.sources).append(", fallbackSources=").append(this.fallbackSources).append(", showControls=").append(this.showControls).append(", autoplay=").append(this.autoplay).append(", loop=").append(this.loop).append(", muteAudio=").append(this.muteAudio).append(", size=").append(this.size).append(", visible=").append(this.visible).append(", padding=").append(this.padding).append(", margin=").append(this.margin).append(", shape=").append(this.shape).append(", border=");
        sb.append(this.border).append(", shadow=").append(this.shadow).append(", overlay=").append(this.overlay).append(", contentScale=").append(this.contentScale).append(", rcPackage=").append(this.rcPackage).append(", resolvedOffer=").append(this.resolvedOffer).append(", tabIndex=").append(this.tabIndex).append(", offerEligibility=").append(this.offerEligibility).append(", ignoreTopWindowInsets=").append(this.ignoreTopWindowInsets).append(", overrides=").append(this.overrides).append(')');
        return sb.toString();
    }
}
