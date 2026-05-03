package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedStackPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.OverflowExtensionsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackComponentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\t¢\u0006\u0002\u0010\u0013J\u001e\u0010q\u001a\u00020r2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0005J\u001c\u0010s\u001a\u00020_*\u00020_2\u0006\u0010@\u001a\u00020A2\u0006\u00109\u001a\u00020\u0005H\u0002R\u0013\u0010\u0014\u001a\u00020\u00158F¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u00020\u00158F¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u00020\u00158F¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R\u001d\u0010'\u001a\u0004\u0018\u00010(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b)\u0010*R\u0019\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-8F¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010!\u001a\u0004\b3\u00104R\u0013\u00106\u001a\u00020\u00158F¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0017R+\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010@\u001a\u00020A8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010!\u001a\u0004\bB\u0010CR\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020A8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010!\u001a\u0004\bH\u0010CR\u001d\u0010J\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010!\u001a\u0004\bL\u0010MR\u001d\u0010O\u001a\u0004\u0018\u00010P8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010!\u001a\u0004\bQ\u0010RR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010T\u001a\u0004\u0018\u00010U8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010!\u001a\u0004\bV\u0010WR\u001b\u0010Y\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010!\u001a\u0004\b[\u0010\\R\u001b\u0010^\u001a\u00020_8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010!\u001a\u0004\b`\u0010aR!\u0010c\u001a\u00020d8FX\u0086\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bg\u0010!\u001a\u0004\be\u0010fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010h\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bj\u0010!\u001a\u0004\bi\u0010\u0017R+\u0010k\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bp\u0010?\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006t"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", "initialLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Landroidx/compose/ui/unit/LayoutDirection;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "applyBottomWindowInsets", "", "getApplyBottomWindowInsets", "()Z", "applyHorizontalWindowInsets", "getApplyHorizontalWindowInsets", "applyTopWindowInsets", "getApplyTopWindowInsets", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "background$delegate", "Landroidx/compose/runtime/State;", "badge", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "getBadge", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "badge$delegate", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "border$delegate", "children", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "getChildren", "()Ljava/util/List;", "dimension", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "getDimension", "()Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "dimension$delegate", "ignoreHeaderHeight", "getIgnoreHeaderHeight", "<set-?>", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "Landroidx/compose/runtime/MutableState;", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "margin$delegate", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "padding", "getPadding", "padding$delegate", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedStackPartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedStackPartial;", "presentedPartial$delegate", "scrollOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "getScrollOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "scrollOrientation$delegate", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "shadow$delegate", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "shape$delegate", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size$delegate", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "spacing$delegate", "visible", "getVisible", "visible$delegate", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "update", "", "adjustForMargin", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StackComponentState {
    public static final int $stable = 0;
    private final boolean applyBottomWindowInsets;
    private final boolean applyHorizontalWindowInsets;
    private final boolean applyTopWindowInsets;

    /* JADX INFO: renamed from: background$delegate, reason: from kotlin metadata */
    private final State background;

    /* JADX INFO: renamed from: badge$delegate, reason: from kotlin metadata */
    private final State badge;

    /* JADX INFO: renamed from: border$delegate, reason: from kotlin metadata */
    private final State border;
    private final List<ComponentStyle> children;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;

    /* JADX INFO: renamed from: dimension$delegate, reason: from kotlin metadata */
    private final State dimension;
    private final boolean ignoreHeaderHeight;

    /* JADX INFO: renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;

    /* JADX INFO: renamed from: margin$delegate, reason: from kotlin metadata */
    private final State margin;
    private final PackageAwareDelegate packageAwareDelegate;

    /* JADX INFO: renamed from: padding$delegate, reason: from kotlin metadata */
    private final State padding;

    /* JADX INFO: renamed from: presentedPartial$delegate, reason: from kotlin metadata */
    private final State presentedPartial;

    /* JADX INFO: renamed from: scrollOrientation$delegate, reason: from kotlin metadata */
    private final State scrollOrientation;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;

    /* JADX INFO: renamed from: shadow$delegate, reason: from kotlin metadata */
    private final State shadow;

    /* JADX INFO: renamed from: shape$delegate, reason: from kotlin metadata */
    private final State shape;

    /* JADX INFO: renamed from: size$delegate, reason: from kotlin metadata */
    private final State size;

    /* JADX INFO: renamed from: spacing$delegate, reason: from kotlin metadata */
    private final State spacing;
    private final StackComponentStyle style;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final State visible;

    /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
    private final MutableState windowSize;

    /* JADX WARN: Multi-variable type inference failed */
    public StackComponentState(WindowWidthSizeClass initialWindowSize, LayoutDirection initialLayoutDirection, StackComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
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
        this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0<PresentedStackPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$presentedPartial$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PresentedStackPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedStackPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.visible = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$visible$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialStackComponent partial;
                Boolean visible;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.children = style.getChildren();
        this.applyTopWindowInsets = style.getApplyTopWindowInsets();
        this.ignoreHeaderHeight = style.getIgnoreHeaderHeight();
        this.applyBottomWindowInsets = style.getApplyBottomWindowInsets();
        this.applyHorizontalWindowInsets = style.getApplyHorizontalWindowInsets();
        this.dimension = SnapshotStateKt.derivedStateOf(new Function0<Dimension>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$dimension$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Dimension invoke() {
                PartialStackComponent partial;
                Dimension dimension;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (dimension = partial.getDimension()) == null) ? this.this$0.style.getDimension() : dimension;
            }
        });
        this.spacing = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$spacing$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Dp invoke() {
                return Dp.m9112boximpl(m10565invokeD9Ej5fM());
            }

            /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
            public final float m10565invokeD9Ej5fM() {
                PartialStackComponent partial;
                Float spacing;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (spacing = partial.getSpacing()) == null) ? this.this$0.style.m10592getSpacingD9Ej5fM() : Dp.m9114constructorimpl(spacing.floatValue());
            }
        });
        this.background = SnapshotStateKt.derivedStateOf(new Function0<BackgroundStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$background$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackgroundStyles invoke() {
                BackgroundStyles backgroundStyles;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (backgroundStyles = presentedPartial.getBackgroundStyles()) == null) ? this.this$0.style.getBackground() : backgroundStyles;
            }
        });
        this.padding = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$padding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialStackComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$margin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialStackComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.size = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$size$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                Size size;
                PartialStackComponent partial;
                StackComponentState stackComponentState = this.this$0;
                PresentedStackPartial presentedPartial = stackComponentState.getPresentedPartial();
                if (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) {
                    size = this.this$0.style.getSize();
                }
                return stackComponentState.adjustForMargin(size, this.this$0.getMargin(), this.this$0.getLayoutDirection());
            }
        });
        this.shape = SnapshotStateKt.derivedStateOf(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$shape$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                PartialStackComponent partial;
                Shape shape;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (shape = partial.getShape()) == null) ? this.this$0.style.getShape() : shape;
            }
        });
        this.border = SnapshotStateKt.derivedStateOf(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$border$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                BorderStyles borderStyles;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (borderStyles = presentedPartial.getBorderStyles()) == null) ? this.this$0.style.getBorder() : borderStyles;
            }
        });
        this.shadow = SnapshotStateKt.derivedStateOf(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$shadow$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                ShadowStyles shadowStyles;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (shadowStyles = presentedPartial.getShadowStyles()) == null) ? this.this$0.style.getShadow() : shadowStyles;
            }
        });
        this.badge = SnapshotStateKt.derivedStateOf(new Function0<BadgeStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$badge$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BadgeStyle invoke() {
                BadgeStyle badgeStyle;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (badgeStyle = presentedPartial.getBadgeStyle()) == null) ? this.this$0.style.getBadge() : badgeStyle;
            }
        });
        this.scrollOrientation = SnapshotStateKt.derivedStateOf(new Function0<Orientation>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$scrollOrientation$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Orientation invoke() {
                PartialStackComponent partial;
                StackComponent.Overflow overflow;
                Orientation orientation;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (overflow = partial.getOverflow()) == null || (orientation = OverflowExtensionsKt.toOrientation(overflow, this.this$0.getDimension())) == null) ? this.this$0.style.getScrollOrientation() : orientation;
            }
        });
    }

    public /* synthetic */ StackComponentState(WindowWidthSizeClass windowWidthSizeClass, LayoutDirection layoutDirection, StackComponentStyle stackComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, layoutDirection, stackComponentStyle, function0, function02, function03, (i & 64) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function04);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Size adjustForMargin(Size size, PaddingValues paddingValues, LayoutDirection layoutDirection) {
        SizeConstraint.Fixed width = size.getWidth();
        if (width instanceof SizeConstraint.Fixed) {
            width = new SizeConstraint.Fixed(UInt.m11540constructorimpl(UInt.m11540constructorimpl(((SizeConstraint.Fixed) width).getValue() + UnsignedKt.doubleToUInt(androidx.compose.foundation.layout.PaddingKt.calculateStartPadding(paddingValues, layoutDirection))) + UnsignedKt.doubleToUInt(androidx.compose.foundation.layout.PaddingKt.calculateEndPadding(paddingValues, layoutDirection))), null);
        } else {
            if (!(width instanceof SizeConstraint.Fill ? true : width instanceof SizeConstraint.Fit)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        SizeConstraint.Fixed height = size.getHeight();
        if (height instanceof SizeConstraint.Fixed) {
            height = new SizeConstraint.Fixed(UInt.m11540constructorimpl(UInt.m11540constructorimpl(((SizeConstraint.Fixed) height).getValue() + UnsignedKt.doubleToUInt(paddingValues.getTop())) + UnsignedKt.doubleToUInt(paddingValues.getBottom())), null);
        } else {
            if (!(height instanceof SizeConstraint.Fill ? true : height instanceof SizeConstraint.Fit)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return new Size(width, height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedStackPartial getPresentedPartial() {
        return (PresentedStackPartial) this.presentedPartial.getValue();
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

    public static /* synthetic */ void update$default(StackComponentState stackComponentState, WindowWidthSizeClass windowWidthSizeClass, LayoutDirection layoutDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            windowWidthSizeClass = null;
        }
        if ((i & 2) != 0) {
            layoutDirection = null;
        }
        stackComponentState.update(windowWidthSizeClass, layoutDirection);
    }

    public final /* synthetic */ boolean getApplyBottomWindowInsets() {
        return this.applyBottomWindowInsets;
    }

    public final /* synthetic */ boolean getApplyHorizontalWindowInsets() {
        return this.applyHorizontalWindowInsets;
    }

    public final /* synthetic */ boolean getApplyTopWindowInsets() {
        return this.applyTopWindowInsets;
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return (BackgroundStyles) this.background.getValue();
    }

    public final /* synthetic */ BadgeStyle getBadge() {
        return (BadgeStyle) this.badge.getValue();
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return (BorderStyles) this.border.getValue();
    }

    public final /* synthetic */ List getChildren() {
        return this.children;
    }

    public final /* synthetic */ Dimension getDimension() {
        return (Dimension) this.dimension.getValue();
    }

    public final /* synthetic */ boolean getIgnoreHeaderHeight() {
        return this.ignoreHeaderHeight;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding.getValue();
    }

    public final /* synthetic */ Orientation getScrollOrientation() {
        return (Orientation) this.scrollOrientation.getValue();
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

    /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m10564getSpacingD9Ej5fM() {
        return ((Dp) this.spacing.getValue()).m9128unboximpl();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowSize, LayoutDirection layoutDirection) {
        if (windowSize != null) {
            setWindowSize(windowSize);
        }
        if (layoutDirection != null) {
            setLayoutDirection(layoutDirection);
        }
    }
}
