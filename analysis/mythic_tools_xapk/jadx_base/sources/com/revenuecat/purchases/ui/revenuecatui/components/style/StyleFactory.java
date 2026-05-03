package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.FallbackHeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialIconComponent;
import com.revenuecat.purchases.paywalls.components.PartialImageComponent;
import com.revenuecat.purchases.paywalls.components.PartialPackageComponent;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.PartialTextComponent;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponent;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponentItem;
import com.revenuecat.purchases.paywalls.components.PartialVideoComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabControlButtonComponent;
import com.revenuecat.purchases.paywalls.components.TabControlComponent;
import com.revenuecat.purchases.paywalls.components.TabControlToggleComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.ui.revenuecatui.components.LocalizedTextPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedCarouselPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedIconPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedImagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPackagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedStackPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTabsPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelineItemPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelinePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedVideoPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FontKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpecKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.extensions.OverflowExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PageControlExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PromoOfferResolver;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StyleFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¤\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u0088\u00012\u00020\u0001:\u0006\u0088\u0001\u0089\u0001\u008a\u0001B\u0083\u0001\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00070\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\t\u0012\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00030\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J6\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00182\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J>\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u00182\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00152\b\b\u0002\u0010'\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u0015J0\u0010)\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u00182\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010.\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u00101\u001a\u000202H\u0002J(\u00103\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000104\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u00105\u001a\u000206H\u0002J(\u00107\u001a\u0014\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\b\u0010\u001d\u001a\u0004\u0018\u000108H\u0002J(\u00109\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020;H\u0002J&\u0010<\u001a\u0014\u0012\u0004\u0012\u00020=\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020>H\u0002J&\u0010?\u001a\u0014\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020AH\u0002J&\u0010B\u001a\u0014\u0012\u0004\u0012\u00020C\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020DH\u0002J&\u0010E\u001a\u0014\u0012\u0004\u0012\u00020F\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020GH\u0002J&\u0010H\u001a\u0014\u0012\u0004\u0012\u00020I\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020JH\u0002J(\u0010K\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010L\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020%H\u0002J(\u0010M\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010N\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020OH\u0002J&\u0010P\u001a\u0014\u0012\u0004\u0012\u00020:\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020QH\u0002J&\u0010R\u001a\u0014\u0012\u0004\u0012\u00020S\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020TH\u0002J&\u0010U\u001a\u0014\u0012\u0004\u0012\u00020V\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020WH\u0002J&\u0010X\u001a\u0014\u0012\u0004\u0012\u00020Y\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020ZH\u0002J&\u0010[\u001a\u0014\u0012\u0004\u0012\u00020\\\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020]H\u0002J&\u0010^\u001a\u0014\u0012\u0004\u0012\u00020_\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020`H\u0002J6\u0010a\u001a\u0014\u0012\u0004\u0012\u00020b\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0002J&\u0010i\u001a\u0014\u0012\u0004\u0012\u00020f\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010j\u001a\u00020kH\u0002J:\u0010l\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\f\u0010m\u001a\b\u0012\u0004\u0012\u00020d0n2\u0006\u0010e\u001a\u00020fH\u0002J&\u0010o\u001a\u0014\u0012\u0004\u0012\u00020p\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020qH\u0002J&\u0010r\u001a\u0014\u0012\u0004\u0012\u00020s\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010t\u001a\u00020uH\u0002J&\u0010v\u001a\u0014\u0012\u0004\u0012\u00020w\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020xH\u0002J&\u0010y\u001a\u0014\u0012\u0004\u0012\u00020z\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u001a0\u0018*\u0002002\u0006\u0010$\u001a\u00020{H\u0002J\u0016\u0010|\u001a\u0004\u0018\u00010}*\u00020\u00132\u0006\u0010~\u001a\u00020\u0011H\u0002JD\u0010\u007f\u001a\"\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0080\u00010\u0003\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0081\u00010\u001a0\u0018*\u00030\u0080\u00012\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001JD\u0010\u007f\u001a\"\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0085\u00010\u0003\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0086\u00010\u001a0\u0018*\u00030\u0085\u00012\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0087\u0001R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u008b\u0001"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory;", "", "localizations", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/ktx/LocalizationDictionary;", "colorAliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "fontAliases", "Lcom/revenuecat/purchases/FontAlias;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "variableLocalizations", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "", "offering", "Lcom/revenuecat/purchases/Offering;", "stripRules", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Ljava/util/Map;Ljava/util/Map;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Lcom/revenuecat/purchases/Offering;Z)V", "buttonComponentStyleUrlDestination", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Url;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingStringLocalization;", "urlLid", FirebaseAnalytics.Param.METHOD, "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "buttonComponentStyleUrlDestination-26kQY28", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "create", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleResult;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "component", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "applyTopWindowInsets", "applyBottomWindowInsets", "applyHorizontalWindowInsets", "createBackgroundStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "background", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "backgroundColor", "convertAction", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "convertDestination", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;", FirebaseAnalytics.Param.DESTINATION, "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "convertPurchaseButtonMethod", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "createButtonComponentStyleOrNull", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent;", "createCarouselComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;", "createCountdownComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CountdownComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent;", "createHeaderComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/HeaderComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/HeaderComponent;", "createIconComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/IconComponent;", "createImageComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/ImageComponent;", "createInternal", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "createPackageComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/PackageComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/PackageComponent;", "createPurchaseButtonComponentStyle", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent;", "createStackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "createStickyFooterComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StickyFooterComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/StickyFooterComponent;", "createTabControlButtonComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlButtonComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TabControlButtonComponent;", "createTabControlToggleComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlToggleComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent;", "createTabsComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent;", "createTabsComponentStyleTab", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle$Tab;", "componentTab", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent$Tab;", "control", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "tabIndex", "", "createTabsComponentStyleTabControl", "componentControl", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent$TabControl;", "createTabsComponentStyleTabs", "componentTabs", "", "createTextComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "createTimelineComponentItemStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "item", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item;", "createTimelineComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent;", "createVideoComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/VideoComponent;", "getPackageOrNull", "Lcom/revenuecat/purchases/Package;", "identifier", "withLocalizedOverrides", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingImageLocalization;", "overrideSourceLid", "withLocalizedOverrides-TDPsjl0", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingVideoLocalization;", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Companion", "StyleFactoryScope", "StyleResult", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StyleFactory {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Shape.Rectangle DEFAULT_SHAPE = new Shape.Rectangle((CornerRadiuses) (0 == true ? 1 : 0), 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    private static final float DEFAULT_SPACING = 0.0f;
    private static final boolean DEFAULT_VISIBILITY = true;
    private final Map<ColorAlias, ColorScheme> colorAliases;
    private final Map<FontAlias, FontSpec> fontAliases;
    private final NonEmptyMap<LocaleId, NonEmptyMap<LocalizationKey, LocalizationData>> localizations;
    private final Offering offering;
    private final boolean stripRules;
    private final NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations;

    /* JADX INFO: compiled from: StyleFactory.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$Companion;", "", "()V", "DEFAULT_SHAPE", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Rectangle;", "getDEFAULT_SHAPE$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Rectangle;", "DEFAULT_SPACING", "", "DEFAULT_VISIBILITY", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Shape.Rectangle getDEFAULT_SHAPE$revenuecatui_defaultsBc8Release() {
            return StyleFactory.DEFAULT_SHAPE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StyleFactory.kt */
    @Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001:\u0002xyB\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012 \b\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0002\u0010\u0013J\u000e\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020PJ\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010U\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010V\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010W\u001a\u00020\fHÆ\u0003J!\u0010X\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eHÂ\u0003J\u0015\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eHÂ\u0003J\u008c\u0001\u0010Z\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2 \b\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eHÆ\u0001¢\u0006\u0002\u0010[J\u0013\u0010\\\u001a\u00020\u00112\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\u0007HÖ\u0001J\u000e\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0010J\u0010\u0010b\u001a\u00020`2\u0006\u0010c\u001a\u00020\u0003H\u0002J\t\u0010d\u001a\u00020eHÖ\u0001JG\u0010f\u001a\b\u0012\u0004\u0012\u0002Hh0g\"\u0004\b\u0000\u0010h2\u0014\b\b\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0017\u0010j\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002Hh0\u000f¢\u0006\u0002\bkH\u0086\bø\u0001\u0000J:\u0010l\u001a\u0002Hh\"\u0004\b\u0000\u0010h2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010j\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002Hh0\u000f¢\u0006\u0002\bk¢\u0006\u0002\u0010mJ>\u0010n\u001a\u0002Hh\"\u0004\b\u0000\u0010h2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0017\u0010j\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002Hh0\u000f¢\u0006\u0002\bk¢\u0006\u0002\u0010oJ2\u0010p\u001a\u0002Hh\"\u0004\b\u0000\u0010h2\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010j\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002Hh0\u000f¢\u0006\u0002\bk¢\u0006\u0002\u0010qJ2\u0010r\u001a\u0002Hh\"\u0004\b\u0000\u0010h2\u0006\u0010\b\u001a\u00020\u00072\u0017\u0010j\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002Hh0\u000f¢\u0006\u0002\bk¢\u0006\u0002\u0010sJ!\u0010t\u001a\u0002Hh\"\b\b\u0000\u0010h*\u00020P*\u0002Hh2\u0006\u0010u\u001a\u00020\u0011¢\u0006\u0002\u0010vJ!\u0010w\u001a\u0002Hh\"\b\b\u0000\u0010h*\u00020P*\u0002Hh2\u0006\u0010u\u001a\u00020\u0011¢\u0006\u0002\u0010vR\u001b\u0010\u0014\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018*\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010'\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b(\u0010\u0018R\u001b\u0010)\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b+\u0010\u0018*\u0004\b*\u0010\u0016R\u0013\u0010,\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u00104\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b6\u00107R \u00108\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003090\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000309X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010;\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0013\u0010?\u001a\u0004\u0018\u00010@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bG\u0010#\"\u0004\bH\u0010%R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010%R\u0011\u0010K\u001a\u00020L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010N\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006z"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope;", "", "packageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "tabControl", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "tabControlIndex", "", "tabIndex", "countdownDate", "Ljava/util/Date;", "countFrom", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "countPredicates", "", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "", "countValues", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Ljava/util/Map;Ljava/util/Map;)V", "applyTopWindowInsets", "getApplyTopWindowInsets$delegate", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope;)Ljava/lang/Object;", "getApplyTopWindowInsets", "()Z", "getCountFrom", "()Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "setCountFrom", "(Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;)V", "getCountdownDate", "()Ljava/util/Date;", "setCountdownDate", "(Ljava/util/Date;)V", "defaultTabIndex", "getDefaultTabIndex", "()Ljava/lang/Integer;", "setDefaultTabIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "heroImageDetected", "getHeroImageDetected", "ignoreTopWindowInsets", "getIgnoreTopWindowInsets$delegate", "getIgnoreTopWindowInsets", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getPackageInfo", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "setPackageInfo", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;)V", "packages", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "getPackages", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "packagesByTab", "", "packagesOutsideTabs", "rcPackage", "Lcom/revenuecat/purchases/Package;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getTabControl", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "setTabControl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;)V", "getTabControlIndex", "setTabControlIndex", "getTabIndex", "setTabIndex", "windowInsetsState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WindowInsetsState;", "getWindowInsetsState", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WindowInsetsState;", "applyTopWindowInsetsIfNotYetApplied", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", TypedValues.TransitionType.S_TO, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Ljava/util/Map;Ljava/util/Map;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope;", "equals", "other", "hashCode", "recordComponent", "", "component", "recordPackage", "pkg", InAppPurchaseConstants.METHOD_TO_STRING, "", "withCount", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WithCount;", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "block", "Lkotlin/ExtensionFunctionType;", "withCountdown", "(Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withSelectedScope", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withTabControl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withTabIndex", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "applyBottomWindowInsetsIfNecessary", "shouldApply", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Z)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "applyHorizontalWindowInsetsIfNecessary", "WindowInsetsState", "WithCount", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final /* data */ class StyleFactoryScope {
        private CountdownComponent.CountFrom countFrom;
        private final Map<Integer, Function1<PaywallComponent, Boolean>> countPredicates;
        private final Map<Integer, Integer> countValues;
        private Date countdownDate;
        private Integer defaultTabIndex;
        private PaywallState.Loaded.Components.AvailablePackages.Info packageInfo;
        private final Map<Integer, List<PaywallState.Loaded.Components.AvailablePackages.Info>> packagesByTab;
        private final List<PaywallState.Loaded.Components.AvailablePackages.Info> packagesOutsideTabs;
        private TabControlStyle tabControl;
        private Integer tabControlIndex;
        private Integer tabIndex;
        private final WindowInsetsState windowInsetsState;

        /* JADX INFO: compiled from: StyleFactory.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014R\u001c\u0010\u0003\u001a\u00020\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u0018\u0010\u0013\u001a\u00020\u0004*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0004*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0017\u001a\u00020\u0004*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WindowInsetsState;", "", "()V", "applyTopWindowInsets", "", "getApplyTopWindowInsets", "()Z", "setApplyTopWindowInsets", "(Z)V", "heroImageDetected", "getHeroImageDetected", "setHeroImageDetected", "ignoreTopWindowInsets", "getIgnoreTopWindowInsets", "setIgnoreTopWindowInsets", "stillLookingForHeaderMedia", "topWindowInsetsApplied", "getTopWindowInsetsApplied", "setTopWindowInsetsApplied", "isHeaderImage", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "(Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;)Z", "isHeaderMedia", "isHeaderVideo", "handleHeaderMediaViewWindowInsets", "", "component", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private static final class WindowInsetsState {
            private boolean applyTopWindowInsets;
            private boolean heroImageDetected;
            private boolean ignoreTopWindowInsets;
            private boolean stillLookingForHeaderMedia = true;
            private boolean topWindowInsetsApplied;

            private final boolean isHeaderImage(PaywallComponent paywallComponent) {
                if (!(paywallComponent instanceof ImageComponent)) {
                    return false;
                }
                SizeConstraint width = ((ImageComponent) paywallComponent).getSize().getWidth();
                if (width instanceof SizeConstraint.Fill) {
                    return true;
                }
                if (width instanceof SizeConstraint.Fit ? true : width instanceof SizeConstraint.Fixed) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }

            private final boolean isHeaderMedia(PaywallComponent paywallComponent) {
                return isHeaderImage(paywallComponent) || isHeaderVideo(paywallComponent);
            }

            private final boolean isHeaderVideo(PaywallComponent paywallComponent) {
                if (!(paywallComponent instanceof VideoComponent)) {
                    return false;
                }
                SizeConstraint width = ((VideoComponent) paywallComponent).getSize().getWidth();
                if (width instanceof SizeConstraint.Fill) {
                    return true;
                }
                if (width instanceof SizeConstraint.Fit ? true : width instanceof SizeConstraint.Fixed) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }

            public final boolean getApplyTopWindowInsets() {
                boolean z = this.applyTopWindowInsets;
                this.applyTopWindowInsets = false;
                return z;
            }

            public final boolean getHeroImageDetected() {
                return this.heroImageDetected;
            }

            public final boolean getIgnoreTopWindowInsets() {
                boolean z = this.ignoreTopWindowInsets;
                this.ignoreTopWindowInsets = false;
                return z;
            }

            public final boolean getTopWindowInsetsApplied() {
                return this.topWindowInsetsApplied;
            }

            public final void handleHeaderMediaViewWindowInsets(PaywallComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                boolean z = false;
                if (component instanceof StackComponent) {
                    if (this.stillLookingForHeaderMedia) {
                        StackComponent stackComponent = (StackComponent) component;
                        Dimension dimension = stackComponent.getDimension();
                        if (dimension instanceof Dimension.ZLayer) {
                            PaywallComponent paywallComponent = (PaywallComponent) CollectionsKt.firstOrNull(stackComponent.getComponents());
                            if (paywallComponent != null && isHeaderMedia(paywallComponent)) {
                                z = true;
                            }
                            this.topWindowInsetsApplied = z;
                            this.heroImageDetected = z;
                        } else {
                            if (!(dimension instanceof Dimension.Horizontal ? true : dimension instanceof Dimension.Vertical)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        this.applyTopWindowInsets = z;
                        return;
                    }
                    return;
                }
                if (component instanceof ImageComponent) {
                    if (this.stillLookingForHeaderMedia) {
                        this.ignoreTopWindowInsets = isHeaderImage(component);
                        this.heroImageDetected = isHeaderImage(component);
                    }
                    this.stillLookingForHeaderMedia = false;
                    return;
                }
                if (!(component instanceof VideoComponent)) {
                    if (component instanceof FallbackHeaderComponent) {
                        return;
                    }
                    this.stillLookingForHeaderMedia = false;
                } else {
                    if (this.stillLookingForHeaderMedia) {
                        this.ignoreTopWindowInsets = isHeaderVideo(component);
                        this.heroImageDetected = isHeaderVideo(component);
                    }
                    this.stillLookingForHeaderMedia = false;
                }
            }

            public final void setApplyTopWindowInsets(boolean z) {
                this.applyTopWindowInsets = z;
            }

            public final void setHeroImageDetected(boolean z) {
                this.heroImageDetected = z;
            }

            public final void setIgnoreTopWindowInsets(boolean z) {
                this.ignoreTopWindowInsets = z;
            }

            public final void setTopWindowInsetsApplied(boolean z) {
                this.topWindowInsetsApplied = z;
            }
        }

        /* JADX INFO: compiled from: StyleFactory.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WithCount;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "count", "", "(Ljava/lang/Object;I)V", "getCount", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WithCount;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class WithCount<T> {
            public static final int $stable = 0;
            private final int count;
            private final T value;

            public WithCount(T t, int i) {
                this.value = t;
                this.count = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ WithCount copy$default(WithCount withCount, Object obj, int i, int i2, Object obj2) {
                if ((i2 & 1) != 0) {
                    obj = withCount.value;
                }
                if ((i2 & 2) != 0) {
                    i = withCount.count;
                }
                return withCount.copy(obj, i);
            }

            public final T component1() {
                return this.value;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            public final WithCount<T> copy(T value, int count) {
                return new WithCount<>(value, count);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WithCount)) {
                    return false;
                }
                WithCount withCount = (WithCount) other;
                return Intrinsics.areEqual(this.value, withCount.value) && this.count == withCount.count;
            }

            public final int getCount() {
                return this.count;
            }

            public final T getValue() {
                return this.value;
            }

            public int hashCode() {
                T t = this.value;
                return ((t == null ? 0 : t.hashCode()) * 31) + Integer.hashCode(this.count);
            }

            public String toString() {
                return "WithCount(value=" + this.value + ", count=" + this.count + ')';
            }
        }

        public StyleFactoryScope() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public StyleFactoryScope(PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, Date date, CountdownComponent.CountFrom countFrom, Map<Integer, Function1<PaywallComponent, Boolean>> countPredicates, Map<Integer, Integer> countValues) {
            Intrinsics.checkNotNullParameter(countFrom, "countFrom");
            Intrinsics.checkNotNullParameter(countPredicates, "countPredicates");
            Intrinsics.checkNotNullParameter(countValues, "countValues");
            this.packageInfo = info;
            this.tabControl = tabControlStyle;
            this.tabControlIndex = num;
            this.tabIndex = num2;
            this.countdownDate = date;
            this.countFrom = countFrom;
            this.countPredicates = countPredicates;
            this.countValues = countValues;
            this.windowInsetsState = new WindowInsetsState();
            this.packagesOutsideTabs = new ArrayList();
            this.packagesByTab = new LinkedHashMap();
        }

        public /* synthetic */ StyleFactoryScope(PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, Date date, CountdownComponent.CountFrom countFrom, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : info, (i & 2) != 0 ? null : tabControlStyle, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : date, (i & 32) != 0 ? CountdownComponent.CountFrom.DAYS : countFrom, (i & 64) != 0 ? new LinkedHashMap() : linkedHashMap, (i & 128) != 0 ? new LinkedHashMap() : linkedHashMap2);
        }

        private final Map<Integer, Function1<PaywallComponent, Boolean>> component7() {
            return this.countPredicates;
        }

        private final Map<Integer, Integer> component8() {
            return this.countValues;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StyleFactoryScope copy$default(StyleFactoryScope styleFactoryScope, PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, Date date, CountdownComponent.CountFrom countFrom, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                info = styleFactoryScope.packageInfo;
            }
            if ((i & 2) != 0) {
                tabControlStyle = styleFactoryScope.tabControl;
            }
            if ((i & 4) != 0) {
                num = styleFactoryScope.tabControlIndex;
            }
            if ((i & 8) != 0) {
                num2 = styleFactoryScope.tabIndex;
            }
            if ((i & 16) != 0) {
                date = styleFactoryScope.countdownDate;
            }
            if ((i & 32) != 0) {
                countFrom = styleFactoryScope.countFrom;
            }
            if ((i & 64) != 0) {
                map = styleFactoryScope.countPredicates;
            }
            if ((i & 128) != 0) {
                map2 = styleFactoryScope.countValues;
            }
            Map map3 = map;
            Map map4 = map2;
            Date date2 = date;
            CountdownComponent.CountFrom countFrom2 = countFrom;
            return styleFactoryScope.copy(info, tabControlStyle, num, num2, date2, countFrom2, map3, map4);
        }

        private final void recordPackage(PaywallState.Loaded.Components.AvailablePackages.Info pkg) {
            Integer num = this.tabIndex;
            if (num == null) {
                this.packagesOutsideTabs.add(pkg);
                return;
            }
            Map<Integer, List<PaywallState.Loaded.Components.AvailablePackages.Info>> map = this.packagesByTab;
            ArrayList arrayList = map.get(num);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(num, arrayList);
            }
            arrayList.add(pkg);
        }

        public final <T extends ComponentStyle> T applyBottomWindowInsetsIfNecessary(T t, boolean z) {
            StickyFooterComponentStyle stickyFooterComponentStyleCopy = t;
            Intrinsics.checkNotNullParameter(stickyFooterComponentStyleCopy, "<this>");
            if (z) {
                if (stickyFooterComponentStyleCopy instanceof StackComponentStyle) {
                    stickyFooterComponentStyleCopy = StackComponentStyle.m10589copyh6c5tkY$default((StackComponentStyle) stickyFooterComponentStyleCopy, null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, true, false, 12582911, null);
                } else if (stickyFooterComponentStyleCopy instanceof StickyFooterComponentStyle) {
                    StickyFooterComponentStyle stickyFooterComponentStyle = (StickyFooterComponentStyle) stickyFooterComponentStyleCopy;
                    stickyFooterComponentStyleCopy = stickyFooterComponentStyle.copy(StackComponentStyle.m10589copyh6c5tkY$default(stickyFooterComponentStyle.getStackComponentStyle(), null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, true, false, 12582911, null));
                }
                Intrinsics.checkNotNull(stickyFooterComponentStyleCopy, "null cannot be cast to non-null type T of com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.StyleFactoryScope.applyBottomWindowInsetsIfNecessary");
            }
            return stickyFooterComponentStyleCopy;
        }

        public final <T extends ComponentStyle> T applyHorizontalWindowInsetsIfNecessary(T t, boolean z) {
            HeaderComponentStyle headerComponentStyleCopy = t;
            Intrinsics.checkNotNullParameter(headerComponentStyleCopy, "<this>");
            if (z) {
                if (headerComponentStyleCopy instanceof StackComponentStyle) {
                    headerComponentStyleCopy = StackComponentStyle.m10589copyh6c5tkY$default((StackComponentStyle) headerComponentStyleCopy, null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, true, 8388607, null);
                } else if (headerComponentStyleCopy instanceof StickyFooterComponentStyle) {
                    StickyFooterComponentStyle stickyFooterComponentStyle = (StickyFooterComponentStyle) headerComponentStyleCopy;
                    headerComponentStyleCopy = stickyFooterComponentStyle.copy(StackComponentStyle.m10589copyh6c5tkY$default(stickyFooterComponentStyle.getStackComponentStyle(), null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, true, 8388607, null));
                } else if (headerComponentStyleCopy instanceof HeaderComponentStyle) {
                    HeaderComponentStyle headerComponentStyle = (HeaderComponentStyle) headerComponentStyleCopy;
                    headerComponentStyleCopy = headerComponentStyle.copy(StackComponentStyle.m10589copyh6c5tkY$default(headerComponentStyle.getStackComponentStyle(), null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, true, 8388607, null));
                }
                Intrinsics.checkNotNull(headerComponentStyleCopy, "null cannot be cast to non-null type T of com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.StyleFactoryScope.applyHorizontalWindowInsetsIfNecessary");
            }
            return headerComponentStyleCopy;
        }

        public final ComponentStyle applyTopWindowInsetsIfNotYetApplied(ComponentStyle to) {
            Intrinsics.checkNotNullParameter(to, "to");
            if (to instanceof StackComponentStyle) {
                return StackComponentStyle.m10589copyh6c5tkY$default((StackComponentStyle) to, null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, !this.windowInsetsState.getTopWindowInsetsApplied(), false, false, false, 15728639, null);
            }
            if (!(to instanceof HeaderComponentStyle)) {
                return to;
            }
            HeaderComponentStyle headerComponentStyle = (HeaderComponentStyle) to;
            return headerComponentStyle.copy(StackComponentStyle.m10589copyh6c5tkY$default(headerComponentStyle.getStackComponentStyle(), null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, !this.windowInsetsState.getTopWindowInsetsApplied(), true, false, false, 13631487, null));
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PaywallState.Loaded.Components.AvailablePackages.Info getPackageInfo() {
            return this.packageInfo;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final TabControlStyle getTabControl() {
            return this.tabControl;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getTabControlIndex() {
            return this.tabControlIndex;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTabIndex() {
            return this.tabIndex;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getCountdownDate() {
            return this.countdownDate;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final CountdownComponent.CountFrom getCountFrom() {
            return this.countFrom;
        }

        public final StyleFactoryScope copy(PaywallState.Loaded.Components.AvailablePackages.Info packageInfo, TabControlStyle tabControl, Integer tabControlIndex, Integer tabIndex, Date countdownDate, CountdownComponent.CountFrom countFrom, Map<Integer, Function1<PaywallComponent, Boolean>> countPredicates, Map<Integer, Integer> countValues) {
            Intrinsics.checkNotNullParameter(countFrom, "countFrom");
            Intrinsics.checkNotNullParameter(countPredicates, "countPredicates");
            Intrinsics.checkNotNullParameter(countValues, "countValues");
            return new StyleFactoryScope(packageInfo, tabControl, tabControlIndex, tabIndex, countdownDate, countFrom, countPredicates, countValues);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StyleFactoryScope)) {
                return false;
            }
            StyleFactoryScope styleFactoryScope = (StyleFactoryScope) other;
            return Intrinsics.areEqual(this.packageInfo, styleFactoryScope.packageInfo) && Intrinsics.areEqual(this.tabControl, styleFactoryScope.tabControl) && Intrinsics.areEqual(this.tabControlIndex, styleFactoryScope.tabControlIndex) && Intrinsics.areEqual(this.tabIndex, styleFactoryScope.tabIndex) && Intrinsics.areEqual(this.countdownDate, styleFactoryScope.countdownDate) && this.countFrom == styleFactoryScope.countFrom && Intrinsics.areEqual(this.countPredicates, styleFactoryScope.countPredicates) && Intrinsics.areEqual(this.countValues, styleFactoryScope.countValues);
        }

        public final boolean getApplyTopWindowInsets() {
            return this.windowInsetsState.getApplyTopWindowInsets();
        }

        public final CountdownComponent.CountFrom getCountFrom() {
            return this.countFrom;
        }

        public final Date getCountdownDate() {
            return this.countdownDate;
        }

        public final Integer getDefaultTabIndex() {
            return this.defaultTabIndex;
        }

        public final boolean getHeroImageDetected() {
            return this.windowInsetsState.getHeroImageDetected();
        }

        public final boolean getIgnoreTopWindowInsets() {
            return this.windowInsetsState.getIgnoreTopWindowInsets();
        }

        public final OfferEligibility getOfferEligibility() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            if (info != null) {
                return PackageExtensionsKt.calculateOfferEligibility(info.getResolvedOffer(), info.getPkg());
            }
            return null;
        }

        public final PaywallState.Loaded.Components.AvailablePackages.Info getPackageInfo() {
            return this.packageInfo;
        }

        public final PaywallState.Loaded.Components.AvailablePackages getPackages() {
            return new PaywallState.Loaded.Components.AvailablePackages(this.packagesOutsideTabs, this.packagesByTab);
        }

        public final Package getRcPackage() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            if (info != null) {
                return info.getPkg();
            }
            return null;
        }

        public final ResolvedOffer getResolvedOffer() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            if (info != null) {
                return info.getResolvedOffer();
            }
            return null;
        }

        public final TabControlStyle getTabControl() {
            return this.tabControl;
        }

        public final Integer getTabControlIndex() {
            return this.tabControlIndex;
        }

        public final Integer getTabIndex() {
            return this.tabIndex;
        }

        public final WindowInsetsState getWindowInsetsState() {
            return this.windowInsetsState;
        }

        public int hashCode() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            int iHashCode = (info == null ? 0 : info.hashCode()) * 31;
            TabControlStyle tabControlStyle = this.tabControl;
            int iHashCode2 = (iHashCode + (tabControlStyle == null ? 0 : tabControlStyle.hashCode())) * 31;
            Integer num = this.tabControlIndex;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.tabIndex;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Date date = this.countdownDate;
            return ((((((iHashCode4 + (date != null ? date.hashCode() : 0)) * 31) + this.countFrom.hashCode()) * 31) + this.countPredicates.hashCode()) * 31) + this.countValues.hashCode();
        }

        public final void recordComponent(PaywallComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            for (Map.Entry<Integer, Function1<PaywallComponent, Boolean>> entry : this.countPredicates.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().invoke(component).booleanValue()) {
                    Integer num = this.countValues.get(Integer.valueOf(iIntValue));
                    this.countValues.put(Integer.valueOf(iIntValue), Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                }
            }
            this.windowInsetsState.handleHeaderMediaViewWindowInsets(component);
        }

        public final void setCountFrom(CountdownComponent.CountFrom countFrom) {
            Intrinsics.checkNotNullParameter(countFrom, "<set-?>");
            this.countFrom = countFrom;
        }

        public final void setCountdownDate(Date date) {
            this.countdownDate = date;
        }

        public final void setDefaultTabIndex(Integer num) {
            this.defaultTabIndex = num;
        }

        public final void setPackageInfo(PaywallState.Loaded.Components.AvailablePackages.Info info) {
            this.packageInfo = info;
        }

        public final void setTabControl(TabControlStyle tabControlStyle) {
            this.tabControl = tabControlStyle;
        }

        public final void setTabControlIndex(Integer num) {
            this.tabControlIndex = num;
        }

        public final void setTabIndex(Integer num) {
            this.tabIndex = num;
        }

        public String toString() {
            return "StyleFactoryScope(packageInfo=" + this.packageInfo + ", tabControl=" + this.tabControl + ", tabControlIndex=" + this.tabControlIndex + ", tabIndex=" + this.tabIndex + ", countdownDate=" + this.countdownDate + ", countFrom=" + this.countFrom + ", countPredicates=" + this.countPredicates + ", countValues=" + this.countValues + ')';
        }

        public final <T> WithCount<T> withCount(Function1<? super PaywallComponent, Boolean> predicate, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            Intrinsics.checkNotNullParameter(block, "block");
            Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) this.countPredicates.keySet());
            int iIntValue = (num != null ? num.intValue() : -1) + 1;
            this.countPredicates.put(Integer.valueOf(iIntValue), predicate);
            this.countValues.put(Integer.valueOf(iIntValue), 0);
            WithCount<T> withCount = new WithCount<>(block.invoke(this), ((Number) MapsKt.getValue(this.countValues, Integer.valueOf(iIntValue))).intValue());
            this.countPredicates.remove(Integer.valueOf(iIntValue));
            this.countValues.remove(Integer.valueOf(iIntValue));
            return withCount;
        }

        public final <T> T withCountdown(Date countdownDate, CountdownComponent.CountFrom countFrom, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(countdownDate, "countdownDate");
            Intrinsics.checkNotNullParameter(countFrom, "countFrom");
            Intrinsics.checkNotNullParameter(block, "block");
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, null, 255, null);
            this.countdownDate = countdownDate;
            this.countFrom = countFrom;
            T tInvoke = block.invoke(this);
            this.countdownDate = styleFactoryScopeCopy$default.countdownDate;
            this.countFrom = styleFactoryScopeCopy$default.countFrom;
            return tInvoke;
        }

        public final <T> T withSelectedScope(PaywallState.Loaded.Components.AvailablePackages.Info packageInfo, Integer tabControlIndex, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            if (packageInfo != null) {
                recordPackage(packageInfo);
            }
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, null, 255, null);
            this.packageInfo = packageInfo;
            this.tabControlIndex = tabControlIndex;
            T tInvoke = block.invoke(this);
            this.packageInfo = styleFactoryScopeCopy$default.packageInfo;
            this.tabControlIndex = styleFactoryScopeCopy$default.tabControlIndex;
            return tInvoke;
        }

        public final <T> T withTabControl(TabControlStyle tabControl, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(tabControl, "tabControl");
            Intrinsics.checkNotNullParameter(block, "block");
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, null, 255, null);
            this.tabControl = tabControl;
            T tInvoke = block.invoke(this);
            this.tabControl = styleFactoryScopeCopy$default.tabControl;
            return tInvoke;
        }

        public final <T> T withTabIndex(int tabIndex, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, null, 255, null);
            this.tabIndex = Integer.valueOf(tabIndex);
            T tInvoke = block.invoke(this);
            this.tabIndex = styleFactoryScopeCopy$default.tabIndex;
            return tInvoke;
        }
    }

    /* JADX INFO: compiled from: StyleFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleResult;", "", "componentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "availablePackages", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "defaultTabIndex", "", "heroImageDetected", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;Ljava/lang/Integer;Z)V", "getAvailablePackages", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "getComponentStyle", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "getDefaultTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeroImageDetected", "()Z", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StyleResult {
        public static final int $stable = 0;
        private final PaywallState.Loaded.Components.AvailablePackages availablePackages;
        private final ComponentStyle componentStyle;
        private final Integer defaultTabIndex;
        private final boolean heroImageDetected;

        public StyleResult(ComponentStyle componentStyle, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z) {
            Intrinsics.checkNotNullParameter(componentStyle, "componentStyle");
            Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
            this.componentStyle = componentStyle;
            this.availablePackages = availablePackages;
            this.defaultTabIndex = num;
            this.heroImageDetected = z;
        }

        public /* synthetic */ StyleResult(ComponentStyle componentStyle, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(componentStyle, availablePackages, num, (i & 8) != 0 ? false : z);
        }

        public final PaywallState.Loaded.Components.AvailablePackages getAvailablePackages() {
            return this.availablePackages;
        }

        public final ComponentStyle getComponentStyle() {
            return this.componentStyle;
        }

        public final Integer getDefaultTabIndex() {
            return this.defaultTabIndex;
        }

        public final boolean getHeroImageDetected() {
            return this.heroImageDetected;
        }
    }

    /* JADX INFO: compiled from: StyleFactory.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonComponent.UrlMethod.values().length];
            try {
                iArr[ButtonComponent.UrlMethod.IN_APP_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StyleFactory(NonEmptyMap<LocaleId, ? extends NonEmptyMap<LocalizationKey, ? extends LocalizationData>> localizations, Map<ColorAlias, ColorScheme> colorAliases, Map<FontAlias, ? extends FontSpec> fontAliases, NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations, Offering offering, boolean z) {
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(colorAliases, "colorAliases");
        Intrinsics.checkNotNullParameter(fontAliases, "fontAliases");
        Intrinsics.checkNotNullParameter(variableLocalizations, "variableLocalizations");
        Intrinsics.checkNotNullParameter(offering, "offering");
        this.localizations = localizations;
        this.colorAliases = colorAliases;
        this.fontAliases = fontAliases;
        this.variableLocalizations = variableLocalizations;
        this.offering = offering;
        this.stripRules = z;
    }

    public /* synthetic */ StyleFactory(NonEmptyMap nonEmptyMap, Map map, Map map2, NonEmptyMap nonEmptyMap2, Offering offering, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, map, map2, nonEmptyMap2, offering, (i & 32) != 0 ? false : z);
    }

    /* JADX INFO: renamed from: buttonComponentStyleUrlDestination-26kQY28, reason: not valid java name */
    private final Result<ButtonComponentStyle.Action.NavigateTo.Destination.Url, NonEmptyList<PaywallValidationError.MissingStringLocalization>> m10595buttonComponentStyleUrlDestination26kQY28(String urlLid, ButtonComponent.UrlMethod method) {
        Result.Success successM10488stringForAllLocales7v81vok = LocalizationKt.m10488stringForAllLocales7v81vok(this.localizations, urlLid);
        if (successM10488stringForAllLocales7v81vok instanceof Result.Success) {
            successM10488stringForAllLocales7v81vok = new Result.Success(new ButtonComponentStyle.Action.NavigateTo.Destination.Url((NonEmptyMap) ((Result.Success) successM10488stringForAllLocales7v81vok).getValue(), method));
        } else if (!(successM10488stringForAllLocales7v81vok instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(successM10488stringForAllLocales7v81vok instanceof Result.Success)) {
            if (successM10488stringForAllLocales7v81vok instanceof Result.Error) {
                return successM10488stringForAllLocales7v81vok;
            }
            throw new NoWhenBranchMatchedException();
        }
        ButtonComponentStyle.Action.NavigateTo.Destination.Url url = (ButtonComponentStyle.Action.NavigateTo.Destination.Url) ((Result.Success) successM10488stringForAllLocales7v81vok).getValue();
        int i = WhenMappings.$EnumSwitchMapping$0[url.getMethod().ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            url = null;
        }
        return new Result.Success(url);
    }

    private final Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> convertAction(StyleFactoryScope styleFactoryScope, ButtonComponent.Action action) {
        if (action instanceof ButtonComponent.Action.NavigateBack) {
            return new Result.Success(ButtonComponentStyle.Action.NavigateBack.INSTANCE);
        }
        if (action instanceof ButtonComponent.Action.RestorePurchases) {
            return new Result.Success(ButtonComponentStyle.Action.RestorePurchases.INSTANCE);
        }
        if (!(action instanceof ButtonComponent.Action.NavigateTo)) {
            if (action instanceof ButtonComponent.Action.Unknown) {
                return new Result.Success(null);
            }
            throw new NoWhenBranchMatchedException();
        }
        Result resultConvertDestination = convertDestination(styleFactoryScope, ((ButtonComponent.Action.NavigateTo) action).getDestination());
        if (resultConvertDestination instanceof Result.Success) {
            ButtonComponentStyle.Action.NavigateTo.Destination destination = (ButtonComponentStyle.Action.NavigateTo.Destination) ((Result.Success) resultConvertDestination).getValue();
            return new Result.Success(destination != null ? new ButtonComponentStyle.Action.NavigateTo(destination) : null);
        }
        if (resultConvertDestination instanceof Result.Error) {
            return resultConvertDestination;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<ButtonComponentStyle.Action.NavigateTo.Destination, NonEmptyList<PaywallValidationError>> convertDestination(StyleFactoryScope styleFactoryScope, ButtonComponent.Destination destination) {
        if (destination instanceof ButtonComponent.Destination.CustomerCenter) {
            return new Result.Success(ButtonComponentStyle.Action.NavigateTo.Destination.CustomerCenter.INSTANCE);
        }
        if (destination instanceof ButtonComponent.Destination.PrivacyPolicy) {
            ButtonComponent.Destination.PrivacyPolicy privacyPolicy = (ButtonComponent.Destination.PrivacyPolicy) destination;
            return m10595buttonComponentStyleUrlDestination26kQY28(privacyPolicy.m10357getUrlLidz7Tp4o(), privacyPolicy.getMethod());
        }
        if (destination instanceof ButtonComponent.Destination.Terms) {
            ButtonComponent.Destination.Terms terms = (ButtonComponent.Destination.Terms) destination;
            return m10595buttonComponentStyleUrlDestination26kQY28(terms.m10361getUrlLidz7Tp4o(), terms.getMethod());
        }
        if (destination instanceof ButtonComponent.Destination.Url) {
            ButtonComponent.Destination.Url url = (ButtonComponent.Destination.Url) destination;
            return m10595buttonComponentStyleUrlDestination26kQY28(url.m10365getUrlLidz7Tp4o(), url.getMethod());
        }
        if (!(destination instanceof ButtonComponent.Destination.Sheet)) {
            if (destination instanceof ButtonComponent.Destination.Unknown) {
                return new Result.Success(null);
            }
            throw new NoWhenBranchMatchedException();
        }
        ButtonComponent.Destination.Sheet sheet = (ButtonComponent.Destination.Sheet) destination;
        Result resultCreateStackComponentStyle = createStackComponentStyle(styleFactoryScope, sheet.getStack());
        if (resultCreateStackComponentStyle instanceof Result.Success) {
            resultCreateStackComponentStyle = new Result.Success((StackComponentStyle) styleFactoryScope.applyBottomWindowInsetsIfNecessary((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), true));
        } else if (!(resultCreateStackComponentStyle instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (resultCreateStackComponentStyle instanceof Result.Success) {
            resultCreateStackComponentStyle = new Result.Success((StackComponentStyle) styleFactoryScope.applyHorizontalWindowInsetsIfNecessary((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), true));
        } else if (!(resultCreateStackComponentStyle instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (resultCreateStackComponentStyle instanceof Result.Success) {
            return new Result.Success(new ButtonComponentStyle.Action.NavigateTo.Destination.Sheet(sheet.getId(), sheet.getName(), (StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), sheet.getBackgroundBlur(), sheet.getSize()));
        }
        if (resultCreateStackComponentStyle instanceof Result.Error) {
            return resultCreateStackComponentStyle;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> convertPurchaseButtonMethod(StyleFactoryScope styleFactoryScope, PurchaseButtonComponent.Method method) {
        boolean zBooleanValue;
        if (method != null && !(method instanceof PurchaseButtonComponent.Method.InAppCheckout)) {
            if (method instanceof PurchaseButtonComponent.Method.WebCheckout) {
                Package rcPackage = styleFactoryScope.getRcPackage();
                PurchaseButtonComponent.Method.WebCheckout webCheckout = (PurchaseButtonComponent.Method.WebCheckout) method;
                Boolean autoDismiss = webCheckout.getAutoDismiss();
                zBooleanValue = autoDismiss != null ? autoDismiss.booleanValue() : true;
                ButtonComponent.UrlMethod openMethod = webCheckout.getOpenMethod();
                if (openMethod == null) {
                    openMethod = ButtonComponent.UrlMethod.EXTERNAL_BROWSER;
                }
                return new Result.Success(new ButtonComponentStyle.Action.WebCheckout(rcPackage, zBooleanValue, openMethod));
            }
            if (method instanceof PurchaseButtonComponent.Method.WebProductSelection) {
                PurchaseButtonComponent.Method.WebProductSelection webProductSelection = (PurchaseButtonComponent.Method.WebProductSelection) method;
                Boolean autoDismiss2 = webProductSelection.getAutoDismiss();
                zBooleanValue = autoDismiss2 != null ? autoDismiss2.booleanValue() : true;
                ButtonComponent.UrlMethod openMethod2 = webProductSelection.getOpenMethod();
                if (openMethod2 == null) {
                    openMethod2 = ButtonComponent.UrlMethod.EXTERNAL_BROWSER;
                }
                return new Result.Success(new ButtonComponentStyle.Action.WebProductSelection(zBooleanValue, openMethod2));
            }
            if (!(method instanceof PurchaseButtonComponent.Method.CustomWebCheckout)) {
                if (!(method instanceof PurchaseButtonComponent.Method.Unknown)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.INSTANCE.e("Unknown purchase button method. Defaulting to purchasing current/default package.");
                return new Result.Success(new ButtonComponentStyle.Action.PurchasePackage(styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer()));
            }
            PurchaseButtonComponent.Method.CustomWebCheckout customWebCheckout = (PurchaseButtonComponent.Method.CustomWebCheckout) method;
            Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> resultM10488stringForAllLocales7v81vok = LocalizationKt.m10488stringForAllLocales7v81vok(this.localizations, customWebCheckout.getCustomUrl().m10384getUrlLidz7Tp4o());
            if (!(resultM10488stringForAllLocales7v81vok instanceof Result.Success)) {
                if (resultM10488stringForAllLocales7v81vok instanceof Result.Error) {
                    return resultM10488stringForAllLocales7v81vok;
                }
                throw new NoWhenBranchMatchedException();
            }
            NonEmptyMap nonEmptyMap = (NonEmptyMap) ((Result.Success) resultM10488stringForAllLocales7v81vok).getValue();
            Boolean autoDismiss3 = customWebCheckout.getAutoDismiss();
            boolean zBooleanValue2 = autoDismiss3 != null ? autoDismiss3.booleanValue() : true;
            ButtonComponent.UrlMethod openMethod3 = customWebCheckout.getOpenMethod();
            if (openMethod3 == null) {
                openMethod3 = ButtonComponent.UrlMethod.EXTERNAL_BROWSER;
            }
            return new Result.Success(new ButtonComponentStyle.Action.CustomWebCheckout(nonEmptyMap, zBooleanValue2, openMethod3, styleFactoryScope.getRcPackage(), customWebCheckout.getCustomUrl().getPackageParam()));
        }
        return new Result.Success(new ButtonComponentStyle.Action.PurchasePackage(styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer()));
    }

    public static /* synthetic */ Result create$default(StyleFactory styleFactory, PaywallComponent paywallComponent, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            z3 = false;
        }
        return styleFactory.create(paywallComponent, z, z2, z3);
    }

    private final Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> createBackgroundStyles(Background background, ColorScheme backgroundColor) {
        Result.Success colorStyles;
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> backgroundStyles;
        if (background != null && (backgroundStyles = BackgroundStyleKt.toBackgroundStyles(background, this.colorAliases)) != null) {
            return backgroundStyles;
        }
        if (backgroundColor == null || (colorStyles = ColorStyleKt.toColorStyles(backgroundColor, this.colorAliases)) == null) {
            colorStyles = null;
        } else if (colorStyles instanceof Result.Success) {
            colorStyles = new Result.Success(BackgroundStyles.Color.m10509boximpl(BackgroundStyles.Color.m10510constructorimpl((ColorStyles) ((Result.Success) colorStyles).getValue())));
        } else if (!(colorStyles instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return ResultKt.orSuccessfullyNull(colorStyles);
    }

    private final Result<ButtonComponentStyle, NonEmptyList<PaywallValidationError>> createButtonComponentStyleOrNull(StyleFactoryScope styleFactoryScope, ButtonComponent buttonComponent) {
        Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = createStackComponentStyle(styleFactoryScope, buttonComponent.getStack());
        Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> resultConvertAction = convertAction(styleFactoryScope, buttonComponent.getAction());
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        Result.Success success4 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreateStackComponentStyle, resultConvertAction, success, success2, success3, success4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultCreateStackComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultCreateStackComponentStyle).getValue();
        Intrinsics.checkNotNull(resultConvertAction, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultConvertAction).getValue();
        Object value3 = success.getValue();
        Object value4 = success2.getValue();
        Object value5 = success3.getValue();
        ButtonComponentStyle.Action action = (ButtonComponentStyle.Action) value2;
        return new Result.Success(action != null ? new ButtonComponentStyle((StackComponentStyle) value, action, buttonComponent.getTransition()) : null);
    }

    private final Result<CarouselComponentStyle, NonEmptyList<PaywallValidationError>> createCarouselComponentStyle(StyleFactoryScope styleFactoryScope, CarouselComponent carouselComponent) {
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(carouselComponent.getOverrides(), this.stripRules, new Function1<PartialCarouselComponent, Result<? extends PresentedCarouselPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createCarouselComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedCarouselPartial, NonEmptyList<PaywallValidationError>> invoke(PartialCarouselComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedCarouselPartial.INSTANCE.invoke(partial, StyleFactory.this.colorAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        List pages = carouselComponent.getPages();
        ArrayList<Result> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
        Iterator it = pages.iterator();
        while (it.hasNext()) {
            arrayList.add(createStackComponentStyle(styleFactoryScope, (StackComponent) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Result result : arrayList) {
            if (result instanceof Result.Success) {
                if (arrayList3.isEmpty()) {
                    arrayList2.add((StackComponentStyle) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList3.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList3);
        Result.Success error = nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList2);
        Border border = carouselComponent.getBorder();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = carouselComponent.getShadow();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> resultCreateBackgroundStyles = createBackgroundStyles(carouselComponent.getBackground(), carouselComponent.getBackgroundColor());
        CarouselComponent.PageControl pageControl = carouselComponent.getPageControl();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(pageControl != null ? PageControlExtensionsKt.toPageControlStyles(pageControl, this.colorAliases) : null);
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, error, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultCreateBackgroundStyles, resultOrSuccessfullyNull3})));
        if (nonEmptyListOrNull2 != null) {
            return new Result.Error(nonEmptyListOrNull2);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Object value2 = ((Result.Success) error).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultCreateBackgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultCreateBackgroundStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        CarouselComponentStyle.PageControlStyles pageControlStyles = (CarouselComponentStyle.PageControlStyles) ((Result.Success) resultOrSuccessfullyNull3).getValue();
        BackgroundStyles backgroundStyles = (BackgroundStyles) value5;
        ShadowStyles shadowStyles = (ShadowStyles) value4;
        BorderStyles borderStyles = (BorderStyles) value3;
        List list = (List) value2;
        List list2 = (List) value;
        Integer initialPageIndex = carouselComponent.getInitialPageIndex();
        int iIntValue = initialPageIndex != null ? initialPageIndex.intValue() : 0;
        Alignment.Vertical alignment = AlignmentKt.toAlignment(carouselComponent.getPageAlignment());
        Boolean visible = carouselComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = carouselComponent.getSize();
        float fM9114constructorimpl = carouselComponent.getPagePeek() != null ? Dp.m9114constructorimpl(r0.intValue()) : Dp.m9114constructorimpl(0.0f);
        Float pageSpacing = carouselComponent.getPageSpacing();
        float fM9114constructorimpl2 = Dp.m9114constructorimpl(pageSpacing != null ? pageSpacing.floatValue() : 0.0f);
        PaddingValues paddingValues = PaddingKt.toPaddingValues(carouselComponent.getPadding());
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(carouselComponent.getMargin());
        Shape.Rectangle shape = carouselComponent.getShape();
        if (shape == null) {
            shape = DEFAULT_SHAPE;
        }
        Shape shape2 = shape;
        Boolean loop = carouselComponent.getLoop();
        return new Result.Success(new CarouselComponentStyle(list, iIntValue, alignment, zBooleanValue, size, fM9114constructorimpl, fM9114constructorimpl2, backgroundStyles, paddingValues, paddingValues2, shape2, borderStyles, shadowStyles, pageControlStyles, loop != null ? loop.booleanValue() : false, carouselComponent.getAutoAdvance(), styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list2, null));
    }

    private final Result<CountdownComponentStyle, NonEmptyList<PaywallValidationError>> createCountdownComponentStyle(StyleFactoryScope styleFactoryScope, final CountdownComponent countdownComponent) {
        return (Result) styleFactoryScope.withCountdown(countdownComponent.getStyle().getDate(), countdownComponent.getCountFrom(), new Function1<StyleFactoryScope, Result<? extends CountdownComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createCountdownComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<CountdownComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withCountdown) {
                Intrinsics.checkNotNullParameter(withCountdown, "$this$withCountdown");
                Result resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withCountdown, countdownComponent.getCountdownStack());
                StackComponent endStack = countdownComponent.getEndStack();
                Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(endStack != null ? StyleFactory.this.createStackComponentStyle(withCountdown, endStack) : null);
                StackComponent fallback = countdownComponent.getFallback();
                Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(fallback != null ? StyleFactory.this.createStackComponentStyle(withCountdown, fallback) : null);
                CountdownComponent countdownComponent2 = countdownComponent;
                Result.Success success = new Result.Success(Unit.INSTANCE);
                Result.Success success2 = new Result.Success(Unit.INSTANCE);
                Result.Success success3 = new Result.Success(Unit.INSTANCE);
                NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreateStackComponentStyle, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success, success2, success3})));
                if (nonEmptyListOrNull != null) {
                    return new Result.Error(nonEmptyListOrNull);
                }
                Intrinsics.checkNotNull(resultCreateStackComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value = ((Result.Success) resultCreateStackComponentStyle).getValue();
                Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
                Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
                Object value4 = success.getValue();
                Object value5 = success2.getValue();
                return new Result.Success(new CountdownComponentStyle(countdownComponent2.getStyle().getDate(), countdownComponent2.getCountFrom(), (StackComponentStyle) value, (StackComponentStyle) value2, (StackComponentStyle) value3));
            }
        });
    }

    private final Result<HeaderComponentStyle, NonEmptyList<PaywallValidationError>> createHeaderComponentStyle(StyleFactoryScope styleFactoryScope, final HeaderComponent headerComponent) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends HeaderComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createHeaderComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<HeaderComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                Result<HeaderComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withSelectedScope, headerComponent.getStack());
                if (resultCreateStackComponentStyle instanceof Result.Success) {
                    return new Result.Success(new HeaderComponentStyle((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                }
                if (resultCreateStackComponentStyle instanceof Result.Error) {
                    return resultCreateStackComponentStyle;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<IconComponentStyle, NonEmptyList<PaywallValidationError>> createIconComponentStyle(StyleFactoryScope styleFactoryScope, IconComponent iconComponent) {
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(iconComponent.getOverrides(), this.stripRules, new Function1<PartialIconComponent, Result<? extends PresentedIconPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createIconComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedIconPartial, NonEmptyList<PaywallValidationError>> invoke(PartialIconComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedIconPartial.INSTANCE.invoke(partial, StyleFactory.this.colorAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        ColorScheme color = iconComponent.getColor();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(color != null ? ColorStyleKt.toColorStyles(color, this.colorAliases) : null);
        IconComponent.IconBackground iconBackground = iconComponent.getIconBackground();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(iconBackground != null ? IconComponentStyleKt.toBackground(iconBackground, this.colorAliases) : null);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success, success2, success3})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Object value4 = success.getValue();
        Object value5 = success2.getValue();
        IconComponentStyle.Background background = (IconComponentStyle.Background) value3;
        ColorStyles colorStyles = (ColorStyles) value2;
        List list = (List) value;
        String baseUrl = iconComponent.getBaseUrl();
        String iconName = iconComponent.getIconName();
        IconComponent.Formats formats = iconComponent.getFormats();
        Boolean visible = iconComponent.getVisible();
        return new Result.Success(new IconComponentStyle(baseUrl, iconName, formats, visible != null ? visible.booleanValue() : true, iconComponent.getSize(), colorStyles, PaddingKt.toPaddingValues(iconComponent.getPadding()), PaddingKt.toPaddingValues(iconComponent.getMargin()), background, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list));
    }

    private final Result<ImageComponentStyle, NonEmptyList<PaywallValidationError>> createImageComponentStyle(StyleFactoryScope styleFactoryScope, ImageComponent imageComponent) {
        Result<NonEmptyMap<LocaleId, ThemeImageUrls>, NonEmptyList<PaywallValidationError.MissingImageLocalization>> resultM10596withLocalizedOverridesTDPsjl0 = m10596withLocalizedOverridesTDPsjl0(imageComponent.getSource(), imageComponent.getOverrideSourceLid());
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(imageComponent.getOverrides(), this.stripRules, new Function1<PartialImageComponent, Result<? extends PresentedImagePartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createImageComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedImagePartial, NonEmptyList<PaywallValidationError>> invoke(PartialImageComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ThemeImageUrls source = it.getSource();
                Result<PresentedImagePartial, NonEmptyList<PaywallValidationError>> resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(source != null ? StyleFactory.this.m10596withLocalizedOverridesTDPsjl0(source, it.getOverrideSourceLid()) : null);
                StyleFactory styleFactory = StyleFactory.this;
                if (resultOrSuccessfullyNull instanceof Result.Success) {
                    return PresentedImagePartial.INSTANCE.invoke(it, (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull).getValue(), styleFactory.colorAliases);
                }
                if (resultOrSuccessfullyNull instanceof Result.Error) {
                    return resultOrSuccessfullyNull;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        ColorScheme colorOverlay = imageComponent.getColorOverlay();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(colorOverlay != null ? ColorStyleKt.toColorStyles(colorOverlay, this.colorAliases) : null);
        Border border = imageComponent.getBorder();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = imageComponent.getShadow();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultM10596withLocalizedOverridesTDPsjl0, presentedOverrides, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, success})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultM10596withLocalizedOverridesTDPsjl0, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultM10596withLocalizedOverridesTDPsjl0).getValue();
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
        ShadowStyles shadowStyles = (ShadowStyles) value5;
        BorderStyles borderStyles = (BorderStyles) value4;
        ColorStyles colorStyles = (ColorStyles) value3;
        List list = (List) value2;
        NonEmptyMap nonEmptyMap = (NonEmptyMap) value;
        Boolean visible = imageComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = imageComponent.getSize();
        PaddingValues paddingValues = PaddingKt.toPaddingValues(imageComponent.getPadding());
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(imageComponent.getMargin());
        MaskShape maskShape = imageComponent.getMaskShape();
        return new Result.Success(new ImageComponentStyle(nonEmptyMap, zBooleanValue, size, paddingValues, paddingValues2, maskShape != null ? ShapeKt.toShape(maskShape) : null, borderStyles, shadowStyles, colorStyles, FitModeKt.toContentScale(imageComponent.getFitMode()), styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list, styleFactoryScope.getIgnoreTopWindowInsets()));
    }

    private final Result<ComponentStyle, NonEmptyList<PaywallValidationError>> createInternal(StyleFactoryScope styleFactoryScope, PaywallComponent paywallComponent) {
        styleFactoryScope.recordComponent(paywallComponent);
        if (paywallComponent instanceof ButtonComponent) {
            return createButtonComponentStyleOrNull(styleFactoryScope, (ButtonComponent) paywallComponent);
        }
        if (paywallComponent instanceof ImageComponent) {
            return createImageComponentStyle(styleFactoryScope, (ImageComponent) paywallComponent);
        }
        if (paywallComponent instanceof PackageComponent) {
            return createPackageComponentStyle(styleFactoryScope, (PackageComponent) paywallComponent);
        }
        if (paywallComponent instanceof PurchaseButtonComponent) {
            return createPurchaseButtonComponentStyle(styleFactoryScope, (PurchaseButtonComponent) paywallComponent);
        }
        if (paywallComponent instanceof StackComponent) {
            return createStackComponentStyle(styleFactoryScope, (StackComponent) paywallComponent);
        }
        if (paywallComponent instanceof HeaderComponent) {
            return createHeaderComponentStyle(styleFactoryScope, (HeaderComponent) paywallComponent);
        }
        if (paywallComponent instanceof StickyFooterComponent) {
            return createStickyFooterComponentStyle(styleFactoryScope, (StickyFooterComponent) paywallComponent);
        }
        if (paywallComponent instanceof TextComponent) {
            return createTextComponentStyle(styleFactoryScope, (TextComponent) paywallComponent);
        }
        if (paywallComponent instanceof IconComponent) {
            return createIconComponentStyle(styleFactoryScope, (IconComponent) paywallComponent);
        }
        if (paywallComponent instanceof TimelineComponent) {
            return createTimelineComponentStyle(styleFactoryScope, (TimelineComponent) paywallComponent);
        }
        if (paywallComponent instanceof CarouselComponent) {
            return createCarouselComponentStyle(styleFactoryScope, (CarouselComponent) paywallComponent);
        }
        if (paywallComponent instanceof TabControlButtonComponent) {
            return createTabControlButtonComponentStyle(styleFactoryScope, (TabControlButtonComponent) paywallComponent);
        }
        if (paywallComponent instanceof TabControlToggleComponent) {
            return createTabControlToggleComponentStyle(styleFactoryScope, (TabControlToggleComponent) paywallComponent);
        }
        if (paywallComponent instanceof TabControlComponent) {
            return ResultKt.errorIfNull(styleFactoryScope.getTabControl(), NonEmptyListKt.nonEmptyListOf(PaywallValidationError.TabControlNotInTab.INSTANCE, new PaywallValidationError.TabControlNotInTab[0]));
        }
        if (paywallComponent instanceof TabsComponent) {
            return createTabsComponentStyle(styleFactoryScope, (TabsComponent) paywallComponent);
        }
        if (paywallComponent instanceof VideoComponent) {
            return createVideoComponentStyle(styleFactoryScope, (VideoComponent) paywallComponent);
        }
        if (paywallComponent instanceof FallbackHeaderComponent) {
            return new Result.Success(null);
        }
        if (paywallComponent instanceof CountdownComponent) {
            return createCountdownComponentStyle(styleFactoryScope, (CountdownComponent) paywallComponent);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<PackageComponentStyle, NonEmptyList<PaywallValidationError>> createPackageComponentStyle(StyleFactoryScope styleFactoryScope, final PackageComponent packageComponent) {
        final Package r0 = (Package) new Result.Success(getPackageOrNull(this.offering, packageComponent.getPackageId())).getValue();
        if (r0 != null) {
            final ResolvedOffer resolvedOfferResolve = PromoOfferResolver.INSTANCE.resolve(r0, packageComponent.getPlayStoreOffer());
            return (Result) styleFactoryScope.withSelectedScope(new PaywallState.Loaded.Components.AvailablePackages.Info(r0, packageComponent.getIsSelectedByDefault(), resolvedOfferResolve), null, new Function1<StyleFactoryScope, Result<? extends PackageComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createPackageComponentStyle$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Result<PackageComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactory.StyleFactoryScope withSelectedScope) {
                    Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                    OfferEligibility offerEligibility = withSelectedScope.getOfferEligibility();
                    Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(packageComponent.getOverrides(), this.stripRules, new Function1<PartialPackageComponent, Result<? extends PresentedPackagePartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createPackageComponentStyle$1$1$presentedOverridesResult$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Result<PresentedPackagePartial, NonEmptyList<PaywallValidationError>> invoke(PartialPackageComponent partial) {
                            Intrinsics.checkNotNullParameter(partial, "partial");
                            return PresentedPackagePartial.INSTANCE.invoke(partial);
                        }
                    });
                    if (!(presentedOverrides instanceof Result.Success)) {
                        if (!(presentedOverrides instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
                    }
                    AnonymousClass1 anonymousClass1 = new Function1<PaywallComponent, Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createPackageComponentStyle$1$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(PaywallComponent it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(it instanceof PurchaseButtonComponent);
                        }
                    };
                    StyleFactory styleFactory = this;
                    PackageComponent packageComponent2 = packageComponent;
                    Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) withSelectedScope.countPredicates.keySet());
                    int iIntValue = (num != null ? num.intValue() : -1) + 1;
                    withSelectedScope.countPredicates.put(Integer.valueOf(iIntValue), anonymousClass1);
                    withSelectedScope.countValues.put(Integer.valueOf(iIntValue), 0);
                    StyleFactory.StyleFactoryScope.WithCount withCount = new StyleFactory.StyleFactoryScope.WithCount(styleFactory.createStackComponentStyle(withSelectedScope, packageComponent2.getStack()), ((Number) MapsKt.getValue(withSelectedScope.countValues, Integer.valueOf(iIntValue))).intValue());
                    withSelectedScope.countPredicates.remove(Integer.valueOf(iIntValue));
                    withSelectedScope.countValues.remove(Integer.valueOf(iIntValue));
                    Result result = (Result) withCount.component1();
                    int count = withCount.getCount();
                    PackageComponent packageComponent3 = packageComponent;
                    Package r2 = r0;
                    ResolvedOffer resolvedOffer = resolvedOfferResolve;
                    Result.Success success = new Result.Success(Unit.INSTANCE);
                    Result.Success success2 = new Result.Success(Unit.INSTANCE);
                    Result.Success success3 = new Result.Success(Unit.INSTANCE);
                    Result.Success success4 = new Result.Success(Unit.INSTANCE);
                    NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, result, success, success2, success3, success4})));
                    if (nonEmptyListOrNull != null) {
                        return new Result.Error(nonEmptyListOrNull);
                    }
                    Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                    Object value = ((Result.Success) presentedOverrides).getValue();
                    Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                    Object value2 = ((Result.Success) result).getValue();
                    Object value3 = success.getValue();
                    Object value4 = success2.getValue();
                    Object value5 = success3.getValue();
                    StackComponentStyle stackComponentStyle = (StackComponentStyle) value2;
                    List list = (List) value;
                    boolean isSelectedByDefault = packageComponent3.getIsSelectedByDefault();
                    boolean z = count == 0;
                    Boolean visible = packageComponent3.getVisible();
                    return new Result.Success(new PackageComponentStyle(r2, isSelectedByDefault, stackComponentStyle, z, resolvedOffer, visible != null ? visible.booleanValue() : true, list, offerEligibility));
                }
            });
        }
        String identifier = this.offering.getIdentifier();
        String packageId = packageComponent.getPackageId();
        List<Package> availablePackages = this.offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availablePackages, 10));
        Iterator<T> it = availablePackages.iterator();
        while (it.hasNext()) {
            arrayList.add(((Package) it.next()).getIdentifier());
        }
        Logger.INSTANCE.w(new PaywallValidationError.MissingPackage(identifier, packageId, arrayList).getMessage());
        return new Result.Success(null);
    }

    private final Result<ButtonComponentStyle, NonEmptyList<PaywallValidationError>> createPurchaseButtonComponentStyle(StyleFactoryScope styleFactoryScope, PurchaseButtonComponent purchaseButtonComponent) {
        Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = createStackComponentStyle(styleFactoryScope, purchaseButtonComponent.getStack());
        PurchaseButtonComponent.Method method = purchaseButtonComponent.getMethod();
        if (method == null) {
            PurchaseButtonComponent.Action action = purchaseButtonComponent.getAction();
            method = action != null ? action.toMethod() : null;
        }
        Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> resultConvertPurchaseButtonMethod = convertPurchaseButtonMethod(styleFactoryScope, method);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        Result.Success success4 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreateStackComponentStyle, resultConvertPurchaseButtonMethod, success, success2, success3, success4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultCreateStackComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultCreateStackComponentStyle).getValue();
        Intrinsics.checkNotNull(resultConvertPurchaseButtonMethod, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultConvertPurchaseButtonMethod).getValue();
        Object value3 = success.getValue();
        Object value4 = success2.getValue();
        Object value5 = success3.getValue();
        return new Result.Success(new ButtonComponentStyle((StackComponentStyle) value, (ButtonComponentStyle.Action) value2, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> createStackComponentStyle(final StyleFactoryScope styleFactoryScope, StackComponent stackComponent) {
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(stackComponent.getOverrides(), this.stripRules, new Function1<PartialStackComponent, Result<? extends PresentedStackPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStackComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedStackPartial, NonEmptyList<PaywallValidationError>> invoke(PartialStackComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                PresentedStackPartial.Companion companion = PresentedStackPartial.INSTANCE;
                Map map = StyleFactory.this.colorAliases;
                final StyleFactory styleFactory = StyleFactory.this;
                final StyleFactoryScope styleFactoryScope2 = styleFactoryScope;
                return companion.invoke(partial, map, new Function1<StackComponent, Result<? extends StackComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStackComponentStyle.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StackComponent stackComponent2) {
                        Intrinsics.checkNotNullParameter(stackComponent2, "stackComponent");
                        return styleFactory.createStackComponentStyle(styleFactoryScope2, stackComponent2);
                    }
                });
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        List components = stackComponent.getComponents();
        ArrayList<Result> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(components, 10));
        Iterator it = components.iterator();
        while (it.hasNext()) {
            arrayList.add(createInternal(styleFactoryScope, (PaywallComponent) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Result result : arrayList) {
            if (result instanceof Result.Success) {
                if (arrayList3.isEmpty()) {
                    arrayList2.add((ComponentStyle) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList3.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList3);
        Result.Success error = nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList2);
        if (error instanceof Result.Success) {
            error = new Result.Success(CollectionsKt.filterNotNull((List) ((Result.Success) error).getValue()));
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Badge badge = stackComponent.getBadge();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(badge != null ? BadgeStyleKt.toBadgeStyle(badge, new Function1<StackComponent, Result<? extends StackComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStackComponentStyle.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StackComponent stackComponent2) {
                Intrinsics.checkNotNullParameter(stackComponent2, "stackComponent");
                return StyleFactory.this.createStackComponentStyle(styleFactoryScope, stackComponent2);
            }
        }) : null);
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> resultCreateBackgroundStyles = createBackgroundStyles(stackComponent.getBackground(), stackComponent.getBackgroundColor());
        Border border = stackComponent.getBorder();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = stackComponent.getShadow();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, error, resultOrSuccessfullyNull, resultCreateBackgroundStyles, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3})));
        if (nonEmptyListOrNull2 != null) {
            return new Result.Error(nonEmptyListOrNull2);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Object value2 = ((Result.Success) error).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultCreateBackgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultCreateBackgroundStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        ShadowStyles shadowStyles = (ShadowStyles) ((Result.Success) resultOrSuccessfullyNull3).getValue();
        BorderStyles borderStyles = (BorderStyles) value5;
        BackgroundStyles backgroundStyles = (BackgroundStyles) value4;
        BadgeStyle badgeStyle = (BadgeStyle) value3;
        List list = (List) value2;
        List list2 = (List) value;
        Dimension dimension = stackComponent.getDimension();
        Boolean visible = stackComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = stackComponent.getSize();
        Float spacing = stackComponent.getSpacing();
        float fM9114constructorimpl = Dp.m9114constructorimpl(spacing != null ? spacing.floatValue() : 0.0f);
        PaddingValues paddingValues = PaddingKt.toPaddingValues(stackComponent.getPadding());
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(stackComponent.getMargin());
        Shape.Rectangle shape = stackComponent.getShape();
        if (shape == null) {
            shape = DEFAULT_SHAPE;
        }
        Shape shape2 = shape;
        StackComponent.Overflow overflow = stackComponent.getOverflow();
        return new Result.Success(new StackComponentStyle(list, dimension, zBooleanValue, size, fM9114constructorimpl, backgroundStyles, paddingValues, paddingValues2, shape2, borderStyles, shadowStyles, badgeStyle, overflow != null ? OverflowExtensionsKt.toOrientation(overflow, stackComponent.getDimension()) : null, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), styleFactoryScope.getCountdownDate(), styleFactoryScope.getCountFrom(), list2, styleFactoryScope.getApplyTopWindowInsets(), false, false, false, 14680064, null));
    }

    private final Result<StickyFooterComponentStyle, NonEmptyList<PaywallValidationError>> createStickyFooterComponentStyle(StyleFactoryScope styleFactoryScope, final StickyFooterComponent stickyFooterComponent) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends StickyFooterComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStickyFooterComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<StickyFooterComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                Result<StickyFooterComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withSelectedScope, stickyFooterComponent.getStack());
                if (resultCreateStackComponentStyle instanceof Result.Success) {
                    return new Result.Success(new StickyFooterComponentStyle((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                }
                if (resultCreateStackComponentStyle instanceof Result.Error) {
                    return resultCreateStackComponentStyle;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<TabControlButtonComponentStyle, NonEmptyList<PaywallValidationError>> createTabControlButtonComponentStyle(StyleFactoryScope styleFactoryScope, final TabControlButtonComponent tabControlButtonComponent) {
        return (Result) styleFactoryScope.withSelectedScope(null, Integer.valueOf(tabControlButtonComponent.getTabIndex()), new Function1<StyleFactoryScope, Result<? extends TabControlButtonComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabControlButtonComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabControlButtonComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                withSelectedScope.setDefaultTabIndex(0);
                Result<TabControlButtonComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withSelectedScope, tabControlButtonComponent.getStack());
                TabControlButtonComponent tabControlButtonComponent2 = tabControlButtonComponent;
                if (resultCreateStackComponentStyle instanceof Result.Success) {
                    return new Result.Success(new TabControlButtonComponentStyle(tabControlButtonComponent2.getTabIndex(), (StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                }
                if (resultCreateStackComponentStyle instanceof Result.Error) {
                    return resultCreateStackComponentStyle;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<TabControlToggleComponentStyle, NonEmptyList<PaywallValidationError>> createTabControlToggleComponentStyle(StyleFactoryScope styleFactoryScope, TabControlToggleComponent tabControlToggleComponent) {
        Result colorStyles = ColorStyleKt.toColorStyles(tabControlToggleComponent.getThumbColorOn(), this.colorAliases);
        Result colorStyles2 = ColorStyleKt.toColorStyles(tabControlToggleComponent.getThumbColorOff(), this.colorAliases);
        Result colorStyles3 = ColorStyleKt.toColorStyles(tabControlToggleComponent.getTrackColorOn(), this.colorAliases);
        Result colorStyles4 = ColorStyleKt.toColorStyles(tabControlToggleComponent.getTrackColorOff(), this.colorAliases);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{colorStyles, colorStyles2, colorStyles3, colorStyles4, success, success2})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(colorStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) colorStyles).getValue();
        Intrinsics.checkNotNull(colorStyles2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) colorStyles2).getValue();
        Intrinsics.checkNotNull(colorStyles3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) colorStyles3).getValue();
        Intrinsics.checkNotNull(colorStyles4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) colorStyles4).getValue();
        Object value5 = success.getValue();
        ColorStyles colorStyles5 = (ColorStyles) value4;
        ColorStyles colorStyles6 = (ColorStyles) value3;
        ColorStyles colorStyles7 = (ColorStyles) value2;
        ColorStyles colorStyles8 = (ColorStyles) value;
        styleFactoryScope.setDefaultTabIndex(tabControlToggleComponent.getDefaultValue() ? 1 : 0);
        return new Result.Success(new TabControlToggleComponentStyle(colorStyles8, colorStyles7, colorStyles6, colorStyles5));
    }

    private final Result<TabsComponentStyle, NonEmptyList<PaywallValidationError>> createTabsComponentStyle(StyleFactoryScope styleFactoryScope, TabsComponent tabsComponent) {
        Result resultCreateTabsComponentStyleTabControl = createTabsComponentStyleTabControl(styleFactoryScope, tabsComponent.getControl());
        if (!(resultCreateTabsComponentStyleTabControl instanceof Result.Success)) {
            if (resultCreateTabsComponentStyleTabControl instanceof Result.Error) {
                return resultCreateTabsComponentStyleTabControl;
            }
            throw new NoWhenBranchMatchedException();
        }
        TabControlStyle tabControlStyle = (TabControlStyle) ((Result.Success) resultCreateTabsComponentStyleTabControl).getValue();
        String defaultTabId = tabsComponent.getDefaultTabId();
        if (defaultTabId != null) {
            if (StringsKt.isBlank(defaultTabId)) {
                defaultTabId = null;
            }
            if (defaultTabId != null) {
                Iterator it = tabsComponent.getTabs().iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(((TabsComponent.Tab) it.next()).getId(), defaultTabId)) {
                        break;
                    }
                    i++;
                }
                Integer numValueOf = Integer.valueOf(i);
                if (numValueOf.intValue() == -1) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    styleFactoryScope.setDefaultTabIndex(Integer.valueOf(numValueOf.intValue()));
                }
            }
        }
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(tabsComponent.getOverrides(), this.stripRules, new Function1<PartialTabsComponent, Result<? extends PresentedTabsPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createTabsComponentStyle$1$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedTabsPartial, NonEmptyList<PaywallValidationError>> invoke(PartialTabsComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedTabsPartial.INSTANCE.invoke(partial, this.this$0.colorAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        Result<NonEmptyList<TabsComponentStyle.Tab>, NonEmptyList<PaywallValidationError>> resultCreateTabsComponentStyleTabs = createTabsComponentStyleTabs(styleFactoryScope, tabsComponent.getTabs(), tabControlStyle);
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> resultCreateBackgroundStyles = createBackgroundStyles(tabsComponent.getBackground(), tabsComponent.getBackgroundColor());
        Border border = tabsComponent.getBorder();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = tabsComponent.getShadow();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, resultCreateTabsComponentStyleTabs, resultCreateBackgroundStyles, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultCreateTabsComponentStyleTabs, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultCreateTabsComponentStyleTabs).getValue();
        Intrinsics.checkNotNull(resultCreateBackgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultCreateBackgroundStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        ShadowStyles shadowStyles = (ShadowStyles) value5;
        BorderStyles borderStyles = (BorderStyles) value4;
        BackgroundStyles backgroundStyles = (BackgroundStyles) value3;
        NonEmptyList nonEmptyList = (NonEmptyList) value2;
        List list = (List) value;
        boolean zBooleanValue = true;
        Boolean visible = tabsComponent.getVisible();
        if (visible != null) {
            zBooleanValue = visible.booleanValue();
        }
        boolean z = zBooleanValue;
        Size size = tabsComponent.getSize();
        PaddingValues paddingValues = PaddingKt.toPaddingValues(tabsComponent.getPadding());
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(tabsComponent.getMargin());
        Shape.Rectangle shape = tabsComponent.getShape();
        if (shape == null) {
            shape = DEFAULT_SHAPE;
        }
        return new Result.Success(new TabsComponentStyle(z, size, paddingValues, paddingValues2, backgroundStyles, shape, borderStyles, shadowStyles, tabControlStyle, nonEmptyList, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> createTabsComponentStyleTab(StyleFactoryScope styleFactoryScope, final TabsComponent.Tab tab, final TabControlStyle tabControlStyle, final int i) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTab.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                int i2 = i;
                final TabControlStyle tabControlStyle2 = tabControlStyle;
                final StyleFactory styleFactory = this;
                final TabsComponent.Tab tab2 = tab;
                return (Result) withSelectedScope.withTabIndex(i2, new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTab.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withTabIndex) {
                        Intrinsics.checkNotNullParameter(withTabIndex, "$this$withTabIndex");
                        TabControlStyle tabControlStyle3 = tabControlStyle2;
                        final StyleFactory styleFactory2 = styleFactory;
                        final TabsComponent.Tab tab3 = tab2;
                        return (Result) withTabIndex.withTabControl(tabControlStyle3, new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTab.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withTabControl) {
                                Intrinsics.checkNotNullParameter(withTabControl, "$this$withTabControl");
                                Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = styleFactory2.createStackComponentStyle(withTabControl, tab3.getStack());
                                if (resultCreateStackComponentStyle instanceof Result.Success) {
                                    return new Result.Success(new TabsComponentStyle.Tab((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                                }
                                if (resultCreateStackComponentStyle instanceof Result.Error) {
                                    return resultCreateStackComponentStyle;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                        });
                    }
                });
            }
        });
    }

    private final Result<TabControlStyle, NonEmptyList<PaywallValidationError>> createTabsComponentStyleTabControl(StyleFactoryScope styleFactoryScope, final TabsComponent.TabControl tabControl) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends TabControlStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTabControl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabControlStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                TabsComponent.TabControl tabControl2 = tabControl;
                if (tabControl2 instanceof TabsComponent.TabControl.Buttons) {
                    Result<TabControlStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = this.createStackComponentStyle(withSelectedScope, ((TabsComponent.TabControl.Buttons) tabControl2).getStack());
                    if (resultCreateStackComponentStyle instanceof Result.Success) {
                        return new Result.Success(new TabControlStyle.Buttons((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                    }
                    if (resultCreateStackComponentStyle instanceof Result.Error) {
                        return resultCreateStackComponentStyle;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (!(tabControl2 instanceof TabsComponent.TabControl.Toggle)) {
                    throw new NoWhenBranchMatchedException();
                }
                Result<TabControlStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle2 = this.createStackComponentStyle(withSelectedScope, ((TabsComponent.TabControl.Toggle) tabControl2).getStack());
                if (resultCreateStackComponentStyle2 instanceof Result.Success) {
                    return new Result.Success(new TabControlStyle.Toggle((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle2).getValue()));
                }
                if (resultCreateStackComponentStyle2 instanceof Result.Error) {
                    return resultCreateStackComponentStyle2;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<NonEmptyList<TabsComponentStyle.Tab>, NonEmptyList<PaywallValidationError>> createTabsComponentStyleTabs(final StyleFactoryScope styleFactoryScope, List<TabsComponent.Tab> list, final TabControlStyle tabControlStyle) {
        Result<NonEmptyList<TabsComponentStyle.Tab>, NonEmptyList<PaywallValidationError>> resultErrorIfNull = ResultKt.errorIfNull(NonEmptyListKt.toNonEmptyListOrNull(list), NonEmptyListKt.nonEmptyListOf(PaywallValidationError.TabsComponentWithoutTabs.INSTANCE, new PaywallValidationError.TabsComponentWithoutTabs[0]));
        if (resultErrorIfNull instanceof Result.Success) {
            return NonEmptyListKt.flatten(((NonEmptyList) ((Result.Success) resultErrorIfNull).getValue()).mapIndexed(new Function2<Integer, TabsComponent.Tab, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createTabsComponentStyleTabs$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(int i, TabsComponent.Tab tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                    return this.this$0.createTabsComponentStyleTab(styleFactoryScope, tab, tabControlStyle, i);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>> invoke(Integer num, TabsComponent.Tab tab) {
                    return invoke(num.intValue(), tab);
                }
            }));
        }
        if (resultErrorIfNull instanceof Result.Error) {
            return resultErrorIfNull;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009d A[LOOP:1: B:18:0x0097->B:20:0x009d, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Result<TextComponentStyle, NonEmptyList<PaywallValidationError>> createTextComponentStyle(StyleFactoryScope styleFactoryScope, TextComponent textComponent) {
        Result resultM10543getFontSpecpDyximM;
        Iterator it;
        Result.Success success;
        Result resultM10488stringForAllLocales7v81vok = LocalizationKt.m10488stringForAllLocales7v81vok(this.localizations, textComponent.getText());
        if (!(resultM10488stringForAllLocales7v81vok instanceof Result.Success)) {
            if (!(resultM10488stringForAllLocales7v81vok instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            NonEmptyList nonEmptyList = (NonEmptyList) ((Result.Error) resultM10488stringForAllLocales7v81vok).getValue();
            NonEmptyMap<LocaleId, NonEmptyMap<LocalizationKey, LocalizationData>> nonEmptyMap = this.localizations;
            if (nonEmptyMap.isEmpty()) {
                Logger.INSTANCE.w("Missing text for text_lid '" + textComponent.getText() + "', using empty string.");
                NonEmptyMap<LocaleId, NonEmptyMap<LocalizationKey, LocalizationData>> nonEmptyMap2 = this.localizations;
                Map map = ((NonEmptyMap) nonEmptyMap2).all;
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                it = map.entrySet().iterator();
                while (it.hasNext()) {
                    linkedHashMap.put(((Map.Entry) it.next()).getKey(), "");
                }
                success = new Result.Success(NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(nonEmptyMap2.getEntry().getKey(), MapsKt.getValue(linkedHashMap, nonEmptyMap2.getEntry().getKey())), linkedHashMap));
                resultM10488stringForAllLocales7v81vok = success;
            } else {
                Iterator<Map.Entry<LocaleId, NonEmptyMap<LocalizationKey, LocalizationData>>> it2 = nonEmptyMap.entrySet().iterator();
                while (it2.hasNext()) {
                    if (it2.next().getValue().containsKey(LocalizationKey.m10428boximpl(textComponent.getText()))) {
                        success = new Result.Error(nonEmptyList);
                        break;
                    }
                }
                Logger.INSTANCE.w("Missing text for text_lid '" + textComponent.getText() + "', using empty string.");
                NonEmptyMap<LocaleId, NonEmptyMap<LocalizationKey, LocalizationData>> nonEmptyMap22 = this.localizations;
                Map map2 = ((NonEmptyMap) nonEmptyMap22).all;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
                it = map2.entrySet().iterator();
                while (it.hasNext()) {
                }
                success = new Result.Success(NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(nonEmptyMap22.getEntry().getKey(), MapsKt.getValue(linkedHashMap2, nonEmptyMap22.getEntry().getKey())), linkedHashMap2));
                resultM10488stringForAllLocales7v81vok = success;
            }
        }
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(textComponent.getOverrides(), this.stripRules, new Function1<PartialTextComponent, Result<? extends LocalizedTextPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTextComponentStyle.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<LocalizedTextPartial, NonEmptyList<PaywallValidationError>> invoke(PartialTextComponent it3) {
                Intrinsics.checkNotNullParameter(it3, "it");
                return LocalizedTextPartial.INSTANCE.invoke(it3, StyleFactory.this.localizations, StyleFactory.this.colorAliases, StyleFactory.this.fontAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        Result colorStyles = ColorStyleKt.toColorStyles(textComponent.getColor(), this.colorAliases);
        ColorScheme backgroundColor = textComponent.getBackgroundColor();
        Result resultRecoverFromFontAliasError = null;
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, this.colorAliases) : null);
        String fontName = textComponent.getFontName();
        if (fontName != null && (resultM10543getFontSpecpDyximM = FontSpecKt.m10543getFontSpecpDyximM(this.fontAliases, fontName)) != null) {
            resultRecoverFromFontAliasError = FontSpecKt.recoverFromFontAliasError(resultM10543getFontSpecpDyximM);
        }
        Result.Error errorOrSuccessfullyNull = ResultKt.orSuccessfullyNull(resultRecoverFromFontAliasError);
        if (!(errorOrSuccessfullyNull instanceof Result.Success)) {
            if (!(errorOrSuccessfullyNull instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            errorOrSuccessfullyNull = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) errorOrSuccessfullyNull).getValue(), new PaywallValidationError[0]));
        }
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultM10488stringForAllLocales7v81vok, presentedOverrides, colorStyles, resultOrSuccessfullyNull, errorOrSuccessfullyNull, success2})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultM10488stringForAllLocales7v81vok, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultM10488stringForAllLocales7v81vok).getValue();
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(colorStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) colorStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(errorOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) errorOrSuccessfullyNull).getValue();
        FontSpec fontSpec = (FontSpec) value5;
        ColorStyles colorStyles2 = (ColorStyles) value4;
        ColorStyles colorStyles3 = (ColorStyles) value3;
        List list = (List) value2;
        NonEmptyMap nonEmptyMap3 = (NonEmptyMap) value;
        Integer fontWeightInt = textComponent.getFontWeightInt();
        FontWeight fontWeight = fontWeightInt != null ? new FontWeight(fontWeightInt.intValue()) : FontKt.toFontWeight(textComponent.getFontWeight());
        int fontSize = textComponent.getFontSize();
        TextAlign textAlignM8985boximpl = TextAlign.m8985boximpl(AlignmentKt.toTextAlign(textComponent.getHorizontalAlignment()));
        Alignment.Horizontal alignment = AlignmentKt.toAlignment(textComponent.getHorizontalAlignment());
        Boolean visible = textComponent.getVisible();
        return new Result.Success(new TextComponentStyle(nonEmptyMap3, colorStyles3, fontSize, fontWeight, fontSpec, textAlignM8985boximpl, alignment, colorStyles2, visible != null ? visible.booleanValue() : true, textComponent.getSize(), PaddingKt.toPaddingValues(textComponent.getPadding()), PaddingKt.toPaddingValues(textComponent.getMargin()), styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), styleFactoryScope.getCountdownDate(), styleFactoryScope.getCountFrom(), this.variableLocalizations, list, null));
    }

    private final Result<TimelineComponentStyle.ItemStyle, NonEmptyList<PaywallValidationError>> createTimelineComponentItemStyle(StyleFactoryScope styleFactoryScope, TimelineComponent.Item item) {
        ColorScheme color;
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(item.getOverrides(), this.stripRules, new Function1<PartialTimelineComponentItem, Result<? extends PresentedTimelineItemPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTimelineComponentItemStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedTimelineItemPartial, NonEmptyList<PaywallValidationError>> invoke(PartialTimelineComponentItem partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedTimelineItemPartial.INSTANCE.invoke(partial, StyleFactory.this.colorAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        Result<TextComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateTextComponentStyle = createTextComponentStyle(styleFactoryScope, item.getTitle());
        TextComponent description = item.getDescription();
        TimelineComponentStyle.ConnectorStyle connectorStyle = null;
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(description != null ? createTextComponentStyle(styleFactoryScope, description) : null);
        Result<IconComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateIconComponentStyle = createIconComponentStyle(styleFactoryScope, item.getIcon());
        TimelineComponent.Connector connector = item.getConnector();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull((connector == null || (color = connector.getColor()) == null) ? null : ColorStyleKt.toColorStyles(color, this.colorAliases));
        Result.Success success = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, resultCreateTextComponentStyle, resultOrSuccessfullyNull, resultCreateIconComponentStyle, resultOrSuccessfullyNull2, success})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultCreateTextComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultCreateTextComponentStyle).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultCreateIconComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultCreateIconComponentStyle).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        ColorStyles colorStyles = (ColorStyles) value5;
        IconComponentStyle iconComponentStyle = (IconComponentStyle) value4;
        TextComponentStyle textComponentStyle = (TextComponentStyle) value3;
        TextComponentStyle textComponentStyle2 = (TextComponentStyle) value2;
        List list = (List) value;
        TimelineComponent.Connector connector2 = item.getConnector();
        if (connector2 != null && colorStyles != null) {
            connectorStyle = new TimelineComponentStyle.ConnectorStyle(connector2.getWidth(), PaddingKt.toPaddingValues(connector2.getMargin()), colorStyles);
        }
        TimelineComponentStyle.ConnectorStyle connectorStyle2 = connectorStyle;
        Boolean visible = item.getVisible();
        return new Result.Success(new TimelineComponentStyle.ItemStyle(textComponentStyle2, visible != null ? visible.booleanValue() : true, textComponentStyle, iconComponentStyle, connectorStyle2, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list));
    }

    private final Result<TimelineComponentStyle, NonEmptyList<PaywallValidationError>> createTimelineComponentStyle(StyleFactoryScope styleFactoryScope, TimelineComponent timelineComponent) {
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(timelineComponent.getOverrides(), this.stripRules, new Function1<PartialTimelineComponent, Result<? extends PresentedTimelinePartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTimelineComponentStyle.1
            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedTimelinePartial, NonEmptyList<PaywallValidationError>> invoke(PartialTimelineComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return new Result.Success(new PresentedTimelinePartial(partial));
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        List items = timelineComponent.getItems();
        ArrayList<Result> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        Iterator it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(createTimelineComponentItemStyle(styleFactoryScope, (TimelineComponent.Item) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Result result : arrayList) {
            if (result instanceof Result.Success) {
                if (arrayList3.isEmpty()) {
                    arrayList2.add((TimelineComponentStyle.ItemStyle) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList3.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList3);
        Result.Success error = nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList2);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        Result.Success success4 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, error, success, success2, success3, success4})));
        if (nonEmptyListOrNull2 != null) {
            return new Result.Error(nonEmptyListOrNull2);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Object value2 = ((Result.Success) error).getValue();
        Object value3 = success.getValue();
        Object value4 = success2.getValue();
        Object value5 = success3.getValue();
        List list = (List) value2;
        List list2 = (List) value;
        int itemSpacing = timelineComponent.getItemSpacing();
        int textSpacing = timelineComponent.getTextSpacing();
        int columnGutter = timelineComponent.getColumnGutter();
        TimelineComponent.IconAlignment iconAlignment = timelineComponent.getIconAlignment();
        Boolean visible = timelineComponent.getVisible();
        return new Result.Success(new TimelineComponentStyle(itemSpacing, textSpacing, columnGutter, iconAlignment, visible != null ? visible.booleanValue() : true, timelineComponent.getSize(), PaddingKt.toPaddingValues(timelineComponent.getPadding()), PaddingKt.toPaddingValues(timelineComponent.getMargin()), list, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list2));
    }

    private final Result<VideoComponentStyle, NonEmptyList<PaywallValidationError>> createVideoComponentStyle(StyleFactoryScope styleFactoryScope, VideoComponent videoComponent) {
        Result.Error presentedOverrides;
        PaddingValues paddingValuesM2032PaddingValuesYgX7TsA$default;
        PaddingValues paddingValuesM2032PaddingValuesYgX7TsA$default2;
        Result<NonEmptyMap<LocaleId, ThemeVideoUrls>, NonEmptyList<PaywallValidationError.MissingVideoLocalization>> resultM10597withLocalizedOverridesTDPsjl0 = m10597withLocalizedOverridesTDPsjl0(videoComponent.getSource(), videoComponent.getOverrideSourceLid());
        ThemeImageUrls fallbackSource = videoComponent.getFallbackSource();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(fallbackSource != null ? m10596withLocalizedOverridesTDPsjl0(fallbackSource, videoComponent.getOverrideSourceLid()) : null);
        List overrides = videoComponent.getOverrides();
        if (overrides == null || (presentedOverrides = PresentedPartialKt.toPresentedOverrides(overrides, this.stripRules, new Function1<PartialVideoComponent, Result<? extends PresentedVideoPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createVideoComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedVideoPartial, NonEmptyList<PaywallValidationError>> invoke(PartialVideoComponent videoPartial) {
                Result resultM10596withLocalizedOverridesTDPsjl0;
                Intrinsics.checkNotNullParameter(videoPartial, "videoPartial");
                ThemeVideoUrls source = videoPartial.getSource();
                NonEmptyMap nonEmptyMap = null;
                Result<PresentedVideoPartial, NonEmptyList<PaywallValidationError>> resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(source != null ? StyleFactory.this.m10597withLocalizedOverridesTDPsjl0(source, videoPartial.getOverrideSourceLid()) : null);
                StyleFactory styleFactory = StyleFactory.this;
                if (!(resultOrSuccessfullyNull2 instanceof Result.Success)) {
                    if (resultOrSuccessfullyNull2 instanceof Result.Error) {
                        return resultOrSuccessfullyNull2;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                NonEmptyMap nonEmptyMap2 = (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull2).getValue();
                PresentedVideoPartial.Companion companion = PresentedVideoPartial.INSTANCE;
                ThemeImageUrls fallbackSource2 = videoPartial.getFallbackSource();
                if (fallbackSource2 != null && (resultM10596withLocalizedOverridesTDPsjl0 = styleFactory.m10596withLocalizedOverridesTDPsjl0(fallbackSource2, videoPartial.getOverrideSourceLid())) != null && (resultM10596withLocalizedOverridesTDPsjl0 instanceof Result.Success)) {
                    nonEmptyMap = (NonEmptyMap) ((Result.Success) resultM10596withLocalizedOverridesTDPsjl0).getValue();
                }
                return companion.invoke(videoPartial, nonEmptyMap2, nonEmptyMap, styleFactory.colorAliases);
            }
        })) == null) {
            presentedOverrides = null;
        } else if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(presentedOverrides);
        ColorScheme colorOverlay = videoComponent.getColorOverlay();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(colorOverlay != null ? ColorStyleKt.toColorStyles(colorOverlay, this.colorAliases) : null);
        Border border = videoComponent.getBorder();
        Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = videoComponent.getShadow();
        Result resultOrSuccessfullyNull5 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultM10597withLocalizedOverridesTDPsjl0, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, resultOrSuccessfullyNull4, resultOrSuccessfullyNull5})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultM10597withLocalizedOverridesTDPsjl0, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultM10597withLocalizedOverridesTDPsjl0).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull4).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull5, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        ShadowStyles shadowStyles = (ShadowStyles) ((Result.Success) resultOrSuccessfullyNull5).getValue();
        BorderStyles borderStyles = (BorderStyles) value5;
        ColorStyles colorStyles = (ColorStyles) value4;
        List listEmptyList = (List) value3;
        NonEmptyMap nonEmptyMap = (NonEmptyMap) value2;
        NonEmptyMap nonEmptyMap2 = (NonEmptyMap) value;
        Boolean visible = videoComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = videoComponent.getSize();
        Padding padding = videoComponent.getPadding();
        if (padding == null || (paddingValuesM2032PaddingValuesYgX7TsA$default = PaddingKt.toPaddingValues(padding)) == null) {
            paddingValuesM2032PaddingValuesYgX7TsA$default = androidx.compose.foundation.layout.PaddingKt.m2032PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null);
        }
        PaddingValues paddingValues = paddingValuesM2032PaddingValuesYgX7TsA$default;
        Padding margin = videoComponent.getMargin();
        if (margin == null || (paddingValuesM2032PaddingValuesYgX7TsA$default2 = PaddingKt.toPaddingValues(margin)) == null) {
            paddingValuesM2032PaddingValuesYgX7TsA$default2 = androidx.compose.foundation.layout.PaddingKt.m2032PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null);
        }
        PaddingValues paddingValues2 = paddingValuesM2032PaddingValuesYgX7TsA$default2;
        Package rcPackage = styleFactoryScope.getRcPackage();
        ResolvedOffer resolvedOffer = styleFactoryScope.getResolvedOffer();
        Integer tabControlIndex = styleFactoryScope.getTabControlIndex();
        OfferEligibility offerEligibility = styleFactoryScope.getOfferEligibility();
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list = listEmptyList;
        boolean showControls = videoComponent.getShowControls();
        boolean autoplay = videoComponent.getAutoplay();
        boolean loop = videoComponent.getLoop();
        boolean muteAudio = videoComponent.getMuteAudio();
        MaskShape maskShape = videoComponent.getMaskShape();
        return new Result.Success(new VideoComponentStyle(nonEmptyMap2, nonEmptyMap, showControls, autoplay, loop, muteAudio, size, zBooleanValue, paddingValues, paddingValues2, maskShape != null ? ShapeKt.toShape(maskShape) : null, borderStyles, shadowStyles, colorStyles, FitModeKt.toContentScale(videoComponent.getFitMode()), rcPackage, resolvedOffer, tabControlIndex, offerEligibility, styleFactoryScope.getIgnoreTopWindowInsets(), list));
    }

    private final Package getPackageOrNull(Offering offering, String str) {
        try {
            return offering.getPackage(str);
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: withLocalizedOverrides-TDPsjl0, reason: not valid java name */
    public final Result<NonEmptyMap<LocaleId, ThemeImageUrls>, NonEmptyList<PaywallValidationError.MissingImageLocalization>> m10596withLocalizedOverridesTDPsjl0(ThemeImageUrls themeImageUrls, String str) {
        Result<NonEmptyMap<LocaleId, ThemeImageUrls>, NonEmptyList<PaywallValidationError.MissingImageLocalization>> resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(str != null ? LocalizationKt.m10486imageForAllLocales7v81vok(this.localizations, str) : null);
        if (!(resultOrSuccessfullyNull instanceof Result.Success)) {
            if (resultOrSuccessfullyNull instanceof Result.Error) {
                return resultOrSuccessfullyNull;
            }
            throw new NoWhenBranchMatchedException();
        }
        NonEmptyMap nonEmptyMap = (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull).getValue();
        Pair pair = TuplesKt.to(this.localizations.getEntry().getKey(), themeImageUrls);
        NonEmptyMap nonEmptyMapEmptyMap = nonEmptyMap;
        if (nonEmptyMapEmptyMap == null) {
            nonEmptyMapEmptyMap = MapsKt.emptyMap();
        }
        return new Result.Success(NonEmptyMapKt.nonEmptyMapOf(pair, nonEmptyMapEmptyMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: withLocalizedOverrides-TDPsjl0, reason: not valid java name */
    public final Result<NonEmptyMap<LocaleId, ThemeVideoUrls>, NonEmptyList<PaywallValidationError.MissingVideoLocalization>> m10597withLocalizedOverridesTDPsjl0(ThemeVideoUrls themeVideoUrls, String str) {
        Result<NonEmptyMap<LocaleId, ThemeVideoUrls>, NonEmptyList<PaywallValidationError.MissingVideoLocalization>> resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(str != null ? LocalizationKt.m10492videoForAllLocales7v81vok(this.localizations, str) : null);
        if (!(resultOrSuccessfullyNull instanceof Result.Success)) {
            if (resultOrSuccessfullyNull instanceof Result.Error) {
                return resultOrSuccessfullyNull;
            }
            throw new NoWhenBranchMatchedException();
        }
        NonEmptyMap nonEmptyMap = (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull).getValue();
        Pair pair = TuplesKt.to(this.localizations.getEntry().getKey(), themeVideoUrls);
        NonEmptyMap nonEmptyMapEmptyMap = nonEmptyMap;
        if (nonEmptyMapEmptyMap == null) {
            nonEmptyMapEmptyMap = MapsKt.emptyMap();
        }
        return new Result.Success(NonEmptyMapKt.nonEmptyMapOf(pair, nonEmptyMapEmptyMap));
    }

    public final Result<StyleResult, NonEmptyList<PaywallValidationError>> create(PaywallComponent component, boolean applyTopWindowInsets, boolean applyBottomWindowInsets, boolean applyHorizontalWindowInsets) {
        Intrinsics.checkNotNullParameter(component, "component");
        StyleFactoryScope styleFactoryScope = new StyleFactoryScope(null, null, null, null, null, null, null, null, 255, null);
        Result.Error errorCreateInternal = createInternal(styleFactoryScope, component);
        if (errorCreateInternal instanceof Result.Success) {
            ComponentStyle componentStyle = (ComponentStyle) ((Result.Success) errorCreateInternal).getValue();
            errorCreateInternal = componentStyle != null ? new Result.Success(componentStyle) : new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.RootComponentUnsupportedProperties(component), new PaywallValidationError.RootComponentUnsupportedProperties[0]));
        } else if (!(errorCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (errorCreateInternal instanceof Result.Success) {
            ComponentStyle componentStyleApplyTopWindowInsetsIfNotYetApplied = (ComponentStyle) ((Result.Success) errorCreateInternal).getValue();
            if (applyTopWindowInsets) {
                componentStyleApplyTopWindowInsetsIfNotYetApplied = styleFactoryScope.applyTopWindowInsetsIfNotYetApplied(componentStyleApplyTopWindowInsetsIfNotYetApplied);
            }
            errorCreateInternal = new Result.Success(componentStyleApplyTopWindowInsetsIfNotYetApplied);
        } else if (!(errorCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (errorCreateInternal instanceof Result.Success) {
            errorCreateInternal = new Result.Success(styleFactoryScope.applyBottomWindowInsetsIfNecessary((ComponentStyle) ((Result.Success) errorCreateInternal).getValue(), applyBottomWindowInsets));
        } else if (!(errorCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (errorCreateInternal instanceof Result.Success) {
            errorCreateInternal = new Result.Success(styleFactoryScope.applyHorizontalWindowInsetsIfNecessary((ComponentStyle) ((Result.Success) errorCreateInternal).getValue(), applyHorizontalWindowInsets));
        } else if (!(errorCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (errorCreateInternal instanceof Result.Success) {
            return new Result.Success(new StyleResult((ComponentStyle) ((Result.Success) errorCreateInternal).getValue(), styleFactoryScope.getPackages(), styleFactoryScope.getDefaultTabIndex(), styleFactoryScope.getHeroImageDetected()));
        }
        if (errorCreateInternal instanceof Result.Error) {
            return errorCreateInternal;
        }
        throw new NoWhenBranchMatchedException();
    }
}
