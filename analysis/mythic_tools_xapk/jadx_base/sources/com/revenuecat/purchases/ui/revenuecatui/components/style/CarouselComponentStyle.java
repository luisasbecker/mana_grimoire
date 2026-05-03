package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedCarouselPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CarouselComponentStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002tuBÕ\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0004¢\u0006\u0002\u0010+J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010U\u001a\u00020\u0014HÆ\u0003J\t\u0010V\u001a\u00020\u0017HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\t\u0010Z\u001a\u00020\u000bHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010$HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010QJ\t\u0010_\u001a\u00020\u0007HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010'HÆ\u0003J\u0015\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0004HÆ\u0003J\t\u0010b\u001a\u00020\tHÆ\u0003J\t\u0010c\u001a\u00020\u000bHÆ\u0003J\t\u0010d\u001a\u00020\rHÆ\u0003J\u0016\u0010e\u001a\u00020\u000fHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010BJ\u0016\u0010g\u001a\u00020\u000fHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010BJ\u000b\u0010i\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010j\u001a\u00020\u0014HÆ\u0003J\u0089\u0002\u0010k\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\u0014\b\u0002\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0004HÆ\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ\u0013\u0010n\u001a\u00020\u000b2\b\u0010o\u001a\u0004\u0018\u00010pHÖ\u0003J\t\u0010q\u001a\u00020\u0007HÖ\u0001J\t\u0010r\u001a\u00020sHÖ\u0001R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u001e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0016\u0010&\u001a\u0004\u0018\u00010'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b<\u00107R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0019\u0010\u0010\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010C\u001a\u0004\bD\u0010BR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010;R\u0016\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0016\u0010#\u001a\u0004\u0018\u00010$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0018\u0010%\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010R\u001a\u0004\bP\u0010QR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u00105\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006v"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", "pages", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "initialPageIndex", "", "pageAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "pagePeek", "Landroidx/compose/ui/unit/Dp;", "pageSpacing", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "pageControl", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "loop", "autoAdvance", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "tabIndex", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "overrides", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedCarouselPartial;", "(Ljava/util/List;ILandroidx/compose/ui/Alignment$Vertical;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;FFLcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;ZLcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoAdvance", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getInitialPageIndex", "()I", "getLoop", "()Z", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOverrides", "()Ljava/util/List;", "getPadding", "getPageAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "getPageControl", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "getPagePeek-D9Ej5fM", "()F", "F", "getPageSpacing-D9Ej5fM", "getPages", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVisible", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component6-D9Ej5fM", "component7", "component7-D9Ej5fM", "component8", "component9", "copy", "copy-aesFJdY", "(Ljava/util/List;ILandroidx/compose/ui/Alignment$Vertical;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;FFLcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;ZLcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/List;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "IndicatorStyles", "PageControlStyles", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CarouselComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final CarouselComponent.AutoAdvancePages autoAdvance;
    private final BackgroundStyles background;
    private final BorderStyles border;
    private final int initialPageIndex;
    private final boolean loop;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedCarouselPartial>> overrides;
    private final PaddingValues padding;
    private final Alignment.Vertical pageAlignment;
    private final PageControlStyles pageControl;
    private final float pagePeek;
    private final float pageSpacing;
    private final List<StackComponentStyle> pages;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final Size size;
    private final Integer tabIndex;
    private final boolean visible;

    /* JADX INFO: compiled from: CarouselComponentStyle.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u0013\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\rJ\u0016\u0010\u0015\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\rJ\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001aJI\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\b\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$IndicatorStyles;", "", "width", "Landroidx/compose/ui/unit/Dp;", "height", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "strokeColor", "strokeWidth", "(FFLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Landroidx/compose/ui/unit/Dp;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getHeight-D9Ej5fM", "()F", "F", "getStrokeColor", "getStrokeWidth-lTKBWiU", "()Landroidx/compose/ui/unit/Dp;", "getWidth-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component4", "component5", "component5-lTKBWiU", "copy", "copy-EwDJqH8", "(FFLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Landroidx/compose/ui/unit/Dp;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$IndicatorStyles;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class IndicatorStyles {
        public static final int $stable = 0;
        private final ColorStyles color;
        private final float height;
        private final ColorStyles strokeColor;
        private final Dp strokeWidth;
        private final float width;

        private IndicatorStyles(float f, float f2, ColorStyles color, ColorStyles colorStyles, Dp dp) {
            Intrinsics.checkNotNullParameter(color, "color");
            this.width = f;
            this.height = f2;
            this.color = color;
            this.strokeColor = colorStyles;
            this.strokeWidth = dp;
        }

        public /* synthetic */ IndicatorStyles(float f, float f2, ColorStyles colorStyles, ColorStyles colorStyles2, Dp dp, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, colorStyles, colorStyles2, dp);
        }

        /* JADX INFO: renamed from: copy-EwDJqH8$default, reason: not valid java name */
        public static /* synthetic */ IndicatorStyles m10577copyEwDJqH8$default(IndicatorStyles indicatorStyles, float f, float f2, ColorStyles colorStyles, ColorStyles colorStyles2, Dp dp, int i, Object obj) {
            if ((i & 1) != 0) {
                f = indicatorStyles.width;
            }
            if ((i & 2) != 0) {
                f2 = indicatorStyles.height;
            }
            if ((i & 4) != 0) {
                colorStyles = indicatorStyles.color;
            }
            if ((i & 8) != 0) {
                colorStyles2 = indicatorStyles.strokeColor;
            }
            if ((i & 16) != 0) {
                dp = indicatorStyles.strokeWidth;
            }
            Dp dp2 = dp;
            ColorStyles colorStyles3 = colorStyles;
            return indicatorStyles.m10581copyEwDJqH8(f, f2, colorStyles3, colorStyles2, dp2);
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
        public final float getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
        public final float getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ColorStyles getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ColorStyles getStrokeColor() {
            return this.strokeColor;
        }

        /* JADX INFO: renamed from: component5-lTKBWiU, reason: not valid java name and from getter */
        public final Dp getStrokeWidth() {
            return this.strokeWidth;
        }

        /* JADX INFO: renamed from: copy-EwDJqH8, reason: not valid java name */
        public final IndicatorStyles m10581copyEwDJqH8(float width, float height, ColorStyles color, ColorStyles strokeColor, Dp strokeWidth) {
            Intrinsics.checkNotNullParameter(color, "color");
            return new IndicatorStyles(width, height, color, strokeColor, strokeWidth, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IndicatorStyles)) {
                return false;
            }
            IndicatorStyles indicatorStyles = (IndicatorStyles) other;
            return Dp.m9119equalsimpl0(this.width, indicatorStyles.width) && Dp.m9119equalsimpl0(this.height, indicatorStyles.height) && Intrinsics.areEqual(this.color, indicatorStyles.color) && Intrinsics.areEqual(this.strokeColor, indicatorStyles.strokeColor) && Intrinsics.areEqual(this.strokeWidth, indicatorStyles.strokeWidth);
        }

        public final /* synthetic */ ColorStyles getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
        public final /* synthetic */ float m10582getHeightD9Ej5fM() {
            return this.height;
        }

        public final /* synthetic */ ColorStyles getStrokeColor() {
            return this.strokeColor;
        }

        /* JADX INFO: renamed from: getStrokeWidth-lTKBWiU, reason: not valid java name */
        public final /* synthetic */ Dp m10583getStrokeWidthlTKBWiU() {
            return this.strokeWidth;
        }

        /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
        public final /* synthetic */ float m10584getWidthD9Ej5fM() {
            return this.width;
        }

        public int hashCode() {
            int iM9120hashCodeimpl = ((((Dp.m9120hashCodeimpl(this.width) * 31) + Dp.m9120hashCodeimpl(this.height)) * 31) + this.color.hashCode()) * 31;
            ColorStyles colorStyles = this.strokeColor;
            int iHashCode = (iM9120hashCodeimpl + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31;
            Dp dp = this.strokeWidth;
            return iHashCode + (dp != null ? Dp.m9120hashCodeimpl(dp.m9128unboximpl()) : 0);
        }

        public String toString() {
            return "IndicatorStyles(width=" + ((Object) Dp.m9125toStringimpl(this.width)) + ", height=" + ((Object) Dp.m9125toStringimpl(this.height)) + ", color=" + this.color + ", strokeColor=" + this.strokeColor + ", strokeWidth=" + this.strokeWidth + ')';
        }
    }

    /* JADX INFO: compiled from: CarouselComponentStyle.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0012HÆ\u0003J\u0016\u0010*\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010&J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00102\u001a\u00020\u0012HÆ\u0003J}\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "", "position", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;", "spacing", "Landroidx/compose/ui/unit/Dp;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "backgroundColor", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$IndicatorStyles;", "default", "(Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$IndicatorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$IndicatorStyles;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActive", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$IndicatorStyles;", "getBackgroundColor", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getDefault", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "getPadding", "getPosition", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getSpacing-D9Ej5fM", "()F", "F", "component1", "component10", "component2", "component2-D9Ej5fM", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy-jfnsLPA", "(Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$IndicatorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$IndicatorStyles;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PageControlStyles {
        public static final int $stable = 0;
        private final IndicatorStyles active;
        private final ColorStyles backgroundColor;
        private final BorderStyles border;
        private final IndicatorStyles default;
        private final PaddingValues margin;
        private final PaddingValues padding;
        private final CarouselComponent.PageControl.Position position;
        private final ShadowStyles shadow;
        private final Shape shape;
        private final float spacing;

        private PageControlStyles(CarouselComponent.PageControl.Position position, float f, PaddingValues padding, PaddingValues margin, ColorStyles colorStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, IndicatorStyles active, IndicatorStyles indicatorStyles) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(shape, "shape");
            Intrinsics.checkNotNullParameter(active, "active");
            Intrinsics.checkNotNullParameter(indicatorStyles, "default");
            this.position = position;
            this.spacing = f;
            this.padding = padding;
            this.margin = margin;
            this.backgroundColor = colorStyles;
            this.shape = shape;
            this.border = borderStyles;
            this.shadow = shadowStyles;
            this.active = active;
            this.default = indicatorStyles;
        }

        public /* synthetic */ PageControlStyles(CarouselComponent.PageControl.Position position, float f, PaddingValues paddingValues, PaddingValues paddingValues2, ColorStyles colorStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, IndicatorStyles indicatorStyles, IndicatorStyles indicatorStyles2, DefaultConstructorMarker defaultConstructorMarker) {
            this(position, f, paddingValues, paddingValues2, colorStyles, shape, borderStyles, shadowStyles, indicatorStyles, indicatorStyles2);
        }

        /* JADX INFO: renamed from: copy-jfnsLPA$default, reason: not valid java name */
        public static /* synthetic */ PageControlStyles m10585copyjfnsLPA$default(PageControlStyles pageControlStyles, CarouselComponent.PageControl.Position position, float f, PaddingValues paddingValues, PaddingValues paddingValues2, ColorStyles colorStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, IndicatorStyles indicatorStyles, IndicatorStyles indicatorStyles2, int i, Object obj) {
            if ((i & 1) != 0) {
                position = pageControlStyles.position;
            }
            if ((i & 2) != 0) {
                f = pageControlStyles.spacing;
            }
            if ((i & 4) != 0) {
                paddingValues = pageControlStyles.padding;
            }
            if ((i & 8) != 0) {
                paddingValues2 = pageControlStyles.margin;
            }
            if ((i & 16) != 0) {
                colorStyles = pageControlStyles.backgroundColor;
            }
            if ((i & 32) != 0) {
                shape = pageControlStyles.shape;
            }
            if ((i & 64) != 0) {
                borderStyles = pageControlStyles.border;
            }
            if ((i & 128) != 0) {
                shadowStyles = pageControlStyles.shadow;
            }
            if ((i & 256) != 0) {
                indicatorStyles = pageControlStyles.active;
            }
            if ((i & 512) != 0) {
                indicatorStyles2 = pageControlStyles.default;
            }
            IndicatorStyles indicatorStyles3 = indicatorStyles;
            IndicatorStyles indicatorStyles4 = indicatorStyles2;
            BorderStyles borderStyles2 = borderStyles;
            ShadowStyles shadowStyles2 = shadowStyles;
            ColorStyles colorStyles2 = colorStyles;
            Shape shape2 = shape;
            return pageControlStyles.m10587copyjfnsLPA(position, f, paddingValues, paddingValues2, colorStyles2, shape2, borderStyles2, shadowStyles2, indicatorStyles3, indicatorStyles4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CarouselComponent.PageControl.Position getPosition() {
            return this.position;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final IndicatorStyles getDefault() {
            return this.default;
        }

        /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
        public final float getSpacing() {
            return this.spacing;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PaddingValues getPadding() {
            return this.padding;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final PaddingValues getMargin() {
            return this.margin;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ColorStyles getBackgroundColor() {
            return this.backgroundColor;
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
        public final IndicatorStyles getActive() {
            return this.active;
        }

        /* JADX INFO: renamed from: copy-jfnsLPA, reason: not valid java name */
        public final PageControlStyles m10587copyjfnsLPA(CarouselComponent.PageControl.Position position, float spacing, PaddingValues padding, PaddingValues margin, ColorStyles backgroundColor, Shape shape, BorderStyles border, ShadowStyles shadow, IndicatorStyles active, IndicatorStyles indicatorStyles) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(shape, "shape");
            Intrinsics.checkNotNullParameter(active, "active");
            Intrinsics.checkNotNullParameter(indicatorStyles, "default");
            return new PageControlStyles(position, spacing, padding, margin, backgroundColor, shape, border, shadow, active, indicatorStyles, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageControlStyles)) {
                return false;
            }
            PageControlStyles pageControlStyles = (PageControlStyles) other;
            return this.position == pageControlStyles.position && Dp.m9119equalsimpl0(this.spacing, pageControlStyles.spacing) && Intrinsics.areEqual(this.padding, pageControlStyles.padding) && Intrinsics.areEqual(this.margin, pageControlStyles.margin) && Intrinsics.areEqual(this.backgroundColor, pageControlStyles.backgroundColor) && Intrinsics.areEqual(this.shape, pageControlStyles.shape) && Intrinsics.areEqual(this.border, pageControlStyles.border) && Intrinsics.areEqual(this.shadow, pageControlStyles.shadow) && Intrinsics.areEqual(this.active, pageControlStyles.active) && Intrinsics.areEqual(this.default, pageControlStyles.default);
        }

        public final /* synthetic */ IndicatorStyles getActive() {
            return this.active;
        }

        public final /* synthetic */ ColorStyles getBackgroundColor() {
            return this.backgroundColor;
        }

        public final /* synthetic */ BorderStyles getBorder() {
            return this.border;
        }

        public final /* synthetic */ IndicatorStyles getDefault() {
            return this.default;
        }

        public final /* synthetic */ PaddingValues getMargin() {
            return this.margin;
        }

        public final /* synthetic */ PaddingValues getPadding() {
            return this.padding;
        }

        public final /* synthetic */ CarouselComponent.PageControl.Position getPosition() {
            return this.position;
        }

        public final /* synthetic */ ShadowStyles getShadow() {
            return this.shadow;
        }

        public final /* synthetic */ Shape getShape() {
            return this.shape;
        }

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
        public final /* synthetic */ float m10588getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public int hashCode() {
            int iHashCode = ((((((this.position.hashCode() * 31) + Dp.m9120hashCodeimpl(this.spacing)) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
            ColorStyles colorStyles = this.backgroundColor;
            int iHashCode2 = (((iHashCode + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31) + this.shape.hashCode()) * 31;
            BorderStyles borderStyles = this.border;
            int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
            ShadowStyles shadowStyles = this.shadow;
            return ((((iHashCode3 + (shadowStyles != null ? shadowStyles.hashCode() : 0)) * 31) + this.active.hashCode()) * 31) + this.default.hashCode();
        }

        public String toString() {
            return "PageControlStyles(position=" + this.position + ", spacing=" + ((Object) Dp.m9125toStringimpl(this.spacing)) + ", padding=" + this.padding + ", margin=" + this.margin + ", backgroundColor=" + this.backgroundColor + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", active=" + this.active + ", default=" + this.default + ')';
        }
    }

    private CarouselComponentStyle(List<StackComponentStyle> pages, int i, Alignment.Vertical pageAlignment, boolean z, Size size, float f, float f2, BackgroundStyles backgroundStyles, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, PageControlStyles pageControlStyles, boolean z2, CarouselComponent.AutoAdvancePages autoAdvancePages, Package r19, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedCarouselPartial>> overrides) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(pageAlignment, "pageAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.pages = pages;
        this.initialPageIndex = i;
        this.pageAlignment = pageAlignment;
        this.visible = z;
        this.size = size;
        this.pagePeek = f;
        this.pageSpacing = f2;
        this.background = backgroundStyles;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.pageControl = pageControlStyles;
        this.loop = z2;
        this.autoAdvance = autoAdvancePages;
        this.rcPackage = r19;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.overrides = overrides;
    }

    public /* synthetic */ CarouselComponentStyle(List list, int i, Alignment.Vertical vertical, boolean z, Size size, float f, float f2, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, PageControlStyles pageControlStyles, boolean z2, CarouselComponent.AutoAdvancePages autoAdvancePages, Package r42, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, vertical, z, size, f, f2, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, pageControlStyles, z2, autoAdvancePages, r42, (i2 & 131072) != 0 ? null : resolvedOffer, num, (i2 & 524288) != 0 ? null : offerEligibility, list2, null);
    }

    public /* synthetic */ CarouselComponentStyle(List list, int i, Alignment.Vertical vertical, boolean z, Size size, float f, float f2, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, PageControlStyles pageControlStyles, boolean z2, CarouselComponent.AutoAdvancePages autoAdvancePages, Package r17, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, vertical, z, size, f, f2, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, pageControlStyles, z2, autoAdvancePages, r17, resolvedOffer, num, offerEligibility, list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-aesFJdY$default, reason: not valid java name */
    public static /* synthetic */ CarouselComponentStyle m10571copyaesFJdY$default(CarouselComponentStyle carouselComponentStyle, List list, int i, Alignment.Vertical vertical, boolean z, Size size, float f, float f2, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, PageControlStyles pageControlStyles, boolean z2, CarouselComponent.AutoAdvancePages autoAdvancePages, Package r34, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list2, int i2, Object obj) {
        List list3;
        OfferEligibility offerEligibility2;
        List list4 = (i2 & 1) != 0 ? carouselComponentStyle.pages : list;
        int i3 = (i2 & 2) != 0 ? carouselComponentStyle.initialPageIndex : i;
        Alignment.Vertical vertical2 = (i2 & 4) != 0 ? carouselComponentStyle.pageAlignment : vertical;
        boolean z3 = (i2 & 8) != 0 ? carouselComponentStyle.visible : z;
        Size size2 = (i2 & 16) != 0 ? carouselComponentStyle.size : size;
        float f3 = (i2 & 32) != 0 ? carouselComponentStyle.pagePeek : f;
        float f4 = (i2 & 64) != 0 ? carouselComponentStyle.pageSpacing : f2;
        BackgroundStyles backgroundStyles2 = (i2 & 128) != 0 ? carouselComponentStyle.background : backgroundStyles;
        PaddingValues paddingValues3 = (i2 & 256) != 0 ? carouselComponentStyle.padding : paddingValues;
        PaddingValues paddingValues4 = (i2 & 512) != 0 ? carouselComponentStyle.margin : paddingValues2;
        Shape shape2 = (i2 & 1024) != 0 ? carouselComponentStyle.shape : shape;
        BorderStyles borderStyles2 = (i2 & 2048) != 0 ? carouselComponentStyle.border : borderStyles;
        ShadowStyles shadowStyles2 = (i2 & 4096) != 0 ? carouselComponentStyle.shadow : shadowStyles;
        PageControlStyles pageControlStyles2 = (i2 & 8192) != 0 ? carouselComponentStyle.pageControl : pageControlStyles;
        List list5 = list4;
        boolean z4 = (i2 & 16384) != 0 ? carouselComponentStyle.loop : z2;
        CarouselComponent.AutoAdvancePages autoAdvancePages2 = (i2 & 32768) != 0 ? carouselComponentStyle.autoAdvance : autoAdvancePages;
        Package r20 = (i2 & 65536) != 0 ? carouselComponentStyle.rcPackage : r34;
        ResolvedOffer resolvedOffer2 = (i2 & 131072) != 0 ? carouselComponentStyle.resolvedOffer : resolvedOffer;
        Integer num2 = (i2 & 262144) != 0 ? carouselComponentStyle.tabIndex : num;
        OfferEligibility offerEligibility3 = (i2 & 524288) != 0 ? carouselComponentStyle.offerEligibility : offerEligibility;
        if ((i2 & 1048576) != 0) {
            offerEligibility2 = offerEligibility3;
            list3 = carouselComponentStyle.overrides;
        } else {
            list3 = list2;
            offerEligibility2 = offerEligibility3;
        }
        return carouselComponentStyle.m10574copyaesFJdY(list5, i3, vertical2, z3, size2, f3, f4, backgroundStyles2, paddingValues3, paddingValues4, shape2, borderStyles2, shadowStyles2, pageControlStyles2, z4, autoAdvancePages2, r20, resolvedOffer2, num2, offerEligibility2, list3);
    }

    public final List<StackComponentStyle> component1() {
        return this.pages;
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
    public final PageControlStyles getPageControl() {
        return this.pageControl;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getLoop() {
        return this.loop;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final CarouselComponent.AutoAdvancePages getAutoAdvance() {
        return this.autoAdvance;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Package getRcPackage() {
        return this.rcPackage;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Integer getTabIndex() {
        return this.tabIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getInitialPageIndex() {
        return this.initialPageIndex;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final List<PresentedOverride<PresentedCarouselPartial>> component21() {
        return this.overrides;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Alignment.Vertical getPageAlignment() {
        return this.pageAlignment;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component6-D9Ej5fM, reason: not valid java name and from getter */
    public final float getPagePeek() {
        return this.pagePeek;
    }

    /* JADX INFO: renamed from: component7-D9Ej5fM, reason: not valid java name and from getter */
    public final float getPageSpacing() {
        return this.pageSpacing;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final BackgroundStyles getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final PaddingValues getPadding() {
        return this.padding;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i);
    }

    /* JADX INFO: renamed from: copy-aesFJdY, reason: not valid java name */
    public final CarouselComponentStyle m10574copyaesFJdY(List<StackComponentStyle> pages, int initialPageIndex, Alignment.Vertical pageAlignment, boolean visible, Size size, float pagePeek, float pageSpacing, BackgroundStyles background, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles border, ShadowStyles shadow, PageControlStyles pageControl, boolean loop, CarouselComponent.AutoAdvancePages autoAdvance, Package rcPackage, ResolvedOffer resolvedOffer, Integer tabIndex, OfferEligibility offerEligibility, List<PresentedOverride<PresentedCarouselPartial>> overrides) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(pageAlignment, "pageAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new CarouselComponentStyle(pages, initialPageIndex, pageAlignment, visible, size, pagePeek, pageSpacing, background, padding, margin, shape, border, shadow, pageControl, loop, autoAdvance, rcPackage, resolvedOffer, tabIndex, offerEligibility, overrides, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CarouselComponentStyle)) {
            return false;
        }
        CarouselComponentStyle carouselComponentStyle = (CarouselComponentStyle) other;
        return Intrinsics.areEqual(this.pages, carouselComponentStyle.pages) && this.initialPageIndex == carouselComponentStyle.initialPageIndex && Intrinsics.areEqual(this.pageAlignment, carouselComponentStyle.pageAlignment) && this.visible == carouselComponentStyle.visible && Intrinsics.areEqual(this.size, carouselComponentStyle.size) && Dp.m9119equalsimpl0(this.pagePeek, carouselComponentStyle.pagePeek) && Dp.m9119equalsimpl0(this.pageSpacing, carouselComponentStyle.pageSpacing) && Intrinsics.areEqual(this.background, carouselComponentStyle.background) && Intrinsics.areEqual(this.padding, carouselComponentStyle.padding) && Intrinsics.areEqual(this.margin, carouselComponentStyle.margin) && Intrinsics.areEqual(this.shape, carouselComponentStyle.shape) && Intrinsics.areEqual(this.border, carouselComponentStyle.border) && Intrinsics.areEqual(this.shadow, carouselComponentStyle.shadow) && Intrinsics.areEqual(this.pageControl, carouselComponentStyle.pageControl) && this.loop == carouselComponentStyle.loop && Intrinsics.areEqual(this.autoAdvance, carouselComponentStyle.autoAdvance) && Intrinsics.areEqual(this.rcPackage, carouselComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, carouselComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, carouselComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, carouselComponentStyle.offerEligibility) && Intrinsics.areEqual(this.overrides, carouselComponentStyle.overrides);
    }

    public final /* synthetic */ CarouselComponent.AutoAdvancePages getAutoAdvance() {
        return this.autoAdvance;
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return this.background;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ int getInitialPageIndex() {
        return this.initialPageIndex;
    }

    public final /* synthetic */ boolean getLoop() {
        return this.loop;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
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

    public final /* synthetic */ Alignment.Vertical getPageAlignment() {
        return this.pageAlignment;
    }

    public final /* synthetic */ PageControlStyles getPageControl() {
        return this.pageControl;
    }

    /* JADX INFO: renamed from: getPagePeek-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m10575getPagePeekD9Ej5fM() {
        return this.pagePeek;
    }

    /* JADX INFO: renamed from: getPageSpacing-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m10576getPageSpacingD9Ej5fM() {
        return this.pageSpacing;
    }

    public final /* synthetic */ List getPages() {
        return this.pages;
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

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.pages.hashCode() * 31) + Integer.hashCode(this.initialPageIndex)) * 31) + this.pageAlignment.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + this.size.hashCode()) * 31) + Dp.m9120hashCodeimpl(this.pagePeek)) * 31) + Dp.m9120hashCodeimpl(this.pageSpacing)) * 31;
        BackgroundStyles backgroundStyles = this.background;
        int iHashCode2 = (((((((iHashCode + (backgroundStyles == null ? 0 : backgroundStyles.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.shape.hashCode()) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        int iHashCode4 = (iHashCode3 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        PageControlStyles pageControlStyles = this.pageControl;
        int iHashCode5 = (((iHashCode4 + (pageControlStyles == null ? 0 : pageControlStyles.hashCode())) * 31) + Boolean.hashCode(this.loop)) * 31;
        CarouselComponent.AutoAdvancePages autoAdvancePages = this.autoAdvance;
        int iHashCode6 = (iHashCode5 + (autoAdvancePages == null ? 0 : autoAdvancePages.hashCode())) * 31;
        Package r1 = this.rcPackage;
        int iHashCode7 = (iHashCode6 + (r1 == null ? 0 : r1.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode8 = (iHashCode7 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return ((iHashCode9 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CarouselComponentStyle(pages=");
        sb.append(this.pages).append(", initialPageIndex=").append(this.initialPageIndex).append(", pageAlignment=").append(this.pageAlignment).append(", visible=").append(this.visible).append(", size=").append(this.size).append(", pagePeek=").append((Object) Dp.m9125toStringimpl(this.pagePeek)).append(", pageSpacing=").append((Object) Dp.m9125toStringimpl(this.pageSpacing)).append(", background=").append(this.background).append(", padding=").append(this.padding).append(", margin=").append(this.margin).append(", shape=").append(this.shape).append(", border=");
        sb.append(this.border).append(", shadow=").append(this.shadow).append(", pageControl=").append(this.pageControl).append(", loop=").append(this.loop).append(", autoAdvance=").append(this.autoAdvance).append(", rcPackage=").append(this.rcPackage).append(", resolvedOffer=").append(this.resolvedOffer).append(", tabIndex=").append(this.tabIndex).append(", offerEligibility=").append(this.offerEligibility).append(", overrides=").append(this.overrides).append(')');
        return sb.toString();
    }
}
