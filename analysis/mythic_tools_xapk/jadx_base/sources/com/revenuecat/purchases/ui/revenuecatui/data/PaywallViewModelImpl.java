package com.revenuecat.purchases.ui.revenuecatui.data;

import android.app.Activity;
import android.os.LocaleList;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.LocaleListCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.ExitOffer;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventType;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogicParams;
import com.revenuecat.purchases.ui.revenuecatui.ProductChange;
import com.revenuecat.purchases.ui.revenuecatui.PurchaseLogicResult;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import com.revenuecat.purchases.ui.revenuecatui.strings.PaywallValidationErrorStrings;
import com.revenuecat.purchases.ui.revenuecatui.utils.Resumable;
import com.revenuecat.purchases.ui.revenuecatui.utils.URIExtensionsKt;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: PaywallViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J*\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010I\u001a\u00020JH\u0016J\u0012\u0010K\u001a\u00020J2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\n\u0010N\u001a\u0004\u0018\u000100H\u0002J\u001c\u0010O\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020Q0P2\u0006\u0010F\u001a\u00020\u001dH\u0002J\b\u0010R\u001a\u00020JH\u0002J\b\u0010S\u001a\u00020\u001bH\u0002J\u0012\u0010T\u001a\u0004\u0018\u00010H2\u0006\u0010U\u001a\u00020VH\u0016J*\u0010W\u001a\u00020J2\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0096@¢\u0006\u0002\u0010^J\u000e\u0010_\u001a\u00020JH\u0096@¢\u0006\u0002\u0010`J\b\u0010a\u001a\u00020JH\u0016J4\u0010b\u001a\u00020J2\u0006\u0010X\u001a\u00020Y2\u0006\u0010c\u001a\u00020[2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010gH\u0082@¢\u0006\u0002\u0010hJ*\u0010i\u001a\u00020J2\u0006\u0010X\u001a\u00020Y2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010d\u001a\u0004\u0018\u00010eH\u0082@¢\u0006\u0002\u0010lJ\b\u0010m\u001a\u00020JH\u0016J\u0012\u0010n\u001a\u00020J2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u0018\u0010o\u001a\u00020J2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010p\u001a\u00020\fH\u0016J\b\u0010q\u001a\u00020JH\u0016J\b\u0010r\u001a\u00020JH\u0016J\u0010\u0010s\u001a\u00020J2\u0006\u0010t\u001a\u00020uH\u0016J\u0010\u0010v\u001a\u00020J2\u0006\u0010w\u001a\u00020xH\u0002J\u0018\u0010y\u001a\u00020J2\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020HH\u0016J\b\u0010}\u001a\u00020JH\u0002J\b\u0010~\u001a\u00020JH\u0002J\b\u0010\u007f\u001a\u00020JH\u0016J\u001b\u0010\u0080\u0001\u001a\u00020J2\u0007\u0010\u0081\u0001\u001a\u00020[2\u0007\u0010\u0082\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020J2\u0007\u0010\u0081\u0001\u001a\u00020[H\u0002J\u000f\u0010\u0084\u0001\u001a\u00020J2\u0006\u0010\u0007\u001a\u00020\bJ\t\u0010\u0085\u0001\u001a\u00020JH\u0002J\t\u0010\u0086\u0001\u001a\u00020JH\u0002J\t\u0010\u0087\u0001\u001a\u00020\fH\u0002J\u000f\u0010N\u001a\u0004\u0018\u000100*\u00030\u0088\u0001H\u0002J\u000f\u0010N\u001a\u0004\u0018\u000100*\u00030\u0089\u0001H\u0002J\u000e\u0010\u008a\u0001\u001a\u00030\u008b\u0001*\u00020\u001bH\u0002R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010$R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\f0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010$R\u0016\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020 0<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010A\u001a\u00020B*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006\u008c\u0001"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "resourceProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "options", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "isDarkMode", "", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "preview", "productChangeCalculator", "Lcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeCalculator;", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;Landroidx/compose/material3/ColorScheme;ZLkotlin/jvm/functions/Function1;ZLcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeCalculator;)V", "_actionError", "Landroidx/compose/runtime/MutableState;", "Lcom/revenuecat/purchases/PurchasesError;", "_actionInProgress", "_colorScheme", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_lastLocaleList", "Landroidx/core/os/LocaleListCompat;", "_preloadedExitOffering", "Lcom/revenuecat/purchases/Offering;", "_purchaseCompleted", "_state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "actionError", "Landroidx/compose/runtime/State;", "getActionError", "()Landroidx/compose/runtime/State;", "actionInProgress", "getActionInProgress", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "getListener", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallListener;", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "getMode", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "paywallPresentationData", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "preloadedExitOffering", "getPreloadedExitOffering", "purchaseCompleted", "getPurchaseCompleted", "purchaseLogic", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getPurchaseLogic", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "getResourceProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", ServerProtocol.DIALOG_PARAM_STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext", "(Lcom/revenuecat/purchases/Offering;)Lcom/revenuecat/purchases/PresentedOfferingContext;", "calculateState", "offering", "storefrontCountryCode", "", "clearActionError", "", "closePaywall", "result", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "createEventData", "extractDefaultCustomVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "finishAction", "getCurrentLocaleList", "getWebCheckoutUrl", "launchWebCheckout", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "handlePackagePurchase", "activity", "Landroid/app/Activity;", "pkg", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRestorePurchases", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateCustomerInfoCache", "performPurchase", "packageToPurchase", "productChangeConfig", "Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lcom/revenuecat/purchases/models/SubscriptionOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performPurchaseIfNecessary", "packageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadExitOffering", "purchaseSelectedPackage", "refreshStateIfColorsChanged", "isDark", "refreshStateIfLocaleChanged", "restorePurchases", "selectPackage", "packageToSelect", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "track", "eventType", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;", "trackExitOffer", "exitOfferType", "Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "exitOfferingIdentifier", "trackPaywallCancel", "trackPaywallClose", "trackPaywallImpressionIfNeeded", "trackPaywallPurchaseError", "rcPackage", "error", "trackPaywallPurchaseInitiated", "updateOptions", "updateState", "validateState", "verifyNoActionInProgressOrStartAction", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "toFrameworkLocaleList", "Landroid/os/LocaleList;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallViewModelImpl extends ViewModel implements PaywallViewModel {
    public static final int $stable = 0;
    private final MutableState<PurchasesError> _actionError;
    private final MutableState<Boolean> _actionInProgress;
    private final MutableStateFlow<ColorScheme> _colorScheme;
    private final MutableStateFlow<LocaleListCompat> _lastLocaleList;
    private final MutableState<Offering> _preloadedExitOffering;
    private final MutableState<Boolean> _purchaseCompleted;
    private final MutableStateFlow<PaywallState> _state;
    private boolean isDarkMode;
    private PaywallOptions options;
    private PaywallEvent.Data paywallPresentationData;
    private final ProductChangeCalculator productChangeCalculator;
    private final PurchasesType purchases;
    private final ResourceProvider resourceProvider;
    private final Function1<CustomerInfo, Boolean> shouldDisplayBlock;
    private final VariableDataProvider variableDataProvider;

    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handlePackagePurchase$1, reason: invalid class name */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", f = "PaywallViewModel.kt", i = {0, 1}, l = {TypedValues.CycleType.TYPE_WAVE_PHASE, Videoio.CAP_PROP_XI_AEAG_ROI_WIDTH}, m = "handlePackagePurchase", n = {"this", "this"}, s = {"L$0", "L$0"})
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
            return PaywallViewModelImpl.this.handlePackagePurchase(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handleRestorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", f = "PaywallViewModel.kt", i = {0, 1, 1, 2, 3, 4}, l = {849, 358, 359, 361, 392}, m = "handleRestorePurchases", n = {"this", "this", "customRestoreHandler", "this", "this", "this"}, s = {"L$0", "L$0", "L$1", "L$0", "L$0", "L$0"})
    static final class C09651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09651(Continuation<? super C09651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.handleRestorePurchases(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$performPurchase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", f = "PaywallViewModel.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4}, l = {Videoio.CAP_PROP_XI_GAMMAY, Videoio.CAP_PROP_XI_CC_MATRIX_30, 510, 513, 557}, m = "performPurchase", n = {"this", "activity", "packageToPurchase", "productChangeConfig", "subscriptionOption", "this", "activity", "packageToPurchase", "subscriptionOption", "this", "packageToPurchase", "this", "packageToPurchase", "this", "packageToPurchase"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    static final class C09661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C09661(Continuation<? super C09661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.performPurchase(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$preloadExitOffering$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$preloadExitOffering$1", f = "PaywallViewModel.kt", i = {0}, l = {230}, m = "invokeSuspend", n = {"exitOfferingId"}, s = {"L$0"})
    static final class C09671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C09671(Continuation<? super C09671> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C09671(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Offering offering;
            MutableState mutableState;
            String str;
            MutableState mutableState2;
            Offering.PaywallComponents paywallComponents;
            PaywallComponentsData data;
            ExitOffers exitOffers;
            ExitOffer dismiss;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (PurchasesException e) {
                Logger.INSTANCE.e("Failed to preload exit offering", e);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PaywallState paywallState = (PaywallState) PaywallViewModelImpl.this._state.getValue();
                offering = null;
                Offering offering2 = paywallState instanceof PaywallState.Loaded.Legacy ? ((PaywallState.Loaded.Legacy) paywallState).getOffering() : paywallState instanceof PaywallState.Loaded.Components ? ((PaywallState.Loaded.Components) paywallState).getOffering() : null;
                String offeringId = (offering2 == null || (paywallComponents = offering2.getPaywallComponents()) == null || (data = paywallComponents.getData()) == null || (exitOffers = data.getExitOffers()) == null || (dismiss = exitOffers.getDismiss()) == null) ? null : dismiss.getOfferingId();
                mutableState = PaywallViewModelImpl.this._preloadedExitOffering;
                if (offeringId != null) {
                    this.L$0 = offeringId;
                    this.L$1 = mutableState;
                    this.label = 1;
                    Object objAwaitOfferings = PaywallViewModelImpl.this.purchases.awaitOfferings(this);
                    if (objAwaitOfferings == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str2 = offeringId;
                    obj = objAwaitOfferings;
                    str = str2;
                    mutableState2 = mutableState;
                }
                mutableState.setValue(offering);
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState2 = (MutableState) this.L$1;
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            offering = ((Offerings) obj).get(str);
            if (offering == null) {
                Logger.INSTANCE.e("Exit offering with ID '" + str + "' not found in available offerings. Exit offer will not be displayed.");
            }
            mutableState = mutableState2;
            mutableState.setValue(offering);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$purchaseSelectedPackage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$purchaseSelectedPackage$1", f = "PaywallViewModel.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
    static final class C09681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09681(Activity activity, Continuation<? super C09681> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C09681(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PaywallViewModel.DefaultImpls.handlePackagePurchase$default(PaywallViewModelImpl.this, this.$activity, null, null, this, 4, null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$restorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$restorePurchases$1", f = "PaywallViewModel.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
    static final class C09691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09691(Continuation<? super C09691> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C09691(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PaywallViewModelImpl.this.handleRestorePurchases(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$updateState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PaywallViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$updateState$1", f = "PaywallViewModel.kt", i = {0}, l = {Videoio.CAP_PROP_XI_REGION_MODE, TypedValues.MotionType.TYPE_EASING}, m = "invokeSuspend", n = {"offeringSelection"}, s = {"L$0"})
    static final class C09701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C09701(Continuation<? super C09701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C09701(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
        
            if (r6 == r0) goto L40;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006d A[Catch: PurchasesException -> 0x0013, TryCatch #0 {PurchasesException -> 0x0013, blocks: (B:6:0x000e, B:41:0x0098, B:44:0x00a2, B:45:0x00b1, B:13:0x0022, B:25:0x0058, B:27:0x006d, B:31:0x0077, B:16:0x0029, B:18:0x0037, B:19:0x003e, B:21:0x0042, B:36:0x0082, B:38:0x0086, B:46:0x00dd, B:47:0x00e2), top: B:51:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            OfferingSelection offeringSelection;
            Offering offeringType;
            PresentedOfferingContext presentedOfferingContext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    OfferingSelection offeringSelection2 = PaywallViewModelImpl.this.options.getOfferingSelection();
                    if (!(offeringSelection2 instanceof OfferingSelection.OfferingType)) {
                        if (offeringSelection2 instanceof OfferingSelection.IdAndPresentedOfferingContext) {
                            this.L$0 = offeringSelection2;
                            this.label = 1;
                            Object objAwaitOfferings = PaywallViewModelImpl.this.purchases.awaitOfferings(this);
                            if (objAwaitOfferings != coroutine_suspended) {
                                offeringSelection = offeringSelection2;
                                obj = objAwaitOfferings;
                                Offerings offerings = (Offerings) obj;
                                presentedOfferingContext = ((OfferingSelection.IdAndPresentedOfferingContext) offeringSelection).getPresentedOfferingContext();
                                Offering offering = offerings.get(((OfferingSelection.IdAndPresentedOfferingContext) offeringSelection).getOfferingId());
                                if (offering != null) {
                                }
                                if (presentedOfferingContext != null) {
                                }
                            }
                        } else {
                            if (!(offeringSelection2 instanceof OfferingSelection.None)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            this.label = 2;
                            obj = PaywallViewModelImpl.this.purchases.awaitOfferings(this);
                        }
                        return coroutine_suspended;
                    }
                    offeringType = ((OfferingSelection.OfferingType) offeringSelection2).getOfferingType();
                } else if (i == 1) {
                    offeringSelection = (OfferingSelection) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Offerings offerings2 = (Offerings) obj;
                    presentedOfferingContext = ((OfferingSelection.IdAndPresentedOfferingContext) offeringSelection).getPresentedOfferingContext();
                    Offering offering2 = offerings2.get(((OfferingSelection.IdAndPresentedOfferingContext) offeringSelection).getOfferingId());
                    offeringType = offering2 != null ? offerings2.getCurrent() : offering2;
                    if (presentedOfferingContext != null) {
                        Offering offeringCopy = offeringType != null ? offeringType.copy(presentedOfferingContext) : null;
                        if (offeringCopy != null) {
                            offeringType = offeringCopy;
                        }
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    offeringType = ((Offerings) obj).getCurrent();
                }
                PaywallViewModelImpl paywallViewModelImpl = PaywallViewModelImpl.this;
                if (offeringType == null) {
                    paywallViewModelImpl._state.setValue(new PaywallState.Error("The RevenueCat dashboard does not have a current offering configured."));
                } else {
                    MutableStateFlow mutableStateFlow = paywallViewModelImpl._state;
                    PaywallViewModelImpl paywallViewModelImpl2 = PaywallViewModelImpl.this;
                    mutableStateFlow.setValue(paywallViewModelImpl2.calculateState(offeringType, (ColorScheme) paywallViewModelImpl2._colorScheme.getValue(), PaywallViewModelImpl.this.purchases.getStorefrontCountryCode(), PaywallViewModelImpl.this.options.getMode()));
                }
            } catch (PurchasesException e) {
                PaywallViewModelImpl.this._state.setValue(new PaywallState.Error("Error " + e.getCode().getCode() + ": " + e.getCode().getDescription()));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallViewModelImpl(ResourceProvider resourceProvider, PurchasesType purchases, PaywallOptions options, ColorScheme colorScheme, boolean z, Function1<? super CustomerInfo, Boolean> function1, boolean z2, ProductChangeCalculator productChangeCalculator) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(productChangeCalculator, "productChangeCalculator");
        this.resourceProvider = resourceProvider;
        this.purchases = purchases;
        this.options = options;
        this.isDarkMode = z;
        this.shouldDisplayBlock = function1;
        this.productChangeCalculator = productChangeCalculator;
        this.variableDataProvider = new VariableDataProvider(getResourceProvider(), z2);
        this._state = StateFlowKt.MutableStateFlow(PaywallState.Loading.INSTANCE);
        this._actionInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this._actionError = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._purchaseCompleted = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this._preloadedExitOffering = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._lastLocaleList = StateFlowKt.MutableStateFlow(getCurrentLocaleList());
        this._colorScheme = StateFlowKt.MutableStateFlow(colorScheme);
        updateState();
        validateState();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ PaywallViewModelImpl(ResourceProvider resourceProvider, PurchasesImpl purchasesImpl, PaywallOptions paywallOptions, ColorScheme colorScheme, boolean z, Function1 function1, boolean z2, ProductChangeCalculator productChangeCalculator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        PurchasesType purchasesImpl2 = (i & 2) != 0 ? new PurchasesImpl(null, 1, 0 == true ? 1 : 0) : purchasesImpl;
        this(resourceProvider, purchasesImpl2, paywallOptions, colorScheme, z, function1, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? new ProductChangeCalculator(purchasesImpl2) : productChangeCalculator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallState calculateState(Offering offering, ColorScheme colorScheme, String storefrontCountryCode, PaywallMode mode) {
        if (offering.getAvailablePackages().isEmpty()) {
            return new PaywallState.Error("No packages available");
        }
        PaywallValidationResult.Legacy legacyValidatedPaywall = OfferingToStateMapperKt.validatedPaywall(offering, colorScheme, getResourceProvider());
        if ((legacyValidatedPaywall instanceof PaywallValidationResult.Components) && !PaywallModeKt.isFullScreen(mode)) {
            legacyValidatedPaywall = OfferingToStateMapperKt.fallbackPaywall(offering, colorScheme, getResourceProvider(), PaywallValidationError.InvalidModeForComponentsPaywall.INSTANCE);
        }
        NonEmptyList<PaywallValidationError> errors = legacyValidatedPaywall.getErrors();
        if (errors != null) {
            Iterator<PaywallValidationError> it = errors.iterator();
            while (it.hasNext()) {
                Logger.INSTANCE.e(it.next().associatedErrorString(offering));
            }
            Logger.INSTANCE.e(PaywallValidationErrorStrings.DISPLAYING_DEFAULT);
        }
        if (legacyValidatedPaywall instanceof PaywallValidationResult.Legacy) {
            PaywallValidationResult.Legacy legacy = (PaywallValidationResult.Legacy) legacyValidatedPaywall;
            return OfferingToStateMapperKt.toLegacyPaywallState(offering, this.variableDataProvider, mode, legacy.getDisplayablePaywall(), legacy.getTemplate(), this.options.getShouldDisplayDismissButton(), storefrontCountryCode, legacy.getWarning());
        }
        if (legacyValidatedPaywall instanceof PaywallValidationResult.Components) {
            return OfferingToStateMapperKt.toComponentsPaywallState(offering, (PaywallValidationResult.Components) legacyValidatedPaywall, storefrontCountryCode, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.calculateState.2
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date();
                }
            }, this.purchases, this.options.getCustomVariables(), extractDefaultCustomVariables(offering));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PaywallEvent.Data createEventData() {
        PaywallState value = getState().getValue();
        if (value instanceof PaywallState.Loaded.Legacy) {
            return createEventData((PaywallState.Loaded.Legacy) value);
        }
        if (value instanceof PaywallState.Loaded.Components) {
            return createEventData((PaywallState.Loaded.Components) value);
        }
        if (!(value instanceof PaywallState.Error ? true : value instanceof PaywallState.Loading)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.INSTANCE.e("Unexpected state trying to create event data: " + value);
        return null;
    }

    private final PaywallEvent.Data createEventData(PaywallState.Loaded.Components components) {
        Offering offering = components.getOffering();
        Offering.PaywallComponents paywallComponents = components.getOffering().getPaywallComponents();
        if (paywallComponents == null) {
            Logger.INSTANCE.e("Null paywall revision trying to create event data");
            return null;
        }
        String id = paywallComponents.getData().getId();
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext(offering);
        int revision = paywallComponents.getData().getRevision();
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        String lowerCase = getMode().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new PaywallEvent.Data(id, presentedOfferingContext, revision, uuidRandomUUID, lowerCase, components.getLocale().toString(), this.isDarkMode, null, null, null, null, null, null, 8064, null);
    }

    private final PaywallEvent.Data createEventData(PaywallState.Loaded.Legacy legacy) {
        PaywallComponentsData data;
        int revision;
        String str;
        PaywallComponentsData data2;
        String id;
        Offering offering = legacy.getOffering();
        PaywallData paywall = legacy.getOffering().getPaywall();
        String id2 = null;
        if (paywall != null) {
            revision = paywall.getRevision();
        } else {
            Offering.PaywallComponents paywallComponents = legacy.getOffering().getPaywallComponents();
            if (paywallComponents == null || (data = paywallComponents.getData()) == null) {
                Logger.INSTANCE.e("Null paywall revision trying to create event data");
                return null;
            }
            revision = data.getRevision();
        }
        int i = revision;
        PaywallData paywall2 = legacy.getOffering().getPaywall();
        if (paywall2 == null || (id = paywall2.getId()) == null) {
            Offering.PaywallComponents paywallComponents2 = legacy.getOffering().getPaywallComponents();
            if (paywallComponents2 != null && (data2 = paywallComponents2.getData()) != null) {
                id2 = data2.getId();
            }
            str = id2;
        } else {
            str = id;
        }
        Locale locale = this._lastLocaleList.getValue().get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext(offering);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        String lowerCase = getMode().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String string = locale.toString();
        Intrinsics.checkNotNullExpressionValue(string, "locale.toString()");
        return new PaywallEvent.Data(str, presentedOfferingContext, i, uuidRandomUUID, lowerCase, string, this.isDarkMode, null, null, null, null, null, null, 8064, null);
    }

    private final Map<String, CustomVariableValue> extractDefaultCustomVariables(Offering offering) {
        UiConfig uiConfig;
        Map customVariables;
        Offering.PaywallComponents paywallComponents = offering.getPaywallComponents();
        if (paywallComponents == null || (uiConfig = paywallComponents.getUiConfig()) == null || (customVariables = uiConfig.getCustomVariables()) == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(customVariables.size()));
        for (Map.Entry entry : customVariables.entrySet()) {
            linkedHashMap.put(entry.getKey(), CustomVariableValue.INSTANCE.from(((UiConfig.CustomVariableDefinition) entry.getValue()).getDefaultValue()));
        }
        return linkedHashMap;
    }

    private final void finishAction() {
        this._actionInProgress.setValue(false);
    }

    private final LocaleListCompat getCurrentLocaleList() {
        String preferredUILocaleOverride = this.purchases.getPreferredUILocaleOverride();
        if (preferredUILocaleOverride == null) {
            LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
            Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault()");
            return localeListCompat;
        }
        try {
            LocaleListCompat localeListCompatCreate = LocaleListCompat.create(LocaleHelpersKt.createLocaleFromString(preferredUILocaleOverride));
            Intrinsics.checkNotNullExpressionValue(localeListCompatCreate, "create(locale)");
            return localeListCompatCreate;
        } catch (IllegalArgumentException e) {
            Logger.INSTANCE.e("Invalid preferred locale format: " + preferredUILocaleOverride + ". Using system default.", e);
            LocaleListCompat localeListCompat2 = LocaleListCompat.getDefault();
            Intrinsics.checkNotNullExpressionValue(localeListCompat2, "{\n            Logger.e(\"…at.getDefault()\n        }");
            return localeListCompat2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallListener getListener() {
        return this.options.getListener();
    }

    private final PaywallMode getMode() {
        return this.options.getMode();
    }

    private final PresentedOfferingContext getPresentedOfferingContext(Offering offering) {
        PresentedOfferingContext presentedOfferingContext;
        Package r0 = (Package) CollectionsKt.firstOrNull((List) offering.getAvailablePackages());
        return (r0 == null || (presentedOfferingContext = r0.getPresentedOfferingContext()) == null) ? new PresentedOfferingContext(offering.getIdentifier()) : presentedOfferingContext;
    }

    private final PaywallPurchaseLogic getPurchaseLogic() {
        return this.options.getPurchaseLogic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0260, code lost:
    
        if (r2 == r6) goto L96;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ff A[Catch: PurchasesException -> 0x0074, TryCatch #1 {PurchasesException -> 0x0074, blocks: (B:16:0x0049, B:78:0x01ec, B:80:0x01ff, B:81:0x020a, B:21:0x0060, B:97:0x0263, B:24:0x006f, B:92:0x024d, B:94:0x0253, B:98:0x0280, B:100:0x0284, B:101:0x0288, B:103:0x028c, B:105:0x0294), top: B:125:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x021a A[Catch: PurchasesException -> 0x02a9, TRY_ENTER, TryCatch #2 {PurchasesException -> 0x02a9, blocks: (B:56:0x0140, B:58:0x0145, B:62:0x015a, B:63:0x0174, B:65:0x017a, B:66:0x017d, B:68:0x0183, B:70:0x018c, B:73:0x01a1, B:74:0x01d4, B:71:0x019a, B:83:0x021a, B:86:0x0222, B:88:0x0233, B:107:0x029d, B:108:0x02a8, B:50:0x0123, B:52:0x0128), top: B:126:0x0123 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0253 A[Catch: PurchasesException -> 0x0074, TryCatch #1 {PurchasesException -> 0x0074, blocks: (B:16:0x0049, B:78:0x01ec, B:80:0x01ff, B:81:0x020a, B:21:0x0060, B:97:0x0263, B:24:0x006f, B:92:0x024d, B:94:0x0253, B:98:0x0280, B:100:0x0284, B:101:0x0288, B:103:0x028c, B:105:0x0294), top: B:125:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0280 A[Catch: PurchasesException -> 0x0074, TryCatch #1 {PurchasesException -> 0x0074, blocks: (B:16:0x0049, B:78:0x01ec, B:80:0x01ff, B:81:0x020a, B:21:0x0060, B:97:0x0263, B:24:0x006f, B:92:0x024d, B:94:0x0253, B:98:0x0280, B:100:0x0284, B:101:0x0288, B:103:0x028c, B:105:0x0294), top: B:125:0x0033 }] */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performPurchase(Activity activity, Package r19, ProductChangeConfig productChangeConfig, SubscriptionOption subscriptionOption, Continuation<? super Unit> continuation) throws Throwable {
        C09661 c09661;
        ?? r10;
        ?? r3;
        ProductChangeConfig productChangeConfig2;
        int i;
        Unit unit;
        PaywallViewModelImpl paywallViewModelImpl;
        SubscriptionOption subscriptionOption2;
        Activity activity2;
        ProductChangeInfo productChangeInfo;
        Activity activity3;
        PaywallViewModelImpl paywallViewModelImpl2;
        int i2;
        PaywallViewModelImpl paywallViewModelImpl3;
        PaywallViewModelImpl paywallViewModelImpl4;
        PaywallViewModelImpl paywallViewModelImpl5;
        PurchaseLogicResult purchaseLogicResult;
        PaywallViewModelImpl paywallViewModelImpl6;
        PaywallListener listener;
        Package r1 = r19;
        ?? r32 = "Performing product change from ";
        if (continuation instanceof C09661) {
            c09661 = (C09661) continuation;
            if ((c09661.label & Integer.MIN_VALUE) != 0) {
                c09661.label -= Integer.MIN_VALUE;
            } else {
                c09661 = new C09661(continuation);
            }
        }
        Object objCalculateProductChangeInfo = c09661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c09661.label;
        try {
        } catch (PurchasesException e) {
            e = e;
        }
        if (i3 == 0) {
            ResultKt.throwOnFailure(objCalculateProductChangeInfo);
            c09661.L$0 = this;
            c09661.L$1 = activity;
            c09661.L$2 = r1;
            productChangeConfig2 = productChangeConfig;
            c09661.L$3 = productChangeConfig2;
            c09661.L$4 = subscriptionOption;
            c09661.label = 1;
            C09661 c096612 = c09661;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(c096612));
            final SafeContinuation safeContinuation2 = safeContinuation;
            i = 1;
            PaywallListener listener2 = getListener();
            if (listener2 != null) {
                listener2.onPurchasePackageInitiated(r1, new Resumable() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$performPurchase$shouldResume$1$1
                    @Override // com.revenuecat.purchases.ui.revenuecatui.utils.Resumable
                    public void invoke(boolean z) {
                        Resumable.DefaultImpls.invoke(this, z);
                    }

                    @Override // com.revenuecat.purchases.ui.revenuecatui.utils.Resumable
                    public final void resume(boolean z) {
                        Boolean boolValueOf = Boolean.valueOf(z);
                        Continuation<Boolean> continuation2 = safeContinuation2;
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m11445constructorimpl(boolValueOf));
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Result.Companion companion = Result.INSTANCE;
                safeContinuation2.resumeWith(Result.m11445constructorimpl(Boxing.boxBoolean(true)));
            }
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c096612);
            }
            if (orThrow != coroutine_suspended) {
                paywallViewModelImpl = this;
                subscriptionOption2 = subscriptionOption;
                activity2 = activity;
                objCalculateProductChangeInfo = orThrow;
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            subscriptionOption2 = (SubscriptionOption) c09661.L$4;
            ProductChangeConfig productChangeConfig3 = (ProductChangeConfig) c09661.L$3;
            Package r7 = (Package) c09661.L$2;
            activity2 = (Activity) c09661.L$1;
            PaywallViewModelImpl paywallViewModelImpl7 = (PaywallViewModelImpl) c09661.L$0;
            ResultKt.throwOnFailure(objCalculateProductChangeInfo);
            productChangeConfig2 = productChangeConfig3;
            r1 = r7;
            i = 1;
            paywallViewModelImpl = paywallViewModelImpl7;
        } else {
            if (i3 == 2) {
                subscriptionOption2 = (SubscriptionOption) c09661.L$3;
                r1 = (Package) c09661.L$2;
                activity3 = (Activity) c09661.L$1;
                PaywallViewModelImpl paywallViewModelImpl8 = (PaywallViewModelImpl) c09661.L$0;
                try {
                    ResultKt.throwOnFailure(objCalculateProductChangeInfo);
                    i = 1;
                    paywallViewModelImpl5 = paywallViewModelImpl8;
                    productChangeInfo = (ProductChangeInfo) objCalculateProductChangeInfo;
                    activity2 = activity3;
                    paywallViewModelImpl2 = paywallViewModelImpl5;
                    i2 = WhenMappings.$EnumSwitchMapping$0[paywallViewModelImpl2.purchases.getPurchasesAreCompletedBy().ordinal()];
                } catch (PurchasesException e2) {
                    e = e2;
                    r32 = paywallViewModelImpl8;
                    if (e.getCode() != PurchasesErrorCode.PurchaseCancelledError) {
                        r32.trackPaywallCancel();
                        PaywallListener listener3 = r32.getListener();
                        r3 = r32;
                        if (listener3 != null) {
                            listener3.onPurchaseCancelled();
                            r3 = r32;
                        }
                    } else {
                        r32.trackPaywallPurchaseError(r1, e.getError());
                        PaywallListener listener4 = r32.getListener();
                        if (listener4 != null) {
                            listener4.onPurchaseError(e.getError());
                        }
                        r32._actionError.setValue(e.getError());
                        r3 = r32;
                    }
                }
                if (i2 == i) {
                    PaywallPurchaseLogic purchaseLogic = paywallViewModelImpl2.getPurchaseLogic();
                    if (purchaseLogic == null) {
                        throw new IllegalStateException("myAppPurchaseLogic must not be null when purchases.purchasesAreCompletedBy is PurchasesAreCompletedBy.MY_APP".toString());
                    }
                    PaywallPurchaseLogicParams paywallPurchaseLogicParams = new PaywallPurchaseLogicParams(r1, productChangeInfo != null ? new ProductChange(productChangeInfo.getOldProductId(), productChangeInfo.getReplacementMode()) : null, subscriptionOption2);
                    c09661.L$0 = paywallViewModelImpl2;
                    c09661.L$1 = r1;
                    c09661.L$2 = null;
                    c09661.L$3 = null;
                    c09661.L$4 = null;
                    c09661.label = 3;
                    objCalculateProductChangeInfo = purchaseLogic.performPurchase(activity2, paywallPurchaseLogicParams, c09661);
                    if (objCalculateProductChangeInfo != coroutine_suspended) {
                        paywallViewModelImpl3 = paywallViewModelImpl2;
                        purchaseLogicResult = (PurchaseLogicResult) objCalculateProductChangeInfo;
                        if (purchaseLogicResult instanceof PurchaseLogicResult.Success) {
                        }
                    }
                } else {
                    if (i2 != 2) {
                        Logger.INSTANCE.e("Unsupported purchase completion type: " + paywallViewModelImpl2.purchases.getPurchasesAreCompletedBy());
                        r10 = paywallViewModelImpl2;
                        r10.finishAction();
                        return Unit.INSTANCE;
                    }
                    PaywallListener listener5 = paywallViewModelImpl2.getListener();
                    if (listener5 != null) {
                        listener5.onPurchaseStarted(r1);
                    }
                    if (paywallViewModelImpl2.getPurchaseLogic() != null) {
                        Logger.INSTANCE.e("myAppPurchaseLogic expected to be null when purchases.purchasesAreCompletedBy is .REVENUECAT. \nmyAppPurchaseLogic.performPurchase will not be executed.");
                    }
                    PurchaseParams.Builder builderPresentedOfferingContext = subscriptionOption2 != null ? new PurchaseParams.Builder(activity2, subscriptionOption2).presentedOfferingContext(r1.getPresentedOfferingContext()) : new PurchaseParams.Builder(activity2, r1);
                    if (productChangeInfo != null) {
                        Logger.INSTANCE.d("Performing product change from " + productChangeInfo.getOldProductId() + " with mode " + productChangeInfo.getReplacementMode());
                        builderPresentedOfferingContext.oldProductId(productChangeInfo.getOldProductId()).googleReplacementMode(productChangeInfo.getReplacementMode());
                    }
                    PurchasesType purchasesType = paywallViewModelImpl2.purchases;
                    c09661.L$0 = paywallViewModelImpl2;
                    c09661.L$1 = r1;
                    c09661.L$2 = null;
                    c09661.L$3 = null;
                    c09661.L$4 = null;
                    c09661.label = 5;
                    objCalculateProductChangeInfo = purchasesType.awaitPurchase(builderPresentedOfferingContext, c09661);
                    if (objCalculateProductChangeInfo != coroutine_suspended) {
                        paywallViewModelImpl4 = paywallViewModelImpl2;
                        PurchaseResult purchaseResult = (PurchaseResult) objCalculateProductChangeInfo;
                        paywallViewModelImpl4._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                        listener = paywallViewModelImpl4.getListener();
                        if (listener != null) {
                        }
                        Logger.INSTANCE.d("Dismissing paywall after purchase");
                        paywallViewModelImpl4.options.getDismissRequest().invoke();
                        r3 = paywallViewModelImpl4;
                        r10 = r3;
                        r10.finishAction();
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    PaywallViewModelImpl paywallViewModelImpl9 = (PaywallViewModelImpl) c09661.L$0;
                    ResultKt.throwOnFailure(objCalculateProductChangeInfo);
                    paywallViewModelImpl6 = paywallViewModelImpl9;
                    paywallViewModelImpl6._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                    Logger.INSTANCE.d("Dismissing paywall after purchase");
                    paywallViewModelImpl6.closePaywall(new PaywallResult.Purchased((CustomerInfo) objCalculateProductChangeInfo));
                    r3 = paywallViewModelImpl6;
                    r10 = r3;
                    r10.finishAction();
                    return Unit.INSTANCE;
                }
                if (i3 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                PaywallViewModelImpl paywallViewModelImpl10 = (PaywallViewModelImpl) c09661.L$0;
                ResultKt.throwOnFailure(objCalculateProductChangeInfo);
                paywallViewModelImpl4 = paywallViewModelImpl10;
                PurchaseResult purchaseResult2 = (PurchaseResult) objCalculateProductChangeInfo;
                paywallViewModelImpl4._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                listener = paywallViewModelImpl4.getListener();
                if (listener != null) {
                    listener.onPurchaseCompleted(purchaseResult2.getCustomerInfo(), purchaseResult2.getStoreTransaction());
                }
                Logger.INSTANCE.d("Dismissing paywall after purchase");
                paywallViewModelImpl4.options.getDismissRequest().invoke();
                r3 = paywallViewModelImpl4;
                r10 = r3;
                r10.finishAction();
                return Unit.INSTANCE;
            }
            r1 = (Package) c09661.L$1;
            PaywallViewModelImpl paywallViewModelImpl11 = (PaywallViewModelImpl) c09661.L$0;
            ResultKt.throwOnFailure(objCalculateProductChangeInfo);
            paywallViewModelImpl3 = paywallViewModelImpl11;
            purchaseLogicResult = (PurchaseLogicResult) objCalculateProductChangeInfo;
            if (purchaseLogicResult instanceof PurchaseLogicResult.Success) {
                if (purchaseLogicResult instanceof PurchaseLogicResult.Cancellation) {
                    paywallViewModelImpl3.trackPaywallCancel();
                    r3 = paywallViewModelImpl3;
                } else {
                    r3 = paywallViewModelImpl3;
                    if (purchaseLogicResult instanceof PurchaseLogicResult.Error) {
                        PurchasesError errorDetails = ((PurchaseLogicResult.Error) purchaseLogicResult).getErrorDetails();
                        r3 = paywallViewModelImpl3;
                        if (errorDetails != null) {
                            paywallViewModelImpl3.trackPaywallPurchaseError(r1, errorDetails);
                            paywallViewModelImpl3._actionError.setValue(errorDetails);
                            r3 = paywallViewModelImpl3;
                        }
                    }
                }
                r10 = r3;
                r10.finishAction();
                return Unit.INSTANCE;
            }
            PurchasesType purchasesType2 = paywallViewModelImpl3.purchases;
            c09661.L$0 = paywallViewModelImpl3;
            c09661.L$1 = r1;
            c09661.label = 4;
            objCalculateProductChangeInfo = purchasesType2.awaitSyncPurchases(c09661);
            paywallViewModelImpl6 = paywallViewModelImpl3;
        }
        if (!((Boolean) objCalculateProductChangeInfo).booleanValue()) {
            Logger.INSTANCE.d("Purchase cancelled listener.onPurchasePackageInitiated returned false");
            return Unit.INSTANCE;
        }
        try {
            paywallViewModelImpl.trackPaywallPurchaseInitiated(r1);
            if (productChangeConfig2 == null) {
                productChangeInfo = null;
                paywallViewModelImpl2 = paywallViewModelImpl;
                i2 = WhenMappings.$EnumSwitchMapping$0[paywallViewModelImpl2.purchases.getPurchasesAreCompletedBy().ordinal()];
                if (i2 == i) {
                }
                return coroutine_suspended;
            }
            ProductChangeCalculator productChangeCalculator = paywallViewModelImpl.productChangeCalculator;
            c09661.L$0 = paywallViewModelImpl;
            c09661.L$1 = activity2;
            c09661.L$2 = r1;
            c09661.L$3 = subscriptionOption2;
            c09661.L$4 = null;
            c09661.label = 2;
            objCalculateProductChangeInfo = productChangeCalculator.calculateProductChangeInfo(r1, productChangeConfig2, c09661);
            if (objCalculateProductChangeInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            activity3 = activity2;
            paywallViewModelImpl5 = paywallViewModelImpl;
            productChangeInfo = (ProductChangeInfo) objCalculateProductChangeInfo;
            activity2 = activity3;
            paywallViewModelImpl2 = paywallViewModelImpl5;
            i2 = WhenMappings.$EnumSwitchMapping$0[paywallViewModelImpl2.purchases.getPurchasesAreCompletedBy().ordinal()];
            if (i2 == i) {
            }
            return coroutine_suspended;
        } catch (PurchasesException e3) {
            e = e3;
            r32 = paywallViewModelImpl;
            if (e.getCode() != PurchasesErrorCode.PurchaseCancelledError) {
            }
        }
    }

    static /* synthetic */ Object performPurchase$default(PaywallViewModelImpl paywallViewModelImpl, Activity activity, Package r8, ProductChangeConfig productChangeConfig, SubscriptionOption subscriptionOption, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            productChangeConfig = null;
        }
        return paywallViewModelImpl.performPurchase(activity, r8, productChangeConfig, subscriptionOption, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performPurchaseIfNecessary(Activity activity, PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, ProductChangeConfig productChangeConfig, Continuation<? super Unit> continuation) throws Throwable {
        if (selectedPackageInfo == null) {
            Logger.INSTANCE.w("Ignoring purchase request as no package is selected");
            return Unit.INSTANCE;
        }
        Package rcPackage = selectedPackageInfo.getRcPackage();
        ResolvedOffer resolvedOffer = selectedPackageInfo.getResolvedOffer();
        Object objPerformPurchase = performPurchase(activity, rcPackage, productChangeConfig, resolvedOffer != null ? resolvedOffer.getSubscriptionOption() : null, continuation);
        return objPerformPurchase == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformPurchase : Unit.INSTANCE;
    }

    private final LocaleList toFrameworkLocaleList(LocaleListCompat localeListCompat) {
        int size = localeListCompat.size();
        Locale[] localeArr = new Locale[size];
        for (int i = 0; i < size; i++) {
            Locale locale = localeListCompat.get(i);
            Intrinsics.checkNotNull(locale);
            localeArr[i] = locale;
        }
        return new LocaleList((Locale[]) Arrays.copyOf(localeArr, size));
    }

    private final void track(PaywallEventType eventType) {
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.e("Paywall event data is null, not tracking event " + eventType);
            return;
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), data, eventType));
    }

    private final void trackPaywallCancel() {
        track(PaywallEventType.CANCEL);
    }

    private final void trackPaywallClose() {
        if (this.paywallPresentationData != null) {
            track(PaywallEventType.CLOSE);
        }
    }

    private final void trackPaywallPurchaseError(Package rcPackage, PurchasesError error) {
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.e("Paywall event data is null, not tracking purchase error event");
            return;
        }
        StoreProduct product = rcPackage.getProduct();
        PaywallEvent.Data dataCopy$default = PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, null, null, rcPackage.getIdentifier(), product instanceof GoogleStoreProduct ? ((GoogleStoreProduct) product).getProductId() : product.getId(), Integer.valueOf(error.getCode().getCode()), error.getMessage(), 511, null);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), dataCopy$default, PaywallEventType.PURCHASE_ERROR));
    }

    private final void trackPaywallPurchaseInitiated(Package rcPackage) {
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.e("Paywall event data is null, not tracking purchase initiated event");
            return;
        }
        StoreProduct product = rcPackage.getProduct();
        PaywallEvent.Data dataCopy$default = PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, null, null, rcPackage.getIdentifier(), product instanceof GoogleStoreProduct ? ((GoogleStoreProduct) product).getProductId() : product.getId(), null, null, 6655, null);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), dataCopy$default, PaywallEventType.PURCHASE_INITIATED));
    }

    private final void updateState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09701(null), 3, null);
    }

    private final void validateState() {
        if (this.purchases.getPurchasesAreCompletedBy() == PurchasesAreCompletedBy.MY_APP && this.options.getPurchaseLogic() == null) {
            this._state.setValue(new PaywallState.Error("myAppPurchaseLogic is null, but is required when purchases.purchasesAreCompletedBy is .MY_APP. App purchases will not be successful."));
        }
    }

    private final boolean verifyNoActionInProgressOrStartAction() {
        if (this._actionInProgress.getValue().booleanValue()) {
            Logger.INSTANCE.d("Ignoring purchase or restore because there already is an action in progress");
            return true;
        }
        this._actionInProgress.setValue(true);
        return false;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void clearActionError() {
        this._actionError.setValue(null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void closePaywall(PaywallResult result) {
        Logger.INSTANCE.d("Paywalls: Close paywall initiated");
        trackPaywallClose();
        Offering value = !this._purchaseCompleted.getValue().booleanValue() ? this._preloadedExitOffering.getValue() : null;
        if (value != null) {
            trackExitOffer(ExitOfferType.DISMISS, value.getIdentifier());
        }
        this.paywallPresentationData = null;
        Function2<Offering, PaywallResult, Unit> dismissRequestWithExitOffering$revenuecatui_defaultsBc8Release = this.options.getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release();
        if (dismissRequestWithExitOffering$revenuecatui_defaultsBc8Release != null) {
            dismissRequestWithExitOffering$revenuecatui_defaultsBc8Release.invoke(value, result);
        } else {
            this.options.getDismissRequest().invoke();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<PurchasesError> getActionError() {
        return this._actionError;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getActionInProgress() {
        return this._actionInProgress;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Offering> getPreloadedExitOffering() {
        return this._preloadedExitOffering;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getPurchaseCompleted() {
        return this._purchaseCompleted;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public ResourceProvider getResourceProvider() {
        return this.resourceProvider;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public StateFlow<PaywallState> getState() {
        return FlowKt.asStateFlow(this._state);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout) {
        Pair pair;
        URL webCheckoutURL;
        String string;
        Intrinsics.checkNotNullParameter(launchWebCheckout, "launchWebCheckout");
        String customUrl = launchWebCheckout.getCustomUrl();
        PaywallState value = getState().getValue();
        PaywallState.Loaded.Components components = value instanceof PaywallState.Loaded.Components ? (PaywallState.Loaded.Components) value : null;
        if (components == null) {
            Logger.INSTANCE.e("Web checkout URL can only be constructed for loaded Components paywalls");
            return null;
        }
        PaywallAction.External.LaunchWebCheckout.PackageParamBehavior packageParamBehavior = launchWebCheckout.getPackageParamBehavior();
        if (packageParamBehavior instanceof PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.Append) {
            PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.Append append = (PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.Append) packageParamBehavior;
            Package rcPackage = append.getRcPackage();
            if (rcPackage == null) {
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = components.getSelectedPackageInfo();
                rcPackage = selectedPackageInfo != null ? selectedPackageInfo.getRcPackage() : null;
            }
            pair = TuplesKt.to(rcPackage, append.getPackageParam());
        } else {
            if (!(packageParamBehavior instanceof PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.DoNotAppend)) {
                throw new NoWhenBranchMatchedException();
            }
            pair = TuplesKt.to(null, null);
        }
        Package r1 = (Package) pair.component1();
        String str = (String) pair.component2();
        if (customUrl == null) {
            return (r1 == null || (webCheckoutURL = r1.getWebCheckoutURL()) == null || (string = webCheckoutURL.toString()) == null) ? String.valueOf(components.getOffering().getWebCheckoutURL()) : string;
        }
        try {
            URI uri = new URI(customUrl);
            if (str != null && r1 != null) {
                uri = URIExtensionsKt.appendQueryParameter(uri, str, r1.getIdentifier());
            }
            return uri.toString();
        } catch (URISyntaxException e) {
            Logger.INSTANCE.e("Invalid custom URI: " + customUrl, e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        if (performPurchase$default(r1, r10, r11, null, null, r6, 4, null) == r0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b3, code lost:
    
        if (r1.performPurchaseIfNecessary(r10, r10, r11, r6) == r0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b5, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object handlePackagePurchase(Activity activity, Package r11, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        PaywallViewModelImpl paywallViewModelImpl;
        PaywallComponentsData data;
        PaywallViewModelImpl paywallViewModelImpl2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object obj = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass12.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (verifyNoActionInProgressOrStartAction()) {
                return Unit.INSTANCE;
            }
            PaywallState value = this._state.getValue();
            if (value instanceof PaywallState.Loaded.Legacy) {
                Package rcPackage = ((PaywallState.Loaded.Legacy) value).getSelectedPackage().getValue().getRcPackage();
                anonymousClass12.L$0 = this;
                anonymousClass12.label = 1;
                paywallViewModelImpl = this;
            } else {
                paywallViewModelImpl = this;
                if (value instanceof PaywallState.Loaded.Components) {
                    PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = r11 != null ? new PaywallState.Loaded.Components.SelectedPackageInfo(r11, resolvedOffer, r11.getIdentifier(), PackageExtensionsKt.calculateOfferEligibility(resolvedOffer, r11)) : ((PaywallState.Loaded.Components) value).getSelectedPackageInfo();
                    Offering.PaywallComponents paywallComponents = ((PaywallState.Loaded.Components) value).getOffering().getPaywallComponents();
                    ProductChangeConfig productChangeConfig = (paywallComponents == null || (data = paywallComponents.getData()) == null) ? null : data.getProductChangeConfig();
                    anonymousClass12.L$0 = paywallViewModelImpl;
                    anonymousClass12.label = 2;
                } else {
                    if (value instanceof PaywallState.Error ? true : value instanceof PaywallState.Loading) {
                        Logger.INSTANCE.e("Unexpected state trying to purchase package: " + value);
                    }
                }
                paywallViewModelImpl2 = paywallViewModelImpl;
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            paywallViewModelImpl2 = (PaywallViewModelImpl) anonymousClass12.L$0;
            ResultKt.throwOnFailure(obj);
        }
        paywallViewModelImpl2.finishAction();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x01e9, code lost:
    
        if (r1 == r5) goto L94;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0217 A[Catch: PurchasesException -> 0x0070, TryCatch #0 {PurchasesException -> 0x0070, blocks: (B:16:0x0042, B:73:0x016d, B:75:0x0187, B:76:0x018a, B:78:0x018e, B:80:0x019a, B:21:0x0054, B:95:0x01ec, B:97:0x01f2, B:99:0x01fe, B:24:0x005e, B:90:0x01d8, B:92:0x01de, B:100:0x0217, B:102:0x021b, B:104:0x021f, B:106:0x0227, B:27:0x006b, B:87:0x01c9), top: B:119:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0187 A[Catch: PurchasesException -> 0x0070, TryCatch #0 {PurchasesException -> 0x0070, blocks: (B:16:0x0042, B:73:0x016d, B:75:0x0187, B:76:0x018a, B:78:0x018e, B:80:0x019a, B:21:0x0054, B:95:0x01ec, B:97:0x01f2, B:99:0x01fe, B:24:0x005e, B:90:0x01d8, B:92:0x01de, B:100:0x0217, B:102:0x021b, B:104:0x021f, B:106:0x0227, B:27:0x006b, B:87:0x01c9), top: B:119:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018e A[Catch: PurchasesException -> 0x0070, TryCatch #0 {PurchasesException -> 0x0070, blocks: (B:16:0x0042, B:73:0x016d, B:75:0x0187, B:76:0x018a, B:78:0x018e, B:80:0x019a, B:21:0x0054, B:95:0x01ec, B:97:0x01f2, B:99:0x01fe, B:24:0x005e, B:90:0x01d8, B:92:0x01de, B:100:0x0217, B:102:0x021b, B:104:0x021f, B:106:0x0227, B:27:0x006b, B:87:0x01c9), top: B:119:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d8 A[Catch: PurchasesException -> 0x0070, PHI: r1 r2
      0x01d8: PHI (r1v16 java.lang.Object) = (r1v15 java.lang.Object), (r1v1 java.lang.Object) binds: [B:88:0x01d5, B:24:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x01d8: PHI (r2v16 com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl) = 
      (r2v41 com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl)
      (r2v42 com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl)
     binds: [B:88:0x01d5, B:24:0x005e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {PurchasesException -> 0x0070, blocks: (B:16:0x0042, B:73:0x016d, B:75:0x0187, B:76:0x018a, B:78:0x018e, B:80:0x019a, B:21:0x0054, B:95:0x01ec, B:97:0x01f2, B:99:0x01fe, B:24:0x005e, B:90:0x01d8, B:92:0x01de, B:100:0x0217, B:102:0x021b, B:104:0x021f, B:106:0x0227, B:27:0x006b, B:87:0x01c9), top: B:119:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01de A[Catch: PurchasesException -> 0x0070, TryCatch #0 {PurchasesException -> 0x0070, blocks: (B:16:0x0042, B:73:0x016d, B:75:0x0187, B:76:0x018a, B:78:0x018e, B:80:0x019a, B:21:0x0054, B:95:0x01ec, B:97:0x01f2, B:99:0x01fe, B:24:0x005e, B:90:0x01d8, B:92:0x01de, B:100:0x0217, B:102:0x021b, B:104:0x021f, B:106:0x0227, B:27:0x006b, B:87:0x01c9), top: B:119:0x0031 }] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object handleRestorePurchases(Continuation<? super Unit> continuation) {
        C09651 c09651;
        ?? r1;
        ?? r2;
        Unit unit;
        Object result;
        PaywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1 paywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1;
        int i;
        PaywallViewModelImpl paywallViewModelImpl;
        PaywallViewModelImpl paywallViewModelImpl2;
        PaywallViewModelImpl paywallViewModelImpl3;
        PurchaseLogicResult purchaseLogicResult;
        PaywallViewModelImpl paywallViewModelImpl4;
        PaywallListener listener;
        Function1<CustomerInfo, Boolean> function1;
        PaywallViewModelImpl paywallViewModelImpl5 = this;
        ?? r22 = "Unsupported purchase completion type: ";
        if (continuation instanceof C09651) {
            c09651 = (C09651) continuation;
            if ((c09651.label & Integer.MIN_VALUE) != 0) {
                c09651.label -= Integer.MIN_VALUE;
            } else {
                c09651 = paywallViewModelImpl5.new C09651(continuation);
            }
        }
        Object objInvoke = c09651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c09651.label;
        try {
        } catch (PurchasesException e) {
            e = e;
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            if (paywallViewModelImpl5.verifyNoActionInProgressOrStartAction()) {
                return Unit.INSTANCE;
            }
            c09651.L$0 = paywallViewModelImpl5;
            c09651.label = 1;
            C09651 c096512 = c09651;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c096512), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            Logger.INSTANCE.d("Restore Purchases Initiated… waiting for listener.onRestoreInitiated to proceed.");
            PaywallListener listener2 = paywallViewModelImpl5.getListener();
            if (listener2 != null) {
                listener2.onRestoreInitiated(new Resumable() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handleRestorePurchases$shouldResume$1$1
                    @Override // com.revenuecat.purchases.ui.revenuecatui.utils.Resumable
                    public void invoke(boolean z) {
                        Resumable.DefaultImpls.invoke(this, z);
                    }

                    @Override // com.revenuecat.purchases.ui.revenuecatui.utils.Resumable
                    public final void resume(boolean z) {
                        Boolean boolValueOf = Boolean.valueOf(z);
                        CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m11445constructorimpl(boolValueOf));
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m11445constructorimpl(Boxing.boxBoolean(true)));
            }
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c096512);
            }
            if (result != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            paywallViewModelImpl5 = (PaywallViewModelImpl) c09651.L$0;
            ResultKt.throwOnFailure(objInvoke);
            result = objInvoke;
        } else {
            if (i2 == 2) {
                paywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1 = (Function2) c09651.L$1;
                PaywallViewModelImpl paywallViewModelImpl6 = (PaywallViewModelImpl) c09651.L$0;
                ResultKt.throwOnFailure(objInvoke);
                paywallViewModelImpl = paywallViewModelImpl6;
                c09651.L$0 = paywallViewModelImpl;
                c09651.L$1 = null;
                c09651.label = 3;
                objInvoke = paywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1.invoke((CustomerInfo) objInvoke, c09651);
                paywallViewModelImpl3 = paywallViewModelImpl;
                if (objInvoke == coroutine_suspended) {
                    purchaseLogicResult = (PurchaseLogicResult) objInvoke;
                    if (purchaseLogicResult instanceof PurchaseLogicResult.Success) {
                    }
                }
                return coroutine_suspended;
            }
            if (i2 != 3) {
                if (i2 == 4) {
                    PaywallViewModelImpl paywallViewModelImpl7 = (PaywallViewModelImpl) c09651.L$0;
                    ResultKt.throwOnFailure(objInvoke);
                    paywallViewModelImpl4 = paywallViewModelImpl7;
                    CustomerInfo customerInfo = (CustomerInfo) objInvoke;
                    Function1<CustomerInfo, Boolean> function12 = paywallViewModelImpl4.shouldDisplayBlock;
                    r2 = paywallViewModelImpl4;
                    if (function12 != null) {
                        r2 = paywallViewModelImpl4;
                        if (!function12.invoke(customerInfo).booleanValue()) {
                            paywallViewModelImpl4._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                            Logger.INSTANCE.d("Dismissing paywall after restore since display condition has not been met");
                            paywallViewModelImpl4.closePaywall(new PaywallResult.Restored(customerInfo));
                            r2 = paywallViewModelImpl4;
                        }
                    }
                    r1 = r2;
                    r1.finishAction();
                    return Unit.INSTANCE;
                }
                if (i2 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                PaywallViewModelImpl paywallViewModelImpl8 = (PaywallViewModelImpl) c09651.L$0;
                ResultKt.throwOnFailure(objInvoke);
                paywallViewModelImpl2 = paywallViewModelImpl8;
                CustomerInfo customerInfo2 = (CustomerInfo) objInvoke;
                Logger.INSTANCE.i("Restore purchases successful: " + customerInfo2);
                listener = paywallViewModelImpl2.getListener();
                if (listener != null) {
                    listener.onRestoreCompleted(customerInfo2);
                }
                function1 = paywallViewModelImpl2.shouldDisplayBlock;
                r2 = paywallViewModelImpl2;
                if (function1 != null) {
                    r2 = paywallViewModelImpl2;
                    if (!function1.invoke(customerInfo2).booleanValue()) {
                        paywallViewModelImpl2._purchaseCompleted.setValue(Boxing.boxBoolean(true));
                        Logger.INSTANCE.d("Dismissing paywall after restore since display condition has not been met");
                        paywallViewModelImpl2.options.getDismissRequest().invoke();
                        r2 = paywallViewModelImpl2;
                    }
                }
                r1 = r2;
                r1.finishAction();
                return Unit.INSTANCE;
            }
            PaywallViewModelImpl paywallViewModelImpl9 = (PaywallViewModelImpl) c09651.L$0;
            ResultKt.throwOnFailure(objInvoke);
            paywallViewModelImpl3 = paywallViewModelImpl9;
            purchaseLogicResult = (PurchaseLogicResult) objInvoke;
            if (purchaseLogicResult instanceof PurchaseLogicResult.Success) {
                r2 = paywallViewModelImpl3;
                if (!(purchaseLogicResult instanceof PurchaseLogicResult.Cancellation)) {
                    r2 = paywallViewModelImpl3;
                    if (purchaseLogicResult instanceof PurchaseLogicResult.Error) {
                        PurchasesError errorDetails = ((PurchaseLogicResult.Error) purchaseLogicResult).getErrorDetails();
                        r2 = paywallViewModelImpl3;
                        if (errorDetails != null) {
                            paywallViewModelImpl3._actionError.setValue(errorDetails);
                            r2 = paywallViewModelImpl3;
                        }
                    }
                }
                r1 = r2;
                r1.finishAction();
                return Unit.INSTANCE;
            }
            PurchasesType purchasesType = paywallViewModelImpl3.purchases;
            c09651.L$0 = paywallViewModelImpl3;
            c09651.label = 4;
            objInvoke = purchasesType.awaitSyncPurchases(c09651);
            paywallViewModelImpl4 = paywallViewModelImpl3;
        }
        PaywallViewModelImpl paywallViewModelImpl10 = paywallViewModelImpl5;
        boolean zBooleanValue = ((Boolean) result).booleanValue();
        Logger.INSTANCE.d("Restore Purchases gate complete. The SDK **" + (zBooleanValue ? "will" : "will not") + "** attempt to restore purchases.");
        if (!zBooleanValue) {
            paywallViewModelImpl10.finishAction();
            return Unit.INSTANCE;
        }
        try {
            PaywallPurchaseLogic purchaseLogic = paywallViewModelImpl10.getPurchaseLogic();
            paywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1 = purchaseLogic != null ? new PaywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1(purchaseLogic) : null;
            i = WhenMappings.$EnumSwitchMapping$0[paywallViewModelImpl10.purchases.getPurchasesAreCompletedBy().ordinal()];
        } catch (PurchasesException e2) {
            e = e2;
            r22 = paywallViewModelImpl10;
            Logger.INSTANCE.e("Error restoring purchases: " + e);
            PaywallListener listener3 = r22.getListener();
            if (listener3 != null) {
                listener3.onRestoreError(e.getError());
            }
            r22._actionError.setValue(e.getError());
            r2 = r22;
        }
        if (i != 1) {
            if (i != 2) {
                Logger.INSTANCE.e("Unsupported purchase completion type: " + paywallViewModelImpl10.purchases.getPurchasesAreCompletedBy());
                r1 = paywallViewModelImpl10;
                r1.finishAction();
                return Unit.INSTANCE;
            }
            PaywallListener listener4 = paywallViewModelImpl10.getListener();
            if (listener4 != null) {
                listener4.onRestoreStarted();
            }
            if (paywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1 != null) {
                Logger.INSTANCE.w("myAppPurchaseLogic expected be null when purchases.purchasesAreCompletedBy is .REVENUECAT.\nmyAppPurchaseLogic.performRestore will not be executed.");
            }
            PurchasesType purchasesType2 = paywallViewModelImpl10.purchases;
            c09651.L$0 = paywallViewModelImpl10;
            c09651.label = 5;
            Object objAwaitRestore = purchasesType2.awaitRestore(c09651);
            if (objAwaitRestore != coroutine_suspended) {
                paywallViewModelImpl2 = paywallViewModelImpl10;
                objInvoke = objAwaitRestore;
                CustomerInfo customerInfo22 = (CustomerInfo) objInvoke;
                Logger.INSTANCE.i("Restore purchases successful: " + customerInfo22);
                listener = paywallViewModelImpl2.getListener();
                if (listener != null) {
                }
                function1 = paywallViewModelImpl2.shouldDisplayBlock;
                r2 = paywallViewModelImpl2;
                if (function1 != null) {
                }
                r1 = r2;
                r1.finishAction();
                return Unit.INSTANCE;
            }
        } else {
            if (paywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1 == null) {
                throw new IllegalStateException("myAppPurchaseLogic must not be null when purchases.purchasesAreCompletedBy is PurchasesAreCompletedBy.MY_APP".toString());
            }
            PurchasesType purchasesType3 = paywallViewModelImpl10.purchases;
            c09651.L$0 = paywallViewModelImpl10;
            c09651.L$1 = paywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1;
            c09651.label = 2;
            Object objAwaitCustomerInfo$default = PurchasesType.DefaultImpls.awaitCustomerInfo$default(purchasesType3, null, c09651, 1, null);
            if (objAwaitCustomerInfo$default != coroutine_suspended) {
                paywallViewModelImpl = paywallViewModelImpl10;
                objInvoke = objAwaitCustomerInfo$default;
                c09651.L$0 = paywallViewModelImpl;
                c09651.L$1 = null;
                c09651.label = 3;
                objInvoke = paywallViewModelImpl$handleRestorePurchases$customRestoreHandler$1$1.invoke((CustomerInfo) objInvoke, c09651);
                paywallViewModelImpl3 = paywallViewModelImpl;
                if (objInvoke == coroutine_suspended) {
                }
            }
        }
        return coroutine_suspended;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void invalidateCustomerInfoCache() {
        this.purchases.invalidateVirtualCurrenciesCache();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void preloadExitOffering() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09671(null), 3, null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void purchaseSelectedPackage(Activity activity) {
        if (activity == null) {
            Logger.INSTANCE.e("Activity is null, not initiating package purchase");
        } else {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09681(activity, null), 3, null);
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean isDark) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        if (this.isDarkMode != isDark) {
            this.isDarkMode = isDark;
        }
        if (Intrinsics.areEqual(this._colorScheme.getValue(), colorScheme)) {
            return;
        }
        this._colorScheme.setValue(colorScheme);
        updateState();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfLocaleChanged() {
        LocaleListCompat currentLocaleList = getCurrentLocaleList();
        if (Intrinsics.areEqual(this._lastLocaleList.getValue(), currentLocaleList)) {
            return;
        }
        this._lastLocaleList.setValue(currentLocaleList);
        PaywallState value = this._state.getValue();
        if (value instanceof PaywallState.Loaded.Components) {
            PaywallState.Loaded.Components.update$default((PaywallState.Loaded.Components) value, toFrameworkLocaleList(currentLocaleList), null, null, 6, null);
        } else {
            updateState();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void restorePurchases() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09691(null), 3, null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void selectPackage(TemplateConfiguration.PackageInfo packageToSelect) {
        Intrinsics.checkNotNullParameter(packageToSelect, "packageToSelect");
        PaywallState value = this._state.getValue();
        if (value instanceof PaywallState.Loaded.Legacy) {
            ((PaywallState.Loaded.Legacy) value).selectPackage(packageToSelect);
        } else {
            Logger.INSTANCE.e("Unexpected state trying to select package: " + value);
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackExitOffer(ExitOfferType exitOfferType, String exitOfferingIdentifier) {
        Intrinsics.checkNotNullParameter(exitOfferType, "exitOfferType");
        Intrinsics.checkNotNullParameter(exitOfferingIdentifier, "exitOfferingIdentifier");
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.e("Paywall event data is null, not tracking exit offer event");
            return;
        }
        PaywallEvent.Data dataCopy$default = PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, exitOfferType, exitOfferingIdentifier, null, null, null, null, 7807, null);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), dataCopy$default, PaywallEventType.EXIT_OFFER));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackPaywallImpressionIfNeeded() {
        if (this.paywallPresentationData == null) {
            this.paywallPresentationData = createEventData();
            track(PaywallEventType.IMPRESSION);
        }
    }

    public final void updateOptions(PaywallOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        boolean z = this.options.hashCode() != options.hashCode();
        this.options = options;
        if (z) {
            updateState();
        }
    }
}
