package com.revenuecat.purchases.ui.revenuecatui;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 :2\u00020\u0001:\u00029:B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B¡\u0001\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012>\b\u0002\u0010\u0014\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015\u0012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\u0002\u0010 J\u0097\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00152\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0000¢\u0006\u0002\b4J\u0013\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00107\u001a\u000208H\u0016R\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$RJ\u0010\u0014\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006;"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "", "builder", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions$Builder;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions$Builder;)V", "offeringSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "shouldDisplayDismissButton", "", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "dismissRequest", "Lkotlin/Function0;", "", "dismissRequestWithExitOffering", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/Offering;", "Lkotlin/ParameterName;", "name", "exitOffering", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "result", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;ZLcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Ljava/util/Map;)V", "getCustomVariables", "()Ljava/util/Map;", "getDismissRequest", "()Lkotlin/jvm/functions/Function0;", "getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release", "()Lkotlin/jvm/functions/Function2;", "getFontProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "getListener", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getMode$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "getOfferingSelection$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "getPurchaseLogic", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release", "()Z", "copy", "copy$revenuecatui_defaultsBc8Release", "equals", "other", "hashCode", "", "Builder", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallOptions {
    public static final int $stable = 0;
    private static final int hashMultiplier = 31;
    private final Map<String, CustomVariableValue> customVariables;
    private final Function0<Unit> dismissRequest;
    private final Function2<Offering, PaywallResult, Unit> dismissRequestWithExitOffering;
    private final FontProvider fontProvider;
    private final PaywallListener listener;
    private final PaywallMode mode;
    private final OfferingSelection offeringSelection;
    private final PaywallPurchaseLogic purchaseLogic;
    private final boolean shouldDisplayDismissButton;

    /* JADX INFO: compiled from: PaywallOptions.kt */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010<\u001a\u00020=J\u001a\u0010>\u001a\u00020\u00002\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J-\u0010@\u001a\u00020\u00002\u001e\u0010\u0010\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\u0016J\u0010\u0010A\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010B\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0015\u0010C\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b(J\u0010\u0010D\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0012J\u0017\u0010F\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u00010HH\u0000¢\u0006\u0002\bIJ\u0017\u0010J\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0002\b.J\u0010\u0010K\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u000101J\u000e\u0010L\u001a\u00020\u00002\u0006\u00106\u001a\u000207R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR2\u0010\u0010\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006M"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions$Builder;", "", "dismissRequest", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "getCustomVariables$revenuecatui_defaultsBc8Release", "()Ljava/util/Map;", "setCustomVariables$revenuecatui_defaultsBc8Release", "(Ljava/util/Map;)V", "getDismissRequest$revenuecatui_defaultsBc8Release", "()Lkotlin/jvm/functions/Function0;", "dismissRequestWithExitOffering", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release", "()Lkotlin/jvm/functions/Function2;", "setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release", "(Lkotlin/jvm/functions/Function2;)V", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "getFontProvider$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "setFontProvider$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getListener$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "setListener$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;)V", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "getMode$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "setMode$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;)V", "offeringSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "getOfferingSelection$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "setOfferingSelection$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;)V", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getPurchaseLogic$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "setPurchaseLogic$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;)V", "shouldDisplayDismissButton", "", "getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release", "()Z", "setShouldDisplayDismissButton$revenuecatui_defaultsBc8Release", "(Z)V", "build", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "setCustomVariables", "variables", "setDismissRequestWithExitOffering", "setFontProvider", InAppPurchaseConstants.METHOD_SET_LISTENER, "setMode", "setOffering", "offering", "setOfferingIdAndPresentedOfferingContext", "idAndPresentedOfferingContext", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;", "setOfferingIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release", "setOfferingSelection", "setPurchaseLogic", "setShouldDisplayDismissButton", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private Map<String, ? extends CustomVariableValue> customVariables;
        private final Function0<Unit> dismissRequest;
        private Function2<? super Offering, ? super PaywallResult, Unit> dismissRequestWithExitOffering;
        private FontProvider fontProvider;
        private PaywallListener listener;
        private PaywallMode mode;
        private OfferingSelection offeringSelection;
        private PaywallPurchaseLogic purchaseLogic;
        private boolean shouldDisplayDismissButton;

        public Builder(Function0<Unit> dismissRequest) {
            Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
            this.dismissRequest = dismissRequest;
            this.offeringSelection = OfferingSelection.None.INSTANCE;
            this.mode = PaywallMode.INSTANCE.getDefault();
            this.customVariables = MapsKt.emptyMap();
        }

        public final PaywallOptions build() {
            return new PaywallOptions(this);
        }

        public final Map<String, CustomVariableValue> getCustomVariables$revenuecatui_defaultsBc8Release() {
            return this.customVariables;
        }

        public final Function0<Unit> getDismissRequest$revenuecatui_defaultsBc8Release() {
            return this.dismissRequest;
        }

        public final Function2<Offering, PaywallResult, Unit> getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release() {
            return this.dismissRequestWithExitOffering;
        }

        /* JADX INFO: renamed from: getFontProvider$revenuecatui_defaultsBc8Release, reason: from getter */
        public final FontProvider getFontProvider() {
            return this.fontProvider;
        }

        /* JADX INFO: renamed from: getListener$revenuecatui_defaultsBc8Release, reason: from getter */
        public final PaywallListener getListener() {
            return this.listener;
        }

        /* JADX INFO: renamed from: getMode$revenuecatui_defaultsBc8Release, reason: from getter */
        public final PaywallMode getMode() {
            return this.mode;
        }

        /* JADX INFO: renamed from: getOfferingSelection$revenuecatui_defaultsBc8Release, reason: from getter */
        public final OfferingSelection getOfferingSelection() {
            return this.offeringSelection;
        }

        /* JADX INFO: renamed from: getPurchaseLogic$revenuecatui_defaultsBc8Release, reason: from getter */
        public final PaywallPurchaseLogic getPurchaseLogic() {
            return this.purchaseLogic;
        }

        /* JADX INFO: renamed from: getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release, reason: from getter */
        public final boolean getShouldDisplayDismissButton() {
            return this.shouldDisplayDismissButton;
        }

        public final Builder setCustomVariables(Map<String, ? extends CustomVariableValue> variables) {
            Intrinsics.checkNotNullParameter(variables, "variables");
            this.customVariables = CustomVariableKeyValidator.INSTANCE.validateAndFilter(variables);
            return this;
        }

        public final void setCustomVariables$revenuecatui_defaultsBc8Release(Map<String, ? extends CustomVariableValue> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.customVariables = map;
        }

        public final Builder setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release(Function2<? super Offering, ? super PaywallResult, Unit> dismissRequestWithExitOffering) {
            this.dismissRequestWithExitOffering = dismissRequestWithExitOffering;
            return this;
        }

        /* JADX INFO: renamed from: setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release, reason: collision with other method in class */
        public final void m10447x1d639bc0(Function2<? super Offering, ? super PaywallResult, Unit> function2) {
            this.dismissRequestWithExitOffering = function2;
        }

        public final Builder setFontProvider(FontProvider fontProvider) {
            this.fontProvider = fontProvider;
            return this;
        }

        public final void setFontProvider$revenuecatui_defaultsBc8Release(FontProvider fontProvider) {
            this.fontProvider = fontProvider;
        }

        public final Builder setListener(PaywallListener listener) {
            this.listener = listener;
            return this;
        }

        public final void setListener$revenuecatui_defaultsBc8Release(PaywallListener paywallListener) {
            this.listener = paywallListener;
        }

        public final Builder setMode$revenuecatui_defaultsBc8Release(PaywallMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
            return this;
        }

        /* JADX INFO: renamed from: setMode$revenuecatui_defaultsBc8Release, reason: collision with other method in class */
        public final void m10448setMode$revenuecatui_defaultsBc8Release(PaywallMode paywallMode) {
            Intrinsics.checkNotNullParameter(paywallMode, "<set-?>");
            this.mode = paywallMode;
        }

        public final Builder setOffering(Offering offering) {
            this.offeringSelection = offering != null ? new OfferingSelection.OfferingType(offering) : OfferingSelection.None.INSTANCE;
            return this;
        }

        public final Builder setOfferingIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release(OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext) {
            OfferingSelection offeringSelection = idAndPresentedOfferingContext;
            if (idAndPresentedOfferingContext == null) {
                offeringSelection = OfferingSelection.None.INSTANCE;
            }
            this.offeringSelection = offeringSelection;
            return this;
        }

        public final Builder setOfferingSelection$revenuecatui_defaultsBc8Release(OfferingSelection offeringSelection) {
            if (offeringSelection == null) {
                offeringSelection = OfferingSelection.None.INSTANCE;
            }
            this.offeringSelection = offeringSelection;
            return this;
        }

        /* JADX INFO: renamed from: setOfferingSelection$revenuecatui_defaultsBc8Release, reason: collision with other method in class */
        public final void m10449setOfferingSelection$revenuecatui_defaultsBc8Release(OfferingSelection offeringSelection) {
            Intrinsics.checkNotNullParameter(offeringSelection, "<set-?>");
            this.offeringSelection = offeringSelection;
        }

        public final Builder setPurchaseLogic(PaywallPurchaseLogic purchaseLogic) {
            this.purchaseLogic = purchaseLogic;
            return this;
        }

        public final void setPurchaseLogic$revenuecatui_defaultsBc8Release(PaywallPurchaseLogic paywallPurchaseLogic) {
            this.purchaseLogic = paywallPurchaseLogic;
        }

        public final Builder setShouldDisplayDismissButton(boolean shouldDisplayDismissButton) {
            this.shouldDisplayDismissButton = shouldDisplayDismissButton;
            return this;
        }

        public final void setShouldDisplayDismissButton$revenuecatui_defaultsBc8Release(boolean z) {
            this.shouldDisplayDismissButton = z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallOptions(OfferingSelection offeringSelection, boolean z, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode mode, Function0<Unit> dismissRequest, Function2<? super Offering, ? super PaywallResult, Unit> function2, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(offeringSelection, "offeringSelection");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.offeringSelection = offeringSelection;
        this.shouldDisplayDismissButton = z;
        this.fontProvider = fontProvider;
        this.listener = paywallListener;
        this.purchaseLogic = paywallPurchaseLogic;
        this.mode = mode;
        this.dismissRequest = dismissRequest;
        this.dismissRequestWithExitOffering = function2;
        this.customVariables = customVariables;
    }

    public /* synthetic */ PaywallOptions(OfferingSelection offeringSelection, boolean z, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode paywallMode, Function0 function0, Function2 function2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(offeringSelection, z, fontProvider, paywallListener, paywallPurchaseLogic, paywallMode, function0, (i & 128) != 0 ? null : function2, (i & 256) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallOptions(Builder builder) {
        this(builder.getOfferingSelection(), builder.getShouldDisplayDismissButton(), builder.getFontProvider(), builder.getListener(), builder.getPurchaseLogic(), builder.getMode(), builder.getDismissRequest$revenuecatui_defaultsBc8Release(), builder.getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release(), builder.getCustomVariables$revenuecatui_defaultsBc8Release());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallOptions copy$revenuecatui_defaultsBc8Release$default(PaywallOptions paywallOptions, OfferingSelection offeringSelection, boolean z, FontProvider fontProvider, PaywallListener paywallListener, PaywallPurchaseLogic paywallPurchaseLogic, PaywallMode paywallMode, Function0 function0, Function2 function2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            offeringSelection = paywallOptions.offeringSelection;
        }
        if ((i & 2) != 0) {
            z = paywallOptions.shouldDisplayDismissButton;
        }
        if ((i & 4) != 0) {
            fontProvider = paywallOptions.fontProvider;
        }
        if ((i & 8) != 0) {
            paywallListener = paywallOptions.listener;
        }
        if ((i & 16) != 0) {
            paywallPurchaseLogic = paywallOptions.purchaseLogic;
        }
        if ((i & 32) != 0) {
            paywallMode = paywallOptions.mode;
        }
        if ((i & 64) != 0) {
            function0 = paywallOptions.dismissRequest;
        }
        if ((i & 128) != 0) {
            function2 = paywallOptions.dismissRequestWithExitOffering;
        }
        if ((i & 256) != 0) {
            map = paywallOptions.customVariables;
        }
        Function2 function22 = function2;
        Map map2 = map;
        PaywallMode paywallMode2 = paywallMode;
        Function0 function02 = function0;
        PaywallPurchaseLogic paywallPurchaseLogic2 = paywallPurchaseLogic;
        FontProvider fontProvider2 = fontProvider;
        return paywallOptions.copy$revenuecatui_defaultsBc8Release(offeringSelection, z, fontProvider2, paywallListener, paywallPurchaseLogic2, paywallMode2, function02, function22, map2);
    }

    public final PaywallOptions copy$revenuecatui_defaultsBc8Release(OfferingSelection offeringSelection, boolean shouldDisplayDismissButton, FontProvider fontProvider, PaywallListener listener, PaywallPurchaseLogic purchaseLogic, PaywallMode mode, Function0<Unit> dismissRequest, Function2<? super Offering, ? super PaywallResult, Unit> dismissRequestWithExitOffering, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(offeringSelection, "offeringSelection");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(dismissRequest, "dismissRequest");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        return new PaywallOptions(offeringSelection, shouldDisplayDismissButton, fontProvider, listener, purchaseLogic, mode, dismissRequest, dismissRequestWithExitOffering, customVariables);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallOptions)) {
            return false;
        }
        PaywallOptions paywallOptions = (PaywallOptions) other;
        if (Intrinsics.areEqual(this.offeringSelection, paywallOptions.offeringSelection) && this.shouldDisplayDismissButton == paywallOptions.shouldDisplayDismissButton && Intrinsics.areEqual(this.fontProvider, paywallOptions.fontProvider) && Intrinsics.areEqual(this.listener, paywallOptions.listener) && Intrinsics.areEqual(this.purchaseLogic, paywallOptions.purchaseLogic) && this.mode == paywallOptions.mode && Intrinsics.areEqual(this.customVariables, paywallOptions.customVariables)) {
            return Intrinsics.areEqual(this.dismissRequest, paywallOptions.dismissRequest);
        }
        return false;
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    public final Function0<Unit> getDismissRequest() {
        return this.dismissRequest;
    }

    public final Function2<Offering, PaywallResult, Unit> getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release() {
        return this.dismissRequestWithExitOffering;
    }

    public final FontProvider getFontProvider() {
        return this.fontProvider;
    }

    public final PaywallListener getListener() {
        return this.listener;
    }

    /* JADX INFO: renamed from: getMode$revenuecatui_defaultsBc8Release, reason: from getter */
    public final PaywallMode getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: getOfferingSelection$revenuecatui_defaultsBc8Release, reason: from getter */
    public final OfferingSelection getOfferingSelection() {
        return this.offeringSelection;
    }

    public final PaywallPurchaseLogic getPurchaseLogic() {
        return this.purchaseLogic;
    }

    /* JADX INFO: renamed from: getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release, reason: from getter */
    public final boolean getShouldDisplayDismissButton() {
        return this.shouldDisplayDismissButton;
    }

    public int hashCode() {
        String offeringIdentifier = this.offeringSelection.getOfferingIdentifier();
        return ((((((offeringIdentifier != null ? offeringIdentifier.hashCode() : 0) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31) + this.mode.hashCode()) * 31) + this.customVariables.hashCode();
    }

    public String toString() {
        return "PaywallOptions(offeringSelection=" + this.offeringSelection + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", fontProvider=" + this.fontProvider + ", listener=" + this.listener + ", purchaseLogic=" + this.purchaseLogic + ", mode=" + this.mode + ", dismissRequest=" + this.dismissRequest + ", dismissRequestWithExitOffering=" + this.dismissRequestWithExitOffering + ", customVariables=" + this.customVariables + ')';
    }
}
