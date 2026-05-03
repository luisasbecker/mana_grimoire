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
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedImagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
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

/* JADX INFO: compiled from: ImageComponentStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002B³\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!\u0012\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0002\u0010%J\u0015\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u0017HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010J\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0015\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!HÆ\u0003J\t\u0010L\u001a\u00020\bHÆ\u0003J\t\u0010M\u001a\u00020\bHÆ\u0003J\t\u0010N\u001a\u00020\nHÆ\u0003J\t\u0010O\u001a\u00020\fHÆ\u0003J\t\u0010P\u001a\u00020\fHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0015HÆ\u0003JÖ\u0001\u0010U\u001a\u00020\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\b\u0002\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!2\b\b\u0002\u0010$\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\b2\b\u0010X\u001a\u0004\u0018\u00010YHÖ\u0003J\t\u0010Z\u001a\u00020\u001dHÖ\u0001J\t\u0010[\u001a\u00020\\HÖ\u0001R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010$\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u0004¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+¨\u0006]"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", "sources", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "overlay", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "tabIndex", "", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "overrides", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedImagePartial;", "ignoreTopWindowInsets", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Landroidx/compose/ui/layout/ContentScale;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/List;Z)V", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getIgnoreTopWindowInsets", "()Z", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOverlay", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getOverrides", "()Ljava/util/List;", "getPadding", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSources", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "getTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVisible", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Landroidx/compose/ui/layout/ContentScale;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/List;Z)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ImageComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final BorderStyles border;
    private final ContentScale contentScale;
    private final boolean ignoreTopWindowInsets;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final ColorStyles overlay;
    private final List<PresentedOverride<PresentedImagePartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final Size size;
    private final NonEmptyMap<LocaleId, ThemeImageUrls> sources;
    private final Integer tabIndex;
    private final boolean visible;

    public ImageComponentStyle(NonEmptyMap<LocaleId, ThemeImageUrls> sources, boolean z, Size size, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r13, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedImagePartial>> overrides, boolean z2) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.sources = sources;
        this.visible = z;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.overlay = colorStyles;
        this.contentScale = contentScale;
        this.rcPackage = r13;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.overrides = overrides;
        this.ignoreTopWindowInsets = z2;
    }

    public /* synthetic */ ImageComponentStyle(NonEmptyMap nonEmptyMap, boolean z, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r31, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, z, size, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, colorStyles, contentScale, r31, (i & 2048) != 0 ? null : resolvedOffer, num, (i & 8192) != 0 ? null : offerEligibility, list, (i & 32768) != 0 ? false : z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageComponentStyle copy$default(ImageComponentStyle imageComponentStyle, NonEmptyMap nonEmptyMap, boolean z, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r28, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list, boolean z2, int i, Object obj) {
        NonEmptyMap nonEmptyMap2 = (i & 1) != 0 ? imageComponentStyle.sources : nonEmptyMap;
        return imageComponentStyle.copy(nonEmptyMap2, (i & 2) != 0 ? imageComponentStyle.visible : z, (i & 4) != 0 ? imageComponentStyle.size : size, (i & 8) != 0 ? imageComponentStyle.padding : paddingValues, (i & 16) != 0 ? imageComponentStyle.margin : paddingValues2, (i & 32) != 0 ? imageComponentStyle.shape : shape, (i & 64) != 0 ? imageComponentStyle.border : borderStyles, (i & 128) != 0 ? imageComponentStyle.shadow : shadowStyles, (i & 256) != 0 ? imageComponentStyle.overlay : colorStyles, (i & 512) != 0 ? imageComponentStyle.contentScale : contentScale, (i & 1024) != 0 ? imageComponentStyle.rcPackage : r28, (i & 2048) != 0 ? imageComponentStyle.resolvedOffer : resolvedOffer, (i & 4096) != 0 ? imageComponentStyle.tabIndex : num, (i & 8192) != 0 ? imageComponentStyle.offerEligibility : offerEligibility, (i & 16384) != 0 ? imageComponentStyle.overrides : list, (i & 32768) != 0 ? imageComponentStyle.ignoreTopWindowInsets : z2);
    }

    public final NonEmptyMap<LocaleId, ThemeImageUrls> component1() {
        return this.sources;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Package getRcPackage() {
        return this.rcPackage;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getTabIndex() {
        return this.tabIndex;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final List<PresentedOverride<PresentedImagePartial>> component15() {
        return this.overrides;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIgnoreTopWindowInsets() {
        return this.ignoreTopWindowInsets;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PaddingValues getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PaddingValues getMargin() {
        return this.margin;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final BorderStyles getBorder() {
        return this.border;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ShadowStyles getShadow() {
        return this.shadow;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ColorStyles getOverlay() {
        return this.overlay;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i);
    }

    public final ImageComponentStyle copy(NonEmptyMap<LocaleId, ThemeImageUrls> sources, boolean visible, Size size, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles border, ShadowStyles shadow, ColorStyles overlay, ContentScale contentScale, Package rcPackage, ResolvedOffer resolvedOffer, Integer tabIndex, OfferEligibility offerEligibility, List<PresentedOverride<PresentedImagePartial>> overrides, boolean ignoreTopWindowInsets) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new ImageComponentStyle(sources, visible, size, padding, margin, shape, border, shadow, overlay, contentScale, rcPackage, resolvedOffer, tabIndex, offerEligibility, overrides, ignoreTopWindowInsets);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageComponentStyle)) {
            return false;
        }
        ImageComponentStyle imageComponentStyle = (ImageComponentStyle) other;
        return Intrinsics.areEqual(this.sources, imageComponentStyle.sources) && this.visible == imageComponentStyle.visible && Intrinsics.areEqual(this.size, imageComponentStyle.size) && Intrinsics.areEqual(this.padding, imageComponentStyle.padding) && Intrinsics.areEqual(this.margin, imageComponentStyle.margin) && Intrinsics.areEqual(this.shape, imageComponentStyle.shape) && Intrinsics.areEqual(this.border, imageComponentStyle.border) && Intrinsics.areEqual(this.shadow, imageComponentStyle.shadow) && Intrinsics.areEqual(this.overlay, imageComponentStyle.overlay) && Intrinsics.areEqual(this.contentScale, imageComponentStyle.contentScale) && Intrinsics.areEqual(this.rcPackage, imageComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, imageComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, imageComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, imageComponentStyle.offerEligibility) && Intrinsics.areEqual(this.overrides, imageComponentStyle.overrides) && this.ignoreTopWindowInsets == imageComponentStyle.ignoreTopWindowInsets;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ ContentScale getContentScale() {
        return this.contentScale;
    }

    public final /* synthetic */ boolean getIgnoreTopWindowInsets() {
        return this.ignoreTopWindowInsets;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
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
        int iHashCode = ((((((((this.sources.hashCode() * 31) + Boolean.hashCode(this.visible)) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode2 = (iHashCode + (shape == null ? 0 : shape.hashCode())) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        int iHashCode4 = (iHashCode3 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        ColorStyles colorStyles = this.overlay;
        int iHashCode5 = (((iHashCode4 + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31) + this.contentScale.hashCode()) * 31;
        Package r1 = this.rcPackage;
        int iHashCode6 = (iHashCode5 + (r1 == null ? 0 : r1.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode7 = (iHashCode6 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return ((((iHashCode8 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + this.overrides.hashCode()) * 31) + Boolean.hashCode(this.ignoreTopWindowInsets);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImageComponentStyle(sources=");
        sb.append(this.sources).append(", visible=").append(this.visible).append(", size=").append(this.size).append(", padding=").append(this.padding).append(", margin=").append(this.margin).append(", shape=").append(this.shape).append(", border=").append(this.border).append(", shadow=").append(this.shadow).append(", overlay=").append(this.overlay).append(", contentScale=").append(this.contentScale).append(", rcPackage=").append(this.rcPackage).append(", resolvedOffer=");
        sb.append(this.resolvedOffer).append(", tabIndex=").append(this.tabIndex).append(", offerEligibility=").append(this.offerEligibility).append(", overrides=").append(this.overrides).append(", ignoreTopWindowInsets=").append(this.ignoreTopWindowInsets).append(')');
        return sb.toString();
    }
}
