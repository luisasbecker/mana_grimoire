package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponent;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponentItem;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelineItemPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelinePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimelineComponentState.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001KB]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0007¢\u0006\u0002\u0010\u0011J\u0012\u0010I\u001a\u00020J2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003R\u001b\u0010\u0012\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001d\u0010\u0014R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b'\u0010(R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b-\u0010(R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0016\u001a\u0004\b1\u00102R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00104\u001a\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0016\u001a\u0004\b6\u00107R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0016\u001a\u0004\b:\u0010\u0014R\u001b\u0010<\u001a\u00020=8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0016\u001a\u0004\b>\u0010?R+\u0010B\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006L"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/timeline/TimelineComponentState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "columnGutter", "getColumnGutter", "()I", "columnGutter$delegate", "Landroidx/compose/runtime/State;", "iconAlignment", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "getIconAlignment", "()Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "iconAlignment$delegate", "itemSpacing", "getItemSpacing", "itemSpacing$delegate", FirebaseAnalytics.Param.ITEMS, "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/timeline/TimelineComponentState$ItemState;", "getItems", "()Ljava/util/List;", "items$delegate", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "margin$delegate", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "padding", "getPadding", "padding$delegate", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelinePartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelinePartial;", "presentedPartial$delegate", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size$delegate", "textSpacing", "getTextSpacing", "textSpacing$delegate", "visible", "", "getVisible", "()Z", "visible$delegate", "<set-?>", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "ItemState", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimelineComponentState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: columnGutter$delegate, reason: from kotlin metadata */
    private final State columnGutter;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;

    /* JADX INFO: renamed from: iconAlignment$delegate, reason: from kotlin metadata */
    private final State iconAlignment;

    /* JADX INFO: renamed from: itemSpacing$delegate, reason: from kotlin metadata */
    private final State itemSpacing;

    /* JADX INFO: renamed from: items$delegate, reason: from kotlin metadata */
    private final State items;

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

    /* JADX INFO: renamed from: size$delegate, reason: from kotlin metadata */
    private final State size;
    private final TimelineComponentStyle style;

    /* JADX INFO: renamed from: textSpacing$delegate, reason: from kotlin metadata */
    private final State textSpacing;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final State visible;

    /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
    private final MutableState windowSize;

    /* JADX INFO: compiled from: TimelineComponentState.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0007¢\u0006\u0002\u0010\u0011J\u0012\u00109\u001a\u00020:2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b&\u0010'R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b*\u0010\u001bR\u001b\u0010,\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0017\u001a\u0004\b.\u0010/R+\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/timeline/TimelineComponentState$ItemState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "connector", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;", "getConnector", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;", "connector$delegate", "Landroidx/compose/runtime/State;", "description", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "getDescription", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "description$delegate", "icon", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "getIcon", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "icon$delegate", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelineItemPartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelineItemPartial;", "presentedPartial$delegate", Constants.GP_IAP_TITLE, "getTitle", "title$delegate", "visible", "", "getVisible", "()Z", "visible$delegate", "<set-?>", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ItemState {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: connector$delegate, reason: from kotlin metadata */
        private final State connector;
        private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;

        /* JADX INFO: renamed from: description$delegate, reason: from kotlin metadata */
        private final State description;

        /* JADX INFO: renamed from: icon$delegate, reason: from kotlin metadata */
        private final State icon;
        private final PackageAwareDelegate packageAwareDelegate;

        /* JADX INFO: renamed from: presentedPartial$delegate, reason: from kotlin metadata */
        private final State presentedPartial;
        private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
        private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
        private final Function0<Integer> selectedTabIndexProvider;
        private final TimelineComponentStyle.ItemStyle style;

        /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
        private final State title;

        /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
        private final State visible;

        /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
        private final MutableState windowSize;

        /* JADX WARN: Multi-variable type inference failed */
        public ItemState(WindowWidthSizeClass initialWindowSize, TimelineComponentStyle.ItemStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
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
            this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0<PresentedTimelineItemPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$presentedPartial$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PresentedTimelineItemPartial invoke() {
                    Package rcPackage;
                    ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                    ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                    List overrides = this.this$0.style.getOverrides();
                    OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                    PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                    return (PresentedTimelineItemPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
                }
            });
            this.visible = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$visible$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    PartialTimelineComponentItem partial;
                    Boolean visible;
                    PresentedTimelineItemPartial presentedPartial = this.this$0.getPresentedPartial();
                    return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
                }
            });
            this.title = SnapshotStateKt.derivedStateOf(new Function0<TextComponentStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$title$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextComponentStyle invoke() {
                    return this.this$0.style.getTitle();
                }
            });
            this.description = SnapshotStateKt.derivedStateOf(new Function0<TextComponentStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$description$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextComponentStyle invoke() {
                    return this.this$0.style.getDescription();
                }
            });
            this.icon = SnapshotStateKt.derivedStateOf(new Function0<IconComponentStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$icon$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final IconComponentStyle invoke() {
                    return this.this$0.style.getIcon();
                }
            });
            this.connector = SnapshotStateKt.derivedStateOf(new Function0<TimelineComponentStyle.ConnectorStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$connector$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TimelineComponentStyle.ConnectorStyle invoke() {
                    TimelineComponentStyle.ConnectorStyle connectorStyle;
                    PresentedTimelineItemPartial presentedPartial = this.this$0.getPresentedPartial();
                    return (presentedPartial == null || (connectorStyle = presentedPartial.getConnectorStyle()) == null) ? this.this$0.style.getConnector() : connectorStyle;
                }
            });
        }

        public /* synthetic */ ItemState(WindowWidthSizeClass windowWidthSizeClass, TimelineComponentStyle.ItemStyle itemStyle, Function0 function0, Function0 function02, Function0 function03, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(windowWidthSizeClass, itemStyle, function0, function02, function03, (i & 32) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState.ItemState.1
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends CustomVariableValue> invoke() {
                    return MapsKt.emptyMap();
                }
            } : anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PresentedTimelineItemPartial getPresentedPartial() {
            return (PresentedTimelineItemPartial) this.presentedPartial.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final WindowWidthSizeClass getWindowSize() {
            return (WindowWidthSizeClass) this.windowSize.getValue();
        }

        private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
            this.windowSize.setValue(windowWidthSizeClass);
        }

        public static /* synthetic */ void update$default(ItemState itemState, WindowWidthSizeClass windowWidthSizeClass, int i, Object obj) {
            if ((i & 1) != 0) {
                windowWidthSizeClass = null;
            }
            itemState.update(windowWidthSizeClass);
        }

        public final /* synthetic */ TimelineComponentStyle.ConnectorStyle getConnector() {
            return (TimelineComponentStyle.ConnectorStyle) this.connector.getValue();
        }

        public final /* synthetic */ TextComponentStyle getDescription() {
            return (TextComponentStyle) this.description.getValue();
        }

        public final /* synthetic */ IconComponentStyle getIcon() {
            return (IconComponentStyle) this.icon.getValue();
        }

        public final /* synthetic */ TextComponentStyle getTitle() {
            return (TextComponentStyle) this.title.getValue();
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

    /* JADX WARN: Multi-variable type inference failed */
    public TimelineComponentState(WindowWidthSizeClass initialWindowSize, TimelineComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
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
        this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0<PresentedTimelinePartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$presentedPartial$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PresentedTimelinePartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedTimelinePartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.visible = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$visible$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialTimelineComponent partial;
                Boolean visible;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.itemSpacing = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$itemSpacing$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialTimelineComponent partial;
                Integer itemSpacing;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (itemSpacing = partial.getItemSpacing()) == null) ? this.this$0.style.getItemSpacing() : itemSpacing.intValue());
            }
        });
        this.textSpacing = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$textSpacing$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialTimelineComponent partial;
                Integer textSpacing;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (textSpacing = partial.getTextSpacing()) == null) ? this.this$0.style.getTextSpacing() : textSpacing.intValue());
            }
        });
        this.columnGutter = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$columnGutter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialTimelineComponent partial;
                Integer columnGutter;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (columnGutter = partial.getColumnGutter()) == null) ? this.this$0.style.getColumnGutter() : columnGutter.intValue());
            }
        });
        this.iconAlignment = SnapshotStateKt.derivedStateOf(new Function0<TimelineComponent.IconAlignment>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$iconAlignment$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TimelineComponent.IconAlignment invoke() {
                PartialTimelineComponent partial;
                TimelineComponent.IconAlignment iconAlignment;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (iconAlignment = partial.getIconAlignment()) == null) ? this.this$0.style.getIconAlignment() : iconAlignment;
            }
        });
        this.size = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$size$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                PartialTimelineComponent partial;
                Size size;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) ? this.this$0.style.getSize() : size;
            }
        });
        this.padding = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$padding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTimelineComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$margin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTimelineComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.items = SnapshotStateKt.derivedStateOf(new Function0<List<? extends ItemState>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$items$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends TimelineComponentState.ItemState> invoke() {
                List items = this.this$0.style.getItems();
                TimelineComponentState timelineComponentState = this.this$0;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
                Iterator it = items.iterator();
                while (it.hasNext()) {
                    arrayList.add(new TimelineComponentState.ItemState(timelineComponentState.getWindowSize(), (TimelineComponentStyle.ItemStyle) it.next(), timelineComponentState.selectedPackageInfoProvider, timelineComponentState.selectedTabIndexProvider, timelineComponentState.selectedOfferEligibilityProvider, timelineComponentState.customVariablesProvider));
                }
                return arrayList;
            }
        });
    }

    public /* synthetic */ TimelineComponentState(WindowWidthSizeClass windowWidthSizeClass, TimelineComponentStyle timelineComponentStyle, Function0 function0, Function0 function02, Function0 function03, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, timelineComponentStyle, function0, function02, function03, (i & 32) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedTimelinePartial getPresentedPartial() {
        return (PresentedTimelinePartial) this.presentedPartial.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize.getValue();
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(TimelineComponentState timelineComponentState, WindowWidthSizeClass windowWidthSizeClass, int i, Object obj) {
        if ((i & 1) != 0) {
            windowWidthSizeClass = null;
        }
        timelineComponentState.update(windowWidthSizeClass);
    }

    public final /* synthetic */ int getColumnGutter() {
        return ((Number) this.columnGutter.getValue()).intValue();
    }

    public final /* synthetic */ TimelineComponent.IconAlignment getIconAlignment() {
        return (TimelineComponent.IconAlignment) this.iconAlignment.getValue();
    }

    public final /* synthetic */ int getItemSpacing() {
        return ((Number) this.itemSpacing.getValue()).intValue();
    }

    public final /* synthetic */ List getItems() {
        return (List) this.items.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding.getValue();
    }

    public final /* synthetic */ Size getSize() {
        return (Size) this.size.getValue();
    }

    public final /* synthetic */ int getTextSpacing() {
        return ((Number) this.textSpacing.getValue()).intValue();
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
