package com.revenuecat.purchases.ui.revenuecatui.data.testdata;

import android.app.Activity;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: TestData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0002\u0085\u0001B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u000e\u0010_\u001a\u00020`H\u0082@¢\u0006\u0002\u0010aJ\b\u0010b\u001a\u00020`H\u0016J\u0012\u0010c\u001a\u00020`2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0012\u0010f\u001a\u0004\u0018\u00010;2\u0006\u0010g\u001a\u00020$H\u0016J*\u0010h\u001a\u00020`2\u0006\u0010i\u001a\u00020+2\b\u0010j\u001a\u0004\u0018\u00010,2\b\u0010k\u001a\u0004\u0018\u00010lH\u0096@¢\u0006\u0002\u0010mJ\u000e\u0010n\u001a\u00020`H\u0096@¢\u0006\u0002\u0010aJ\b\u0010o\u001a\u00020`H\u0016J\b\u0010p\u001a\u0004\u0018\u00010qJ\b\u0010r\u001a\u00020`H\u0016J\u0012\u0010s\u001a\u00020`2\b\u0010i\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010t\u001a\u00020`2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\nH\u0016J\b\u0010x\u001a\u00020`H\u0016J\b\u0010y\u001a\u00020`H\u0016J\u0010\u0010z\u001a\u00020`2\u0006\u0010{\u001a\u00020LH\u0016J\b\u0010|\u001a\u00020`H\u0002J\u0018\u0010}\u001a\u00020`2\u0006\u0010~\u001a\u00020U2\u0006\u0010\u007f\u001a\u00020;H\u0016J\t\u0010\u0080\u0001\u001a\u00020`H\u0016J\u0014\u0010\u0081\u0001\u001a\u00020`2\t\b\u0002\u0010\u0082\u0001\u001a\u00020;H\u0002J\u0010\u0010\u0083\u0001\u001a\u00020`2\u0007\u0010\u0084\u0001\u001a\u00020\\R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR*\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020$0#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eRF\u0010-\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,0*0#2\u001a\u0010\u001a\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,0*0#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u001e\u0010/\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u001e\u00101\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u001e\u00103\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0017R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\n0\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0017R\u001e\u00109\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR.\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0#2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R.\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0#2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010'R\u001e\u0010@\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001eR\u001e\u0010B\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u001eR\u0014\u0010D\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001e\u0010H\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u001eR\u001e\u0010J\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u001eR*\u0010M\u001a\b\u0012\u0004\u0012\u00020L0#2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020L0#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bN\u0010'R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130P8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001e\u0010S\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u001eRB\u0010V\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020;0*0#2\u0018\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020;0*0#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bW\u0010'R\u001e\u0010X\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u001eR\u001e\u0010Z\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u001eR*\u0010]\u001a\b\u0012\u0004\u0012\u00020\\0#2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\\0#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b^\u0010'¨\u0006\u0086\u0001"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/MockViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "offering", "Lcom/revenuecat/purchases/Offering;", "validationWarning", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "allowsPurchases", "", "shouldErrorOnUnsupportedMethods", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;ZZ)V", "_actionError", "Landroidx/compose/runtime/MutableState;", "Lcom/revenuecat/purchases/PurchasesError;", "_actionInProgress", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "actionError", "Landroidx/compose/runtime/State;", "getActionError", "()Landroidx/compose/runtime/State;", "actionInProgress", "getActionInProgress", "<set-?>", "", "clearActionErrorCallCount", "getClearActionErrorCallCount", "()I", "closePaywallCallCount", "getClosePaywallCallCount", "getWebCheckoutUrlCallCount", "getGetWebCheckoutUrlCallCount", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "getWebCheckoutUrlParams", "getGetWebCheckoutUrlParams", "()Ljava/util/List;", "handlePackagePurchaseCount", "getHandlePackagePurchaseCount", "Lkotlin/Pair;", "Landroid/app/Activity;", "Lcom/revenuecat/purchases/Package;", "handlePackagePurchaseParams", "getHandlePackagePurchaseParams", "handleRestorePurchasesCallCount", "getHandleRestorePurchasesCallCount", "invalidateCustomerInfoCacheCallCount", "getInvalidateCustomerInfoCacheCallCount", "preloadExitOfferingCallCount", "getPreloadExitOfferingCallCount", "preloadedExitOffering", "getPreloadedExitOffering", "purchaseCompleted", "getPurchaseCompleted", "purchaseSelectedPackageCallCount", "getPurchaseSelectedPackageCallCount", "", "purchaseSelectedPackageIdentifiers", "getPurchaseSelectedPackageIdentifiers", "purchaseSelectedPackageParams", "getPurchaseSelectedPackageParams", "refreshStateIfColorsChangedCallCount", "getRefreshStateIfColorsChangedCallCount", "refreshStateIfLocaleChangedCallCount", "getRefreshStateIfLocaleChangedCallCount", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "getResourceProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "restorePurchasesCallCount", "getRestorePurchasesCallCount", "selectPackageCallCount", "getSelectPackageCallCount", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "selectPackageCallParams", "getSelectPackageCallParams", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "trackExitOfferCallCount", "getTrackExitOfferCallCount", "Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "trackExitOfferParams", "getTrackExitOfferParams", "trackPaywallImpressionIfNeededCallCount", "getTrackPaywallImpressionIfNeededCallCount", "updateOptionsCallCount", "getUpdateOptionsCallCount", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "updateOptionsParams", "getUpdateOptionsParams", "awaitSimulateActionInProgress", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearActionError", "closePaywall", "result", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "getWebCheckoutUrl", "launchWebCheckout", "handlePackagePurchase", "activity", "pkg", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRestorePurchases", "invalidateCustomerInfoCache", "loadedLegacyState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "preloadExitOffering", "purchaseSelectedPackage", "refreshStateIfColorsChanged", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDarkMode", "refreshStateIfLocaleChanged", "restorePurchases", "selectPackage", "packageToSelect", "simulateActionInProgress", "trackExitOffer", "exitOfferType", "exitOfferingIdentifier", "trackPaywallImpressionIfNeeded", "unsupportedMethod", "errorMessage", "updateOptions", "options", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MockViewModel extends ViewModel implements PaywallViewModel {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private static final long MILLIS_2025_01_25 = 1737763200000L;

    @Deprecated
    public static final long fakePurchaseDelayMillis = 2000;
    private final MutableState<PurchasesError> _actionError;
    private final MutableState<Boolean> _actionInProgress;
    private final MutableStateFlow<PaywallState> _state;
    private final boolean allowsPurchases;
    private int clearActionErrorCallCount;
    private int closePaywallCallCount;
    private int getWebCheckoutUrlCallCount;
    private List<PaywallAction.External.LaunchWebCheckout> getWebCheckoutUrlParams;
    private int handlePackagePurchaseCount;
    private List<Pair<Activity, Package>> handlePackagePurchaseParams;
    private int handleRestorePurchasesCallCount;
    private int invalidateCustomerInfoCacheCallCount;
    private int preloadExitOfferingCallCount;
    private final State<Offering> preloadedExitOffering;
    private final State<Boolean> purchaseCompleted;
    private int purchaseSelectedPackageCallCount;
    private List<String> purchaseSelectedPackageIdentifiers;
    private List<Activity> purchaseSelectedPackageParams;
    private int refreshStateIfColorsChangedCallCount;
    private int refreshStateIfLocaleChangedCallCount;
    private int restorePurchasesCallCount;
    private int selectPackageCallCount;
    private List<TemplateConfiguration.PackageInfo> selectPackageCallParams;
    private final boolean shouldErrorOnUnsupportedMethods;
    private int trackExitOfferCallCount;
    private List<Pair<ExitOfferType, String>> trackExitOfferParams;
    private int trackPaywallImpressionIfNeededCallCount;
    private int updateOptionsCallCount;
    private List<PaywallOptions> updateOptionsParams;

    /* JADX INFO: compiled from: TestData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/MockViewModel$Companion;", "", "()V", "MILLIS_2025_01_25", "", "fakePurchaseDelayMillis", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$awaitSimulateActionInProgress$1, reason: invalid class name */
    /* JADX INFO: compiled from: TestData.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel", f = "TestData.kt", i = {0}, l = {699}, m = "awaitSimulateActionInProgress", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MockViewModel.this.awaitSimulateActionInProgress(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$simulateActionInProgress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TestData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$simulateActionInProgress$1", f = "TestData.kt", i = {}, l = {693}, m = "invokeSuspend", n = {}, s = {})
    static final class C09751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09751(Continuation<? super C09751> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MockViewModel.this.new C09751(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MockViewModel.this.awaitSimulateActionInProgress(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public MockViewModel(PaywallMode mode, Offering offering, PaywallWarning paywallWarning, boolean z, boolean z2) {
        PaywallState.Loaded.Components componentsPaywallState$default;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(offering, "offering");
        this.allowsPurchases = z;
        this.shouldErrorOnUnsupportedMethods = z2;
        this.purchaseCompleted = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.preloadedExitOffering = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        PaywallValidationResult paywallValidationResultValidatedPaywall = OfferingToStateMapperKt.validatedPaywall(offering, TestData.Constants.INSTANCE.getCurrentColorScheme(), getResourceProvider());
        if (paywallValidationResultValidatedPaywall instanceof PaywallValidationResult.Legacy) {
            PaywallValidationResult.Legacy legacy = (PaywallValidationResult.Legacy) paywallValidationResultValidatedPaywall;
            componentsPaywallState$default = OfferingToStateMapperKt.toLegacyPaywallState(offering, new VariableDataProvider(getResourceProvider(), false, 2, null), mode, legacy.getDisplayablePaywall(), legacy.getTemplate(), false, "US", paywallWarning);
        } else {
            if (!(paywallValidationResultValidatedPaywall instanceof PaywallValidationResult.Components)) {
                throw new NoWhenBranchMatchedException();
            }
            componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, (PaywallValidationResult.Components) paywallValidationResultValidatedPaywall, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$_state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
        }
        this._state = StateFlowKt.MutableStateFlow(componentsPaywallState$default);
        this._actionInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this._actionError = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.trackExitOfferParams = new ArrayList();
        this.selectPackageCallParams = new ArrayList();
        this.getWebCheckoutUrlParams = new ArrayList();
        this.purchaseSelectedPackageParams = new ArrayList();
        this.purchaseSelectedPackageIdentifiers = new ArrayList();
        this.handlePackagePurchaseParams = new ArrayList();
        this.updateOptionsParams = new ArrayList();
    }

    public /* synthetic */ MockViewModel(PaywallMode paywallMode, Offering offering, PaywallWarning paywallWarning, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PaywallMode.INSTANCE.getDefault() : paywallMode, offering, (i & 4) != 0 ? null : paywallWarning, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitSimulateActionInProgress(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this._actionInProgress.setValue(Boxing.boxBoolean(true));
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            if (DelayKt.delay(2000L, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (MockViewModel) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this._actionInProgress.setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }

    private final void simulateActionInProgress() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09751(null), 3, null);
    }

    private final void unsupportedMethod(String errorMessage) {
        if (this.shouldErrorOnUnsupportedMethods) {
            throw new IllegalStateException(errorMessage.toString());
        }
    }

    static /* synthetic */ void unsupportedMethod$default(MockViewModel mockViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Not supported";
        }
        mockViewModel.unsupportedMethod(str);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void clearActionError() {
        this.clearActionErrorCallCount++;
        this._actionError.setValue(null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void closePaywall(PaywallResult result) {
        this.closePaywallCallCount++;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<PurchasesError> getActionError() {
        return this._actionError;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getActionInProgress() {
        return this._actionInProgress;
    }

    public final int getClearActionErrorCallCount() {
        return this.clearActionErrorCallCount;
    }

    public final int getClosePaywallCallCount() {
        return this.closePaywallCallCount;
    }

    public final int getGetWebCheckoutUrlCallCount() {
        return this.getWebCheckoutUrlCallCount;
    }

    public final List<PaywallAction.External.LaunchWebCheckout> getGetWebCheckoutUrlParams() {
        return this.getWebCheckoutUrlParams;
    }

    public final int getHandlePackagePurchaseCount() {
        return this.handlePackagePurchaseCount;
    }

    public final List<Pair<Activity, Package>> getHandlePackagePurchaseParams() {
        return this.handlePackagePurchaseParams;
    }

    public final int getHandleRestorePurchasesCallCount() {
        return this.handleRestorePurchasesCallCount;
    }

    public final int getInvalidateCustomerInfoCacheCallCount() {
        return this.invalidateCustomerInfoCacheCallCount;
    }

    public final int getPreloadExitOfferingCallCount() {
        return this.preloadExitOfferingCallCount;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Offering> getPreloadedExitOffering() {
        return this.preloadedExitOffering;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getPurchaseCompleted() {
        return this.purchaseCompleted;
    }

    public final int getPurchaseSelectedPackageCallCount() {
        return this.purchaseSelectedPackageCallCount;
    }

    public final List<String> getPurchaseSelectedPackageIdentifiers() {
        return this.purchaseSelectedPackageIdentifiers;
    }

    public final List<Activity> getPurchaseSelectedPackageParams() {
        return this.purchaseSelectedPackageParams;
    }

    public final int getRefreshStateIfColorsChangedCallCount() {
        return this.refreshStateIfColorsChangedCallCount;
    }

    public final int getRefreshStateIfLocaleChangedCallCount() {
        return this.refreshStateIfLocaleChangedCallCount;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public ResourceProvider getResourceProvider() {
        return new MockResourceProvider(null, null, null, null, null, 31, null);
    }

    public final int getRestorePurchasesCallCount() {
        return this.restorePurchasesCallCount;
    }

    public final int getSelectPackageCallCount() {
        return this.selectPackageCallCount;
    }

    public final List<TemplateConfiguration.PackageInfo> getSelectPackageCallParams() {
        return this.selectPackageCallParams;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public StateFlow<PaywallState> getState() {
        return FlowKt.asStateFlow(this._state);
    }

    public final int getTrackExitOfferCallCount() {
        return this.trackExitOfferCallCount;
    }

    public final List<Pair<ExitOfferType, String>> getTrackExitOfferParams() {
        return this.trackExitOfferParams;
    }

    public final int getTrackPaywallImpressionIfNeededCallCount() {
        return this.trackPaywallImpressionIfNeededCallCount;
    }

    public final int getUpdateOptionsCallCount() {
        return this.updateOptionsCallCount;
    }

    public final List<PaywallOptions> getUpdateOptionsParams() {
        return this.updateOptionsParams;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout) {
        Intrinsics.checkNotNullParameter(launchWebCheckout, "launchWebCheckout");
        this.getWebCheckoutUrlCallCount++;
        this.getWebCheckoutUrlParams.add(launchWebCheckout);
        return null;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public Object handlePackagePurchase(Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation) {
        this.handlePackagePurchaseCount++;
        this.handlePackagePurchaseParams.add(TuplesKt.to(activity, r2));
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't purchase mock view model");
        }
        return Unit.INSTANCE;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public Object handleRestorePurchases(Continuation<? super Unit> continuation) {
        this.handleRestorePurchasesCallCount++;
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't restore purchases");
        }
        return Unit.INSTANCE;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void invalidateCustomerInfoCache() {
        this.invalidateCustomerInfoCacheCallCount++;
    }

    public final PaywallState.Loaded.Legacy loadedLegacyState() {
        return PaywallStateKt.loadedLegacy(getState().getValue());
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void preloadExitOffering() {
        this.preloadExitOfferingCallCount++;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void purchaseSelectedPackage(Activity activity) {
        MutableState<TemplateConfiguration.PackageInfo> selectedPackage;
        TemplateConfiguration.PackageInfo value;
        Package rcPackage;
        this.purchaseSelectedPackageCallCount++;
        this.purchaseSelectedPackageParams.add(activity);
        List<String> list = this.purchaseSelectedPackageIdentifiers;
        PaywallState.Loaded.Legacy legacyLoadedLegacyState = loadedLegacyState();
        list.add((legacyLoadedLegacyState == null || (selectedPackage = legacyLoadedLegacyState.getSelectedPackage()) == null || (value = selectedPackage.getValue()) == null || (rcPackage = value.getRcPackage()) == null) ? null : rcPackage.getIdentifier());
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't purchase mock view model");
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean isDarkMode) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.refreshStateIfColorsChangedCallCount++;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfLocaleChanged() {
        this.refreshStateIfLocaleChangedCallCount++;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void restorePurchases() {
        this.restorePurchasesCallCount++;
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't restore purchases");
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void selectPackage(TemplateConfiguration.PackageInfo packageToSelect) {
        Unit unit;
        Intrinsics.checkNotNullParameter(packageToSelect, "packageToSelect");
        this.selectPackageCallCount++;
        this.selectPackageCallParams.add(packageToSelect);
        PaywallState.Loaded.Legacy legacyLoadedLegacyState = loadedLegacyState();
        if (legacyLoadedLegacyState != null) {
            legacyLoadedLegacyState.selectPackage(packageToSelect);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            unsupportedMethod$default(this, null, 1, null);
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackExitOffer(ExitOfferType exitOfferType, String exitOfferingIdentifier) {
        Intrinsics.checkNotNullParameter(exitOfferType, "exitOfferType");
        Intrinsics.checkNotNullParameter(exitOfferingIdentifier, "exitOfferingIdentifier");
        this.trackExitOfferCallCount++;
        this.trackExitOfferParams.add(new Pair<>(exitOfferType, exitOfferingIdentifier));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackPaywallImpressionIfNeeded() {
        this.trackPaywallImpressionIfNeededCallCount++;
    }

    public final void updateOptions(PaywallOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.updateOptionsCallCount++;
        this.updateOptionsParams.add(options);
    }
}
