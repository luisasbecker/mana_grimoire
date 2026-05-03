package com.revenuecat.purchases.ui.revenuecatui.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.intercept.Interceptor;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.BuildConfig;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FontKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallResourceProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.opencv.imgcodecs.Imgcodecs;

/* JADX INFO: compiled from: PreviewHelpers.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001ai\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010\u001c\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u001d\u001a¶\u0001\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00112\b\b\u0002\u0010*\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020+2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0000ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a¿\u0001\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020B2\b\b\u0002\u0010*\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u0002032\u0014\b\u0002\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0E0!H\u0000¢\u0006\u0002\u0010G\u001a>\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u00020K2 \b\u0002\u0010L\u001a\u001a\u0012\u0004\u0012\u00020N\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u0002090M0M2\b\b\u0002\u0010P\u001a\u00020QH\u0000\u001a\u0014\u0010R\u001a\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u0002090SH\u0001\u001a%\u0010T\u001a\u0016\u0012\u0004\u0012\u00020V\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0W\u0018\u00010U*\u00020YH\u0001¢\u0006\u0002\u0010Z\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006["}, d2 = {"MILLIS_2025_01_25", "", "previewEmptyState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "initialSelectedTabIndex", "", "(Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "previewIconComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "visible", "", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "backgroundColor", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "marginValues", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "(Lcom/revenuecat/purchases/paywalls/components/properties/Size;ZLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "previewImageLoader", "Lcoil/ImageLoader;", "resource", "(ILandroidx/compose/runtime/Composer;II)Lcoil/ImageLoader;", "previewStackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "children", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "dimension", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "spacing", "Landroidx/compose/ui/unit/Dp;", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "padding", "margin", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "badge", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "scrollOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "countdownDate", "Ljava/util/Date;", "countFrom", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "previewStackComponentStyle-7SJ-wSw", "(Ljava/util/List;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;Landroidx/compose/foundation/gestures/Orientation;Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "previewTextComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "text", "", "fontSize", "fontWeight", "Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;", "fontSpec", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "textAlign", "Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;", "horizontalAlignment", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "tabIndex", "overrides", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/LocalizedTextPartial;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;ILcom/revenuecat/purchases/paywalls/components/properties/FontWeight;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Ljava/lang/Integer;Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Ljava/util/List;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "previewUiConfig", "Lcom/revenuecat/purchases/UiConfig;", AndroidContextPlugin.APP_KEY, "Lcom/revenuecat/purchases/UiConfig$AppConfig;", "localizations", "", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "variableConfig", "Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "variableLocalizationKeysForEnUs", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "validatePaywallComponentsDataOrNullForPreviews", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallValidationResult$Components;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "Lcom/revenuecat/purchases/Offering;", "(Lcom/revenuecat/purchases/Offering;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class PreviewHelpersKt {
    public static final long MILLIS_2025_01_25 = 1737763200000L;

    /* JADX INFO: compiled from: PreviewHelpers.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VariableLocalizationKey.values().length];
            try {
                iArr[VariableLocalizationKey.ANNUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VariableLocalizationKey.ANNUAL_SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VariableLocalizationKey.ANNUALLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VariableLocalizationKey.DAILY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VariableLocalizationKey.DAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VariableLocalizationKey.DAY_SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[VariableLocalizationKey.FREE_PRICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[VariableLocalizationKey.MONTH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[VariableLocalizationKey.MONTH_SHORT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[VariableLocalizationKey.MONTHLY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[VariableLocalizationKey.LIFETIME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_FEW.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_MANY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_ONE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_OTHER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_TWO.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_ZERO.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_FEW.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_MANY.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_ONE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_OTHER.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_TWO.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_ZERO.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_FEW.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_MANY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_ONE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_OTHER.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_TWO.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_ZERO.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_FEW.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_MANY.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_ONE.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_OTHER.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_TWO.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_ZERO.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[VariableLocalizationKey.PERCENT.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[VariableLocalizationKey.WEEK.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[VariableLocalizationKey.WEEK_SHORT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[VariableLocalizationKey.WEEKLY.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[VariableLocalizationKey.YEAR.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[VariableLocalizationKey.YEAR_SHORT.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[VariableLocalizationKey.YEARLY.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAYS_SHORT.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEKS_SHORT.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTHS_SHORT.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEARS_SHORT.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PaywallState.Loaded.Components previewEmptyState(Integer num, Composer composer, int i, int i2) {
        composer.startReplaceGroup(1055380879);
        ComposerKt.sourceInformation(composer, "C(previewEmptyState)117@6728L48:PreviewHelpers.kt#dnqhhd");
        PaywallValidationResult.Components components = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Integer num2 = (i2 & 1) != 0 ? null : num;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1055380879, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.previewEmptyState (PreviewHelpers.kt:85)");
        }
        URL url = new URL("https://assets.pawwalls.com");
        StackComponent stackComponent = new StackComponent(CollectionsKt.listOf(TestData.Components.INSTANCE.getMonthlyPackageComponent()), (Boolean) null, (Dimension) null, (Size) null, (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, Imgcodecs.IMWRITE_TIFF_COMPRESSION_NEXT, (DefaultConstructorMarker) null);
        Object[] objArr3 = objArr2 == true ? 1 : 0;
        Offering offering = new Offering("identifier", "serverDescription", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(new UiConfig((UiConfig.AppConfig) null, (Map) NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), variableLocalizationKeysForEnUs()), new Pair[0]), (UiConfig.VariableConfig) (0 == true ? 1 : 0), (Map) (0 == true ? 1 : 0), 13, (DefaultConstructorMarker) (0 == true ? 1 : 0)), new PaywallComponentsData("preview_paywall_id", "template", url, new ComponentsConfig(new PaywallComponentsConfig(stackComponent, new Background.Color(new ColorScheme((ColorInfo) new ColorInfo.Hex(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6362getWhite0d7_KjU())), (ColorInfo) objArr3, 2, (DefaultConstructorMarker) (objArr == true ? 1 : 0))), (StickyFooterComponent) null, (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), (Map) NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(LocalizationKey.m10428boximpl(LocalizationKey.m10429constructorimpl("text")), LocalizationData.Text.m10410boximpl(LocalizationData.Text.m10411constructorimpl("text"))), new Pair[0])), new Pair[0]), LocaleId.m10393constructorimpl("en_US"), 0, (List) (0 == true ? 1 : 0), (ExitOffers) (0 == true ? 1 : 0), (ProductChangeConfig) (0 == true ? 1 : 0), 960, (DefaultConstructorMarker) (0 == true ? 1 : 0))), null, 80, null);
        Result.Success successValidatePaywallComponentsDataOrNullForPreviews = validatePaywallComponentsDataOrNullForPreviews(offering, composer, 0);
        if (successValidatePaywallComponentsDataOrNullForPreviews != null) {
            if (successValidatePaywallComponentsDataOrNullForPreviews instanceof Result.Success) {
                PaywallValidationResult.Components componentsCopy$default = (PaywallValidationResult.Components) ((Result.Success) successValidatePaywallComponentsDataOrNullForPreviews).getValue();
                if (num2 != null) {
                    componentsCopy$default = PaywallValidationResult.Components.copy$default(componentsCopy$default, null, null, null, null, null, null, null, null, null, num2, false, 1535, null);
                }
                successValidatePaywallComponentsDataOrNullForPreviews = new Result.Success(componentsCopy$default);
            } else if (!(successValidatePaywallComponentsDataOrNullForPreviews instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            components = (PaywallValidationResult.Components) ResultKt.getOrThrow(successValidatePaywallComponentsDataOrNullForPreviews);
        }
        PaywallValidationResult.Components components2 = components;
        Intrinsics.checkNotNull(components2);
        PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components2, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt.previewEmptyState.1
            @Override // kotlin.jvm.functions.Function0
            public final Date invoke() {
                return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
            }
        }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return componentsPaywallState$default;
    }

    public static final IconComponentStyle previewIconComponentStyle(Size size, boolean z, ColorStyles colorStyles, ColorStyles colorStyles2, PaddingValues paddingValues, PaddingValues paddingValues2, BorderStyles borderStyles, ShadowStyles shadowStyles, MaskShape maskShape, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(size, "size");
        composer.startReplaceGroup(971508494);
        ComposerKt.sourceInformation(composer, "C(previewIconComponentStyle)P(7,8,2!1,4,3):PreviewHelpers.kt#dnqhhd");
        boolean z2 = (i2 & 2) != 0 ? true : z;
        ColorStyles colorStyles3 = (i2 & 4) != 0 ? new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6353getCyan0d7_KjU())), null, 2, null) : colorStyles;
        ColorStyles colorStyles4 = (i2 & 8) != 0 ? new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), null, 2, null) : colorStyles2;
        PaddingValues paddingValuesM2030PaddingValues0680j_4 = (i2 & 16) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(10.0f)) : paddingValues;
        PaddingValues paddingValuesM2030PaddingValues0680j_42 = (i2 & 32) != 0 ? PaddingKt.m2030PaddingValues0680j_4(Dp.m9114constructorimpl(10.0f)) : paddingValues2;
        BorderStyles borderStyles2 = (i2 & 64) != 0 ? new BorderStyles(Dp.m9114constructorimpl(2.0f), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6353getCyan0d7_KjU())), null, 2, null), null) : borderStyles;
        ShadowStyles shadowStyles2 = (i2 & 128) != 0 ? new ShadowStyles(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null), Dp.m9114constructorimpl(10.0f), Dp.m9114constructorimpl(0.0f), Dp.m9114constructorimpl(3.0f), null) : shadowStyles;
        MaskShape.Circle circle = (i2 & 256) != 0 ? MaskShape.Circle.INSTANCE : maskShape;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(971508494, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.previewIconComponentStyle (PreviewHelpers.kt:261)");
        }
        IconComponentStyle iconComponentStyle = new IconComponentStyle("https://example.com", "test-icon-name", new IconComponent.Formats("test-webp"), z2, size, colorStyles3, paddingValuesM2030PaddingValues0680j_4, paddingValuesM2030PaddingValues0680j_42, new IconComponentStyle.Background(colorStyles4, circle, borderStyles2, shadowStyles2), null, null, null, null, CollectionsKt.emptyList(), 5120, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconComponentStyle;
    }

    public static final /* synthetic */ ImageLoader previewImageLoader(final int i, Composer composer, int i2, int i3) {
        composer.startReplaceGroup(-1745938743);
        ComposerKt.sourceInformation(composer, "C(previewImageLoader)288@12336L7,*291@12422L234:PreviewHelpers.kt#dnqhhd");
        boolean z = true;
        if ((i3 & 1) != 0) {
            i = R.drawable.f434android;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1745938743, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.previewImageLoader (PreviewHelpers.kt:287)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Context context = (Context) objConsume;
        ImageLoader.Builder builder = new ImageLoader.Builder(context);
        ComponentRegistry.Builder builder2 = new ComponentRegistry.Builder();
        composer.startReplaceGroup(1695006622);
        ComposerKt.sourceInformation(composer, "CC(remember):PreviewHelpers.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(context);
        if ((((i2 & 14) ^ 6) <= 4 || !composer.changed(i)) && (i2 & 6) != 4) {
            z = false;
        }
        boolean z2 = zChangedInstance | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Interceptor) new Interceptor() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt$previewImageLoader$1$1$1
                @Override // coil.intercept.Interceptor
                public final Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
                    Drawable drawable = context.getDrawable(i);
                    Intrinsics.checkNotNull(drawable);
                    return new SuccessResult(drawable, chain.getRequest(), DataSource.MEMORY, null, null, false, false, 120, null);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        builder2.add((Interceptor) objRememberedValue);
        ImageLoader imageLoaderBuild = builder.components(builder2.build()).build();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageLoaderBuild;
    }

    /* JADX INFO: renamed from: previewStackComponentStyle-7SJ-wSw, reason: not valid java name */
    public static final StackComponentStyle m10457previewStackComponentStyle7SJwSw(List<? extends ComponentStyle> children, Dimension dimension, boolean z, Size size, float f, BackgroundStyles background, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Date date, CountdownComponent.CountFrom countFrom) {
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        return new StackComponentStyle(children, dimension, z, size, f, background, padding, margin, shape, borderStyles, shadowStyles, badgeStyle, orientation, null, null, null, null, date, countFrom, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
    }

    public static final /* synthetic */ TextComponentStyle previewTextComponentStyle(String text, ColorStyles color, int i, FontWeight fontWeight, FontSpec fontSpec, HorizontalAlignment textAlign, HorizontalAlignment horizontalAlignment, ColorStyles colorStyles, boolean z, Size size, Padding padding, Padding margin, Integer num, Date date, CountdownComponent.CountFrom countFrom, List overrides) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(textAlign, "textAlign");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        androidx.compose.ui.text.font.FontWeight fontWeight2 = FontKt.toFontWeight(fontWeight);
        String strM10393constructorimpl = LocaleId.m10393constructorimpl("en_US");
        return new TextComponentStyle(NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(LocaleId.m10392boximpl(strM10393constructorimpl), text), new Pair[0]), color, i, fontWeight2, fontSpec, TextAlign.m8985boximpl(AlignmentKt.toTextAlign(textAlign)), AlignmentKt.toAlignment(horizontalAlignment), colorStyles, z, size, com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt.toPaddingValues(padding), com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt.toPaddingValues(margin), null, null, num, null, date, countFrom, NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(LocaleId.m10392boximpl(strM10393constructorimpl), variableLocalizationKeysForEnUs()), new Pair[0]), overrides, 40960, null);
    }

    public static /* synthetic */ TextComponentStyle previewTextComponentStyle$default(String str, ColorStyles colorStyles, int i, FontWeight fontWeight, FontSpec fontSpec, HorizontalAlignment horizontalAlignment, HorizontalAlignment horizontalAlignment2, ColorStyles colorStyles2, boolean z, Size size, Padding padding, Padding padding2, Integer num, Date date, CountdownComponent.CountFrom countFrom, List list, int i2, Object obj) {
        return previewTextComponentStyle(str, (i2 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6351getBlack0d7_KjU())), null, 2, null) : colorStyles, (i2 & 4) != 0 ? 15 : i, (i2 & 8) != 0 ? FontWeight.REGULAR : fontWeight, (i2 & 16) != 0 ? null : fontSpec, (i2 & 32) != 0 ? HorizontalAlignment.CENTER : horizontalAlignment, (i2 & 64) != 0 ? HorizontalAlignment.CENTER : horizontalAlignment2, (i2 & 128) != 0 ? null : colorStyles2, (i2 & 256) != 0 ? true : z, (i2 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i2 & 1024) != 0 ? Padding.INSTANCE.getZero() : padding, (i2 & 2048) != 0 ? Padding.INSTANCE.getZero() : padding2, (i2 & 4096) != 0 ? null : num, (i2 & 8192) == 0 ? date : null, (i2 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : countFrom, (i2 & 32768) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final UiConfig previewUiConfig(UiConfig.AppConfig app, Map<LocaleId, ? extends Map<VariableLocalizationKey, String>> localizations, UiConfig.VariableConfig variableConfig) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
        return new UiConfig(app, localizations, variableConfig, (Map) null, 8, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UiConfig previewUiConfig$default(UiConfig.AppConfig appConfig, Map map, UiConfig.VariableConfig variableConfig, int i, Object obj) {
        int i2 = 3;
        Map map2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if ((i & 1) != 0) {
            appConfig = new UiConfig.AppConfig(map2, (Map) (objArr5 == true ? 1 : 0), i2, (DefaultConstructorMarker) (objArr4 == true ? 1 : 0));
        }
        if ((i & 2) != 0) {
            map = MapsKt.mapOf(TuplesKt.to(LocaleId.m10392boximpl(LocaleId.m10393constructorimpl("en_US")), variableLocalizationKeysForEnUs()));
        }
        if ((i & 4) != 0) {
            variableConfig = new UiConfig.VariableConfig((Map) (objArr3 == true ? 1 : 0), (Map) (objArr2 == true ? 1 : 0), i2, (DefaultConstructorMarker) (objArr == true ? 1 : 0));
        }
        return previewUiConfig(appConfig, map, variableConfig);
    }

    public static final /* synthetic */ Result validatePaywallComponentsDataOrNullForPreviews(Offering offering, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        composer.startReplaceGroup(1679297795);
        ComposerKt.sourceInformation(composer, "C(validatePaywallComponentsDataOrNullForPreviews)310@13132L7:PreviewHelpers.kt#dnqhhd");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1679297795, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.validatePaywallComponentsDataOrNullForPreviews (PreviewHelpers.kt:306)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Resources resources = ((Context) objConsume).getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "LocalContext.current.resources");
        Result<PaywallValidationResult.Components, NonEmptyList<PaywallValidationError>> resultValidatePaywallComponentsDataOrNull = OfferingToStateMapperKt.validatePaywallComponentsDataOrNull(offering, new PaywallResourceProvider("RevenueCatUI Previews", BuildConfig.LIBRARY_PACKAGE_NAME, resources));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return resultValidatePaywallComponentsDataOrNull;
    }

    public static final /* synthetic */ NonEmptyMap variableLocalizationKeysForEnUs() {
        VariableLocalizationKey[] variableLocalizationKeyArrValues = VariableLocalizationKey.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(variableLocalizationKeyArrValues.length), 16));
        for (VariableLocalizationKey variableLocalizationKey : variableLocalizationKeyArrValues) {
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            String str = "%d year";
            switch (WhenMappings.$EnumSwitchMapping$0[variableLocalizationKey.ordinal()]) {
                case 1:
                    str = "annual";
                    break;
                case 2:
                case 41:
                    str = "yr";
                    break;
                case 3:
                    str = "annually";
                    break;
                case 4:
                    str = "daily";
                    break;
                case 5:
                case 6:
                    str = "day";
                    break;
                case 7:
                    str = "free";
                    break;
                case 8:
                    str = "month";
                    break;
                case 9:
                    str = "mo";
                    break;
                case 10:
                    str = "monthly";
                    break;
                case 11:
                    str = "lifetime";
                    break;
                case 12:
                case 13:
                case 15:
                case 16:
                    str = "%d days";
                    break;
                case 14:
                case 17:
                    str = "%d day";
                    break;
                case 18:
                case 19:
                case 21:
                case 22:
                    str = "%d months";
                    break;
                case 20:
                case 23:
                    str = "%d month";
                    break;
                case 24:
                case 25:
                case 27:
                case 28:
                    str = "%d weeks";
                    break;
                case 26:
                case 29:
                    str = "%d week";
                    break;
                case 30:
                case 31:
                case 33:
                case 34:
                    str = "%d years";
                    break;
                case 32:
                case 35:
                    break;
                case 36:
                    str = "%d%%";
                    break;
                case 37:
                    str = "week";
                    break;
                case 38:
                    str = "wk";
                    break;
                case 39:
                    str = "weekly";
                    break;
                case 40:
                    str = "year";
                    break;
                case 42:
                    str = "yearly";
                    break;
                case 43:
                    str = "%dd";
                    break;
                case 44:
                    str = "%dwk";
                    break;
                case 45:
                    str = "%dmo";
                    break;
                case 46:
                    str = "%dyr";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            linkedHashMap2.put(variableLocalizationKey, str);
        }
        NonEmptyMap nonEmptyMapOrNull = NonEmptyMapKt.toNonEmptyMapOrNull(linkedHashMap);
        Intrinsics.checkNotNull(nonEmptyMapOrNull);
        return nonEmptyMapOrNull;
    }
}
