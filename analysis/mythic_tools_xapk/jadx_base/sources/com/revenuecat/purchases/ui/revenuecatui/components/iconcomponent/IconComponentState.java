package com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.PartialIconComponent;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedIconPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.SizeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: IconComponentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\t¢\u0006\u0002\u0010\u0013J\u0012\u0010j\u001a\u00020k2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u0003R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b \u0010!R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0019\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0019\u001a\u0004\b.\u0010\u001cR+\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001b\u00108\u001a\u0002098FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0019\u001a\u0004\b:\u0010;R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u0002098FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0019\u001a\u0004\b@\u0010;R\u001d\u0010B\u001a\u0004\u0018\u00010C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0019\u001a\u0004\bD\u0010ER\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010G\u001a\u0004\u0018\u00010H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u0019\u001a\u0004\bI\u0010JR\u001d\u0010L\u001a\u0004\u0018\u00010M8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0019\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020R8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0019\u001a\u0004\bS\u0010TR\u001b\u0010V\u001a\u00020R8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0019\u001a\u0004\bW\u0010TR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010Y\u001a\u0004\u0018\u00010\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0019\u001a\u0004\bZ\u0010\u0017R\u001b\u0010\\\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0019\u001a\u0004\b]\u0010\u001cR\u001b\u0010_\u001a\u00020`8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0019\u001a\u0004\ba\u0010bR+\u0010d\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bi\u00107\u001a\u0004\be\u0010f\"\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/iconcomponent/IconComponentState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", "initialLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Landroidx/compose/ui/unit/LayoutDirection;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "backgroundColorStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getBackgroundColorStyles", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "backgroundColorStyles$delegate", "Landroidx/compose/runtime/State;", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "baseUrl$delegate", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "border$delegate", "formats", "Lcom/revenuecat/purchases/paywalls/components/IconComponent$Formats;", "getFormats", "()Lcom/revenuecat/purchases/paywalls/components/IconComponent$Formats;", "formats$delegate", "iconBackground", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle$Background;", "getIconBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle$Background;", "iconBackground$delegate", "iconName", "getIconName", "iconName$delegate", "<set-?>", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "Landroidx/compose/runtime/MutableState;", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "margin$delegate", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "padding", "getPadding", "padding$delegate", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedIconPartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedIconPartial;", "presentedPartial$delegate", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "shadow$delegate", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "shape$delegate", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size$delegate", "sizePlusMargin", "getSizePlusMargin", "sizePlusMargin$delegate", "tintColor", "getTintColor", "tintColor$delegate", "url", "getUrl", "url$delegate", "visible", "", "getVisible", "()Z", "visible$delegate", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "update", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IconComponentState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: backgroundColorStyles$delegate, reason: from kotlin metadata */
    private final State backgroundColorStyles;

    /* JADX INFO: renamed from: baseUrl$delegate, reason: from kotlin metadata */
    private final State baseUrl;

    /* JADX INFO: renamed from: border$delegate, reason: from kotlin metadata */
    private final State border;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;

    /* JADX INFO: renamed from: formats$delegate, reason: from kotlin metadata */
    private final State formats;

    /* JADX INFO: renamed from: iconBackground$delegate, reason: from kotlin metadata */
    private final State iconBackground;

    /* JADX INFO: renamed from: iconName$delegate, reason: from kotlin metadata */
    private final State iconName;

    /* JADX INFO: renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;

    /* JADX INFO: renamed from: margin$delegate, reason: from kotlin metadata */
    private final State margin;
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
    private final IconComponentStyle style;

    /* JADX INFO: renamed from: tintColor$delegate, reason: from kotlin metadata */
    private final State tintColor;

    /* JADX INFO: renamed from: url$delegate, reason: from kotlin metadata */
    private final State url;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final State visible;

    /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
    private final MutableState windowSize;

    /* JADX WARN: Multi-variable type inference failed */
    public IconComponentState(WindowWidthSizeClass initialWindowSize, LayoutDirection initialLayoutDirection, IconComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
        Intrinsics.checkNotNullParameter(initialLayoutDirection, "initialLayoutDirection");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        Intrinsics.checkNotNullParameter(customVariablesProvider, "customVariablesProvider");
        this.style = style;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.customVariablesProvider = customVariablesProvider;
        this.windowSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialWindowSize, null, 2, null);
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialLayoutDirection, null, 2, null);
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0<PresentedIconPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$presentedPartial$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PresentedIconPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedIconPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.baseUrl = SnapshotStateKt.derivedStateOf(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$baseUrl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PartialIconComponent partial;
                String baseUrl;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (baseUrl = partial.getBaseUrl()) == null) ? this.this$0.style.getBaseUrl() : baseUrl;
            }
        });
        this.iconName = SnapshotStateKt.derivedStateOf(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$iconName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PartialIconComponent partial;
                String iconName;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (iconName = partial.getIconName()) == null) ? this.this$0.style.getIconName() : iconName;
            }
        });
        this.formats = SnapshotStateKt.derivedStateOf(new Function0<IconComponent.Formats>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$formats$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IconComponent.Formats invoke() {
                PartialIconComponent partial;
                IconComponent.Formats formats;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (formats = partial.getFormats()) == null) ? this.this$0.style.getFormats() : formats;
            }
        });
        this.iconBackground = SnapshotStateKt.derivedStateOf(new Function0<IconComponentStyle.Background>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$iconBackground$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IconComponentStyle.Background invoke() {
                IconComponentStyle.Background background;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (background = presentedPartial.getBackground()) == null) ? this.this$0.style.getIconBackground() : background;
            }
        });
        this.visible = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$visible$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialIconComponent partial;
                Boolean visible;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.url = SnapshotStateKt.derivedStateOf(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$url$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getBaseUrl() + IOUtils.DIR_SEPARATOR_UNIX + this.this$0.getFormats().getWebp();
            }
        });
        this.size = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$size$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                PartialIconComponent partial;
                Size size;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) ? this.this$0.style.getSize() : size;
            }
        });
        this.padding = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$padding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialIconComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$margin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialIconComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.sizePlusMargin = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$sizePlusMargin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                return SizeKt.addMargin(this.this$0.getSize(), this.this$0.getMargin(), this.this$0.getLayoutDirection());
            }
        });
        this.shape = SnapshotStateKt.derivedStateOf(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$shape$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                MaskShape shape;
                IconComponentStyle.Background iconBackground = this.this$0.getIconBackground();
                if (iconBackground == null || (shape = iconBackground.getShape()) == null) {
                    return null;
                }
                return ShapeKt.toShape(shape);
            }
        });
        this.border = SnapshotStateKt.derivedStateOf(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$border$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                IconComponentStyle.Background iconBackground = this.this$0.getIconBackground();
                if (iconBackground != null) {
                    return iconBackground.getBorder();
                }
                return null;
            }
        });
        this.shadow = SnapshotStateKt.derivedStateOf(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$shadow$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                IconComponentStyle.Background iconBackground = this.this$0.getIconBackground();
                if (iconBackground != null) {
                    return iconBackground.getShadow();
                }
                return null;
            }
        });
        this.backgroundColorStyles = SnapshotStateKt.derivedStateOf(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$backgroundColorStyles$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                IconComponentStyle.Background iconBackground = this.this$0.getIconBackground();
                if (iconBackground != null) {
                    return iconBackground.getColor();
                }
                return null;
            }
        });
        this.tintColor = SnapshotStateKt.derivedStateOf(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$tintColor$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                ColorStyles colorStyles;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (colorStyles = presentedPartial.getColorStyles()) == null) ? this.this$0.style.getColor() : colorStyles;
            }
        });
    }

    public /* synthetic */ IconComponentState(WindowWidthSizeClass windowWidthSizeClass, LayoutDirection layoutDirection, IconComponentStyle iconComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, layoutDirection, iconComponentStyle, function0, function02, function03, (i & 64) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function04);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBaseUrl() {
        return (String) this.baseUrl.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IconComponent.Formats getFormats() {
        return (IconComponent.Formats) this.formats.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IconComponentStyle.Background getIconBackground() {
        return (IconComponentStyle.Background) this.iconBackground.getValue();
    }

    private final String getIconName() {
        return (String) this.iconName.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedIconPartial getPresentedPartial() {
        return (PresentedIconPartial) this.presentedPartial.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize.getValue();
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(IconComponentState iconComponentState, WindowWidthSizeClass windowWidthSizeClass, int i, Object obj) {
        if ((i & 1) != 0) {
            windowWidthSizeClass = null;
        }
        iconComponentState.update(windowWidthSizeClass);
    }

    public final /* synthetic */ ColorStyles getBackgroundColorStyles() {
        return (ColorStyles) this.backgroundColorStyles.getValue();
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return (BorderStyles) this.border.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin.getValue();
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

    public final ColorStyles getTintColor() {
        return (ColorStyles) this.tintColor.getValue();
    }

    public final /* synthetic */ String getUrl() {
        return (String) this.url.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowSize) {
        if (windowSize != null) {
            setWindowSize(windowSize);
        }
    }
}
