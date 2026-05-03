package com.revenuecat.purchases.ui.revenuecatui.components.video;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.PartialVideoComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.VideoUrls;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedVideoPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.SizeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.AspectRatio;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.VideoComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UnsignedKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoComponentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\r\u0012\u001a\b\u0002\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\r¢\u0006\u0002\u0010\u0019J?\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\t¢\u0006\u0003\u0010\u0092\u0001JA\u0010\u0093\u0001\u001a\u00030\u0094\u0001*\u00030\u0094\u00012\b\u0010\u0095\u0001\u001a\u00030\u0094\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\b\u0010\u0098\u0001\u001a\u00030\u0097\u00012\u0006\u00102\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u001f\u0010\u009b\u0001\u001a\u00020r*\u00020r2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u00102\u001a\u00020\u0005H\u0002R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010 \u001a\u0004\u0018\u00010!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b'\u0010(R \u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\rX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R+\u00102\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b7\u00101\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001d\u00108\u001a\u0004\u0018\u00010\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u001f\u001a\u0004\b9\u0010\u001dR\u001d\u0010;\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u001f\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010A8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u001f\u001a\u0004\bB\u0010CR\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u001f\u001a\u0004\bG\u0010HR+\u0010J\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bO\u00101\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010P\u001a\u00020Q8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u001f\u001a\u0004\bR\u0010SR\u001d\u0010U\u001a\u0004\u0018\u00010\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u001f\u001a\u0004\bV\u0010\u001dR\u001d\u0010X\u001a\u0004\u0018\u00010Y8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u001f\u001a\u0004\bZ\u0010[R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010_\u001a\u00020Q8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\u001f\u001a\u0004\b`\u0010SR\u001d\u0010b\u001a\u0004\u0018\u00010c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\u001f\u001a\u0004\bd\u0010eR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010g\u001a\u0004\u0018\u00010h8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u001f\u001a\u0004\bi\u0010jR\u001d\u0010l\u001a\u0004\u0018\u00010m8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\u001f\u001a\u0004\bn\u0010oR\u001b\u0010q\u001a\u00020r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\u001f\u001a\u0004\bs\u0010tR\u001b\u0010v\u001a\u00020r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\u001f\u001a\u0004\bw\u0010tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010y\u001a\u00020z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b}\u0010\u001f\u001a\u0004\b{\u0010|R\u001d\u0010~\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\u001f\u001a\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0082\u0001\u001a\u00030\u0083\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0086\u0001\u0010\u001f\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001e\u0010\u0087\u0001\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010\u001f\u001a\u0005\b\u0088\u0001\u0010-R1\u0010\u008a\u0001\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0005\b\u008f\u0001\u00101\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/video/VideoComponentState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", "initialDensity", "Landroidx/compose/ui/unit/Density;", "initialDarkMode", "", "initialLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;", "localeProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/text/intl/Locale;", "selectedPackageInfoProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Landroidx/compose/ui/unit/Density;ZLandroidx/compose/ui/unit/LayoutDirection;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "aspectRatio", "Lcom/revenuecat/purchases/ui/revenuecatui/components/modifier/AspectRatio;", "getAspectRatio", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/modifier/AspectRatio;", "aspectRatio$delegate", "Landroidx/compose/runtime/State;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "border$delegate", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "contentScale$delegate", "<set-?>", "darkMode", "getDarkMode", "()Z", "setDarkMode", "(Z)V", "darkMode$delegate", "Landroidx/compose/runtime/MutableState;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "fallbackAspectRatio", "getFallbackAspectRatio", "fallbackAspectRatio$delegate", "fallbackImageUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "getFallbackImageUrls", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "fallbackImageUrls$delegate", "fallbackUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "getFallbackUrls", "()Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "fallbackUrls$delegate", "imageAspectRatio", "", "getImageAspectRatio", "()Ljava/lang/Float;", "imageAspectRatio$delegate", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "margin$delegate", "marginAdjustedAspectRatio", "getMarginAdjustedAspectRatio", "marginAdjustedAspectRatio$delegate", "overlay", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getOverlay", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "overlay$delegate", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "padding", "getPadding", "padding$delegate", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedVideoPartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedVideoPartial;", "presentedPartial$delegate", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "shadow$delegate", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "shape$delegate", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size$delegate", "sizePlusMargin", "getSizePlusMargin", "sizePlusMargin$delegate", "themeVideoUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "getThemeVideoUrls", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "themeVideoUrls$delegate", "videoAspectRatio", "getVideoAspectRatio", "()F", "videoAspectRatio$delegate", "videoUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "getVideoUrls", "()Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "videoUrls$delegate", "visible", "getVisible", "visible$delegate", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "update", "", "(Landroidx/window/core/layout/WindowWidthSizeClass;Landroidx/compose/ui/unit/Density;Ljava/lang/Boolean;Landroidx/compose/ui/unit/LayoutDirection;)V", "adjustDimension", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "other", "thisDimensionPx", "Lkotlin/UInt;", "otherDimensionPx", "adjustDimension-yOCu0fQ", "(Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;IILandroidx/compose/ui/unit/Density;)Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "adjustForVideo", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VideoComponentState {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: aspectRatio$delegate, reason: from kotlin metadata */
    private final State aspectRatio;

    /* JADX INFO: renamed from: border$delegate, reason: from kotlin metadata */
    private final State border;

    /* JADX INFO: renamed from: contentScale$delegate, reason: from kotlin metadata */
    private final State contentScale;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;

    /* JADX INFO: renamed from: darkMode$delegate, reason: from kotlin metadata */
    private final MutableState darkMode;

    /* JADX INFO: renamed from: density$delegate, reason: from kotlin metadata */
    private final MutableState density;

    /* JADX INFO: renamed from: fallbackAspectRatio$delegate, reason: from kotlin metadata */
    private final State fallbackAspectRatio;

    /* JADX INFO: renamed from: fallbackImageUrls$delegate, reason: from kotlin metadata */
    private final State fallbackImageUrls;

    /* JADX INFO: renamed from: fallbackUrls$delegate, reason: from kotlin metadata */
    private final State fallbackUrls;

    /* JADX INFO: renamed from: imageAspectRatio$delegate, reason: from kotlin metadata */
    private final State imageAspectRatio;

    /* JADX INFO: renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final Function0<Locale> localeProvider;

    /* JADX INFO: renamed from: margin$delegate, reason: from kotlin metadata */
    private final State margin;

    /* JADX INFO: renamed from: marginAdjustedAspectRatio$delegate, reason: from kotlin metadata */
    private final State marginAdjustedAspectRatio;

    /* JADX INFO: renamed from: overlay$delegate, reason: from kotlin metadata */
    private final State overlay;
    private final PackageAwareDelegate packageAwareDelegate;

    /* JADX INFO: renamed from: padding$delegate, reason: from kotlin metadata */
    private final State padding;

    /* JADX INFO: renamed from: presentedPartial$delegate, reason: from kotlin metadata */
    private final State presentedPartial;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;

    /* JADX INFO: renamed from: shadow$delegate, reason: from kotlin metadata */
    private final State shadow;

    /* JADX INFO: renamed from: shape$delegate, reason: from kotlin metadata */
    private final State shape;

    /* JADX INFO: renamed from: size$delegate, reason: from kotlin metadata */
    private final State size;

    /* JADX INFO: renamed from: sizePlusMargin$delegate, reason: from kotlin metadata */
    private final State sizePlusMargin;
    private final VideoComponentStyle style;

    /* JADX INFO: renamed from: themeVideoUrls$delegate, reason: from kotlin metadata */
    private final State themeVideoUrls;

    /* JADX INFO: renamed from: videoAspectRatio$delegate, reason: from kotlin metadata */
    private final State videoAspectRatio;

    /* JADX INFO: renamed from: videoUrls$delegate, reason: from kotlin metadata */
    private final State videoUrls;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final State visible;

    /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
    private final MutableState windowSize;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoComponentState(WindowWidthSizeClass initialWindowSize, Density initialDensity, boolean z, LayoutDirection initialLayoutDirection, VideoComponentStyle style, Function0<Locale> localeProvider, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
        Intrinsics.checkNotNullParameter(initialDensity, "initialDensity");
        Intrinsics.checkNotNullParameter(initialLayoutDirection, "initialLayoutDirection");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        Intrinsics.checkNotNullParameter(customVariablesProvider, "customVariablesProvider");
        this.style = style;
        this.localeProvider = localeProvider;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.customVariablesProvider = customVariablesProvider;
        this.windowSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialWindowSize, null, 2, null);
        this.density = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialDensity, null, 2, null);
        this.darkMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialLayoutDirection, null, 2, null);
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0<PresentedVideoPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$presentedPartial$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PresentedVideoPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedVideoPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.themeVideoUrls = SnapshotStateKt.derivedStateOf(new Function0<ThemeVideoUrls>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$themeVideoUrls$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final ThemeVideoUrls invoke() {
                NonEmptyMap sources;
                ThemeVideoUrls themeVideoUrls;
                String localeId = LocalizationKt.toLocaleId((Locale) this.this$0.localeProvider.invoke());
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial != null && (sources = presentedPartial.getSources()) != null && (themeVideoUrls = (ThemeVideoUrls) sources.getOrDefault(LocaleId.m10392boximpl(localeId), sources.getEntry().getValue())) != null) {
                    return themeVideoUrls;
                }
                NonEmptyMap sources2 = this.this$0.style.getSources();
                return (ThemeVideoUrls) sources2.getOrDefault(LocaleId.m10392boximpl(localeId), sources2.getEntry().getValue());
            }
        });
        this.fallbackImageUrls = SnapshotStateKt.derivedStateOf(new Function0<ThemeImageUrls>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$fallbackImageUrls$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final ThemeImageUrls invoke() {
                NonEmptyMap fallbackSources;
                String localeId = LocalizationKt.toLocaleId((Locale) this.this$0.localeProvider.invoke());
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial == null || (fallbackSources = presentedPartial.getFallbackSources()) == null) {
                    fallbackSources = this.this$0.style.getFallbackSources();
                }
                if (fallbackSources != null) {
                    return (ThemeImageUrls) fallbackSources.getOrDefault(LocaleId.m10392boximpl(localeId), fallbackSources.getEntry().getValue());
                }
                return null;
            }
        });
        this.visible = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$visible$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialVideoComponent partial;
                Boolean visible;
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.videoUrls = SnapshotStateKt.derivedStateOf(new Function0<VideoUrls>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$videoUrls$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoUrls invoke() {
                ThemeVideoUrls themeVideoUrls;
                boolean darkMode = this.this$0.getDarkMode();
                VideoComponentState videoComponentState = this.this$0;
                if (darkMode) {
                    VideoUrls dark = videoComponentState.getThemeVideoUrls().getDark();
                    if (dark != null) {
                        return dark;
                    }
                    themeVideoUrls = this.this$0.getThemeVideoUrls();
                } else {
                    themeVideoUrls = videoComponentState.getThemeVideoUrls();
                }
                return themeVideoUrls.getLight();
            }
        });
        this.fallbackUrls = SnapshotStateKt.derivedStateOf(new Function0<ImageUrls>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$fallbackUrls$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageUrls invoke() {
                ImageUrls dark;
                boolean darkMode = this.this$0.getDarkMode();
                VideoComponentState videoComponentState = this.this$0;
                if (!darkMode) {
                    ThemeImageUrls fallbackImageUrls = videoComponentState.getFallbackImageUrls();
                    if (fallbackImageUrls != null) {
                        return fallbackImageUrls.getLight();
                    }
                    return null;
                }
                ThemeImageUrls fallbackImageUrls2 = videoComponentState.getFallbackImageUrls();
                if (fallbackImageUrls2 != null && (dark = fallbackImageUrls2.getDark()) != null) {
                    return dark;
                }
                ThemeImageUrls fallbackImageUrls3 = this.this$0.getFallbackImageUrls();
                if (fallbackImageUrls3 != null) {
                    return fallbackImageUrls3.getLight();
                }
                return null;
            }
        });
        this.imageAspectRatio = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$imageAspectRatio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                ImageUrls fallbackUrls = this.this$0.getFallbackUrls();
                if (fallbackUrls == null) {
                    return null;
                }
                return Float.valueOf(((float) UnsignedKt.uintToDouble(fallbackUrls.getWidth())) / ((float) UnsignedKt.uintToDouble(fallbackUrls.getHeight())));
            }
        });
        this.videoAspectRatio = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$videoAspectRatio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(((float) UnsignedKt.uintToDouble(this.this$0.getVideoUrls().getWidth())) / ((float) UnsignedKt.uintToDouble(this.this$0.getVideoUrls().getHeight())));
            }
        });
        this.size = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$size$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                Size size;
                PartialVideoComponent partial;
                VideoComponentState videoComponentState = this.this$0;
                PresentedVideoPartial presentedPartial = videoComponentState.getPresentedPartial();
                if (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) {
                    size = this.this$0.style.getSize();
                }
                return videoComponentState.adjustForVideo(size, this.this$0.getVideoUrls(), this.this$0.getDensity());
            }
        });
        this.aspectRatio = SnapshotStateKt.derivedStateOf(new Function0<AspectRatio>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$aspectRatio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AspectRatio invoke() {
                Size size = this.this$0.getSize();
                VideoComponentState videoComponentState = this.this$0;
                SizeConstraint height = size.getHeight();
                if (height instanceof SizeConstraint.Fit) {
                    SizeConstraint width = size.getWidth();
                    if (!(width instanceof SizeConstraint.Fit) && !(width instanceof SizeConstraint.Fill)) {
                        if (width instanceof SizeConstraint.Fixed) {
                            return null;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new AspectRatio(videoComponentState.getVideoAspectRatio(), true);
                }
                if (height instanceof SizeConstraint.Fill) {
                    SizeConstraint width2 = size.getWidth();
                    if (width2 instanceof SizeConstraint.Fit) {
                        return new AspectRatio(videoComponentState.getVideoAspectRatio(), false);
                    }
                    if ((width2 instanceof SizeConstraint.Fill) || (width2 instanceof SizeConstraint.Fixed)) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (!(height instanceof SizeConstraint.Fixed)) {
                    throw new NoWhenBranchMatchedException();
                }
                SizeConstraint width3 = size.getWidth();
                if ((width3 instanceof SizeConstraint.Fit) || (width3 instanceof SizeConstraint.Fill)) {
                    return null;
                }
                if (width3 instanceof SizeConstraint.Fixed) {
                    return new AspectRatio(((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) width3).getValue())) / ((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) height).getValue())), true);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        this.fallbackAspectRatio = SnapshotStateKt.derivedStateOf(new Function0<AspectRatio>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$fallbackAspectRatio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AspectRatio invoke() {
                Float imageAspectRatio = this.this$0.getImageAspectRatio();
                if (imageAspectRatio == null) {
                    return null;
                }
                VideoComponentState videoComponentState = this.this$0;
                float fFloatValue = imageAspectRatio.floatValue();
                Size size = videoComponentState.getSize();
                SizeConstraint height = size.getHeight();
                if (height instanceof SizeConstraint.Fit) {
                    SizeConstraint width = size.getWidth();
                    if (!(width instanceof SizeConstraint.Fit) && !(width instanceof SizeConstraint.Fill)) {
                        if (width instanceof SizeConstraint.Fixed) {
                            return null;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new AspectRatio(fFloatValue, true);
                }
                if (height instanceof SizeConstraint.Fill) {
                    SizeConstraint width2 = size.getWidth();
                    if (width2 instanceof SizeConstraint.Fit) {
                        return new AspectRatio(fFloatValue, false);
                    }
                    if ((width2 instanceof SizeConstraint.Fill) || (width2 instanceof SizeConstraint.Fixed)) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (!(height instanceof SizeConstraint.Fixed)) {
                    throw new NoWhenBranchMatchedException();
                }
                SizeConstraint width3 = size.getWidth();
                if ((width3 instanceof SizeConstraint.Fit) || (width3 instanceof SizeConstraint.Fill)) {
                    return null;
                }
                if (width3 instanceof SizeConstraint.Fixed) {
                    return new AspectRatio(((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) width3).getValue())) / ((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) height).getValue())), true);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        this.padding = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$padding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialVideoComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$margin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialVideoComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.sizePlusMargin = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$sizePlusMargin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                return SizeKt.addMargin(this.this$0.getSize(), this.this$0.getMargin(), this.this$0.getLayoutDirection());
            }
        });
        this.marginAdjustedAspectRatio = SnapshotStateKt.derivedStateOf(new Function0<AspectRatio>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$marginAdjustedAspectRatio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AspectRatio invoke() {
                Size sizePlusMargin = this.this$0.getSizePlusMargin();
                SizeConstraint height = sizePlusMargin.getHeight();
                if (!(height instanceof SizeConstraint.Fixed)) {
                    if (height instanceof SizeConstraint.Fit ? true : height instanceof SizeConstraint.Fill) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                SizeConstraint width = sizePlusMargin.getWidth();
                if (width instanceof SizeConstraint.Fit ? true : width instanceof SizeConstraint.Fill) {
                    return null;
                }
                if (width instanceof SizeConstraint.Fixed) {
                    return new AspectRatio(((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) width).getValue())) / ((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) height).getValue())), true);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        this.shape = SnapshotStateKt.derivedStateOf(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$shape$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                PartialVideoComponent partial;
                MaskShape maskShape;
                Shape shape;
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (maskShape = partial.getMaskShape()) == null || (shape = ShapeKt.toShape(maskShape)) == null) ? this.this$0.style.getShape() : shape;
            }
        });
        this.border = SnapshotStateKt.derivedStateOf(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$border$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                BorderStyles border;
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (border = presentedPartial.getBorder()) == null) ? this.this$0.style.getBorder() : border;
            }
        });
        this.shadow = SnapshotStateKt.derivedStateOf(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$shadow$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                ShadowStyles shadow;
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (shadow = presentedPartial.getShadow()) == null) ? this.this$0.style.getShadow() : shadow;
            }
        });
        this.overlay = SnapshotStateKt.derivedStateOf(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$overlay$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                ColorStyles overlay;
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (overlay = presentedPartial.getOverlay()) == null) ? this.this$0.style.getOverlay() : overlay;
            }
        });
        this.contentScale = SnapshotStateKt.derivedStateOf(new Function0<ContentScale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState$contentScale$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ContentScale invoke() {
                PartialVideoComponent partial;
                FitMode fitMode;
                ContentScale contentScale;
                PresentedVideoPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (fitMode = partial.getFitMode()) == null || (contentScale = FitModeKt.toContentScale(fitMode)) == null) ? this.this$0.style.getContentScale() : contentScale;
            }
        });
    }

    public /* synthetic */ VideoComponentState(WindowWidthSizeClass windowWidthSizeClass, Density density, boolean z, LayoutDirection layoutDirection, VideoComponentStyle videoComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, density, z, layoutDirection, videoComponentStyle, function0, function02, function03, function04, (i & 512) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function05);
    }

    /* JADX INFO: renamed from: adjustDimension-yOCu0fQ, reason: not valid java name */
    private final SizeConstraint m10614adjustDimensionyOCu0fQ(SizeConstraint sizeConstraint, SizeConstraint sizeConstraint2, int i, int i2, Density density) {
        if (!(sizeConstraint instanceof SizeConstraint.Fit)) {
            if (!(sizeConstraint instanceof SizeConstraint.Fill ? true : sizeConstraint instanceof SizeConstraint.Fixed)) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (sizeConstraint2 instanceof SizeConstraint.Fit) {
                return new SizeConstraint.Fixed(UnsignedKt.doubleToUInt(density.mo1621toDpu2uoSUM(i)), null);
            }
            if (!(sizeConstraint2 instanceof SizeConstraint.Fill)) {
                if (sizeConstraint2 instanceof SizeConstraint.Fixed) {
                    return new SizeConstraint.Fixed(UnsignedKt.doubleToUInt(density.mo1620toDpu2uoSUM((((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) sizeConstraint2).getValue())) / density.mo1621toDpu2uoSUM(i2)) * i)), null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return sizeConstraint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Size adjustForVideo(Size size, VideoUrls videoUrls, Density density) {
        return new Size(m10614adjustDimensionyOCu0fQ(size.getWidth(), size.getHeight(), videoUrls.getWidth(), videoUrls.getHeight(), density), m10614adjustDimensionyOCu0fQ(size.getHeight(), size.getWidth(), videoUrls.getHeight(), videoUrls.getWidth(), density));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getDarkMode() {
        return ((Boolean) this.darkMode.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density getDensity() {
        return (Density) this.density.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThemeImageUrls getFallbackImageUrls() {
        return (ThemeImageUrls) this.fallbackImageUrls.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Float getImageAspectRatio() {
        return (Float) this.imageAspectRatio.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedVideoPartial getPresentedPartial() {
        return (PresentedVideoPartial) this.presentedPartial.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThemeVideoUrls getThemeVideoUrls() {
        return (ThemeVideoUrls) this.themeVideoUrls.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getVideoAspectRatio() {
        return ((Number) this.videoAspectRatio.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize.getValue();
    }

    private final void setDarkMode(boolean z) {
        this.darkMode.setValue(Boolean.valueOf(z));
    }

    private final void setDensity(Density density) {
        this.density.setValue(density);
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(VideoComponentState videoComponentState, WindowWidthSizeClass windowWidthSizeClass, Density density, Boolean bool, LayoutDirection layoutDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            windowWidthSizeClass = null;
        }
        if ((i & 2) != 0) {
            density = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            layoutDirection = null;
        }
        videoComponentState.update(windowWidthSizeClass, density, bool, layoutDirection);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoComponentState)) {
            return false;
        }
        VideoComponentState videoComponentState = (VideoComponentState) obj;
        return Intrinsics.areEqual(this.style, videoComponentState.style) && Intrinsics.areEqual(this.localeProvider, videoComponentState.localeProvider) && Intrinsics.areEqual(this.selectedPackageInfoProvider, videoComponentState.selectedPackageInfoProvider) && Intrinsics.areEqual(this.selectedTabIndexProvider, videoComponentState.selectedTabIndexProvider) && Intrinsics.areEqual(this.selectedOfferEligibilityProvider, videoComponentState.selectedOfferEligibilityProvider) && Intrinsics.areEqual(this.customVariablesProvider, videoComponentState.customVariablesProvider);
    }

    public final /* synthetic */ AspectRatio getAspectRatio() {
        return (AspectRatio) this.aspectRatio.getValue();
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return (BorderStyles) this.border.getValue();
    }

    public final /* synthetic */ ContentScale getContentScale() {
        return (ContentScale) this.contentScale.getValue();
    }

    public final /* synthetic */ AspectRatio getFallbackAspectRatio() {
        return (AspectRatio) this.fallbackAspectRatio.getValue();
    }

    public final /* synthetic */ ImageUrls getFallbackUrls() {
        return (ImageUrls) this.fallbackUrls.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin.getValue();
    }

    public final /* synthetic */ AspectRatio getMarginAdjustedAspectRatio() {
        return (AspectRatio) this.marginAdjustedAspectRatio.getValue();
    }

    public final /* synthetic */ ColorStyles getOverlay() {
        return (ColorStyles) this.overlay.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding.getValue();
    }

    public final /* synthetic */ ShadowStyles getShadow() {
        return (ShadowStyles) this.shadow.getValue();
    }

    public final /* synthetic */ Shape getShape() {
        return (Shape) this.shape.getValue();
    }

    public final /* synthetic */ Size getSize() {
        return (Size) this.size.getValue();
    }

    public final /* synthetic */ Size getSizePlusMargin() {
        return (Size) this.sizePlusMargin.getValue();
    }

    public final /* synthetic */ VideoUrls getVideoUrls() {
        return (VideoUrls) this.videoUrls.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public int hashCode() {
        return (((((((((this.style.hashCode() * 31) + this.localeProvider.hashCode()) * 31) + this.selectedPackageInfoProvider.hashCode()) * 31) + this.selectedTabIndexProvider.hashCode()) * 31) + this.selectedOfferEligibilityProvider.hashCode()) * 31) + this.customVariablesProvider.hashCode();
    }

    public String toString() {
        return "VideoComponentState(style=" + this.style + ", localeProvider=" + this.localeProvider + ", selectedPackageInfoProvider=" + this.selectedPackageInfoProvider + ", selectedTabIndexProvider=" + this.selectedTabIndexProvider + ", selectedOfferEligibilityProvider=" + this.selectedOfferEligibilityProvider + ", customVariablesProvider=" + this.customVariablesProvider + ')';
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowSize, Density density, Boolean darkMode, LayoutDirection layoutDirection) {
        if (windowSize != null) {
            setWindowSize(windowSize);
        }
        if (density != null) {
            setDensity(density);
        }
        if (darkMode != null) {
            setDarkMode(darkMode.booleanValue());
        }
        if (layoutDirection != null) {
            setLayoutDirection(layoutDirection);
        }
    }
}
