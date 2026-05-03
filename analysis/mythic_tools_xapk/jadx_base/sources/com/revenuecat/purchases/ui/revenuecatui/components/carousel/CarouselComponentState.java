package com.revenuecat.purchases.ui.revenuecatui.components.carousel;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedCarouselPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CarouselComponentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0007¢\u0006\u0002\u0010\u0011J\u0012\u0010l\u001a\u00020m2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u0003R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001f\u0010 R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0017\u001a\u0004\b-\u0010.R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0017\u001a\u0004\b3\u0010.R\u001b\u00105\u001a\u0002068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0017\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0017\u001a\u0004\b<\u0010=R!\u0010?\u001a\u00020@8FX\u0086\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bC\u0010\u0017\u001a\u0004\bA\u0010BR!\u0010D\u001a\u00020@8FX\u0086\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bF\u0010\u0017\u001a\u0004\bE\u0010BR!\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0017\u001a\u0004\bJ\u0010KR\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0017\u001a\u0004\bO\u0010PR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010R\u001a\u0004\u0018\u00010S8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0017\u001a\u0004\bT\u0010UR\u001b\u0010W\u001a\u00020X8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0017\u001a\u0004\bY\u0010ZR\u001b\u0010\\\u001a\u00020]8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u0017\u001a\u0004\b^\u0010_R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010a\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0017\u001a\u0004\bb\u0010)R+\u0010e\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/carousel/CarouselComponentState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "autoAdvance", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "getAutoAdvance", "()Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "autoAdvance$delegate", "Landroidx/compose/runtime/State;", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "background$delegate", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "border$delegate", "initialPageIndex", "getInitialPageIndex", "()I", "initialPageIndex$delegate", "loop", "", "getLoop", "()Z", "loop$delegate", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "margin$delegate", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "padding", "getPadding", "padding$delegate", "pageAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "getPageAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "pageAlignment$delegate", "pageControl", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "getPageControl", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "pageControl$delegate", "pagePeek", "Landroidx/compose/ui/unit/Dp;", "getPagePeek-D9Ej5fM", "()F", "pagePeek$delegate", "pageSpacing", "getPageSpacing-D9Ej5fM", "pageSpacing$delegate", "pages", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "getPages", "()Ljava/util/List;", "pages$delegate", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedCarouselPartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedCarouselPartial;", "presentedPartial$delegate", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "shadow$delegate", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "shape$delegate", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size$delegate", "visible", "getVisible", "visible$delegate", "<set-?>", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarouselComponentState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: autoAdvance$delegate, reason: from kotlin metadata */
    private final State autoAdvance;

    /* JADX INFO: renamed from: background$delegate, reason: from kotlin metadata */
    private final State background;

    /* JADX INFO: renamed from: border$delegate, reason: from kotlin metadata */
    private final State border;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;

    /* JADX INFO: renamed from: initialPageIndex$delegate, reason: from kotlin metadata */
    private final State initialPageIndex;

    /* JADX INFO: renamed from: loop$delegate, reason: from kotlin metadata */
    private final State loop;

    /* JADX INFO: renamed from: margin$delegate, reason: from kotlin metadata */
    private final State margin;
    private final PackageAwareDelegate packageAwareDelegate;

    /* JADX INFO: renamed from: padding$delegate, reason: from kotlin metadata */
    private final State padding;

    /* JADX INFO: renamed from: pageAlignment$delegate, reason: from kotlin metadata */
    private final State pageAlignment;

    /* JADX INFO: renamed from: pageControl$delegate, reason: from kotlin metadata */
    private final State pageControl;

    /* JADX INFO: renamed from: pagePeek$delegate, reason: from kotlin metadata */
    private final State pagePeek;

    /* JADX INFO: renamed from: pageSpacing$delegate, reason: from kotlin metadata */
    private final State pageSpacing;

    /* JADX INFO: renamed from: pages$delegate, reason: from kotlin metadata */
    private final State pages;

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
    private final CarouselComponentStyle style;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final State visible;

    /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
    private final MutableState windowSize;

    /* JADX WARN: Multi-variable type inference failed */
    public CarouselComponentState(WindowWidthSizeClass initialWindowSize, CarouselComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
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
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0<PresentedCarouselPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$presentedPartial$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PresentedCarouselPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedCarouselPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.visible = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$visible$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialCarouselComponent partial;
                Boolean visible;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.initialPageIndex = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$initialPageIndex$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialCarouselComponent partial;
                Integer initialPageIndex;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (initialPageIndex = partial.getInitialPageIndex()) == null) ? this.this$0.style.getInitialPageIndex() : initialPageIndex.intValue());
            }
        });
        this.pages = SnapshotStateKt.derivedStateOf(new Function0<List<? extends StackComponentStyle>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pages$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends StackComponentStyle> invoke() {
                return this.this$0.style.getPages();
            }
        });
        this.pageAlignment = SnapshotStateKt.derivedStateOf(new Function0<Alignment.Vertical>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pageAlignment$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Alignment.Vertical invoke() {
                PartialCarouselComponent partial;
                VerticalAlignment pageAlignment;
                Alignment.Vertical alignment;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (pageAlignment = partial.getPageAlignment()) == null || (alignment = AlignmentKt.toAlignment(pageAlignment)) == null) ? this.this$0.style.getPageAlignment() : alignment;
            }
        });
        this.size = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$size$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                PartialCarouselComponent partial;
                Size size;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) ? this.this$0.style.getSize() : size;
            }
        });
        this.pagePeek = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pagePeek$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Dp invoke() {
                return Dp.m9112boximpl(m10466invokeD9Ej5fM());
            }

            /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
            public final float m10466invokeD9Ej5fM() {
                PartialCarouselComponent partial;
                Integer pagePeek;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (pagePeek = partial.getPagePeek()) == null) ? this.this$0.style.m10575getPagePeekD9Ej5fM() : Dp.m9114constructorimpl(pagePeek.intValue());
            }
        });
        this.background = SnapshotStateKt.derivedStateOf(new Function0<BackgroundStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$background$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackgroundStyles invoke() {
                BackgroundStyles backgroundStyles;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (backgroundStyles = presentedPartial.getBackgroundStyles()) == null) ? this.this$0.style.getBackground() : backgroundStyles;
            }
        });
        this.pageSpacing = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pageSpacing$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Dp invoke() {
                return Dp.m9112boximpl(m10467invokeD9Ej5fM());
            }

            /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
            public final float m10467invokeD9Ej5fM() {
                PartialCarouselComponent partial;
                Float pageSpacing;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (pageSpacing = partial.getPageSpacing()) == null) ? this.this$0.style.m10576getPageSpacingD9Ej5fM() : Dp.m9114constructorimpl(pageSpacing.floatValue());
            }
        });
        this.padding = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$padding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialCarouselComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$margin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialCarouselComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.shape = SnapshotStateKt.derivedStateOf(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$shape$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                PartialCarouselComponent partial;
                com.revenuecat.purchases.paywalls.components.properties.Shape shape;
                Shape shape2;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (shape = partial.getShape()) == null || (shape2 = ShapeKt.toShape(shape)) == null) ? ShapeKt.toShape(this.this$0.style.getShape()) : shape2;
            }
        });
        this.border = SnapshotStateKt.derivedStateOf(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$border$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                BorderStyles borderStyles;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (borderStyles = presentedPartial.getBorderStyles()) == null) ? this.this$0.style.getBorder() : borderStyles;
            }
        });
        this.shadow = SnapshotStateKt.derivedStateOf(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$shadow$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                ShadowStyles shadowStyles;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (shadowStyles = presentedPartial.getShadowStyles()) == null) ? this.this$0.style.getShadow() : shadowStyles;
            }
        });
        this.pageControl = SnapshotStateKt.derivedStateOf(new Function0<CarouselComponentStyle.PageControlStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pageControl$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CarouselComponentStyle.PageControlStyles invoke() {
                CarouselComponentStyle.PageControlStyles pageControlStyles;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (pageControlStyles = presentedPartial.getPageControlStyles()) == null) ? this.this$0.style.getPageControl() : pageControlStyles;
            }
        });
        this.loop = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$loop$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialCarouselComponent partial;
                Boolean loop;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (loop = partial.getLoop()) == null) ? this.this$0.style.getLoop() : loop.booleanValue());
            }
        });
        this.autoAdvance = SnapshotStateKt.derivedStateOf(new Function0<CarouselComponent.AutoAdvancePages>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$autoAdvance$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CarouselComponent.AutoAdvancePages invoke() {
                PartialCarouselComponent partial;
                CarouselComponent.AutoAdvancePages autoAdvance;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (autoAdvance = partial.getAutoAdvance()) == null) ? this.this$0.style.getAutoAdvance() : autoAdvance;
            }
        });
    }

    public /* synthetic */ CarouselComponentState(WindowWidthSizeClass windowWidthSizeClass, CarouselComponentStyle carouselComponentStyle, Function0 function0, Function0 function02, Function0 function03, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, carouselComponentStyle, function0, function02, function03, (i & 32) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedCarouselPartial getPresentedPartial() {
        return (PresentedCarouselPartial) this.presentedPartial.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize.getValue();
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(CarouselComponentState carouselComponentState, WindowWidthSizeClass windowWidthSizeClass, int i, Object obj) {
        if ((i & 1) != 0) {
            windowWidthSizeClass = null;
        }
        carouselComponentState.update(windowWidthSizeClass);
    }

    public final /* synthetic */ CarouselComponent.AutoAdvancePages getAutoAdvance() {
        return (CarouselComponent.AutoAdvancePages) this.autoAdvance.getValue();
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return (BackgroundStyles) this.background.getValue();
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return (BorderStyles) this.border.getValue();
    }

    public final /* synthetic */ int getInitialPageIndex() {
        return ((Number) this.initialPageIndex.getValue()).intValue();
    }

    public final /* synthetic */ boolean getLoop() {
        return ((Boolean) this.loop.getValue()).booleanValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding.getValue();
    }

    public final /* synthetic */ Alignment.Vertical getPageAlignment() {
        return (Alignment.Vertical) this.pageAlignment.getValue();
    }

    public final /* synthetic */ CarouselComponentStyle.PageControlStyles getPageControl() {
        return (CarouselComponentStyle.PageControlStyles) this.pageControl.getValue();
    }

    /* JADX INFO: renamed from: getPagePeek-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m10464getPagePeekD9Ej5fM() {
        return ((Dp) this.pagePeek.getValue()).m9128unboximpl();
    }

    /* JADX INFO: renamed from: getPageSpacing-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m10465getPageSpacingD9Ej5fM() {
        return ((Dp) this.pageSpacing.getValue()).m9128unboximpl();
    }

    public final /* synthetic */ List getPages() {
        return (List) this.pages.getValue();
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

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowSize) {
        if (windowSize != null) {
            setWindowSize(windowSize);
        }
    }
}
