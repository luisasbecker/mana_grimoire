package com.revenuecat.purchases.ui.revenuecatui.data;

import android.app.Activity;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.State;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: PaywallViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\b\u0010\u0018\u001a\u00020\u0019H&J\u0014\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H&J,\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H¦@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u0019H&J\b\u0010,\u001a\u00020\u0019H&J\u0012\u0010-\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H&J\u0018\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\bH&J\b\u00102\u001a\u00020\u0019H&J\b\u00103\u001a\u00020\u0019H&J\u0010\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u000206H&J\u0018\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u001eH&J\b\u0010;\u001a\u00020\u0019H&R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006<"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "", "actionError", "Landroidx/compose/runtime/State;", "Lcom/revenuecat/purchases/PurchasesError;", "getActionError", "()Landroidx/compose/runtime/State;", "actionInProgress", "", "getActionInProgress", "preloadedExitOffering", "Lcom/revenuecat/purchases/Offering;", "getPreloadedExitOffering", "purchaseCompleted", "getPurchaseCompleted", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "getResourceProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearActionError", "", "closePaywall", "result", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "getWebCheckoutUrl", "", "launchWebCheckout", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "handlePackagePurchase", "activity", "Landroid/app/Activity;", "pkg", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRestorePurchases", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateCustomerInfoCache", "preloadExitOffering", "purchaseSelectedPackage", "refreshStateIfColorsChanged", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDark", "refreshStateIfLocaleChanged", "restorePurchases", "selectPackage", "packageToSelect", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "trackExitOffer", "exitOfferType", "Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "exitOfferingIdentifier", "trackPaywallImpressionIfNeeded", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaywallViewModel {

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void closePaywall$default(PaywallViewModel paywallViewModel, PaywallResult paywallResult, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closePaywall");
            }
            if ((i & 1) != 0) {
                paywallResult = null;
            }
            paywallViewModel.closePaywall(paywallResult);
        }

        public static /* synthetic */ Object handlePackagePurchase$default(PaywallViewModel paywallViewModel, Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handlePackagePurchase");
            }
            if ((i & 4) != 0) {
                resolvedOffer = null;
            }
            return paywallViewModel.handlePackagePurchase(activity, r2, resolvedOffer, continuation);
        }
    }

    void clearActionError();

    void closePaywall(PaywallResult result);

    State<PurchasesError> getActionError();

    State<Boolean> getActionInProgress();

    State<Offering> getPreloadedExitOffering();

    State<Boolean> getPurchaseCompleted();

    ResourceProvider getResourceProvider();

    StateFlow<PaywallState> getState();

    String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout);

    Object handlePackagePurchase(Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation);

    Object handleRestorePurchases(Continuation<? super Unit> continuation);

    void invalidateCustomerInfoCache();

    void preloadExitOffering();

    void purchaseSelectedPackage(Activity activity);

    void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean isDark);

    void refreshStateIfLocaleChanged();

    void restorePurchases();

    void selectPackage(TemplateConfiguration.PackageInfo packageToSelect);

    void trackExitOffer(ExitOfferType exitOfferType, String exitOfferingIdentifier);

    void trackPaywallImpressionIfNeeded();
}
